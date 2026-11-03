package dev.brahmkshatriya.echo.ui.screensaver

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.databinding.ActivityScreensaverBinding
import dev.brahmkshatriya.echo.playback.PlayerState
import dev.brahmkshatriya.echo.ui.equalizer.EqualizerBottomSheet
import dev.brahmkshatriya.echo.ui.player.PlayerViewModel
import dev.brahmkshatriya.echo.utils.image.ImageUtils.loadInto
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class ScreensaverActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScreensaverBinding
    private val playerViewModel by viewModel<PlayerViewModel>()

    private val handler = Handler(Looper.getMainLooper())
    private var isPlaying = false
    private var isSeeking = false
    private lateinit var audioManager: AudioManager

    private val progressRunnable = object : Runnable {
        override fun run() {
            updateProgress()
            handler.postDelayed(this, 800L)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreensaverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        // Fullscreen immersive mode
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)
        insetsController.hide(WindowInsetsCompat.Type.systemBars())
        insetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        setupListeners()
        observePlayback()
        setupVolume()
    }

    private fun setupListeners() {
        // Dismiss on close button or background tap
        binding.btnCloseScreensaver.setOnClickListener { finish() }
        binding.screensaverRoot.setOnClickListener { finish() }
        binding.cardScreensaverConsole.setOnClickListener {
            // Absorb click so interacting with the card doesn't exit screensaver
        }

        binding.btnScreensaverAirplay.setOnClickListener {
            EqualizerBottomSheet().show(supportFragmentManager, null)
        }

        binding.btnPlayPause.setOnClickListener {
            val browser = playerViewModel.browser.value ?: return@setOnClickListener
            if (browser.isPlaying) {
                browser.pause()
            } else {
                browser.play()
            }
        }

        binding.btnPrevious.setOnClickListener {
            val browser = playerViewModel.browser.value ?: return@setOnClickListener
            if (browser.hasPreviousMediaItem()) {
                browser.seekToPreviousMediaItem()
            } else {
                browser.seekTo(0L)
            }
        }

        binding.btnNext.setOnClickListener {
            val browser = playerViewModel.browser.value ?: return@setOnClickListener
            if (browser.hasNextMediaItem()) {
                browser.seekToNextMediaItem()
            }
        }

        // Progress seekbar
        binding.sliderProgress.addOnChangeListener { _, value, fromUser ->
            if (fromUser) {
                val browser = playerViewModel.browser.value ?: return@addOnChangeListener
                val duration = browser.duration.coerceAtLeast(0L)
                if (duration > 0) {
                    val pos = (duration * value).toLong()
                    val rem = (duration - pos).coerceAtLeast(0L)
                    binding.tvCurrentTime.text = formatMs(pos)
                    binding.tvTotalDuration.text = "-${formatMs(rem)}"
                }
            }
        }

        binding.sliderProgress.addOnSliderTouchListener(object :
            com.google.android.material.slider.Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: com.google.android.material.slider.Slider) {
                isSeeking = true
            }

            override fun onStopTrackingTouch(slider: com.google.android.material.slider.Slider) {
                val browser = playerViewModel.browser.value
                val duration = browser?.duration?.coerceAtLeast(0L) ?: 0L
                if (duration > 0) {
                    val targetMs = (duration * slider.value).toLong()
                    browser?.seekTo(targetMs)
                }
                isSeeking = false
            }
        })
    }

    private fun setupVolume() {
        runCatching {
            val maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            val currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
            if (maxVol > 0) {
                binding.sliderVolume.value = (currentVol.toFloat() / maxVol.toFloat()).coerceIn(0f, 1f)
            }

            binding.sliderVolume.addOnChangeListener { _, value, fromUser ->
                if (fromUser && maxVol > 0) {
                    val target = (value * maxVol).toInt().coerceIn(0, maxVol)
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, target, 0)
                }
            }
        }
    }

    private fun observePlayback() {
        lifecycleScope.launch {
            playerViewModel.playerState.current.collectLatest { current ->
                updateUiForCurrent(current)
            }
        }
    }

    private fun updateUiForCurrent(current: PlayerState.Current?) {
        val track = current?.track
        if (track != null) {
            val rawTitle = track.title
            val displayTitle = rawTitle.replace(
                Regex("""\s*[\(\[\{].*?(?:official|music\s*video|video|audio|lyrics|lyric\s*video|feat|ft\.|hd|4k|remaster|visualizer|live|full\s*song|from\s*["']|soundtrack|ost).*?[\)\]\}]""", RegexOption.IGNORE_CASE),
                ""
            ).substringBefore("|").substringBefore("//").trim().ifBlank { rawTitle.trim() }

            binding.tvScreensaverTitle.text = displayTitle
            val artistStr = track.artists.joinToString(", ") { it.name.trim() }.ifBlank { "Nightly Artist" }
            binding.tvScreensaverArtist.text = artistStr
            binding.tvDeviceSpec.text = "Nightly • Studio Hi-Res Stream"

            track.cover.loadInto(binding.ivScreensaverCover, R.drawable.art_music)
        } else {
            binding.tvScreensaverTitle.text = "Nightly Hi-Res Flow"
            binding.tvScreensaverArtist.text = "Studio Soundstage • Ready"
            binding.tvDeviceSpec.text = "Nightly • Idle"
            binding.ivScreensaverCover.setImageResource(R.drawable.art_music)
        }

        val playing = current?.isPlaying == true
        isPlaying = playing

        if (playing) {
            binding.btnPlayPause.setImageResource(R.drawable.ic_pause_to_play_48dp_anim)
        } else {
            binding.btnPlayPause.setImageResource(R.drawable.ic_play)
        }

        updateProgress()
    }

    private fun updateProgress() {
        if (isSeeking) return
        val browser = playerViewModel.browser.value ?: return
        val pos = browser.currentPosition.coerceAtLeast(0L)
        val dur = browser.duration.coerceAtLeast(0L)
        val rem = (dur - pos).coerceAtLeast(0L)

        binding.tvCurrentTime.text = formatMs(pos)
        binding.tvTotalDuration.text = if (dur > 0L) "-${formatMs(rem)}" else "-0:00"

        if (dur > 0L) {
            val frac = (pos.toFloat() / dur.toFloat()).coerceIn(0f, 1f)
            binding.sliderProgress.value = frac
        } else {
            binding.sliderProgress.value = 0f
        }
    }

    private fun formatMs(ms: Long): String {
        val totalSecs = (ms / 1000).coerceAtLeast(0)
        val mins = totalSecs / 60
        val secs = totalSecs % 60
        return String.format(Locale.getDefault(), "%d:%02d", mins, secs)
    }

    override fun onResume() {
        super.onResume()
        handler.post(progressRunnable)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(progressRunnable)
    }

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, ScreensaverActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
            context.startActivity(intent)
        }
    }
}
