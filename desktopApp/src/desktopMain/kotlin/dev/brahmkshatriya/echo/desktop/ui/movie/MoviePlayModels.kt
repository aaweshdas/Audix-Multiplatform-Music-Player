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
        .connectTimeout(4, TimeUnit.SECONDS)
        .readTimeout(6, TimeUnit.SECONDS)
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
                    val serverDir = File("S:/All Code/Movie Box Reverse engineer")
                    if (serverDir.exists()) {
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

    suspend fun fetchMovieStreams(item: MovieBoxItem): List<MovieStreamOption> = withContext(Dispatchers.IO) {
        val streams = mutableListOf<MovieStreamOption>()

        // 1. Try Live MovieBox Server API
        runCatching {
            val url = "$MOVIEBOX_SERVER_URL/api/streams?id=${item.id}&type=${item.type}"
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
                        val sUrl = obj["url"]?.jsonPrimitive?.content ?: continue
                        val res = obj["resolution"]?.jsonPrimitive?.content ?: "1080"
                        val format = obj["format"]?.jsonPrimitive?.content ?: "MP4"
                        val isEmbed = obj["isEmbed"]?.jsonPrimitive?.content?.toBooleanStrictOrNull() ?: false
                        val size = obj["size"]?.jsonPrimitive?.content ?: ""
                        val codec = obj["codec"]?.jsonPrimitive?.content ?: "h264"
                        val audio = obj["audio"]?.jsonPrimitive?.content ?: "Original Audio"
                        val st = obj["sourceType"]?.jsonPrimitive?.content ?: "moviebox"
                        streams.add(MovieStreamOption(id, title, sUrl, res, format, isEmbed, size, codec, audio, st))
                    }
                }
            }
        }

        // 2. If no streams returned, attach high-speed reliable mirror streams
        if (streams.isEmpty()) {
            val cleanTitle = item.title.replace(Regex("""\[.*?\]|\(.*?\)|4k|uhd|1080p""", RegexOption.IGNORE_CASE), "").trim()
            val enc = URLEncoder.encode(cleanTitle, "UTF-8")
            streams.add(
                MovieStreamOption(
                    id = "mirror_vidsrc_${item.id}",
                    title = "Mirror 1 • 1080p Full HD (VidSrc Direct)",
                    url = "https://vidsrc.me/embed/${if (item.type == "series") "tv" else "movie"}?title=$enc",
                    resolution = "1080",
                    format = "STREAM",
                    isEmbed = true,
                    size = "Full HD",
                    audio = "Original Audio + CC"
                )
            )
            streams.add(
                MovieStreamOption(
                    id = "mirror_vidto_${item.id}",
                    title = "Mirror 2 • 1080p Ultra HD (VidTo Server)",
                    url = "https://vidsrc.to/embed/${if (item.type == "series") "tv" else "movie"}/$enc",
                    resolution = "1080",
                    format = "STREAM",
                    isEmbed = true,
                    size = "1080p HD",
                    audio = "Original Audio + CC"
                )
            )
            streams.add(
                MovieStreamOption(
                    id = "mirror_2embed_${item.id}",
                    title = "Mirror 3 • 720p High Speed (2Embed)",
                    url = "https://2embed.cc/embed/${if (item.type == "series") "tv" else "movie"}?title=$enc",
                    resolution = "720",
                    format = "STREAM",
                    isEmbed = true,
                    size = "720p HD",
                    audio = "Original Audio + CC"
                )
            )
        }

        streams
    }

    fun getTrailerUrl(title: String): String {
        val clean = title.replace(Regex("""\b(4k|uhd|2160p|1080p|bluray|season \d+)\b""", RegexOption.IGNORE_CASE), "").trim()
        val enc = URLEncoder.encode("$clean official trailer", "UTF-8")
        return "https://www.youtube-nocookie.com/embed?listType=search&list=$enc&autoplay=1"
    }

    // ---------------------------------------------------------------------
    // External Player & Browser Launchers
    // ---------------------------------------------------------------------

    fun launchVideoStream(streamUrl: String, title: String) {
        // Try portable bundled VLC or system VLC
        Thread {
            try {
                val appDir = File(".").canonicalFile
                val portableVlc = File(appDir, "runtime/vlc/vlc.exe")
                val candidateVlcPaths = listOf(
                    portableVlc.absolutePath,
                    "C:\\Program Files\\VideoLAN\\VLC\\vlc.exe",
                    "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe"
                )
                val vlcExe = candidateVlcPaths.firstOrNull { File(it).exists() }
                if (vlcExe != null && !streamUrl.contains("/embed/")) {
                    ProcessBuilder(vlcExe, streamUrl, "--meta-title=$title").start()
                    return@Thread
                }
            } catch (_: Exception) {}

            // Open in browser
            openInBrowser(streamUrl)
        }.start()
    }

    fun openInBrowser(url: String) {
        Thread {
            try {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(URI(url))
                } else {
                    Runtime.getRuntime().exec(arrayOf("cmd.exe", "/c", "start", "", url))
                }
            } catch (_: Exception) {
                runCatching {
                    ProcessBuilder("cmd.exe", "/c", "start", "", url).start()
                }
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
        val imgHolder = ImageHolder.NetworkRequestImageHolder(NetworkRequest(coverUrl), false)
        return Track(
            id = id,
            title = title,
            artists = listOf(Artist("art_$id", artist, imgHolder)),
            album = Album(id = "alb_$id", title = movieTitle, cover = imgHolder),
            cover = imgHolder,
            duration = durationMs,
            extras = mapOf(
                "source" to "saavn",
                "track_title" to title,
                "artist_name" to artist,
                "album_name" to movieTitle,
                "cover_url" to coverUrl
            )
        )
    }

    suspend fun resolveSoundtrackForMovie(movieTitle: String): List<Track> = withContext(Dispatchers.IO) {
        runCatching {
            val clean = movieTitle.replace(Regex("""\[.*?\]|\(.*?\)|4k|uhd|1080p""", RegexOption.IGNORE_CASE), "").trim()
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
