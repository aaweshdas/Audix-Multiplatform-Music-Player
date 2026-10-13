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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.Playlist
import dev.brahmkshatriya.echo.common.models.QuickSearchItem
import dev.brahmkshatriya.echo.common.models.Shelf
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
import java.util.Locale
import javax.swing.JFileChooser

private fun StoredTrack.toTrack(): Track {
    return Track(
        id = id,
        title = title,
        artists = artists.map { Artist(id = it, name = it) },
        album = albumTitle?.let { Album(id = it, title = it) },
        cover = coverUrl?.let {
            ImageHolder.NetworkRequestImageHolder(
                request = dev.brahmkshatriya.echo.common.models.NetworkRequest(url = it),
                crop = false
            )
        },
        duration = durationMs,
        extras = extras
    )
}

private fun Track.toStoredTrack(): StoredTrack {
    val coverUrl = when (val c = cover ?: album?.cover) {
        is ImageHolder.NetworkRequestImageHolder -> c.request.url
        is ImageHolder.ResourceUriImageHolder -> c.uri
        else -> null
    }
    return StoredTrack(
        id = id,
        title = title,
        artists = artists.map { it.name },
        albumTitle = album?.title,
        coverUrl = coverUrl,
        durationMs = duration,
        extras = extras
    )
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
private val TextSecondary = Color(0xFFA0A0A0)
private val TextMuted = Color(0xFF6E6E6E)

private fun ImageHolder?.toCoverUrl(): String? = when (this) {
    is ImageHolder.NetworkRequestImageHolder -> request.url
    is ImageHolder.ResourceUriImageHolder -> uri
    else -> null
}

private fun EchoMediaItem.extractCoverUrl(): String? = when (this) {
    is Track -> (cover ?: album?.cover).toCoverUrl()
    else -> cover.toCoverUrl()
}

private fun Track.extractCoverUrl(): String? = (cover ?: album?.cover).toCoverUrl()

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
        val effective1 = if (isPlaying) height1 else 0.3f
        val effective2 = if (isPlaying) height2 else 0.6f
        val effective3 = if (isPlaying) height3 else 0.4f

        Box(
            Modifier
                .width(3.dp)
                .fillMaxHeight(effective1)
                .clip(RoundedCornerShape(1.5.dp))
                .background(color)
        )
        Box(
            Modifier
                .width(3.dp)
                .fillMaxHeight(effective2)
                .clip(RoundedCornerShape(1.5.dp))
                .background(color)
        )
        Box(
            Modifier
                .width(3.dp)
                .fillMaxHeight(effective3)
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
        backgroundColor = if (isHovered) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.65f),
        borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),
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
        backgroundColor = if (isHovered) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.65f),
        borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),
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
                        tint = Color(0xFF475569),
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
                    text = track.title,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFF8FAFC),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = track.artists.joinToString(", ") { it.name }.ifBlank { "Unknown Artist" },
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8),
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
                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                    borderColor = Color.White.copy(alpha = 0.08f)
                ) {
                    Text(
                        text = "320k",
                        color = Color(0xFF64748B),
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
                            tint = if (isHovered) Color(0xFFE2E8F0) else Color(0xFF64748B),
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
                            tint = if (isHovered) Color(0xFFE2E8F0) else Color(0xFF64748B),
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
    onPlayTrack: (Track) -> Unit = {},
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
                            backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                            borderColor = Color(0xFF38BDF8).copy(alpha = 0.35f)
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
                                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                                            tint = Color(0xFF94A3B8),
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Text(
                                            text = artist,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFFF1F5F9)
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
                                onPlay = { onPlayTrack(track) },
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
                                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.60f),
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
        backgroundColor = if (isHovered) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.65f),
        borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),
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
                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
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
            Text(
                text = track.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = if (isCurrentTrack) FontWeight.Bold else FontWeight.SemiBold
                ),
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
        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
        backgroundColor = Color(0xFF13172A).copy(alpha = 0.65f),
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
    var recentSearches by remember {
        mutableStateOf(listOf("The Weeknd", "Lofi Beats", "Coldplay", "Hans Zimmer", "Synthwave"))
    }

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

    fun executeSearch(searchTerm: String) {
        val trimmed = searchTerm.trim()
        if (trimmed.isNotBlank()) {
            if (extensionManager.current.value == null && musicExtensions.isNotEmpty()) {
                val defaultExt = musicExtensions.firstOrNull { it.isEnabled } ?: musicExtensions.firstOrNull()
                if (defaultExt != null) {
                    extensionManager.setupMusicExtension(defaultExt, true)
                }
            }
            queryInput = trimmed
            hasSearched = true
            if (!recentSearches.contains(trimmed)) {
                recentSearches = (listOf(trimmed) + recentSearches).take(10)
            }
            viewModel.updateQuery(trimmed)
            viewModel.search(trimmed)
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
                        OutlinedTextField(
                            value = queryInput,
                            onValueChange = {
                                queryInput = it
                                viewModel.updateQuery(it)
                                if (it.isBlank()) {
                                    hasSearched = false
                                }
                            },
                            placeholder = {
                                Text(
                                    "Search songs, artists, albums, or playlists...",
                                    color = TextMuted,
                                    fontSize = 13.5.sp
                                )
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = { executeSearch(queryInput) }),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color.White,
                                cursorColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent
                            ),
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
                if (musicExtensions.isNotEmpty()) {
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

                        musicExtensions.forEach { ext ->
                            val isSelected = currentExt?.metadata?.id == ext.metadata.id
                            LiquidGlassBox(
                                shape = RoundedCornerShape(8.dp),
                                backgroundColor = if (isSelected) Color.White else Color(0x30181818),
                                borderColor = if (isSelected) Color.White else Color.White.copy(alpha = 0.12f),
                                modifier = Modifier
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable {
                                        if (!isSelected) {
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
                                                .background(Color.Black)
                                        )
                                    }
                                    Text(
                                        text = ext.metadata.name,
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                        ),
                                        color = if (isSelected) Color.Black else TextSecondary
                                    )
                                }
                            }
                        }
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
                                            onMediaSelected(item.media)
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
        Box(modifier = Modifier.fillMaxSize()) {
            when {
                // IDLE STATE (Nothing searched yet or search cleared)
                !hasSearched || queryInput.isBlank() -> {
                    SearchDiscoveryHub(
                        recentSearches = recentSearches,
                        onSelectQuery = { executeSearch(it) },
                        onRemoveRecent = { term -> recentSearches = recentSearches.filter { it != term } },
                        onClearRecents = { recentSearches = emptyList() },
                        onPlayTrack = { playerViewModel.play(it) },
                        onAddToPlaylist = { trackForPlaylist = it },
                        onDownloadTrack = { downloadManager.downloadTrack(it) }
                    )
                }

                // LOADING STATE
                isLoading && shelves.isEmpty() -> {
                    SearchLoadingSkeleton()
                }

                // ERROR STATE
                error != null && shelves.isEmpty() -> {
                    SearchErrorBanner(
                        error = error,
                        onRetry = { viewModel.search(queryInput) },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                // ZERO RESULTS FOUND
                !isLoading && shelves.isEmpty() && error == null -> {
                    SearchZeroResultsView(
                        query = queryInput,
                        extensions = musicExtensions,
                        currentExt = currentExt,
                        onSwitchExtension = { ext ->
                            extensionManager.setupMusicExtension(ext, true)
                            viewModel.search(queryInput)
                        },
                        onClearSearch = {
                            queryInput = ""
                            hasSearched = false
                            viewModel.clearSearch()
                        }
                    )
                }

                // RESULTS LOADED
                shelves.isNotEmpty() -> {
                    val allTracks = remember(shelves) {
                        shelves.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
                    }
                    val topSongs = remember(shelves, allTracks) {
                        if (allTracks.isNotEmpty()) allTracks.take(4)
                        else {
                            shelves.filterIsInstance<Shelf.Lists.Items>()
                                .flatMap { it.list }
                                .filterIsInstance<Track>()
                                .take(4)
                        }
                    }
                    val topResultItem: EchoMediaItem? = remember(shelves, topSongs) {
                        val firstItem = shelves.firstOrNull()?.let { shelf ->
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
                                                    playerViewModel.play(topResultItem)
                                                } else {
                                                    onMediaSelected(topResultItem)
                                                }
                                            },
                                            onClick = { onMediaSelected(topResultItem) },
                                            modifier = Modifier.weight(0.40f)
                                        )

                                        TopSongsQuickList(
                                            tracks = topSongs,
                                            currentTrack = currentTrack,
                                            isPlaying = isPlaying,
                                            onPlayTrack = { playerViewModel.play(it) },
                                            onAddToPlaylist = { trackForPlaylist = it },
                                            onDownloadTrack = { downloadManager.downloadTrack(it) },
                                            modifier = Modifier.weight(0.60f)
                                        )
                                    }
                                }
                            }
                        }


                        // ALL CATEGORIZED RESULT SHELVES
                        items(shelves, key = { it.id }) { shelf ->
                            ShelfRow(
                                shelf = shelf,
                                onMediaClick = onMediaSelected,
                                onPlayTrack = { playerViewModel.play(it) },
                                onMoreClick = {}
                            )
                        }
                    }
                }
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
                            playerViewModel.addToQueue(domainTracks)
                            playerViewModel.play(domainTracks.first())
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
                            backgroundColor = if (isTrackActive) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.60f),
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
                                        text = track.artists.joinToString(", ") { a: Artist -> a.name }.ifBlank { "Unknown Artist" },
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
                                        else playerViewModel.play(track)
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
            OutlinedTextField(
                value = filterQuery,
                onValueChange = { filterQuery = it },
                placeholder = { Text("Filter items in ${selectedTab.title.lowercase()}...", fontSize = 12.5.sp, color = TextMuted) },
                singleLine = true,
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null, tint = TextMuted, modifier = Modifier.size(16.dp))
                },
                trailingIcon = {
                    if (filterQuery.isNotBlank()) {
                        IconButton(onClick = { filterQuery = "" }, modifier = Modifier.size(24.dp)) {
                            Icon(Icons.Default.Close, contentDescription = "Clear", tint = TextMuted, modifier = Modifier.size(14.dp))
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White.copy(alpha = 0.50f),
                    unfocusedBorderColor = BorderSubtle,
                    focusedContainerColor = SurfaceDark,
                    unfocusedContainerColor = SurfaceDark
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth().height(44.dp)
            )

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
                                    playerViewModel.addToQueue(filteredFavorites)
                                    playerViewModel.play(filteredFavorites.first())
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
                                    backgroundColor = if (isTrackActive) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.60f),
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
                                                text = track.artists.joinToString(", ") { it.name }.ifBlank { "Unknown Artist" },
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
                                                else playerViewModel.play(track)
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
                                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                                                    playerViewModel.addToQueue(domainTracks)
                                                    playerViewModel.play(domainTracks.first())
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
                                    backgroundColor = if (isTrackActive) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.60f),
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
                                                text = track.artists.joinToString(", ") { it.name }.ifBlank { "Unknown Artist" },
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
                                                else playerViewModel.play(track)
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
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
                borderColor = Color.White.copy(alpha = 0.12f),
                modifier = Modifier.weight(1.6f)
            ) {
                Column(Modifier.padding(14.dp)) {
                    Text("STORAGE LOCATION", color = TextMuted, fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        downloadDir.absolutePath,
                        color = Color(0xFFE2E8F0),
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
                        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                                        task.track.artists.joinToString(", ") { it.name }.ifBlank { "Unknown Artist" },
                                        fontSize = 11.5.sp,
                                        color = TextSecondary
                                    )
                                }

                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(4.dp),
                                        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
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
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search offline tracks by title or artist...", fontSize = 12.5.sp, color = TextMuted) },
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, tint = TextMuted, modifier = Modifier.size(16.dp))
            },
            trailingIcon = {
                if (searchQuery.isNotBlank()) {
                    IconButton(onClick = { searchQuery = "" }, modifier = Modifier.size(24.dp)) {
                        Icon(Icons.Default.Close, contentDescription = "Clear", tint = TextMuted, modifier = Modifier.size(14.dp))
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color.White.copy(alpha = 0.50f),
                unfocusedBorderColor = BorderSubtle,
                focusedContainerColor = SurfaceDark,
                unfocusedContainerColor = SurfaceDark
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().height(44.dp)
        )

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
                        backgroundColor = if (isTrackActive) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.60f),
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
                                    text = dl.track.artists.joinToString(", ") { a: Artist -> a.name }.ifBlank { "Unknown Artist" },
                                    fontSize = 11.5.sp,
                                    color = TextSecondary,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // Format tag
                            LiquidGlassBox(
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
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
        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                        backgroundColor = Color(0xFF141B30).copy(alpha = 0.80f),
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
                        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
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

    var activeSection by remember { mutableStateOf(SettingsSection.AUDIO) }
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
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            placeholder = {
                Text("Search settings (e.g. latency, cache, tray, quality, folders)...", fontSize = 13.sp, color = Color.White.copy(alpha = 0.40f))
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null, tint = Color.White.copy(alpha = 0.55f), modifier = Modifier.size(18.dp))
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(Icons.Default.Close, contentDescription = "Clear search", tint = Color.White.copy(alpha = 0.60f), modifier = Modifier.size(16.dp))
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF141414),
                unfocusedContainerColor = Color(0xFF101010),
                focusedBorderColor = Color.White.copy(alpha = 0.45f),
                unfocusedBorderColor = Color.White.copy(alpha = 0.10f),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White
            )
        )

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
                                            appendLine("Version: 1.0.0-nightly")
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
            val matchesStorage = q.contains("stor") || q.contains("down") || q.contains("folder") || q.contains("dir") || q.contains("path") || q.contains("cache") || q.contains("temp") || q.contains("clear") || q.contains("disk")
            val matchesLocal = q.contains("local") || q.contains("music") || q.contains("scan") || q.contains("offline") || q.contains("mp3") || q.contains("flac") || q.contains("dir") || q.contains("folder")
            val matchesSystem = q.contains("sys") || q.contains("tray") || q.contains("close") || q.contains("min") || q.contains("notif") || q.contains("key") || q.contains("media") || q.contains("window")
            val matchesExt = q.contains("ext") || q.contains("plug") || q.contains("source") || q.contains("repo") || q.contains("update") || q.contains("saavn") || q.contains("sound") || q.contains("radio")
            val matchesAbout = q.contains("about") || q.contains("ver") || q.contains("diag") || q.contains("info") || q.contains("jvm") || q.contains("java") || q.contains("mem") || q.contains("reset") || q.contains("factory")

            val hasAnyMatch = matchesAudio || matchesAppearance || matchesStorage || matchesLocal || matchesSystem || matchesExt || matchesAbout

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
                                    Thread {
                                        runCatching { platform.cacheDir.toFile().deleteRecursively() }
                                        refreshCacheSize()
                                    }.start()
                                    showCacheClearedDialog = true
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
                                        appendLine("Version: 1.0.0-nightly")
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
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
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
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
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
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
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
                Text("Version 1.0.0-nightly (Windows x64 Build)", fontWeight = FontWeight.SemiBold, color = Color.White.copy(alpha = 0.70f), fontSize = 12.5.sp)
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
