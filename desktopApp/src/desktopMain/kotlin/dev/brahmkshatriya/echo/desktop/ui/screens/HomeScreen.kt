package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.automirrored.filled.QueueMusic
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.models.*
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.desktop.download.DesktopDownloadManager
import dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist
import dev.brahmkshatriya.echo.desktop.library.toTrack
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRow
import dev.brahmkshatriya.echo.desktop.ui.screensaver.EchoScreensaver
import dev.brahmkshatriya.echo.desktop.viewmodel.HomeViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import org.koin.compose.koinInject
import java.time.LocalTime

private var cachedHomeLogoBitmap: ImageBitmap? = null

// ------------------------------------------------------------------------------------------------
// HELPER EXTENSIONS FOR ARTWORK EXTRACTION
// ------------------------------------------------------------------------------------------------
private fun ImageHolder?.toCoverUrl(): String? = when (this) {
    is ImageHolder.NetworkRequestImageHolder -> request.url
    is ImageHolder.ResourceUriImageHolder -> uri
    else -> null
}

private fun Track.extractCoverUrl(): String? = (cover ?: album?.cover).toCoverUrl()

/**
 * SENIOR UI/UX DESIGNER REDESIGN FOR AUDIX MUSIC PLAYER
 *
 * Design Pillars:
 * 1. Visual Hierarchy & Spatial Harmony:
 *    - Executive Frosted Glass Masthead with live lossless telemetry & high-contrast action hub.
 *    - Capsule Filter Rail with active glowing cyan states and mood routing.
 *    - Flagship Audiophile Billboard: Featuring the signature peeking 3D Vinyl Record Gatefold.
 *    - Heavy Rotation Matrix: Quick-play 6-pack grid for instantaneous listening resumption.
 *    - "Made For You" Algorithmic Shelf with personalized recommendations.
 *    - High-Fidelity Curated Soundscapes & Extension Shelves.
 * 2. Liquid-Glass Engineering:
 *    - Physical multi-stop specular highlights, deep dark refraction, and responsive hover glow.
 */
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinInject(),
    playerViewModel: PlayerViewModel = koinInject(),
    onMediaSelected: (EchoMediaItem) -> Unit = {},
    onLaunchScreensaver: () -> Unit = {}
) {
    val feed by viewModel.feed.collectAsState()
    val shelves by viewModel.shelves.collectAsState()
    val orderedShelves = remember(shelves) { normalizeAndOrderShelves(shelves) }
    val hasMadeForYouInShelves = remember(orderedShelves) {
        orderedShelves.any { it.title.contains("Made For You", ignoreCase = true) || it.id.contains("made_for_you", ignoreCase = true) }
    }
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()
    val currentExtension by viewModel.currentExtension.collectAsState()

    val extensionManager = koinInject<ExtensionManager>()
    val musicExtensions by extensionManager.music.collectAsState()

    // Desktop Library and Download Managers
    val libraryManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val downloadManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }

    var trackForPlaylist by remember { mutableStateOf<Track?>(null) }
    var selectedMoodFilter by remember { mutableStateOf("For You") }

    val userPlaylists by libraryManager.playlists.collectAsState()
    var selectedPlaylistForModal by remember { mutableStateOf<CuratedHomePlaylist?>(null) }
    var playlistToastMessage by remember { mutableStateOf<String?>(null) }
    var showCreatePlaylistModal by remember { mutableStateOf(false) }

    LaunchedEffect(playlistToastMessage) {
        if (playlistToastMessage != null) {
            kotlinx.coroutines.delay(3500)
            playlistToastMessage = null
        }
    }

    // Playlist Add Modal Dialog
    trackForPlaylist?.let { track ->
        AddToPlaylistDialog(
            track = track,
            onDismiss = { trackForPlaylist = null }
        )
    }

    // Dynamic Time-of-Day Context
    val currentHour = remember { runCatching { LocalTime.now().hour }.getOrDefault(12) }
    val (greetingText, greetingKicker) = remember(currentHour) {
        when (currentHour) {
            in 5..11 -> "Good morning" to "DAWN & MORNING ACOUSTICS"
            in 12..17 -> "Good afternoon" to "AFTERNOON FOCUS & ENERGY"
            in 18..22 -> "Good evening" to "EVENING LOUNGE & RELAXATION"
            else -> "Late night" to "MIDNIGHT SERENITY & AMBIENCE"
        }
    }

    // Dynamic User Taste Subline
    val topArtists = remember { libraryManager.getUserFavoriteArtists().take(3) }
    val dynamicTasteSubline = remember(topArtists) {
        if (topArtists.isNotEmpty()) {
            "Tuned to your affinity for ${topArtists.joinToString(", ")} • 320 kbps Studio Stream"
        } else {
            "Master Studio Streaming • Zero Distortion Hi-Fi Audio"
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ------------------------------------------------------------------------------------
            // 1. EXECUTIVE FROSTED GLASS MASTHEAD
            // ------------------------------------------------------------------------------------
            item {
                SeniorExecutiveMasthead(
                    greeting = greetingText,
                    kicker = greetingKicker,
                    tasteSubline = dynamicTasteSubline,
                    currentHour = currentHour,
                    onInstantMix = {
                        val candidates = listOf(
                            Track(
                                id = "mix_1",
                                title = "Blinding Lights",
                                artists = listOf(Artist("ar_w", "The Weeknd")),
                                album = Album("After Hours", "After Hours"),
                                cover = ImageHolder.NetworkRequestImageHolder(NetworkRequest("https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg"), false),
                                duration = 200000L
                            ),
                            Track(
                                id = "mix_2",
                                title = "Starboy",
                                artists = listOf(Artist("ar_w", "The Weeknd"), Artist("ar_dp", "Daft Punk")),
                                album = Album("Starboy", "Starboy"),
                                cover = ImageHolder.NetworkRequestImageHolder(NetworkRequest("https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg"), false),
                                duration = 230000L
                            ),
                            Track(
                                id = "mix_3",
                                title = "Midnight City",
                                artists = listOf(Artist("ar_m83", "M83")),
                                duration = 244000L
                            ),
                            Track(
                                id = "mix_4",
                                title = "Sunset Reverie",
                                artists = listOf(Artist("ar_al", "Acoustic Lounge")),
                                duration = 185000L
                            )
                        )
                        val pool = (libraryManager.favorites.value + libraryManager.getRecommendedTracks() + candidates).distinctBy { it.id }
                        val chosen = pool.shuffled().firstOrNull() ?: candidates.first()
                        playerViewModel.play(chosen)
                    },
                    onLaunchScreensaver = onLaunchScreensaver,
                    onRefresh = { viewModel.loadFeed() }
                )
            }

            // ------------------------------------------------------------------------------------
            // 2. SOURCE & MOOD FILTER CAPSULE RIBBON
            // ------------------------------------------------------------------------------------
            item {
                SeniorSourceAndMoodBar(
                    currentExtension = currentExtension,
                    musicExtensions = musicExtensions,
                    selectedMood = selectedMoodFilter,
                    onSelectExtension = { ext ->
                        if (ext == null) {
                            viewModel.loadFeed(null)
                        } else {
                            extensionManager.setupMusicExtension(ext, true)
                            viewModel.loadFeed(ext)
                        }
                    },
                    onSelectMood = { selectedMoodFilter = it }
                )
            }

            // ------------------------------------------------------------------------------------
            // 3. FLAGSHIP EDITORIAL HERO BILLBOARD (With 3D Peeking Vinyl Gatefold)
            // ------------------------------------------------------------------------------------
            item {
                SeniorEditorialBillboard(
                    playerViewModel = playerViewModel,
                    libraryManager = libraryManager,
                    downloadManager = downloadManager,
                    onAddToPlaylist = { trackForPlaylist = it },
                    onDownload = { downloadManager.downloadTrack(it) },
                    onLaunchScreensaver = onLaunchScreensaver
                )
            }

            // ------------------------------------------------------------------------------------
            // 4. FLAGSHIP FEATURED & CURATED PLAYLISTS (Continuous Multi-Track Playlists)
            // ------------------------------------------------------------------------------------
            item {
                SeniorFeaturedPlaylistsSection(
                    userPlaylists = userPlaylists,
                    onPlayPlaylist = { playlist ->
                        if (playlist.tracks.isNotEmpty()) {
                            playerViewModel.playWithQueue(playlist.tracks.first(), playlist.tracks)
                            playlistToastMessage = "▶ Playing Playlist: ${playlist.title} (${playlist.tracks.size} songs queued for continuous play)"
                        } else {
                            playlistToastMessage = "⚠ Playlist \"${playlist.title}\" is empty. Add songs to start continuous playback!"
                        }
                    },
                    onSelectPlaylist = { playlist ->
                        selectedPlaylistForModal = playlist
                    },
                    onCreatePlaylistClick = {
                        showCreatePlaylistModal = true
                    }
                )
            }

            // ------------------------------------------------------------------------------------
            // 5. EXTENSION TABS (If active source provides categories)
            // ------------------------------------------------------------------------------------
            val tabs = feed?.tabs
            if (!tabs.isNullOrEmpty()) {
                item {
                    ExtensionCategoryTabs(
                        tabs = tabs,
                        selectedTab = selectedTab,
                        onTabSelected = { viewModel.selectTab(it) }
                    )
                }
            }

            // ------------------------------------------------------------------------------------
            // 6. ALGORITHMIC "MADE FOR YOU" PERSONALIZED SHELF (Only if not provided by active feed)
            // ------------------------------------------------------------------------------------
            if (!hasMadeForYouInShelves) {
                item {
                    SeniorRecommendedShelf(
                        libraryManager = libraryManager,
                        onPlayTrack = { playerViewModel.play(it) },
                        onAddToPlaylist = { trackForPlaylist = it },
                        onDownloadTrack = { downloadManager.downloadTrack(it) }
                    )
                }
            }

            // ------------------------------------------------------------------------------------
            // 7. CURATED SOUNDSCAPE DISCOVERY OR LIVE EXTENSION FEEDS
            // ------------------------------------------------------------------------------------
            if (error != null && orderedShelves.isEmpty()) {
                item {
                    SeniorErrorGlassState(
                        error = error,
                        onRetry = { viewModel.loadFeed() }
                    )
                }
            } else if (orderedShelves.isNotEmpty()) {
                items(orderedShelves, key = { it.id }) { shelf ->
                    ShelfRow(
                        shelf = shelf,
                        onMediaClick = onMediaSelected,
                        onPlayTrack = { playerViewModel.play(it) },
                        onMoreClick = {}
                    )
                }
            } else {
                item {
                    SeniorCuratedSoundscapes(
                        onPlayTrack = { playerViewModel.play(it) },
                        onAddToPlaylist = { trackForPlaylist = it },
                        onDownloadTrack = { downloadManager.downloadTrack(it) }
                    )
                }
            }

            // Bottom docking spacer for smooth clearance above player dock
            item {
                Spacer(Modifier.height(52.dp))
            }
        }

        // ========================================================================================
        // 1. PLAYLIST DETAIL MODAL
        // ========================================================================================
        selectedPlaylistForModal?.let { playlist ->
            SeniorPlaylistDetailModal(
                playlist = playlist,
                onDismiss = { selectedPlaylistForModal = null },
                onPlayAll = {
                    if (playlist.tracks.isNotEmpty()) {
                        playerViewModel.playWithQueue(playlist.tracks.first(), playlist.tracks)
                        playlistToastMessage = "▶ Playing Playlist: ${playlist.title} (${playlist.tracks.size} songs queued)"
                        selectedPlaylistForModal = null
                    }
                },
                onShufflePlay = {
                    if (playlist.tracks.isNotEmpty()) {
                        val shuffled = playlist.tracks.shuffled()
                        playerViewModel.playWithQueue(shuffled.first(), shuffled)
                        playlistToastMessage = "🔀 Shuffled Playlist: ${playlist.title} (${playlist.tracks.size} songs queued)"
                        selectedPlaylistForModal = null
                    }
                },
                onPlayTrack = { track ->
                    playerViewModel.playWithQueue(track, playlist.tracks)
                    playlistToastMessage = "▶ Playing: ${track.title} (${playlist.tracks.size} songs in continuous queue)"
                },
                onAddToPlaylist = { track ->
                    trackForPlaylist = track
                },
                onDownloadTrack = { track ->
                    downloadManager.downloadTrack(track)
                    playlistToastMessage = "⬇ Downloading: ${track.title}"
                }
            )
        }

        // ========================================================================================
        // 2. CREATE NEW PLAYLIST MODAL
        // ========================================================================================
        if (showCreatePlaylistModal) {
            SeniorCreatePlaylistModal(
                onDismiss = { showCreatePlaylistModal = false },
                onCreate = { title, desc ->
                    if (title.isNotBlank()) {
                        libraryManager.createPlaylist(title.trim(), desc.trim())
                        playlistToastMessage = "✔ Created Playlist: ${title.trim()}"
                    }
                    showCreatePlaylistModal = false
                }
            )
        }

        // ========================================================================================
        // 3. TRANSIENT PLAYBACK NOTIFICATION TOAST BANNER
        // ========================================================================================
        AnimatedVisibility(
            visible = playlistToastMessage != null,
            enter = slideInVertically(initialOffsetY = { -it }) + fadeIn(),
            exit = slideOutVertically(targetOffsetY = { -it }) + fadeOut(),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp)
                .zIndex(100f)
        ) {
            playlistToastMessage?.let { msg ->
                LiquidGlassBox(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = Color(0xF00A1326),
                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.6f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 22.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF38BDF8).copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.QueueMusic,
                                contentDescription = null,
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        Text(
                            text = msg,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}

// ================================================================================================
// SENIOR CURATED & USER PLAYLIST ARCHITECTURE
// ================================================================================================
data class CuratedHomePlaylist(
    val id: String,
    val title: String,
    val curator: String,
    val description: String,
    val coverUrl: String,
    val badge: String,
    val category: String,
    val accentColor: Color,
    val tracks: List<Track>
)

private fun makePlaylistTrack(
    id: String,
    title: String,
    artist: String,
    albumTitle: String,
    coverUrl: String,
    durationMs: Long
): Track {
    val streamable = Streamable.server(
        id = id,
        quality = 320,
        title = "320 kbps (Master HQ)",
        extras = mapOf(
            "track_title" to title,
            "artist_name" to artist,
            "extension_id" to "youtube_music"
        )
    )
    return Track(
        id = id,
        title = title,
        artists = listOf(Artist(id = artist, name = artist)),
        album = Album(id = albumTitle, title = albumTitle),
        cover = ImageHolder.NetworkRequestImageHolder(NetworkRequest(coverUrl), false),
        duration = durationMs,
        streamables = listOf(streamable),
        extras = mapOf(
            "track_title" to title,
            "artist_name" to artist
        )
    )
}

private fun getCuratedHomePlaylists(): List<CuratedHomePlaylist> {
    return listOf(
        CuratedHomePlaylist(
            id = "curated_top_hits",
            title = "Today's Top Global Hits",
            curator = "Audix Editorial",
            description = "The hottest chart-toppers dominating streaming worldwide right now.",
            coverUrl = "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg",
            badge = "CHART TOPPER",
            category = "Featured",
            accentColor = Color(0xFF38BDF8),
            tracks = listOf(
                makePlaylistTrack("top_1", "Starboy", "The Weeknd ft. Daft Punk", "Starboy", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 230000L),
                makePlaylistTrack("top_2", "Blinding Lights", "The Weeknd", "After Hours", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 200000L),
                makePlaylistTrack("top_3", "Cruel Summer", "Taylor Swift", "Lover", "https://c.saavncdn.com/228/Lover-English-2019-20250731010741-500x500.jpg", 178000L),
                makePlaylistTrack("top_4", "Die With A Smile", "Lady Gaga & Bruno Mars", "Die With A Smile", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 251000L),
                makePlaylistTrack("top_5", "Espresso", "Sabrina Carpenter", "Short n' Sweet", "https://c.saavncdn.com/228/Lover-English-2019-20250731010741-500x500.jpg", 175000L),
                makePlaylistTrack("top_6", "Birds of a Feather", "Billie Eilish", "HIT ME HARD AND SOFT", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 192000L),
                makePlaylistTrack("top_7", "As It Was", "Harry Styles", "Harry's House", "https://c.saavncdn.com/228/Lover-English-2019-20250731010741-500x500.jpg", 167000L),
                makePlaylistTrack("top_8", "Levitating", "Dua Lipa", "Future Nostalgia", "https://c.saavncdn.com/228/Lover-English-2019-20250731010741-500x500.jpg", 203000L),
                makePlaylistTrack("top_9", "Houdini", "Dua Lipa", "Radical Optimism", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 185000L),
                makePlaylistTrack("top_10", "Beautiful Things", "Benson Boone", "Fireworks & Rollerblades", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 180000L)
            )
        ),
        CuratedHomePlaylist(
            id = "curated_bollywood_hits",
            title = "Bollywood Romance & Hits",
            curator = "Audix Desi Beats",
            description = "Timeless romantic ballads, soulful melodies, and modern Bollywood anthems.",
            coverUrl = "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg",
            badge = "BOLLYWOOD HITS",
            category = "Bollywood",
            accentColor = Color(0xFFEC4899),
            tracks = listOf(
                makePlaylistTrack("bol_1", "Kesariya", "Arijit Singh & Pritam", "Brahmastra", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 268000L),
                makePlaylistTrack("bol_2", "Raataan Lambiyan", "Jubin Nautiyal & Asees Kaur", "Shershaah", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 230000L),
                makePlaylistTrack("bol_3", "Tum Hi Ho", "Arijit Singh & Mithoon", "Aashiqui 2", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 262000L),
                makePlaylistTrack("bol_4", "Apna Bana Le", "Arijit Singh & Sachin-Jigar", "Bhediya", "https://c.saavncdn.com/022/Heeriye-feat-Arijit-Singh-Hindi-2023-20230928050405-500x500.jpg", 261000L),
                makePlaylistTrack("bol_5", "Chaleya", "Arijit Singh, Shilpa Rao & Anirudh", "Jawan", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 200000L),
                makePlaylistTrack("bol_6", "Heeriye", "Jasleen Royal & Arijit Singh", "Heeriye", "https://c.saavncdn.com/022/Heeriye-feat-Arijit-Singh-Hindi-2023-20230928050405-500x500.jpg", 195000L),
                makePlaylistTrack("bol_7", "Pehle Bhi Main", "Vishal Mishra & Raj Shekhar", "Animal", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 250000L),
                makePlaylistTrack("bol_8", "Tere Vaaste", "Varun Jain & Sachin-Jigar", "Zara Hatke Zara Bachke", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 189000L),
                makePlaylistTrack("bol_9", "Shayad", "Arijit Singh & Pritam", "Love Aaj Kal", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 247000L),
                makePlaylistTrack("bol_10", "Tujh Mein Rab Dikhta Hai", "Roop Kumar Rathod", "Rab Ne Bana Di Jodi", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 281000L)
            )
        ),
        CuratedHomePlaylist(
            id = "curated_chill_lofi",
            title = "Chill Lofi Study & Focus",
            curator = "Lofi Beats Lab",
            description = "Warm analog textures, soft ambient keys, and gentle downtempo beats to stay focused.",
            coverUrl = "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg",
            badge = "STUDY & FOCUS",
            category = "Chill & Focus",
            accentColor = Color(0xFFA855F7),
            tracks = listOf(
                makePlaylistTrack("lofi_1", "Midnight City", "M83", "Hurry Up, We're Dreaming", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 244000L),
                makePlaylistTrack("lofi_2", "Sunset Reverie", "Acoustic Lounge", "Sundown Sessions", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 185000L),
                makePlaylistTrack("lofi_3", "Rainy Cafe Piano", "Lofi Sleep Club", "Rainy Afternoon", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 165000L),
                makePlaylistTrack("lofi_4", "Golden Hour Lofi", "Chillhop Beats", "Golden Hour", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 190000L),
                makePlaylistTrack("lofi_5", "Tokyo Rain Study", "Nujabes Vibe", "Tokyo Rain", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 210000L),
                makePlaylistTrack("lofi_6", "Late Night Coding", "Synthwave Chill", "Midnight Terminal", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 225000L),
                makePlaylistTrack("lofi_7", "Autumn Leaves", "Jazz Hop Cafe", "Coffee & Rain", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 175000L),
                makePlaylistTrack("lofi_8", "Warm Breeze", "Ambient Lounge", "Quiet Horizons", "https://c.saavncdn.com/435/Before-the-Dawn-Heals-Us-French-2005-20231007191910-500x500.jpg", 195000L)
            )
        ),
        CuratedHomePlaylist(
            id = "curated_edm_surge",
            title = "EDM & Workout Power Surge",
            curator = "Audix Rave",
            description = "High-octane club anthems and workout adrenaline boosters for non-stop energy.",
            coverUrl = "https://c.saavncdn.com/562/Different-World-English-2018-20181130144209-500x500.jpg",
            badge = "HIGH ENERGY",
            category = "High Energy",
            accentColor = Color(0xFF10B981),
            tracks = listOf(
                makePlaylistTrack("edm_1", "Faded", "Alan Walker", "Different World", "https://c.saavncdn.com/562/Different-World-English-2018-20181130144209-500x500.jpg", 212000L),
                makePlaylistTrack("edm_2", "The Spectre", "Alan Walker", "Different World", "https://c.saavncdn.com/562/Different-World-English-2018-20181130144209-500x500.jpg", 193000L),
                makePlaylistTrack("edm_3", "Wake Me Up", "Avicii", "True", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 247000L),
                makePlaylistTrack("edm_4", "Titanium", "David Guetta ft. Sia", "Nothing But The Beat", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 245000L),
                makePlaylistTrack("edm_5", "Don't You Worry Child", "Swedish House Mafia", "Until Now", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 212000L),
                makePlaylistTrack("edm_6", "Closer", "The Chainsmokers ft. Halsey", "Collage", "https://c.saavncdn.com/228/Lover-English-2019-20250731010741-500x500.jpg", 244000L),
                makePlaylistTrack("edm_7", "Animals", "Martin Garrix", "Gold Skies", "https://c.saavncdn.com/562/Different-World-English-2018-20181130144209-500x500.jpg", 176000L),
                makePlaylistTrack("edm_8", "Clarity", "Zedd ft. Foxes", "Clarity", "https://c.saavncdn.com/562/Different-World-English-2018-20181130144209-500x500.jpg", 271000L)
            )
        ),
        CuratedHomePlaylist(
            id = "curated_rock_legends",
            title = "Rock & Classic Legends",
            curator = "Rock Hall of Fame",
            description = "Electrifying guitar riffs, powerhouse vocals, and stadium anthems that shaped generations.",
            coverUrl = "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg",
            badge = "ROCK LEGENDS",
            category = "Rock",
            accentColor = Color(0xFFF59E0B),
            tracks = listOf(
                makePlaylistTrack("rock_1", "Believer", "Imagine Dragons", "Evolve", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 204000L),
                makePlaylistTrack("rock_2", "Radioactive", "Imagine Dragons", "Night Visions", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 186000L),
                makePlaylistTrack("rock_3", "In The End", "Linkin Park", "Hybrid Theory", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 216000L),
                makePlaylistTrack("rock_4", "Numb", "Linkin Park", "Meteora", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 185000L),
                makePlaylistTrack("rock_5", "Bohemian Rhapsody", "Queen", "A Night at the Opera", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 354000L),
                makePlaylistTrack("rock_6", "Sweet Child O' Mine", "Guns N' Roses", "Appetite for Destruction", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 355000L),
                makePlaylistTrack("rock_7", "Smells Like Teen Spirit", "Nirvana", "Nevermind", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 301000L),
                makePlaylistTrack("rock_8", "Hotel California", "Eagles", "Hotel California", "https://c.saavncdn.com/248/Evolve-English-2018-20260605220036-500x500.jpg", 390000L)
            )
        ),
        CuratedHomePlaylist(
            id = "curated_hiphop_urban",
            title = "Hip-Hop & Urban Heavy Rotation",
            curator = "808 & Rhymes",
            description = "Hard-hitting 808s, clever flows, and the most dominant voices in modern rap.",
            coverUrl = "https://c.saavncdn.com/974/Not-Like-Us-English-2024-20240505084246-500x500.jpg",
            badge = "URBAN ESSENTIALS",
            category = "Hip-Hop",
            accentColor = Color(0xFFEF4444),
            tracks = listOf(
                makePlaylistTrack("rap_1", "Not Like Us", "Kendrick Lamar", "Not Like Us", "https://c.saavncdn.com/974/Not-Like-Us-English-2024-20240505084246-500x500.jpg", 274000L),
                makePlaylistTrack("rap_2", "HUMBLE.", "Kendrick Lamar", "DAMN.", "https://c.saavncdn.com/974/Not-Like-Us-English-2024-20240505084246-500x500.jpg", 177000L),
                makePlaylistTrack("rap_3", "God's Plan", "Drake", "Scorpion", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 198000L),
                makePlaylistTrack("rap_4", "Sicko Mode", "Travis Scott", "ASTROWORLD", "https://c.saavncdn.com/974/Not-Like-Us-English-2024-20240505084246-500x500.jpg", 312000L),
                makePlaylistTrack("rap_5", "Rockstar", "Post Malone ft. 21 Savage", "beerbongs & bentleys", "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg", 218000L),
                makePlaylistTrack("rap_6", "Goosebumps", "Travis Scott", "Birds in the Trap", "https://c.saavncdn.com/974/Not-Like-Us-English-2024-20240505084246-500x500.jpg", 243000L),
                makePlaylistTrack("rap_7", "Praise The Lord", "A\$AP Rocky ft. Skepta", "TESTING", "https://c.saavncdn.com/974/Not-Like-Us-English-2024-20240505084246-500x500.jpg", 205000L),
                makePlaylistTrack("rap_8", "A Bar Song (Tipsy)", "Shaboozey", "Where I've Been", "https://c.saavncdn.com/228/Lover-English-2019-20250731010741-500x500.jpg", 171000L)
            )
        )
    )
}

private fun getAllHomePlaylists(userPlaylists: List<UserPlaylist>): List<CuratedHomePlaylist> {
    val curated = getCuratedHomePlaylists()
    val mappedUserPlaylists = userPlaylists.map { up ->
        val tracks = up.tracks.map { it.toTrack() }
        val coverUrl = up.tracks.firstNotNullOfOrNull { it.coverUrl } ?: "https://c.saavncdn.com/396/The-Highlights-English-2021-20240207045714-500x500.jpg"
        CuratedHomePlaylist(
            id = "user_${up.id}",
            title = up.title,
            curator = "Your Library",
            description = up.description.ifBlank { "Personalized collection with ${tracks.size} tracks." },
            coverUrl = coverUrl,
            badge = "MY PLAYLIST",
            category = "My Playlists",
            accentColor = Color(0xFF8B5CF6),
            tracks = tracks
        )
    }
    return curated + mappedUserPlaylists
}

@Composable
private fun SeniorFeaturedPlaylistsSection(
    userPlaylists: List<UserPlaylist>,
    onPlayPlaylist: (CuratedHomePlaylist) -> Unit,
    onSelectPlaylist: (CuratedHomePlaylist) -> Unit,
    onCreatePlaylistClick: () -> Unit
) {
    val allPlaylists = remember(userPlaylists) { getAllHomePlaylists(userPlaylists) }
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = remember(userPlaylists) {
        listOf("All", "Featured", "Bollywood", "Chill & Focus", "High Energy", "Rock", "Hip-Hop", "My Playlists")
    }

    val filteredPlaylists = remember(selectedCategory, allPlaylists) {
        if (selectedCategory == "All") {
            allPlaylists
        } else {
            allPlaylists.filter { it.category.equals(selectedCategory, ignoreCase = true) }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // ----------------------------------------------------------------------------------------
        // SECTION HEADER & CONTROLS
        // ----------------------------------------------------------------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF38BDF8).copy(alpha = 0.15f))
                            .border(1.dp, Color(0xFF38BDF8).copy(alpha = 0.40f), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "CONTINUOUS PLAY • MULTI-TRACK QUEUE",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF38BDF8),
                            letterSpacing = 0.5.sp
                        )
                    }
                }
                Text(
                    text = "Featured & Curated Playlists",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = (-0.5).sp
                    ),
                    color = Color.White
                )
                Text(
                    text = "Seamless continuous listening — click Play to load and play all tracks in sequence",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF94A3B8)
                )
            }

            // Create Playlist Button
            LiquidGlassBox(
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color(0xFF1E293B).copy(alpha = 0.6f),
                borderColor = Color.White.copy(alpha = 0.15f),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onCreatePlaylistClick() }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "New Playlist",
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "New Playlist",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }

        // ----------------------------------------------------------------------------------------
        // CATEGORY FILTER RAIL
        // ----------------------------------------------------------------------------------------
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ) {
            items(categories) { cat ->
                val isSelected = cat == selectedCategory
                val count = when (cat) {
                    "All" -> allPlaylists.size
                    "My Playlists" -> userPlaylists.size
                    else -> allPlaylists.count { it.category.equals(cat, ignoreCase = true) }
                }

                SeniorFilterPill(
                    title = "$cat ($count)",
                    isSelected = isSelected,
                    onClick = { selectedCategory = cat }
                )
            }
        }

        // ----------------------------------------------------------------------------------------
        // PLAYLIST CARDS HORIZONTAL SHELF
        // ----------------------------------------------------------------------------------------
        if (filteredPlaylists.isEmpty() && selectedCategory == "My Playlists") {
            // Empty state for My Playlists
            LiquidGlassBox(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                backgroundColor = Color(0xFF0F172A).copy(alpha = 0.60f),
                borderColor = Color.White.copy(alpha = 0.10f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF38BDF8).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.PlaylistAdd,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                    Text(
                        text = "No Custom Playlists Created Yet",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Create your own customized collection of songs or add tracks from any album.",
                        fontSize = 13.sp,
                        color = Color(0xFF94A3B8),
                        textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = onCreatePlaylistClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38BDF8)),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = Color.Black, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Create Your First Playlist", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }
        } else {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                contentPadding = PaddingValues(horizontal = 2.dp, vertical = 6.dp)
            ) {
                items(filteredPlaylists, key = { it.id }) { playlist ->
                    SeniorPlaylistCard(
                        playlist = playlist,
                        onPlay = { onPlayPlaylist(playlist) },
                        onClick = { onSelectPlaylist(playlist) }
                    )
                }
            }
        }
    }
}

@Composable
private fun SeniorPlaylistCard(
    playlist: CuratedHomePlaylist,
    onPlay: () -> Unit,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        modifier = Modifier
            .width(228.dp)
            .pointerHoverIcon(PointerIcon.Hand),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = if (isHovered) Color(0xFF131D33).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.70f),
        borderColor = if (isHovered) playlist.accentColor.copy(alpha = 0.60f) else Color.White.copy(alpha = 0.12f),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Artwork container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(204.dp)
                    .clip(RoundedCornerShape(14.dp))
            ) {
                AsyncImage(
                    model = playlist.coverUrl,
                    contentDescription = playlist.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Dark gradient scrim
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.35f),
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.85f)
                                )
                            )
                        )
                )

                // Top badge tag
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.Black.copy(alpha = 0.65f))
                        .border(1.dp, playlist.accentColor.copy(alpha = 0.60f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = playlist.badge,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = playlist.accentColor,
                        letterSpacing = 0.5.sp
                    )
                }

                // Bottom-left track count pill
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.Black.copy(alpha = 0.70f))
                        .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.QueueMusic,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = "${playlist.tracks.size} TRACKS",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                // Bottom-right glowing play button
                val playButtonScale by animateFloatAsState(
                    targetValue = if (isHovered) 1.08f else 1.0f,
                    animationSpec = spring(stiffness = Spring.StiffnessMedium)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(10.dp)
                        .scale(playButtonScale)
                        .size(44.dp)
                        .shadow(8.dp, CircleShape, spotColor = playlist.accentColor)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(playlist.accentColor, playlist.accentColor.copy(alpha = 0.75f))
                            )
                        )
                        .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                            onPlay()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Playlist",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            // Playlist Title
            Text(
                text = playlist.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(3.dp))

            // Curator
            Text(
                text = playlist.curator,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = playlist.accentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(4.dp))

            // Description
            Text(
                text = playlist.description,
                fontSize = 11.sp,
                color = Color(0xFF94A3B8),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
private fun SeniorPlaylistDetailModal(
    playlist: CuratedHomePlaylist,
    onDismiss: () -> Unit,
    onPlayAll: () -> Unit,
    onShufflePlay: () -> Unit,
    onPlayTrack: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    val totalSeconds = remember(playlist.tracks) {
        playlist.tracks.sumOf { it.duration ?: 0L } / 1000
    }
    val totalMinutes = totalSeconds / 60
    val totalSecRemainder = totalSeconds % 60

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.75f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                onDismiss()
            }
            .zIndex(90f),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(760.dp)
                .heightIn(max = 680.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                    // Prevent dismissal when clicking inside modal
                }
        ) {
            LiquidGlassBox(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Color(0xF20B1120),
                borderColor = playlist.accentColor.copy(alpha = 0.45f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // ----------------------------------------------------------------------------
                    // MODAL HERO HEADER
                    // ----------------------------------------------------------------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        // Large Artwork
                        Box(
                            modifier = Modifier
                                .size(136.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(16.dp))
                                .shadow(12.dp, RoundedCornerShape(16.dp), spotColor = playlist.accentColor)
                        ) {
                            AsyncImage(
                                model = playlist.coverUrl,
                                contentDescription = playlist.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        // Playlist Meta & Controls
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(playlist.accentColor.copy(alpha = 0.18f))
                                        .border(1.dp, playlist.accentColor.copy(alpha = 0.50f), RoundedCornerShape(6.dp))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "${playlist.badge} • ${playlist.category.uppercase()}",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = playlist.accentColor
                                    )
                                }

                                IconButton(
                                    onClick = onDismiss,
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close",
                                        tint = Color.White.copy(alpha = 0.7f),
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }

                            Text(
                                text = playlist.title,
                                style = MaterialTheme.typography.headlineSmall.copy(
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = (-0.5).sp
                                ),
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = "Curated by ${playlist.curator} • ${playlist.tracks.size} tracks • ${totalMinutes}m ${totalSecRemainder}s • Studio Quality",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF94A3B8)
                            )

                            Text(
                                text = playlist.description,
                                fontSize = 12.sp,
                                color = Color(0xFFCBD5E1),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                lineHeight = 16.sp
                            )

                            Spacer(Modifier.height(4.dp))

                            // Play All & Shuffle Buttons
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Button(
                                    onClick = onPlayAll,
                                    colors = ButtonDefaults.buttonColors(containerColor = playlist.accentColor),
                                    shape = RoundedCornerShape(10.dp),
                                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    Text(
                                        text = "Play All (${playlist.tracks.size} Songs)",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 13.sp,
                                        color = Color.Black
                                    )
                                }

                                OutlinedButton(
                                    onClick = onShufflePlay,
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Shuffle,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    Text(
                                        text = "Shuffle",
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 13.sp
                                    )
                                }
                            }
                        }
                    }

                    // Divider
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(
                                Brush.horizontalGradient(
                                    listOf(
                                        Color.Transparent,
                                        playlist.accentColor.copy(alpha = 0.40f),
                                        Color.Transparent
                                    )
                                )
                            )
                    )

                    // Tracklist Column Header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("#", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B), modifier = Modifier.width(32.dp))
                        Text("TITLE & ARTIST", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B), modifier = Modifier.weight(1f))
                        Text("ALBUM", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B), modifier = Modifier.weight(0.7f))
                        Text("TIME", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B), modifier = Modifier.width(60.dp), textAlign = TextAlign.End)
                        Spacer(Modifier.width(76.dp))
                    }

                    // ----------------------------------------------------------------------------
                    // SCROLLABLE TRACKLIST
                    // ----------------------------------------------------------------------------
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        itemsIndexed(playlist.tracks, key = { idx, t -> "${t.id}_$idx" }) { index, track ->
                            SeniorPlaylistTrackRow(
                                index = index + 1,
                                track = track,
                                accentColor = playlist.accentColor,
                                onPlay = { onPlayTrack(track) },
                                onAddToPlaylist = { onAddToPlaylist(track) },
                                onDownload = { onDownloadTrack(track) }
                            )
                        }
                    }

                    // Footer notification tip
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF1E293B).copy(alpha = 0.5f))
                            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(10.dp))
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.QueueMusic,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "Playing any song from this playlist queues all ${playlist.tracks.size} tracks seamlessly for non-stop continuous playback.",
                            fontSize = 11.sp,
                            color = Color(0xFF94A3B8)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SeniorPlaylistTrackRow(
    index: Int,
    track: Track,
    accentColor: Color,
    onPlay: () -> Unit,
    onAddToPlaylist: () -> Unit,
    onDownload: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val coverUrl = remember(track) { track.extractCoverUrl() }
    val durationText = remember(track.duration) { formatTrackDuration(track.duration) }
    val artistName = remember(track.artists) { track.artists.joinToString(", ") { it.name } }
    val albumTitle = remember(track.album) { track.album?.title ?: "Single" }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (isHovered) Color(0xFF1E293B).copy(alpha = 0.65f) else Color.White.copy(alpha = 0.02f)
            )
            .border(
                1.dp,
                if (isHovered) accentColor.copy(alpha = 0.40f) else Color.Transparent,
                RoundedCornerShape(10.dp)
            )
            .clickable(interactionSource = interactionSource, indication = null) {
                onPlay()
            }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Track number or mini play icon on hover
        Box(
            modifier = Modifier.width(32.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (isHovered) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Play",
                    tint = accentColor,
                    modifier = Modifier.size(16.dp)
                )
            } else {
                Text(
                    text = index.toString().padStart(2, '0'),
                    fontSize = 12.sp,
                    color = Color(0xFF64748B),
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Mini cover
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFF1E293B))
        ) {
            if (!coverUrl.isNullOrBlank()) {
                AsyncImage(
                    model = coverUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Icon(
                    imageVector = Icons.Default.MusicNote,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.4f),
                    modifier = Modifier.size(18.dp).align(Alignment.Center)
                )
            }
        }

        Spacer(Modifier.width(12.dp))

        // Title and Artist
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = track.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isHovered) Color.White else Color(0xFFE2E8F0),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = artistName,
                fontSize = 11.sp,
                color = Color(0xFF94A3B8),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Album
        Text(
            text = albumTitle,
            fontSize = 12.sp,
            color = Color(0xFF64748B),
            modifier = Modifier.weight(0.7f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Duration
        Text(
            text = durationText,
            fontSize = 12.sp,
            color = Color(0xFF94A3B8),
            modifier = Modifier.width(60.dp),
            textAlign = TextAlign.End
        )

        Spacer(Modifier.width(10.dp))

        // Action icons (Add to playlist, Download)
        Row(
            modifier = Modifier.width(66.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onAddToPlaylist,
                modifier = Modifier.size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.PlaylistAdd,
                    contentDescription = "Add to playlist",
                    tint = if (isHovered) Color.White else Color(0xFF94A3B8),
                    modifier = Modifier.size(16.dp)
                )
            }

            IconButton(
                onClick = onDownload,
                modifier = Modifier.size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Download,
                    contentDescription = "Download track",
                    tint = if (isHovered) Color.White else Color(0xFF94A3B8),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
private fun SeniorCreatePlaylistModal(
    onDismiss: () -> Unit,
    onCreate: (title: String, description: String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.70f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                onDismiss()
            }
            .zIndex(98f),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(480.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {}
        ) {
            LiquidGlassBox(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                backgroundColor = Color(0xF50D1424),
                borderColor = Color(0xFF38BDF8).copy(alpha = 0.50f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Create New Playlist",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        IconButton(onClick = onDismiss, modifier = Modifier.size(28.dp)) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White.copy(alpha = 0.7f), modifier = Modifier.size(18.dp))
                        }
                    }

                    Text(
                        text = "Build a custom multi-track playlist to queue and listen to songs sequentially.",
                        fontSize = 12.sp,
                        color = Color(0xFF94A3B8)
                    )

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Playlist Name") },
                        placeholder = { Text("e.g. Late Night Vibes") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF38BDF8),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.20f),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )

                    OutlinedTextField(
                        value = description,
                        onValueChange = { description = it },
                        label = { Text("Description (Optional)") },
                        placeholder = { Text("e.g. My favorite smooth tracks") },
                        singleLine = false,
                        maxLines = 3,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF38BDF8),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.20f),
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = onDismiss) {
                            Text("Cancel", color = Color(0xFF94A3B8))
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(
                            onClick = { onCreate(title, description) },
                            enabled = title.isNotBlank(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF38BDF8),
                                disabledContainerColor = Color(0xFF1E293B)
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text("Create", color = if (title.isNotBlank()) Color.Black else Color(0xFF64748B), fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

// ================================================================================================
// REUSABLE 3D-GLOSSY GLASS ARCHITECTURE ENGINE
// ================================================================================================
// Pre-allocated static color lists to eliminate frame-by-frame memory churn and Skiko GC latency
private val CardSheenColorsHovered = listOf(Color.White.copy(alpha = 0.20f), Color.White.copy(alpha = 0.05f), Color.Transparent)
private val CardSheenColorsNormal = listOf(Color.White.copy(alpha = 0.13f), Color.White.copy(alpha = 0.02f), Color.Transparent)

private val CardGlareColorsHovered = listOf(Color.White.copy(alpha = 0.22f), Color(0xFF38BDF8).copy(alpha = 0.10f), Color.Transparent)
private val CardGlareColorsNormal = listOf(Color.White.copy(alpha = 0.14f), Color(0xFF38BDF8).copy(alpha = 0.04f), Color.Transparent)

private val CardTopRimColorsHovered = listOf(Color.Transparent, Color.White.copy(alpha = 0.85f), Color(0xFF67E8F9).copy(alpha = 0.65f), Color.White.copy(alpha = 0.75f), Color.Transparent)
private val CardTopRimColorsNormal = listOf(Color.Transparent, Color.White.copy(alpha = 0.60f), Color(0xFF67E8F9).copy(alpha = 0.40f), Color.White.copy(alpha = 0.50f), Color.Transparent)

private val CardInnerRimColorsHovered = listOf(Color.Transparent, Color.White.copy(alpha = 0.28f), Color.Transparent)
private val CardInnerRimColorsNormal = listOf(Color.Transparent, Color.White.copy(alpha = 0.16f), Color.Transparent)

private val CardBottomCausticColorsHovered = listOf(Color.Transparent, Color(0xFF38BDF8).copy(alpha = 0.35f), Color(0xFF818CF8).copy(alpha = 0.22f), Color.Transparent)
private val CardBottomCausticColorsNormal = listOf(Color.Transparent, Color(0xFF38BDF8).copy(alpha = 0.18f), Color(0xFF818CF8).copy(alpha = 0.10f), Color.Transparent)

private val BoxSheenColorsSelected = listOf(Color.White.copy(alpha = 0.22f), Color.White.copy(alpha = 0.06f), Color.Transparent)
private val BoxSheenColorsHovered = listOf(Color.White.copy(alpha = 0.18f), Color.White.copy(alpha = 0.04f), Color.Transparent)
private val BoxSheenColorsNormal = listOf(Color.White.copy(alpha = 0.12f), Color.White.copy(alpha = 0.02f), Color.Transparent)

private val BoxGlareColorsSelected = listOf(Color.White.copy(alpha = 0.24f), Color(0xFF38BDF8).copy(alpha = 0.12f), Color.Transparent)
private val BoxGlareColorsHovered = listOf(Color.White.copy(alpha = 0.18f), Color(0xFF38BDF8).copy(alpha = 0.08f), Color.Transparent)
private val BoxGlareColorsNormal = listOf(Color.White.copy(alpha = 0.12f), Color(0xFF38BDF8).copy(alpha = 0.03f), Color.Transparent)

private val BoxTopRimColorsSelected = listOf(Color.Transparent, Color.White.copy(alpha = 0.85f), Color(0xFF67E8F9).copy(alpha = 0.65f), Color.White.copy(alpha = 0.75f), Color.Transparent)
private val BoxTopRimColorsHovered = listOf(Color.Transparent, Color.White.copy(alpha = 0.80f), Color(0xFF67E8F9).copy(alpha = 0.60f), Color.White.copy(alpha = 0.70f), Color.Transparent)
private val BoxTopRimColorsNormal = listOf(Color.Transparent, Color.White.copy(alpha = 0.55f), Color(0xFF67E8F9).copy(alpha = 0.35f), Color.White.copy(alpha = 0.45f), Color.Transparent)

private val BoxInnerRimColorsSelected = listOf(Color.Transparent, Color.White.copy(alpha = 0.28f), Color.Transparent)
private val BoxInnerRimColorsHovered = listOf(Color.Transparent, Color.White.copy(alpha = 0.20f), Color.Transparent)
private val BoxInnerRimColorsNormal = listOf(Color.Transparent, Color.White.copy(alpha = 0.12f), Color.Transparent)

private val BoxBottomCausticColorsSelected = listOf(Color.Transparent, Color(0xFF38BDF8).copy(alpha = 0.35f), Color(0xFF818CF8).copy(alpha = 0.22f), Color.Transparent)
private val BoxBottomCausticColorsHovered = listOf(Color.Transparent, Color(0xFF38BDF8).copy(alpha = 0.25f), Color(0xFF818CF8).copy(alpha = 0.15f), Color.Transparent)
private val BoxBottomCausticColorsNormal = listOf(Color.Transparent, Color(0xFF38BDF8).copy(alpha = 0.16f), Color(0xFF818CF8).copy(alpha = 0.08f), Color.Transparent)

@Composable
fun LiquidGlassCard(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(20.dp),
    backgroundColor: Color = Color(0xFF0C101F).copy(alpha = 0.65f),
    borderColor: Color = Color.White.copy(alpha = 0.12f),
    hoverBorderColor: Color = Color(0xFF38BDF8).copy(alpha = 0.40f),
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isInteractiveHover = isHovered && onClick != null

    val currentTopBg = if (isInteractiveHover) {
        Color(0xFF1E325A).copy(alpha = 0.82f)
    } else {
        if (backgroundColor != Color(0xFF0C101F).copy(alpha = 0.65f)) {
            backgroundColor.copy(alpha = (backgroundColor.alpha * 1.08f).coerceIn(0f, 1f))
        } else {
            Color(0xFF16213B).copy(alpha = 0.72f)
        }
    }

    val currentBottomBg = if (isInteractiveHover) {
        Color(0xFF0A1326).copy(alpha = 0.92f)
    } else {
        if (backgroundColor != Color(0xFF0C101F).copy(alpha = 0.65f)) {
            backgroundColor.copy(alpha = (backgroundColor.alpha * 1.30f).coerceIn(0f, 1f))
        } else {
            Color(0xFF050814).copy(alpha = 0.88f)
        }
    }

    val currentBorder = if (isInteractiveHover) hoverBorderColor else borderColor

    val bgBrush = remember(currentTopBg, currentBottomBg) {
        Brush.verticalGradient(listOf(currentTopBg, currentBottomBg))
    }

    val borderStroke = remember(isInteractiveHover, currentBorder) {
        val colors = if (isInteractiveHover) {
            listOf(
                Color.White.copy(alpha = 0.85f),
                Color(0xFF38BDF8).copy(alpha = 0.70f),
                Color(0xFF818CF8).copy(alpha = 0.35f),
                Color(0xFF020617).copy(alpha = 0.90f)
            )
        } else {
            listOf(
                Color.White.copy(alpha = 0.60f),
                Color(0xFF67E8F9).copy(alpha = 0.40f),
                currentBorder.copy(alpha = 0.15f),
                Color(0xFF0F172A).copy(alpha = 0.50f),
                Color(0xFF020617).copy(alpha = 0.85f)
            )
        }
        BorderStroke(1.2.dp, Brush.linearGradient(colors, start = Offset(0f, 0f), end = Offset(450f, 450f)))
    }

    Box(
        modifier = modifier
            .shadow(
                elevation = if (isInteractiveHover) 12.dp else 6.dp,
                shape = shape,
                clip = false,
                ambientColor = Color(0x66000000),
                spotColor = if (isInteractiveHover) Color(0x4038BDF8) else Color(0x2238BDF8)
            )
            .clip(shape)
            .background(bgBrush)
            .border(borderStroke, shape)
            .drawWithContent {
                drawContent()

                // Layer 1: 3D Convex Gloss Sheen (Smooth upper-dome light reflection)
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = if (isInteractiveHover) CardSheenColorsHovered else CardSheenColorsNormal,
                        startY = 0f,
                        endY = size.height * 0.48f
                    ),
                    size = Size(size.width, size.height * 0.48f)
                )

                // Layer 2: Diagonal High-Gloss Specular Glare
                drawOval(
                    brush = Brush.radialGradient(
                        colors = if (isInteractiveHover) CardGlareColorsHovered else CardGlareColorsNormal,
                        center = Offset(size.width * 0.22f, 0f),
                        radius = (size.width * 0.50f).coerceAtLeast(70f)
                    ),
                    topLeft = Offset(-size.width * 0.10f, -size.height * 0.15f),
                    size = Size(size.width * 0.85f, size.height * 0.65f)
                )

                // Layer 3: Ultra-Sharp Top Specular Rim Reflection
                drawLine(
                    brush = Brush.horizontalGradient(
                        colors = if (isInteractiveHover) CardTopRimColorsHovered else CardTopRimColorsNormal
                    ),
                    start = Offset(size.width * 0.06f, 1f),
                    end = Offset(size.width * 0.94f, 1f),
                    strokeWidth = 1.5.dp.toPx()
                )

                // Layer 4: Secondary Inner Specular Micro-Bevel Hairline
                drawLine(
                    brush = Brush.horizontalGradient(
                        colors = if (isInteractiveHover) CardInnerRimColorsHovered else CardInnerRimColorsNormal
                    ),
                    start = Offset(size.width * 0.15f, 3f),
                    end = Offset(size.width * 0.85f, 3f),
                    strokeWidth = 1.dp.toPx()
                )

                // Layer 5: Bottom Refractive Caustic Rim Reflection
                drawLine(
                    brush = Brush.horizontalGradient(
                        colors = if (isInteractiveHover) CardBottomCausticColorsHovered else CardBottomCausticColorsNormal
                    ),
                    start = Offset(size.width * 0.12f, size.height - 1f),
                    end = Offset(size.width * 0.88f, size.height - 1f),
                    strokeWidth = 1.dp.toPx()
                )
            }
            .then(
                if (onClick != null) {
                    Modifier
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = onClick
                        )
                } else Modifier
            ),
        content = content
    )
}

@Composable
fun LiquidGlassBox(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    backgroundColor: Color = Color(0xFF0C101F).copy(alpha = 0.60f),
    borderColor: Color = Color.White.copy(alpha = 0.14f),
    hoverBorderColor: Color = Color(0xFF38BDF8).copy(alpha = 0.45f),
    isSelected: Boolean = false,
    selectedBgColor: Color = Color(0xFF1B253D).copy(alpha = 0.85f),
    selectedBorderColor: Color = Color(0xFF38BDF8).copy(alpha = 0.60f),
    onClick: (() -> Unit)? = null,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isInteractiveHover = isHovered && onClick != null

    val currentTopBg = when {
        isSelected -> if (selectedBgColor != Color(0xFF1B253D).copy(alpha = 0.85f)) selectedBgColor else Color(0xFF1E3A68).copy(alpha = 0.90f)
        isInteractiveHover -> Color(0xFF192542).copy(alpha = 0.80f)
        else -> if (backgroundColor != Color(0xFF0C101F).copy(alpha = 0.60f)) backgroundColor else Color(0xFF12192E).copy(alpha = 0.68f)
    }

    val currentBottomBg = when {
        isSelected -> Color(0xFF0D1C36).copy(alpha = 0.95f)
        isInteractiveHover -> Color(0xFF091022).copy(alpha = 0.88f)
        else -> Color(0xFF070B16).copy(alpha = 0.82f)
    }

    val currentBorder = when {
        isSelected -> selectedBorderColor
        isInteractiveHover -> hoverBorderColor
        else -> borderColor
    }

    val bgBrush = remember(currentTopBg, currentBottomBg) {
        Brush.verticalGradient(listOf(currentTopBg, currentBottomBg))
    }

    val borderStroke = remember(isSelected, isInteractiveHover, currentBorder) {
        val borderBrush = when {
            isSelected -> Brush.linearGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.90f),
                    Color(0xFF38BDF8).copy(alpha = 0.80f),
                    Color(0xFF818CF8).copy(alpha = 0.45f),
                    Color(0xFF020617).copy(alpha = 0.90f)
                ),
                start = Offset(0f, 0f),
                end = Offset(300f, 300f)
            )
            isInteractiveHover -> Brush.linearGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.80f),
                    Color(0xFF38BDF8).copy(alpha = 0.65f),
                    Color(0xFF818CF8).copy(alpha = 0.35f),
                    Color(0xFF020617).copy(alpha = 0.88f)
                ),
                start = Offset(0f, 0f),
                end = Offset(300f, 300f)
            )
            else -> Brush.linearGradient(
                colors = listOf(
                    Color.White.copy(alpha = 0.55f),
                    Color(0xFF67E8F9).copy(alpha = 0.35f),
                    currentBorder.copy(alpha = 0.15f),
                    Color(0xFF0F172A).copy(alpha = 0.45f),
                    Color(0xFF020617).copy(alpha = 0.85f)
                ),
                start = Offset(0f, 0f),
                end = Offset(300f, 300f)
            )
        }
        BorderStroke(1.2.dp, borderBrush)
    }

    Box(
        modifier = modifier
            .shadow(
                elevation = if (isSelected) 6.dp else if (isInteractiveHover) 4.dp else 2.dp,
                shape = shape,
                clip = false,
                ambientColor = Color(0x55000000),
                spotColor = if (isSelected || isInteractiveHover) Color(0x3838BDF8) else Color(0x1838BDF8)
            )
            .clip(shape)
            .background(bgBrush)
            .border(borderStroke, shape)
            .drawWithContent {
                drawContent()

                // Layer 1: 3D Convex Gloss Sheen
                val sheenColors = when {
                    isSelected -> BoxSheenColorsSelected
                    isInteractiveHover -> BoxSheenColorsHovered
                    else -> BoxSheenColorsNormal
                }
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = sheenColors,
                        startY = 0f,
                        endY = size.height * 0.48f
                    ),
                    size = Size(size.width, size.height * 0.48f)
                )

                // Layer 2: Diagonal High-Gloss Specular Glare
                val glareColors = when {
                    isSelected -> BoxGlareColorsSelected
                    isInteractiveHover -> BoxGlareColorsHovered
                    else -> BoxGlareColorsNormal
                }
                drawOval(
                    brush = Brush.radialGradient(
                        colors = glareColors,
                        center = Offset(size.width * 0.22f, 0f),
                        radius = (size.width * 0.50f).coerceAtLeast(40f)
                    ),
                    topLeft = Offset(-size.width * 0.10f, -size.height * 0.15f),
                    size = Size(size.width * 0.85f, size.height * 0.65f)
                )

                // Layer 3: Ultra-Sharp Top Specular Rim Reflection
                val topRimColors = when {
                    isSelected -> BoxTopRimColorsSelected
                    isInteractiveHover -> BoxTopRimColorsHovered
                    else -> BoxTopRimColorsNormal
                }
                drawLine(
                    brush = Brush.horizontalGradient(colors = topRimColors),
                    start = Offset(size.width * 0.06f, 1f),
                    end = Offset(size.width * 0.94f, 1f),
                    strokeWidth = 1.5.dp.toPx()
                )

                // Layer 4: Secondary Inner Specular Micro-Bevel Hairline
                val innerRimColors = when {
                    isSelected -> BoxInnerRimColorsSelected
                    isInteractiveHover -> BoxInnerRimColorsHovered
                    else -> BoxInnerRimColorsNormal
                }
                drawLine(
                    brush = Brush.horizontalGradient(colors = innerRimColors),
                    start = Offset(size.width * 0.15f, 2.5f),
                    end = Offset(size.width * 0.85f, 2.5f),
                    strokeWidth = 1.dp.toPx()
                )

                // Layer 5: Bottom Refractive Caustic Rim Reflection
                val bottomCausticColors = when {
                    isSelected -> BoxBottomCausticColorsSelected
                    isInteractiveHover -> BoxBottomCausticColorsHovered
                    else -> BoxBottomCausticColorsNormal
                }
                drawLine(
                    brush = Brush.horizontalGradient(colors = bottomCausticColors),
                    start = Offset(size.width * 0.12f, size.height - 1f),
                    end = Offset(size.width * 0.88f, size.height - 1f),
                    strokeWidth = 1.dp.toPx()
                )
            }
            .then(
                if (onClick != null) {
                    Modifier
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = onClick
                        )
                } else Modifier
            ),
        contentAlignment = contentAlignment,
        content = content
    )
}

// ================================================================================================
// 1. EXECUTIVE FROSTED GLASS MASTHEAD
// ================================================================================================
@Composable
private fun SeniorExecutiveMasthead(
    greeting: String,
    kicker: String,
    tasteSubline: String,
    currentHour: Int,
    onInstantMix: () -> Unit,
    onLaunchScreensaver: () -> Unit,
    onRefresh: () -> Unit
) {
    val (greetingIcon, accentColor) = when (currentHour) {
        in 5..11 -> Icons.Default.WbSunny to Color(0xFFF59E0B) // Amber Morning
        in 12..17 -> Icons.Default.LightMode to Color(0xFF0EA5E9) // Electric Azure Noon
        in 18..22 -> Icons.Default.NightsStay to Color(0xFF6366F1) // Indigo Dusk
        else -> Icons.Default.Bedtime to Color(0xFF8B5CF6) // Violet Midnight
    }

    val logoBitmap = remember {
        cachedHomeLogoBitmap ?: runCatching {
            val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_logo_square.png")
                ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_logo.png")
                ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/spothub_logo.png")
                ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "audix_logo_square.png").toFile().takeIf { it.exists() }?.inputStream()
                ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "audix_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                ?: java.nio.file.Paths.get("desktopApp", "src", "desktopMain", "resources", "images", "audix_logo_square.png").toFile().takeIf { it.exists() }?.inputStream()
                ?: java.nio.file.Paths.get("desktopApp", "src", "desktopMain", "resources", "images", "audix_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "audix_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "spothub_logo.png").toFile().takeIf { it.exists() }?.inputStream()
            stream?.use { loadImageBitmap(it) }
        }.getOrNull()?.also { cachedHomeLogoBitmap = it }
    }

    LiquidGlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        backgroundColor = Color(0xFF0B0F1E).copy(alpha = 0.74f),
        borderColor = Color.White.copy(alpha = 0.14f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // LEFT COLUMN: Audix Brand Logo, Greeting & Dynamic Soundscape Subline
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.weight(1f, fill = false)
            ) {
                // Audix Official Brand Logo Badge (Square shape, proportioned according to text height)
                LiquidGlassBox(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(64.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        if (logoBitmap != null) {
                            Image(
                                bitmap = logoBitmap,
                                contentDescription = "Audix Logo",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(4.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.GraphicEq,
                                contentDescription = "Audix Logo",
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier.widthIn(max = 650.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    // Top Kicker & Studio Lossless Pill
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = kicker,
                            color = accentColor,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.2.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        // 320 kbps Studio Lossless Pill
                        LiquidGlassBox(
                            shape = RoundedCornerShape(16.dp),
                            backgroundColor = Color(0xFF0F1A28).copy(alpha = 0.85f),
                            borderColor = Color(0xFF10B981).copy(alpha = 0.40f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(5.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF10B981))
                                )
                                Text(
                                    text = "320 kbps Lossless",
                                    color = Color(0xFF34D399),
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }

                    // Large Typographic Display Greeting
                    Text(
                        text = greeting,
                        color = Color(0xFFF8FAFC),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.4).sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    // Subtitle / Soundscape Insight
                    Text(
                        text = tasteSubline,
                        color = Color(0xFF94A3B8),
                        fontSize = 11.5.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(Modifier.width(14.dp))

            // RIGHT COLUMN: Precision Aligned Action Strip
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // High-Contrast Porcelain Button: Instant Flow Mix
                Button(
                    onClick = onInstantMix,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF8FAFC),
                        contentColor = Color(0xFF0A0E17)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                ) {
                    Icon(
                        Icons.Default.Shuffle,
                        contentDescription = "Instant Flow Mix",
                        modifier = Modifier.size(15.dp),
                        tint = Color(0xFF0284C7)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        text = "Instant Mix",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Screensaver Action Pill
                LiquidGlassBox(
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = Color(0xFF12182B).copy(alpha = 0.70f),
                    borderColor = Color.White.copy(alpha = 0.16f),
                    hoverBorderColor = Color(0xFF38BDF8).copy(alpha = 0.50f),
                    onClick = onLaunchScreensaver,
                    modifier = Modifier.height(36.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            Icons.Default.Bedtime,
                            contentDescription = "Ambient Screensaver",
                            tint = Color(0xFFCBD5E1),
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = "Cinema",
                            color = Color(0xFFF1F5F9),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                // Refresh Circular Glass Action
                LiquidGlassBox(
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = Color(0xFF12182B).copy(alpha = 0.70f),
                    borderColor = Color.White.copy(alpha = 0.16f),
                    hoverBorderColor = Color(0xFF38BDF8).copy(alpha = 0.50f),
                    onClick = onRefresh,
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Icon(
                            Icons.Default.Refresh,
                            contentDescription = "Refresh Feed",
                            tint = Color(0xFF94A3B8),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

// ================================================================================================
// 2. SOURCE & MOOD FILTER CAPSULE RIBBON
// ================================================================================================
@Composable
private fun SeniorSourceAndMoodBar(
    currentExtension: MusicExtension?,
    musicExtensions: List<MusicExtension>,
    selectedMood: String,
    onSelectExtension: (MusicExtension?) -> Unit,
    onSelectMood: (String) -> Unit
) {
    LiquidGlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFF090D1A).copy(alpha = 0.55f),
        borderColor = Color.White.copy(alpha = 0.09f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 9.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Source Indicator Tag
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(end = 12.dp)
            ) {
                Icon(
                    Icons.Default.Tune,
                    contentDescription = null,
                    tint = Color(0xFF64748B),
                    modifier = Modifier.size(15.dp)
                )
                Text(
                    text = "CATALOG",
                    color = Color(0xFF64748B),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp
                )
            }

            // Scrollable Sources Pills
            LazyRow(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val isAllActive = currentExtension == null
                item {
                    SeniorFilterPill(
                        title = "Master Collection",
                        isSelected = isAllActive,
                        onClick = { onSelectExtension(null) }
                    )
                }

                items(musicExtensions, key = { it.metadata.id }) { ext ->
                    val isSelected = currentExtension?.metadata?.id == ext.metadata.id
                    SeniorFilterPill(
                        title = ext.metadata.name,
                        isSelected = isSelected,
                        onClick = { onSelectExtension(ext) }
                    )
                }
            }

            // Vertical Hairline Divider
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(1.dp)
                    .height(20.dp)
                    .background(Color.White.copy(alpha = 0.12f))
            )

            // Mood Taste Filters
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("For You", "Top Charts", "Focus Sanctuary", "Midnight Lo-Fi", "Hi-Res Masters").forEach { mood ->
                    val isMoodActive = selectedMood == mood
                    LiquidGlassBox(
                        shape = RoundedCornerShape(16.dp),
                        isSelected = isMoodActive,
                        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
                        onClick = { onSelectMood(mood) }
                    ) {
                        Text(
                            text = mood,
                            color = if (isMoodActive) Color(0xFF38BDF8) else Color(0xFF64748B),
                            fontSize = 11.5.sp,
                            fontWeight = if (isMoodActive) FontWeight.SemiBold else FontWeight.Medium,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SeniorFilterPill(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    LiquidGlassBox(
        shape = RoundedCornerShape(18.dp),
        isSelected = isSelected,
        selectedBgColor = Color(0xFF1E2842).copy(alpha = 0.90f),
        selectedBorderColor = Color(0xFF38BDF8).copy(alpha = 0.60f),
        backgroundColor = Color(0xFF0F1424).copy(alpha = 0.55f),
        borderColor = Color.White.copy(alpha = 0.10f),
        hoverBorderColor = Color(0xFF38BDF8).copy(alpha = 0.45f),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF38BDF8))
                )
            }
            Text(
                text = title,
                color = if (isSelected) Color(0xFFF8FAFC) else Color(0xFF94A3B8),
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium
            )
        }
    }
}

// ================================================================================================
// 3. FLAGSHIP EDITORIAL HERO BILLBOARD (Dynamic Currently Playing / Recently Played Session)
// ================================================================================================
@Composable
private fun LiveEqualizerBars(
    modifier: Modifier = Modifier,
    barCount: Int = 3,
    color: Color = Color.White
) {
    val infiniteTransition = rememberInfiniteTransition(label = "eq_bars")
    val h1 by infiniteTransition.animateFloat(
        initialValue = 0.35f,
        targetValue = 0.95f,
        animationSpec = infiniteRepeatable(
            animation = tween(420, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "eq_1"
    )
    val h2 by infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 0.25f,
        animationSpec = infiniteRepeatable(
            animation = tween(530, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "eq_2"
    )
    val h3 by infiniteTransition.animateFloat(
        initialValue = 0.45f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(380, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "eq_3"
    )

    val fractions = listOf(h1, h2, h3)

    Row(
        modifier = modifier.height(13.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        fractions.take(barCount).forEach { fraction ->
            Box(
                modifier = Modifier
                    .width(2.5.dp)
                    .fillMaxHeight(fraction)
                    .clip(RoundedCornerShape(1.dp))
                    .background(color)
            )
        }
    }
}

private fun formatBillboardDuration(ms: Long?): String {
    if (ms == null || ms <= 0) return ""
    val totalSeconds = ms / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "${minutes}:${seconds.toString().padStart(2, '0')}"
}

@Composable
private fun BillboardActionButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    activeIconColor: Color = Color.White,
    defaultIconColor: Color = Color(0xFFD4D4D8)
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val bg = when {
        isActive -> Color.White.copy(alpha = 0.22f)
        isHovered -> Color.White.copy(alpha = 0.16f)
        else -> Color.White.copy(alpha = 0.08f)
    }
    val border = when {
        isActive -> Color.White.copy(alpha = 0.70f)
        isHovered -> Color.White.copy(alpha = 0.45f)
        else -> Color.White.copy(alpha = 0.15f)
    }

    Box(
        modifier = modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(bg)
            .border(1.dp, border, CircleShape)
            .hoverable(interactionSource)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = if (isActive) activeIconColor else defaultIconColor,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun BillboardOptionPill(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    activeColor: Color = Color.White
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val bg = when {
        isActive -> Color.White.copy(alpha = 0.20f)
        isHovered -> Color.White.copy(alpha = 0.14f)
        else -> Color.White.copy(alpha = 0.06f)
    }
    val border = when {
        isActive -> Color.White.copy(alpha = 0.60f)
        isHovered -> Color.White.copy(alpha = 0.35f)
        else -> Color.White.copy(alpha = 0.10f)
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(bg)
            .border(1.dp, border, RoundedCornerShape(10.dp))
            .hoverable(interactionSource)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .padding(horizontal = 9.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isActive) activeColor else Color(0xFFA1A1AA),
            modifier = Modifier.size(13.dp)
        )
        Text(
            text = label,
            color = if (isActive) Color.White else Color(0xFFD4D4D8),
            fontSize = 11.sp,
            fontWeight = if (isActive) FontWeight.SemiBold else FontWeight.Medium
        )
    }
}

@Composable
private fun BillboardSoundstageVisualizer(
    isPlaying: Boolean,
    phase: Float,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.fillMaxWidth().height(38.dp)) {
        if (size.width <= 0f) return@Canvas
        val barCount = 28
        val spacingPx = 3.5.dp.toPx()
        val totalSpacing = spacingPx * (barCount - 1)
        if (size.width <= totalSpacing) return@Canvas
        val barWidth = ((size.width - totalSpacing) / barCount).coerceIn(2.5.dp.toPx(), 6.5.dp.toPx())
        val actualWidth = barCount * barWidth + totalSpacing
        val startX = (size.width - actualWidth) / 2f

        for (i in 0 until barCount) {
            val x = startX + i * (barWidth + spacingPx)
            val normalizedIndex = i.toFloat() / (barCount - 1) // 0f..1f

            val barFraction = if (isPlaying) {
                val wave1 = kotlin.math.sin(phase * 3.2f + i * 0.45f)
                val wave2 = kotlin.math.cos(phase * 1.8f - i * 0.65f)
                val envelope = 0.4f + 0.6f * kotlin.math.sin(normalizedIndex * Math.PI.toFloat())
                val raw = (0.45f + 0.32f * wave1 + 0.23f * wave2) * envelope
                raw.coerceIn(0.12f, 0.95f)
            } else {
                val resting = 0.15f + 0.14f * kotlin.math.sin(normalizedIndex * Math.PI.toFloat())
                resting.coerceIn(0.08f, 0.30f)
            }

            val barHeight = size.height * barFraction
            val topY = size.height - barHeight

            drawRoundRect(
                brush = Brush.verticalGradient(
                    colors = if (isPlaying) listOf(
                        Color.White,
                        Color(0xFFE4E4E7),
                        Color(0xFF71717A).copy(alpha = 0.60f)
                    ) else listOf(
                        Color(0xFFA1A1AA).copy(alpha = 0.65f),
                        Color(0xFF52525B).copy(alpha = 0.35f)
                    ),
                    startY = topY,
                    endY = size.height
                ),
                topLeft = Offset(x, topY),
                size = Size(barWidth, barHeight),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(barWidth / 2, barWidth / 2)
            )
        }
    }
}

@Composable
private fun SeniorEditorialBillboard(
    playerViewModel: PlayerViewModel,
    libraryManager: DesktopLibraryManager? = null,
    downloadManager: DesktopDownloadManager? = null,
    onAddToPlaylist: (Track) -> Unit,
    onDownload: (Track) -> Unit,
    onLaunchScreensaver: () -> Unit = {}
) {
    val currentTrack by playerViewModel.currentTrack.collectAsState()
    val isPlaying by playerViewModel.isPlaying.collectAsState()
    val historyList by (libraryManager?.history?.collectAsState() ?: remember { mutableStateOf(emptyList()) })
    val favoritesList by (libraryManager?.favorites?.collectAsState() ?: remember { mutableStateOf(emptyList()) })
    val completedDownloads by (downloadManager?.completedDownloads?.collectAsState() ?: remember { mutableStateOf(emptyList()) })

    // Resolve active track strictly adhering to user directive:
    // 1. Currently playing/session track
    // 2. Previously played track (from listening history)
    // 3. Fallback to favorites or curated default if history is empty
    val (activeTrack, isCurrentSession) = remember(currentTrack, historyList, favoritesList) {
        when {
            currentTrack != null -> currentTrack!! to true
            historyList.isNotEmpty() -> historyList.first() to false
            favoritesList.isNotEmpty() -> favoritesList.first() to false
            else -> Track(
                id = "echo_curated_master",
                title = "Acoustic Reflections",
                artists = listOf(Artist("echo_studio", "Echo Hi-Fi Studio")),
                album = Album("Echo Master Editions", "Echo Master Editions"),
                duration = 210000L
            ) to false
        }
    }

    val isFavorited = remember(favoritesList, activeTrack.id) {
        favoritesList.any { it.id == activeTrack.id }
    }

    val isDownloaded = remember(completedDownloads, activeTrack.id) {
        completedDownloads.any { it.track.id == activeTrack.id }
    }

    // Infinite Transitions for Vinyl & Soundstage
    val infiniteTransition = rememberInfiniteTransition(label = "billboard_fx")
    val vinylAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(16000, easing = LinearEasing),
            repeatMode = androidx.compose.animation.core.RepeatMode.Restart
        ),
        label = "vinyl_angle"
    )
    val soundstagePhase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (2 * Math.PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(2400, easing = LinearEasing),
            repeatMode = androidx.compose.animation.core.RepeatMode.Restart
        ),
        label = "soundstage_phase"
    )

    var showCopiedFeedback by remember { mutableStateOf(false) }
    LaunchedEffect(showCopiedFeedback) {
        if (showCopiedFeedback) {
            kotlinx.coroutines.delay(2000)
            showCopiedFeedback = false
        }
    }

    // Obsidian Glass Container with Zero Content Occlusion
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(164.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = Color.Black,
                spotColor = Color(0x35000000)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF141519),
                        Color(0xFF101114),
                        Color(0xFF0C0D0F)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(1400f, 700f)
                )
            )
            .border(
                BorderStroke(
                    1.dp,
                    Brush.linearGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.22f),
                            Color.White.copy(alpha = 0.08f),
                            Color.White.copy(alpha = 0.03f),
                            Color.White.copy(alpha = 0.14f)
                        ),
                        start = Offset(0f, 0f),
                        end = Offset(800f, 400f)
                    )
                ),
                RoundedCornerShape(20.dp)
            )
    ) {
        // Ambient specular glows drawn BEFORE content (so text and buttons are never washed out or sliced!)
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // Top-left subtle ambient light
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.035f),
                        Color.Transparent
                    ),
                    center = Offset(80.dp.toPx(), 25.dp.toPx()),
                    radius = 140.dp.toPx()
                ),
                radius = 140.dp.toPx(),
                center = Offset(80.dp.toPx(), 25.dp.toPx())
            )

            // Right side ambient glow behind vinyl
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.045f),
                        Color.White.copy(alpha = 0.015f),
                        Color.Transparent
                    ),
                    center = Offset(w - 110.dp.toPx(), h / 2),
                    radius = 160.dp.toPx()
                ),
                radius = 160.dp.toPx(),
                center = Offset(w - 110.dp.toPx(), h / 2)
            )
        }

        // Main 3-Zone Horizontally Balanced Content Architecture
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // ====================================================================================
            // ZONE 1 (LEFT): Track Metadata & Primary Audio Execution Matrix
            // ====================================================================================
            Column(
                modifier = Modifier
                    .widthIn(min = 280.dp, max = 340.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                // Tier 1: Kicker & Audio Telemetry (Real state badge)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (isCurrentSession && isPlaying) {
                        LiveEqualizerBars(
                            barCount = 3,
                            color = Color.White
                        )
                        Text(
                            text = "NOW PLAYING",
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.3.sp
                        )
                    } else if (isCurrentSession) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFA1A1AA))
                        )
                        Text(
                            text = "CURRENT SESSION • PAUSED",
                            color = Color(0xFFA1A1AA),
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.1.sp
                        )
                    } else if (historyList.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = null,
                            tint = Color(0xFFA1A1AA),
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "RECENTLY PLAYED",
                            color = Color(0xFFA1A1AA),
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.1.sp
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = null,
                            tint = Color(0xFFA1A1AA),
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "FEATURED TRACK",
                            color = Color(0xFFA1A1AA),
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.1.sp
                        )
                    }

                    // Duration or Lossless Audio Pill
                    val durationStr = formatBillboardDuration(activeTrack.duration)
                    if (durationStr.isNotBlank()) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White.copy(alpha = 0.08f))
                                .border(1.dp, Color.White.copy(alpha = 0.15f), RoundedCornerShape(8.dp))
                                .padding(horizontal = 7.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = durationStr,
                                color = Color(0xFFD4D4D8),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    if (showCopiedFeedback) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .padding(horizontal = 7.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "Link copied!",
                                color = Color.Black,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Tier 2: Title & Artist (Spacious, bold, high legibility)
                Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Text(
                        text = activeTrack.title.ifBlank { "Untitled Track" },
                        color = Color(0xFFFAFAFA),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.4).sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    val artistsText = activeTrack.artists.joinToString(" • ") { it.name }.ifBlank { "Unknown Artist" }
                    val albumTitle = activeTrack.album?.title?.takeIf { it.isNotBlank() && it != activeTrack.title }
                    val displaySubtitle = if (albumTitle != null) "$artistsText  ·  $albumTitle" else artistsText

                    Text(
                        text = displaySubtitle,
                        color = Color(0xFFA1A1AA),
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Tier 3: Functional Action Matrix (All 100% working, with clean BillboardActionButton!)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(9.dp)
                ) {
                    // 1. Primary Hero Play/Pause/Resume Button
                    Button(
                        onClick = {
                            if (isCurrentSession) {
                                playerViewModel.togglePlayPause()
                            } else {
                                playerViewModel.play(activeTrack)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF0F0F12)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                    ) {
                        val heroIcon = if (isCurrentSession && isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow
                        val heroLabel = when {
                            isCurrentSession && isPlaying -> "Pause"
                            isCurrentSession -> "Resume"
                            else -> "Play Now"
                        }
                        Icon(
                            imageVector = heroIcon,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = heroLabel,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // 2. Favorite Toggle Button
                    BillboardActionButton(
                        icon = if (isFavorited) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        isActive = isFavorited,
                        activeIconColor = Color.White,
                        onClick = { libraryManager?.toggleFavorite(activeTrack) }
                    )

                    // 3. Add to Playlist Button
                    BillboardActionButton(
                        icon = Icons.AutoMirrored.Filled.PlaylistAdd,
                        contentDescription = "Add to Playlist",
                        onClick = { onAddToPlaylist(activeTrack) }
                    )

                    // 4. Download / Offline Button
                    BillboardActionButton(
                        icon = if (isDownloaded) Icons.Default.Check else Icons.Default.Download,
                        contentDescription = "Download Track",
                        isActive = isDownloaded,
                        activeIconColor = Color.White,
                        onClick = { onDownload(activeTrack) }
                    )

                    // 5. Skip Next Button (Active if in session)
                    if (isCurrentSession) {
                        BillboardActionButton(
                            icon = Icons.Default.SkipNext,
                            contentDescription = "Skip Next",
                            onClick = { playerViewModel.skipNext() }
                        )
                    }

                    // 6. Share / Copy Info Button
                    BillboardActionButton(
                        icon = Icons.Default.Share,
                        contentDescription = "Share Track",
                        onClick = {
                            runCatching {
                                val text = "${activeTrack.title} — ${activeTrack.artists.joinToString(", ") { it.name }}"
                                java.awt.Toolkit.getDefaultToolkit().systemClipboard.setContents(
                                    java.awt.datatransfer.StringSelection(text),
                                    null
                                )
                                showCopiedFeedback = true
                            }
                        }
                    )
                }
            }

            // ====================================================================================
            // ZONE 2 (CENTER): Dynamic Studio Soundstage Spectrum & Option Controls
            // ====================================================================================
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Tier 1: Telemetry Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.GraphicEq,
                            contentDescription = null,
                            tint = Color(0xFFA1A1AA),
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = "STUDIO SOUNDSTAGE",
                            color = Color(0xFFA1A1AA),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.1.sp
                        )
                    }

                    Text(
                        text = "320 KBPS AAC  •  STEREO 44.1 KHZ",
                        color = Color(0xFF71717A),
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.8.sp
                    )
                }

                // Tier 2: Real Animated Multi-Band Audio Spectrum Visualizer
                BillboardSoundstageVisualizer(
                    isPlaying = isCurrentSession && isPlaying,
                    phase = soundstagePhase
                )

                // Tier 3: Working Options Bar ("along with their options")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 1. Screensaver Quick Launch
                    BillboardOptionPill(
                        icon = Icons.Default.Tv,
                        label = "Screensaver",
                        onClick = onLaunchScreensaver
                    )

                    // 2. Audio Effects / Equalizer
                    val showAudioEffects by playerViewModel.showAudioEffectsDialog.collectAsState()
                    BillboardOptionPill(
                        icon = Icons.Default.Equalizer,
                        label = "Equalizer",
                        isActive = showAudioEffects,
                        onClick = { playerViewModel.toggleAudioEffectsDialog() }
                    )

                    // 3. Shuffle Toggle
                    val isShuffle by playerViewModel.shuffleEnabled.collectAsState()
                    BillboardOptionPill(
                        icon = Icons.Default.Shuffle,
                        label = "Shuffle",
                        isActive = isShuffle,
                        onClick = { playerViewModel.setShuffle(!isShuffle) }
                    )

                    // 4. Repeat Mode Cycle
                    val currentRepeat by playerViewModel.repeatMode.collectAsState()
                    val isRepeatActive = currentRepeat != dev.brahmkshatriya.echo.core.platform.RepeatMode.NONE
                    BillboardOptionPill(
                        icon = if (currentRepeat == dev.brahmkshatriya.echo.core.platform.RepeatMode.ONE) Icons.Default.RepeatOne else Icons.Default.Repeat,
                        label = when (currentRepeat) {
                            dev.brahmkshatriya.echo.core.platform.RepeatMode.ONE -> "Repeat 1"
                            dev.brahmkshatriya.echo.core.platform.RepeatMode.ALL -> "Repeat All"
                            else -> "Repeat"
                        },
                        isActive = isRepeatActive,
                        onClick = {
                            val nextMode = when (currentRepeat) {
                                dev.brahmkshatriya.echo.core.platform.RepeatMode.NONE -> dev.brahmkshatriya.echo.core.platform.RepeatMode.ALL
                                dev.brahmkshatriya.echo.core.platform.RepeatMode.ALL -> dev.brahmkshatriya.echo.core.platform.RepeatMode.ONE
                                else -> dev.brahmkshatriya.echo.core.platform.RepeatMode.NONE
                            }
                            playerViewModel.setRepeatMode(nextMode)
                        }
                    )

                    // 5. Now Playing Fullscreen / Details
                    BillboardOptionPill(
                        icon = Icons.Default.OpenInFull,
                        label = "Now Playing",
                        onClick = { playerViewModel.toggleNowPlaying() }
                    )
                }
            }

            // ====================================================================================
            // ZONE 3 (RIGHT): 3D Peeking Vinyl Record & Square Album Jacket
            // ====================================================================================
            Box(
                modifier = Modifier
                    .width(214.dp)
                    .height(126.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                // 1. Vinyl Record (Spins ONLY when playing current session!)
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 4.dp)
                        .size(108.dp)
                        .shadow(12.dp, CircleShape)
                        .clip(CircleShape)
                        .background(Color(0xFF0C0D10))
                        .border(1.dp, Color.White.copy(alpha = 0.16f), CircleShape)
                        .rotate(if (isCurrentSession && isPlaying) vinylAngle else 0f),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val center = Offset(size.width / 2, size.height / 2)
                        listOf(20f, 32f, 44f, 50f).forEach { rDp ->
                            drawCircle(
                                color = Color.White.copy(alpha = 0.08f),
                                radius = rDp * density,
                                center = center,
                                style = Stroke(width = 0.8f)
                            )
                        }
                    }

                    // Center Spindle Hub with dynamic track thumbnail
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF18191E))
                            .border(1.dp, Color.White.copy(alpha = 0.25f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        val centerCoverUrl = activeTrack.extractCoverUrl()
                        if (!centerCoverUrl.isNullOrBlank()) {
                            AsyncImage(
                                model = centerCoverUrl,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize().clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }
                        // Center spindle hole
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF0C0D10))
                                .border(0.6.dp, Color.White.copy(alpha = 0.60f), CircleShape)
                        )
                    }
                }

                // 2. Square Album Jacket (Clickable to play/pause)
                val jacketInteractionSource = remember { MutableInteractionSource() }
                val isJacketHovered by jacketInteractionSource.collectIsHoveredAsState()
                val jacketScale by animateFloatAsState(if (isJacketHovered) 1.025f else 1f)

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(114.dp)
                        .scale(jacketScale)
                        .shadow(14.dp, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(12.dp))
                        .hoverable(jacketInteractionSource)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable(
                            interactionSource = jacketInteractionSource,
                            indication = null,
                            onClick = {
                                if (isCurrentSession) {
                                    playerViewModel.togglePlayPause()
                                } else {
                                    playerViewModel.play(activeTrack)
                                }
                            }
                        )
                ) {
                    val coverUrl = activeTrack.extractCoverUrl()
                    if (!coverUrl.isNullOrBlank()) {
                        AsyncImage(
                            model = coverUrl,
                            contentDescription = activeTrack.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFF222226),
                                            Color(0xFF161619),
                                            Color(0xFF0E0E10)
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.MusicNote,
                                contentDescription = null,
                                tint = Color.White.copy(alpha = 0.35f),
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }

                    // Diagonal Specular Gloss Sheen
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color.White.copy(alpha = 0.16f),
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.25f)
                                    ),
                                    start = Offset(0f, 0f),
                                    end = Offset(140f, 140f)
                                )
                            )
                    )
                }

                // 3. Floating 33⅓ RPM micro badge
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 2.dp, end = 2.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.Black.copy(alpha = 0.65f))
                        .border(0.6.dp, Color.White.copy(alpha = 0.25f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 5.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "33⅓ RPM",
                        color = Color(0xFFE4E4E7),
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                }
            }
        }
    }
}

// ================================================================================================
// HEAVY ROTATION DEDICATED SCREEN & HIGH-VELOCITY PLAYBACK MATRIX
// ================================================================================================
@Composable
fun HeavyRotationScreen(
    playerViewModel: PlayerViewModel = koinInject(),
    onMediaSelected: (EchoMediaItem) -> Unit = {},
    onLaunchScreensaver: () -> Unit = {}
) {
    val libraryManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val downloadManager = remember {
        runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }

    val history by libraryManager.history.collectAsState()
    val favorites by libraryManager.favorites.collectAsState()
    val currentTrack by playerViewModel.currentTrack.collectAsState()
    val isPlaying by playerViewModel.isPlaying.collectAsState()

    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }
    var trackForPlaylist by remember { mutableStateOf<Track?>(null) }
    var showClearConfirmDialog by remember { mutableStateOf(false) }

    // Fallback curated tracks if history is empty
    val defaultTracks = remember {
        listOf(
            Track(
                id = "rot_1",
                title = "Blinding Lights",
                artists = listOf(Artist("ar_w", "The Weeknd")),
                cover = ImageHolder.NetworkRequestImageHolder(NetworkRequest("https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg"), false),
                duration = 200000L
            ),
            Track(
                id = "rot_2",
                title = "Midnight City",
                artists = listOf(Artist("ar_m83", "M83")),
                duration = 244000L
            ),
            Track(
                id = "rot_3",
                title = "Starboy",
                artists = listOf(Artist("ar_w", "The Weeknd"), Artist("ar_dp", "Daft Punk")),
                cover = ImageHolder.NetworkRequestImageHolder(NetworkRequest("https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg"), false),
                duration = 230000L
            ),
            Track(
                id = "rot_4",
                title = "Levitating",
                artists = listOf(Artist("ar_dl", "Dua Lipa")),
                duration = 203000L
            ),
            Track(
                id = "rot_5",
                title = "Save Your Tears",
                artists = listOf(Artist("ar_w", "The Weeknd")),
                duration = 215000L
            ),
            Track(
                id = "rot_6",
                title = "Sunset Reverie",
                artists = listOf(Artist("ar_al", "Acoustic Lounge")),
                duration = 185000L
            )
        )
    }

    val baseTracks = if (history.isNotEmpty()) history else defaultTracks
    val isRealHistory = history.isNotEmpty()

    val filteredTracks = remember(baseTracks, searchQuery, selectedFilter, favorites) {
        var res = baseTracks
        if (searchQuery.isNotBlank()) {
            res = res.filter {
                it.title.contains(searchQuery, ignoreCase = true) ||
                it.artists.any { a -> a.name.contains(searchQuery, ignoreCase = true) }
            }
        }
        when (selectedFilter) {
            "Favorites in Rotation" -> res.filter { track -> favorites.any { it.id == track.id } }
            "Recently Played" -> res.take(12)
            else -> res
        }
    }

    // Modal Add-to-Playlist Dialog
    trackForPlaylist?.let { track ->
        AddToPlaylistDialog(
            track = track,
            onDismiss = { trackForPlaylist = null },
            libraryManager = libraryManager
        )
    }

    // Clear History Confirmation Dialog
    if (showClearConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showClearConfirmDialog = false },
            containerColor = Color(0xFF0F1424),
            shape = RoundedCornerShape(18.dp),
            title = {
                Text(
                    text = "Clear Rotation History?",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            },
            text = {
                Text(
                    text = "This will clear your frequent listening history. You can rebuild your rotation list dynamically as you stream new songs.",
                    color = Color(0xFF94A3B8),
                    fontSize = 13.sp,
                    lineHeight = 18.sp
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        libraryManager.clearHistory()
                        showClearConfirmDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text("Clear All", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearConfirmDialog = false }) {
                    Text("Cancel", color = Color(0xFF94A3B8), fontSize = 12.sp)
                }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            // 1. EXECUTIVE GLASS HEADER & STATS BILLBOARD
            item {
                LiquidGlassCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    backgroundColor = Color(0xFF0B1021).copy(alpha = 0.75f),
                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.25f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Left Brand Header
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(54.dp)
                                        .shadow(12.dp, RoundedCornerShape(16.dp))
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(
                                            Brush.linearGradient(
                                                listOf(Color(0xFF38BDF8), Color(0xFF0284C7), Color(0xFF0F172A))
                                            )
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Whatshot,
                                        contentDescription = "Rotation",
                                        tint = Color.White,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }

                                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Text(
                                            text = "HEAVY ROTATION",
                                            color = Color(0xFF64748B),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            letterSpacing = 1.3.sp
                                        )
                                        Box(
                                            modifier = Modifier
                                                .size(4.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFF38BDF8))
                                        )
                                        Text(
                                            text = "INSTANT PLAYBACK",
                                            color = Color(0xFF38BDF8),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }

                                    Text(
                                        text = "Heavy Rotation",
                                        color = Color(0xFFF8FAFC),
                                        fontSize = 26.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        letterSpacing = (-0.5).sp
                                    )

                                    Text(
                                        text = "Your high-velocity playback matrix and personalized streaming history",
                                        color = Color(0xFF94A3B8),
                                        fontSize = 12.5.sp
                                    )
                                }
                            }

                            // Right Stats & Badges
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(10.dp),
                                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.25f)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(6.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFF10B981))
                                        )
                                        Text(
                                            text = "${filteredTracks.size} FREQUENT TRACKS",
                                            color = Color(0xFFE2E8F0),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }

                                LiquidGlassBox(
                                    shape = RoundedCornerShape(10.dp),
                                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                                    borderColor = Color.White.copy(alpha = 0.12f)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(
                                            Icons.Default.GraphicEq,
                                            contentDescription = null,
                                            tint = Color(0xFF38BDF8),
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Text(
                                            text = "320 KBPS HI-FI",
                                            color = Color(0xFF94A3B8),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                            }
                        }

                        // Divider
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.White.copy(alpha = 0.06f))
                        )

                        // Action Controls Bar
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Primary playback controls
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = {
                                        if (filteredTracks.isNotEmpty()) {
                                            playerViewModel.play(filteredTracks.first())
                                            if (filteredTracks.size > 1) {
                                                playerViewModel.addToQueue(filteredTracks.drop(1))
                                            }
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF38BDF8)),
                                    shape = RoundedCornerShape(12.dp),
                                    contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp)
                                ) {
                                    Icon(
                                        Icons.Default.PlayArrow,
                                        contentDescription = "Play All",
                                        tint = Color(0xFF090D16),
                                        modifier = Modifier.size(17.dp)
                                    )
                                    Spacer(Modifier.width(6.dp))
                                    Text(
                                        text = "Play All",
                                        color = Color(0xFF090D16),
                                        fontSize = 12.5.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                LiquidGlassBox(
                                    shape = RoundedCornerShape(12.dp),
                                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                                    borderColor = Color.White.copy(alpha = 0.15f),
                                    onClick = {
                                        if (filteredTracks.isNotEmpty()) {
                                            val shuffled = filteredTracks.shuffled()
                                            playerViewModel.play(shuffled.first())
                                            if (shuffled.size > 1) {
                                                playerViewModel.addToQueue(shuffled.drop(1))
                                            }
                                        }
                                    }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Icon(
                                            Icons.Default.Shuffle,
                                            contentDescription = "Shuffle",
                                            tint = Color(0xFFE2E8F0),
                                            modifier = Modifier.size(15.dp)
                                        )
                                        Text(
                                            text = "Shuffle",
                                            color = Color(0xFFE2E8F0),
                                            fontSize = 12.5.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }

                                if (isRealHistory) {
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(12.dp),
                                        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.50f),
                                        borderColor = Color.White.copy(alpha = 0.10f),
                                        onClick = { showClearConfirmDialog = true }
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            Icon(
                                                Icons.Default.DeleteOutline,
                                                contentDescription = "Clear History",
                                                tint = Color(0xFF94A3B8),
                                                modifier = Modifier.size(15.dp)
                                            )
                                            Text(
                                                text = "Clear History",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Medium
                                            )
                                        }
                                    }
                                }
                            }

                            // Filter Chips Row
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                val filterOptions = listOf("All", "Recently Played", "Favorites in Rotation")
                                for (opt in filterOptions) {
                                    val isSelected = selectedFilter == opt
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(20.dp),
                                        isSelected = isSelected,
                                        onClick = { selectedFilter = opt }
                                    ) {
                                        Text(
                                            text = opt,
                                            color = if (isSelected) Color(0xFF38BDF8) else Color(0xFF94A3B8),
                                            fontSize = 11.5.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 2. SEARCH / QUICK FILTER INPUT
            item {
                LiquidGlassBox(
                    shape = RoundedCornerShape(14.dp),
                    backgroundColor = Color(0xFF0C101F).copy(alpha = 0.65f),
                    borderColor = Color.White.copy(alpha = 0.12f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color(0xFF64748B),
                            modifier = Modifier.size(18.dp)
                        )
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = {
                                Text(
                                    "Filter tracks by title or artist...",
                                    color = Color(0xFF64748B),
                                    fontSize = 12.5.sp
                                )
                            },
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent,
                                focusedTextColor = Color.White,
                                unfocusedTextColor = Color(0xFFE2E8F0),
                                cursorColor = Color(0xFF38BDF8)
                            ),
                            modifier = Modifier.weight(1f)
                        )
                        if (searchQuery.isNotEmpty()) {
                            IconButton(
                                onClick = { searchQuery = "" },
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Clear",
                                    tint = Color(0xFF94A3B8),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }

            // 3. INSTANT ACCESS MATRIX (Top 6 Quick-Play Cards Grid)
            if (filteredTracks.isNotEmpty()) {
                val matrixTracks = filteredTracks.take(6)
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "INSTANT PLAY MATRIX",
                                    color = Color(0xFF64748B),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.3.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .size(4.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF38BDF8))
                                )
                                Text(
                                    text = "CLICK TO RESUME",
                                    color = Color(0xFF38BDF8),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Text(
                                text = "TOP ${matrixTracks.size} FREQUENT",
                                color = Color(0xFF475569),
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        // Chunked into rows of 3
                        val chunked = matrixTracks.chunked(3)
                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            for (rowTracks in chunked) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    for (track in rowTracks) {
                                        val isCurrentActive = currentTrack?.id == track.id
                                        Box(modifier = Modifier.weight(1f)) {
                                            SeniorMatrixTrackCard(
                                                track = track,
                                                isCurrentlyPlaying = isCurrentActive && isPlaying,
                                                onPlay = { playerViewModel.play(track) }
                                            )
                                        }
                                    }
                                    val missing = 3 - rowTracks.size
                                    for (i in 0 until missing) {
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }
                            }
                        }
                    }
                }

                // 4. COMPREHENSIVE FREQUENT TRACK LISTING
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "ALL FREQUENT TRACKS",
                                    color = Color(0xFF64748B),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.3.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .size(4.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF38BDF8))
                                )
                                Text(
                                    text = "STREAM HISTORY LIST",
                                    color = Color(0xFF38BDF8),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Text(
                                text = "${filteredTracks.size} TOTAL",
                                color = Color(0xFF475569),
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                // Track items indexed
                itemsIndexed(filteredTracks) { index, track ->
                    val isCurrentActive = currentTrack?.id == track.id
                    val isFav = favorites.any { it.id == track.id }

                    SeniorRotationTrackRow(
                        index = index + 1,
                        track = track,
                        isPlaying = isCurrentActive && isPlaying,
                        isFavorite = isFav,
                        onPlay = { playerViewModel.play(track) },
                        onToggleFavorite = { libraryManager.toggleFavorite(track) },
                        onAddToPlaylist = { trackForPlaylist = track },
                        onDownload = { downloadManager.downloadTrack(track) }
                    )
                }
            } else {
                // EMPTY STATE
                item {
                    LiquidGlassCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 40.dp),
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.55f)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(40.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            LiquidGlassBox(
                                shape = CircleShape,
                                modifier = Modifier.size(64.dp)
                            ) {
                                Icon(
                                    Icons.Default.Whatshot,
                                    contentDescription = null,
                                    tint = Color(0xFF38BDF8),
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Text(
                                text = if (searchQuery.isNotEmpty()) "No matching tracks found" else "No rotation history yet",
                                color = Color(0xFFF8FAFC),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = if (searchQuery.isNotEmpty()) "Try adjusting your search or clear the filter query." else "Play your favorite music from Home, Search, or Library to start populating your personalized heavy rotation stream.",
                                color = Color(0xFF94A3B8),
                                fontSize = 13.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.widthIn(max = 420.dp)
                            )
                        }
                    }
                }
            }

            // Bottom space for mini player dock clearance
            item {
                Spacer(Modifier.height(100.dp))
            }
        }
    }
}

@Composable
private fun SeniorMatrixTrackCard(
    track: Track,
    isCurrentlyPlaying: Boolean = false,
    onPlay: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = if (isHovered) Color(0xFF182035).copy(alpha = 0.82f) else Color(0xFF0F1426).copy(alpha = 0.55f),
        borderColor = if (isCurrentlyPlaying) Color(0xFF38BDF8).copy(alpha = 0.80f) else if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.08f),
        onClick = onPlay
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Square Cover Art on Left (54dp)
            val coverUrl = track.extractCoverUrl()
            LiquidGlassBox(
                shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp),
                modifier = Modifier.size(54.dp)
            ) {
                if (!coverUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = coverUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        Icons.Default.MusicNote,
                        contentDescription = null,
                        tint = Color(0xFF64748B),
                        modifier = Modifier.size(24.dp)
                    )
                }

                if (isCurrentlyPlaying) {
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
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Spacer(Modifier.width(12.dp))

            // Title & Artist
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = track.title,
                    color = if (isCurrentlyPlaying) Color(0xFF38BDF8) else Color(0xFFF8FAFC),
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = track.artists.joinToString(", ") { it.name },
                    color = Color(0xFF94A3B8),
                    fontSize = 11.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Right Hover Play Button or 320k Tag
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(32.dp),
                contentAlignment = Alignment.Center
            ) {
                if (isHovered) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .shadow(6.dp, CircleShape)
                            .clip(CircleShape)
                            .background(Color(0xFF38BDF8)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (isCurrentlyPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            tint = Color(0xFF0A0E17),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                } else if (isCurrentlyPlaying) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = Color(0xFF0284C7).copy(alpha = 0.40f),
                        borderColor = Color(0xFF38BDF8).copy(alpha = 0.40f)
                    ) {
                        Text(
                            text = "LIVE",
                            color = Color(0xFF38BDF8),
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                } else {
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
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SeniorRotationTrackRow(
    index: Int,
    track: Track,
    isPlaying: Boolean,
    isFavorite: Boolean,
    onPlay: () -> Unit,
    onToggleFavorite: () -> Unit,
    onAddToPlaylist: () -> Unit,
    onDownload: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = if (isHovered) Color(0xFF161F36).copy(alpha = 0.85f) else Color(0xFF0B1020).copy(alpha = 0.45f),
        borderColor = if (isPlaying) Color(0xFF38BDF8).copy(alpha = 0.60f) else if (isHovered) Color.White.copy(alpha = 0.16f) else Color.White.copy(alpha = 0.05f),
        onClick = onPlay
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Index number or Playing Equalizer
            Box(
                modifier = Modifier.width(32.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (isPlaying) {
                    Icon(
                        Icons.Default.GraphicEq,
                        contentDescription = "Playing",
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(16.dp)
                    )
                } else {
                    Text(
                        text = "#$index",
                        color = if (isHovered) Color(0xFF38BDF8) else Color(0xFF64748B),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Cover Art
            val coverUrl = track.extractCoverUrl()
            LiquidGlassBox(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(40.dp)
            ) {
                if (!coverUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = coverUrl,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        Icons.Default.MusicNote,
                        contentDescription = null,
                        tint = Color(0xFF64748B),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(Modifier.width(14.dp))

            // Title & Artist
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = track.title,
                    color = if (isPlaying) Color(0xFF38BDF8) else Color(0xFFF8FAFC),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = track.artists.joinToString(", ") { it.name },
                    color = Color(0xFF94A3B8),
                    fontSize = 11.5.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Quality tag
            LiquidGlassBox(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.60f),
                borderColor = Color.White.copy(alpha = 0.08f)
            ) {
                Text(
                    text = "320 kbps",
                    color = Color(0xFF64748B),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }

            Spacer(Modifier.width(16.dp))

            // Duration
            Text(
                text = formatTrackDuration(track.duration),
                color = Color(0xFF64748B),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.width(42.dp),
                textAlign = TextAlign.End
            )

            Spacer(Modifier.width(12.dp))

            // Quick Actions Hub
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Favorite
                IconButton(
                    onClick = onToggleFavorite,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color(0xFFF43F5E) else Color(0xFF64748B),
                        modifier = Modifier.size(16.dp)
                    )
                }

                // Add to Playlist
                IconButton(
                    onClick = onAddToPlaylist,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.PlaylistAdd,
                        contentDescription = "Add to playlist",
                        tint = Color(0xFF64748B),
                        modifier = Modifier.size(18.dp)
                    )
                }

                // Download
                IconButton(
                    onClick = onDownload,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        Icons.Default.Download,
                        contentDescription = "Download",
                        tint = Color(0xFF64748B),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

private fun formatTrackDuration(durationMs: Long?): String {
    if (durationMs == null || durationMs <= 0) return "--:--"
    val totalSecs = durationMs / 1000
    val m = totalSecs / 60
    val s = totalSecs % 60
    return "${m}:${s.toString().padStart(2, '0')}"
}

// ================================================================================================
// 5. EXTENSION CATEGORY TABS
// ================================================================================================
@Composable
private fun ExtensionCategoryTabs(
    tabs: List<Tab>,
    selectedTab: Tab?,
    onTabSelected: (Tab) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = tabs.indexOfFirst { it.id == selectedTab?.id }.coerceAtLeast(0),
        containerColor = Color.Transparent,
        contentColor = Color.White,
        edgePadding = 0.dp,
        divider = {},
        indicator = {}
    ) {
        for (tab in tabs) {
            val isTabSelected = tab.id == selectedTab?.id
            LiquidGlassBox(
                modifier = Modifier.padding(end = 8.dp),
                shape = RoundedCornerShape(12.dp),
                isSelected = isTabSelected,
                onClick = { onTabSelected(tab) }
            ) {
                Text(
                    text = tab.title,
                    color = if (isTabSelected) Color(0xFFF8FAFC) else Color(0xFF94A3B8),
                    fontSize = 12.sp,
                    fontWeight = if (isTabSelected) FontWeight.SemiBold else FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

// ================================================================================================
// 6. ALGORITHMIC "MADE FOR YOU" PERSONALIZED SHELF
// ================================================================================================
@Composable
private fun SeniorRecommendedShelf(
    libraryManager: DesktopLibraryManager,
    onPlayTrack: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    val favorites by libraryManager.favorites.collectAsState()
    val recommendedTracks = remember(favorites) { libraryManager.getRecommendedTracks() }
    val topArtists = remember(favorites) { libraryManager.getUserFavoriteArtists().take(3) }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        // Shelf Header with Luxury Typography
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Made For You",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF8FAFC),
                        letterSpacing = (-0.3).sp
                    )

                    LiquidGlassBox(
                        shape = RoundedCornerShape(12.dp),
                        backgroundColor = Color(0xFF0C101F).copy(alpha = 0.80f),
                        borderColor = Color(0xFF38BDF8).copy(alpha = 0.40f)
                    ) {
                        Text(
                            text = "Algorithmic Taste",
                            color = Color(0xFF38BDF8),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }

                Text(
                    text = if (topArtists.isNotEmpty()) "Curated from your affinity for ${topArtists.joinToString(", ")}"
                           else "Personalized soundscapes calibrated to your acoustic taste profile",
                    fontSize = 12.5.sp,
                    color = Color(0xFF64748B)
                )
            }

            LiquidGlassBox(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.50f),
                borderColor = Color.White.copy(alpha = 0.08f)
            ) {
                Text(
                    text = "${recommendedTracks.size} Curated Tracks",
                    color = Color(0xFF94A3B8),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                )
            }
        }

        // Horizontal Row of Masterpiece Liquid Music Cards
        LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
            items(recommendedTracks, key = { it.id }) { track ->
                SeniorLiquidMusicCard(
                    track = track,
                    onPlay = { onPlayTrack(track) },
                    onAddToPlaylist = { onAddToPlaylist(track) },
                    onDownload = { onDownloadTrack(track) }
                )
            }
        }
    }
}

// ================================================================================================
// SHELF HIERARCHY NORMALIZER & COMPARATOR
// ================================================================================================
private fun normalizeAndOrderShelves(shelves: List<Shelf>): List<Shelf> {
    fun shelfPriority(shelf: Shelf): Int {
        val title = shelf.title.lowercase()
        val id = shelf.id.lowercase()
        return when {
            title.contains("made for you") || id.contains("made_for_you") -> 10
            title.contains("top songs") || id.contains("top_songs") || title == "top song" -> 20
            title.contains("top playlists") || id.contains("top_playlists") || title == "top playlist" -> 30
            title.contains("top 50") || title.contains("global hit") || id.contains("top_50") -> 40
            title.contains("2026") || id.contains("2026") -> 50
            title.contains("2025") || id.contains("2025") -> 51
            title.contains("2024") || id.contains("2024") -> 52
            title.contains("2023") || id.contains("2023") -> 53
            title.contains("2020s") || id.contains("2020s") -> 54
            title.contains("2010s") || id.contains("2010s") -> 55
            title.contains("2000s") || id.contains("2000s") -> 56
            title.contains("90s") || id.contains("90s") -> 57
            else -> 100
        }
    }
    return shelves.sortedWith(compareBy({ shelfPriority(it) }, { it.title }))
}

// ================================================================================================
// 7. CURATED SOUNDSCAPE SHELVES (12-SHELF HIERARCHICAL FALLBACK)
// ================================================================================================
@Composable
private fun SeniorCuratedSoundscapes(
    onPlayTrack: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    fun makeTrack(id: String, title: String, artist: String, coverUrl: String, durationMs: Long): Track {
        val streamable = Streamable.server(
            id = id,
            quality = 320,
            title = "320 kbps (Master HQ)",
            extras = mapOf(
                "track_title" to title,
                "artist_name" to artist,
                "extension_id" to "youtube_music"
            )
        )
        return Track(
            id = id,
            title = title,
            artists = listOf(Artist(id = artist, name = artist)),
            cover = ImageHolder.NetworkRequestImageHolder(NetworkRequest(coverUrl), false),
            duration = durationMs,
            streamables = listOf(streamable),
            extras = mapOf(
                "track_title" to title,
                "artist_name" to artist
            )
        )
    }

    // 1. Made For You
    val madeForYouTracks = remember {
        listOf(
            makeTrack("mfy_1", "Blinding Lights", "The Weeknd", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 200000L),
            makeTrack("mfy_2", "Cruel Summer", "Taylor Swift", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 178000L),
            makeTrack("mfy_3", "Die With A Smile", "Lady Gaga & Bruno Mars", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 251000L),
            makeTrack("mfy_4", "Birds of a Feather", "Billie Eilish", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 192000L),
            makeTrack("mfy_5", "Chemical", "Post Malone", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 184000L)
        )
    }

    // 2. Top Songs
    val topSongsTracks = remember {
        listOf(
            makeTrack("ts_1", "Espresso", "Sabrina Carpenter", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 175000L),
            makeTrack("ts_2", "Beautiful Things", "Benson Boone", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 180000L),
            makeTrack("ts_3", "I Had Some Help", "Post Malone ft. Morgan Wallen", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 178000L),
            makeTrack("ts_4", "Lose Control", "Teddy Swims", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 210000L),
            makeTrack("ts_5", "Too Sweet", "Hozier", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 251000L)
        )
    }

    // 3. Top Playlists
    val topPlaylistsTracks = remember {
        listOf(
            makeTrack("tpl_1", "Houdini", "Dua Lipa", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 185000L),
            makeTrack("tpl_2", "we can't be friends", "Ariana Grande", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 228000L),
            makeTrack("tpl_3", "360", "Charli xcx", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 133000L),
            makeTrack("tpl_4", "Good Luck, Babe!", "Chappell Roan", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 218000L),
            makeTrack("tpl_5", "MILLION DOLLAR BABY", "Tommy Richman", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 155000L)
        )
    }

    // 4. Top 50 Global Hit Songs
    val top50GlobalTracks = remember {
        listOf(
            makeTrack("g50_1", "Starboy", "The Weeknd ft. Daft Punk", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 230000L),
            makeTrack("g50_2", "As It Was", "Harry Styles", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 167000L),
            makeTrack("g50_3", "Levitating", "Dua Lipa", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 203000L),
            makeTrack("g50_4", "Kill Bill", "SZA", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 153000L),
            makeTrack("g50_5", "Flowers", "Miley Cyrus", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 200000L)
        )
    }

    // 5. 2026 Hits
    val hits2026Tracks = remember {
        listOf(
            makeTrack("h26_1", "Die With A Smile", "Lady Gaga & Bruno Mars", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 251000L),
            makeTrack("h26_2", "Taste", "Sabrina Carpenter", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 157000L),
            makeTrack("h26_3", "Please Please Please", "Sabrina Carpenter", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 186000L),
            makeTrack("h26_4", "Not Like Us", "Kendrick Lamar", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 274000L)
        )
    }

    // 6. 2025 Hits
    val hits2025Tracks = remember {
        listOf(
            makeTrack("h25_1", "Espresso", "Sabrina Carpenter", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 175000L),
            makeTrack("h25_2", "Beautiful Things", "Benson Boone", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 180000L),
            makeTrack("h25_3", "Birds of a Feather", "Billie Eilish", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 192000L),
            makeTrack("h25_4", "A Bar Song (Tipsy)", "Shaboozey", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 171000L)
        )
    }

    // 7. 2024 Hits
    val hits2024Tracks = remember {
        listOf(
            makeTrack("h24_1", "Cruel Summer", "Taylor Swift", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 178000L),
            makeTrack("h24_2", "vampire", "Olivia Rodrigo", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 219000L),
            makeTrack("h24_3", "Paint The Town Red", "Doja Cat", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 231000L),
            makeTrack("h24_4", "greedy", "Tate McRae", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 131000L)
        )
    }

    // 8. 2023 Hits
    val hits2023Tracks = remember {
        listOf(
            makeTrack("h23_1", "Flowers", "Miley Cyrus", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 200000L),
            makeTrack("h23_2", "Kill Bill", "SZA", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 153000L),
            makeTrack("h23_3", "Calm Down", "Rema & Selena Gomez", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 239000L),
            makeTrack("h23_4", "Creepin'", "Metro Boomin, The Weeknd, 21 Savage", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 221000L)
        )
    }

    // 9. 2020s Decade Hits
    val hits2020sTracks = remember {
        listOf(
            makeTrack("h20s_1", "Blinding Lights", "The Weeknd", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 200000L),
            makeTrack("h20s_2", "Don't Start Now", "Dua Lipa", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 183000L),
            makeTrack("h20s_3", "Stay", "The Kid LAROI & Justin Bieber", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 141000L),
            makeTrack("h20s_4", "Heat Waves", "Glass Animals", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 238000L)
        )
    }

    // 10. 2010s Golden Hits
    val hits2010sTracks = remember {
        listOf(
            makeTrack("h10s_1", "Rolling in the Deep", "Adele", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 228000L),
            makeTrack("h10s_2", "Uptown Funk", "Mark Ronson ft. Bruno Mars", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 269000L),
            makeTrack("h10s_3", "Shape of You", "Ed Sheeran", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 233000L),
            makeTrack("h10s_4", "Counting Stars", "OneRepublic", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 257000L)
        )
    }

    // 11. 2000s Millennial Hits
    val hits2000sTracks = remember {
        listOf(
            makeTrack("h00s_1", "In the End", "Linkin Park", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 216000L),
            makeTrack("h00s_2", "Hips Don't Lie", "Shakira ft. Wyclef Jean", "https://c.saavncdn.com/023/Lover-English-2019-20190823144917-500x500.jpg", 218000L),
            makeTrack("h00s_3", "Umbrella", "Rihanna ft. JAY-Z", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 275000L),
            makeTrack("h00s_4", "Hey Ya!", "Outkast", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 235000L)
        )
    }

    // 12. 90s Retro Classics
    val hits90sTracks = remember {
        listOf(
            makeTrack("h90s_1", "Smells Like Teen Spirit", "Nirvana", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 301000L),
            makeTrack("h90s_2", "Wonderwall", "Oasis", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 258000L),
            makeTrack("h90s_3", "Zombie", "The Cranberries", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 306000L),
            makeTrack("h90s_4", "Gangsta's Paradise", "Coolio ft. L.V.", "https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", 240000L)
        )
    }

    Column(verticalArrangement = Arrangement.spacedBy(28.dp)) {
        // 1. Made For You
        SeniorSoundscapeSection(
            title = "Made For You",
            kicker = "ALGORITHMIC PERSONAL MIX // HIGH FIDELITY",
            subtitle = "Personalized algorithmic mix calibrated to your acoustic taste profile",
            tracks = madeForYouTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 2. Top Songs
        SeniorSoundscapeSection(
            title = "Top Songs",
            kicker = "GLOBAL TRENDING // HOTTEST TRACKS",
            subtitle = "Today's most played trending hits worldwide",
            tracks = topSongsTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 3. Top Playlists
        SeniorSoundscapeSection(
            title = "Top Playlists",
            kicker = "VIRAL & CURATED // HIT COMPILATIONS",
            subtitle = "Curated global & viral playlists",
            tracks = topPlaylistsTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 4. Top 50 Global Hit Songs
        SeniorSoundscapeSection(
            title = "Top 50 Global Hit Songs",
            kicker = "STREAMING TITANS // BILLBOARD RECORD BREAKERS",
            subtitle = "The biggest record-breaking streaming hits worldwide",
            tracks = top50GlobalTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 5. 2026 Hits
        SeniorSoundscapeSection(
            title = "2026 Hits",
            kicker = "2026 CHARTS // VIRAL ANTHEMS",
            subtitle = "Current chart anthems & viral tracks of 2026",
            tracks = hits2026Tracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 6. 2025 Hits
        SeniorSoundscapeSection(
            title = "2025 Hits",
            kicker = "2025 SOUNDSCAPES // GLOBAL SMASHES",
            subtitle = "Worldwide smash hits of 2025",
            tracks = hits2025Tracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 7. 2024 Hits
        SeniorSoundscapeSection(
            title = "2024 Hits",
            kicker = "2024 HIGHLIGHTS // TOP ANTHEMS",
            subtitle = "Top global anthems of 2024",
            tracks = hits2024Tracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 8. 2023 Hits
        SeniorSoundscapeSection(
            title = "2023 Hits",
            kicker = "2023 FAVORITES // CHART TOPPERS",
            subtitle = "Chart-topping favorites of 2023",
            tracks = hits2023Tracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 9. 2020s Decade Hits
        SeniorSoundscapeSection(
            title = "2020s Decade Hits",
            kicker = "2020s DEFINITIVE // MODERN CLASSICS",
            subtitle = "The definitive sounds and peak hits of the 2020s",
            tracks = hits2020sTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 10. 2010s Golden Hits
        SeniorSoundscapeSection(
            title = "2010s Golden Hits",
            kicker = "2010s GOLDEN DECADE // MEGA HITS",
            subtitle = "Unforgettable mega-hits from 2010 to 2019",
            tracks = hits2010sTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 11. 2000s Millennial Hits
        SeniorSoundscapeSection(
            title = "2000s Millennial Hits",
            kicker = "2000s MILLENNIAL // ICONIC NOSTALGIA",
            subtitle = "Iconic nostalgia and mega anthems from 2000 to 2009",
            tracks = hits2000sTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )

        // 12. 90s Retro Classics
        SeniorSoundscapeSection(
            title = "90s Retro Classics",
            kicker = "90s RETRO ICONS // TIMELESS LEGENDS",
            subtitle = "Timeless 1990s chartbuster legends",
            tracks = hits90sTracks,
            onPlayTrack = onPlayTrack,
            onAddToPlaylist = onAddToPlaylist,
            onDownloadTrack = onDownloadTrack
        )
    }
}

@Composable
private fun SeniorSoundscapeSection(
    title: String,
    kicker: String,
    subtitle: String,
    tracks: List<Track>,
    onPlayTrack: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = kicker,
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF64748B),
                    letterSpacing = 1.3.sp
                )
                Text(
                    text = title,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF8FAFC),
                    letterSpacing = (-0.3).sp
                )
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = Color(0xFF64748B)
                )
            }

            LiquidGlassBox(
                shape = RoundedCornerShape(16.dp),
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.50f),
                borderColor = Color.White.copy(alpha = 0.08f),
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text("${tracks.size} Tracks", fontSize = 11.sp, color = Color(0xFF94A3B8))
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xFF94A3B8),
                        modifier = Modifier.size(12.dp)
                    )
                }
            }
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
            items(tracks, key = { it.id }) { track ->
                SeniorLiquidMusicCard(
                    track = track,
                    onPlay = { onPlayTrack(track) },
                    onAddToPlaylist = { onAddToPlaylist(track) },
                    onDownload = { onDownloadTrack(track) }
                )
            }
        }
    }
}

// ================================================================================================
// MASTERPIECE SENIOR LIQUID MUSIC CARD COMPONENT (176.dp Grid Card)
// ================================================================================================
@Composable
private fun SeniorLiquidMusicCard(
    track: Track,
    onPlay: () -> Unit,
    onAddToPlaylist: () -> Unit,
    onDownload: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        modifier = Modifier.width(176.dp),
        shape = RoundedCornerShape(18.dp),
        backgroundColor = if (isHovered) Color(0xFF171F36).copy(alpha = 0.80f) else Color(0xFF0F1426).copy(alpha = 0.55f),
        borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.50f) else Color.White.copy(alpha = 0.10f),
        onClick = onPlay
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Square Cover Artwork with Micro-Badge & Floating Glass Play Trigger
            val coverUrl = track.extractCoverUrl()
            LiquidGlassBox(
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.size(152.dp)
            ) {
                if (!coverUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = coverUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(if (isHovered) 1.05f else 1.0f),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        Icons.Default.MusicNote,
                        contentDescription = null,
                        tint = Color(0xFF475569),
                        modifier = Modifier.size(48.dp)
                    )
                }

                // Top-Right Specular 320k Pill directly on artwork
                LiquidGlassBox(
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = Color.Black.copy(alpha = 0.70f),
                    borderColor = Color.White.copy(alpha = 0.18f),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                ) {
                    Text(
                        text = "320k",
                        color = Color(0xFFF1F5F9),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }

                // Hover Scrim & Springy Frosted Circular Play Button
                if (isHovered) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.38f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .shadow(10.dp, CircleShape)
                                .clip(CircleShape)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = "Play",
                                tint = Color(0xFF090A0D),
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }
                }
            }

            // Title & Artist
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = track.title,
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFFF8FAFC),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = track.artists.joinToString(", ") { it.name },
                    fontSize = 11.5.sp,
                    color = Color(0xFF94A3B8),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Bottom Actions: Genre / Studio Tag + Playlist + Download
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
                        text = "STUDIO",
                        color = Color(0xFF64748B),
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onAddToPlaylist,
                        modifier = Modifier.size(26.dp)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.PlaylistAdd,
                            contentDescription = "Add to playlist",
                            tint = if (isHovered) Color(0xFFF1F5F9) else Color(0xFF64748B),
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    IconButton(
                        onClick = onDownload,
                        modifier = Modifier.size(26.dp)
                    ) {
                        Icon(
                            Icons.Default.Download,
                            contentDescription = "Download offline",
                            tint = if (isHovered) Color(0xFFF1F5F9) else Color(0xFF64748B),
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }
            }
        }
    }
}

// ================================================================================================
// ERROR GLASS STATE
// ================================================================================================
@Composable
private fun SeniorErrorGlassState(
    error: Throwable?,
    onRetry: () -> Unit
) {
    LiquidGlassCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(0xFF13172A).copy(alpha = 0.65f)
    ) {
        Column(
            modifier = Modifier.padding(38.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                Icons.Default.ErrorOutline,
                contentDescription = null,
                tint = Color(0xFF94A3B8),
                modifier = Modifier.size(38.dp)
            )
            Text(
                text = "Unable to connect to active feed",
                color = Color(0xFFF8FAFC),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = error?.localizedMessage ?: "Verify internet connection or check extension status",
                color = Color(0xFF64748B),
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF263350),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Retry Feed", fontSize = 12.sp)
            }
        }
    }
}

// ================================================================================================
// AMBIENT SCREENSAVER DELEGATION
// ================================================================================================
@Composable
fun DecentAmbientScreensaver(
    playerViewModel: PlayerViewModel,
    screensaverActivatedAt: Long,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    EchoScreensaver(
        playerViewModel = playerViewModel,
        onWakeUp = onDismiss,
        modifier = modifier,
        screensaverActivatedAt = screensaverActivatedAt
    )
}
