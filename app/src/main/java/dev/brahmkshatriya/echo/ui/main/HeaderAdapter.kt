package dev.brahmkshatriya.echo.ui.main

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.color.MaterialColors
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.common.Extension
import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.models.ExtensionType
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.User
import dev.brahmkshatriya.echo.databinding.ItemMainHeaderBinding
import dev.brahmkshatriya.echo.extensions.db.models.UserEntity.Companion.toEntity
import dev.brahmkshatriya.echo.playback.PlayerState
import dev.brahmkshatriya.echo.ui.ai.AiStudioBottomSheet
import dev.brahmkshatriya.echo.ui.common.GridAdapter
import dev.brahmkshatriya.echo.ui.equalizer.EqualizerBottomSheet
import dev.brahmkshatriya.echo.ui.extensions.list.ExtensionsListBottomSheet
import dev.brahmkshatriya.echo.ui.extensions.login.LoginUserListViewModel
import dev.brahmkshatriya.echo.ui.movie.CinemaDetailsBottomSheet
import dev.brahmkshatriya.echo.ui.movie.CinemaStudioBottomSheet
import dev.brahmkshatriya.echo.ui.movie.MoviePlayRepository
import dev.brahmkshatriya.echo.ui.player.PlayerViewModel
import dev.brahmkshatriya.echo.ui.screensaver.ScreensaverActivity
import dev.brahmkshatriya.echo.ui.settings.SettingsBottomSheet
import dev.brahmkshatriya.echo.utils.ContextUtils.observe
import dev.brahmkshatriya.echo.utils.image.ImageUtils.loadAsCircle
import dev.brahmkshatriya.echo.utils.image.ImageUtils.loadInto
import dev.brahmkshatriya.echo.utils.ui.scrolling.ScrollAnimRecyclerAdapter
import dev.brahmkshatriya.echo.utils.ui.scrolling.ScrollAnimViewHolder
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class HeaderAdapter(
    private val fragment: Fragment,
) : ScrollAnimRecyclerAdapter<HeaderAdapter.ViewHolder>(), GridAdapter {
    private val viewModel by fragment.activityViewModel<LoginUserListViewModel>()
    private val playerViewModel by fragment.activityViewModel<PlayerViewModel>()

    override val adapter = this
    override fun getSpanSize(position: Int, width: Int, count: Int) = count
    override fun getItemCount() = 1

    private var currentPlayingState: PlayerState.Current? = null
    private var liveVinylAnimator: ObjectAnimator? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(parent)
        val binding = holder.binding
        val parentFragmentManager = fragment.parentFragmentManager
        val context = parent.context

        binding.extensionsCont.setOnClickListener {
            ExtensionsListBottomSheet.newInstance(ExtensionType.MUSIC)
                .show(parentFragmentManager, null)
        }

        binding.accountsCont.setOnClickListener {
            SettingsBottomSheet().show(parentFragmentManager, null)
        }

        // Screensaver triggers
        val openScreensaver = View.OnClickListener {
            ScreensaverActivity.launch(context)
        }
        binding.tileScreensaver.setOnClickListener(openScreensaver)
        binding.btnLaunchScreensaver.setOnClickListener(openScreensaver)

        // Equalizer trigger
        binding.tileEqualizer.setOnClickListener {
            EqualizerBottomSheet().show(parentFragmentManager, null)
        }

        // AI Studio trigger
        binding.tileAiStudio.setOnClickListener {
            AiStudioBottomSheet().show(parentFragmentManager, null)
        }

        // Cinema Studio triggers
        val openCinema = View.OnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }
        binding.tileCinemaStudio.setOnClickListener(openCinema)
        binding.btnViewAllMovies.setOnClickListener(openCinema)

        // Tapping Now Playing card opens screensaver
        binding.cardNowPlayingSoundstage.setOnClickListener {
            ScreensaverActivity.launch(context)
        }

        // Live Play/Pause button
        binding.btnLivePlayPause.setOnClickListener {
            val browser = playerViewModel.browser.value
            if (browser != null && browser.mediaItemCount > 0) {
                if (browser.isPlaying) browser.pause() else browser.play()
            } else {
                AiStudioBottomSheet().show(parentFragmentManager, null)
            }
        }

        // Extension Switcher Chips
        fun selectExtensionById(id: String) {
            val exts = viewModel.extensionLoader.music.value
            val target = exts.find { it.id == id } ?: exts.firstOrNull()
            if (target != null) {
                viewModel.extensionLoader.setupMusicExtension(target, true)
            }
        }

        binding.chipMasterCollection.setOnClickListener { selectExtensionById("unified") }
        binding.chipSpotify.setOnClickListener { selectExtensionById("spotify_music") }
        binding.chipSaavn.setOnClickListener { selectExtensionById("saavn_music") }
        binding.chipYoutube.setOnClickListener { selectExtensionById("youtube_music") }
        binding.chipSoundCloud.setOnClickListener { selectExtensionById("soundcloud") }
        binding.chipRadio.setOnClickListener { selectExtensionById("radiobrowser") }

        // Setup spinning vinyl animator
        liveVinylAnimator = ObjectAnimator.ofFloat(binding.flLiveVinylContainer, "rotation", 0f, 360f).apply {
            duration = 14000L
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
        }

        return holder
    }

    private var extension: MusicExtension? = null
        set(value) {
            field = value
            notifyItemChanged(0)
        }

    private var triple: Triple<Extension<*>?, Boolean, List<Pair<User, Boolean>>> =
        Triple(null, false, emptyList())
        set(value) {
            field = value
            notifyItemChanged(0)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.binding) {
        super.onBindViewHolder(holder, position)
        val context = root.context
        val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        val greetingStr = when (hour) {
            in 4..11 -> "Good morning"
            in 12..16 -> "Good afternoon"
            else -> "Good evening"
        }
        headerGreeting.text = greetingStr
        title.text = extension?.name ?: "Master Collection"
        extensions.loadBigIcon(extension?.metadata?.icon, R.drawable.ic_extension_32dp)

        val (ext, isLoginClient, all) = triple
        accounts.loadBigIcon(
            viewModel.currentUser.value?.cover,
            if (isLoginClient) R.drawable.ic_account_circle_32dp else R.drawable.ic_settings_outline_32dp
        )
        accountsCont.setLoopedLongClick(all, { all.find { it.second } }) {
            ext ?: return@setLoopedLongClick
            viewModel.setLoginUser(it.first.toEntity(ext.type, ext.id))
        }

        // Bind Live Playing track info
        val current = currentPlayingState
        val track = current?.track
        if (track != null) {
            tvLiveTrackTitle.text = track.title
            val artistStr = track.artists.joinToString(", ") { it.name }
            tvLiveTrackArtist.text = if (track.album != null) {
                "$artistStr • ${track.album?.title}"
            } else {
                artistStr
            }
            track.cover.loadInto(ivLiveCover, R.drawable.art_music)
        } else {
            tvLiveTrackTitle.text = "Nightly Hi-Res Flow"
            tvLiveTrackArtist.text = "Master Collection • Ready to stream"
            ivLiveCover.setImageResource(R.drawable.art_music)
        }

        val isPlaying = current?.isPlaying == true
        if (isPlaying) {
            tvLivePlayText.text = "Pause"
            ivLivePlayIcon.setImageResource(R.drawable.ic_pause_to_play_48dp_anim)
            if (liveVinylAnimator?.isStarted == true) {
                liveVinylAnimator?.resume()
            } else {
                liveVinylAnimator?.start()
            }
        } else {
            tvLivePlayText.text = if (track != null) "Resume" else "Play Flow"
            ivLivePlayIcon.setImageResource(R.drawable.ic_play)
            liveVinylAnimator?.pause()
        }

        // Horizontal Movie Carousel
        if (rvHeaderMovies.adapter == null) {
            val movies = MoviePlayRepository.getMovies(context)
            rvHeaderMovies.adapter = CinemaStudioBottomSheet.CinemaAdapter(movies) { movie ->
                CinemaDetailsBottomSheet.newInstance(movie).show(fragment.parentFragmentManager, null)
            }
        }
    }

    class ViewHolder(
        parent: ViewGroup,
        val binding: ItemMainHeaderBinding = ItemMainHeaderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
    ) : ScrollAnimViewHolder(binding.root)

    init {
        with(fragment) {
            observe(viewModel.extensionLoader.current) {
                viewModel.currentExtension.value = it
                extension = it
            }
            observe(viewModel.allUsersWithClient) {
                triple = it
            }
            observe(playerViewModel.playerState.current) { current ->
                currentPlayingState = current
                notifyItemChanged(0)
            }
        }
    }

    companion object {
        fun <T> View.setLoopedLongClick(
            list: List<T>,
            getCurrent: (View) -> T?,
            onSelect: (T) -> Unit,
        ) {
            setOnClickListener {
                if (list.size <= 1) return@setOnClickListener
                val current = getCurrent(it)
                val index = list.indexOf(current)
                val next = list[(index + 1) % list.size]
                onSelect(next)
            }
        }

        fun ImageView.loadBigIcon(image: ImageHolder?, placeholder: Int) {
            val color = ColorStateList.valueOf(
                MaterialColors.getColor(
                    this,
                    androidx.appcompat.R.attr.colorControlNormal
                )
            )
            image.loadAsCircle(this) {
                if (it == null) {
                    imageTintList = color
                    setImageResource(placeholder)
                } else {
                    imageTintList = null
                    setImageDrawable(it)
                }
            }
        }
    }
}
