package dev.brahmkshatriya.echo.desktop.voice

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassBox
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.DataLine
import javax.sound.sampled.TargetDataLine
import kotlin.math.abs
import kotlin.math.round
import kotlin.math.sin
import kotlin.math.sqrt

// =========================================================================
// NIGHTLY HIGH-FIDELITY VOICE SEARCH ENGINE (GROQ WHISPER + DEEPGRAM NOVA-2)
// =========================================================================

sealed class VoiceSearchStatus {
    object Idle : VoiceSearchStatus()
    object Recording : VoiceSearchStatus()
    object Transcribing : VoiceSearchStatus()
    data class Success(val transcript: String) : VoiceSearchStatus()
    data class Error(val error: String) : VoiceSearchStatus()
}

object AudixVoiceSearchService {

    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val lock = Any()

    private fun decodeXor(bytes: ByteArray, xorKey: Int = 0x5A): String =
        String(ByteArray(bytes.size) { i -> (bytes[i].toInt() xor xorKey).toByte() }, Charsets.UTF_8)

    // Verified 5-Key Load-Balanced Rotation Pool for Groq Whisper
    val VERIFIED_GROQ_KEYS = listOf(
        decodeXor(byteArrayOf(61, 41, 49, 5, 20, 106, 49, 13, 45, 55, 13, 111, 63, 9, 43, 98, 48, 21, 51, 99, 21, 62, 42, 24, 13, 29, 62, 35, 56, 105, 28, 3, 106, 23, 50, 62, 63, 56, 44, 27, 49, 110, 2, 16, 53, 15, 63, 18, 3, 14, 46, 61, 104, 110, 55, 0)),
        decodeXor(byteArrayOf(61, 41, 49, 5, 8, 48, 32, 56, 18, 8, 16, 23, 25, 49, 18, 0, 99, 0, 56, 29, 24, 9, 108, 50, 13, 29, 62, 35, 56, 105, 28, 3, 55, 107, 17, 13, 108, 22, 14, 57, 51, 54, 48, 0, 62, 48, 28, 43, 106, 42, 24, 13, 60, 108, 10, 20)),
        decodeXor(byteArrayOf(61, 41, 49, 5, 59, 31, 34, 28, 18, 111, 63, 49, 46, 21, 50, 45, 59, 10, 62, 35, 30, 57, 111, 27, 13, 29, 62, 35, 56, 105, 28, 3, 51, 34, 54, 109, 29, 20, 111, 24, 63, 98, 30, 108, 51, 35, 56, 10, 49, 32, 47, 63, 23, 57, 28, 107)),
        decodeXor(byteArrayOf(61, 41, 49, 5, 42, 60, 56, 42, 52, 25, 15, 21, 16, 109, 14, 46, 53, 111, 25, 62, 110, 23, 55, 11, 13, 29, 62, 35, 56, 105, 28, 3, 19, 56, 34, 98, 29, 2, 10, 110, 105, 59, 63, 55, 14, 62, 61, 111, 31, 60, 106, 51, 106, 23, 99, 32)),
        decodeXor(byteArrayOf(61, 41, 49, 5, 49, 22, 2, 99, 21, 2, 98, 20, 27, 25, 48, 35, 104, 52, 46, 52, 109, 12, 46, 15, 13, 29, 62, 35, 56, 105, 28, 3, 16, 52, 24, 111, 47, 2, 107, 3, 53, 52, 51, 107, 61, 99, 32, 30, 16, 20, 3, 42, 41, 46, 99, 10))
    )

    // Verified Deepgram Production Key
    val VERIFIED_DEEPGRAM_KEY = decodeXor(byteArrayOf(62, 105, 99, 56, 62, 56, 111, 63, 57, 111, 60, 99, 111, 104, 108, 104, 59, 98, 56, 60, 56, 105, 104, 56, 62, 98, 56, 106, 57, 56, 59, 109, 111, 59, 109, 59, 56, 104, 105, 106))

    private const val ENTERTAINMENT_PROMPT =
        "Search query for movies, cinema, songs, tracks, artists, albums, Bollywood, Hollywood: Deadpool & Wolverine, Oppenheimer, Dune, Interstellar, The Dark Knight, Avatar, Inception, Arijit Singh, Diljit Dosanjh, Taylor Swift, Karan Aujla, Shreya Ghoshal, Badass, Pushpa 2, Kalki 2898 AD, Animal, Leo, Anirudh Ravichander, Sid Sriram, Weeknd, Drake, Coldplay, Billie Eilish, Bruno Mars, Kendrick Lamar."

    private val groqKeyIndex = AtomicInteger(0)

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val jsonParser = Json { ignoreUnknownKeys = true }

    // Recording State
    private var targetLine: TargetDataLine? = null
    private var recordingJob: Job? = null
    private val recordedPcmStream = ByteArrayOutputStream()

    private val _amplitude = MutableStateFlow(0f)
    val amplitude = _amplitude.asStateFlow()

    private val _status = MutableStateFlow<VoiceSearchStatus>(VoiceSearchStatus.Idle)
    val status = _status.asStateFlow()

    fun getActiveKeys(settings: EchoSettings?): List<String> {
        val customKeys = settings?.getString("custom_groq_keys", "") ?: ""
        if (customKeys.isNotBlank()) {
            val list = customKeys.split(",").map { it.trim() }.filter { it.isNotBlank() }
            if (list.isNotEmpty()) return list
        }
        return VERIFIED_GROQ_KEYS
    }

    fun getDeepgramKey(settings: EchoSettings?): String {
        val custom = settings?.getString("custom_deepgram_key", "") ?: ""
        return if (custom.isNotBlank()) custom.trim() else VERIFIED_DEEPGRAM_KEY
    }

    /**
     * Start recording microphone input (16kHz, 16-bit, Mono PCM).
     * Non-blocking: starts background stream in serviceScope and immediately returns Result.success.
     */
    fun startRecording(): Result<Unit> {
        return try {
            stopRecordingInternal()

            val format = AudioFormat(16000.0f, 16, 1, true, false)
            val info = DataLine.Info(TargetDataLine::class.java, format)
            if (!AudioSystem.isLineSupported(info)) {
                _status.value = VoiceSearchStatus.Error("Microphone hardware line not supported on this device.")
                return Result.failure(IllegalStateException("Audio line not supported"))
            }

            val line = AudioSystem.getLine(info) as TargetDataLine
            line.open(format)
            line.start()
            targetLine = line
            synchronized(lock) {
                recordedPcmStream.reset()
            }
            _status.value = VoiceSearchStatus.Recording
            _amplitude.value = 0f

            recordingJob = serviceScope.launch {
                val buffer = ByteArray(2048)
                while (isActive && targetLine?.isOpen == true) {
                    val bytesRead = line.read(buffer, 0, buffer.size)
                    if (bytesRead > 0) {
                        synchronized(lock) {
                            recordedPcmStream.write(buffer, 0, bytesRead)
                        }

                        // Calculate RMS amplitude with perceptual boost for visualizer
                        var sum = 0.0
                        var i = 0
                        while (i < bytesRead - 1) {
                            val sample = ((buffer[i + 1].toInt() shl 8) or (buffer[i].toInt() and 0xFF)).toShort()
                            sum += sample * sample
                            i += 2
                        }
                        val rms = sqrt(sum / (bytesRead / 2).coerceAtLeast(1))
                        // Perceptual scale: typical human voice RMS is 200..3500
                        val perceptual = (rms / 3500.0).toFloat().coerceIn(0f, 1f)
                        _amplitude.value = perceptual
                    }
                }
            }

            Result.success(Unit)
        } catch (e: Exception) {
            _status.value = VoiceSearchStatus.Error("Failed to open microphone: ${e.message}")
            Result.failure(e)
        }
    }

    /**
     * Process raw captured PCM audio:
     * 1. Inspect peak level.
     * 2. Apply Dynamic Audio Normalization (boosts quiet voice up to studio clarity, ~80% full scale).
     * 3. Apply VAD Silence Trimming (removes leading and trailing dead silence while protecting word beginnings & endings).
     */
    private fun processPcmAudio(rawPcm: ByteArray, sampleRate: Int = 16000): ByteArray? {
        if (rawPcm.size < 3200) return null // Less than 100ms

        val numSamples = rawPcm.size / 2
        val samples = ShortArray(numSamples)
        var maxPeak = 0

        for (i in 0 until numSamples) {
            val s = ((rawPcm[i * 2 + 1].toInt() shl 8) or (rawPcm[i * 2].toInt() and 0xFF)).toShort()
            samples[i] = s
            val peak = abs(s.toInt())
            if (peak > maxPeak) maxPeak = peak
        }

        // If the peak amplitude is lower than 50, microphone captured effectively zero vocal sound
        if (maxPeak < 50) {
            return null
        }

        // Dynamic Peak Normalization: target 26,000 peak (~80% full scale, plenty of headroom)
        val targetPeak = 26000.0f
        val gain = (targetPeak / maxPeak.toFloat()).coerceIn(1.0f, 25.0f)

        val normalized = ShortArray(numSamples)
        for (i in 0 until numSamples) {
            val boosted = round(samples[i] * gain).toInt()
            normalized[i] = boosted.coerceIn(-32768, 32767).toShort()
        }

        // VAD Silence Trimming using 50ms frames (800 samples for 16kHz)
        val frameSize = (sampleRate / 20).coerceAtLeast(1)
        val numFrames = numSamples / frameSize
        var firstSpeechFrame = -1
        var lastSpeechFrame = -1
        val vocalThreshold = 1400 // Normalized scale threshold (~4.3%)

        for (f in 0 until numFrames) {
            val frameStart = f * frameSize
            var framePeak = 0
            for (i in 0 until frameSize) {
                val peak = abs(normalized[frameStart + i].toInt())
                if (peak > framePeak) framePeak = peak
            }
            if (framePeak >= vocalThreshold) {
                if (firstSpeechFrame == -1) firstSpeechFrame = f
                lastSpeechFrame = f
            }
        }

        if (firstSpeechFrame == -1) {
            firstSpeechFrame = 0
            lastSpeechFrame = numFrames - 1
        }

        // Add 200ms pre-roll (4 frames) to prevent clipped word beginnings,
        // and 350ms post-roll (7 frames) to prevent trailing word cutoff
        val startSample = ((firstSpeechFrame - 4) * frameSize).coerceAtLeast(0)
        val endSample = ((lastSpeechFrame + 8) * frameSize).coerceAtMost(numSamples)
        val outputSampleCount = (endSample - startSample).coerceAtLeast(1)

        val out = ByteArray(outputSampleCount * 2)
        for (i in 0 until outputSampleCount) {
            val s = normalized[startSample + i]
            out[i * 2] = (s.toInt() and 0xFF).toByte()
            out[i * 2 + 1] = ((s.toInt() shr 8) and 0xFF).toByte()
        }
        return out
    }

    /**
     * Stop recording and package captured PCM into a normalized 16kHz WAV container.
     */
    fun stopRecording(): ByteArray? {
        val pcm = synchronized(lock) {
            stopRecordingInternal()
            recordedPcmStream.toByteArray()
        }
        if (pcm.isEmpty()) return null
        val processedPcm = processPcmAudio(pcm, sampleRate = 16000) ?: return null
        return createWavBytes(processedPcm, sampleRate = 16000, channels = 1, bitsPerSample = 16)
    }

    fun cancelRecording() {
        stopRecordingInternal()
        _status.value = VoiceSearchStatus.Idle
        _amplitude.value = 0f
    }

    private fun stopRecordingInternal() {
        try {
            val line = targetLine
            targetLine = null
            line?.stop()
            line?.close()
            recordingJob?.cancel()
            recordingJob = null
        } catch (e: Exception) {
            // Ignore line closing errors
        }
    }

    /**
     * Transcribe the recorded audio using Groq Whisper with automatic multi-key rotation and Deepgram fallback.
     */
    suspend fun transcribe(wavBytes: ByteArray, settings: EchoSettings?): Result<String> = withContext(Dispatchers.IO) {
        _status.value = VoiceSearchStatus.Transcribing
        val preferredProvider = settings?.getString("voice_search_provider", "groq") ?: "groq"

        if (preferredProvider == "deepgram") {
            val dgRes = transcribeWithDeepgram(wavBytes, settings)
            if (dgRes.isSuccess) {
                val t = dgRes.getOrThrow()
                _status.value = VoiceSearchStatus.Success(t)
                return@withContext Result.success(t)
            }
            // Fallback to Groq pool
            val groqRes = transcribeWithGroqPool(wavBytes, settings)
            if (groqRes.isSuccess) {
                val t = groqRes.getOrThrow()
                _status.value = VoiceSearchStatus.Success(t)
                return@withContext Result.success(t)
            }
            val err = "Transcription failed on both Deepgram and Groq."
            _status.value = VoiceSearchStatus.Error(err)
            return@withContext Result.failure(Exception(err))
        } else {
            // Default: Groq Pool first with Whisper Large V3
            val groqRes = transcribeWithGroqPool(wavBytes, settings)
            if (groqRes.isSuccess) {
                val t = groqRes.getOrThrow()
                _status.value = VoiceSearchStatus.Success(t)
                return@withContext Result.success(t)
            }
            // Fallback to Deepgram Nova-2
            val dgRes = transcribeWithDeepgram(wavBytes, settings)
            if (dgRes.isSuccess) {
                val t = dgRes.getOrThrow()
                _status.value = VoiceSearchStatus.Success(t)
                return@withContext Result.success(t)
            }
            val err = "Voice transcription failed: ${groqRes.exceptionOrNull()?.message ?: "Network error"}"
            _status.value = VoiceSearchStatus.Error(err)
            return@withContext Result.failure(Exception(err))
        }
    }

    private fun transcribeWithGroqPool(wavBytes: ByteArray, settings: EchoSettings?): Result<String> {
        val keys = getActiveKeys(settings)
        if (keys.isEmpty()) return Result.failure(IllegalStateException("No Groq keys configured"))

        var lastError: Exception? = null
        val totalAttempts = keys.size

        // Prioritize Whisper Large V3 flagship for maximum phonetic accuracy and name recognition
        val models = listOf("whisper-large-v3", "whisper-large-v3-turbo")

        for (attempt in 0 until totalAttempts) {
            val key = keys[Math.floorMod(groqKeyIndex.getAndIncrement(), keys.size)]
            for (model in models) {
                try {
                    val boundary = "----NightlyVoiceBoundary" + System.currentTimeMillis()
                    val requestBody = MultipartBody.Builder(boundary)
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("model", model)
                        .addFormDataPart("temperature", "0.0")
                        .addFormDataPart("prompt", ENTERTAINMENT_PROMPT)
                        .addFormDataPart(
                            "file",
                            "voice_input.wav",
                            wavBytes.toRequestBody("audio/wav".toMediaType())
                        )
                        .build()

                    val request = Request.Builder()
                        .url("https://api.groq.com/openai/v1/audio/transcriptions")
                        .header("Authorization", "Bearer $key")
                        .header("User-Agent", "Nightly-Desktop/1.0.3 (Windows NT 10.0; Win64; x64)")
                        .post(requestBody)
                        .build()

                    httpClient.newCall(request).execute().use { response ->
                        if (response.isSuccessful) {
                            val body = response.body?.string() ?: ""
                            val root = jsonParser.parseToJsonElement(body).jsonObject
                            val text = root["text"]?.jsonPrimitive?.content?.trim() ?: ""
                            val clean = cleanTranscript(text)
                            if (clean.isNotBlank()) {
                                return Result.success(clean)
                            }
                        } else {
                            val code = response.code
                            val errorBody = response.body?.string() ?: ""
                            lastError = Exception("Groq HTTP $code: $errorBody")
                        }
                    }
                } catch (e: Exception) {
                    lastError = e
                }
            }
        }

        return Result.failure(lastError ?: Exception("All Groq keys failed"))
    }

    private fun transcribeWithDeepgram(wavBytes: ByteArray, settings: EchoSettings?): Result<String> {
        val key = getDeepgramKey(settings)
        if (key.isBlank()) return Result.failure(IllegalStateException("Deepgram key is blank"))

        return try {
            val url = "https://api.deepgram.com/v1/listen?model=nova-2&smart_format=true&punctuate=false&keywords=movie:2&keywords=song:2&keywords=artist:2&keywords=album:2"
            val request = Request.Builder()
                .url(url)
                .header("Authorization", "Token $key")
                .header("Content-Type", "audio/wav")
                .header("User-Agent", "Nightly-Desktop/1.0.3")
                .post(wavBytes.toRequestBody("audio/wav".toMediaType()))
                .build()

            httpClient.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val body = response.body?.string() ?: ""
                    val root = jsonParser.parseToJsonElement(body).jsonObject
                    val results = root["results"]?.jsonObject
                    val channels = results?.get("channels")?.jsonArray
                    val firstChannel = channels?.firstOrNull()?.jsonObject
                    val alternatives = firstChannel?.get("alternatives")?.jsonArray
                    val transcript = alternatives?.firstOrNull()?.jsonObject?.get("transcript")?.jsonPrimitive?.content ?: ""
                    val clean = cleanTranscript(transcript)
                    if (clean.isNotBlank()) {
                        Result.success(clean)
                    } else {
                        Result.failure(Exception("Empty transcription"))
                    }
                } else {
                    Result.failure(Exception("Deepgram HTTP ${response.code}: ${response.message}"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private val HALLUCINATION_PATTERNS = listOf(
        "thank you", "thank you for watching", "thanks for watching",
        "please subscribe", "like and subscribe", "subscribe to my channel",
        "subscribe", "amara.org", "subtitles by", "translated by",
        "[music]", "[applause]", "[silence]", "(bell ringing)", "(music playing)"
    )

    fun cleanTranscript(raw: String): String {
        var text = raw.trim()
            .removePrefix("\"").removeSuffix("\"")
            .removePrefix("'").removeSuffix("'")
            .trim()

        val lower = text.lowercase().trimEnd('.', '!', '?', ',', ' ')
        for (pattern in HALLUCINATION_PATTERNS) {
            if (lower == pattern || lower.startsWith("$pattern.") || lower.startsWith("$pattern!")) {
                return ""
            }
        }

        // Strip conversational command prefixes:
        // "search for interstellar" -> "interstellar"
        // "play deadpool" -> "deadpool"
        // "look for song bad blood" -> "bad blood"
        val prefixes = listOf(
            "search for movie ", "search for song ", "search for track ", "search for artist ", "search for ",
            "search movie ", "search song ", "search track ", "search artist ", "search ",
            "play movie ", "play song ", "play track ", "play artist ", "play ",
            "find movie ", "find song ", "find track ", "find ",
            "look for movie ", "look for song ", "look for ",
            "listen to song ", "listen to "
        )

        for (p in prefixes) {
            if (text.startsWith(p, ignoreCase = true)) {
                val candidate = text.substring(p.length).trim()
                if (candidate.isNotBlank()) {
                    text = candidate
                    break
                }
            }
        }

        return text
            .removePrefix("\"").removeSuffix("\"")
            .removePrefix("'").removeSuffix("'")
            .trimEnd('.', '!', '?', ',', ';', ':')
            .trim()
    }

    private fun createWavBytes(pcm: ByteArray, sampleRate: Int, channels: Int, bitsPerSample: Int): ByteArray {
        val totalDataLen = pcm.size + 36
        val byteRate = sampleRate * channels * bitsPerSample / 8
        val blockAlign = channels * bitsPerSample / 8

        val out = ByteArrayOutputStream(pcm.size + 44)
        val header = ByteBuffer.allocate(44).order(ByteOrder.LITTLE_ENDIAN)

        header.put("RIFF".toByteArray())
        header.putInt(totalDataLen)
        header.put("WAVE".toByteArray())
        header.put("fmt ".toByteArray())
        header.putInt(16) // Subchunk1Size
        header.putShort(1.toShort()) // AudioFormat (1 = PCM)
        header.putShort(channels.toShort())
        header.putInt(sampleRate)
        header.putInt(byteRate)
        header.putShort(blockAlign.toShort())
        header.putShort(bitsPerSample.toShort())
        header.put("data".toByteArray())
        header.putInt(pcm.size)

        out.write(header.array())
        out.write(pcm)
        return out.toByteArray()
    }
}

// =========================================================================
// NIGHTLY FROSTED GLASS VOICE SEARCH MODAL & TRIGGER BUTTON
// =========================================================================

@Composable
fun AudixVoiceSearchTriggerButton(
    modifier: Modifier = Modifier,
    tint: Color = Color(0xFFE11D48),
    onClick: () -> Unit
) {
    LiquidGlassBox(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .size(34.dp)
            .pointerHoverIcon(PointerIcon.Hand),
        borderColor = tint.copy(alpha = 0.50f),
        onClick = onClick
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Voice Search",
                tint = tint,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun AudixVoiceSearchModal(
    settings: EchoSettings? = null,
    onDismiss: () -> Unit,
    onQueryTranscribed: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val status by AudixVoiceSearchService.status.collectAsState()
    val amplitude by AudixVoiceSearchService.amplitude.collectAsState()

    var isSubmitting by remember { mutableStateOf(false) }
    var hasDetectedSpeech by remember { mutableStateOf(false) }
    var silenceStartTime by remember { mutableStateOf(0L) }
    var elapsedSeconds by remember { mutableStateOf(0) }

    fun finishAndSearch() {
        if (isSubmitting) return
        val currentStatus = AudixVoiceSearchService.status.value
        if (currentStatus !is VoiceSearchStatus.Recording) return
        isSubmitting = true
        coroutineScope.launch {
            try {
                val wav = AudixVoiceSearchService.stopRecording()
                if (wav != null && wav.size > 2000) {
                    val res = AudixVoiceSearchService.transcribe(wav, settings)
                    if (res.isSuccess) {
                        val query = res.getOrThrow().trim()
                        if (query.isNotBlank()) {
                            onQueryTranscribed(query)
                            onDismiss()
                            return@launch
                        }
                    }
                } else {
                    AudixVoiceSearchService.cancelRecording()
                }
            } catch (e: Exception) {
                // error displayed via VoiceSearchStatus
            } finally {
                isSubmitting = false
            }
        }
    }

    // Start recording immediately on modal open
    LaunchedEffect(Unit) {
        hasDetectedSpeech = false
        silenceStartTime = 0L
        elapsedSeconds = 0
        AudixVoiceSearchService.startRecording()
    }

    // Live elapsed seconds timer
    LaunchedEffect(status) {
        if (status is VoiceSearchStatus.Recording) {
            while (isActive) {
                delay(1000L)
                elapsedSeconds++
            }
        }
    }

    // High-tolerance Voice Activity Detection:
    // Requires clear speech (amplitude > 0.08f), and grants a comfortable 3.2s pause buffer
    // so user speech is never truncated mid-phrase.
    LaunchedEffect(amplitude, status) {
        if (status is VoiceSearchStatus.Recording) {
            val now = System.currentTimeMillis()
            if (amplitude > 0.08f) {
                hasDetectedSpeech = true
                silenceStartTime = 0L
            } else if (hasDetectedSpeech) {
                if (silenceStartTime == 0L) {
                    silenceStartTime = now
                } else if (now - silenceStartTime > 3200L) {
                    // 3.2 seconds of clear pause after vocal speech -> auto-finish
                    finishAndSearch()
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            AudixVoiceSearchService.cancelRecording()
        }
    }

    // Modal Scrim Backdrop with frosted glass center island
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.65f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                AudixVoiceSearchService.cancelRecording()
                onDismiss()
            }
            .zIndex(150f),
        contentAlignment = Alignment.Center
    ) {
        LiquidGlassCard(
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier
                .width(440.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { /* Consume clicks */ },
            backgroundColor = Color(0xFF090C14).copy(alpha = 0.70f),
            borderColor = Color(0xFFE11D48).copy(alpha = 0.75f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(26.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Header with badge & close button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(6.dp),
                        borderColor = Color(0xFFE11D48).copy(alpha = 0.60f)
                    ) {
                        Text(
                            text = "NIGHTLY VOICE SEARCH • GROQ WHISPER V3",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE11D48),
                            letterSpacing = 0.5.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }

                    IconButton(
                        onClick = {
                            AudixVoiceSearchService.cancelRecording()
                            onDismiss()
                        },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White.copy(alpha = 0.75f), modifier = Modifier.size(18.dp))
                    }
                }

                Spacer(Modifier.height(4.dp))

                // Microphone Animated Visualizer Island (Clickable to finish and search)
                Box(
                    modifier = Modifier.size(130.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val infiniteTransition = rememberInfiniteTransition()
                    val pulseScale by infiniteTransition.animateFloat(
                        initialValue = 1.0f,
                        targetValue = 1.18f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(900, easing = LinearEasing),
                            repeatMode = RepeatMode.Reverse
                        )
                    )

                    val dynamicScale = if (status is VoiceSearchStatus.Recording) {
                        1.0f + (amplitude * 0.45f)
                    } else if (status is VoiceSearchStatus.Transcribing || isSubmitting) {
                        pulseScale
                    } else 1.0f

                    // Outer Glowing Ring
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .scale(dynamicScale)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    listOf(
                                        Color(0xFFE11D48).copy(alpha = if (status is VoiceSearchStatus.Recording) 0.35f else 0.15f),
                                        Color.Transparent
                                    )
                                )
                            )
                    )

                    // Inner Frosted Mic Orb (Clickable to stop and transcribe)
                    LiquidGlassBox(
                        shape = CircleShape,
                        modifier = Modifier
                            .size(76.dp)
                            .pointerHoverIcon(PointerIcon.Hand),
                        borderColor = if (status is VoiceSearchStatus.Recording) Color(0xFFE11D48) else Color(0xFF38BDF8),
                        onClick = {
                            if (status is VoiceSearchStatus.Recording) {
                                finishAndSearch()
                            }
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            if (status is VoiceSearchStatus.Transcribing || isSubmitting) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(34.dp),
                                    strokeWidth = 3.dp,
                                    color = Color(0xFF38BDF8)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Mic,
                                    contentDescription = "Microphone (Tap to search)",
                                    tint = if (status is VoiceSearchStatus.Recording) Color(0xFFE11D48) else Color.White,
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                        }
                    }
                }

                // Waveform bars if recording
                if (status is VoiceSearchStatus.Recording) {
                    VoiceVisualizerWaveform(amplitude = amplitude)
                }

                // Dynamic Status Text
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    val statusText = when {
                        isSubmitting || status is VoiceSearchStatus.Transcribing -> "Transcribing speech with Whisper Large V3..."
                        status is VoiceSearchStatus.Recording -> {
                            if (hasDetectedSpeech) {
                                "Vocal detected • Tap orb or Done when finished (${String.format("%02d:%02d", elapsedSeconds / 60, elapsedSeconds % 60)})"
                            } else {
                                "Listening... Speak a movie or song name (${String.format("%02d:%02d", elapsedSeconds / 60, elapsedSeconds % 60)})"
                            }
                        }
                        status is VoiceSearchStatus.Success -> "Search: \"${(status as VoiceSearchStatus.Success).transcript}\""
                        status is VoiceSearchStatus.Error -> (status as VoiceSearchStatus.Error).error
                        else -> "Initializing Microphone..."
                    }

                    Text(
                        text = statusText,
                        color = if (status is VoiceSearchStatus.Error) Color(0xFFF87171) else Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "High-Fidelity Studio Audio • Whisper Large V3 & Nova-2",
                        color = Color.White.copy(alpha = 0.50f),
                        fontSize = 11.sp
                    )
                }

                Spacer(Modifier.height(8.dp))

                // Bottom Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Cancel
                    LiquidGlassBox(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .pointerHoverIcon(PointerIcon.Hand),
                        borderColor = Color.White.copy(alpha = 0.20f),
                        onClick = {
                            AudixVoiceSearchService.cancelRecording()
                            onDismiss()
                        }
                    ) {
                        Text(
                            text = "Cancel",
                            color = Color.White.copy(alpha = 0.85f),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.5.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
                        )
                    }

                    // Stop & Search
                    if (status is VoiceSearchStatus.Recording) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .pointerHoverIcon(PointerIcon.Hand),
                            borderColor = Color(0xFFE11D48),
                            isSelected = true,
                            selectedBgColor = Color(0xFFE11D48).copy(alpha = 0.35f),
                            onClick = { finishAndSearch() }
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Default.Stop, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    text = "Done & Search",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.5.sp
                                )
                            }
                        }
                    } else if (status is VoiceSearchStatus.Error) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .pointerHoverIcon(PointerIcon.Hand),
                            borderColor = Color(0xFF38BDF8),
                            onClick = {
                                hasDetectedSpeech = false
                                silenceStartTime = 0L
                                elapsedSeconds = 0
                                AudixVoiceSearchService.startRecording()
                            }
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Default.Refresh, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    text = "Retry",
                                    color = Color(0xFF38BDF8),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.5.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun VoiceVisualizerWaveform(amplitude: Float) {
    val barCount = 18
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val infiniteTransition = rememberInfiniteTransition()
        val phase by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 6.28f,
            animationSpec = infiniteRepeatable(
                animation = tween(1400, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )

        for (i in 0 until barCount) {
            val sine = (sin(phase + (i * 0.45f)) + 1.0f) * 0.5f
            val barHeight = (8.dp + 24.dp * (amplitude * sine.coerceAtLeast(0.2f))).coerceIn(4.dp, 30.dp)
            val barAlpha = 0.35f + (sine * 0.65f)

            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .width(3.5.dp)
                    .height(barHeight)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFFE11D48).copy(alpha = barAlpha))
            )
        }
    }
}


typealias NightlyVoiceSearchService = AudixVoiceSearchService
