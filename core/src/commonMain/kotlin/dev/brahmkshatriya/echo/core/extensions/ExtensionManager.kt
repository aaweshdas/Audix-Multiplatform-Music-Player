package dev.brahmkshatriya.echo.core.extensions

import dev.brahmkshatriya.echo.common.Extension
import dev.brahmkshatriya.echo.common.LyricsExtension
import dev.brahmkshatriya.echo.common.MiscExtension
import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.TrackerExtension
import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.clients.LoginClient
import dev.brahmkshatriya.echo.common.helpers.Injectable
import dev.brahmkshatriya.echo.common.models.ExtensionType
import dev.brahmkshatriya.echo.common.models.Message
import dev.brahmkshatriya.echo.common.models.Metadata
import dev.brahmkshatriya.echo.common.models.NetworkConnection
import dev.brahmkshatriya.echo.common.providers.GlobalSettingsProvider
import dev.brahmkshatriya.echo.common.providers.LyricsExtensionsProvider
import dev.brahmkshatriya.echo.common.providers.MessageFlowProvider
import dev.brahmkshatriya.echo.common.providers.MetadataProvider
import dev.brahmkshatriya.echo.common.providers.MiscExtensionsProvider
import dev.brahmkshatriya.echo.common.providers.MusicExtensionsProvider
import dev.brahmkshatriya.echo.common.providers.NetworkConnectionProvider
import dev.brahmkshatriya.echo.common.providers.TrackerExtensionsProvider
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils.get
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils.getOrEmit
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils.inject
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * Platform-neutral port of the Android ExtensionLoader.
 *
 * All business logic — extension injection, provider wiring, priority sorting,
 * user management — is 100% identical on Android and Desktop.
 *
 * Only the injected [ExtensionRepository] implementation differs per platform:
 * - Android: DexExtensionRepository (DexClassLoader + APK)
 * - Desktop: JarExtensionRepository (URLClassLoader + JAR)
 */
class ExtensionManager(
    private val repository: ExtensionRepository,
    private val settings: EchoSettings,
) {
    val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    /** Flow of errors from extension operations — UI should collect and display these */
    val throwFlow = MutableSharedFlow<Throwable>(extraBufferCapacity = 10)

    /** Flow of messages from extensions — collect to show toasts/snackbars */
    val messageFlow = MutableSharedFlow<Message>(extraBufferCapacity = 10)

    /** Current network state — updated by the platform layer */
    val networkFlow = MutableStateFlow(NetworkConnection.Unmetered)

    /** Priority ordering per extension type */
    val priorityMap = ExtensionType.entries.associateWith { type ->
        val key = type.priorityKey()
        val list = settings.getString(key, null).orEmpty().split(',').filter { it.isNotBlank() }
        MutableStateFlow(list)
    }

    /** The currently active MusicExtension */
    val current = MutableStateFlow<MusicExtension?>(null)

    private fun setCurrentExtension() {
        val last = settings.getString(LAST_EXTENSION_KEY, null)
        val list = music.value
        val isLocal = last == "local_music" || last == "desktop_local_music"
        val extension = if (last != null && !isLocal) {
            list.find { it.id == last && it.isEnabled }
        } else {
            list.find { (it.id.equals("Youtube_music", ignoreCase = true) || it.id.equals("youtube", ignoreCase = true)) && it.isEnabled }
                ?: list.find { it.id == last && it.isEnabled }
        } ?: list.find { (it.id.equals("Youtube_music", ignoreCase = true) || it.id.equals("youtube", ignoreCase = true)) && it.isEnabled }
          ?: list.firstOrNull { it.isEnabled }
          ?: return

        if (current.value?.id == extension.id) return

        println("[Echo ExtensionManager] Setting current music extension to: ${extension.metadata.name} (${extension.id})")
        setupMusicExtension(extension, manual = false)
    }

    fun setupMusicExtension(extension: MusicExtension, manual: Boolean) {
        if (manual) settings.putString(LAST_EXTENSION_KEY, extension.id)
        if (current.value?.id == extension.id) return
        current.value = extension
        scope.launch {
            extension.get { onExtensionSelected() }.getOrEmit(throwFlow)
        }
