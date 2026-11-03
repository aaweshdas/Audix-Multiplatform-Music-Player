package dev.brahmkshatriya.echo.ui.movie

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.common.models.ImageHolder.Companion.toImageHolder
import dev.brahmkshatriya.echo.databinding.BottomSheetCinemaStudioBinding
import dev.brahmkshatriya.echo.databinding.ItemMovieCardBinding
import dev.brahmkshatriya.echo.utils.image.ImageUtils.loadInto

class CinemaStudioBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetCinemaStudioBinding? = null
    private val binding get() = _binding!!

    override fun getTheme() = R.style.EchoBottomSheetDialog

    override fun onStart() {
        super.onStart()
        val dialog = dialog as? BottomSheetDialog
        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.let {
            val behavior = BottomSheetBehavior.from(it)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            behavior.skipCollapsed = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetCinemaStudioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()
        val allMovies = MoviePlayRepository.getMovies(context)
        var filteredList = allMovies

        binding.movieCountBadge.text = "${allMovies.size} TITLES"

        val adapter = CinemaAdapter(filteredList) { movie ->
            CinemaDetailsBottomSheet.newInstance(movie).show(parentFragmentManager, null)
        }

        binding.rvCinemaGrid.layoutManager = GridLayoutManager(context, 3)
        binding.rvCinemaGrid.adapter = adapter

        binding.searchCinemaInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s?.toString()?.trim() ?: ""
                filteredList = if (query.isBlank()) {
                    allMovies
                } else {
                    allMovies.filter {
                        it.title.contains(query, ignoreCase = true) ||
                                it.genre.contains(query, ignoreCase = true) ||
                                it.year.contains(query, ignoreCase = true)
                    }
                }
                adapter.updateItems(filteredList)
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class CinemaAdapter(
        private var items: List<MovieBoxItem>,
        private val onMovieClick: (MovieBoxItem) -> Unit
    ) : RecyclerView.Adapter<CinemaAdapter.ViewHolder>() {

        fun updateItems(newItems: List<MovieBoxItem>) {
            items = newItems
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemMovieCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.binding.movieTitle.text = item.title
            holder.binding.movieSubtitle.text = "${item.year} • ${item.genre.split(",").firstOrNull()?.trim() ?: "Cinema"}"
            holder.binding.movieBadge.text = item.qualityBadge

            if (item.coverUrl.isNotBlank()) {
                item.coverUrl.toImageHolder().loadInto(holder.binding.moviePoster)
            }
            holder.itemView.setOnClickListener {
                onMovieClick(item)
            }
        }

        override fun getItemCount() = items.size

        class ViewHolder(val binding: ItemMovieCardBinding) : RecyclerView.ViewHolder(binding.root)
    }
}
