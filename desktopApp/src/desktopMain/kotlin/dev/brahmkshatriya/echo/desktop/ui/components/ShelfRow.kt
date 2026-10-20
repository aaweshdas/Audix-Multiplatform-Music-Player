package dev.brahmkshatriya.echo.desktop.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.Shelf
import dev.brahmkshatriya.echo.common.models.Track

@Composable
fun ShelfRow(
    shelf: Shelf,
    onMediaClick: (EchoMediaItem) -> Unit,
    onPlayTrack: (Track) -> Unit,
    onMoreClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        // Shelf Header: Title, Subtitle, and Optional "More" action button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f, fill = false)
            ) {
                Text(
                    text = shelf.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                if (shelf is Shelf.Lists<*> && !shelf.subtitle.isNullOrBlank()) {
                    Text(
                        text = shelf.subtitle.orEmpty(),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.70f)
                    )
                }
            }

            if (onMoreClick != null) {
                TextButton(
                    onClick = onMoreClick,
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.White.copy(alpha = 0.85f))
                ) {
                    Text(
                        text = "More",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }
            }
        }

        // Shelf Content: Items, Tracks, or Single Item
        when (shelf) {
            is Shelf.Lists.Items -> {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(shelf.list) { item ->
                        MediaCard(
                            media = item,
                            onClick = { onMediaClick(item) },
                            onPlayClick = if (item is Track) { { onPlayTrack(item) } } else null
                        )
                    }
                }
            }
            is Shelf.Lists.Tracks -> {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(shelf.list) { track ->
                        MediaCard(
                            media = track,
                            onClick = { onMediaClick(track) },
                            onPlayClick = { onPlayTrack(track) }
                        )
                    }
                }
            }
            is Shelf.Item -> {
                MediaCard(
                    media = shelf.media,
                    onClick = { onMediaClick(shelf.media) },
                    onPlayClick = if (shelf.media is Track) { { onPlayTrack(shelf.media as Track) } } else null,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            }
            else -> {}
        }
    }
}
