package dev.brahmkshatriya.echo.desktop.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassCard
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.ui.player.MiniPlayer
import dev.brahmkshatriya.echo.desktop.ui.screens.DownloadsScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.HeavyRotationScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.LibraryScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen
import dev.brahmkshatriya.echo.desktop.ui.screens.SettingsScreen
import dev.brahmkshatriya.echo.desktop.ui.screensaver.EchoScreensaver
import dev.brahmkshatriya.echo.desktop.ui.theme.EchoTheme
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import java.io.File
import java.awt.Toolkit
import java.awt.AWTEvent
import java.awt.event.AWTEventListener
import java.awt.event.MouseEvent
import java.awt.event.KeyEvent
import java.awt.MouseInfo
import java.awt.Window

enum class Screen(
    val title: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    ROTATION("Rotation", Icons.Default.Whatshot),
    SEARCH("Search", Icons.Default.Search),
    LIBRARY("Library", Icons.Default.LibraryMusic),
    DOWNLOADS("Downloads", Icons.Default.Download),
    EXTENSIONS("Extensions", Icons.Default.Extension),
    SETTINGS("Settings", Icons.Default.Settings),
}

private var cachedBgBitmap: ImageBitmap? = null
private var cachedAppLogoBitmap: ImageBitmap? = null

object UiZoomManager {
    var zoomScale by mutableStateOf(0.90f)
}

@Composable
fun EchoDesktopApp() {
    val currentDensity = LocalDensity.current
    val scaledDensity = remember(currentDensity, UiZoomManager.zoomScale) {
        Density(
            density = currentDensity.density * UiZoomManager.zoomScale,
            fontScale = currentDensity.fontScale
        )
    }

    CompositionLocalProvider(LocalDensity provides scaledDensity) {
        EchoTheme {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF070913))
            ) {
            val playerViewModel = koinInject<PlayerViewModel>()
            val settings = runCatching { koinInject<EchoSettings>() }.getOrNull()

            var isScreensaverActive by remember { mutableStateOf(false) }
            var lastActivityTime by remember { mutableStateOf(System.currentTimeMillis()) }
            var screensaverActivatedAt by remember { mutableStateOf(0L) }
            var isMouseInsideApp by remember { mutableStateOf(true) }
            var mouseExitedAt by remember { mutableStateOf(0L) }
            var lastPointerPosition by remember { mutableStateOf(Offset.Zero) }
            var screensaverStartPointerPosition by remember { mutableStateOf(Offset.Zero) }

            val launchScreensaver: () -> Unit = {
                mouseExitedAt = 0L
                screensaverActivatedAt = System.currentTimeMillis()
                screensaverStartPointerPosition = lastPointerPosition
                isScreensaverActive = true
            }

            // Load custom background wallpaper image and Audix logo with in-memory caching
            val bgBitmap = remember {
                cachedBgBitmap ?: runCatching {
                    val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_bg.jpg")
                        ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/music_notes_bg.jpg")
                        ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
                        ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
                        ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "music_notes_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
                    stream?.use { loadImageBitmap(it) }
                }.getOrNull()?.also { cachedBgBitmap = it }
            }

            val logoBitmap = remember {
                cachedAppLogoBitmap ?: runCatching {
                    val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_logo.png")
                        ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/spothub_logo.png")
                        ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "audix_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                        ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "spothub_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                    stream?.use { loadImageBitmap(it) }
                }.getOrNull()?.also { cachedAppLogoBitmap = it }
            }

            // Global AWT Event listener to detect any mouse movement, click, scroll or key press
            DisposableEffect(isScreensaverActive) {
                val listener = AWTEventListener { event ->
                    val now = System.currentTimeMillis()
                    when (event.id) {
                        MouseEvent.MOUSE_ENTERED -> {
                            isMouseInsideApp = true
                            mouseExitedAt = 0L
                            lastActivityTime = now
                        }
                        MouseEvent.MOUSE_EXITED -> {
                            isMouseInsideApp = false
                            mouseExitedAt = now
                        }
                        MouseEvent.MOUSE_PRESSED, MouseEvent.MOUSE_CLICKED -> {
                            lastActivityTime = now
                        }
                        KeyEvent.KEY_PRESSED -> {
                            lastActivityTime = now
                            if (isScreensaverActive && now - screensaverActivatedAt > 400L) {
                                isScreensaverActive = false
                                mouseExitedAt = 0L
                            }
                        }
                        MouseEvent.MOUSE_MOVED, MouseEvent.MOUSE_DRAGGED -> {
                            if (event is MouseEvent) {
                                val curPt = runCatching {
                                    Offset(event.xOnScreen.toFloat(), event.yOnScreen.toFloat())
                                }.getOrNull()
                                if (curPt != null) {
                                    val dx = curPt.x - lastPointerPosition.x
                                    val dy = curPt.y - lastPointerPosition.y

                                    // Ignore optical sensor micro-jitter (< 10px distance)
                                    if (dx * dx + dy * dy > 100f) {
                                        lastPointerPosition = curPt
                                        lastActivityTime = now
                                        isMouseInsideApp = true

                                        // Wake from screensaver on deliberate movement (> 30px from activation)
                                        if (isScreensaverActive && now - screensaverActivatedAt > 600L) {
                                            val wakeDx = curPt.x - screensaverStartPointerPosition.x
                                            val wakeDy = curPt.y - screensaverStartPointerPosition.y
                                            if (wakeDx * wakeDx + wakeDy * wakeDy > 900f) {
                                                isScreensaverActive = false
                                                mouseExitedAt = 0L
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                val mask = AWTEvent.MOUSE_MOTION_EVENT_MASK or
                        AWTEvent.MOUSE_EVENT_MASK or
                        AWTEvent.KEY_EVENT_MASK or
                        AWTEvent.MOUSE_WHEEL_EVENT_MASK

                runCatching {
                    Toolkit.getDefaultToolkit().addAWTEventListener(listener, mask)
                }

                onDispose {
                    runCatching {
                        Toolkit.getDefaultToolkit().removeAWTEventListener(listener)
                    }
                }
            }

            // Hardware-polled monitor loop running continuously
            LaunchedEffect(Unit) {
                while (true) {
                    delay(200)
                    val now = System.currentTimeMillis()

                    // 1. Physically check if pointer is inside any visible application window
                    val mousePt = runCatching { MouseInfo.getPointerInfo()?.location }.getOrNull()
                    val isPhysicallyInside = if (mousePt != null) {
                        runCatching {
                            Window.getWindows().any { w -> w.isShowing && w.bounds.contains(mousePt) }
                        }.getOrDefault(isMouseInsideApp)
                    } else {
                        isMouseInsideApp
                    }

                    // Sync mouse state
                    if (isPhysicallyInside) {
                        if (!isMouseInsideApp) {
                            // Pointer entered the application window!
                            isMouseInsideApp = true
                            lastActivityTime = now
                        }
                    } else {
                        if (isMouseInsideApp) {
                            // Pointer just left the application window!
                            isMouseInsideApp = false
                            mouseExitedAt = now
                        }
                    }

                    // 2. Hardware motion detection (jitter rejection > 10px)
                    if (mousePt != null) {
                        val curX = mousePt.x.toFloat()
                        val curY = mousePt.y.toFloat()
                        val dx = curX - lastPointerPosition.x
                        val dy = curY - lastPointerPosition.y
                        if (dx * dx + dy * dy > 100f) {
                            lastPointerPosition = Offset(curX, curY)
                            lastActivityTime = now
                        }
                    }

                    // 3. Screen saver activation conditions
                    if (!isScreensaverActive) {
                        val mouseExitEnabled = settings?.getBoolean("screensaver_mouse_exit", true) ?: true
                        // Condition A: Cursor is outside the app for >= 2.5s ("dont bring the mouse in the app")
                        if (mouseExitEnabled && !isMouseInsideApp && mouseExitedAt > 0L) {
                            val outsideDuration = now - mouseExitedAt
                            if (outsideDuration >= 2500L) {
                                launchScreensaver()
                            }
                        }

                        // Condition B: User doesn't click or interact for >= timeout ("when the user dont click")
                        val timeoutSecs = settings?.getInt("screensaver_timeout", 60) ?: 60
                        if (timeoutSecs > 0) {
                            val idleTimeoutMs = (timeoutSecs * 1000L).coerceAtLeast(5000L)
                            val idleDuration = now - lastActivityTime
                            if (idleDuration >= idleTimeoutMs) {
                                launchScreensaver()
                            }
                        }
                    }
                }
            }

            Box(Modifier.fillMaxSize()) {
                // 1. Sleek Gradient Noise Background Image across whole application
                if (bgBitmap != null) {
                    Image(
                        bitmap = bgBitmap,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    // Ultra-subtle deep film-vignette glaze for high text readability
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFF04060A).copy(alpha = 0.12f))
                    )
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize().background(Color(0xFF090B12))
                    )
                }

                Column(Modifier.fillMaxSize()) {
                    // Floating Workstation Row
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 6.dp)
                    ) {
                        var selectedScreen by remember { mutableStateOf(Screen.HOME) }

                        // 1. Floating Liquid-Glass Navigation Rail Island
                        LiquidGlassCard(
                            shape = RoundedCornerShape(22.dp),
                            modifier = Modifier.width(82.dp).fillMaxHeight()
                        ) {
                            EchoNavigationRail(
                                selectedScreen = selectedScreen,
                                logoBitmap = logoBitmap,
                                onScreenSelected = {
                                    selectedScreen = it
                                },
                                onLaunchScreensaver = launchScreensaver
                            )
                        }

                        Spacer(Modifier.width(10.dp))

                        // 2. Floating Liquid-Glass Workstation Viewport Island
                        LiquidGlassCard(
                            shape = RoundedCornerShape(22.dp),
                            modifier = Modifier.weight(1f).fillMaxHeight()
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                when (selectedScreen) {
                                    Screen.HOME -> HomeScreen(onLaunchScreensaver = launchScreensaver)
                                    Screen.ROTATION -> HeavyRotationScreen(playerViewModel = playerViewModel, onLaunchScreensaver = launchScreensaver)
                                    Screen.SEARCH -> SearchScreen()
                                    Screen.LIBRARY -> LibraryScreen()
                                    Screen.DOWNLOADS -> DownloadsScreen()
                                    Screen.EXTENSIONS -> ExtensionsScreen()
                                    Screen.SETTINGS -> SettingsScreen(onLaunchScreensaver = launchScreensaver)
                                }
                            }
                        }
                    }

                    // 3. Floating Liquid-Glass MiniPlayer Dock Island
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 4.dp)
                    ) {
                        MiniPlayer(
                            viewModel = playerViewModel,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Ambient Screensaver Overlay
                AnimatedVisibility(
                    visible = isScreensaverActive,
                    enter = fadeIn(tween(400)),
                    exit = fadeOut(tween(300))
                ) {
                    EchoScreensaver(
                        playerViewModel = playerViewModel,
                        screensaverActivatedAt = screensaverActivatedAt,
                        settings = settings,
                        onWakeUp = {
                            isScreensaverActive = false
                            mouseExitedAt = 0L
                            lastActivityTime = System.currentTimeMillis()
                        }
                    )
                }
            }
        }
    }
}
}

@Composable
fun EchoNavigationRail(
    selectedScreen: Screen,
    logoBitmap: ImageBitmap? = null,
    onScreenSelected: (Screen) -> Unit,
    onLaunchScreensaver: () -> Unit = {}
) {
    NavigationRail(
        modifier = Modifier.width(80.dp).fillMaxHeight(),
        containerColor = Color.Transparent
    ) {
        if (logoBitmap != null) {
            LiquidGlassBox(
                shape = CircleShape,
                modifier = Modifier.size(40.dp)
            ) {
                Image(
                    bitmap = logoBitmap,
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize().clip(CircleShape)
                )
            }
            Spacer(Modifier.height(12.dp))
        }

        Screen.entries.forEach { screen ->
            NavigationRailItem(
                selected = selectedScreen == screen,
                onClick = { onScreenSelected(screen) },
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title, fontSize = 11.sp) },
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color.White.copy(alpha = 0.18f),
                    unselectedIconColor = Color.White.copy(alpha = 0.65f),
                    unselectedTextColor = Color.White.copy(alpha = 0.65f)
                )
            )
        }

        Spacer(Modifier.weight(1f))

        LiquidGlassBox(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.size(42.dp),
            contentAlignment = Alignment.Center,
            onClick = onLaunchScreensaver
        ) {
            Icon(
                Icons.Default.Tv,
                contentDescription = "Ambient Screensaver",
                tint = Color(0xFF94A3B8),
                modifier = Modifier.size(20.dp).align(Alignment.Center)
            )
        }
        Spacer(Modifier.height(12.dp))
    }
}
