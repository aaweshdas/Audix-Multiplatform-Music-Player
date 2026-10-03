package dev.brahmkshatriya.echo.core.data

import dev.brahmkshatriya.echo.common.helpers.PagedData
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.Playlist
import dev.brahmkshatriya.echo.common.models.Track

/**
 * Decoupled data contracts for audio and media repositories in core:data.
 */
interface MediaDataRepository {
    suspend fun getTrack(id: String): Result<Track>
    suspend fun getAlbum(id: String): Result<Album>
    suspend fun getArtist(id: String): Result<Artist>
    suspend fun getPlaylist(id: String): Result<Playlist>
    suspend fun searchTracks(query: String): Result<PagedData<Track>>
}
