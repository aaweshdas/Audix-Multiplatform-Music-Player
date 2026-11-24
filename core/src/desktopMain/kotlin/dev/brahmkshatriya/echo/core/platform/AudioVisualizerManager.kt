package dev.brahmkshatriya.echo.core.platform

import com.sun.jna.Pointer
import com.sun.jna.platform.win32.COM.Unknown
import com.sun.jna.platform.win32.Guid
import com.sun.jna.platform.win32.Ole32
import com.sun.jna.ptr.IntByReference
import com.sun.jna.ptr.PointerByReference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.*

/**
 * Real-time Audio Vibration, Beat-Onset & Spectrum Visualizer Engine.
 *
 * On Windows, taps the live system playback mix out-of-band via native Core Audio
 * WASAPI Loopback (AUDCLNT_STREAMFLAGS_LOOPBACK) through JNA COM:
 *  - Zero interference with LibVLC's native WASAPI hardware output, Equalizer, or volume.
 *  - Automatically adapts to any sample rate (44.1 / 48 / 96 kHz), channel count, and
 *    headphone/Bluetooth output hot-swaps (AUDCLNT_E_DEVICE_INVALIDATED).
 *  - Runs a 1024-point Hann-windowed Cooley-Tukey FFT, Adaptive Auto-Gain Control (AGC),
 *    noise gate, dual-band spectral-flux beat/kick onset detector, and live downsampled
 *    acoustic waveform capture with zero per-frame allocations.
 *  - Stops immediately on pause/stop for 0% idle CPU usage.
 */
object AudioVisualizerManager {

    const val BARS = 28
    const val WAVEFORM_SAMPLES = 96
    private const val FFT_SIZE = 1024

    private val _visualizerBands = MutableStateFlow(FloatArray(BARS) { 0f })
    val visualizerBands: StateFlow<FloatArray> = _visualizerBands.asStateFlow()

    private val _peakBands = MutableStateFlow(FloatArray(BARS) { 0f })
    val peakBands: StateFlow<FloatArray> = _peakBands.asStateFlow()

    @Volatile
    var isAudioActive = false
        private set

    // =========================================================================
    // Lock-Free Real-Time Telemetry Fields (Read directly in Compose Draw Phase)
    // =========================================================================
    @Volatile
    var liveBass: Float = 0f
        private set

    @Volatile
    var liveMid: Float = 0f
        private set

    @Volatile
    var liveTreble: Float = 0f
        private set

    /** Sharp spectral-flux cardiac contraction impulse triggered by real kicks, drums & drops. */
    @Volatile
    var liveBeatImpulse: Float = 0f
        private set

    /** Instantaneous AGC-normalized acoustic vibration loudness (0 on silence, 0..1 on audio). */
    @Volatile
    var liveRms: Float = 0f
        private set

    /** Monotonically increasing counter bumped whenever a strong real beat onset is detected. */
    @Volatile
    var beatCount: Long = 0L
        private set

    /** True while live Windows WASAPI loopback audio packets are actively captured. */
    @Volatile
    var isRealAudioCaptured: Boolean = false
        private set

    // Double-buffered lock-free real PCM waveform snapshot for acoustic line vibration
    private val waveBufA = FloatArray(WAVEFORM_SAMPLES)
    private val waveBufB = FloatArray(WAVEFORM_SAMPLES)

    @Volatile
    private var activeWaveBuf: FloatArray = waveBufA

    fun getLiveWaveform(): FloatArray = activeWaveBuf

    // =========================================================================
    // Pre-Allocated DSP Working Buffers (Zero-GC Hot Loop)
    // =========================================================================
    private val fftReal = FloatArray(FFT_SIZE)
    private val fftImag = FloatArray(FFT_SIZE)
    private val pcmRingBuffer = FloatArray(FFT_SIZE)
    private var ringPos = 0

    private val currentBands = FloatArray(BARS) { 0f }
    private val peakBandsInternal = FloatArray(BARS) { 0f }
    private val peakHoldTimers = IntArray(BARS) { 0 }

    private val window = FloatArray(FFT_SIZE) { i ->
        (0.5 * (1.0 - cos(2.0 * PI * i / (FFT_SIZE - 1)))).toFloat()
    }

    private val binLow = IntArray(BARS)
    private val binHigh = IntArray(BARS)
    private val tiltDbs = FloatArray(BARS)

    @Volatile
    private var configuredSampleRate = 0

    // Adaptive AGC & Dual-Band Spectral Flux Beat Detector state
    private var agcPeak = 0.12f
    private var bassRollingAvg = 0.12f
    private var punchRollingAvg = 0.10f
    private var beatImpulseState = 0f
    private var lastBeatTriggerMs = 0L

    @Volatile
    private var lastUpdateTime = 0L

    @Volatile
    private var lastFlowEmitTime = 0L

    init {
        configureFrequencyBins(48000)
    }

    @Synchronized
    private fun configureFrequencyBins(sampleRate: Int) {
        val sr = sampleRate.coerceIn(16000, 192000)
        if (sr == configuredSampleRate) return
        configuredSampleRate = sr
        val minFreq = 35.0
        val maxFreq = min(16000.0, sr * 0.46)
        for (b in 0 until BARS) {
            val fLow = minFreq * (maxFreq / minFreq).pow(b.toDouble() / BARS.toDouble())
            val fHigh = minFreq * (maxFreq / minFreq).pow((b + 1).toDouble() / BARS.toDouble())
            val fCenter = sqrt(fLow * fHigh)
            val octaves = log2(fCenter / 1000.0)
            tiltDbs[b] = (octaves * 2.6).coerceIn(-5.5, 8.5).toFloat()

            val l = max(1, (fLow * FFT_SIZE / sr).roundToInt())
            val h = min(FFT_SIZE / 2 - 1, (fHigh * FFT_SIZE / sr).roundToInt())
            binLow[b] = l
            binHigh[b] = max(l, h)
        }
    }

    /**
     * Direct 16-bit interleaved stereo PCM ingestion API (kept for compatibility).
     */
    fun processPcmSamples(pcmBytes: ByteArray, sampleCount: Int) {
        if (sampleCount <= 0 || pcmBytes.isEmpty()) return
        isAudioActive = true
        isRealAudioCaptured = true
        configureFrequencyBins(44100)

        val maxSamples = min(sampleCount, pcmBytes.size / 4)
        for (i in 0 until maxSamples) {
            val offset = i * 4
            val left = ((pcmBytes[offset].toInt() and 0xFF) or (pcmBytes[offset + 1].toInt() shl 8)).toShort()
            val right = ((pcmBytes[offset + 2].toInt() and 0xFF) or (pcmBytes[offset + 3].toInt() shl 8)).toShort()
            val mono = (left.toFloat() + right.toFloat()) / 65536.0f
            pcmRingBuffer[ringPos] = mono
            ringPos = (ringPos + 1) and (FFT_SIZE - 1)
        }

        val now = System.currentTimeMillis()
        if (now - lastUpdateTime < 16L) return
        lastUpdateTime = now
        analyzeRingBufferAndPublish(hasNewSignal = true, nowMs = now)
    }

    /**
     * Core zero-GC DSP pipeline:
     * 1. Computes block RMS & peak + noise gate + Adaptive AGC.
     * 2. Publishes lock-free live PCM waveform for direct acoustic line vibration.
     * 3. Computes 1024-pt Hann-windowed FFT across 28 logarithmic bands.
     * 4. Runs Dual-Band Spectral Flux beat-onset detection for true kick/drum heartbeats.
     */
    private fun analyzeRingBufferAndPublish(hasNewSignal: Boolean, nowMs: Long) {
        // 1. Measure instantaneous RMS and Peak over the most recent 512 samples
        var sumSq = 0f
        var blockPeak = 0f
        val recentCount = 512
        val startRecent = (ringPos - recentCount + FFT_SIZE) and (FFT_SIZE - 1)
        for (i in 0 until recentCount) {
            val s = pcmRingBuffer[(startRecent + i) and (FFT_SIZE - 1)]
            val a = abs(s)
            if (a > blockPeak) blockPeak = a
            sumSq += s * s
        }
        val blockRms = sqrt(sumSq / recentCount)
        val isSilent = !hasNewSignal || blockRms < 0.00055f

        if (isSilent) {
            // Smooth natural decay to calm state during silent breakdowns/pauses
            liveRms *= 0.82f
            liveBass *= 0.82f
            liveMid *= 0.82f
            liveTreble *= 0.82f
            beatImpulseState *= 0.80f
            liveBeatImpulse = beatImpulseState
            agcPeak = max(0.04f, agcPeak * 0.985f)

            val writeBuf = if (activeWaveBuf === waveBufA) waveBufB else waveBufA
            for (i in 0 until WAVEFORM_SAMPLES) {
                writeBuf[i] = activeWaveBuf[i] * 0.72f
            }
            activeWaveBuf = writeBuf

            for (b in 0 until BARS) {
                currentBands[b] = max(0f, currentBands[b] * 0.80f - 0.005f)
                peakBandsInternal[b] = max(currentBands[b], peakBandsInternal[b] - 0.020f)
            }
            emitFlowsIfDue(nowMs)
            return
        }

        // 2. Adaptive Auto-Gain Control (AGC): works vividly at 15% late-night volume AND 100% volume
        if (blockPeak > agcPeak) {
            agcPeak = agcPeak * 0.35f + blockPeak * 0.65f
        } else {
            agcPeak = max(0.032f, agcPeak * 0.993f)
        }
        val agcGain = (0.78f / agcPeak).coerceIn(0.8f, 16.0f)

        // 3. Publish lock-free downsampled real acoustic waveform (96 samples across latest 512 PCM frames)
        val writeBuf = if (activeWaveBuf === waveBufA) waveBufB else waveBufA
        val prevBuf = activeWaveBuf
        val stride = recentCount.toFloat() / WAVEFORM_SAMPLES.toFloat()
        for (i in 0 until WAVEFORM_SAMPLES) {
            val offset = (i * stride).toInt()
            // 3-sample local average for clean anti-aliased acoustic vibration trace
            val idx0 = (startRecent + offset) and (FFT_SIZE - 1)
            val idx1 = (idx0 + 1) and (FFT_SIZE - 1)
            val idx2 = (idx0 + 2) and (FFT_SIZE - 1)
            val raw = (pcmRingBuffer[idx0] + pcmRingBuffer[idx1] + pcmRingBuffer[idx2]) * (1f / 3f)
            val norm = (raw * agcGain * 1.15f).coerceIn(-1f, 1f)
            // Light temporal smoothing preserves crisp acoustic vibration without high-freq flicker
            writeBuf[i] = prevBuf[i] * 0.25f + norm * 0.75f
        }
        activeWaveBuf = writeBuf

        // 4. Copy AGC-normalized Hann-windowed samples into FFT buffers
        for (i in 0 until FFT_SIZE) {
            val srcIdx = (ringPos + i) and (FFT_SIZE - 1)
            fftReal[i] = (pcmRingBuffer[srcIdx] * agcGain).coerceIn(-1.5f, 1.5f) * window[i]
            fftImag[i] = 0f
        }

        // 5. Execute in-place Cooley-Tukey Radix-2 FFT
        computeFft(fftReal, fftImag)

        val normScale = FFT_SIZE / 4.0f
        val half = FFT_SIZE / 2
        val minDb = -46.0f
        val maxDb = 0.0f

        var rawBassMax = 0f
        var rawBassSum = 0f
        var rawPunchSum = 0f
        var rawMidSum = 0f
        var rawTrebleSum = 0f

        for (b in 0 until BARS) {
            val l = binLow[b]
            val h = min(half - 1, binHigh[b])
            var maxMag = 0f
            for (k in l..h) {
                val r = fftReal[k]
                val im = fftImag[k]
                val mag = sqrt(r * r + im * im) / normScale
                if (mag > maxMag) maxMag = mag
            }

            val rawDb = 20.0f * log10(max(1e-4f, maxMag))
            val compDb = rawDb + tiltDbs[b]
            val rawFraction = ((compDb - minDb) / (maxDb - minDb)).coerceIn(0f, 1f)
            val targetEnergy = rawFraction.pow(1.18f)

            // Accumulate un-smoothed instantaneous band energies for zero-lag beat detection
            when {
                b < 6 -> {
                    if (targetEnergy > rawBassMax) rawBassMax = targetEnergy
                    rawBassSum += targetEnergy
                }
                b < 11 -> {
                    rawPunchSum += targetEnergy
                    rawMidSum += targetEnergy
                }
                b < 17 -> rawMidSum += targetEnergy
                else -> rawTrebleSum += targetEnergy
            }

            // Studio Ballistics: instant attack, smooth exponential decay
            if (targetEnergy >= currentBands[b]) {
                currentBands[b] = targetEnergy
            } else {
                currentBands[b] = max(0f, currentBands[b] * 0.82f - 0.006f)
            }

            if (currentBands[b] >= peakBandsInternal[b]) {
                peakBandsInternal[b] = currentBands[b]
                peakHoldTimers[b] = 8
            } else {
                if (peakHoldTimers[b] > 0) {
                    peakHoldTimers[b]--
                } else {
                    peakBandsInternal[b] = max(currentBands[b], peakBandsInternal[b] - 0.024f)
                }
            }
        }

        // 6. Dual-Band Spectral Flux Beat & Vibration Onset Detection
        val rawBass = (rawBassMax * 0.65f + (rawBassSum / 6f) * 0.35f).coerceIn(0f, 1f)
        val rawPunch = (rawPunchSum / 5f).coerceIn(0f, 1f)
        val rawMid = (rawMidSum / 11f).coerceIn(0f, 1f)
        val rawTreble = (rawTrebleSum / 11f).coerceIn(0f, 1f)
        val normRms = (blockRms * agcGain * 1.9f).coerceIn(0f, 1f)

        // Compare instantaneous energy against fast-adapting local average to isolate real beats
        val bassFlux = max(0f, rawBass - bassRollingAvg * 1.05f)
        val punchFlux = max(0f, rawPunch - punchRollingAvg * 1.10f)

        bassRollingAvg = bassRollingAvg * 0.86f + rawBass * 0.14f
        punchRollingAvg = punchRollingAvg * 0.86f + rawPunch * 0.14f

        val fluxHit = (bassFlux * 4.5f + punchFlux * 2.0f).coerceIn(0f, 1f)
        val beatTarget = (fluxHit * 0.85f + rawBass * 0.38f + normRms * 0.18f).coerceIn(0f, 1f)

        if (fluxHit > 0.24f && (nowMs - lastBeatTriggerMs) > 135L) {
            lastBeatTriggerMs = nowMs
            beatCount++
        }

        // Fast systolic snap up, smooth cardiac diastolic release
        beatImpulseState = if (beatTarget > beatImpulseState) {
            beatImpulseState * 0.15f + beatTarget * 0.85f
        } else {
            max(0f, beatImpulseState * 0.83f - 0.008f)
        }

        liveRms = if (normRms > liveRms) liveRms * 0.25f + normRms * 0.75f else liveRms * 0.84f
        liveBass = if (rawBass > liveBass) liveBass * 0.20f + rawBass * 0.80f else liveBass * 0.84f
        liveMid = if (rawMid > liveMid) liveMid * 0.25f + rawMid * 0.75f else liveMid * 0.84f
        liveTreble = if (rawTreble > liveTreble) liveTreble * 0.25f + rawTreble * 0.75f else liveTreble * 0.85f
        liveBeatImpulse = beatImpulseState

        emitFlowsIfDue(nowMs)
    }

    private fun emitFlowsIfDue(nowMs: Long) {
        // Throttle Compose StateFlow snapshots to ~40 FPS (25ms) to minimize allocations for MiniPlayer
        if (nowMs - lastFlowEmitTime >= 25L) {
            lastFlowEmitTime = nowMs
            _visualizerBands.value = currentBands.copyOf()
            _peakBands.value = peakBandsInternal.copyOf()
        }
    }

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

    fun getPeakBands(count: Int): FloatArray {
        val peaks = _peakBands.value
        if (count == BARS) return peaks
        val result = FloatArray(count)
        for (i in 0 until count) {
            val srcIndex = (i.toFloat() / (count - 1).coerceAtLeast(1) * (BARS - 1))
            val lowIdx = srcIndex.toInt().coerceIn(0, BARS - 1)
            val highIdx = min(BARS - 1, lowIdx + 1)
            val frac = srcIndex - lowIdx
            result[i] = (peaks[lowIdx] * (1f - frac) + peaks[highIdx] * frac).coerceIn(0f, 1f)
        }
        return result
    }

    // =========================================================================
    // Playback Lifecycle & Real Windows WASAPI Loopback Capture Thread
    // =========================================================================
    private val captureGeneration = AtomicLong(0L)
    private var captureThread: Thread? = null
    private var fallbackJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    @Synchronized
    fun onPlaybackResumed() {
        isAudioActive = true
        startAudioCapture()
    }

    @Synchronized
    fun onPlaybackPaused() {
        isAudioActive = false
        stopAudioCapture()
        liveRms = 0f
        liveBass = 0f
        liveMid = 0f
        liveTreble = 0f
        beatImpulseState = 0f
        liveBeatImpulse = 0f
        for (i in 0 until WAVEFORM_SAMPLES) {
            waveBufA[i] = 0f
            waveBufB[i] = 0f
        }
        for (b in 0 until BARS) {
            currentBands[b] = currentBands[b] * 0.25f
            peakBandsInternal[b] = peakBandsInternal[b] * 0.25f
            peakHoldTimers[b] = 0
        }
        _visualizerBands.value = currentBands.copyOf()
        _peakBands.value = peakBandsInternal.copyOf()
    }

    @Synchronized
    fun clear() {
        isAudioActive = false
        stopAudioCapture()
        liveRms = 0f
        liveBass = 0f
        liveMid = 0f
        liveTreble = 0f
        beatImpulseState = 0f
        liveBeatImpulse = 0f
        agcPeak = 0.12f
        bassRollingAvg = 0.12f
        punchRollingAvg = 0.10f
        for (i in 0 until WAVEFORM_SAMPLES) {
            waveBufA[i] = 0f
            waveBufB[i] = 0f
        }
        for (b in 0 until BARS) {
            currentBands[b] = 0f
            peakBandsInternal[b] = 0f
            peakHoldTimers[b] = 0
        }
        for (i in 0 until FFT_SIZE) pcmRingBuffer[i] = 0f
        _visualizerBands.value = FloatArray(BARS) { 0f }
        _peakBands.value = FloatArray(BARS) { 0f }
    }

    private fun startAudioCapture() {
        val isWindows = System.getProperty("os.name", "").lowercase().contains("win")
        if (!isWindows) {
            startFallbackLoop()
            return
        }
        // If an active thread for the current generation is already alive, keep it running
        val existing = captureThread
        if (existing != null && existing.isAlive) return

        val gen = captureGeneration.incrementAndGet()
        val t = Thread({ runWasapiLoopbackCapture(gen) }, "Nightly-WASAPI-Visualizer").apply {
            isDaemon = true
            priority = Thread.NORM_PRIORITY
        }
        captureThread = t
        t.start()
    }

    private fun stopAudioCapture() {
        captureGeneration.incrementAndGet()
        isRealAudioCaptured = false
        captureThread?.interrupt()
        captureThread = null
        fallbackJob?.cancel()
        fallbackJob = null
    }

    // =========================================================================
    // Native Windows Core Audio WASAPI Loopback COM Wrappers (Zero Native DLLs)
    // =========================================================================
    private class MMDeviceEnumeratorCom(p: Pointer) : Unknown(p) {
        fun getDefaultAudioEndpoint(dataFlow: Int, role: Int, ppEndpoint: PointerByReference): Int =
            _invokeNativeInt(4, arrayOf(pointer, dataFlow, role, ppEndpoint))
    }

    private class MMDeviceCom(p: Pointer) : Unknown(p) {
        fun activate(iid: Guid.REFIID, dwClsCtx: Int, pActivationParams: Pointer?, ppInterface: PointerByReference): Int =
            _invokeNativeInt(3, arrayOf(pointer, iid, dwClsCtx, pActivationParams, ppInterface))
    }

    private class AudioClientCom(p: Pointer) : Unknown(p) {
        fun initialize(
            shareMode: Int,
            streamFlags: Int,
            hnsBufferDuration: Long,
            hnsPeriodicity: Long,
            pFormat: Pointer,
            audioSessionGuid: Pointer?
        ): Int = _invokeNativeInt(3, arrayOf(pointer, shareMode, streamFlags, hnsBufferDuration, hnsPeriodicity, pFormat, audioSessionGuid))

        fun getMixFormat(ppDeviceFormat: PointerByReference): Int =
            _invokeNativeInt(8, arrayOf(pointer, ppDeviceFormat))

        fun start(): Int = _invokeNativeInt(10, arrayOf(pointer))
        fun stop(): Int = _invokeNativeInt(11, arrayOf(pointer))

        fun getService(riid: Guid.REFIID, ppv: PointerByReference): Int =
            _invokeNativeInt(14, arrayOf(pointer, riid, ppv))
    }

    private class AudioCaptureClientCom(p: Pointer) : Unknown(p) {
        fun getBuffer(
            ppData: PointerByReference,
            pNumFrames: IntByReference,
            pdwFlags: IntByReference,
            pu64DevicePosition: Pointer?,
            pu64QPCPosition: Pointer?
        ): Int = _invokeNativeInt(3, arrayOf(pointer, ppData, pNumFrames, pdwFlags, pu64DevicePosition, pu64QPCPosition))

        fun releaseBuffer(numFramesRead: Int): Int =
            _invokeNativeInt(4, arrayOf(pointer, numFramesRead))

        fun getNextPacketSize(pNumFramesInNextPacket: IntByReference): Int =
            _invokeNativeInt(5, arrayOf(pointer, pNumFramesInNextPacket))
    }

    private fun runWasapiLoopbackCapture(gen: Long) {
        val hrInit = runCatching {
            Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, Ole32.COINIT_MULTITHREADED).toInt()
        }.getOrElse {
            if (captureGeneration.get() == gen && isAudioActive) startFallbackLoop()
            return
        }

        // Reusable native read scratch buffers (zero allocations in packet loop)
        var floatScratch = FloatArray(8192)
        var shortScratch = ShortArray(8192)
        var byteScratch = ByteArray(32768)

        val clsidEnum = Guid.GUID("{BCDE0395-E52F-467C-8E3D-C4579291692E}")
        val iidEnum = Guid.GUID("{A95664D2-9614-4F35-A746-DE8DB63617E6}")
        val iidAudioClient = Guid.REFIID(Guid.IID("{1CB9AD4C-DBFA-4c32-B178-C2F568A703B2}"))
        val iidCaptureClient = Guid.REFIID(Guid.IID("{C8ADBD64-E71E-48a0-A4DE-185C395CD317}"))

        val audclntDeviceInvalidated = -2004287484 // 0x88890004
        val audclntBufferFlagsSilent = 0x2
        val audclntStreamFlagsLoopback = 0x00020000
        val clsctxAll = 0x17

        var consecutiveFailures = 0

        try {
            while (captureGeneration.get() == gen && isAudioActive && !Thread.currentThread().isInterrupted) {
                var enumerator: MMDeviceEnumeratorCom? = null
                var device: MMDeviceCom? = null
                var audioClient: AudioClientCom? = null
                var captureClient: AudioCaptureClientCom? = null
                var started = false

                try {
                    val pEnumRef = PointerByReference()
                    val hrEnum = Ole32.INSTANCE.CoCreateInstance(clsidEnum, Pointer.NULL, clsctxAll, iidEnum, pEnumRef).toInt()
                    if (hrEnum != 0 || pEnumRef.value == null) throw IllegalStateException("CoCreateInstance failed: 0x${hrEnum.toUInt().toString(16)}")
                    enumerator = MMDeviceEnumeratorCom(pEnumRef.value)

                    val pDevRef = PointerByReference()
                    val hrDev = enumerator.getDefaultAudioEndpoint(0 /* eRender */, 0 /* eConsole */, pDevRef)
                    if (hrDev != 0 || pDevRef.value == null) throw IllegalStateException("GetDefaultAudioEndpoint failed: 0x${hrDev.toUInt().toString(16)}")
                    device = MMDeviceCom(pDevRef.value)

                    val pClientRef = PointerByReference()
                    val hrAct = device.activate(iidAudioClient, clsctxAll, Pointer.NULL, pClientRef)
                    if (hrAct != 0 || pClientRef.value == null) throw IllegalStateException("Activate IAudioClient failed: 0x${hrAct.toUInt().toString(16)}")
                    audioClient = AudioClientCom(pClientRef.value)

                    val pFmtRef = PointerByReference()
                    val hrFmt = audioClient.getMixFormat(pFmtRef)
                    val pFmt = pFmtRef.value
                    if (hrFmt != 0 || pFmt == null) throw IllegalStateException("GetMixFormat failed: 0x${hrFmt.toUInt().toString(16)}")

                    val formatTag = pFmt.getShort(0).toInt() and 0xFFFF
                    val channels = (pFmt.getShort(2).toInt() and 0xFFFF).coerceIn(1, 16)
                    val sampleRate = pFmt.getInt(4).coerceIn(16000, 192000)
                    val blockAlign = (pFmt.getShort(12).toInt() and 0xFFFF).coerceAtLeast(channels * 2)
                    val bitsPerSample = pFmt.getShort(14).toInt() and 0xFFFF
                    val cbSize = pFmt.getShort(16).toInt() and 0xFFFF
                    val subFormatData1 = if (formatTag == 0xFFFE && cbSize >= 22) pFmt.getInt(24) else formatTag
                    val isFloat32 = (subFormatData1 == 3 && bitsPerSample == 32)
                    val isPcm16 = (subFormatData1 == 1 && bitsPerSample == 16)
                    val isPcm24 = (subFormatData1 == 1 && bitsPerSample == 24)
                    val isPcm32 = (subFormatData1 == 1 && bitsPerSample == 32)

                    val hrInitClient = audioClient.initialize(
                        0 /* AUDCLNT_SHAREMODE_SHARED */,
                        audclntStreamFlagsLoopback,
                        1_000_000L /* 100ms buffer */,
                        0L,
                        pFmt,
                        Pointer.NULL
                    )
                    Ole32.INSTANCE.CoTaskMemFree(pFmt)
                    if (hrInitClient != 0) throw IllegalStateException("IAudioClient.Initialize failed: 0x${hrInitClient.toUInt().toString(16)}")

                    val pCapRef = PointerByReference()
                    val hrSvc = audioClient.getService(iidCaptureClient, pCapRef)
                    if (hrSvc != 0 || pCapRef.value == null) throw IllegalStateException("GetService IAudioCaptureClient failed: 0x${hrSvc.toUInt().toString(16)}")
                    captureClient = AudioCaptureClientCom(pCapRef.value)

                    val hrStart = audioClient.start()
                    if (hrStart != 0) throw IllegalStateException("IAudioClient.Start failed: 0x${hrStart.toUInt().toString(16)}")
                    started = true
                    consecutiveFailures = 0

                    configureFrequencyBins(sampleRate)
                    if (captureGeneration.get() == gen) {
                        isRealAudioCaptured = true
                    }

                    val pktLenRef = IntByReference()
                    val pDataRef = PointerByReference()
                    val framesRef = IntByReference()
                    val flagsRef = IntByReference()
                    val invChannels = 1.0f / channels.toFloat()

                    // High-precision real-time packet drain loop (~60–80 Hz, <0.25% CPU)
                    while (captureGeneration.get() == gen && isAudioActive && !Thread.currentThread().isInterrupted) {
                        var gotAudioFrames = false
                        var gotNonSilent = false
                        var deviceLost = false

                        while (captureGeneration.get() == gen && isAudioActive) {
                            val hrNext = captureClient.getNextPacketSize(pktLenRef)
                            if (hrNext == audclntDeviceInvalidated) {
                                deviceLost = true
                                break
                            }
                            if (hrNext != 0) break
                            val packetFrames = pktLenRef.value
                            if (packetFrames <= 0) break

                            val hrBuf = captureClient.getBuffer(pDataRef, framesRef, flagsRef, Pointer.NULL, Pointer.NULL)
                            if (hrBuf == audclntDeviceInvalidated) {
                                deviceLost = true
                                break
                            }
                            if (hrBuf != 0) break

                            val frames = framesRef.value
                            val flags = flagsRef.value
                            val dataPtr = pDataRef.value

                            if (frames > 0) {
                                gotAudioFrames = true
                                val silent = (flags and audclntBufferFlagsSilent) != 0 || dataPtr == null
                                if (silent) {
                                    val count = min(frames, FFT_SIZE)
                                    for (f in 0 until count) {
                                        pcmRingBuffer[ringPos] = 0f
                                        ringPos = (ringPos + 1) and (FFT_SIZE - 1)
                                    }
                                } else {
                                    gotNonSilent = true
                                    val totalSamples = frames * channels
                                    when {
                                        isFloat32 -> {
                                            if (totalSamples > floatScratch.size && totalSamples <= 131072) {
                                                floatScratch = FloatArray(totalSamples)
                                            }
                                            val safeFrames = min(frames, floatScratch.size / channels)
                                            dataPtr!!.read(0L, floatScratch, 0, safeFrames * channels)
                                            var idx = 0
                                            for (f in 0 until safeFrames) {
                                                var sum = 0f
                                                for (c in 0 until channels) {
                                                    sum += floatScratch[idx++]
                                                }
                                                pcmRingBuffer[ringPos] = (sum * invChannels).coerceIn(-1.5f, 1.5f)
                                                ringPos = (ringPos + 1) and (FFT_SIZE - 1)
                                            }
                                        }
                                        isPcm16 -> {
                                            if (totalSamples > shortScratch.size && totalSamples <= 131072) {
                                                shortScratch = ShortArray(totalSamples)
                                            }
                                            val safeFrames = min(frames, shortScratch.size / channels)
                                            dataPtr!!.read(0L, shortScratch, 0, safeFrames * channels)
                                            var idx = 0
                                            val scale = invChannels / 32768.0f
                                            for (f in 0 until safeFrames) {
                                                var sum = 0f
                                                for (c in 0 until channels) {
                                                    sum += shortScratch[idx++].toFloat()
                                                }
                                                pcmRingBuffer[ringPos] = (sum * scale).coerceIn(-1.5f, 1.5f)
                                                ringPos = (ringPos + 1) and (FFT_SIZE - 1)
                                            }
                                        }
                                        isPcm24 || isPcm32 -> {
                                            val byteCount = frames * blockAlign
                                            if (byteCount > byteScratch.size && byteCount <= 262144) {
                                                byteScratch = ByteArray(byteCount)
                                            }
                                            val safeFrames = min(frames, byteScratch.size / blockAlign)
                                            dataPtr!!.read(0L, byteScratch, 0, safeFrames * blockAlign)
                                            val bytesPerCh = bitsPerSample / 8
                                            val normDiv = if (isPcm24) 8388608.0f else 2147483648.0f
                                            val scale = invChannels / normDiv
                                            for (f in 0 until safeFrames) {
                                                val base = f * blockAlign
                                                var sum = 0f
                                                for (c in 0 until channels) {
                                                    val o = base + c * bytesPerCh
                                                    val sampleInt = if (isPcm24) {
                                                        val raw24 = (byteScratch[o].toInt() and 0xFF) or
                                                            ((byteScratch[o + 1].toInt() and 0xFF) shl 8) or
                                                            (byteScratch[o + 2].toInt() shl 16)
                                                        raw24
                                                    } else {
                                                        (byteScratch[o].toInt() and 0xFF) or
                                                            ((byteScratch[o + 1].toInt() and 0xFF) shl 8) or
                                                            ((byteScratch[o + 2].toInt() and 0xFF) shl 16) or
                                                            (byteScratch[o + 3].toInt() shl 24)
                                                    }
                                                    sum += sampleInt.toFloat()
                                                }
                                                pcmRingBuffer[ringPos] = (sum * scale).coerceIn(-1.5f, 1.5f)
                                                ringPos = (ringPos + 1) and (FFT_SIZE - 1)
                                            }
                                        }
                                    }
                                }
                            }
                            captureClient.releaseBuffer(frames)
                        }

                        if (deviceLost) {
                            // User switched headphones/speakers -> tear down and re-acquire new default endpoint
                            break
                        }

                        val now = System.currentTimeMillis()
                        if (gotAudioFrames) {
                            lastUpdateTime = now
                            analyzeRingBufferAndPublish(hasNewSignal = gotNonSilent, nowMs = now)
                        } else if (now - lastUpdateTime >= 32L) {
                            // No active audio stream writing right now -> smooth calm decay
                            lastUpdateTime = now
                            analyzeRingBufferAndPublish(hasNewSignal = false, nowMs = now)
                        }

                        try {
                            Thread.sleep(14L)
                        } catch (_: InterruptedException) {
                            break
                        }
                    }
                } catch (e: Throwable) {
                    consecutiveFailures++
                    System.err.println("[AudioVisualizerManager] WASAPI loopback notice (#$consecutiveFailures): ${e.message}")
                    if (consecutiveFailures >= 3) {
                        // Graceful fallback if system has no audio render endpoint or broken audio service
                        if (captureGeneration.get() == gen) {
                            isRealAudioCaptured = false
                            if (isAudioActive) startFallbackLoop()
                        }
                        return
                    }
                } finally {
                    if (started) runCatching { audioClient?.stop() }
                    runCatching { captureClient?.Release() }
                    runCatching { audioClient?.Release() }
                    runCatching { device?.Release() }
                    runCatching { enumerator?.Release() }
                }

                if (captureGeneration.get() == gen && isAudioActive && !Thread.currentThread().isInterrupted) {
                    try {
                        Thread.sleep(260L)
                    } catch (_: InterruptedException) {
                        break
                    }
                }
            }
        } finally {
            if (captureGeneration.get() == gen) {
                isRealAudioCaptured = false
            }
            if (hrInit == 0 || hrInit == 1) {
                runCatching { Ole32.INSTANCE.CoUninitialize() }
            }
        }
    }

    /** Fallback loop ONLY used on non-Windows OS or machines without any audio output endpoint. */
    private fun startFallbackLoop() {
        if (fallbackJob?.isActive == true) return
        fallbackJob = scope.launch {
            var phase = 0.0
            while (isActive && isAudioActive) {
                phase += 0.10
                val now = System.currentTimeMillis()
                lastUpdateTime = now

                val beatProgress = ((phase * 1.55) % (2.0 * PI)).toFloat()
                val kickImpulse = if (beatProgress < 0.55f) exp(-beatProgress * 7.5f) else 0f
                val kickHit = (kickImpulse * 0.90f).coerceIn(0f, 1f)

                val backbeatProgress = (((phase * 1.55) + PI) % (2.0 * PI)).toFloat()
                val snareImpulse = if (backbeatProgress < 0.50f) exp(-backbeatProgress * 8.0f) else 0f
                val snareHit = (snareImpulse * 0.80f).coerceIn(0f, 1f)

                val hihatTick = abs(sin(phase * 6.2).toFloat()).pow(3.5f) * 0.65f
                val macroEnvelope = (0.55f + 0.40f * sin(phase * 0.16).toFloat()).coerceIn(0.20f, 0.95f)

                for (b in 0 until BARS) {
                    val melodicWave = (sin(phase * 0.80 + b * 0.35).toFloat() * 0.24f + 0.24f)
                    val rawEnergy = when {
                        b < 7 -> (kickHit * 0.88f + melodicWave * 0.22f) * macroEnvelope
                        b < 18 -> (snareHit * 0.78f + melodicWave * 0.48f + kickHit * 0.18f) * macroEnvelope
                        else -> (hihatTick * 0.82f + melodicWave * 0.25f) * macroEnvelope
                    }
                    val targetEnergy = rawEnergy.coerceIn(0.04f, 0.96f)
                    currentBands[b] = if (targetEnergy >= currentBands[b]) targetEnergy else max(0.03f, currentBands[b] * 0.81f - 0.006f)
                    peakBandsInternal[b] = max(currentBands[b], peakBandsInternal[b] - 0.022f)
                }

                liveBass = (kickHit * macroEnvelope).coerceIn(0f, 1f)
                liveMid = (snareHit * 0.7f * macroEnvelope).coerceIn(0f, 1f)
                liveTreble = (hihatTick * macroEnvelope).coerceIn(0f, 1f)
                liveBeatImpulse = liveBass
                liveRms = ((liveBass * 0.5f + liveMid * 0.35f + liveTreble * 0.15f)).coerceIn(0f, 1f)

                val writeBuf = if (activeWaveBuf === waveBufA) waveBufB else waveBufA
                for (i in 0 until WAVEFORM_SAMPLES) {
                    val t = i.toFloat() / WAVEFORM_SAMPLES.toFloat()
                    writeBuf[i] = (sin(t * 24f + phase.toFloat() * 3f) * liveMid * 0.4f +
                        sin(t * 6f - phase.toFloat() * 2f) * liveBass * 0.5f).coerceIn(-1f, 1f)
                }
                activeWaveBuf = writeBuf

                emitFlowsIfDue(now)
                delay(20L)
            }
        }
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
