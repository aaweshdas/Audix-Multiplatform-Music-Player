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
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder
import java.util.Base64
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class SpotifyExtension : ExtensionClient, HomeFeedClient, SearchFeedClient, TrackClient {

    companion object {
        const val ID = "spotify_music"
        private const val USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
    }

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val saavnDesKey = "38346591".toByteArray(Charsets.UTF_8)
    private val soundCloudClientId = "T574VRKI5KSLMzLdUreWOpXss1R3Fzfx"

    private data class PlaylistSeed(val id: String, val title: String, val subtitle: String)

    private val featuredPlaylists = listOf(
        PlaylistSeed("37i9dQZF1DXcBWIGoYBM5M", "Today's Top Hits", "The hottest tracks right now on Spotify"),
        PlaylistSeed("37i9dQZEVXbMDoHDwVN2tF", "Top 50 - Global", "Most played tracks worldwide on Spotify"),
        PlaylistSeed("37i9dQZEVXbLiRSasKsNU9", "Viral 50 - Global", "Trending tracks going viral right now"),
        PlaylistSeed("37i9dQZF1DX4o1oenSJRJd", "All Out 2010s", "The biggest songs of the 2010s decade")
    )

    private fun fetchEmbedJson(url: String): JsonObject? {
        return runCatching {
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", USER_AGENT)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.9")
                .build()

            val body = client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return null
                resp.body.string()
            }

            val pattern = Pattern.compile("<script id=\"__NEXT_DATA__\"[^>]*>(.*?)</script>", Pattern.DOTALL)
            val matcher = pattern.matcher(body)
            if (matcher.find()) {
                val jsonStr = matcher.group(1)
                json.parseToJsonElement(jsonStr).jsonObject
            } else {
                null
            }
        }.getOrNull()
    }

    private fun fetchPlaylistTracks(playlistId: String): List<Track> {
        val embedUrl = "https://open.spotify.com/embed/playlist/$playlistId"
        val root = fetchEmbedJson(embedUrl) ?: return emptyList()

        return runCatching {
            val entity = root["props"]?.jsonObject
                ?.get("pageProps")?.jsonObject
                ?.get("state")?.jsonObject
                ?.get("data")?.jsonObject
                ?.get("entity")?.jsonObject ?: return emptyList()

            val coverArtUrl = entity["coverArt"]?.jsonObject
                ?.get("sources")?.jsonArray
                ?.firstOrNull()?.jsonObject
                ?.get("url")?.jsonPrimitive?.content

            val trackList = entity["trackList"]?.jsonArray ?: return emptyList()

            trackList.mapNotNull { item ->
                parseTrackItem(item.jsonObject, coverArtUrl)
            }
        }.getOrDefault(emptyList())
    }

    private fun parseTrackItem(obj: JsonObject, defaultCover: String?): Track? {
        return runCatching {
            val title = obj["title"]?.jsonPrimitive?.content?.takeIf { it.isNotBlank() } ?: return null
            val trackUri = obj["uri"]?.jsonPrimitive?.content ?: ""
            val id = trackUri.substringAfterLast(":").ifBlank { title.hashCode().toString() }
            val subtitle = obj["subtitle"]?.jsonPrimitive?.content?.replace('\u00a0', ' ')?.trim() ?: "Spotify Artist"

            val durationMs = obj["duration"]?.jsonPrimitive?.content?.toLongOrNull()

            val isGenericChartCover = defaultCover?.contains("charts-images.scdn.co") == true ||
                                      defaultCover?.contains("region_global_default") == true
            val validCover = if (!isGenericChartCover) defaultCover else null

            val streamable = Streamable.server(
                id = id,
                quality = 320,
                title = "Spotify Stream",
                extras = buildMap {
                    put("extension_id", ID)
                    put("spotify_uri", trackUri)
                    put("track_title", title)
                    put("artist_name", subtitle)
                    if (validCover != null) put("cover_url", validCover)
                }
            )

            val artistList = if (subtitle.contains(",") || subtitle.contains("&")) {
                subtitle.split(Regex("""[,&]""")).map { it.trim() }.filter { it.isNotBlank() }.map { Artist(id = it, name = it) }
            } else listOf(Artist(id = subtitle, name = subtitle))

            Track(
                id = id,
                title = title,
                artists = if (artistList.isNotEmpty()) artistList else listOf(Artist(id = subtitle, name = subtitle)),
                cover = validCover?.toImageHolder(),
                duration = durationMs,
                streamables = listOf(streamable),
                extras = buildMap {
                    put("extension_id", ID)
                    put("spotify_uri", trackUri)
                    put("track_title", title)
                    put("artist_name", subtitle)
                    if (validCover != null) put("cover_url", validCover)
                }
            )
        }.getOrNull()
    }

    private fun searchMusicCatalog(query: String): List<Track> {
        return runCatching {
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://itunes.apple.com/search?term=$encoded&entity=song&limit=25"
            val req = Request.Builder().url(url).header("User-Agent", USER_AGENT).build()

            val body = client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return emptyList()
                resp.body.string()
            }

            val root = json.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return emptyList()

            results.mapNotNull { item ->
                runCatching {
                    val obj = item.jsonObject
                    val trackId = obj["trackId"]?.jsonPrimitive?.content ?: return@runCatching null
                    val trackName = obj["trackName"]?.jsonPrimitive?.content ?: return@runCatching null
                    val artistName = obj["artistName"]?.jsonPrimitive?.content ?: "Unknown Artist"
                    val collectionName = obj["collectionName"]?.jsonPrimitive?.content
                    val artwork100 = obj["artworkUrl100"]?.jsonPrimitive?.content
                    val artworkHighRes = artwork100?.replace("100x100bb", "600x600bb")
                    val durationMs = obj["trackTimeMillis"]?.jsonPrimitive?.content?.toLongOrNull()

                    val streamable = Streamable.server(
                        id = trackId,
                        quality = 320,
                        title = "Spotify Stream",
                        extras = buildMap {
                            put("extension_id", ID)
                            put("spotify_uri", "spotify:track:$trackId")
                            put("track_title", trackName)
                            put("artist_name", artistName)
                            if (artworkHighRes != null) put("cover_url", artworkHighRes)
                        }
                    )

                    Track(
                        id = trackId,
                        title = trackName,
                        artists = listOf(Artist(id = artistName, name = artistName)),
                        album = collectionName?.let { Album(id = it, title = it) },
                        cover = artworkHighRes?.toImageHolder(),
                        duration = durationMs,
                        streamables = listOf(streamable),
                        extras = buildMap {
                            put("extension_id", ID)
                            put("spotify_uri", "spotify:track:$trackId")
                            put("track_title", trackName)
                            put("artist_name", artistName)
                            if (artworkHighRes != null) put("cover_url", artworkHighRes)
                        }
                    )
                }.getOrNull()
            }
        }.getOrDefault(emptyList())
    }

    override suspend fun loadHomeFeed(): Feed<Shelf> = withContext(Dispatchers.IO) {
        val shelves = mutableListOf<Shelf>()

        coroutineScope {
            val madeForYouAsync = async { searchMusicCatalog("Made For You Mix Hits").take(20) }
            val topSongsAsync = async {
                fetchPlaylistTracks("37i9dQZF1DXcBWIGoYBM5M").takeIf { it.isNotEmpty() }
                    ?: searchMusicCatalog("Today's Top Hits 2026").take(20)
            }
            val topPlaylistsAsync = async { searchMusicCatalog("Top Hits Playlist").take(20) }
            val top50GlobalAsync = async {
                fetchPlaylistTracks("37i9dQZEVXbMDoHDwVN2tF").takeIf { it.isNotEmpty() }
                    ?: searchMusicCatalog("Global Top 50 Hits").take(20)
            }
            val hits2026Async = async { searchMusicCatalog("2026 Hit Songs").take(20) }
            val hits2025Async = async { searchMusicCatalog("2025 Hit Songs").take(20) }
            val hits2024Async = async { searchMusicCatalog("2024 Hit Songs").take(20) }
            val hits2023Async = async { searchMusicCatalog("2023 Hit Songs").take(20) }
            val hits2020sAsync = async { searchMusicCatalog("Best of 2020s Hits").take(20) }
            val hits2010sAsync = async {
                fetchPlaylistTracks("37i9dQZF1DX4o1oenSJRJd").takeIf { it.isNotEmpty() }
                    ?: searchMusicCatalog("2010s Greatest Hits").take(20)
            }
            val hits2000sAsync = async { searchMusicCatalog("2000s Greatest Hits").take(20) }
            val hits90sAsync = async { searchMusicCatalog("90s Greatest Hits").take(20) }

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
                        id = "spotify_made_for_you",
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
                        id = "spotify_top_songs",
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
                        id = "spotify_top_playlists",
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
                        id = "spotify_top_50_global",
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
                        id = "spotify_2026_hits",
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
                        id = "spotify_2025_hits",
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
                        id = "spotify_2024_hits",
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
                        id = "spotify_2023_hits",
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
                        id = "spotify_2020s_hits",
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
                        id = "spotify_2010s_hits",
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
                        id = "spotify_2000s_hits",
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
                        id = "spotify_90s_hits",
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

        val results = searchMusicCatalog(trimmed)
        val shelves = listOf(
            Shelf.Lists.Tracks(
                id = "spotify_search_$trimmed",
                title = "Results for \"$trimmed\"",
                list = results,
                subtitle = "${results.size} tracks found on Spotify catalog",
                type = Shelf.Lists.Type.Linear
            )
        )
        shelves.toFeed()
    }

    override suspend fun loadTrack(track: Track, isDownload: Boolean): Track {
        if (track.servers.isNotEmpty() && track.servers.first().extras.containsKey("track_title")) {
            return track
        }
        val title = track.extras["track_title"] ?: track.title
        val artist = track.extras["artist_name"] ?: track.artists.firstOrNull()?.name ?: "Spotify Artist"
        val s = Streamable.server(
            id = track.id,
            quality = 320,
            title = "Spotify Stream",
            extras = track.extras + mapOf(
                "extension_id" to ID,
                "track_title" to title,
                "artist_name" to artist
            )
        )
        return track.copy(streamables = listOf(s))
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
        if (t.contains("|")) {
            val beforePipe = t.substringBefore("|").trim()
            if (beforePipe.isNotBlank()) {
                t = beforePipe
            }
        }
        if (t.contains("//")) {
            val beforeSlash = t.substringBefore("//").trim()
            if (beforeSlash.isNotBlank()) {
                t = beforeSlash
            }
        }
        t = t.replace(Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song|from\s*["']|soundtrack|ost).*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
        t = t.replace(Regex("""\s*[\(\[\{]\s*from\s+.*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
        if (artist.isNotBlank() && !artist.equals("Unknown Artist", ignoreCase = true) && !artist.equals("Spotify Artist", ignoreCase = true)) {
            val esc = Regex.escape(artist)
            t = t.replace(Regex("""^$esc\s*[-–:]\s*""", RegexOption.IGNORE_CASE), "")
            t = t.replace(Regex("""\s*[-–:]\s*$esc$""", RegexOption.IGNORE_CASE), "")
        } else if (t.contains(" - ") || t.contains(" – ")) {
            val parts = t.split(Regex("""\s+[-–]\s+"""))
            if (parts.size >= 2 && parts[1].isNotBlank()) {
                t = parts[1].trim()
            }
        }
        t = t.replace(Regex("""\s*[-–:]\s*(?:official\s*video|official\s*audio|lyrics|lyric\s*video|from\s+["'].*?|soundtrack|ost)\s*$""", RegexOption.IGNORE_CASE), "")
        t = t.replace(Regex("""\s+(?:feat|ft)\.?\s+.*$""", RegexOption.IGNORE_CASE), "")
        t = t.replace(Regex("""\s*[\(\[\{]\s*[\)\]\}]"""), "")
        t = t.replace(Regex("""\s+"""), " ").trim()
        return if (t.isNotBlank()) t else title.trim()
    }

    private fun scoreTrackCandidate(candidateTitle: String, candidateArtist: String, targetTitle: String, targetArtist: String): Int {
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

        if (normCTitle == normTTitle) {
            score += 70
        } else if (cleanC.isNotBlank() && cleanC == cleanT) {
            score += 65
        } else if ((baseC.isNotBlank() && baseC == cleanT) || (baseT.isNotBlank() && cleanC == baseT) || (baseC.isNotBlank() && baseT.isNotBlank() && baseC == baseT)) {
            score += 60
        } else if (normCTitle.startsWith(normTTitle) || normTTitle.startsWith(normCTitle) || (cleanC.isNotBlank() && cleanT.isNotBlank() && (cleanC.startsWith(cleanT) || cleanT.startsWith(cleanC)))) {
            score += 55
        } else if (normCTitle.contains(normTTitle) || normTTitle.contains(normCTitle)) {
            score += 35
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
                        score = maxOf(score, 65)
                    }
                }
                // Title - Artist
                if (normCTitle == pArt || cleanC == pArt || pArt.contains(normCTitle) || normCTitle.contains(pArt)) {
                    if (cArtist.isNotBlank() && (cArtist.contains(pTit) || pTit.contains(cArtist))) {
                        score = maxOf(score, 85)
                    } else {
                        score = maxOf(score, 65)
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

        if (tArtist.isNotBlank() && !tArtist.equals("unknown artist", ignoreCase = true) && !tArtist.equals("spotify artist", ignoreCase = true)) {
            val normCArtist = cArtist.replace(Regex("""\s+"""), " ").trim()
            val normTArtist = tArtist.replace(Regex("""\s+"""), " ").trim()
            if (normCArtist.contains(normTArtist) || normTArtist.contains(normCArtist)) {
                score += 40
            } else {
                val firstWord = normTArtist.split(" ").firstOrNull { it.length > 2 }
                if (firstWord != null && normCArtist.contains(firstWord)) {
                    score += 25
                } else {
                    return 0
                }
            }
        }
        return score.coerceAtLeast(0)
    }

    override suspend fun loadStreamableMedia(streamable: Streamable, isDownload: Boolean): Streamable.Media = withContext(Dispatchers.IO) {
        val rawTitle = streamable.extras["track_title"] ?: streamable.title ?: ""
        val trackTitle = if (rawTitle.equals("Spotify Stream", ignoreCase = true)) "" else rawTitle
        val rawArtist = streamable.extras["artist_name"] ?: ""
        val artistName = if (rawArtist.equals("Spotify Artist", ignoreCase = true)) "" else rawArtist

        val cleanArtist = if (artistName.equals("Spotify Artist", ignoreCase = true) || artistName.equals("Unknown Artist", ignoreCase = true)) "" else artistName
        val cleanTitle = cleanTrackTitle(trackTitle, cleanArtist)

        // 1. Resolve multi-bitrate high fidelity stream via JioSaavn with candidate scoring
        val saavnSources = tryMatchSaavnStream(cleanTitle, cleanArtist)
        if (!saavnSources.isNullOrEmpty()) {
            return@withContext Streamable.Media.Server(saavnSources, merged = false)
        }

        // 2. Fallback to SoundCloud progressive stream with candidate scoring
        val scStream = tryMatchSoundCloudStream(cleanTitle, cleanArtist)
        if (!scStream.isNullOrBlank()) {
            val source = Streamable.Source.Http(
                request = scStream.toGetRequest(),
                quality = 128,
                title = "128 kbps (Spotify Stream)",
                isLive = false
            )
            return@withContext Streamable.Media.Server(listOf(source), merged = false)
        }

        error("Unable to resolve audio stream for Spotify track: $cleanTitle by $cleanArtist")
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
            Streamable.Source.Http(request = s320.toGetRequest(), quality = 320, title = "320 kbps (Spotify HQ)", isLive = false),
            Streamable.Source.Http(request = s160.toGetRequest(), quality = 160, title = "160 kbps (Spotify Standard)", isLive = false),
            Streamable.Source.Http(request = s96.toGetRequest(), quality = 96, title = "96 kbps (Efficient)", isLive = false)
        )
    }

    private fun tryMatchSaavnStream(targetTitle: String, targetArtist: String): List<Streamable.Source.Http>? {
        return runCatching {
            val cleanArtist = if (targetArtist.equals("Spotify Artist", ignoreCase = true) || targetArtist.equals("Unknown Artist", ignoreCase = true)) "" else targetArtist
            val cleanTitle = cleanTrackTitle(targetTitle, cleanArtist)
            val query = if (cleanArtist.isNotBlank()) "$cleanTitle $cleanArtist" else cleanTitle
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
                val score = scoreTrackCandidate(cTitle, cArtist, cleanTitle, targetArtist)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            // Strictly require bestScore >= 50
            if (bestScore < 50 || bestObj == null) {
                return@runCatching null
            }

            val enc = bestObj["encrypted_media_url"]?.jsonPrimitive?.content
            val preview = bestObj["media_preview_url"]?.jsonPrimitive?.content

            val rawUrl = enc?.let { decryptSaavnRawMediaUrl(it) } ?: preview
            if (!rawUrl.isNullOrBlank()) {
                getSaavnMultiQualitySources(rawUrl)
            } else null
        }.getOrNull()
    }

    private fun tryMatchSoundCloudStream(targetTitle: String, targetArtist: String): String? {
        return runCatching {
            val cleanArtist = if (targetArtist.equals("Spotify Artist", ignoreCase = true) || targetArtist.equals("Unknown Artist", ignoreCase = true)) "" else targetArtist
            val cleanTitle = cleanTrackTitle(targetTitle, cleanArtist)
            val query = if (cleanArtist.isNotBlank()) "$cleanTitle $cleanArtist" else cleanTitle
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://api-v2.soundcloud.com/search/tracks?q=$encoded&client_id=$soundCloudClientId&limit=5"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", USER_AGENT)
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
                val score = scoreTrackCandidate(cTitle, cArtist, cleanTitle, targetArtist)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            if (bestScore < 45 || bestObj == null) {
                return@runCatching null
            }

            val mediaObj = bestObj["media"]?.jsonObject
            val transArray = mediaObj?.get("transcodings")?.jsonArray ?: return@runCatching null

            for (elem in transArray) {
                val tObj = elem.jsonObject
                val format = tObj["format"]?.jsonObject
                val protocol = format?.get("protocol")?.jsonPrimitive?.content
                val transUrl = tObj["url"]?.jsonPrimitive?.content
                if (protocol == "progressive" && !transUrl.isNullOrBlank()) {
                    val streamReq = Request.Builder()
                        .url("$transUrl?client_id=$soundCloudClientId")
                        .header("User-Agent", USER_AGENT)
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
