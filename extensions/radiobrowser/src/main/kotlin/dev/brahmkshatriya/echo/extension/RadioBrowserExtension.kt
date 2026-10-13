package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient
import dev.brahmkshatriya.echo.common.clients.TrackClient
import dev.brahmkshatriya.echo.common.models.Artist
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

class RadioBrowserExtension : ExtensionClient, HomeFeedClient, SearchFeedClient, TrackClient {

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val apiBase = "https://de1.api.radio-browser.info/json"

    private suspend fun fetchStations(endpoint: String): List<Track> = withContext(Dispatchers.IO) {
        runCatching {
            val req = Request.Builder()
                .url("$apiBase/$endpoint")
                .header("User-Agent", "Audix/1.0.0 (Audix Multiplatform Music Player)")
                .build()
            val body = client.newCall(req).execute().use { it.body.string() }
            val array = json.parseToJsonElement(body).jsonArray
            array.mapNotNull { element ->
                runCatching {
                    val obj = element.jsonObject
                    val uuid = obj["stationuuid"]?.jsonPrimitive?.content ?: return@runCatching null
                    val name = obj["name"]?.jsonPrimitive?.content?.trim() ?: "Radio Station"
                    val streamUrl = obj["url_resolved"]?.jsonPrimitive?.content?.trim()
                        ?: obj["url"]?.jsonPrimitive?.content?.trim()
                        ?: return@runCatching null
                    if (streamUrl.isBlank()) return@runCatching null

                    val favicon = obj["favicon"]?.jsonPrimitive?.content?.takeIf { it.isNotBlank() }
                        ?: "https://icons.duckduckgo.com/ip3/www.radio-browser.info.ico"
                    val country = obj["country"]?.jsonPrimitive?.content?.takeIf { it.isNotBlank() } ?: "Global"
                    val tags = obj["tags"]?.jsonPrimitive?.content?.takeIf { it.isNotBlank() } ?: "Live Radio"
                    val bitrate = obj["bitrate"]?.jsonPrimitive?.content?.toIntOrNull() ?: 128
                    val trackStreamable = Streamable.server(
                        id = uuid,
                        quality = bitrate,
                        title = "$bitrate kbps",
                        extras = mapOf(
                            "stream_url" to streamUrl,
                            "extension_id" to "radio_browser",
                            "is_live" to "true",
                            "track_title" to name,
                            "artist_name" to "$country • $tags"
                        )
                    )

                    Track(
                        id = uuid,
                        title = name,
                        artists = listOf(Artist(id = country, name = "$country • $tags")),
                        cover = favicon.toImageHolder(),
                        streamables = listOf(trackStreamable),
                        duration = null,
                        extras = mapOf("stream_url" to streamUrl, "extension_id" to "radio_browser", "is_live" to "true")
                    )
                }.getOrNull()
            }
        }.getOrDefault(emptyList())
    }

    override suspend fun loadHomeFeed(): Feed<Shelf> = withContext(Dispatchers.IO) {
        val shelves = mutableListOf<Shelf>()

        coroutineScope {
            val madeForYouAsync = async { fetchStations("stations/bytag/hits?limit=20") }
            val topSongsAsync = async { fetchStations("stations/topclick/20") }
            val topPlaylistsAsync = async { fetchStations("stations/bytag/top40?limit=20") }
            val top50GlobalAsync = async { fetchStations("stations/topvote/20") }
            val hits2026Async = async { fetchStations("stations/bytag/today?limit=20") }
            val hits2025Async = async { fetchStations("stations/bytag/dance?limit=20") }
            val hits2024Async = async { fetchStations("stations/bytag/pop?limit=20") }
            val hits2023Async = async { fetchStations("stations/bytag/charts?limit=20") }
            val hits2020sAsync = async { fetchStations("stations/bytag/2020s?limit=20") }
            val hits2010sAsync = async { fetchStations("stations/bytag/2010s?limit=20") }
            val hits2000sAsync = async { fetchStations("stations/bytag/2000s?limit=20") }
            val hits90sAsync = async { fetchStations("stations/bytag/90s?limit=20") }

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
                        id = "radio_made_for_you",
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
                        id = "radio_top_songs",
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
                        id = "radio_top_playlists",
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
                        id = "radio_top_50_global",
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
                        id = "radio_2026_hits",
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
                        id = "radio_2025_hits",
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
                        id = "radio_2024_hits",
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
                        id = "radio_2023_hits",
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
                        id = "radio_2020s_hits",
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
                        id = "radio_2010s_hits",
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
                        id = "radio_2000s_hits",
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
                        id = "radio_90s_hits",
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
        val encoded = URLEncoder.encode(trimmed, "UTF-8")
        val results = fetchStations("stations/search?name=$encoded&limit=30")
        val shelves = listOf(
            Shelf.Lists.Tracks(
                id = "search_$encoded",
                title = "Stations for \"$trimmed\"",
                list = results,
                subtitle = "${results.size} stations found",
                type = Shelf.Lists.Type.Linear
            )
        )
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
                quality = 128,
                title = "128 kbps",
                extras = track.extras + mapOf(
                    "stream_url" to streamUrl,
                    "extension_id" to "radio_browser",
                    "is_live" to "true",
                    "track_title" to track.title,
                    "artist_name" to track.artists.joinToString(", ") { it.name }
                )
            )
            return track.copy(streamables = listOf(s))
        }
        return track
    }

    override suspend fun loadStreamableMedia(streamable: Streamable, isDownload: Boolean): Streamable.Media {
        val url = streamable.extras["stream_url"]
            ?: streamable.id.takeIf { it.startsWith("http") }
            ?: run {
                // If not in extras, query station detail
                val req = Request.Builder()
                    .url("$apiBase/stations/byuuid/${streamable.id}")
                    .header("User-Agent", "Audix/1.0.0")
                    .build()
                runCatching {
                    client.newCall(req).execute().use { resp ->
                        val array = json.parseToJsonElement(resp.body.string()).jsonArray
                        val obj = array.firstOrNull()?.jsonObject
                        obj?.get("url_resolved")?.jsonPrimitive?.content
                            ?: obj?.get("url")?.jsonPrimitive?.content
                    }
                }.getOrNull() ?: streamable.id
            }

        val httpSource = Streamable.Source.Http(
            request = url.toGetRequest(),
            quality = streamable.quality,
            title = streamable.title,
            isLive = true
        )
        return Streamable.Media.Server(listOf(httpSource), merged = false)
    }

    override suspend fun loadFeed(track: Track): Feed<Shelf>? = null
}
