package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.automirrored.filled.QueueMusic
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Theaters
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.download.DesktopDownloadManager
import dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager
import dev.brahmkshatriya.echo.desktop.ui.movie.MoviePlayRepository
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieSoundtrack
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

// =========================================================================
// MOVIE PLAY DEDICATED SCREEN & WORKSTATION
// =========================================================================

@Composable
fun MoviePlayScreen(
    playerViewModel: PlayerViewModel = koinInject(),
    libraryManager: DesktopLibraryManager? = null,
    downloadManager: DesktopDownloadManager? = null,
    settings: EchoSettings? = null,
    onLaunchScreensaver: () -> Unit = {}
) {
    val effectiveLibraryManager = remember {
        libraryManager ?: runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopLibraryManager>() }
            .getOrElse { DesktopLibraryManager.getInstance() }
    }
    val effectiveDownloadManager = remember {
        downloadManager ?: runCatching { org.koin.mp.KoinPlatformTools.defaultContext().get().get<DesktopDownloadManager>() }
            .getOrElse { DesktopDownloadManager.getInstance() }
    }

    val curatedMovies = remember { MoviePlayRepository.getCuratedMovies() }
    var selectedCategory by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }
    var selectedMovieForModal by remember { mutableStateOf<MovieSoundtrack?>(null) }
    var trackForPlaylist by remember { mutableStateOf<Track?>(null) }
    var toastMessage by remember { mutableStateOf<String?>(null) }

    var isSearchingOnline by remember { mutableStateOf(false) }
    var searchResults by remember { mutableStateOf<List<MovieSoundtrack>>(emptyList()) }
    val scope = rememberCoroutineScope()

    val categories = listOf("All", "Bollywood", "South Cinema", "Romantic Hits", "Action & Thriller", "Golden Classics", "Hollywood")

    // Dynamic search debounce
    LaunchedEffect(searchQuery) {
        val q = searchQuery.trim()
        if (q.length >= 2) {
            isSearchingOnline = true
            delay(350L)
            searchResults = MoviePlayRepository.searchOnlineMovieSoundtracks(q)
            isSearchingOnline = false
        } else {
            searchResults = emptyList()
            isSearchingOnline = false
        }
    }

    val displayMovies = remember(selectedCategory, searchQuery, searchResults) {
        if (searchQuery.trim().length >= 2 && searchResults.isNotEmpty()) {
            searchResults
        } else if (selectedCategory == "All") {
            curatedMovies
        } else {
            curatedMovies.filter { it.genre.equals(selectedCategory, ignoreCase = true) }
        }
    }

    // Hero Spotlight Movie (e.g. Animal or Jawan)
    val heroMovie = curatedMovies.firstOrNull()

    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 40.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            // ------------------------------------------------------------------------------------
            // 1. HEADER: Title & Cinema Spotlight
            // ------------------------------------------------------------------------------------
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color(0xFFF43F5E).copy(alpha = 0.15f))
                                    .border(1.dp, Color(0xFFF43F5E).copy(alpha = 0.40f), RoundedCornerShape(6.dp))
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = "CINEMA SOUNDTRACKS • FULL MOVIE JUKEBOX",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFF43F5E),
                                    letterSpacing = 0.5.sp
                                )
                            }
                        }
                        Text(
                            text = "Movie Play",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = (-0.5).sp
                            ),
                            color = Color.White
                        )
                        Text(
                            text = "Stream entire original motion picture soundtracks & cinema albums in continuous sequence.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }

                    // Screensaver button
                    LiquidGlassBox(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { onLaunchScreensaver() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Default.Theaters, contentDescription = null, tint = Color(0xFFF43F5E), modifier = Modifier.size(16.dp))
                            Text("Cinema Mode", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 2. HERO CINEMA SPOTLIGHT BANNER
            // ------------------------------------------------------------------------------------
            if (searchQuery.isBlank() && heroMovie != null) {
                item {
                    LiquidGlassBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(210.dp),
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.45f),
                        borderColor = Color(0xFFF43F5E).copy(alpha = 0.35f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(18.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(22.dp)
                        ) {
                            // Left Poster
                            Box(
                                modifier = Modifier
                                    .width(135.dp)
                                    .height(174.dp)
                                    .shadow(12.dp, RoundedCornerShape(14.dp), spotColor = heroMovie.accentColor)
                                    .clip(RoundedCornerShape(14.dp))
                                    .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(14.dp))
                            ) {
                                AsyncImage(
                                    model = heroMovie.posterUrl,
                                    contentDescription = heroMovie.title,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }

                            // Center Info
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(heroMovie.accentColor.copy(alpha = 0.20f))
                                            .border(1.dp, heroMovie.accentColor.copy(alpha = 0.60f), RoundedCornerShape(6.dp))
                                            .padding(horizontal = 8.dp, vertical = 2.dp)
                                    ) {
                                        Text(heroMovie.bannerBadge, color = heroMovie.accentColor, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                    }
                                    Text(
                                        text = "${heroMovie.year}  •  ${heroMovie.genre}  •  ${heroMovie.tracks.size} SONGS",
                                        color = Color.White.copy(alpha = 0.70f),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }

                                Text(
                                    text = heroMovie.title,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )

                                Text(
                                    text = "Star Cast: ${heroMovie.starCast}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF38BDF8),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Text(
                                    text = heroMovie.description,
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.85f),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    lineHeight = 16.sp
                                )

                                Spacer(Modifier.height(4.dp))

                                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    Button(
                                        onClick = {
                                            if (heroMovie.tracks.isNotEmpty()) {
                                                playerViewModel.playWithQueue(heroMovie.tracks.first(), heroMovie.tracks)
                                                toastMessage = "▶ Playing Movie: ${heroMovie.title} (${heroMovie.tracks.size} tracks queued)"
                                            }
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = heroMovie.accentColor),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("Play Movie Jukebox", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                    }

                                    Button(
                                        onClick = {
                                            selectedMovieForModal = heroMovie
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.12f)),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(Icons.Default.Theaters, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("View Tracklist", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 3. SEARCH & GENRE FILTER RAILS
            // ------------------------------------------------------------------------------------
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    // Search Bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        placeholder = { Text("Search any movie soundtrack, e.g. Animal, Aashiqui 2, Jawan, Rockstar, DDLJ...", fontSize = 13.sp) },
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFFF43F5E), modifier = Modifier.size(20.dp))
                        },
                        trailingIcon = {
                            if (isSearchingOnline) {
                                CircularProgressIndicator(color = Color(0xFFF43F5E), strokeWidth = 2.dp, modifier = Modifier.size(18.dp))
                            } else if (searchQuery.isNotBlank()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(18.dp))
                                }
                            }
                        },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color(0xFFF43F5E),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.18f),
                            focusedContainerColor = Color(0xFF0A0C10).copy(alpha = 0.40f),
                            unfocusedContainerColor = Color(0xFF0A0C10).copy(alpha = 0.30f)
                        )
                    )

                    // Category Filter Pills
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(horizontal = 2.dp)
                    ) {
                        items(categories, key = { it }) { cat ->
                            val isSelected = cat == selectedCategory
                            val count = when (cat) {
                                "All" -> curatedMovies.size
                                else -> curatedMovies.count { it.genre.equals(cat, ignoreCase = true) }
                            }

                            SeniorFilterPill(
                                title = "$cat ($count)",
                                isSelected = isSelected,
                                onClick = {
                                    selectedCategory = cat
                                    searchQuery = ""
                                }
                            )
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 4. MOVIE SOUNDTRACKS GRID
            // ------------------------------------------------------------------------------------
            item {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text(
                        text = if (searchQuery.isNotBlank()) "Search Results for \"$searchQuery\" (${displayMovies.size} Movies)" else "$selectedCategory Cinema Soundtracks (${displayMovies.size})",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color.White
                    )

                    // Responsive rows of movie cards
                    val chunkedMovies = displayMovies.chunked(4)
                    for (row in chunkedMovies) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            for (movie in row) {
                                Box(modifier = Modifier.weight(1f)) {
                                    MovieCinemaCard(
                                        movie = movie,
                                        onPlay = {
                                            if (movie.tracks.isNotEmpty()) {
                                                playerViewModel.playWithQueue(movie.tracks.first(), movie.tracks)
                                                toastMessage = "▶ Playing Movie: ${movie.title} (${movie.tracks.size} tracks queued)"
                                            }
                                        },
                                        onSelect = {
                                            selectedMovieForModal = movie
                                        }
                                    )
                                }
                            }
                            // Fill remaining spaces in row
                            val remaining = 4 - row.size
                            if (remaining > 0) {
                                for (i in 0 until remaining) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }
        }

        // Toast feedback overlay
        toastMessage?.let { msg ->
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0F172A).copy(alpha = 0.95f))
                    .border(1.dp, Color(0xFFF43F5E), RoundedCornerShape(12.dp))
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .zIndex(100f)
            ) {
                Text(text = msg, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
            }
            LaunchedEffect(msg) {
                delay(3000L)
                toastMessage = null
            }
        }

        // Movie Detail Modal
        selectedMovieForModal?.let { movie ->
            SeniorMovieDetailModal(
                movie = movie,
                onDismiss = { selectedMovieForModal = null },
                onPlayAll = {
                    if (movie.tracks.isNotEmpty()) {
                        playerViewModel.playWithQueue(movie.tracks.first(), movie.tracks)
                        toastMessage = "▶ Playing Movie: ${movie.title} (${movie.tracks.size} tracks queued)"
                        selectedMovieForModal = null
                    }
                },
                onShufflePlay = {
                    if (movie.tracks.isNotEmpty()) {
                        val shuffled = movie.tracks.shuffled()
                        playerViewModel.playWithQueue(shuffled.first(), shuffled)
                        toastMessage = "🔀 Shuffled Movie: ${movie.title} (${movie.tracks.size} tracks queued)"
                        selectedMovieForModal = null
                    }
                },
                onPlayTrack = { trk ->
                    val idx = movie.tracks.indexOfFirst { it.id == trk.id }
                    val q = if (idx >= 0) movie.tracks.drop(idx) + movie.tracks.take(idx) else listOf(trk)
                    playerViewModel.playWithQueue(trk, q)
                    selectedMovieForModal = null
                },
                onAddToPlaylist = { trk ->
                    trackForPlaylist = trk
                },
                onDownloadTrack = { trk ->
                    effectiveDownloadManager.downloadTrack(trk)
                    toastMessage = "⬇ Downloading: ${trk.title}"
                }
            )
        }

        // Add to playlist modal dialog
        trackForPlaylist?.let { track ->
            AddToPlaylistDialog(
                track = track,
                libraryManager = effectiveLibraryManager,
                onDismiss = { trackForPlaylist = null }
            )
        }
    }
}

// =========================================================================
// EMBEDDABLE MOVIE PLAY SECTION (FOR HOME SCREEN ABOVE PLAYLISTS)
// =========================================================================

@Composable
fun SeniorMoviePlaySection(
    onPlayMovie: (MovieSoundtrack) -> Unit,
    onSelectMovie: (MovieSoundtrack) -> Unit
) {
    val curatedMovies = remember { MoviePlayRepository.getCuratedMovies() }
    var selectedCategory by remember { mutableStateOf("All") }

    val categories = listOf("All", "Bollywood", "South Cinema", "Romantic Hits", "Action & Thriller", "Golden Classics")

    val filteredMovies = remember(selectedCategory) {
        if (selectedCategory == "All") curatedMovies
        else curatedMovies.filter { it.genre.equals(selectedCategory, ignoreCase = true) }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Section Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFFF43F5E).copy(alpha = 0.15f))
                            .border(1.dp, Color(0xFFF43F5E).copy(alpha = 0.40f), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "CINEMA SOUNDTRACKS • CONTINUOUS MOVIE JUKEBOX",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF43F5E),
                            letterSpacing = 0.5.sp
                        )
                    }
                }
                Text(
                    text = "Movie Play",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = (-0.5).sp
                    ),
                    color = Color.White
                )
                Text(
                    text = "Complete blockbuster film albums & cinema jukeboxes in continuous playback sequence.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF0A0C10).copy(alpha = 0.30f))
                    .border(1.dp, Color.White.copy(alpha = 0.15f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(Icons.Default.LocalMovies, contentDescription = null, tint = Color(0xFFF43F5E), modifier = Modifier.size(15.dp))
                    Text("${curatedMovies.size} Movies Curated", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                }
            }
        }

        // Category Filter Rail
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ) {
            items(categories, key = { it }) { cat ->
                val isSelected = cat == selectedCategory
                val count = when (cat) {
                    "All" -> curatedMovies.size
                    else -> curatedMovies.count { it.genre.equals(cat, ignoreCase = true) }
                }

                SeniorFilterPill(
                    title = "$cat ($count)",
                    isSelected = isSelected,
                    onClick = { selectedCategory = cat }
                )
            }
        }

        // Horizontal Row of Movie Cards
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ) {
            items(filteredMovies, key = { it.id }) { movie ->
                MovieCinemaCard(
                    movie = movie,
                    onPlay = { onPlayMovie(movie) },
                    onSelect = { onSelectMovie(movie) },
                    modifier = Modifier.width(220.dp)
                )
            }
        }
    }
}

// =========================================================================
// MOVIE CINEMA CARD COMPONENT
// =========================================================================

@Composable
fun MovieCinemaCard(
    movie: MovieSoundtrack,
    onPlay: () -> Unit,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val cardScale by animateFloatAsState(
        targetValue = if (isHovered) 1.025f else 1.0f,
        animationSpec = spring(stiffness = Spring.StiffnessMedium)
    )

    LiquidGlassBox(
        modifier = modifier
            .scale(cardScale)
            .clip(RoundedCornerShape(18.dp))
            .clickable(interactionSource = interactionSource, indication = null) {
                onSelect()
            },
        shape = RoundedCornerShape(18.dp),
        backgroundColor = Color(0xFF0A0C10).copy(alpha = if (isHovered) 0.50f else 0.35f),
        borderColor = if (isHovered) movie.accentColor.copy(alpha = 0.60f) else Color.White.copy(alpha = 0.12f)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            // Poster Cover
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                AsyncImage(
                    model = movie.posterUrl,
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Dark gradient scrim
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.25f),
                                    Color.Transparent,
                                    Color.Black.copy(alpha = 0.85f)
                                )
                            )
                        )
                )

                // Top badge tag
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.Black.copy(alpha = 0.70f))
                        .border(1.dp, movie.accentColor.copy(alpha = 0.60f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 7.dp, vertical = 2.5.dp)
                ) {
                    Text(
                        text = movie.bannerBadge,
                        fontSize = 8.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = movie.accentColor,
                        letterSpacing = 0.5.sp
                    )
                }

                // Bottom-left track count pill
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.Black.copy(alpha = 0.75f))
                        .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 7.dp, vertical = 2.5.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.QueueMusic,
                            contentDescription = null,
                            tint = movie.accentColor,
                            modifier = Modifier.size(11.dp)
                        )
                        Text(
                            text = "${movie.tracks.size} TRACKS",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                // Bottom-right glowing play button
                val playButtonScale by animateFloatAsState(
                    targetValue = if (isHovered) 1.10f else 1.0f,
                    animationSpec = spring(stiffness = Spring.StiffnessMedium)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .scale(playButtonScale)
                        .size(40.dp)
                        .shadow(8.dp, CircleShape, spotColor = movie.accentColor)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                listOf(movie.accentColor, movie.accentColor.copy(alpha = 0.75f))
                            )
                        )
                        .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                            onPlay()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play Movie Jukebox",
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            // Movie Title & Year
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = movie.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = movie.year,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White.copy(alpha = 0.60f)
                )
            }

            Spacer(Modifier.height(3.dp))

            // Star Cast
            Text(
                text = movie.starCast,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF38BDF8),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(4.dp))

            // Director & Composer
            Text(
                text = movie.directorOrComposer,
                fontSize = 10.5.sp,
                color = Color.White.copy(alpha = 0.70f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

// =========================================================================
// SENIOR MOVIE DETAIL MODAL DIALOG
// =========================================================================

@Composable
fun SeniorMovieDetailModal(
    movie: MovieSoundtrack,
    onDismiss: () -> Unit,
    onPlayAll: () -> Unit,
    onShufflePlay: () -> Unit,
    onPlayTrack: (Track) -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    val totalSeconds = remember(movie.tracks) {
        movie.tracks.sumOf { it.duration ?: 0L } / 1000
    }
    val totalMinutes = totalSeconds / 60
    val totalSecRemainder = totalSeconds % 60

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.80f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                onDismiss()
            }
            .zIndex(90f),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(780.dp)
                .heightIn(max = 690.dp)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                    // Prevent dismiss when clicking inside
                }
        ) {
            LiquidGlassBox(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(24.dp),
                backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.75f),
                borderColor = Color.White.copy(alpha = 0.25f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // --------------------------------------------------------------------------------
                    // MODAL HEADER: Movie Poster + Details + Action Controls
                    // --------------------------------------------------------------------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Poster Artwork
                        Box(
                            modifier = Modifier
                                .size(148.dp)
                                .shadow(12.dp, RoundedCornerShape(16.dp), spotColor = movie.accentColor)
                                .clip(RoundedCornerShape(16.dp))
                                .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(16.dp))
                        ) {
                            AsyncImage(
                                model = movie.posterUrl,
                                contentDescription = movie.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        // Meta details
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(movie.accentColor.copy(alpha = 0.20f))
                                        .border(1.dp, movie.accentColor.copy(alpha = 0.60f), RoundedCornerShape(6.dp))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Text(movie.bannerBadge, color = movie.accentColor, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    text = "${movie.year}  •  ${movie.genre}",
                                    color = Color.White.copy(alpha = 0.70f),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }

                            Text(
                                text = movie.title,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )

                            Text(
                                text = "Star Cast: ${movie.starCast}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF38BDF8)
                            )

                            Text(
                                text = movie.directorOrComposer,
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.75f)
                            )

                            Text(
                                text = "${movie.tracks.size} Songs  •  Total Runtime: ${totalMinutes}m ${totalSecRemainder}s",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White.copy(alpha = 0.60f)
                            )
                        }

                        // Close button
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    // --------------------------------------------------------------------------------
                    // ACTION BUTTONS: Play Full Movie Jukebox + Shuffle
                    // --------------------------------------------------------------------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = onPlayAll,
                            colors = ButtonDefaults.buttonColors(containerColor = movie.accentColor),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.weight(1f).height(44.dp)
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White)
                            Spacer(Modifier.width(8.dp))
                            Text("Play Full Movie Jukebox", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }

                        Button(
                            onClick = onShufflePlay,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.12f)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.weight(1f).height(44.dp)
                        ) {
                            Icon(Icons.Default.Shuffle, contentDescription = null, tint = Color.White)
                            Spacer(Modifier.width(8.dp))
                            Text("Shuffle Soundtrack", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                        }
                    }

                    // --------------------------------------------------------------------------------
                    // TRACKLIST TABLE
                    // --------------------------------------------------------------------------------
                    Text(
                        text = "ORIGINAL MOTION PICTURE TRACKLIST",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White.copy(alpha = 0.70f),
                        letterSpacing = 0.8.sp
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(movie.tracks.size) { idx ->
                            val track = movie.tracks[idx]
                            val trackDurationSec = (track.duration ?: 0L) / 1000
                            val trackMin = trackDurationSec / 60
                            val trackSec = trackDurationSec % 60
                            val durFormatted = String.format("%d:%02d", trackMin, trackSec)

                            val trkInteraction = remember { MutableInteractionSource() }
                            val trkHovered by trkInteraction.collectIsHoveredAsState()

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(if (trkHovered) Color.White.copy(alpha = 0.10f) else Color.Transparent)
                                    .clickable(interactionSource = trkInteraction, indication = null) {
                                        onPlayTrack(track)
                                    }
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                // Track Number or Play Icon on hover
                                Box(
                                    modifier = Modifier.size(24.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (trkHovered) {
                                        Icon(
                                            imageVector = Icons.Default.PlayArrow,
                                            contentDescription = "Play",
                                            tint = movie.accentColor,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    } else {
                                        Text(
                                            text = "${idx + 1}",
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = Color.White.copy(alpha = 0.60f)
                                        )
                                    }
                                }

                                // Track Title & Artists
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = track.title,
                                        fontSize = 13.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (trkHovered) movie.accentColor else Color.White,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = track.artists.joinToString { it.name },
                                        fontSize = 11.sp,
                                        color = Color.White.copy(alpha = 0.65f),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                                // Duration
                                Text(
                                    text = durFormatted,
                                    fontSize = 11.5.sp,
                                    color = Color.White.copy(alpha = 0.70f)
                                )

                                // Add to playlist action
                                IconButton(
                                    onClick = { onAddToPlaylist(track) },
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.PlaylistAdd,
                                        contentDescription = "Add to Playlist",
                                        tint = Color.White.copy(alpha = 0.75f),
                                        modifier = Modifier.size(16.dp)
                                    )
                                }

                                // Download action
                                IconButton(
                                    onClick = { onDownloadTrack(track) },
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Download,
                                        contentDescription = "Download Track",
                                        tint = Color.White.copy(alpha = 0.75f),
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
