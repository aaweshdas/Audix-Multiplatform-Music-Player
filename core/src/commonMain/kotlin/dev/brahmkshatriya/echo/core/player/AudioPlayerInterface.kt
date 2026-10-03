package dev.brahmkshatriya.echo.core.player

import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import kotlinx.coroutines.flow.StateFlow

/**
 * Decoupled interface for audio player implementations (ExoPlayer on Android, VLC on Desktop).
 */
interface AudioPlayerInterface {
    val isPlaying: StateFlow<Boolean>
    val currentTrack: StateFlow<Track?>
    val currentPosition: StateFlow<Long>
    val duration: StateFlow<Long>
    val volume: StateFlow<Float>

    fun play()
    fun pause()
    fun togglePlayPause()
    fun seekTo(positionMs: Long)
    fun setVolume(volume: Float)
    fun setSource(track: Track, server: Streamable.Media.Server)
    fun release()
}
