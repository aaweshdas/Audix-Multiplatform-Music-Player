package dev.brahmkshatriya.echo.desktop.viewmodel

import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.clients.TrackClient
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
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
                    val curPos = player.positionMs.value
                    val curDur = player.durationMs.value
                    if (curDur > 10_000L && curPos > 0L && curPos < (curDur - 5_000L)) {
                        println("[PlayerViewModel] Ignored premature ENDED event at ${curPos}ms of ${curDur}ms")
                        return@collect
                    }
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
                                if (!recovered) {
                                    println("[PlayerViewModel] Track '${curr.title}' failed recovery.")
                                }
                            }
                        } else {
                            println("[PlayerViewModel] Track '${curr.title}' already failed recovery.")
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
        return String.format(java.util.Locale.ROOT, "%d:%02d", minutes, seconds)
    }

    private suspend fun getTrackClient(extension: MusicExtension): TrackClient? {
        return runCatching {
            (extension.instance.value ?: extension.instance.value().getOrNull()) as? TrackClient
        }.getOrNull()
    }

    private fun unescapeHtml(text: String): String {
        return text
            .replace("&quot;", "\"")
            .replace("&amp;", "&")
            .replace("&#039;", "'")
            .replace("&apos;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .trim()
    }

    fun isGarbageArtist(name: String?): Boolean {
        if (name.isNullOrBlank()) return true
        val clean = name.trim().lowercase()
        if (clean in setOf(
            "song", "video", "episode", "podcast", "audio", "track",
            "unknown", "unknown artist", "youtube music", "spotify artist",
            "various artists", "audix artist", "audix music", "audix hi-res audio",
            "music video", "official", "vevo", "lyric video", "lyrics", "full song",
            "t-series", "sonymusicindiavevo", "zee music company", "tips official",
            "speed records", "white hill music", "geet mp3", "sony music india",
            "saregama music", "yrf", "t-series regional", "single", "album",
            "soundcloud artist", "sound cloud", "soundclound"
        )) return true
        if (clean.startsWith("user-") || clean.endsWith(" - topic")) return true
        return false
    }

    fun isGarbageAlbum(title: String?): Boolean {
        if (title.isNullOrBlank()) return true
        val t = title.lowercase().trim()
        if (t in setOf("single", "album", "audio", "video", "song", "episode", "podcast", "youtube music", "soundcloud", "soundcloud single")) return true
        if (t.contains("views") || t.contains("view") || t.contains("subscribers") || t.contains("watching") || t.contains("streamed")) return true
        if (t.contains("ago") || t.contains("uploaded")) return true
        if (t.matches(REGEX_GARBAGE_METRICS)) return true
        return false
    }

    fun cleanArtistName(name: String): String {
        var a = name.trim()
        if (a.endsWith(" - Topic", ignoreCase = true)) {
            a = a.substring(0, a.length - 8).trim()
        }
        for (p in listOf("Song", "Video", "Episode", "Podcast")) {
            if (a.startsWith(p, ignoreCase = true)) {
                a = a.substring(p.length).trim(' ', '\t', '\n', '\r', '•', '·', '-', '–', ':')
            }
        }
        return a
    }

    fun isSpamTitle(title: String): Boolean {
        val t = title.lowercase()
        return t.contains("|") || t.contains("//") ||
            t.contains("official video") || t.contains("official music video") ||
            t.contains("full song") || t.contains("lyrical") ||
            t.contains("video song") || t.contains("4k video") ||
            t.contains("hd video")
    }

    fun isLowResOrGenericCover(url: String?): Boolean {
        if (url.isNullOrBlank()) return true
        val u = url.lowercase()
        if (u.contains("charts-images.scdn.co")) return true
        if (u.contains("hqdefault.jpg") || u.contains("mqdefault.jpg") || u.contains("default.jpg") || u.contains("sddefault.jpg")) return true
        if (u.contains("120x120") || u.contains("50x50") || u.contains("150x150") || u.contains("60x60") || u.contains("100x100bb")) return true
        if (u.contains("placeholder") || u.contains("default_album") || u.contains("default_artist") || u.contains("avatar")) return true
        return false
    }

    fun extractTrackCoverUrl(track: Track?): String? {
        if (track == null) return null
        val cover = track.cover ?: track.album?.cover
        val directUrl = when (cover) {
            is ImageHolder.NetworkRequestImageHolder -> cover.request.url
            is ImageHolder.ResourceUriImageHolder -> cover.uri
            else -> null
        }
        val extraCover = track.extras["cover_url"]
        if (!extraCover.isNullOrBlank()) {
            if (isLowResOrGenericCover(directUrl)) return extraCover
        }
        return directUrl ?: extraCover
    }

    fun sanitizeTrackLocally(track: Track): Track {
        var currentArtist = track.artists.firstOrNull { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }?.name
            ?: track.extras["artist_name"]?.takeIf { !isGarbageArtist(it) && it != "Audix Hi-Res Audio" } ?: ""
        var cleanedTitle = cleanTrackTitle(track.title, currentArtist)

        // If artist is missing or garbage, check if title is formatted as "Artist - Title"
        if (currentArtist.isBlank() && (track.title.contains(" - ") || track.title.contains(" – "))) {
            val parts = track.title.split(REGEX_DASH_SEPARATION)
            if (parts.size >= 2 && parts[0].isNotBlank() && parts[0].length < 40 && !isGarbageArtist(parts[0])) {
                currentArtist = cleanArtistName(parts[0].trim())
                cleanedTitle = cleanTrackTitle(parts.drop(1).joinToString(" - "), currentArtist)
            }
        }

        val validArtists = track.artists
            .map { cleanArtistName(it.name) }
            .filterNot { isGarbageArtist(it) || it == "Audix Hi-Res Audio" }
            .distinct()
            .map { Artist(id = it, name = it) }

        val finalArtists = when {
            validArtists.isNotEmpty() -> validArtists
            currentArtist.isNotBlank() && !isGarbageArtist(currentArtist) && currentArtist != "Audix Hi-Res Audio" -> listOf(Artist(id = currentArtist, name = currentArtist))
            else -> {
                val extraArtist = track.extras["artist_name"]?.let { cleanArtistName(it) }?.takeIf { !isGarbageArtist(it) && it != "Audix Hi-Res Audio" }
                if (extraArtist != null) listOf(Artist(id = extraArtist, name = extraArtist)) else emptyList()
            }
        }

        val directCover = when (val c = track.cover ?: track.album?.cover) {
            is ImageHolder.NetworkRequestImageHolder -> c.request.url
            is ImageHolder.ResourceUriImageHolder -> c.uri
            else -> null
        }
        val extraCover = track.extras["cover_url"]
        val highResCover = when {
            !extraCover.isNullOrBlank() && !isLowResOrGenericCover(extraCover) -> extraCover
            !directCover.isNullOrBlank() && !isLowResOrGenericCover(directCover) -> directCover
            !extraCover.isNullOrBlank() -> extraCover
            !directCover.isNullOrBlank() -> directCover
            else -> null
        }

        val finalHolder: ImageHolder? = highResCover?.takeIf { it.isNotBlank() }?.let { urlStr ->
            ImageHolder.NetworkRequestImageHolder(
                request = urlStr.toGetRequest(),
                crop = false
            )
        }
        val currentAlb = track.album?.takeIf { !isGarbageAlbum(it.title) }
        val finalArtistsToSet = if (finalArtists.isNotEmpty()) finalArtists else listOf(Artist(id = "Audix Hi-Res Audio", name = "Audix Hi-Res Audio"))

        return track.copy(
            title = cleanedTitle.ifBlank { track.title },
            artists = finalArtistsToSet,
            cover = finalHolder ?: track.cover,
            album = if (currentAlb != null && finalHolder != null) currentAlb.copy(cover = finalHolder) else currentAlb,
            extras = buildMap {
                putAll(track.extras)
                if (highResCover != null) put("cover_url", highResCover)
                if (cleanedTitle.isNotBlank()) put("track_title", cleanedTitle)
                if (finalArtists.isNotEmpty()) put("artist_name", finalArtists.joinToString(", ") { it.name })
                if (currentAlb != null) put("album_name", currentAlb.title) else remove("album_name")
            }
        )
    }

    companion object {
        private val REGEX_BRACKETED_SUFFIX = Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song|from\s*["']|soundtrack|ost).*?[\)\]\}]""", RegexOption.IGNORE_CASE)
        private val REGEX_FROM_SUFFIX = Regex("""\s*[\(\[\{]\s*from\s+.*?[\)\]\}]""", RegexOption.IGNORE_CASE)
        private val REGEX_DASH_SEPARATION = Regex("""\s+[-–]\s+""")
        private val REGEX_TRAILING_INFO = Regex("""\s*[-–:]\s*(?:official\s*video|official\s*audio|lyrics|lyric\s*video|from\s+["'].*?|soundtrack|ost)\s*$""", RegexOption.IGNORE_CASE)
        private val REGEX_FEAT_SUFFIX = Regex("""\s+(?:feat|ft)\.?\s+.*$""", RegexOption.IGNORE_CASE)
        private val REGEX_EMPTY_BRACKETS = Regex("""\s*[\(\[\{]\s*[\)\]\}]""")
        private val REGEX_WHITESPACE = Regex("""\s+""")
        private val REGEX_NON_WORD = Regex("""[^\p{L}\p{Nd}\s]""")
        private val REGEX_DELIMITERS = Regex("""[-–:]""")
        private val REGEX_ARTIST_SEPARATORS = Regex("""[,&]""")
        private val REGEX_GARBAGE_METRICS = Regex("""^[\d\s\.,kmb]+views?$""", RegexOption.IGNORE_CASE)
        private val REGEX_YOUTUBE_ID = Regex("^[a-zA-Z0-9_-]{11}$")
        private val REGEX_BASE64_CLEAN = Regex("^[A-Za-z0-9+/=_-]+$")
    }

    private fun cleanTrackTitle(title: String, artist: String): String {
        var t = unescapeHtml(title)
        // Strip pipe metadata: "Song Title | Movie | Actors | Label" -> "Song Title"
        if (t.contains("|")) {
            val beforePipe = t.substringBefore("|").trim()
            if (beforePipe.isNotBlank()) {
                t = beforePipe
            }
        }
        // Strip double slashes or colons
        if (t.contains("//")) {
            val beforeSlash = t.substringBefore("//").trim()
            if (beforeSlash.isNotBlank()) {
                t = beforeSlash
            }
        }
        // Remove bracketed suffixes: (Official Music Video), [Official Audio], (Lyrics), (From "Movie"), etc.
        t = t.replace(REGEX_BRACKETED_SUFFIX, "")
        t = t.replace(REGEX_FROM_SUFFIX, "")
        // Remove artist prefixes/suffixes if repeated
        if (artist.isNotBlank() && !isGarbageArtist(artist)) {
            val trimmedArtist = artist.trim()
            if (t.startsWith(trimmedArtist, ignoreCase = true)) {
                val rem = t.substring(trimmedArtist.length).trimStart(' ', '\t', '-', '–', ':')
                if (rem.isNotBlank()) t = rem
            } else if (t.endsWith(trimmedArtist, ignoreCase = true)) {
                val rem = t.substring(0, t.length - trimmedArtist.length).trimEnd(' ', '\t', '-', '–', ':')
                if (rem.isNotBlank()) t = rem
            }
        } else if (t.contains(" - ") || t.contains(" – ")) {
            // If artist is generic, strip "Artist - " prefix if present!
            val parts = t.split(REGEX_DASH_SEPARATION)
            if (parts.size >= 2 && parts[1].isNotBlank()) {
                t = parts[1].trim()
            }
        }
        // Remove trailing " - Official Video", " - From ...", etc.
        t = t.replace(REGEX_TRAILING_INFO, "")
        // Remove unparenthesized "feat. ..."
        t = t.replace(REGEX_FEAT_SUFFIX, "")
        t = t.replace(REGEX_EMPTY_BRACKETS, "")
        // Clean whitespace
        t = t.replace(REGEX_WHITESPACE, " ").trim()
        return if (t.isNotBlank()) t else title.trim()
    }

    private fun scoreTrackCandidate(
        candidateTitle: String,
        candidateArtist: String,
        targetTitle: String,
        targetArtist: String,
        candidateDurationMs: Long? = null,
        targetDurationMs: Long? = null
    ): Int {
        val cTitle = unescapeHtml(candidateTitle).lowercase().trim().replace(REGEX_NON_WORD, " ")
        val cArtist = unescapeHtml(candidateArtist).lowercase().trim().replace(REGEX_NON_WORD, " ")
        val tTitle = unescapeHtml(targetTitle).lowercase().trim().replace(REGEX_NON_WORD, " ")
        val tArtist = unescapeHtml(targetArtist).lowercase().trim().replace(REGEX_NON_WORD, " ")

        val normCTitle = cTitle.replace(REGEX_WHITESPACE, " ").trim()
        val normTTitle = tTitle.replace(REGEX_WHITESPACE, " ").trim()
        if (normCTitle.isBlank() || normTTitle.isBlank()) return 0

        var score = 0
        val cleanC = cleanTrackTitle(candidateTitle, "").lowercase().trim().replace(REGEX_NON_WORD, " ").replace(REGEX_WHITESPACE, " ").trim()
        val cleanT = cleanTrackTitle(targetTitle, "").lowercase().trim().replace(REGEX_NON_WORD, " ").replace(REGEX_WHITESPACE, " ").trim()

        val baseC = cleanC.substringBefore("-").trim()
        val baseT = cleanT.substringBefore("-").trim()

        val isExactTitleMatch = (normCTitle == normTTitle) ||
                (cleanC.isNotBlank() && cleanC == cleanT) ||
                ((baseC.isNotBlank() && baseC == cleanT) || (baseT.isNotBlank() && cleanC == baseT) || (baseC.isNotBlank() && baseT.isNotBlank() && baseC == baseT))

        if (isExactTitleMatch) {
            score += 60
        } else if (normCTitle.startsWith(normTTitle) || normTTitle.startsWith(normCTitle) || (cleanC.isNotBlank() && cleanT.isNotBlank() && (cleanC.startsWith(cleanT) || cleanT.startsWith(cleanC)))) {
            score += 40
        } else if (normCTitle.contains(normTTitle) || normTTitle.contains(normCTitle)) {
            score += 30
        }

        // Check Dash / Colon separation: "Artist - Title" or "Title - Artist"
        if (targetTitle.contains("-") || targetTitle.contains("–") || targetTitle.contains(":")) {
            val parts = targetTitle.split(REGEX_DELIMITERS).map { it.trim() }.filter { it.isNotBlank() }
            if (parts.size >= 2) {
                val pArt = parts[0].lowercase().replace(REGEX_NON_WORD, " ").replace(REGEX_WHITESPACE, " ").trim()
                val pTit = parts.drop(1).joinToString(" ").lowercase().replace(REGEX_NON_WORD, " ").replace(REGEX_WHITESPACE, " ").trim()
                // Artist - Title
                if (normCTitle == pTit || cleanC == pTit || pTit.contains(normCTitle) || normCTitle.contains(pTit)) {
                    if (cArtist.isNotBlank() && (cArtist.contains(pArt) || pArt.contains(cArtist))) {
                        score = maxOf(score, 85)
                    } else {
                        score = maxOf(score, 60)
                    }
                }
                // Title - Artist
                if (normCTitle == pArt || cleanC == pArt || pArt.contains(normCTitle) || normCTitle.contains(pArt)) {
                    if (cArtist.isNotBlank() && (cArtist.contains(pTit) || pTit.contains(cArtist))) {
                        score = maxOf(score, 85)
                    } else {
                        score = maxOf(score, 60)
                    }
                }
            }
        }

        if (score == 0) {
            val tWords = normTTitle.split(" ").filter { it.length > 2 }
            if (tWords.isNotEmpty()) {
                val matches = tWords.count { normCTitle.contains(it) }
                val ratio = matches.toFloat() / tWords.size
                if (ratio >= 0.75f) score += (30 * ratio).toInt() else return 0
            } else return 0
        }

        // Penalize remix/cover if target is not remix/cover
        val isTargetRemix = normTTitle.contains("remix") || normTTitle.contains("cover") || normTTitle.contains("live")
        val isCandRemix = normCTitle.contains("remix") || normCTitle.contains("cover") || normCTitle.contains("live") || normCTitle.contains("karaoke")
        if (isCandRemix && !isTargetRemix) {
            score -= 40
        }

        if (tArtist.isNotBlank() && !isGarbageArtist(tArtist)) {
            val normCArtist = cArtist.replace(REGEX_WHITESPACE, " ").trim()
            val normTArtist = tArtist.replace(REGEX_WHITESPACE, " ").trim()
            if (normCArtist.contains(normTArtist) || normTArtist.contains(normCArtist)) {
                score += 35
            } else {
                val firstWord = normTArtist.split(" ").firstOrNull { it.length > 2 }
                if (firstWord != null && normCArtist.contains(firstWord)) {
                    score += 20
                } else {
                    // Zero word overlap: If Title is an Exact Match (+60) AND duration matches within ±3000ms,
                    // award a Duration + Exact Title Synergy Bonus of +15 points (Total = 60 + 15 = 75),
                    // qualifying genuine regional/soundtrack tracks while blocking mismatches.
                    val isDurationMatch = candidateDurationMs != null && targetDurationMs != null &&
                            Math.abs(candidateDurationMs - targetDurationMs) <= 3000L
                    if (isExactTitleMatch && isDurationMatch) {
                        score += 15
                    } else {
                        // Conflicting artist with duration mismatch or non-exact title: reject candidate immediately
                        return 0
                    }
                }
            }
        }
        return score.coerceAtLeast(0)
    }

    private fun decryptSaavnRaw(encUrl: String): String? {
        return runCatching {
            val cleanEnc = encUrl.replace("\\/", "/").replace("\\", "").trim()
            if (cleanEnc.length < 8 || cleanEnc.length > 2048) return null
            if (!cleanEnc.matches(REGEX_BASE64_CLEAN)) return null
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

    private suspend fun resolveSaavnStudioStream(
        query: String,
        targetTitle: String,
        targetArtist: String,
        targetDurationMs: Long? = null,
        trackId: String? = null
    ): Pair<Track, List<Streamable.Source.Http>>? = withContext(Dispatchers.IO) {
        // Direct ID resolution if numeric JioSaavn track ID is present
        if (!trackId.isNullOrBlank() && trackId.length >= 6 && trackId.all { it.isDigit() }) {
            val directResult = runCatching {
                val url = "https://www.jiosaavn.com/api.php?__call=song.getDetails&cc=in&_marker=0%3F_marker%3D0&_format=json&pids=$trackId"
                val req = Request.Builder().url(url).header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)").build()
                okHttpClient.newCall(req).execute().use { resp ->
                    if (!resp.isSuccessful) return@use null
                    val body = resp.body?.string() ?: return@use null
                    val root = jsonParser.parseToJsonElement(body).jsonObject
                    val songObj = root[trackId]?.jsonObject ?: root.values.firstOrNull()?.jsonObject ?: return@use null
                    val enc = songObj["encrypted_media_url"]?.jsonPrimitive?.content
                    val preview = songObj["media_preview_url"]?.jsonPrimitive?.content
                    val sources = getSaavnMultiQualitySources(enc, preview)
                    if (sources.isNotEmpty()) {
                        val sTitle = unescapeHtml(songObj["song"]?.jsonPrimitive?.content ?: targetTitle)
                        val sArtist = unescapeHtml(songObj["primary_artists"]?.jsonPrimitive?.content ?: targetArtist)
                        val sAlbum = unescapeHtml(songObj["album"]?.jsonPrimitive?.content ?: "")
                        val sImage = songObj["image"]?.jsonPrimitive?.content?.replace("150x150", "500x500")?.replace("50x50", "500x500") ?: ""
                        val sDur = songObj["duration"]?.jsonPrimitive?.content?.toLongOrNull()?.times(1000L)
                        val sArtList = if (sArtist.contains(",") || sArtist.contains("&")) {
                            sArtist.split(REGEX_ARTIST_SEPARATORS).map { it.trim() }.filter { it.isNotBlank() && !isGarbageArtist(it) }.map { Artist(id = it, name = it) }
                        } else listOf(Artist(id = sArtist, name = sArtist))
                        val coverHolder = if (sImage.isNotBlank()) ImageHolder.NetworkRequestImageHolder(request = sImage.toGetRequest(), crop = false) else null
                        val resolvedTrack = Track(
                            id = trackId,
                            title = sTitle,
                            artists = sArtList,
                            album = if (sAlbum.isNotBlank()) Album(id = sAlbum, title = sAlbum, cover = coverHolder) else null,
                            cover = coverHolder,
                            duration = sDur,
                            extras = buildMap {
                                put("extension_id", "saavn_music")
                                put("source", "JioSaavn")
                                put("track_title", sTitle)
                                put("artist_name", sArtist)
                                if (sImage.isNotBlank()) put("cover_url", sImage)
                                if (sAlbum.isNotBlank()) put("album_name", sAlbum)
                            }
                        )
                        Pair(resolvedTrack, sources)
                    } else null
                }
            }.getOrNull()
            if (directResult != null) return@withContext directResult
        }

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
                val candDurationSec = obj["duration"]?.jsonPrimitive?.content?.toDoubleOrNull()
                val candDurationMs = candDurationSec?.let { (it * 1000).toLong() }
                val score = scoreTrackCandidate(songTitle, songArtist, targetTitle, targetArtist, candDurationMs, targetDurationMs)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            // Strictly require an authentic match (score >= 75).
            // Reject low confidence or wrong-artist candidates so we don't play wrong songs or overwrite metadata with unrelated tracks.
            if (bestScore < 75 || bestObj == null) {
                println("[PlayerViewModel] JioSaavn match score ($bestScore) below threshold (75) for '$targetTitle' by '$targetArtist'")
                return@withContext null
            }

            val chosen = bestObj
            val enc = chosen["encrypted_media_url"]?.jsonPrimitive?.content
            val preview = chosen["media_preview_url"]?.jsonPrimitive?.content
            val sources = getSaavnMultiQualitySources(enc, preview)

            if (sources.isNotEmpty()) {
                val rawTitle = chosen["song"]?.jsonPrimitive?.content ?: targetTitle
                val rawArtist = chosen["primary_artists"]?.jsonPrimitive?.content ?: targetArtist
                val realTitle = unescapeHtml(rawTitle)
                val realArtist = unescapeHtml(rawArtist)
                val rawAlbum = chosen["album"]?.jsonPrimitive?.content ?: ""
                val realAlbum = unescapeHtml(rawAlbum)
                val rawImage = chosen["image"]?.jsonPrimitive?.content ?: ""
                val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
                val durationStr = chosen["duration"]?.jsonPrimitive?.content
                val durationMs = durationStr?.toLongOrNull()?.times(1000L)

                val resolvedTrack = Track(
                    id = chosen["id"]?.jsonPrimitive?.content ?: "saavn_track",
                    title = realTitle,
                    artists = listOf(Artist(id = realArtist, name = realArtist)),
                    album = if (realAlbum.isNotBlank()) Album(id = realAlbum, title = realAlbum) else null,
                    cover = if (highResImage.isNotBlank()) highResImage.toImageHolder() else null,
                    duration = durationMs,
                    extras = buildMap {
                        put("stream_url", sources.first().request.url)
                        put("source", "JioSaavn")
                        put("extension_id", "saavn_music")
                        put("track_title", realTitle)
                        put("artist_name", realArtist)
                        if (highResImage.isNotBlank()) {
                            put("cover_url", highResImage)
                        }
                    }
                )
                return@withContext Pair(resolvedTrack, sources)
            }
            null
        }.getOrNull()
    }

    private suspend fun resolveSoundCloudStream(query: String, targetTitle: String = "", targetArtist: String = "", targetDurationMs: Long? = null): String? = withContext(Dispatchers.IO) {
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

            var chosenTrackObj: kotlinx.serialization.json.JsonObject? = null
            var bestScore = -1
            if (targetTitle.isNotBlank()) {
                for (elem in collection) {
                    val tObj = elem.jsonObject
                    val cTitle = tObj["title"]?.jsonPrimitive?.content ?: ""
                    val cArtist = tObj["user"]?.jsonObject?.get("username")?.jsonPrimitive?.content ?: ""
                    val candDurationMs = tObj["duration"]?.jsonPrimitive?.content?.toLongOrNull()
                    val score = scoreTrackCandidate(cTitle, cArtist, targetTitle, targetArtist, candDurationMs, targetDurationMs)
                    if (score > bestScore) {
                        bestScore = score
                        chosenTrackObj = tObj
                    }
                }
                if (bestScore < 75 || chosenTrackObj == null) {
                    println("[PlayerViewModel] SoundCloud candidate score ($bestScore) below threshold (75) for '$targetTitle'")
                    return@runCatching null
                }
            }

            val trackObj = chosenTrackObj ?: if (targetTitle.isBlank()) collection[0].jsonObject else return@runCatching null
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
                track.extras.containsKey("video_id") || track.id.matches(Regex("^[a-zA-Z0-9_-]{11}$")) -> {
                    allMusic.firstOrNull { it.id.contains("youtube", ignoreCase = true) }
                }
                track.extras["source"]?.equals("JioSaavn", ignoreCase = true) == true ||
                track.extras["stream_url"]?.contains("saavn") == true ||
                (track.id.length >= 6 && track.id.all { it.isDigit() }) -> {
                    allMusic.firstOrNull { it.id.contains("saavn", ignoreCase = true) }
                }
                track.id.startsWith("sc_") -> {
                    allMusic.firstOrNull { it.id.contains("soundcloud", ignoreCase = true) }
                }
                track.extras.containsKey("spotify_uri") || track.id.startsWith("spotify:") -> {
                    allMusic.firstOrNull { it.id.contains("spotify", ignoreCase = true) }
                }
                track.id.startsWith("local_") || track.extras.containsKey("local_file") -> {
                    allMusic.firstOrNull { it.id.contains("local", ignoreCase = true) }
                }
                track.extras["is_live"] == "true" -> {
                    allMusic.firstOrNull { it.id.contains("radio", ignoreCase = true) }
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
            val localCleaned = sanitizeTrackLocally(track)
            val rawArtist = localCleaned.artists.firstOrNull { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }?.name ?: ""
            val cleanTitle = cleanTrackTitle(localCleaned.title, rawArtist)
            val searchQuery = if (rawArtist.isNotBlank()) "$cleanTitle $rawArtist" else cleanTitle

            val saavnResult = resolveSaavnStudioStream(searchQuery, cleanTitle, rawArtist, localCleaned.duration)
            if (saavnResult != null) {
                return@withContext saavnResult.second.firstOrNull()?.request?.url
            }

            val scStream = resolveSoundCloudStream(searchQuery, cleanTitle, rawArtist, localCleaned.duration)
            if (!scStream.isNullOrBlank()) {
                return@withContext scStream
            }

            null
        }.getOrNull()
    }

    private val metadataEnrichmentCache = java.util.concurrent.ConcurrentHashMap<String, Track>()

    suspend fun searchJioSaavnMetadata(query: String, targetTitle: String, targetArtist: String, targetDurationMs: Long? = null): Track? = withContext(Dispatchers.IO) {
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
                val candDurationSec = obj["duration"]?.jsonPrimitive?.content?.toDoubleOrNull()
                val candDurationMs = candDurationSec?.let { (it * 1000).toLong() }
                val score = scoreTrackCandidate(songTitle, songArtist, targetTitle, targetArtist, candDurationMs, targetDurationMs)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            if (bestScore < 75 || bestObj == null) return@runCatching null

            val chosen = bestObj
            val rawTitle = chosen["song"]?.jsonPrimitive?.content ?: targetTitle
            val rawArtist = chosen["primary_artists"]?.jsonPrimitive?.content ?: targetArtist
            val realTitle = unescapeHtml(rawTitle)
            val realArtist = unescapeHtml(rawArtist)
            val rawAlbum = chosen["album"]?.jsonPrimitive?.content ?: ""
            val realAlbum = unescapeHtml(rawAlbum)
            val rawImage = chosen["image"]?.jsonPrimitive?.content ?: ""
            val highResImage = rawImage.replace("150x150", "500x500").replace("50x50", "500x500")
            val durationStr = chosen["duration"]?.jsonPrimitive?.content
            val durationMs = durationStr?.toLongOrNull()?.times(1000L)

            val artistList = if (realArtist.contains(",") || realArtist.contains("&")) {
                realArtist.split(REGEX_ARTIST_SEPARATORS).map { it.trim() }.filter { it.isNotBlank() && !isGarbageArtist(it) }.map { Artist(id = it, name = it) }
            } else listOf(Artist(id = realArtist, name = realArtist))

            val coverHolder = if (highResImage.isNotBlank()) {
                ImageHolder.NetworkRequestImageHolder(request = highResImage.toGetRequest(), crop = false)
            } else null

            Track(
                id = chosen["id"]?.jsonPrimitive?.content ?: "saavn_meta",
                title = realTitle,
                artists = if (artistList.isNotEmpty()) artistList else listOf(Artist(id = realArtist, name = realArtist)),
                album = if (realAlbum.isNotBlank()) Album(id = realAlbum, title = realAlbum, cover = coverHolder) else null,
                cover = coverHolder,
                duration = durationMs,
                extras = buildMap {
                    put("metadata_source", "JioSaavn")
                    put("track_title", realTitle)
                    put("artist_name", realArtist)
                    if (highResImage.isNotBlank()) put("cover_url", highResImage)
                    if (realAlbum.isNotBlank()) put("album_name", realAlbum)
                }
            )
        }.getOrNull()
    }

    suspend fun searchITunesMetadata(query: String, targetTitle: String, targetArtist: String, targetDurationMs: Long? = null): Track? = withContext(Dispatchers.IO) {
        runCatching {
            val encoded = java.net.URLEncoder.encode(query, "UTF-8")
            val url = "https://itunes.apple.com/search?term=$encoded&media=music&limit=5"
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
                val songTitle = obj["trackName"]?.jsonPrimitive?.content ?: ""
                val songArtist = obj["artistName"]?.jsonPrimitive?.content ?: ""
                val candDurationMs = obj["trackTimeMillis"]?.jsonPrimitive?.content?.toLongOrNull()
                val score = scoreTrackCandidate(songTitle, songArtist, targetTitle, targetArtist, candDurationMs, targetDurationMs)
                if (score > bestScore) {
                    bestScore = score
                    bestObj = obj
                }
            }

            if (bestScore < 75 || bestObj == null) return@runCatching null

            val chosen = bestObj
            val rawTitle = chosen["trackName"]?.jsonPrimitive?.content ?: targetTitle
            val rawArtist = chosen["artistName"]?.jsonPrimitive?.content ?: targetArtist
            val realTitle = unescapeHtml(rawTitle)
            val realArtist = unescapeHtml(rawArtist)
            val rawAlbum = chosen["collectionName"]?.jsonPrimitive?.content ?: ""
            val realAlbum = unescapeHtml(rawAlbum)
            val rawImage = chosen["artworkUrl100"]?.jsonPrimitive?.content ?: ""
            val highResImage = rawImage.replace("100x100bb.jpg", "600x600bb.jpg").replace("100x100bb.png", "600x600bb.jpg")
            val durationMs = chosen["trackTimeMillis"]?.jsonPrimitive?.content?.toLongOrNull()

            val artistList = if (realArtist.contains(",") || realArtist.contains("&")) {
                realArtist.split(REGEX_ARTIST_SEPARATORS).map { it.trim() }.filter { it.isNotBlank() && !isGarbageArtist(it) }.map { Artist(id = it, name = it) }
            } else listOf(Artist(id = realArtist, name = realArtist))

            val coverHolder = if (highResImage.isNotBlank()) {
                ImageHolder.NetworkRequestImageHolder(request = highResImage.toGetRequest(), crop = false)
            } else null

            Track(
                id = chosen["trackId"]?.jsonPrimitive?.content ?: "itunes_meta",
                title = realTitle,
                artists = if (artistList.isNotEmpty()) artistList else listOf(Artist(id = realArtist, name = realArtist)),
                album = if (realAlbum.isNotBlank()) Album(id = realAlbum, title = realAlbum, cover = coverHolder) else null,
                cover = coverHolder,
                duration = durationMs,
                extras = buildMap {
                    put("metadata_source", "iTunes")
                    put("track_title", realTitle)
                    put("artist_name", realArtist)
                    if (highResImage.isNotBlank()) put("cover_url", highResImage)
                    if (realAlbum.isNotBlank()) put("album_name", realAlbum)
                }
            )
        }.getOrNull()
    }

    fun needsOnlineEnrichment(track: Track): Boolean {
        val hasValidArtist = track.artists.any { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }
        if (!hasValidArtist) return true

        val t = track.title
        if (isSpamTitle(t)) return true

        val coverUrl = when (val c = track.cover ?: track.album?.cover) {
            is ImageHolder.NetworkRequestImageHolder -> c.request.url
            is ImageHolder.ResourceUriImageHolder -> c.uri
            else -> null
        } ?: track.extras["cover_url"]

        if (isLowResOrGenericCover(coverUrl)) return true
        val alb = track.album
        if (alb == null || alb.title.isBlank() || isGarbageAlbum(alb.title)) return true

        // If track came from YouTube or SoundCloud without verified studio metadata, enrich it!
        val source = track.extras["source"]
        if (source != "JioSaavn" && source != "iTunes" && track.extras["is_enriched"] != "true") return true

        return false
    }

    suspend fun enrichTrackOnline(track: Track): Track = withContext(Dispatchers.IO) {
        val cacheKey = track.id.ifBlank { "${track.title}_${track.artists.firstOrNull()?.name}" }
        metadataEnrichmentCache[cacheKey]?.let { return@withContext it }

        var rawArtist = track.artists.firstOrNull { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }?.name ?: ""
        var cleanTitle = cleanTrackTitle(track.title, rawArtist)

        if (rawArtist.isBlank() && (track.title.contains(" - ") || track.title.contains(" – "))) {
            val parts = track.title.split(REGEX_DASH_SEPARATION)
            if (parts.size >= 2 && parts[0].isNotBlank() && parts[0].length < 40 && !isGarbageArtist(parts[0])) {
                rawArtist = cleanArtistName(parts[0].trim())
                cleanTitle = cleanTrackTitle(parts.drop(1).joinToString(" - "), rawArtist)
            }
        }

        if (cleanTitle.isBlank()) return@withContext track

        val query = if (rawArtist.isNotBlank()) "$cleanTitle $rawArtist" else cleanTitle

        val saavnTrack = searchJioSaavnMetadata(query, cleanTitle, rawArtist, track.duration)
        if (saavnTrack != null) {
            val chosenTitle = if (track.title.isNotBlank() && !isSpamTitle(track.title)) track.title else saavnTrack.title
            val chosenArtists = if (track.artists.any { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }) track.artists else saavnTrack.artists
            val merged = track.copy(
                title = chosenTitle,
                artists = chosenArtists,
                album = saavnTrack.album ?: track.album?.takeIf { !isGarbageAlbum(it.title) },
                cover = saavnTrack.cover ?: track.cover,
                duration = if ((saavnTrack.duration ?: 0L) > 0L) saavnTrack.duration else track.duration,
                extras = buildMap {
                    putAll(saavnTrack.extras)
                    putAll(track.extras) // Track's own original source and extension_id MUST PREVAIL!
                    if (!saavnTrack.extras["cover_url"].isNullOrBlank() && track.extras["cover_url"].isNullOrBlank()) {
                        put("cover_url", saavnTrack.extras["cover_url"]!!)
                    }
                    if (!saavnTrack.extras["album_name"].isNullOrBlank() && track.extras["album_name"].isNullOrBlank()) {
                        put("album_name", saavnTrack.extras["album_name"]!!)
                    }
                    put("is_enriched", "true")
                    put("metadata_source", "JioSaavn")
                }
            )
            val sanitizedMerged = sanitizeTrackLocally(merged)
            metadataEnrichmentCache[cacheKey] = sanitizedMerged
            return@withContext sanitizedMerged
        }

        val itunesTrack = searchITunesMetadata(query, cleanTitle, rawArtist, track.duration)
        if (itunesTrack != null) {
            val chosenTitle = if (track.title.isNotBlank() && !isSpamTitle(track.title)) track.title else itunesTrack.title
            val chosenArtists = if (track.artists.any { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }) track.artists else itunesTrack.artists
            val merged = track.copy(
                title = chosenTitle,
                artists = chosenArtists,
                album = itunesTrack.album ?: track.album?.takeIf { !isGarbageAlbum(it.title) },
                cover = itunesTrack.cover ?: track.cover,
                duration = if ((itunesTrack.duration ?: 0L) > 0L) itunesTrack.duration else track.duration,
                extras = buildMap {
                    putAll(itunesTrack.extras)
                    putAll(track.extras) // Track's own original source and extension_id MUST PREVAIL!
                    if (!itunesTrack.extras["cover_url"].isNullOrBlank() && track.extras["cover_url"].isNullOrBlank()) {
                        put("cover_url", itunesTrack.extras["cover_url"]!!)
                    }
                    if (!itunesTrack.extras["album_name"].isNullOrBlank() && track.extras["album_name"].isNullOrBlank()) {
                        put("album_name", itunesTrack.extras["album_name"]!!)
                    }
                    put("is_enriched", "true")
                    put("metadata_source", "iTunes")
                }
            )
            val sanitizedMerged = sanitizeTrackLocally(merged)
            metadataEnrichmentCache[cacheKey] = sanitizedMerged
            return@withContext sanitizedMerged
        }

        track
    }

    fun playWithQueue(track: Track, newQueue: List<Track>) {
        val cleanQueue = newQueue.map { sanitizeTrackLocally(it) }
        val cleanTrack = sanitizeTrackLocally(track)
        if (cleanQueue.isNotEmpty()) {
            val idx = cleanQueue.indexOfFirst { it.id == cleanTrack.id }.coerceAtLeast(0)
            player.setQueue(cleanQueue, idx)
        }
        play(cleanTrack)
    }

    private var currentPlayJob: Job? = null
    private val playRequestId = java.util.concurrent.atomic.AtomicLong(0L)

    fun play(track: Track) {
        val currentToken = playRequestId.incrementAndGet()
        failedTracks.remove(track.id)
        currentPlayJob?.cancel()
        currentPlayJob = scope.launch {
            runCatching {
                if (currentToken != playRequestId.get() || !isActive) return@runCatching
                // 1. Maintain queue and immediately sanitize locally so UI never shows "Song" or spam titles
                val localCleaned = sanitizeTrackLocally(track)
                if (player.queue.value.none { it.id == localCleaned.id }) {
                    player.addToQueue(listOf(localCleaned), player.queue.value.size)
                }
                player.prepareTrack(localCleaned)

                // 2. Perform online enrichment if track has incomplete metadata, spam title, or low-res cover
                var workingTrack = localCleaned
                if (needsOnlineEnrichment(workingTrack)) {
                    val enriched = enrichTrackOnline(workingTrack)
                    if (enriched != workingTrack) {
                        workingTrack = sanitizeTrackLocally(enriched)
                        player.prepareTrack(workingTrack)
                    }
                }

                var loadedTrack = workingTrack
                var mediaToPlay: Streamable.Media.Server? = null

                // 3. Direct stream URL fast path
                val directUrl = workingTrack.extras["stream_url"]
                    ?: workingTrack.servers.firstOrNull()?.extras?.get("stream_url")
                if (!directUrl.isNullOrBlank() && (directUrl.startsWith("http://") || directUrl.startsWith("https://") || directUrl.startsWith("file:/"))) {
                    val isLive = workingTrack.extras["is_live"] == "true"
                    val source = Streamable.Source.Http(
                        request = directUrl.toGetRequest(),
                        quality = 320,
                        title = if (isLive) "Live Radio" else "Direct Stream",
                        isLive = isLive
                    )
                    mediaToPlay = Streamable.Media.Server(listOf(source), merged = false)
                }

                // 4. Extension origin resolution
                if (mediaToPlay == null) {
                    val extIdFromTrack = workingTrack.extras["extension_id"]
                        ?: workingTrack.servers.firstOrNull()?.extras?.get("extension_id")
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
                        workingTrack.extras.containsKey("video_id") || workingTrack.id.matches(REGEX_YOUTUBE_ID) -> {
                            allMusic.firstOrNull { it.id.contains("youtube", ignoreCase = true) }
                        }
                        workingTrack.extras["source"]?.equals("JioSaavn", ignoreCase = true) == true ||
                        workingTrack.extras["stream_url"]?.contains("saavn") == true ||
                        (workingTrack.id.length >= 6 && workingTrack.id.all { it.isDigit() }) -> {
                            allMusic.firstOrNull { it.id.contains("saavn", ignoreCase = true) }
                        }
                        workingTrack.id.startsWith("sc_") -> {
                            allMusic.firstOrNull { it.id.contains("soundcloud", ignoreCase = true) }
                        }
                        workingTrack.extras.containsKey("spotify_uri") || workingTrack.id.startsWith("spotify:") -> {
                            allMusic.firstOrNull { it.id.contains("spotify", ignoreCase = true) }
                        }
                        workingTrack.id.startsWith("local_") || workingTrack.extras.containsKey("local_file") -> {
                            allMusic.firstOrNull { it.id.contains("local", ignoreCase = true) }
                        }
                        workingTrack.extras["is_live"] == "true" -> {
                            allMusic.firstOrNull { it.id.contains("radio", ignoreCase = true) }
                        }
                        else -> null
                    } ?: extensionManager.current.value ?: allMusic.firstOrNull()

                    if (matchingExtension != null) {
                        runCatching { extensionManager.setupMusicExtension(matchingExtension, false) }
                        val client = getTrackClient(matchingExtension)
                        if (client != null) {
                            runCatching {
                                withContext(Dispatchers.IO) {
                                    val loaded = client.loadTrack(workingTrack, false)
                                    val server = loaded.servers.firstOrNull() ?: loaded.streamables.firstOrNull() ?: workingTrack.servers.firstOrNull() ?: workingTrack.streamables.firstOrNull()
                                    if (server != null) {
                                        val resolvedMedia = client.loadStreamableMedia(server, false)
                                        if (resolvedMedia is Streamable.Media.Server && resolvedMedia.sources.isNotEmpty()) {
                                            mediaToPlay = resolvedMedia
                                            val cleanLoadedArtists = loaded.artists.filterNot { isGarbageArtist(it.name) || it.name == "Audix Hi-Res Audio" }
                                            val chosenTitle = if (workingTrack.title.isNotBlank() && !isSpamTitle(workingTrack.title)) workingTrack.title else cleanTrackTitle(loaded.title, "")
                                            val chosenArtists = if (workingTrack.artists.any { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }) workingTrack.artists else cleanLoadedArtists.ifEmpty { workingTrack.artists }
                                            val chosenCover = when {
                                                workingTrack.cover != null && !isLowResOrGenericCover(extractTrackCoverUrl(workingTrack)) -> workingTrack.cover
                                                loaded.cover != null && !isLowResOrGenericCover(extractTrackCoverUrl(loaded)) -> loaded.cover
                                                workingTrack.cover != null -> workingTrack.cover
                                                else -> loaded.cover
                                            }
                                            val cleanAlb = workingTrack.album?.takeIf { !isGarbageAlbum(it.title) } ?: loaded.album?.takeIf { !isGarbageAlbum(it.title) }
                                            loadedTrack = workingTrack.copy(
                                                title = cleanTrackTitle(chosenTitle, chosenArtists.firstOrNull()?.name ?: ""),
                                                artists = chosenArtists,
                                                album = cleanAlb,
                                                cover = chosenCover,
                                                duration = if ((workingTrack.duration ?: 0L) > 0L) workingTrack.duration else loaded.duration,
                                                streamables = loaded.streamables.ifEmpty { workingTrack.streamables },
                                                extras = workingTrack.extras + loaded.extras
                                            )
                                        }
                                    }
                                }
                            }.onFailure { err ->
                                println("[PlayerViewModel] Extension ${matchingExtension.id} resolution failed: ${err.message}")
                            }
                        }
                    }
                }

                // 5. Studio Engine Fallback (JioSaavn -> SoundCloud)
                if (mediaToPlay == null) {
                    val rawArtist = loadedTrack.artists.firstOrNull { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }?.name ?: ""
                    val cleanTitle = cleanTrackTitle(loadedTrack.title, rawArtist)
                    val searchQuery = if (rawArtist.isNotBlank()) "$cleanTitle $rawArtist" else cleanTitle

                    println("[PlayerViewModel] Resolving stream for '$cleanTitle' ($rawArtist) via Studio Engine...")

                    val saavnResult = resolveSaavnStudioStream(searchQuery, cleanTitle, rawArtist, loadedTrack.duration, loadedTrack.id)
                    if (saavnResult != null) {
                        val (resolvedTrack, sources) = saavnResult
                        val chosenTitle = if (loadedTrack.title.isNotBlank() && !isSpamTitle(loadedTrack.title)) loadedTrack.title else resolvedTrack.title
                        val chosenArtists = if (loadedTrack.artists.any { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }) loadedTrack.artists else resolvedTrack.artists
                        val cleanAlb = loadedTrack.album?.takeIf { !isGarbageAlbum(it.title) } ?: resolvedTrack.album?.takeIf { !isGarbageAlbum(it.title) }
                        loadedTrack = loadedTrack.copy(
                            title = cleanTrackTitle(chosenTitle, chosenArtists.firstOrNull()?.name ?: ""),
                            artists = chosenArtists,
                            album = cleanAlb,
                            cover = loadedTrack.cover ?: resolvedTrack.cover,
                            duration = if ((loadedTrack.duration ?: 0L) > 0L) loadedTrack.duration else resolvedTrack.duration,
                            extras = loadedTrack.extras + resolvedTrack.extras
                        )
                        mediaToPlay = Streamable.Media.Server(sources, merged = false)
                    }

                    if (mediaToPlay == null) {
                        val scStream = resolveSoundCloudStream(searchQuery, cleanTitle, rawArtist, loadedTrack.duration)
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

                // 6. Start Playback & Record Clean History
                if (mediaToPlay != null) {
                    if (!isActive || currentToken != playRequestId.get()) return@runCatching
                    val finalSanitized = sanitizeTrackLocally(loadedTrack)
                    println("[PlayerViewModel] Starting playback: '${finalSanitized.title}' by '${finalSanitized.artists.joinToString { it.name }}' (sources: ${mediaToPlay.sources.size})")
                    player.play(finalSanitized, mediaToPlay)

                    runCatching {
                        dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager.getOrNull()?.recordHistory(finalSanitized)
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
            val localCleaned = sanitizeTrackLocally(track)
            val rawArtist = localCleaned.artists.firstOrNull { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }?.name ?: ""
            val cleanTitle = cleanTrackTitle(localCleaned.title, rawArtist)
            val searchQuery = if (rawArtist.isNotBlank()) "$cleanTitle $rawArtist" else cleanTitle

            println("[PlayerViewModel] Executing auto-recovery fallback for '$cleanTitle' ($rawArtist)...")

            val saavnResult = resolveSaavnStudioStream(searchQuery, cleanTitle, rawArtist)
            if (saavnResult != null) {
                val (resolvedTrack, sources) = saavnResult
                val chosenTitle = if (localCleaned.title.isNotBlank() && !isSpamTitle(localCleaned.title)) localCleaned.title else resolvedTrack.title
                val chosenArtists = if (localCleaned.artists.any { !isGarbageArtist(it.name) && it.name != "Audix Hi-Res Audio" }) localCleaned.artists else resolvedTrack.artists
                val cleanAlb = localCleaned.album?.takeIf { !isGarbageAlbum(it.title) } ?: resolvedTrack.album?.takeIf { !isGarbageAlbum(it.title) }
                val finalTrack = sanitizeTrackLocally(localCleaned.copy(
                    title = cleanTrackTitle(chosenTitle, chosenArtists.firstOrNull()?.name ?: ""),
                    artists = chosenArtists,
                    album = cleanAlb,
                    cover = localCleaned.cover ?: resolvedTrack.cover,
                    duration = if ((localCleaned.duration ?: 0L) > 0L) localCleaned.duration else resolvedTrack.duration,
                    extras = localCleaned.extras + resolvedTrack.extras
                ))
                val media = Streamable.Media.Server(sources, merged = false)
                player.play(finalTrack, media)
                return@withContext
            }

            val scStream = resolveSoundCloudStream(searchQuery, cleanTitle, rawArtist)
            if (!scStream.isNullOrBlank()) {
                val source = Streamable.Source.Http(
                    request = scStream.toGetRequest(),
                    quality = 160,
                    title = "160 kbps (SoundCloud HQ)",
                    isLive = false
                )
                player.play(localCleaned, Streamable.Media.Server(listOf(source), merged = false))
                return@withContext
            }

            println("[PlayerViewModel] Auto-recovery could not find alternative stream for '${track.title}'")
        }.onFailure { err ->
            println("[PlayerViewModel] Error during studio fallback: ${err.message}")
        }
    }
}
