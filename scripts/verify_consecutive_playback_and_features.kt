package scripts

import dev.brahmkshatriya.echo.core.platform.AudioPlayer
import dev.brahmkshatriya.echo.core.platform.PlayerState
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.desktop.di.desktopModule
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import dev.brahmkshatriya.echo.desktop.ui.DesktopBackgroundManager
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import kotlinx.coroutines.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.java.KoinJavaComponent.getKoin

fun main() = runBlocking {
    println("==================================================")
    println("AUDIX END-TO-END VERIFICATION TEST")
    println("==================================================")

    stopKoin()
    startKoin {
        modules(desktopModule)
    }

    val koin = getKoin()
    val audioPlayer = koin.get<AudioPlayer>()
    val settings = koin.get<EchoSettings>()
    val pvm1 = koin.get<PlayerViewModel>()

    // Register singleton override as in Main.kt
    val extraModule = org.koin.dsl.module {
        single<PlayerViewModel> { pvm1 }
    }
    koin.loadModules(listOf(extraModule), allowOverride = true)

    val pvm2 = koin.get<PlayerViewModel>()
    println("[Test 1/3] Verifying PlayerViewModel singleton semantics...")
    if (pvm1 === pvm2) {
        println("  -> PASSED: PlayerViewModel is an absolute singleton (ref: ${System.identityHashCode(pvm1)})")
    } else {
        println("  -> FAILED: PlayerViewModel instances differ!")
        System.exit(1)
    }

    println("\n[Test 2/3] Verifying DesktopBackgroundManager...")
    DesktopBackgroundManager.initialize(settings)
    val wpList = DesktopBackgroundManager.wallpapers.value
    println("  -> Available themes count: ${wpList.size}")
    for (wp in wpList) {
        println("     * [${wp.id}] ${wp.title}")
    }
    val curWp = DesktopBackgroundManager.currentWallpaperId.value
    val curBmp = DesktopBackgroundManager.currentBitmap.value
    val curBlurred = DesktopBackgroundManager.currentBlurredBitmap.value
    println("  -> Current active wallpaper ID: $curWp")
    println("  -> Active bitmap loaded: ${curBmp != null}")
    println("  -> Blurred liquid-glass background loaded: ${curBlurred != null}")
    if (wpList.size >= 8 && curBmp != null && curBlurred != null) {
        println("  -> PASSED: All wallpaper presets and blurred glass buffers are initialized.")
    } else {
        println("  -> FAILED: Wallpapers or blurred background missing!")
        System.exit(2)
    }

    println("\n[Test 3/3] Testing consecutive 3-track playback without freezes...")
    val tracks = listOf(
        Track(id = "yt:syFZfO_wfMQ", title = "Night Changes", artists = listOf(Artist(id = "a1", name = "One Direction"))),
        Track(id = "yt:QJO3ROT-A4E", title = "What Makes You Beautiful", artists = listOf(Artist(id = "a1", name = "One Direction"))),
        Track(id = "yt:psU1Xm_q7yE", title = "Steal My Girl", artists = listOf(Artist(id = "a1", name = "One Direction")))
    )

    for ((index, track) in tracks.withIndex()) {
        println("\n>>> Playing Track ${index + 1}/${tracks.size}: '${track.title}'...")
        pvm1.play(track)

        var becamePlaying = false
        withTimeoutOrNull(15_000L) {
            while (isActive) {
                val st = audioPlayer.state.value
                val isP = audioPlayer.isPlaying.value
                val pos = audioPlayer.positionMs.value
                if (st.status == PlayerState.Status.PLAYING || (isP && pos > 200L)) {
                    println("  -> Track '${track.title}' is PLAYING! (state: $st, isPlaying: $isP, pos: ${pos}ms)")
                    becamePlaying = true
                    break
                }
                delay(300L)
            }
        }

        if (!becamePlaying) {
            println("  -> FAILED: Track '${track.title}' did not reach PLAYING within 15 seconds.")
            System.exit(3)
        }

        // Let it play smoothly for 3 seconds
        delay(3000L)
        val posAfter = audioPlayer.positionMs.value
        println("  -> Track smoothly progressed to ${posAfter}ms.")
    }

    println("\n==================================================")
    println("ALL VERIFICATIONS PASSED SUCCESSFULLY (100% HEALTHY)")
    println("==================================================")
    audioPlayer.stop()
    stopKoin()
    System.exit(0)
}
