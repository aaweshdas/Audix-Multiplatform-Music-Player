package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient
import dev.brahmkshatriya.echo.common.clients.TrackClient
import dev.brahmkshatriya.echo.common.models.Album
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
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.net.URLEncoder
import java.util.Base64
import java.util.concurrent.TimeUnit
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class YoutubeExtension : ExtensionClient, HomeFeedClient, SearchFeedClient, TrackClient {

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val jsonMediaType = "application/json; charset=utf-8".toMediaType()
    private val saavnDesKey = "38346591".toByteArray(Charsets.UTF_8)
    private val soundCloudClientId = "T574VRKI5KSLMzLdUreWOpXss1R3Fzfx"

    private suspend fun searchSongs(query: String, limit: Int = 25): List<Track> = withContext(Dispatchers.IO) {
        runCatching {
            val url = "https://music.youtube.com/youtubei/v1/search"
            val payload = """
                {
                    "context": {
                        "client": {
                            "clientName": "WEB_REMIX",
                            "clientVersion": "1.20240101.01.00",
                            "hl": "en",
                            "gl": "US"
                        }
                    },
                    "query": "${query.replace("\"", "\\\"")}"
                }
            """.trimIndent()

            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("Referer", "https://music.youtube.com/")
                .post(payload.toRequestBody(jsonMediaType))
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body)

            val tracks = mutableListOf<Track>()
            extractTracksFromElement(root, tracks, limit)
            tracks
        }.getOrDefault(emptyList())
    }

    private fun extractTracksFromElement(element: JsonElement, outList: MutableList<Track>, limit: Int) {
        if (outList.size >= limit) return
        when (element) {
            is JsonObject -> {
                val item = element["musicResponsiveListItemRenderer"]?.jsonObject
                if (item != null) {
                    val track = parseMusicResponsiveItem(item)
                    if (track != null) {
                        outList.add(track)
                        if (outList.size >= limit) return
                    }
                }
                for (value in element.values) {
                    extractTracksFromElement(value, outList, limit)
                    if (outList.size >= limit) return
                }
            }
            is JsonArray -> {
                for (item in element) {
                    extractTracksFromElement(item, outList, limit)
                    if (outList.size >= limit) return
                }
            }
            else -> {}
        }
    }

    private fun parseMusicResponsiveItem(item: JsonObject): Track? {
        return runCatching {
            // Find videoId
            var videoId: String? = item["playlistItemData"]?.jsonObject?.get("videoId")?.jsonPrimitive?.content
            val flexCols = item["flexColumns"]?.jsonArray

            if (videoId == null && flexCols != null) {
                for (col in flexCols) {
                    val runs = col.jsonObject["musicResponsiveListItemFlexColumnRenderer"]
                        ?.jsonObject?.get("text")?.jsonObject?.get("runs")?.jsonArray
                    if (runs != null) {
                        for (r in runs) {
                            val nav = r.jsonObject["navigationEndpoint"]?.jsonObject
                            val vid = nav?.get("watchEndpoint")?.jsonObject?.get("videoId")?.jsonPrimitive?.content
                            if (!vid.isNullOrBlank()) {
                                videoId = vid
                                break
                            }
                        }
                    }
                    if (videoId != null) break
                }
            }

            if (videoId.isNullOrBlank()) return null

            // Title
            val titleCol = flexCols?.firstOrNull()?.jsonObject
                ?.get("musicResponsiveListItemFlexColumnRenderer")?.jsonObject
                ?.get("text")?.jsonObject?.get("runs")?.jsonArray
            val title = titleCol?.firstOrNull()?.jsonObject?.get("text")?.jsonPrimitive?.content?.trim() ?: "Unknown Track"

            // Artist & Album
            var artistName = "YouTube Music"
            var albumName: String? = null
            if (flexCols != null && flexCols.size > 1) {
                val secondColRuns = flexCols[1].jsonObject
                    ?.get("musicResponsiveListItemFlexColumnRenderer")?.jsonObject
                    ?.get("text")?.jsonObject?.get("runs")?.jsonArray
                if (secondColRuns != null && secondColRuns.isNotEmpty()) {
                    val firstRun = secondColRuns[0].jsonObject["text"]?.jsonPrimitive?.content?.trim()
                    if (!firstRun.isNullOrBlank()) artistName = firstRun
                    if (secondColRuns.size > 2) {
                        val albumRun = secondColRuns[2].jsonObject["text"]?.jsonPrimitive?.content?.trim()
                        if (!albumRun.isNullOrBlank()) albumName = albumRun
                    }
                }
            }

            // Thumbnail
            var thumbUrl = "https://i.ytimg.com/vi/$videoId/hqdefault.jpg"
            val thumbRenderer = item["thumbnail"]?.jsonObject?.get("musicThumbnailRenderer")?.jsonObject
            val thumbs = thumbRenderer?.get("thumbnail")?.jsonObject?.get("thumbnails")?.jsonArray
            if (thumbs != null && thumbs.isNotEmpty()) {
                val lastThumb = thumbs.last().jsonObject["url"]?.jsonPrimitive?.content
                if (!lastThumb.isNullOrBlank()) {
                    thumbUrl = lastThumb
                }
            }

            val streamable = Streamable.server(
                id = videoId,
                quality = 160,
                title = "YouTube Audio (Adaptive)",
                extras = mapOf(
                    "video_id" to videoId,
                    "extension_id" to "youtube_music",
                    "track_title" to title,
                    "artist_name" to artistName
                )
            )

            Track(
                id = videoId,
                title = title,
                artists = listOf(Artist(id = artistName, name = artistName)),
                album = albumName?.let { Album(id = it, title = it) },
                cover = thumbUrl.toImageHolder(),
                streamables = listOf(streamable),
                extras = mapOf(
                    "video_id" to videoId,
                    "extension_id" to "youtube_music",
                    "track_title" to title,
                    "artist_name" to artistName
                )
            )
        }.getOrNull()
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
                        id = "ytm_made_for_you",
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
                        id = "ytm_top_songs",
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
                        id = "ytm_top_playlists",
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
                        id = "ytm_top_50_global",
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
                        id = "ytm_2026_hits",
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
                        id = "ytm_2025_hits",
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
                        id = "ytm_2024_hits",
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
                        id = "ytm_2023_hits",
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
                        id = "ytm_2020s_hits",
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
                        id = "ytm_2010s_hits",
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
                        id = "ytm_2000s_hits",
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
                        id = "ytm_90s_hits",
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
                id = "ytm_search_$trimmed",
                title = "Results for \"$trimmed\"",
                list = results,
                subtitle = "${results.size} tracks found on YouTube Music",
                type = Shelf.Lists.Type.Linear
            )
        )
        shelves.toFeed()
    }

    override suspend fun loadTrack(track: Track, isDownload: Boolean): Track {
        if (track.servers.isNotEmpty() && track.servers.first().extras.containsKey("video_id")) {
            return track
        }
        val videoId = track.extras["video_id"] ?: track.id
        val title = track.extras["track_title"] ?: track.title
        val artist = track.extras["artist_name"] ?: track.artists.firstOrNull()?.name ?: "YouTube Music"
        val s = Streamable.server(
            id = videoId,
            quality = 160,
            title = "YouTube Audio (Adaptive)",
            extras = track.extras + mapOf(
                "video_id" to videoId,
                "extension_id" to "youtube_music",
                "track_title" to title,
                "artist_name" to artist
            )
        )
        return track.copy(streamables = listOf(s))
    }

    override suspend fun loadStreamableMedia(streamable: Streamable, isDownload: Boolean): Streamable.Media = withContext(Dispatchers.IO) {
        val videoId = streamable.extras["video_id"] ?: streamable.id
        val rawTitle = streamable.extras["track_title"] ?: streamable.title ?: ""
        val trackTitle = if (rawTitle.equals("YouTube Audio (Adaptive)", ignoreCase = true)) "" else rawTitle
        val rawArtist = streamable.extras["artist_name"] ?: ""
        val artistName = if (rawArtist.equals("YouTube Music", ignoreCase = true)) "" else rawArtist

        // 1. Try resolving direct YouTube stream via ANDROID_VR Innertube
        val ytDirectUrl = tryResolveYouTubeDirect(videoId)
        if (!ytDirectUrl.isNullOrBlank()) {
            val source = Streamable.Source.Http(
                request = ytDirectUrl.toGetRequest(),
                quality = 160,
                title = "160 kbps (YouTube Direct)",
                isLive = false
            )
            return@withContext Streamable.Media.Server(listOf(source), merged = false)
        }

        // 2. High-fidelity audio match on JioSaavn (320kbps MP4/AAC)
        val query = if (artistName.isNotBlank() && !artistName.equals("YouTube Music", ignoreCase = true)) {
            "$trackTitle $artistName"
        } else {
            trackTitle
        }

        val saavnSources = tryMatchSaavnStream(query)
        if (!saavnSources.isNullOrEmpty()) {
            return@withContext Streamable.Media.Server(saavnSources, merged = false)
        }

        // 3. Fallback match on SoundCloud progressive MP3
        val soundcloudStreamUrl = tryMatchSoundCloudStream(query)
        if (!soundcloudStreamUrl.isNullOrBlank()) {
            val source = Streamable.Source.Http(
                request = soundcloudStreamUrl.toGetRequest(),
                quality = 128,
                title = "128 kbps (SoundCloud Stream)",
                isLive = false
            )
            return@withContext Streamable.Media.Server(listOf(source), merged = false)
        }

        error("Unable to resolve audio stream for YouTube track: $videoId ($trackTitle)")
    }

    private fun tryResolveYouTubeDirect(videoId: String): String? {
        return runCatching {
            val url = "https://www.youtube.com/youtubei/v1/player"
            val payload = """
                {
                    "context": {
                        "client": {
                            "clientName": "ANDROID_VR",
                            "clientVersion": "1.56.21",
                            "deviceMake": "Oculus",
                            "deviceModel": "Quest 3",
                            "osName": "Android",
                            "osVersion": "12"
                        }
                    },
                    "videoId": "$videoId"
                }
            """.trimIndent()

            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .post(payload.toRequestBody(jsonMediaType))
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val streamingData = root["streamingData"]?.jsonObject ?: return@runCatching null
            val adaptiveFormats = streamingData["adaptiveFormats"]?.jsonArray ?: return@runCatching null

            for (fmt in adaptiveFormats) {
                val fObj = fmt.jsonObject
                val mime = fObj["mimeType"]?.jsonPrimitive?.content ?: ""
                val directUrl = fObj["url"]?.jsonPrimitive?.content
                if (mime.contains("audio") && !directUrl.isNullOrBlank()) {
                    return@runCatching directUrl
                }
            }
            null
        }.getOrNull()
    }

    private fun decryptSaavnRawMediaUrl(encUrl: String): String? {
        return runCatching {
            val cleanEnc = encUrl.replace("\\/", "/").replace("\\", "").trim()
            val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(saavnDesKey, "DES"))
            val decodedBytes = Base64.getDecoder().decode(cleanEnc)
            val decryptedBytes = cipher.doFinal(decodedBytes)
            String(decryptedBytes, Charsets.UTF_8).trim()
        }.getOrNull()
    }

    private fun decryptSaavnMediaUrl(encUrl: String): String? {
        val raw = decryptSaavnRawMediaUrl(encUrl) ?: return null
        return raw.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
    }

    private fun getSaavnMultiQualitySources(rawUrl: String): List<Streamable.Source.Http> {
        val s320 = rawUrl.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
        val s160 = rawUrl.replace("_96.mp4", "_160.mp4").replace("_320.mp4", "_160.mp4")
        val s96 = rawUrl.replace("_320.mp4", "_96.mp4").replace("_160.mp4", "_96.mp4")
        return listOf(
            Streamable.Source.Http(request = s320.toGetRequest(), quality = 320, title = "320 kbps (High Fidelity)", isLive = false),
            Streamable.Source.Http(request = s160.toGetRequest(), quality = 160, title = "160 kbps (Standard)", isLive = false),
            Streamable.Source.Http(request = s96.toGetRequest(), quality = 96, title = "96 kbps (Efficient)", isLive = false)
        )
    }

    private fun tryMatchSaavnStream(query: String): List<Streamable.Source.Http>? {
        return runCatching {
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://www.jiosaavn.com/api.php?__call=search.getResults&_format=json&_marker=0&ctx=android&p=1&n=5&q=$encoded"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return@runCatching null
            if (results.isEmpty()) return@runCatching null

            val first = results[0].jsonObject
            val enc = first["encrypted_media_url"]?.jsonPrimitive?.content
            val preview = first["media_preview_url"]?.jsonPrimitive?.content

            val rawUrl = enc?.let { decryptSaavnRawMediaUrl(it) } ?: preview
            if (!rawUrl.isNullOrBlank()) {
                getSaavnMultiQualitySources(rawUrl)
            } else null
        }.getOrNull()
    }

    private fun tryMatchSoundCloudStream(query: String): String? {
        return runCatching {
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://api-v2.soundcloud.com/search/tracks?q=$encoded&client_id=$soundCloudClientId&limit=3"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val collection = root["collection"]?.jsonArray ?: return@runCatching null
            if (collection.isEmpty()) return@runCatching null

            val trackObj = collection[0].jsonObject
            val mediaObj = trackObj["media"]?.jsonObject
            val transArray = mediaObj?.get("transcodings")?.jsonArray ?: return@runCatching null

            for (elem in transArray) {
                val tObj = elem.jsonObject
                val format = tObj["format"]?.jsonObject
                val protocol = format?.get("protocol")?.jsonPrimitive?.content
                val transUrl = tObj["url"]?.jsonPrimitive?.content
                if (protocol == "progressive" && !transUrl.isNullOrBlank()) {
                    val streamReq = Request.Builder()
                        .url("$transUrl?client_id=$soundCloudClientId")
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                        .build()
                    val streamBody = client.newCall(streamReq).execute().use { it.body.string() }
                    val streamJson = json.parseToJsonElement(streamBody).jsonObject
                    val directUrl = streamJson["url"]?.jsonPrimitive?.content
                    if (!directUrl.isNullOrBlank()) return@runCatching directUrl
                }
            }
            null
        }.getOrNull()
    }

    override suspend fun loadFeed(track: Track): Feed<Shelf>? = null
}
