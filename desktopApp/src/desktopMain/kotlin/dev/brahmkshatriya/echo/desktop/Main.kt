package dev.brahmkshatriya.echo.desktop

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.isAltPressed
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.isTraySupported
import androidx.compose.ui.window.rememberWindowState
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.disk.DiskCache
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

fun main() {
    val logFile = File(System.getProperty("user.home"), "audix_desktop.log")
    runCatching {
        if (logFile.exists() && logFile.length() > 5 * 1024 * 1024) {
            val backup = File(System.getProperty("user.home"), "audix_desktop.log.1")
            if (backup.exists()) backup.delete()
            logFile.renameTo(backup)
        }
    }
    fun log(message: String) {
        runCatching {
            if (logFile.length() > 5 * 1024 * 1024) {
                val backup = File(System.getProperty("user.home"), "audix_desktop.log.1")
                if (backup.exists()) backup.delete()
                logFile.renameTo(backup)
            }
            logFile.appendText("[${LocalDateTime.now()}] $message\n")
        }
    }

    runCatching {
        val outStream = java.io.FileOutputStream(logFile, true)
        val teeOut = object : java.io.PrintStream(outStream, true) {
            override fun println(x: String?) {
                logFile.appendText("[${LocalDateTime.now()}] [STDOUT] $x\n")
                System.out.print(x + "\n")
            }
        }
        val teeErr = object : java.io.PrintStream(outStream, true) {
            override fun println(x: String?) {
                logFile.appendText("[${LocalDateTime.now()}] [STDERR] $x\n")
                System.err.print(x + "\n")
            }
        }
        System.setOut(teeOut)
        System.setErr(teeErr)
    }

    log("Audix Desktop initializing...")

    val singleInstancePort = 49876
    try {
        val testSocket = java.net.Socket("127.0.0.1", singleInstancePort)
        testSocket.use { s ->
            s.getOutputStream().write("SHOW\n".toByteArray())
            s.getOutputStream().flush()
        }
        log("Existing Audix instance already running and notified to show window. Exiting duplicate process.")
        System.exit(0)
    } catch (_: Exception) {
        // Port free, this is the primary instance
    }

    val instanceServer = runCatching {
        java.net.ServerSocket(singleInstancePort, 50, java.net.InetAddress.getByName("127.0.0.1"))
    }.getOrNull()

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

    log("Initializing Coil...")
    runCatching {
        SingletonImageLoader.setSafe {
            ImageLoader.Builder(it)
                .components {
                    add(OkHttpNetworkFetcherFactory(OkHttpClient()))
                    add(SvgDecoder.Factory())
                }
                .diskCache {
                    DiskCache.Builder()
                        .directory(platform.cacheDir.resolve("images").toFile().toOkioPath())
                        .maxSizeBytes(512L * 1024 * 1024)
                        .build()
                }
                .crossfade(true)
                .build()
        }
        log("Coil initialized")
    }.onFailure {
        log("Coil initialization warning: ${it.stackTraceToString()}")
    }

    log("Launching Compose Desktop application...")
    application(exitProcessOnExit = true) {
        log("Inside application {} block")

        val windowVisibleState = remember { mutableStateOf(true) }

        DisposableEffect(Unit) {
            log("Starting WindowsMediaKeys listener...")
            mediaKeys.start()

            val listenerThread = Thread {
                try {
                    while (instanceServer != null && !instanceServer.isClosed) {
                        val client = instanceServer.accept()
                        client.use {
                            val line = it.getInputStream().bufferedReader().readLine()
                            if (line == "SHOW") {
                                log("Received SHOW signal from another process. Restoring window.")
                                windowVisibleState.value = true
                            }
                        }
                    }
                } catch (_: Exception) {}
            }.apply {
                isDaemon = true
                name = "Audix-SingleInstanceListener"
                start()
            }

            onDispose {
                log("Stopping WindowsMediaKeys listener and releasing audio player...")
                runCatching { instanceServer?.close() }
                runCatching { mediaKeys.stop() }
                runCatching { audioPlayer.release() }
            }
        }

        val logoPainter = remember {
            runCatching {
                val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_logo.png")
                    ?: Thread.currentThread().contextClassLoader.getResourceAsStream("images/spothub_logo.png")
                    ?: File("src/desktopMain/resources/images/audix_logo.png").takeIf { it.exists() }?.inputStream()
                    ?: File("src/desktopMain/resources/images/spothub_logo.png").takeIf { it.exists() }?.inputStream()
                stream?.use { androidx.compose.ui.res.loadImageBitmap(it) }?.let { androidx.compose.ui.graphics.painter.BitmapPainter(it) }
            }.getOrNull() ?: EchoTrayPainter
        }

        log("Checking isTraySupported...")
        val traySupported = runCatching { isTraySupported }.getOrDefault(false)
        log("isTraySupported result: $traySupported")

        if (traySupported) {
            log("Configuring Tray...")
            Tray(
                icon = logoPainter,
                tooltip = "Audix Music",
                onAction = { windowVisibleState.value = true },
                menu = {
                    Item("Show Audix", onClick = { windowVisibleState.value = true })
                    Item("Play / Pause", onClick = { playerViewModel.togglePlayPause() })
                    Item("Next", onClick = { playerViewModel.skipNext() })
                    Item("Previous", onClick = { playerViewModel.skipPrevious() })
                    Separator()
                    Item("Exit", onClick = {
                        runCatching { instanceServer?.close() }
                        runCatching { audioPlayer.stop() }
                        runCatching { audioPlayer.release() }
                        exitApplication()
                    })
                }
            )
            log("Tray configured")
        }

        log("Remembering WindowState...")
        val windowState = rememberWindowState(
            width = 1280.dp,
            height = 800.dp,
            placement = WindowPlacement.Floating
        )
        log("WindowState remembered: $windowState")

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
                }
            },
            title = "Audix",
            icon = logoPainter,
            state = windowState,
            onKeyEvent = { keyEvent ->
                if (keyEvent.type == KeyEventType.KeyDown) {
                    when {
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

                        else -> false
                    }
                } else false
            }
        ) {
            log("Inside Window { } content lambda - rendering EchoDesktopApp")
            EchoDesktopApp()
            log("EchoDesktopApp rendered")
        }
    }
}

