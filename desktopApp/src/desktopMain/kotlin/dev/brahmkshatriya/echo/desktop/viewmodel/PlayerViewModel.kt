package dev.brahmkshatriya.echo.desktop.viewmodel

import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.clients.TrackClient
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder.Companion.toImageHolder
import dev.brahmkshatriya.echo.common.models.NetworkRequest.Companion.toGetRequest
import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.core.platform.AudioPlayer
import dev.brahmkshatriya.echo.core.platform.PlayerState
import dev.brahmkshatriya.echo.core.platform.RepeatMode
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive
import dev.brahmkshatriya.echo.common.clients.TrackerClient
import dev.brahmkshatriya.echo.common.models.TrackDetails
import okhttp3.OkHttpClient
import okhttp3.Request

class PlayerViewModel(
    private val player: AudioPlayer,
    private val extensionManager: ExtensionManager,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
) {
    val state: StateFlow<PlayerState> get() = player.state
    val currentTrack: StateFlow<Track?> get() = player.currentTrack
    val queue: StateFlow<List<Track>> get() = player.queue
    val positionMs: StateFlow<Long> get() = player.positionMs
    val durationMs: StateFlow<Long> get() = player.durationMs
    val isPlaying: StateFlow<Boolean> get() = player.isPlaying
    val volume: StateFlow<Float> get() = player.volume
    val repeatMode: StateFlow<RepeatMode> get() = player.repeatMode
    val shuffleEnabled: StateFlow<Boolean> get() = player.shuffleEnabled
    private val failedTracks = java.util.concurrent.ConcurrentHashMap.newKeySet<String>()

    init {
        var consecutiveErrors = 0
        scope.launch {
            player.state.collect { st ->
                if (st.status == PlayerState.Status.PLAYING) {
                    consecutiveErrors = 0
                }
                if (st == PlayerState.ENDED) {
                    when (player.repeatMode.value) {
                        RepeatMode.ONE -> {
                            player.currentTrack.value?.let { play(it) }
                        }
                        RepeatMode.ALL -> {
                            skipNext()
                        }
                        RepeatMode.NONE -> {
                            val q = player.queue.value
                            val curr = player.currentTrack.value
                            val idx = if (curr != null) q.indexOfFirst { it.id == curr.id } else -1
                            if (idx >= 0 && idx + 1 < q.size) {
                                skipNext()
                            }
                        }
                    }
                } else if (st.status == PlayerState.Status.ERROR || st.error != null) {
                    consecutiveErrors++
                    if (consecutiveErrors > 3) {
                        println("[PlayerViewModel] Multiple consecutive playback failures ($consecutiveErrors). Stopping auto-skip loop.")
                        return@collect
                    }
                    val curr = player.currentTrack.value
                    if (curr != null) {
                        if (!failedTracks.contains(curr.id)) {
                            failedTracks.add(curr.id)
                            println("[PlayerViewModel] Player error detected for '${curr.title}'. Initiating auto-recovery fallback...")
                            scope.launch {
                                val recovered = runCatching { playStudioFallback(curr) }.isSuccess
                                if (!recovered && player.repeatMode.value != RepeatMode.ONE) {
                                    kotlinx.coroutines.delay(1000)
                                    skipNext()
                                }
                            }
                        } else if (player.repeatMode.value != RepeatMode.ONE) {
                            println("[PlayerViewModel] Track '${curr.title}' already failed recovery. Auto-advancing queue...")
                            scope.launch {
                                kotlinx.coroutines.delay(800)
                                skipNext()
                            }
                        }
                    }
                }
            }
        }

        // Live Tracker Extensions Integration (Discord Rich Presence, Last.fm Scrobbler, etc.)
        scope.launch(Dispatchers.IO) {
            player.currentTrack.collect { track ->
                val trackers = runCatching { extensionManager.tracker.value }.getOrDefault(emptyList())
                if (trackers.isEmpty()) return@collect
                val details = track?.let {
                    TrackDetails(
                        extensionId = track.extras["extension_id"] ?: extensionManager.current.value?.id ?: "audix_player",
                        track = track,
                        context = null,
                        currentPosition = player.positionMs.value,
                        totalDuration = player.durationMs.value.takeIf { it > 0 } ?: track.duration
                    )
                }
                for (tr in trackers) {
                    runCatching {
                        val client = (tr.instance.value ?: tr.instance.value().getOrNull()) as? TrackerClient
                        client?.onTrackChanged(details)
                    }
                }
            }
        }

        scope.launch(Dispatchers.IO) {
            player.isPlaying.collect { playing ->
                val trackers = runCatching { extensionManager.tracker.value }.getOrDefault(emptyList())
                if (trackers.isEmpty()) return@collect
                val track = player.currentTrack.value
                val details = track?.let {
                    TrackDetails(
                        extensionId = track.extras["extension_id"] ?: extensionManager.current.value?.id ?: "audix_player",
                        track = track,
                        context = null,
                        currentPosition = player.positionMs.value,
                        totalDuration = player.durationMs.value.takeIf { it > 0 } ?: track.duration
                    )
                }
                for (tr in trackers) {
                    runCatching {
                        val client = (tr.instance.value ?: tr.instance.value().getOrNull()) as? TrackerClient
                        client?.onPlayingStateChanged(details, playing)
                    }
                }
            }
        }

        scope.launch(Dispatchers.IO) {
            var lastTrackerWindow = -1L
            player.positionMs.collect { pos ->
                val window = pos / 15000L
                if (pos > 0 && window != lastTrackerWindow) {
                    lastTrackerWindow = window
                    val trackers = runCatching { extensionManager.tracker.value }.getOrDefault(emptyList())
                    if (trackers.isEmpty()) return@collect
                    val track = player.currentTrack.value ?: return@collect
                    val isPlay = player.isPlaying.value
                    val details = TrackDetails(
                        extensionId = track.extras["extension_id"] ?: extensionManager.current.value?.id ?: "audix_player",
                        track = track,
                        context = null,
                        currentPosition = pos,
                        totalDuration = player.durationMs.value.takeIf { it > 0 } ?: track.duration
                    )
                    for (tr in trackers) {
                        runCatching {
                            val client = (tr.instance.value ?: tr.instance.value().getOrNull()) as? TrackerClient
                            client?.onPlayingStateChanged(details, isPlay)
                        }
                    }
                }
            }
        }
    }

    fun togglePlayPause() {
        player.togglePlayPause()
    }

    fun pause() {
        player.pause()
    }

    fun resume() {
        player.resume()
    }

    fun seekTo(positionMs: Long) {
        player.seekTo(positionMs)
    }

    fun skipNext() {
        val q = queue.value
        if (q.isEmpty()) return
        val current = currentTrack.value
        val currentIndex = if (current != null) q.indexOfFirst { it.id == current.id } else -1
        val nextIndex = when (repeatMode.value) {
            RepeatMode.ONE -> if (currentIndex >= 0) currentIndex else 0
            RepeatMode.ALL -> if (currentIndex >= 0) (currentIndex + 1) % q.size else 0
            RepeatMode.NONE -> if (currentIndex >= 0) {
                if (currentIndex + 1 < q.size) currentIndex + 1 else null
            } else 0
        }
        if (nextIndex != null && nextIndex in q.indices) {
            play(q[nextIndex])
        }
    }

    fun skipPrevious() {
        if (positionMs.value > 3000L) {
            seekTo(0L)
            return
        }
        val q = queue.value
        if (q.isEmpty()) return
        val current = currentTrack.value
        val currentIndex = if (current != null) q.indexOfFirst { it.id == current.id } else -1
        val prevIndex = if (currentIndex > 0) currentIndex - 1 else 0
        if (prevIndex in q.indices) {
            play(q[prevIndex])
        }
    }

    fun stop() {
        player.stop()
    }

    fun setVolume(v: Float) {
        player.setVolume(v)
    }

    fun seekRelative(deltaMs: Long) {
        val current = positionMs.value
        val total = durationMs.value
        val target = (current + deltaMs).coerceIn(0L, if (total > 0) total else Long.MAX_VALUE)
        seekTo(target)
    }

    fun adjustVolume(delta: Float) {
        val current = volume.value
        val target = (current + delta).coerceIn(0f, 1f)
        setVolume(target)
    }

    private var previousVolume: Float = 1.0f

    fun toggleMute() {
        if (volume.value > 0f) {
            previousVolume = volume.value
            setVolume(0f)
        } else {
            setVolume(if (previousVolume > 0f) previousVolume else 0.5f)
        }
    }

    private val _showNowPlaying = kotlinx.coroutines.flow.MutableStateFlow(false)
    val showNowPlaying: StateFlow<Boolean> = _showNowPlaying

    fun toggleNowPlaying() {
        _showNowPlaying.value = !_showNowPlaying.value
    }

    private val _showAudioEffectsDialog = kotlinx.coroutines.flow.MutableStateFlow(false)
    val showAudioEffectsDialog: StateFlow<Boolean> = _showAudioEffectsDialog

    fun toggleAudioEffectsDialog() {
        _showAudioEffectsDialog.value = !_showAudioEffectsDialog.value
    }

    private val _showSleepTimerDialog = kotlinx.coroutines.flow.MutableStateFlow(false)
    val showSleepTimerDialog: StateFlow<Boolean> = _showSleepTimerDialog

    fun toggleSleepTimerDialog() {
        _showSleepTimerDialog.value = !_showSleepTimerDialog.value
    }

    fun setRepeatMode(mode: RepeatMode) {
        player.setRepeatMode(mode)
    }

    fun setShuffle(enabled: Boolean) {
        player.setShuffle(enabled)
    }

    fun addToQueue(tracks: List<Track>) {
        player.addToQueue(tracks, 0)
    }

    fun removeFromQueue(index: Int) {
        player.removeFromQueue(index)
    }

    fun clearQueue() {
        val qSize = queue.value.size
        for (i in (qSize - 1) downTo 0) {
            runCatching { player.removeFromQueue(i) }
        }
    }

    fun moveInQueue(from: Int, to: Int) {
        player.moveInQueue(from, to)
    }

    fun setPlaybackRate(rate: Float) {
        runCatching { player.setPlaybackRate(rate) }
    }

    fun setEqualizer(bands: FloatArray, preamp: Float) {
        runCatching { player.setEqualizer(bands, preamp) }
    }

    fun setEqualizerPreset(preset: String) {
        runCatching { player.setEqualizerPreset(preset) }
    }

    fun disableEqualizer() {
        runCatching { player.disableEqualizer() }
    }

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(12, java.util.concurrent.TimeUnit.SECONDS)
        .readTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val saavnDesKey = "38346591".toByteArray(Charsets.UTF_8)
    private val soundCloudClientId = "T574VRKI5KSLMzLdUreWOpXss1R3Fzfx"
    private val jsonParser = Json { ignoreUnknownKeys = true }

    fun formatDuration(ms: Long): String {
        val totalSeconds = ms / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format("%d:%02d", minutes, seconds)
    }

    private suspend fun getTrackClient(extension: MusicExtension): TrackClient? {
        return runCatching {
            (extension.instance.value ?: extension.instance.value().getOrNull()) as? TrackClient
        }.getOrNull()
    }

    private fun cleanTrackTitle(title: String, artist: String): String {
        var t = title
        // Remove bracketed suffixes: (Official Music Video), [Official Audio], (Lyrics), etc.
        t = t.replace(Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song).*?[\)\]\}]""", RegexOption.IGNORE_CASE), "")
        // Remove artist prefixes/suffixes if repeated
        if (artist.isNotBlank() && !artist.equals("Unknown Artist", ignoreCase = true)) {
            val esc = Regex.escape(artist)
            t = t.replace(Regex("""^$esc\s*[-–:]\s*""", RegexOption.IGNORE_CASE), "")
            t = t.replace(Regex("""\s*[-–:]\s*$esc$""", RegexOption.IGNORE_CASE), "")
        }
        // Remove unparenthesized "feat. ..."
        t = t.replace(Regex("""\s+(?:feat|ft)\.?\s+.*$""", RegexOption.IGNORE_CASE), "")
        // Clean whitespace
        t = t.replace(Regex("""\s+"""), " ").trim()
        return if (t.isNotBlank()) t else title.trim()
    }

    private fun scoreTrackCandidate(candidateTitle: String, candidateArtist: String, targetTitle: String, targetArtist: String): Int {
        val cTitle = candidateTitle.lowercase().trim()
        val cArtist = candidateArtist.lowercase().trim()
        val tTitle = targetTitle.lowercase().trim()
        val tArtist = targetArtist.lowercase().trim()

        var score = 0
        if (cTitle == tTitle) {
            score += 100
        } else if (cTitle.contains(tTitle) || tTitle.contains(cTitle)) {
            score += 60
        }

        if (tArtist.isNotBlank() && (cArtist.contains(tArtist) || tArtist.contains(cArtist))) {
            score += 40
        }
        return score
    }

    private fun decryptSaavnRaw(encUrl: String): String? {
        return runCatching {
            val cleanEnc = encUrl.replace("\\/", "/").replace("\\", "").trim()
            if (cleanEnc.length < 8 || cleanEnc.length > 2048) return null
            if (!cleanEnc.matches(Regex("^[A-Za-z0-9+/=_-]+$"))) return null
            val cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding")
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, javax.crypto.spec.SecretKeySpec(saavnDesKey, "DES"))
            var normalizedBase64 = cleanEnc.replace("-", "+").replace("_", "/")
            val missingPadding = (4 - (normalizedBase64.length % 4)) % 4
            normalizedBase64 += "=".repeat(missingPadding)
            val decoded = runCatching { java.util.Base64.getDecoder().decode(normalizedBase64) }
                .getOrElse {
                    java.util.Base64.getUrlDecoder().decode(cleanEnc)
                }
            val decrypted = cipher.doFinal(decoded)
            String(decrypted, Charsets.UTF_8).trim()
        }.getOrNull()
    }

    private fun decryptSaavnUrl(encUrl: String): String? {
        val raw = decryptSaavnRaw(encUrl) ?: return null
        return raw.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
    }

    private fun getSaavnMultiQualitySources(encUrl: String?, previewUrl: String?): List<Streamable.Source.Http> {
        val sources = mutableListOf<Streamable.Source.Http>()
        if (!encUrl.isNullOrBlank()) {
            val raw = decryptSaavnRaw(encUrl)
            if (!raw.isNullOrBlank()) {
                val s320 = raw.replace("_96.mp4", "_320.mp4").replace("_160.mp4", "_320.mp4")
                val s160 = raw.replace("_96.mp4", "_160.mp4").replace("_320.mp4", "_160.mp4")
                val s96 = raw.replace("_320.mp4", "_96.mp4").replace("_160.mp4", "_96.mp4")
                sources.add(Streamable.Source.Http(request = s320.toGetRequest(), quality = 320, title = "320 kbps Studio Master", isLive = false))
                sources.add(Streamable.Source.Http(request = s160.toGetRequest(), quality = 160, title = "160 kbps High Quality", isLive = false))
                sources.add(Streamable.Source.Http(request = s96.toGetRequest(), quality = 96, title = "96 kbps Standard", isLive = false))
            }
        }
        if (!previewUrl.isNullOrBlank() && sources.none { it.request.url == previewUrl }) {
            sources.add(Streamable.Source.Http(request = previewUrl.toGetRequest(), quality = 96, title = "Preview Stream", isLive = false))
        }
        return sources
    }

    private suspend fun resolveSaavnStudioStream(query: String, targetTitle: String, targetArtist: String): Pair<Track, List<Streamable.Source.Http>>? = withContext(Dispatchers.IO) {
        runCatching {
            val encoded = java.net.URLEncoder.encode(query, "UTF-8")
            val url = "https://www.jiosaavn.com/api.php?__call=search.getResults&_format=json&_marker=0&ctx=android&p=1&n=8&q=$encoded"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            val body = okHttpClient.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return@runCatching null
                resp.body?.string() ?: return@runCatching null
            }
            val root = jsonParser.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return@runCatching null
            if (results.isEmpty()) return@runCatching null

            var bestObj: kotlinx.serialization.json.JsonObject? = null
            var bestScore = -1

            for (elem in results) {
                val obj = elem.jsonObject
                val songTitle = obj["song"]?.jsonPrimitive?.content ?: ""
                val songArtist = obj["primary_artists"]?.jsonPrimitive?.content ?: ""
                val score = scoreTrackCandidate(songTitle, songArtist, targetTitle, targetArtist)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            val chosen = bestObj ?: results[0].jsonObject
            val enc = chosen["encrypted_media_url"]?.jsonPrimitive?.content
            val preview = chosen["media_preview_url"]?.jsonPrimitive?.content
            val sources = getSaavnMultiQualitySources(enc, preview)

            if (sources.isNotEmpty()) {
                val realTitle = chosen["song"]?.jsonPrimitive?.content ?: targetTitle
                val realArtist = chosen["primary_artists"]?.jsonPrimitive?.content ?: targetArtist
                val rawImage = chosen["image"]?.jsonPrimitive?.content ?: ""
                val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
                val durationStr = chosen["duration"]?.jsonPrimitive?.content
                val durationMs = durationStr?.toLongOrNull()?.times(1000L)

                val resolvedTrack = Track(
                    id = chosen["id"]?.jsonPrimitive?.content ?: "saavn_track",
                    title = realTitle,
                    artists = listOf(Artist(id = realArtist, name = realArtist)),
                    album = chosen["album"]?.jsonPrimitive?.content?.let { Album(id = it, title = it) },
                    cover = if (highResImage.isNotBlank()) highResImage.toImageHolder() else null,
                    duration = durationMs,
                    extras = mapOf(
                        "stream_url" to sources.first().request.url,
                        "source" to "JioSaavn",
                        "extension_id" to "saavn_music"
                    )
                )
                return@withContext Pair(resolvedTrack, sources)
            }
            null
        }.getOrNull()
    }

    private suspend fun resolveSoundCloudStream(query: String): String? = withContext(Dispatchers.IO) {
        runCatching {
            val encoded = java.net.URLEncoder.encode(query, "UTF-8")
            val url = "https://api-v2.soundcloud.com/search/tracks?q=$encoded&client_id=$soundCloudClientId&limit=5"
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .build()

            val body = okHttpClient.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return@runCatching null
                resp.body?.string() ?: return@runCatching null
            }
            val root = jsonParser.parseToJsonElement(body).jsonObject
            val collection = root["collection"]?.jsonArray ?: return@runCatching null
            if (collection.isEmpty()) return@runCatching null

            val trackObj = collection[0].jsonObject
            val mediaObj = trackObj["media"]?.jsonObject
            val transArray = mediaObj?.get("transcodings")?.jsonArray ?: return@runCatching null

            for (elem in transArray) {
                val tObj = elem.jsonObject
                val protocol = tObj["format"]?.jsonObject?.get("protocol")?.jsonPrimitive?.content
                val transUrl = tObj["url"]?.jsonPrimitive?.content
                if (protocol == "progressive" && !transUrl.isNullOrBlank()) {
                    val delim = if (transUrl.contains("?")) "&" else "?"
                    val streamReq = Request.Builder()
                        .url("$transUrl${delim}client_id=$soundCloudClientId")
                        .header("User-Agent", "Mozilla/5.0")
                        .build()
                    val streamBody = okHttpClient.newCall(streamReq).execute().use { resp ->
                        if (!resp.isSuccessful) return@runCatching null
                        resp.body?.string() ?: return@runCatching null
                    }
                    val streamJson = jsonParser.parseToJsonElement(streamBody).jsonObject
                    val directUrl = streamJson["url"]?.jsonPrimitive?.content
                    if (!directUrl.isNullOrBlank()) return@runCatching directUrl
                }
            }
            null
        }.getOrNull()
    }

    suspend fun resolveStreamUrl(track: Track): String? = withContext(Dispatchers.IO) {
        runCatching {
            // 1. Local file or direct stream URL fast path
            val localPath = track.extras["local_file"]
            if (!localPath.isNullOrBlank()) {
                val file = java.io.File(localPath)
                if (file.exists()) return@withContext file.toURI().toString()
            }
            val directUrl = track.extras["stream_url"]
                ?: track.servers.firstOrNull()?.extras?.get("stream_url")
            if (!directUrl.isNullOrBlank() && (directUrl.startsWith("http://") || directUrl.startsWith("https://") || directUrl.startsWith("file:/"))) {
                return@withContext directUrl
            }

            // 2. Extension origin resolution
            val extIdFromTrack = track.extras["extension_id"]
                ?: track.servers.firstOrNull()?.extras?.get("extension_id")
            val allMusic = extensionManager.music.value
            val matchingExtension = when {
                !extIdFromTrack.isNullOrBlank() -> {
                    allMusic.firstOrNull { ext ->
                        ext.id.equals(extIdFromTrack, ignoreCase = true) ||
                        ext.metadata.id.equals(extIdFromTrack, ignoreCase = true) ||
                        ext.id.contains(extIdFromTrack, ignoreCase = true) ||
                        extIdFromTrack.contains(ext.id, ignoreCase = true)
                    }
                }
                track.id.startsWith("sc_") -> {
                    allMusic.firstOrNull { it.id.contains("soundcloud", ignoreCase = true) }
                }
                track.extras.containsKey("spotify_uri") || track.id.startsWith("spotify:") -> {
                    allMusic.firstOrNull { it.id.contains("spotify", ignoreCase = true) }
                }
                track.extras["source"]?.equals("JioSaavn", ignoreCase = true) == true ||
                track.extras["stream_url"]?.contains("saavn") == true -> {
                    allMusic.firstOrNull { it.id.contains("saavn", ignoreCase = true) }
                }
                else -> null
            } ?: extensionManager.current.value ?: allMusic.firstOrNull()

            if (matchingExtension != null) {
                runCatching { extensionManager.setupMusicExtension(matchingExtension, false) }
                val client = getTrackClient(matchingExtension)
                if (client != null) {
                    val loaded = runCatching { client.loadTrack(track, false) }.getOrNull() ?: track
                    val server = loaded.servers.firstOrNull() ?: loaded.streamables.firstOrNull() ?: track.servers.firstOrNull() ?: track.streamables.firstOrNull()
                    if (server != null) {
                        val resolvedMedia = runCatching { client.loadStreamableMedia(server, false) }.getOrNull()
                        if (resolvedMedia is Streamable.Media.Server && resolvedMedia.sources.isNotEmpty()) {
                            val firstSource = resolvedMedia.sources.firstOrNull()
                            if (firstSource is Streamable.Source.Http) {
                                val u = firstSource.request.url
                                if (!u.isNullOrBlank()) return@withContext u
                            }
                        }
                    }
                }
            }

            // 3. Studio Engine fallback (JioSaavn 320kbps -> SoundCloud)
            val rawArtist = track.artists.firstOrNull()?.name ?: ""
            val cleanArtist = if (rawArtist.equals("Unknown Artist", ignoreCase = true) || rawArtist.equals("YouTube Music", ignoreCase = true)) "" else rawArtist
            val cleanTitle = cleanTrackTitle(track.title, cleanArtist)
            val searchQuery = if (cleanArtist.isNotBlank()) "$cleanTitle $cleanArtist" else cleanTitle

            val saavnResult = resolveSaavnStudioStream(searchQuery, cleanTitle, cleanArtist)
            if (saavnResult != null) {
                return@withContext saavnResult.second.firstOrNull()?.request?.url
            }

            val scStream = resolveSoundCloudStream(searchQuery)
            if (!scStream.isNullOrBlank()) {
                return@withContext scStream
            }

            null
        }.getOrNull()
    }

    fun playWithQueue(track: Track, newQueue: List<Track>) {
        if (newQueue.isNotEmpty()) {
            val idx = newQueue.indexOfFirst { it.id == track.id }.coerceAtLeast(0)
            player.setQueue(newQueue, idx)
        }
        play(track)
    }

    private var currentPlayJob: Job? = null

    fun play(track: Track) {
        failedTracks.remove(track.id)
        currentPlayJob?.cancel()
        currentPlayJob = scope.launch {
            runCatching {
                // 1. Maintain queue without duplicate pollution and prepare player
                if (player.queue.value.none { it.id == track.id }) {
                    player.addToQueue(listOf(track), player.queue.value.size)
                }
                player.prepareTrack(track)

                var loadedTrack = track
                var mediaToPlay: Streamable.Media.Server? = null

                // 2. Direct stream URL fast path (already resolved on track)
                val directUrl = track.extras["stream_url"]
                    ?: track.servers.firstOrNull()?.extras?.get("stream_url")
                if (!directUrl.isNullOrBlank() && (directUrl.startsWith("http://") || directUrl.startsWith("https://") || directUrl.startsWith("file:/"))) {
                    val isLive = track.extras["is_live"] == "true"
                    val source = Streamable.Source.Http(
                        request = directUrl.toGetRequest(),
                        quality = 320,
                        title = if (isLive) "Live Radio" else "Direct Stream",
                        isLive = isLive
                    )
                    mediaToPlay = Streamable.Media.Server(listOf(source), merged = false)
                }

                // 3. Extension origin resolution
                if (mediaToPlay == null) {
                    val extIdFromTrack = track.extras["extension_id"]
                        ?: track.servers.firstOrNull()?.extras?.get("extension_id")

                    val allMusic = extensionManager.music.value

                    val matchingExtension = when {
                        !extIdFromTrack.isNullOrBlank() -> {
                            allMusic.firstOrNull { ext ->
                                ext.id.equals(extIdFromTrack, ignoreCase = true) ||
                                ext.metadata.id.equals(extIdFromTrack, ignoreCase = true) ||
                                ext.id.contains(extIdFromTrack, ignoreCase = true) ||
                                extIdFromTrack.contains(ext.id, ignoreCase = true)
                            }
                        }
                        track.id.startsWith("sc_") -> {
                            allMusic.firstOrNull { it.id.contains("soundcloud", ignoreCase = true) }
                        }
                        track.extras.containsKey("spotify_uri") || track.id.startsWith("spotify:") -> {
                            allMusic.firstOrNull { it.id.contains("spotify", ignoreCase = true) }
                        }
                        track.extras["is_live"] == "true" -> {
                            allMusic.firstOrNull { it.id.contains("radio", ignoreCase = true) }
                        }
                        track.extras.containsKey("video_id") -> {
                            allMusic.firstOrNull { it.id.contains("youtube", ignoreCase = true) }
                        }
                        track.extras["source"]?.equals("JioSaavn", ignoreCase = true) == true ||
                        track.extras["stream_url"]?.contains("saavn") == true -> {
                            allMusic.firstOrNull { it.id.contains("saavn", ignoreCase = true) }
                        }
                        else -> null
                    } ?: extensionManager.current.value ?: allMusic.firstOrNull()

                    if (matchingExtension != null) {
                        runCatching { extensionManager.setupMusicExtension(matchingExtension, false) }
                        val client = getTrackClient(matchingExtension)
                        if (client != null) {
                            runCatching {
                                withContext(Dispatchers.IO) {
                                    val loaded = client.loadTrack(track, false)
                                    loadedTrack = loaded
                                    val server = loaded.servers.firstOrNull() ?: loaded.streamables.firstOrNull() ?: track.servers.firstOrNull() ?: track.streamables.firstOrNull()
                                    if (server != null) {
                                        val resolvedMedia = client.loadStreamableMedia(server, false)
                                        if (resolvedMedia is Streamable.Media.Server && resolvedMedia.sources.isNotEmpty()) {
                                            mediaToPlay = resolvedMedia
                                        }
                                    }
                                }
                            }.onFailure { err ->
                                println("[PlayerViewModel] Extension ${matchingExtension.id} resolution failed: ${err.message}")
                            }
                        }
                    }
                }

                // 4. Resilient Studio Engine Fallback (Cleaned title + best match candidate scoring)
                if (mediaToPlay == null) {
                    val rawArtist = track.artists.firstOrNull()?.name ?: ""
                    val cleanArtist = if (rawArtist.equals("Unknown Artist", ignoreCase = true) || rawArtist.equals("YouTube Music", ignoreCase = true)) "" else rawArtist
                    val cleanTitle = cleanTrackTitle(track.title, cleanArtist)
                    val searchQuery = if (cleanArtist.isNotBlank()) "$cleanTitle $cleanArtist" else cleanTitle

                    println("[PlayerViewModel] Resolving stream for '$cleanTitle' ($cleanArtist) via Studio Engine...")

                    // Try JioSaavn Multi-Bitrate Studio Master first
                    val saavnResult = resolveSaavnStudioStream(searchQuery, cleanTitle, cleanArtist)
                    if (saavnResult != null) {
                        val (resolvedTrack, sources) = saavnResult
                        loadedTrack = resolvedTrack.copy(id = track.id) // preserve track id
                        mediaToPlay = Streamable.Media.Server(sources, merged = false)
                    }

                    // Fallback to SoundCloud Progressive MP3
                    if (mediaToPlay == null) {
                        val scStream = resolveSoundCloudStream(searchQuery)
                        if (!scStream.isNullOrBlank()) {
                            val source = Streamable.Source.Http(
                                request = scStream.toGetRequest(),
                                quality = 160,
                                title = "160 kbps (SoundCloud HQ)",
                                isLive = false
                            )
                            mediaToPlay = Streamable.Media.Server(listOf(source), merged = false)
                        }
                    }
                }

                // 5. Start Playback
                if (mediaToPlay != null) {
                    if (!isActive) return@runCatching
                    println("[PlayerViewModel] Starting playback for '${loadedTrack.title}' (sources: ${mediaToPlay.sources.size})")
                    player.play(loadedTrack, mediaToPlay)

                    // Auto-record in DesktopLibraryManager history
                    runCatching {
                        dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager.getOrNull()?.recordHistory(loadedTrack)
                    }
                } else {
                    println("[PlayerViewModel] Error: Unable to resolve playable media for '${track.title}'")
                }
            }.onFailure { e ->
                println("[PlayerViewModel] Fatal error in play(): ${e.message}")
                e.printStackTrace()
            }
        }
    }

    private suspend fun playStudioFallback(track: Track) = withContext(Dispatchers.IO) {
        runCatching {
            val rawArtist = track.artists.firstOrNull()?.name ?: ""
            val cleanArtist = if (rawArtist.equals("Unknown Artist", ignoreCase = true) || rawArtist.equals("YouTube Music", ignoreCase = true)) "" else rawArtist
            val cleanTitle = cleanTrackTitle(track.title, cleanArtist)
            val searchQuery = if (cleanArtist.isNotBlank()) "$cleanTitle $cleanArtist" else cleanTitle

            println("[PlayerViewModel] Executing auto-recovery fallback for '$cleanTitle' ($cleanArtist)...")

            val saavnResult = resolveSaavnStudioStream(searchQuery, cleanTitle, cleanArtist)
            if (saavnResult != null) {
                val (resolvedTrack, sources) = saavnResult
                val finalTrack = resolvedTrack.copy(id = track.id)
                val media = Streamable.Media.Server(sources, merged = false)
                player.play(finalTrack, media)
                return@withContext
            }

            val scStream = resolveSoundCloudStream(searchQuery)
            if (!scStream.isNullOrBlank()) {
                val source = Streamable.Source.Http(
                    request = scStream.toGetRequest(),
                    quality = 160,
                    title = "160 kbps (SoundCloud HQ)",
                    isLive = false
                )
                player.play(track, Streamable.Media.Server(listOf(source), merged = false))
                return@withContext
            }

            println("[PlayerViewModel] Auto-recovery could not find alternative stream for '${track.title}'")
        }.onFailure { err ->
            println("[PlayerViewModel] Error during studio fallback: ${err.message}")
        }
    }
}
