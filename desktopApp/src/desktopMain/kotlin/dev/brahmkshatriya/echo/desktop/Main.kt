package dev.brahmkshatriya.echo.desktop

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isAltPressed
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.isTraySupported
import androidx.compose.ui.window.rememberWindowState
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.network.okhttp.OkHttpNetworkFetcherFactory
import coil3.request.crossfade
import coil3.svg.SvgDecoder
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import dev.brahmkshatriya.echo.core.platform.AudioPlayer
import dev.brahmkshatriya.echo.desktop.di.desktopModule
import dev.brahmkshatriya.echo.desktop.platform.WindowsMediaKeys
import dev.brahmkshatriya.echo.desktop.ui.EchoDesktopApp
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import okhttp3.OkHttpClient
import okio.Path.Companion.toOkioPath
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.getKoin
import java.io.File
import java.time.LocalDateTime

private object EchoTrayPainter : Painter() {
    override val intrinsicSize: Size = Size(32f, 32f)
    override fun DrawScope.onDraw() {
        drawCircle(Color(0xFF6750A4), radius = size.minDimension / 2f)
    }
}

@Volatile
private var activeWindow: java.awt.Window? = null
private var cachedLogoPainter: Painter? = null

private interface WindowsKernel32MemoryTrimmer : com.sun.jna.Library {
    fun GetCurrentProcess(): com.sun.jna.Pointer
    fun SetProcessWorkingSetSize(hProcess: com.sun.jna.Pointer, dwMinimumWorkingSetSize: Long, dwMaximumWorkingSetSize: Long): Boolean

    companion object {
        val INSTANCE: WindowsKernel32MemoryTrimmer? by lazy {
            runCatching {
                if (System.getProperty("os.name")?.contains("Windows", ignoreCase = true) == true) {
                    com.sun.jna.Native.load("kernel32", WindowsKernel32MemoryTrimmer::class.java)
                } else null
            }.getOrNull()
        }

        fun trimMemory() {
            runCatching {
                val trimmer = INSTANCE ?: return
                val handle = trimmer.GetCurrentProcess()
                trimmer.SetProcessWorkingSetSize(handle, -1L, -1L)
            }
        }
    }
}


fun main() {
    val logFile = File(System.getProperty("user.home"), "audix_desktop.log")
    runCatching {
        if (logFile.exists() && logFile.length() > 5 * 1024 * 1024) {
            val backup = File(System.getProperty("user.home"), "audix_desktop.log.1")
            if (backup.exists()) backup.delete()
            logFile.renameTo(backup)
        }
    }
    val logWriter = runCatching {
        java.io.PrintWriter(java.io.BufferedWriter(java.io.FileWriter(logFile, true)), true)
    }.getOrNull()

    val sensitiveRegex = Regex("""(?i)(token|client_secret|client_id|auth|key|password|credential)=([^\s&"'>]+)""")
    fun sanitizeLog(message: String): String {
        return message.replace(sensitiveRegex) { mr ->
            "${mr.groupValues[1]}=***REDACTED***"
        }
    }

    fun log(message: String) {
        val entry = "[${LocalDateTime.now()}] ${sanitizeLog(message)}"
        runCatching {
            logWriter?.println(entry)
            logWriter?.flush()
        }
        System.out.println(entry)
    }

    runCatching {
        val teeOut = object : java.io.PrintStream(System.out) {
            override fun println(x: String?) {
                val clean = sanitizeLog(x ?: "")
                logWriter?.println("[${LocalDateTime.now()}] [STDOUT] $clean")
                logWriter?.flush()
                super.println(clean)
            }
            override fun println(x: Any?) {
                println(x?.toString())
            }
        }
        val teeErr = object : java.io.PrintStream(System.err) {
            override fun println(x: String?) {
                val clean = sanitizeLog(x ?: "")
                logWriter?.println("[${LocalDateTime.now()}] [STDERR] $clean")
                logWriter?.flush()
                super.println(clean)
            }
            override fun println(x: Any?) {
                println(x?.toString())
            }
        }
        System.setOut(teeOut)
        System.setErr(teeErr)
    }

    log("Audix Desktop initializing...")

    val singleInstancePort = 49876
    var instanceHandedOver = false
    val dataDir = File(System.getProperty("user.home"), ".echo_audix_data").apply { mkdirs() }
    val tokenFile = File(dataDir, "session.token")

    try {
        if (tokenFile.exists() && tokenFile.length() > 0) {
            val existingToken = tokenFile.readText().trim()
            if (existingToken.isNotBlank()) {
                java.net.Socket().use { testSocket ->
                    testSocket.connect(java.net.InetSocketAddress(java.net.InetAddress.getLoopbackAddress(), singleInstancePort), 300)
                    testSocket.soTimeout = 1500
                    val out = java.io.PrintWriter(testSocket.getOutputStream(), true)
                    val reader = java.io.BufferedReader(java.io.InputStreamReader(testSocket.getInputStream()))
                    out.println("SHOW $existingToken")
                    val resp = reader.readLine()
                    if (resp == "ACK") {
                        log("Existing Audix instance authenticated with session token. Handing over and exiting duplicate launcher.")
                        instanceHandedOver = true
                    } else {
                        log("Existing socket rejected handshake or replied with '$resp'. Proceeding with primary launch.")
                    }
                }
            }
        }
    } catch (_: Exception) {
        // Port free or previous instance unreachable
    }

    if (instanceHandedOver) {
        kotlin.system.exitProcess(0)
    }

    val sessionSecret = java.util.UUID.randomUUID().toString()
    runCatching {
        tokenFile.writeText(sessionSecret)
        tokenFile.setReadable(false, false)
        tokenFile.setReadable(true, true)
        tokenFile.setWritable(false, false)
        tokenFile.setWritable(true, true)
    }

    val instanceServer = runCatching {
        java.net.ServerSocket(singleInstancePort, 10, java.net.InetAddress.getLoopbackAddress())
    }.getOrElse { err ->
        log("Notice: Single-instance port $singleInstancePort busy or restricted (${err.message}). Proceeding.")
        null
    }

    Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
        log("FATAL uncaught exception in thread ${thread.name}: ${throwable.stackTraceToString()}")
        runCatching {
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error: ${throwable.message}\n\nCheck log: ${logFile.absolutePath}",
                "Audix Music Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
            )
        }
    }

    try {
        log("Starting Koin...")
        startKoin {
            modules(desktopModule)
        }
        log("Koin started successfully")
    } catch (e: Throwable) {
        log("Koin initialization failed: ${e.stackTraceToString()}")
        throw e
    }

    val koin = getKoin()
    val platform = koin.get<AppPlatform>()
    val audioPlayer = koin.get<AudioPlayer>()
    val mediaKeys = koin.get<WindowsMediaKeys>()
    val playerViewModel = koin.get<PlayerViewModel>()
    val extensionManager = koin.get<dev.brahmkshatriya.echo.core.extensions.ExtensionManager>()
    val echoSettings = koin.get<dev.brahmkshatriya.echo.core.settings.EchoSettings>()

    log("Initializing Desktop Managers (Library & Downloads)...")
    val libraryManager = dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager.getInstance(platform, extensionManager)
    val downloadManager = dev.brahmkshatriya.echo.desktop.download.DesktopDownloadManager.getInstance(playerViewModel, echoSettings, platform)
    runCatching {
        val extraModule = org.koin.dsl.module {
            single<PlayerViewModel> { playerViewModel }
            single { libraryManager }
            single { downloadManager }
            single { dev.brahmkshatriya.echo.desktop.viewmodel.LyricsViewModel(get(), get(), get()) }
        }
        koin.loadModules(listOf(extraModule), allowOverride = true)
        log("Registered singleton PlayerViewModel, DesktopLibraryManager, DesktopDownloadManager & LyricsViewModel into Koin container")
    }.onFailure {
        log("Failed to register extra modules: ${it.stackTraceToString()}")
    }

    log("Initializing DesktopBackgroundManager...")
    runCatching {
        dev.brahmkshatriya.echo.desktop.ui.DesktopBackgroundManager.initialize(echoSettings)
        log("DesktopBackgroundManager initialized successfully")
    }.onFailure {
        log("DesktopBackgroundManager init failed: ${it.stackTraceToString()}")
    }

    log("Initializing Coil...")
    runCatching {
        val sharedImageClient = OkHttpClient.Builder()
            .connectTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(20, java.util.concurrent.TimeUnit.SECONDS)
            .connectionPool(okhttp3.ConnectionPool(24, 5, java.util.concurrent.TimeUnit.MINUTES))
            .followRedirects(true)
            .build()

        SingletonImageLoader.setSafe {
            ImageLoader.Builder(it)
                .components {
                    add(OkHttpNetworkFetcherFactory(sharedImageClient))
                    add(SvgDecoder.Factory())
                }
                .memoryCache {
                    MemoryCache.Builder()
                        .maxSizeBytes(67_108_864L) // 128MB
                        .build()
                }
                .diskCache {
                    DiskCache.Builder()
                        .directory(platform.cacheDir.resolve("images").toFile().toOkioPath())
                        .maxSizeBytes(262_144_000L) // 250MB
                        .build()
                }
                .crossfade(true)
                .build()
        }
        log("Coil initialized with 25% RAM memoryCache and 250MB diskCache")
    }.onFailure {
        log("Coil initialization warning: ${it.stackTraceToString()}")
    }

    log("Launching Compose Desktop application...")
    application(exitProcessOnExit = true) {
        log("Inside application {} block")

        val windowVisibleState = remember { mutableStateOf(true) }
        val windowState = rememberWindowState(
            width = 1652.dp,
            height = 903.dp,
            position = WindowPosition.Aligned(Alignment.Center),
            placement = WindowPlacement.Floating
        )

        // Strictly enforce medium floating window: block fullscreen and maximized states
        LaunchedEffect(windowState.placement) {
            if (windowState.placement != WindowPlacement.Floating) {
                log("Blocked non-floating placement (${windowState.placement}). Reverting to WindowPlacement.Floating")
                windowState.placement = WindowPlacement.Floating
            }
        }

        // Strictly enforce 1652.dp width x 903.dp height as the absolute maximum length and breadth
        LaunchedEffect(windowState.size) {
            val maxWidth = 1652.dp
            val maxHeight = 903.dp
            if (windowState.size.width > maxWidth || windowState.size.height > maxHeight) {
                log("Window size exceeded limit (${windowState.size}), clamping to ${maxWidth}x${maxHeight}")
                windowState.size = DpSize(
                    width = windowState.size.width.coerceAtMost(maxWidth),
                    height = windowState.size.height.coerceAtMost(maxHeight)
                )
            }
        }

        DisposableEffect(Unit) {
            log("Starting WindowsMediaKeys listener...")
            mediaKeys.start()

            val ipcExecutor = java.util.concurrent.Executors.newFixedThreadPool(2) { r ->
                Thread(r, "Audix-IPC-Worker").apply { isDaemon = true }
            }

            val listenerThread = if (instanceServer != null) {
                Thread {
                    try {
                        while (!instanceServer.isClosed) {
                            val client = instanceServer.accept()
                            ipcExecutor.submit {
                                try {
                                    client.soTimeout = 1000
                                    val reader = client.getInputStream().bufferedReader()
                                    val writer = java.io.PrintWriter(client.getOutputStream(), true)
                                    val charBuf = CharArray(512)
                                    val charsRead = reader.read(charBuf, 0, 512)
                                    val line = if (charsRead > 0) String(charBuf, 0, charsRead).lineSequence().firstOrNull()?.trim() ?: "" else ""
                                    val incomingSecret = line.removePrefix("SHOW ").trim()
                                    val isSecretMatch = java.security.MessageDigest.isEqual(
                                        incomingSecret.toByteArray(Charsets.UTF_8),
                                        sessionSecret.toByteArray(Charsets.UTF_8)
                                    )
                                    if (line.startsWith("SHOW ") && isSecretMatch) {
                                        log("Received authenticated SHOW signal. Restoring and focusing window.")
                                        javax.swing.SwingUtilities.invokeLater {
                                            windowVisibleState.value = true
                                            windowState.isMinimized = false
                                            activeWindow?.let { win ->
                                                win.isVisible = true
                                                if (win is java.awt.Frame) {
                                                    win.extendedState = java.awt.Frame.NORMAL
                                                }
                                                win.isAlwaysOnTop = true
                                                win.toFront()
                                                win.isAlwaysOnTop = false
                                                win.requestFocus()
                                            }
                                        }
                                        writer.println("ACK")
                                    } else {
                                        writer.println("REJECTED")
                                    }
                                } catch (_: Exception) {
                                } finally {
                                    runCatching { client.close() }
                                }
                            }
                        }
                    } catch (_: Exception) {}
                }.apply {
                    isDaemon = true
                    name = "Audix-SingleInstanceListener"
                    start()
                }
            } else null

            val shutdownHook = Thread {
                log("JVM Shutdown Hook executing...")
                runCatching { instanceServer?.close() }
                runCatching { ipcExecutor.shutdownNow() }
                runCatching { tokenFile.delete() }
                runCatching { mediaKeys.stop() }
                runCatching { audioPlayer.release() }
                runCatching { logWriter?.flush(); logWriter?.close() }
            }
            runCatching { Runtime.getRuntime().addShutdownHook(shutdownHook) }

            onDispose {
                log("Stopping WindowsMediaKeys listener and releasing audio player...")
                runCatching { Runtime.getRuntime().removeShutdownHook(shutdownHook) }
                runCatching { instanceServer?.close() }
                runCatching { ipcExecutor.shutdownNow() }
                runCatching { tokenFile.delete() }
                runCatching { mediaKeys.stop() }
                runCatching { audioPlayer.release() }
            }
        }

        val logoPainter = remember {
            cachedLogoPainter ?: runCatching {
                val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_logo.png")
                    ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/spothub_logo.png")
                    ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "audix_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                    ?: java.nio.file.Paths.get("src", "desktopMain", "resources", "images", "spothub_logo.png").toFile().takeIf { it.exists() }?.inputStream()
                stream?.use { javax.imageio.ImageIO.read(it)?.toComposeImageBitmap() }?.let { androidx.compose.ui.graphics.painter.BitmapPainter(it) }
            }.getOrNull()?.also { cachedLogoPainter = it } ?: EchoTrayPainter
        }

        log("Checking isTraySupported...")
        val traySupported = runCatching { isTraySupported }.getOrDefault(false)
        log("isTraySupported result: $traySupported")

        if (traySupported) {
            log("Configuring Tray...")
            Tray(
                icon = logoPainter,
                tooltip = "Audix Music",
                onAction = {
                    windowVisibleState.value = true
                    windowState.isMinimized = false
                    activeWindow?.let { win ->
                        win.isVisible = true
                        if (win is java.awt.Frame) {
                            win.extendedState = java.awt.Frame.NORMAL
                        }
                        win.isAlwaysOnTop = true
                        win.toFront()
                        win.isAlwaysOnTop = false
                        win.requestFocus()
                    }
                },
                menu = {
                    Item("Show Audix", onClick = {
                        windowVisibleState.value = true
                        windowState.isMinimized = false
                        activeWindow?.let { win ->
                            win.isVisible = true
                            if (win is java.awt.Frame) {
                                win.extendedState = java.awt.Frame.NORMAL
                            }
                            win.isAlwaysOnTop = true
                            win.toFront()
                            win.isAlwaysOnTop = false
                            win.requestFocus()
                        }
                    })
                    Item("Play / Pause", onClick = { playerViewModel.togglePlayPause() })
                    Item("Next", onClick = { playerViewModel.skipNext() })
                    Item("Previous", onClick = { playerViewModel.skipPrevious() })
                    Separator()
                    Item("Exit", onClick = {
                        log("Tray Exit requested...")
                        runCatching { instanceServer?.close() }
                        runCatching { audioPlayer.stop() }
                        runCatching { audioPlayer.release() }
                        exitApplication()
                        kotlin.system.exitProcess(0)
                    })
                }
            )
            log("Tray configured")
        }

        log("Invoking Window composable...")
        Window(
            visible = windowVisibleState.value,
            onCloseRequest = {
                log("Window onCloseRequest triggered (traySupported=$traySupported)")
                val minimizeToTray = runCatching {
                    koin.get<dev.brahmkshatriya.echo.core.settings.EchoSettings>().getBoolean("minimize_to_tray_on_close", false)
                }.getOrDefault(false)

                if (minimizeToTray && traySupported) {
                    windowVisibleState.value = false
                } else {
                    log("Cleanly shutting down Audix on window close...")
                    runCatching { instanceServer?.close() }
                    runCatching { audioPlayer.stop() }
                    runCatching { audioPlayer.release() }
                    exitApplication()
                    kotlin.system.exitProcess(0)
                }
            },
            title = "Audix v1.0.3-UNIFIED",
            icon = logoPainter,
            state = windowState,
            resizable = false,
            onKeyEvent = { keyEvent ->
                if (keyEvent.type == KeyEventType.KeyDown) {
                    when {
                        // Strictly block F11 fullscreen trigger
                        keyEvent.key == Key.F11 -> {
                            true
                        }

                        // Media keys (work globally)
                        keyEvent.key == Key.MediaPlayPause || keyEvent.key == Key.MediaPlay || keyEvent.key == Key.MediaPause -> {
                            playerViewModel.togglePlayPause()
                            true
                        }
                        keyEvent.key == Key.MediaNext -> {
                            playerViewModel.skipNext()
                            true
                        }
                        keyEvent.key == Key.MediaPrevious -> {
                            playerViewModel.skipPrevious()
                            true
                        }
                        keyEvent.key == Key.MediaStop -> {
                            playerViewModel.stop()
                            true
                        }

                        // Space: Play / Pause
                        keyEvent.key == Key.Spacebar -> {
                            playerViewModel.togglePlayPause()
                            true
                        }

                        // Left / Right Arrow: Seek backward / forward 5s (or skip if with Ctrl)
                        keyEvent.key == Key.DirectionLeft -> {
                            if (keyEvent.isCtrlPressed) {
                                playerViewModel.skipPrevious()
                            } else {
                                playerViewModel.seekRelative(-5000L)
                            }
                            true
                        }
                        keyEvent.key == Key.DirectionRight -> {
                            if (keyEvent.isCtrlPressed) {
                                playerViewModel.skipNext()
                            } else {
                                playerViewModel.seekRelative(5000L)
                            }
                            true
                        }

                        // Up / Down Arrow: Volume +/- 5%
                        keyEvent.key == Key.DirectionUp -> {
                            playerViewModel.adjustVolume(0.05f)
                            true
                        }
                        keyEvent.key == Key.DirectionDown -> {
                            playerViewModel.adjustVolume(-0.05f)
                            true
                        }

                        // M / Ctrl+M: Toggle Mute
                        keyEvent.key == Key.M -> {
                            playerViewModel.toggleMute()
                            true
                        }

                        // L / Ctrl+L: Toggle Lyrics / Now Playing
                        keyEvent.key == Key.L -> {
                            playerViewModel.toggleNowPlaying()
                            true
                        }

                        // E / Ctrl+E: Toggle Equalizer / Audio FX Dialog
                        keyEvent.key == Key.E -> {
                            playerViewModel.toggleAudioEffectsDialog()
                            true
                        }

                        // T / Ctrl+T: Toggle Sleep Timer Dialog
                        keyEvent.key == Key.T -> {
                            playerViewModel.toggleSleepTimerDialog()
                            true
                        }

                        // Zoom shortcuts: Ctrl + Minus / Ctrl + Plus / Ctrl + 0
                        keyEvent.isCtrlPressed && (keyEvent.key == Key.Minus || keyEvent.key == Key.NumPadSubtract) -> {
                            dev.brahmkshatriya.echo.desktop.ui.UiZoomManager.zoomScale =
                                (dev.brahmkshatriya.echo.desktop.ui.UiZoomManager.zoomScale - 0.05f).coerceIn(0.5f, 1.5f)
                            true
                        }
                        keyEvent.isCtrlPressed && (keyEvent.key == Key.Equals || keyEvent.key == Key.Plus || keyEvent.key == Key.NumPadAdd) -> {
                            dev.brahmkshatriya.echo.desktop.ui.UiZoomManager.zoomScale =
                                (dev.brahmkshatriya.echo.desktop.ui.UiZoomManager.zoomScale + 0.05f).coerceIn(0.5f, 1.5f)
                            true
                        }
                        keyEvent.isCtrlPressed && (keyEvent.key == Key.Zero) -> {
                            dev.brahmkshatriya.echo.desktop.ui.UiZoomManager.zoomScale = 0.90f
                            true
                        }

                        else -> false
                    }
                } else false
            }
        ) {
            val currentFrame = this.window as? java.awt.Frame
            LaunchedEffect(this.window) {
                activeWindow = this@Window.window
                log("Main window registered: ${this@Window.window}")
                currentFrame?.let { win ->
                    win.isResizable = false
                    val screenBounds = win.graphicsConfiguration?.bounds
                        ?: java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice.defaultConfiguration.bounds
                    val targetW = minOf(1652, (screenBounds.width * 0.8609).toInt().coerceAtLeast(1024))
                    val targetH = minOf(903, (screenBounds.height * 0.8369).toInt().coerceAtLeast(640))
                    win.setSize(targetW, targetH)
                    val left = screenBounds.x + ((screenBounds.width - targetW) / 2).coerceAtLeast(0)
                    val top = screenBounds.y + ((screenBounds.height - targetH) / 2).coerceAtLeast(30)
                    win.setLocation(left, top)
                }
            }
            DisposableEffect(currentFrame) {
                val listener = if (currentFrame != null) {
                    val l = java.awt.event.WindowStateListener { e ->
                        if ((e.newState and java.awt.Frame.MAXIMIZED_BOTH) != 0) {
                            log("Intercepted MAXIMIZED_BOTH on AWT Frame. Reverting extendedState to Frame.NORMAL.")
                            currentFrame.extendedState = java.awt.Frame.NORMAL
                        }
                    }
                    currentFrame.addWindowStateListener(l)
                    l
                } else null

                onDispose {
                    if (currentFrame != null && listener != null) {
                        currentFrame.removeWindowStateListener(listener)
                    }
                    activeWindow = null
                }
            }
                        LaunchedEffect(Unit) {
                kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
                    while (true) {
                        kotlinx.coroutines.delay(45_000L)
                        WindowsKernel32MemoryTrimmer.trimMemory()
                    }
                }
            }
            log("Inside Window { } content lambda - rendering EchoDesktopApp")
            EchoDesktopApp()
            log("EchoDesktopApp rendered")
        }
    }
}

