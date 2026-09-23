package dev.brahmkshatriya.echo.desktop.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog
import dev.brahmkshatriya.echo.desktop.ui.components.SleepTimerDialog
import dev.brahmkshatriya.echo.desktop.ui.player.MiniPlayer
import dev.brahmkshatriya.echo.desktop.ui.screens.DownloadsScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.LibraryScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.MediaDetailScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.NowPlayingScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.NowPlayingTab
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.SettingsScreen
import dev.brahmkshatriya.echo.desktop.ui.screensaver.EchoScreensaver
import dev.brahmkshatriya.echo.desktop.ui.theme.EchoTheme
import dev.brahmkshatriya.echo.desktop.viewmodel.DownloadsViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.SettingsViewModel
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import java.io.File

enum class Screen(
    val title: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    SEARCH("Search", Icons.Default.Search),
    LIBRARY("Library", Icons.Default.LibraryMusic),
    DOWNLOADS("Downloads", Icons.Default.Download),
    EXTENSIONS("Extensions", Icons.Default.Extension),
    SETTINGS("Settings", Icons.Default.Settings),
}

@Composable
fun EchoDesktopApp() {
    EchoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val playerViewModel = koinInject<PlayerViewModel>()
            val downloadsViewModel = koinInject<DownloadsViewModel>()
            val settingsViewModel = koinInject<SettingsViewModel>()

            val screensaverTimeoutSec by settingsViewModel.screensaverTimeout.collectAsState()
            var isScreensaverActive by remember { mutableStateOf(false) }
            var lastActivityTime by remember { mutableStateOf(System.currentTimeMillis()) }
            var screensaverActivatedAt by remember { mutableStateOf(0L) }

            var isNowPlayingExpanded by remember { mutableStateOf(false) }
            var nowPlayingInitialTab by remember { mutableStateOf(NowPlayingTab.LYRICS) }

            val showAudioEffectsDialog by playerViewModel.showAudioEffectsDialog.collectAsState()
            val showSleepTimerDialog by playerViewModel.showSleepTimerDialog.collectAsState()
            val isNowPlayingVmExpanded by playerViewModel.isNowPlayingExpanded.collectAsState()

            // Load 3D musical notes background and Audix logo
            val bgBitmap = remember {
                runCatching {
                    val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/music_notes_bg.jpg")
                        ?: File("src/desktopMain/resources/images/music_notes_bg.jpg").takeIf { it.exists() }?.inputStream()
                    stream?.use { loadImageBitmap(it) }
                }.getOrNull()
            }

            val logoBitmap = remember {
                runCatching {
                    val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_logo.png")
                        ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/spothub_logo.png")
                        ?: File("src/desktopMain/resources/images/audix_logo.png").takeIf { it.exists() }?.inputStream()
                        ?: File("src/desktopMain/resources/images/spothub_logo.png").takeIf { it.exists() }?.inputStream()
                    stream?.use { loadImageBitmap(it) }
                }.getOrNull()
            }

            // Global AWT Event listener to detect any mouse movement, click, scroll or key press
            DisposableEffect(isScreensaverActive) {
                val listener = java.awt.event.AWTEventListener { _ ->
                    val now = System.currentTimeMillis()
                    if (isScreensaverActive) {
                        // Debounce: only wake up if screensaver was active for > 400ms
                        if (now - screensaverActivatedAt > 400L) {
                            isScreensaverActive = false
                            lastActivityTime = now
                        }
                    } else {
                        lastActivityTime = now
                    }
                }

                val mask = java.awt.AWTEvent.MOUSE_MOTION_EVENT_MASK or
                        java.awt.AWTEvent.MOUSE_EVENT_MASK or
                        java.awt.AWTEvent.KEY_EVENT_MASK or
                        java.awt.AWTEvent.MOUSE_WHEEL_EVENT_MASK

                runCatching {
                    java.awt.Toolkit.getDefaultToolkit().addAWTEventListener(listener, mask)
                }

                onDispose {
                    runCatching {
                        java.awt.Toolkit.getDefaultToolkit().removeAWTEventListener(listener)
                    }
                }
            }

            // Inactivity timer loop: launches screensaver if idle >= screensaverTimeoutSec (default 10s)
            LaunchedEffect(isScreensaverActive, screensaverTimeoutSec) {
                if (screensaverTimeoutSec > 0 && !isScreensaverActive) {
                    while (true) {
                        delay(500)
                        val idleMs = System.currentTimeMillis() - lastActivityTime
                        if (idleMs >= screensaverTimeoutSec * 1000L) {
                            screensaverActivatedAt = System.currentTimeMillis()
                            isScreensaverActive = true
                            break
                        }
                    }
                }
            }

            Box(Modifier.fillMaxSize()) {
                // 1. Music Notes Wallpaper Background
                if (bgBitmap != null) {
                    Image(
                        bitmap = bgBitmap,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    // Sleek dark glass scrim overlay for contrast & readability
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFF080614).copy(alpha = 0.35f))
                    )
                }

                Column(Modifier.fillMaxSize()) {
                    // Main content area: rail + content
                    Row(Modifier.weight(1f).fillMaxWidth()) {
                        var selectedScreen by remember { mutableStateOf(Screen.HOME) }
                        var activeMediaDetail by remember { mutableStateOf<EchoMediaItem?>(null) }

                        // Left navigation rail
                        EchoNavigationRail(
                            selectedScreen = selectedScreen,
                            logoBitmap = logoBitmap,
                            onScreenSelected = {
                                selectedScreen = it
                                activeMediaDetail = null
                            },
                            onLaunchScreensaver = {
                                screensaverActivatedAt = System.currentTimeMillis()
                                isScreensaverActive = true
                            }
                        )

                        // Main content
                        Box(Modifier.weight(1f).fillMaxHeight()) {
                            val currentMedia = activeMediaDetail
                            if (currentMedia != null) {
                                MediaDetailScreen(
                                    media = currentMedia,
                                    onBack = { activeMediaDetail = null },
                                    onMediaSelected = { activeMediaDetail = it }
                                )
                            } else {
                                when (selectedScreen) {
                                    Screen.HOME -> HomeScreen(onMediaSelected = { activeMediaDetail = it })
                                    Screen.SEARCH -> SearchScreen(onMediaSelected = { activeMediaDetail = it })
                                    Screen.LIBRARY -> LibraryScreen()
                                    Screen.DOWNLOADS -> DownloadsScreen()
                                    Screen.EXTENSIONS -> ExtensionsScreen()
                                    Screen.SETTINGS -> SettingsScreen()
                                }
                            }
                        }
                    }

                    // Bottom player bar — always visible
                    HorizontalDivider(color = Color.White.copy(alpha = 0.08f))
                    MiniPlayer(
                        viewModel = playerViewModel,
                        onExpandNowPlaying = { tab ->
                            nowPlayingInitialTab = tab
                            isNowPlayingExpanded = true
                            playerViewModel.openNowPlaying()
                        },
                        onDownloadTrack = { track ->
                            downloadsViewModel.downloadTrack(track)
                        }
                    )
                }

                // Full Now Playing overlay (Lyrics, Audio specs, Queue)
                if (isNowPlayingExpanded || isNowPlayingVmExpanded) {
                    NowPlayingScreen(
                        onClose = {
                            isNowPlayingExpanded = false
                            playerViewModel.closeNowPlaying()
                        },
                        initialTab = nowPlayingInitialTab
                    )
                }

                // Global Audio Effects / Equalizer Modal
                if (showAudioEffectsDialog) {
                    AudioEffectsDialog(
                        viewModel = playerViewModel,
                        onDismiss = { playerViewModel.closeAudioEffectsDialog() }
                    )
                }

                // Global Sleep Timer Modal
                if (showSleepTimerDialog) {
                    SleepTimerDialog(
                        viewModel = playerViewModel,
                        onDismiss = { playerViewModel.closeSleepTimerDialog() }
                    )
                }

                // Futuristic Acoustic Glass Screensaver Overlay
                AnimatedVisibility(
