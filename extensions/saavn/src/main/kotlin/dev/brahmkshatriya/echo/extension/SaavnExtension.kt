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
import java.util.Base64
import java.util.concurrent.TimeUnit
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class SaavnExtension : ExtensionClient, HomeFeedClient, SearchFeedClient, TrackClient {

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val desKey = "38346591".toByteArray(Charsets.UTF_8)

    private fun decryptRawMediaUrl(encUrl: String): String? {
        return runCatching {
            val cleanEnc = encUrl.replace("\\/", "/").replace("\\", "").trim()
            val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(desKey, "DES"))
            val decodedBytes = Base64.getDecoder().decode(cleanEnc)
            val decryptedBytes = cipher.doFinal(decodedBytes)
            String(decryptedBytes, Charsets.UTF_8).trim()
        }.getOrNull()
    }

    private fun decryptMediaUrl(encUrl: String): String? {
        val raw = decryptRawMediaUrl(encUrl) ?: return null
        return raw.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
    }

    private fun getMultiQualitySources(rawUrl: String): List<Streamable.Source.Http> {
        val s320 = rawUrl.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
        val s160 = rawUrl.replace("_96.mp4", "_160.mp4").replace("_320.mp4", "_160.mp4")
        val s96 = rawUrl.replace("_320.mp4", "_96.mp4").replace("_160.mp4", "_96.mp4")
        return listOf(
            Streamable.Source.Http(request = s320.toGetRequest(), quality = 320, title = "320 kbps (JioSaavn HQ)", isLive = false),
            Streamable.Source.Http(request = s160.toGetRequest(), quality = 160, title = "160 kbps (Standard)", isLive = false),
            Streamable.Source.Http(request = s96.toGetRequest(), quality = 96, title = "96 kbps (Efficient)", isLive = false)
        )
    }

    private fun cleanHtml(text: String): String {
        return text.replace("&quot;", "\"")
            .replace("&amp;", "&")
            .replace("&#039;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .trim()
    }

    private suspend fun searchSongs(query: String, limit: Int = 20): List<Track> = withContext(Dispatchers.IO) {
        runCatching {
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://www.jiosaavn.com/api.php?__call=search.getResults&_format=json&_marker=0&ctx=android&p=1&n=$limit&q=$encoded"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return@runCatching emptyList()

            results.mapNotNull { elem ->
                runCatching {
                    val obj = elem.jsonObject
                    val id = obj["id"]?.jsonPrimitive?.content ?: return@runCatching null
                    val titleRaw = obj["song"]?.jsonPrimitive?.content ?: "Track"
                    val title = cleanHtml(titleRaw)

                    val artistsRaw = obj["primary_artists"]?.jsonPrimitive?.content ?: "Unknown Artist"
                    val artistsList = artistsRaw.split(",").map { name ->
                        val cleanName = cleanHtml(name)
                        Artist(id = cleanName, name = cleanName)
                    }

                    val albumRaw = obj["album"]?.jsonPrimitive?.content
                    val album = albumRaw?.let { Album(id = cleanHtml(it), title = cleanHtml(it)) }

                    val rawImage = obj["image"]?.jsonPrimitive?.content ?: ""
                    val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")

                    val encUrl = obj["encrypted_media_url"]?.jsonPrimitive?.content
                    val previewUrl = obj["media_preview_url"]?.jsonPrimitive?.content

                    val streamUrl = encUrl?.let { decryptMediaUrl(it) } ?: previewUrl ?: ""
                    if (streamUrl.isBlank()) return@runCatching null

                    val durationStr = obj["duration"]?.jsonPrimitive?.content
                    val durationMs = durationStr?.toLongOrNull()?.times(1000L)

                    val streamable = Streamable.server(
                        id = id,
                        quality = 320,
                        title = "320 kbps (JioSaavn HQ)",
                        extras = mapOf(
                            "stream_url" to streamUrl,
                            "extension_id" to "saavn_music",
                            "track_title" to title,
                            "artist_name" to artistsRaw
                        )
                    )

                    Track(
                        id = id,
                        title = title,
                        artists = artistsList,
                        album = album,
                        cover = highResImage.toImageHolder(),
                        streamables = listOf(streamable),
                        duration = durationMs,
                        extras = mapOf(
                            "stream_url" to streamUrl,
                            "extension_id" to "saavn_music",
                            "source" to "JioSaavn"
                        )
                    )
                }.getOrNull()
            }
        }.getOrDefault(emptyList())
    }

    override suspend fun loadHomeFeed(): Feed<Shelf> = withContext(Dispatchers.IO) {
        val shelves = mutableListOf<Shelf>()

        coroutineScope {
            val madeForYouAsync = async { searchSongs("Made For You Mix Hits", 20) }
            val topSongsAsync = async { searchSongs("Today's Top Hits 2026", 20) }
            val topPlaylistsAsync = async { searchSongs("Top Hits Playlist", 20) }
            val top50GlobalAsync = async { searchSongs("Global Top 50 Hits", 20) }
            val hits2026Async = async { searchSongs("2026 Hit Songs", 20) }
            val hits2025Async = async { searchSongs("2025 Hit Songs", 20) }
            val hits2024Async = async { searchSongs("2024 Hit Songs", 20) }
            val hits2023Async = async { searchSongs("2023 Hit Songs", 20) }
            val hits2020sAsync = async { searchSongs("Best of 2020s Hits", 20) }
            val hits2010sAsync = async { searchSongs("2010s Greatest Hits", 20) }
            val hits2000sAsync = async { searchSongs("2000s Greatest Hits", 20) }
            val hits90sAsync = async { searchSongs("90s Greatest Hits", 20) }

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
                        id = "saavn_made_for_you",
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
                        id = "saavn_top_songs",
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
                        id = "saavn_top_playlists",
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
                        id = "saavn_top_50_global",
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
                        id = "saavn_2026_hits",
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
                        id = "saavn_2025_hits",
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
                        id = "saavn_2024_hits",
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
                        id = "saavn_2023_hits",
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
                        id = "saavn_2020s_hits",
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
                        id = "saavn_2010s_hits",
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
                        id = "saavn_2000s_hits",
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
                        id = "saavn_90s_hits",
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
        val trimmed = query.trim()
        if (trimmed.isBlank()) {
            return@withContext loadHomeFeed()
        }

        val results = searchSongs(trimmed, 30)
        val shelves = listOf(
            Shelf.Lists.Tracks(
                id = "search_$trimmed",
                title = "Results for \"$trimmed\"",
                list = results,
                subtitle = "${results.size} tracks found on JioSaavn",
                type = Shelf.Lists.Type.Linear
            )
        )
        shelves.toFeed()
    }

    override suspend fun loadTrack(track: Track, isDownload: Boolean): Track {
        if (track.servers.isNotEmpty() && track.servers.first().extras.containsKey("stream_url")) {
            return track
        }
        val directUrl = track.extras["stream_url"]
        if (!directUrl.isNullOrBlank()) {
            val streamable = Streamable.server(
                id = track.id,
                quality = 320,
                title = "320 kbps (JioSaavn HQ)",
                extras = track.extras + mapOf(
                    "stream_url" to directUrl,
                    "extension_id" to "saavn_music",
                    "track_title" to track.title,
                    "artist_name" to track.artists.joinToString(", ") { it.name }
                )
            )
            return track.copy(streamables = listOf(streamable))
        }
        val query = "${track.title} ${track.artists.firstOrNull()?.name ?: ""}".trim()
        if (query.isNotBlank()) {
            val matches = searchSongs(query, 1)
            if (matches.isNotEmpty()) {
                return matches.first()
            }
        }
        return track
    }

    override suspend fun loadStreamableMedia(streamable: Streamable, isDownload: Boolean): Streamable.Media {
        val directUrl = streamable.extras["stream_url"]
        val encUrl = streamable.extras["encrypted_media_url"]

        val rawUrl = (if (!encUrl.isNullOrBlank()) {
            decryptRawMediaUrl(encUrl)
        } else if (!directUrl.isNullOrBlank()) {
            directUrl
        } else {
            val songId = streamable.id
            val url = "https://www.jiosaavn.com/api.php?__call=song.getDetails&cc=in&_marker=0%3F_marker%3D0&_format=json&pids=$songId"
            val req = Request.Builder().url(url).build()
            runCatching {
                client.newCall(req).execute().use { resp ->
                    val root = json.parseToJsonElement(resp.body.string()).jsonObject
                    val songObj = root[songId]?.jsonObject ?: root.values.firstOrNull()?.jsonObject
                    val enc = songObj?.get("encrypted_media_url")?.jsonPrimitive?.content
                    enc?.let { decryptRawMediaUrl(it) } ?: songObj?.get("media_preview_url")?.jsonPrimitive?.content
                }
            }.getOrNull()
        }) ?: error("Unable to retrieve direct audio stream for ${streamable.id}")

        val sources = getMultiQualitySources(rawUrl)
        return Streamable.Media.Server(sources, merged = false)
    }

    override suspend fun loadFeed(track: Track): Feed<Shelf>? = null
}
