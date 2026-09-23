package dev.brahmkshatriya.echo.core.platform

import dev.brahmkshatriya.echo.common.models.Streamable
import dev.brahmkshatriya.echo.common.models.Track
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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

    // VLC player — lazily initialized to avoid crashing if VLC isn't installed
    private val vlcAvailable: Boolean by lazy {
        try {
            val commonPaths = listOf(
                "C:\\Program Files\\VideoLAN\\VLC",
                "C:\\Program Files (x86)\\VideoLAN\\VLC",
                System.getenv("VLC_PLUGIN_PATH") ?: "",
                System.getenv("PROGRAMFILES")?.let { "$it\\VideoLAN\\VLC" } ?: ""
            ).filter { it.isNotBlank() }

            for (path in commonPaths) {
                val dir = java.io.File(path)
                if (dir.exists() && java.io.File(dir, "libvlc.dll").exists()) {
                    println("[VlcAudioPlayer] Found libvlc.dll at: ${dir.absolutePath}")
                    com.sun.jna.NativeLibrary.addSearchPath("libvlc", dir.absolutePath)
                    com.sun.jna.NativeLibrary.addSearchPath("libvlccore", dir.absolutePath)
                    System.setProperty("jna.library.path", dir.absolutePath)
                    break
                }
            }
            val discovered = NativeDiscovery().discover()
            println("[VlcAudioPlayer] NativeDiscovery().discover() result: $discovered")
            discovered
        } catch (e: Throwable) {
            System.err.println("[VlcAudioPlayer] Error discovering VLC: ${e.message}")
            e.printStackTrace()
            false
        }
    }

    private val audioComponent: AudioPlayerComponent? by lazy {
        if (vlcAvailable) {
            try {
                AudioPlayerComponent()
            } catch (t: Throwable) {
                System.err.println("[VlcAudioPlayer] Failed creating AudioPlayerComponent: ${t.message}")
                t.printStackTrace()
                null
            }
        } else null
    }
    private val player: MediaPlayer? get() = audioComponent?.mediaPlayer()

    init {
        // Register VLC event listener
        scope.launch {
            delay(100) // Wait for lazy init
            player?.events()?.addMediaPlayerEventListener(object : MediaPlayerEventAdapter() {
                override fun playing(mp: MediaPlayer) {
                    println("[VlcAudioPlayer] Event: PLAYING for ${_currentTrack.value?.title}")
                    _state.value = PlayerState.PLAYING
                    _isPlaying.value = true
                    if (currentPlaybackRate != 1.0f) {
                        runCatching { player?.controls()?.setRate(currentPlaybackRate) }
                    }
                    currentEqualizer?.let { eq ->
                        runCatching { player?.audio()?.setEqualizer(eq) }
                    }
                }

                override fun paused(mp: MediaPlayer) {
                    println("[VlcAudioPlayer] Event: PAUSED")
                    _state.value = PlayerState.PAUSED
                    _isPlaying.value = false
                }

                override fun stopped(mp: MediaPlayer) {
                    println("[VlcAudioPlayer] Event: STOPPED")
                    _state.value = PlayerState.IDLE
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
                    System.err.println("[VlcAudioPlayer] Event: ERROR playing ${_currentTrack.value?.title}")
                    _state.value = PlayerState.error(Exception("VLC playback error"))
                    _isPlaying.value = false
                }

                override fun timeChanged(mp: MediaPlayer, newTime: Long) {
                    _positionMs.value = newTime
                }

                override fun lengthChanged(mp: MediaPlayer, newLength: Long) {
                    _durationMs.value = newLength
                }
            })
        }

        // Poll position for smooth UI updates (50ms for instantaneous lyric synchronization & progress bar)
        scope.launch {
            while (true) {
                delay(50)
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
    }

    override suspend fun play(track: Track, media: Streamable.Media.Server) {
        _state.value = PlayerState.LOADING
        _currentTrack.value = track
        _positionMs.value = 0L
        _durationMs.value = 0L

        val p = player ?: run {
            System.err.println("[VlcAudioPlayer] VLC is not available!")
            _state.value = PlayerState.error(Exception("VLC is not available. Please install VLC media player."))
            return
        }

        val source = media.sources.maxByOrNull { it.quality } ?: run {
            System.err.println("[VlcAudioPlayer] No media source found in ${media.sources.size} sources!")
            _state.value = PlayerState.error(Exception("No media source available"))
            return
        }

        when (source) {
            is Streamable.Source.Http -> {
                val cleanUrl = source.request.url.replace(Regex("[\\r\\n\\u0000]"), "").trim()
                println("[VlcAudioPlayer] Playing stream: $cleanUrl (quality: ${source.quality}kbps, mime: ${source.title})")
                
                // If local file URL, play directly without network caching overhead
                if (cleanUrl.startsWith("file:") || java.io.File(cleanUrl).exists()) {
                    runCatching {
                        val ok = p.media().play(cleanUrl, ":no-video", ":audio-resampler=soxr", ":audio-replay-gain-mode=none")
                        println("[VlcAudioPlayer] Local playback p.media().play() returned: $ok")
                    }.onFailure { err ->
                        _state.value = PlayerState.error(err)
                    }
                    return
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
                    add(":audio-resampler=soxr")
                    add(":sout-audio")
                    add(":audio-replay-gain-mode=none")
                    if (skipSilence) {
                        add(":audio-filter=normvol")
                    }
                    val ua = source.request.headers["User-Agent"]
                        ?: "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36"
                    add(":http-user-agent=${cleanOpt(ua)}")
                    source.request.headers["Referer"]?.let { add(":http-referrer=${cleanOpt(it)}") }
                    source.request.headers["Origin"]?.let { add(":http-origin=${cleanOpt(it)}") }
                }

                runCatching {
                    val ok = p.media().play(cleanUrl, *options.toTypedArray())
                    println("[VlcAudioPlayer] p.media().play() returned: $ok")
                }.onFailure { err ->
                    System.err.println("[VlcAudioPlayer] Error calling p.media().play(): ${err.message}")
                    _state.value = PlayerState.error(err)
                }
            }
