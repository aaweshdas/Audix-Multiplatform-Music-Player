package dev.brahmkshatriya.echo.desktop.download

import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.NetworkRequest
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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import java.awt.Desktop
import java.io.File
import java.io.FileOutputStream
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

data class DownloadTask(
    val id: String,
    val track: Track,
    val status: Status,
    val progress: Float = 0.0f, // 0.0 to 1.0
    val bytesRead: Long = 0L,
    val totalBytes: Long = 0L,
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
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val _activeDownloads = MutableStateFlow<List<DownloadTask>>(emptyList())
    val activeDownloads: StateFlow<List<DownloadTask>> = _activeDownloads.asStateFlow()

    private val _completedDownloads = MutableStateFlow<List<DownloadedTrack>>(emptyList())
    val completedDownloads: StateFlow<List<DownloadedTrack>> = _completedDownloads.asStateFlow()

    private val jobs = ConcurrentHashMap<String, Job>()

    companion object {
        @Volatile
        private var instance: DesktopDownloadManager? = null

        fun getInstance(
            playerViewModel: PlayerViewModel,
            settings: EchoSettings,
            platform: AppPlatform,
            scope: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        ): DesktopDownloadManager {
            return instance ?: synchronized(this) {
                instance ?: DesktopDownloadManager(playerViewModel, settings, platform, scope).also { instance = it }
            }
        }

        fun getInstance(): DesktopDownloadManager {
            return instance ?: synchronized(this) {
                instance ?: run {
                    val koin = org.koin.mp.KoinPlatformTools.defaultContext().get()
                    val pvm = koin.get<PlayerViewModel>()
                    val s = koin.get<EchoSettings>()
                    val p = koin.get<AppPlatform>()
                    DesktopDownloadManager(pvm, s, p).also { instance = it }
                }
            }
        }

        fun getOrNull(): DesktopDownloadManager? = instance
    }

    init {
        instance = this
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
    }

    fun refreshCompleted() {
        scope.launch(Dispatchers.IO) {
            val list = mutableListOf<DownloadedTrack>()
            val dir = getDownloadDir()
            val files = dir.listFiles() ?: emptyArray()

            for (file in files) {
                if (!file.isFile) continue
                val name = file.name.lowercase(Locale.ROOT)
                if (!name.endsWith(".mp3") && !name.endsWith(".m4a") &&
                    !name.endsWith(".opus") && !name.endsWith(".webm") &&
                    !name.endsWith(".flac")) {
                    continue
                }

                val metaFile = File(file.absolutePath + ".echo.json")
                if (metaFile.exists()) {
                    try {
                        val meta = json.decodeFromString<OfflineTrackMetadata>(metaFile.readText())
                        val track = Track(
                            id = meta.id,
                            title = meta.title,
                            artists = meta.artists.map { Artist(id = it, name = it) },
                            album = meta.album?.let { Album(id = it, title = it) },
                            cover = meta.coverUrl?.let {
                                ImageHolder.NetworkRequestImageHolder(NetworkRequest(url = it), crop = false)
                            },
                            duration = meta.durationMs,
                            extras = mapOf("local_file" to file.absolutePath)
                        )
                        list.add(DownloadedTrack(meta.id, track, file, file.length(), meta.format, meta.downloadTime))
                    } catch (e: Throwable) {
                        val fallbackTrack = Track(
                            id = file.absolutePath,
                            title = file.nameWithoutExtension,
                            artists = listOf(Artist("Local Artist", "Local Artist")),
                            extras = mapOf("local_file" to file.absolutePath)
                        )
                        list.add(DownloadedTrack(file.absolutePath, fallbackTrack, file, file.length(), file.extension.uppercase(), file.lastModified()))
                    }
                } else {
                    val fallbackTrack = Track(
                        id = file.absolutePath,
                        title = file.nameWithoutExtension,
                        artists = listOf(Artist("Offline Audio", "Offline Audio")),
                        extras = mapOf("local_file" to file.absolutePath)
                    )
                    list.add(DownloadedTrack(file.absolutePath, fallbackTrack, file, file.length(), file.extension.uppercase(), file.lastModified()))
                }
            }

            _completedDownloads.value = list.sortedByDescending { it.dateAdded }
        }
    }

    private fun updateTask(task: DownloadTask) {
        _activeDownloads.update { current ->
            val list = current.toMutableList()
            val idx = list.indexOfFirst { it.id == task.id }
            if (idx >= 0) {
                list[idx] = task
            } else {
                list.add(0, task)
            }
            list
        }
    }

    private fun sanitizeFileName(name: String, trackId: String = ""): String {
        var clean = name.replace(Regex("""[\\/:*?"<>|\r\n\t]"""), "_").trim()
        clean = clean.replace(Regex("""[.\s]+$"""), "")
        if (clean.isBlank()) clean = "track"
        val base = clean.substringBeforeLast('.')
        val reserved = setOf(
            "CON", "PRN", "AUX", "NUL",
            "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9",
            "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"
        )
        if (reserved.contains(base.uppercase())) {
            clean = "_$clean"
        }
        val suffix = if (trackId.isNotBlank()) "_${(trackId.hashCode().toLong() and 0xFFFFFFFFL).toString(16).padStart(6, '0').take(6)}" else ""
        return "$clean$suffix"
    }

    private fun validateStreamUrl(streamUrl: String): okhttp3.HttpUrl {
        val httpUrl = streamUrl.trim().toHttpUrlOrNull()
            ?: throw SecurityException("Security violation: Malformed audio stream URL")
        val scheme = httpUrl.scheme.lowercase()
        if (scheme != "http" && scheme != "https") {
            throw SecurityException("Security violation: Only HTTP/HTTPS audio streams permitted: $scheme")
        }
        val host = httpUrl.host.lowercase()
        if (host.isBlank() || host == "localhost" || host == "127.0.0.1" || host == "::1" || host == "169.254.169.254" || host == "0.0.0.0") {
            throw SecurityException("Security violation: Blocked access to loopback/metadata host: $host")
        }
        val inet = runCatching { java.net.InetAddress.getByName(host) }.getOrNull()
        if (inet != null) {
            if (inet.isLoopbackAddress || inet.isSiteLocalAddress || inet.isLinkLocalAddress || inet.isAnyLocalAddress) {
                throw SecurityException("Security violation: Blocked internal network address: ${inet.hostAddress}")
            }
        }
        return httpUrl
    }

    fun downloadTrack(track: Track) {
        val existing = _activeDownloads.value.firstOrNull { it.id == track.id }
        if (existing != null && (existing.status == DownloadTask.Status.DOWNLOADING || existing.status == DownloadTask.Status.CONNECTING)) {
            return
        }

        val task = DownloadTask(
            id = track.id,
            track = track,
            status = DownloadTask.Status.QUEUED
        )
        updateTask(task)

        val job = scope.launch(Dispatchers.IO) {
            val dir = getDownloadDir()
            val safeTitle = sanitizeFileName(track.title, track.id)
            val tempFile = File(dir, "${safeTitle}.part")

            try {
                updateTask(task.copy(status = DownloadTask.Status.CONNECTING))
                println("[DesktopDownloadManager] Resolving stream for download: ${track.title}")

                val streamUrl = playerViewModel.resolveStreamUrl(track)
                if (streamUrl.isNullOrBlank()) {
                    throw Exception("Could not resolve downloadable audio stream for: ${track.title}")
                }

                validateStreamUrl(streamUrl)

                println("[DesktopDownloadManager] Starting download from: $streamUrl")
                val request = Request.Builder()
                    .url(streamUrl)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .build()

                httpClient.newCall(request).execute().use { response ->
                    if (!response.isSuccessful) {
                        throw Exception("HTTP download error: ${response.code} ${response.message}")
                    }

                    val body = response.body ?: throw Exception("Empty response body from audio stream")
                    val totalBytes = body.contentLength().coerceAtLeast(1L)
                    val isUnknownTotal = totalBytes <= 1L

                    updateTask(task.copy(status = DownloadTask.Status.DOWNLOADING, totalBytes = totalBytes))

                    var totalDownloadedBytes = 0L
                    body.byteStream().use { input ->
                        FileOutputStream(tempFile).use { output ->
                            val buffer = ByteArray(16 * 1024)
                            var read: Int
                            var lastProgressUpdate = System.currentTimeMillis()

                            while (input.read(buffer).also { read = it } != -1) {
                                output.write(buffer, 0, read)
                                totalDownloadedBytes += read

                                if (totalDownloadedBytes > 500L * 1024 * 1024) {
                                    throw Exception("Stream exceeded maximum allowed file size of 500 MB")
                                }

                                val now = System.currentTimeMillis()
                                if (now - lastProgressUpdate > 250L) {
                                    lastProgressUpdate = now
                                    val progress = if (isUnknownTotal) 0.5f else (totalDownloadedBytes.toFloat() / totalBytes).coerceIn(0.0f, 1.0f)
                                    updateTask(task.copy(
                                        status = DownloadTask.Status.DOWNLOADING,
                                        progress = progress,
                                        bytesRead = totalDownloadedBytes,
                                        totalBytes = if (isUnknownTotal) totalDownloadedBytes else totalBytes
                                    ))
                                }
                            }
                            output.flush()
                        }
                    }
                }

                val format = if (streamUrl.contains(".m4a", ignoreCase = true)) "M4A" else "MP3"
                val finalFile = File(dir, "$safeTitle.${format.lowercase(Locale.ROOT)}")

                if (finalFile.exists()) finalFile.delete()
                val moved = runCatching {
                    java.nio.file.Files.move(
                        tempFile.toPath(),
                        finalFile.toPath(),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING
                    )
                    true
                }.getOrElse {
                    tempFile.renameTo(finalFile)
                }

                if (!moved || !finalFile.exists()) {
                    throw Exception("Failed to finalize downloaded file from .part to destination")
                }

                // Save metadata file
                val coverUrl = when (val c = track.cover ?: track.album?.cover) {
                    is ImageHolder.NetworkRequestImageHolder -> c.request.url
                    is ImageHolder.ResourceUriImageHolder -> c.uri
                    else -> null
                }
                val meta = OfflineTrackMetadata(
                    id = track.id,
                    title = track.title,
                    artists = track.artists.map { it.name },
                    album = track.album?.title,
                    coverUrl = coverUrl,
                    durationMs = track.duration,
                    format = format
                )
                File(finalFile.absolutePath + ".echo.json").writeText(json.encodeToString(meta))

                val finalSize = finalFile.length()
                updateTask(task.copy(
                    status = DownloadTask.Status.COMPLETED,
                    progress = 1.0f,
                    bytesRead = finalSize,
                    totalBytes = finalSize
                ))
                println("[DesktopDownloadManager] Successfully downloaded: ${finalFile.absolutePath}")
                refreshCompleted()

            } catch (e: CancellationException) {
                if (tempFile.exists()) tempFile.delete()
                updateTask(task.copy(status = DownloadTask.Status.CANCELLED))
            } catch (e: Throwable) {
                if (tempFile.exists()) tempFile.delete()
                System.err.println("[DesktopDownloadManager] Download failed for ${track.title}: ${e.message}")
                updateTask(task.copy(status = DownloadTask.Status.FAILED, errorMessage = e.message ?: "Download error"))
            } finally {
                if (tempFile.exists()) {
                    runCatching { tempFile.delete() }
                }
                jobs.remove(track.id)
            }
        }

        jobs[track.id] = job
    }

    fun downloadAlbum(tracks: List<Track>) {
        tracks.forEach { downloadTrack(it) }
    }

    fun cancel(trackId: String) {
        jobs[trackId]?.cancel()
        jobs.remove(trackId)
        _activeDownloads.update { current ->
            val list = current.toMutableList()
            val idx = list.indexOfFirst { it.id == trackId }
            if (idx >= 0) {
                list[idx] = list[idx].copy(status = DownloadTask.Status.CANCELLED)
            }
            list
        }
    }

    fun clearCompleted() {
        _activeDownloads.update { current ->
            current.filter {
                it.status == DownloadTask.Status.DOWNLOADING || it.status == DownloadTask.Status.CONNECTING || it.status == DownloadTask.Status.QUEUED
            }
        }
    }

    fun deleteDownloaded(item: DownloadedTrack) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                if (playerViewModel.currentTrack.value?.id == item.id) {
                    playerViewModel.stop()
                }
                if (item.file.exists()) item.file.delete()
                val meta = File(item.file.absolutePath + ".echo.json")
                if (meta.exists()) meta.delete()
            }
            refreshCompleted()
        }
    }

    fun playOffline(item: DownloadedTrack) {
        val offlineTrack = item.track.copy(
            extras = item.track.extras + ("local_file" to item.file.absolutePath)
        )
        playerViewModel.play(offlineTrack)
    }

    fun openInExplorer(file: File) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                if (System.getProperty("os.name").lowercase(Locale.ROOT).contains("win")) {
                    ProcessBuilder("explorer.exe", "/select,${file.canonicalPath}").start()
                } else if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file.parentFile ?: file)
                }
            }
        }
    }

    fun openDownloadsFolder() {
        scope.launch(Dispatchers.IO) {
            runCatching {
                val dir = getDownloadDir()
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(dir)
                } else {
                    Runtime.getRuntime().exec(arrayOf("explorer.exe", dir.absolutePath))
                }
            }
        }
    }
}
