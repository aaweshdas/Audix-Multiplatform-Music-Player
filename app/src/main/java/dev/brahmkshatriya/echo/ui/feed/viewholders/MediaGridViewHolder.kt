package dev.brahmkshatriya.echo.ui.feed.viewholders

import android.graphics.drawable.Animatable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import dev.brahmkshatriya.echo.R
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.databinding.ItemShelfMediaGridBinding
import dev.brahmkshatriya.echo.playback.PlayerState
import dev.brahmkshatriya.echo.ui.feed.FeedClickListener
import dev.brahmkshatriya.echo.ui.feed.FeedType
import dev.brahmkshatriya.echo.ui.feed.viewholders.MediaViewHolder.Companion.applyCover
import dev.brahmkshatriya.echo.ui.feed.viewholders.MediaViewHolder.Companion.subtitle
import dev.brahmkshatriya.echo.ui.media.MediaHeaderAdapter.Companion.playableString

class MediaGridViewHolder(
    parent: ViewGroup,
    listener: FeedClickListener,
    getAllTracks: (FeedType) -> Pair<List<Track>, Int>,
    val binding: ItemShelfMediaGridBinding = ItemShelfMediaGridBinding.inflate(
        LayoutInflater.from(parent.context), parent, false
    ),
) : FeedViewHolder<FeedType.MediaGrid>(binding.root) {
    var feed: FeedType.MediaGrid? = null
    private var lastCurrent: PlayerState.Current? = null

    init {
        binding.root.setOnClickListener {
            val item = feed?.item ?: return@setOnClickListener
            when (item) {
                is Track -> {
                    if (item.isPlayable != Track.Playable.Yes) {
                        listener.onMediaClicked(it, feed?.extensionId, item, feed?.context)
                        return@setOnClickListener
                    }
                    val (tracks, pos) = getAllTracks(feed!!)
                    listener.onTracksClicked(it, feed?.extensionId, feed?.context, tracks, pos)
                }

                else -> listener.onMediaClicked(it, feed?.extensionId, item, feed?.context)
            }
        }
        binding.root.setOnLongClickListener {
            listener.onMediaLongClicked(
                it, feed?.extensionId, feed?.item,
                feed?.context, feed?.tabId, bindingAdapterPosition
            )
            true
        }
    }

    override fun bind(feed: FeedType.MediaGrid) {
        this.feed = feed
        val item = feed.item
        val index = feed.number
        binding.title.text = if (index == null) item.title
        else binding.root.context.getString(R.string.n_dot_x, index + 1, item.title)
        val subtitleText = item.subtitle(binding.root.context)
        binding.subtitle.text = subtitleText
        binding.subtitle.isVisible = !subtitleText.isNullOrBlank()
        binding.coverContainer.run { applyCover(item, cover, listBg1, listBg2, icon) }

        // Reset state on reuse
        binding.coverContainer.isPlaying.isVisible = false
        binding.title.setTextColor(ContextCompat.getColor(binding.root.context, R.color.audix_white))
        lastCurrent?.let { onCurrentChanged(it) }
    }

    override fun onCurrentChanged(current: PlayerState.Current?) {
        lastCurrent = current
        val itemId = feed?.item?.id
        val currTrack = current?.track
        val isThisTrack = itemId != null && (
            itemId == currTrack?.id || 
            itemId == current?.mediaItem?.mediaId ||
            (feed?.item is Track && (feed?.item as Track).title.equals(currTrack?.title, ignoreCase = true))
        )
        val isActivelyPlaying = isThisTrack && current?.isPlaying == true

        binding.coverContainer.isPlaying.isVisible = isThisTrack
        runCatching {
            val icon = binding.coverContainer.isPlaying.icon
            if (icon is Animatable) {
                if (isActivelyPlaying) icon.start() else icon.stop()
            }
        }
        if (isThisTrack) {
            runCatching {
                binding.title.setTextColor(ContextCompat.getColor(binding.root.context, R.color.audix_cyan_bright))
            }
        } else {
            runCatching {
                binding.title.setTextColor(ContextCompat.getColor(binding.root.context, R.color.audix_white))
            }
        }
    }
}
