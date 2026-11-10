package scripts

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent
import com.sun.jna.NativeLibrary

fun main() {
    val vlcPath = "release-artifacts/Audix-Windows-Portable/runtime/vlc"
    NativeLibrary.addSearchPath("libvlc", vlcPath)
    System.setProperty("jna.library.path", vlcPath)

    try {
        val comp = EmbeddedMediaPlayerComponent()
        println("Created EmbeddedMediaPlayerComponent successfully: $comp")
        println("Media player: " + comp.mediaPlayer())
        comp.release()
        println("Released successfully!")
    } catch (t: Throwable) {
        t.printStackTrace()
    }
}
