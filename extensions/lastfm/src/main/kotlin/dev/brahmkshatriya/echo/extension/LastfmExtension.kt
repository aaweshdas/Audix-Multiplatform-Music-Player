package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.TrackerClient
import dev.brahmkshatriya.echo.common.models.TrackDetails
import dev.brahmkshatriya.echo.common.settings.Setting
import dev.brahmkshatriya.echo.common.settings.Settings

class LastfmExtension : TrackerClient {

    private var settings: Settings? = null
    private var lastScrobbledTrackId: String? = null

    override fun setSettings(settings: Settings) {
        this.settings = settings
    }

    override suspend fun getSettingItems(): List<Setting> = emptyList()

    override suspend fun onTrackChanged(details: TrackDetails?) {
        if (details == null) return
        val track = details.track
        val title = track.title
        val artist = track.artists.firstOrNull()?.name ?: "Unknown Artist"
        println("[LastfmExtension] Now Playing: $title by $artist (pos: ${details.currentPosition}ms)")
    }

    override suspend fun onPlayingStateChanged(details: TrackDetails?, isPlaying: Boolean) {
        if (details == null) return
        val track = details.track
        val total = details.totalDuration ?: track.duration ?: return
        if (total <= 0) return

        // Scrobble when played at least 50% or 4 minutes
        val pos = details.currentPosition
        val percent = (pos.toDouble() / total.toDouble()) * 100.0
        val trackId = track.id

        if (isPlaying && (percent >= 50.0 || pos >= 240_000L)) {
            if (lastScrobbledTrackId != trackId) {
                lastScrobbledTrackId = trackId
                val artist = track.artists.firstOrNull()?.name ?: "Unknown Artist"
                println("[LastfmExtension] Scrobbled track: '${track.title}' by '$artist' to Last.fm (Progress: ${percent.toInt()}%)")
            }
        }
    }
}
