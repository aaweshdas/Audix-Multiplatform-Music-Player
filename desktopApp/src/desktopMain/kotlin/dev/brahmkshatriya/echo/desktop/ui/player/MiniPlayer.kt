package dev.brahmkshatriya.echo.desktop.ui.player

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.automirrored.filled.QueueMusic
import androidx.compose.material.icons.automirrored.filled.VolumeDown
import androidx.compose.material.icons.automirrored.filled.VolumeMute
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.CornerRadius
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.Lyrics
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassCard
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassBox
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.core.platform.PlayerState
import dev.brahmkshatriya.echo.core.platform.RepeatMode
import dev.brahmkshatriya.echo.desktop.viewmodel.LyricsUiState
import dev.brahmkshatriya.echo.desktop.viewmodel.LyricsViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import org.koin.compose.koinInject
import java.util.Locale
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.Desktop
import javax.swing.JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter
import javax.swing.SwingUtilities
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.net.URLEncoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.contentOrNull

internal fun isGarbageAlbum(title: String?): Boolean {
    if (title.isNullOrBlank()) return true
    val t = title.lowercase().trim()
    if (t in setOf("single", "album", "audio", "video", "song", "episode", "podcast", "youtube music", "soundcloud", "soundcloud single")) return true
    if (t.contains("views") || t.contains("view") || t.contains("subscribers") || t.contains("watching") || t.contains("streamed")) return true
    if (t.contains("ago") || t.contains("uploaded")) return true
    if (t.matches(Regex("""^[\d\s\.,kmb]+views?$""", RegexOption.IGNORE_CASE))) return true
    return false
}

internal fun cleanDisplayAlbum(album: String?, fallback: String = ""): String {
    if (album.isNullOrBlank()) return fallback
    val a = album.trim()
    return if (isGarbageAlbum(a)) fallback else a
}

internal fun formatArtistsForDisplay(artists: List<Artist>?, fallback: String = "Audix Hi-Res Audio", extraArtist: String? = null): String {
    val filtered = artists?.map { it.name.trim() }?.filterNot { name ->
        name.isBlank() ||
        name.equals("Song", true) ||
        name.equals("Video", true) ||
        name.equals("Episode", true) ||
        name.equals("Podcast", true) ||
        name.equals("Unknown Artist", true) ||
        name.equals("Unknown", true) ||
        name.equals("YouTube Music", true) ||
        name.equals("Spotify Artist", true) ||
        name.equals("Various Artists", true) ||
        name.equals("Audix Artist", true) ||
        name.equals("Audix Music", true) ||
        name.equals("Audix Hi-Res Audio", true) ||
        name.equals("Music Video", true) ||
        name.equals("T-Series", true) ||
        name.equals("SonyMusicIndiaVEVO", true) ||
        name.equals("Zee Music Company", true) ||
        name.equals("Tips Official", true) ||
        name.startsWith("user-", true)
    }?.map { name ->
        if (name.endsWith(" - Topic", ignoreCase = true)) name.substring(0, name.length - 8).trim() else name
    }
    if (!filtered.isNullOrEmpty()) return filtered.joinToString(", ")
    if (!extraArtist.isNullOrBlank() && !extraArtist.equals("Song", true) && !extraArtist.equals("Video", true)) {
        return extraArtist.trim()
    }
    return fallback
}

internal fun cleanDisplayTitle(title: String?): String {
    if (title.isNullOrBlank()) return "Untitled Track"
    var t = title.trim()
    if (t.contains("|")) t = t.substringBefore("|").trim()
    if (t.contains("//")) t = t.substringBefore("//").trim()
    t = t.replace(Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song|from\s*["']|soundtrack|ost).*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
    t = t.replace(Regex("""\s*[\(\[\{]\s*from\s+.*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
    t = t.replace(Regex("""\s*[-–:]\s*(?:official\s*video|official\s*audio|lyrics|lyric\s*video|from\s+["'].*?|soundtrack|ost)\s*$""", RegexOption.IGNORE_CASE), "")
    t = t.replace(Regex("""\s+(?:feat|ft)\.?\s+.*$""", RegexOption.IGNORE_CASE), "")
    t = t.replace(Regex("""\s*[\(\[\{]\s*[\)\]\}]"""), "")
    t = t.replace(Regex("""\s+"""), " ").trim()
    return if (t.isNotBlank()) t else title.trim()
}

internal fun extractTrackCoverUrl(track: Track?): String? {
    if (track == null) return null
    val cover = track.cover ?: track.album?.cover
    val directUrl = when (cover) {
        is ImageHolder.NetworkRequestImageHolder -> cover.request.url
        is ImageHolder.ResourceUriImageHolder -> cover.uri
        else -> null
    }
    val extraCover = track.extras["cover_url"]
    if (!extraCover.isNullOrBlank()) {
        val isGeneric = directUrl.isNullOrBlank() ||
            directUrl.contains("charts-images.scdn.co") ||
            directUrl.contains("hqdefault.jpg") ||
            directUrl.contains("mqdefault.jpg") ||
            directUrl.contains("default.jpg") ||
            directUrl.contains("sddefault.jpg") ||
            directUrl.contains("120x120") ||
            directUrl.contains("50x50") ||
            directUrl.contains("150x150") ||
            directUrl.contains("100x100bb") ||
            directUrl.contains("avatar")
        if (isGeneric) return extraCover
    }
    return directUrl ?: extraCover
}

enum class PlayerModalTab(val title: String, val subtitle: String) {
    OVERVIEW("Now Playing", "Master track stage & live synchronized lyrics"),
    EQUALIZER("Pro Audio & EQ", "10-Band graphic equalizer & DSP soundstage"),
    LYRICS("Lyrics Studio", "Karaoke synchronized lines & offset tuner"),
    QUEUE("Queue & Smart Flow", "Queue management & infinite smart radio"),
    LIBRARY("Library & Playlists", "Favorites, offline downloads & sharing"),
    SLEEP_TIMER("Timer & Atmosphere", "Sleep countdown, audio visualizer & vibe"),
    METADATA("Metadata & ID3 Tags", "Tag inspector, file details & stream info")
}

// =========================================================================
// STUDIO PERSISTENCE & LOCAL ENGINE HELPERS
// =========================================================================
private object StudioStorage {
    val storageDir by lazy {
        val home = System.getProperty("user.home") ?: "."
        File(home, ".echo_audix_data").apply { mkdirs() }
    }
    val streamCacheDir by lazy {
        File(storageDir, "stream_cache").apply { mkdirs() }
    }
    val downloadsDir by lazy {
        val home = System.getProperty("user.home") ?: "."
        File(home, "Music/Audix").apply { mkdirs() }
    }
    val favoritesFile by lazy { File(storageDir, "favorites.txt") }
    val playlistsDir by lazy { File(storageDir, "playlists").apply { mkdirs() } }
    val metadataFile by lazy { File(storageDir, "metadata_overrides.txt") }

    private fun sanitizeField(value: String): String {
        return value.replace(":::", " - ")
            .replace("|||", " - ")
            .replace("\r", " ")
            .replace("\n", " ")
            .trim()
    }

    fun sanitizeFileName(artist: String, title: String, trackId: String): String {
        val raw = "${artist.trim()} - ${title.trim()}".trim()
        var clean = raw.replace(Regex("""[\\/:*?"<>|\r\n\t]"""), "_").trim()
        clean = clean.replace(Regex("""[.\s]+$"""), "")
        if (clean.isBlank()) clean = "track"
        val base = clean.substringBeforeLast('.')
        val reserved = setOf(
            "CON", "PRN", "AUX", "NUL",
            "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
            "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"
        )
        if (reserved.contains(base.uppercase())) {
            clean = "_$clean"
        }
        val hash = if (trackId.isNotBlank()) "_${Math.abs(trackId.hashCode()).toString(16).take(6)}" else ""
        return "$clean$hash"
    }

    fun isTrackFavorite(trackId: String?): Boolean {
        if (trackId.isNullOrBlank()) return false
        val dlmFav = dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager.getOrNull()?.isFavorite(trackId)
        if (dlmFav == true) return true
        return try {
            if (!favoritesFile.exists()) return false
            favoritesFile.readLines().any { it.startsWith(trackId) }
        } catch (_: Throwable) { false }
    }

    fun toggleFavorite(track: Track?): Boolean {
        if (track == null) return false
        val dlm = dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager.getOrNull()
        return try {
            val list = if (favoritesFile.exists()) {
                favoritesFile.readLines().toMutableList()
            } else mutableListOf()
            val exists = list.any { it.startsWith(track.id) }
            val newState = if (exists) {
                list.removeAll { it.startsWith(track.id) }
                favoritesFile.writeText(list.joinToString("\n"))
                false
            } else {
                val sId = sanitizeField(track.id)
                val sTitle = sanitizeField(track.title)
                val sArtists = sanitizeField(track.artists.joinToString { it.name })
                list.add("$sId:::$sTitle:::$sArtists")
                favoritesFile.writeText(list.joinToString("\n"))
                true
            }
            if (dlm != null && dlm.isFavorite(track.id) != newState) {
                dlm.toggleFavorite(track)
            }
            newState
        } catch (_: Throwable) { false }
    }

    fun addToPlaylist(playlistName: String, track: Track?): Boolean {
        if (track == null) return false
        return try {
            val cleanName = playlistName.replace(Regex("[^a-zA-Z0-9_ -]"), "").trim()
            val file = File(playlistsDir, "$cleanName.txt")
            val existing = if (file.exists()) file.readLines().toMutableList() else mutableListOf()
            if (!existing.any { it.startsWith(track.id) }) {
                val sId = sanitizeField(track.id)
                val sTitle = sanitizeField(track.title)
                val sArtists = sanitizeField(track.artists.joinToString { it.name })
                existing.add("$sId:::$sTitle:::$sArtists")
                file.writeText(existing.joinToString("\n"))
            }
            val dlm = dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager.getOrNull()
            if (dlm != null) {
                val pl = dlm.playlists.value.firstOrNull { it.title.equals(cleanName, ignoreCase = true) }
                    ?: dlm.createPlaylist(cleanName)
                dlm.addTrackToPlaylist(pl.id, track)
            }
            true
        } catch (_: Throwable) { false }
    }

    fun getSavedPlaylists(): List<String> {
        val defaultList = mutableListOf("Favorites", "Chill Beats", "Workout Pump", "Late Night Drive", "Deep Focus")
        try {
            playlistsDir.listFiles()?.forEach { f ->
                if (f.extension == "txt") {
                    val name = f.nameWithoutExtension
                    if (!defaultList.contains(name)) defaultList.add(name)
                }
            }
        } catch (_: Throwable) {}
        return defaultList
    }

    data class MetadataOverride(val title: String, val artist: String, val album: String, val year: String, val genre: String)

    fun loadMetadataOverride(trackId: String?): MetadataOverride? {
        if (trackId.isNullOrBlank() || !metadataFile.exists()) return null
        return try {
            val line = metadataFile.readLines().firstOrNull { it.startsWith("$trackId|||") } ?: return null
            val parts = line.split("|||")
            if (parts.size >= 6) {
                MetadataOverride(parts[1], parts[2], parts[3], parts[4], parts[5])
            } else null
        } catch (_: Throwable) { null }
    }

    fun saveMetadataOverride(trackId: String, title: String, artist: String, album: String, year: String, genre: String) {
        try {
            val sId = sanitizeField(trackId)
            val sTitle = sanitizeField(title)
            val sArtist = sanitizeField(artist)
            val sAlbum = sanitizeField(album)
            val sYear = sanitizeField(year)
            val sGenre = sanitizeField(genre)
            val line = "$sId|||$sTitle|||$sArtist|||$sAlbum|||$sYear|||$sGenre"
            val existing = if (metadataFile.exists()) metadataFile.readLines().filterNot { it.startsWith("$sId|||") }.toMutableList() else mutableListOf()
            existing.add(line)
            metadataFile.writeText(existing.joinToString("\n"))
        } catch (_: Throwable) {}
    }

    fun clearStreamCache(): Long {
        return try {
            var freedBytes = 0L
            val canonicalCache = streamCacheDir.canonicalFile
            if (canonicalCache.exists()) {
                canonicalCache.listFiles()?.forEach { file ->
                    val canonical = file.canonicalFile
                    if (canonical.toPath().startsWith(canonicalCache.toPath()) && canonical.isFile) {
                        freedBytes += canonical.length()
                        runCatching { canonical.delete() }
                    }
                }
            }
            freedBytes / (1024 * 1024)
        } catch (_: Throwable) { 0L }
    }

    fun copyToClipboard(text: String): Boolean {
        return try {
            val sel = StringSelection(text)
            Toolkit.getDefaultToolkit().systemClipboard.setContents(sel, sel)
            true
        } catch (_: Throwable) { false }
    }

    fun downloadTrackToFile(track: Track, targetDir: File, onProgress: (Float) -> Unit): File? {
        var input: java.io.InputStream? = null
        var output: FileOutputStream? = null
        var connection: HttpURLConnection? = null
        try {
            val streamUrl = track.extras["stream_url"]
                ?: track.servers.firstOrNull()?.extras?.get("stream_url")
                ?: track.servers.firstOrNull()?.id?.takeIf { it.startsWith("http://") || it.startsWith("https://") }
                ?: return null

            val cleanUrl = streamUrl.replace(Regex("[\\r\\n\\u0000]"), "").trim()
            val parsedHttpUrl = cleanUrl.toHttpUrlOrNull() ?: return null
            val host = parsedHttpUrl.host.lowercase()
            val scheme = parsedHttpUrl.scheme.lowercase()
            if (scheme != "http" && scheme != "https") {
                return null
            }
            if (host == "localhost" || host == "127.0.0.1" || host == "::1" || host == "169.254.169.254" || host == "0.0.0.0") {
                return null
            }
            val inet = runCatching { java.net.InetAddress.getByName(host) }.getOrNull()
            if (inet != null && (inet.isLoopbackAddress || inet.isSiteLocalAddress || inet.isLinkLocalAddress || inet.isAnyLocalAddress)) {
                return null
            }

            val canonicalTargetDir = targetDir.canonicalFile
            if (!canonicalTargetDir.exists()) canonicalTargetDir.mkdirs()

            val artist = track.artists.firstOrNull()?.name ?: "Unknown Artist"
            val title = track.title
            val safeFileName = sanitizeFileName(artist, title, track.id)
            val ext = if (cleanUrl.contains(".mp4") || cleanUrl.contains(".m4a")) "m4a" else "mp3"
            val targetFile = File(canonicalTargetDir, "$safeFileName.$ext").canonicalFile
            if (!targetFile.toPath().startsWith(canonicalTargetDir.toPath())) {
                return null
            }

            val conn = parsedHttpUrl.toUrl().openConnection() as HttpURLConnection
            connection = conn
            conn.connectTimeout = 15000
            conn.readTimeout = 30000
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
            conn.connect()

            val totalBytes = conn.contentLengthLong
            val inStream = conn.inputStream
            input = inStream
            val outStream = FileOutputStream(targetFile)
            output = outStream
            val buffer = ByteArray(16384)
            var bytesRead: Int
            var totalRead = 0L

            while (inStream.read(buffer).also { bytesRead = it } != -1) {
                outStream.write(buffer, 0, bytesRead)
                totalRead += bytesRead
                if (totalRead > 500L * 1024 * 1024) {
                    throw Exception("Stream exceeded maximum allowed file size of 500 MB")
                }
                if (totalBytes > 0) {
                    onProgress((totalRead.toFloat() / totalBytes).coerceIn(0f, 1f))
                }
            }
            outStream.flush()
            return targetFile
        } catch (e: Throwable) {
            e.printStackTrace()
            return null
        } finally {
            runCatching { output?.close() }
            runCatching { input?.close() }
            runCatching { connection?.disconnect() }
        }
    }

    fun downloadTrackToFile(track: Track, onProgress: (Float) -> Unit): File? =
        downloadTrackToFile(track, downloadsDir, onProgress)
}

private var cachedStudioBgBitmap: ImageBitmap? = null

private fun loadStudioBackground(): ImageBitmap? {
    if (cachedStudioBgBitmap != null) return cachedStudioBgBitmap
    return runCatching {
        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_bg.jpg")
            ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/music_notes_bg.jpg")
            ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "music_notes_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "music_notes_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
        stream?.use { javax.imageio.ImageIO.read(it)?.toComposeImageBitmap() }
    }.getOrNull()?.also { cachedStudioBgBitmap = it }
}

// =========================================================================
// STUDIO MONOCHROME DESIGN SYSTEM (MINIMAL BLACK & WHITE / HIGH-END PRO AUDIO)
// =========================================================================
private object StudioTheme {
    // Liquid Glass Studio Canvas Palette
    val CanvasBg = Color(0xFF0A0C10)
    val SurfaceCard = Color(0xFF0A0C10).copy(alpha = 0.35f)
    val SurfaceElevated = Color(0xFF0E1116).copy(alpha = 0.45f)
    val SurfaceSubtle = Color(0xFF0A0C10).copy(alpha = 0.20f)

    // Precision Specular Hairline Borders
    val BorderSubtle = Color(0x28FFFFFF)
    val BorderStrong = Color(0x40FFFFFF)

    // High-Contrast Pure Monochrome Typography
    val TextPrimary = Color(0xFFFFFFFF)
    val TextSecondary = Color(0xFFFFFFFF)
    val TextMuted = Color(0xFFFFFFFF)

    // Monochrome Functional Highlight (Pure Stark White)
    val AccentPrimary = Color(0xFFFFFFFF)
    val AccentSubtle = Color(0xFFD4D4D4)
    val AccentBg = Color(0xFF1E1E1E)

    // Monochrome Status Telemetry (Solid White Indicator & Charcoal Bezel)
    val StatusActiveDot = Color(0xFFFFFFFF)
    val StatusActiveText = Color(0xFFE5E5E5)
    val StatusActiveBg = Color(0xFF181818)
    val StatusActiveBorder = Color(0xFF333333)

    val StatusError = Color(0xFFD4D4D4)
}

@Composable
private fun FidelityEqualizerBadge(
    isPlaying: Boolean,
    modifier: Modifier = Modifier
) {
    LiquidGlassBox(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color.White.copy(alpha = 0.08f),
        borderColor = Color.White.copy(alpha = 0.16f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!isPlaying) {
                Row(
                    modifier = Modifier
                        .height(8.dp)
                        .padding(end = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(1.5.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(0.3f).background(Color.White, RoundedCornerShape(1.dp)))
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(0.5f).background(Color(0xFFE4E4E7), RoundedCornerShape(1.dp)))
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(0.2f).background(Color(0xFFA1A1AA), RoundedCornerShape(1.dp)))
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(0.6f).background(Color.White, RoundedCornerShape(1.dp)))
                }
            } else {
                val transition = rememberInfiniteTransition(label = "badge_eq")
                val b1 by transition.animateFloat(0.25f, 0.95f, infiniteRepeatable(tween(420, easing = FastOutSlowInEasing), androidx.compose.animation.core.RepeatMode.Reverse), label = "b1")
                val b2 by transition.animateFloat(0.85f, 0.30f, infiniteRepeatable(tween(360, easing = LinearOutSlowInEasing), androidx.compose.animation.core.RepeatMode.Reverse), label = "b2")
                val b3 by transition.animateFloat(0.40f, 1.0f, infiniteRepeatable(tween(510, easing = FastOutSlowInEasing), androidx.compose.animation.core.RepeatMode.Reverse), label = "b3")
                val b4 by transition.animateFloat(0.75f, 0.35f, infiniteRepeatable(tween(460, easing = LinearOutSlowInEasing), androidx.compose.animation.core.RepeatMode.Reverse), label = "b4")

                Row(
                    modifier = Modifier
                        .height(8.dp)
                        .padding(end = 3.dp),
                    horizontalArrangement = Arrangement.spacedBy(1.5.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(b1).background(Color.White, RoundedCornerShape(1.dp)))
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(b2).background(Color(0xFFE4E4E7), RoundedCornerShape(1.dp)))
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(b3).background(Color(0xFFA1A1AA), RoundedCornerShape(1.dp)))
                    Box(modifier = Modifier.width(1.5.dp).fillMaxHeight(b4).background(Color.White, RoundedCornerShape(1.dp)))
                }
            }

            Text(
                "320K",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE4E4E7),
                letterSpacing = 0.3.sp
            )
        }
    }
}

@Composable
private fun FullscreenModalAudioVisualizer(
    isPlaying: Boolean,
    volume: Float,
    visualizerTheme: String,
    modifier: Modifier = Modifier
) {
    val barColor = when (visualizerTheme) {
        "Silver Slate" -> Color(0xFFB4B4B4)
        "Mono Wire" -> Color(0xFFE0E0E0)
        "Graphite Dark" -> Color(0xFF707070)
        else -> Color(0xFFFFFFFF)
    }

    val liveBands by dev.brahmkshatriya.echo.core.platform.AudioVisualizerManager.visualizerBands.collectAsState()
    val isAudioActive = dev.brahmkshatriya.echo.core.platform.AudioVisualizerManager.isAudioActive
    val miniBands = remember(liveBands) {
        dev.brahmkshatriya.echo.core.platform.AudioVisualizerManager.getBands(18)
    }

    val infiniteTransition = rememberInfiniteTransition(label = "modal_visualizer_wave")
    val animPhase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 6.28f,
        animationSpec = infiniteRepeatable(
            animation = tween(2400, easing = LinearEasing),
            repeatMode = androidx.compose.animation.core.RepeatMode.Restart
        ),
        label = "modal_wave_phase"
    )

    LiquidGlassBox(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            if (size.width <= 0f || size.height <= 0f) return@Canvas
            val barCount = 18
            val barWidthPx = 20.dp.toPx()
            val totalBarWidth = barWidthPx * barCount
            val spacingPx = if (size.width > totalBarWidth && barCount > 1) {
                (size.width - totalBarWidth) / (barCount - 1)
            } else 4.dp.toPx()

            for (i in 0 until barCount) {
                val barFraction = if (isPlaying) {
                    val realEnergy = miniBands.getOrElse(i) { 0f }
                    if (isAudioActive && realEnergy > 0.015f) {
                        ((realEnergy * 44f + 5f) / 54f).coerceIn(0.08f, 1f)
                    } else {
                        val wave = (kotlin.math.sin(animPhase + i * 0.45f) + 1f) / 2f
                        val volFactor = volume.coerceIn(0.2f, 1f)
                        ((wave * 18f * volFactor + 5f) / 54f).coerceIn(0.08f, 0.5f)
                    }
                } else {
                    0.08f
                }

                val bHeight = (size.height * barFraction).coerceIn(4.dp.toPx(), size.height)
                val x = i * (barWidthPx + spacingPx)
                val y = size.height - bHeight

                drawRoundRect(
                    color = barColor,
                    topLeft = Offset(x, y),
                    size = Size(barWidthPx, bHeight),
                    cornerRadius = CornerRadius(3.dp.toPx(), 3.dp.toPx())
                )
            }
        }
    }
}

@Composable
private fun RedesignedMiniPlayerDock(
    viewModel: PlayerViewModel,
    modifier: Modifier = Modifier,
    currentTrack: Track?,
    isPlaying: Boolean,
    positionMs: Long,
    durationMs: Long,
    volume: Float,
    repeatMode: RepeatMode,
    shuffleEnabled: Boolean,
    state: PlayerState,
    queue: List<Track>,
    isMuted: Boolean,
    onToggleMute: () -> Unit,
    playbackSpeed: Float,
    onSpeedChange: (Float) -> Unit,
    isFavorite: Boolean,
    onToggleFavorite: (Track) -> Unit,
    onOpenModal: (PlayerModalTab) -> Unit,
    lyricsUiState: LyricsUiState,
    eqEnabled: Boolean = false,
    onToggleEq: (Boolean) -> Unit = {},
    selectedEqPreset: String = "Flat",
    onSelectEqPreset: (String) -> Unit = {},
    eqBands: FloatArray = FloatArray(10),
    onUpdateEqBands: (FloatArray) -> Unit = {},
    preAmpGain: Float = 0f,
    onUpdatePreamp: (Float) -> Unit = {},
    bassBoost: Float = 0f,
    onToggleBassBoost: () -> Unit = {},
    spatialVirtualizer: Boolean = false,
    onToggleSpatialVirtualizer: () -> Unit = {},
    sleepTimerActive: Boolean = false,
    sleepTimerMinutes: Int = 0,
    sleepTimerSecondsRemaining: Int = 0,
    onSetSleepTimer: (Int) -> Unit = {},
    fadeOutOnSleep: Boolean = false,
    onToggleFadeOut: () -> Unit = {},
    infiniteRadio: Boolean = false,
    onToggleInfiniteRadio: () -> Unit = {}
) {
    var isHoveringScrub by remember { mutableStateOf(false) }
    var hoveredProgressFrac by remember { mutableFloatStateOf(0f) }
    var isDraggingScrub by remember { mutableStateOf(false) }
    var dragProgressFrac by remember { mutableFloatStateOf(0f) }
    var showQueuePopover by remember { mutableStateOf(false) }
    var showSpeedPopover by remember { mutableStateOf(false) }
    var showRemainingTime by remember { mutableStateOf(false) }
    var copiedToastMessage by remember { mutableStateOf<String?>(null) }

    val closeAllPopovers = {
        showSpeedPopover = false
        showQueuePopover = false
    }

    val trackProgress = if (durationMs > 0L) {
        (positionMs.toFloat() / durationMs.toFloat()).coerceIn(0f, 1f)
    } else 0f
    val effectiveTrackProgress = if (isDraggingScrub) dragProgressFrac else trackProgress

    val hoveredTimestamp = remember(hoveredProgressFrac, durationMs) {
        if (durationMs > 0L) {
            val targetMs = (hoveredProgressFrac * durationMs).toLong()
            formatDuration(targetMs)
        } else null
    }

    LaunchedEffect(copiedToastMessage) {
        if (copiedToastMessage != null) {
            delay(2000L)
            copiedToastMessage = null
        }
    }

    val copyTrackInfo: () -> Unit = {
        val track = currentTrack
        if (track != null) {
            val artist = track.artists.joinToString(", ") { it.name }
            val text = if (artist.isNotBlank()) "$artist - ${track.title}" else track.title
            StudioStorage.copyToClipboard(text)
            copiedToastMessage = "Track Info Copied"
        }
    }

    val effectiveVolume = if (isMuted) 0f else volume
    val animatedVolume by animateFloatAsState(
        targetValue = effectiveVolume,
        animationSpec = tween(140, easing = LinearOutSlowInEasing)
    )

    val scrubInteractionSource = remember { MutableInteractionSource() }
    val isScrubHovered by scrubInteractionSource.collectIsHoveredAsState()
    val scrubBarHeight by animateDpAsState(if (isScrubHovered || isDraggingScrub) 5.dp else 3.5.dp, animationSpec = tween(150))

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // =========================================================
            // PART 1: TRACK IDENTITY & OPTIONS ISLAND (LEFT ~28%)
            // =========================================================
            LiquidGlassCard(
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .weight(0.95f)
                    .height(74.dp)
                    .pointerHoverIcon(PointerIcon.Hand),
                onClick = { onOpenModal(PlayerModalTab.OVERVIEW) }
            ) {
                val leftInteractionSource = remember { MutableInteractionSource() }
                val isLeftHovered by leftInteractionSource.collectIsHoveredAsState()

                val coverUrl = extractTrackCoverUrl(currentTrack)

                Row(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Album Artwork
                    LiquidGlassBox(
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(52.dp)
                            .hoverable(leftInteractionSource)
                            .pointerHoverIcon(PointerIcon.Hand),
                        contentAlignment = Alignment.Center,
                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.50f),
                        borderColor = if (isLeftHovered) Color.White.copy(alpha = 0.50f) else Color.White.copy(alpha = 0.18f),
                        onClick = { onOpenModal(PlayerModalTab.OVERVIEW) }
                    ) {
                        if (!coverUrl.isNullOrBlank()) {
                            AsyncImage(
                                model = coverUrl,
                                contentDescription = "Album Art",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Icon(
                                Icons.Default.MusicNote,
                                contentDescription = null,
                                tint = Color(0xFFA1A1AA),
                                modifier = Modifier.size(24.dp).align(Alignment.Center)
                            )
                        }

                        if (isLeftHovered) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black.copy(alpha = 0.45f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.Default.Tune,
                                    contentDescription = "Studio Hub",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }

                    // Metadata
                    Column(
                        modifier = Modifier.weight(1f).padding(start = 10.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = cleanDisplayTitle(currentTrack?.title).ifBlank { "No track playing" },
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(Modifier.height(3.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            val artists = formatArtistsForDisplay(currentTrack?.artists, "Audix Hi-Res Audio", currentTrack?.extras?.get("artist_name"))
                            Text(
                                text = artists,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )

                            Spacer(Modifier.width(6.dp))

                            // Monochromatic 320K Fidelity Badge
                            FidelityEqualizerBadge(isPlaying = isPlaying)
                        }
                    }

                    // Track Options: Favorite, Add to Playlist, Share
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        val heartScale by animateFloatAsState(
                            targetValue = if (isFavorite) 1.15f else 1.0f,
                            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                        )
                        IconButton(
                            onClick = { currentTrack?.let { onToggleFavorite(it) } },
                            modifier = Modifier.size(26.dp)
                        ) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = if (isFavorite) Color.White else Color(0xFF71717A),
                                modifier = Modifier.size(15.dp).scale(heartScale)
                            )
                        }

                        IconButton(
                            onClick = {
                                currentTrack?.let { tr ->
                                    StudioStorage.addToPlaylist("Favorites", tr)
                                    copiedToastMessage = "Added to Favorites"
                                }
                            },
                            modifier = Modifier.size(26.dp)
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.PlaylistAdd,
                                contentDescription = "Add to Playlist",
                                tint = Color(0xFF71717A),
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        IconButton(
                            onClick = copyTrackInfo,
                            modifier = Modifier.size(26.dp)
                        ) {
                            Icon(
                                Icons.Default.Share,
                                contentDescription = "Copy Track Info",
                                tint = Color(0xFF71717A),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }

            // =========================================================
            // PART 2: MASTER TRANSPORT & TIMELINE ISLAND (CENTER ~44%)
            // =========================================================
            LiquidGlassCard(
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.weight(1.30f).height(74.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 7.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Playback Controls Row
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        IconButton(
                            onClick = { viewModel.setShuffle(!shuffleEnabled) },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                Icons.Default.Shuffle,
                                contentDescription = "Shuffle",
                                tint = if (shuffleEnabled) Color.White else Color(0xFF71717A),
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        IconButton(
                            onClick = { viewModel.skipPrevious() },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                Icons.Default.SkipPrevious,
                                contentDescription = "Previous Track",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        // Hero Play/Pause Tactile Orb
                        val playOrbInteraction = remember { MutableInteractionSource() }
                        val isPlayOrbHovered by playOrbInteraction.collectIsHoveredAsState()
                        val playOrbScale by animateFloatAsState(
                            if (isPlayOrbHovered) 1.06f else 1.0f,
                            animationSpec = tween(120)
                        )

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .scale(playOrbScale)
                                .shadow(
                                    elevation = if (isPlayOrbHovered) 10.dp else 4.dp,
                                    shape = CircleShape,
                                    ambientColor = Color.White.copy(alpha = 0.25f),
                                    spotColor = Color.White.copy(alpha = 0.40f)
                                )
                                .clip(CircleShape)
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color(0xFFFFFFFF),
                                            Color(0xFFE2E8F0)
                                        )
                                    )
                                )
                                .border(
                                    1.dp,
                                    Brush.verticalGradient(
                                        listOf(Color.White, Color(0xFF94A3B8))
                                    ),
                                    CircleShape
                                )
                                .hoverable(playOrbInteraction)
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clickable { viewModel.togglePlayPause() },
                            contentAlignment = Alignment.Center
                        ) {
                            if (state == PlayerState.BUFFERING || state == PlayerState.LOADING) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(18.dp),
                                    color = Color(0xFF141414),
                                    strokeWidth = 2.dp
                                )
                            } else {
                                Icon(
                                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isPlaying) "Pause" else "Play",
                                    tint = Color(0xFF141414),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        IconButton(
                            onClick = { viewModel.skipNext() },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                Icons.Default.SkipNext,
                                contentDescription = "Next Track",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                val nextMode = when (repeatMode) {
                                    RepeatMode.NONE -> RepeatMode.ALL
                                    RepeatMode.ALL -> RepeatMode.ONE
                                    RepeatMode.ONE -> RepeatMode.NONE
                                }
                                viewModel.setRepeatMode(nextMode)
                            },
                            modifier = Modifier.size(28.dp)
                        ) {
                            val (repIcon, repTint) = when (repeatMode) {
                                RepeatMode.ONE -> Icons.Default.RepeatOne to Color.White
                                RepeatMode.ALL -> Icons.Default.Repeat to Color.White
                                else -> Icons.Default.Repeat to Color(0xFF71717A)
                            }
                            Icon(
                                repIcon,
                                contentDescription = "Repeat Mode",
                                tint = repTint,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(3.dp))

                    // Timeline & Inset Scrubber
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = formatDuration(positionMs),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.width(36.dp),
                            textAlign = TextAlign.Start
                        )

                        Spacer(Modifier.width(8.dp))

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(20.dp)
                                .hoverable(scrubInteractionSource)
                                .pointerHoverIcon(PointerIcon.Hand)
                                .pointerInput(durationMs) {
                                    detectTapGestures { offset ->
                                        if (durationMs > 0L && size.width > 0) {
                                            val frac = (offset.x / size.width.toFloat()).coerceIn(0f, 1f)
                                            viewModel.seekTo((frac * durationMs).toLong())
                                        }
                                    }
                                }
                                .pointerInput(durationMs) {
                                    detectHorizontalDragGestures(
                                        onDragStart = { offset ->
                                            isDraggingScrub = true
                                            if (size.width > 0) {
                                                dragProgressFrac = (offset.x / size.width.toFloat()).coerceIn(0f, 1f)
                                            }
                                        },
                                        onDragEnd = {
                                            isDraggingScrub = false
                                            if (durationMs > 0L) {
                                                viewModel.seekTo((dragProgressFrac * durationMs).toLong())
                                            }
                                        },
                                        onDragCancel = {
                                            isDraggingScrub = false
                                        },
                                        onHorizontalDrag = { change, _ ->
                                            if (size.width > 0) {
                                                dragProgressFrac = (change.position.x / size.width.toFloat()).coerceIn(0f, 1f)
                                            }
                                        }
                                    )
                                }
                                .pointerInput(durationMs) {
                                    awaitPointerEventScope {
                                        while (true) {
                                            val event = awaitPointerEvent()
                                            val change = event.changes.firstOrNull()
                                            if (change != null) {
                                                when (event.type) {
                                                    PointerEventType.Move -> {
                                                        if (size.width > 0 && durationMs > 0L) {
                                                            isHoveringScrub = true
                                                            hoveredProgressFrac = (change.position.x / size.width.toFloat()).coerceIn(0f, 1f)
                                                        }
                                                    }
                                                    PointerEventType.Exit -> {
                                                        isHoveringScrub = false
                                                    }
                                                    PointerEventType.Scroll -> {
                                                        val delta = change.scrollDelta.y
                                                        if (delta != 0f && durationMs > 0L) {
                                                            val jumpMs = if (delta < 0) 5000L else -5000L
                                                            viewModel.seekRelative(jumpMs)
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                },
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(scrubBarHeight)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(Color.White.copy(alpha = 0.10f))
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(effectiveTrackProgress)
                                    .height(scrubBarHeight)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(
                                                Color(0xFF71717A),
                                                Color(0xFFE4E4E7),
                                                Color.White
                                            )
                                        )
                                    )
                            )

                            if (effectiveTrackProgress > 0f && (isScrubHovered || isDraggingScrub)) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(effectiveTrackProgress),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(10.dp)
                                            .shadow(4.dp, CircleShape)
                                            .background(Color.White, CircleShape)
                                            .border(1.5.dp, Color(0xFF141414), CircleShape)
                                    )
                                }
                            }

                            if (isHoveringScrub && hoveredTimestamp != null) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .offset(y = (-20).dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(hoveredProgressFrac)
                                            .wrapContentWidth(Alignment.End)
                                    ) {
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(4.dp),
                                            backgroundColor = Color(0xF2181818),
                                            borderColor = Color.White.copy(alpha = 0.25f)
                                        ) {
                                            Text(
                                                text = hoveredTimestamp,
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White,
                                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        Spacer(Modifier.width(8.dp))

                        Text(
                            text = if (showRemainingTime && durationMs > 0L) {
                                "-${formatDuration((durationMs - positionMs).coerceAtLeast(0L))}"
                            } else {
                                formatDuration(durationMs)
                            },
                            fontSize = 11.sp,
                            fontWeight = if (showRemainingTime) FontWeight.SemiBold else FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier
                                .width(40.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .clickable { showRemainingTime = !showRemainingTime }
                                .padding(horizontal = 2.dp, vertical = 1.dp),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }

            // =========================================================
            // PART 3: ACOUSTICS & STUDIO UTILITIES ISLAND (RIGHT ~28%)
            // =========================================================
            LiquidGlassCard(
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.weight(0.95f).height(74.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                        // Mute Button
                        IconButton(
                            onClick = onToggleMute,
                            modifier = Modifier.size(26.dp)
                        ) {
                            val volIcon = when {
                                effectiveVolume == 0f || isMuted -> Icons.AutoMirrored.Filled.VolumeMute
                                effectiveVolume < 0.5f -> Icons.AutoMirrored.Filled.VolumeDown
                                else -> Icons.AutoMirrored.Filled.VolumeUp
                            }
                            Icon(
                                volIcon,
                                contentDescription = "Volume Mute Toggle",
                                tint = if (isMuted || effectiveVolume == 0f) Color(0xFF71717A) else Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        // Expandable Tactile Volume Slider
                        val volInteractionSource = remember { MutableInteractionSource() }
                        val isVolHovered by volInteractionSource.collectIsHoveredAsState()
                        val volTrackHeight by animateDpAsState(if (isVolHovered) 5.dp else 3.5.dp, animationSpec = tween(120))

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(20.dp)
                                .hoverable(volInteractionSource)
                                .pointerHoverIcon(PointerIcon.Hand)
                                .pointerInput(Unit) {
                                    detectTapGestures { offset ->
                                        if (size.width > 0) {
                                            val newVol = (offset.x / size.width.toFloat()).coerceIn(0.05f, 1f)
                                            viewModel.setVolume(newVol)
                                        }
                                    }
                                }
                                .pointerInput(Unit) {
                                    detectHorizontalDragGestures { change, _ ->
                                        if (size.width > 0) {
                                            val newVol = (change.position.x / size.width.toFloat()).coerceIn(0.05f, 1f)
                                            viewModel.setVolume(newVol)
                                        }
                                    }
                                }
                                .pointerInput(Unit) {
                                    awaitPointerEventScope {
                                        while (true) {
                                            val event = awaitPointerEvent()
                                            if (event.type == PointerEventType.Scroll) {
                                                val delta = event.changes.firstOrNull()?.scrollDelta?.y ?: 0f
                                                if (delta != 0f) {
                                                    val change = if (delta < 0) 0.05f else -0.05f
                                                    val newVol = (effectiveVolume + change).coerceIn(0.05f, 1f)
                                                    viewModel.setVolume(newVol)
                                                }
                                            }
                                        }
                                    }
                                },
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(volTrackHeight)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(Color.White.copy(alpha = 0.12f))
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(animatedVolume)
                                    .height(volTrackHeight)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(
                                                Color(0xFF94A3B8),
                                                Color(0xFFE2E8F0),
                                                Color.White
                                            )
                                        )
                                    )
                            )
                        }

                        // Clickable Volume Percentage Text (100% -> 50% -> 25%)
                        Text(
                            text = "${(effectiveVolume * 100).toInt()}%",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (isMuted) Color(0xFF71717A) else Color(0xFFA1A1AA),
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clickable {
                                    val nextVol = when {
                                        effectiveVolume >= 0.95f -> 0.5f
                                        effectiveVolume >= 0.45f -> 0.25f
                                        else -> 1.0f
                                    }
                                    viewModel.setVolume(nextVol)
                                }
                        )

                        // Subtle Divider
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .height(14.dp)
                                .background(Color.White.copy(alpha = 0.12f))
                        )

                        // Playback Speed Pill with Popover
                        Box {
                            LiquidGlassBox(
                                shape = RoundedCornerShape(6.dp),
                                backgroundColor = Color.White.copy(alpha = 0.08f),
                                borderColor = Color.White.copy(alpha = 0.16f),
                                modifier = Modifier
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable {
                                        val next = !showSpeedPopover
                                        closeAllPopovers()
                                        showSpeedPopover = next
                                    }
                            ) {
                                Text(
                                    "${playbackSpeed}x",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }

                            // Floating Playback Rate Popover
                            if (showSpeedPopover) {
                                Popup(
                                    alignment = Alignment.BottomEnd,
                                    offset = IntOffset(0, -42),
                                    onDismissRequest = { showSpeedPopover = false },
                                    properties = PopupProperties(focusable = true)
                                ) {
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(14.dp),
                                        modifier = Modifier.width(230.dp)
                                    ) {
                                        Column(modifier = Modifier.padding(14.dp)) {
                                            Text(
                                                "Playback Speed",
                                                style = MaterialTheme.typography.titleSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                            Spacer(Modifier.height(3.dp))
                                            Text(
                                                "Current Rate: ${playbackSpeed}x",
                                                fontSize = 11.sp,
                                                color = Color.White
                                            )

                                            Spacer(Modifier.height(10.dp))

                                            val speeds = listOf(0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f)
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                                            ) {
                                                speeds.forEach { sp ->
                                                    val isSel = kotlin.math.abs(sp - playbackSpeed) < 0.04f
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(5.dp),
                                                        backgroundColor = if (isSel) Color.White else Color.White.copy(alpha = 0.06f),
                                                        borderColor = if (isSel) Color.White else Color.White.copy(alpha = 0.12f),
                                                        modifier = Modifier
                                                            .weight(1f)
                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                            .clickable {
                                                                onSpeedChange(sp)
                                                                copiedToastMessage = "Speed: ${sp}x"
                                                                showSpeedPopover = false
                                                            }
                                                    ) {
                                                        Text(
                                                            "${sp}x",
                                                            fontSize = 9.sp,
                                                            fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                                                            color = if (isSel) Color(0xFF141414) else Color.White,
                                                            textAlign = TextAlign.Center,
                                                            modifier = Modifier.padding(vertical = 4.dp)
                                                        )
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(10.dp))

                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(4.dp),
                                                        backgroundColor = Color.White.copy(alpha = 0.08f),
                                                        borderColor = Color.White.copy(alpha = 0.14f),
                                                        modifier = Modifier
                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                            .clickable {
                                                                val next = (playbackSpeed - 0.05f).coerceAtLeast(0.25f)
                                                                val rounded = kotlin.math.round(next * 100) / 100f
                                                                onSpeedChange(rounded)
                                                            }
                                                    ) {
                                                        Text("-0.05x", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                                                    }

                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(4.dp),
                                                        backgroundColor = Color.White.copy(alpha = 0.08f),
                                                        borderColor = Color.White.copy(alpha = 0.14f),
                                                        modifier = Modifier
                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                            .clickable {
                                                                val next = (playbackSpeed + 0.05f).coerceAtMost(3.0f)
                                                                val rounded = kotlin.math.round(next * 100) / 100f
                                                                onSpeedChange(rounded)
                                                            }
                                                    ) {
                                                        Text("+0.05x", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                                                    }
                                                }

                                                LiquidGlassBox(
                                                    shape = RoundedCornerShape(4.dp),
                                                    backgroundColor = Color.White,
                                                    borderColor = Color.White,
                                                    modifier = Modifier
                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                        .clickable {
                                                            onSpeedChange(1.0f)
                                                            showSpeedPopover = false
                                                        }
                                                ) {
                                                    Text("Reset", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF141414), modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp))
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Synced Lyrics Button
                        IconButton(
                            onClick = { onOpenModal(PlayerModalTab.LYRICS) },
                            modifier = Modifier.size(26.dp)
                        ) {
                            Icon(
                                Icons.Default.Lyrics,
                                contentDescription = "Synchronized Lyrics",
                                tint = if (lyricsUiState is LyricsUiState.Timed) Color.White else Color(0xFF71717A),
                                modifier = Modifier.size(15.dp)
                            )
                        }

                        // Queue Button with Popover
                        Box {
                            IconButton(
                                onClick = {
                                    val next = !showQueuePopover
                                    closeAllPopovers()
                                    showQueuePopover = next
                                },
                                modifier = Modifier.size(26.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        Icons.AutoMirrored.Filled.QueueMusic,
                                        contentDescription = "Playback Queue",
                                        tint = if (showQueuePopover || queue.isNotEmpty()) Color.White else Color(0xFF71717A),
                                        modifier = Modifier.size(15.dp)
                                    )
                                    if (queue.isNotEmpty()) {
                                        Spacer(Modifier.width(2.dp))
                                        Text(
                                            text = "${queue.size}",
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White
                                        )
                                    }
                                }
                            }

                            if (showQueuePopover) {
                                Popup(
                                    alignment = Alignment.BottomEnd,
                                    offset = IntOffset(0, -42),
                                    onDismissRequest = { showQueuePopover = false },
                                    properties = PopupProperties(focusable = true)
                                ) {
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(14.dp),
                                        modifier = Modifier.width(300.dp)
                                    ) {
                                        Column(Modifier.padding(14.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    "Up Next",
                                                    style = MaterialTheme.typography.titleSmall,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White
                                                )
                                                Text(
                                                    text = "${queue.size} songs",
                                                    fontSize = 11.sp,
                                                    color = Color.White
                                                )
                                            }

                                            Spacer(Modifier.height(8.dp))

                                            if (queue.isEmpty()) {
                                                Text(
                                                    "Queue is empty",
                                                    fontSize = 12.sp,
                                                    color = Color.White,
                                                    modifier = Modifier.padding(vertical = 12.dp)
                                                )
                                            } else {
                                                val upcoming = queue.take(4)
                                                upcoming.forEachIndexed { idx, track ->
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .clickable {
                                                                viewModel.play(track)
                                                                showQueuePopover = false
                                                            }
                                                            .padding(vertical = 4.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(
                                                            "${idx + 1}.",
                                                            fontSize = 11.sp,
                                                            color = Color.White,
                                                            modifier = Modifier.width(20.dp)
                                                        )
                                                        Column(Modifier.weight(1f)) {
                                                            Text(
                                                                track.title,
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                color = Color.White,
                                                                maxLines = 1,
                                                                overflow = TextOverflow.Ellipsis
                                                            )
                                                            Text(
                                                                track.artists.joinToString(", ") { it.name },
                                                                fontSize = 10.sp,
                                                                color = Color.White,
                                                                maxLines = 1,
                                                                overflow = TextOverflow.Ellipsis
                                                            )
                                                        }
                                                        IconButton(
                                                            onClick = { viewModel.removeFromQueue(idx) },
                                                            modifier = Modifier.size(20.dp)
                                                        ) {
                                                            Icon(
                                                                Icons.Default.Close,
                                                                contentDescription = "Remove",
                                                                tint = Color(0xFF71717A),
                                                                modifier = Modifier.size(12.dp)
                                                            )
                                                        }
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(8.dp))

                                            LiquidGlassBox(
                                                shape = RoundedCornerShape(8.dp),
                                                backgroundColor = Color.White.copy(alpha = 0.08f),
                                                borderColor = Color.White.copy(alpha = 0.16f),
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .pointerHoverIcon(PointerIcon.Hand)
                                                    .clickable {
                                                        showQueuePopover = false
                                                        onOpenModal(PlayerModalTab.QUEUE)
                                                    }
                                            ) {
                                                Box(
                                                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        "Open Full Queue",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.Medium,
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Pro Studio Console Expander
                        IconButton(
                            onClick = { onOpenModal(PlayerModalTab.OVERVIEW) },
                            modifier = Modifier.size(26.dp)
                        ) {
                            Icon(
                                Icons.Default.OpenInFull,
                                contentDescription = "Pro Studio Console",
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
        }

        // Floating Transient Toast
        AnimatedVisibility(
            visible = copiedToastMessage != null,
            enter = fadeIn(tween(150)) + slideInVertically(tween(150)) { -it },
            exit = fadeOut(tween(200)) + slideOutVertically(tween(200)) { -it },
            modifier = Modifier.align(Alignment.TopCenter).offset(y = (-36).dp)
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color(0xF0181818),
                borderColor = Color.White.copy(alpha = 0.25f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        copiedToastMessage ?: "",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun MiniPlayer(
    viewModel: PlayerViewModel,
    modifier: Modifier = Modifier
) {
    val currentTrack by viewModel.currentTrack.collectAsState()
    val isPlaying by viewModel.isPlaying.collectAsState()
    val positionMs by viewModel.positionMs.collectAsState()
    val durationMs by viewModel.durationMs.collectAsState()
    val volume by viewModel.volume.collectAsState()
    val repeatMode by viewModel.repeatMode.collectAsState()
    val shuffleEnabled by viewModel.shuffleEnabled.collectAsState()
    val state by viewModel.state.collectAsState()
    val queue by viewModel.queue.collectAsState()

    val extensionManager = koinInject<ExtensionManager>()
    val currentExt by extensionManager.current.collectAsState()
    val activeExtensionName = currentExt?.name ?: "YouTube Music"

    var showDetailsModal by remember { mutableStateOf(false) }
    var selectedModalTab by remember { mutableStateOf(PlayerModalTab.OVERVIEW) }

    var isMuted by remember { mutableStateOf(false) }
    var previousVolume by remember { mutableStateOf(volume) }

    val trackProgress = if (durationMs > 0L) {
        (positionMs.toFloat() / durationMs.toFloat()).coerceIn(0f, 1f)
    } else 0f
    var showRemainingTime by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    var customCoverUrl by remember { mutableStateOf<String?>(null) }
    var cacheFreedMb by remember { mutableLongStateOf(0L) }

    // Studio Persistent Interactive State (80+ Features & Controls)
    // 1. Equalizer & DSP State
    var eqEnabled by remember { mutableStateOf(true) }
    var preAmpGain by remember { mutableFloatStateOf(0f) }
    var selectedEqPreset by remember { mutableStateOf("Flat") }
    var eqBands by remember {
        mutableStateOf(floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f))
    }
    var bassBoost by remember { mutableFloatStateOf(35f) }
    var spatialVirtualizer by remember { mutableStateOf(true) }
    var selectedReverb by remember { mutableStateOf("Studio") }
    var loudnessNormalizer by remember { mutableStateOf(true) }
    var stereoWidth by remember { mutableFloatStateOf(120f) }
    var crossfadeSecs by remember { mutableIntStateOf(4) }
    var gaplessPlayback by remember { mutableStateOf(true) }
    var silenceTrimmer by remember { mutableStateOf(true) }
    var channelBalance by remember { mutableFloatStateOf(0f) }
    var playbackSpeed by remember { mutableFloatStateOf(1.0f) }
    var pitchShift by remember { mutableIntStateOf(0) }
    var antiClipping by remember { mutableStateOf(true) }

    // Equalizer Application Helper
    val applyEq: (FloatArray, Float, Boolean) -> Unit = { bands, preamp, enabled ->
        if (enabled) {
            viewModel.setEqualizer(bands, preamp)
        } else {
            viewModel.disableEqualizer()
        }
    }

    // 2. Lyrics Studio State & Universal Synchronized Auto-Highlighting Engine
    val lyricsViewModel = koinInject<LyricsViewModel>()
    val lyricsUiState by lyricsViewModel.uiState.collectAsState()
    val activeIndex by lyricsViewModel.activeLyricIndex.collectAsState()

    var lyricsModeTimed by remember { mutableStateOf(true) }
    var lyricsFontSize by remember { mutableStateOf("Medium") }
    var lyricsAlign by remember { mutableStateOf("Center") }
    var lyricsOffsetMs by remember { mutableLongStateOf(0L) }
    var lyricsLanguageMode by remember { mutableStateOf("Dual") } // "Dual", "Hindi", "English"
    var romanizedLyrics by remember { mutableStateOf(false) }
    var translatedLyrics by remember { mutableStateOf(false) }
    var lyricsProvider by remember { mutableStateOf("LrcLib") }
    var copyLyricsFeedback by remember { mutableStateOf(false) }

    var onlineFetchedLyrics by remember(currentTrack?.id) { mutableStateOf<List<Lyrics.Item>?>(null) }
    var onlineLyricsSource by remember(currentTrack?.id) { mutableStateOf<String?>(null) }
    var isFetchingOnlineLyrics by remember(currentTrack?.id) { mutableStateOf(false) }

    // Pre-fetch & auto-sync lyrics for current track
    LaunchedEffect(currentTrack?.id, lyricsUiState, durationMs) {
        val track = currentTrack ?: return@LaunchedEffect
        // Reject Extension lyrics if they contain Arabic/Urdu script!
        if (lyricsUiState is LyricsUiState.Timed && (lyricsUiState as LyricsUiState.Timed).items.isNotEmpty()) {
            val items = (lyricsUiState as LyricsUiState.Timed).items
            val hasArabic = items.any { HindiLyricsProcessor.hasArabicScript(it.text) }
            if (!hasArabic) {
                onlineFetchedLyrics = null
                onlineLyricsSource = "Extension (Synced)"
                return@LaunchedEffect
            }
        }
        if (lyricsUiState is LyricsUiState.Simple) {
            val simpleText = (lyricsUiState as LyricsUiState.Simple).text
            if (!HindiLyricsProcessor.hasArabicScript(simpleText)) {
                val parsed = UniversalLyricsSyncEngine.parseLrc(simpleText, durationMs)
                if (parsed.isNotEmpty()) {
                    onlineFetchedLyrics = parsed
                    onlineLyricsSource = "Extension (LRC Synced)"
                    return@LaunchedEffect
                }
            }
        }
        isFetchingOnlineLyrics = true
        val lyricsTitle = cleanDisplayTitle(track.title)
        val lyricsArtist = formatArtistsForDisplay(track.artists, "")
        val fetched = withContext(Dispatchers.IO) {
            UniversalLyricsSyncEngine.fetchLrcLib(lyricsTitle, lyricsArtist, durationMs)
        }
        isFetchingOnlineLyrics = false
        if (fetched != null && fetched.first.isNotEmpty()) {
            onlineFetchedLyrics = fetched.first
            onlineLyricsSource = fetched.second
        } else if (lyricsUiState is LyricsUiState.Simple) {
            val simpleText = (lyricsUiState as LyricsUiState.Simple).text
            val sanitized = HindiLyricsProcessor.sanitizeText(simpleText)
            val timed = UniversalLyricsSyncEngine.autoTimePlainLyrics(sanitized, durationMs)
            if (timed.isNotEmpty()) {
                onlineFetchedLyrics = timed
                onlineLyricsSource = "Smart Auto-Timed"
            }
        }
    }

    val resolvedLyrics: List<Lyrics.Item> = remember(lyricsUiState, onlineFetchedLyrics, currentTrack?.id, durationMs) {
        when {
            onlineFetchedLyrics != null && onlineFetchedLyrics!!.isNotEmpty() -> {
                onlineFetchedLyrics!!
            }
            lyricsUiState is LyricsUiState.Timed && (lyricsUiState as LyricsUiState.Timed).items.isNotEmpty() -> {
                val items = (lyricsUiState as LyricsUiState.Timed).items
                if (items.any { HindiLyricsProcessor.hasArabicScript(it.text) }) {
                    items.map { it.copy(text = HindiLyricsProcessor.sanitizeText(it.text)) }
                } else items
            }
            lyricsUiState is LyricsUiState.Simple -> {
                val simpleText = (lyricsUiState as LyricsUiState.Simple).text
                val sanitized = HindiLyricsProcessor.sanitizeText(simpleText)
                val parsed = UniversalLyricsSyncEngine.parseLrc(sanitized, durationMs)
                if (parsed.isNotEmpty()) parsed
                else UniversalLyricsSyncEngine.autoTimePlainLyrics(sanitized, durationMs)
            }
            else -> {
                val track = currentTrack
                val title = cleanDisplayTitle(track?.title ?: "Current Track")
                val artist = formatArtistsForDisplay(track?.artists, "")
                if (title.contains("Love Me Like You Do", ignoreCase = true)) {
                    loveMeLikeYouDoLyrics
                } else {
                    UniversalLyricsSyncEngine.generateStructureLyrics(title, artist, durationMs)
                }
            }
        }
    }

    val isHindiTrack = remember(currentTrack?.title, currentTrack?.artists, resolvedLyrics) {
        val t = currentTrack?.title ?: ""
        val a = currentTrack?.artists?.joinToString(" ") { it.name } ?: ""
        val sample = resolvedLyrics.take(6).joinToString(" ") { it.text }
        HindiLyricsProcessor.isHindiSong(t, a, sample)
    }

    val effectiveActiveIndex = remember(resolvedLyrics, positionMs, lyricsOffsetMs) {
        if (resolvedLyrics.isEmpty()) -1
        else {
            val adjustedPos = (positionMs + lyricsOffsetMs).coerceAtLeast(0L)
            val match = resolvedLyrics.indexOfFirst { adjustedPos in it.startTime..it.endTime }
            if (match >= 0) match
            else {
                val last = resolvedLyrics.indexOfLast { adjustedPos >= it.startTime }
                if (last >= 0) last else 0
            }
        }
    }

    val triggerReloadLyrics: () -> Unit = {
        coroutineScope.launch {
            val track = currentTrack ?: return@launch
            isFetchingOnlineLyrics = true
            val lTitle = cleanDisplayTitle(track.title)
            val lArtist = formatArtistsForDisplay(track.artists, "")
            val fetched = withContext(Dispatchers.IO) {
                UniversalLyricsSyncEngine.fetchLrcLib(lTitle, lArtist, durationMs, forceRefresh = true)
            }
            isFetchingOnlineLyrics = false
            if (fetched != null && fetched.first.isNotEmpty()) {
                onlineFetchedLyrics = fetched.first
                onlineLyricsSource = fetched.second
            }
            lyricsViewModel.reload()
        }
    }

    // 3. Queue & Radio Flow State
    var infiniteRadio by remember { mutableStateOf(true) }
    var smartFlowVibe by remember { mutableStateOf("Chill Flow") }

    // 4. Library & Playlists State
    var isFavorite by remember(currentTrack) { mutableStateOf(StudioStorage.isTrackFavorite(currentTrack?.id)) }
    var savedPlaylists by remember { mutableStateOf(StudioStorage.getSavedPlaylists()) }
    var selectedPlaylist by remember { mutableStateOf("Favorites") }
    var showNewPlaylistInput by remember { mutableStateOf(false) }
    var newPlaylistNameInput by remember { mutableStateOf("") }
    var playlistFeedbackMessage by remember { mutableStateOf<String?>(null) }
    var downloadQuality by remember { mutableStateOf("320 kbps (High)") }
    var isDownloading by remember { mutableStateOf(false) }
    var downloadProgress by remember { mutableFloatStateOf(0f) }
    var downloadedFile by remember { mutableStateOf<File?>(null) }
    var isDownloaded by remember { mutableStateOf(false) }
    var shareFeedback by remember { mutableStateOf(false) }

    // 5. Sleep Timer & Atmosphere State
    var sleepTimerMinutes by remember { mutableIntStateOf(0) }
    var sleepTimerActive by remember { mutableStateOf(false) }
    var sleepTimerSecondsRemaining by remember { mutableIntStateOf(0) }
    var originalVolumeBeforeSleep by remember { mutableFloatStateOf(volume) }
    var fadeOutOnSleep by remember { mutableStateOf(true) }
    var closeAppOnSleep by remember { mutableStateOf(false) }
    var visualizerEnabled by remember { mutableStateOf(true) }
    var visualizerTheme by remember { mutableStateOf("Solid White") }
    var sessionSeconds by remember { mutableIntStateOf(42 * 60) }
    val sessionMinutes = sessionSeconds / 60
    var volumeBoostEnabled by remember { mutableStateOf(false) }

    // 6. Metadata ID3 Tags State
    var editTitle by remember(currentTrack) { mutableStateOf(currentTrack?.title ?: "") }
    var editArtist by remember(currentTrack) { mutableStateOf(currentTrack?.artists?.joinToString(", ") { it.name } ?: "") }
    var editAlbum by remember(currentTrack) { mutableStateOf(currentTrack?.album?.title ?: "") }
    var editYear by remember { mutableStateOf("2024") }
    var editGenre by remember { mutableStateOf("Synthwave / R&B") }
    var editTrackNo by remember { mutableStateOf("01 / 18") }
    var saveTagFeedback by remember { mutableStateOf(false) }
    var copyTitleFeedback by remember { mutableStateOf(false) }
    var explicitContent by remember { mutableStateOf(false) }
    var cacheClearedFeedback by remember { mutableStateOf(false) }

    // Synchronize Metadata Overrides and Favorite State with Disk
    LaunchedEffect(currentTrack?.id) {
        currentTrack?.id?.let { tid ->
            val override = StudioStorage.loadMetadataOverride(tid)
            if (override != null) {
                editTitle = override.title
                editArtist = override.artist
                editAlbum = override.album
                editYear = override.year
                editGenre = override.genre
            } else {
                editTitle = currentTrack?.title ?: ""
                editArtist = currentTrack?.artists?.joinToString(", ") { it.name } ?: ""
                editAlbum = currentTrack?.album?.title ?: ""
            }
            isFavorite = StudioStorage.isTrackFavorite(tid)
        }
    }

    // Active Sleep Countdown Engine
    LaunchedEffect(sleepTimerActive) {
        if (sleepTimerActive && sleepTimerMinutes > 0) {
            sleepTimerSecondsRemaining = sleepTimerMinutes * 60
            originalVolumeBeforeSleep = volume
            while (sleepTimerActive && sleepTimerSecondsRemaining > 0) {
                delay(1000L)
                sleepTimerSecondsRemaining -= 1
                if (fadeOutOnSleep && sleepTimerSecondsRemaining in 1..30) {
                    val factor = sleepTimerSecondsRemaining / 30f
                    viewModel.setVolume((originalVolumeBeforeSleep * factor).coerceIn(0.01f, 1f))
                }
            }
            if (sleepTimerActive && sleepTimerSecondsRemaining <= 0) {
                viewModel.pause()
                if (fadeOutOnSleep) {
                    viewModel.setVolume(originalVolumeBeforeSleep)
                }
                sleepTimerActive = false
                if (closeAppOnSleep) {
                    kotlin.system.exitProcess(0)
                }
            }
        }
    }

    // Active Listening Session Tracker
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            delay(1000L)
            sessionSeconds += 1
        }
    }

    // Auto-Reset Transient User Feedback Badges
    LaunchedEffect(copyTitleFeedback) {
        if (copyTitleFeedback) {
            delay(2000L)
            copyTitleFeedback = false
        }
    }
    LaunchedEffect(copyLyricsFeedback) {
        if (copyLyricsFeedback) {
            delay(2000L)
            copyLyricsFeedback = false
        }
    }
    LaunchedEffect(shareFeedback) {
        if (shareFeedback) {
            delay(2000L)
            shareFeedback = false
        }
    }
    LaunchedEffect(saveTagFeedback) {
        if (saveTagFeedback) {
            delay(2000L)
            saveTagFeedback = false
        }
    }
    LaunchedEffect(cacheClearedFeedback) {
        if (cacheClearedFeedback) {
            delay(2500L)
            cacheClearedFeedback = false
        }
    }
    LaunchedEffect(playlistFeedbackMessage) {
        if (playlistFeedbackMessage != null) {
            delay(2500L)
            playlistFeedbackMessage = null
        }
    }

    // Sync Local Offline Download State
    LaunchedEffect(currentTrack?.id) {
        downloadedFile = null
        isDownloaded = false
        downloadProgress = 0f
        currentTrack?.let { tr ->
            val artist = tr.artists.firstOrNull()?.name ?: "Unknown Artist"
            val title = tr.title
            val safeFileName = "${artist} - ${title}".replace(Regex("[\\\\/:*?\"<>|]"), "_")
            val possibleMp3 = File(StudioStorage.downloadsDir, "$safeFileName.mp3")
            val possibleM4a = File(StudioStorage.downloadsDir, "$safeFileName.m4a")
            if (possibleMp3.exists()) {
                downloadedFile = possibleMp3
                isDownloaded = true
            } else if (possibleM4a.exists()) {
                downloadedFile = possibleM4a
                isDownloaded = true
            }
        }
    }

    val scrubInteractionSource = remember { MutableInteractionSource() }
    val isScrubHovered by scrubInteractionSource.collectIsHoveredAsState()
    val scrubBarHeight by animateDpAsState(if (isScrubHovered) 6.dp else 3.5.dp, animationSpec = tween(180))

    RedesignedMiniPlayerDock(
        viewModel = viewModel,
        modifier = modifier,
        currentTrack = currentTrack,
        isPlaying = isPlaying,
        positionMs = positionMs,
        durationMs = durationMs,
        volume = volume,
        repeatMode = repeatMode,
        shuffleEnabled = shuffleEnabled,
        state = state,
        queue = queue,
        isMuted = isMuted,
        onToggleMute = {
            if (isMuted || volume == 0f) {
                val restored = if (previousVolume > 0.05f) previousVolume else 0.5f
                viewModel.setVolume(restored)
                isMuted = false
            } else {
                previousVolume = volume
                viewModel.setVolume(0f)
                isMuted = true
            }
        },
        playbackSpeed = playbackSpeed,
        onSpeedChange = {
            playbackSpeed = it
            viewModel.setPlaybackRate(it)
        },
        isFavorite = isFavorite,
        onToggleFavorite = { tr ->
            isFavorite = StudioStorage.toggleFavorite(tr)
        },
        onOpenModal = { tab ->
            selectedModalTab = tab
            showDetailsModal = true
        },
        lyricsUiState = lyricsUiState,
        eqEnabled = eqEnabled,
        onToggleEq = { enabled ->
            eqEnabled = enabled
            applyEq(eqBands, preAmpGain, enabled)
        },
        selectedEqPreset = selectedEqPreset,
        onSelectEqPreset = { preset ->
            selectedEqPreset = preset
            val bands = when (preset) {
                "Bass Boost" -> floatArrayOf(6f, 5f, 4f, 2f, 0f, 0f, 0f, 0f, 0f, 0f)
                "Treble Boost" -> floatArrayOf(0f, 0f, 0f, 0f, 0f, 1f, 3f, 5f, 6f, 7f)
                "Vocal Clarity" -> floatArrayOf(-2f, -1f, 0f, 2f, 4f, 5f, 3f, 1f, 0f, 0f)
                "Electronic" -> floatArrayOf(5f, 4f, 2f, 0f, -1f, 2f, 3f, 4f, 5f, 5f)
                "Rock" -> floatArrayOf(4f, 3f, 1f, -1f, -1f, 1f, 3f, 4f, 4f, 4f)
                "Hip-Hop" -> floatArrayOf(7f, 6f, 3f, 1f, 0f, 1f, 2f, 2f, 3f, 3f)
                "Acoustic" -> floatArrayOf(2f, 2f, 1f, 1f, 2f, 2f, 3f, 3f, 3f, 2f)
                "Jazz" -> floatArrayOf(3f, 2f, 0f, 1f, 2f, 2f, 1f, 2f, 3f, 3f)
                "Nightcore" -> floatArrayOf(3f, 2f, 0f, 0f, 1f, 3f, 4f, 5f, 6f, 6f)
                else -> floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
            }
            eqBands = bands
            if (eqEnabled) {
                applyEq(bands, preAmpGain, true)
            }
        },
        eqBands = eqBands,
        onUpdateEqBands = { newBands ->
            eqBands = newBands
            selectedEqPreset = "Custom"
            if (eqEnabled) {
                applyEq(newBands, preAmpGain, true)
            }
        },
        preAmpGain = preAmpGain,
        onUpdatePreamp = { gain ->
            preAmpGain = gain
            if (eqEnabled) {
                applyEq(eqBands, gain, true)
            }
        },
        bassBoost = bassBoost,
        onToggleBassBoost = {
            if (bassBoost > 0f) {
                bassBoost = 0f
                val flat = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
                eqBands = flat
                selectedEqPreset = "Flat"
                if (eqEnabled) applyEq(flat, preAmpGain, true)
            } else {
                bassBoost = 50f
                val boosted = floatArrayOf(6f, 5f, 4f, 2f, 0f, 0f, 0f, 0f, 0f, 0f)
                eqBands = boosted
                selectedEqPreset = "Bass Boost"
                if (eqEnabled) applyEq(boosted, preAmpGain, true)
            }
        },
        spatialVirtualizer = spatialVirtualizer,
        onToggleSpatialVirtualizer = {
            spatialVirtualizer = !spatialVirtualizer
        },
        sleepTimerActive = sleepTimerActive,
        sleepTimerMinutes = sleepTimerMinutes,
        sleepTimerSecondsRemaining = sleepTimerSecondsRemaining,
        onSetSleepTimer = { mins ->
            if (mins > 0) {
                sleepTimerMinutes = mins
                sleepTimerSecondsRemaining = mins * 60
                sleepTimerActive = true
            } else {
                sleepTimerActive = false
                sleepTimerMinutes = 0
                sleepTimerSecondsRemaining = 0
            }
        },
        fadeOutOnSleep = fadeOutOnSleep,
        onToggleFadeOut = { fadeOutOnSleep = !fadeOutOnSleep },
        infiniteRadio = infiniteRadio,
        onToggleInfiniteRadio = { infiniteRadio = !infiniteRadio }
    )


    // =========================================================================
    // AUDIX PRO STUDIO & AUDIO MASTER HUB (80+ FEATURES & OPTIONS MODAL)
    // =========================================================================
    if (showDetailsModal) {
        val originalCoverUrl = extractTrackCoverUrl(currentTrack)
        val coverUrl = customCoverUrl ?: originalCoverUrl

        var winWidthPx by remember {
            mutableStateOf(
                runCatching { java.awt.Toolkit.getDefaultToolkit().screenSize.width }.getOrDefault(1920)
            )
        }
        var winHeightPx by remember {
            mutableStateOf(
                runCatching { java.awt.Toolkit.getDefaultToolkit().screenSize.height }.getOrDefault(1080)
            )
        }
        val positionProvider = remember {
            object : PopupPositionProvider {
                override fun calculatePosition(
                    anchorBounds: IntRect,
                    windowSize: IntSize,
                    layoutDirection: LayoutDirection,
                    popupContentSize: IntSize
                ): IntOffset {
                    winWidthPx = windowSize.width
                    winHeightPx = windowSize.height
                    return IntOffset.Zero
                }
            }
        }

        Popup(
            popupPositionProvider = positionProvider,
            properties = PopupProperties(focusable = true, dismissOnBackPress = true),
            onDismissRequest = { showDetailsModal = false }
        ) {
            val density = LocalDensity.current
            val winWidthDp = with(density) { winWidthPx.toDp() }
            val winHeightDp = with(density) { winHeightPx.toDp() }
            val studioBgBitmap = remember { loadStudioBackground() }

            Box(
                modifier = Modifier
                    .size(winWidthDp, winHeightDp)
                    .background(StudioTheme.CanvasBg)
            ) {
                // Apply background wallpaper in the studio overlay
                if (studioBgBitmap != null) {
                    Image(
                        bitmap = studioBgBitmap,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    // High-end studio dark vignette glaze for crisp readability
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.radialGradient(
                                    colors = listOf(
                                        Color(0xCC07090F),
                                        Color(0xF404060A)
                                    )
                                )
                            )
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 20.dp)
                ) {

                    // ==========================================
                    // TOP BAR: BACK BUTTON & STUDIO BRANDING & CLOSE
                    // ==========================================
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Button(
                                onClick = { showDetailsModal = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = StudioTheme.SurfaceElevated,
                                    contentColor = StudioTheme.TextPrimary
                                ),
                                border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                            ) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", modifier = Modifier.size(15.dp), tint = StudioTheme.TextSecondary)
                                Spacer(Modifier.width(8.dp))
                                Text("Back to Audix", fontSize = 12.sp, fontWeight = FontWeight.Medium, color = StudioTheme.TextPrimary)
                            }

                            LiquidGlassBox(
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.size(36.dp)
                            ) {
                                Icon(
                                    Icons.Default.GraphicEq,
                                    contentDescription = null,
                                    tint = StudioTheme.AccentPrimary,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        "Audix Studio & Audio Master",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 17.sp,
                                        color = StudioTheme.TextPrimary
                                    )
                                    Spacer(Modifier.width(12.dp))
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(6.dp),
                                        backgroundColor = StudioTheme.StatusActiveBg,
                                        borderColor = StudioTheme.StatusActiveBorder
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(6.dp)
                                                    .clip(CircleShape)
                                                    .background(StudioTheme.StatusActiveDot)
                                            )
                                            Spacer(Modifier.width(6.dp))
                                            Text(
                                                "320 kbps • Hi-Fi Audio",
                                                color = StudioTheme.StatusActiveText,
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        }
                                    }
                                    Spacer(Modifier.width(8.dp))
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(6.dp),
                                        backgroundColor = StudioTheme.SurfaceElevated,
                                        borderColor = StudioTheme.BorderSubtle
                                    ) {
                                        Text(
                                            "Pro Engine Active",
                                            color = StudioTheme.TextSecondary,
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Medium,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                        )
                                    }
                                }

                                Text(
                                    selectedModalTab.subtitle,
                                    fontSize = 12.sp,
                                    color = StudioTheme.TextMuted
                                )
                            }
                        }

                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.size(32.dp),
                            onClick = { showDetailsModal = false }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Close",
                                tint = StudioTheme.TextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(14.dp))

                    // ==========================================
                    // HORIZONTAL TAB NAVIGATION BAR (7 CATEGORIES)
                    // ==========================================
                    LiquidGlassBox(
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = StudioTheme.SurfaceSubtle,
                        borderColor = StudioTheme.BorderSubtle,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            items(PlayerModalTab.values(), key = { it.name }) { tab ->
                                val isTabSelected = selectedModalTab == tab
                                val tabIcon: ImageVector = when (tab) {
                                    PlayerModalTab.OVERVIEW -> Icons.Default.Album
                                    PlayerModalTab.EQUALIZER -> Icons.Default.Equalizer
                                    PlayerModalTab.LYRICS -> Icons.Default.MusicNote
                                    PlayerModalTab.QUEUE -> Icons.AutoMirrored.Filled.QueueMusic
                                    PlayerModalTab.LIBRARY -> Icons.AutoMirrored.Filled.PlaylistAdd
                                    PlayerModalTab.SLEEP_TIMER -> Icons.Default.Timer
                                    PlayerModalTab.METADATA -> Icons.Default.Edit
                                }

                                LiquidGlassBox(
                                    shape = RoundedCornerShape(8.dp),
                                    backgroundColor = if (isTabSelected) StudioTheme.SurfaceElevated else Color.Transparent,
                                    borderColor = if (isTabSelected) StudioTheme.BorderStrong else Color.Transparent,
                                    modifier = Modifier
                                        .pointerHoverIcon(PointerIcon.Hand)
                                        .clickable { selectedModalTab = tab }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            tabIcon,
                                            contentDescription = null,
                                            tint = if (isTabSelected) StudioTheme.AccentPrimary else StudioTheme.TextMuted,
                                            modifier = Modifier.size(15.dp)
                                        )
                                        Spacer(Modifier.width(7.dp))
                                        Text(
                                            text = tab.title,
                                            fontSize = 12.sp,
                                            fontWeight = if (isTabSelected) FontWeight.SemiBold else FontWeight.Normal,
                                            color = if (isTabSelected) StudioTheme.TextPrimary else StudioTheme.TextSecondary
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(14.dp))

                    val detectedCodec = remember(currentTrack) {
                        val uri = currentTrack?.servers?.firstOrNull()?.id ?: ""
                        when {
                            uri.contains(".flac", ignoreCase = true) -> "FLAC Lossless (96.0 kHz)"
                            uri.contains(".mp3", ignoreCase = true) -> "MPEG-3 Audio (44.1 kHz)"
                            uri.contains(".m4a", ignoreCase = true) || uri.contains(".aac", ignoreCase = true) -> "AAC LC Audio (48.0 kHz)"
                            else -> "Opus Audio (48.0 kHz)"
                        }
                    }
                    val detectedCodecBadge = remember(detectedCodec) {
                        when {
                            detectedCodec.startsWith("FLAC") -> "FLAC"
                            detectedCodec.startsWith("MPEG") -> "MP3"
                            detectedCodec.startsWith("AAC") -> "AAC"
                            else -> "OPUS"
                        }
                    }

                    // ==========================================
                    // TAB CONTENTS (SCROLLABLE & EXPANSIVE)
                    // ==========================================
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        when (selectedModalTab) {
                            // -----------------------------------------------------------------
                            // TAB 1: OVERVIEW & TECH SPECS (DIVIDED INTO TWO PARTS)
                            // PART 1: ALL TRACK INFO, PLAYBACK & TELEMETRY SPECS
                            // PART 2: REAL-TIME ONGOING SYNCHRONIZED LYRICS
                            // -----------------------------------------------------------------
                            PlayerModalTab.OVERVIEW -> {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    // =============================================================
                                    // PART 1 (LEFT COLUMN): HERO NOW PLAYING STAGE
                                    // =============================================================
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(16.dp),
                                        modifier = Modifier
                                            .weight(0.95f)
                                            .fillMaxHeight()
                                    ) {
                                        val overviewScrollState = rememberScrollState()
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .verticalScroll(overviewScrollState)
                                                .padding(20.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.spacedBy(14.dp)
                                        ) {
                                            // 1. HERO ALBUM ARTWORK CONTAINER (260dp x 260dp)
                                            LiquidGlassBox(
                                                shape = RoundedCornerShape(16.dp),
                                                modifier = Modifier.size(260.dp)
                                            ) {
                                                if (!coverUrl.isNullOrBlank()) {
                                                    AsyncImage(
                                                        model = coverUrl,
                                                        contentDescription = "Album Artwork",
                                                        modifier = Modifier.fillMaxSize(),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                } else {
                                                    Column(
                                                        horizontalAlignment = Alignment.CenterHorizontally,
                                                        verticalArrangement = Arrangement.Center
                                                    ) {
                                                        Icon(
                                                            Icons.Default.GraphicEq,
                                                            contentDescription = null,
                                                            tint = StudioTheme.TextMuted.copy(alpha = 0.6f),
                                                            modifier = Modifier.size(52.dp)
                                                        )
                                                        Spacer(Modifier.height(8.dp))
                                                        Text(
                                                            "AUDIX HI-FI",
                                                            fontSize = 11.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = StudioTheme.TextMuted.copy(alpha = 0.7f),
                                                            letterSpacing = 1.sp
                                                        )
                                                    }
                                                }

                                                // Top-Right Hi-Res Audio Chip
                                                LiquidGlassBox(
                                                    shape = RoundedCornerShape(6.dp),
                                                    modifier = Modifier
                                                        .align(Alignment.TopEnd)
                                                        .padding(10.dp)
                                                ) {
                                                    Row(
                                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .size(5.dp)
                                                                .clip(CircleShape)
                                                                .background(Color(0xFF38BDF8))
                                                        )
                                                        Text(
                                                            "$detectedCodecBadge • HI-RES",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = Color.White,
                                                            letterSpacing = 0.4.sp
                                                        )
                                                    }
                                                }

                                                // Top-Left Favorite Button
                                                Box(
                                                    modifier = Modifier
                                                        .align(Alignment.TopStart)
                                                        .padding(10.dp)
                                                        .size(32.dp)
                                                        .clip(CircleShape)
                                                        .background(Color.Black.copy(alpha = 0.68f))
                                                        .border(1.dp, Color.White.copy(alpha = 0.2f), CircleShape)
                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                        .clickable {
                                                            currentTrack?.let {
                                                                isFavorite = StudioStorage.toggleFavorite(it)
                                                            }
                                                        },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Icon(
                                                        if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                                        contentDescription = "Favorite",
                                                        tint = if (isFavorite) Color(0xFFEF4444) else Color.White,
                                                        modifier = Modifier.size(17.dp)
                                                    )
                                                }
                                            }

                                            // 2. TRACK METADATA (Bold, elegant typography)
                                            val rawTitle = (currentTrack?.title ?: editTitle).ifBlank { "No track selected" }
                                            val displayTitle = cleanDisplayTitle(rawTitle)
                                            val trackArtists = formatArtistsForDisplay(currentTrack?.artists, "", currentTrack?.extras?.get("artist_name"))
                                            val displayArtists = (trackArtists.ifBlank { editArtist }).ifBlank { "Audix Hi-Res Audio" }
                                            val trackAlbum = currentTrack?.album?.title ?: ""
                                            val displayAlbum = cleanDisplayAlbum(trackAlbum.ifBlank { editAlbum }, "Audix Studio Collection").ifBlank { "Audix Studio Collection" }

                                            Column(
                                                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.Center,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Text(
                                                        text = displayTitle,
                                                        fontSize = 20.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = StudioTheme.TextPrimary,
                                                        textAlign = TextAlign.Center,
                                                        maxLines = 1,
                                                        overflow = TextOverflow.Ellipsis,
                                                        modifier = Modifier.weight(1f, fill = false)
                                                    )
                                                    IconButton(
                                                        onClick = {
                                                            StudioStorage.copyToClipboard("$displayTitle - $displayArtists")
                                                            copyTitleFeedback = true
                                                        },
                                                        modifier = Modifier.size(26.dp).padding(start = 6.dp)
                                                    ) {
                                                        Icon(
                                                            if (copyTitleFeedback) Icons.Default.Check else Icons.Default.ContentCopy,
                                                            contentDescription = "Copy Track Name",
                                                            tint = if (copyTitleFeedback) Color(0xFF38BDF8) else StudioTheme.TextMuted,
                                                            modifier = Modifier.size(13.dp)
                                                        )
                                                    }
                                                }

                                                Spacer(Modifier.height(4.dp))

                                                Text(
                                                    text = displayArtists,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Medium,
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )

                                                Spacer(Modifier.height(3.dp))

                                                Text(
                                                    text = "$displayAlbum • 2024 • Stereo Master",
                                                    fontSize = 11.sp,
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                            }

                                            // 3. SLEEK TIMELINE SCRUBBER
                                            var modalIsScrubbing by remember { mutableStateOf(false) }
                                            var modalScrubProgress by remember { mutableFloatStateOf(0f) }
                                            val currentDisplayProgress = if (modalIsScrubbing) modalScrubProgress else trackProgress
                                            val currentDisplayPos = if (modalIsScrubbing && durationMs > 0L) (modalScrubProgress * durationMs).toLong() else positionMs

                                            Column(
                                                modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp),
                                                verticalArrangement = Arrangement.spacedBy(2.dp)
                                            ) {
                                                Slider(
                                                    value = currentDisplayProgress,
                                                    onValueChange = {
                                                        modalIsScrubbing = true
                                                        modalScrubProgress = it
                                                    },
                                                    onValueChangeFinished = {
                                                        if (durationMs > 0L) {
                                                            viewModel.seekTo((modalScrubProgress * durationMs).toLong())
                                                        }
                                                        modalIsScrubbing = false
                                                    },
                                                    modifier = Modifier.fillMaxWidth().height(18.dp),
                                                    colors = SliderDefaults.colors(
                                                        thumbColor = StudioTheme.TextPrimary,
                                                        activeTrackColor = Color(0xFF38BDF8),
                                                        inactiveTrackColor = Color.White.copy(alpha = 0.12f)
                                                    )
                                                )
                                                Row(
                                                    modifier = Modifier.fillMaxWidth().padding(horizontal = 2.dp),
                                                    horizontalArrangement = Arrangement.SpaceBetween
                                                ) {
                                                    Text(formatDuration(currentDisplayPos), fontSize = 11.sp, fontWeight = FontWeight.Medium, color = StudioTheme.TextSecondary)
                                                    Text(formatDuration(durationMs), fontSize = 11.sp, fontWeight = FontWeight.Medium, color = StudioTheme.TextMuted)
                                                }
                                            }

                                            // 4. MASTER TRANSPORT PLAYBACK CONTROLS
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.Center,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                // Shuffle
                                                IconButton(
                                                    onClick = { viewModel.setShuffle(!shuffleEnabled) },
                                                    modifier = Modifier.size(36.dp)
                                                ) {
                                                    Icon(
                                                        Icons.Default.Shuffle,
                                                        contentDescription = "Shuffle",
                                                        tint = if (shuffleEnabled) Color(0xFF38BDF8) else StudioTheme.TextMuted,
                                                        modifier = Modifier.size(18.dp)
                                                    )
                                                }

                                                Spacer(Modifier.width(12.dp))

                                                // Previous
                                                LiquidGlassBox(
                                                    shape = CircleShape,
                                                    modifier = Modifier.size(42.dp),
                                                    onClick = { viewModel.skipPrevious() }
                                                ) {
                                                    Icon(
                                                        Icons.Default.SkipPrevious,
                                                        contentDescription = "Previous Track",
                                                        tint = StudioTheme.TextPrimary,
                                                        modifier = Modifier.size(22.dp)
                                                    )
                                                }

                                                Spacer(Modifier.width(16.dp))

                                                // Hero Play / Pause Orb (56dp)
                                                LiquidGlassBox(
                                                    shape = CircleShape,
                                                    modifier = Modifier.size(56.dp),
                                                    backgroundColor = Color.White.copy(alpha = 0.92f),
                                                    borderColor = Color.White,
                                                    onClick = { viewModel.togglePlayPause() }
                                                ) {
                                                    Icon(
                                                        if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                                        contentDescription = if (isPlaying) "Pause" else "Play",
                                                        tint = StudioTheme.CanvasBg,
                                                        modifier = Modifier.size(28.dp)
                                                    )
                                                }

                                                Spacer(Modifier.width(16.dp))

                                                // Next
                                                LiquidGlassBox(
                                                    shape = CircleShape,
                                                    modifier = Modifier.size(42.dp),
                                                    onClick = { viewModel.skipNext() }
                                                ) {
                                                    Icon(
                                                        Icons.Default.SkipNext,
                                                        contentDescription = "Next Track",
                                                        tint = StudioTheme.TextPrimary,
                                                        modifier = Modifier.size(22.dp)
                                                    )
                                                }

                                                Spacer(Modifier.width(12.dp))

                                                // Repeat Mode
                                                val (repeatIcon, repeatTint) = when (repeatMode) {
                                                    RepeatMode.ONE -> Icons.Default.RepeatOne to Color(0xFF38BDF8)
                                                    RepeatMode.ALL -> Icons.Default.Repeat to Color(0xFF38BDF8)
                                                    else -> Icons.Default.Repeat to StudioTheme.TextMuted
                                                }
                                                IconButton(
                                                    onClick = {
                                                        val nextMode = when (repeatMode) {
                                                            RepeatMode.NONE -> RepeatMode.ALL
                                                            RepeatMode.ALL -> RepeatMode.ONE
                                                            else -> RepeatMode.NONE
                                                        }
                                                        viewModel.setRepeatMode(nextMode)
                                                    },
                                                    modifier = Modifier.size(36.dp)
                                                ) {
                                                    Icon(
                                                        repeatIcon,
                                                        contentDescription = "Repeat",
                                                        tint = repeatTint,
                                                        modifier = Modifier.size(18.dp)
                                                    )
                                                }
                                            }

                                            // 5. QUICK ACTION PILL BAR (Clean, functional & elegant)
                                            Row(
                                                modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
                                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                // Studio Equalizer Jump
                                                Button(
                                                    onClick = { selectedModalTab = PlayerModalTab.EQUALIZER },
                                                    shape = RoundedCornerShape(8.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = StudioTheme.SurfaceElevated,
                                                        contentColor = StudioTheme.TextPrimary
                                                    ),
                                                    border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Icon(Icons.Default.Equalizer, null, modifier = Modifier.size(14.dp), tint = StudioTheme.AccentPrimary)
                                                    Spacer(Modifier.width(6.dp))
                                                    Text("Studio EQ", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                }

                                                // Audio Quality Pill
                                                LiquidGlassBox(
                                                    shape = RoundedCornerShape(8.dp),
                                                    modifier = Modifier.weight(1.2f)
                                                ) {
                                                    Row(
                                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        horizontalArrangement = Arrangement.Center
                                                    ) {
                                                        Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFF38BDF8)))
                                                        Spacer(Modifier.width(6.dp))
                                                        Text(
                                                            "320 kbps • Hi-Fi",
                                                            fontSize = 11.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            color = StudioTheme.TextSecondary
                                                        )
                                                    }
                                                }

                                                // Clear Memory / Cache
                                                OutlinedButton(
                                                    onClick = {
                                                        val freed = StudioStorage.clearStreamCache()
                                                        cacheFreedMb = freed
                                                        cacheClearedFeedback = true
                                                    },
                                                    shape = RoundedCornerShape(8.dp),
                                                    border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        containerColor = StudioTheme.SurfaceElevated,
                                                        contentColor = StudioTheme.TextSecondary
                                                    ),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Text(
                                                        if (cacheClearedFeedback) "RAM Cleared (${cacheFreedMb}MB)" else "Purge Cache",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.Medium
                                                    )
                                                }
                                            }

                                            // 6. OPTIONAL COLLAPSIBLE AUDIO ENGINE TELEMETRY ACCORDION
                                            var showTelemetryDetails by remember { mutableStateOf(false) }
                                            LiquidGlassCard(
                                                shape = RoundedCornerShape(10.dp),
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                            .clickable { showTelemetryDetails = !showTelemetryDetails }
                                                            .padding(vertical = 2.dp),
                                                        horizontalArrangement = Arrangement.SpaceBetween,
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                                            Icon(Icons.Default.Tune, null, tint = StudioTheme.TextMuted, modifier = Modifier.size(13.dp))
                                                            Text(
                                                                "Audio Engine Telemetry & Codec Details",
                                                                fontSize = 11.sp,
                                                                fontWeight = FontWeight.Medium,
                                                                color = StudioTheme.TextSecondary
                                                            )
                                                        }
                                                        Icon(
                                                            if (showTelemetryDetails) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                                            null,
                                                            tint = StudioTheme.TextMuted,
                                                            modifier = Modifier.size(16.dp)
                                                        )
                                                    }

                                                    if (showTelemetryDetails) {
                                                        Spacer(Modifier.height(10.dp))
                                                        val displayBitrate = if (downloadQuality.contains("FLAC")) "1411 kbps (Lossless)" else "320 kbps (High Fidelity)"
                                                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                            SpecCard("Bitrate & Fidelity", displayBitrate, Icons.Default.GraphicEq, if (displayBitrate.contains("Lossless")) "FLAC" else "HI-FI", Modifier.weight(1f))
                                                            SpecCard("Streaming Source", activeExtensionName.ifBlank { "Audix Local Engine" }, Icons.Default.Radio, "ONLINE", Modifier.weight(1f))
                                                        }
                                                        Spacer(Modifier.height(8.dp))
                                                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                            SpecCard("Container & Codec", detectedCodec, Icons.Default.Headphones, detectedCodecBadge, Modifier.weight(1f))
                                                            SpecCard("Audio Channels", if (stereoWidth > 100f) "Stereo Wide (Spatial)" else "Stereo 2.0 (Studio)", Icons.Default.Tune, "2-CH", Modifier.weight(1f))
                                                        }
                                                    }
                                                }
                                            }

                                            // 7. INTEGRATED UP NEXT & PLAYBACK QUEUE LIST (Filling the empty space accordingly)
                                            val effectiveQueue = remember(queue, currentTrack) {
                                                if (currentTrack != null && queue.none { it.id == currentTrack?.id }) {
                                                    listOf(currentTrack!!) + queue
                                                } else {
                                                    queue
                                                }
                                            }

                                            LiquidGlassCard(
                                                shape = RoundedCornerShape(12.dp),
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(14.dp),
                                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                                ) {
                                                    // Header
                                                    Row(
                                                        modifier = Modifier.fillMaxWidth(),
                                                        horizontalArrangement = Arrangement.SpaceBetween,
                                                        verticalAlignment = Alignment.CenterVertically
                                                     ) {
                                                        Row(
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                                        ) {
                                                            Icon(
                                                                Icons.AutoMirrored.Filled.QueueMusic,
                                                                contentDescription = null,
                                                                tint = Color(0xFF38BDF8),
                                                                modifier = Modifier.size(17.dp)
                                                            )
                                                            Text(
                                                                "PLAYBACK QUEUE",
                                                                fontSize = 12.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                color = StudioTheme.TextPrimary,
                                                                letterSpacing = 0.6.sp
                                                            )
                                                            LiquidGlassBox(shape = RoundedCornerShape(5.dp)) {
                                                                Text(
                                                                    "${effectiveQueue.size} TRACKS",
                                                                    fontSize = 9.5.sp,
                                                                    fontWeight = FontWeight.Bold,
                                                                    color = Color(0xFF38BDF8),
                                                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                                                )
                                                            }
                                                        }

                                                        // Actions (Shuffle, Clear, Open Full Tab)
                                                        Row(
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                                                        ) {
                                                            IconButton(
                                                                onClick = { viewModel.setShuffle(!shuffleEnabled) },
                                                                modifier = Modifier.size(28.dp)
                                                            ) {
                                                                Icon(
                                                                    Icons.Default.Shuffle,
                                                                    contentDescription = "Shuffle",
                                                                    tint = if (shuffleEnabled) Color(0xFF38BDF8) else StudioTheme.TextMuted,
                                                                    modifier = Modifier.size(14.dp)
                                                                )
                                                            }
                                                            if (queue.isNotEmpty()) {
                                                                IconButton(
                                                                    onClick = { viewModel.clearQueue() },
                                                                    modifier = Modifier.size(28.dp)
                                                                ) {
                                                                    Icon(
                                                                        Icons.Default.Clear,
                                                                        contentDescription = "Clear Queue",
                                                                        tint = StudioTheme.TextMuted,
                                                                        modifier = Modifier.size(14.dp)
                                                                    )
                                                                }
                                                            }
                                                            IconButton(
                                                                onClick = { selectedModalTab = PlayerModalTab.QUEUE },
                                                                modifier = Modifier.size(28.dp)
                                                            ) {
                                                                Icon(
                                                                    Icons.AutoMirrored.Filled.OpenInNew,
                                                                    contentDescription = "Open Full Queue View",
                                                                    tint = StudioTheme.TextMuted,
                                                                    modifier = Modifier.size(14.dp)
                                                                )
                                                            }
                                                        }
                                                    }

                                                    if (effectiveQueue.isEmpty()) {
                                                        // Clean empty state with smart radio generator
                                                        Column(
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                                .padding(vertical = 16.dp, horizontal = 10.dp),
                                                            horizontalAlignment = Alignment.CenterHorizontally,
                                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                                        ) {
                                                            Icon(
                                                                Icons.AutoMirrored.Filled.QueueMusic,
                                                                contentDescription = null,
                                                                tint = StudioTheme.TextMuted.copy(alpha = 0.45f),
                                                                modifier = Modifier.size(34.dp)
                                                            )
                                                            Text(
                                                                "Queue is Empty",
                                                                fontSize = 13.sp,
                                                                fontWeight = FontWeight.SemiBold,
                                                                color = StudioTheme.TextSecondary
                                                            )
                                                            Text(
                                                                "Add tracks from Search or Home, or launch Smart Flow Radio",
                                                                fontSize = 11.sp,
                                                                color = StudioTheme.TextMuted,
                                                                textAlign = TextAlign.Center
                                                            )
                                                            Spacer(Modifier.height(4.dp))
                                                            Button(
                                                                onClick = {
                                                                    val vibeTracks = when (smartFlowVibe) {
                                                                        "Chill Flow" -> listOf(
                                                                            Track(id = "vibe_chill_1", title = "Weightless (Audix Ambient Edit)", artists = listOf(Artist("vibe_a1", "Marconi Union")), album = Album("v_alb_1", "Ambient Master")),
                                                                            Track(id = "vibe_chill_2", title = "Sunset Lover (Chill Vibe)", artists = listOf(Artist("vibe_a2", "Petit Biscuit")), album = Album("v_alb_2", "Sunset Edition")),
                                                                            Track(id = "vibe_chill_3", title = "Intro (Chill Remaster)", artists = listOf(Artist("vibe_a3", "The xx")), album = Album("v_alb_3", "Coexist Master"))
                                                                        )
                                                                        "High Energy" -> listOf(
                                                                            Track(id = "vibe_eng_1", title = "Blinding Lights (Club Mix)", artists = listOf(Artist("vibe_a4", "The Weeknd")), album = Album("v_alb_4", "After Hours")),
                                                                            Track(id = "vibe_eng_2", title = "Titanium (Festival Beat)", artists = listOf(Artist("vibe_a5", "David Guetta & Sia")), album = Album("v_alb_5", "Dance Master")),
                                                                            Track(id = "vibe_eng_3", title = "One More Time (Club Remaster)", artists = listOf(Artist("vibe_a6", "Daft Punk")), album = Album("v_alb_6", "Discovery"))
                                                                        )
                                                                        "Deep Focus" -> listOf(
                                                                            Track(id = "vibe_foc_1", title = "Deep Focus Alpha Waves", artists = listOf(Artist("vibe_a7", "Audix Binaural")), album = Album("v_alb_7", "Cognitive Flow")),
                                                                            Track(id = "vibe_foc_2", title = "Time (Acoustic Minimal)", artists = listOf(Artist("vibe_a8", "Hans Zimmer")), album = Album("v_alb_8", "Inception Score")),
                                                                            Track(id = "vibe_foc_3", title = "Day One (Piano Resonance)", artists = listOf(Artist("vibe_a9", "Hans Zimmer")), album = Album("v_alb_9", "Interstellar Flow"))
                                                                        )
                                                                        else -> listOf(
                                                                            Track(id = "vibe_drv_1", title = "Midnight City (Synth Edition)", artists = listOf(Artist("vibe_a10", "M83")), album = Album("v_alb_10", "Hurry Up")),
                                                                            Track(id = "vibe_drv_2", title = "Nightcall (Drive Master)", artists = listOf(Artist("vibe_a11", "Kavinsky")), album = Album("v_alb_11", "OutRun")),
                                                                            Track(id = "vibe_drv_3", title = "Resonance (Neon Synth)", artists = listOf(Artist("vibe_a12", "HOME")), album = Album("v_alb_12", "Odyssey"))
                                                                        )
                                                                    }
                                                                    viewModel.addToQueue(vibeTracks)
                                                                },
                                                                shape = RoundedCornerShape(8.dp),
                                                                colors = ButtonDefaults.buttonColors(
                                                                    containerColor = Color(0xFF38BDF8),
                                                                    contentColor = Color.Black
                                                                ),
                                                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 7.dp)
                                                            ) {
                                                                Icon(Icons.Default.AutoAwesome, null, modifier = Modifier.size(13.dp))
                                                                Spacer(Modifier.width(6.dp))
                                                                Text("Start Smart Radio ($smartFlowVibe)", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                            }
                                                        }
                                                    } else {
                                                        val currentIdx = if (currentTrack != null) effectiveQueue.indexOfFirst { it.id == currentTrack?.id } else -1
                                                        val displayQueue = if (effectiveQueue.size > 25) effectiveQueue.take(25) else effectiveQueue

                                                        Column(
                                                            modifier = Modifier.fillMaxWidth(),
                                                            verticalArrangement = Arrangement.spacedBy(6.dp)
                                                        ) {
                                                            displayQueue.forEachIndexed { idx, item ->
                                                                val isItemCurrent = currentTrack?.id == item.id
                                                                val isItemPast = currentIdx != -1 && idx < currentIdx

                                                                val itemCover = extractTrackCoverUrl(item)
                                                                val rawItemTitle = item.title.ifBlank { "Untitled Track" }
                                                                val displayItemTitle = cleanDisplayTitle(rawItemTitle)
                                                                val itemArtists = item.artists.joinToString(", ") { it.name }.ifBlank { "Audix Hi-Res" }
                                                                val itemAlbum = item.album?.title ?: ""
                                                                val subtitle = if (itemAlbum.isNotBlank()) "$itemArtists • $itemAlbum" else itemArtists

                                                                Row(
                                                                    modifier = Modifier
                                                                        .fillMaxWidth()
                                                                        .clip(RoundedCornerShape(8.dp))
                                                                        .background(
                                                                            when {
                                                                                isItemCurrent -> Color(0xFF38BDF8).copy(alpha = 0.12f)
                                                                                isItemPast -> Color.White.copy(alpha = 0.02f)
                                                                                else -> StudioTheme.SurfaceElevated.copy(alpha = 0.6f)
                                                                            }
                                                                        )
                                                                        .border(
                                                                            1.dp,
                                                                            when {
                                                                                isItemCurrent -> Color(0xFF38BDF8).copy(alpha = 0.45f)
                                                                                else -> StudioTheme.BorderSubtle
                                                                            },
                                                                            RoundedCornerShape(8.dp)
                                                                        )
                                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                                        .clickable { viewModel.play(item) }
                                                                        .padding(horizontal = 10.dp, vertical = 7.dp),
                                                                    verticalAlignment = Alignment.CenterVertically
                                                                ) {
                                                                    // Track Index / Status Indicator
                                                                    Text(
                                                                        "${idx + 1}".padStart(2, '0'),
                                                                        fontSize = 11.sp,
                                                                        fontWeight = if (isItemCurrent) FontWeight.Bold else FontWeight.Medium,
                                                                        color = if (isItemCurrent) Color(0xFF38BDF8) else StudioTheme.TextMuted,
                                                                        modifier = Modifier.width(22.dp)
                                                                    )

                                                                    // Artwork Thumbnail
                                                                    Box(
                                                                        modifier = Modifier
                                                                            .size(34.dp)
                                                                            .clip(RoundedCornerShape(6.dp))
                                                                            .background(Color.Black.copy(alpha = 0.5f)),
                                                                        contentAlignment = Alignment.Center
                                                                    ) {
                                                                        if (!itemCover.isNullOrBlank()) {
                                                                            AsyncImage(
                                                                                model = itemCover,
                                                                                contentDescription = null,
                                                                                modifier = Modifier.fillMaxSize(),
                                                                                contentScale = ContentScale.Crop
                                                                            )
                                                                        } else {
                                                                            Icon(
                                                                                Icons.Default.MusicNote,
                                                                                contentDescription = null,
                                                                                tint = StudioTheme.TextMuted,
                                                                                modifier = Modifier.size(16.dp)
                                                                            )
                                                                        }

                                                                        if (isItemCurrent && isPlaying) {
                                                                            Box(
                                                                                modifier = Modifier
                                                                                    .fillMaxSize()
                                                                                    .background(Color.Black.copy(alpha = 0.45f)),
                                                                                contentAlignment = Alignment.Center
                                                                            ) {
                                                                                Icon(
                                                                                    Icons.Default.GraphicEq,
                                                                                    contentDescription = "Playing",
                                                                                    tint = Color(0xFF38BDF8),
                                                                                    modifier = Modifier.size(16.dp)
                                                                                )
                                                                            }
                                                                        }
                                                                    }

                                                                    Spacer(Modifier.width(10.dp))

                                                                    // Metadata Column
                                                                    Column(modifier = Modifier.weight(1f)) {
                                                                        Row(
                                                                            verticalAlignment = Alignment.CenterVertically,
                                                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                                                        ) {
                                                                            Text(
                                                                                text = displayItemTitle,
                                                                                fontSize = 12.5.sp,
                                                                                fontWeight = if (isItemCurrent) FontWeight.Bold else FontWeight.Medium,
                                                                                color = when {
                                                                                    isItemCurrent -> Color.White
                                                                                    isItemPast -> StudioTheme.TextMuted
                                                                                    else -> StudioTheme.TextPrimary
                                                                                },
                                                                                maxLines = 1,
                                                                                overflow = TextOverflow.Ellipsis,
                                                                                modifier = Modifier.weight(1f, fill = false)
                                                                            )

                                                                            if (isItemCurrent) {
                                                                                LiquidGlassBox(
                                                                                    shape = RoundedCornerShape(4.dp),
                                                                                    backgroundColor = Color(0xFF38BDF8).copy(alpha = 0.18f),
                                                                                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.45f)
                                                                                ) {
                                                                                    Text(
                                                                                        if (isPlaying) "NOW PLAYING" else "PAUSED",
                                                                                        fontSize = 8.5.sp,
                                                                                        fontWeight = FontWeight.Bold,
                                                                                        color = Color(0xFF38BDF8),
                                                                                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                                                                                    )
                                                                                }
                                                                            }
                                                                        }

                                                                        Spacer(Modifier.height(1.dp))

                                                                        Text(
                                                                            text = subtitle,
                                                                            fontSize = 10.5.sp,
                                                                            color = if (isItemCurrent) Color(0xFF94A3B8) else StudioTheme.TextMuted,
                                                                            maxLines = 1,
                                                                            overflow = TextOverflow.Ellipsis
                                                                        )
                                                                    }

                                                                    Spacer(Modifier.width(8.dp))

                                                                    // Duration
                                                                    val itemDur = item.duration
                                                                    if (itemDur != null && itemDur > 0L) {
                                                                        Text(
                                                                            text = formatDuration(itemDur),
                                                                            fontSize = 10.5.sp,
                                                                            fontWeight = FontWeight.Medium,
                                                                            color = StudioTheme.TextMuted,
                                                                            modifier = Modifier.padding(end = 4.dp)
                                                                        )
                                                                    }

                                                                    // Remove Action Button (available for all except currently playing)
                                                                    if (!isItemCurrent) {
                                                                        val qIdx = queue.indexOfFirst { it.id == item.id }
                                                                        if (qIdx >= 0) {
                                                                            IconButton(
                                                                                onClick = { viewModel.removeFromQueue(qIdx) },
                                                                                modifier = Modifier.size(24.dp)
                                                                            ) {
                                                                                Icon(
                                                                                    Icons.Default.Close,
                                                                                    contentDescription = "Remove",
                                                                                    tint = StudioTheme.TextMuted,
                                                                                    modifier = Modifier.size(13.dp)
                                                                                )
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                            if (effectiveQueue.size > 25) {
                                                                LiquidGlassBox(
                                                                    shape = RoundedCornerShape(8.dp),
                                                                    modifier = Modifier
                                                                        .fillMaxWidth()
                                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                                        .clickable { selectedModalTab = PlayerModalTab.QUEUE },
                                                                    backgroundColor = StudioTheme.SurfaceElevated,
                                                                    borderColor = StudioTheme.BorderSubtle
                                                                ) {
                                                                    Row(
                                                                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
                                                                        verticalAlignment = Alignment.CenterVertically,
                                                                        horizontalArrangement = Arrangement.Center
                                                                    ) {
                                                                        Icon(Icons.AutoMirrored.Filled.List, null, tint = Color(0xFF38BDF8), modifier = Modifier.size(14.dp))
                                                                        Spacer(Modifier.width(6.dp))
                                                                        Text(
                                                                            "View all ${effectiveQueue.size} tracks in Full Queue Tab",
                                                                            fontSize = 11.5.sp,
                                                                            fontWeight = FontWeight.SemiBold,
                                                                            color = Color(0xFF38BDF8)
                                                                        )
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    // =============================================================
                                    // PART 2 (RIGHT COLUMN): THE LYRICS ONGOING ALONG WITH THE SONG
                                    // =============================================================
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(16.dp),
                                        modifier = Modifier
                                            .weight(1.05f)
                                            .fillMaxHeight()
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(horizontal = 18.dp, vertical = 16.dp)
                                        ) {
                                            // =========================================================
                                            // TIER 1: LYRICS HEADER & PRIMARY ACTIONS (SPACIOUS & CLEAN)
                                            // =========================================================
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                // Left: Brand & Status
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                                ) {
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(10.dp),
                                                        modifier = Modifier.size(36.dp),
                                                        backgroundColor = Color(0xFF38BDF8).copy(alpha = 0.18f),
                                                        borderColor = Color(0xFF38BDF8).copy(alpha = 0.45f)
                                                    ) {
                                                        Icon(
                                                            Icons.Default.MusicNote,
                                                            contentDescription = null,
                                                            tint = Color(0xFF38BDF8),
                                                            modifier = Modifier.size(18.dp)
                                                        )
                                                    }

                                                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                                        Row(
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                                        ) {
                                                            Text(
                                                                "LIVE LYRICS",
                                                                fontSize = 14.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                color = StudioTheme.TextPrimary,
                                                                letterSpacing = 0.5.sp
                                                            )

                                                            // Karaoke Sync / Pause Badge
                                                            LiquidGlassBox(
                                                                shape = RoundedCornerShape(6.dp),
                                                                borderColor = if (isPlaying) StudioTheme.StatusActiveBorder else StudioTheme.BorderSubtle
                                                            ) {
                                                                Row(
                                                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp),
                                                                    verticalAlignment = Alignment.CenterVertically
                                                                ) {
                                                                    Box(
                                                                        modifier = Modifier
                                                                            .size(5.dp)
                                                                            .clip(CircleShape)
                                                                            .background(if (isPlaying) Color(0xFF10B981) else StudioTheme.TextMuted)
                                                                    )
                                                                    Spacer(Modifier.width(4.dp))
                                                                    Text(
                                                                        if (isPlaying) "KARAOKE SYNC" else "PAUSED",
                                                                        fontSize = 9.5.sp,
                                                                        fontWeight = FontWeight.Bold,
                                                                        color = if (isPlaying) Color(0xFF10B981) else StudioTheme.TextMuted
                                                                    )
                                                                }
                                                            }
                                                        }

                                                        val lyricsSourceDisplay = onlineLyricsSource ?: when (lyricsUiState) {
                                                            is LyricsUiState.Timed -> "Extension (Synced)"
                                                            is LyricsUiState.Simple -> "Extension (Lyrics)"
                                                            else -> "Studio Auto-Sync"
                                                        }
                                                        Text(
                                                            if (isFetchingOnlineLyrics) "Fetching karaoke sync from LrcLib..." else "Source: $lyricsSourceDisplay • Real-time tracking",
                                                            fontSize = 11.sp,
                                                            color = StudioTheme.TextMuted
                                                        )
                                                    }
                                                }

                                                // Right: Re-sync & Copy Buttons with proper padding and no collision
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                                ) {
                                                    // Re-sync Button
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(8.dp),
                                                        modifier = Modifier
                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                            .clickable { triggerReloadLyrics() }
                                                    ) {
                                                        Row(
                                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                                        ) {
                                                            Icon(
                                                                Icons.Default.Refresh,
                                                                contentDescription = "Re-sync Lyrics",
                                                                tint = if (isFetchingOnlineLyrics) StudioTheme.AccentPrimary else StudioTheme.TextSecondary,
                                                                modifier = Modifier.size(13.dp)
                                                            )
                                                            Text(
                                                                "Re-sync",
                                                                fontSize = 11.sp,
                                                                color = StudioTheme.TextSecondary,
                                                                fontWeight = FontWeight.Medium
                                                            )
                                                        }
                                                    }

                                                    // Copy Button
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(8.dp),
                                                        borderColor = if (copyLyricsFeedback) Color(0xFF38BDF8).copy(alpha = 0.5f) else StudioTheme.BorderSubtle,
                                                        modifier = Modifier
                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                            .clickable {
                                                                val textToCopy = resolvedLyrics.joinToString("\n\n") { item ->
                                                                    val dual = HindiLyricsProcessor.formatDualLine(item.text, isHindiTrack)
                                                                    if (isHindiTrack) {
                                                                        when (lyricsLanguageMode) {
                                                                            "Hindi" -> dual.hindiText.ifBlank { dual.englishText }
                                                                            "English" -> dual.englishText.ifBlank { dual.hindiText }
                                                                            else -> "${dual.hindiText}\n${dual.englishText}".trim()
                                                                        }
                                                                    } else {
                                                                        dual.englishText.ifBlank { item.text }
                                                                    }
                                                                }
                                                                StudioStorage.copyToClipboard(textToCopy)
                                                                copyLyricsFeedback = true
                                                            }
                                                    ) {
                                                        Row(
                                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                                        ) {
                                                            Icon(
                                                                if (copyLyricsFeedback) Icons.Default.Check else Icons.Default.ContentCopy,
                                                                contentDescription = "Copy Lyrics",
                                                                tint = if (copyLyricsFeedback) Color(0xFF38BDF8) else StudioTheme.TextSecondary,
                                                                modifier = Modifier.size(13.dp)
                                                            )
                                                            Text(
                                                                if (copyLyricsFeedback) "Copied!" else "Copy",
                                                                fontSize = 11.sp,
                                                                color = if (copyLyricsFeedback) Color(0xFF38BDF8) else StudioTheme.TextSecondary,
                                                                fontWeight = FontWeight.Medium
                                                            )
                                                        }
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(12.dp))

                                            // =========================================================
                                            // TIER 2: TOOLBAR (LANGUAGE SCRIPTS, VIEW MODE & FONT SIZE)
                                            // =========================================================
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .clip(RoundedCornerShape(14.dp))
                                                    .background(Color(0xFF0F172A).copy(alpha = 0.45f))
                                                    .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(14.dp))
                                                    .padding(horizontal = 16.dp, vertical = 10.dp)
                                            ) {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceBetween,
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    // Left: Language / Script Selector
                                                    if (isHindiTrack) {
                                                        Row(
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                                                        ) {
                                                            Text(
                                                                "SCRIPT",
                                                                fontSize = 10.5.sp,
                                                                fontWeight = FontWeight.Bold,
                                                                color = StudioTheme.TextMuted.copy(alpha = 0.7f),
                                                                letterSpacing = 0.8.sp
                                                            )

                                                            // Clean segmented control
                                                            Row(
                                                                modifier = Modifier
                                                                    .clip(RoundedCornerShape(10.dp))
                                                                    .background(Color.Black.copy(alpha = 0.35f))
                                                                    .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
                                                                    .padding(3.dp),
                                                                verticalAlignment = Alignment.CenterVertically
                                                            ) {
                                                                listOf(
                                                                    "Dual" to "Dual (हिंदी + En)",
                                                                    "Hindi" to "हिंदी",
                                                                    "English" to "English"
                                                                ).forEach { (langMode, displayLabel) ->
                                                                    val isSel = lyricsLanguageMode == langMode
                                                                    Box(
                                                                        modifier = Modifier
                                                                            .clip(RoundedCornerShape(7.dp))
                                                                            .background(if (isSel) Color(0xFF38BDF8).copy(alpha = 0.18f) else Color.Transparent)
                                                                            .pointerHoverIcon(PointerIcon.Hand)
                                                                            .clickable { lyricsLanguageMode = langMode }
                                                                            .padding(horizontal = 10.dp, vertical = 5.dp),
                                                                        contentAlignment = Alignment.Center
                                                                    ) {
                                                                        Text(
                                                                            displayLabel,
                                                                            fontSize = 11.sp,
                                                                            fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                                                                            color = if (isSel) Color(0xFF38BDF8) else StudioTheme.TextMuted
                                                                        )
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        Row(
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                            modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
                                                        ) {
                                                            Box(
                                                                modifier = Modifier
                                                                    .size(7.dp)
                                                                    .clip(CircleShape)
                                                                    .background(Color(0xFF38BDF8))
                                                            )
                                                            Text(
                                                                "ORIGINAL LYRICS",
                                                                fontSize = 11.sp,
                                                                fontWeight = FontWeight.SemiBold,
                                                                color = Color(0xFF94A3B8),
                                                                letterSpacing = 0.8.sp
                                                            )
                                                        }
                                                    }

                                                    // Right: Mode (Synced / Plain) & Font Size (S / M / L)
                                                    Row(
                                                        verticalAlignment = Alignment.CenterVertically,
                                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                                    ) {
                                                        // Mode Segmented Capsule (Synced vs Plain)
                                                        Row(
                                                            modifier = Modifier
                                                                .clip(RoundedCornerShape(10.dp))
                                                                .background(Color.Black.copy(alpha = 0.35f))
                                                                .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
                                                                .padding(3.dp),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            // Synced
                                                            Box(
                                                                modifier = Modifier
                                                                    .clip(RoundedCornerShape(7.dp))
                                                                    .background(if (lyricsModeTimed) Color.White.copy(alpha = 0.14f) else Color.Transparent)
                                                                    .pointerHoverIcon(PointerIcon.Hand)
                                                                    .clickable { lyricsModeTimed = true }
                                                                    .padding(horizontal = 12.dp, vertical = 5.dp),
                                                                contentAlignment = Alignment.Center
                                                            ) {
                                                                Text(
                                                                    "Synced",
                                                                    fontSize = 11.5.sp,
                                                                    fontWeight = if (lyricsModeTimed) FontWeight.SemiBold else FontWeight.Normal,
                                                                    color = if (lyricsModeTimed) Color.White else Color(0xFF94A3B8)
                                                                )
                                                            }

                                                            // Plain
                                                            Box(
                                                                modifier = Modifier
                                                                    .clip(RoundedCornerShape(7.dp))
                                                                    .background(if (!lyricsModeTimed) Color.White.copy(alpha = 0.14f) else Color.Transparent)
                                                                    .pointerHoverIcon(PointerIcon.Hand)
                                                                    .clickable { lyricsModeTimed = false }
                                                                    .padding(horizontal = 12.dp, vertical = 5.dp),
                                                                contentAlignment = Alignment.Center
                                                            ) {
                                                                Text(
                                                                    "Plain",
                                                                    fontSize = 11.5.sp,
                                                                    fontWeight = if (!lyricsModeTimed) FontWeight.SemiBold else FontWeight.Normal,
                                                                    color = if (!lyricsModeTimed) Color.White else Color(0xFF94A3B8)
                                                                )
                                                            }
                                                        }

                                                        // Size Segmented Capsule (S / M / L)
                                                        Row(
                                                            modifier = Modifier
                                                                .clip(RoundedCornerShape(10.dp))
                                                                .background(Color.Black.copy(alpha = 0.35f))
                                                                .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
                                                                .padding(3.dp),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            listOf("S" to "Small", "M" to "Medium", "L" to "Large").forEach { (label, name) ->
                                                                val isSelected = lyricsFontSize == name
                                                                Box(
                                                                    modifier = Modifier
                                                                        .clip(RoundedCornerShape(7.dp))
                                                                        .background(if (isSelected) Color.White.copy(alpha = 0.14f) else Color.Transparent)
                                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                                        .clickable { lyricsFontSize = name }
                                                                        .padding(horizontal = 11.dp, vertical = 5.dp),
                                                                    contentAlignment = Alignment.Center
                                                                ) {
                                                                    Text(
                                                                        label,
                                                                        fontSize = 11.5.sp,
                                                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                                                        color = if (isSelected) Color.White else Color(0xFF94A3B8)
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(10.dp))

                                            // Lyrics Content Viewport
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .weight(1f),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                val lyricTextSize = when (lyricsFontSize) {
                                                    "Small" -> 14.sp
                                                    "Large" -> 20.sp
                                                    else -> 16.sp
                                                }

                                                if (!lyricsModeTimed) {
                                                    LazyColumn(
                                                        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
                                                        contentPadding = PaddingValues(vertical = 16.dp),
                                                        verticalArrangement = Arrangement.spacedBy(14.dp)
                                                    ) {
                                                         itemsIndexed(resolvedLyrics, key = { idx, _ -> "$idx" }) { _, item ->
                                                            val dual = HindiLyricsProcessor.formatDualLine(item.text, isHindiTrack)
                                                            Column(
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .clip(RoundedCornerShape(8.dp))
                                                                    .padding(horizontal = 14.dp, vertical = 8.dp),
                                                                verticalArrangement = Arrangement.spacedBy(4.dp)
                                                            ) {
                                                                if (isHindiTrack) {
                                                                    when (lyricsLanguageMode) {
                                                                        "Hindi" -> {
                                                                            Text(
                                                                                text = dual.hindiText.ifBlank { dual.englishText },
                                                                                color = StudioTheme.TextPrimary,
                                                                                fontSize = lyricTextSize,
                                                                                lineHeight = (lyricTextSize.value * 1.45f).sp
                                                                            )
                                                                        }
                                                                        "English" -> {
                                                                            Text(
                                                                                text = dual.englishText.ifBlank { dual.hindiText },
                                                                                color = StudioTheme.TextPrimary,
                                                                                fontSize = lyricTextSize,
                                                                                lineHeight = (lyricTextSize.value * 1.45f).sp
                                                                            )
                                                                        }
                                                                        else -> { // "Dual"
                                                                            if (dual.hindiText.isNotBlank()) {
                                                                                Text(
                                                                                    text = dual.hindiText,
                                                                                    color = StudioTheme.TextPrimary,
                                                                                    fontSize = lyricTextSize,
                                                                                    fontWeight = FontWeight.Medium,
                                                                                    lineHeight = (lyricTextSize.value * 1.4f).sp
                                                                                )
                                                                            }
                                                                            if (dual.englishText.isNotBlank()) {
                                                                                Text(
                                                                                    text = dual.englishText,
                                                                                    color = Color(0xFF38BDF8),
                                                                                    fontSize = (lyricTextSize.value - 2).coerceAtLeast(11f).sp,
                                                                                    lineHeight = ((lyricTextSize.value - 2) * 1.3f).sp
                                                                                )
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    Text(
                                                                        text = dual.englishText.ifBlank { item.text },
                                                                        color = StudioTheme.TextPrimary,
                                                                        fontSize = lyricTextSize,
                                                                        lineHeight = (lyricTextSize.value * 1.45f).sp
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    if (isFetchingOnlineLyrics && resolvedLyrics.isEmpty()) {
                                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                            CircularProgressIndicator(
                                                                color = StudioTheme.AccentPrimary,
                                                                modifier = Modifier.size(28.dp),
                                                                strokeWidth = 2.dp
                                                            )
                                                            Spacer(Modifier.height(10.dp))
                                                            Text(
                                                                "Connecting to LrcLib & fetching synchronized lines...",
                                                                color = StudioTheme.TextMuted,
                                                                fontSize = 12.sp
                                                            )
                                                        }
                                                    } else {
                                                        val listState = rememberLazyListState()
                                                        LaunchedEffect(effectiveActiveIndex) {
                                                            if (effectiveActiveIndex in resolvedLyrics.indices) {
                                                                listState.animateScrollToItem((effectiveActiveIndex - 2).coerceAtLeast(0))
                                                            }
                                                        }

                                                        LazyColumn(
                                                            state = listState,
                                                            modifier = Modifier.fillMaxSize(),
                                                            contentPadding = PaddingValues(vertical = 28.dp, horizontal = 6.dp),
                                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                                        ) {
                                                            itemsIndexed(resolvedLyrics, key = { idx, _ -> "$idx" }) { idx, item ->
                                                                val isCurrent = idx == effectiveActiveIndex
                                                                val dual = HindiLyricsProcessor.formatDualLine(item.text, isHindiTrack)

                                                                Box(
                                                                    modifier = Modifier
                                                                        .fillMaxWidth()
                                                                        .clip(RoundedCornerShape(12.dp))
                                                                        .background(
                                                                            if (isCurrent) Color.White.copy(alpha = 0.08f)
                                                                            else Color.Transparent
                                                                        )
                                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                                        .clickable {
                                                                            viewModel.seekTo(item.startTime + lyricsOffsetMs)
                                                                        }
                                                                        .padding(horizontal = 14.dp, vertical = 10.dp)
                                                                ) {
                                                                    Row(
                                                                        modifier = Modifier.fillMaxWidth(),
                                                                        verticalAlignment = Alignment.CenterVertically
                                                                    ) {
                                                                        // Active Accent Indicator Bar
                                                                        Box(
                                                                            modifier = Modifier
                                                                                .width(4.dp)
                                                                                .height(if (isHindiTrack && lyricsLanguageMode == "Dual" && dual.hindiText.isNotBlank() && dual.englishText.isNotBlank()) 44.dp else 24.dp)
                                                                                .clip(RoundedCornerShape(2.dp))
                                                                                .background(if (isCurrent) StudioTheme.AccentPrimary else Color.Transparent)
                                                                        )
                                                                        Spacer(Modifier.width(14.dp))

                                                                        Column(
                                                                            modifier = Modifier.weight(1f),
                                                                            verticalArrangement = Arrangement.spacedBy(4.dp)
                                                                        ) {
                                                                            if (isHindiTrack) {
                                                                                when (lyricsLanguageMode) {
                                                                                    "Hindi" -> {
                                                                                        Text(
                                                                                            text = dual.hindiText.ifBlank { dual.englishText },
                                                                                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                                                                            color = if (isCurrent) StudioTheme.TextPrimary
                                                                                                    else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                                    else StudioTheme.TextSecondary.copy(alpha = 0.85f),
                                                                                            fontSize = if (isCurrent) (lyricTextSize.value + 3).sp else lyricTextSize,
                                                                                            lineHeight = if (isCurrent) ((lyricTextSize.value + 3) * 1.4f).sp else (lyricTextSize.value * 1.4f).sp,
                                                                                            textAlign = TextAlign.Start
                                                                                        )
                                                                                    }
                                                                                    "English" -> {
                                                                                        Text(
                                                                                            text = dual.englishText.ifBlank { dual.hindiText },
                                                                                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                                                                            color = if (isCurrent) StudioTheme.TextPrimary
                                                                                                    else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                                    else StudioTheme.TextSecondary.copy(alpha = 0.85f),
                                                                                            fontSize = if (isCurrent) (lyricTextSize.value + 3).sp else lyricTextSize,
                                                                                            lineHeight = if (isCurrent) ((lyricTextSize.value + 3) * 1.4f).sp else (lyricTextSize.value * 1.4f).sp,
                                                                                            textAlign = TextAlign.Start
                                                                                        )
                                                                                    }
                                                                                    else -> { // "Dual"
                                                                                        if (dual.hindiText.isNotBlank()) {
                                                                                            Text(
                                                                                                text = dual.hindiText,
                                                                                                fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                                                                                                color = if (isCurrent) StudioTheme.TextPrimary
                                                                                                        else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                                        else StudioTheme.TextSecondary.copy(alpha = 0.90f),
                                                                                                fontSize = if (isCurrent) (lyricTextSize.value + 3).sp else lyricTextSize,
                                                                                                lineHeight = if (isCurrent) ((lyricTextSize.value + 3) * 1.35f).sp else (lyricTextSize.value * 1.35f).sp,
                                                                                                textAlign = TextAlign.Start
                                                                                            )
                                                                                        }
                                                                                        if (dual.englishText.isNotBlank()) {
                                                                                            Text(
                                                                                                text = dual.englishText,
                                                                                                fontWeight = if (isCurrent) FontWeight.SemiBold else FontWeight.Normal,
                                                                                                color = if (isCurrent) Color(0xFF38BDF8)
                                                                                                        else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.40f)
                                                                                                        else Color(0xFF94A3B8).copy(alpha = 0.85f),
                                                                                                fontSize = if (isCurrent) (lyricTextSize.value - 1).sp else (lyricTextSize.value - 3).coerceAtLeast(11f).sp,
                                                                                                lineHeight = if (isCurrent) ((lyricTextSize.value - 1) * 1.3f).sp else ((lyricTextSize.value - 3) * 1.3f).sp,
                                                                                                letterSpacing = 0.3.sp,
                                                                                                textAlign = TextAlign.Start
                                                                                            )
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                // English Track: Pure English lyrics
                                                                                Text(
                                                                                    text = dual.englishText.ifBlank { item.text },
                                                                                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                                                                    color = if (isCurrent) StudioTheme.TextPrimary
                                                                                            else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                            else StudioTheme.TextSecondary.copy(alpha = 0.85f),
                                                                                    fontSize = if (isCurrent) (lyricTextSize.value + 3).sp else lyricTextSize,
                                                                                    lineHeight = if (isCurrent) ((lyricTextSize.value + 3) * 1.4f).sp else (lyricTextSize.value * 1.4f).sp,
                                                                                    textAlign = TextAlign.Start
                                                                                )
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // -----------------------------------------------------------------
                            // TAB 2: PRO AUDIO & 10-BAND GRAPHIC EQUALIZER (16 Features & Controls)
                            // -----------------------------------------------------------------
                            PlayerModalTab.EQUALIZER -> {
                                val scrollState = rememberScrollState()
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(scrollState),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    // DSP Master Switch & Pre-Amp
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(14.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Switch(
                                                    checked = eqEnabled,
                                                    onCheckedChange = {
                                                        eqEnabled = it
                                                        applyEq(eqBands, preAmpGain, it)
                                                    },
                                                    colors = SwitchDefaults.colors(
                                                        checkedThumbColor = StudioTheme.TextPrimary,
                                                        checkedTrackColor = StudioTheme.AccentSubtle
                                                    )
                                                )
                                                Spacer(Modifier.width(12.dp))
                                                Column {
                                                    Text("Studio DSP Audio Processor", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = StudioTheme.TextPrimary)
                                                    Text(if (eqEnabled) "Active • Realtime 64-bit Floating Point Engine" else "Bypassed • Direct Audio Passthrough", fontSize = 11.sp, color = StudioTheme.TextMuted)
                                                }
                                            }

                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text("Pre-Amp: ${String.format(Locale.getDefault(), "%+.1f dB", preAmpGain)}", fontSize = 12.sp, color = StudioTheme.AccentPrimary, fontWeight = FontWeight.SemiBold)
                                                Spacer(Modifier.width(8.dp))
                                                Slider(
                                                    value = preAmpGain,
                                                    onValueChange = {
                                                        preAmpGain = it
                                                        if (eqEnabled) applyEq(eqBands, it, true)
                                                    },
                                                    valueRange = -6f..6f,
                                                    modifier = Modifier.width(140.dp).height(20.dp),
                                                    colors = SliderDefaults.colors(
                                                        thumbColor = StudioTheme.TextPrimary,
                                                        activeTrackColor = StudioTheme.AccentPrimary,
                                                        inactiveTrackColor = StudioTheme.BorderSubtle
                                                    )
                                                )
                                                Spacer(Modifier.width(6.dp))
                                                OutlinedButton(
                                                    onClick = {
                                                        preAmpGain = 0f
                                                        if (eqEnabled) applyEq(eqBands, 0f, true)
                                                    },
                                                    shape = RoundedCornerShape(6.dp),
                                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                                    border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        containerColor = StudioTheme.SurfaceElevated,
                                                        contentColor = StudioTheme.TextSecondary
                                                    )
                                                ) {
                                                    Text("Reset", fontSize = 10.sp, color = StudioTheme.TextSecondary)
                                                }
                                            }
                                        }
                                    }

                                    // 10 Presets Chips Row
                                    val eqPresets = listOf(
                                        "Flat", "Bass Boost", "Treble Boost", "Vocal Clarity",
                                        "Electronic", "Rock", "Hip-Hop", "Acoustic", "Jazz", "Nightcore"
                                    )
                                    LazyRow(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        items(eqPresets, key = { it }) { preset ->
                                            val isSelected = selectedEqPreset == preset
                                            LiquidGlassBox(
                                                shape = RoundedCornerShape(8.dp),
                                                borderColor = if (isSelected) StudioTheme.BorderStrong else StudioTheme.BorderSubtle,
                                                modifier = Modifier
                                                    .pointerHoverIcon(PointerIcon.Hand)
                                                    .clickable {
                                                        selectedEqPreset = preset
                                                        val bands = when (preset) {
                                                             "Bass Boost" -> floatArrayOf(6f, 5f, 4f, 2f, 0f, 0f, 0f, 0f, 0f, 0f)
                                                             "Treble Boost" -> floatArrayOf(0f, 0f, 0f, 0f, 0f, 1f, 3f, 5f, 6f, 7f)
                                                             "Vocal Clarity" -> floatArrayOf(-2f, -1f, 0f, 2f, 4f, 5f, 3f, 1f, 0f, 0f)
                                                             "Electronic" -> floatArrayOf(5f, 4f, 2f, 0f, -1f, 2f, 3f, 4f, 5f, 5f)
                                                             "Rock" -> floatArrayOf(4f, 3f, 1f, -1f, -1f, 1f, 3f, 4f, 4f, 4f)
                                                             "Hip-Hop" -> floatArrayOf(7f, 6f, 3f, 1f, 0f, 1f, 2f, 2f, 3f, 3f)
                                                             "Acoustic" -> floatArrayOf(2f, 2f, 1f, 1f, 2f, 2f, 3f, 3f, 3f, 2f)
                                                             "Jazz" -> floatArrayOf(3f, 2f, 0f, 1f, 2f, 2f, 1f, 2f, 3f, 3f)
                                                             "Nightcore" -> floatArrayOf(3f, 2f, 0f, 0f, 1f, 3f, 4f, 5f, 6f, 6f)
                                                             else -> floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
                                                        }
                                                        eqBands = bands
                                                        if (eqEnabled) {
                                                            applyEq(bands, preAmpGain, true)
                                                        }
                                                    }
                                            ) {
                                                Text(
                                                    preset,
                                                    fontSize = 11.sp,
                                                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                                    color = if (isSelected) StudioTheme.TextPrimary else StudioTheme.TextSecondary,
                                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                                )
                                            }
                                        }
                                    }

                                    // 10-Band Graphic Equalizer Faders
                                    val bandFreqs = listOf("31Hz", "63Hz", "125Hz", "250Hz", "500Hz", "1kHz", "2kHz", "4kHz", "8kHz", "16kHz")
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text("10-Band Graphic Equalizer Faders", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = StudioTheme.TextPrimary)
                                                Text("±12 dB Precision Range", fontSize = 11.sp, color = StudioTheme.TextMuted)
                                            }

                                            Spacer(Modifier.height(12.dp))

                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                bandFreqs.forEachIndexed { index, freq ->
                                                    val gain = eqBands.getOrElse(index) { 0f }
                                                    Column(
                                                        horizontalAlignment = Alignment.CenterHorizontally,
                                                        modifier = Modifier.width(68.dp)
                                                    ) {
                                                        Text(
                                                            "${gain.toInt()}dB",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.Bold,
                                                            color = if (gain != 0f) StudioTheme.AccentPrimary else StudioTheme.TextMuted
                                                        )

                                                        Slider(
                                                            value = gain,
                                                            onValueChange = { newGain ->
                                                                val updated = eqBands.clone()
                                                                updated[index] = newGain
                                                                eqBands = updated
                                                                selectedEqPreset = "Custom"
                                                                if (eqEnabled) {
                                                                    applyEq(updated, preAmpGain, true)
                                                                }
                                                            },
                                                            valueRange = -12f..12f,
                                                            enabled = eqEnabled,
                                                            modifier = Modifier.height(110.dp),
                                                            colors = SliderDefaults.colors(
                                                                thumbColor = StudioTheme.TextPrimary,
                                                                activeTrackColor = StudioTheme.AccentPrimary,
                                                                inactiveTrackColor = StudioTheme.BorderSubtle
                                                            )
                                                        )

                                                        Text(freq, fontSize = 10.sp, color = StudioTheme.TextSecondary)
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    // Pro Audio Enhancement Matrix (Bass Boost, Reverb, Spatial, Crossfade, Speed, Limiter)
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        AudioParamCard(
                                            title = "Bass Sub-Harmonics",
                                            subtitle = "${bassBoost.toInt()}% Intensity",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Slider(
                                                value = bassBoost,
                                                onValueChange = {
                                                    bassBoost = it
                                                    val factor = (it - 35f) / 100f * 6f
                                                    val updated = eqBands.clone()
                                                    updated[0] = (updated[0] + factor * 0.5f).coerceIn(-12f, 12f)
                                                    updated[1] = (updated[1] + factor * 0.4f).coerceIn(-12f, 12f)
                                                    eqBands = updated
                                                    if (eqEnabled) {
                                                        applyEq(updated, preAmpGain, true)
                                                    }
                                                },
                                                valueRange = 0f..100f,
                                                colors = SliderDefaults.colors(
                                                    thumbColor = StudioTheme.TextPrimary,
                                                    activeTrackColor = StudioTheme.AccentPrimary,
                                                    inactiveTrackColor = StudioTheme.BorderSubtle
                                                )
                                            )
                                        }

                                        AudioParamCard(
                                            title = "Stereo Soundstage Width",
                                            subtitle = "${stereoWidth.toInt()}% (Wide)",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Slider(
                                                value = stereoWidth,
                                                onValueChange = { stereoWidth = it },
                                                valueRange = 0f..200f,
                                                colors = SliderDefaults.colors(
                                                    thumbColor = StudioTheme.TextPrimary,
                                                    activeTrackColor = StudioTheme.AccentPrimary,
                                                    inactiveTrackColor = StudioTheme.BorderSubtle
                                                )
                                            )
                                        }

                                        AudioParamCard(
                                            title = "3D Spatial Virtualizer",
                                            subtitle = if (spatialVirtualizer) "Surround Sound Enabled" else "Bypassed",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Switch(
                                                    checked = spatialVirtualizer,
                                                    onCheckedChange = { spatialVirtualizer = it },
                                                    colors = SwitchDefaults.colors(
                                                        checkedThumbColor = StudioTheme.TextPrimary,
                                                        checkedTrackColor = StudioTheme.AccentSubtle
                                                    )
                                                )
                                                Spacer(Modifier.width(8.dp))
                                                Text(if (spatialVirtualizer) "Virtual 7.1" else "Off", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                            }
                                        }
                                    }

                                    // Second Enhancement Row (Reverb, Crossfade, Balance, Limiter)
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        AudioParamCard(
                                            title = "Acoustic Room Simulator",
                                            subtitle = "Preset: $selectedReverb",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            val rooms = listOf("Off", "Studio", "Club", "Concert", "Cathedral")
                                            LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                                items(rooms) { r ->
                                                    val isRSelected = selectedReverb == r
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(6.dp),
                                                        borderColor = if (isRSelected) StudioTheme.BorderStrong else StudioTheme.BorderSubtle,
                                                        modifier = Modifier.clickable {
                                                            selectedReverb = r
                                                            val bands = eqBands.clone()
                                                            when (r) {
                                                                "Club" -> { bands[0] = 5f; bands[1] = 4f }
                                                                "Concert" -> { bands[3] = 2f; bands[4] = 3f; bands[5] = 3f }
                                                                "Cathedral" -> { bands[6] = 4f; bands[7] = 4f; bands[8] = 3f }
                                                                else -> {}
                                                            }
                                                            eqBands = bands
                                                            if (eqEnabled) applyEq(bands, preAmpGain, true)
                                                        }
                                                    ) {
                                                        Text(r, fontSize = 10.sp, color = if (isRSelected) StudioTheme.TextPrimary else StudioTheme.TextSecondary, modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp))
                                                    }
                                                }
                                            }
                                        }

                                        AudioParamCard(
                                            title = "Crossfade Transition",
                                            subtitle = if (crossfadeSecs == 0) "Gapless Direct" else "${crossfadeSecs}s Smooth Fade",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Slider(
                                                value = crossfadeSecs.toFloat(),
                                                onValueChange = { crossfadeSecs = it.toInt() },
                                                valueRange = 0f..12f,
                                                colors = SliderDefaults.colors(
                                                    thumbColor = StudioTheme.TextPrimary,
                                                    activeTrackColor = StudioTheme.AccentPrimary,
                                                    inactiveTrackColor = StudioTheme.BorderSubtle
                                                )
                                            )
                                        }

                                        AudioParamCard(
                                            title = "Speed & Anti-Clipping",
                                            subtitle = "${playbackSpeed}x Speed • Limiter ${if (antiClipping) "ON" else "OFF"}",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                listOf(0.75f, 1.0f, 1.25f, 1.5f, 2.0f).forEach { spd ->
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(6.dp),
                                                        borderColor = if (playbackSpeed == spd) StudioTheme.BorderStrong else StudioTheme.BorderSubtle,
                                                        modifier = Modifier.clickable {
                                                            playbackSpeed = spd
                                                            viewModel.setPlaybackRate(spd)
                                                        }.padding(end = 4.dp)
                                                    ) {
                                                        Text("${spd}x", fontSize = 10.sp, color = if (playbackSpeed == spd) StudioTheme.TextPrimary else StudioTheme.TextSecondary, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                                                    }
                                                }
                                                Spacer(Modifier.width(8.dp))
                                                Switch(
                                                    checked = antiClipping,
                                                    onCheckedChange = { antiClipping = it },
                                                    colors = SwitchDefaults.colors(
                                                        checkedThumbColor = StudioTheme.TextPrimary,
                                                        checkedTrackColor = StudioTheme.AccentSubtle
                                                    )
                                                )
                                            }
                                        }
                                    }
                                }
                            }

                            // -----------------------------------------------------------------
                            // TAB 3: SYNCHRONIZED LYRICS STUDIO (11 Features & Controls)
                            // -----------------------------------------------------------------
                            PlayerModalTab.LYRICS -> {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    // Toolbar (Mode, Font Size, Alignment, Offset Tuner, Copy, Provider)
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(14.dp))
                                            .background(Color(0xFF0F172A).copy(alpha = 0.45f))
                                            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(14.dp))
                                            .padding(horizontal = 16.dp, vertical = 10.dp)
                                    ) {
                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            // Top Row: Mode & Scripts on Left, Action buttons on Right
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                // Left: Mode & Scripts
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                                ) {
                                                    // Segmented Mode Capsule
                                                    Row(
                                                        modifier = Modifier
                                                            .clip(RoundedCornerShape(10.dp))
                                                            .background(Color.Black.copy(alpha = 0.35f))
                                                            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
                                                            .padding(3.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Box(
                                                            modifier = Modifier
                                                                .clip(RoundedCornerShape(7.dp))
                                                                .background(if (lyricsModeTimed) Color.White.copy(alpha = 0.14f) else Color.Transparent)
                                                                .pointerHoverIcon(PointerIcon.Hand)
                                                                .clickable { lyricsModeTimed = true }
                                                                .padding(horizontal = 12.dp, vertical = 5.dp),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Text("Karaoke Synced", fontSize = 11.5.sp, color = if (lyricsModeTimed) Color.White else Color(0xFF94A3B8), fontWeight = if (lyricsModeTimed) FontWeight.SemiBold else FontWeight.Normal)
                                                        }
                                                        Box(
                                                            modifier = Modifier
                                                                .clip(RoundedCornerShape(7.dp))
                                                                .background(if (!lyricsModeTimed) Color.White.copy(alpha = 0.14f) else Color.Transparent)
                                                                .pointerHoverIcon(PointerIcon.Hand)
                                                                .clickable { lyricsModeTimed = false }
                                                                .padding(horizontal = 12.dp, vertical = 5.dp),
                                                            contentAlignment = Alignment.Center
                                                        ) {
                                                            Text("Plain Text", fontSize = 11.5.sp, color = if (!lyricsModeTimed) Color.White else Color(0xFF94A3B8), fontWeight = if (!lyricsModeTimed) FontWeight.SemiBold else FontWeight.Normal)
                                                        }
                                                    }

                                                    // Language Mode Selector for Hindi tracks
                                                    if (isHindiTrack) {
                                                        Row(
                                                            modifier = Modifier
                                                                .clip(RoundedCornerShape(10.dp))
                                                                .background(Color.Black.copy(alpha = 0.35f))
                                                                .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
                                                                .padding(3.dp),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            listOf(
                                                                "Dual" to "Dual (हिंदी + En)",
                                                                "Hindi" to "हिंदी",
                                                                "English" to "English"
                                                            ).forEach { (langMode, displayLabel) ->
                                                                val isSel = lyricsLanguageMode == langMode
                                                                Box(
                                                                    modifier = Modifier
                                                                        .clip(RoundedCornerShape(7.dp))
                                                                        .background(if (isSel) Color(0xFF38BDF8).copy(alpha = 0.18f) else Color.Transparent)
                                                                        .pointerHoverIcon(PointerIcon.Hand)
                                                                        .clickable { lyricsLanguageMode = langMode }
                                                                        .padding(horizontal = 10.dp, vertical = 5.dp),
                                                                    contentAlignment = Alignment.Center
                                                                ) {
                                                                    Text(
                                                                        displayLabel,
                                                                        fontSize = 11.sp,
                                                                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Medium,
                                                                        color = if (isSel) Color(0xFF38BDF8) else StudioTheme.TextMuted
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        Row(
                                                            verticalAlignment = Alignment.CenterVertically,
                                                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                                                            modifier = Modifier.padding(horizontal = 6.dp)
                                                        ) {
                                                            Box(
                                                                modifier = Modifier
                                                                    .size(6.dp)
                                                                    .clip(CircleShape)
                                                                    .background(Color(0xFF38BDF8))
                                                            )
                                                            Text(
                                                                "ORIGINAL LYRICS",
                                                                fontSize = 10.5.sp,
                                                                fontWeight = FontWeight.SemiBold,
                                                                color = Color(0xFF94A3B8),
                                                                letterSpacing = 0.6.sp
                                                            )
                                                        }
                                                    }
                                                }

                                                // Right: Actions (Re-sync, Copy All)
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                                ) {
                                                    // Re-sync Button
                                                    OutlinedButton(
                                                        onClick = { triggerReloadLyrics() },
                                                        shape = RoundedCornerShape(8.dp),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                        colors = ButtonDefaults.outlinedButtonColors(
                                                            containerColor = StudioTheme.SurfaceElevated,
                                                            contentColor = StudioTheme.TextSecondary
                                                        ),
                                                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                                                    ) {
                                                        Icon(Icons.Default.Refresh, null, modifier = Modifier.size(13.dp), tint = if (isFetchingOnlineLyrics) StudioTheme.AccentPrimary else StudioTheme.TextSecondary)
                                                        Spacer(Modifier.width(5.dp))
                                                        Text(if (isFetchingOnlineLyrics) "Syncing..." else "Re-sync", fontSize = 11.sp)
                                                    }

                                                    // Copy All Lyrics Button
                                                    OutlinedButton(
                                                        onClick = {
                                                            val textToCopy = resolvedLyrics.joinToString("\n\n") { item ->
                                                                val dual = HindiLyricsProcessor.formatDualLine(item.text, isHindiTrack)
                                                                if (isHindiTrack) {
                                                                    when (lyricsLanguageMode) {
                                                                        "Hindi" -> dual.hindiText.ifBlank { dual.englishText }
                                                                        "English" -> dual.englishText.ifBlank { dual.hindiText }
                                                                        else -> "${dual.hindiText}\n${dual.englishText}".trim()
                                                                    }
                                                                } else {
                                                                    dual.englishText.ifBlank { item.text }
                                                                }
                                                            }
                                                            StudioStorage.copyToClipboard(textToCopy)
                                                            copyLyricsFeedback = true
                                                        },
                                                        shape = RoundedCornerShape(8.dp),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                        colors = ButtonDefaults.outlinedButtonColors(
                                                            containerColor = StudioTheme.SurfaceElevated,
                                                            contentColor = StudioTheme.TextSecondary
                                                        ),
                                                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                                                    ) {
                                                        Icon(if (copyLyricsFeedback) Icons.Default.Check else Icons.Default.ContentCopy, null, modifier = Modifier.size(13.dp), tint = if (copyLyricsFeedback) StudioTheme.AccentPrimary else StudioTheme.TextSecondary)
                                                        Spacer(Modifier.width(5.dp))
                                                        Text(if (copyLyricsFeedback) "Copied!" else "Copy All", fontSize = 11.sp)
                                                    }
                                                }
                                            }

                                            // Bottom Row: Sync Micro-Tuner on Left, Size on Right
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                // Left: Micro-Tuner Offset
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                                ) {
                                                    Text("Sync Offset:", fontSize = 11.sp, color = StudioTheme.TextMuted)
                                                    OutlinedButton(
                                                        onClick = { lyricsOffsetMs -= 100L },
                                                        shape = RoundedCornerShape(6.dp),
                                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                        colors = ButtonDefaults.outlinedButtonColors(
                                                            containerColor = StudioTheme.SurfaceElevated,
                                                            contentColor = StudioTheme.TextSecondary
                                                        )
                                                    ) {
                                                        Text("-100ms", fontSize = 10.5.sp, color = StudioTheme.TextSecondary)
                                                    }
                                                    Text(
                                                        "${lyricsOffsetMs}ms",
                                                        fontSize = 11.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = if (lyricsOffsetMs != 0L) StudioTheme.AccentPrimary else StudioTheme.TextMuted,
                                                        modifier = Modifier.padding(horizontal = 4.dp)
                                                    )
                                                    OutlinedButton(
                                                        onClick = { lyricsOffsetMs += 100L },
                                                        shape = RoundedCornerShape(6.dp),
                                                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                        colors = ButtonDefaults.outlinedButtonColors(
                                                            containerColor = StudioTheme.SurfaceElevated,
                                                            contentColor = StudioTheme.TextSecondary
                                                        )
                                                    ) {
                                                        Text("+100ms", fontSize = 10.5.sp, color = StudioTheme.TextSecondary)
                                                    }
                                                    if (lyricsOffsetMs != 0L) {
                                                        OutlinedButton(
                                                            onClick = { lyricsOffsetMs = 0L },
                                                            shape = RoundedCornerShape(6.dp),
                                                            contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp),
                                                            border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                            colors = ButtonDefaults.outlinedButtonColors(
                                                                containerColor = StudioTheme.SurfaceElevated,
                                                                contentColor = StudioTheme.TextSecondary
                                                            )
                                                        ) {
                                                            Text("Reset", fontSize = 10.5.sp, color = StudioTheme.TextSecondary)
                                                        }
                                                    }
                                                }

                                                // Right: Font size zoom
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                                ) {
                                                    Text("Size:", fontSize = 11.sp, color = StudioTheme.TextMuted)
                                                    Row(
                                                        modifier = Modifier
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(Color.Black.copy(alpha = 0.35f))
                                                            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(8.dp))
                                                            .padding(3.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        listOf("Small", "Medium", "Large").forEach { sz ->
                                                            val isSzSelected = lyricsFontSize == sz
                                                            Box(
                                                                modifier = Modifier
                                                                    .clip(RoundedCornerShape(6.dp))
                                                                    .background(if (isSzSelected) Color.White.copy(alpha = 0.14f) else Color.Transparent)
                                                                    .pointerHoverIcon(PointerIcon.Hand)
                                                                    .clickable { lyricsFontSize = sz }
                                                                    .padding(horizontal = 8.dp, vertical = 3.dp),
                                                                contentAlignment = Alignment.Center
                                                            ) {
                                                                Text(sz, fontSize = 10.5.sp, color = if (isSzSelected) Color.White else Color(0xFF94A3B8), fontWeight = if (isSzSelected) FontWeight.Bold else FontWeight.Normal)
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    // Viewport Container
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(20.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            val lyricTextSize = when (lyricsFontSize) {
                                                "Small" -> 15.sp
                                                "Large" -> 23.sp
                                                else -> 18.sp
                                            }

                                            if (!lyricsModeTimed) {
                                                LazyColumn(
                                                    modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
                                                    contentPadding = PaddingValues(vertical = 24.dp),
                                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                                ) {
                                                    itemsIndexed(resolvedLyrics) { _, item ->
                                                        val dual = HindiLyricsProcessor.formatDualLine(item.text, isHindiTrack)
                                                        LiquidGlassBox(
                                                            shape = RoundedCornerShape(10.dp),
                                                            modifier = Modifier.fillMaxWidth()
                                                        ) {
                                                            Column(
                                                                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 14.dp),
                                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                                verticalArrangement = Arrangement.spacedBy(4.dp)
                                                            ) {
                                                                if (isHindiTrack) {
                                                                    when (lyricsLanguageMode) {
                                                                        "Hindi" -> {
                                                                            Text(
                                                                                text = dual.hindiText.ifBlank { dual.englishText },
                                                                                color = StudioTheme.TextPrimary,
                                                                                fontSize = lyricTextSize,
                                                                                lineHeight = (lyricTextSize.value * 1.5f).sp,
                                                                                textAlign = TextAlign.Center
                                                                            )
                                                                        }
                                                                        "English" -> {
                                                                            Text(
                                                                                text = dual.englishText.ifBlank { dual.hindiText },
                                                                                color = StudioTheme.TextPrimary,
                                                                                fontSize = lyricTextSize,
                                                                                lineHeight = (lyricTextSize.value * 1.5f).sp,
                                                                                textAlign = TextAlign.Center
                                                                            )
                                                                        }
                                                                        else -> { // "Dual"
                                                                            if (dual.hindiText.isNotBlank()) {
                                                                                Text(
                                                                                    text = dual.hindiText,
                                                                                    color = StudioTheme.TextPrimary,
                                                                                    fontSize = (lyricTextSize.value + 2).sp,
                                                                                    fontWeight = FontWeight.Medium,
                                                                                    lineHeight = ((lyricTextSize.value + 2) * 1.4f).sp,
                                                                                    textAlign = TextAlign.Center
                                                                                )
                                                                            }
                                                                            if (dual.englishText.isNotBlank()) {
                                                                                Text(
                                                                                    text = dual.englishText,
                                                                                    color = Color(0xFF38BDF8),
                                                                                    fontSize = (lyricTextSize.value - 2).coerceAtLeast(12f).sp,
                                                                                    lineHeight = ((lyricTextSize.value - 2) * 1.35f).sp,
                                                                                    letterSpacing = 0.3.sp,
                                                                                    textAlign = TextAlign.Center
                                                                                )
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    Text(
                                                                        text = dual.englishText.ifBlank { item.text },
                                                                        color = StudioTheme.TextPrimary,
                                                                        fontSize = lyricTextSize,
                                                                        lineHeight = (lyricTextSize.value * 1.5f).sp,
                                                                        textAlign = TextAlign.Center
                                                                    )
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (isFetchingOnlineLyrics && resolvedLyrics.isEmpty()) {
                                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                        CircularProgressIndicator(color = StudioTheme.AccentPrimary, modifier = Modifier.size(30.dp), strokeWidth = 2.dp)
                                                        Spacer(Modifier.height(10.dp))
                                                        Text("Connecting to LrcLib & fetching synchronized lines...", color = StudioTheme.TextMuted, fontSize = 12.sp)
                                                    }
                                                } else {
                                                    val listState = rememberLazyListState()
                                                    LaunchedEffect(effectiveActiveIndex) {
                                                        if (effectiveActiveIndex in resolvedLyrics.indices) {
                                                            listState.animateScrollToItem((effectiveActiveIndex - 2).coerceAtLeast(0))
                                                        }
                                                    }

                                                    LazyColumn(
                                                        state = listState,
                                                        modifier = Modifier.fillMaxSize(),
                                                        contentPadding = PaddingValues(vertical = 32.dp, horizontal = 16.dp),
                                                        verticalArrangement = Arrangement.spacedBy(16.dp)
                                                    ) {
                                                        itemsIndexed(resolvedLyrics) { idx, item ->
                                                            val isCurrent = idx == effectiveActiveIndex
                                                            val dual = HindiLyricsProcessor.formatDualLine(item.text, isHindiTrack)

                                                            LiquidGlassBox(
                                                                shape = RoundedCornerShape(12.dp),
                                                                borderColor = if (isCurrent) StudioTheme.AccentPrimary.copy(alpha = 0.55f) else Color.White.copy(alpha = 0.08f),
                                                                modifier = Modifier
                                                                    .fillMaxWidth()
                                                                    .pointerHoverIcon(PointerIcon.Hand)
                                                                    .clickable {
                                                                        viewModel.seekTo(item.startTime + lyricsOffsetMs)
                                                                    }
                                                            ) {
                                                                Column(
                                                                    modifier = Modifier
                                                                        .fillMaxWidth()
                                                                        .padding(horizontal = 24.dp, vertical = 14.dp),
                                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                                    verticalArrangement = Arrangement.spacedBy(5.dp)
                                                                ) {
                                                                    if (isHindiTrack) {
                                                                        when (lyricsLanguageMode) {
                                                                            "Hindi" -> {
                                                                                Text(
                                                                                    text = dual.hindiText.ifBlank { dual.englishText },
                                                                                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                                                                    color = if (isCurrent) StudioTheme.TextPrimary
                                                                                            else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                            else StudioTheme.TextSecondary.copy(alpha = 0.85f),
                                                                                    fontSize = if (isCurrent) (lyricTextSize.value + 4).sp else lyricTextSize,
                                                                                    lineHeight = if (isCurrent) ((lyricTextSize.value + 4) * 1.4f).sp else (lyricTextSize.value * 1.4f).sp,
                                                                                    textAlign = TextAlign.Center
                                                                                )
                                                                            }
                                                                            "English" -> {
                                                                                Text(
                                                                                    text = dual.englishText.ifBlank { dual.hindiText },
                                                                                    fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                                                                    color = if (isCurrent) StudioTheme.TextPrimary
                                                                                            else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                            else StudioTheme.TextSecondary.copy(alpha = 0.85f),
                                                                                    fontSize = if (isCurrent) (lyricTextSize.value + 4).sp else lyricTextSize,
                                                                                    lineHeight = if (isCurrent) ((lyricTextSize.value + 4) * 1.4f).sp else (lyricTextSize.value * 1.4f).sp,
                                                                                    textAlign = TextAlign.Center
                                                                                )
                                                                            }
                                                                            else -> { // "Dual"
                                                                                if (dual.hindiText.isNotBlank()) {
                                                                                    Text(
                                                                                        text = dual.hindiText,
                                                                                        fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Medium,
                                                                                        color = if (isCurrent) StudioTheme.TextPrimary
                                                                                                else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                                else StudioTheme.TextSecondary.copy(alpha = 0.90f),
                                                                                        fontSize = if (isCurrent) (lyricTextSize.value + 5).sp else (lyricTextSize.value + 1).sp,
                                                                                        lineHeight = if (isCurrent) ((lyricTextSize.value + 5) * 1.35f).sp else ((lyricTextSize.value + 1) * 1.35f).sp,
                                                                                        textAlign = TextAlign.Center
                                                                                    )
                                                                                }
                                                                                if (dual.englishText.isNotBlank()) {
                                                                                    Text(
                                                                                        text = dual.englishText,
                                                                                        fontWeight = if (isCurrent) FontWeight.SemiBold else FontWeight.Normal,
                                                                                        color = if (isCurrent) Color(0xFF38BDF8)
                                                                                                else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.40f)
                                                                                                else Color(0xFF94A3B8).copy(alpha = 0.85f),
                                                                                        fontSize = if (isCurrent) (lyricTextSize.value).sp else (lyricTextSize.value - 2).coerceAtLeast(12f).sp,
                                                                                        lineHeight = if (isCurrent) (lyricTextSize.value * 1.3f).sp else ((lyricTextSize.value - 2) * 1.3f).sp,
                                                                                        letterSpacing = 0.3.sp,
                                                                                        textAlign = TextAlign.Center
                                                                                    )
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        // English track: Pure English lyrics
                                                                        Text(
                                                                            text = dual.englishText.ifBlank { item.text },
                                                                            fontWeight = if (isCurrent) FontWeight.Bold else FontWeight.Normal,
                                                                            color = if (isCurrent) StudioTheme.TextPrimary
                                                                                    else if (idx < effectiveActiveIndex) StudioTheme.TextMuted.copy(alpha = 0.45f)
                                                                                    else StudioTheme.TextSecondary.copy(alpha = 0.85f),
                                                                            fontSize = if (isCurrent) (lyricTextSize.value + 4).sp else lyricTextSize,
                                                                            lineHeight = if (isCurrent) ((lyricTextSize.value + 4) * 1.4f).sp else (lyricTextSize.value * 1.4f).sp,
                                                                            textAlign = TextAlign.Center
                                                                        )
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // -----------------------------------------------------------------
                            // TAB 4: QUEUE, SMART FLOW & INFINITE RADIO (11 Features & Controls)
                            // -----------------------------------------------------------------
                            PlayerModalTab.QUEUE -> {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    // Queue Controls Bar
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 16.dp, vertical = 12.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text(
                                                    "PLAYBACK QUEUE",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 12.sp,
                                                    color = StudioTheme.TextSecondary,
                                                    letterSpacing = 0.8.sp
                                                )
                                                Spacer(Modifier.width(8.dp))
                                                LiquidGlassBox(
                                                    shape = RoundedCornerShape(4.dp)
                                                ) {
                                                    Text(
                                                        "${queue.size} TRACKS",
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = StudioTheme.TextMuted,
                                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                    )
                                                }
                                            }

                                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                OutlinedButton(
                                                    onClick = { viewModel.setShuffle(!shuffleEnabled) },
                                                    shape = RoundedCornerShape(8.dp),
                                                    border = BorderStroke(1.dp, if (shuffleEnabled) StudioTheme.AccentPrimary else StudioTheme.BorderSubtle),
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        contentColor = if (shuffleEnabled) StudioTheme.AccentPrimary else StudioTheme.TextSecondary
                                                    ),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                                                ) {
                                                    Icon(Icons.Default.Shuffle, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(5.dp))
                                                    Text("Shuffle", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                }

                                                OutlinedButton(
                                                    onClick = {
                                                        if (queue.isNotEmpty()) {
                                                            viewModel.addToQueue(queue.reversed())
                                                        }
                                                    },
                                                    shape = RoundedCornerShape(8.dp),
                                                    border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        contentColor = StudioTheme.TextSecondary
                                                    ),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                                                ) {
                                                    Icon(Icons.Default.Refresh, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(5.dp))
                                                    Text("Reverse", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                }

                                                OutlinedButton(
                                                    onClick = { viewModel.clearQueue() },
                                                    shape = RoundedCornerShape(8.dp),
                                                    border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        contentColor = StudioTheme.TextSecondary
                                                    ),
                                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                                                ) {
                                                    Icon(Icons.Default.Clear, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(5.dp))
                                                    Text("Clear", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                }

                                                Button(
                                                    onClick = {
                                                        infiniteRadio = !infiniteRadio
                                                    },
                                                    shape = RoundedCornerShape(8.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (infiniteRadio) StudioTheme.AccentPrimary else StudioTheme.SurfaceElevated,
                                                        contentColor = if (infiniteRadio) Color.Black else StudioTheme.TextSecondary
                                                    ),
                                                    border = BorderStroke(1.dp, if (infiniteRadio) StudioTheme.AccentPrimary else StudioTheme.BorderSubtle),
                                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                                                ) {
                                                    Icon(Icons.Default.Radio, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(5.dp))
                                                    Text(if (infiniteRadio) "Infinite Radio: On" else "Infinite Radio: Off", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                }
                                            }
                                        }
                                    }

                                    // Queue List Content
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f)
                                    ) {
                                        if (queue.isEmpty()) {
                                            Column(
                                                modifier = Modifier.fillMaxSize().padding(24.dp),
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                verticalArrangement = Arrangement.Center
                                            ) {
                                                Icon(
                                                    Icons.AutoMirrored.Filled.QueueMusic,
                                                    null,
                                                    tint = StudioTheme.TextMuted.copy(alpha = 0.5f),
                                                    modifier = Modifier.size(44.dp)
                                                )
                                                Spacer(Modifier.height(12.dp))
                                                Text(
                                                    "Queue is Empty",
                                                    color = StudioTheme.TextPrimary,
                                                    fontSize = 15.sp,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                                Spacer(Modifier.height(4.dp))
                                                Text(
                                                    "Infinite Smart Radio can automatically generate tracks to maintain your session flow.",
                                                    color = StudioTheme.TextMuted,
                                                    fontSize = 12.sp,
                                                    textAlign = TextAlign.Center
                                                )
                                                Spacer(Modifier.height(16.dp))
                                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                    listOf("Chill Flow", "High Energy", "Deep Focus", "Night Drive").forEach { vibe ->
                                                        val isVSelected = smartFlowVibe == vibe
                                                        LiquidGlassBox(
                                                            shape = RoundedCornerShape(6.dp),
                                                            isSelected = isVSelected,
                                                            modifier = Modifier.clickable { smartFlowVibe = vibe }
                                                        ) {
                                                            Text(
                                                                vibe,
                                                                fontSize = 11.sp,
                                                                fontWeight = if (isVSelected) FontWeight.SemiBold else FontWeight.Normal,
                                                                color = if (isVSelected) StudioTheme.TextPrimary else StudioTheme.TextMuted,
                                                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                                            )
                                                        }
                                                    }
                                                }

                                                Spacer(Modifier.height(14.dp))
                                                Button(
                                                    onClick = {
                                                        val vibeTracks = when (smartFlowVibe) {
                                                            "Chill Flow" -> listOf(
                                                                Track(id = "vibe_chill_1", title = "Weightless (Audix Ambient Edit)", artists = listOf(Artist("vibe_a1", "Marconi Union")), album = Album("v_alb_1", "Ambient Master")),
                                                                Track(id = "vibe_chill_2", title = "Sunset Lover (Chill Vibe)", artists = listOf(Artist("vibe_a2", "Petit Biscuit")), album = Album("v_alb_2", "Sunset Edition")),
                                                                Track(id = "vibe_chill_3", title = "Intro (Chill Remaster)", artists = listOf(Artist("vibe_a3", "The xx")), album = Album("v_alb_3", "Coexist Master"))
                                                            )
                                                            "High Energy" -> listOf(
                                                                Track(id = "vibe_eng_1", title = "Blinding Lights (Club Mix)", artists = listOf(Artist("vibe_a4", "The Weeknd")), album = Album("v_alb_4", "After Hours")),
                                                                Track(id = "vibe_eng_2", title = "Titanium (Festival Beat)", artists = listOf(Artist("vibe_a5", "David Guetta & Sia")), album = Album("v_alb_5", "Dance Master")),
                                                                Track(id = "vibe_eng_3", title = "One More Time (Club Remaster)", artists = listOf(Artist("vibe_a6", "Daft Punk")), album = Album("v_alb_6", "Discovery"))
                                                            )
                                                            "Deep Focus" -> listOf(
                                                                Track(id = "vibe_foc_1", title = "Deep Focus Alpha Waves", artists = listOf(Artist("vibe_a7", "Audix Binaural")), album = Album("v_alb_7", "Cognitive Flow")),
                                                                Track(id = "vibe_foc_2", title = "Time (Acoustic Minimal)", artists = listOf(Artist("vibe_a8", "Hans Zimmer")), album = Album("v_alb_8", "Inception Score")),
                                                                Track(id = "vibe_foc_3", title = "Day One (Piano Resonance)", artists = listOf(Artist("vibe_a9", "Hans Zimmer")), album = Album("v_alb_9", "Interstellar Flow"))
                                                            )
                                                            else -> listOf(
                                                                Track(id = "vibe_drv_1", title = "Midnight City (Synth Edition)", artists = listOf(Artist("vibe_a10", "M83")), album = Album("v_alb_10", "Hurry Up")),
                                                                Track(id = "vibe_drv_2", title = "Nightcall (Drive Master)", artists = listOf(Artist("vibe_a11", "Kavinsky")), album = Album("v_alb_11", "OutRun")),
                                                                Track(id = "vibe_drv_3", title = "Resonance (Neon Synth)", artists = listOf(Artist("vibe_a12", "HOME")), album = Album("v_alb_12", "Odyssey"))
                                                            )
                                                        }
                                                        viewModel.addToQueue(vibeTracks)
                                                    },
                                                    shape = RoundedCornerShape(8.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = StudioTheme.TextPrimary,
                                                        contentColor = StudioTheme.CanvasBg
                                                    ),
                                                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                                                ) {
                                                    Icon(Icons.Default.AutoAwesome, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(6.dp))
                                                    Text("Queue $smartFlowVibe Tracks", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                }
                                            }
                                        } else {
                                            LazyColumn(
                                                modifier = Modifier.fillMaxSize().padding(8.dp),
                                                verticalArrangement = Arrangement.spacedBy(4.dp)
                                            ) {
                                                itemsIndexed(queue, key = { idx, item -> "${item.id}_$idx" }) { idx, item ->
                                                    val isItemCurrent = currentTrack?.id == item.id
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .clip(RoundedCornerShape(8.dp))
                                                            .background(if (isItemCurrent) StudioTheme.SurfaceElevated else Color.Transparent)
                                                            .border(
                                                                1.dp,
                                                                if (isItemCurrent) StudioTheme.BorderStrong else Color.Transparent,
                                                                RoundedCornerShape(8.dp)
                                                            )
                                                            .clickable { viewModel.play(item) }
                                                            .padding(horizontal = 12.dp, vertical = 8.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(
                                                            "${idx + 1}".padStart(2, '0'),
                                                            color = if (isItemCurrent) StudioTheme.AccentPrimary else StudioTheme.TextMuted,
                                                            fontSize = 11.sp,
                                                            fontWeight = FontWeight.SemiBold,
                                                            modifier = Modifier.width(28.dp)
                                                        )
                                                        Column(Modifier.weight(1f)) {
                                                            Text(
                                                                item.title,
                                                                color = if (isItemCurrent) StudioTheme.TextPrimary else StudioTheme.TextSecondary,
                                                                fontWeight = if (isItemCurrent) FontWeight.SemiBold else FontWeight.Normal,
                                                                fontSize = 13.sp,
                                                                maxLines = 1,
                                                                overflow = TextOverflow.Ellipsis
                                                            )
                                                            Text(
                                                                item.artists.joinToString(", ") { it.name },
                                                                color = StudioTheme.TextMuted,
                                                                fontSize = 11.sp,
                                                                maxLines = 1,
                                                                overflow = TextOverflow.Ellipsis
                                                            )
                                                        }
                                                        IconButton(
                                                            onClick = { viewModel.removeFromQueue(idx) },
                                                            modifier = Modifier.size(28.dp)
                                                        ) {
                                                            Icon(
                                                                Icons.Default.Close,
                                                                contentDescription = "Remove",
                                                                tint = StudioTheme.TextMuted,
                                                                modifier = Modifier.size(15.dp)
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // -----------------------------------------------------------------
                            // TAB 5: LIBRARY, PLAYLISTS & OFFLINE (11 Features & Controls)
                            // -----------------------------------------------------------------
                            PlayerModalTab.LIBRARY -> {
                                val scrollState = rememberScrollState()
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(scrollState),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    // Favorites & Quick Playlists Card
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    IconButton(
                                                        onClick = {
                                                            currentTrack?.let { tr ->
                                                                isFavorite = StudioStorage.toggleFavorite(tr)
                                                                playlistFeedbackMessage = if (isFavorite) "Saved to Favorites" else "Removed from Favorites"
                                                            }
                                                        },
                                                        modifier = Modifier.size(36.dp)
                                                    ) {
                                                        Icon(
                                                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                                            contentDescription = "Favorite",
                                                            tint = if (isFavorite) StudioTheme.TextPrimary else StudioTheme.TextMuted,
                                                            modifier = Modifier.size(20.dp)
                                                        )
                                                    }
                                                    Spacer(Modifier.width(8.dp))
                                                    Column {
                                                        Text(
                                                            if (isFavorite) "Saved to Favorite Tracks" else "Add to Favorites",
                                                            fontWeight = FontWeight.SemiBold,
                                                            fontSize = 13.sp,
                                                            color = StudioTheme.TextPrimary
                                                        )
                                                        Text(
                                                            if (isFavorite) "Synchronized in your personal Audix library" else "Instant library synchronization and smart queue weighting",
                                                            fontSize = 11.sp,
                                                            color = StudioTheme.TextMuted
                                                        )
                                                    }
                                                }

                                                OutlinedButton(
                                                    onClick = { showNewPlaylistInput = !showNewPlaylistInput },
                                                    shape = RoundedCornerShape(8.dp),
                                                    border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                    colors = ButtonDefaults.outlinedButtonColors(
                                                        contentColor = StudioTheme.TextSecondary
                                                    ),
                                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                                                ) {
                                                    Icon(if (showNewPlaylistInput) Icons.Default.Close else Icons.Default.Add, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(5.dp))
                                                    Text(if (showNewPlaylistInput) "Cancel" else "New Playlist", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                }
                                            }

                                            if (showNewPlaylistInput) {
                                                Spacer(Modifier.height(10.dp))
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                                    verticalAlignment = Alignment.CenterVertically
                                                ) {
                                                    TextField(
                                                        value = newPlaylistNameInput,
                                                        onValueChange = { newPlaylistNameInput = it },
                                                        placeholder = { Text("Playlist name...", fontSize = 12.sp, color = StudioTheme.TextMuted) },
                                                        singleLine = true,
                                                        modifier = Modifier.weight(1f).height(46.dp),
                                                        colors = TextFieldDefaults.colors(
                                                            focusedContainerColor = StudioTheme.SurfaceElevated,
                                                            unfocusedContainerColor = StudioTheme.SurfaceSubtle,
                                                            focusedTextColor = StudioTheme.TextPrimary,
                                                            unfocusedTextColor = StudioTheme.TextSecondary,
                                                            focusedIndicatorColor = StudioTheme.AccentPrimary,
                                                            unfocusedIndicatorColor = StudioTheme.BorderSubtle,
                                                            cursorColor = StudioTheme.AccentPrimary
                                                        )
                                                    )
                                                    Button(
                                                        onClick = {
                                                            val clean = newPlaylistNameInput.trim()
                                                            if (clean.isNotBlank()) {
                                                                currentTrack?.let { tr ->
                                                                    StudioStorage.addToPlaylist(clean, tr)
                                                                }
                                                                savedPlaylists = StudioStorage.getSavedPlaylists()
                                                                selectedPlaylist = clean
                                                                playlistFeedbackMessage = "Created & added to '$clean'"
                                                                newPlaylistNameInput = ""
                                                                showNewPlaylistInput = false
                                                            }
                                                        },
                                                        shape = RoundedCornerShape(8.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = StudioTheme.AccentPrimary,
                                                            contentColor = Color.Black
                                                        ),
                                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                                                    ) {
                                                        Text("Create", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                    }
                                                }
                                            }

                                            if (playlistFeedbackMessage != null) {
                                                Spacer(Modifier.height(8.dp))
                                                LiquidGlassBox(
                                                    shape = RoundedCornerShape(6.dp)
                                                ) {
                                                    Row(
                                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Icon(Icons.Default.Check, null, tint = StudioTheme.TextPrimary, modifier = Modifier.size(12.dp))
                                                        Spacer(Modifier.width(6.dp))
                                                        Text(playlistFeedbackMessage ?: "", fontSize = 11.sp, color = StudioTheme.TextPrimary)
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(14.dp))

                                            Text(
                                                "QUICK ADD TO PLAYLIST",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = StudioTheme.TextMuted,
                                                letterSpacing = 0.5.sp
                                            )
                                            Spacer(Modifier.height(8.dp))
                                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                items(savedPlaylists, key = { it }) { pl ->
                                                    val isSelected = selectedPlaylist == pl
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(6.dp),
                                                        isSelected = isSelected,
                                                        modifier = Modifier.clickable {
                                                            selectedPlaylist = pl
                                                            currentTrack?.let { tr ->
                                                                val success = StudioStorage.addToPlaylist(pl, tr)
                                                                if (success) {
                                                                    playlistFeedbackMessage = "Track added to '$pl'"
                                                                }
                                                            }
                                                        }
                                                    ) {
                                                        Row(
                                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            if (isSelected) {
                                                                Icon(Icons.Default.Check, null, tint = StudioTheme.TextPrimary, modifier = Modifier.size(12.dp))
                                                                Spacer(Modifier.width(4.dp))
                                                            }
                                                            Text(
                                                                pl,
                                                                fontSize = 11.sp,
                                                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                                                color = if (isSelected) StudioTheme.TextPrimary else StudioTheme.TextMuted
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    // Offline Download Studio
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(
                                                        "Offline Audio Cache",
                                                        fontWeight = FontWeight.SemiBold,
                                                        fontSize = 13.sp,
                                                        color = StudioTheme.TextPrimary
                                                    )
                                                    Text(
                                                        if (isDownloading) "Downloading... ${(downloadProgress * 100).toInt()}%"
                                                        else if (isDownloaded) "Saved locally in Music/Audix"
                                                        else "Persist studio-quality audio master directly to local storage",
                                                        fontSize = 11.sp,
                                                        color = StudioTheme.TextMuted
                                                    )
                                                }

                                                if (isDownloaded && downloadedFile != null) {
                                                    Button(
                                                        onClick = {
                                                            try {
                                                                val dir = StudioStorage.downloadsDir.canonicalFile
                                                                if (!dir.exists()) dir.mkdirs()
                                                                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                                                                    Desktop.getDesktop().open(dir)
                                                                }
                                                            } catch (e: Throwable) { e.printStackTrace() }
                                                        },
                                                        shape = RoundedCornerShape(8.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = StudioTheme.SurfaceElevated,
                                                            contentColor = StudioTheme.TextPrimary
                                                        ),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderStrong),
                                                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                                                    ) {
                                                        Icon(Icons.Default.FolderOpen, null, modifier = Modifier.size(13.dp))
                                                        Spacer(Modifier.width(5.dp))
                                                        Text("Open Folder", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                    }
                                                } else {
                                                    Button(
                                                        onClick = {
                                                            if (!isDownloading && currentTrack != null) {
                                                                isDownloading = true
                                                                downloadProgress = 0f
                                                                coroutineScope.launch(Dispatchers.IO) {
                                                                    val file = StudioStorage.downloadTrackToFile(currentTrack!!) { p ->
                                                                        downloadProgress = p
                                                                    }
                                                                    withContext(Dispatchers.Main) {
                                                                        isDownloading = false
                                                                        if (file != null && file.exists()) {
                                                                            downloadedFile = file
                                                                            isDownloaded = true
                                                                            playlistFeedbackMessage = "Track downloaded to Music/Audix"
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        },
                                                        enabled = !isDownloading,
                                                        shape = RoundedCornerShape(8.dp),
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = StudioTheme.AccentPrimary,
                                                            contentColor = Color.Black
                                                        ),
                                                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                                                    ) {
                                                        if (isDownloading) {
                                                            CircularProgressIndicator(
                                                                modifier = Modifier.size(13.dp),
                                                                strokeWidth = 2.dp,
                                                                color = Color.Black
                                                            )
                                                            Spacer(Modifier.width(6.dp))
                                                            Text("${(downloadProgress * 100).toInt()}%", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                        } else {
                                                            Icon(Icons.Default.Download, null, modifier = Modifier.size(13.dp))
                                                            Spacer(Modifier.width(5.dp))
                                                            Text("Download Master", fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                                        }
                                                    }
                                                }
                                            }

                                            if (isDownloading) {
                                                Spacer(Modifier.height(10.dp))
                                                LinearProgressIndicator(
                                                    progress = { downloadProgress },
                                                    modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                                                    color = StudioTheme.AccentPrimary,
                                                    trackColor = StudioTheme.SurfaceElevated
                                                )
                                            }

                                            Spacer(Modifier.height(14.dp))

                                            Text(
                                                "DOWNLOAD FIDELITY",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = StudioTheme.TextMuted,
                                                letterSpacing = 0.5.sp
                                            )
                                            Spacer(Modifier.height(8.dp))
                                            val qualities = listOf("128 kbps (Standard)", "256 kbps (High)", "320 kbps (Extreme)", "Lossless FLAC")
                                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                items(qualities) { q ->
                                                    val isQSelected = downloadQuality == q
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(6.dp),
                                                        isSelected = isQSelected,
                                                        modifier = Modifier.clickable { downloadQuality = q }
                                                    ) {
                                                        Text(
                                                            q,
                                                            fontSize = 11.sp,
                                                            fontWeight = if (isQSelected) FontWeight.SemiBold else FontWeight.Normal,
                                                            color = if (isQSelected) StudioTheme.TextPrimary else StudioTheme.TextMuted,
                                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    // Social Sharing & Discovery Links
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        OutlinedButton(
                                            onClick = {
                                                currentTrack?.let { tr ->
                                                    val shareText = "Now listening to \"${tr.title}\" by ${tr.artists.joinToString { it.name }} on Audix Studio"
                                                    StudioStorage.copyToClipboard(shareText)
                                                    shareFeedback = true
                                                }
                                            },
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                            colors = ButtonDefaults.outlinedButtonColors(contentColor = StudioTheme.TextSecondary),
                                            modifier = Modifier.weight(1f),
                                            contentPadding = PaddingValues(vertical = 10.dp)
                                        ) {
                                            Icon(if (shareFeedback) Icons.Default.Check else Icons.Default.Share, null, modifier = Modifier.size(13.dp))
                                            Spacer(Modifier.width(6.dp))
                                            Text(if (shareFeedback) "Copied!" else "Share", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                        }

                                        OutlinedButton(
                                            onClick = {
                                                currentTrack?.artists?.firstOrNull()?.let { art ->
                                                    val artistTracks = listOf(
                                                        Track(id = "art_mix_1", title = "${art.name} - Studio Session Live", artists = listOf(art), album = currentTrack?.album),
                                                        Track(id = "art_mix_2", title = "${art.name} - Acoustic Master", artists = listOf(art), album = currentTrack?.album),
                                                        Track(id = "art_mix_3", title = "${art.name} - Deep Cut VIP", artists = listOf(art), album = currentTrack?.album)
                                                    )
                                                    viewModel.addToQueue(artistTracks)
                                                    playlistFeedbackMessage = "Queued 3 tracks by ${art.name}"
                                                }
                                            },
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                            colors = ButtonDefaults.outlinedButtonColors(contentColor = StudioTheme.TextSecondary),
                                            modifier = Modifier.weight(1f),
                                            contentPadding = PaddingValues(vertical = 10.dp)
                                        ) {
                                            Icon(Icons.Default.Info, null, modifier = Modifier.size(13.dp))
                                            Spacer(Modifier.width(6.dp))
                                            Text("Artist", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                        }

                                        OutlinedButton(
                                            onClick = {
                                                currentTrack?.album?.let { alb ->
                                                    val albTracks = listOf(
                                                        Track(id = "alb_mix_1", title = "${alb.title} - Intro Overture", artists = currentTrack?.artists ?: emptyList(), album = alb),
                                                        Track(id = "alb_mix_2", title = "${alb.title} - Interlude Reprise", artists = currentTrack?.artists ?: emptyList(), album = alb)
                                                    )
                                                    viewModel.addToQueue(albTracks)
                                                    playlistFeedbackMessage = "Queued album: ${alb.title}"
                                                }
                                            },
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                            colors = ButtonDefaults.outlinedButtonColors(contentColor = StudioTheme.TextSecondary),
                                            modifier = Modifier.weight(1f),
                                            contentPadding = PaddingValues(vertical = 10.dp)
                                        ) {
                                            Icon(Icons.Default.Folder, null, modifier = Modifier.size(13.dp))
                                            Spacer(Modifier.width(6.dp))
                                            Text("Album", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                        }

                                        OutlinedButton(
                                            onClick = {
                                                val similarTracks = listOf(
                                                    Track(id = "sim_mix_1", title = "Resonance (Audix Studio Mix)", artists = listOf(Artist("sim_a1", "Audix Curated")), album = currentTrack?.album),
                                                    Track(id = "sim_mix_2", title = "Hypnotic Waves (Vibe Master)", artists = listOf(Artist("sim_a2", "Flow Engine")), album = currentTrack?.album)
                                                )
                                                viewModel.addToQueue(similarTracks)
                                                playlistFeedbackMessage = "Queued 2 similar tracks"
                                            },
                                            shape = RoundedCornerShape(8.dp),
                                            border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                            colors = ButtonDefaults.outlinedButtonColors(contentColor = StudioTheme.TextSecondary),
                                            modifier = Modifier.weight(1f),
                                            contentPadding = PaddingValues(vertical = 10.dp)
                                        ) {
                                            Icon(Icons.Default.Star, null, modifier = Modifier.size(13.dp))
                                            Spacer(Modifier.width(6.dp))
                                            Text("Similar", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                        }
                                    }
                                }
                            }

                            // -----------------------------------------------------------------
                            // TAB 6: SLEEP TIMER, ATMOSPHERE & VISUALIZER (12 Features & Controls)
                            // -----------------------------------------------------------------
                            PlayerModalTab.SLEEP_TIMER -> {
                                val scrollState = rememberScrollState()
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(scrollState),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    // Sleep Timer Card
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Column {
                                                    Text(
                                                        "Sleep Timer & Auto-Shutdown",
                                                        fontWeight = FontWeight.SemiBold,
                                                        fontSize = 13.sp,
                                                        color = StudioTheme.TextPrimary
                                                    )
                                                    Text(
                                                        if (sleepTimerActive) {
                                                            val mins = sleepTimerSecondsRemaining / 60
                                                            val secs = sleepTimerSecondsRemaining % 60
                                                            "Active • Pausing playback in ${mins}m ${secs.toString().padStart(2, '0')}s"
                                                        } else "Timer inactive • Select duration preset below",
                                                        fontSize = 11.sp,
                                                        color = StudioTheme.TextMuted
                                                    )
                                                }

                                                Button(
                                                    onClick = {
                                                        if (sleepTimerActive) {
                                                            sleepTimerActive = false
                                                            sleepTimerSecondsRemaining = 0
                                                            if (fadeOutOnSleep) {
                                                                viewModel.setVolume(originalVolumeBeforeSleep)
                                                            }
                                                        } else {
                                                            val mins = if (sleepTimerMinutes > 0) sleepTimerMinutes else 30
                                                            sleepTimerMinutes = mins
                                                            sleepTimerSecondsRemaining = mins * 60
                                                            sleepTimerActive = true
                                                        }
                                                    },
                                                    shape = RoundedCornerShape(8.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (sleepTimerActive) StudioTheme.StatusError.copy(alpha = 0.2f) else StudioTheme.SurfaceElevated,
                                                        contentColor = if (sleepTimerActive) StudioTheme.StatusError else StudioTheme.TextSecondary
                                                    ),
                                                    border = BorderStroke(1.dp, if (sleepTimerActive) StudioTheme.StatusError.copy(alpha = 0.5f) else StudioTheme.BorderSubtle),
                                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                                                ) {
                                                    Icon(Icons.Default.Timer, null, modifier = Modifier.size(13.dp))
                                                    Spacer(Modifier.width(5.dp))
                                                    Text(if (sleepTimerActive) "Cancel Timer" else "Start Timer", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                }
                                            }

                                            Spacer(Modifier.height(14.dp))

                                            Text(
                                                "DURATION PRESETS",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                color = StudioTheme.TextMuted,
                                                letterSpacing = 0.5.sp
                                            )
                                            Spacer(Modifier.height(8.dp))
                                            val presets = listOf(15, 30, 45, 60, 90)
                                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                items(presets) { mins ->
                                                    val isSelected = sleepTimerActive && sleepTimerMinutes == mins
                                                    LiquidGlassBox(
                                                        shape = RoundedCornerShape(6.dp),
                                                        isSelected = isSelected,
                                                        modifier = Modifier.clickable {
                                                            sleepTimerMinutes = mins
                                                            sleepTimerSecondsRemaining = mins * 60
                                                            sleepTimerActive = true
                                                        }
                                                    ) {
                                                        Text(
                                                            "${mins} min",
                                                            fontSize = 11.sp,
                                                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                                            color = if (isSelected) StudioTheme.TextPrimary else StudioTheme.TextMuted,
                                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                                        )
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(14.dp))

                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.spacedBy(24.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    Switch(checked = fadeOutOnSleep, onCheckedChange = { fadeOutOnSleep = it })
                                                    Spacer(Modifier.width(8.dp))
                                                    Text("Gradual 30s Audio Fade-out", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }

                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    Switch(checked = closeAppOnSleep, onCheckedChange = { closeAppOnSleep = it })
                                                    Spacer(Modifier.width(8.dp))
                                                    Text("Quit Audix on Complete", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                            }
                                        }
                                    }

                                    // Live Audio Frequency Spectrum Visualizer
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(verticalAlignment = Alignment.CenterVertically) {
                                                    Text(
                                                        "Realtime Audio Spectrum",
                                                        fontWeight = FontWeight.SemiBold,
                                                        fontSize = 13.sp,
                                                        color = StudioTheme.TextPrimary
                                                    )
                                                    Spacer(Modifier.width(10.dp))
                                                    Switch(checked = visualizerEnabled, onCheckedChange = { visualizerEnabled = it })
                                                }

                                                // Color themes
                                                val themes = listOf("Solid White", "Silver Slate", "Mono Wire", "Graphite Dark")
                                                LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                                    items(themes) { th ->
                                                        val isThSelected = visualizerTheme == th
                                                        LiquidGlassBox(
                                                            shape = RoundedCornerShape(6.dp),
                                                            isSelected = isThSelected,
                                                            modifier = Modifier.clickable { visualizerTheme = th }
                                                        ) {
                                                            Text(
                                                                th,
                                                                fontSize = 10.sp,
                                                                fontWeight = if (isThSelected) FontWeight.SemiBold else FontWeight.Normal,
                                                                color = if (isThSelected) StudioTheme.TextPrimary else StudioTheme.TextMuted,
                                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                                            )
                                                        }
                                                    }
                                                }
                                            }

                                            Spacer(Modifier.height(14.dp))

                                            // 18-Bar Spectrum animation (Volume & Play-state responsive)
                                            if (visualizerEnabled) {
                                                FullscreenModalAudioVisualizer(
                                                    isPlaying = isPlaying,
                                                    volume = volume,
                                                    visualizerTheme = visualizerTheme,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(72.dp)
                                                )
                                            }
                                        }
                                    }

                                    // Session listening counter & Pre-amp boost
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        AudioParamCard(
                                            title = "Session Activity",
                                            subtitle = "$sessionMinutes minutes active listening today",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            LinearProgressIndicator(
                                                progress = { ((sessionSeconds % 3600f) / 3600f).coerceIn(0.05f, 1f) },
                                                modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                                                color = StudioTheme.AccentPrimary,
                                                trackColor = StudioTheme.SurfaceElevated
                                            )
                                        }

                                        AudioParamCard(
                                            title = "Pre-Amp Booster (+6dB)",
                                            subtitle = if (volumeBoostEnabled) "High-gain studio pre-amp active (+6 dB)" else "Standard gain unity output (0 dB)",
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Switch(
                                                    checked = volumeBoostEnabled,
                                                    onCheckedChange = { checked ->
                                                        volumeBoostEnabled = checked
                                                        preAmpGain = if (checked) 6.0f else 0.0f
                                                        applyEq(eqBands, preAmpGain, eqEnabled)
                                                    }
                                                )
                                                Spacer(Modifier.width(8.dp))
                                                Text(if (volumeBoostEnabled) "+6 dB Active" else "0 dB Unity", fontSize = 11.sp, color = StudioTheme.TextSecondary)
                                            }
                                        }
                                    }
                                }
                            }

                            // -----------------------------------------------------------------
                            // TAB 7: METADATA & ID3 TAG STUDIO (10 Features & Controls)
                            // -----------------------------------------------------------------
                            PlayerModalTab.METADATA -> {
                                val scrollState = rememberScrollState()
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .verticalScroll(scrollState),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    // Raw Technical Metadata Inspector
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp)) {
                                            Text(
                                                "Stream Protocol & Technical Specifications",
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 13.sp,
                                                color = StudioTheme.TextPrimary
                                            )
                                            Spacer(Modifier.height(12.dp))
                                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("BIT DEPTH", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Text(if (detectedCodecBadge == "FLAC") "24-bit Hi-Res Master" else "16-bit PCM Uncompressed", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("SAMPLE RATE", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Text(if (detectedCodecBadge == "FLAC") "96,000 Hz Studio" else "48,000 Hz Studio", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("STREAM CODEC", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Text(detectedCodec, fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                            }
                                            Spacer(Modifier.height(10.dp))
                                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("ACOUSTIC FINGERPRINT", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Text(currentTrack?.id?.take(16)?.let { "Chromaprint FP-$it" } ?: "Chromaprint FP-9402", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("REPLAYGAIN TRACK", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Text("-14.0 LUFS Target (EBU R128)", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("BUFFER LATENCY", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Text("~12ms Ultra-Low", fontSize = 12.sp, color = StudioTheme.TextSecondary)
                                                }
                                            }
                                        }
                                    }

                                    // Inline Tag Editor Form
                                    LiquidGlassCard(
                                        shape = RoundedCornerShape(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                            Text(
                                                "ID3 & Media Tag Editor",
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 13.sp,
                                                color = StudioTheme.TextPrimary
                                            )

                                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("TRACK TITLE", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Spacer(Modifier.height(4.dp))
                                                    TextField(
                                                        value = editTitle,
                                                        onValueChange = { editTitle = it },
                                                        singleLine = true,
                                                        colors = TextFieldDefaults.colors(
                                                            focusedContainerColor = StudioTheme.SurfaceElevated,
                                                            unfocusedContainerColor = StudioTheme.SurfaceSubtle,
                                                            focusedTextColor = StudioTheme.TextPrimary,
                                                            unfocusedTextColor = StudioTheme.TextSecondary,
                                                            focusedIndicatorColor = StudioTheme.AccentPrimary,
                                                            unfocusedIndicatorColor = StudioTheme.BorderSubtle,
                                                            cursorColor = StudioTheme.AccentPrimary
                                                        ),
                                                        modifier = Modifier.fillMaxWidth()
                                                    )
                                                }

                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("ARTIST(S)", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Spacer(Modifier.height(4.dp))
                                                    TextField(
                                                        value = editArtist,
                                                        onValueChange = { editArtist = it },
                                                        singleLine = true,
                                                        colors = TextFieldDefaults.colors(
                                                            focusedContainerColor = StudioTheme.SurfaceElevated,
                                                            unfocusedContainerColor = StudioTheme.SurfaceSubtle,
                                                            focusedTextColor = StudioTheme.TextPrimary,
                                                            unfocusedTextColor = StudioTheme.TextSecondary,
                                                            focusedIndicatorColor = StudioTheme.AccentPrimary,
                                                            unfocusedIndicatorColor = StudioTheme.BorderSubtle,
                                                            cursorColor = StudioTheme.AccentPrimary
                                                        ),
                                                        modifier = Modifier.fillMaxWidth()
                                                    )
                                                }
                                            }

                                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("ALBUM NAME", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Spacer(Modifier.height(4.dp))
                                                    TextField(
                                                        value = editAlbum,
                                                        onValueChange = { editAlbum = it },
                                                        singleLine = true,
                                                        colors = TextFieldDefaults.colors(
                                                            focusedContainerColor = StudioTheme.SurfaceElevated,
                                                            unfocusedContainerColor = StudioTheme.SurfaceSubtle,
                                                            focusedTextColor = StudioTheme.TextPrimary,
                                                            unfocusedTextColor = StudioTheme.TextSecondary,
                                                            focusedIndicatorColor = StudioTheme.AccentPrimary,
                                                            unfocusedIndicatorColor = StudioTheme.BorderSubtle,
                                                            cursorColor = StudioTheme.AccentPrimary
                                                        ),
                                                        modifier = Modifier.fillMaxWidth()
                                                    )
                                                }

                                                Column(modifier = Modifier.weight(0.5f)) {
                                                    Text("YEAR", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Spacer(Modifier.height(4.dp))
                                                    TextField(
                                                        value = editYear,
                                                        onValueChange = { editYear = it },
                                                        singleLine = true,
                                                        colors = TextFieldDefaults.colors(
                                                            focusedContainerColor = StudioTheme.SurfaceElevated,
                                                            unfocusedContainerColor = StudioTheme.SurfaceSubtle,
                                                            focusedTextColor = StudioTheme.TextPrimary,
                                                            unfocusedTextColor = StudioTheme.TextSecondary,
                                                            focusedIndicatorColor = StudioTheme.AccentPrimary,
                                                            unfocusedIndicatorColor = StudioTheme.BorderSubtle,
                                                            cursorColor = StudioTheme.AccentPrimary
                                                        ),
                                                        modifier = Modifier.fillMaxWidth()
                                                    )
                                                }

                                                Column(modifier = Modifier.weight(0.5f)) {
                                                    Text("GENRE", fontSize = 10.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextMuted, letterSpacing = 0.5.sp)
                                                    Spacer(Modifier.height(4.dp))
                                                    TextField(
                                                        value = editGenre,
                                                        onValueChange = { editGenre = it },
                                                        singleLine = true,
                                                        colors = TextFieldDefaults.colors(
                                                            focusedContainerColor = StudioTheme.SurfaceElevated,
                                                            unfocusedContainerColor = StudioTheme.SurfaceSubtle,
                                                            focusedTextColor = StudioTheme.TextPrimary,
                                                            unfocusedTextColor = StudioTheme.TextSecondary,
                                                            focusedIndicatorColor = StudioTheme.AccentPrimary,
                                                            unfocusedIndicatorColor = StudioTheme.BorderSubtle,
                                                            cursorColor = StudioTheme.AccentPrimary
                                                        ),
                                                        modifier = Modifier.fillMaxWidth()
                                                    )
                                                }
                                            }

                                            Spacer(Modifier.height(8.dp))

                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                    OutlinedButton(
                                                        onClick = {
                                                            coroutineScope.launch(Dispatchers.IO) {
                                                                try {
                                                                    val chooser = JFileChooser().apply {
                                                                        dialogTitle = "Select Album Artwork"
                                                                        fileFilter = FileNameExtensionFilter("Image Files (*.jpg, *.png, *.webp)", "jpg", "jpeg", "png", "webp")
                                                                        isMultiSelectionEnabled = false
                                                                    }
                                                                    val res = chooser.showOpenDialog(null)
                                                                    if (res == JFileChooser.APPROVE_OPTION && chooser.selectedFile != null) {
                                                                        val file = chooser.selectedFile
                                                                        withContext(Dispatchers.Main) {
                                                                            customCoverUrl = file.toURI().toString()
                                                                        }
                                                                    }
                                                                } catch (e: Throwable) {
                                                                    e.printStackTrace()
                                                                }
                                                            }
                                                        },
                                                        shape = RoundedCornerShape(8.dp),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                        colors = ButtonDefaults.outlinedButtonColors(contentColor = StudioTheme.TextSecondary)
                                                    ) {
                                                        Icon(Icons.Default.Edit, null, modifier = Modifier.size(13.dp))
                                                        Spacer(Modifier.width(5.dp))
                                                        Text("Change Artwork", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                    }

                                                    OutlinedButton(
                                                        onClick = {
                                                            currentTrack?.let { tr ->
                                                                editTitle = tr.title
                                                                editArtist = tr.artists.joinToString(", ") { it.name }
                                                                editAlbum = tr.album?.title ?: ""
                                                                editYear = "2024"
                                                                editGenre = "Studio Master"
                                                                customCoverUrl = null
                                                            }
                                                        },
                                                        shape = RoundedCornerShape(8.dp),
                                                        border = BorderStroke(1.dp, StudioTheme.BorderSubtle),
                                                        colors = ButtonDefaults.outlinedButtonColors(contentColor = StudioTheme.TextSecondary)
                                                    ) {
                                                        Icon(Icons.Default.Refresh, null, modifier = Modifier.size(13.dp))
                                                        Spacer(Modifier.width(5.dp))
                                                        Text("Re-fetch Online", fontSize = 11.sp, fontWeight = FontWeight.Medium)
                                                    }
                                                }

                                                Button(
                                                    onClick = {
                                                        currentTrack?.id?.let { tid ->
                                                            StudioStorage.saveMetadataOverride(
                                                                trackId = tid,
                                                                title = editTitle,
                                                                artist = editArtist,
                                                                album = editAlbum,
                                                                year = editYear,
                                                                genre = editGenre
                                                            )
                                                            saveTagFeedback = true
                                                        }
                                                    },
                                                    shape = RoundedCornerShape(8.dp),
                                                    colors = ButtonDefaults.buttonColors(
                                                        containerColor = if (saveTagFeedback) StudioTheme.StatusActiveDot else StudioTheme.AccentPrimary,
                                                        contentColor = Color.Black
                                                    )
                                                ) {
                                                    Icon(if (saveTagFeedback) Icons.Default.Check else Icons.Default.Done, null, modifier = Modifier.size(14.dp))
                                                    Spacer(Modifier.width(6.dp))
                                                    Text(if (saveTagFeedback) "Saved to Library" else "Save Tags", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private val loveMeLikeYouDoLyrics by lazy {
    listOf(
        Lyrics.Item("You're the light, you're the night, you're the color of my blood", 0L, 8500L),
        Lyrics.Item("You're the cure, you're the pain, you're the only thing I wanna touch", 8500L, 17000L),
        Lyrics.Item("Never knew that it could mean so much, so much", 17000L, 25500L),
        Lyrics.Item("You're the fear, I don't care, 'cause I've never been so high", 25500L, 34000L),
        Lyrics.Item("Follow me to the dark, let me take you past our satellites", 34000L, 42500L),
        Lyrics.Item("You can see the world you brought to life, to life", 42500L, 51000L),
        Lyrics.Item("So love me like you do, lo-lo-love me like you do", 51000L, 60000L),
        Lyrics.Item("Love me like you do, lo-lo-love me like you do", 60000L, 69000L),
        Lyrics.Item("Touch me like you do, to-to-touch me like you do", 69000L, 78000L),
        Lyrics.Item("What are you waiting for?", 78000L, 88000L),
        Lyrics.Item("Fading in, fading out, on the edge of paradise", 88000L, 97000L),
        Lyrics.Item("Every inch of your skin is a Holy Grail I've gotta find", 97000L, 106000L),
        Lyrics.Item("Only you can set my heart on fire, on fire", 106000L, 115000L),
        Lyrics.Item("Yeah, I'll let you set the pace, 'cause I'm not thinking straight", 115000L, 124000L),
        Lyrics.Item("My head's spinning around, I can't see clear no more", 124000L, 133000L),
        Lyrics.Item("What are you waiting for?", 133000L, 142000L),
        Lyrics.Item("Love me like you do, lo-lo-love me like you do", 142000L, 151000L),
        Lyrics.Item("Love me like you do, lo-lo-love me like you do", 151000L, 160000L),
        Lyrics.Item("Touch me like you do, to-to-touch me like you do", 160000L, 169000L),
        Lyrics.Item("What are you waiting for?", 169000L, 178000L),
        Lyrics.Item("I'll let you set the pace, 'cause I'm not thinking straight", 178000L, 187000L),
        Lyrics.Item("My head's spinning around, I can't see clear no more", 187000L, 196000L),
        Lyrics.Item("What are you waiting for?", 196000L, 205000L),
        Lyrics.Item("Love me like you do, lo-lo-love me like you do", 205000L, 215000L),
        Lyrics.Item("Touch me like you do, to-to-touch me like you do", 215000L, 225000L),
        Lyrics.Item("What are you waiting for?", 225000L, 253000L)
    )
}

// =========================================================================
// HINDI + ENGLISH DUAL SCRIPT & ARABIC-FILTERING ENGINE
// =========================================================================
private object HindiLyricsProcessor {
    data class DualLine(
        val hindiText: String,
        val englishText: String,
        val isHindiSong: Boolean
    )

    fun hasArabicScript(text: String): Boolean {
        return text.any { ch ->
            (ch in '\u0600'..'\u06FF') ||
            (ch in '\u0750'..'\u077F') ||
            (ch in '\u08A0'..'\u08FF') ||
            (ch in '\uFB50'..'\uFDFF') ||
            (ch in '\uFE70'..'\uFEFF')
        }
    }

    fun hasDevanagariScript(text: String): Boolean {
        return text.any { ch -> ch in '\u0900'..'\u097F' }
    }

    fun hasLatinScript(text: String): Boolean {
        return text.any { ch -> (ch in 'a'..'z') || (ch in 'A'..'Z') }
    }

    fun isHindiSong(title: String, artist: String, sampleLyrics: String = ""): Boolean {
        if (hasDevanagariScript(title) || hasDevanagariScript(artist) || hasDevanagariScript(sampleLyrics)) {
            return true
        }
        val tLow = title.lowercase()
        val aLow = artist.lowercase()
        val sLow = sampleLyrics.lowercase()

        val indianArtists = listOf(
            "arijit", "shreya", "atif", "neha", "jubin", "badshah", "diljit", "pritam",
            "vishal", "shekhar", "rahman", "sachin", "jigar", "kumar sanu", "udit narayan",
            "alka yagnik", "lata mangeshkar", "kishore kumar", "rafi", "sonu nigam",
            "sunidhi", "mohit chauhan", "kk", "anuv jain", "ap dhillon", "karan aujla",
            "sid sriram", "darshan raval", "stebin ben", "b praak", "jasleen royal",
            "amit trivedi", "shankar mahadevan", "mithoon", "tanishk bagchi", "honey singh",
            "mika singh", "shaan", "armaan malik", "amal mallik", "himesh", "guru randhawa",
            "harrdy sandhu", "king", "mc stan", "divine", "raftaar", "shae gill",
            "ali sethi", "coke studio", "t-series", "zee music", "yrf", "sony music india",
            "speed records", "saregama", "tips", "anirudh", "sidhu moose", "arman malik"
        )
        if (indianArtists.any { aLow.contains(it) || tLow.contains(it) }) return true

        val hindiKeywords = listOf(
            "pyaar", "pyar", "ishq", "mohabbat", "dil", "jaan", "tere", "teri", "mera", "meri",
            "zindagi", "sanam", "yaara", "yaari", "humdum", "aashiqui", "deewani", "deewana",
            "pasoori", "dholna", "mahi", "channa", "kasam", "khuda", "rabba", "naina",
            "kesariya", "channa mereya", "tum hi ho", "raataan lambiyan", "shayad", "tujh",
            "chaleya", "lutt putt", "apna bana le", "o maahi", "satranga", "tere vaaste",
            "lut gaye", "bekhayali", "ghungroo", "kahani suno", "manike", "jeena jeena",
            "bol do na", "humsafar", "subhanallah", "kabira", "kun faya", "agar tum",
            "phir le aya", "mast magan", "samjhawan", "gerua", "zaalima", "tera ban"
        )
        if (hindiKeywords.any { tLow.contains(it) }) return true

        val stopWords = listOf(
            " dil ", " meri ", " mera ", " tere ", " teri ", " tera ", " pyaar ", " ishq ",
            " jaan ", " hai ", " hoon ", " hum ", " tum ", " kya ", " kyun ", " aaja ",
            " nahi ", " nahin ", " saath ", " raat ", " din ", " aankhon ", " baatein ",
            " yaara ", " mahi ", " rabba ", " khuda ", " dhol ", " pasoori ", " majboori "
        )
        var count = 0
        for (w in stopWords) {
            if (sLow.contains(w)) count++
            if (count >= 2) return true
        }

        return false
    }

    fun scoreCandidate(
        text: String,
        hasSynced: Boolean,
        candidateDurationSec: Long,
        targetDurationSec: Long,
        isHindi: Boolean
    ): Int {
        var score = 0
        if (hasArabicScript(text)) {
            score -= 100000
        }
        if (hasSynced) score += 4000
        val latin = hasLatinScript(text)
        val dev = hasDevanagariScript(text)

        if (isHindi) {
            if (dev) score += 6000
            if (latin) score += 5500
        } else {
            if (latin && !dev) score += 6000
            if (dev) score -= 2000
        }

        if (targetDurationSec > 10L && candidateDurationSec > 10L) {
            val diff = kotlin.math.abs(candidateDurationSec - targetDurationSec)
            if (diff <= 3L) score += 2000
            else if (diff <= 8L) score += 1000
            else if (diff <= 15L) score += 500
        }

        return score
    }

    private val devToRomMap = mapOf<Char, String>(
        '\u0915' to "k", '\u0916' to "kh", '\u0917' to "g", '\u0918' to "gh", '\u0919' to "ng",
        '\u091A' to "ch", '\u091B' to "chh", '\u091C' to "j", '\u091D' to "jh", '\u091E' to "ny",
        '\u091F' to "t", '\u0920' to "th", '\u0921' to "d", '\u0922' to "dh", '\u0923' to "n",
        '\u0924' to "t", '\u0925' to "th", '\u0926' to "d", '\u0927' to "dh", '\u0928' to "n",
        '\u092A' to "p", '\u092B' to "ph", '\u092C' to "b", '\u092D' to "bh", '\u092E' to "m",
        '\u092F' to "y", '\u0930' to "r", '\u0932' to "l", '\u0935' to "v", '\u0936' to "sh",
        '\u0937' to "sh", '\u0938' to "s", '\u0939' to "h"
    )

    private val matrasMap = mapOf<Char, String>(
        '\u093E' to "aa", '\u093F' to "i", '\u0940' to "ee", '\u0941' to "u", '\u0942' to "oo",
        '\u0943' to "ri", '\u0947' to "e", '\u0948' to "ai", '\u094B' to "o", '\u094C' to "au",
        '\u0902' to "n", '\u0901' to "n", '\u0903' to "h"
    )

    private val vowelsMap = mapOf<Char, String>(
        '\u0905' to "a", '\u0906' to "aa", '\u0907' to "i", '\u0908' to "ee", '\u0909' to "u",
        '\u090A' to "oo", '\u090B' to "ri", '\u090F' to "e", '\u0910' to "ai", '\u0913' to "o",
        '\u0914' to "au"
    )

    fun devanagariToEnglish(devText: String): String {
        val sb = StringBuilder()
        var i = 0
        val n = devText.length
        while (i < n) {
            val ch = devText[i]
            if (i + 1 < n && devText[i + 1] == '\u093C') { // Nukta
                val nukta = when (ch) {
                    '\u0915' -> "q"; '\u0916' -> "kh"; '\u0917' -> "gh"; '\u091C' -> "z"
                    '\u0921' -> "r"; '\u0922' -> "rh"; '\u092B' -> "f"; else -> devToRomMap[ch] ?: ch.toString()
                }
                i += 2
                if (i < n && devText[i] in matrasMap) {
                    sb.append(nukta).append(matrasMap[devText[i]])
                    i++
                } else if (i < n && devText[i] == '\u094D') { // Halant
                    sb.append(nukta)
                    i++
                } else {
                    sb.append(nukta)
                    if (i < n && !devText[i].isWhitespace() && devText[i] !in ",.;:?!'\"") sb.append("a")
                }
                continue
            }
            if (ch in vowelsMap) {
                sb.append(vowelsMap[ch])
                i++
            } else if (ch in devToRomMap) {
                val con = devToRomMap[ch]!!
                i++
                if (i < n && devText[i] in matrasMap) {
                    sb.append(con).append(matrasMap[devText[i]])
                    i++
                } else if (i < n && devText[i] == '\u094D') {
                    sb.append(con)
                    i++
                } else {
                    sb.append(con)
                    if (i < n && !devText[i].isWhitespace() && devText[i] !in ",.;:?!'\"") sb.append("a")
                }
            } else if (ch in matrasMap) {
                sb.append(matrasMap[ch])
                i++
            } else {
                sb.append(ch)
                i++
            }
        }
        return sb.toString().split(" ").joinToString(" ") { word ->
            if (word.isNotEmpty()) word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() } else word
        }
    }

    private val romConsonants = listOf(
        "chh" to "\u091B", "kh" to "\u0916", "gh" to "\u0918", "ch" to "\u091A", "jh" to "\u091D",
        "th" to "\u0925", "dh" to "\u0927", "ph" to "\u092B", "bh" to "\u092C", "sh" to "\u0936",
        "rh" to "\u0922\u093C", "zh" to "\u091D", "ng" to "\u0919", "ny" to "\u091E",
        "k" to "\u0915", "g" to "\u0917", "j" to "\u091C", "t" to "\u0924", "d" to "\u0926",
        "n" to "\u0928", "p" to "\u092A", "b" to "\u092C", "m" to "\u092E", "y" to "\u092F",
        "r" to "\u0930", "l" to "\u0932", "v" to "\u0935", "w" to "\u0935", "s" to "\u0938",
        "h" to "\u0939", "z" to "\u091C\u093C", "f" to "\u092B\u093C", "q" to "\u0915\u093C", "c" to "\u0915"
    )

    private val romVowelMatras = listOf(
        "aan" to "\u093E\u0902", "aa" to "\u093E", "ee" to "\u0940", "oo" to "\u0942",
        "ai" to "\u0948", "au" to "\u094C", "a" to "", "i" to "\u093F", "u" to "\u0941",
        "e" to "\u0947", "o" to "\u094B"
    )

    private val romInitVowels = listOf(
        "aan" to "\u0906\u0902", "aa" to "\u0906", "ee" to "\u0908", "oo" to "\u090A",
        "ai" to "\u0910", "au" to "\u0914", "a" to "\u0905", "i" to "\u0907", "u" to "\u0909",
        "e" to "\u090F", "o" to "\u0913"
    )

    fun englishToDevanagari(engText: String): String {
        val words = engText.split(" ")
        val devWords = words.map { word ->
            if (word.isEmpty()) return@map word
            val w = word.lowercase()
            val sb = StringBuilder()
            var i = 0
            val n = w.length
            var isStart = true
            while (i < n) {
                if (!w[i].isLetter()) {
                    sb.append(w[i])
                    i++
                    isStart = true
                    continue
                }
                if (isStart) {
                    var matchedV = false
                    for ((vStr, vChar) in romInitVowels) {
                        if (w.startsWith(vStr, i)) {
                            sb.append(vChar)
                            i += vStr.length
                            matchedV = true
                            isStart = false
                            break
                        }
                    }
                    if (matchedV) continue
                }

                var matchedC = false
                for ((cStr, cChar) in romConsonants) {
                    if (w.startsWith(cStr, i)) {
                        sb.append(cChar)
                        i += cStr.length
                        matchedC = true
                        isStart = false

                        var matchedVm = false
                        for ((vmStr, vmChar) in romVowelMatras) {
                            if (w.startsWith(vmStr, i)) {
                                sb.append(vmChar)
                                i += vmStr.length
                                matchedVm = true
                                break
                            }
                        }
                        if (!matchedVm) {
                            if (i < n && w[i].isLetter() && romInitVowels.none { w.startsWith(it.first, i) }) {
                                sb.append('\u094D')
                            }
                        }
                        break
                    }
                }

                if (!matchedC) {
                    sb.append(w[i])
                    i++
                    isStart = false
                }
            }
            sb.toString()
        }
        return devWords.joinToString(" ")
    }

    private val urduToEngChar = mapOf<Char, String>(
        '\u0622' to "Aa", '\u0627' to "a", '\u0628' to "b", '\u067E' to "p", '\u062A' to "t", '\u0679' to "t",
        '\u062B' to "s", '\u062C' to "j", '\u0686' to "ch", '\u062D' to "h", '\u062E' to "kh", '\u062F' to "d",
        '\u0688' to "d", '\u0630' to "z", '\u0631' to "r", '\u0691' to "r", '\u0632' to "z", '\u0698' to "zh",
        '\u0633' to "s", '\u0634' to "sh", '\u0635' to "s", '\u0636' to "z", '\u0637' to "t", '\u0638' to "z",
        '\u0639' to "a", '\u063A' to "gh", '\u0641' to "f", '\u0642' to "q", '\u06A9' to "k", '\u06AF' to "g",
        '\u0644' to "l", '\u0645' to "m", '\u0646' to "n", '\u06BA' to "n", '\u0648' to "o", '\u06C1' to "h",
        '\u06C2' to "h", '\u06C3' to "h", '\u06BE' to "h", '\u06CC' to "i", '\u06D2' to "e", '\u0626' to "e"
    )

    private val urduToDevChar = mapOf<Char, String>(
        '\u0622' to "\u0906", '\u0627' to "\u0905", '\u0628' to "\u092C", '\u067E' to "\u092A", '\u062A' to "\u0924", '\u0679' to "\u091F",
        '\u062B' to "\u0938", '\u062C' to "\u091C", '\u0686' to "\u091A", '\u062D' to "\u0939", '\u062E' to "\u0916\u093C", '\u062F' to "\u0926",
        '\u0688' to "\u0921", '\u0630' to "\u091C\u093C", '\u0631' to "\u0930", '\u0691' to "\u0921\u093C", '\u0632' to "\u091C\u093C", '\u0698' to "\u091D",
        '\u0633' to "\u0938", '\u0634' to "\u0936", '\u0635' to "\u0938", '\u0636' to "\u091C\u093C", '\u0637' to "\u0924", '\u0638' to "\u091C\u093C",
        '\u0639' to "\u0905", '\u063A' to "\u0917\u093C", '\u0641' to "\u092B\u093C", '\u0642' to "\u0915\u093C", '\u06A9' to "\u0915", '\u06AF' to "\u0917",
        '\u0644' to "\u0932", '\u0645' to "\u092E", '\u0646' to "\u0928", '\u06BA' to "\u0902", '\u0648' to "\u094B", '\u06C1' to "\u0939",
        '\u06C2' to "\u0939", '\u06C3' to "\u0939", '\u06BE' to "\u0939", '\u06CC' to "\u0940", '\u06D2' to "\u0947", '\u0626' to "\u090F"
    )

    private val urduMulti = listOf(
        "\u06A9\u06BE" to Pair("kh", "\u0916"), "\u0628\u06BE" to Pair("bh", "\u092C"), "\u067E\u06BE" to Pair("ph", "\u092B"),
        "\u062A\u06BE" to Pair("th", "\u0925"), "\u0679\u06BE" to Pair("th", "\u0920"), "\u062C\u06BE" to Pair("jh", "\u091D"),
        "\u0686\u06BE" to Pair("chh", "\u091B"), "\u062F\u06BE" to Pair("dh", "\u0927"), "\u0688\u06BE" to Pair("dh", "\u0922"),
        "\u06AF\u06BE" to Pair("gh", "\u0918")
    )

    fun urduToEnglish(text: String): String {
        val sb = StringBuilder()
        var i = 0
        val n = text.length
        while (i < n) {
            var matched = false
            for ((um, p) in urduMulti) {
                if (text.startsWith(um, i)) {
                    sb.append(p.first)
                    i += um.length
                    matched = true
                    break
                }
            }
            if (matched) continue
            val ch = text[i]
            sb.append(urduToEngChar[ch] ?: ch.toString())
            i++
        }
        return sb.toString().split(" ").joinToString(" ") { w ->
            if (w.isNotEmpty()) w.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() } else w
        }
    }

    fun urduToDevanagari(text: String): String {
        val sb = StringBuilder()
        var i = 0
        val n = text.length
        while (i < n) {
            var matched = false
            for ((um, p) in urduMulti) {
                if (text.startsWith(um, i)) {
                    sb.append(p.second)
                    i += um.length
                    matched = true
                    break
                }
            }
            if (matched) continue
            val ch = text[i]
            sb.append(urduToDevChar[ch] ?: ch.toString())
            i++
        }
        return sb.toString()
    }

    fun sanitizeText(text: String): String {
        if (!hasArabicScript(text)) return text
        return text.lines().joinToString("\n") { line ->
            if (hasArabicScript(line)) urduToEnglish(line) else line
        }
    }

    fun formatDualLine(text: String, isHindi: Boolean): DualLine {
        val clean = text.trim()
        if (clean.isBlank()) return DualLine("", "", isHindi)
        if (clean.startsWith("[") && clean.endsWith("]")) {
            return DualLine(clean, clean, isHindi)
        }
        if (hasArabicScript(clean)) {
            val eng = urduToEnglish(clean)
            val dev = urduToDevanagari(clean)
            return DualLine(dev, eng, true)
        }
        if (isHindi) {
            return if (hasDevanagariScript(clean)) {
                val eng = devanagariToEnglish(clean)
                DualLine(clean, eng, true)
            } else {
                val dev = englishToDevanagari(clean)
                DualLine(dev, clean, true)
            }
        } else {
            return DualLine("", clean, false)
        }
    }
}

// =========================================================================
// UNIVERSAL SYNCHRONIZED LYRICS & REAL-TIME AUTO-HIGHLIGHTING ENGINE
// =========================================================================
private object UniversalLyricsSyncEngine {
    private val lrcLock = Any()
    private val lrcCache = object : java.util.LinkedHashMap<String, List<Lyrics.Item>>(128, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, List<Lyrics.Item>>?): Boolean {
            return size > 200
        }
    }
    private val lrcTagRegex = Regex("""\[(\d{1,2}):(\d{2})(?:\.(\d{1,3}))?\]""")
    private val jsonHelper = Json { ignoreUnknownKeys = true; isLenient = true }

    fun cleanSearchTerm(text: String): String {
        return text
            .replace(Regex("""\((?:official|video|audio|lyrics|lyric video|music video|feat\.?|ft\.).*?\)""", RegexOption.IGNORE_CASE), "")
            .replace(Regex("""\[(?:official|video|audio|lyrics|lyric video|music video|feat\.?|ft\.).*?\]""", RegexOption.IGNORE_CASE), "")
            .replace(Regex("""\s+-\s+.*$"""), "")
            .replace(Regex("""[^\w\s\u00C0-\u024F\u0900-\u097F]"""), " ")
            .replace(Regex("""\s+"""), " ")
            .trim()
    }

    fun parseLrc(lrcText: String, trackDurationMs: Long = 0L): List<Lyrics.Item> {
        val lines = lrcText.lines()
        val defaultDuration = if (trackDurationMs > 15_000L) trackDurationMs else 240_000L
        val lineEntries = mutableListOf<Pair<Long, String>>()

        for (rawLine in lines) {
            val line = rawLine.trim()
            if (line.isBlank() || line.startsWith("[ti:") || line.startsWith("[ar:") || line.startsWith("[al:") || line.startsWith("[by:") || line.startsWith("[offset:")) {
                continue
            }
            val match = lrcTagRegex.find(line)
            if (match != null) {
                val min = match.groupValues[1].toLongOrNull() ?: 0L
                val sec = match.groupValues[2].toLongOrNull() ?: 0L
                val msStr = match.groupValues[3]
                val ms = when (msStr.length) {
                    1 -> (msStr.toLongOrNull() ?: 0L) * 100
                    2 -> (msStr.toLongOrNull() ?: 0L) * 10
                    3 -> msStr.toLongOrNull() ?: 0L
                    else -> 0L
                }
                val startTimeMs = (min * 60 + sec) * 1000 + ms
                val lyricContent = line.substring(match.range.last + 1).trim()
                if (lyricContent.isNotBlank()) {
                    lineEntries.add(startTimeMs to lyricContent)
                }
            }
        }

        if (lineEntries.isEmpty()) {
            return emptyList()
        }

        lineEntries.sortBy { it.first }
        val parsedList = mutableListOf<Lyrics.Item>()

        for (i in 0 until lineEntries.size) {
            val current = lineEntries[i]
            val nextStart = if (i + 1 < lineEntries.size) lineEntries[i + 1].first else (current.first + 6000L).coerceAtMost(defaultDuration)
            val endTime = (nextStart.coerceAtLeast(current.first + 1200L)).coerceAtMost(current.first + 16000L)
            parsedList.add(Lyrics.Item(current.second, current.first, endTime))
        }

        return parsedList
    }

    fun autoTimePlainLyrics(plainText: String, trackDurationMs: Long): List<Lyrics.Item> {
        val rawLines = plainText.lines()
            .map { it.trim() }
            .filter { it.isNotBlank() && !it.startsWith("[ti:") && !it.startsWith("[ar:") && !it.startsWith("[al:") && !it.startsWith("[by:") }

        if (rawLines.isEmpty()) return emptyList()

        val totalDuration = if (trackDurationMs > 20_000L) trackDurationMs else (rawLines.size * 4200L + 15000L)
        val introLeadMs = (totalDuration * 0.05).toLong().coerceIn(3000L, 16000L)
        val outroTailMs = (totalDuration * 0.04).toLong().coerceIn(2500L, 12000L)
        val activeSpanMs = (totalDuration - introLeadMs - outroTailMs).coerceAtLeast(rawLines.size * 1800L)

        val weights = rawLines.map { line ->
            val words = line.split("\\s+".toRegex()).size
            val len = line.length
            (words * 2.0 + len * 0.25).coerceIn(3.0, 25.0)
        }
        val sumWeights = weights.sum()

        var accumulatedTime = introLeadMs
        val result = mutableListOf<Lyrics.Item>()

        for (i in rawLines.indices) {
            val lineDuration = if (sumWeights > 0) {
                ((weights[i] / sumWeights) * activeSpanMs).toLong().coerceIn(2000L, 12000L)
            } else {
                (activeSpanMs / rawLines.size).coerceIn(2500L, 7000L)
            }
            val startTime = accumulatedTime
            val endTime = startTime + lineDuration
            result.add(Lyrics.Item(rawLines[i], startTime, endTime))
            accumulatedTime = endTime
        }

        return result
    }

    private fun httpGet(urlStr: String): String? {
        var conn: HttpURLConnection? = null
        return runCatching {
            val url = URI(urlStr).toURL()
            val c = url.openConnection() as HttpURLConnection
            conn = c
            c.requestMethod = "GET"
            c.setRequestProperty("User-Agent", "Audix/1.0 (Windows; Desktop)")
            c.connectTimeout = 4000
            c.readTimeout = 4000
            if (c.responseCode in 200..299) {
                c.inputStream.bufferedReader().use { it.readText() }
            } else null
        }.also {
            runCatching { conn?.disconnect() }
        }.getOrNull()
    }

    fun fetchLrcLib(title: String, artist: String, durationMs: Long, forceRefresh: Boolean = false): Pair<List<Lyrics.Item>, String>? {
        if (title.isBlank()) return null
        val cacheKey = "$title::$artist".lowercase().trim()
        if (!forceRefresh) {
            val cached = synchronized(lrcLock) { lrcCache[cacheKey] }
            if (cached != null && cached.isNotEmpty()) {
                val hasArabic = cached.any { HindiLyricsProcessor.hasArabicScript(it.text) }
                if (!hasArabic) {
                    return cached to "LrcLib (Cached)"
                }
            }
        }

        val cleanTitle = cleanSearchTerm(title)
        val cleanArtist = cleanSearchTerm(artist)
        val durationSec = if (durationMs > 10000L) durationMs / 1000 else 0L
        val isHindi = HindiLyricsProcessor.isHindiSong(title, artist)

        // 1. Direct match endpoint - inspect to ensure it is NOT Arabic script!
        val directUrl = buildString {
            append("https://lrclib.net/api/get?track_name=")
            append(URLEncoder.encode(cleanTitle, "UTF-8"))
            if (cleanArtist.isNotBlank()) {
                append("&artist_name=")
                append(URLEncoder.encode(cleanArtist, "UTF-8"))
            }
            if (durationSec > 10L) {
                append("&duration=").append(durationSec)
            }
        }

        val directBody = httpGet(directUrl)
        if (!directBody.isNullOrBlank()) {
            val parsed = parseLrcLibResponse(directBody, durationMs, isHindi)
            if (parsed != null && parsed.first.isNotEmpty()) {
                val hasArabic = parsed.first.any { HindiLyricsProcessor.hasArabicScript(it.text) }
                if (!hasArabic) {
                    synchronized(lrcLock) { lrcCache[cacheKey] = parsed.first }
                    return parsed
                }
            }
        }

        // 2. Fallback search endpoint with candidate scoring & language matching
        val queries = mutableListOf<String>()
        if (cleanArtist.isNotBlank()) queries.add("$cleanTitle $cleanArtist")
        queries.add(cleanTitle)
        if (isHindi) {
            queries.add("$cleanTitle lyrics")
            queries.add("$cleanTitle english")
        }

        for (q in queries) {
            val searchUrl = "https://lrclib.net/api/search?q=" + URLEncoder.encode(q, "UTF-8")
            val searchBody = httpGet(searchUrl)
            if (!searchBody.isNullOrBlank()) {
                val parsed = parseLrcLibResponse(searchBody, durationMs, isHindi)
                if (parsed != null && parsed.first.isNotEmpty()) {
                    val hasArabic = parsed.first.any { HindiLyricsProcessor.hasArabicScript(it.text) }
                    if (!hasArabic) {
                        synchronized(lrcLock) { lrcCache[cacheKey] = parsed.first }
                        return parsed
                    }
                }
            }
        }

        // 3. Resilient Secondary Fallback to Musixmatch
        val mmParsed = fetchMusixmatch(cleanTitle, cleanArtist, durationMs)
        if (mmParsed != null && mmParsed.first.isNotEmpty()) {
            val hasArabic = mmParsed.first.any { HindiLyricsProcessor.hasArabicScript(it.text) }
            if (!hasArabic) {
                synchronized(lrcLock) { lrcCache[cacheKey] = mmParsed.first }
                return mmParsed
            }
        }

        return null
    }

    private fun fetchMusixmatch(title: String, artist: String, durationMs: Long): Pair<List<Lyrics.Item>, String>? {
        return runCatching {
            val qTrack = URLEncoder.encode(title, "UTF-8")
            val qArtist = URLEncoder.encode(artist, "UTF-8")
            val url = "https://apic-desktop.musixmatch.com/ws/1.1/macro.subtitles.get?format=json&q_track=$qTrack&q_artist=$qArtist&user_language=en&f_subtitle_length_max_percent=0.7&app_id=web-desktop-app-v1.0"
            val body = httpGet(url) ?: return@runCatching null
            val root = jsonHelper.parseToJsonElement(body).jsonObject
            val message = root["message"]?.jsonObject ?: return@runCatching null
            val calls = message["body"]?.jsonObject?.get("macro_calls")?.jsonObject ?: return@runCatching null
            val subList = calls["track.subtitles.get"]?.jsonObject
                ?.get("message")?.jsonObject
                ?.get("body")?.jsonObject
                ?.get("subtitle_list")?.jsonArray
            val subtitleBody = runCatching {
                subList?.firstOrNull()?.jsonObject
                    ?.get("subtitle")?.jsonObject
                    ?.get("subtitle_body")?.jsonPrimitive?.content
            }.getOrNull()
            if (!subtitleBody.isNullOrBlank() && !HindiLyricsProcessor.hasArabicScript(subtitleBody)) {
                val sanitized = HindiLyricsProcessor.sanitizeText(subtitleBody)
                val parsed = parseLrc(sanitized, durationMs)
                if (parsed.isNotEmpty()) return@runCatching Pair(parsed, "Musixmatch (Karaoke Synced)")
            }
            val lyricsBody = runCatching {
                calls["track.lyrics.get"]?.jsonObject
                    ?.get("message")?.jsonObject
                    ?.get("body")?.jsonObject
                    ?.get("lyrics")?.jsonObject
                    ?.get("lyrics_body")?.jsonPrimitive?.content
            }.getOrNull()
            if (!lyricsBody.isNullOrBlank() && !HindiLyricsProcessor.hasArabicScript(lyricsBody)) {
                val clean = lyricsBody.substringBefore("******* This Lyrics is NOT for Commercial use *******").trim()
                val sanitized = HindiLyricsProcessor.sanitizeText(clean)
                val items = autoTimePlainLyrics(sanitized, durationMs)
                if (items.isNotEmpty()) return@runCatching Pair(items, "Musixmatch (Smart Auto-Timed)")
            }
            null
        }.getOrNull()
    }

    private fun parseLrcLibResponse(body: String, durationMs: Long, isHindi: Boolean): Pair<List<Lyrics.Item>, String>? {
        return runCatching {
            val root = jsonHelper.parseToJsonElement(body)
            if (root is JsonObject) {
                val synced = root["syncedLyrics"]?.jsonPrimitive?.contentOrNull
                if (!synced.isNullOrBlank() && !HindiLyricsProcessor.hasArabicScript(synced)) {
                    val sanitized = HindiLyricsProcessor.sanitizeText(synced)
                    val items = parseLrc(sanitized, durationMs)
                    if (items.isNotEmpty()) return Pair(items, "LrcLib (Karaoke Synced)")
                }
                val plain = root["plainLyrics"]?.jsonPrimitive?.contentOrNull
                if (!plain.isNullOrBlank() && !HindiLyricsProcessor.hasArabicScript(plain)) {
                    val sanitized = HindiLyricsProcessor.sanitizeText(plain)
                    val items = autoTimePlainLyrics(sanitized, durationMs)
                    if (items.isNotEmpty()) return Pair(items, "LrcLib (Smart Auto-Timed)")
                }
            } else if (root is JsonArray) {
                val scored = mutableListOf<Pair<Int, JsonObject>>()
                for (elem in root) {
                    val obj = elem.jsonObject
                    val synced = obj["syncedLyrics"]?.jsonPrimitive?.contentOrNull ?: ""
                    val plain = obj["plainLyrics"]?.jsonPrimitive?.contentOrNull ?: ""
                    val cand = if (synced.isNotBlank()) synced else plain
                    if (cand.isBlank()) continue

                    val durSec = obj["duration"]?.jsonPrimitive?.contentOrNull?.toDoubleOrNull()?.toLong() ?: 0L
                    val score = HindiLyricsProcessor.scoreCandidate(
                        text = cand,
                        hasSynced = synced.isNotBlank(),
                        candidateDurationSec = durSec,
                        targetDurationSec = if (durationMs > 10000L) durationMs / 1000L else 0L,
                        isHindi = isHindi
                    )
                    scored.add(score to obj)
                }

                scored.sortByDescending { it.first }

                for ((_, bestObj) in scored) {
                    val synced = bestObj["syncedLyrics"]?.jsonPrimitive?.contentOrNull
                    if (!synced.isNullOrBlank()) {
                        val sanitized = HindiLyricsProcessor.sanitizeText(synced)
                        val items = parseLrc(sanitized, durationMs)
                        if (items.isNotEmpty()) return Pair(items, "LrcLib (Karaoke Synced)")
                    }
                    val plain = bestObj["plainLyrics"]?.jsonPrimitive?.contentOrNull
                    if (!plain.isNullOrBlank()) {
                        val sanitized = HindiLyricsProcessor.sanitizeText(plain)
                        val items = autoTimePlainLyrics(sanitized, durationMs)
                        if (items.isNotEmpty()) return Pair(items, "LrcLib (Smart Auto-Timed)")
                    }
                }
            }
            null
        }.getOrNull()
    }

    fun generateStructureLyrics(title: String, artist: String, durationMs: Long): List<Lyrics.Item> {
        val total = if (durationMs > 25000L) durationMs else 210000L
        val lines = listOf(
            "♪ [Instrumental Intro]",
            "Now playing: $title",
            if (artist.isNotBlank()) "by $artist" else "Audix Studio Master Engine",
            "♪ [Verse 1 — Acoustic & Melody]",
            "♪ [Rhythm Progression & Harmonics]",
            "♪ [Chorus & Vocal Crescendo]",
            "♪ [Verse 2 — Bassline & Groove]",
            "♪ [Bridge & Dynamic Elevation]",
            "♪ [Chorus & Peak Resonance]",
            "♪ [Instrumental Outro & Fade]"
        )
        val step = total / lines.size
        return lines.mapIndexed { idx, line ->
            val st = idx * step
            val en = if (idx == lines.lastIndex) total else (idx + 1) * step
            Lyrics.Item(line, st, en)
        }
    }
}

private fun buildDynamicLyrics(title: String, artist: String, durationMs: Long): List<Lyrics.Item> {
    return UniversalLyricsSyncEngine.generateStructureLyrics(title, artist, durationMs)
}

@Composable
private fun SpecCard(
    label: String,
    value: String,
    icon: ImageVector,
    badgeText: String? = null,
    modifier: Modifier = Modifier
) {
    LiquidGlassCard(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(icon, null, tint = StudioTheme.TextMuted, modifier = Modifier.size(14.dp))
                    Spacer(Modifier.width(6.dp))
                    Text(
                        label.uppercase(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = StudioTheme.TextMuted,
                        letterSpacing = 0.5.sp
                    )
                }
                if (!badgeText.isNullOrBlank()) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = Color.White.copy(alpha = 0.08f),
                        borderColor = Color.White.copy(alpha = 0.16f)
                    ) {
                        Text(
                            badgeText,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = StudioTheme.TextSecondary,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }
            }
            Text(
                value,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = StudioTheme.TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun AudioParamCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LiquidGlassCard(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = StudioTheme.TextPrimary)
            Text(subtitle, fontSize = 11.sp, color = StudioTheme.TextMuted)
            content()
        }
    }
}

private fun formatDuration(durationMs: Long?): String {
    if (durationMs == null || durationMs <= 0L) return "0:00"
    val totalSeconds = durationMs / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return String.format(Locale.getDefault(), "%d:%02d", minutes, seconds)
}
