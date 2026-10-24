package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.automirrored.filled.QueueMusic
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import java.util.Locale
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.desktop.ui.AudixArtworkEngine
import dev.brahmkshatriya.echo.desktop.ui.DesktopBackgroundManager
import dev.brahmkshatriya.echo.desktop.ui.BackgroundWallpaper
import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.Playlist
import dev.brahmkshatriya.echo.common.models.QuickSearchItem
import dev.brahmkshatriya.echo.common.models.Shelf
import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.desktop.download.DesktopDownloadManager
import dev.brahmkshatriya.echo.desktop.download.DownloadTask
import dev.brahmkshatriya.echo.desktop.download.DownloadedTrack
import dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist
import dev.brahmkshatriya.echo.desktop.library.StoredTrack
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRow
import dev.brahmkshatriya.echo.desktop.viewmodel.DownloadsViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.LibraryViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.SearchViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.SettingsViewModel
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.compose.koinInject
import java.awt.Desktop
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.io.File
import javax.swing.JFileChooser
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import dev.brahmkshatriya.echo.common.models.NetworkRequest.Companion.toGetRequest
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient
import dev.brahmkshatriya.echo.common.clients.AlbumClient
import dev.brahmkshatriya.echo.common.clients.ArtistClient

private val REGEX_VIEWS = Regex("""^[\d\s\.,kmb]+views?$""", RegexOption.IGNORE_CASE)
private val REGEX_DASH_SPLIT = Regex("""\s+[-–]\s+""")
private val REGEX_BRACKETED_MEDIA = Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song|from\s*["']|soundtrack|ost).*?[\)\]\}]""", RegexOption.IGNORE_CASE)
private val REGEX_BRACKETED_FROM = Regex("""\s*[\(\[\{]\s*from\s+.*?[\)\]\}]""", RegexOption.IGNORE_CASE)
private val REGEX_TRAILING_MEDIA = Regex("""\s*[-–:]\s*(?:official\s*video|official\s*audio|lyrics|lyric\s*video|from\s+["'].*?|soundtrack|ost)\s*$""", RegexOption.IGNORE_CASE)
private val REGEX_FEAT = Regex("""\s+(?:feat|ft)\.?\s+.*$""", RegexOption.IGNORE_CASE)
private val REGEX_EMPTY_PARENS = Regex("""\s*[\(\[\{]\s*[\)\]\}]""")
private val REGEX_SPACES = Regex("""\s+""")
private val REGEX_ARTIST_SPLIT = Regex("""[,&]""")

private fun isGarbageAlbum(title: String?): Boolean {
    if (title.isNullOrBlank()) return true
    val t = title.lowercase().trim()
    if (t in setOf("single", "album", "audio", "video", "song", "episode", "podcast", "youtube music", "soundcloud", "soundcloud single")) return true
    if (t.contains("views") || t.contains("view") || t.contains("subscribers") || t.contains("watching") || t.contains("streamed")) return true
    if (t.contains("ago") || t.contains("uploaded")) return true
    if (t.matches(REGEX_VIEWS)) return true
    return false
}

private fun cleanDisplayAlbum(album: String?, fallback: String = ""): String {
    if (album.isNullOrBlank()) return fallback
    val a = album.trim()
    return if (isGarbageAlbum(a)) fallback else a
}

private fun StoredTrack.toTrack(): Track {
    val realCover = coverUrl?.takeIf { it.isNotBlank() } ?: extras["cover_url"]
    val imageHolder = realCover?.takeIf { it.isNotBlank() }?.let {
        ImageHolder.NetworkRequestImageHolder(
            request = dev.brahmkshatriya.echo.common.models.NetworkRequest(url = it),
            crop = false
        )
    }
    val cleanArtists = artists.filterNot { name ->
        name.isBlank() || name.equals("Song", true) || name.equals("Video", true) || name.equals("Episode", true) || name.equals("Unknown Artist", true) || name.equals("YouTube Music", true)
    }.map { name ->
        if (name.endsWith(" - Topic", ignoreCase = true)) name.substring(0, name.length - 8).trim() else name
    }
    var detectedArtist = cleanArtists.firstOrNull() ?: extras["artist_name"]?.takeIf { !it.equals("Song", true) && !it.equals("Video", true) } ?: ""
    var cleanedTitle = cleanDisplayTitle(title)
    if (detectedArtist.isBlank() && (title.contains(" - ") || title.contains(" – "))) {
        val parts = title.split(REGEX_DASH_SPLIT)
        if (parts.size >= 2 && parts[0].isNotBlank() && parts[0].length < 40) {
            detectedArtist = parts[0].trim()
            cleanedTitle = cleanDisplayTitle(parts.drop(1).joinToString(" - "))
        }
    }

    val finalArtists = when {
        cleanArtists.isNotEmpty() -> cleanArtists.map { Artist(id = it, name = it) }
        detectedArtist.isNotBlank() -> listOf(Artist(id = detectedArtist, name = detectedArtist))
        else -> listOf(Artist(id = "Audix Hi-Res Audio", name = "Audix Hi-Res Audio"))
    }
    val validAlbumTitle = albumTitle?.takeIf { !isGarbageAlbum(it) }

    return Track(
        id = id,
        title = cleanedTitle.ifBlank { title },
        artists = finalArtists,
        album = validAlbumTitle?.let { Album(id = it, title = it, cover = imageHolder) },
        cover = imageHolder,
        duration = durationMs,
        extras = buildMap {
            putAll(extras)
            if (!realCover.isNullOrBlank()) put("cover_url", realCover)
            if (cleanedTitle.isNotBlank()) put("track_title", cleanedTitle)
            if (finalArtists.isNotEmpty()) put("artist_name", finalArtists.joinToString(", ") { it.name })
            if (validAlbumTitle != null) put("album_name", validAlbumTitle) else remove("album_name")
        }
    )
}

private fun Track.toStoredTrack(): StoredTrack {
    val directCover = when (val c = cover ?: album?.cover) {
        is ImageHolder.NetworkRequestImageHolder -> c.request.url
        is ImageHolder.ResourceUriImageHolder -> c.uri
        else -> null
    }
    val extraCover = extras["cover_url"]
    val effectiveCover = when {
        !extraCover.isNullOrBlank() && !extraCover.contains("hqdefault.jpg") && !extraCover.contains("120x120") -> extraCover
        !directCover.isNullOrBlank() && !directCover.contains("hqdefault.jpg") && !directCover.contains("120x120") -> directCover
        !extraCover.isNullOrBlank() -> extraCover
        !directCover.isNullOrBlank() -> directCover
        else -> null
    }

    val cleanArtists = artists.map { it.name }.filterNot { name ->
        name.isBlank() || name.equals("Song", true) || name.equals("Video", true) || name.equals("Episode", true) || name.equals("Unknown Artist", true) || name.equals("YouTube Music", true)
    }.map { name ->
        if (name.endsWith(" - Topic", ignoreCase = true)) name.substring(0, name.length - 8).trim() else name
    }
    var detectedArtist = cleanArtists.firstOrNull() ?: extras["artist_name"]?.takeIf { !it.equals("Song", true) && !it.equals("Video", true) } ?: ""
    var cleanedTitle = cleanDisplayTitle(title)
    if (detectedArtist.isBlank() && (title.contains(" - ") || title.contains(" – "))) {
        val parts = title.split(REGEX_DASH_SPLIT)
        if (parts.size >= 2 && parts[0].isNotBlank() && parts[0].length < 40) {
            detectedArtist = parts[0].trim()
            cleanedTitle = cleanDisplayTitle(parts.drop(1).joinToString(" - "))
        }
    }

    val finalArtists = when {
        cleanArtists.isNotEmpty() -> cleanArtists
        detectedArtist.isNotBlank() -> listOf(detectedArtist)
        else -> listOf("Audix Hi-Res Audio")
    }
    val validAlbumTitle = album?.title?.takeIf { !isGarbageAlbum(it) }

    return StoredTrack(
        id = id,
        title = cleanedTitle.ifBlank { title },
        artists = finalArtists,
        albumTitle = validAlbumTitle,
        coverUrl = effectiveCover,
        durationMs = duration,
        extras = buildMap {
            putAll(extras)
            if (!effectiveCover.isNullOrBlank()) put("cover_url", effectiveCover)
            if (cleanedTitle.isNotBlank()) put("track_title", cleanedTitle)
            if (finalArtists.isNotEmpty()) put("artist_name", finalArtists.joinToString(", "))
            if (validAlbumTitle != null) put("album_name", validAlbumTitle) else remove("album_name")
        }
    )
}

private fun formatArtistsForDisplay(artists: List<Artist>?, fallback: String = "Audix Hi-Res Audio"): String {
    if (artists.isNullOrEmpty()) return fallback
    val filtered = artists.map { it.name.trim() }.filterNot { name ->
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
        name.equals("Music Video", true) ||
        name.equals("T-Series", true) ||
        name.equals("SonyMusicIndiaVEVO", true) ||
        name.equals("Zee Music Company", true) ||
        name.equals("Tips Official", true)
    }.map { name ->
        if (name.endsWith(" - Topic", ignoreCase = true)) name.substring(0, name.length - 8).trim() else name
    }
    return if (filtered.isNotEmpty()) filtered.joinToString(", ") else fallback
}

private fun cleanDisplayTitle(title: String?): String {
    if (title.isNullOrBlank()) return "Untitled Track"
    var t = title.trim()
    if (t.contains("|")) t = t.substringBefore("|").trim()
    if (t.contains("//")) t = t.substringBefore("//").trim()
    t = t.replace(REGEX_BRACKETED_MEDIA, "")
    t = t.replace(REGEX_BRACKETED_FROM, "")
    t = t.replace(REGEX_TRAILING_MEDIA, "")
    t = t.replace(REGEX_FEAT, "")
    t = t.replace(REGEX_EMPTY_PARENS, "")
    t = t.replace(REGEX_SPACES, " ").trim()
    return if (t.isNotBlank()) t else title.trim()
}

// =========================================================================
// MONOCHROME THEME PALETTE & DATA HELPERS
// =========================================================================

private val BgDark = Color.Transparent
private val SurfaceDark = Color(0x800C101F)
private val SurfaceCard = Color(0x990C101F)
private val SurfaceHover = Color(0xCC161E34)
private val BorderMuted = Color(0x1FFFFFFF)
private val BorderSubtle = Color(0x33FFFFFF)
private val TextPrimary = Color(0xFFFFFFFF)
private val TextSecondary = Color(0xFFFFFFFF)
private val TextMuted = Color(0xFFFFFFFF)

private fun ImageHolder?.toCoverUrl(): String? = AudixArtworkEngine.toCoverUrl(this)

private fun EchoMediaItem.extractCoverUrl(): String? = when (this) {
    is Track -> this.extractCoverUrl()
    is Artist -> AudixArtworkEngine.toCoverUrl(cover) ?: AudixArtworkEngine.artistCache[AudixArtworkEngine.cleanArtistKey(name)] ?: extras["cover_url"]
    is Album -> AudixArtworkEngine.toCoverUrl(cover) ?: AudixArtworkEngine.albumCache[AudixArtworkEngine.cleanAlbumKey(title)] ?: extras["cover_url"]
    else -> AudixArtworkEngine.toCoverUrl(cover) ?: (this as? dev.brahmkshatriya.echo.common.models.Album)?.cover?.let { AudixArtworkEngine.toCoverUrl(it) } ?: extras["cover_url"]
}

private fun Track.extractCoverUrl(): String? {
    val fromHolder = (cover ?: album?.cover).toCoverUrl()
    val extraCover = extras["cover_url"]
    if (!extraCover.isNullOrBlank()) {
        val isGeneric = fromHolder.isNullOrBlank() ||
            fromHolder.contains("charts-images.scdn.co") ||
            fromHolder.contains("hqdefault.jpg") ||
            fromHolder.contains("mqdefault.jpg") ||
            fromHolder.contains("120x120")
        if (isGeneric) return AudixArtworkEngine.upgradeYouTubeThumbnail(extraCover)
    }
    return AudixArtworkEngine.upgradeYouTubeThumbnail(fromHolder ?: extraCover)
}

private fun formatTrackDuration(durationMs: Long?): String {
    if (durationMs == null || durationMs <= 0L) return "--:--"
    val totalSeconds = durationMs / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "${minutes}:${seconds.toString().padStart(2, '0')}"
}

// =========================================================================
// MINI EQUALIZER BARS (Clean Monochrome Indicator)
// =========================================================================

@Composable
fun MiniEqualizerBars(
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {
    if (!isPlaying) {
        Row(
            modifier = modifier.size(width = 16.dp, height = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Box(Modifier.width(3.dp).fillMaxHeight(0.3f).clip(RoundedCornerShape(1.5.dp)).background(color))
            Box(Modifier.width(3.dp).fillMaxHeight(0.6f).clip(RoundedCornerShape(1.5.dp)).background(color))
            Box(Modifier.width(3.dp).fillMaxHeight(0.4f).clip(RoundedCornerShape(1.5.dp)).background(color))
        }
        return
    }

    val infiniteTransition = rememberInfiniteTransition(label = "EqualizerTransition")

    val height1 by infiniteTransition.animateFloat(
        initialValue = 0.25f,
        targetValue = 0.95f,
        animationSpec = infiniteRepeatable(
            animation = tween(420, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Bar1"
    )
    val height2 by infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 0.30f,
        animationSpec = infiniteRepeatable(
            animation = tween(550, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Bar2"
    )
    val height3 by infiniteTransition.animateFloat(
        initialValue = 0.40f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(380, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Bar3"
    )

    Row(
        modifier = modifier.size(width = 16.dp, height = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            Modifier
                .width(3.dp)
                .fillMaxHeight(height1)
                .clip(RoundedCornerShape(1.5.dp))
                .background(color)
        )
        Box(
            Modifier
                .width(3.dp)
                .fillMaxHeight(height2)
                .clip(RoundedCornerShape(1.5.dp))
                .background(color)
        )
        Box(
            Modifier
                .width(3.dp)
                .fillMaxHeight(height3)
                .clip(RoundedCornerShape(1.5.dp))
                .background(color)
        )
    }
}

// =========================================================================
// DECENT MONOCHROMATIC CATEGORY CARD
// =========================================================================

data class SearchCategoryItem(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val query: String
)

@Composable
fun CategoryCard(
    category: SearchCategoryItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        modifier = modifier
            .height(88.dp)
            .pointerHoverIcon(PointerIcon.Hand),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = if (isHovered) Color.White.copy(alpha = 0.12f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
        borderColor = if (isHovered) Color.White.copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = category.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    color = TextPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = category.subtitle,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                    color = TextMuted,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(Modifier.width(8.dp))

            LiquidGlassBox(
                shape = CircleShape,
                modifier = Modifier.size(38.dp)
            ) {
                Icon(
                    imageVector = category.icon,
                    contentDescription = null,
                    tint = if (isHovered) TextPrimary else TextSecondary,
                    modifier = Modifier.size(19.dp)
                )
            }
        }
    }
}

// =========================================================================
// =========================================================================
// RECOMMENDED TRACK TASTE CARD & DISCOVERY HUB
// =========================================================================

@Composable
fun RecommendedTrackTasteCard(
    track: Track,
    onPlay: () -> Unit,
    onAddToPlaylist: () -> Unit,
    onDownload: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        modifier = modifier
            .width(172.dp)
            .pointerHoverIcon(PointerIcon.Hand),
        shape = RoundedCornerShape(14.dp),
        backgroundColor = if (isHovered) Color.White.copy(alpha = 0.12f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
        borderColor = if (isHovered) Color.White.copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),
        onClick = onPlay
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val coverUrl = track.extractCoverUrl()
            LiquidGlassBox(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(148.dp)
            ) {
                if (coverUrl != null) {
                    AsyncImage(
                        model = coverUrl,
                        contentDescription = track.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Icon(
                        Icons.Default.MusicNote,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(42.dp)
                    )
                }

                if (isHovered) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.35f)),
                        contentAlignment = Alignment.Center
                    ) {
                        LiquidGlassBox(
                            shape = CircleShape,
                            backgroundColor = Color.White.copy(alpha = 0.90f),
                            borderColor = Color.White,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                                Icon(
                                    Icons.Default.PlayArrow,
                                    contentDescription = "Play",
                                    tint = Color.Black,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }
                    }
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = cleanDisplayTitle(track.title),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = formatArtistsForDisplay(track.artists, "Audix Artist"),
                    fontSize = 11.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LiquidGlassBox(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                    borderColor = Color.White.copy(alpha = 0.08f)
                ) {
                    Text(
                        text = "320k",
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onAddToPlaylist,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.PlaylistAdd,
                            contentDescription = "Add to playlist",
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                    }

                    IconButton(
                        onClick = onDownload,
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Default.Download,
                            contentDescription = "Download offline",
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchDiscoveryHub(
    recentSearches: List<String>,
    onSelectQuery: (String) -> Unit,
    onRemoveRecent: (String) -> Unit,
    onClearRecents: () -> Unit,
    onPlayTrack: (Track, List<Track>) -> Unit = { _, _ -> },
    onAddToPlaylist: (Track) -> Unit = {},
    onDownloadTrack: (Track) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val libraryManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val downloadManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }

    val favorites by libraryManager.favorites.collectAsState()
    val history by libraryManager.history.collectAsState()
    val playlists by libraryManager.playlists.collectAsState()

    val recommendedTracks = remember(favorites, history, playlists) {
        libraryManager.getRecommendedTracks()
    }
    val userFavoriteArtists = remember(favorites, history, playlists) {
        libraryManager.getUserFavoriteArtists()
    }

    val categories = remember {
        listOf(
            SearchCategoryItem("Pop", "Top charts & popular hits", Icons.Default.MusicNote, "Pop"),
            SearchCategoryItem("Hip-Hop & Rap", "Beats, rhythm & rhymes", Icons.Default.GraphicEq, "Hip Hop"),
            SearchCategoryItem("Lo-Fi & Chill", "Relax, study & focus beats", Icons.Default.History, "Lo-Fi Beats"),
            SearchCategoryItem("Rock & Alt", "Classics, modern & indie rock", Icons.Default.PlayArrow, "Rock"),
            SearchCategoryItem("Electronic & EDM", "Dance, house & synthwave", Icons.Default.Settings, "EDM"),
            SearchCategoryItem("Ambient & Focus", "Deep study & background peaceful music", Icons.Default.AccessTime, "Deep Focus Ambient"),
            SearchCategoryItem("Bollywood & Desi", "Indian classics & trending hits", Icons.AutoMirrored.Filled.TrendingUp, "Bollywood Top Hits"),
            SearchCategoryItem("Acoustic & Folk", "Unplugged instruments & warm melodies", Icons.Default.LibraryMusic, "Acoustic"),
            SearchCategoryItem("Jazz & Blues", "Smooth horns, swing & soul", Icons.Default.Palette, "Jazz Soul"),
            SearchCategoryItem("Classical & Piano", "Orchestras, symphonies & solo piano", Icons.Default.FolderOpen, "Classical Piano")
        )
    }

    val trendingPills = remember {
        listOf(
            "Global Top 50", "The Weeknd", "Hans Zimmer", "Synthwave 80s",
            "Midnight Lofi", "Coldplay", "Workout Energy", "Taylor Swift",
            "Interstellar OST", "Cyberpunk"
        )
    }

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val screenWidth = maxWidth
        val columnsCount = when {
            screenWidth < 750.dp -> 2
            screenWidth < 1150.dp -> 3
            screenWidth < 1550.dp -> 4
            else -> 5
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            // 0. TASTE RECOMMENDATION ENGINE ("Recommended For You • Personalized To Your Taste")
            item {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(7.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF38BDF8))
                                )
                                Text(
                                    text = "Recommended For You",
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    ),
                                    color = TextPrimary
                                )
                            }
                            Text(
                                text = if (userFavoriteArtists.isNotEmpty())
                                    "Personalized to your taste: ${userFavoriteArtists.take(3).joinToString(", ")}"
                                else
                                    "Adaptive recommendation engine tailored to your music taste",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondary
                            )
                        }

                        LiquidGlassBox(
                            shape = RoundedCornerShape(20.dp),
                            backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                            borderColor = Color.White.copy(alpha = 0.20f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    Icons.Default.AutoAwesome,
                                    contentDescription = null,
                                    tint = Color(0xFF38BDF8),
                                    modifier = Modifier.size(13.dp)
                                )
                                Text(
                                    text = "Taste Engine",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    // User's Favorite Artists Pills (if any)
                    if (userFavoriteArtists.isNotEmpty()) {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(vertical = 2.dp)
                        ) {
                            items(userFavoriteArtists, key = { it }) { artist ->
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(16.dp),
                                    backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                                    borderColor = Color.White.copy(alpha = 0.15f),
                                    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                                    onClick = { onSelectQuery(artist) }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(
                                            Icons.Default.Person,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Text(
                                            text = artist,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Recommended Tracks Row
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        contentPadding = PaddingValues(vertical = 4.dp)
                    ) {
                        items(recommendedTracks, key = { it.id }) { track ->
                            RecommendedTrackTasteCard(
                                track = track,
                                onPlay = { onPlayTrack(track, recommendedTracks) },
                                onAddToPlaylist = { onAddToPlaylist(track) },
                                onDownload = {
                                    downloadManager.downloadTrack(track)
                                    onDownloadTrack(track)
                                }
                            )
                        }
                    }
                }
            }

            // 1. RECENT SEARCHES (if any)
            if (recentSearches.isNotEmpty()) {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Recent Searches",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = TextPrimary
                            )
                            TextButton(
                                onClick = onClearRecents,
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    "Clear all",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = TextMuted
                                )
                            }
                        }

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(vertical = 2.dp)
                        ) {
                            items(recentSearches, key = { it }) { term ->
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(18.dp),
                                    backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                                    borderColor = Color.White.copy(alpha = 0.12f),
                                    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .clickable { onSelectQuery(term) }
                                            .padding(start = 12.dp, end = 6.dp, top = 6.dp, bottom = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(
                                            Icons.Default.History,
                                            contentDescription = null,
                                            tint = TextMuted,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Text(
                                            text = term,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = TextPrimary
                                        )
                                        IconButton(
                                            onClick = { onRemoveRecent(term) },
                                            modifier = Modifier.size(18.dp)
                                        ) {
                                            Icon(
                                                Icons.Default.Close,
                                                contentDescription = "Remove",
                                                tint = TextMuted,
                                                modifier = Modifier.size(12.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 2. TRENDING NOW
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Trending Suggestions",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = TextPrimary
                    )

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(vertical = 2.dp)
                    ) {
                        items(trendingPills, key = { it }) { pill ->
                            LiquidGlassBox(
                                shape = RoundedCornerShape(18.dp),
                                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                                borderColor = Color.White.copy(alpha = 0.12f),
                                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                                onClick = { onSelectQuery(pill) }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        Icons.AutoMirrored.Filled.TrendingUp,
                                        contentDescription = null,
                                        tint = TextSecondary,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Text(
                                        text = pill,
                                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                                        color = TextPrimary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // 3. EXPLORE CATEGORIES & GENRES (Clean Responsive Multi-Column Grid)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                        Text(
                            text = "Browse All",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            ),
                            color = TextPrimary
                        )
                        Text(
                            text = "Explore music genres, mood playlists, and charts",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondary
                        )
                    }

                    val rows = categories.chunked(columnsCount)
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        rows.forEach { rowItems ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                rowItems.forEach { cat ->
                                    CategoryCard(
                                        category = cat,
                                        onClick = { onSelectQuery(cat.query) },
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                                val missing = columnsCount - rowItems.size
                                repeat(missing) {
                                    Spacer(Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


// =========================================================================
// SPOTLIGHT TOP RESULT HERO CARD (Clean Monochromatic Design)
// =========================================================================

@Composable
fun TopResultSpotlightCard(
    item: EchoMediaItem,
    isCurrentTrack: Boolean,
    isPlaying: Boolean,
    onPlay: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val typeLabel = when (item) {
        is Artist -> "ARTIST"
        is Album -> "ALBUM"
        is Playlist -> "PLAYLIST"
        is Track -> "SONG"
        else -> "MEDIA"
    }

    val isCircular = item is Artist

    LiquidGlassCard(
        modifier = modifier
            .fillMaxWidth()
            .pointerHoverIcon(PointerIcon.Hand),
        shape = RoundedCornerShape(14.dp),
        backgroundColor = if (isHovered) Color.White.copy(alpha = 0.12f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
        borderColor = if (isHovered) Color.White.copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Visual Cover Artwork + Play button top row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                val coverUrl = item.extractCoverUrl()
                LiquidGlassBox(
                    shape = if (isCircular) CircleShape else RoundedCornerShape(10.dp),
                    modifier = Modifier.size(92.dp)
                ) {
                    if (coverUrl != null) {
                        AsyncImage(
                            model = coverUrl,
                            contentDescription = item.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Icon(
                            imageVector = if (isCircular) Icons.Default.Palette else Icons.Default.MusicNote,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.4f),
                            modifier = Modifier
                                .size(40.dp)
                                .align(Alignment.Center)
                        )
                    }
                }

                LiquidGlassBox(
                    shape = CircleShape,
                    backgroundColor = Color.White,
                    borderColor = Color.White,
                    modifier = Modifier
                        .size(46.dp)
                        .pointerHoverIcon(PointerIcon.Hand),
                    onClick = onPlay
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            imageVector = if (isCurrentTrack && isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            // Title & Subtitle
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    color = TextPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.subtitle ?: (if (item is Artist) "Artist" else ""),
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Bottom badge row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LiquidGlassBox(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                    borderColor = Color.White.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = typeLabel,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        ),
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                if (isCurrentTrack) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MiniEqualizerBars(isPlaying = isPlaying, color = Color.White)
                        Text(
                            "PLAYING",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}


// =========================================================================
// SEARCH TRACK ITEM ROW (Desktop Standard Track Table Row)
// =========================================================================

@Composable
fun SearchTrackItemRow(
    track: Track,
    index: Int,
    isCurrentTrack: Boolean,
    isPlaying: Boolean,
    onPlay: () -> Unit,
    onAddToPlaylist: () -> Unit,
    onDownload: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val backgroundColor = when {
        isCurrentTrack -> Color(0xFF222222)
        isHovered -> Color(0xFF1A1A1A)
        else -> Color.Transparent
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(interactionSource = interactionSource, indication = null, onClick = onPlay)
            .padding(horizontal = 12.dp, vertical = 7.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Track Index or Equalizer or Play Icon
        Box(
            modifier = Modifier.width(26.dp),
            contentAlignment = Alignment.Center
        ) {
            when {
                isCurrentTrack -> {
                    MiniEqualizerBars(isPlaying = isPlaying, color = Color.White)
                }
                isHovered -> {
                    Icon(
                        Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
                else -> {
                    Text(
                        text = "${index + 1}",
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                        color = TextMuted
                    )
                }
            }
        }

        // Cover Thumbnail
        val coverUrl = track.extractCoverUrl()
        LiquidGlassBox(
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.size(40.dp)
        ) {
            if (coverUrl != null) {
                AsyncImage(
                    model = coverUrl,
                    contentDescription = track.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Icon(
                    Icons.Default.MusicNote,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.3f),
                    modifier = Modifier.size(18.dp).align(Alignment.Center)
                )
            }
        }

        // Title and Subtitle (Artist)
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = track.title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = if (isCurrentTrack) FontWeight.Bold else FontWeight.SemiBold
                    ),
                    color = TextPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f, fill = false)
                )

                val sourceTag = track.extras["source_name"] ?: when {
                    track.extras["extension_id"]?.contains("youtube", true) == true -> "YouTube"
                    track.extras["extension_id"]?.contains("saavn", true) == true || track.extras["source"] == "JioSaavn" -> "JioSaavn"
                    track.extras["extension_id"]?.contains("spotify", true) == true -> "Spotify"
                    track.extras["extension_id"]?.contains("soundcloud", true) == true -> "SoundCloud"
                    track.extras["extension_id"]?.contains("radio", true) == true -> "Radio"
                    else -> null
                }
                if (sourceTag != null) {
                    val (badgeBg, badgeBorder, badgeText) = when {
                        sourceTag.contains("YouTube", true) -> Triple(Color(0x33FF0000), Color(0x66FF0000), Color(0xFFFF6E6E))
                        sourceTag.contains("Saavn", true) -> Triple(Color(0x3310B981), Color(0x6610B981), Color(0xFF34D399))
                        sourceTag.contains("Spotify", true) -> Triple(Color(0x331DB954), Color(0x661DB954), Color(0xFF1DB954))
                        sourceTag.contains("SoundCloud", true) -> Triple(Color(0x33F97316), Color(0x66F97316), Color(0xFFFB923C))
                        sourceTag.contains("Radio", true) -> Triple(Color(0x3338BDF8), Color(0x6638BDF8), Color(0xFF38BDF8))
                        else -> Triple(Color(0x22FFFFFF), Color(0x44FFFFFF), Color(0xFFCCCCCC))
                    }
                    LiquidGlassBox(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = badgeBg,
                        borderColor = badgeBorder
                    ) {
                        Text(
                            text = sourceTag,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = badgeText,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                        )
                    }
                }
            }
            Text(
                text = track.subtitle ?: "Unknown Artist",
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Album Name (if space permits)
        val albumTitle = track.album?.title
        if (!albumTitle.isNullOrBlank()) {
            Text(
                text = albumTitle,
                style = MaterialTheme.typography.bodySmall,
                color = TextMuted,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(0.7f)
                    .padding(horizontal = 8.dp)
            )
        }

        // Duration
        Text(
            text = formatTrackDuration(track.duration),
            style = MaterialTheme.typography.labelMedium,
            color = TextSecondary
        )

        // Add to Playlist Button
        IconButton(
            onClick = onAddToPlaylist,
            modifier = Modifier.size(28.dp)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.PlaylistAdd,
                contentDescription = "Add to Playlist",
                tint = if (isHovered) TextPrimary else Color.Transparent,
                modifier = Modifier.size(18.dp)
            )
        }

        // Download Button
        IconButton(
            onClick = onDownload,
            modifier = Modifier.size(28.dp)
        ) {
            Icon(
                Icons.Default.Download,
                contentDescription = "Download Offline",
                tint = if (isHovered) TextSecondary else Color.Transparent,
                modifier = Modifier.size(17.dp)
            )
        }
    }
}

// =========================================================================
// TOP SONGS QUICK LIST (Right side of Spotlight Card)
// =========================================================================

@Composable
fun TopSongsQuickList(
    tracks: List<Track>,
    currentTrack: Track?,
    isPlaying: Boolean,
    onPlayTrack: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LiquidGlassCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
        borderColor = Color.White.copy(alpha = 0.12f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Songs",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = TextPrimary
                )
                Text(
                    text = "${tracks.size} top results",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextMuted
                )
            }

            tracks.forEachIndexed { index, track ->
                val isCurrent = currentTrack?.id == track.id
                SearchTrackItemRow(
                    track = track,
                    index = index,
                    isCurrentTrack = isCurrent,
                    isPlaying = isPlaying,
                    onPlay = { onPlayTrack(track) },
                    onAddToPlaylist = { onAddToPlaylist(track) },
                    onDownload = { onDownloadTrack(track) }
                )
            }
        }
    }
}

// =========================================================================
// ZERO RESULTS STATE VIEW (Decent Monochrome)
// =========================================================================

@Composable
fun SearchZeroResultsView(
    query: String,
    extensions: List<MusicExtension>,
    currentExt: MusicExtension?,
    onSwitchExtension: (MusicExtension) -> Unit,
    onClearSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LiquidGlassBox(
            shape = CircleShape,
            modifier = Modifier.size(72.dp)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = TextSecondary,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(Modifier.height(18.dp))

        Text(
            text = "No results found for \"$query\"",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = TextPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = "Please check your spelling, try fewer keywords, or switch your audio source.",
            style = MaterialTheme.typography.bodyMedium,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.widthIn(max = 480.dp)
        )

        val otherExtensions = extensions.filter { it.metadata.id != currentExt?.metadata?.id }
        if (otherExtensions.isNotEmpty()) {
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Try searching on:",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                color = TextMuted
            )
            Spacer(Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                otherExtensions.forEach { ext ->
                    Button(
                        onClick = { onSwitchExtension(ext) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = SurfaceCard,
                            contentColor = TextPrimary
                        ),
                        border = BorderStroke(1.dp, BorderMuted),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            Icons.Default.Extension,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp),
                            tint = Color.White
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = ext.metadata.name,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        OutlinedButton(
            onClick = onClearSearch,
            shape = RoundedCornerShape(18.dp),
            border = BorderStroke(1.dp, BorderSubtle),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
        ) {
            Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(15.dp))
            Spacer(Modifier.width(6.dp))
            Text("Clear Search")
        }
    }
}

// =========================================================================
// LOADING SKELETON (Monochrome)
// =========================================================================

@Composable
fun SearchLoadingSkeleton(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "SkeletonTransition")
    val alpha by transition.animateFloat(
        initialValue = 0.15f,
        targetValue = 0.45f,
        animationSpec = infiniteRepeatable(
            animation = tween(700, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Alpha"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.42f)
                    .height(200.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF262626).copy(alpha = alpha))
            )
            Box(
                modifier = Modifier
                    .weight(0.58f)
                    .height(200.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFF262626).copy(alpha = alpha))
            )
        }

        Box(
            modifier = Modifier
                .width(160.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFF262626).copy(alpha = alpha))
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(4) {
                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF262626).copy(alpha = alpha))
                )
            }
        }
    }
}

// =========================================================================
// SEARCH ERROR BANNER (Decent Monochrome)
// =========================================================================

@Composable
fun SearchErrorBanner(
    error: Throwable?,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    LiquidGlassCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.40f),
        borderColor = Color.White.copy(alpha = 0.15f)
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                Icons.Default.Close,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Unable to fetch search results",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = TextPrimary
                )
                Text(
                    text = error?.localizedMessage ?: "Provider timed out or network error occurred.",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Retry", fontWeight = FontWeight.Bold)
            }
        }
    }
}

// =========================================================================
// ADD TO PLAYLIST DIALOG (Monochrome)
// =========================================================================

@Composable
fun AddToPlaylistDialog(
    track: Track,
    onDismiss: () -> Unit,
    libraryManager: DesktopLibraryManager? = null
) {
    val libMgr = remember(libraryManager) {
        libraryManager ?: runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val playlists by libMgr.playlists.collectAsState()
    var isCreatingNew by remember { mutableStateOf(false) }
    var newPlaylistTitle by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = if (isCreatingNew) "Create New Playlist" else "Add to Playlist",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = TextPrimary
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 360.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                LiquidGlassBox(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color(0x60181818),
                    borderColor = Color.White.copy(alpha = 0.12f)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        val coverUrl = track.extractCoverUrl()
                        LiquidGlassBox(
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier.size(36.dp)
                        ) {
                            if (coverUrl != null) {
                                AsyncImage(
                                    model = coverUrl,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            } else {
                                Icon(
                                    Icons.Default.MusicNote,
                                    contentDescription = null,
                                    tint = Color.White.copy(alpha = 0.5f),
                                    modifier = Modifier.size(18.dp).align(Alignment.Center)
                                )
                            }
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = track.title,
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                                color = TextPrimary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = track.subtitle ?: "Unknown Artist",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                if (isCreatingNew) {
                    OutlinedTextField(
                        value = newPlaylistTitle,
                        onValueChange = { newPlaylistTitle = it },
                        label = { Text("Playlist Title", color = TextSecondary) },
                        placeholder = { Text("e.g. Late Night Vibes", color = TextMuted) },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = BorderSubtle
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    if (playlists.isEmpty()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "No playlists created yet.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextSecondary
                            )
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            items(playlists, key = { it.id }) { pl ->
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(8.dp),
                                    backgroundColor = Color(0x60181818),
                                    borderColor = Color.White.copy(alpha = 0.12f),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .pointerHoverIcon(PointerIcon.Hand)
                                        .clickable {
                                            libMgr.addTrackToPlaylist(pl.id, track)
                                            onDismiss()
                                        }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Icon(
                                            Icons.AutoMirrored.Filled.PlaylistAdd,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = pl.title,
                                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                                                color = TextPrimary
                                            )
                                            Text(
                                                text = "${pl.tracks.size} tracks",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = TextSecondary
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            if (isCreatingNew) {
                Button(
                    onClick = {
                        if (newPlaylistTitle.isNotBlank()) {
                            val created = libMgr.createPlaylist(newPlaylistTitle.trim(), "")
                            libMgr.addTrackToPlaylist(created.id, track)
                            onDismiss()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    enabled = newPlaylistTitle.isNotBlank()
                ) {
                    Text("Create & Add", fontWeight = FontWeight.Bold)
                }
            } else {
                Button(
                    onClick = { isCreatingNew = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("New Playlist", fontWeight = FontWeight.Bold)
                }
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    if (isCreatingNew) {
                        isCreatingNew = false
                    } else {
                        onDismiss()
                    }
                }
            ) {
                Text(if (isCreatingNew) "Back" else "Cancel", color = TextSecondary)
            }
        },
        containerColor = SurfaceDark,
        shape = RoundedCornerShape(14.dp)
    )
}

// =========================================================================
// UNIFIED CATALOG AGGREGATOR & DETAIL MODALS
// =========================================================================

object UnifiedCatalogEngine {
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(12, java.util.concurrent.TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val jsonParser = Json { ignoreUnknownKeys = true }
    private val saavnDesKey = "38346591".toByteArray(Charsets.UTF_8)

    fun decryptSaavnRaw(encUrl: String): String? {
        return runCatching {
            val cleanEnc = encUrl.replace("\\/", "/").replace("\\", "").trim()
            if (cleanEnc.length < 8 || cleanEnc.length > 2048) return null
            val cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, javax.crypto.spec.SecretKeySpec(saavnDesKey, "DES"))
            var normalizedBase64 = cleanEnc.replace("-", "+").replace("_", "/")
            val missingPadding = (4 - (normalizedBase64.length % 4)) % 4
            normalizedBase64 += "=".repeat(missingPadding)
            val decoded = runCatching { java.util.Base64.getDecoder().decode(normalizedBase64) }
                .getOrElse { java.util.Base64.getUrlDecoder().decode(cleanEnc) }
            val decrypted = cipher.doFinal(decoded)
            String(decrypted, Charsets.UTF_8).trim()
        }.getOrNull()
    }

    fun decryptSaavnUrl(encUrl: String): String? {
        val raw = decryptSaavnRaw(encUrl) ?: return null
        return raw.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
    }

    fun unescapeHtml(text: String): String {
        return text
            .replace("&quot;", "\"")
            .replace("&amp;", "&")
            .replace("&#039;", "'")
            .replace("&apos;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .trim()
    }

    suspend fun fetchSaavnSearchCatalog(query: String): List<Shelf> = withContext(Dispatchers.IO) {
        val shelves = mutableListOf<Shelf>()
        val encoded = runCatching { java.net.URLEncoder.encode(query, "UTF-8") }.getOrDefault(query)

        // 1. Fetch Tracks
        runCatching {
            val url = "https://www.jiosaavn.com/api.php?__call=search.getResults&_format=json&_marker=0&ctx=android&p=1&n=25&q=$encoded"
            val req = Request.Builder().url(url).header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)").build()
            okHttpClient.newCall(req).execute().use { resp ->
                if (resp.isSuccessful) {
                    val body = resp.body?.string() ?: ""
                    val root = jsonParser.parseToJsonElement(body).jsonObject
                    val results = root["results"]?.jsonArray ?: kotlinx.serialization.json.JsonArray(emptyList())
                    val tracks = results.mapNotNull { elem ->
                        val obj = elem.jsonObject
                        val id = obj["id"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        val rawTitle = obj["song"]?.jsonPrimitive?.content ?: "Unknown Track"
                        val rawArtist = obj["primary_artists"]?.jsonPrimitive?.content ?: "Unknown Artist"
                        val realTitle = unescapeHtml(rawTitle)
                        val realArtist = unescapeHtml(rawArtist)
                        val rawImage = obj["image"]?.jsonPrimitive?.content ?: ""
                        val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
                        val durSec = obj["duration"]?.jsonPrimitive?.content?.toLongOrNull() ?: 0L
                        val durationMs = durSec * 1000L
                        val albumName = unescapeHtml(obj["album"]?.jsonPrimitive?.content ?: "")

                        val encUrl = obj["encrypted_media_url"]?.jsonPrimitive?.content
                        val previewUrl = obj["media_preview_url"]?.jsonPrimitive?.content
                        val streamUrl = encUrl?.let { decryptSaavnUrl(it) } ?: previewUrl ?: ""

                        val coverHolder = if (highResImage.isNotBlank()) ImageHolder.NetworkRequestImageHolder(highResImage.toGetRequest(), false) else null
                        val artistList = if (realArtist.contains(",") || realArtist.contains("&")) {
                            realArtist.split(REGEX_ARTIST_SPLIT).map { it.trim() }.filter { it.isNotBlank() }.map { Artist(id = it, name = it) }
                        } else listOf(Artist(id = realArtist, name = realArtist))

                        val streamable = if (streamUrl.isNotBlank()) {
                            Streamable.server(
                                id = id,
                                quality = 320,
                                title = "320 kbps (JioSaavn HQ)",
                                extras = mapOf(
                                    "stream_url" to streamUrl,
                                    "extension_id" to "saavn_music",
                                    "track_title" to realTitle,
                                    "artist_name" to realArtist
                                )
                            )
                        } else null

                        Track(
                            id = id,
                            title = realTitle,
                            artists = artistList,
                            album = if (albumName.isNotBlank()) Album(id = albumName, title = albumName, cover = coverHolder) else null,
                            cover = coverHolder,
                            streamables = if (streamable != null) listOf(streamable) else emptyList(),
                            duration = durationMs,
                            extras = buildMap {
                                put("extension_id", "saavn_music")
                                put("source_name", "JioSaavn")
                                put("source", "JioSaavn")
                                put("song_id", id)
                                if (streamUrl.isNotBlank()) put("stream_url", streamUrl)
                                put("track_title", realTitle)
                                put("artist_name", realArtist)
                                if (highResImage.isNotBlank()) put("cover_url", highResImage)
                                if (albumName.isNotBlank()) put("album_name", albumName)
                            }
                        )
                    }
                    if (tracks.isNotEmpty()) {
                        shelves.add(Shelf.Lists.Tracks(id = "saavn_tracks", title = "JioSaavn Studio Tracks", list = tracks))
                    }
                }
            }
        }

        // 2. Fetch Albums
        runCatching {
            val url = "https://www.jiosaavn.com/api.php?__call=search.getAlbumResults&_format=json&ctx=android&p=1&n=12&q=$encoded"
            val req = Request.Builder().url(url).header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)").build()
            okHttpClient.newCall(req).execute().use { resp ->
                if (resp.isSuccessful) {
                    val body = resp.body?.string() ?: ""
                    val root = jsonParser.parseToJsonElement(body).jsonObject
                    val results = root["results"]?.jsonArray ?: kotlinx.serialization.json.JsonArray(emptyList())
                    val albums = results.mapNotNull { elem ->
                        val obj = elem.jsonObject
                        val id = obj["id"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        val rawTitle = obj["title"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        val realTitle = unescapeHtml(rawTitle)
                        val rawArtist = obj["primary_artists"]?.jsonPrimitive?.content ?: obj["artist"]?.jsonPrimitive?.content ?: ""
                        val realArtist = unescapeHtml(rawArtist)
                        val rawImage = obj["image"]?.jsonPrimitive?.content ?: ""
                        val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
                        val year = obj["year"]?.jsonPrimitive?.content ?: ""
                        val coverHolder = if (highResImage.isNotBlank()) ImageHolder.NetworkRequestImageHolder(highResImage.toGetRequest(), false) else null

                        Album(
                            id = id,
                            title = realTitle,
                            artists = if (realArtist.isNotBlank()) listOf(Artist(id = realArtist, name = realArtist)) else emptyList(),
                            cover = coverHolder,
                            subtitle = year,
                            extras = buildMap {
                                put("extension_id", "saavn_music")
                                put("source_name", "JioSaavn")
                                put("album_id", id)
                                if (highResImage.isNotBlank()) put("cover_url", highResImage)
                            }
                        )
                    }
                    if (albums.isNotEmpty()) {
                        shelves.add(Shelf.Lists.Items(id = "saavn_albums", title = "JioSaavn Albums", list = albums))
                    }
                }
            }
        }

        // 3. Fetch Artists
        runCatching {
            val url = "https://www.jiosaavn.com/api.php?__call=search.getArtistResults&_format=json&ctx=android&p=1&n=8&q=$encoded"
            val req = Request.Builder().url(url).header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)").build()
            okHttpClient.newCall(req).execute().use { resp ->
                if (resp.isSuccessful) {
                    val body = resp.body?.string() ?: ""
                    val root = jsonParser.parseToJsonElement(body).jsonObject
                    val results = root["results"]?.jsonArray ?: kotlinx.serialization.json.JsonArray(emptyList())
                    val artists = results.mapNotNull { elem ->
                        val obj = elem.jsonObject
                        val id = obj["artistid"]?.jsonPrimitive?.content ?: obj["id"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        val rawName = obj["name"]?.jsonPrimitive?.content ?: return@mapNotNull null
                        val realName = unescapeHtml(rawName)
                        val rawImage = obj["image"]?.jsonPrimitive?.content ?: ""
                        val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
                        val coverHolder = if (highResImage.isNotBlank()) ImageHolder.NetworkRequestImageHolder(highResImage.toGetRequest(), false) else null

                        Artist(
                            id = id,
                            name = realName,
                            cover = coverHolder,
                            subtitle = "JioSaavn Artist",
                            extras = buildMap {
                                put("extension_id", "saavn_music")
                                put("source_name", "JioSaavn")
                                put("artist_id", id)
                                if (highResImage.isNotBlank()) put("cover_url", highResImage)
                            }
                        )
                    }
                    if (artists.isNotEmpty()) {
                        shelves.add(Shelf.Lists.Items(id = "saavn_artists", title = "Artists", list = artists))
                    }
                }
            }
        }

        shelves
    }

    suspend fun loadAlbumTracks(album: Album, extensionManager: ExtensionManager): List<Track> = withContext(Dispatchers.IO) {
        val extId = album.extras["extension_id"]
        val allMusic = extensionManager.music.value
        val ext = allMusic.firstOrNull { it.id.equals(extId, ignoreCase = true) || it.metadata.id.equals(extId, ignoreCase = true) }
            ?: extensionManager.current.value ?: allMusic.firstOrNull()

        if (ext != null) {
            val albumClient = runCatching {
                (ext.instance.value ?: ext.instance.value().getOrNull()) as? dev.brahmkshatriya.echo.common.clients.AlbumClient
            }.getOrNull()
            if (albumClient != null) {
                val extTracks = runCatching {
                    val feed = albumClient.loadTracks(album)
                    val pagedData = feed?.getPagedData(null)?.pagedData
                    pagedData?.loadAll() ?: emptyList<Track>()
                }.getOrNull()
                if (!extTracks.isNullOrEmpty()) {
                    return@withContext extTracks.map { t ->
                        t.copy(extras = t.extras + ("extension_id" to ext.id) + ("source_name" to ext.metadata.name))
                    }
                }
            }
        }

        val albumId = album.extras["album_id"] ?: album.id.takeIf { it.all { ch -> ch.isDigit() } }
        if (!albumId.isNullOrBlank()) {
            val tracks = runCatching {
                val url = "https://www.jiosaavn.com/api.php?__call=content.getAlbumDetails&_format=json&albumid=$albumId"
                val req = Request.Builder().url(url).header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)").build()
                okHttpClient.newCall(req).execute().use { resp ->
                    if (resp.isSuccessful) {
                        val body = resp.body?.string() ?: ""
                        val root = jsonParser.parseToJsonElement(body).jsonObject
                        val songs = root["songs"]?.jsonArray ?: return@use emptyList<Track>()
                        songs.mapNotNull { elem ->
                            val obj = elem.jsonObject
                            val sId = obj["id"]?.jsonPrimitive?.content ?: return@mapNotNull null
                            val rawTitle = obj["song"]?.jsonPrimitive?.content ?: return@mapNotNull null
                            val realTitle = unescapeHtml(rawTitle)
                            val rawArtist = obj["primary_artists"]?.jsonPrimitive?.content ?: ""
                            val realArtist = unescapeHtml(rawArtist)
                            val rawImage = obj["image"]?.jsonPrimitive?.content ?: ""
                            val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
                            val durSec = obj["duration"]?.jsonPrimitive?.content?.toLongOrNull() ?: 0L
                            val coverHolder = if (highResImage.isNotBlank()) ImageHolder.NetworkRequestImageHolder(highResImage.toGetRequest(), false) else album.cover

                            val encUrl = obj["encrypted_media_url"]?.jsonPrimitive?.content
                            val previewUrl = obj["media_preview_url"]?.jsonPrimitive?.content
                            val streamUrl = encUrl?.let { decryptSaavnUrl(it) } ?: previewUrl ?: ""

                            val streamable = if (streamUrl.isNotBlank()) {
                                Streamable.server(
                                    id = sId,
                                    quality = 320,
                                    title = "320 kbps (JioSaavn HQ)",
                                    extras = mapOf(
                                        "stream_url" to streamUrl,
                                        "extension_id" to "saavn_music",
                                        "track_title" to realTitle,
                                        "artist_name" to realArtist
                                    )
                                )
                            } else null

                            Track(
                                id = sId,
                                title = realTitle,
                                artists = if (realArtist.isNotBlank()) listOf(Artist(id = realArtist, name = realArtist)) else album.artists,
                                album = album,
                                cover = coverHolder,
                                streamables = if (streamable != null) listOf(streamable) else emptyList(),
                                duration = durSec * 1000L,
                                extras = buildMap {
                                    put("extension_id", "saavn_music")
                                    put("source_name", "JioSaavn")
                                    put("source", "JioSaavn")
                                    put("song_id", sId)
                                    if (streamUrl.isNotBlank()) put("stream_url", streamUrl)
                                    put("track_title", realTitle)
                                    if (realArtist.isNotBlank()) put("artist_name", realArtist)
                                    if (highResImage.isNotBlank()) put("cover_url", highResImage)
                                }
                            )
                        }
                    } else emptyList()
                }
            }.getOrDefault(emptyList())

            if (tracks.isNotEmpty()) return@withContext tracks
        }

        val artistName = album.artists.firstOrNull()?.name ?: ""
        val targetQuery = if (artistName.isNotBlank()) "${album.title} $artistName" else album.title
        val searchShelves = fetchSaavnSearchCatalog(targetQuery)
        val candidateTracks = searchShelves.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
        if (candidateTracks.isNotEmpty()) {
            return@withContext candidateTracks.take(15)
        }

        emptyList()
    }

    suspend fun loadArtistDiscography(artist: Artist, extensionManager: ExtensionManager): Pair<List<Track>, List<Album>> = withContext(Dispatchers.IO) {
        val extId = artist.extras["extension_id"]
        val allMusic = extensionManager.music.value
        val ext = allMusic.firstOrNull { it.id.equals(extId, ignoreCase = true) || it.metadata.id.equals(extId, ignoreCase = true) }
            ?: extensionManager.current.value ?: allMusic.firstOrNull()

        var loadedTracks = emptyList<Track>()
        var loadedAlbums = emptyList<Album>()

        if (ext != null) {
            val artistClient = runCatching {
                (ext.instance.value ?: ext.instance.value().getOrNull()) as? dev.brahmkshatriya.echo.common.clients.ArtistClient
            }.getOrNull()
            if (artistClient != null) {
                runCatching {
                    val feed = artistClient.loadFeed(artist)
                    val pagedData = feed.getPagedData(null)?.pagedData
                    val shelves = pagedData?.loadAll() ?: emptyList<Shelf>()
                    val tracks = shelves.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
                    val albums = shelves.filterIsInstance<Shelf.Lists.Items>().flatMap { it.list }.filterIsInstance<Album>()
                    if (tracks.isNotEmpty()) loadedTracks = tracks.map { t -> t.copy(extras = t.extras + ("extension_id" to ext.id) + ("source_name" to ext.metadata.name)) }
                    if (albums.isNotEmpty()) loadedAlbums = albums
                }
            }
        }

        if (loadedTracks.isEmpty() || loadedAlbums.isEmpty()) {
            val saavnShelves = fetchSaavnSearchCatalog(artist.name)
            if (loadedTracks.isEmpty()) {
                val sTracks = saavnShelves.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
                if (sTracks.isNotEmpty()) loadedTracks = sTracks.take(15)
            }
            if (loadedAlbums.isEmpty()) {
                val sAlbums = saavnShelves.filterIsInstance<Shelf.Lists.Items>().flatMap { it.list }.filterIsInstance<Album>()
                if (sAlbums.isNotEmpty()) loadedAlbums = sAlbums.take(12)
            }
        }

        Pair(loadedTracks, loadedAlbums)
    }

    suspend fun searchUnified(
        query: String,
        musicExtensions: List<MusicExtension>,
        extensionManager: ExtensionManager
    ): List<Shelf> = kotlinx.coroutines.coroutineScope {
        val activeExtensions = musicExtensions.filter { it.isEnabled }.ifEmpty { musicExtensions }
        val deferredExt = activeExtensions.map { ext ->
            async(Dispatchers.IO) {
                val shelves: List<Shelf> = runCatching {
                    val client = (ext.instance.value ?: ext.instance.value().getOrNull()) as? dev.brahmkshatriya.echo.common.clients.SearchFeedClient
                    if (client != null) {
                        val feed = client.loadSearchFeed(query)
                        val pagedData = feed.getPagedData(null)?.pagedData
                        val loaded = pagedData?.loadAll() ?: emptyList<Shelf>()
                        loaded.map { s -> stampShelf(s, ext.id, ext.metadata.name) }
                    } else emptyList<Shelf>()
                }.getOrDefault(emptyList<Shelf>())
                shelves
            }
        }

        val saavnDeferred = async(Dispatchers.IO) {
            runCatching { fetchSaavnSearchCatalog(query) }.getOrDefault(emptyList<Shelf>())
        }

        val allShelves = deferredExt.awaitAll().flatten() + saavnDeferred.await()
        organizeShelves(allShelves)
    }

    private fun stampShelf(shelf: Shelf, extId: String, extName: String): Shelf {
        return when (shelf) {
            is Shelf.Lists.Tracks -> shelf.copy(list = shelf.list.map { t -> stampTrack(t, extId, extName) })
            is Shelf.Lists.Items -> shelf.copy(list = shelf.list.map { item ->
                if (item is Track) stampTrack(item, extId, extName) else item
            })
            else -> shelf
        }
    }

    private fun stampTrack(track: Track, extId: String, extName: String): Track {
        val existingExt = track.extras["extension_id"]
        val existingSrc = track.extras["source_name"] ?: track.extras["source"]
        val finalExtId = if (existingExt.isNullOrBlank()) extId else existingExt
        val finalSrcName = if (existingSrc.isNullOrBlank()) extName else existingSrc
        return track.copy(extras = track.extras + ("extension_id" to finalExtId) + ("source_name" to finalSrcName))
    }

    private fun organizeShelves(shelves: List<Shelf>): List<Shelf> {
        val result = mutableListOf<Shelf>()
        val allTracks = mutableListOf<Track>()
        val allAlbums = mutableListOf<Album>()
        val allArtists = mutableListOf<Artist>()
        val otherShelves = mutableListOf<Shelf>()

        for (shelf in shelves) {
            when (shelf) {
                is Shelf.Lists.Tracks -> allTracks.addAll(shelf.list)
                is Shelf.Lists.Items -> {
                    for (item in shelf.list) {
                        when (item) {
                            is Track -> allTracks.add(item)
                            is Album -> allAlbums.add(item)
                            is Artist -> allArtists.add(item)
                            else -> {}
                        }
                    }
                }
                else -> otherShelves.add(shelf)
            }
        }

        val seenTrackKeys = mutableSetOf<String>()
        val distinctTracks = mutableListOf<Track>()
        for (t in allTracks) {
            val key = "${t.title.lowercase().trim()}_${t.artists.firstOrNull()?.name?.lowercase()?.trim()}"
            if (seenTrackKeys.add(key)) {
                distinctTracks.add(t)
            }
        }
        if (distinctTracks.isNotEmpty()) {
            result.add(Shelf.Lists.Tracks(id = "unified_top_tracks", title = "Top Songs (Unified Catalog)", list = distinctTracks))
        }

        val seenAlbumKeys = mutableSetOf<String>()
        val distinctAlbums = mutableListOf<Album>()
        for (a in allAlbums) {
            val key = a.title.lowercase().trim()
            if (seenAlbumKeys.add(key)) {
                distinctAlbums.add(a)
            }
        }
        if (distinctAlbums.isNotEmpty()) {
            result.add(Shelf.Lists.Items(id = "unified_albums", title = "Albums (All Sources)", list = distinctAlbums))
        }

        val seenArtistKeys = mutableSetOf<String>()
        val distinctArtists = mutableListOf<Artist>()
        for (art in allArtists) {
            val key = art.name.lowercase().trim()
            if (seenArtistKeys.add(key)) {
                distinctArtists.add(art)
            }
        }
        if (distinctArtists.isNotEmpty()) {
            result.add(Shelf.Lists.Items(id = "unified_artists", title = "Artists (All Sources)", list = distinctArtists))
        }

        result.addAll(otherShelves)
        return result
    }
}

@Composable
fun ShelfMediaCardRow(
    title: String,
    subtitle: String,
    badge: String,
    coverUrl: String?,
    isCircle: Boolean = false,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(if (isHovered) Color.White.copy(alpha = 0.08f) else Color.Transparent)
            .clickable(interactionSource = interactionSource, indication = null, onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        val shape = if (isCircle) CircleShape else RoundedCornerShape(8.dp)
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(shape)
                .background(Color.White.copy(alpha = 0.06f))
        ) {
            if (!coverUrl.isNullOrBlank()) {
                AsyncImage(
                    model = coverUrl,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Icon(
                    imageVector = if (isCircle) Icons.Default.Person else Icons.Default.Album,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.4f),
                    modifier = Modifier.size(22.dp).align(Alignment.Center)
                )
            }
        }

        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        LiquidGlassBox(
            shape = RoundedCornerShape(6.dp),
            backgroundColor = Color.White.copy(alpha = 0.08f),
            borderColor = Color.White.copy(alpha = 0.15f)
        ) {
            Text(
                text = badge,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White.copy(alpha = 0.85f),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
            )
        }
    }
}

@Composable
fun SeniorShelfDetailModal(
    shelf: Shelf,
    onDismiss: () -> Unit,
    onMediaSelected: (EchoMediaItem) -> Unit,
    onPlayTrack: (Track, List<Track>) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    val items: List<EchoMediaItem> = remember(shelf) {
        when (shelf) {
            is Shelf.Lists.Tracks -> shelf.list
            is Shelf.Lists.Items -> shelf.list
            is Shelf.Item -> listOf(shelf.media)
            else -> emptyList()
        }
    }
    val tracks = remember(items) { items.filterIsInstance<Track>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.78f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                onDismiss()
            }
            .zIndex(100f),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(860.dp)
                .heightIn(max = 700.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                    // Prevent dismiss on inner click
                }
        ) {
            LiquidGlassBox(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.65f),
                borderColor = Color.White.copy(alpha = 0.22f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Text(
                                    text = shelf.title.ifBlank { "All Items" },
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(12.dp),
                                    backgroundColor = Color.White.copy(alpha = 0.12f),
                                    borderColor = Color.White.copy(alpha = 0.20f)
                                ) {
                                    Text(
                                        text = "${items.size} Items",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Full scrollable catalog view • Instant high-fidelity playback",
                                fontSize = 12.sp,
                                color = TextMuted
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (tracks.isNotEmpty()) {
                                Button(
                                    onClick = { onPlayTrack(tracks.first(), tracks) },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                                    shape = RoundedCornerShape(10.dp),
                                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                                ) {
                                    Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text("Play All", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                }

                                OutlinedButton(
                                    onClick = {
                                        val sh = tracks.shuffled()
                                        if (sh.isNotEmpty()) onPlayTrack(sh.first(), sh)
                                    },
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                                ) {
                                    Icon(Icons.Default.Shuffle, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text("Shuffle", color = Color.White, fontSize = 12.sp)
                                }
                            }

                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.10f))
                            ) {
                                Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(18.dp))
                            }
                        }
                    }

                    HorizontalDivider(color = Color.White.copy(alpha = 0.08f), thickness = 1.dp)

                    // Items List
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        itemsIndexed(items, key = { idx, item -> "${item.id}_$idx" }) { index, item ->
                            when (item) {
                                is Track -> {
                                    SearchTrackItemRow(
                                        track = item,
                                        index = index,
                                        isCurrentTrack = false,
                                        isPlaying = false,
                                        onPlay = { onPlayTrack(item, if (tracks.isNotEmpty()) tracks else listOf(item)) },
                                        onAddToPlaylist = { onAddToPlaylist(item) },
                                        onDownload = { onDownloadTrack(item) }
                                    )
                                }
                                is Album -> {
                                    val albCover = AudixArtworkEngine.rememberAlbumCover(item)
                                    ShelfMediaCardRow(
                                        title = item.title,
                                        subtitle = item.artists.joinToString(", ") { it.name }.ifBlank { "Album" },
                                        badge = "ALBUM",
                                        coverUrl = albCover,
                                        onClick = { onMediaSelected(item) }
                                    )
                                }
                                is Artist -> {
                                    val artCover = AudixArtworkEngine.rememberArtistCover(item)
                                    ShelfMediaCardRow(
                                        title = item.name,
                                        subtitle = item.subtitle ?: "Artist",
                                        badge = "ARTIST",
                                        isCircle = true,
                                        coverUrl = artCover,
                                        onClick = { onMediaSelected(item) }
                                    )
                                }
                                is Playlist -> {
                                    ShelfMediaCardRow(
                                        title = item.title,
                                        subtitle = "${item.trackCount ?: 0} tracks",
                                        badge = "PLAYLIST",
                                        coverUrl = when (val c = item.cover) {
                                            is ImageHolder.NetworkRequestImageHolder -> c.request.url
                                            is ImageHolder.ResourceUriImageHolder -> c.uri
                                            else -> item.extras["cover_url"]
                                        },
                                        onClick = { onMediaSelected(item) }
                                    )
                                }
                                else -> {}
                            }
                        }
                    }
                }
            }
        }
    }
}

// =========================================================================
// YOUTUBE PLAYLIST IMPORT & ENGINE
// =========================================================================

data class YouTubePlaylistInfo(
    val id: String,
    val title: String,
    val description: String = "",
    val author: String = "YouTube",
    val coverUrl: String? = null,
    val tracks: List<Track> = emptyList()
)

object YouTubePlaylistEngine {
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(18, java.util.concurrent.TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val json = Json { ignoreUnknownKeys = true }
    private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()

    fun extractPlaylistId(input: String?): String? {
        if (input.isNullOrBlank()) return null
        val trimmed = input.trim()

        val matchParam = Regex("""[?&]list=([a-zA-Z0-9_-]+)""").find(trimmed)
        if (matchParam != null) return matchParam.groupValues[1]

        val matchBrowse = Regex("""(?:browse/|browse\?id=)(?:VL)?([a-zA-Z0-9_-]+)""").find(trimmed)
        if (matchBrowse != null) return matchBrowse.groupValues[1]

        val matchDirect = Regex("""^(?:VL)?(PL[a-zA-Z0-9_-]+|OLAK5uy_[a-zA-Z0-9_-]+|RD[a-zA-Z0-9_-]+|UL[a-zA-Z0-9_-]+)$""").find(trimmed)
        if (matchDirect != null) return matchDirect.groupValues[1]

        val vMatch = extractVideoId(trimmed)
        if (vMatch != null && (trimmed.contains("youtube.com") || trimmed.contains("youtu.be"))) {
            return "RD$vMatch"
        }

        return null
    }

    fun extractVideoId(input: String?): String? {
        if (input.isNullOrBlank()) return null
        val trimmed = input.trim()

        val matchV = Regex("""[?&]v=([a-zA-Z0-9_-]{11})""").find(trimmed)
        if (matchV != null) return matchV.groupValues[1]

        val matchShort = Regex("""(?:youtu\.be/|embed/|shorts/)([a-zA-Z0-9_-]{11})""").find(trimmed)
        if (matchShort != null) return matchShort.groupValues[1]

        val matchDirect = Regex("""^([a-zA-Z0-9_-]{11})$""").find(trimmed)
        if (matchDirect != null) return matchDirect.groupValues[1]

        val matchRD = Regex("""RD([a-zA-Z0-9_-]{11})""").find(trimmed)
        if (matchRD != null) return matchRD.groupValues[1]

        return null
    }

    private fun parseTimeStringToMs(timeStr: String?): Long {
        if (timeStr.isNullOrBlank()) return 180000L
        val parts = timeStr.trim().split(":").mapNotNull { it.toLongOrNull() }
        return when (parts.size) {
            1 -> parts[0] * 1000L
            2 -> (parts[0] * 60L + parts[1]) * 1000L
            3 -> (parts[0] * 3600L + parts[1] * 60L + parts[2]) * 1000L
            else -> 180000L
        }
    }

    suspend fun fetchPlaylist(
        playlistId: String,
        videoIdHint: String? = null,
        extensionId: String? = null,
        maxPages: Int = 5
    ): YouTubePlaylistInfo = withContext(Dispatchers.IO) {
        val cleanPlaylistId = if (playlistId.startsWith("VL")) playlistId.substring(2) else playlistId
        val isMix = cleanPlaylistId.startsWith("RD") || cleanPlaylistId.startsWith("UL")

        if (isMix) {
            return@withContext fetchMixPlaylist(cleanPlaylistId, videoIdHint, extensionId, maxPages = 3)
        }

        try {
            fetchBrowsePlaylist(cleanPlaylistId, extensionId, maxPages)
        } catch (e: Throwable) {
            val msg = e.message ?: ""
            if (msg.contains("unviewable", ignoreCase = true) || msg.contains("does not exist", ignoreCase = true)) {
                runCatching {
                    fetchMixPlaylist(cleanPlaylistId, videoIdHint, extensionId, maxPages = 3)
                }.getOrElse { throw e }
            } else {
                throw e
            }
        }
    }

    private suspend fun fetchMixPlaylist(
        playlistId: String,
        videoIdHint: String? = null,
        extensionId: String? = null,
        maxPages: Int = 3
    ): YouTubePlaylistInfo = withContext(Dispatchers.IO) {
        val nextUrl = "https://www.youtube.com/youtubei/v1/next"
        val seedVid = videoIdHint
            ?: extractVideoId(playlistId)
            ?: playlistId.removePrefix("RD").removePrefix("AMVM").removePrefix("MM").take(11)

        val collectedTracks = mutableListOf<Track>()
        val seenVideoIds = mutableSetOf<String>()
        var playlistTitle = "YouTube Mix"
        var playlistAuthor = "YouTube Mix"
        var playlistCover: String? = if (seedVid.isNotBlank()) "https://i.ytimg.com/vi/$seedVid/hqdefault.jpg" else null

        var currVid = seedVid
        var currIndex = 0
        var currParams: String? = null

        for (page in 0 until maxPages) {
            val payloadObj = buildString {
                append("""{"context":{"client":{"clientName":"WEB","clientVersion":"2.20240101.01.00","hl":"en","gl":"US"}},""")
                append(""""videoId":"$currVid","playlistId":"$playlistId"""")
                if (currIndex > 0) append(""","playlistIndex":$currIndex""")
                if (!currParams.isNullOrBlank()) append(""","params":"$currParams"""")
                append("}")
            }

            val req = Request.Builder()
                .url(nextUrl)
                .post(payloadObj.toRequestBody(JSON_MEDIA_TYPE))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("Accept", "application/json")
                .build()

            val respBody = runCatching {
                client.newCall(req).execute().use { resp ->
                    if (!resp.isSuccessful) null else resp.body?.string()
                }
            }.getOrNull() ?: break

            val root = runCatching { json.parseToJsonElement(respBody).jsonObject }.getOrNull() ?: break
            val tcb = root["contents"]?.jsonObject?.get("twoColumnWatchNextResults")?.jsonObject
            val pl = tcb?.get("playlist")?.jsonObject?.get("playlist")?.jsonObject ?: break

            val titleVal = pl["title"]?.jsonPrimitive?.content
            if (!titleVal.isNullOrBlank()) playlistTitle = titleVal

            val authorVal = pl["authorText"]?.jsonObject?.get("simpleText")?.jsonPrimitive?.content
            if (!authorVal.isNullOrBlank()) playlistAuthor = authorVal

            val items = pl["contents"]?.jsonArray ?: break
            if (items.isEmpty()) break

            var newCount = 0
            var nextWatchEndpoint: JsonObject? = null

            for (elem in items) {
                val ppvr = elem.jsonObject["playlistPanelVideoRenderer"]?.jsonObject ?: continue
                val vid = ppvr["videoId"]?.jsonPrimitive?.content ?: continue
                if (!seenVideoIds.add(vid)) continue

                val tTitle = ppvr["title"]?.jsonObject?.get("simpleText")?.jsonPrimitive?.content
                    ?: ppvr["title"]?.jsonObject?.get("runs")?.jsonArray?.firstOrNull()?.jsonObject?.get("text")?.jsonPrimitive?.content
                    ?: "Unknown Track"

                var tArtist = playlistAuthor
                val longRuns = ppvr["longBylineText"]?.jsonObject?.get("runs")?.jsonArray
                val shortRuns = ppvr["shortBylineText"]?.jsonObject?.get("runs")?.jsonArray
                val artistRun = longRuns?.firstOrNull() ?: shortRuns?.firstOrNull()
                val artistText = artistRun?.jsonObject?.get("text")?.jsonPrimitive?.content
                if (!artistText.isNullOrBlank()) tArtist = artistText

                val durText = ppvr["lengthText"]?.jsonObject?.get("simpleText")?.jsonPrimitive?.content
                    ?: ppvr["lengthText"]?.jsonObject?.get("runs")?.jsonArray?.firstOrNull()?.jsonObject?.get("text")?.jsonPrimitive?.content
                val durationMs = parseTimeStringToMs(durText)

                val thumbs = ppvr["thumbnail"]?.jsonObject?.get("thumbnails")?.jsonArray
                val tCover = thumbs?.lastOrNull()?.jsonObject?.get("url")?.jsonPrimitive?.content
                    ?: "https://i.ytimg.com/vi/$vid/hqdefault.jpg"
                if (playlistCover.isNullOrBlank()) playlistCover = tCover

                val extrasMap = mutableMapOf(
                    "video_id" to vid,
                    "cover_url" to tCover,
                    "track_title" to tTitle,
                    "artist_name" to tArtist,
                    "source" to "youtube"
                )
                if (!extensionId.isNullOrBlank()) {
                    extrasMap["extension_id"] = extensionId
                }

                collectedTracks.add(
                    Track(
                        id = vid,
                        title = tTitle,
                        artists = listOf(Artist(name = tArtist, id = tArtist)),
                        album = Album(title = playlistTitle, id = playlistId),
                        cover = ImageHolder.NetworkRequestImageHolder(
                            dev.brahmkshatriya.echo.common.models.NetworkRequest(tCover),
                            crop = false
                        ),
                        duration = durationMs,
                        extras = extrasMap
                    )
                )
                newCount++
                nextWatchEndpoint = ppvr["navigationEndpoint"]?.jsonObject?.get("watchEndpoint")?.jsonObject
            }

            if (newCount == 0 || nextWatchEndpoint == null) break

            val nextVid = nextWatchEndpoint["videoId"]?.jsonPrimitive?.content
            if (!nextVid.isNullOrBlank()) currVid = nextVid
            val nextIdx = nextWatchEndpoint["index"]?.jsonPrimitive?.content?.toIntOrNull()
            if (nextIdx != null) currIndex = nextIdx else currIndex += items.size
            val nextP = nextWatchEndpoint["params"]?.jsonPrimitive?.content
            if (!nextP.isNullOrBlank()) currParams = nextP
        }

        if (collectedTracks.isEmpty()) {
            throw Exception("Could not load any tracks from this YouTube Mix.")
        }

        YouTubePlaylistInfo(
            id = playlistId,
            title = playlistTitle,
            description = "Auto-generated YouTube Mix based on $playlistAuthor",
            author = playlistAuthor,
            coverUrl = playlistCover,
            tracks = collectedTracks
        )
    }

    private suspend fun fetchBrowsePlaylist(
        playlistId: String,
        extensionId: String? = null,
        maxPages: Int = 5
    ): YouTubePlaylistInfo = withContext(Dispatchers.IO) {
        val cleanPlaylistId = if (playlistId.startsWith("VL")) playlistId.substring(2) else playlistId
        val browseId = "VL$cleanPlaylistId"
        val browseUrl = "https://www.youtube.com/youtubei/v1/browse"

        val initialPayload = """
            {
                "context": {
                    "client": {
                        "clientName": "WEB",
                        "clientVersion": "2.20240101.01.00",
                        "hl": "en",
                        "gl": "US"
                    }
                },
                "browseId": "$browseId"
            }
        """.trimIndent()

        val req = Request.Builder()
            .url(browseUrl)
            .post(initialPayload.toRequestBody(JSON_MEDIA_TYPE))
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
            .header("Accept", "application/json")
            .build()

        val respBody = client.newCall(req).execute().use { resp ->
            if (!resp.isSuccessful) throw Exception("YouTube returned HTTP ${resp.code}")
            resp.body?.string() ?: throw Exception("Empty response from YouTube")
        }

        val root = json.parseToJsonElement(respBody).jsonObject

        val alerts = root["alerts"]?.jsonArray
        if (!alerts.isNullOrEmpty()) {
            val alertText = alerts.firstOrNull()?.jsonObject
                ?.get("alertRenderer")?.jsonObject
                ?.get("text")?.jsonObject
                ?.get("runs")?.jsonArray?.firstOrNull()?.jsonObject
                ?.get("text")?.jsonPrimitive?.content
            if (!alertText.isNullOrBlank() && (root["contents"] == null || root["contents"]?.jsonObject?.isEmpty() == true)) {
                throw Exception("YouTube: $alertText")
            }
        }

        val metadataRenderer = root["metadata"]?.jsonObject?.get("playlistMetadataRenderer")?.jsonObject
        val pageHeader = root["header"]?.jsonObject?.get("pageHeaderRenderer")?.jsonObject
        val microformat = root["microformat"]?.jsonObject?.get("microformatDataRenderer")?.jsonObject

        val playlistTitle = metadataRenderer?.get("title")?.jsonPrimitive?.content
            ?: pageHeader?.get("pageTitle")?.jsonPrimitive?.content
            ?: microformat?.get("title")?.jsonPrimitive?.content
            ?: "YouTube Playlist"

        val playlistDesc = metadataRenderer?.get("description")?.jsonPrimitive?.content
            ?: microformat?.get("description")?.jsonPrimitive?.content
            ?: ""

        var playlistAuthor = "YouTube"
        val sidebarItems = root["sidebar"]?.jsonObject?.get("playlistSidebarRenderer")?.jsonObject?.get("items")?.jsonArray
        if (sidebarItems != null) {
            for (it in sidebarItems) {
                val sec = it.jsonObject["playlistSidebarSecondaryInfoRenderer"]?.jsonObject
                val runs = sec?.get("videoOwner")?.jsonObject?.get("videoOwnerRenderer")?.jsonObject?.get("title")?.jsonObject?.get("runs")?.jsonArray
                val runText = runs?.firstOrNull()?.jsonObject?.get("text")?.jsonPrimitive?.content
                if (!runText.isNullOrBlank()) {
                    playlistAuthor = runText.replace(Regex("""^by\s+""", RegexOption.IGNORE_CASE), "").trim()
                    break
                }
            }
        }

        var playlistCover: String? = null
        val thumbs = microformat?.get("thumbnail")?.jsonObject?.get("thumbnails")?.jsonArray
        if (thumbs != null && thumbs.isNotEmpty()) {
            playlistCover = thumbs.last().jsonObject["url"]?.jsonPrimitive?.content
        }

        val collectedTracks = mutableListOf<Track>()
        val seenVideoIds = mutableSetOf<String>()
        var continuationToken: String? = null

        fun parseItems(items: JsonArray) {
            for (elem in items) {
                val itObj = elem.jsonObject

                // lockupViewModel
                if (itObj.containsKey("lockupViewModel")) {
                    val lvm = itObj["lockupViewModel"]?.jsonObject ?: continue
                    var vid = lvm["contentId"]?.jsonPrimitive?.content
                    if (vid.isNullOrBlank()) {
                        val onTap = lvm["rendererContext"]?.jsonObject
                            ?.get("commandContext")?.jsonObject
                            ?.get("onTap")?.jsonObject
                            ?.get("innertubeCommand")?.jsonObject
                            ?.get("watchEndpoint")?.jsonObject
                        vid = onTap?.get("videoId")?.jsonPrimitive?.content
                    }
                    if (vid.isNullOrBlank() || !seenVideoIds.add(vid)) continue

                    val meta = lvm["metadata"]?.jsonObject?.get("lockupMetadataViewModel")?.jsonObject
                    val titleText = meta?.get("title")?.jsonObject?.get("content")?.jsonPrimitive?.content ?: "Unknown Track"

                    var artistName = playlistAuthor
                    val rows = meta?.get("metadata")?.jsonObject?.get("contentMetadataViewModel")?.jsonObject?.get("metadataRows")?.jsonArray
                    if (!rows.isNullOrEmpty()) {
                        val parts = rows[0].jsonObject["metadataParts"]?.jsonArray
                        if (!parts.isNullOrEmpty()) {
                            val partContent = parts[0].jsonObject["text"]?.jsonObject?.get("content")?.jsonPrimitive?.content
                            if (!partContent.isNullOrBlank()) artistName = partContent
                        }
                    }

                    var trackCover = "https://i.ytimg.com/vi/$vid/hqdefault.jpg"
                    val sources = lvm["contentImage"]?.jsonObject?.get("thumbnailViewModel")?.jsonObject?.get("image")?.jsonObject?.get("sources")?.jsonArray
                    if (!sources.isNullOrEmpty()) {
                        trackCover = sources.last().jsonObject["url"]?.jsonPrimitive?.content ?: trackCover
                    }
                    if (playlistCover.isNullOrBlank()) playlistCover = trackCover

                    var durationMs = 180000L
                    val overlays = lvm["contentImage"]?.jsonObject?.get("thumbnailViewModel")?.jsonObject?.get("overlays")?.jsonArray
                    if (!overlays.isNullOrEmpty()) {
                        for (ov in overlays) {
                            val badges = ov.jsonObject["thumbnailBottomOverlayViewModel"]?.jsonObject?.get("badges")?.jsonArray
                            if (!badges.isNullOrEmpty()) {
                                val timeText = badges[0].jsonObject["thumbnailBadgeViewModel"]?.jsonObject?.get("text")?.jsonPrimitive?.content
                                if (!timeText.isNullOrBlank()) {
                                    durationMs = parseTimeStringToMs(timeText)
                                    break
                                }
                            }
                        }
                    }

                    val extrasMap = mutableMapOf(
                        "video_id" to vid,
                        "cover_url" to trackCover,
                        "track_title" to titleText,
                        "artist_name" to artistName,
                        "source" to "youtube"
                    )
                    if (!extensionId.isNullOrBlank()) {
                        extrasMap["extension_id"] = extensionId
                    }

                    collectedTracks.add(
                        Track(
                            id = vid,
                            title = titleText,
                            artists = listOf(Artist(name = artistName, id = artistName)),
                            album = Album(title = playlistTitle, id = cleanPlaylistId),
                            cover = ImageHolder.NetworkRequestImageHolder(
                                dev.brahmkshatriya.echo.common.models.NetworkRequest(trackCover),
                                crop = false
                            ),
                            duration = durationMs,
                            extras = extrasMap
                        )
                    )
                }

                // playlistVideoRenderer
                if (itObj.containsKey("playlistVideoRenderer")) {
                    val pvr = itObj["playlistVideoRenderer"]?.jsonObject ?: continue
                    val vid = pvr["videoId"]?.jsonPrimitive?.content
                    if (vid.isNullOrBlank() || !seenVideoIds.add(vid)) continue

                    val runs = pvr["title"]?.jsonObject?.get("runs")?.jsonArray
                    val titleText = runs?.firstOrNull()?.jsonObject?.get("text")?.jsonPrimitive?.content
                        ?: pvr["title"]?.jsonObject?.get("simpleText")?.jsonPrimitive?.content
                        ?: "Unknown Track"

                    val bylineRuns = pvr["shortBylineText"]?.jsonObject?.get("runs")?.jsonArray
                    val artistName = bylineRuns?.firstOrNull()?.jsonObject?.get("text")?.jsonPrimitive?.content
                        ?: pvr["shortBylineText"]?.jsonObject?.get("simpleText")?.jsonPrimitive?.content
                        ?: playlistAuthor

                    var trackCover = "https://i.ytimg.com/vi/$vid/hqdefault.jpg"
                    val pvrThumbs = pvr["thumbnail"]?.jsonObject?.get("thumbnails")?.jsonArray
                    if (!pvrThumbs.isNullOrEmpty()) {
                        trackCover = pvrThumbs.last().jsonObject["url"]?.jsonPrimitive?.content ?: trackCover
                    }
                    if (playlistCover.isNullOrBlank()) playlistCover = trackCover

                    val lengthSec = pvr["lengthSeconds"]?.jsonPrimitive?.content?.toLongOrNull() ?: 180L
                    val durationMs = lengthSec * 1000L

                    val extrasMap = mutableMapOf(
                        "video_id" to vid,
                        "cover_url" to trackCover,
                        "track_title" to titleText,
                        "artist_name" to artistName,
                        "source" to "youtube"
                    )
                    if (!extensionId.isNullOrBlank()) {
                        extrasMap["extension_id"] = extensionId
                    }

                    collectedTracks.add(
                        Track(
                            id = vid,
                            title = titleText,
                            artists = listOf(Artist(name = artistName, id = artistName)),
                            album = Album(title = playlistTitle, id = cleanPlaylistId),
                            cover = ImageHolder.NetworkRequestImageHolder(
                                dev.brahmkshatriya.echo.common.models.NetworkRequest(trackCover),
                                crop = false
                            ),
                            duration = durationMs,
                            extras = extrasMap
                        )
                    )
                }

                // continuationItemViewModel
                if (itObj.containsKey("continuationItemViewModel")) {
                    val civ = itObj["continuationItemViewModel"]?.jsonObject
                    val cmd = civ?.get("continuationCommand")?.jsonObject?.get("innertubeCommand")?.jsonObject?.get("continuationCommand")?.jsonObject
                        ?: civ?.get("continuationEndpoint")?.jsonObject?.get("continuationCommand")?.jsonObject
                    val token = cmd?.get("token")?.jsonPrimitive?.content
                    if (!token.isNullOrBlank()) continuationToken = token
                }

                // continuationItemRenderer
                if (itObj.containsKey("continuationItemRenderer")) {
                    val cir = itObj["continuationItemRenderer"]?.jsonObject
                    val cmd = cir?.get("continuationEndpoint")?.jsonObject?.get("continuationCommand")?.jsonObject
                    val token = cmd?.get("token")?.jsonPrimitive?.content
                    if (!token.isNullOrBlank()) continuationToken = token
                }
            }
        }

        val tcb = root["contents"]?.jsonObject?.get("twoColumnBrowseResultsRenderer")?.jsonObject
        val tabs = tcb?.get("tabs")?.jsonArray
        if (tabs != null && tabs.isNotEmpty()) {
            val secList = tabs[0].jsonObject["tabRenderer"]?.jsonObject
                ?.get("content")?.jsonObject
                ?.get("sectionListRenderer")?.jsonObject
            val secContents = secList?.get("contents")?.jsonArray
            if (secContents != null) {
                for (sc in secContents) {
                    val itemSec = sc.jsonObject["itemSectionRenderer"]?.jsonObject
                    val plRenderer = itemSec?.get("contents")?.jsonArray ?: continue
                    for (sub in plRenderer) {
                        val subObj = sub.jsonObject
                        if (subObj.containsKey("playlistVideoListRenderer")) {
                            val vids = subObj["playlistVideoListRenderer"]?.jsonObject?.get("contents")?.jsonArray
                            if (vids != null) parseItems(vids)
                        }
                    }
                    parseItems(plRenderer)
                }
            }
        }

        var pageCount = 1
        while (!continuationToken.isNullOrBlank() && pageCount < maxPages) {
            pageCount++
            val currToken = continuationToken
            continuationToken = null

            val contPayload = """
                {
                    "context": {
                        "client": {
                            "clientName": "WEB",
                            "clientVersion": "2.20240101.01.00",
                            "hl": "en",
                            "gl": "US"
                        }
                    },
                    "continuation": "$currToken"
                }
            """.trimIndent()

            val contReq = Request.Builder()
                .url(browseUrl)
                .post(contPayload.toRequestBody(JSON_MEDIA_TYPE))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                .header("Accept", "application/json")
                .build()

            val contBody = runCatching {
                client.newCall(contReq).execute().use { it.body?.string() }
            }.getOrNull() ?: break

            val contRoot = runCatching { json.parseToJsonElement(contBody).jsonObject }.getOrNull() ?: break
            val actions = contRoot["onResponseReceivedActions"]?.jsonArray
            if (actions.isNullOrEmpty()) break

            val contItems = actions[0].jsonObject["appendContinuationItemsAction"]?.jsonObject?.get("continuationItems")?.jsonArray
            if (contItems.isNullOrEmpty()) break

            parseItems(contItems)
        }

        YouTubePlaylistInfo(
            id = cleanPlaylistId,
            title = playlistTitle,
            description = playlistDesc,
            author = playlistAuthor,
            coverUrl = playlistCover,
            tracks = collectedTracks
        )
    }
}

@Composable
fun YouTubePlaylistImportingView(onCancel: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LiquidGlassCard(
            modifier = Modifier.width(420.dp).padding(24.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CircularProgressIndicator(color = Color.White, modifier = Modifier.size(36.dp), strokeWidth = 3.dp)
                Text(
                    text = "Importing YouTube Playlist",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.White
                )
                Text(
                    text = "Fetching all songs and playlist metadata from YouTube...",
                    fontSize = 13.sp,
                    color = TextMuted,
                    textAlign = TextAlign.Center
                )
                OutlinedButton(
                    onClick = onCancel,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.20f))
                ) {
                    Text("Cancel", color = TextSecondary, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun YouTubePlaylistErrorView(
    error: String,
    onRetry: () -> Unit,
    onDismiss: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LiquidGlassCard(
            modifier = Modifier.width(440.dp).padding(24.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Icon(
                    Icons.Default.ErrorOutline,
                    contentDescription = null,
                    tint = Color(0xFFEF4444),
                    modifier = Modifier.size(42.dp)
                )
                Text(
                    text = "Playlist Import Failed",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.White
                )
                Text(
                    text = error,
                    fontSize = 13.sp,
                    color = TextSecondary,
                    textAlign = TextAlign.Center
                )
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = onRetry,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("Retry", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                    }
                    OutlinedButton(
                        onClick = onDismiss,
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f))
                    ) {
                        Text("Dismiss", color = Color.White, fontSize = 12.5.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun YouTubePlaylistDetailView(
    playlistInfo: YouTubePlaylistInfo,
    isSavedLocally: Boolean,
    onSaveToggle: () -> Unit,
    onPlayAll: () -> Unit,
    onShuffle: () -> Unit,
    onTrackSelect: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // TOP HERO CARD
        LiquidGlassBox(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color(0xFF0F1117).copy(alpha = 0.70f),
            borderColor = Color.White.copy(alpha = 0.18f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Large Thumbnail
                Box(
                    modifier = Modifier
                        .size(140.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(16.dp))
                        .shadow(12.dp, RoundedCornerShape(16.dp))
                ) {
                    if (!playlistInfo.coverUrl.isNullOrBlank()) {
                        AsyncImage(
                            model = playlistInfo.coverUrl,
                            contentDescription = playlistInfo.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Box(
                            modifier = Modifier.fillMaxSize().background(Color(0xFF1E222D)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.LibraryMusic, contentDescription = null, tint = TextMuted, modifier = Modifier.size(48.dp))
                        }
                    }
                }

                // Info & Action Buttons
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = Color(0xFFE50914).copy(alpha = 0.18f),
                            borderColor = Color(0xFFFF4D4D).copy(alpha = 0.40f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Box(
                                    modifier = Modifier.size(6.dp).clip(CircleShape).background(Color(0xFFFF3333))
                                )
                                Text(
                                    text = "YOUTUBE PLAYLIST",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFF6666)
                                )
                            }
                        }

                        IconButton(
                            onClick = onClose,
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.10f))
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Close Playlist", tint = Color.White, modifier = Modifier.size(16.dp))
                        }
                    }

                    Text(
                        text = playlistInfo.title,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = "by ${playlistInfo.author} • ${playlistInfo.tracks.size} Songs",
                        fontSize = 13.5.sp,
                        color = TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    // Actions Row
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (playlistInfo.tracks.isNotEmpty()) {
                            Button(
                                onClick = onPlayAll,
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                                shape = RoundedCornerShape(10.dp),
                                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Play All", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                            }

                            OutlinedButton(
                                onClick = onShuffle,
                                shape = RoundedCornerShape(10.dp),
                                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                            ) {
                                Icon(Icons.Default.Shuffle, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Shuffle", color = Color.White, fontSize = 12.5.sp)
                            }
                        }

                        Button(
                            onClick = onSaveToggle,
                            colors = if (isSavedLocally) {
                                ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981).copy(alpha = 0.25f), contentColor = Color(0xFF34D399))
                            } else {
                                ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.12f), contentColor = Color.White)
                            },
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, if (isSavedLocally) Color(0xFF10B981).copy(alpha = 0.60f) else Color.White.copy(alpha = 0.25f)),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Icon(
                                imageVector = if (isSavedLocally) Icons.Default.Check else Icons.AutoMirrored.Filled.PlaylistAdd,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                text = if (isSavedLocally) "Saved to Library" else "Save Playlist",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.5.sp
                            )
                        }
                    }
                }
            }
        }

        // TRACKLIST HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Playlist Tracks (${playlistInfo.tracks.size})",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Click song to play with full queue context",
                fontSize = 12.sp,
                color = TextMuted
            )
        }

        // TRACKLIST
        if (playlistInfo.tracks.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("No playable tracks found in this playlist.", color = TextMuted, fontSize = 14.sp)
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(playlistInfo.tracks, key = { idx, tr -> "${tr.id}_$idx" }) { idx, track ->
                    SearchTrackItemRow(
                        track = track,
                        index = idx,
                        isCurrentTrack = false,
                        isPlaying = false,
                        onPlay = { onTrackSelect(track) },
                        onAddToPlaylist = { onAddToPlaylist(track) },
                        onDownload = { onDownloadTrack(track) }
                    )
                }
            }
        }
    }
}

@Composable
fun SeniorMediaDetailModal(
    media: EchoMediaItem,
    onDismiss: () -> Unit,
    onMediaSelected: (EchoMediaItem) -> Unit,
    playerViewModel: PlayerViewModel,
    extensionManager: ExtensionManager,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    var albumTracks by remember(media) { mutableStateOf<List<Track>>(emptyList()) }
    var playlistTracks by remember(media) { mutableStateOf<List<Track>>(emptyList()) }
    var artistTracks by remember(media) { mutableStateOf<List<Track>>(emptyList()) }
    var artistAlbums by remember(media) { mutableStateOf<List<Album>>(emptyList()) }
    var isLoading by remember(media) { mutableStateOf(true) }

    LaunchedEffect(media) {
        isLoading = true
        when (media) {
            is Album -> {
                albumTracks = UnifiedCatalogEngine.loadAlbumTracks(media, extensionManager)
            }
            is Artist -> {
                val (t, a) = UnifiedCatalogEngine.loadArtistDiscography(media, extensionManager)
                artistTracks = t
                artistAlbums = a
            }
            is Playlist -> {
                val ytId = YouTubePlaylistEngine.extractPlaylistId(media.id)
                if (ytId != null) {
                    val ytExt = extensionManager.music.value.firstOrNull { it.id.contains("youtube", ignoreCase = true) }
                    playlistTracks = runCatching {
                        val ytVid = YouTubePlaylistEngine.extractVideoId(media.id)
                        YouTubePlaylistEngine.fetchPlaylist(ytId, ytVid, ytExt?.id).tracks
                    }.getOrDefault(emptyList())
                }
            }
            else -> {}
        }
        isLoading = false
    }

    val isAlbum = media is Album
    val isArtist = media is Artist
    val isPlaylist = media is Playlist

    val title = when (media) {
        is Album -> media.title
        is Artist -> media.name
        is Playlist -> media.title
        is Track -> media.title
        else -> "Details"
    }
    val subtitle = when (media) {
        is Album -> media.artists.joinToString(", ") { it.name }.ifBlank { "Album" }
        is Artist -> media.subtitle ?: "Artist"
        is Playlist -> "${media.trackCount ?: 0} tracks"
        is Track -> media.artists.joinToString(", ") { it.name }
        else -> ""
    }
    val coverUrl = when (media) {
        is Artist -> AudixArtworkEngine.rememberArtistCover(media)
        is Album -> AudixArtworkEngine.rememberAlbumCover(media)
        is Track -> AudixArtworkEngine.rememberMediaCover(media)
        else -> when (val c = media.cover) {
            is ImageHolder.NetworkRequestImageHolder -> AudixArtworkEngine.upgradeYouTubeThumbnail(c.request.url)
            is ImageHolder.ResourceUriImageHolder -> c.uri
            else -> media.extras["cover_url"]
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                onDismiss()
            }
            .zIndex(110f),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(880.dp)
                .heightIn(max = 740.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                    // Prevent dismiss on inner click
                }
        ) {
            LiquidGlassBox(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.65f),
                borderColor = Color.White.copy(alpha = 0.22f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(26.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    // HERO HEADER
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(22.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        val imgShape = if (isArtist) CircleShape else RoundedCornerShape(16.dp)
                        Box(
                            modifier = Modifier
                                .size(140.dp)
                                .clip(imgShape)
                                .border(1.dp, Color.White.copy(alpha = 0.20f), imgShape)
                                .shadow(14.dp, imgShape, spotColor = Color(0xFF38BDF8))
                        ) {
                            if (!coverUrl.isNullOrBlank()) {
                                AsyncImage(
                                    model = coverUrl,
                                    contentDescription = title,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            } else {
                                Icon(
                                    imageVector = if (isArtist) Icons.Default.Person else if (isPlaylist) Icons.Default.LibraryMusic else Icons.Default.Album,
                                    contentDescription = null,
                                    tint = Color.White.copy(alpha = 0.40f),
                                    modifier = Modifier.size(54.dp).align(Alignment.Center)
                                )
                            }
                        }

                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(8.dp),
                                    backgroundColor = Color.White.copy(alpha = 0.12f),
                                    borderColor = Color.White.copy(alpha = 0.22f)
                                ) {
                                    Text(
                                        text = if (isArtist) "ARTIST" else if (isAlbum) "ALBUM" else if (isPlaylist) "PLAYLIST" else "COLLECTION",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF38BDF8),
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
                                    )
                                }

                                IconButton(
                                    onClick = onDismiss,
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(Color.White.copy(alpha = 0.10f))
                                ) {
                                    Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(18.dp))
                                }
                            }

                            Text(
                                text = title,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = subtitle,
                                fontSize = 13.5.sp,
                                color = TextSecondary,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            val activeTracks = if (isAlbum) albumTracks else if (isPlaylist) playlistTracks else artistTracks
                            Row(
                                modifier = Modifier.padding(top = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (activeTracks.isNotEmpty()) {
                                    Button(
                                        onClick = { playerViewModel.playWithQueue(activeTracks.first(), activeTracks) },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                                        shape = RoundedCornerShape(10.dp),
                                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                                    ) {
                                        Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text(if (isArtist) "Play Popular" else if (isPlaylist) "Play Playlist" else "Play Album", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                                    }

                                    OutlinedButton(
                                        onClick = {
                                            val sh = activeTracks.shuffled()
                                            if (sh.isNotEmpty()) playerViewModel.playWithQueue(sh.first(), sh)
                                        },
                                        shape = RoundedCornerShape(10.dp),
                                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                                    ) {
                                        Icon(Icons.Default.Shuffle, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("Shuffle", color = Color.White, fontSize = 12.5.sp)
                                    }
                                }

                                if ((isAlbum || isPlaylist) && activeTracks.isNotEmpty()) {
                                    IconButton(
                                        onClick = {
                                            albumTracks.forEach { onDownloadTrack(it) }
                                        },
                                        modifier = Modifier
                                            .size(34.dp)
                                            .clip(CircleShape)
                                            .background(Color.White.copy(alpha = 0.08f))
                                    ) {
                                        Icon(Icons.Default.Download, contentDescription = "Download All", tint = Color.White, modifier = Modifier.size(16.dp))
                                    }
                                }
                            }
                        }
                    }

                    HorizontalDivider(color = Color.White.copy(alpha = 0.08f), thickness = 1.dp)

                    // BODY: TRACKS & DISCOGRAPHY
                    if (isLoading) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(color = Color.White, modifier = Modifier.size(28.dp), strokeWidth = 2.5.dp)
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (isAlbum) {
                                if (albumTracks.isEmpty()) {
                                    item {
                                        Text("No tracks found for this album.", color = TextMuted, fontSize = 13.sp, modifier = Modifier.padding(16.dp))
                                    }
                                } else {
                                    item {
                                        Text(
                                            text = "Tracklist (${albumTracks.size} Songs)",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White.copy(alpha = 0.90f),
                                            modifier = Modifier.padding(bottom = 4.dp)
                                        )
                                    }
                                    itemsIndexed(albumTracks, key = { idx, tr -> "${tr.id}_$idx" }) { idx, tr ->
                                        SearchTrackItemRow(
                                            track = tr,
                                            index = idx,
                                            isCurrentTrack = false,
                                            isPlaying = false,
                                            onPlay = { playerViewModel.playWithQueue(tr, albumTracks) },
                                            onAddToPlaylist = { onAddToPlaylist(tr) },
                                            onDownload = { onDownloadTrack(tr) }
                                        )
                                    }
                                }
                            } else if (isPlaylist) {
                                if (playlistTracks.isEmpty()) {
                                    item {
                                        Text("No tracks found for this playlist.", color = TextMuted, fontSize = 13.sp, modifier = Modifier.padding(16.dp))
                                    }
                                } else {
                                    item {
                                        Text(
                                            text = "Playlist Tracks (${playlistTracks.size} Songs)",
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White.copy(alpha = 0.90f),
                                            modifier = Modifier.padding(bottom = 4.dp)
                                        )
                                    }
                                    itemsIndexed(playlistTracks, key = { idx, tr -> "${tr.id}_$idx" }) { idx, tr ->
                                        SearchTrackItemRow(
                                            track = tr,
                                            index = idx,
                                            isCurrentTrack = false,
                                            isPlaying = false,
                                            onPlay = { playerViewModel.playWithQueue(tr, playlistTracks) },
                                            onAddToPlaylist = { onAddToPlaylist(tr) },
                                            onDownload = { onDownloadTrack(tr) }
                                        )
                                    }
                                }
                            } else if (isArtist) {
                                if (artistTracks.isNotEmpty()) {
                                    item {
                                        Text(
                                            text = "Popular Songs",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            modifier = Modifier.padding(bottom = 4.dp)
                                        )
                                    }
                                    itemsIndexed(artistTracks.take(8), key = { idx, tr -> "${tr.id}_$idx" }) { idx, tr ->
                                        SearchTrackItemRow(
                                            track = tr,
                                            index = idx,
                                            isCurrentTrack = false,
                                            isPlaying = false,
                                            onPlay = { playerViewModel.playWithQueue(tr, artistTracks) },
                                            onAddToPlaylist = { onAddToPlaylist(tr) },
                                            onDownload = { onDownloadTrack(tr) }
                                        )
                                    }
                                }

                                if (artistAlbums.isNotEmpty()) {
                                    item {
                                        Spacer(Modifier.height(12.dp))
                                        Text(
                                            text = "Albums & Discography (${artistAlbums.size})",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            modifier = Modifier.padding(bottom = 6.dp)
                                        )
                                    }
                                    items(artistAlbums, key = { it.id }) { alb ->
                                        val albCover = AudixArtworkEngine.rememberAlbumCover(alb)
                                        ShelfMediaCardRow(
                                            title = alb.title,
                                            subtitle = alb.releaseDate?.toString()?.takeIf { it.isNotBlank() } ?: alb.subtitle ?: "Album",
                                            badge = "ALBUM",
                                            coverUrl = albCover,
                                            onClick = { onMediaSelected(alb) }
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

// =========================================================================
// MAIN REDESIGNED SEARCH SCREEN (Pure Decent Black & White)
// =========================================================================

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinInject(),
    playerViewModel: PlayerViewModel = koinInject(),
    onMediaSelected: (EchoMediaItem) -> Unit = {}
) {
    val extensionManager: ExtensionManager = koinInject()
    val query by viewModel.query.collectAsState()
    val quickResults by viewModel.quickResults.collectAsState()
    val searchFeed by viewModel.searchFeed.collectAsState()
    val shelves by viewModel.shelves.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    val currentTrack by playerViewModel.currentTrack.collectAsState()
    val isPlaying by playerViewModel.isPlaying.collectAsState()

    val currentExt by extensionManager.current.collectAsState()
    val musicExtensions by extensionManager.music.collectAsState()

    val downloadManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }

    // Local text input state for seamless physical keyboard input
    var queryInput by remember { mutableStateOf(query) }
    var hasSearched by remember { mutableStateOf(false) }
    var trackForPlaylist by remember { mutableStateOf<Track?>(null) }
        val libraryManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val savedPlaylists by libraryManager.playlists.collectAsState()
    var activeYouTubePlaylist by remember { mutableStateOf<YouTubePlaylistInfo?>(null) }
    var isImportingPlaylist by remember { mutableStateOf(false) }
    var playlistImportError by remember { mutableStateOf<String?>(null) }
    val detectedPlaylistId = remember(queryInput) { YouTubePlaylistEngine.extractPlaylistId(queryInput) }

    var recentSearches by remember {
        mutableStateOf(listOf("The Weeknd", "Lofi Beats", "Coldplay", "Hans Zimmer", "Synthwave"))
    }

    var selectedSourceId by remember { mutableStateOf("all") }
    var unifiedShelves by remember { mutableStateOf<List<Shelf>>(emptyList()) }
    var isUnifiedLoading by remember { mutableStateOf(false) }
    var unifiedError by remember { mutableStateOf<Throwable?>(null) }
    var selectedShelfForModal by remember { mutableStateOf<Shelf?>(null) }
    var selectedMediaForDetail by remember { mutableStateOf<EchoMediaItem?>(null) }
    val coroutineScope = rememberCoroutineScope()

    // Safety: ensure default music extension is active if none is set
    LaunchedEffect(musicExtensions) {
        if (extensionManager.current.value == null && musicExtensions.isNotEmpty()) {
            val defaultExt = musicExtensions.firstOrNull { it.isEnabled } ?: musicExtensions.firstOrNull()
            if (defaultExt != null) {
                extensionManager.setupMusicExtension(defaultExt, true)
            }
        }
    }

    // Sync external query changes
    LaunchedEffect(query) {
        if (query != queryInput && query.isNotBlank()) {
            queryInput = query
            hasSearched = true
        }
    }

    trackForPlaylist?.let { track ->
        AddToPlaylistDialog(
            track = track,
            onDismiss = { trackForPlaylist = null }
        )
    }

    val stampTrackSource: (Track) -> Track = { t ->
        if (!t.extras["extension_id"].isNullOrBlank()) t
        else {
            val isYt = t.extras["source"]?.equals("youtube", ignoreCase = true) == true
                || t.extras.containsKey("video_id")
                || t.id.matches(Regex("^[a-zA-Z0-9_-]{11}$"))
            val targetExt = if (isYt) {
                musicExtensions.firstOrNull { it.id.contains("youtube", ignoreCase = true) } ?: currentExt
            } else {
                currentExt
            }
            if (targetExt != null) {
                t.copy(extras = t.extras + ("extension_id" to targetExt.id))
            } else t
        }
    }

    val playTrackWithSource: (Track) -> Unit = { track ->
        playerViewModel.play(stampTrackSource(track))
    }

    val playTrackWithQueueContext: (Track, List<Track>) -> Unit = { track, queueContext ->
        val stamped = stampTrackSource(track)
        val stampedQueue = if (queueContext.isNotEmpty()) {
            queueContext.map { stampTrackSource(it) }
        } else listOf(stamped)
        playerViewModel.playWithQueue(stamped, stampedQueue)
    }

    fun executeSearch(searchTerm: String) {
        val trimmed = searchTerm.trim()
        if (trimmed.isNotBlank()) {
            val ytPlaylistId = YouTubePlaylistEngine.extractPlaylistId(trimmed)
            if (ytPlaylistId != null) {
                queryInput = trimmed
                hasSearched = true
                isImportingPlaylist = true
                playlistImportError = null
                activeYouTubePlaylist = null
                coroutineScope.launch {
                    try {
                        val ytExt = musicExtensions.firstOrNull { it.id.contains("youtube", ignoreCase = true) }
                        val ytVideoId = YouTubePlaylistEngine.extractVideoId(trimmed)
                        val info = YouTubePlaylistEngine.fetchPlaylist(ytPlaylistId, ytVideoId, ytExt?.id)
                        activeYouTubePlaylist = info
                    } catch (e: Throwable) {
                        playlistImportError = e.message ?: "Failed to import YouTube playlist"
                    } finally {
                        isImportingPlaylist = false
                    }
                }
                return
            }
            activeYouTubePlaylist = null
            playlistImportError = null
            queryInput = trimmed
            hasSearched = true
            if (!recentSearches.contains(trimmed)) {
                recentSearches = (listOf(trimmed) + recentSearches).take(10)
            }
            viewModel.updateQuery(trimmed)
            if (selectedSourceId == "all") {
                isUnifiedLoading = true
                unifiedError = null
                coroutineScope.launch {
                    try {
                        unifiedShelves = UnifiedCatalogEngine.searchUnified(trimmed, musicExtensions, extensionManager)
                    } catch (e: Throwable) {
                        unifiedError = e
                    } finally {
                        isUnifiedLoading = false
                    }
                }
            } else {
                if (extensionManager.current.value == null && musicExtensions.isNotEmpty()) {
                    val defaultExt = musicExtensions.firstOrNull { it.isEnabled } ?: musicExtensions.firstOrNull()
                    if (defaultExt != null) {
                        extensionManager.setupMusicExtension(defaultExt, true)
                    }
                }
                viewModel.search(trimmed)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDark)
    ) {
        // -----------------------------------------------------------------
        // 1. UNIFIED DESKTOP SEARCH TOOLBAR (Search Field + Integrated Source Switcher)
        // -----------------------------------------------------------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Integrated Search Field
                LiquidGlassBox(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    backgroundColor = SurfaceDark,
                    borderColor = BorderSubtle
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Search icon
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = TextSecondary,
                            modifier = Modifier.size(19.dp)
                        )

                        // Text Field with desktop Enter key interception
                        BasicTextField(
                            value = queryInput,
                            onValueChange = {
                                queryInput = it
                                viewModel.updateQuery(it)
                                if (it.isBlank()) {
                                    hasSearched = false
                                }
                            },
                            singleLine = true,
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            cursorBrush = SolidColor(Color.White),
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = { executeSearch(queryInput) }),
                            decorationBox = { innerTextField ->
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    if (queryInput.isEmpty()) {
                                        Text(
                                            "Search songs, artists, albums, or playlists...",
                                            color = TextMuted,
                                            fontSize = 13.5.sp
                                        )
                                    }
                                    innerTextField()
                                }
                            },
                            modifier = Modifier
                                .weight(1f)
                                .onPreviewKeyEvent { event ->
                                    if (event.type == KeyEventType.KeyDown &&
                                        (event.key == Key.Enter || event.key == Key.NumPadEnter)
                                    ) {
                                        executeSearch(queryInput)
                                        true
                                    } else false
                                }
                        )

                        // Spinner if searching
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                strokeWidth = 2.dp,
                                color = Color.White
                            )
                        }

                        // Clear button
                        if (queryInput.isNotBlank()) {
                            IconButton(
                                onClick = {
                                    queryInput = ""
                                    hasSearched = false
                                    viewModel.clearSearch()
                                },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Clear",
                                    tint = TextSecondary,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                        // Prominent Decent Search Button
                        Button(
                            onClick = { executeSearch(queryInput) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 0.dp),
                            modifier = Modifier
                                .height(32.dp)
                                .pointerHoverIcon(PointerIcon.Hand)
                        ) {
                            Text(
                                text = "Search",
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.5.sp
                            )
                        }
                    }
                }

                // Integrated Source Selector (Toolbar Right)
                LiquidGlassBox(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.height(48.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(horizontal = 6.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "Source",
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = TextMuted,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                        // 1. Unified All-in-One Aggregator Engine
                        val isAllSelected = selectedSourceId == "all"
                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = if (isAllSelected) Color.White.copy(alpha = 0.22f) else Color(0x30181818),
                            borderColor = if (isAllSelected) Color.White.copy(alpha = 0.70f) else Color.White.copy(alpha = 0.12f),
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clickable {
                                    if (!isAllSelected) {
                                        selectedSourceId = "all"
                                        if (hasSearched && queryInput.isNotBlank()) {
                                            executeSearch(queryInput)
                                        }
                                    }
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                if (isAllSelected) {
                                    Box(
                                        modifier = Modifier
                                            .size(5.dp)
                                            .clip(CircleShape)
                                            .background(Color.White)
                                    )
                                }
                                Text(
                                    text = "⚡ Unified (All Sources)",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = if (isAllSelected) FontWeight.Bold else FontWeight.Medium
                                    ),
                                    color = if (isAllSelected) Color.White else TextSecondary
                                )
                            }
                        }

                        // 2. Individual Extension Sources
                        musicExtensions.forEach { ext ->
                            val isSelected = selectedSourceId == ext.metadata.id
                            LiquidGlassBox(
                                shape = RoundedCornerShape(8.dp),
                                backgroundColor = if (isSelected) Color.White.copy(alpha = 0.22f) else Color(0x30181818),
                                borderColor = if (isSelected) Color.White.copy(alpha = 0.70f) else Color.White.copy(alpha = 0.12f),
                                modifier = Modifier
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable {
                                        if (!isSelected) {
                                            selectedSourceId = ext.metadata.id
                                            extensionManager.setupMusicExtension(ext, true)
                                            if (hasSearched && queryInput.isNotBlank()) {
                                                viewModel.search(queryInput)
                                            }
                                        }
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    if (isSelected) {
                                        Box(
                                            modifier = Modifier
                                                .size(5.dp)
                                                .clip(CircleShape)
                                                .background(Color.White)
                                        )
                                    }
                                    Text(
                                        text = ext.metadata.name,
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                        ),
                                        color = if (isSelected) Color.White else TextSecondary
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // YouTube Playlist Link Detected Banner
            if (detectedPlaylistId != null && activeYouTubePlaylist == null && !isImportingPlaylist) {
                LiquidGlassCard(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable { executeSearch(queryInput) }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE50914).copy(alpha = 0.22f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color(0xFFFF4D4D), modifier = Modifier.size(20.dp))
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                "YouTube Playlist URL Detected",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                color = Color.White
                            )
                            Text(
                                "Click here or press Enter to load, play, and save all songs from this playlist",
                                style = MaterialTheme.typography.labelSmall,
                                color = TextSecondary
                            )
                        }
                        Button(
                            onClick = { executeSearch(queryInput) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 4.dp),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Text("Load Playlist", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    }
                }
            }

            // Autocomplete suggestions dropdown when typing (anchored directly under the search bar)
            if (queryInput.isNotBlank() && quickResults.isNotEmpty() && !hasSearched) {
                LiquidGlassCard(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(vertical = 4.dp)) {
                        quickResults.take(6).forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable {
                                        if (item is QuickSearchItem.Media) {
                                            val media = item.media
                                            if (media is Track) {
                                                val quickTracks = quickResults.filterIsInstance<QuickSearchItem.Media>().mapNotNull { it.media as? Track }
                                                val q = if (quickTracks.isNotEmpty()) quickTracks else listOf(media)
                                                playTrackWithQueueContext(media, q)
                                            } else {
                                                onMediaSelected(media)
                                            }
                                        } else {
                                            executeSearch(item.title)
                                        }
                                    }
                                    .padding(horizontal = 14.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    imageVector = if (item is QuickSearchItem.Media) Icons.Default.MusicNote else Icons.Default.Search,
                                    contentDescription = null,
                                    tint = TextSecondary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                                    color = TextPrimary
                                )
                            }
                        }
                    }
                }
            }

            // Category filter tabs (All, Songs, Videos, Artists, Albums...)
            val tabs = searchFeed?.tabs
            if (!tabs.isNullOrEmpty() && hasSearched) {
                val selectedIndex = tabs.indexOfFirst { it == selectedTab }.coerceAtLeast(0)
                ScrollableTabRow(
                    selectedTabIndex = selectedIndex,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    edgePadding = 0.dp,
                    containerColor = Color.Transparent,
                    divider = {
                        HorizontalDivider(color = BorderMuted, thickness = 1.dp)
                    }
                ) {
                    tabs.forEachIndexed { index, tab ->
                        Tab(
                            selected = index == selectedIndex,
                            onClick = { viewModel.selectTab(tab) },
                            text = {
                                Text(
                                    text = tab.title,
                                    style = MaterialTheme.typography.titleSmall.copy(
                                        fontWeight = if (index == selectedIndex) FontWeight.Bold else FontWeight.Medium
                                    ),
                                    color = if (index == selectedIndex) Color.White else TextMuted
                                )
                            }
                        )
                    }
                }
            }
        }


        // -----------------------------------------------------------------
        // 4. MAIN BODY (Discovery Hub vs Skeletons vs Error vs Results)
        // -----------------------------------------------------------------
        val effectiveShelves = if (selectedSourceId == "all") unifiedShelves else shelves
        val effectiveLoading = if (selectedSourceId == "all") isUnifiedLoading else isLoading
        val effectiveError = if (selectedSourceId == "all") unifiedError else error

        Box(modifier = Modifier.fillMaxSize()) {
            when {
                // IMPORTING YOUTUBE PLAYLIST
                isImportingPlaylist -> {
                    YouTubePlaylistImportingView(onCancel = { isImportingPlaylist = false })
                }

                // YOUTUBE PLAYLIST IMPORT ERROR
                playlistImportError != null -> {
                    YouTubePlaylistErrorView(
                        error = playlistImportError ?: "Error importing playlist",
                        onRetry = { executeSearch(queryInput) },
                        onDismiss = {
                            playlistImportError = null
                            hasSearched = false
                        }
                    )
                }

                // ACTIVE YOUTUBE PLAYLIST VIEW
                activeYouTubePlaylist != null -> {
                    val pl = activeYouTubePlaylist!!
                    val isSaved = libraryManager.isPlaylistSaved(pl.title)
                    YouTubePlaylistDetailView(
                        playlistInfo = pl,
                        isSavedLocally = isSaved,
                        onSaveToggle = {
                            if (!isSaved) {
                                libraryManager.saveImportedPlaylist(
                                    title = pl.title,
                                    description = pl.description,
                                    tracks = pl.tracks
                                )
                            }
                        },
                        onPlayAll = {
                            if (pl.tracks.isNotEmpty()) {
                                playTrackWithQueueContext(pl.tracks.first(), pl.tracks)
                            }
                        },
                        onShuffle = {
                            val shuffled = pl.tracks.shuffled()
                            if (shuffled.isNotEmpty()) {
                                playTrackWithQueueContext(shuffled.first(), shuffled)
                            }
                        },
                        onTrackSelect = { tr ->
                            playTrackWithQueueContext(tr, pl.tracks)
                        },
                        onAddToPlaylist = { tr -> trackForPlaylist = tr },
                        onDownloadTrack = { tr -> downloadManager.downloadTrack(tr) },
                        onClose = {
                            activeYouTubePlaylist = null
                            hasSearched = false
                            queryInput = ""
                        }
                    )
                }

                // IDLE STATE (Nothing searched yet or search cleared)
                !hasSearched || queryInput.isBlank() -> {
                    SearchDiscoveryHub(
                        recentSearches = recentSearches,
                        onSelectQuery = { executeSearch(it) },
                        onRemoveRecent = { term -> recentSearches = recentSearches.filter { it != term } },
                        onClearRecents = { recentSearches = emptyList() },
                        onPlayTrack = playTrackWithQueueContext,
                        onAddToPlaylist = { trackForPlaylist = it },
                        onDownloadTrack = { downloadManager.downloadTrack(it) }
                    )
                }

                // LOADING STATE
                effectiveLoading && effectiveShelves.isEmpty() -> {
                    SearchLoadingSkeleton()
                }

                // ERROR STATE
                effectiveError != null && effectiveShelves.isEmpty() -> {
                    SearchErrorBanner(
                        error = effectiveError,
                        onRetry = { executeSearch(queryInput) },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                // ZERO RESULTS FOUND
                !effectiveLoading && effectiveShelves.isEmpty() && effectiveError == null -> {
                    SearchZeroResultsView(
                        query = queryInput,
                        extensions = musicExtensions,
                        currentExt = currentExt,
                        onSwitchExtension = { ext ->
                            selectedSourceId = ext.metadata.id
                            extensionManager.setupMusicExtension(ext, true)
                            viewModel.search(queryInput)
                        },
                        onClearSearch = {
                            queryInput = ""
                            hasSearched = false
                            viewModel.clearSearch()
                            unifiedShelves = emptyList()
                        }
                    )
                }

                // RESULTS LOADED
                effectiveShelves.isNotEmpty() -> {
                    val allTracks = remember(effectiveShelves) {
                        effectiveShelves.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
                    }
                    val topSongs = remember(effectiveShelves, allTracks) {
                        if (allTracks.isNotEmpty()) allTracks.take(4)
                        else {
                            effectiveShelves.filterIsInstance<Shelf.Lists.Items>()
                                .flatMap { it.list }
                                .filterIsInstance<Track>()
                                .take(4)
                        }
                    }
                    val topResultItem: EchoMediaItem? = remember(effectiveShelves, topSongs) {
                        val firstItem = effectiveShelves.firstOrNull()?.let { shelf ->
                            when (shelf) {
                                is Shelf.Lists.Tracks -> shelf.list.firstOrNull()
                                is Shelf.Lists.Items -> shelf.list.firstOrNull()
                                is Shelf.Item -> shelf.media
                                else -> null
                            }
                        }
                        firstItem ?: topSongs.firstOrNull()
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        // SPOTLIGHT HERO + TOP 4 SONGS
                        if (topResultItem != null && topSongs.isNotEmpty()) {
                            item {
                                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                                    ) {
                                        Text(
                                            text = "Top Result",
                                            style = MaterialTheme.typography.titleMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 18.sp
                                            ),
                                            color = TextPrimary,
                                            modifier = Modifier.weight(0.40f)
                                        )
                                        Text(
                                            text = "Songs",
                                            style = MaterialTheme.typography.titleMedium.copy(
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 18.sp
                                            ),
                                            color = TextPrimary,
                                            modifier = Modifier.weight(0.60f)
                                        )
                                    }

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                                    ) {
                                        val isCurrent = topResultItem is Track && currentTrack?.id == topResultItem.id
                                        TopResultSpotlightCard(
                                            item = topResultItem,
                                            isCurrentTrack = isCurrent,
                                            isPlaying = isPlaying,
                                            onPlay = {
                                                if (topResultItem is Track) {
                                                    val q = if (allTracks.isNotEmpty()) allTracks else topSongs
                                                    playTrackWithQueueContext(topResultItem, q)
                                                } else {
                                                    selectedMediaForDetail = topResultItem
                                                    onMediaSelected(topResultItem)
                                                }
                                            },
                                            onClick = {
                                                if (topResultItem is Track) {
                                                    val q = if (allTracks.isNotEmpty()) allTracks else topSongs
                                                    playTrackWithQueueContext(topResultItem, q)
                                                } else {
                                                    selectedMediaForDetail = topResultItem
                                                    onMediaSelected(topResultItem)
                                                }
                                            },
                                            modifier = Modifier.weight(0.40f)
                                        )

                                        TopSongsQuickList(
                                            tracks = topSongs,
                                            currentTrack = currentTrack,
                                            isPlaying = isPlaying,
                                            onPlayTrack = { track ->
                                                val q = if (allTracks.isNotEmpty()) allTracks else topSongs
                                                playTrackWithQueueContext(track, q)
                                            },
                                            onAddToPlaylist = { trackForPlaylist = it },
                                            onDownloadTrack = { downloadManager.downloadTrack(it) },
                                            modifier = Modifier.weight(0.60f)
                                        )
                                    }
                                }
                            }
                        }


                        // ALL CATEGORIZED RESULT SHELVES
                        items(effectiveShelves, key = { it.id }) { shelf ->
                            ShelfRow(
                                shelf = shelf,
                                onMediaClick = { item ->
                                    if (item is Track) {
                                        val shelfTracks = when (shelf) {
                                            is Shelf.Lists.Tracks -> shelf.list
                                            is Shelf.Lists.Items -> shelf.list.filterIsInstance<Track>()
                                            else -> emptyList()
                                        }
                                        val q = if (shelfTracks.isNotEmpty()) shelfTracks else if (allTracks.isNotEmpty()) allTracks else topSongs
                                        playTrackWithQueueContext(item, q)
                                    } else {
                                        selectedMediaForDetail = item
                                        onMediaSelected(item)
                                    }
                                },
                                onPlayTrack = { track ->
                                    val shelfTracks = when (shelf) {
                                        is Shelf.Lists.Tracks -> shelf.list
                                        is Shelf.Lists.Items -> shelf.list.filterIsInstance<Track>()
                                        else -> emptyList()
                                    }
                                    val q = if (shelfTracks.isNotEmpty()) shelfTracks else if (allTracks.isNotEmpty()) allTracks else topSongs
                                    playTrackWithQueueContext(track, q)
                                },
                                onMoreClick = {
                                    selectedShelfForModal = shelf
                                }
                            )
                        }
                    }
                }
            }

            // MODALS: Interactive Full Shelf ("See All") & Full Media Detail (Album / Artist)
            selectedShelfForModal?.let { shelf ->
                SeniorShelfDetailModal(
                    shelf = shelf,
                    onDismiss = { selectedShelfForModal = null },
                    onMediaSelected = { item ->
                        selectedMediaForDetail = item
                        onMediaSelected(item)
                    },
                    onPlayTrack = playTrackWithQueueContext,
                    onAddToPlaylist = { trackForPlaylist = it },
                    onDownloadTrack = { downloadManager.downloadTrack(it) }
                )
            }

            selectedMediaForDetail?.let { mediaItem ->
                SeniorMediaDetailModal(
                    media = mediaItem,
                    onDismiss = { selectedMediaForDetail = null },
                    onMediaSelected = { item ->
                        selectedMediaForDetail = item
                        onMediaSelected(item)
                    },
                    playerViewModel = playerViewModel,
                    extensionManager = extensionManager,
                    onAddToPlaylist = { trackForPlaylist = it },
                    onDownloadTrack = { downloadManager.downloadTrack(it) }
                )
            }
        }
    }
}




@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    playerViewModel: PlayerViewModel,
    extensionManager: ExtensionManager,
    onMediaSelected: (EchoMediaItem) -> Unit
) {
    SearchScreen(
        viewModel = viewModel,
        playerViewModel = playerViewModel,
        onMediaSelected = onMediaSelected
    )
}

// =========================================================================
// =========================================================================
// SENIOR DEVELOPER REDESIGNED LIBRARY WORKSTATION
// =========================================================================

enum class LibraryTab(val title: String, val icon: ImageVector) {
    FAVORITES("Favorites", Icons.Default.Favorite),
    PLAYLISTS("Playlists", Icons.Default.LibraryMusic),
    HISTORY("Recent History", Icons.Default.History)
}

@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel = koinInject()
) {
    val libraryManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val downloadManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }
    val playerViewModel: PlayerViewModel = koinInject()

    val favorites by libraryManager.favorites.collectAsState()
    val playlists by libraryManager.playlists.collectAsState()
    val history by libraryManager.history.collectAsState()

    val currentTrack by playerViewModel.currentTrack.collectAsState()
    val isPlaying by playerViewModel.isPlaying.collectAsState()

    var selectedTab by remember { mutableStateOf(LibraryTab.FAVORITES) }
    var filterQuery by remember { mutableStateOf("") }
    var showCreatePlaylistDialog by remember { mutableStateOf(false) }
    var activePlaylistDetails by remember { mutableStateOf<UserPlaylist?>(null) }

    // Dialog for creating a new playlist
    if (showCreatePlaylistDialog) {
        var playlistTitle by remember { mutableStateOf("") }
        var playlistDesc by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = { showCreatePlaylistDialog = false },
            title = {
                Text("Create New Playlist", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Enter details to create an offline custom playlist collection.", color = TextSecondary, fontSize = 12.5.sp)

                    OutlinedTextField(
                        value = playlistTitle,
                        onValueChange = { playlistTitle = it },
                        label = { Text("Playlist Name") },
                        placeholder = { Text("e.g. Midnight Chill, Synthwave Beats") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = BorderSubtle
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = playlistDesc,
                        onValueChange = { playlistDesc = it },
                        label = { Text("Description (Optional)") },
                        placeholder = { Text("Brief notes about this playlist...") },
                        maxLines = 3,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = BorderSubtle
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val name = playlistTitle.trim()
                        if (name.isNotBlank()) {
                            libraryManager.createPlaylist(name, playlistDesc.trim())
                            showCreatePlaylistDialog = false
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Create Playlist", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { showCreatePlaylistDialog = false },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, BorderSubtle),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Cancel")
                }
            },
            containerColor = Color(0xFF161616),
            tonalElevation = 6.dp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDark)
            .padding(horizontal = 32.dp, vertical = 24.dp)
    ) {
        // If viewing an active playlist's detail view
        val openPlaylist = activePlaylistDetails
        if (openPlaylist != null) {
            // Playlist Detail View
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = { activePlaylistDetails = null },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, BorderSubtle),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("All Playlists", fontSize = 12.5.sp)
                }

                Text(
                    text = openPlaylist.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(Modifier.height(8.dp))
            if (openPlaylist.description.isNotBlank()) {
                Text(openPlaylist.description, color = TextSecondary, fontSize = 13.sp)
                Spacer(Modifier.height(4.dp))
            }
            Text("${openPlaylist.tracks.size} tracks in playlist", color = TextMuted, fontSize = 11.5.sp)

            Spacer(Modifier.height(16.dp))

            // Actions row
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                if (openPlaylist.tracks.isNotEmpty()) {
                    Button(
                        onClick = {
                            val domainTracks = openPlaylist.tracks.map { t: StoredTrack -> t.toTrack() }
                            playerViewModel.playWithQueue(domainTracks.first(), domainTracks)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Play All", fontWeight = FontWeight.Bold)
                    }
                }

                OutlinedButton(
                    onClick = {
                        libraryManager.deletePlaylist(openPlaylist.id)
                        activePlaylistDetails = null
                    },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFEF4444)),
                    border = BorderStroke(1.dp, Color(0xFFEF4444).copy(alpha = 0.35f)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Delete Playlist", fontSize = 12.5.sp)
                }
            }

            Spacer(Modifier.height(20.dp))

            if (openPlaylist.tracks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxWidth().weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.AutoMirrored.Filled.QueueMusic, contentDescription = null, tint = TextMuted, modifier = Modifier.size(48.dp))
                        Spacer(Modifier.height(12.dp))
                        Text("This playlist is empty", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        Spacer(Modifier.height(4.dp))
                        Text("Add tracks from Search or Home by clicking '+ Add to Playlist'.", color = TextSecondary, fontSize = 12.5.sp)
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    itemsIndexed(openPlaylist.tracks, key = { idx: Int, t: StoredTrack -> "${t.id}_$idx" }) { idx: Int, storedTrack: StoredTrack ->
                        val track = storedTrack.toTrack()
                        val isTrackActive = currentTrack?.id == track.id
                        LiquidGlassCard(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            backgroundColor = if (isTrackActive) Color.White.copy(alpha = 0.18f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
                            borderColor = if (isTrackActive) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.10f)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(14.dp)
                            ) {
                                Text("${idx + 1}", color = TextMuted, fontSize = 12.sp, modifier = Modifier.width(24.dp))

                                val coverUrl = track.extractCoverUrl()
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(6.dp),
                                    modifier = Modifier.size(42.dp)
                                ) {
                                    if (!coverUrl.isNullOrBlank()) {
                                        AsyncImage(
                                            model = coverUrl,
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    } else {
                                        Icon(Icons.Default.MusicNote, contentDescription = null, tint = TextMuted, modifier = Modifier.size(20.dp))
                                    }
                                }

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = track.title,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 13.5.sp,
                                        color = if (isTrackActive) Color.White else Color(0xFFE2E8F0),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = formatArtistsForDisplay(track.artists, "Audix Artist"),
                                        fontSize = 11.5.sp,
                                        color = TextSecondary,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                                Text(formatTrackDuration(track.duration), fontSize = 11.5.sp, color = TextMuted)

                                IconButton(
                                    onClick = {
                                        if (isTrackActive && isPlaying) playerViewModel.pause()
                                        else {
                                            val domainTracks = openPlaylist.tracks.map { it.toTrack() }
                                            playerViewModel.playWithQueue(track, domainTracks)
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (isTrackActive && isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                        contentDescription = "Play",
                                        tint = Color.White
                                    )
                                }

                                IconButton(
                                    onClick = { libraryManager.removeTrackFromPlaylist(openPlaylist.id, storedTrack.id) }
                                ) {
                                    Icon(Icons.Default.Delete, contentDescription = "Remove", tint = TextMuted, modifier = Modifier.size(18.dp))
                                }
                            }
                        }
                    }
                }
            }
        } else {
            // Main Library View (Header + Tabs + Content)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Your Library",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.5).sp,
                        color = Color.White
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Curated collections, saved masters & session listening history",
                        fontSize = 13.sp,
                        color = TextSecondary
                    )
                }

                Button(
                    onClick = { showCreatePlaylistDialog = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("New Playlist", fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.height(20.dp))

            // Tab Selector Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LibraryTab.values().forEach { tab ->
                    val isSelected = selectedTab == tab
                    val count = when (tab) {
                        LibraryTab.FAVORITES -> favorites.size
                        LibraryTab.PLAYLISTS -> playlists.size
                        LibraryTab.HISTORY -> history.size
                    }

                    LiquidGlassBox(
                        shape = RoundedCornerShape(8.dp),
                        isSelected = isSelected,
                        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                        onClick = { selectedTab = tab }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                tab.icon,
                                contentDescription = null,
                                tint = if (isSelected) Color(0xFF38BDF8) else TextSecondary,
                                modifier = Modifier.size(16.dp)
                            )
                            Text(
                                text = "${tab.title} ($count)",
                                fontSize = 12.5.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) Color(0xFF38BDF8) else Color.White
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Filter search field for tracks
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .background(SurfaceDark, RoundedCornerShape(8.dp))
                    .border(1.dp, BorderSubtle, RoundedCornerShape(8.dp))
                    .padding(horizontal = 14.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = TextMuted,
                        modifier = Modifier.size(16.dp)
                    )
                    BasicTextField(
                        value = filterQuery,
                        onValueChange = { filterQuery = it },
                        singleLine = true,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        cursorBrush = SolidColor(Color.White),
                        decorationBox = { innerTextField ->
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                if (filterQuery.isEmpty()) {
                                    Text(
                                        "Filter items in ${selectedTab.title.lowercase()}...",
                                        fontSize = 12.5.sp,
                                        color = TextMuted
                                    )
                                }
                                innerTextField()
                            }
                        },
                        modifier = Modifier.weight(1f)
                    )
                    if (filterQuery.isNotBlank()) {
                        IconButton(
                            onClick = { filterQuery = "" },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Clear",
                                tint = TextMuted,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(18.dp))

            // Tab Content
            when (selectedTab) {
                LibraryTab.FAVORITES -> {
                    val filteredFavorites = if (filterQuery.isBlank()) favorites else {
                        favorites.filter {
                            it.title.contains(filterQuery, ignoreCase = true) ||
                            it.artists.any { a -> a.name.contains(filterQuery, ignoreCase = true) }
                        }
                    }

                    if (filteredFavorites.isEmpty()) {
                        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = TextMuted, modifier = Modifier.size(48.dp))
                                Spacer(Modifier.height(12.dp))
                                Text("No favorites saved yet", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                                Spacer(Modifier.height(4.dp))
                                Text("Click the heart icon on any playing track or search result to pin it here.", color = TextSecondary, fontSize = 12.5.sp)
                            }
                        }
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("${filteredFavorites.size} Favorite Tracks", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = TextSecondary)
                            Button(
                                onClick = {
                                    playerViewModel.playWithQueue(filteredFavorites.first(), filteredFavorites)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Play All", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }

                        Spacer(Modifier.height(12.dp))

                        LazyColumn(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            itemsIndexed(filteredFavorites, key = { idx, t -> "${t.id}_$idx" }) { idx, track ->
                                val isTrackActive = currentTrack?.id == track.id
                                LiquidGlassCard(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(10.dp),
                                    backgroundColor = if (isTrackActive) Color.White.copy(alpha = 0.18f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
                                    borderColor = if (isTrackActive) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.10f)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                                    ) {
                                        Text("${idx + 1}", color = TextMuted, fontSize = 12.sp, modifier = Modifier.width(24.dp))

                                        val coverUrl = track.extractCoverUrl()
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(6.dp),
                                            modifier = Modifier.size(42.dp)
                                        ) {
                                            if (!coverUrl.isNullOrBlank()) {
                                                AsyncImage(
                                                    model = coverUrl,
                                                    contentDescription = null,
                                                    modifier = Modifier.fillMaxSize(),
                                                    contentScale = ContentScale.Crop
                                                )
                                            } else {
                                                Icon(Icons.Default.MusicNote, contentDescription = null, tint = TextMuted, modifier = Modifier.size(20.dp))
                                            }
                                        }

                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = track.title,
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 13.5.sp,
                                                color = if (isTrackActive) Color.White else Color(0xFFE2E8F0),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = formatArtistsForDisplay(track.artists, "Audix Artist"),
                                                fontSize = 11.5.sp,
                                                color = TextSecondary,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }

                                        Text(formatTrackDuration(track.duration), fontSize = 11.5.sp, color = TextMuted)

                                        IconButton(
                                            onClick = {
                                                if (isTrackActive && isPlaying) playerViewModel.pause()
                                                else playerViewModel.playWithQueue(track, filteredFavorites)
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (isTrackActive && isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                                contentDescription = "Play",
                                                tint = Color.White
                                            )
                                        }

                                        IconButton(
                                            onClick = { downloadManager.downloadTrack(track) }
                                        ) {
                                            Icon(Icons.Default.Download, contentDescription = "Download", tint = TextSecondary, modifier = Modifier.size(18.dp))
                                        }

                                        IconButton(
                                            onClick = { libraryManager.toggleFavorite(track) }
                                        ) {
                                            Icon(Icons.Default.Favorite, contentDescription = "Unfavorite", tint = Color.White, modifier = Modifier.size(18.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                LibraryTab.PLAYLISTS -> {
                    val filteredPlaylists = if (filterQuery.isBlank()) playlists else {
                        playlists.filter {
                            it.title.contains(filterQuery, ignoreCase = true) ||
                            it.description.contains(filterQuery, ignoreCase = true)
                        }
                    }

                    if (filteredPlaylists.isEmpty()) {
                        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.LibraryMusic, contentDescription = null, tint = TextMuted, modifier = Modifier.size(48.dp))
                                Spacer(Modifier.height(12.dp))
                                Text("No custom playlists yet", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                                Spacer(Modifier.height(4.dp))
                                Text("Create custom playlists to organize your favorite music into focused listening sets.", color = TextSecondary, fontSize = 12.5.sp)
                                Spacer(Modifier.height(16.dp))
                                Button(
                                    onClick = { showCreatePlaylistDialog = true },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Create Playlist", fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            items(filteredPlaylists, key = { it.id }) { pl ->
                                LiquidGlassCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .pointerHoverIcon(PointerIcon.Hand),
                                    shape = RoundedCornerShape(12.dp),
                                    backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                                    borderColor = Color.White.copy(alpha = 0.12f),
                                    onClick = { activePlaylistDetails = pl }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(16.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                                    ) {
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(8.dp),
                                            modifier = Modifier.size(52.dp)
                                        ) {
                                            Icon(Icons.AutoMirrored.Filled.QueueMusic, contentDescription = null, tint = Color.White, modifier = Modifier.size(26.dp))
                                        }

                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(pl.title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Color.White)
                                            Spacer(Modifier.height(2.dp))
                                            Text(
                                                if (pl.description.isNotBlank()) pl.description else "Custom personal playlist",
                                                fontSize = 12.sp,
                                                color = TextSecondary,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Spacer(Modifier.height(4.dp))
                                            Text("${pl.tracks.size} tracks", fontSize = 11.sp, color = TextMuted)
                                        }

                                        if (pl.tracks.isNotEmpty()) {
                                            IconButton(
                                                onClick = {
                                                    val domainTracks = pl.tracks.map { t: StoredTrack -> t.toTrack() }
                                                    playerViewModel.playWithQueue(domainTracks.first(), domainTracks)
                                                }
                                            ) {
                                                Icon(Icons.Default.PlayArrow, contentDescription = "Play All", tint = Color.White)
                                            }
                                        }

                                        IconButton(
                                            onClick = { libraryManager.deletePlaylist(pl.id) }
                                        ) {
                                            Icon(Icons.Default.Delete, contentDescription = "Delete", tint = TextMuted, modifier = Modifier.size(18.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                LibraryTab.HISTORY -> {
                    val filteredHistory = if (filterQuery.isBlank()) history else {
                        history.filter {
                            it.title.contains(filterQuery, ignoreCase = true) ||
                            it.artists.any { a -> a.name.contains(filterQuery, ignoreCase = true) }
                        }
                    }

                    if (filteredHistory.isEmpty()) {
                        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.History, contentDescription = null, tint = TextMuted, modifier = Modifier.size(48.dp))
                                Spacer(Modifier.height(12.dp))
                                Text("No listening history yet", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                                Spacer(Modifier.height(4.dp))
                                Text("Tracks you play from any extension or search will appear here automatically.", color = TextSecondary, fontSize = 12.5.sp)
                            }
                        }
                    } else {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("${filteredHistory.size} Recently Played Tracks", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = TextSecondary)
                            OutlinedButton(
                                onClick = { libraryManager.clearHistory() },
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                                border = BorderStroke(1.dp, BorderSubtle),
                                shape = RoundedCornerShape(8.dp),
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(15.dp))
                                Spacer(Modifier.width(6.dp))
                                Text("Clear History", fontSize = 12.sp)
                            }
                        }

                        Spacer(Modifier.height(12.dp))

                        LazyColumn(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            itemsIndexed(filteredHistory, key = { idx, t -> "${t.id}_$idx" }) { idx, track ->
                                val isTrackActive = currentTrack?.id == track.id
                                LiquidGlassCard(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(10.dp),
                                    backgroundColor = if (isTrackActive) Color.White.copy(alpha = 0.18f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
                                    borderColor = if (isTrackActive) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.10f)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                                    ) {
                                        Text("${idx + 1}", color = TextMuted, fontSize = 12.sp, modifier = Modifier.width(24.dp))

                                        val coverUrl = track.extractCoverUrl()
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(6.dp),
                                            modifier = Modifier.size(42.dp)
                                        ) {
                                            if (!coverUrl.isNullOrBlank()) {
                                                AsyncImage(
                                                    model = coverUrl,
                                                    contentDescription = null,
                                                    modifier = Modifier.fillMaxSize(),
                                                    contentScale = ContentScale.Crop
                                                )
                                            } else {
                                                Icon(Icons.Default.MusicNote, contentDescription = null, tint = TextMuted, modifier = Modifier.size(20.dp))
                                            }
                                        }

                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = track.title,
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 13.5.sp,
                                                color = if (isTrackActive) Color.White else Color(0xFFE2E8F0),
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                text = formatArtistsForDisplay(track.artists, "Audix Artist"),
                                                fontSize = 11.5.sp,
                                                color = TextSecondary,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }

                                        Text(formatTrackDuration(track.duration), fontSize = 11.5.sp, color = TextMuted)

                                        IconButton(
                                            onClick = {
                                                if (isTrackActive && isPlaying) playerViewModel.pause()
                                                else playerViewModel.playWithQueue(track, filteredHistory)
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (isTrackActive && isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                                contentDescription = "Play",
                                                tint = Color.White
                                            )
                                        }

                                        IconButton(
                                            onClick = { libraryManager.toggleFavorite(track) }
                                        ) {
                                            val isFav = libraryManager.isFavorite(track.id)
                                            Icon(
                                                if (isFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                                contentDescription = "Favorite",
                                                tint = if (isFav) Color.White else TextMuted,
                                                modifier = Modifier.size(18.dp)
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

// =========================================================================
// SENIOR DEVELOPER REDESIGNED DOWNLOADS WORKSTATION
// =========================================================================

@Composable
fun DownloadsScreen(
    viewModel: DownloadsViewModel = koinInject()
) {
    val downloadManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }
    val playerViewModel: PlayerViewModel = koinInject()

    val activeDownloads: List<DownloadTask> by downloadManager.activeDownloads.collectAsState(initial = emptyList())
    val completedDownloads: List<DownloadedTrack> by downloadManager.completedDownloads.collectAsState(initial = emptyList())

    val currentTrack by playerViewModel.currentTrack.collectAsState()
    val isPlaying by playerViewModel.isPlaying.collectAsState()

    var searchQuery by remember { mutableStateOf("") }
    val downloadDir = remember { downloadManager.getDownloadDir() }

    val totalSizeBytes = remember(completedDownloads) {
        completedDownloads.sumOf { dl: DownloadedTrack -> dl.sizeBytes }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgDark)
            .padding(horizontal = 32.dp, vertical = 24.dp)
    ) {
        // Top Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Offline Audio Vault",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.5).sp,
                    color = Color.White
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Studio recordings stored on your device for zero-latency offline listening",
                    fontSize = 13.sp,
                    color = TextSecondary
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                OutlinedButton(
                    onClick = { downloadManager.openDownloadsFolder() },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, BorderSubtle),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Default.Folder, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Open Folder", fontSize = 12.5.sp)
                }

                if (completedDownloads.isNotEmpty()) {
                    OutlinedButton(
                        onClick = { downloadManager.clearCompleted() },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = BorderStroke(1.dp, BorderSubtle),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Clear Completed", fontSize = 12.5.sp)
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // Telemetry Metrics Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LiquidGlassCard(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                borderColor = Color.White.copy(alpha = 0.12f),
                modifier = Modifier.weight(1f)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Text("OFFLINE TRACKS", color = TextMuted, fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text("${completedDownloads.size} Tracks", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }

            LiquidGlassCard(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                borderColor = Color.White.copy(alpha = 0.12f),
                modifier = Modifier.weight(1f)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Text("VAULT DISK USAGE", color = TextMuted, fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text(formatSettingsBytes(totalSizeBytes), color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }

            LiquidGlassCard(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                borderColor = Color.White.copy(alpha = 0.12f),
                modifier = Modifier.weight(1.6f)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Text("STORAGE LOCATION", color = TextMuted, fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        downloadDir.absolutePath,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        // Active Queue Section (if any running downloads)
        if (activeDownloads.isNotEmpty()) {
            Spacer(Modifier.height(20.dp))
            Text("ACTIVE DOWNLOADS (${activeDownloads.size})", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
            Spacer(Modifier.height(10.dp))

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                activeDownloads.forEach { task: DownloadTask ->
                    LiquidGlassCard(
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                        borderColor = Color.White.copy(alpha = 0.15f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(task.track.title, fontWeight = FontWeight.SemiBold, fontSize = 13.5.sp, color = Color.White)
                                    Text(
                                        formatArtistsForDisplay(task.track.artists, "Audix Artist"),
                                        fontSize = 11.5.sp,
                                        color = TextSecondary
                                    )
                                }

                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(4.dp),
                                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                                        borderColor = Color.White.copy(alpha = 0.15f)
                                    ) {
                                        Text(
                                            task.status.name,
                                            color = Color.White,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }

                                    IconButton(onClick = { downloadManager.cancel(task.id) }) {
                                        Icon(Icons.Default.Close, contentDescription = "Cancel", tint = TextMuted, modifier = Modifier.size(16.dp))
                                    }
                                }
                            }

                            Spacer(Modifier.height(8.dp))

                            LinearProgressIndicator(
                                progress = { task.progress.coerceIn(0f, 1f) },
                                modifier = Modifier.fillMaxWidth().height(4.dp).clip(RoundedCornerShape(2.dp)),
                                color = Color.White,
                                trackColor = Color(0xFF262626)
                            )

                            Spacer(Modifier.height(4.dp))
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("${(task.progress * 100).toInt()}%", fontSize = 10.5.sp, color = TextSecondary)
                                Text(
                                    if (task.totalBytes > 0) "${formatSettingsBytes(task.bytesRead)} / ${formatSettingsBytes(task.totalBytes)}"
                                    else formatSettingsBytes(task.bytesRead),
                                    fontSize = 10.5.sp,
                                    color = TextMuted
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // Search in downloaded tracks
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(SurfaceDark, RoundedCornerShape(8.dp))
                .border(1.dp, BorderSubtle, RoundedCornerShape(8.dp))
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = TextMuted,
                    modifier = Modifier.size(16.dp)
                )
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    cursorBrush = SolidColor(Color.White),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (searchQuery.isEmpty()) {
                                Text(
                                    "Search offline tracks by title or artist...",
                                    fontSize = 12.5.sp,
                                    color = TextMuted
                                )
                            }
                            innerTextField()
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                if (searchQuery.isNotBlank()) {
                    IconButton(
                        onClick = { searchQuery = "" },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Clear",
                            tint = TextMuted,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Completed List
        val filteredCompleted: List<DownloadedTrack> = if (searchQuery.isBlank()) completedDownloads else {
            completedDownloads.filter { dl: DownloadedTrack ->
                dl.track.title.contains(searchQuery, ignoreCase = true) ||
                dl.track.artists.any { a: Artist -> a.name.contains(searchQuery, ignoreCase = true) }
            }
        }

        if (filteredCompleted.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxWidth().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Download, contentDescription = null, tint = TextMuted, modifier = Modifier.size(48.dp))
                    Spacer(Modifier.height(12.dp))
                    Text("Your offline audio vault is empty", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    Spacer(Modifier.height(4.dp))
                    Text("Click the download icon on any song, playlist, or album to save it for zero-latency offline listening.", color = TextSecondary, fontSize = 12.5.sp)
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                itemsIndexed(filteredCompleted, key = { idx: Int, dl: DownloadedTrack -> "${dl.id}_$idx" }) { idx: Int, dl: DownloadedTrack ->
                    val isTrackActive = currentTrack?.id == dl.track.id
                    LiquidGlassCard(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = if (isTrackActive) Color.White.copy(alpha = 0.18f) else Color(0xFF0A0C10).copy(alpha = 0.30f),
                        borderColor = if (isTrackActive) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.10f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Text("${idx + 1}", color = TextMuted, fontSize = 12.sp, modifier = Modifier.width(24.dp))

                            val coverUrl = dl.track.extractCoverUrl()
                            LiquidGlassBox(
                                shape = RoundedCornerShape(6.dp),
                                modifier = Modifier.size(42.dp)
                            ) {
                                if (!coverUrl.isNullOrBlank()) {
                                    AsyncImage(
                                        model = coverUrl,
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                } else {
                                    Icon(Icons.Default.MusicNote, contentDescription = null, tint = TextMuted, modifier = Modifier.size(20.dp))
                                }
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = dl.track.title,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 13.5.sp,
                                    color = if (isTrackActive) Color.White else Color(0xFFE2E8F0),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = formatArtistsForDisplay(dl.track.artists, "Audix Artist"),
                                    fontSize = 11.5.sp,
                                    color = TextSecondary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // Format tag
                            LiquidGlassBox(
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                                borderColor = Color.White.copy(alpha = 0.12f)
                            ) {
                                Text(
                                    dl.format.uppercase(java.util.Locale.US),
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }

                            // File size
                            Text(formatSettingsBytes(dl.sizeBytes), fontSize = 11.5.sp, color = TextMuted)

                            // Play offline
                            IconButton(
                                onClick = {
                                    downloadManager.playOffline(dl)
                                }
                            ) {
                                Icon(
                                    imageVector = if (isTrackActive && isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = "Play Offline",
                                    tint = Color.White
                                )
                            }

                            // Reveal in explorer
                            IconButton(
                                onClick = { downloadManager.openInExplorer(dl.file) }
                            ) {
                                Icon(Icons.Default.Folder, contentDescription = "Reveal file", tint = TextMuted, modifier = Modifier.size(18.dp))
                            }

                            // Delete
                            IconButton(
                                onClick = { downloadManager.deleteDownloaded(dl) }
                            ) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete", tint = TextMuted, modifier = Modifier.size(18.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

// =========================================================================
// SENIOR DEVELOPER REDESIGNED MONOCHROME SETTINGS WORKSTATION
// =========================================================================

enum class SettingsSection(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
) {
    AUDIO("Audio & Playback", "Stream bitrate, volume normalization, buffer latency & LibVLC decoding", Icons.Default.GraphicEq),
    APPEARANCE("Appearance & Visuals", "3D music screensaver, interface styling & fluid animations", Icons.Default.Palette),
    AI_INTELLIGENCE("Audix Intelligence", "Gemini AI API key, generative playlists & smart DJ", Icons.Default.AutoAwesome),
    STORAGE("Storage & Downloads", "Download paths, directory picker & cache management", Icons.Default.Folder),
    LOCAL_LIBRARY("Local Music Folders", "Offline music scan directories & storage paths", Icons.Default.LibraryMusic),
    SYSTEM("System & Desktop", "Tray minimization, startup & notifications", Icons.Default.Computer),
    EXTENSIONS("Extensions & Sources", "Plugins, data providers & repositories", Icons.Default.Extension),
    ABOUT("About & Diagnostics", "Engine build, memory metrics & factory reset", Icons.Default.Info)
}

private fun formatSettingsBytes(bytes: Long): String {
    if (bytes <= 0) return "0 B"
    val units = arrayOf("B", "KB", "MB", "GB")
    var b = bytes.toDouble()
    var i = 0
    while (b >= 1024.0 && i < units.size - 1) {
        b /= 1024.0
        i++
    }
    return String.format(Locale.US, "%.1f %s", b, units[i])
}

private fun openSettingsDirInExplorer(dir: File) {
    try {
        val userHome = System.getProperty("user.home")?.let { File(it).canonicalFile }
        val canonical = dir.canonicalFile
        if (userHome != null && !canonical.toPath().startsWith(userHome.toPath())) {
            println("[SearchAndOthers] Blocked opening directory outside user profile: $canonical")
            return
        }
        if (!canonical.exists()) canonical.mkdirs()
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(canonical)
        }
    } catch (_: Exception) {}
}

private fun launchSettingsFolderPicker(initialDir: File?, onSelected: (File) -> Unit) {
    javax.swing.SwingUtilities.invokeLater {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName())
            val chooser = JFileChooser().apply {
                fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
                dialogTitle = "Select Directory"
                isAcceptAllFileFilterUsed = false
                if (initialDir != null && initialDir.exists()) {
                    currentDirectory = initialDir
                }
            }
            val result = chooser.showOpenDialog(null)
            if (result == JFileChooser.APPROVE_OPTION && chooser.selectedFile != null) {
                val chosen = chooser.selectedFile
                if (chosen.exists() && chosen.isDirectory) {
                    onSelected(chosen)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private fun launchSettingsImageFilePicker(initialDir: File?, onSelected: (File) -> Unit) {
    javax.swing.SwingUtilities.invokeLater {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName())
            val chooser = JFileChooser().apply {
                fileSelectionMode = JFileChooser.FILES_ONLY
                dialogTitle = "Select Screensaver Background Image"
                isAcceptAllFileFilterUsed = true
                val filter = javax.swing.filechooser.FileNameExtensionFilter(
                    "Image Files (*.jpg, *.jpeg, *.png, *.webp, *.bmp)",
                    "jpg", "jpeg", "png", "webp", "bmp"
                )
                addChoosableFileFilter(filter)
                fileFilter = filter
                if (initialDir != null && initialDir.exists()) {
                    currentDirectory = if (initialDir.isDirectory) initialDir else initialDir.parentFile
                }
            }
            val result = chooser.showOpenDialog(null)
            if (result == JFileChooser.APPROVE_OPTION && chooser.selectedFile != null) {
                val chosen = chooser.selectedFile
                if (chosen.exists() && chosen.isFile) {
                    onSelected(chosen)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

@Composable
fun SettingsCategoryCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    subtitle: String? = null,
    badge: String? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    LiquidGlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
        borderColor = Color.White.copy(alpha = 0.12f)
    ) {
        Column(Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    LiquidGlassBox(
                        modifier = Modifier.size(32.dp),
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.35f),
                        borderColor = Color.White.copy(alpha = 0.15f)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Icon(
                                icon,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(17.dp)
                            )
                        }
                    }
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        if (subtitle != null) {
                            Text(
                                text = subtitle,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.50f),
                                fontSize = 11.5.sp
                            )
                        }
                    }
                }
                if (badge != null) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                        borderColor = Color.White.copy(alpha = 0.18f)
                    ) {
                        Text(
                            text = badge,
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }
            }
            Spacer(Modifier.height(14.dp))
            content()
        }
    }
}

@Composable
private fun SettingRow(
    title: String,
    description: String? = null,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f).padding(end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            if (!description.isNullOrBlank()) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.50f),
                    fontSize = 11.5.sp,
                    lineHeight = 16.sp
                )
            }
        }
        content()
    }
}

@Composable
private fun SettingDivider() {
    HorizontalDivider(
        color = Color.White.copy(alpha = 0.06f),
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
private fun MonochromeSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Black,
            checkedTrackColor = Color.White,
            uncheckedThumbColor = Color.White.copy(alpha = 0.50f),
            uncheckedTrackColor = Color(0xFF222222),
            uncheckedBorderColor = Color.White.copy(alpha = 0.15f)
        )
    )
}

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = koinInject(),
    onLaunchScreensaver: () -> Unit = {}
) {
    val settings = koinInject<EchoSettings>()
    val platform = koinInject<AppPlatform>()

    LaunchedEffect(settings) {
        DesktopBackgroundManager.initialize(settings)
    }

    val wallpapers by DesktopBackgroundManager.wallpapers.collectAsState()
    val currentWallpaperId by DesktopBackgroundManager.currentWallpaperId.collectAsState()

    val initialSectionName = settings.getString("active_settings_section", "APPEARANCE") ?: "APPEARANCE"
    var activeSection by remember {
        mutableStateOf(runCatching { SettingsSection.valueOf(initialSectionName) }.getOrDefault(SettingsSection.APPEARANCE))
    }
    var searchQuery by remember { mutableStateOf("") }

    // Audio & Playback state
    var audioQuality by remember { mutableStateOf(settings.getString("audio_quality", "high") ?: "high") }
    var normalizationEnabled by remember { mutableStateOf(settings.getBoolean("audio_normalization", false)) }
    var skipSilence by remember { mutableStateOf(settings.getBoolean("skip_silence", true)) }
    var bufferLatency by remember { mutableStateOf(settings.getInt("buffer_latency", 400).coerceAtLeast(150)) }

    // Appearance & Screensaver Studio state
    var screensaverTimeout by remember { mutableStateOf(settings.getInt("screensaver_timeout", 60)) }
    var screensaverTheme by remember { mutableStateOf(settings.getString("screensaver_theme", "card_mosaic") ?: "card_mosaic") }
    var screensaverSpectrumStyle by remember { mutableStateOf(settings.getString("screensaver_spectrum_style", "bars") ?: "bars") }
    var screensaverClockFormat by remember { mutableStateOf(settings.getString("screensaver_clock_format", "24h") ?: "24h") }
    var screensaverShowSeconds by remember { mutableStateOf(settings.getBoolean("screensaver_show_seconds", true)) }
    var screensaverShowDate by remember { mutableStateOf(settings.getBoolean("screensaver_show_date", true)) }
    var screensaverShowTelemetry by remember { mutableStateOf(settings.getBoolean("screensaver_show_telemetry", true)) }
    var screensaverBurnInProtection by remember { mutableStateOf(settings.getBoolean("screensaver_burn_in_protection", true)) }
    var screensaverAmbientGlow by remember { mutableStateOf(settings.getBoolean("screensaver_ambient_glow", true)) }
    var screensaverVinylSpeed by remember { mutableStateOf(settings.getString("screensaver_vinyl_speed", "33rpm") ?: "33rpm") }
    var screensaverMouseExit by remember { mutableStateOf(settings.getBoolean("screensaver_mouse_exit", true)) }

    var screensaverBgMode by remember { mutableStateOf(settings.getString("screensaver_bg_mode", "default") ?: "default") }
    var screensaverBgCustomPath by remember { mutableStateOf(settings.getString("screensaver_bg_custom_path", "") ?: "") }
    var screensaverBgOpacity by remember { mutableStateOf(settings.getInt("screensaver_bg_opacity", 45)) }

    var enableAnimations by remember { mutableStateOf(settings.getBoolean("enable_animations", true)) }
    var dynamicAccentGlow by remember { mutableStateOf(settings.getBoolean("dynamic_accent_glow", true)) }

    // Audix Intelligence state
    var geminiApiKey by remember { mutableStateOf(settings.getString("gemini_api_key", "") ?: "") }
    var geminiModel by remember { mutableStateOf(settings.getString("gemini_selected_model", "gemini-2.5-flash") ?: "gemini-2.5-flash") }
    var isTestingAiConnection by remember { mutableStateOf(false) }
    var aiConnectionStatus by remember { mutableStateOf<String?>(null) }
    var aiConnectionSuccess by remember { mutableStateOf<Boolean?>(null) }

    // Storage state
    var downloadDir by remember {
        val custom = settings.getString("download_dir", "") ?: ""
        val dir = if (custom.isNotBlank()) File(custom) else platform.downloadsDir.toFile()
        if (!dir.exists()) dir.mkdirs()
        mutableStateOf(dir)
    }
    var cacheSizeBytes by remember { mutableStateOf<Long?>(null) }
    var isCalculatingCache by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // Local library state
    var customMusicFolders by remember {
        val raw = settings.getString("custom_music_folders", null) ?: ""
        mutableStateOf(raw.split(';').filter { it.isNotBlank() })
    }

    // System & Desktop state
    var minimizeToTray by remember { mutableStateOf(settings.getBoolean("minimize_to_tray_on_close", false)) }
    var showNotifications by remember { mutableStateOf(settings.getBoolean("show_track_notifications", true)) }

    // Extensions state
    var checkForUpdates by remember { mutableStateOf(settings.getBoolean("check_for_updates", true)) }

    // Dialog & Feedback states
    var showCacheClearedDialog by remember { mutableStateOf(false) }
    var showResetConfirmDialog by remember { mutableStateOf(false) }
    var showResetSuccessDialog by remember { mutableStateOf(false) }
    var showCopiedBanner by remember { mutableStateOf(false) }
    var libraryScanTriggered by remember { mutableStateOf(false) }

    fun refreshCacheSize() {
        isCalculatingCache = true
        coroutineScope.launch(Dispatchers.IO) {
            val size = runCatching {
                val cDir = platform.cacheDir.toFile()
                if (cDir.exists()) cDir.walkTopDown().filter { it.isFile }.sumOf { it.length() } else 0L
            }.getOrDefault(0L)
            withContext(Dispatchers.Main) {
                cacheSizeBytes = size
                isCalculatingCache = false
            }
        }
    }

    LaunchedEffect(Unit) {
        refreshCacheSize()
    }

    LaunchedEffect(showCopiedBanner) {
        if (showCopiedBanner) {
            kotlinx.coroutines.delay(2500)
            showCopiedBanner = false
        }
    }

    LaunchedEffect(libraryScanTriggered) {
        if (libraryScanTriggered) {
            kotlinx.coroutines.delay(3000)
            libraryScanTriggered = false
        }
    }

    // Dialogs
    if (showCacheClearedDialog) {
        AlertDialog(
            onDismissRequest = { showCacheClearedDialog = false },
            title = { Text("Cache Cleared", color = Color.White, fontWeight = FontWeight.Bold) },
            text = { Text("Temporary artwork thumbnails, streamed media fragments, and network session data have been cleared.", color = Color.White.copy(alpha = 0.70f)) },
            containerColor = Color(0xFF141414),
            confirmButton = {
                Button(
                    onClick = { showCacheClearedDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                    Text("OK", fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    if (showResetConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showResetConfirmDialog = false },
            title = { Text("Reset All Preferences?", color = Color.White, fontWeight = FontWeight.Bold) },
            text = {
                Text(
                    "This action restores audio bitrates, buffer latency, screensaver timeouts, and UI settings back to factory defaults. Your downloaded tracks and stored playlists will not be deleted.",
                    color = Color.White.copy(alpha = 0.70f)
                )
            },
            containerColor = Color(0xFF141414),
            confirmButton = {
                Button(
                    onClick = {
                        settings.putString("audio_quality", "high")
                        audioQuality = "high"
                        settings.putBoolean("audio_normalization", false)
                        normalizationEnabled = false
                        settings.putInt("buffer_latency", 400)
                        bufferLatency = 400
                        settings.putBoolean("skip_silence", true)
                        skipSilence = true
                        settings.putInt("screensaver_timeout", 10)
                        screensaverTimeout = 10
                        settings.putBoolean("enable_animations", true)
                        enableAnimations = true
                        settings.putBoolean("dynamic_accent_glow", true)
                        dynamicAccentGlow = true
                        settings.remove("download_dir")
                        downloadDir = platform.downloadsDir.toFile()
                        settings.putBoolean("minimize_to_tray_on_close", false)
                        minimizeToTray = false
                        settings.putBoolean("show_track_notifications", true)
                        showNotifications = true
                        settings.putBoolean("check_for_updates", true)
                        checkForUpdates = true
                        settings.remove("custom_music_folders")
                        customMusicFolders = emptyList()
                        showResetConfirmDialog = false
                        showResetSuccessDialog = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                    Text("Reset to Defaults", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetConfirmDialog = false }) {
                    Text("Cancel", color = Color.White.copy(alpha = 0.70f))
                }
            }
        )
    }

    if (showResetSuccessDialog) {
        AlertDialog(
            onDismissRequest = { showResetSuccessDialog = false },
            title = { Text("Settings Restored", color = Color.White, fontWeight = FontWeight.Bold) },
            text = { Text("All preferences have been successfully reset to default factory configurations.", color = Color.White.copy(alpha = 0.70f)) },
            containerColor = Color(0xFF141414),
            confirmButton = {
                Button(
                    onClick = { showResetSuccessDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
                ) {
                    Text("OK", fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    // Master Layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        // Top Header Row
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "System preferences, audio decoding, offline storage, and desktop integration",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.50f)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (showCopiedBanner) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(6.dp),
                        backgroundColor = Color(0x991C1C1C),
                        borderColor = Color.White.copy(alpha = 0.30f)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Diagnostics Copied", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                LiquidGlassBox(
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = Color(0x80161616),
                    borderColor = Color.White.copy(alpha = 0.18f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text("Auto-Saved", color = Color.White.copy(alpha = 0.85f), fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        // Live Search Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(Color(0xFF141414), RoundedCornerShape(8.dp))
                .border(1.dp, BorderSubtle, RoundedCornerShape(8.dp))
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.55f),
                    modifier = Modifier.size(18.dp)
                )
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    cursorBrush = SolidColor(Color.White),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (searchQuery.isEmpty()) {
                                Text(
                                    "Search settings (e.g. latency, cache, tray, quality, folders)...",
                                    fontSize = 13.sp,
                                    color = Color.White.copy(alpha = 0.40f)
                                )
                            }
                            innerTextField()
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                if (searchQuery.isNotEmpty()) {
                    IconButton(
                        onClick = { searchQuery = "" },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Clear search",
                            tint = Color.White.copy(alpha = 0.60f),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        val q = searchQuery.trim().lowercase()
        val isSearching = q.isNotEmpty()

        if (!isSearching) {
            // Master-Detail Workstation Layout
            Row(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Left Navigation Sidebar
                Column(
                    modifier = Modifier
                        .width(230.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    SettingsSection.values().forEach { section ->
                        val isSelected = activeSection == section
                        val interactionSource = remember { MutableInteractionSource() }
                        val isHovered by interactionSource.collectIsHoveredAsState()

                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = when {
                                isSelected -> Color(0x99202020)
                                isHovered -> Color(0x60161616)
                                else -> Color.Transparent
                            },
                            borderColor = when {
                                isSelected -> Color.White.copy(alpha = 0.25f)
                                isHovered -> Color.White.copy(alpha = 0.12f)
                                else -> Color.Transparent
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .clickable(interactionSource = interactionSource, indication = null) {
                                    activeSection = section
                                    settings.putString("active_settings_section", section.name)
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .width(3.dp)
                                        .height(16.dp)
                                        .clip(RoundedCornerShape(2.dp))
                                        .background(if (isSelected) Color.White else Color.Transparent)
                                )
                                Spacer(Modifier.width(10.dp))
                                Icon(
                                    section.icon,
                                    contentDescription = null,
                                    tint = if (isSelected) Color.White else Color.White.copy(alpha = 0.55f),
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(Modifier.width(10.dp))
                                Text(
                                    text = section.title,
                                    color = if (isSelected) Color.White else Color.White.copy(alpha = 0.70f),
                                    fontSize = 13.sp,
                                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                                )
                            }
                        }
                    }
                }

                // Right Content Panel
                LazyColumn(
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    item {
                        // Section Header
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LiquidGlassBox(
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.size(34.dp)
                            ) {
                                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                    Icon(activeSection.icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                                }
                            }
                            Spacer(Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = activeSection.title,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    text = activeSection.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.White.copy(alpha = 0.50f)
                                )
                            }
                        }
                    }

                    when (activeSection) {
                        SettingsSection.AI_INTELLIGENCE -> {
                            item {
                                RenderAiIntelligenceCard(
                                    apiKey = geminiApiKey,
                                    selectedModel = geminiModel,
                                    isTesting = isTestingAiConnection,
                                    connectionStatus = aiConnectionStatus,
                                    isSuccess = aiConnectionSuccess,
                                    onApiKeyChange = { key ->
                                        geminiApiKey = key
                                        settings.putString("gemini_api_key", key)
                                        aiConnectionStatus = null
                                        aiConnectionSuccess = null
                                    },
                                    onModelChange = { model ->
                                        geminiModel = model
                                        settings.putString("gemini_selected_model", model)
                                    },
                                    onTestConnection = {
                                        coroutineScope.launch {
                                            isTestingAiConnection = true
                                            aiConnectionStatus = "Connecting to Google Generative AI..."
                                            aiConnectionSuccess = null
                                            val res = dev.brahmkshatriya.echo.desktop.ai.AudixAiService.testApiKey(geminiApiKey, geminiModel)
                                            if (res.isSuccess) {
                                                aiConnectionStatus = "Connected successfully (${geminiModel})"
                                                aiConnectionSuccess = true
                                            } else {
                                                aiConnectionStatus = res.exceptionOrNull()?.message ?: "Connection failed"
                                                aiConnectionSuccess = false
                                            }
                                            isTestingAiConnection = false
                                        }
                                    }
                                )
                            }
                        }
                        SettingsSection.AUDIO -> {
                            item {
                                RenderAudioFidelityCard(
                                    audioQuality = audioQuality,
                                    normalizationEnabled = normalizationEnabled,
                                    skipSilence = skipSilence,
                                    onQualityChange = {
                                        audioQuality = it
                                        settings.putString("audio_quality", it)
                                    },
                                    onNormalizationChange = {
                                        normalizationEnabled = it
                                        settings.putBoolean("audio_normalization", it)
                                    },
                                    onSkipSilenceChange = {
                                        skipSilence = it
                                        settings.putBoolean("skip_silence", it)
                                    }
                                )
                            }
                            item {
                                RenderAudioEngineCard(
                                    bufferLatency = bufferLatency,
                                    onBufferLatencyChange = {
                                        bufferLatency = it
                                        settings.putInt("buffer_latency", it)
                                    }
                                )
                            }
                        }
                        SettingsSection.APPEARANCE -> {
                            item {
                                RenderWorkspaceWallpaperCard(
                                    wallpapers = wallpapers,
                                    currentWallpaperId = currentWallpaperId,
                                    onSelectWallpaper = { id ->
                                        DesktopBackgroundManager.selectWallpaper(id)
                                    },
                                    onAddWallpaper = { file ->
                                        DesktopBackgroundManager.addCustomWallpaper(file)
                                    },
                                    onDeleteWallpaper = { id ->
                                        DesktopBackgroundManager.deleteCustomWallpaper(id)
                                    }
                                )
                            }
                            item {
                                RenderScreensaverStudioCard(
                                    screensaverTheme = screensaverTheme,
                                    screensaverSpectrumStyle = screensaverSpectrumStyle,
                                    screensaverClockFormat = screensaverClockFormat,
                                    screensaverShowSeconds = screensaverShowSeconds,
                                    screensaverShowDate = screensaverShowDate,
                                    screensaverShowTelemetry = screensaverShowTelemetry,
                                    screensaverBurnInProtection = screensaverBurnInProtection,
                                    screensaverAmbientGlow = screensaverAmbientGlow,
                                    screensaverVinylSpeed = screensaverVinylSpeed,
                                    screensaverTimeout = screensaverTimeout,
                                    screensaverMouseExit = screensaverMouseExit,
                                    screensaverBgMode = screensaverBgMode,
                                    screensaverBgCustomPath = screensaverBgCustomPath,
                                    screensaverBgOpacity = screensaverBgOpacity,
                                    onThemeChange = {
                                        screensaverTheme = it
                                        settings.putString("screensaver_theme", it)
                                    },
                                    onSpectrumStyleChange = {
                                        screensaverSpectrumStyle = it
                                        settings.putString("screensaver_spectrum_style", it)
                                    },
                                    onClockFormatChange = {
                                        screensaverClockFormat = it
                                        settings.putString("screensaver_clock_format", it)
                                    },
                                    onShowSecondsChange = {
                                        screensaverShowSeconds = it
                                        settings.putBoolean("screensaver_show_seconds", it)
                                    },
                                    onShowDateChange = {
                                        screensaverShowDate = it
                                        settings.putBoolean("screensaver_show_date", it)
                                    },
                                    onShowTelemetryChange = {
                                        screensaverShowTelemetry = it
                                        settings.putBoolean("screensaver_show_telemetry", it)
                                    },
                                    onBurnInProtectionChange = {
                                        screensaverBurnInProtection = it
                                        settings.putBoolean("screensaver_burn_in_protection", it)
                                    },
                                    onAmbientGlowChange = {
                                        screensaverAmbientGlow = it
                                        settings.putBoolean("screensaver_ambient_glow", it)
                                    },
                                    onVinylSpeedChange = {
                                        screensaverVinylSpeed = it
                                        settings.putString("screensaver_vinyl_speed", it)
                                    },
                                    onTimeoutChange = {
                                        screensaverTimeout = it
                                        settings.putInt("screensaver_timeout", it)
                                    },
                                    onMouseExitChange = {
                                        screensaverMouseExit = it
                                        settings.putBoolean("screensaver_mouse_exit", it)
                                    },
                                    onBgModeChange = {
                                        screensaverBgMode = it
                                        settings.putString("screensaver_bg_mode", it)
                                    },
                                    onBgCustomPathChange = {
                                        screensaverBgCustomPath = it
                                        settings.putString("screensaver_bg_custom_path", it)
                                    },
                                    onBgOpacityChange = {
                                        screensaverBgOpacity = it
                                        settings.putInt("screensaver_bg_opacity", it)
                                    },
                                    onPreviewScreensaver = onLaunchScreensaver
                                )
                            }
                            item {
                                RenderAppearanceStyleCard(
                                    enableAnimations = enableAnimations,
                                    dynamicAccentGlow = dynamicAccentGlow,
                                    onAnimationsChange = {
                                        enableAnimations = it
                                        settings.putBoolean("enable_animations", it)
                                    },
                                    onDynamicGlowChange = {
                                        dynamicAccentGlow = it
                                        settings.putBoolean("dynamic_accent_glow", it)
                                    }
                                )
                            }
                        }
                        SettingsSection.STORAGE -> {
                            item {
                                RenderDownloadStorageCard(
                                    downloadDir = downloadDir,
                                    onDirChange = {
                                        downloadDir = it
                                        settings.putString("download_dir", it.absolutePath)
                                        DesktopDownloadManager.getInstance().setDownloadDir(it)
                                    },
                                    onResetDefault = {
                                        val def = platform.downloadsDir.toFile().also { if (!it.exists()) it.mkdirs() }
                                        downloadDir = def
                                        settings.remove("download_dir")
                                        DesktopDownloadManager.getInstance().setDownloadDir(def)
                                    }
                                )
                            }
                            item {
                                RenderCacheStorageCard(
                                    cacheSizeBytes = cacheSizeBytes,
                                    isCalculating = isCalculatingCache,
                                    cacheDirName = platform.cacheDir.name,
                                    onRefresh = { refreshCacheSize() },
                                    onClearCache = {
                                        isCalculatingCache = true
                                        coroutineScope.launch(Dispatchers.IO) {
                                            runCatching { platform.cacheDir.toFile().deleteRecursively() }
                                            val size = runCatching {
                                                val cDir = platform.cacheDir.toFile()
                                                if (cDir.exists()) cDir.walkTopDown().filter { it.isFile }.sumOf { it.length() } else 0L
                                            }.getOrDefault(0L)
                                            withContext(Dispatchers.Main) {
                                                cacheSizeBytes = size
                                                isCalculatingCache = false
                                                showCacheClearedDialog = true
                                            }
                                        }
                                    }
                                )
                            }
                        }
                        SettingsSection.LOCAL_LIBRARY -> {
                            item {
                                RenderLocalLibraryFoldersCard(
                                    downloadDir = downloadDir,
                                    customFolders = customMusicFolders,
                                    scanTriggered = libraryScanTriggered,
                                    onAddFolder = {
                                        launchSettingsFolderPicker(null) { newFolder ->
                                            val path = newFolder.absolutePath
                                            if (!path.contains(';') && !customMusicFolders.contains(path)) {
                                                val updated = customMusicFolders + path
                                                customMusicFolders = updated
                                                settings.putString("custom_music_folders", updated.joinToString(";"))
                                            }
                                        }
                                    },
                                    onRemoveFolder = { folderPath ->
                                        val updated = customMusicFolders.filter { it != folderPath }
                                        customMusicFolders = updated
                                        settings.putString("custom_music_folders", updated.joinToString(";"))
                                    },
                                    onTriggerScan = {
                                        libraryScanTriggered = true
                                        settings.notifyChanged()
                                    }
                                )
                            }
                        }
                        SettingsSection.SYSTEM -> {
                            item {
                                RenderSystemIntegrationCard(
                                    minimizeToTray = minimizeToTray,
                                    showNotifications = showNotifications,
                                    onMinimizeToTrayChange = {
                                        minimizeToTray = it
                                        settings.putBoolean("minimize_to_tray_on_close", it)
                                    },
                                    onShowNotificationsChange = {
                                        showNotifications = it
                                        settings.putBoolean("show_track_notifications", it)
                                    }
                                )
                            }
                        }
                        SettingsSection.EXTENSIONS -> {
                            item {
                                RenderExtensionsSettingsCard(
                                    extensionsDir = platform.extensionsDir.toFile(),
                                    checkForUpdates = checkForUpdates,
                                    onCheckUpdatesChange = {
                                        checkForUpdates = it
                                        settings.putBoolean("check_for_updates", it)
                                    }
                                )
                            }
                        }
                        SettingsSection.ABOUT -> {
                            item {
                                RenderAboutAndDiagnosticsCard(
                                    downloadDir = downloadDir,
                                    cacheDir = platform.cacheDir.toFile(),
                                    extensionsDir = platform.extensionsDir.toFile(),
                                    audioQuality = audioQuality,
                                    bufferLatency = bufferLatency,
                                    normalizationEnabled = normalizationEnabled,
                                    skipSilence = skipSilence,
                                    screensaverTimeout = screensaverTimeout,
                                    minimizeToTray = minimizeToTray,
                                    customFoldersCount = customMusicFolders.size,
                                    onCopyDiagnostics = {
                                        val totalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024)
                                        val freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024)
                                        val maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024)
                                        val usedMem = totalMem - freeMem
                                        val diag = buildString {
                                            appendLine("=== AUDIX DESKTOP DIAGNOSTICS ===")
                                            appendLine("Version: 1.0.3-UNIFIED")
                                            appendLine("OS: ${System.getProperty("os.name")} (${System.getProperty("os.arch")})")
                                            appendLine("Java: ${System.getProperty("java.version")} - ${System.getProperty("java.vendor")}")
                                            appendLine("Memory: Used ${usedMem}MB / Total ${totalMem}MB / Max ${maxMem}MB")
                                            appendLine("Downloads: ${downloadDir.absolutePath}")
                                            appendLine("Cache: ${platform.cacheDir}")
                                            appendLine("Extensions: ${platform.extensionsDir}")
                                            appendLine("Audio Quality: $audioQuality")
                                            appendLine("Buffer Latency: ${bufferLatency}ms")
                                            appendLine("Audio Normalization: $normalizationEnabled")
                                            appendLine("Skip Silence: $skipSilence")
                                            appendLine("Screensaver Timeout: ${screensaverTimeout}s")
                                            appendLine("Minimize to Tray: $minimizeToTray")
                                            appendLine("Custom Music Folders: ${customMusicFolders.size}")
                                        }
                                        try {
                                            val clip = Toolkit.getDefaultToolkit().systemClipboard
                                            val sel = StringSelection(diag)
                                            clip.setContents(sel, sel)
                                            showCopiedBanner = true
                                        } catch (_: Exception) {}
                                    },
                                    onRequestReset = { showResetConfirmDialog = true }
                                )
                            }
                        }
                    }
                }
            }
        } else {
            // Live Search View: Matches cards across all categories in monochrome style
            val matchesAudio = q.contains("audio") || q.contains("qual") || q.contains("bitrate") || q.contains("stream") || q.contains("opus") || q.contains("norm") || q.contains("vol") || q.contains("silence") || q.contains("trim") || q.contains("buffer") || q.contains("latency") || q.contains("vlc") || q.contains("decod") || q.contains("engine")
            val matchesAppearance = q.contains("appear") || q.contains("visual") || q.contains("screen") || q.contains("saver") || q.contains("anim") || q.contains("motion") || q.contains("theme") || q.contains("glow") || q.contains("scrim") || q.contains("idle") || q.contains("time")
            val matchesAi = q.contains("ai") || q.contains("gemini") || q.contains("intel") || q.contains("prompt") || q.contains("dj") || q.contains("persona") || q.contains("radar") || q.contains("smart") || q.contains("key")
            val matchesStorage = q.contains("stor") || q.contains("down") || q.contains("folder") || q.contains("dir") || q.contains("path") || q.contains("cache") || q.contains("temp") || q.contains("clear") || q.contains("disk")
            val matchesLocal = q.contains("local") || q.contains("music") || q.contains("scan") || q.contains("offline") || q.contains("mp3") || q.contains("flac") || q.contains("dir") || q.contains("folder")
            val matchesSystem = q.contains("sys") || q.contains("tray") || q.contains("close") || q.contains("min") || q.contains("notif") || q.contains("key") || q.contains("media") || q.contains("window")
            val matchesExt = q.contains("ext") || q.contains("plug") || q.contains("source") || q.contains("repo") || q.contains("update") || q.contains("saavn") || q.contains("sound") || q.contains("radio")
            val matchesAbout = q.contains("about") || q.contains("ver") || q.contains("diag") || q.contains("info") || q.contains("jvm") || q.contains("java") || q.contains("mem") || q.contains("reset") || q.contains("factory")

            val hasAnyMatch = matchesAudio || matchesAppearance || matchesAi || matchesStorage || matchesLocal || matchesSystem || matchesExt || matchesAbout

            LazyColumn(
                modifier = Modifier.weight(1f).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 32.dp)
            ) {
                if (!hasAnyMatch) {
                    item {
                        LiquidGlassCard(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth().padding(vertical = 32.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(32.dp).fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(Icons.Default.Search, contentDescription = null, tint = Color.White.copy(alpha = 0.40f), modifier = Modifier.size(36.dp))
                                Spacer(Modifier.height(12.dp))
                                Text("No settings found for \"$searchQuery\"", fontWeight = FontWeight.SemiBold, color = Color.White)
                                Spacer(Modifier.height(4.dp))
                                Text("Try searching for 'bitrate', 'buffer', 'tray', 'cache', or 'folder'", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.40f))
                            }
                        }
                    }
                } else {
                    if (matchesAudio) {
                        item {
                            RenderAudioFidelityCard(
                                audioQuality = audioQuality,
                                normalizationEnabled = normalizationEnabled,
                                skipSilence = skipSilence,
                                onQualityChange = {
                                    audioQuality = it
                                    settings.putString("audio_quality", it)
                                },
                                onNormalizationChange = {
                                    normalizationEnabled = it
                                    settings.putBoolean("audio_normalization", it)
                                },
                                onSkipSilenceChange = {
                                    skipSilence = it
                                    settings.putBoolean("skip_silence", it)
                                }
                            )
                        }
                        item {
                            RenderAudioEngineCard(
                                bufferLatency = bufferLatency,
                                onBufferLatencyChange = {
                                    bufferLatency = it
                                    settings.putInt("buffer_latency", it)
                                }
                            )
                        }
                    }
                    if (matchesAi) {
                        item {
                            RenderAiIntelligenceCard(
                                apiKey = geminiApiKey,
                                selectedModel = geminiModel,
                                isTesting = isTestingAiConnection,
                                connectionStatus = aiConnectionStatus,
                                isSuccess = aiConnectionSuccess,
                                onApiKeyChange = { key ->
                                    geminiApiKey = key
                                    settings.putString("gemini_api_key", key)
                                    aiConnectionStatus = null
                                    aiConnectionSuccess = null
                                },
                                onModelChange = { model ->
                                    geminiModel = model
                                    settings.putString("gemini_selected_model", model)
                                },
                                onTestConnection = {
                                    coroutineScope.launch {
                                        isTestingAiConnection = true
                                        aiConnectionStatus = "Connecting to Google Generative AI..."
                                        aiConnectionSuccess = null
                                        val res = dev.brahmkshatriya.echo.desktop.ai.AudixAiService.testApiKey(geminiApiKey, geminiModel)
                                        if (res.isSuccess) {
                                            aiConnectionStatus = "Connected successfully (${geminiModel})"
                                            aiConnectionSuccess = true
                                        } else {
                                            aiConnectionStatus = res.exceptionOrNull()?.message ?: "Connection failed"
                                            aiConnectionSuccess = false
                                        }
                                        isTestingAiConnection = false
                                    }
                                }
                            )
                        }
                    }
                    if (matchesAppearance) {
                        item {
                            RenderScreensaverStudioCard(
                                screensaverTheme = screensaverTheme,
                                screensaverSpectrumStyle = screensaverSpectrumStyle,
                                screensaverClockFormat = screensaverClockFormat,
                                screensaverShowSeconds = screensaverShowSeconds,
                                screensaverShowDate = screensaverShowDate,
                                screensaverShowTelemetry = screensaverShowTelemetry,
                                screensaverBurnInProtection = screensaverBurnInProtection,
                                screensaverAmbientGlow = screensaverAmbientGlow,
                                screensaverVinylSpeed = screensaverVinylSpeed,
                                screensaverTimeout = screensaverTimeout,
                                screensaverMouseExit = screensaverMouseExit,
                                screensaverBgMode = screensaverBgMode,
                                screensaverBgCustomPath = screensaverBgCustomPath,
                                screensaverBgOpacity = screensaverBgOpacity,
                                onThemeChange = {
                                    screensaverTheme = it
                                    settings.putString("screensaver_theme", it)
                                },
                                onSpectrumStyleChange = {
                                    screensaverSpectrumStyle = it
                                    settings.putString("screensaver_spectrum_style", it)
                                },
                                onClockFormatChange = {
                                    screensaverClockFormat = it
                                    settings.putString("screensaver_clock_format", it)
                                },
                                onShowSecondsChange = {
                                    screensaverShowSeconds = it
                                    settings.putBoolean("screensaver_show_seconds", it)
                                },
                                onShowDateChange = {
                                    screensaverShowDate = it
                                    settings.putBoolean("screensaver_show_date", it)
                                },
                                onShowTelemetryChange = {
                                    screensaverShowTelemetry = it
                                    settings.putBoolean("screensaver_show_telemetry", it)
                                },
                                onBurnInProtectionChange = {
                                    screensaverBurnInProtection = it
                                    settings.putBoolean("screensaver_burn_in_protection", it)
                                },
                                onAmbientGlowChange = {
                                    screensaverAmbientGlow = it
                                    settings.putBoolean("screensaver_ambient_glow", it)
                                },
                                onVinylSpeedChange = {
                                    screensaverVinylSpeed = it
                                    settings.putString("screensaver_vinyl_speed", it)
                                },
                                onTimeoutChange = {
                                    screensaverTimeout = it
                                    settings.putInt("screensaver_timeout", it)
                                },
                                onMouseExitChange = {
                                    screensaverMouseExit = it
                                    settings.putBoolean("screensaver_mouse_exit", it)
                                },
                                onBgModeChange = {
                                    screensaverBgMode = it
                                    settings.putString("screensaver_bg_mode", it)
                                },
                                onBgCustomPathChange = {
                                    screensaverBgCustomPath = it
                                    settings.putString("screensaver_bg_custom_path", it)
                                },
                                onBgOpacityChange = {
                                    screensaverBgOpacity = it
                                    settings.putInt("screensaver_bg_opacity", it)
                                },
                                onPreviewScreensaver = onLaunchScreensaver
                            )
                        }
                        item {
                            RenderAppearanceStyleCard(
                                enableAnimations = enableAnimations,
                                dynamicAccentGlow = dynamicAccentGlow,
                                onAnimationsChange = {
                                    enableAnimations = it
                                    settings.putBoolean("enable_animations", it)
                                },
                                onDynamicGlowChange = {
                                    dynamicAccentGlow = it
                                    settings.putBoolean("dynamic_accent_glow", it)
                                }
                            )
                        }
                    }
                    if (matchesStorage) {
                        item {
                            RenderDownloadStorageCard(
                                downloadDir = downloadDir,
                                onDirChange = {
                                    downloadDir = it
                                    settings.putString("download_dir", it.absolutePath)
                                    DesktopDownloadManager.getInstance().setDownloadDir(it)
                                },
                                onResetDefault = {
                                    val def = platform.downloadsDir.toFile().also { if (!it.exists()) it.mkdirs() }
                                    downloadDir = def
                                    settings.remove("download_dir")
                                    DesktopDownloadManager.getInstance().setDownloadDir(def)
                                }
                            )
                        }
                        item {
                            RenderCacheStorageCard(
                                cacheSizeBytes = cacheSizeBytes,
                                isCalculating = isCalculatingCache,
                                cacheDirName = platform.cacheDir.name,
                                onRefresh = { refreshCacheSize() },
                                onClearCache = {
                                    isCalculatingCache = true
                                    coroutineScope.launch(Dispatchers.IO) {
                                        runCatching { platform.cacheDir.toFile().deleteRecursively() }
                                        val size = runCatching {
                                            val cDir = platform.cacheDir.toFile()
                                            if (cDir.exists()) cDir.walkTopDown().filter { it.isFile }.sumOf { it.length() } else 0L
                                        }.getOrDefault(0L)
                                        withContext(Dispatchers.Main) {
                                            cacheSizeBytes = size
                                            isCalculatingCache = false
                                            showCacheClearedDialog = true
                                        }
                                    }
                                }
                            )
                        }
                    }
                    if (matchesLocal) {
                        item {
                            RenderLocalLibraryFoldersCard(
                                downloadDir = downloadDir,
                                customFolders = customMusicFolders,
                                scanTriggered = libraryScanTriggered,
                                onAddFolder = {
                                    launchSettingsFolderPicker(null) { newFolder ->
                                        val path = newFolder.absolutePath
                                        if (!customMusicFolders.contains(path)) {
                                            val updated = customMusicFolders + path
                                            customMusicFolders = updated
                                            settings.putString("custom_music_folders", updated.joinToString(";"))
                                        }
                                    }
                                },
                                onRemoveFolder = { folderPath ->
                                    val updated = customMusicFolders.filter { it != folderPath }
                                    customMusicFolders = updated
                                    settings.putString("custom_music_folders", updated.joinToString(";"))
                                },
                                onTriggerScan = {
                                    libraryScanTriggered = true
                                    settings.notifyChanged()
                                }
                            )
                        }
                    }
                    if (matchesSystem) {
                        item {
                            RenderSystemIntegrationCard(
                                minimizeToTray = minimizeToTray,
                                showNotifications = showNotifications,
                                onMinimizeToTrayChange = {
                                    minimizeToTray = it
                                    settings.putBoolean("minimize_to_tray_on_close", it)
                                },
                                onShowNotificationsChange = {
                                    showNotifications = it
                                    settings.putBoolean("show_track_notifications", it)
                                }
                            )
                        }
                    }
                    if (matchesExt) {
                        item {
                            RenderExtensionsSettingsCard(
                                extensionsDir = platform.extensionsDir.toFile(),
                                checkForUpdates = checkForUpdates,
                                onCheckUpdatesChange = {
                                    checkForUpdates = it
                                    settings.putBoolean("check_for_updates", it)
                                }
                            )
                        }
                    }
                    if (matchesAbout) {
                        item {
                            RenderAboutAndDiagnosticsCard(
                                downloadDir = downloadDir,
                                cacheDir = platform.cacheDir.toFile(),
                                extensionsDir = platform.extensionsDir.toFile(),
                                audioQuality = audioQuality,
                                bufferLatency = bufferLatency,
                                normalizationEnabled = normalizationEnabled,
                                skipSilence = skipSilence,
                                screensaverTimeout = screensaverTimeout,
                                minimizeToTray = minimizeToTray,
                                customFoldersCount = customMusicFolders.size,
                                onCopyDiagnostics = {
                                    val totalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024)
                                    val freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024)
                                    val maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024)
                                    val usedMem = totalMem - freeMem
                                    val diag = buildString {
                                        appendLine("=== AUDIX DESKTOP DIAGNOSTICS ===")
                                        appendLine("Version: 1.0.3-UNIFIED")
                                        appendLine("OS: ${System.getProperty("os.name")} (${System.getProperty("os.arch")})")
                                        appendLine("Java: ${System.getProperty("java.version")} - ${System.getProperty("java.vendor")}")
                                        appendLine("Memory: Used ${usedMem}MB / Total ${totalMem}MB / Max ${maxMem}MB")
                                        appendLine("Downloads: ${downloadDir.absolutePath}")
                                        appendLine("Cache: ${platform.cacheDir}")
                                        appendLine("Extensions: ${platform.extensionsDir}")
                                        appendLine("Audio Quality: $audioQuality")
                                        appendLine("Buffer Latency: ${bufferLatency}ms")
                                        appendLine("Audio Normalization: $normalizationEnabled")
                                        appendLine("Skip Silence: $skipSilence")
                                        appendLine("Screensaver Timeout: ${screensaverTimeout}s")
                                        appendLine("Minimize to Tray: $minimizeToTray")
                                        appendLine("Custom Music Folders: ${customMusicFolders.size}")
                                    }
                                    try {
                                        val clip = Toolkit.getDefaultToolkit().systemClipboard
                                        val sel = StringSelection(diag)
                                        clip.setContents(sel, sel)
                                        showCopiedBanner = true
                                    } catch (_: Exception) {}
                                },
                                onRequestReset = { showResetConfirmDialog = true }
                            )
                        }
                    }
                }
            }
        }
    }
}

// ==========================================
// MODULAR MONOCHROME SETTINGS CARD RENDERERS
// ==========================================

@Composable
private fun RenderAiIntelligenceCard(
    apiKey: String,
    selectedModel: String,
    isTesting: Boolean,
    connectionStatus: String?,
    isSuccess: Boolean?,
    onApiKeyChange: (String) -> Unit,
    onModelChange: (String) -> Unit,
    onTestConnection: () -> Unit
) {
    var isKeyVisible by remember { mutableStateOf(false) }

    SettingsCategoryCard(
        title = "Audix Intelligence & Gemini AI Engine",
        subtitle = "Connect Google Gemini generative intelligence to unlock natural-language playlist synthesis, real-time DJ track commentary, song lore & neural vibe radar.",
        icon = Icons.Default.AutoAwesome,
        badge = if (apiKey.isNotBlank()) "Gemini Active" else "Autonomous Studio"
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Engine Status Glass Banner
            LiquidGlassCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = if (apiKey.isNotBlank()) Color(0xFF00382B).copy(alpha = 0.28f) else Color(0xFF1A153A).copy(alpha = 0.28f),
                borderColor = if (apiKey.isNotBlank()) Color(0xFF00E5A3).copy(alpha = 0.35f) else Color(0xFF8A70FF).copy(alpha = 0.35f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LiquidGlassBox(
                        modifier = Modifier.size(36.dp),
                        shape = CircleShape,
                        backgroundColor = if (apiKey.isNotBlank()) Color(0xFF00E5A3).copy(alpha = 0.18f) else Color(0xFF8A70FF).copy(alpha = 0.18f),
                        borderColor = if (apiKey.isNotBlank()) Color(0xFF00E5A3).copy(alpha = 0.40f) else Color(0xFF8A70FF).copy(alpha = 0.40f)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Icon(
                                if (apiKey.isNotBlank()) Icons.Default.AutoAwesome else Icons.Default.Psychology,
                                contentDescription = null,
                                tint = if (apiKey.isNotBlank()) Color(0xFF00E5A3) else Color(0xFFB5A4FF),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (apiKey.isNotBlank()) "Google Gemini Generative AI Active" else "Autonomous Studio AI Engine Active",
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(
                            text = if (apiKey.isNotBlank())
                                "Connected to Google DeepMind Gemini API. Natural language reasoning, lyrical interpretation, and DJ commentary are streaming live."
                            else
                                "Audix AI works 100% offline with built-in semantic curation and acoustic feature detection. Provide a Gemini API key below to unlock limitless deep-story reasoning.",
                            color = Color.White.copy(alpha = 0.70f),
                            fontSize = 11.sp,
                            lineHeight = 15.sp
                        )
                    }
                }
            }

            // API Key Input Field with Liquid Glass styling
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Google Gemini API Key",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(
                        modifier = Modifier
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                runCatching {
                                    Desktop.getDesktop().browse(java.net.URI("https://aistudio.google.com/app/apikey"))
                                }
                            }
                            .pointerHoverIcon(PointerIcon.Hand),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.OpenInNew,
                            contentDescription = null,
                            tint = Color(0xFF4E95FF),
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = "Get Free Gemini Key",
                            color = Color(0xFF4E95FF),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Spacer(Modifier.height(8.dp))

                LiquidGlassBox(
                    modifier = Modifier.fillMaxWidth().height(44.dp),
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = Color(0xFF0F131D).copy(alpha = 0.40f),
                    borderColor = Color.White.copy(alpha = 0.15f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Key,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = 0.50f),
                            modifier = Modifier.size(16.dp)
                        )

                        Spacer(Modifier.width(10.dp))

                        BasicTextField(
                            value = apiKey,
                            onValueChange = onApiKeyChange,
                            modifier = Modifier.weight(1f),
                            textStyle = TextStyle(
                                color = Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            singleLine = true,
                            visualTransformation = if (isKeyVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            cursorBrush = SolidColor(Color.White),
                            decorationBox = { innerTextField ->
                                if (apiKey.isEmpty()) {
                                    Text(
                                        text = "Paste AIzaSy... key or leave blank for autonomous studio mode",
                                        color = Color.White.copy(alpha = 0.35f),
                                        fontSize = 12.sp
                                    )
                                }
                                innerTextField()
                            }
                        )

                        if (apiKey.isNotEmpty()) {
                            IconButton(
                                onClick = { isKeyVisible = !isKeyVisible },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    if (isKeyVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                    contentDescription = "Toggle Visibility",
                                    tint = Color.White.copy(alpha = 0.60f),
                                    modifier = Modifier.size(16.dp)
                                )
                            }

                            Spacer(Modifier.width(4.dp))

                            IconButton(
                                onClick = { onApiKeyChange("") },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    Icons.Default.Clear,
                                    contentDescription = "Clear Key",
                                    tint = Color.White.copy(alpha = 0.60f),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Connection Diagnostic Feedback Banner
            if (connectionStatus != null) {
                LiquidGlassBox(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = if (isSuccess == true) Color(0xFF00E5A3).copy(alpha = 0.12f) else Color(0xFFFF4848).copy(alpha = 0.12f),
                    borderColor = if (isSuccess == true) Color(0xFF00E5A3).copy(alpha = 0.30f) else Color(0xFFFF4848).copy(alpha = 0.30f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            if (isSuccess == true) Icons.Default.CheckCircle else Icons.Default.ErrorOutline,
                            contentDescription = null,
                            tint = if (isSuccess == true) Color(0xFF00E5A3) else Color(0xFFFF6B6B),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = connectionStatus,
                            color = if (isSuccess == true) Color(0xFF00E5A3) else Color(0xFFFF6B6B),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // Model Selection Pills & Test Button Row
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Gemini Foundation Model",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(Modifier.height(8.dp))

                val availableModels = listOf(
                    "gemini-2.5-flash" to "2.5 Flash (Recommended)",
                    "gemini-2.0-flash" to "2.0 Flash (Fast)",
                    "gemini-1.5-flash" to "1.5 Flash (Lightweight)",
                    "gemini-1.5-pro" to "1.5 Pro (Deep Reasoning)"
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    availableModels.forEach { (modelId, modelName) ->
                        val isSelected = selectedModel == modelId
                        LiquidGlassBox(
                            modifier = Modifier
                                .weight(1f)
                                .height(38.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ) { onModelChange(modelId) }
                                .pointerHoverIcon(PointerIcon.Hand),
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = if (isSelected) Color.White.copy(alpha = 0.20f) else Color(0xFF0F131D).copy(alpha = 0.35f),
                            borderColor = if (isSelected) Color.White.copy(alpha = 0.50f) else Color.White.copy(alpha = 0.12f)
                        ) {
                            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().padding(horizontal = 6.dp)) {
                                Text(
                                    text = modelName,
                                    color = if (isSelected) Color.White else Color.White.copy(alpha = 0.65f),
                                    fontSize = 10.5.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }

            // Action Buttons Row (Test Connection)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LiquidGlassBox(
                    modifier = Modifier
                        .height(36.dp)
                        .clickable(
                            enabled = !isTesting,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = onTestConnection
                        )
                        .pointerHoverIcon(if (isTesting) PointerIcon.Default else PointerIcon.Hand),
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.White.copy(alpha = 0.14f),
                    borderColor = Color.White.copy(alpha = 0.28f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (isTesting) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(14.dp),
                                color = Color.White,
                                strokeWidth = 1.8.dp
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = "Testing...",
                                color = Color.White,
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Medium
                            )
                        } else {
                            Icon(
                                Icons.Default.Refresh,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = "Test Connection",
                                color = Color.White,
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            // Feature Highlights Matrix
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf(
                    Icons.Default.AutoAwesome to "Prompt-to-Playlist" to "Natural language to full playable queue",
                    Icons.Default.GraphicEq to "AI DJ & Lore" to "Behind-the-scenes song stories & meaning",
                    Icons.Default.Tune to "Musical DNA" to "Estimated BPM, Key & Mood metadata",
                    Icons.Default.Psychology to "Taste Radar" to "5-axis acoustic persona visualization"
                ).forEach { (pair, desc) ->
                    val (icon, title) = pair
                    LiquidGlassBox(
                        modifier = Modifier.weight(1f).height(74.dp),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = Color(0xFF0F131D).copy(alpha = 0.28f),
                        borderColor = Color.White.copy(alpha = 0.10f)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(8.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(icon, contentDescription = null, tint = Color.White.copy(alpha = 0.85f), modifier = Modifier.size(13.dp))
                                Spacer(Modifier.width(5.dp))
                                Text(title, color = Color.White, fontSize = 10.5.sp, fontWeight = FontWeight.Bold, maxLines = 1)
                            }
                            Spacer(Modifier.height(3.dp))
                            Text(desc, color = Color.White.copy(alpha = 0.55f), fontSize = 9.sp, lineHeight = 12.sp, maxLines = 2)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RenderAudioFidelityCard(
    audioQuality: String,
    normalizationEnabled: Boolean,
    skipSilence: Boolean,
    onQualityChange: (String) -> Unit,
    onNormalizationChange: (Boolean) -> Unit,
    onSkipSilenceChange: (Boolean) -> Unit
) {
    SettingsCategoryCard(
        title = "Streaming Audio Quality",
        subtitle = "Configures dynamic stream bitrate for audio provider extensions.",
        icon = Icons.Default.GraphicEq
    ) {
        Text("Select Bitrate Tier", fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                Triple("high", "320 kbps", "High Fidelity Opus/AAC"),
                Triple("medium", "160 kbps", "Standard Balanced"),
                Triple("low", "96 kbps", "Data Saver")
            ).forEach { (id, label, desc) ->
                val isSel = audioQuality == id
                LiquidGlassBox(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    isSelected = isSel,
                    onClick = { onQualityChange(id) }
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(if (isSel) Color.White else Color.White.copy(alpha = 0.25f))
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = label,
                                fontWeight = if (isSel) FontWeight.Bold else FontWeight.SemiBold,
                                color = Color.White,
                                fontSize = 13.5.sp
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = desc,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = if (isSel) 0.70f else 0.40f),
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }

        SettingDivider()

        SettingRow(
            title = "Volume Normalization (ReplayGain)",
            description = "Equalizes loudness across disparate song releases and providers to prevent volume spikes."
        ) {
            MonochromeSwitch(
                checked = normalizationEnabled,
                onCheckedChange = onNormalizationChange
            )
        }

        SettingDivider()

        SettingRow(
            title = "Auto-Trim Silent Headers & Footers",
            description = "Automatically skips long silent intros and fadeouts for faster, seamless track transitions."
        ) {
            MonochromeSwitch(
                checked = skipSilence,
                onCheckedChange = onSkipSilenceChange
            )
        }
    }
}

@Composable
private fun RenderAudioEngineCard(
    bufferLatency: Int,
    onBufferLatencyChange: (Int) -> Unit
) {
    SettingsCategoryCard(
        title = "LibVLC Engine & Hardware Decoder",
        subtitle = "Embedded LibVLC 64-bit native pipeline parameters.",
        icon = Icons.Default.Tune,
        badge = "LIBVLC 64-BIT"
    ) {
        SettingRow(
            title = "Native Audio Backend",
            description = "LibVLC 4.8.3 Core • SoXR Sinc 32-bit Float Resampler • Zero-Clock Jitter"
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                borderColor = Color.White.copy(alpha = 0.20f)
            ) {
                Text(
                    "HARDWARE ACTIVE",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }
        }

        SettingDivider()

        SettingRow(
            title = "Network Stream Buffer Latency",
            description = "HTTP streaming preload buffer. Lower values start playback faster; higher values prevent stutter on slow Wi-Fi."
        ) {
            Text(
                text = "${bufferLatency} ms",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 13.5.sp
            )
        }

        Spacer(Modifier.height(8.dp))
        Slider(
            value = bufferLatency.toFloat(),
            onValueChange = { onBufferLatencyChange(it.toInt()) },
            valueRange = 150f..1000f,
            steps = 16,
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.White,
                inactiveTrackColor = Color(0xFF2C2C2C)
            )
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(200 to "Low Latency (200ms)", 400 to "Standard (400ms)", 800 to "High Buffer (800ms)").forEach { (ms, name) ->
                val isSel = bufferLatency == ms
                LiquidGlassBox(
                    shape = RoundedCornerShape(6.dp),
                    isSelected = isSel,
                    onClick = { onBufferLatencyChange(ms) }
                ) {
                    Text(
                        text = name,
                        fontSize = 11.sp,
                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.70f),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun RenderScreensaverStudioCard(
    screensaverTheme: String,
    screensaverSpectrumStyle: String,
    screensaverClockFormat: String,
    screensaverShowSeconds: Boolean,
    screensaverShowDate: Boolean,
    screensaverShowTelemetry: Boolean,
    screensaverBurnInProtection: Boolean,
    screensaverAmbientGlow: Boolean,
    screensaverVinylSpeed: String,
    screensaverTimeout: Int,
    screensaverMouseExit: Boolean,
    screensaverBgMode: String,
    screensaverBgCustomPath: String,
    screensaverBgOpacity: Int,
    onThemeChange: (String) -> Unit,
    onSpectrumStyleChange: (String) -> Unit,
    onClockFormatChange: (String) -> Unit,
    onShowSecondsChange: (Boolean) -> Unit,
    onShowDateChange: (Boolean) -> Unit,
    onShowTelemetryChange: (Boolean) -> Unit,
    onBurnInProtectionChange: (Boolean) -> Unit,
    onAmbientGlowChange: (Boolean) -> Unit,
    onVinylSpeedChange: (String) -> Unit,
    onTimeoutChange: (Int) -> Unit,
    onMouseExitChange: (Boolean) -> Unit,
    onBgModeChange: (String) -> Unit,
    onBgCustomPathChange: (String) -> Unit,
    onBgOpacityChange: (Int) -> Unit,
    onPreviewScreensaver: () -> Unit
) {
    SettingsCategoryCard(
        title = "Screensaver Studio & Visualizer",
        subtitle = "Acoustic 3D ambient display, dynamic themes, spectrum analyzer, and OLED protection.",
        icon = Icons.Default.Palette
    ) {
        // Quick Preview Header Action
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f).padding(end = 12.dp)) {
                Text(
                    text = "Acoustic Screensaver Studio",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 13.5.sp
                )
                Text(
                    text = "Apple-style floating music console with live album art, cosmic vortex clock, and backdrop visualizers.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.50f)
                )
            }

            Button(
                onClick = onPreviewScreensaver,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 7.dp)
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(Modifier.width(6.dp))
                Text("Preview Now", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }

        SettingDivider()

        // 1. Frequency Spectrum Visualizer Style
        SettingRow(
            title = "Acoustic Spectrum Analyzer Style",
            description = "Select geometric waveform visualization rendered during playback."
        ) {}

        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                "bars" to "Stereo Bars (36-Band)",
                "radial" to "Radial Halo",
                "wave" to "Liquid Wave",
                "none" to "Hidden"
            ).forEach { (styleId, label) ->
                val isSel = screensaverSpectrumStyle == styleId
                LiquidGlassBox(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(6.dp),
                    isSelected = isSel,
                    onClick = { onSpectrumStyleChange(styleId) }
                ) {
                    Text(
                        text = label,
                        fontSize = 11.5.sp,
                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.70f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 7.dp)
                    )
                }
            }
        }

        SettingDivider()

        // 2. Chronometer & Clock Format
        SettingRow(
            title = "Chronometer Time Display Format",
            description = "Choose between standard 24-hour military notation and 12-hour AM/PM notation."
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                listOf("24h" to "24-Hour (HH:mm)", "12h" to "12-Hour (hh:mm)").forEach { (fmt, label) ->
                    val isSel = screensaverClockFormat == fmt
                    LiquidGlassBox(
                        shape = RoundedCornerShape(6.dp),
                        isSelected = isSel,
                        onClick = { onClockFormatChange(fmt) }
                    ) {
                        Text(
                            text = label,
                            fontSize = 11.5.sp,
                            fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.70f),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }

        SettingDivider()

        SettingRow(
            title = "Live Running Seconds Indicator",
            description = "Display precision running seconds counter next to the master clock."
        ) {
            MonochromeSwitch(
                checked = screensaverShowSeconds,
                onCheckedChange = onShowSecondsChange
            )
        }

        SettingDivider()

        SettingRow(
            title = "Formatted Calendar Date Capsule",
            description = "Show full day of week, month, date, and year pill beneath the clock."
        ) {
            MonochromeSwitch(
                checked = screensaverShowDate,
                onCheckedChange = onShowDateChange
            )
        }

        SettingDivider()

        // 3. Display & Panel Protection
        SettingRow(
            title = "OLED Anti-Burn-In Protection",
            description = "Gradually drifts screensaver elements along an organic Lissajous orbit to prevent pixel burn-in on OLED and IPS monitors."
        ) {
            MonochromeSwitch(
                checked = screensaverBurnInProtection,
                onCheckedChange = onBurnInProtectionChange
            )
        }

        SettingDivider()

        SettingRow(
            title = "Celestial Cosmic Glow & Constellations",
            description = "Renders dynamic chromatic nebula auras and stardust filaments in the screensaver background."
        ) {
            MonochromeSwitch(
                checked = screensaverAmbientGlow,
                onCheckedChange = onAmbientGlowChange
            )
        }

        SettingDivider()

        // Background Backdrop Selection
        SettingRow(
            title = "Screensaver Background Backdrop",
            description = "Select what renders behind the visualizers, clock, and controls: cosmic space, live album art, or your custom image."
        ) {}

        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                Triple("default", "Cosmic Nebula", Icons.Default.Bedtime),
                Triple("album_art", "Live Album Art", Icons.Default.Album),
                Triple("custom_image", "Custom Wallpaper", Icons.Default.Image)
            ).forEach { (modeId, label, icon) ->
                val isSel = screensaverBgMode == modeId
                LiquidGlassBox(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    isSelected = isSel,
                    onClick = { onBgModeChange(modeId) }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(icon, contentDescription = null, tint = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.6f), modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = label,
                            fontSize = 11.5.sp,
                            fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.70f),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        if (screensaverBgMode == "custom_image") {
            Spacer(Modifier.height(10.dp))
            LiquidGlassCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                borderColor = Color.White.copy(alpha = 0.12f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val customFile = remember(screensaverBgCustomPath) {
                        if (screensaverBgCustomPath.isNotBlank()) File(screensaverBgCustomPath) else null
                    }
                    val validCustomFile = customFile?.takeIf { it.exists() && it.isFile }

                    if (validCustomFile != null) {
                        AsyncImage(
                            model = validCustomFile,
                            contentDescription = null,
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(6.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(Modifier.width(12.dp))
                    } else {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.size(44.dp)
                        ) {
                            Icon(Icons.Default.Image, contentDescription = null, tint = Color.White.copy(alpha = 0.4f), modifier = Modifier.size(22.dp))
                        }
                        Spacer(Modifier.width(12.dp))
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = validCustomFile?.name ?: "No image selected",
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = validCustomFile?.absolutePath ?: "Select JPG, PNG, WEBP, or BMP file",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.45f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    Button(
                        onClick = {
                            val initialDir = validCustomFile?.parentFile
                            launchSettingsImageFilePicker(initialDir) { chosenFile ->
                                onBgCustomPathChange(chosenFile.absolutePath)
                            }
                        },
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2C2C2C),
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.FolderOpen, contentDescription = null, modifier = Modifier.size(15.dp))
                        Spacer(Modifier.width(5.dp))
                        Text("Browse...", fontSize = 11.5.sp, fontWeight = FontWeight.Medium)
                    }

                    if (screensaverBgCustomPath.isNotBlank()) {
                        Spacer(Modifier.width(6.dp))
                        IconButton(
                            onClick = { onBgCustomPathChange("") },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White.copy(alpha = 0.6f), modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(10.dp))

        SettingRow(
            title = "Backdrop Opacity & Dimming",
            description = "Control opacity and intensity of the screensaver background."
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.30f),
                borderColor = Color.White.copy(alpha = 0.20f)
            ) {
                Text(
                    text = "${screensaverBgOpacity}%",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }
        }

        Spacer(Modifier.height(4.dp))
        Slider(
            value = screensaverBgOpacity.toFloat(),
            onValueChange = { onBgOpacityChange(it.toInt()) },
            valueRange = 5f..100f,
            steps = 18,
            colors = SliderDefaults.colors(
                thumbColor = Color.White,
                activeTrackColor = Color.White,
                inactiveTrackColor = Color(0xFF2C2C2C)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                20 to "20% Subtle",
                40 to "40% Moderate",
                60 to "60% Balanced",
                80 to "80% Vivid",
                100 to "100% Full"
            ).forEach { (presetVal, label) ->
                val isSel = screensaverBgOpacity == presetVal
                LiquidGlassBox(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(6.dp),
                    isSelected = isSel,
                    onClick = { onBgOpacityChange(presetVal) }
                ) {
                    Text(
                        text = label,
                        fontSize = 10.5.sp,
                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.65f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
        }

        SettingDivider()

        SettingRow(
            title = "Lossless Audio Telemetry Badges",
            description = "Display 320 kbps, 48 kHz, FLAC, and hardware playback badges inside screensaver."
        ) {
            MonochromeSwitch(
                checked = screensaverShowTelemetry,
                onCheckedChange = onShowTelemetryChange
            )
        }

        SettingDivider()

        // 4. Inactivity & Trigger
        SettingRow(
            title = "Inactivity Timeout Before Activation",
            description = "Select duration of keyboard and mouse inactivity to launch the acoustic 3D visualizer."
        ) {}

        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
            listOf(
                10 to "10 sec",
                30 to "30 sec",
                60 to "1 min",
                120 to "2 min",
                300 to "5 min",
                0 to "Off"
            ).forEach { (sec, label) ->
                val isSel = screensaverTimeout == sec
                LiquidGlassBox(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(6.dp),
                    isSelected = isSel,
                    onClick = { onTimeoutChange(sec) }
                ) {
                    Text(
                        text = label,
                        fontSize = 12.sp,
                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSel) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.70f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 7.dp)
                    )
                }
            }
        }

        SettingDivider()

        SettingRow(
            title = "Activate When Mouse Leaves App Window",
            description = "Automatically launch screensaver 2.5 seconds after your cursor exits the Audix application window."
        ) {
            MonochromeSwitch(
                checked = screensaverMouseExit,
                onCheckedChange = onMouseExitChange
            )
        }
    }
}

@Composable
private fun RenderWorkspaceWallpaperCard(
    wallpapers: List<BackgroundWallpaper>,
    currentWallpaperId: String,
    onSelectWallpaper: (String) -> Unit,
    onAddWallpaper: (File) -> Unit,
    onDeleteWallpaper: (String) -> Unit
) {
    SettingsCategoryCard(
        title = "Workspace Wallpaper & Atmosphere",
        subtitle = "Personalize your studio backdrop with high-resolution themes or custom photography.",
        icon = Icons.Default.Wallpaper,
        badge = "${wallpapers.size} Themes"
    ) {
        // Active Wallpaper Hero Glass Bar
        val activeWallpaper = wallpapers.find { it.id == currentWallpaperId } ?: wallpapers.firstOrNull()

        LiquidGlassCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            backgroundColor = Color(0xFF0F131D).copy(alpha = 0.35f),
            borderColor = Color.White.copy(alpha = 0.15f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Active thumbnail preview
                val activeThumb = activeWallpaper?.let { remember(it.id) { DesktopBackgroundManager.loadThumbnailBitmap(it) } }
                Box(
                    modifier = Modifier
                        .size(width = 80.dp, height = 48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.25f), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    if (activeThumb != null) {
                        Image(
                            bitmap = activeThumb,
                            contentDescription = activeWallpaper.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        LiquidGlassBox(shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxSize()) {
                            Icon(Icons.Default.Wallpaper, contentDescription = null, tint = Color.White.copy(alpha = 0.4f), modifier = Modifier.size(24.dp))
                        }
                    }
                }

                Spacer(Modifier.width(14.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = activeWallpaper?.title ?: "Default Master",
                            fontSize = 13.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(Modifier.width(8.dp))
                        LiquidGlassBox(
                            shape = RoundedCornerShape(12.dp),
                            backgroundColor = Color(0xFF22C55E).copy(alpha = 0.15f),
                            borderColor = Color(0xFF22C55E).copy(alpha = 0.40f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(5.dp)
                                        .background(Color(0xFF22C55E), CircleShape)
                                )
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = "ACTIVE BACKDROP",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF86EFAC)
                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = activeWallpaper?.subtitle ?: "Live application canvas background",
                        fontSize = 11.5.sp,
                        color = Color.White.copy(alpha = 0.60f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(Modifier.width(12.dp))

                // Upload / Add Image Button
                Button(
                    onClick = {
                        launchSettingsImageFilePicker(null) { chosenFile ->
                            onAddWallpaper(chosenFile)
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3B82F6).copy(alpha = 0.25f),
                        contentColor = Color.White
                    ),
                    border = BorderStroke(1.dp, Color(0xFF60A5FA).copy(alpha = 0.45f)),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Icon(Icons.Default.AddPhotoAlternate, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color(0xFF93C5FD))
                    Spacer(Modifier.width(6.dp))
                    Text("Add Wallpaper", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                }
            }
        }

        Spacer(Modifier.height(14.dp))

        Text(
            text = "SELECT BACKDROP THEME",
            fontSize = 10.5.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White.copy(alpha = 0.45f),
            letterSpacing = 1.sp
        )

        Spacer(Modifier.height(8.dp))

        // Grid of Wallpapers in 2 columns
        val chunkedWallpapers = remember(wallpapers) { wallpapers.chunked(2) }

        chunkedWallpapers.forEach { rowWallpapers ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rowWallpapers.forEach { wp ->
                    val isSelected = wp.id == currentWallpaperId
                    val thumbBitmap = remember(wp.id) { DesktopBackgroundManager.loadThumbnailBitmap(wp) }

                    LiquidGlassCard(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onSelectWallpaper(wp.id) },
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = if (isSelected) Color(0xFF1E293B).copy(alpha = 0.55f) else Color(0xFF0C1017).copy(alpha = 0.28f),
                        borderColor = if (isSelected) Color(0xFF38BDF8).copy(alpha = 0.70f) else Color.White.copy(alpha = 0.10f)
                    ) {
                        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(110.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .border(
                                        width = if (isSelected) 1.5.dp else 1.dp,
                                        color = if (isSelected) Color(0xFF38BDF8).copy(alpha = 0.85f) else Color.White.copy(alpha = 0.12f),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ) {
                                if (thumbBitmap != null) {
                                    Image(
                                        bitmap = thumbBitmap,
                                        contentDescription = wp.title,
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                } else {
                                    Box(
                                        modifier = Modifier.fillMaxSize().background(Color(0xFF141A24)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(Icons.Default.Wallpaper, contentDescription = null, tint = Color.White.copy(alpha = 0.3f), modifier = Modifier.size(28.dp))
                                    }
                                }

                                if (isSelected) {
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                            .padding(6.dp)
                                    ) {
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(12.dp),
                                            backgroundColor = Color(0xFF0369A1).copy(alpha = 0.75f),
                                            borderColor = Color(0xFF38BDF8)
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Icon(
                                                    Icons.Default.Check,
                                                    contentDescription = "Selected",
                                                    tint = Color.White,
                                                    modifier = Modifier.size(12.dp)
                                                )
                                                Spacer(Modifier.width(3.dp))
                                                Text(
                                                    text = "APPLIED",
                                                    fontSize = 9.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White
                                                )
                                            }
                                        }
                                    }
                                }

                                if (wp.isCustom) {
                                    Box(
                                        modifier = Modifier
                                            .align(Alignment.TopStart)
                                            .padding(6.dp)
                                    ) {
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(6.dp),
                                            backgroundColor = Color(0xFF7F1D1D).copy(alpha = 0.75f),
                                            borderColor = Color(0xFFEF4444).copy(alpha = 0.5f),
                                            modifier = Modifier.clickable { onDeleteWallpaper(wp.id) }
                                        ) {
                                            Icon(
                                                Icons.Default.DeleteOutline,
                                                contentDescription = "Delete custom wallpaper",
                                                tint = Color.White,
                                                modifier = Modifier.padding(4.dp).size(13.dp)
                                            )
                                        }
                                    }
                                }
                            }

                            Spacer(Modifier.height(8.dp))

                            Text(
                                text = wp.title,
                                fontSize = 12.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isSelected) Color(0xFFE0F2FE) else Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(Modifier.height(2.dp))

                            Text(
                                text = wp.subtitle,
                                fontSize = 10.5.sp,
                                color = Color.White.copy(alpha = 0.50f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                if (rowWallpapers.size < 2) {
                    Spacer(Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(10.dp))
        }

        // Add custom wallpaper prompt banner
        LiquidGlassCard(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    launchSettingsImageFilePicker(null) { chosenFile ->
                        onAddWallpaper(chosenFile)
                    }
                },
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xFF0F1522).copy(alpha = 0.25f),
            borderColor = Color(0xFF38BDF8).copy(alpha = 0.25f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LiquidGlassBox(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color(0xFF1E293B).copy(alpha = 0.4f),
                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.35f),
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Import Custom Wallpaper or Photo",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Text(
                        text = "Select any JPG, PNG, WEBP, or BMP file from your computer to use as your studio background",
                        fontSize = 11.sp,
                        color = Color.White.copy(alpha = 0.50f)
                    )
                }
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.40f),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
private fun RenderAppearanceStyleCard(
    enableAnimations: Boolean,
    dynamicAccentGlow: Boolean,
    onAnimationsChange: (Boolean) -> Unit,
    onDynamicGlowChange: (Boolean) -> Unit
) {
    SettingsCategoryCard(
        title = "Interface & Visual Polish",
        subtitle = "Window styling, fluid transitions, and ambient music reactive effects.",
        icon = Icons.Default.Palette
    ) {
        SettingRow(
            title = "Fluid UI Animations",
            description = "Enable smooth screen transitions, hover scale states, and carousel scrolling."
        ) {
            MonochromeSwitch(
                checked = enableAnimations,
                onCheckedChange = onAnimationsChange
            )
        }

        SettingDivider()

        SettingRow(
            title = "Ambient Album Scrim Tint",
            description = "Apply translucent acoustic gradient wash reflecting active song artwork."
        ) {
            MonochromeSwitch(
                checked = dynamicAccentGlow,
                onCheckedChange = onDynamicGlowChange
            )
        }
    }
}

@Composable
private fun RenderDownloadStorageCard(
    downloadDir: File,
    onDirChange: (File) -> Unit,
    onResetDefault: () -> Unit
) {
    SettingsCategoryCard(
        title = "Offline Downloads Location",
        subtitle = "Destination directory where offline tracks and cached audio files are stored.",
        icon = Icons.Default.Folder
    ) {
        LiquidGlassCard(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.FolderOpen, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text("Current Download Directory", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.45f))
                    Text(
                        downloadDir.absolutePath,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 12.5.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    launchSettingsFolderPicker(downloadDir) { onDirChange(it) }
                },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
            ) {
                Icon(Icons.Default.Folder, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(Modifier.width(6.dp))
                Text("Change Directory...", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = { openSettingsDirInExplorer(downloadDir) },
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.20f)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Icon(Icons.Default.FolderOpen, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(Modifier.width(6.dp))
                Text("Open in Explorer", fontSize = 12.sp)
            }

            TextButton(onClick = onResetDefault) {
                Text("Reset Default", fontSize = 12.sp, color = Color.White.copy(alpha = 0.55f))
            }
        }
    }
}

@Composable
private fun RenderCacheStorageCard(
    cacheSizeBytes: Long?,
    isCalculating: Boolean,
    cacheDirName: String,
    onRefresh: () -> Unit,
    onClearCache: () -> Unit
) {
    SettingsCategoryCard(
        title = "Temporary Cache & Storage",
        subtitle = "Streaming segments, HTTP response caches, and remote album art thumbnails.",
        icon = Icons.Default.Folder
    ) {
        SettingRow(
            title = "Temporary Cached Data",
            description = if (isCalculating) "Calculating disk usage..."
            else "${formatSettingsBytes(cacheSizeBytes ?: 0L)} stored in $cacheDirName"
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onRefresh) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh cache size", tint = Color.White.copy(alpha = 0.70f), modifier = Modifier.size(18.dp))
                }

                OutlinedButton(
                    onClick = onClearCache,
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.20f))
                ) {
                    Icon(Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(15.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Clear Cache", fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
private fun RenderLocalLibraryFoldersCard(
    downloadDir: File,
    customFolders: List<String>,
    scanTriggered: Boolean,
    onAddFolder: () -> Unit,
    onRemoveFolder: (String) -> Unit,
    onTriggerScan: () -> Unit
) {
    SettingsCategoryCard(
        title = "Local Music Folders",
        subtitle = "Audix scans these local directories on startup to populate your offline Library.",
        icon = Icons.Default.LibraryMusic
    ) {
        Text("Default Monitored Directories", fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))

        val systemMusicDir = remember { File(System.getProperty("user.home") ?: "", "Music") }
        LiquidGlassCard(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
        ) {
            Row(Modifier.padding(horizontal = 12.dp, vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Folder, contentDescription = null, tint = Color.White.copy(alpha = 0.70f), modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(10.dp))
                Column(Modifier.weight(1f)) {
                    Text(systemMusicDir.absolutePath, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text("System User Music Folder [Always Scanned]", fontSize = 10.5.sp, color = Color.White.copy(alpha = 0.45f))
                }
                LiquidGlassBox(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color(0x80222222),
                    borderColor = Color.White.copy(alpha = 0.20f)
                ) {
                    Text("SYSTEM", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
            }
        }

        LiquidGlassCard(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
        ) {
            Row(Modifier.padding(horizontal = 12.dp, vertical = 10.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Folder, contentDescription = null, tint = Color.White.copy(alpha = 0.70f), modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(10.dp))
                Column(Modifier.weight(1f)) {
                    Text(downloadDir.absolutePath, fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                    Text("Audix Downloads Directory [Always Scanned]", fontSize = 10.5.sp, color = Color.White.copy(alpha = 0.45f))
                }
                LiquidGlassBox(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color(0x80222222),
                    borderColor = Color.White.copy(alpha = 0.20f)
                ) {
                    Text("DOWNLOADS", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
            }
        }

        SettingDivider()

        Text("Custom Music Directories", fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 13.sp)
        Text("Add extra folders containing albums, FLACs, or audio downloads on any internal or external drive.", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.45f))
        Spacer(Modifier.height(8.dp))

        if (customFolders.isEmpty()) {
            LiquidGlassBox(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.White.copy(alpha = 0.03f),
                borderColor = Color.White.copy(alpha = 0.08f),
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(
                    "No custom music folders added yet. Click '+ Add Folder' below to add directories from external drives or custom collections.",
                    modifier = Modifier.padding(12.dp),
                    fontSize = 11.5.sp,
                    color = Color.White.copy(alpha = 0.45f)
                )
            }
        } else {
            customFolders.forEach { folderPath ->
                val folderFile = File(folderPath)
                val exists = folderFile.exists() && folderFile.isDirectory
                LiquidGlassCard(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
                ) {
                    Row(Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            if (exists) Icons.Default.Folder else Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color.White.copy(alpha = if (exists) 0.80f else 0.50f),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Column(Modifier.weight(1f)) {
                            Text(folderPath, fontSize = 12.sp, color = Color.White, maxLines = 1, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.SemiBold)
                            Text(if (exists) "Active & Scannable" else "Directory not found / Drive unmounted", fontSize = 10.sp, color = Color.White.copy(alpha = if (exists) 0.50f else 0.35f))
                        }
                        IconButton(onClick = { onRemoveFolder(folderPath) }) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove folder", tint = Color.White.copy(alpha = 0.60f), modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onAddFolder,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
            ) {
                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(Modifier.width(6.dp))
                Text("Add Folder...", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            OutlinedButton(
                onClick = onTriggerScan,
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.20f)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(Modifier.width(6.dp))
                Text(if (scanTriggered) "Scan Requested" else "Trigger Re-Scan", fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun RenderSystemIntegrationCard(
    minimizeToTray: Boolean,
    showNotifications: Boolean,
    onMinimizeToTrayChange: (Boolean) -> Unit,
    onShowNotificationsChange: (Boolean) -> Unit
) {
    SettingsCategoryCard(
        title = "Window & Background Playback",
        subtitle = "System tray, background execution, and close button behavior.",
        icon = Icons.Default.Computer
    ) {
        SettingRow(
            title = "Minimize to System Tray on Close",
            description = "When enabled, closing the Audix window keeps the application playing in the Windows taskbar tray instead of terminating."
        ) {
            MonochromeSwitch(
                checked = minimizeToTray,
                onCheckedChange = onMinimizeToTrayChange
            )
        }

        SettingDivider()

        SettingRow(
            title = "Desktop Song Change Notifications",
            description = "Display Windows banner notification with track title and artist whenever a new song begins playing."
        ) {
            MonochromeSwitch(
                checked = showNotifications,
                onCheckedChange = onShowNotificationsChange
            )
        }

        SettingDivider()

        SettingRow(
            title = "Global Multimedia Key Transport",
            description = "Hardware Play/Pause, Next Track, Prev Track, and Volume keys supported globally."
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color(0x801E1E1E),
                borderColor = Color.White.copy(alpha = 0.25f)
            ) {
                Text("ACTIVE", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
            }
        }
    }
}

@Composable
private fun RenderExtensionsSettingsCard(
    extensionsDir: File,
    checkForUpdates: Boolean,
    onCheckUpdatesChange: (Boolean) -> Unit
) {
    SettingsCategoryCard(
        title = "Extensions & Providers Directory",
        subtitle = "Audix loads external modular JAR plugins for music searching, streaming, and synchronized lyrics.",
        icon = Icons.Default.Extension
    ) {
        LiquidGlassCard(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Extension, contentDescription = null, tint = Color.White, modifier = Modifier.size(22.dp))
                Spacer(Modifier.width(12.dp))
                Column(Modifier.weight(1f)) {
                    Text("Installed Extensions Directory", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.45f))
                    Text(
                        extensionsDir.absolutePath,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 12.5.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { openSettingsDirInExplorer(extensionsDir) },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
        ) {
            Icon(Icons.Default.FolderOpen, contentDescription = null, modifier = Modifier.size(15.dp))
            Spacer(Modifier.width(6.dp))
            Text("Open Extensions Folder", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }

        SettingDivider()

        SettingRow(
            title = "Auto-Check for Extension Updates",
            description = "Periodically query verified repositories for newer extension versions and security patches."
        ) {
            MonochromeSwitch(
                checked = checkForUpdates,
                onCheckedChange = onCheckUpdatesChange
            )
        }

        SettingDivider()

        Text("Active Built-in Providers", fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("JioSaavn", "SoundCloud", "RadioBrowser", "LRCLIB Lyrics", "Local Audio Engine").forEach { ext ->
                LiquidGlassBox(
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = Color(0x801C1C1C),
                    borderColor = Color.White.copy(alpha = 0.16f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(ext, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun RenderAboutAndDiagnosticsCard(
    downloadDir: File,
    cacheDir: File,
    extensionsDir: File,
    audioQuality: String,
    bufferLatency: Int,
    normalizationEnabled: Boolean,
    skipSilence: Boolean,
    screensaverTimeout: Int,
    minimizeToTray: Boolean,
    customFoldersCount: Int,
    onCopyDiagnostics: () -> Unit,
    onRequestReset: () -> Unit
) {
    SettingsCategoryCard(
        title = "Audix Desktop Workstation",
        subtitle = "Next-generation multiplatform audio player for Windows.",
        icon = Icons.Default.Info
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Audix Native Edition", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 15.sp)
                Text("Audix v1.0.3-UNIFIED (Windows x64 Build)", fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 12.5.sp)
                Spacer(Modifier.height(3.dp))
                Text("Multiplatform Kotlin 2.2 • Jetpack Compose Desktop 1.8.2 • VLCJ / LibVLC 4.8.3", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.45f))
            }
            OutlinedButton(
                onClick = onCopyDiagnostics,
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.20f)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(Modifier.width(6.dp))
                Text("Copy Diagnostics", fontSize = 12.sp)
            }
        }

        SettingDivider()

        val totalMem = Runtime.getRuntime().totalMemory() / (1024 * 1024)
        val freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024)
        val maxMem = Runtime.getRuntime().maxMemory() / (1024 * 1024)
        val usedMem = totalMem - freeMem
        val heapFraction = (usedMem.toFloat() / totalMem.toFloat().coerceAtLeast(1f)).coerceIn(0f, 1f)

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Java Virtual Machine", fontSize = 12.sp, color = Color.White.copy(alpha = 0.50f))
                Text("${System.getProperty("java.version")} (${System.getProperty("java.vendor")})", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Host Operating System", fontSize = 12.sp, color = Color.White.copy(alpha = 0.50f))
                Text("${System.getProperty("os.name")} [${System.getProperty("os.arch")}]", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Heap Memory Consumption", fontSize = 12.sp, color = Color.White.copy(alpha = 0.50f))
                Text("${usedMem} MB used of ${totalMem} MB (Max ${maxMem} MB)", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(Color(0xFF222222))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(heapFraction)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color.White)
                )
            }
        }

        SettingDivider()

        SettingRow(
            title = "Reset All Preferences",
            description = "Restore all player, buffer, screensaver, and UI settings back to factory defaults. Offline music is not affected."
        ) {
            OutlinedButton(
                onClick = onRequestReset,
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f))
            ) {
                Icon(Icons.Default.RestartAlt, contentDescription = null, modifier = Modifier.size(15.dp))
                Spacer(Modifier.width(6.dp))
                Text("Reset to Defaults", fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun ErrorView(
    error: Throwable?,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.Close,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(44.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = error?.localizedMessage ?: "An error occurred",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Retry", fontWeight = FontWeight.Bold)
        }
    }
}
