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
                    "query": "${query.replace("\"", "\\\"")}",
                    "params": "EgWKAQIIAWoKEAkQBRAKEAMQBA%3D%3D"
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

            // Title: combine all text runs
            val titleCol = flexCols?.firstOrNull()?.jsonObject
                ?.get("musicResponsiveListItemFlexColumnRenderer")?.jsonObject
                ?.get("text")?.jsonObject?.get("runs")?.jsonArray
            val rawTitle = titleCol?.mapNotNull { it.jsonObject["text"]?.jsonPrimitive?.content }
                ?.joinToString("")?.trim()?.ifBlank { null } ?: "Unknown Track"

            // Artist, Album & Duration
            var artistName = "YouTube Music"
            var albumName: String? = null
            var durationMs: Long? = null
            if (flexCols != null && flexCols.size > 1) {
                val secondColRuns = flexCols[1].jsonObject
                    ?.get("musicResponsiveListItemFlexColumnRenderer")?.jsonObject
                    ?.get("text")?.jsonObject?.get("runs")?.jsonArray
                if (secondColRuns != null && secondColRuns.isNotEmpty()) {
                    val rawRuns = secondColRuns.mapNotNull { it.jsonObject["text"]?.jsonPrimitive?.content }
                    val sections = mutableListOf<String>()
                    val curr = StringBuilder()
                    for (r in rawRuns) {
                        val cleaned = r.trim()
                        if (cleaned == "•" || cleaned == "·" || cleaned == "â€¢" || cleaned == "\u2022" || cleaned == "\u00b7" || cleaned == "\u2027" || cleaned == "\ufffd") {
                            if (curr.isNotBlank()) {
                                sections.add(curr.toString().trim())
                                curr.clear()
                            }
                        } else {
                            curr.append(r)
                        }
                    }
                    if (curr.isNotBlank()) {
                        sections.add(curr.toString().trim())
                    }

                    if (sections.isNotEmpty() && sections[0].lowercase() in setOf("song", "video", "episode", "podcast")) {
                        sections.removeAt(0)
                    }

                    if (sections.isNotEmpty()) {
                        var parsedArtist = sections[0].trim()
                        for (p in listOf("Song", "Video", "Episode", "Podcast")) {
                            if (parsedArtist.startsWith(p, ignoreCase = true)) {
                                parsedArtist = parsedArtist.substring(p.length).trim(' ', '\t', '\n', '\r', '•', '·', '-', '–', ':')
                            }
                        }
                        if (parsedArtist.isNotBlank() && !isGarbageArtist(parsedArtist)) {
                            artistName = parsedArtist
                        }
                    }

                    if (sections.size > 1) {
                        val lastSec = sections.last()
                        if (lastSec.contains(":") && lastSec.any { it.isDigit() }) {
                            val parts = lastSec.split(":")
                            if (parts.size == 2) {
                                val min = parts[0].trim().toLongOrNull() ?: 0L
                                val sec = parts[1].trim().toLongOrNull() ?: 0L
                                durationMs = (min * 60 + sec) * 1000L
                            }
                            if (sections.size > 2) {
                                val candAlbum = sections[1].trim()
                                if (!isGarbageAlbum(candAlbum)) {
                                    albumName = candAlbum
                                }
                            }
                        } else {
                            val candAlbum = sections[1].trim()
                            if (!isGarbageAlbum(candAlbum)) {
                                albumName = candAlbum
                            }
                        }
                    }
                }
            }

            if ((isGarbageArtist(artistName) || artistName == "YouTube Music") && rawTitle.contains(" - ")) {
                val left = rawTitle.substringBefore(" - ").trim()
                val right = rawTitle.substringAfter(" - ").trim()
                if (left.isNotBlank() && right.isNotBlank() && left.length < 50 && !isGarbageArtist(left)) {
                    artistName = left
                }
            }

            val cleanTitle = cleanTrackTitle(rawTitle, artistName)

            // Thumbnail with high-res 544x544 upgrade
            var thumbUrl = "https://i.ytimg.com/vi/$videoId/hqdefault.jpg"
            val thumbRenderer = item["thumbnail"]?.jsonObject?.get("musicThumbnailRenderer")?.jsonObject
            val thumbs = thumbRenderer?.get("thumbnail")?.jsonObject?.get("thumbnails")?.jsonArray
            if (thumbs != null && thumbs.isNotEmpty()) {
                val lastThumb = thumbs.last().jsonObject["url"]?.jsonPrimitive?.content
                if (!lastThumb.isNullOrBlank()) {
                    thumbUrl = lastThumb.replace(Regex("""=w\d+-h\d+[^&?]*"""), "=w544-h544-l90-rj")
                }
            }

            val streamable = Streamable.server(
                id = videoId,
                quality = 160,
                title = "YouTube Audio (Adaptive)",
                extras = buildMap {
                    put("video_id", videoId)
                    put("extension_id", "youtube_music")
                    put("track_title", cleanTitle)
                    if (!isGarbageArtist(artistName)) put("artist_name", artistName)
                    put("cover_url", thumbUrl)
                    if (albumName != null && !isGarbageAlbum(albumName)) put("album_name", albumName)
                }
            )

            val artistList = if (artistName.contains(",") || artistName.contains("&")) {
                artistName.split(Regex("""[,&]""")).map { it.trim() }.filter { it.isNotBlank() && !isGarbageArtist(it) }.map { Artist(id = it, name = it) }
            } else if (!isGarbageArtist(artistName)) {
                listOf(Artist(id = artistName, name = artistName))
            } else emptyList()

            val finalArtists = if (artistList.isNotEmpty()) artistList else listOf(Artist(id = "Audix Hi-Res Audio", name = "Audix Hi-Res Audio"))

            Track(
                id = videoId,
                title = cleanTitle,
                artists = finalArtists,
                album = albumName?.takeIf { !isGarbageAlbum(it) }?.let { Album(id = it, title = it) },
                cover = thumbUrl.toImageHolder(),
                duration = durationMs,
                streamables = listOf(streamable),
                extras = buildMap {
                    put("video_id", videoId)
                    put("extension_id", "youtube_music")
                    put("track_title", cleanTitle)
                    put("raw_title", rawTitle)
                    if (durationMs != null) put("duration_ms", durationMs.toString())
                    if (!isGarbageArtist(artistName)) put("artist_name", artistName)
                    put("cover_url", thumbUrl)
                    if (albumName != null && !isGarbageAlbum(albumName)) put("album_name", albumName)
                }
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

    private fun isGarbageArtist(name: String?): Boolean {
        if (name.isNullOrBlank()) return true
        val low = name.lowercase().trim()
        return low in setOf(
            "song", "video", "episode", "podcast", "youtube music", "unknown artist",
            "t-series", "sony music india", "zee music company", "speed records",
            "yrf", "tips official", "aditya music", "saregama music", "audix music",
            "audix hi-res audio", "various artists"
        ) || low.startsWith("user-")
    }

    private fun isGarbageAlbum(album: String?): Boolean {
        if (album.isNullOrBlank()) return true
        val low = album.lowercase().trim()
        if (low in setOf("single", "album", "ep", "audio", "video", "track", "music", "song", "audix", "youtube", "soundcloud", "unknown album", "various artists")) return true
        if (low.contains("views") || low.contains("view") || low.contains("subscribers") || low.contains("subscriber") || low.contains("ago") || low.contains("stream") || low.contains("watching")) return true
        if (low.matches(Regex("""^[\d\.,\s]+[kkmgbt]?\s*(views|subscribers|plays)?$""", RegexOption.IGNORE_CASE))) return true
        return false
    }

    private fun unescapeHtml(text: String): String {
        return text
            .replace("&quot;", "\"")
            .replace("&amp;", "&")
            .replace("&#039;", "'")
            .replace("&apos;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .trim()
    }

    private fun cleanTrackTitle(title: String, artist: String): String {
        var t = unescapeHtml(title)
        // Strip pipe metadata: "Song Title | Movie | Actors | Label" -> "Song Title"
        if (t.contains("|")) {
            val beforePipe = t.substringBefore("|").trim()
            if (beforePipe.isNotBlank()) {
                t = beforePipe
            }
        }
        // Strip double slashes or colons
        if (t.contains("//")) {
            val beforeSlash = t.substringBefore("//").trim()
            if (beforeSlash.isNotBlank()) {
                t = beforeSlash
            }
        }
        // Remove bracketed suffixes: (Official Music Video), [Official Audio], (Lyrics), (From "Movie"), etc.
        t = t.replace(Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song|from\s*["']|soundtrack|ost).*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
        t = t.replace(Regex("""\s*[\(\[\{]\s*from\s+.*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
        // Remove artist prefixes/suffixes if repeated
        if (artist.isNotBlank() && !isGarbageArtist(artist)) {
            val esc = Regex.escape(artist)
            t = t.replace(Regex("""^$esc\s*[-–:]\s*""", RegexOption.IGNORE_CASE), "")
            t = t.replace(Regex("""\s*[-–:]\s*$esc$""", RegexOption.IGNORE_CASE), "")
        } else if (t.contains(" - ") || t.contains(" – ")) {
            val parts = t.split(Regex("""\s+[-–]\s+"""))
            if (parts.size >= 2 && parts[1].isNotBlank()) {
                t = parts[1].trim()
            }
        }
        // Remove trailing " - Official Video", " - From ...", etc.
        t = t.replace(Regex("""\s*[-–:]\s*(?:official\s*video|official\s*audio|lyrics|lyric\s*video|from\s+["'].*?|soundtrack|ost)\s*$""", RegexOption.IGNORE_CASE), "")
        // Remove unparenthesized "feat. ..."
        t = t.replace(Regex("""\s+(?:feat|ft)\.?\s+.*$""", RegexOption.IGNORE_CASE), "")
        t = t.replace(Regex("""\s*[\(\[\{]\s*[\)\]\}]"""), "")
        // Clean whitespace
        t = t.replace(Regex("""\s+"""), " ").trim()
        return if (t.isNotBlank()) t else title.trim()
    }

    override suspend fun loadStreamableMedia(streamable: Streamable, isDownload: Boolean): Streamable.Media = withContext(Dispatchers.IO) {
        val videoId = streamable.extras["video_id"] ?: streamable.id
        val rawTitle = streamable.extras["track_title"] ?: streamable.title ?: ""
        val trackTitle = if (rawTitle.equals("YouTube Audio (Adaptive)", ignoreCase = true)) "" else rawTitle
        val rawArtist = streamable.extras["artist_name"] ?: ""
        val artistName = if (isGarbageArtist(rawArtist)) "" else rawArtist

        val cleanArtist = if (isGarbageArtist(artistName)) "" else artistName
        val cleanTitle = cleanTrackTitle(trackTitle, cleanArtist)
        val targetDurationMs = streamable.extras["duration_ms"]?.toLongOrNull()

        // 1. High-fidelity audio match on JioSaavn (320kbps MP4/AAC Studio Master) with verified candidate scoring
        if (cleanTitle.isNotBlank()) {
            val saavnSources = tryMatchSaavnStream(cleanTitle, cleanArtist, targetDurationMs)
            if (!saavnSources.isNullOrEmpty()) {
                return@withContext Streamable.Media.Server(saavnSources, merged = false)
            }
        }

        // 2. Direct YouTube stream via ANDROID Innertube client with guaranteed progressive MP4 fallback
        val ytDirectSources = tryResolveYouTubeDirect(videoId)
        if (!ytDirectSources.isNullOrEmpty()) {
            return@withContext Streamable.Media.Server(ytDirectSources, merged = false)
        }

        // 3. Fallback match on SoundCloud progressive MP3 with verified candidate scoring
        if (cleanTitle.isNotBlank()) {
            val soundcloudStreamUrl = tryMatchSoundCloudStream(cleanTitle, cleanArtist, targetDurationMs)
            if (!soundcloudStreamUrl.isNullOrBlank()) {
                val source = Streamable.Source.Http(
                    request = soundcloudStreamUrl.toGetRequest(),
                    quality = 128,
                    title = "128 kbps (SoundCloud Stream)",
                    isLive = false
                )
                return@withContext Streamable.Media.Server(listOf(source), merged = false)
            }
        }

        error("Unable to resolve audio stream for YouTube track: $videoId ($trackTitle by $artistName)")
    }

    private fun tryResolveYouTubeDirect(videoId: String): List<Streamable.Source.Http>? {
        return runCatching {
            val url = "https://www.youtube.com/youtubei/v1/player"
            val payload = """
                {
                    "context": {
                        "client": {
                            "clientName": "ANDROID",
                            "clientVersion": "20.10.38",
                            "hl": "en",
                            "gl": "US"
                        }
                    },
                    "videoId": "$videoId"
                }
            """.trimIndent()

            val req = Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .header("User-Agent", "com.google.android.youtube/20.10.38 (Linux; U; Android 14) gzip")
                .post(payload.toRequestBody(jsonMediaType))
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val streamingData = root["streamingData"]?.jsonObject ?: return@runCatching null
            val adaptiveFormats = streamingData["adaptiveFormats"]?.jsonArray ?: kotlinx.serialization.json.JsonArray(emptyList())
            val formats = streamingData["formats"]?.jsonArray ?: kotlinx.serialization.json.JsonArray(emptyList())

            val sources = mutableListOf<Streamable.Source.Http>()
            val uaHeader = mapOf("User-Agent" to "com.google.android.youtube/20.10.38 (Linux; U; Android 14) gzip")

            // Progressive formats (format 18: 360p MP4 / AAC) return HTTP 200 without Range header and never fail with 403
            for (fmt in formats) {
                val fObj = fmt.jsonObject
                val directUrl = fObj["url"]?.jsonPrimitive?.content
                val itag = fObj["itag"]?.jsonPrimitive?.content?.toIntOrNull() ?: 0
                if (!directUrl.isNullOrBlank()) {
                    val q = if (itag == 22) 320 else 256
                    sources.add(
                        Streamable.Source.Http(
                            request = directUrl.toGetRequest(headers = uaHeader),
                            quality = q,
                            title = "$q kbps (YouTube Direct Audio)",
                            isLive = false
                        )
                    )
                }
            }

            // Only fallback to adaptive formats if progressive format 18 is absent
            if (sources.isEmpty()) {
                for (fmt in adaptiveFormats) {
                    val fObj = fmt.jsonObject
                    val mime = fObj["mimeType"]?.jsonPrimitive?.content ?: ""
                    val directUrl = fObj["url"]?.jsonPrimitive?.content
                    val bitrate = fObj["bitrate"]?.jsonPrimitive?.content?.toIntOrNull() ?: 128000
                    if (mime.contains("audio") && !directUrl.isNullOrBlank()) {
                        val qualityKbps = (bitrate / 1000).coerceAtLeast(64)
                        val title = if (mime.contains("opus", ignoreCase = true)) "$qualityKbps kbps (YouTube Opus HQ)" else "$qualityKbps kbps (YouTube AAC)"
                        sources.add(
                            Streamable.Source.Http(
                                request = directUrl.toGetRequest(headers = uaHeader),
                                quality = qualityKbps,
                                title = title,
                                isLive = false
                            )
                        )
                    }
                }
            }
            if (sources.isNotEmpty()) sources.sortedByDescending { it.quality } else null
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

    private fun scoreTrackCandidate(
        candidateTitle: String,
        candidateArtist: String,
        targetTitle: String,
        targetArtist: String,
        candidateDurationMs: Long? = null,
        targetDurationMs: Long? = null
    ): Int {
        val cTitle = unescapeHtml(candidateTitle).lowercase().trim().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ")
        val cArtist = unescapeHtml(candidateArtist).lowercase().trim().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ")
        val tTitle = unescapeHtml(targetTitle).lowercase().trim().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ")
        val tArtist = unescapeHtml(targetArtist).lowercase().trim().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ")

        val normCTitle = cTitle.replace(Regex("""\s+"""), " ").trim()
        val normTTitle = tTitle.replace(Regex("""\s+"""), " ").trim()
        if (normCTitle.isBlank() || normTTitle.isBlank()) return 0

        var score = 0
        val cleanC = cleanTrackTitle(candidateTitle, "").lowercase().trim().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ").replace(Regex("""\s+"""), " ").trim()
        val cleanT = cleanTrackTitle(targetTitle, "").lowercase().trim().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ").replace(Regex("""\s+"""), " ").trim()

        val baseC = cleanC.substringBefore("-").trim()
        val baseT = cleanT.substringBefore("-").trim()

        val isExactTitleMatch = (normCTitle == normTTitle) ||
                (cleanC.isNotBlank() && cleanC == cleanT) ||
                ((baseC.isNotBlank() && baseC == cleanT) || (baseT.isNotBlank() && cleanC == baseT) || (baseC.isNotBlank() && baseT.isNotBlank() && baseC == baseT))

        if (isExactTitleMatch) {
            score += 60
        } else if (normCTitle.startsWith(normTTitle) || normTTitle.startsWith(normCTitle) || (cleanC.isNotBlank() && cleanT.isNotBlank() && (cleanC.startsWith(cleanT) || cleanT.startsWith(cleanC)))) {
            score += 40
        } else if (normCTitle.contains(normTTitle) || normTTitle.contains(normCTitle)) {
            score += 30
        }

        // Check Dash / Colon separation: "Artist - Title" or "Title - Artist"
        if (targetTitle.contains("-") || targetTitle.contains("–") || targetTitle.contains(":")) {
            val parts = targetTitle.split(Regex("""[-–:]""")).map { it.trim() }.filter { it.isNotBlank() }
            if (parts.size >= 2) {
                val pArt = parts[0].lowercase().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ").replace(Regex("""\s+"""), " ").trim()
                val pTit = parts.drop(1).joinToString(" ").lowercase().replace(Regex("""[^\p{L}\p{Nd}\s]"""), " ").replace(Regex("""\s+"""), " ").trim()
                // Artist - Title
                if (normCTitle == pTit || cleanC == pTit || pTit.contains(normCTitle) || normCTitle.contains(pTit)) {
                    if (cArtist.isNotBlank() && (cArtist.contains(pArt) || pArt.contains(cArtist))) {
                        score = maxOf(score, 85)
                    } else {
                        score = maxOf(score, 60)
                    }
                }
                // Title - Artist
                if (normCTitle == pArt || cleanC == pArt || pArt.contains(normCTitle) || normCTitle.contains(pArt)) {
                    if (cArtist.isNotBlank() && (cArtist.contains(pTit) || pTit.contains(cArtist))) {
                        score = maxOf(score, 85)
                    } else {
                        score = maxOf(score, 60)
                    }
                }
            }
        }

        if (score == 0) {
            val tWords = normTTitle.split(" ").filter { it.length > 2 }
            if (tWords.isNotEmpty()) {
                val matches = tWords.count { normCTitle.contains(it) }
                val ratio = matches.toFloat() / tWords.size
                if (ratio >= 0.75f) score += (30 * ratio).toInt() else return 0
            } else return 0
        }

        // Penalize remix/cover if target is not remix/cover
        val isTargetRemix = normTTitle.contains("remix") || normTTitle.contains("cover") || normTTitle.contains("live")
        val isCandRemix = normCTitle.contains("remix") || normCTitle.contains("cover") || normCTitle.contains("live") || normCTitle.contains("karaoke")
        if (isCandRemix && !isTargetRemix) {
            score -= 40
        }

        if (tArtist.isNotBlank() && !isGarbageArtist(tArtist)) {
            val normCArtist = cArtist.replace(Regex("""\s+"""), " ").trim()
            val normTArtist = tArtist.replace(Regex("""\s+"""), " ").trim()
            if (normCArtist.contains(normTArtist) || normTArtist.contains(normCArtist)) {
                score += 35
            } else {
                val firstWord = normTArtist.split(" ").firstOrNull { it.length > 2 }
                if (firstWord != null && normCArtist.contains(firstWord)) {
                    score += 20
                } else {
                    // Zero word overlap: If Title is an Exact Match (+60) AND duration matches within ±3000ms,
                    // award a Duration + Exact Title Synergy Bonus of +15 points (Total = 60 + 15 = 75),
                    // qualifying genuine regional/soundtrack tracks while blocking mismatches.
                    val isDurationMatch = candidateDurationMs != null && targetDurationMs != null &&
                            Math.abs(candidateDurationMs - targetDurationMs) <= 3000L
                    if (isExactTitleMatch && isDurationMatch) {
                        score += 15
                    } else {
                        // Conflicting artist with duration mismatch or non-exact title: reject candidate immediately
                        return 0
                    }
                }
            }
        }
        return score.coerceAtLeast(0)
    }

    private fun tryMatchSaavnStream(targetTitle: String, targetArtist: String, targetDurationMs: Long? = null): List<Streamable.Source.Http>? {
        return runCatching {
            val cleanArtist = if (isGarbageArtist(targetArtist)) "" else targetArtist
            val query = if (cleanArtist.isNotBlank()) "$targetTitle $cleanArtist" else targetTitle
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://www.jiosaavn.com/api.php?__call=search.getResults&_format=json&_marker=0&ctx=android&p=1&n=8&q=$encoded"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return@runCatching null
            if (results.isEmpty()) return@runCatching null

            var bestScore = -1
            var bestObj: JsonObject? = null
            for (elem in results) {
                val obj = elem.jsonObject
                val cTitle = obj["song"]?.jsonPrimitive?.content ?: ""
                val cArtist = obj["primary_artists"]?.jsonPrimitive?.content ?: ""
                val candDurationSec = obj["duration"]?.jsonPrimitive?.content?.toDoubleOrNull()
                val candDurationMs = candDurationSec?.let { (it * 1000).toLong() }
                val score = scoreTrackCandidate(cTitle, cArtist, targetTitle, targetArtist, candDurationMs, targetDurationMs)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            // Strictly require an authentic match (bestScore >= 75)
            if (bestScore < 75 || bestObj == null) {
                return@runCatching null
            }

            val sid = bestObj["id"]?.jsonPrimitive?.content ?: bestObj["songid"]?.jsonPrimitive?.content ?: return@runCatching null
            val dUrl = "https://www.jiosaavn.com/api.php?__call=song.getDetails&cc=in&_marker=0%3F_marker%3D0&_format=json&pids=$sid"
            val dReq = Request.Builder().url(dUrl).header("User-Agent", "Mozilla/5.0").build()
            val dBody = client.newCall(dReq).execute().use { it.body.string() }
            val dRoot = json.parseToJsonElement(dBody).jsonObject
            val songObj = dRoot[sid]?.jsonObject ?: dRoot.values.firstOrNull()?.jsonObject
            val enc = songObj?.get("encrypted_media_url")?.jsonPrimitive?.content
            val preview = songObj?.get("media_preview_url")?.jsonPrimitive?.content

            val rawUrl = enc?.let { decryptSaavnRawMediaUrl(it) } ?: preview
            if (!rawUrl.isNullOrBlank()) {
                getSaavnMultiQualitySources(rawUrl)
            } else null
        }.getOrNull()
    }

    private fun tryMatchSoundCloudStream(targetTitle: String, targetArtist: String, targetDurationMs: Long? = null): String? {
        return runCatching {
            val cleanArtist = if (isGarbageArtist(targetArtist)) "" else targetArtist
            val query = if (cleanArtist.isNotBlank()) "$targetTitle $cleanArtist" else targetTitle
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://api-v2.soundcloud.com/search/tracks?q=$encoded&client_id=$soundCloudClientId&limit=5"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val root = json.parseToJsonElement(body).jsonObject
            val collection = root["collection"]?.jsonArray ?: return@runCatching null
            if (collection.isEmpty()) return@runCatching null

            var bestScore = -1
            var bestObj: JsonObject? = null
            for (elem in collection) {
                val obj = elem.jsonObject
                val cTitle = obj["title"]?.jsonPrimitive?.content ?: ""
                val cArtist = obj["user"]?.jsonObject?.get("username")?.jsonPrimitive?.content ?: ""
                val candDurationMs = obj["duration"]?.jsonPrimitive?.content?.toLongOrNull()
                val score = scoreTrackCandidate(cTitle, cArtist, targetTitle, targetArtist, candDurationMs, targetDurationMs)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            // Strictly require an authentic match (bestScore >= 75)
            if (bestScore < 75 || bestObj == null) {
                return@runCatching null
            }

            val trackObj = bestObj
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
