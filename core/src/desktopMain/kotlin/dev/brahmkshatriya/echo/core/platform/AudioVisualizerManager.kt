package dev.brahmkshatriya.echo.core.platform

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.*

/**
 * Real-time Audio Spectrum & Waveform Visualizer Manager.
 * Analyzes live PCM audio decoded by the player engine using a 512-point FFT
 * across 28 logarithmic frequency bands (from sub-bass 40Hz to treble 15kHz).
 *
 * Implements professional studio ballistics with instant transient attack,
 * exponential release decay, and logarithmic dynamic range mapping so that
 * the visualizer bars jump and dance in exact synchrony with the music.
 */
object AudioVisualizerManager {

    const val BARS = 28
    private const val FFT_SIZE = 512
    private const val SAMPLE_RATE = 44100

    private val _visualizerBands = MutableStateFlow(FloatArray(BARS) { 0f })
    val visualizerBands: StateFlow<FloatArray> = _visualizerBands.asStateFlow()

    @Volatile
    var isAudioActive = false
        private set

    // Internal FFT working buffers (allocated once to avoid GC churn on audio thread)
    private val fftReal = FloatArray(FFT_SIZE)
    private val fftImag = FloatArray(FFT_SIZE)
    private val currentBands = FloatArray(BARS) { 0f }
    private val window = FloatArray(FFT_SIZE) { i ->
        (0.5 * (1.0 - cos(2.0 * PI * i / (FFT_SIZE - 1)))).toFloat()
    }

    // Precomputed logarithmic frequency bin ranges for each of the 28 bands
    private val binLow = IntArray(BARS)
    private val binHigh = IntArray(BARS)

    init {
        val minFreq = 40.0
        val maxFreq = 15000.0
        for (b in 0 until BARS) {
            val fLow = minFreq * (maxFreq / minFreq).pow(b.toDouble() / BARS.toDouble())
            val fHigh = minFreq * (maxFreq / minFreq).pow((b + 1).toDouble() / BARS.toDouble())
            val l = max(1, (fLow * FFT_SIZE / SAMPLE_RATE).roundToInt())
            val h = min(FFT_SIZE / 2 - 1, (fHigh * FFT_SIZE / SAMPLE_RATE).roundToInt())
            binLow[b] = l
            binHigh[b] = max(l, h)
        }
    }

    @Volatile
    private var lastUpdateTime = 0L

    /**
     * Process raw 16-bit interleaved stereo PCM audio samples.
     * Called directly from the audio output engine on each decoded buffer.
     * Throttled to ~40 FPS to keep audio thread latency near zero and prevent recomposition churn.
     */
    fun processPcmSamples(pcmBytes: ByteArray, sampleCount: Int) {
        if (sampleCount <= 0 || pcmBytes.isEmpty()) return
        isAudioActive = true

        val now = System.currentTimeMillis()
        if (now - lastUpdateTime < 25L) return
        lastUpdateTime = now

        val count = min(sampleCount, FFT_SIZE)
        // Convert stereo 16-bit PCM to mono float samples [-1.0 .. 1.0] with Hann windowing
        for (i in 0 until count) {
            val offset = i * 4
            if (offset + 3 >= pcmBytes.size) break
            val left = ((pcmBytes[offset].toInt() and 0xFF) or (pcmBytes[offset + 1].toInt() shl 8)).toShort()
            val right = ((pcmBytes[offset + 2].toInt() and 0xFF) or (pcmBytes[offset + 3].toInt() shl 8)).toShort()
            val mono = ((left.toFloat() + right.toFloat()) / 65536.0f)
            fftReal[i] = mono * window[i]
            fftImag[i] = 0f
        }
        for (i in count until FFT_SIZE) {
            fftReal[i] = 0f
            fftImag[i] = 0f
        }

        // Execute in-place Cooley-Tukey Radix-2 FFT
        computeFft(fftReal, fftImag)

        // Map FFT magnitudes to 28 logarithmic frequency bands
        val half = FFT_SIZE / 2
        for (b in 0 until BARS) {
            val l = binLow[b]
            val h = min(half - 1, binHigh[b])
            var sum = 0f
            for (k in l..h) {
                val r = fftReal[k]
                val im = fftImag[k]
                sum += sqrt(r * r + im * im)
            }
            val avg = sum / max(1, h - l + 1)

            // Dynamic non-linear logarithmic curve with frequency equalization
            // Low frequencies have more raw acoustic energy than high frequencies,
            // so we apply a subtle pink-noise compensation curve (+0.035 * b)
            val freqWeight = 1.0f + (b.toFloat() / BARS.toFloat()) * 1.5f
            val energy = (min(1.0, (avg * 18.0f * freqWeight).toDouble().pow(0.85))).toFloat()

            // Studio Ballistics: Instant Attack (0ms), Exponential Decay (decay factor 0.72)
            if (energy >= currentBands[b]) {
                currentBands[b] = energy
            } else {
                currentBands[b] = max(0f, currentBands[b] * 0.72f - 0.012f)
            }
        }

        // Post updated snapshot
        _visualizerBands.value = currentBands.copyOf()
    }

    /**
     * Resample the 28 frequency bands to any desired count of visualizer bars (e.g. 18 for miniplayer).
     */
    fun getBands(count: Int): FloatArray {
        val bands = _visualizerBands.value
        if (count == BARS) return bands
        val result = FloatArray(count)
        for (i in 0 until count) {
            val srcIndex = (i.toFloat() / (count - 1).coerceAtLeast(1) * (BARS - 1))
            val lowIdx = srcIndex.toInt().coerceIn(0, BARS - 1)
            val highIdx = min(BARS - 1, lowIdx + 1)
            val frac = srcIndex - lowIdx
            result[i] = (bands[lowIdx] * (1f - frac) + bands[highIdx] * frac).coerceIn(0f, 1f)
        }
        return result
    }

    fun onPlaybackPaused() {
        isAudioActive = false
        // Smoothly decay all bands to resting zero
        for (b in 0 until BARS) {
            currentBands[b] = currentBands[b] * 0.4f
        }
        _visualizerBands.value = currentBands.copyOf()
    }

    fun onPlaybackResumed() {
        isAudioActive = true
    }

    fun clear() {
        isAudioActive = false
        for (b in 0 until BARS) currentBands[b] = 0f
        _visualizerBands.value = FloatArray(BARS) { 0f }
    }

    private fun computeFft(real: FloatArray, imag: FloatArray) {
        val n = real.size
        var j = 0
        for (i in 0 until n - 1) {
            if (i < j) {
                val tr = real[i]; real[i] = real[j]; real[j] = tr
                val ti = imag[i]; imag[i] = imag[j]; imag[j] = ti
            }
            var k = n / 2
            while (k <= j) {
                j -= k
                k /= 2
            }
            j += k
        }
        var len = 2
        while (len <= n) {
            val angle = -2.0 * PI / len
            val wlenR = cos(angle).toFloat()
            val wlenI = sin(angle).toFloat()
            var i = 0
            while (i < n) {
                var wR = 1.0f
                var wI = 0.0f
                for (m in 0 until len / 2) {
                    val u = i + m
                    val v = i + m + len / 2
                    val vr = real[v] * wR - imag[v] * wI
                    val vi = real[v] * wI + imag[v] * wR
                    real[v] = real[u] - vr
                    imag[v] = imag[u] - vi
                    real[u] = real[u] + vr
                    imag[u] = imag[u] + vi
                    val nwR = wR * wlenR - wI * wlenI
                    val nwI = wR * wlenI + wI * wlenR
                    wR = nwR
                    wI = nwI
                }
                i += len
            }
            len = len shl 1
        }
    }
}
