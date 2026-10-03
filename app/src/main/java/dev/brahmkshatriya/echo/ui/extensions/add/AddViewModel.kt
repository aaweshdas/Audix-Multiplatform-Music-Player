package dev.brahmkshatriya.echo.ui.extensions.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.brahmkshatriya.echo.common.helpers.ContinuationCallback.Companion.await
import dev.brahmkshatriya.echo.di.App
import dev.brahmkshatriya.echo.extensions.ExtensionLoader
import dev.brahmkshatriya.echo.extensions.exceptions.InvalidExtensionListException
import dev.brahmkshatriya.echo.ui.extensions.ExtensionsViewModel
import dev.brahmkshatriya.echo.utils.AppUpdater.downloadUpdate
import dev.brahmkshatriya.echo.utils.AppUpdater.getUpdateFileUrl
import dev.brahmkshatriya.echo.utils.Serializer.toData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File

class AddViewModel(
    private val app: App,
    private val extensionLoader: ExtensionLoader
) : ViewModel() {

    fun getList() = (addingFlow.value as? AddState.AddList)?.list.orEmpty()

    fun selectAll(select: Boolean) {
        val list = getList()
        addingFlow.value = AddState.AddList(list.map { it.copy(isChecked = select) })
    }

    fun toggleItem(item: ExtensionAssetResponse, isChecked: Boolean) {
        val list = getList()
        val index = list.indexOfFirst { it.item.id == item.id }
        if (index == -1) return
        val currentItem = list[index]
        addingFlow.value = AddState.AddList(list.toMutableList().apply {
            set(index, currentItem.copy(isChecked = isChecked))
        })
    }

    private val client = OkHttpClient()
    private suspend fun getExtensionList(
        link: String,
        client: OkHttpClient
    ) = withContext(Dispatchers.IO) {
        runCatching {
            var targetUrl = link
            val request = Request.Builder()
                .header("User-Agent", "Mozilla/5.0")
                .url(targetUrl).build()
            val response = client.newCall(request).await()
            val body = response.body.string()

            // If the response is HTML (e.g. from v.gd URL shortener preview page), extract the destination URL!
            if (!body.trimStart().startsWith("[") && body.contains("href=")) {
                val match = Regex("""class="biglink"[^>]*href="([^"]+)"""").find(body)
                    ?: Regex("""href="(https?://[^"]+\.json)"""").find(body)
                    ?: Regex("""href="([^"]+)"""").find(body)
                if (match != null) {
                    targetUrl = match.groupValues[1]
                    val followReq = Request.Builder()
                        .header("User-Agent", "Mozilla/5.0")
                        .url(targetUrl).build()
                    val followResp = client.newCall(followReq).await()
                    return@runCatching followResp.body.string()
                        .toData<List<ExtensionAssetResponse>>().getOrThrow()
                }
            }
            body.toData<List<ExtensionAssetResponse>>().getOrThrow()
        }
    }.getOrElse {
        throw InvalidExtensionListException(link, it)
    }

    @Serializable
    data class ExtensionAssetResponse(
        val id: String,
        val name: String,
        val subtitle: String? = null,
        val iconUrl: String? = null,
        val updateUrl: String
    )

    sealed class AddState {
        data object Init : AddState()
        data object Loading : AddState()
        data class AddList(val list: List<ExtensionsAddListAdapter.Item>?) : AddState()
        data class Downloading(val item: ExtensionAssetResponse) : AddState()
        data class Final(val files: List<File>) : AddState()
    }

    var opened = false
    val addingFlow = MutableStateFlow<AddState>(AddState.Init)
    fun addFromLinkOrCode(link: String) = viewModelScope.launch {
        addingFlow.value = AddState.Loading
        val trimmed = link.trim()
        val actualLink = when {
            trimmed.isBlank() || trimmed.equals("extension", ignoreCase = true) || trimmed.equals("extensions", ignoreCase = true) ->
                dev.brahmkshatriya.echo.common.config.FlavorConfig.DEFAULT_EXTENSIONS_URL
            trimmed.startsWith("http://") || trimmed.startsWith("https://") -> trimmed
            else -> "https://v.gd/$trimmed"
        }

        val list = runCatching { getExtensionList(actualLink, client) }.getOrElse {
            app.throwFlow.emit(it)
            null
        }
        val installed = extensionLoader.all.value.map { it.id }
        val shouldBeChecked = (list?.size ?: 0) <= 3
        addingFlow.value = AddState.AddList(list?.map {
            val isInstalled = it.id in installed
            ExtensionsAddListAdapter.Item(
                it,
                isChecked = shouldBeChecked && !isInstalled,
                isInstalled = isInstalled
            )
        })
    }

    fun download(
        download: Boolean, extensionsViewModel: ExtensionsViewModel
    ) = viewModelScope.launch {
        val selected =
            if (download) getList().filter { it.isChecked }.map { it.item } else listOf()
        val files = selected.mapNotNull { item ->
            addingFlow.value = AddState.Downloading(item)
            val url = getUpdateFileUrl("", item.updateUrl, client).getOrElse {
                app.throwFlow.emit(it)
                null
            } ?: return@mapNotNull null
            downloadUpdate(app.context, url, client).getOrElse {
                app.throwFlow.emit(it)
                null
            }
        }
        extensionsViewModel.installWithPrompt(files)
        addingFlow.value = AddState.Final(files)
    }
}