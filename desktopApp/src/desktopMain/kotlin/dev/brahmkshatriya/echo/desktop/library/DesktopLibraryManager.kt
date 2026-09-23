package dev.brahmkshatriya.echo.desktop.library

import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.NetworkRequest
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.util.UUID

@Serializable
data class StoredTrack(
    val id: String,
    val title: String,
    val artists: List<String> = emptyList(),
    val albumTitle: String? = null,
    val coverUrl: String? = null,
    val durationMs: Long? = null,
    val extras: Map<String, String> = emptyMap(),
    val timestamp: Long = System.currentTimeMillis()
)

fun StoredTrack.toTrack(): Track {
    return Track(
        id = id,
        title = title,
        artists = artists.map { Artist(id = it, name = it) },
        album = albumTitle?.let { Album(id = it, title = it) },
        cover = coverUrl?.let {
            ImageHolder.NetworkRequestImageHolder(
                request = NetworkRequest(url = it),
                crop = false
            )
        },
        duration = durationMs,
        extras = extras
    )
}

fun Track.toStoredTrack(): StoredTrack {
    val coverUrl = when (val c = cover ?: album?.cover) {
        is ImageHolder.NetworkRequestImageHolder -> c.request.url
        is ImageHolder.ResourceUriImageHolder -> c.uri
        else -> null
    }
    return StoredTrack(
        id = id,
        title = title,
        artists = artists.map { it.name },
        albumTitle = album?.title,
        coverUrl = coverUrl,
        durationMs = duration,
        extras = extras
    )
}

@Serializable
data class UserPlaylist(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val tracks: List<StoredTrack> = emptyList()
)

@Serializable
data class LibraryData(
    val favorites: List<StoredTrack> = emptyList(),
    val playlists: List<UserPlaylist> = emptyList(),
    val history: List<StoredTrack> = emptyList()
)

class DesktopLibraryManager(
    private val platform: AppPlatform,
    private val extensionManager: ExtensionManager,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
) {
    private val json = Json { ignoreUnknownKeys = true; prettyPrint = true }

    private val _favorites = MutableStateFlow<List<Track>>(emptyList())
    val favorites: StateFlow<List<Track>> = _favorites.asStateFlow()

    private val _playlists = MutableStateFlow<List<UserPlaylist>>(emptyList())
    val playlists: StateFlow<List<UserPlaylist>> = _playlists.asStateFlow()

    private val _history = MutableStateFlow<List<Track>>(emptyList())
    val history: StateFlow<List<Track>> = _history.asStateFlow()

