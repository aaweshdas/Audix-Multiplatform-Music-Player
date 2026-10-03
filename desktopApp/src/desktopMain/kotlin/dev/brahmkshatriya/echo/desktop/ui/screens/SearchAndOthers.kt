package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.DownloadDone
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.filled.QueueMusic
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.ui.graphics.Brush
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist
import dev.brahmkshatriya.echo.desktop.library.toTrack
import dev.brahmkshatriya.echo.desktop.ui.components.AddToPlaylistDialog
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.desktop.download.DownloadTask
import dev.brahmkshatriya.echo.desktop.download.DownloadedTrack
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRow
import dev.brahmkshatriya.echo.desktop.viewmodel.DownloadsViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.LibraryViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.SearchViewModel
import dev.brahmkshatriya.echo.desktop.viewmodel.SettingsViewModel
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinInject(),
    playerViewModel: PlayerViewModel = koinInject(),
    onMediaSelected: (EchoMediaItem) -> Unit = {}
) {
    val query by viewModel.query.collectAsState()
    val quickResults by viewModel.quickResults.collectAsState()
    val searchFeed by viewModel.searchFeed.collectAsState()
    val shelves by viewModel.shelves.collectAsState()
    val selectedTab by viewModel.selectedTab.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val recommendedTracks by viewModel.recommendedTracks.collectAsState()
    val recentSearches by viewModel.recentSearches.collectAsState()
    val selectedSourceId by viewModel.selectedSourceId.collectAsState()
    val availableExtensions by viewModel.availableExtensions.collectAsState()

    var expanded by remember { mutableStateOf(false) }
    var trackForPlaylist by remember { mutableStateOf<Track?>(null) }

    trackForPlaylist?.let { track ->
        AddToPlaylistDialog(
            track = track,
            onDismiss = { trackForPlaylist = null }
        )
    }

    Column(Modifier.fillMaxSize()) {
        // Search bar
        Box(Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 16.dp)) {
            DockedSearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = query,
                        onQueryChange = { viewModel.updateQuery(it) },
                        onSearch = {
                            expanded = false
                            viewModel.search(it)
                        },
                        expanded = expanded,
                        onExpandedChange = { expanded = it },
                        placeholder = { Text("Search songs, artists, albums, playlists...") },
                        leadingIcon = { Icon(Icons.Default.Search, null) },
                        trailingIcon = if (query.isNotBlank()) {
                            {
                                IconButton(onClick = { viewModel.clearSearch(); expanded = false }) {
                                    Icon(Icons.Default.Close, "Clear")
                                }
                            }
                        } else null
                    )
                },
                expanded = expanded,
                onExpandedChange = { expanded = it },
                modifier = Modifier.fillMaxWidth()
            ) {
                // Quick search suggestions
                LazyColumn {
                    items(quickResults, key = { it.title }) { item ->
                        ListItem(
                            headlineContent = { Text(item.title) },
                            modifier = Modifier.clickable {
                                viewModel.search(item.title)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        // Source Filter Chips (All Sources, YouTube Music, JioSaavn, SoundCloud, Radio Browser, Local Files)
        val sourceOptions = remember(availableExtensions) {
            val enabledExts = availableExtensions.filter { it.isEnabled }
            if (enabledExts.isNotEmpty()) {
                listOf("all" to "All Sources") + enabledExts.map { it.id to it.metadata.name }
            } else {
                listOf(
                    "all" to "All Sources",
                    "Youtube_music" to "YouTube Music",
                    "saavn_music" to "JioSaavn",
                    "soundcloud" to "SoundCloud",
                    "radio_browser" to "Radio Browser",
                    "echo-offline" to "Local Files"
                )
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sourceOptions) { (id, name) ->
                FilterChip(
                    selected = selectedSourceId == id,
                    onClick = { viewModel.setSourceFilter(id) },
                    label = { Text(name) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }

        // Tabs if search feed has multiple categories
        val tabs = searchFeed?.tabs
        if (!tabs.isNullOrEmpty()) {
            val selectedIndex = tabs.indexOfFirst { it == selectedTab }.coerceAtLeast(0)
            ScrollableTabRow(
                selectedTabIndex = selectedIndex,
                modifier = Modifier.fillMaxWidth(),
                edgePadding = 24.dp
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = index == selectedIndex,
                        onClick = { viewModel.selectTab(tab) },
                        text = { Text(tab.title) }
                    )
                }
            }
        }

        Box(Modifier.fillMaxSize()) {
            when {
                isLoading && shelves.isEmpty() -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
                error != null && shelves.isEmpty() -> {
                    ErrorView(
                        error = error,
                        onRetry = { viewModel.search(query) },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                shelves.isNotEmpty() -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 12.dp)
                    ) {
                        items(shelves) { shelf ->
                            ShelfRow(
                                shelf = shelf,
                                onMediaSelected = onMediaSelected,
                                onAddToPlaylist = { track -> trackForPlaylist = track }
                            )
                        }
                    }
                }
                query.isBlank() -> {
                    Column(
                        Modifier.fillMaxSize().padding(24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            "Search for songs, artists, albums, and playlists",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LibraryScreen(
    viewModel: LibraryViewModel = koinInject()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.LibraryMusic,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "Your Library",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "Saved tracks, playlists, and followed artists will appear here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun DownloadsScreen(
    viewModel: DownloadsViewModel = koinInject()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.Download,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "Downloads",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "Downloaded tracks and offline media will appear here.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = koinInject()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.Settings,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "Settings",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(8.dp))
        Text(
            "Audio playback, equalizer, themes, and extension preferences.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ErrorView(
    error: Throwable?,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            Icons.Default.Close,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(48.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = error?.localizedMessage ?: "An error occurred",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}
