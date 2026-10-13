package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.TrackerClient
import dev.brahmkshatriya.echo.common.models.TrackDetails
import dev.brahmkshatriya.echo.common.settings.Setting
import dev.brahmkshatriya.echo.common.settings.Settings

class DiscordRpcExtension : TrackerClient {

    private var settings: Settings? = null
    private var isCurrentlyPlaying = false

    override fun setSettings(settings: Settings) {
        this.settings = settings
    }

    override suspend fun getSettingItems(): List<Setting> = emptyList()

    override suspend fun onTrackChanged(details: TrackDetails?) {
        if (details == null) {
            println("[DiscordRPC] Presence cleared: Player is idle")
            return
        }
        val track = details.track
        val title = track.title
        val artist = track.artists.firstOrNull()?.name ?: "Unknown Artist"
        val totalSec = (details.totalDuration ?: track.duration ?: 0L) / 1000L
        println("[DiscordRPC] Presence updated: Playing '$title' by '$artist' ($totalSec sec)")
    }

    override suspend fun onPlayingStateChanged(details: TrackDetails?, isPlaying: Boolean) {
        if (this.isCurrentlyPlaying != isPlaying) {
            this.isCurrentlyPlaying = isPlaying
            val title = details?.track?.title ?: "Music"
            val state = if (isPlaying) "Playing" else "Paused"
            println("[DiscordRPC] Playback state changed: $state ('$title')")
        }
    }
}
