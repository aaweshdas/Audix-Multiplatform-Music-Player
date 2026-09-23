package dev.brahmkshatriya.echo.desktop.download

import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import java.awt.Desktop
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

data class DownloadTask(
    val id: String,
    val track: Track,
    val status: Status,
    val progress: Float, // 0.0 to 1.0
    val bytesRead: Long,
    val totalBytes: Long,
    val errorMessage: String? = null
) {
    enum class Status { QUEUED, CONNECTING, DOWNLOADING, COMPLETED, FAILED, CANCELLED }
}

data class DownloadedTrack(
    val id: String,
    val track: Track,
    val file: File,
    val sizeBytes: Long,
    val format: String,
    val dateAdded: Long
)

@Serializable
data class OfflineTrackMetadata(
    val id: String,
    val title: String,
    val artists: List<String>,
    val album: String? = null,
    val coverUrl: String? = null,
    val durationMs: Long? = null,
    val format: String = "MP3",
    val downloadTime: Long = System.currentTimeMillis()
)

class DesktopDownloadManager(
    private val playerViewModel: PlayerViewModel,
    private val settings: EchoSettings,
    private val platform: AppPlatform,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
) {
    private val json = Json { ignoreUnknownKeys = true; prettyPrint = true }

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val _activeDownloads = MutableStateFlow<List<DownloadTask>>(emptyList())
    val activeDownloads: StateFlow<List<DownloadTask>> = _activeDownloads.asStateFlow()

    private val _completedDownloads = MutableStateFlow<List<DownloadedTrack>>(emptyList())
    val completedDownloads: StateFlow<List<DownloadedTrack>> = _completedDownloads.asStateFlow()

    private val jobs = ConcurrentHashMap<String, Job>()

    init {
        refreshCompleted()
    }

    fun getDownloadDir(): File {
        val customPath = settings.getString("download_dir", null)
        val dir = if (!customPath.isNullOrBlank()) File(customPath) else platform.downloadsDir.toFile()
        if (!dir.exists()) dir.mkdirs()
        return dir
    }

    fun setDownloadDir(dir: File) {
        if (!dir.exists()) dir.mkdirs()
        settings.putString("download_dir", dir.absolutePath)
        refreshCompleted()
