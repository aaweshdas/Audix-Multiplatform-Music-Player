package dev.brahmkshatriya.echo.core.platform

import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import uk.co.caprica.vlcj.player.base.MediaPlayer
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent
import java.io.File

/**
 * AudioPlayer implementation backed by vlcj / libVLC.
 * Supports HTTP progressive, HLS (m3u8), DASH (mpd), and raw streams.
 *
 * To use on Windows: libvlc.dll and libvlccore.dll must be on PATH
 * or bundled in the application's native libraries directory.
 */
class VlcAudioPlayer(
    private val settings: dev.brahmkshatriya.echo.core.settings.EchoSettings? = null
) : AudioPlayer {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val _state = MutableStateFlow(PlayerState.IDLE)
    override val state: StateFlow<PlayerState> = _state.asStateFlow()

    private val _currentTrack = MutableStateFlow<Track?>(null)
    override val currentTrack: StateFlow<Track?> = _currentTrack.asStateFlow()

    private val _queue = MutableStateFlow<List<Track>>(emptyList())
    override val queue: StateFlow<List<Track>> = _queue.asStateFlow()

    private val _positionMs = MutableStateFlow(0L)
    override val positionMs: StateFlow<Long> = _positionMs.asStateFlow()

    private val _durationMs = MutableStateFlow(0L)
    override val durationMs: StateFlow<Long> = _durationMs.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    override val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _volume = MutableStateFlow(1.0f)
    override val volume: StateFlow<Float> = _volume.asStateFlow()

    private val _repeatMode = MutableStateFlow(RepeatMode.NONE)
    override val repeatMode: StateFlow<RepeatMode> = _repeatMode.asStateFlow()

    private val _shuffleEnabled = MutableStateFlow(false)
    override val shuffleEnabled: StateFlow<Boolean> = _shuffleEnabled.asStateFlow()

    private var queueIndex = 0
    private var originalQueue = listOf<Track>()
    private var currentPlaybackRate = 1.0f
    private var currentEqualizer: uk.co.caprica.vlcj.player.base.Equalizer? = null

    private var activeSources: List<Streamable.Source.Http> = emptyList()
    private var activeSourceIndex: Int = 0

    // VLC player — lazily initialized to avoid crashing if VLC isn't installed
    private val vlcAvailable: Boolean by lazy {
        try {
            val userDir = System.getProperty("user.dir") ?: "."
            val codeSourceDir = runCatching {
                java.io.File(VlcAudioPlayer::class.java.protectionDomain.codeSource.location.toURI()).parentFile
            }.getOrNull()

            val candidateDirs = mutableListOf<java.io.File>()

            // 1. Highest Priority: Official System VideoLAN installation paths
            candidateDirs.add(java.io.File("C:\\Program Files\\VideoLAN\\VLC"))
            candidateDirs.add(java.io.File("C:\\Program Files (x86)\\VideoLAN\\VLC"))
            System.getenv("PROGRAMFILES")?.let { candidateDirs.add(java.io.File("$it\\VideoLAN\\VLC")) }
            System.getenv("ProgramFiles(x86)")?.let { candidateDirs.add(java.io.File("$it\\VideoLAN\\VLC")) }
            System.getenv("VLC_PLUGIN_PATH")?.let {
                val p = java.io.File(it)
                candidateDirs.add(p.parentFile ?: p)
            }

            // 2. Application-bundled runtime VLC directories (canonical check)
            if (codeSourceDir != null) {
                candidateDirs.add(java.io.File(codeSourceDir, "runtime/vlc"))
                candidateDirs.add(java.io.File(codeSourceDir, "../runtime/vlc"))
                candidateDirs.add(java.io.File(codeSourceDir, "../../runtime/vlc"))
            }
            val appBaseDir = java.io.File(userDir).canonicalFile
            candidateDirs.add(java.io.File(appBaseDir, "runtime/vlc"))
            candidateDirs.add(java.io.File(appBaseDir, "release-artifacts/Audix-Windows-Portable/runtime/vlc"))

            var foundDirect = false
            for (dir in candidateDirs) {
                if (dir.exists() && java.io.File(dir, "libvlc.dll").exists()) {
                    val abs = dir.canonicalPath
                    println("[VlcAudioPlayer] Found libvlc.dll at canonical path: $abs")
                    com.sun.jna.NativeLibrary.addSearchPath("libvlc", abs)
                    com.sun.jna.NativeLibrary.addSearchPath("libvlccore", abs)
                    System.setProperty("jna.library.path", abs)
                    val pluginsDir = java.io.File(dir, "plugins")
                    if (pluginsDir.exists()) {
                        System.setProperty("VLC_PLUGIN_PATH", pluginsDir.canonicalPath)
                    }
                    foundDirect = true
                    break
                }
            }

            val discovered = runCatching { NativeDiscovery().discover() }.getOrDefault(false)
            println("[VlcAudioPlayer] Discovery result - foundDirect: $foundDirect, NativeDiscovery: $discovered")
            foundDirect || discovered
        } catch (e: Throwable) {
            System.err.println("[VlcAudioPlayer] Error discovering VLC: ${e.message}")
            e.printStackTrace()
            false
        }
    }

    private val vlcEventListener = object : MediaPlayerEventAdapter() {
        override fun playing(mp: MediaPlayer) {
            println("[VlcAudioPlayer] Event: PLAYING for ${_currentTrack.value?.title}")
            _state.value = PlayerState.PLAYING
            _isPlaying.value = true
            scope.launch(Dispatchers.IO) {
                if (currentPlaybackRate != 1.0f) {
                    runCatching { player?.controls()?.setRate(currentPlaybackRate) }
                }
                currentEqualizer?.let { eq ->
                    runCatching { player?.audio()?.setEqualizer(eq) }
                }
            }
        }

        override fun paused(mp: MediaPlayer) {
            println("[VlcAudioPlayer] Event: PAUSED")
            _state.value = PlayerState.PAUSED
            _isPlaying.value = false
        }

        override fun stopped(mp: MediaPlayer) {
            println("[VlcAudioPlayer] Event: STOPPED")
            if (_state.value != PlayerState.LOADING) {
                _state.value = PlayerState.IDLE
            }
            _isPlaying.value = false
        }

        override fun finished(mp: MediaPlayer) {
            println("[VlcAudioPlayer] Event: FINISHED for ${_currentTrack.value?.title}")
            _state.value = PlayerState.ENDED
            _isPlaying.value = false
        }

        override fun buffering(mp: MediaPlayer, newCache: Float) {
            if (newCache < 100.0f) {
                _state.value = PlayerState.BUFFERING
            } else if (_state.value == PlayerState.BUFFERING) {
                _state.value = PlayerState.PLAYING
            }
        }

        override fun error(mp: MediaPlayer) {
            System.err.println("[VlcAudioPlayer] Event: ERROR playing ${_currentTrack.value?.title} (source $activeSourceIndex of ${activeSources.size})")
            val nextIdx = activeSourceIndex + 1
            if (nextIdx < activeSources.size) {
                activeSourceIndex = nextIdx
                val nextSource = activeSources[nextIdx]
                println("[VlcAudioPlayer] Auto-failing over to alternative source #$nextIdx: ${nextSource.title} (${nextSource.quality} kbps)")
                scope.launch(Dispatchers.IO) {
                    playHttpSource(nextSource)
                }
            } else {
                _state.value = PlayerState.error(Exception("VLC playback error on all available stream sources"))
                _isPlaying.value = false
            }
        }

        override fun timeChanged(mp: MediaPlayer, newTime: Long) {
            _positionMs.value = newTime
        }

        override fun lengthChanged(mp: MediaPlayer, newLength: Long) {
            _durationMs.value = newLength
        }
    }

    private val audioComponent: AudioPlayerComponent? by lazy {
        if (vlcAvailable) {
            try {
                AudioPlayerComponent().apply {
                    mediaPlayer().events().addMediaPlayerEventListener(vlcEventListener)
                }
            } catch (t: Throwable) {
                System.err.println("[VlcAudioPlayer] Failed creating AudioPlayerComponent: ${t.message}")
                t.printStackTrace()
                null
            }
        } else null
    }

    @Volatile
    private var isReleased = false
    private val player: MediaPlayer? get() = if (isReleased) null else audioComponent?.mediaPlayer()

    init {
        // Poll position for smooth UI updates (50ms when playing for lyric sync, 1000ms when idle to reduce CPU wakeups)
        scope.launch {
            while (true) {
                val delayMs = if (_isPlaying.value) 50L else 1000L
                delay(delayMs)
                if (!_isPlaying.value) continue
                runCatching {
                    val p = player ?: return@runCatching
                    if (p.status().isPlaying) {
                        val t = p.status().time()
                        val l = p.status().length()
                        if (t >= 0L) _positionMs.value = t
                        if (l > 0L) _durationMs.value = l
                    }
                }
            }
        }
    }

    override fun prepareTrack(track: Track) {
        // Immediately halt current audio output so old song stops playing in 0ms
        runCatching { player?.controls()?.stop() }
        _isPlaying.value = false
        _currentTrack.value = track
        _state.value = PlayerState.LOADING
        _positionMs.value = 0L
        _durationMs.value = 0L
        val foundIdx = _queue.value.indexOfFirst { it.id == track.id }
        if (foundIdx >= 0) {
            queueIndex = foundIdx
        }
    }

    override suspend fun play(track: Track, media: Streamable.Media.Server) {
        _state.value = PlayerState.LOADING
        _currentTrack.value = track
        _positionMs.value = 0L
        _durationMs.value = 0L
        val foundIdx = _queue.value.indexOfFirst { it.id == track.id }
        if (foundIdx >= 0) {
            queueIndex = foundIdx
        }

        val p = player ?: run {
            System.err.println("[VlcAudioPlayer] VLC is not available!")
            _state.value = PlayerState.error(Exception("VLC is not available. Please install VLC media player."))
            return
        }

        val httpSources = media.sources.filterIsInstance<Streamable.Source.Http>().sortedByDescending { it.quality }
        if (httpSources.isEmpty()) {
            System.err.println("[VlcAudioPlayer] No HTTP media source found in ${media.sources.size} sources!")
            _state.value = PlayerState.error(Exception("No HTTP media source available"))
            return
        }

        activeSources = httpSources
        activeSourceIndex = 0
        playHttpSource(httpSources[0])
    }

    private suspend fun playHttpSource(source: Streamable.Source.Http): Unit = withContext(Dispatchers.IO) {
        val p = player ?: return@withContext
        val cleanUrl = source.request.url.replace(Regex("[\\r\\n\\u0000]"), "").trim()
        println("[VlcAudioPlayer] Playing stream: $cleanUrl (quality: ${source.quality}kbps, mime: ${source.title})")

        // If local file URL, play directly without network caching overhead
        if (cleanUrl.startsWith("file:") || java.io.File(cleanUrl).exists()) {
            runCatching {
                val ok = p.media().play(cleanUrl, ":no-video", ":audio-replay-gain-mode=none")
                println("[VlcAudioPlayer] Local playback p.media().play() returned: $ok")
            }.onFailure { err ->
                _state.value = PlayerState.error(err)
            }
            return@withContext
        }

        val latency = settings?.getInt("buffer_latency", 400)?.coerceAtLeast(150) ?: 400
        val skipSilence = settings?.getBoolean("skip_silence", true) ?: true

        fun cleanOpt(v: String) = v.replace(Regex("[\\r\\n\\u0000]"), "").trim()

        val options = buildList {
            add(":http-caching=$latency")
            add(":network-caching=$latency")
            add(":live-caching=${latency + 100}")
            add(":http-reconnect=true")
            add(":clock-jitter=0")
            add(":drop-late-frames=true")
            add(":no-video")
            add(":audio-replay-gain-mode=none")
            if (skipSilence) {
                add(":audio-filter=normvol")
            }
            val ua = source.request.headers["User-Agent"]
                ?: "Audix/1.0.0 (Windows; OpenJDK 21)"
            add(":http-user-agent=${cleanOpt(ua)}")
            source.request.headers["Referer"]?.let { if (it.isNotBlank()) add(":http-referrer=${cleanOpt(it)}") }
            source.request.headers["Origin"]?.let { if (it.isNotBlank()) add(":http-origin=${cleanOpt(it)}") }
        }

        runCatching {
            val ok = p.media().play(cleanUrl, *options.toTypedArray())
            println("[VlcAudioPlayer] p.media().play() returned: $ok")
            if (!ok) {
                // If play returned false immediately, trigger failover
                val nextIdx = activeSourceIndex + 1
                if (nextIdx < activeSources.size) {
                    activeSourceIndex = nextIdx
                    val nextSource = activeSources[nextIdx]
                    println("[VlcAudioPlayer] play() returned false, immediately trying source #$nextIdx")
                    playHttpSource(nextSource)
                } else {
                    _state.value = PlayerState.error(Exception("Unable to play stream"))
                }
            }
        }.onFailure { err ->
            System.err.println("[VlcAudioPlayer] Error calling p.media().play(): ${err.message}")
            _state.value = PlayerState.error(err)
        }
    }

    override fun pause() {
        runCatching { player?.controls()?.pause() }
    }

    override fun resume() {
        runCatching { player?.controls()?.play() }
    }

    override fun togglePlayPause() {
        if (_isPlaying.value) {
            pause()
        } else {
            resume()
        }
    }

    override fun seekTo(positionMs: Long) {
        runCatching { player?.controls()?.setTime(positionMs) }
        _positionMs.value = positionMs
    }

    override fun stop() {
        runCatching { player?.controls()?.stop() }
        _currentTrack.value = null
        _positionMs.value = 0L
        _durationMs.value = 0L
        _queue.value = emptyList()
        queueIndex = 0
    }

    override fun skipNext() {
        val q = _queue.value
        if (q.isEmpty()) return
        queueIndex = when (_repeatMode.value) {
            RepeatMode.ONE -> queueIndex
            RepeatMode.ALL -> (queueIndex + 1) % q.size
            RepeatMode.NONE -> (queueIndex + 1).coerceAtMost(q.size - 1)
        }
        _currentTrack.value = q.getOrNull(queueIndex)
    }

    override fun skipPrevious() {
        if (_positionMs.value > 3000L) {
            seekTo(0L)
            return
        }
        val q = _queue.value
        if (q.isEmpty()) return
        queueIndex = (queueIndex - 1).coerceAtLeast(0)
        _currentTrack.value = q.getOrNull(queueIndex)
    }

    override fun setQueue(tracks: List<Track>, startIndex: Int) {
        _queue.value = tracks
        originalQueue = tracks
        queueIndex = if (tracks.isNotEmpty()) startIndex.coerceIn(0, tracks.size - 1) else 0
        _currentTrack.value = tracks.getOrNull(queueIndex)
    }

    override fun addToQueue(tracks: List<Track>, index: Int) {
        val current = _queue.value.toMutableList()
        if (index < 0 || index >= current.size) {
            current.addAll(tracks)
        } else {
            current.addAll(index, tracks)
            if (index <= queueIndex) {
                queueIndex += tracks.size
            }
        }
        _queue.value = current
        originalQueue = current
    }

    override fun removeFromQueue(index: Int) {
        val current = _queue.value.toMutableList()
        if (index in current.indices) {
            current.removeAt(index)
            val currId = _currentTrack.value?.id
            if (currId != null) {
                val newIdx = current.indexOfFirst { it.id == currId }
                if (newIdx >= 0) {
                    queueIndex = newIdx
                } else if (current.isNotEmpty()) {
                    queueIndex = queueIndex.coerceIn(0, current.size - 1)
                } else {
                    queueIndex = 0
                }
            } else if (index < queueIndex) {
                queueIndex--
            }
        }
        _queue.value = current
    }

    override fun moveInQueue(from: Int, to: Int) {
        val current = _queue.value.toMutableList()
        if (from in current.indices && to in current.indices) {
            val item = current.removeAt(from)
            current.add(to, item)
            _queue.value = current
            val currId = _currentTrack.value?.id
            if (currId != null) {
                val newIdx = current.indexOfFirst { it.id == currId }
                if (newIdx >= 0) queueIndex = newIdx
            }
        }
    }

    override fun setVolume(volume: Float) {
        val clamped = volume.coerceIn(0f, 1f)
        _volume.value = clamped
        runCatching { player?.audio()?.setVolume((clamped * 100).toInt()) }
    }

    override fun setRepeatMode(mode: RepeatMode) {
        _repeatMode.value = mode
    }

    override fun setShuffle(enabled: Boolean) {
        _shuffleEnabled.value = enabled
        if (enabled) {
            val shuffled = _queue.value.toMutableList().apply { shuffle() }
            _queue.value = shuffled
            val currId = _currentTrack.value?.id
            if (currId != null) {
                val newIdx = shuffled.indexOfFirst { it.id == currId }
                if (newIdx >= 0) queueIndex = newIdx
            }
        } else {
            _queue.value = originalQueue
            val currId = _currentTrack.value?.id
            if (currId != null) {
                val newIdx = originalQueue.indexOfFirst { it.id == currId }
                if (newIdx >= 0) queueIndex = newIdx
            }
        }
    }

    override fun setPlaybackRate(rate: Float) {
        val clamped = rate.coerceIn(0.25f, 4.0f)
        currentPlaybackRate = clamped
        runCatching { player?.controls()?.setRate(clamped) }
    }

    override fun setEqualizer(bands: FloatArray, preamp: Float) {
        runCatching {
            val factory = audioComponent?.mediaPlayerFactory() ?: return@runCatching
            val eq = factory.equalizer().newEqualizer()
            eq.setPreamp(preamp.coerceIn(-20f, 20f))
            bands.forEachIndexed { index, amp ->
                if (index < eq.bandCount()) {
                    eq.setAmp(index, amp.coerceIn(-20f, 20f))
                }
            }
            currentEqualizer = eq
            player?.audio()?.setEqualizer(eq)
        }
    }

    override fun setEqualizerPreset(preset: String) {
        runCatching {
            val factory = audioComponent?.mediaPlayerFactory() ?: return@runCatching
            val eq = factory.equalizer().newEqualizer(preset)
            currentEqualizer = eq
            player?.audio()?.setEqualizer(eq)
        }
    }

    override fun disableEqualizer() {
        runCatching {
            currentEqualizer = null
            player?.audio()?.setEqualizer(null)
        }
    }

    override fun release() {
        if (isReleased) return
        isReleased = true
        runCatching { scope.coroutineContext.cancelChildren() }
        runCatching { player?.controls()?.stop() }
        runCatching { audioComponent?.release() }
    }
}

