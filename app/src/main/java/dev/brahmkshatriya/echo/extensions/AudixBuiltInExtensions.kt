package dev.brahmkshatriya.echo.extensions

import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.models.ExtensionType
import dev.brahmkshatriya.echo.common.models.ImageHolder.Companion.toResourceImageHolder
import dev.brahmkshatriya.echo.common.models.ImportType
import dev.brahmkshatriya.echo.common.models.Metadata
import dev.brahmkshatriya.echo.extension.GeniusExtension
import dev.brahmkshatriya.echo.extension.LastfmExtension
import dev.brahmkshatriya.echo.extension.LrclibExtension
import dev.brahmkshatriya.echo.extension.MusixmatchExtension
import dev.brahmkshatriya.echo.extension.RadioBrowserExtension
import dev.brahmkshatriya.echo.extension.SaavnExtension
import dev.brahmkshatriya.echo.extension.SoundcloudExtension
import dev.brahmkshatriya.echo.extension.SpotifyExtension
import dev.brahmkshatriya.echo.extension.YoutubeExtension

object AudixBuiltInExtensions {

    val spotifyMetadata = Metadata(
        className = SpotifyExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.MUSIC,
        id = "spotify_music",
        name = "Spotify",
        description = "Browse Spotify Top Charts, Today's Top Hits, Viral 50, and stream high-fidelity tracks.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val saavnMetadata = Metadata(
        className = SaavnExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.MUSIC,
        id = "saavn_music",
        name = "JioSaavn",
        description = "High-Fidelity 320kbps Bollywood, Punjabi, Regional & International catalog with original covers.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val youtubeMetadata = Metadata(
        className = YoutubeExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.MUSIC,
        id = "youtube_music",
        name = "YouTube Music",
        description = "Comprehensive music streaming, live performances, official tracks, and remixes.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val soundcloudMetadata = Metadata(
        className = SoundcloudExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.MUSIC,
        id = "soundcloud",
        name = "SoundCloud",
        description = "Independent music, electronic beats, remixes, underground playlists, and original creator tracks.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val radioBrowserMetadata = Metadata(
        className = RadioBrowserExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.MUSIC,
        id = "radio_browser",
        name = "Radio Browser",
        description = "Global community radio stations, live news, and ambient broadcasts from around the world.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val geniusMetadata = Metadata(
        className = GeniusExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.LYRICS,
        id = "genius_lyrics",
        name = "Genius Lyrics",
        description = "Synchronized lyrics, artist commentary, and comprehensive song annotations.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val lrclibMetadata = Metadata(
        className = LrclibExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.LYRICS,
        id = "lrclib_lyrics",
        name = "LrcLib",
        description = "Time-synced and plain text lyrics database for audio tracks.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val musixmatchMetadata = Metadata(
        className = MusixmatchExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.LYRICS,
        id = "musixmatch_lyrics",
        name = "Musixmatch",
        description = "Real-time synced lyrics with rich metadata translations.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    val lastfmMetadata = Metadata(
        className = LastfmExtension::class.java.name,
        path = "",
        importType = ImportType.BuiltIn,
        type = ExtensionType.TRACKER,
        id = "lastfm_tracker",
        name = "Last.fm Scrobbler",
        description = "Automatic track scrobbling and playback statistics tracking.",
        version = "1.0.0",
        author = "Audix",
        icon = R.drawable.ic_audix_logo.toResourceImageHolder()
    )

    fun getBuiltIns(): List<Pair<Metadata, Lazy<ExtensionClient>>> = listOf(
        spotifyMetadata to lazy { SpotifyExtension() },
        saavnMetadata to lazy { SaavnExtension() },
        youtubeMetadata to lazy { YoutubeExtension() },
        soundcloudMetadata to lazy { SoundcloudExtension() },
        radioBrowserMetadata to lazy { RadioBrowserExtension() },
        geniusMetadata to lazy { GeniusExtension() },
        lrclibMetadata to lazy { LrclibExtension() },
        musixmatchMetadata to lazy { MusixmatchExtension() },
        lastfmMetadata to lazy { LastfmExtension() }
    )
}
