package dev.brahmkshatriya.echo.desktop.ui.movie

import androidx.compose.ui.graphics.Color
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.NetworkRequest
import dev.brahmkshatriya.echo.common.models.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.awt.Desktop
import java.io.File
import java.net.URI
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

// =========================================================================
// 1. MOVIE BOX DOMAIN MODELS (From Movie Box Reverse Engineer Studio)
// =========================================================================

@Serializable
data class MovieBoxItem(
    val id: String,
    val title: String,
    val type: String = "movie", // "movie", "series", "livetv"
    val year: String = "2024",
    val duration: String = "",
    val genre: String = "Cinema",
    val rating: String = "8.5",
    val qualityBadge: String = "1080p HD",
    val coverUrl: String = "",
    val bannerUrl: String = "",
    val description: String = "",
    val provider: String = "moviebox",
    val rawTitle: String = "",
    val releaseDate: String = ""
) {
    fun toMovieSoundtrack(): MovieSoundtrack {
        val cleanGenre = genre.split(",").firstOrNull()?.trim() ?: "Action"
        return MovieSoundtrack(
            id = "mb_$id",
            title = title,
            year = year,
            directorOrComposer = "$genre • $qualityBadge",
            starCast = if (type == "series") "TV Series • $duration" else "Motion Picture • $duration",
            posterUrl = coverUrl.ifBlank { bannerUrl },
            backdropUrl = bannerUrl.ifBlank { coverUrl },
            bannerBadge = qualityBadge.ifBlank { "CINEMA 4K" },
            genre = cleanGenre,
            accentColor = when {
                genre.contains("Action", true) -> Color(0xFFE11D48)
                genre.contains("Sci-Fi", true) -> Color(0xFF38BDF8)
                genre.contains("Drama", true) -> Color(0xFFA855F7)
                genre.contains("Animation", true) || genre.contains("Anime", true) -> Color(0xFFF59E0B)
                genre.contains("Horror", true) -> Color(0xFF10B981)
                else -> Color(0xFFF43F5E)
            },
            description = description,
            tracks = emptyList(),
            movieBoxItem = this
        )
    }
}

@Serializable
data class MovieBoxCollection(
    val id: String,
    val name: String,
    val emoji: String = "🎬",
    val category: String = "collections",
    val color: String = "#E11D48",
    val tagline: String = "",
    val desc: String = "",
    val keywords: List<String> = emptyList()
)

@Serializable
data class MovieBoxLiveChannel(
    val id: String,
    val name: String,
    val category: String = "News",
    val logo: String = "",
    val url: String = "",
    val country: String = "Global"
)

data class MovieStreamOption(
    val id: String,
    val title: String,
    val url: String,
    val resolution: String = "1080",
    val format: String = "MP4",
    val isEmbed: Boolean = false,
    val size: String = "",
    val codec: String = "h264",
    val audio: String = "Original Audio",
    val sourceType: String = "moviebox"
)

enum class MovieSortOrder(val label: String) {
    NAME_ASC("Name (A → Z)"),
    NAME_DESC("Name (Z → A)"),
    RATING_DESC("Top Rated (★)"),
    YEAR_DESC("Year (Newest)"),
    YEAR_ASC("Year (Oldest)")
}

// Legacy compatibility model
data class MovieSoundtrack(
    val id: String,
    val title: String,
    val year: String,
    val directorOrComposer: String,
    val starCast: String,
    val posterUrl: String,
    val backdropUrl: String? = null,
    val bannerBadge: String = "BLOCKBUSTER OST",
    val genre: String,
    val accentColor: Color = Color(0xFFF43F5E),
    val description: String,
    val tracks: List<Track>,
    val movieBoxItem: MovieBoxItem? = null
)

// =========================================================================
// 2. REPOSITORY & MOVIE BOX CORE SERVICE
// =========================================================================

object MoviePlayRepository {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(8, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private const val MOVIEBOX_SERVER_URL = "http://127.0.0.1:3000"

    private var cachedCatalog: List<MovieBoxItem>? = null
    private var cachedCollections: List<MovieBoxCollection>? = null
    private var cachedChannels: List<MovieBoxLiveChannel>? = null

    // ---------------------------------------------------------------------
    // Catalog Loading with Multi-Layer Fallback
    // ---------------------------------------------------------------------

    fun getAllMovies(): List<MovieBoxItem> {
        cachedCatalog?.let { return it }

        val loaded = runCatching {
            loadCatalogFromJson()
        }.getOrNull()

        val result = if (!loaded.isNullOrEmpty()) {
            loaded
        } else {
            getCuratedFallbackCatalog()
        }
        cachedCatalog = result
        return result
    }

    private fun loadCatalogFromJson(): List<MovieBoxItem>? {
        // 1. Try ClassLoader Resource
        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("moviebox/curated_catalog.json")
            ?: this::class.java.classLoader?.getResourceAsStream("moviebox/curated_catalog.json")
        if (stream != null) {
            val content = stream.bufferedReader().use { it.readText() }
            if (content.isNotBlank()) {
                return json.decodeFromString<List<MovieBoxItem>>(content)
            }
        }

        // 2. Try App Resources Directory
        val resDir = System.getProperty("compose.application.resources.dir")
        if (!resDir.isNullOrBlank()) {
            val f = File(resDir, "moviebox/curated_catalog.json")
            if (f.exists()) {
                return json.decodeFromString<List<MovieBoxItem>>(f.readText(Charsets.UTF_8))
            }
        }

        // 3. Try Local File in Movie Box Directory
        val directPath = File("S:/All Code/Movie Box Reverse engineer/server/curated_catalog.json")
        if (directPath.exists()) {
            return json.decodeFromString<List<MovieBoxItem>>(directPath.readText(Charsets.UTF_8))
        }

        // 4. Try Workspace Source Resource Path
        val devResPath = File("desktopApp/src/desktopMain/resources/moviebox/curated_catalog.json")
        if (devResPath.exists()) {
            return json.decodeFromString<List<MovieBoxItem>>(devResPath.readText(Charsets.UTF_8))
        }

        // 5. Try Relative Path
        val relPath = File("app/resources/moviebox/curated_catalog.json")
        if (relPath.exists()) {
            return json.decodeFromString<List<MovieBoxItem>>(relPath.readText(Charsets.UTF_8))
        }

        return null
    }

    fun getFranchiseCollections(): List<MovieBoxCollection> {
        cachedCollections?.let { return it }

        val loaded = runCatching {
            loadCollectionsFromJson()
        }.getOrNull()

        val result = if (!loaded.isNullOrEmpty()) {
            loaded
        } else {
            getDefaultCollections()
        }
        cachedCollections = result
        return result
    }

    private fun loadCollectionsFromJson(): List<MovieBoxCollection>? {
        fun parseCollections(text: String): List<MovieBoxCollection>? {
            return runCatching {
                val element = json.parseToJsonElement(text).jsonObject
                val colArray = element["collections"]?.jsonArray ?: return null
                json.decodeFromString<List<MovieBoxCollection>>(colArray.toString())
            }.getOrNull()
        }

        // 1. ClassLoader Resource
        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("moviebox/collections.json")
            ?: this::class.java.classLoader?.getResourceAsStream("moviebox/collections.json")
        if (stream != null) {
            val content = stream.bufferedReader().use { it.readText() }
            val parsed = parseCollections(content)
            if (parsed != null) return parsed
        }

        // 2. Resources dir
        val resDir = System.getProperty("compose.application.resources.dir")
        if (!resDir.isNullOrBlank()) {
            val f = File(resDir, "moviebox/collections.json")
            if (f.exists()) {
                val parsed = parseCollections(f.readText(Charsets.UTF_8))
                if (parsed != null) return parsed
            }
        }

        // 3. Direct path
        val directPath = File("S:/All Code/Antigravity/echo-nightly/desktopApp/src/desktopMain/resources/moviebox/collections.json")
        if (directPath.exists()) {
            val parsed = parseCollections(directPath.readText(Charsets.UTF_8))
            if (parsed != null) return parsed
        }

        return null
    }

    fun getLiveTvChannels(): List<MovieBoxLiveChannel> {
        cachedChannels?.let { return it }

        val loaded = runCatching {
            loadLiveTvFromJson()
        }.getOrNull()

        val result = if (!loaded.isNullOrEmpty()) {
            loaded
        } else {
            getDefaultLiveChannels()
        }
        cachedChannels = result
        return result
    }

    private fun loadLiveTvFromJson(): List<MovieBoxLiveChannel>? {
        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("moviebox/livetv.json")
            ?: this::class.java.classLoader?.getResourceAsStream("moviebox/livetv.json")
        if (stream != null) {
            val content = stream.bufferedReader().use { it.readText() }
            return json.decodeFromString<List<MovieBoxLiveChannel>>(content)
        }

        val resDir = System.getProperty("compose.application.resources.dir")
        if (!resDir.isNullOrBlank()) {
            val f = File(resDir, "moviebox/livetv.json")
            if (f.exists()) {
                return json.decodeFromString<List<MovieBoxLiveChannel>>(f.readText(Charsets.UTF_8))
            }
        }

        return null
    }

    // ---------------------------------------------------------------------
    // Server Status & Background Starter
    // ---------------------------------------------------------------------

    suspend fun isMovieBoxServerOnline(): Boolean = withContext(Dispatchers.IO) {
        runCatching {
            val req = Request.Builder().url("$MOVIEBOX_SERVER_URL/api/status").build()
            httpClient.newCall(req).execute().use { it.isSuccessful }
        }.getOrDefault(false)
    }

    fun ensureServerRunning() {
        Thread {
            try {
                val req = Request.Builder().url("$MOVIEBOX_SERVER_URL/api/status").build()
                val ok = runCatching { httpClient.newCall(req).execute().use { it.isSuccessful } }.getOrDefault(false)
                if (!ok) {
                    val envDir = System.getenv("MOVIEBOX_SERVER_DIR")
                    val candidateDirs = listOfNotNull(
                        envDir?.let { File(it) },
                        File("S:/All Code/Movie Box Reverse engineer"),
                        File("moviebox_server"),
                        File(System.getProperty("user.home"), ".nightly/moviebox_server")
                    )
                    val serverDir = candidateDirs.firstOrNull { it.exists() && File(it, "server/index.js").exists() }
                    if (serverDir != null) {
                        val pb = ProcessBuilder("node", "server/index.js")
                        pb.directory(serverDir)
                        pb.redirectErrorStream(true)
                        pb.start()
                    }
                }
            } catch (_: Exception) {}
        }.start()
    }

    // ---------------------------------------------------------------------
    // Stream Resolution
    // ---------------------------------------------------------------------

    suspend fun searchOnlineMovies(query: String): List<MovieBoxItem> = withContext(Dispatchers.IO) {
        val trimmed = query.trim()
        if (trimmed.length < 2) return@withContext emptyList()

        runCatching {
            val enc = URLEncoder.encode(trimmed, "UTF-8")
            val results = mutableListOf<MovieBoxItem>()

            for (type in listOf("movie", "series")) {
                try {
                    val url = "https://v3-cinemeta.strem.io/catalog/$type/top/search=$enc.json"
                    val req = Request.Builder().url(url).header("User-Agent", "Mozilla/5.0").build()
                    val body = httpClient.newCall(req).execute().use { it.body?.string().orEmpty() }
                    if (body.isNotBlank()) {
                        val root = json.parseToJsonElement(body).jsonObject
                        val metas = root["metas"]?.jsonArray
                        if (metas != null) {
                            for (meta in metas) {
                                val obj = meta.jsonObject
                                val id = obj["id"]?.jsonPrimitive?.content ?: continue
                                val name = obj["name"]?.jsonPrimitive?.content ?: continue
                                val year = obj["releaseInfo"]?.jsonPrimitive?.content ?: "2024"
                                val poster = obj["poster"]?.jsonPrimitive?.content ?: ""
                                val background = obj["background"]?.jsonPrimitive?.content ?: poster
                                val desc = obj["description"]?.jsonPrimitive?.content ?: "Stream $name in HD with multi-audio and subtitles."
                                val isSeries = type == "series"
                                results.add(
                                    MovieBoxItem(
                                        id = id,
                                        title = name,
                                        type = type,
                                        year = year,
                                        duration = if (isSeries) "TV Series" else "120 min",
                                        genre = if (isSeries) "TV Series" else "Cinema",
                                        rating = "8.5",
                                        qualityBadge = if (isSeries) "HD TV" else "1080p HD",
                                        coverUrl = poster,
                                        bannerUrl = background,
                                        description = desc
                                    )
                                )
                            }
                        }
                    }
                } catch (_: Exception) {}
            }
            results
        }.getOrDefault(emptyList())
    }

    suspend fun resolveImdbId(cleanTitle: String, type: String): String? = withContext(Dispatchers.IO) {
        runCatching {
            val cinemetaType = if (type == "series") "series" else "movie"
            val enc = URLEncoder.encode(cleanTitle, "UTF-8")
            val url = "https://v3-cinemeta.strem.io/catalog/$cinemetaType/top/search=$enc.json"
            val req = Request.Builder().url(url).header("User-Agent", "Mozilla/5.0").build()
            val body = httpClient.newCall(req).execute().use { it.body?.string().orEmpty() }
            if (body.isNotBlank()) {
                val root = json.parseToJsonElement(body).jsonObject
                val metas = root["metas"]?.jsonArray
                if (metas != null && metas.isNotEmpty()) {
                    return@runCatching metas[0].jsonObject["id"]?.jsonPrimitive?.content
                }
            }
            null
        }.getOrNull()
    }

    suspend fun fetchMovieStreams(item: MovieBoxItem): List<MovieStreamOption> = withContext(Dispatchers.IO) {
        val streams = mutableListOf<MovieStreamOption>()
        val cleanTitle = item.title.replace(Regex("""\[.*?\]|\(.*?\)|4k|uhd|1080p|season \d+""", RegexOption.IGNORE_CASE), "").trim()
        val encTitle = URLEncoder.encode(cleanTitle, "UTF-8")

        // 1. Fetch Streams from Local MovieBox Server API
        runCatching {
            val url = "$MOVIEBOX_SERVER_URL/api/streams?id=${item.id}&type=${item.type}&title=$encTitle"
            val req = Request.Builder().url(url).build()
            val body = httpClient.newCall(req).execute().use { it.body?.string().orEmpty() }
            if (body.isNotBlank()) {
                val root = json.parseToJsonElement(body).jsonObject
                val streamArray = root["streams"]?.jsonArray
                if (streamArray != null) {
                    for (elem in streamArray) {
                        val obj = elem.jsonObject
                        val id = obj["id"]?.jsonPrimitive?.content ?: continue
                        val title = obj["title"]?.jsonPrimitive?.content ?: "Stream"
                        val rawUrl = obj["url"]?.jsonPrimitive?.content ?: continue
                        val res = obj["resolution"]?.jsonPrimitive?.content ?: "1080"
                        val format = obj["format"]?.jsonPrimitive?.content ?: "MP4"
                        val isEmbed = obj["isEmbed"]?.jsonPrimitive?.content?.toBooleanStrictOrNull() ?: false
                        val size = obj["size"]?.jsonPrimitive?.content ?: ""
                        val codec = obj["codec"]?.jsonPrimitive?.content ?: "h264"
                        val audio = obj["audio"]?.jsonPrimitive?.content ?: "Original Audio"
                        val st = obj["sourceType"]?.jsonPrimitive?.content ?: "moviebox"

                        val sUrl = if ((rawUrl.contains("hakunaymatata.com") || rawUrl.contains("aoneroom.com")) && !rawUrl.contains("stream-proxy")) {
                            "$MOVIEBOX_SERVER_URL/api/stream-proxy?url=${URLEncoder.encode(rawUrl, "UTF-8")}"
                        } else {
                            rawUrl
                        }
                        streams.add(MovieStreamOption(id, title, sUrl, res, format, isEmbed, size, codec, audio, st))
                    }
                }
            }
        }

        // 2. Guaranteed TMDB Mirror Generator for Native TMDB Titles (628 TV Series & 575 Movies)
        val tmdbId = when {
            item.id.startsWith("tv_") -> item.id.removePrefix("tv_").trim()
            item.id.length <= 8 && item.id.all { it.isDigit() } -> item.id.trim()
            else -> null
        }

        if (tmdbId != null && streams.none { it.url.contains("vidsrc.me") }) {
            val isSeries = item.type == "series" || item.id.startsWith("tv_")
            if (isSeries) {
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrc_$tmdbId",
                        title = "Mirror 1 • 1080p Full HD (VidSrc Direct)",
                        url = "https://vidsrc.me/embed/tv?tmdb=$tmdbId&season=1&episode=1",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "Full HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrcpm_$tmdbId",
                        title = "Mirror 2 • 1080p Ultra HD (VidSrc PM)",
                        url = "https://vidsrc.pm/embed/tv/$tmdbId/1-1",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_2embed_$tmdbId",
                        title = "Mirror 3 • 720p High Speed (2Embed)",
                        url = "https://2embed.cc/embed/tmdb/tv?id=$tmdbId&s=1&e=1",
                        resolution = "720",
                        format = "STREAM",
                        isEmbed = true,
                        size = "720p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_smashy_$tmdbId",
                        title = "Mirror 4 • Fast Stream (Smashy)",
                        url = "https://embed.smashystream.com/playere.php?tmdb=$tmdbId&season=1&episode=1",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
            } else {
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrc_$tmdbId",
                        title = "Mirror 1 • 1080p Full HD (VidSrc Direct)",
                        url = "https://vidsrc.me/embed/movie?tmdb=$tmdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "Full HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrcpm_$tmdbId",
                        title = "Mirror 2 • 1080p Ultra HD (VidSrc PM)",
                        url = "https://vidsrc.pm/embed/movie/$tmdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_2embed_$tmdbId",
                        title = "Mirror 3 • 720p High Speed (2Embed)",
                        url = "https://2embed.cc/embed/tmdb/movie?id=$tmdbId",
                        resolution = "720",
                        format = "STREAM",
                        isEmbed = true,
                        size = "720p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_smashy_$tmdbId",
                        title = "Mirror 4 • Fast Stream (Smashy)",
                        url = "https://embed.smashystream.com/playere.php?tmdb=$tmdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
            }
        }

        // 3. If still no mirror streams present, resolve verified Cinemeta IMDb ID for working mirrors
        val hasMirrors = streams.any { it.isEmbed && (it.url.contains("vidsrc") || it.url.contains("2embed") || it.url.contains("smashy")) }
        if (!hasMirrors) {
            val imdbId = if (item.id.startsWith("tt", ignoreCase = true)) item.id else resolveImdbId(cleanTitle, item.type)
            if (!imdbId.isNullOrBlank()) {
                val isSeries = item.type == "series"
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrc_$imdbId",
                        title = "Mirror 1 • 1080p Ultra HD (VidSrc Cloud)",
                        url = if (isSeries) "https://vidsrc.to/embed/tv/$imdbId/1/1" else "https://vidsrc.to/embed/movie/$imdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "Full HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrcpm_$imdbId",
                        title = "Mirror 2 • 1080p Full HD (VidSrc PM)",
                        url = if (isSeries) "https://vidsrc.pm/embed/tv/$imdbId/1-1" else "https://vidsrc.pm/embed/movie/$imdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_vidsrcxyz_$imdbId",
                        title = "Mirror 3 • 1080p VIP (VidSrc VIP)",
                        url = if (isSeries) "https://vidsrc.xyz/embed/tv/$imdbId/1-1" else "https://vidsrc.xyz/embed/movie/$imdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_2embed_$imdbId",
                        title = "Mirror 4 • 720p High Speed (2Embed)",
                        url = if (isSeries) "https://www.2embed.cc/embedtv/$imdbId&s=1&e=1" else "https://www.2embed.cc/embed/$imdbId",
                        resolution = "720",
                        format = "STREAM",
                        isEmbed = true,
                        size = "720p HD",
                        audio = "Original Audio + CC"
                    )
                )
                streams.add(
                    MovieStreamOption(
                        id = "mirror_smashy_$imdbId",
                        title = "Mirror 5 • Fast Stream (SmashyStream)",
                        url = if (isSeries) "https://embed.smashystream.com/playere.php?imdb=$imdbId&season=1&episode=1" else "https://embed.smashystream.com/playere.php?imdb=$imdbId",
                        resolution = "1080",
                        format = "STREAM",
                        isEmbed = true,
                        size = "1080p HD",
                        audio = "Original Audio + CC"
                    )
                )
            }
        }

        // 4. Primary High-Performance Web Cinema Studio Player Option
        streams.add(
            MovieStreamOption(
                id = "web_studio_${item.id}",
                title = "▶ Cinema Web Player (Full 4K/1080p, Subtitles & Audio Boost)",
                url = "$MOVIEBOX_SERVER_URL/?id=${item.id}&play=true",
                resolution = "1080",
                format = "WEB",
                isEmbed = true,
                size = "Instant",
                audio = "Multi-Audio + Subs"
            )
        )

        streams
    }

    suspend fun playMovieDirect(item: MovieBoxItem, onToast: (String) -> Unit) {
        onToast("▶ Preparing ${item.title}...")
        val streams = fetchMovieStreams(item)
        val best = streams.firstOrNull { !it.isEmbed } ?: streams.firstOrNull()
        if (best != null) {
            onToast("▶ Playing: ${item.title} (${best.title})")
            launchVideoStream(best.url, item.title, streams)
        } else {
            onToast("🎬 Opening ${item.title}...")
            launchVideoStream("$MOVIEBOX_SERVER_URL/?id=${item.id}&play=true", item.title)
        }
    }

    fun getTrailerUrl(title: String): String {
        val clean = title.replace(Regex("""\b(4k|uhd|2160p|1080p|bluray|season \d+)\b""", RegexOption.IGNORE_CASE), "").trim()
        val enc = URLEncoder.encode("$clean official trailer", "UTF-8")
        return "https://www.youtube.com/results?search_query=$enc"
    }

    // ---------------------------------------------------------------------
    // External Player & Browser Launchers
    // ---------------------------------------------------------------------

    fun openCinemaTheater(title: String, activeUrl: String, mirrors: List<MovieStreamOption> = emptyList()) {
        Thread {
            try {
                val tempDir = System.getProperty("java.io.tmpdir")
                val theaterFile = File(tempDir, "nightly_cinema_theater.html")

                val mirrorOptions = if (mirrors.isNotEmpty()) mirrors else listOf(
                    MovieStreamOption("current", "Default Server", activeUrl, "1080", "STREAM", true)
                )

                val mirrorsJsonArray = mirrorOptions.joinToString(",", "[", "]") { m ->
                    val safeTitle = m.title.replace("\\", "\\\\").replace("\"", "\\\"").replace("<", "&lt;").replace(">", "&gt;")
                    val safeUrl = m.url.replace("\\", "\\\\").replace("\"", "\\\"").replace("<", "&lt;").replace(">", "&gt;")
                    """{"id":"${m.id}","title":"$safeTitle","url":"$safeUrl","res":"${m.resolution}"}"""
                }

                val mirrorButtonsHtml = mirrorOptions.mapIndexed { idx, m ->
                    val isActive = if (m.url == activeUrl || (idx == 0 && mirrorOptions.none { it.url == activeUrl })) " active" else ""
                    val shortName = when {
                        m.title.contains("VidSrc Direct", true) -> "VidSrc Direct"
                        m.title.contains("VidSrc PM", true) -> "VidSrc PM"
                        m.title.contains("VidTo", true) -> "VidTo Server"
                        m.title.contains("2Embed", true) -> "2Embed Fast"
                        m.title.contains("Smashy", true) -> "Smashy Player"
                        m.title.contains("Hindi", true) -> "Hindi Dub"
                        m.title.contains("Original", true) -> "Original Audio"
                        m.title.contains("4K", true) -> "4K UHD"
                        m.title.contains("1080", true) -> "1080p HD"
                        else -> "Mirror ${idx + 1}"
                    }
                    """<button class="mirror-btn$isActive" onclick="selectMirror($idx)">$shortName</button>"""
                }.joinToString("\n")

                val cleanTitle = title.replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;")

                val html = """
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>$cleanTitle • Nightly Cinema Theater</title>
<style>
  * { box-sizing: border-box; margin: 0; padding: 0; }
  body {
    background-color: #07090e;
    color: #f1f5f9;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", sans-serif;
    overflow: hidden;
    height: 100vh;
    display: flex;
    flex-direction: column;
  }
  header {
    height: 52px;
    background: rgba(10, 12, 16, 0.92);
    backdrop-filter: blur(18px);
    -webkit-backdrop-filter: blur(18px);
    border-bottom: 1px solid rgba(225, 29, 72, 0.35);
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 16px;
    z-index: 100;
  }
  .brand {
    display: flex;
    align-items: center;
    gap: 12px;
    font-weight: 700;
    font-size: 13.5px;
    letter-spacing: 0.5px;
  }
  .brand-badge {
    background: rgba(225, 29, 72, 0.22);
    border: 1px solid #e11d48;
    color: #f43f5e;
    padding: 3px 9px;
    border-radius: 6px;
    font-size: 10.5px;
    font-weight: 800;
    letter-spacing: 0.8px;
  }
  .movie-title {
    font-size: 13.5px;
    font-weight: 700;
    color: #ffffff;
    max-width: 320px;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
  }
  .mirror-bar {
    display: flex;
    align-items: center;
    gap: 8px;
    overflow-x: auto;
    padding: 4px 0;
  }
  .mirror-btn {
    background: rgba(255, 255, 255, 0.08);
    border: 1px solid rgba(255, 255, 255, 0.14);
    color: #cbd5e1;
    padding: 6px 12px;
    border-radius: 8px;
    font-size: 12px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.2s ease;
    white-space: nowrap;
  }
  .mirror-btn:hover {
    background: rgba(255, 255, 255, 0.18);
    color: #ffffff;
    border-color: rgba(255, 255, 255, 0.3);
  }
  .mirror-btn.active {
    background: #e11d48;
    color: #ffffff;
    border-color: #e11d48;
    box-shadow: 0 0 14px rgba(225, 29, 72, 0.55);
  }
  .actions {
    display: flex;
    align-items: center;
    gap: 8px;
  }
  .action-btn {
    background: rgba(255, 255, 255, 0.08);
    border: 1px solid rgba(255, 255, 255, 0.15);
    color: #cbd5e1;
    padding: 6px 12px;
    border-radius: 8px;
    font-size: 12px;
    font-weight: 600;
    cursor: pointer;
    transition: all 0.2s ease;
  }
  .action-btn:hover {
    background: rgba(255, 255, 255, 0.18);
    color: #ffffff;
  }
  #player-container {
    flex: 1;
    width: 100%;
    height: calc(100vh - 52px);
    position: relative;
    background: #000;
  }
  iframe, video {
    width: 100%;
    height: 100%;
    border: none;
    display: block;
  }
</style>
</head>
<body>
  <header>
    <div class="brand">
      <span class="brand-badge">NIGHTLY CINEMA</span>
      <span class="movie-title">$cleanTitle</span>
    </div>
    <div class="mirror-bar">
$mirrorButtonsHtml
    </div>
    <div class="actions">
      <button class="action-btn" onclick="toggleFullscreen()">⛶ Fullscreen (F)</button>
    </div>
  </header>
  <div id="player-container">
    <iframe id="cinema-frame" src="$activeUrl" allowfullscreen allow="autoplay; fullscreen; encrypted-media; picture-in-picture"></iframe>
  </div>
  <script>
    const mirrors = $mirrorsJsonArray;
    function selectMirror(index) {
      if (!mirrors[index]) return;
      document.querySelectorAll('.mirror-btn').forEach((btn, idx) => {
        btn.classList.toggle('active', idx === index);
      });
      document.getElementById('cinema-frame').src = mirrors[index].url;
    }
    function toggleFullscreen() {
      if (!document.fullscreenElement) {
        document.documentElement.requestFullscreen().catch(() => {});
      } else {
        document.exitFullscreen().catch(() => {});
      }
    }
    window.addEventListener('keydown', (e) => {
      if (e.key === 'f' || e.key === 'F') toggleFullscreen();
      const num = parseInt(e.key);
      if (num >= 1 && num <= mirrors.length) selectMirror(num - 1);
    });
  </script>
</body>
</html>
                """.trimIndent()

                theaterFile.writeText(html, Charsets.UTF_8)
                openInBrowser(theaterFile.toURI().toString())
            } catch (e: Exception) {
                e.printStackTrace()
                openInBrowser(activeUrl)
            }
        }.start()
    }

    fun launchVideoStream(streamUrl: String, title: String, allStreams: List<MovieStreamOption> = emptyList()) {
        Thread {
            try {
                // If it is a direct CDN MP4 stream, proxy through local server so it never 428-blocks
                val targetUrl = if (streamUrl.contains("bcdn.") || streamUrl.contains("hakunaymatata") || streamUrl.contains("resource/")) {
                    if (!streamUrl.contains("stream-proxy")) {
                        "http://127.0.0.1:3000/api/stream-proxy?url=${URLEncoder.encode(streamUrl, "UTF-8")}"
                    } else {
                        streamUrl
                    }
                } else {
                    streamUrl
                }

                // Check for VLC on system
                val candidateVlcPaths = listOf(
                    "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe",
                    "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe"
                )
                val vlcExe = candidateVlcPaths.firstOrNull { File(it).exists() }
                val isEmbed = streamUrl.contains("/embed") || streamUrl.contains("vidsrc") || streamUrl.contains("2embed") || streamUrl.contains("smashy") || streamUrl.contains("/?id=")
                if (vlcExe != null && !isEmbed) {
                    val safeTitle = title.replace(Regex("[^a-zA-Z0-9 ._-]"), "")
                    val movieBoxUa = "com.community.oneroom/50020117 (Linux; U; Android 12; en_US; Redmi; Build/S1B.220414.015; Cronet/135.0.7012.3)"
                    ProcessBuilder(
                        vlcExe,
                        targetUrl,
                        "--http-user-agent=$movieBoxUa",
                        "--meta-title=$safeTitle",
                        "--network-caching=3000"
                    ).start()
                    return@Thread
                }

                // If embed or VLC not present, launch in Audix Cinema Theater
                openCinemaTheater(title, targetUrl, allStreams)
            } catch (e: Exception) {
                e.printStackTrace()
                openInBrowser(streamUrl)
            }
        }.start()
    }

    fun openInBrowser(url: String) {
        val trimmed = url.trim()
        if (trimmed.isBlank()) return

        val uri = runCatching { URI(trimmed) }.getOrNull()
        if (uri == null) {
            System.err.println("[MoviePlayModels] Security violation: Malformed URL rejected: $trimmed")
            return
        }

        val scheme = uri.scheme?.lowercase()
        val isValidHttp = scheme == "http" || scheme == "https"
        val isAllowedLocalHtml = scheme == "file" && (trimmed.endsWith(".html", ignoreCase = true) || trimmed.contains("cinema_theater.html"))

        if (!isValidHttp && !isAllowedLocalHtml) {
            System.err.println("[MoviePlayModels] Security violation: Blocked unauthorized URI scheme: $scheme")
            return
        }

        if (trimmed.any { it < ' ' || it == '\n' || it == '\r' || it == '\t' || it == '"' || it == '\'' }) {
            System.err.println("[MoviePlayModels] Security violation: Blocked control/quote characters in URL: $trimmed")
            return
        }

        Thread {
            try {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(uri)
                        return@Thread
                    } catch (_: Exception) {}
                }
                val os = System.getProperty("os.name").lowercase()
                val targetPath = if (scheme == "file") {
                    val fromFile = runCatching { File(uri).absolutePath }.getOrNull()
                    if (!fromFile.isNullOrBlank()) {
                        fromFile
                    } else {
                        val p = uri.path.orEmpty()
                        if (p.startsWith("/") && p.length > 2 && p[2] == ':') p.substring(1) else p
                    }
                } else {
                    trimmed
                }
                if (os.contains("win")) {
                    try {
                        ProcessBuilder("explorer.exe", targetPath).start()
                    } catch (_: Exception) {
                        ProcessBuilder("rundll32.exe", "url.dll,FileProtocolHandler", targetPath).start()
                    }
                } else if (os.contains("mac")) {
                    ProcessBuilder("open", targetPath).start()
                } else {
                    ProcessBuilder("xdg-open", targetPath).start()
                }
            } catch (e: Exception) {
                System.err.println("[MoviePlayModels] Failed to open browser: ${e.message}")
            }
        }.start()
    }

    // ---------------------------------------------------------------------
    // Audio Soundtrack & Jukebox Resolution
    // ---------------------------------------------------------------------

    private fun makeMovieTrack(
        id: String,
        title: String,
        artist: String,
        movieTitle: String,
        coverUrl: String,
        durationMs: Long
    ): Track {
        val cleanTitle = title.replace("&quot;", "\"").replace("&amp;", "&").replace("&#039;", "'").replace("&lt;", "<").replace("&gt;", ">").trim()
        val cleanArtist = artist.replace("&quot;", "\"").replace("&amp;", "&").replace("&#039;", "'").trim()
        val imgHolder = ImageHolder.NetworkRequestImageHolder(NetworkRequest(coverUrl), false)
        return Track(
            id = id,
            title = cleanTitle,
            artists = listOf(Artist("art_$id", cleanArtist, imgHolder)),
            album = Album(id = "alb_$id", title = movieTitle, cover = imgHolder),
            cover = imgHolder,
            duration = durationMs,
            extras = mapOf(
                "extension_id" to "saavn_music",
                "source" to "JioSaavn",
                "song_id" to id,
                "track_title" to cleanTitle,
                "artist_name" to cleanArtist,
                "album_name" to movieTitle,
                "cover_url" to coverUrl
            )
        )
    }

    suspend fun resolveSoundtrackForMovie(movieTitle: String): List<Track> = withContext(Dispatchers.IO) {
        runCatching {
            val clean = movieTitle.replace(Regex("""\[.*?]|\(.*?\)|4k|uhd|1080p|season \d+""", RegexOption.IGNORE_CASE), "").trim()

            // 1. Try direct song search for official theme / OST tracks
            val songEnc = URLEncoder.encode("$clean theme", "UTF-8")
            val songUrl = "https://www.jiosaavn.com/api.php?__call=search.getResults&_format=json&_marker=0&api_version=4&p=1&n=10&q=$songEnc"
            val songReq = Request.Builder().url(songUrl).header("User-Agent", "Mozilla/5.0").build()
            val songBody = httpClient.newCall(songReq).execute().use { it.body?.string().orEmpty() }
            if (songBody.isNotBlank()) {
                val root = json.parseToJsonElement(songBody).jsonObject
                val results = root["results"]?.jsonArray
                if (results != null && results.isNotEmpty()) {
                    val tracks = mutableListOf<Track>()
                    for (sElem in results) {
                        val sObj = sElem.jsonObject
                        val sid = sObj["id"]?.jsonPrimitive?.content ?: continue
                        val sTitle = sObj["title"]?.jsonPrimitive?.content ?: continue
                        val moreInfo = sObj["more_info"]?.jsonObject
                        val sArtist = moreInfo?.get("music")?.jsonPrimitive?.content
                            ?: moreInfo?.get("artist_name")?.jsonPrimitive?.content
                            ?: "Hans Zimmer / Cinema OST"
                        val sDur = moreInfo?.get("duration")?.jsonPrimitive?.content?.toLongOrNull()?.times(1000L) ?: 210000L
                        val rawImg = sObj["image"]?.jsonPrimitive?.content ?: ""
                        val highResImg = rawImg.replace("150x150", "500x500").replace("50x50", "500x500")
                        tracks.add(makeMovieTrack(sid, sTitle, sArtist, clean, highResImg, sDur))
                    }
                    if (tracks.isNotEmpty()) return@runCatching tracks
                }
            }

            // 2. Try album search
            val enc = URLEncoder.encode("$clean original soundtrack", "UTF-8")
            val url = "https://www.jiosaavn.com/api.php?__call=search.getAlbumResults&_format=json&_marker=0&api_version=4&p=1&n=5&q=$enc"
            val req = Request.Builder().url(url).header("User-Agent", "Mozilla/5.0").build()
            val body = httpClient.newCall(req).execute().use { it.body?.string().orEmpty() }
            if (body.isBlank()) return@runCatching emptyList()

            val root = json.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return@runCatching emptyList()
            if (results.isEmpty()) return@runCatching emptyList()

            val firstAlb = results[0].jsonObject
            val albId = firstAlb["id"]?.jsonPrimitive?.content ?: return@runCatching emptyList()
            val albTitle = firstAlb["title"]?.jsonPrimitive?.content ?: clean
            val rawImg = firstAlb["image"]?.jsonPrimitive?.content ?: ""
            val highResImg = rawImg.replace("150x150", "500x500").replace("50x50", "500x500")

            val detailUrl = "https://www.jiosaavn.com/api.php?__call=content.getAlbumDetails&_format=json&_marker=0&api_version=4&albumid=$albId"
            val dReq = Request.Builder().url(detailUrl).header("User-Agent", "Mozilla/5.0").build()
            val dBody = httpClient.newCall(dReq).execute().use { it.body?.string().orEmpty() }
            val dRoot = json.parseToJsonElement(dBody).jsonObject
            val songList = dRoot["list"]?.jsonArray ?: return@runCatching emptyList()

            val tracks = mutableListOf<Track>()
            for (sElem in songList) {
                val sObj = sElem.jsonObject
                val sid = sObj["id"]?.jsonPrimitive?.content ?: continue
                val sTitle = sObj["title"]?.jsonPrimitive?.content ?: continue
                val sArtist = sObj["more_info"]?.jsonObject?.get("artist_name")?.jsonPrimitive?.content ?: "Cinema Master"
                val sDur = sObj["more_info"]?.jsonObject?.get("duration")?.jsonPrimitive?.content?.toLongOrNull()?.times(1000L) ?: 210000L
                tracks.add(makeMovieTrack(sid, sTitle, sArtist, albTitle, highResImg, sDur))
            }
            tracks
        }.getOrDefault(emptyList())
    }

    // Curated movies list for home screen backwards compatibility
    fun getCuratedMovies(): List<MovieSoundtrack> {
        val all = getAllMovies()
        val converted = all.take(16).map { it.toMovieSoundtrack() }
        if (converted.isNotEmpty()) return converted

        return listOf(
            MovieSoundtrack(
                id = "movie_deadpool_wolverine",
                title = "Deadpool & Wolverine",
                year = "2024",
                directorOrComposer = "Shawn Levy • Music: Rob Simonsen",
                starCast = "Ryan Reynolds, Hugh Jackman, Emma Corrin",
                posterUrl = "https://pbcdn.aoneroom.com/image/2026/08/18/b40075c2cea4e0a29226c4045564d24e.jpg",
                bannerBadge = "4K ULTRA HD",
                genre = "Action",
                accentColor = Color(0xFFE11D48),
                description = "Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, teaming up with Wolverine.",
                tracks = emptyList()
            )
        )
    }

    // ---------------------------------------------------------------------
    // Fallback Data
    // ---------------------------------------------------------------------

    private fun getCuratedFallbackCatalog(): List<MovieBoxItem> {
        return listOf(
            MovieBoxItem(
                id = "8319000940355404624",
                title = "Deadpool & Wolverine",
                type = "movie",
                year = "2024",
                duration = "2h 8m",
                genre = "Action, Adventure, Comedy",
                rating = "8.5",
                qualityBadge = "1080p HD",
                coverUrl = "https://pbcdn.aoneroom.com/image/2026/08/18/b40075c2cea4e0a29226c4045564d24e.jpg",
                bannerUrl = "https://pbcdn.aoneroom.com/image/2026/08/18/b40075c2cea4e0a29226c4045564d24e.jpg",
                description = "Deadpool is offered a place in the Marvel Cinematic Universe by the Time Variance Authority, teaming up with Wolverine to save his universe.",
                provider = "moviebox"
            ),
            MovieBoxItem(
                id = "8319000940355404625",
                title = "Dune: Part Two",
                type = "movie",
                year = "2024",
                duration = "2h 46m",
                genre = "Action, Adventure, Sci-Fi",
                rating = "8.6",
                qualityBadge = "4K UHD",
                coverUrl = "https://pbcdn.aoneroom.com/image/2026/03/15/dune2_poster.jpg",
                bannerUrl = "https://pbcdn.aoneroom.com/image/2026/03/15/dune2_banner.jpg",
                description = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family.",
                provider = "moviebox"
            ),
            MovieBoxItem(
                id = "8319000940355404626",
                title = "Oppenheimer",
                type = "movie",
                year = "2023",
                duration = "3h 00m",
                genre = "Biography, Drama, History",
                rating = "8.9",
                qualityBadge = "IMAX 4K",
                coverUrl = "https://pbcdn.aoneroom.com/image/2026/07/21/oppenheimer_poster.jpg",
                bannerUrl = "https://pbcdn.aoneroom.com/image/2026/07/21/oppenheimer_banner.jpg",
                description = "The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb.",
                provider = "moviebox"
            )
        )
    }

    private fun getDefaultCollections(): List<MovieBoxCollection> {
        return listOf(
            MovieBoxCollection("the-avengers", "The Avengers", "🦸", "collections", "#DC2626", "Earth's Mightiest Heroes Assemble", "The complete Avengers saga uniting superheroes against cosmic extinction threats", listOf("avengers", "iron man", "captain america", "thor")),
            MovieBoxCollection("harry-potter", "Harry Potter", "⚡", "collections", "#D97706", "The Complete Wizarding World Chronicle", "Journey through all eight magical years at Hogwarts School of Witchcraft and Wizardry", listOf("harry potter", "fantastic beasts")),
            MovieBoxCollection("star-wars", "Star Wars", "🌌", "collections", "#EAB308", "A Long Time Ago in a Galaxy Far, Far Away", "The Skywalker saga, Jedi masters, Galactic Empire, and cosmic space rebellion", listOf("star wars", "mandalorian", "skywalker")),
            MovieBoxCollection("christopher-nolan", "Christopher Nolan Masterpieces", "🌀", "collections", "#3B82F6", "Mind-Bending Practical Cinema", "Non-linear epics, practical effects, and existential blockbusters by Christopher Nolan", listOf("oppenheimer", "interstellar", "inception", "dark knight", "tenet", "dunkirk")),
            MovieBoxCollection("john-wick", "John Wick Universe", "🎯", "collections", "#10B981", "Gun-Fu Continental Chronicles", "The underworld assassin odyssey of the Baba Yaga seeking vengeance and freedom", listOf("john wick", "continental", "ballerina")),
            MovieBoxCollection("fast-furious", "Fast & Furious", "🏎️", "collections", "#F59E0B", "Family, Speed & Gravity-Defying Heists", "Quarter-mile street races evolving into global covert operation spectacles", listOf("fast & furious", "fast x", "hobbs"))
        )
    }

    private fun getDefaultLiveChannels(): List<MovieBoxLiveChannel> {
        return listOf(
            MovieBoxLiveChannel("ch-bloomberg", "Bloomberg TV+", "News", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Bloomberg_Television_logo.svg/320px-Bloomberg_Television_logo.svg.png", "https://bloomberg.com/media-manifest/streams/us.m3u8", "US"),
            MovieBoxLiveChannel("ch-dw-news", "DW News English HD", "News", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Deutsche_Welle_symbol_2012.svg/320px-Deutsche_Welle_symbol_2012.svg.png", "https://dwamdstream102.akamaized.net/hls/live/2015525/dwstream102/index.m3u8", "DE"),
            MovieBoxLiveChannel("ch-redbull", "Red Bull TV Sports", "Sports", "https://upload.wikimedia.org/wikipedia/en/thumb/7/77/Red_Bull_TV_logo.svg/320px-Red_Bull_TV_logo.svg.png", "https://rbmn-live.akamaized.net/hls/live/590964/BoRB-AT/master.m3u8", "AT")
        )
    }
}
