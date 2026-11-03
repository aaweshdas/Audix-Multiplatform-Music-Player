package dev.brahmkshatriya.echo.ui.movie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.common.models.ImageHolder.Companion.toImageHolder
import dev.brahmkshatriya.echo.databinding.BottomSheetCinemaDetailsBinding
import dev.brahmkshatriya.echo.utils.image.ImageUtils.loadInto
import java.net.URLEncoder

class CinemaDetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetCinemaDetailsBinding? = null
    private val binding get() = _binding!!

    override fun getTheme() = R.style.EchoBottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetCinemaDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(ARG_TITLE) ?: "Movie"
        val year = arguments?.getString(ARG_YEAR) ?: ""
        val genre = arguments?.getString(ARG_GENRE) ?: ""
        val duration = arguments?.getString(ARG_DURATION) ?: ""
        val rating = arguments?.getString(ARG_RATING) ?: "8.5"
        val badge = arguments?.getString(ARG_BADGE) ?: "1080p HD"
        val coverUrl = arguments?.getString(ARG_COVER) ?: ""
        val bannerUrl = arguments?.getString(ARG_BANNER) ?: coverUrl
        val desc = arguments?.getString(ARG_DESC) ?: ""
        val movieId = arguments?.getString(ARG_ID) ?: ""

        binding.movieTitle.text = title
        binding.movieBadge.text = badge
        binding.movieGenre.text = genre
        binding.movieMeta.text = "$year • $duration • ★ $rating"
        binding.movieDescription.text = desc

        if (coverUrl.isNotBlank()) {
            coverUrl.toImageHolder().loadInto(binding.moviePoster)
        }
        if (bannerUrl.isNotBlank()) {
            bannerUrl.toImageHolder().loadInto(binding.movieBanner)
        }

        binding.btnWatchStream.setOnClickListener {
            val streamUrl = when {
                movieId.startsWith("tt") -> "https://vidsrc.to/embed/movie/$movieId"
                movieId.isNotBlank() -> "https://vidsrc.to/embed/movie/$movieId"
                else -> "https://vidsrc.to/embed/movie/${URLEncoder.encode(title, "UTF-8")}"
            }
            runCatching {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(streamUrl)).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                startActivity(intent)
            }
        }

        binding.btnSoundtracks.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_ID = "id"
        private const val ARG_TITLE = "title"
        private const val ARG_YEAR = "year"
        private const val ARG_GENRE = "genre"
        private const val ARG_DURATION = "duration"
        private const val ARG_RATING = "rating"
        private const val ARG_BADGE = "badge"
        private const val ARG_COVER = "cover"
        private const val ARG_BANNER = "banner"
        private const val ARG_DESC = "desc"

        fun newInstance(movie: MovieBoxItem): CinemaDetailsBottomSheet {
            return CinemaDetailsBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID, movie.id)
                    putString(ARG_TITLE, movie.title)
                    putString(ARG_YEAR, movie.year)
                    putString(ARG_GENRE, movie.genre)
                    putString(ARG_DURATION, movie.duration)
                    putString(ARG_RATING, movie.rating)
                    putString(ARG_BADGE, movie.qualityBadge)
                    putString(ARG_COVER, movie.coverUrl)
                    putString(ARG_BANNER, movie.bannerUrl)
                    putString(ARG_DESC, movie.description)
                }
            }
        }
    }
}
