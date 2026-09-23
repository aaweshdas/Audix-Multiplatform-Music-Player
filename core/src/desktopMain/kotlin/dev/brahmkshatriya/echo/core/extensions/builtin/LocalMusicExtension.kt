package dev.brahmkshatriya.echo.core.extensions.builtin

import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient
import dev.brahmkshatriya.echo.common.clients.TrackClient
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ExtensionType
import dev.brahmkshatriya.echo.common.models.Feed
import dev.brahmkshatriya.echo.common.models.Feed.Companion.toFeed
import dev.brahmkshatriya.echo.common.models.ImportType
import dev.brahmkshatriya.echo.common.models.Metadata
import dev.brahmkshatriya.echo.common.models.NetworkRequest.Companion.toGetRequest
import dev.brahmkshatriya.echo.common.models.Shelf
import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.common.settings.Setting
import dev.brahmkshatriya.echo.common.settings.Settings
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import java.io.File

/**
 * Built-in Desktop Local Music provider for Echo Windows.
 * Automatically discovers audio and media files in the user's Music folder
 * and Echo downloads directory.
 */
class LocalMusicExtension(
    private val platform: AppPlatform,
    private val echoSettings: dev.brahmkshatriya.echo.core.settings.EchoSettings? = null,
) : ExtensionClient, HomeFeedClient, TrackClient, SearchFeedClient {

    companion object {
        const val ID = "desktop_local_music"
        val METADATA = Metadata(
            className = LocalMusicExtension::class.qualifiedName ?: "LocalMusicExtension",
            path = "builtin:local",
            importType = ImportType.File,
            type = ExtensionType.MUSIC,
            id = ID,
            name = "Local Music",
            version = "1.0.0",
            description = "Play songs directly from your Windows Music library and custom folders",
            author = "Echo Desktop",
            isEnabled = true,
        )

        private val AUDIO_EXTENSIONS = setOf(
            "mp3", "flac", "wav", "m4a", "ogg", "opus", "aac", "mp4", "wma", "webm"
        )
    }

    private var currentSettings: Settings? = null

    override fun setSettings(settings: Settings) {
        this.currentSettings = settings
    }

    override suspend fun getSettingItems(): List<Setting> = emptyList()

    private fun getMusicDirectories(): List<File> {
        val userHome = System.getProperty("user.home") ?: ""
        val dirs = mutableListOf(
            File(userHome, "Music"),
            platform.downloadsDir.toFile(),
        )
        val customFolders = echoSettings?.getString("custom_music_folders", null)
            ?.split(';')
            ?.filter { it.isNotBlank() }
            ?.map { File(it.trim()) }
            .orEmpty()
        dirs.addAll(customFolders)
        return dirs.filter { it.exists() && it.isDirectory }
    }

    private fun scanLocalTracks(): List<Track> {
        val files = mutableListOf<File>()
        for (dir in getMusicDirectories()) {
            dir.walkTopDown().maxDepth(3).forEach { file ->
                if (file.isFile && file.extension.lowercase() in AUDIO_EXTENSIONS) {
                    files.add(file)
                }
            }
        }

        return files.distinctBy { it.absolutePath }.map { file ->
            val title = file.nameWithoutExtension
            Track(
                id = file.absolutePath,
                title = title,
                artists = listOf(Artist(name = "Local Audio", id = "local_artist")),
                streamables = listOf(
                    Streamable(
                        id = file.absolutePath,
                        quality = 100,
                        type = Streamable.MediaType.Server,
                        title = "Local File",
                    )
                )
            )
        }
    }

    override suspend fun loadHomeFeed(): Feed<Shelf> {
        val tracks = scanLocalTracks()
        val shelves = if (tracks.isNotEmpty()) {
            listOf(
                Shelf.Lists.Tracks(
                    id = "local_tracks_shelf",
                    title = "Local Music (${tracks.size} tracks)",
                    list = tracks,
                    type = Shelf.Lists.Type.Linear,
                )
            )
        } else {
            listOf(
                Shelf.Lists.Tracks(
                    id = "no_local_tracks",
                    title = "No songs found in Music folder (${System.getProperty("user.home")}\\Music)",
                    list = emptyList(),
                    type = Shelf.Lists.Type.Linear,
                )
            )
        }
        return shelves.toFeed()
    }

    override suspend fun loadSearchFeed(query: String): Feed<Shelf> {
        val all = scanLocalTracks()
        val filtered = if (query.isBlank()) all else {
            all.filter { it.title.contains(query, ignoreCase = true) }
        }
        return listOf(
            Shelf.Lists.Tracks(
                id = "search_results",
                title = if (query.isBlank()) "All Local Songs" else "Results for \"$query\"",
                list = filtered,
                type = Shelf.Lists.Type.Linear,
            )
        ).toFeed()
    }

    override suspend fun loadTrack(track: Track, isDownload: Boolean): Track {
        return track
    }

    override suspend fun loadStreamableMedia(
        streamable: Streamable,
        isDownload: Boolean
    ): Streamable.Media {
        val file = File(streamable.id)
        require(file.exists() && file.isFile && file.extension.lowercase() in AUDIO_EXTENSIONS) {
            "Refusing to stream non-audio or nonexistent file: ${file.name}"
        }
        val uri = file.toURI().toString()
        val source = Streamable.Source.Http(
            request = uri.toGetRequest(),
            quality = 100,
            title = "Local File"
        )
        return Streamable.Media.Server(listOf(source), merged = false)
    }

    override suspend fun loadFeed(track: Track): Feed<Shelf>? {
        return null
    }
}

