package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient
import dev.brahmkshatriya.echo.common.clients.TrackClient
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.Feed
import dev.brahmkshatriya.echo.common.models.Feed.Companion.toFeed
import dev.brahmkshatriya.echo.common.models.ImageHolder.Companion.toImageHolder
import dev.brahmkshatriya.echo.common.models.NetworkRequest.Companion.toGetRequest
import dev.brahmkshatriya.echo.common.models.Shelf
import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.common.settings.Setting
import dev.brahmkshatriya.echo.common.settings.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

class SoundcloudExtension : ExtensionClient, HomeFeedClient, SearchFeedClient, TrackClient {

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    // Public SoundCloud API credentials
    private val clientId = "T574VRKI5KSLMzLdUreWOpXss1R3Fzfx"

    private suspend fun searchTracks(query: String, limit: Int = 20): List<Track> = withContext(Dispatchers.IO) {
        runCatching {
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://api-v2.soundcloud.com/search/tracks?q=$encoded&client_id=$clientId&limit=$limit"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val collection = root["collection"]?.jsonArray ?: return@runCatching emptyList()

            collection.mapNotNull { elem ->
                runCatching {
                    val obj = elem.jsonObject
                    val id = obj["id"]?.jsonPrimitive?.content ?: return@runCatching null
                    val title = obj["title"]?.jsonPrimitive?.content ?: "Track"

                    val userObj = obj["user"]?.jsonObject
                    val artistName = userObj?.get("username")?.jsonPrimitive?.content ?: "SoundCloud Artist"
                    val artists = listOf(Artist(id = artistName, name = artistName))

                    val rawArtwork = obj["artwork_url"]?.jsonPrimitive?.content
                        ?: userObj?.get("avatar_url")?.jsonPrimitive?.content
                        ?: "https://a-v2.sndcdn.com/assets/images/default/avatar-large-521b7c02b3.png"
                    val highResArtwork = rawArtwork.replace("-large.", "-t500x500.")

                    val duration = obj["duration"]?.jsonPrimitive?.content?.toLongOrNull()

                    // Extract progressive stream URL or fallback transcoding url
                    var streamTranscodingUrl: String? = null
                    val media = obj["media"]?.jsonObject
                    val transcodings = media?.get("transcodings")?.jsonArray
                    if (transcodings != null) {
                        for (t in transcodings) {
                            val tObj = t.jsonObject
                            val format = tObj["format"]?.jsonObject
                            val protocol = format?.get("protocol")?.jsonPrimitive?.content
                            if (protocol == "progressive") {
                                streamTranscodingUrl = tObj["url"]?.jsonPrimitive?.content
                                break
                            }
                        }
                        if (streamTranscodingUrl == null && transcodings.isNotEmpty()) {
                            streamTranscodingUrl = transcodings[0].jsonObject["url"]?.jsonPrimitive?.content
                        }
                    }

                    val extras = mutableMapOf<String, String>()
                    if (streamTranscodingUrl != null) {
                        extras["stream_url"] = streamTranscodingUrl
                    }
                    extras["extension_id"] = "soundcloud_music"
                    extras["track_title"] = title
                    extras["artist_name"] = artistName

                    val streamable = Streamable.server(
                        id = "sc_$id",
                        quality = 160,
                        title = "SoundCloud Stream",
                        extras = extras
                    )

                    Track(
                        id = "sc_$id",
                        title = title,
                        artists = artists,
                        album = Album(id = "SoundCloud", title = "SoundCloud Single"),
                        cover = highResArtwork.toImageHolder(),
                        duration = duration,
                        streamables = listOf(streamable),
                        extras = extras
                    )
                }.getOrNull()
            }
        }.getOrDefault(emptyList())
    }

    override suspend fun loadHomeFeed(): Feed<Shelf> = withContext(Dispatchers.IO) {
        val shelves = mutableListOf<Shelf>()

        coroutineScope {
            val madeForYouAsync = async { searchTracks("Made For You Mix Hits", 20) }
            val topSongsAsync = async { searchTracks("Today's Top Hits 2026", 20) }
            val topPlaylistsAsync = async { searchTracks("Top Hits Playlist", 20) }
            val top50GlobalAsync = async { searchTracks("Global Top 50 Hits", 20) }
            val hits2026Async = async { searchTracks("2026 Hit Songs", 20) }
            val hits2025Async = async { searchTracks("2025 Hit Songs", 20) }
            val hits2024Async = async { searchTracks("2024 Hit Songs", 20) }
            val hits2023Async = async { searchTracks("2023 Hit Songs", 20) }
            val hits2020sAsync = async { searchTracks("Best of 2020s Hits", 20) }
            val hits2010sAsync = async { searchTracks("2010s Greatest Hits", 20) }
            val hits2000sAsync = async { searchTracks("2000s Greatest Hits", 20) }
            val hits90sAsync = async { searchTracks("90s Greatest Hits", 20) }

            val madeForYou = madeForYouAsync.await()
            val topSongs = topSongsAsync.await()
            val topPlaylists = topPlaylistsAsync.await()
            val top50Global = top50GlobalAsync.await()
            val hits2026 = hits2026Async.await()
            val hits2025 = hits2025Async.await()
            val hits2024 = hits2024Async.await()
            val hits2023 = hits2023Async.await()
            val hits2020s = hits2020sAsync.await()
            val hits2010s = hits2010sAsync.await()
            val hits2000s = hits2000sAsync.await()
            val hits90s = hits90sAsync.await()

            // 1. Made For You
            if (madeForYou.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_made_for_you",
                        title = "Made For You",
                        list = madeForYou,
                        subtitle = "Personalized algorithmic mix based on your taste",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            // 2. Top Songs
            if (topSongs.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_top_songs",
                        title = "Top Songs",
                        list = topSongs,
                        subtitle = "Today's most played trending hits worldwide",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            // 3. Top Playlists
            if (topPlaylists.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_top_playlists",
                        title = "Top Playlists",
                        list = topPlaylists,
                        subtitle = "Curated global & viral playlists",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            // 4. Top 50 Global Hit Songs
            if (top50Global.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_top_50_global",
                        title = "Top 50 Global Hit Songs",
                        list = top50Global,
                        subtitle = "The biggest record-breaking streaming hits worldwide",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            // 5. Year-Wise Shelves (Descending Order)
            if (hits2026.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2026_hits",
                        title = "2026 Hits",
                        list = hits2026,
                        subtitle = "Current chart anthems & viral tracks of 2026",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits2025.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2025_hits",
                        title = "2025 Hits",
                        list = hits2025,
                        subtitle = "Worldwide smash hits of 2025",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits2024.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2024_hits",
                        title = "2024 Hits",
                        list = hits2024,
                        subtitle = "Top global anthems of 2024",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits2023.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2023_hits",
                        title = "2023 Hits",
                        list = hits2023,
                        subtitle = "Chart-topping favorites of 2023",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits2020s.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2020s_hits",
                        title = "2020s Decade Hits",
                        list = hits2020s,
                        subtitle = "The definitive sounds and peak hits of the 2020s",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits2010s.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2010s_hits",
                        title = "2010s Golden Hits",
                        list = hits2010s,
                        subtitle = "Unforgettable mega-hits from 2010 to 2019",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits2000s.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_2000s_hits",
                        title = "2000s Millennial Hits",
                        list = hits2000s,
                        subtitle = "Iconic nostalgia and mega anthems from 2000 to 2009",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
            if (hits90s.isNotEmpty()) {
                shelves.add(
                    Shelf.Lists.Tracks(
                        id = "sc_90s_hits",
                        title = "90s Retro Classics",
                        list = hits90s,
                        subtitle = "Timeless 1990s chartbuster legends",
                        type = Shelf.Lists.Type.Linear
                    )
                )
            }
        }

        shelves.toFeed()
    }

    override suspend fun loadSearchFeed(query: String): Feed<Shelf> = withContext(Dispatchers.IO) {
        val results = searchTracks(query, 25)
        val shelves = if (results.isNotEmpty()) {
            listOf(
                Shelf.Lists.Tracks(
                    id = "sc_search_results",
                    title = "SoundCloud Results for \"$query\"",
                    list = results
                )
            )
        } else {
            emptyList()
        }
        shelves.toFeed()
    }

    override suspend fun loadTrack(track: Track, isDownload: Boolean): Track {
        if (track.servers.isNotEmpty() && track.servers.first().extras.containsKey("stream_url")) {
            return track
        }
        val streamUrl = track.extras["stream_url"]
        if (!streamUrl.isNullOrBlank()) {
            val s = Streamable.server(
                id = track.id,
                quality = 160,
                title = "SoundCloud Stream",
                extras = track.extras + mapOf(
                    "stream_url" to streamUrl,
                    "extension_id" to "soundcloud_music",
                    "track_title" to track.title,
                    "artist_name" to track.artists.joinToString(", ") { it.name }
                )
            )
            return track.copy(streamables = listOf(s))
        }
        val query = "${track.title} ${track.artists.firstOrNull()?.name ?: ""}".trim()
        if (query.isNotBlank()) {
            val matches = searchTracks(query, 1)
            if (matches.isNotEmpty()) {
                return matches.first()
            }
        }
        return track
    }

    override suspend fun loadStreamableMedia(streamable: Streamable, isDownload: Boolean): Streamable.Media = withContext(Dispatchers.IO) {
        var transcodingUrl = streamable.extras["stream_url"]

        // If direct stream URL is already http mp3/mp4, return immediately
        if (transcodingUrl != null && (transcodingUrl.contains(".mp3") || transcodingUrl.contains(".mp4") || transcodingUrl.contains("cf-hls-media") || transcodingUrl.contains("sndcdn.com/media"))) {
            val source = Streamable.Source.Http(
                request = transcodingUrl.toGetRequest(),
                quality = 160,
                title = "SoundCloud Stream",
                isLive = false
            )
            return@withContext Streamable.Media.Server(listOf(source), merged = false)
        }

        // If missing or expired, search for track by title
        if (transcodingUrl.isNullOrBlank()) {
            val trackTitle = streamable.extras["track_title"] ?: streamable.title ?: ""
            val artistName = streamable.extras["artist_name"] ?: ""
            val query = "$trackTitle $artistName".trim()
            if (query.isNotBlank()) {
                val matches = searchTracks(query, 1)
                if (matches.isNotEmpty()) {
                    transcodingUrl = matches.first().extras["stream_url"]
                }
            }
        }

        if (transcodingUrl.isNullOrBlank()) {
            error("Missing stream url for ${streamable.id}")
        }

        val reqUrl = if (transcodingUrl.contains("?")) "$transcodingUrl&client_id=$clientId" else "$transcodingUrl?client_id=$clientId"
        val req = Request.Builder()
            .url(reqUrl)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
            .build()

        val directUrl = client.newCall(req).execute().use { resp ->
            val body = resp.body.string()
            val obj = json.parseToJsonElement(body).jsonObject
            obj["url"]?.jsonPrimitive?.content ?: error("Failed to resolve SoundCloud media stream")
        }

        val source = Streamable.Source.Http(
            request = directUrl.toGetRequest(),
            quality = 160,
            title = "SoundCloud Stream",
            isLive = false
        )
        Streamable.Media.Server(listOf(source), merged = false)
    }

    override suspend fun loadFeed(track: Track): Feed<Shelf>? = null
}
