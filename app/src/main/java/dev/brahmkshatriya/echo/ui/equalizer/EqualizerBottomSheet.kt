package dev.brahmkshatriya.echo.ui.equalizer

import android.content.Context
import android.content.SharedPreferences
import android.media.audiofx.BassBoost
import android.media.audiofx.Equalizer
import android.media.audiofx.Virtualizer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.databinding.BottomSheetEqualizerBinding

class EqualizerBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetEqualizerBinding? = null
    private val binding get() = _binding!!

    private lateinit var prefs: SharedPreferences
    private var equalizer: Equalizer? = null
    private var bassBoost: BassBoost? = null
    private var virtualizer: Virtualizer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetEqualizerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()
        prefs = context.getSharedPreferences("nightly_audio_engine", Context.MODE_PRIVATE)

        initAudioEffects()
        loadSavedSettings()
        setupListeners()
    }

    private fun initAudioEffects() {
        runCatching {
            equalizer = Equalizer(0, 0).apply { enabled = true }
        }
        runCatching {
            bassBoost = BassBoost(0, 0).apply { enabled = true }
        }
        runCatching {
            virtualizer = Virtualizer(0, 0).apply { enabled = true }
        }
    }

    private fun loadSavedSettings() {
        // Load 5 EQ bands
        val b0 = prefs.getFloat("eq_band_0", 0f)
        val b1 = prefs.getFloat("eq_band_1", 0f)
        val b2 = prefs.getFloat("eq_band_2", 0f)
        val b3 = prefs.getFloat("eq_band_3", 0f)
        val b4 = prefs.getFloat("eq_band_4", 0f)

        binding.sliderBand0.value = b0
        binding.sliderBand1.value = b1
        binding.sliderBand2.value = b2
        binding.sliderBand3.value = b3
        binding.sliderBand4.value = b4

        updateBandLabel(binding.tvBand0, b0)
        updateBandLabel(binding.tvBand1, b1)
        updateBandLabel(binding.tvBand2, b2)
        updateBandLabel(binding.tvBand3, b3)
        updateBandLabel(binding.tvBand4, b4)

        applyBand(0, b0)
        applyBand(1, b1)
        applyBand(2, b2)
        applyBand(3, b3)
        applyBand(4, b4)

        // Bass Boost & Virtualizer
        val bb = prefs.getFloat("bass_boost", 20f)
        binding.sliderBassBoost.value = bb
        binding.tvBassBoostVal.text = "${bb.toInt()}%"
        applyBassBoost(bb)

        val virt = prefs.getFloat("virtualizer", 15f)
        binding.sliderVirtualizer.value = virt
        binding.tvVirtualizerVal.text = "${virt.toInt()}%"
        applyVirtualizer(virt)

        // Toggles
        binding.switchNormalization.isChecked = prefs.getBoolean("audio_norm", true)
        binding.switchLowLatency.isChecked = prefs.getBoolean("low_latency", true)
    }

    private fun setupListeners() {
        binding.sliderBand0.addOnChangeListener { _, value, _ ->
            updateBandLabel(binding.tvBand0, value)
            applyBand(0, value)
            prefs.edit().putFloat("eq_band_0", value).apply()
        }
        binding.sliderBand1.addOnChangeListener { _, value, _ ->
            updateBandLabel(binding.tvBand1, value)
            applyBand(1, value)
            prefs.edit().putFloat("eq_band_1", value).apply()
        }
        binding.sliderBand2.addOnChangeListener { _, value, _ ->
            updateBandLabel(binding.tvBand2, value)
            applyBand(2, value)
            prefs.edit().putFloat("eq_band_2", value).apply()
        }
        binding.sliderBand3.addOnChangeListener { _, value, _ ->
            updateBandLabel(binding.tvBand3, value)
            applyBand(3, value)
            prefs.edit().putFloat("eq_band_3", value).apply()
        }
        binding.sliderBand4.addOnChangeListener { _, value, _ ->
            updateBandLabel(binding.tvBand4, value)
            applyBand(4, value)
            prefs.edit().putFloat("eq_band_4", value).apply()
        }

        binding.sliderBassBoost.addOnChangeListener { _, value, _ ->
            binding.tvBassBoostVal.text = "${value.toInt()}%"
            applyBassBoost(value)
            prefs.edit().putFloat("bass_boost", value).apply()
        }

        binding.sliderVirtualizer.addOnChangeListener { _, value, _ ->
            binding.tvVirtualizerVal.text = "${value.toInt()}%"
            applyVirtualizer(value)
            prefs.edit().putFloat("virtualizer", value).apply()
        }

        binding.switchNormalization.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("audio_norm", isChecked).apply()
        }

        binding.switchLowLatency.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("low_latency", isChecked).apply()
        }

        // Preset Buttons
        binding.presetFlat.setOnClickListener { applyPreset(0f, 0f, 0f, 0f, 0f, 0f, 0f) }
        binding.presetBass.setOnClickListener { applyPreset(8f, 5f, 0f, 1f, 2f, 65f, 20f) }
        binding.presetVocal.setOnClickListener { applyPreset(-2f, 1f, 6f, 4f, 2f, 10f, 30f) }
        binding.presetElectronic.setOnClickListener { applyPreset(6f, 3f, -1f, 4f, 5f, 45f, 40f) }
        binding.presetRock.setOnClickListener { applyPreset(5f, 2f, -2f, 3f, 6f, 35f, 25f) }

        binding.btnResetEqualizer.setOnClickListener {
            applyPreset(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        }
    }

    private fun applyPreset(b0: Float, b1: Float, b2: Float, b3: Float, b4: Float, bb: Float, virt: Float) {
        binding.sliderBand0.value = b0
        binding.sliderBand1.value = b1
        binding.sliderBand2.value = b2
        binding.sliderBand3.value = b3
        binding.sliderBand4.value = b4
        binding.sliderBassBoost.value = bb
        binding.sliderVirtualizer.value = virt

        updateBandLabel(binding.tvBand0, b0)
        updateBandLabel(binding.tvBand1, b1)
        updateBandLabel(binding.tvBand2, b2)
        updateBandLabel(binding.tvBand3, b3)
        updateBandLabel(binding.tvBand4, b4)
        binding.tvBassBoostVal.text = "${bb.toInt()}%"
        binding.tvVirtualizerVal.text = "${virt.toInt()}%"

        applyBand(0, b0)
        applyBand(1, b1)
        applyBand(2, b2)
        applyBand(3, b3)
        applyBand(4, b4)
        applyBassBoost(bb)
        applyVirtualizer(virt)

        prefs.edit()
            .putFloat("eq_band_0", b0)
            .putFloat("eq_band_1", b1)
            .putFloat("eq_band_2", b2)
            .putFloat("eq_band_3", b3)
            .putFloat("eq_band_4", b4)
            .putFloat("bass_boost", bb)
            .putFloat("virtualizer", virt)
            .apply()
    }

    private fun updateBandLabel(tv: TextView, db: Float) {
        val sign = if (db > 0) "+" else ""
        tv.text = "$sign${db.toInt()} dB"
    }

    private fun applyBand(index: Int, db: Float) {
        runCatching {
            val eq = equalizer ?: return@runCatching
            if (index < eq.numberOfBands) {
                // dB * 100 = millibels
                val mb = (db * 100).toInt().coerceIn(eq.bandLevelRange[0].toInt(), eq.bandLevelRange[1].toInt()).toShort()
                eq.setBandLevel(index.toShort(), mb)
            }
        }
    }

    private fun applyBassBoost(percent: Float) {
        runCatching {
            val bb = bassBoost ?: return@runCatching
            if (bb.strengthSupported) {
                val strength = (percent * 10).toInt().coerceIn(0, 1000).toShort()
                bb.setStrength(strength)
            }
        }
    }

    private fun applyVirtualizer(percent: Float) {
        runCatching {
            val virt = virtualizer ?: return@runCatching
            if (virt.strengthSupported) {
                val strength = (percent * 10).toInt().coerceIn(0, 1000).toShort()
                virt.setStrength(strength)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        runCatching { equalizer?.release() }
        runCatching { bassBoost?.release() }
        runCatching { virtualizer?.release() }
    }
}
