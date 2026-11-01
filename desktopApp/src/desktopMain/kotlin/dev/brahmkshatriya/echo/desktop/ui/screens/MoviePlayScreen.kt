package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.derivedStateOf
import dev.brahmkshatriya.echo.desktop.ui.LocalAppBlurredBackground
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.filled.PlaylistAdd
import androidx.compose.material.icons.automirrored.filled.QueueMusic
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.SortByAlpha
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieSortOrder
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Theaters
import androidx.compose.material.icons.filled.Tv
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
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
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
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieBoxCollection
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieBoxItem
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieBoxLiveChannel
import dev.brahmkshatriya.echo.desktop.ui.movie.MoviePlayRepository
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieSoundtrack
import dev.brahmkshatriya.echo.desktop.ui.movie.MovieStreamOption
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

// =========================================================================
// MOVIE PLAY CINEMA STUDIO (POWERED BY MOVIEBOX REVERSE ENGINEER CORE)
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

    val allMovies = remember { MoviePlayRepository.getAllMovies() }
    val franchiseCollections = remember { MoviePlayRepository.getFranchiseCollections() }
    val liveChannels = remember { MoviePlayRepository.getLiveTvChannels() }

    var selectedTab by remember { mutableStateOf("All") }
    var selectedVibe by remember { mutableStateOf("All") }
    var selectedFranchise by remember { mutableStateOf<MovieBoxCollection?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedLetter by remember { mutableStateOf("All") }
    var sortOrder by remember { mutableStateOf(MovieSortOrder.NAME_ASC) }
    var groupByLetter by remember { mutableStateOf(true) }

    val alphabetList = remember {
        listOf("All", "#") + ('A'..'Z').map { it.toString() }
    }

    var selectedMovieForModal by remember { mutableStateOf<MovieBoxItem?>(null) }
    var selectedChannelForModal by remember { mutableStateOf<MovieBoxLiveChannel?>(null) }
    var trackForPlaylist by remember { mutableStateOf<Track?>(null) }
    var toastMessage by remember { mutableStateOf<String?>(null) }

    var isServerOnline by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // Ensure server is started and check status
    LaunchedEffect(Unit) {
        MoviePlayRepository.ensureServerRunning()
        delay(1000)
        isServerOnline = MoviePlayRepository.isMovieBoxServerOnline()
    }

    val tabs = listOf("All", "Movies", "TV Shows", "4K Ultra HD", "Franchises", "Live TV")
    val vibes = listOf("All", "🔥 Adrenaline", "🧠 Sci-Fi", "❤️ Romance", "🌑 Dark Thrillers", "😂 Comedy", "🌸 Anime", "👻 Horror")

    // Base filtering based on search, tab, vibe, franchise
    val baseFilteredMovies = remember(selectedTab, selectedVibe, selectedFranchise, searchQuery, allMovies) {
        val q = searchQuery.trim()
        var list = if (q.isNotBlank()) {
            allMovies.filter { m ->
                m.title.contains(q, ignoreCase = true) ||
                m.genre.contains(q, ignoreCase = true) ||
                m.year.contains(q, ignoreCase = true) ||
                m.description.contains(q, ignoreCase = true)
            }
        } else {
            when (selectedTab) {
                "Movies" -> allMovies.filter { it.type == "movie" }
                "TV Shows" -> allMovies.filter { it.type == "series" }
                "4K Ultra HD" -> allMovies.filter {
                    it.qualityBadge.contains("4k", ignoreCase = true) ||
                    it.qualityBadge.contains("uhd", ignoreCase = true) ||
                    it.genre.contains("Action", true)
                }
                "Franchises" -> {
                    val activeFranchise = selectedFranchise
                    if (activeFranchise != null) {
                        allMovies.filter { m ->
                            activeFranchise.keywords.any { kw -> m.title.contains(kw, ignoreCase = true) }
                        }
                    } else {
                        allMovies
                    }
                }
                else -> allMovies
            }
        }

        if (selectedVibe != "All" && q.isBlank()) {
            val vibeKeyword = when (selectedVibe) {
                "🔥 Adrenaline" -> "Action"
                "🧠 Sci-Fi" -> "Sci-Fi"
                "❤️ Romance" -> "Romance"
                "🌑 Dark Thrillers" -> "Thriller"
                "😂 Comedy" -> "Comedy"
                "🌸 Anime" -> "Animation"
                "👻 Horror" -> "Horror"
                else -> ""
            }
            if (vibeKeyword.isNotBlank()) {
                list = list.filter { it.genre.contains(vibeKeyword, ignoreCase = true) }
            }
        }

        list
    }

    // Precalculate letter counts for A-Z ribbon
    val letterCounts = remember(baseFilteredMovies) {
        val counts = mutableMapOf<String, Int>()
        counts["All"] = baseFilteredMovies.size
        for (c in 'A'..'Z') {
            val s = c.toString()
            counts[s] = baseFilteredMovies.count { m ->
                val clean = m.title.trim()
                val withoutArticle = clean.removePrefix("The ").removePrefix("A ").removePrefix("An ").trim()
                clean.startsWith(s, ignoreCase = true) || withoutArticle.startsWith(s, ignoreCase = true)
            }
        }
        counts["#"] = baseFilteredMovies.count { m ->
            val firstChar = m.title.trim().firstOrNull()?.uppercaseChar() ?: '#'
            firstChar !in 'A'..'Z'
        }
        counts
    }

    // Filter by selected letter & sort by selected sort order (Defaults to Alphabetical Name A-Z)
    val displayMovies = remember(baseFilteredMovies, selectedLetter, sortOrder) {
        val letterFiltered = if (selectedLetter == "All") {
            baseFilteredMovies
        } else if (selectedLetter == "#") {
            baseFilteredMovies.filter { m ->
                val firstChar = m.title.trim().firstOrNull()?.uppercaseChar() ?: '#'
                firstChar !in 'A'..'Z'
            }
        } else {
            baseFilteredMovies.filter { m ->
                val clean = m.title.trim()
                val withoutArticle = clean.removePrefix("The ").removePrefix("A ").removePrefix("An ").trim()
                clean.startsWith(selectedLetter, ignoreCase = true) || withoutArticle.startsWith(selectedLetter, ignoreCase = true)
            }
        }

        when (sortOrder) {
            MovieSortOrder.NAME_ASC -> letterFiltered.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.title.trim() })
            MovieSortOrder.NAME_DESC -> letterFiltered.sortedWith(compareByDescending(String.CASE_INSENSITIVE_ORDER) { it.title.trim() })
            MovieSortOrder.RATING_DESC -> letterFiltered.sortedByDescending { it.rating.toDoubleOrNull() ?: 0.0 }
            MovieSortOrder.YEAR_DESC -> letterFiltered.sortedByDescending { it.year.toIntOrNull() ?: 0 }
            MovieSortOrder.YEAR_ASC -> letterFiltered.sortedBy { it.year.toIntOrNull() ?: 9999 }
        }
    }

    // Grouping by starting letter for organized A-Z view
    val groupedSections = remember(displayMovies, groupByLetter, selectedLetter, sortOrder, searchQuery) {
        if (groupByLetter && selectedLetter == "All" && sortOrder == MovieSortOrder.NAME_ASC && searchQuery.isBlank()) {
            displayMovies.groupBy { movie ->
                val firstChar = movie.title.trim().firstOrNull()?.uppercaseChar() ?: '#'
                if (firstChar in 'A'..'Z') firstChar.toString() else "#"
            }.toSortedMap { a, b ->
                if (a == "#") -1 else if (b == "#") 1 else a.compareTo(b)
            }
        } else {
            null
        }
    }

    // Hero Spotlight Movie (top blockbuster e.g. Deadpool & Wolverine or Dune 2)
    val heroMovie = remember(displayMovies) { displayMovies.firstOrNull() ?: allMovies.firstOrNull() }

    val listState = rememberLazyListState()
    val showScrollToTop by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 1 }
    }
    val franchiseListState = rememberLazyListState()

    BoxWithConstraints(Modifier.fillMaxSize()) {
        val screenWidth = maxWidth
        val columns = when {
            screenWidth >= 1650.dp -> 6
            screenWidth >= 1350.dp -> 5
            screenWidth >= 1050.dp -> 4
            screenWidth >= 720.dp -> 3
            else -> 2
        }
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 24.dp, top = 20.dp, end = 24.dp, bottom = 48.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // ------------------------------------------------------------------------------------
            // 1. HEADER: Title & Cinema Studio Status
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
                            LiquidGlassBox(
                                shape = RoundedCornerShape(6.dp),
                                borderColor = Color(0xFFE11D48).copy(alpha = 0.40f)
                            ) {
                                Text(
                                    text = "MOVIEBOX CORE • 1,534+ CINEMA & SERIES TITLES",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFE11D48),
                                    letterSpacing = 0.5.sp,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }

                            // Live server status pill
                            LiquidGlassBox(
                                shape = RoundedCornerShape(6.dp),
                                borderColor = if (isServerOnline) Color(0xFF10B981).copy(alpha = 0.40f) else Color(0xFF38BDF8).copy(alpha = 0.40f)
                            ) {
                                Text(
                                    text = if (isServerOnline) "● Server 3000 Online" else "● Local Master Cache",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isServerOnline) Color(0xFF10B981) else Color(0xFF38BDF8),
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Text(
                            text = "Movie Play Cinema Studio",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                fontWeight = FontWeight.ExtraBold,
                                letterSpacing = (-0.5).sp
                            ),
                            color = Color.White
                        )
                        Text(
                            text = "Direct high-speed cinema streams, franchise universes, 4K releases, live TV & continuous soundtrack jukeboxes.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }

                    // Action buttons (Open Web Studio / Cinema Screensaver)
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { MoviePlayRepository.openInBrowser("http://127.0.0.1:3000") }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(15.dp))
                                Text("Web Studio", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                            }
                        }

                        LiquidGlassBox(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { onLaunchScreensaver() }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(Icons.Default.Theaters, contentDescription = null, tint = Color(0xFFE11D48), modifier = Modifier.size(15.dp))
                                Text("Cinema Mode", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                            }
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 2. HERO CINEMA SPOTLIGHT BANNER
            // ------------------------------------------------------------------------------------
            if (searchQuery.isBlank() && heroMovie != null && selectedTab != "Live TV") {
                item {
                    LiquidGlassBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        shape = RoundedCornerShape(20.dp),
                        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.45f),
                        borderColor = Color(0xFFE11D48).copy(alpha = 0.35f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(18.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(22.dp)
                        ) {
                            // Poster
                            Box(
                                modifier = Modifier
                                    .width(135.dp)
                                    .height(180.dp)
                                    .shadow(12.dp, RoundedCornerShape(14.dp), spotColor = Color(0xFFE11D48))
                                    .clip(RoundedCornerShape(14.dp))
                                    .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(14.dp))
                            ) {
                                AsyncImage(
                                    model = heroMovie.coverUrl.ifBlank { heroMovie.bannerUrl },
                                    contentDescription = heroMovie.title,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }

                            // Details
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(6.dp),
                                        borderColor = Color(0xFFE11D48).copy(alpha = 0.60f)
                                    ) {
                                        Text(heroMovie.qualityBadge.ifBlank { "4K UHD" }, color = Color(0xFFE11D48), fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp))
                                    }

                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFBBF24), modifier = Modifier.size(13.dp))
                                        Text("${heroMovie.rating} IMDB", color = Color(0xFFFBBF24), fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                                    }

                                    Text(
                                        text = "•  ${heroMovie.year}  •  ${heroMovie.duration.ifBlank { "2h" }}  •  ${heroMovie.genre}",
                                        color = Color.White.copy(alpha = 0.70f),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }

                                Text(
                                    text = heroMovie.title,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White,
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
                                    // Watch Stream
                                    Button(
                                        onClick = {
                                            scope.launch {
                                                MoviePlayRepository.playMovieDirect(heroMovie) { toastMessage = it }
                                            }
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("Stream Movie", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                    }

                                    // Trailer
                                    Button(
                                        onClick = {
                                            val tUrl = MoviePlayRepository.getTrailerUrl(heroMovie.title)
                                            MoviePlayRepository.openInBrowser(tUrl)
                                            toastMessage = "🎬 Opening Official Trailer for ${heroMovie.title}..."
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.12f)),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(Icons.Default.Theaters, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("Trailer", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                                    }

                                    // Jukebox
                                    Button(
                                        onClick = {
                                            scope.launch {
                                                toastMessage = "🎵 Finding Original Soundtrack for ${heroMovie.title}..."
                                                val tracks = MoviePlayRepository.resolveSoundtrackForMovie(heroMovie.title)
                                                if (tracks.isNotEmpty()) {
                                                    playerViewModel.playWithQueue(tracks.first(), tracks)
                                                    toastMessage = "▶ Playing Soundtrack: ${heroMovie.title} (${tracks.size} tracks queued)"
                                                } else {
                                                    toastMessage = "⚠ No audio album found for ${heroMovie.title}"
                                                }
                                            }
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.12f)),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(Icons.AutoMirrored.Filled.QueueMusic, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(16.dp))
                                        Spacer(Modifier.width(6.dp))
                                        Text("Soundtrack Jukebox", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 3. NAVIGATION TABS & VIBE DISCOVERY RAILS
            // ------------------------------------------------------------------------------------
            item {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    // Search Bar
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                            if (it.isNotBlank()) selectedLetter = "All"
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        placeholder = { Text("Search 1,534+ movies & shows by name, e.g. Avengers, Deadpool, Dune, Oppenheimer, Batman...", fontSize = 13.sp) },
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFFE11D48), modifier = Modifier.size(20.dp))
                        },
                        trailingIcon = {
                            if (searchQuery.isNotBlank()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White, modifier = Modifier.size(18.dp))
                                }
                            }
                        },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color(0xFFE11D48),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.18f),
                            focusedContainerColor = Color(0xFF0A0C10).copy(alpha = 0.40f),
                            unfocusedContainerColor = Color(0xFF0A0C10).copy(alpha = 0.30f)
                        )
                    )

                    // Primary Navigation Tabs
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(tabs, key = { it }) { tab ->
                            val isSelected = tab == selectedTab
                            val count = when (tab) {
                                "All" -> allMovies.size
                                "Movies" -> allMovies.count { it.type == "movie" }
                                "TV Shows" -> allMovies.count { it.type == "series" }
                                "4K Ultra HD" -> allMovies.count { it.qualityBadge.contains("4k", true) || it.genre.contains("Action", true) }
                                "Franchises" -> franchiseCollections.size
                                "Live TV" -> liveChannels.size
                                else -> 0
                            }

                            SeniorFilterPill(
                                title = "$tab ($count)",
                                isSelected = isSelected,
                                onClick = {
                                    selectedTab = tab
                                    searchQuery = ""
                                    selectedLetter = "All"
                                }
                            )
                        }
                    }

                    // A-Z Alphabetical Index Filter Ribbon (when not in Live TV)
                    if (selectedTab != "Live TV") {
                        AlphabeticalRibbon(
                            letters = alphabetList,
                            selectedLetter = selectedLetter,
                            letterCounts = letterCounts,
                            onLetterSelected = {
                                selectedLetter = it
                                if (it != "All") searchQuery = ""
                            }
                        )
                    }

                    // Vibe discovery pills (when not in Live TV)
                    if (selectedTab != "Live TV") {
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(vibes, key = { it }) { vibe ->
                                val isSelected = vibe == selectedVibe
                                MovieVibePill(
                                    title = vibe,
                                    isSelected = isSelected,
                                    onClick = { selectedVibe = vibe }
                                )
                            }
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 4. FRANCHISE UNIVERSES ROW (When in All or Franchises tab)
            // ------------------------------------------------------------------------------------
            if ((selectedTab == "All" || selectedTab == "Franchises") && searchQuery.isBlank()) {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Franchise Universes & Studios (${franchiseCollections.size})",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = Color.White
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                if (selectedFranchise != null) {
                                    Text(
                                        text = "Clear filter",
                                        fontSize = 11.5.sp,
                                        color = Color(0xFF38BDF8),
                                        modifier = Modifier.clickable { selectedFranchise = null }
                                    )
                                    Spacer(Modifier.width(4.dp))
                                }
                                // Carousel scroll buttons
                                LiquidGlassBox(
                                    shape = CircleShape,
                                    modifier = Modifier.size(28.dp).pointerHoverIcon(PointerIcon.Hand),
                                    onClick = {
                                        scope.launch {
                                            val current = franchiseListState.firstVisibleItemIndex
                                            franchiseListState.animateScrollToItem((current - 3).coerceAtLeast(0))
                                        }
                                    }
                                ) {
                                    Icon(Icons.Default.ChevronLeft, contentDescription = "Scroll Left", tint = Color.White, modifier = Modifier.size(16.dp))
                                }
                                LiquidGlassBox(
                                    shape = CircleShape,
                                    modifier = Modifier.size(28.dp).pointerHoverIcon(PointerIcon.Hand),
                                    onClick = {
                                        scope.launch {
                                            val current = franchiseListState.firstVisibleItemIndex
                                            franchiseListState.animateScrollToItem((current + 3).coerceAtMost(franchiseCollections.size - 1))
                                        }
                                    }
                                ) {
                                    Icon(Icons.Default.ChevronRight, contentDescription = "Scroll Right", tint = Color.White, modifier = Modifier.size(16.dp))
                                }
                            }
                        }

                        LazyRow(
                            state = franchiseListState,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(franchiseCollections, key = { it.id }) { col ->
                                val isSelected = selectedFranchise?.id == col.id
                                FranchiseCard(
                                    collection = col,
                                    isSelected = isSelected,
                                    onClick = {
                                        selectedFranchise = if (isSelected) null else col
                                    }
                                )
                            }
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 5. LIVE TV CHANNELS (When in Live TV tab)
            // ------------------------------------------------------------------------------------
            if (selectedTab == "Live TV") {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                        Text(
                            text = "Verified 24/7 Live IPTV Channels (${liveChannels.size})",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )

                        val chunkedChannels = liveChannels.chunked(3)
                        for (row in chunkedChannels) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                for (ch in row) {
                                    Box(modifier = Modifier.weight(1f)) {
                                        LiveChannelCard(
                                            channel = ch,
                                            onPlay = {
                                                MoviePlayRepository.launchVideoStream(ch.url, ch.name)
                                                toastMessage = "▶ Launching Live Stream: ${ch.name}..."
                                            }
                                        )
                                    }
                                }
                                val rem = 3 - row.size
                                if (rem > 0) {
                                    for (i in 0 until rem) Spacer(Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 6. MOVIE CATALOG GRID & A-Z ALPHABETICAL SECTIONS (1,534+ Titles)
            // ------------------------------------------------------------------------------------
            if (selectedTab != "Live TV") {
                item(key = "catalog_header_controls") {
                    val headerTitle = when {
                        searchQuery.isNotBlank() -> "Search Results for \"$searchQuery\" (${displayMovies.size} Titles)"
                        selectedLetter != "All" -> "Letter '$selectedLetter' Titles (${displayMovies.size})"
                        selectedFranchise != null -> "${selectedFranchise?.name} Saga (${displayMovies.size} Titles)"
                        selectedVibe != "All" -> "$selectedVibe Movies & Shows (${displayMovies.size})"
                        else -> "$selectedTab Cinema Catalog (${displayMovies.size} Titles)"
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = headerTitle,
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = Color.White
                            )
                            Text(
                                text = "Showing ${displayMovies.size} titles • Organized by ${sortOrder.label}",
                                fontSize = 11.5.sp,
                                color = Color.White.copy(alpha = 0.70f)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (selectedLetter == "All" && searchQuery.isBlank() && sortOrder == MovieSortOrder.NAME_ASC) {
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(8.dp),
                                    borderColor = if (groupByLetter) Color(0xFFE11D48).copy(alpha = 0.60f) else Color.White.copy(alpha = 0.15f),
                                    isSelected = groupByLetter,
                                    selectedBgColor = Color(0xFFE11D48).copy(alpha = 0.22f)
                                ) {
                                    Text(
                                        text = if (groupByLetter) "✓ A-Z Grouped" else "Flat Grid",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = if (groupByLetter) Color.White else Color.White.copy(alpha = 0.75f),
                                        modifier = Modifier.clickable { groupByLetter = !groupByLetter }.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }

                            if (selectedLetter != "All") {
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(8.dp),
                                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.40f)
                                ) {
                                    Text(
                                        text = "Reset Letter filter ×",
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFF38BDF8),
                                        modifier = Modifier.clickable { selectedLetter = "All" }.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }

                            MovieSortSelector(
                                currentSort = sortOrder,
                                onSortSelected = { sortOrder = it }
                            )
                        }
                    }
                }

                if (groupedSections != null) {
                    for ((letter, letterMovies) in groupedSections) {
                        item(key = "letter_hdr_$letter") {
                            AlphabeticalSectionHeader(
                                letter = letter,
                                count = letterMovies.size,
                                onJumpToLetter = { selectedLetter = letter }
                            )
                        }
                        val rows = letterMovies.chunked(columns)
                        items(
                            items = rows,
                            key = { row -> "row_${letter}_${row.first().id}" }
                        ) { row ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(14.dp)
                            ) {
                                for (movie in row) {
                                    Box(modifier = Modifier.weight(1f)) {
                                        MovieBoxCinemaCard(
                                            item = movie,
                                            onPlay = {
                                                scope.launch {
                                                    MoviePlayRepository.playMovieDirect(movie) { toastMessage = it }
                                                }
                                            },
                                            onSelect = { selectedMovieForModal = movie },
                                            onTrailerClick = {
                                                val tUrl = MoviePlayRepository.getTrailerUrl(movie.title)
                                                MoviePlayRepository.openInBrowser(tUrl)
                                                toastMessage = "🎬 Opening Official Trailer for ${movie.title}..."
                                            },
                                            onSoundtrackClick = {
                                                scope.launch {
                                                    toastMessage = "🎵 Finding Original Soundtrack for ${movie.title}..."
                                                    val tracks = MoviePlayRepository.resolveSoundtrackForMovie(movie.title)
                                                    if (tracks.isNotEmpty()) {
                                                        playerViewModel.playWithQueue(tracks.first(), tracks)
                                                        toastMessage = "▶ Playing Soundtrack: ${movie.title} (${tracks.size} tracks queued)"
                                                    } else {
                                                        toastMessage = "⚠ No audio album found for ${movie.title}"
                                                    }
                                                }
                                            }
                                        )
                                    }
                                }
                                val rem = columns - row.size
                                if (rem > 0) {
                                    for (i in 0 until rem) Spacer(Modifier.weight(1f))
                                }
                            }
                        }
                    }
                } else {
                    val rows = displayMovies.chunked(columns)
                    items(
                        items = rows,
                        key = { row -> "row_${row.first().id}" }
                    ) { row ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            for (movie in row) {
                                Box(modifier = Modifier.weight(1f)) {
                                    MovieBoxCinemaCard(
                                        item = movie,
                                        onPlay = {
                                            scope.launch {
                                                MoviePlayRepository.playMovieDirect(movie) { toastMessage = it }
                                            }
                                        },
                                        onSelect = { selectedMovieForModal = movie },
                                        onTrailerClick = {
                                            val tUrl = MoviePlayRepository.getTrailerUrl(movie.title)
                                            MoviePlayRepository.openInBrowser(tUrl)
                                            toastMessage = "🎬 Opening Official Trailer for ${movie.title}..."
                                        },
                                        onSoundtrackClick = {
                                            scope.launch {
                                                toastMessage = "🎵 Finding Original Soundtrack for ${movie.title}..."
                                                val tracks = MoviePlayRepository.resolveSoundtrackForMovie(movie.title)
                                                if (tracks.isNotEmpty()) {
                                                    playerViewModel.playWithQueue(tracks.first(), tracks)
                                                    toastMessage = "▶ Playing Soundtrack: ${movie.title} (${tracks.size} tracks queued)"
                                                } else {
                                                    toastMessage = "⚠ No audio album found for ${movie.title}"
                                                }
                                            }
                                        }
                                    )
                                }
                            }
                            val rem = columns - row.size
                            if (rem > 0) {
                                for (i in 0 until rem) Spacer(Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }

        // Floating Quick Scroll-to-Top Navigation Button
        AnimatedVisibility(
            visible = showScrollToTop,
            enter = fadeIn(tween(250)) + scaleIn(spring(dampingRatio = Spring.DampingRatioMediumBouncy)),
            exit = fadeOut(tween(200)) + scaleOut(),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 28.dp, bottom = 28.dp)
                .zIndex(95f)
        ) {
            LiquidGlassCard(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .height(44.dp)
                    .shadow(16.dp, RoundedCornerShape(16.dp), spotColor = Color(0xFFE11D48).copy(alpha = 0.60f))
                    .pointerHoverIcon(PointerIcon.Hand),
                backgroundColor = Color(0xFFE11D48).copy(alpha = 0.90f),
                borderColor = Color.White.copy(alpha = 0.40f),
                hoverBorderColor = Color.White,
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(0)
                    }
                }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowUp,
                        contentDescription = "Scroll to Top",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        "Top",
                        color = Color.White,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Toast feedback overlay
        toastMessage?.let { msg ->
            LiquidGlassBox(
                shape = RoundedCornerShape(12.dp),
                borderColor = Color(0xFFE11D48).copy(alpha = 0.85f),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
                    .zIndex(100f)
            ) {
                Text(
                    text = msg,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                )
            }
            LaunchedEffect(msg) {
                delay(3200L)
                toastMessage = null
            }
        }

        // Movie Detail Modal (With working streams, trailer & soundtrack)
        selectedMovieForModal?.let { movie ->
            SeniorMovieBoxDetailModal(
                movie = movie,
                onDismiss = { selectedMovieForModal = null },
                onStreamSelected = { stream, allStreams ->
                    MoviePlayRepository.launchVideoStream(stream.url, movie.title, allStreams)
                    toastMessage = "▶ Launching: ${stream.title}..."
                },
                onTrailerClick = {
                    val tUrl = MoviePlayRepository.getTrailerUrl(movie.title)
                    MoviePlayRepository.openInBrowser(tUrl)
                    toastMessage = "🎬 Opening Official Trailer for ${movie.title}..."
                },
                onPlaySoundtrack = {
                    scope.launch {
                        toastMessage = "🎵 Finding Original Soundtrack for ${movie.title}..."
                        val tracks = MoviePlayRepository.resolveSoundtrackForMovie(movie.title)
                        if (tracks.isNotEmpty()) {
                            playerViewModel.playWithQueue(tracks.first(), tracks)
                            toastMessage = "▶ Playing Soundtrack: ${movie.title} (${tracks.size} tracks queued)"
                            selectedMovieForModal = null
                        } else {
                            toastMessage = "⚠ No audio album found for ${movie.title}"
                        }
                    }
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

    val categories = listOf("All", "Action", "Sci-Fi", "Drama", "Animation", "Comedy")

    val filteredMovies = remember(selectedCategory, curatedMovies) {
        if (selectedCategory == "All") curatedMovies
        else curatedMovies.filter { it.genre.contains(selectedCategory, ignoreCase = true) }
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
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(4.dp),
                        borderColor = Color(0xFFE11D48).copy(alpha = 0.50f)
                    ) {
                        Text(
                            text = "CINEMA STUDIO • 1,534+ TITLES",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE11D48),
                            letterSpacing = 0.5.sp,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
                Text(
                    text = "Movie Play & Blockbuster Soundtracks",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.3).sp
                    ),
                    color = Color.White
                )
                Text(
                    text = "Stream Hollywood & global blockbusters, 4K releases, and complete original motion picture jukeboxes.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.80f)
                )
            }
        }

        // Category Pills
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories, key = { it }) { cat ->
                val isSelected = cat == selectedCategory
                SeniorFilterPill(
                    title = cat,
                    isSelected = isSelected,
                    onClick = { selectedCategory = cat }
                )
            }
        }

        // Horizontal Carousel
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ) {
            items(filteredMovies, key = { it.id }) { movie ->
                Box(modifier = Modifier.width(180.dp)) {
                    MovieCinemaCard(
                        movie = movie,
                        onPlay = { onPlayMovie(movie) },
                        onSelect = { onSelectMovie(movie) }
                    )
                }
            }
        }
    }
}

// =========================================================================
// UI COMPONENTS: CARDS & MODALS
// =========================================================================

@Composable
fun MovieBoxCinemaCard(
    item: MovieBoxItem,
    onPlay: () -> Unit,
    onSelect: () -> Unit,
    onTrailerClick: (() -> Unit)? = null,
    onSoundtrackClick: (() -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.035f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMedium)
    )

    LiquidGlassCard(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .pointerHoverIcon(PointerIcon.Hand),
        backgroundColor = if (isHovered) Color(0xFF131824).copy(alpha = 0.35f) else Color(0xFF0A0D14).copy(alpha = 0.20f),
        borderColor = if (isHovered) Color(0xFFE11D48).copy(alpha = 0.70f) else Color.White.copy(alpha = 0.12f),
        hoverBorderColor = Color(0xFFE11D48).copy(alpha = 0.85f),
        onClick = onSelect
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Poster with true cinema portrait 2:3 aspect ratio
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        BorderStroke(1.dp, if (isHovered) Color(0xFFE11D48).copy(alpha = 0.60f) else Color.White.copy(alpha = 0.08f)),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                AsyncImage(
                    model = item.coverUrl.ifBlank { item.bannerUrl },
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Top Quality & Rating badges with Frosted Glass Blur
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Quality Pill
                    LiquidGlassBox(
                        shape = RoundedCornerShape(6.dp),
                        borderColor = Color(0xFFE11D48).copy(alpha = 0.60f)
                    ) {
                        Text(
                            text = item.qualityBadge.ifBlank { "1080p HD" },
                            color = Color.White,
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }

                    // IMDB Rating Pill
                    LiquidGlassBox(
                        shape = RoundedCornerShape(6.dp),
                        borderColor = Color(0xFFFBBF24).copy(alpha = 0.50f)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFBBF24), modifier = Modifier.size(10.dp))
                            Text(
                                text = item.rating.ifBlank { "8.5" },
                                color = Color.White,
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                // Bottom badges on poster: Type (Left) & Duration (Right) with Frosted Glass Blur
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(5.dp),
                        borderColor = if (item.type == "series") Color(0xFF38BDF8).copy(alpha = 0.6f) else Color(0xFFE11D48).copy(alpha = 0.5f)
                    ) {
                        Text(
                            text = if (item.type == "series") "SERIES" else "MOVIE",
                            color = if (item.type == "series") Color(0xFF38BDF8) else Color(0xFFFDA4AF),
                            fontSize = 8.sp,
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = 0.3.sp,
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                        )
                    }

                    if (item.duration.isNotBlank()) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(5.dp),
                            borderColor = Color.White.copy(alpha = 0.20f)
                        ) {
                            Text(
                                text = item.duration,
                                color = Color.White.copy(alpha = 0.90f),
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                            )
                        }
                    }
                }

                // Hover Action Overlay
                if (isHovered) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color.Black.copy(alpha = 0.25f),
                                        Color.Black.copy(alpha = 0.60f),
                                        Color(0xFF0F172A).copy(alpha = 0.92f)
                                    )
                                )
                            )
                    ) {
                        // Center Play Stream Button
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .align(Alignment.Center)
                                .clip(CircleShape)
                                .background(Color(0xFFE11D48))
                                .clickable { onPlay() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.White, modifier = Modifier.size(26.dp))
                        }

                        // Bottom Quick Actions: Trailer & Music with Frosted Glass Blur
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter)
                                .padding(horizontal = 6.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (onTrailerClick != null) {
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(6.dp),
                                    borderColor = Color.White.copy(alpha = 0.35f),
                                    onClick = onTrailerClick
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.5.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                                    ) {
                                        Icon(Icons.Default.Theaters, contentDescription = null, tint = Color.White, modifier = Modifier.size(11.dp))
                                        Text("Trailer", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }

                            if (onSoundtrackClick != null) {
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(6.dp),
                                    borderColor = Color(0xFF38BDF8).copy(alpha = 0.50f),
                                    onClick = onSoundtrackClick
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.5.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                                    ) {
                                        Icon(Icons.AutoMirrored.Filled.QueueMusic, contentDescription = null, tint = Color(0xFF38BDF8), modifier = Modifier.size(11.dp))
                                        Text("Music", color = Color.White, fontSize = 8.5.sp, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            // Mini-Info: Title
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.White,
                fontSize = 12.5.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(2.dp))

            // Mini-Info: Year • Genre • Mirrors
            val mainGenre = item.genre.split(",").firstOrNull()?.trim() ?: "Cinema"
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${item.year} • $mainGenre",
                    fontSize = 10.5.sp,
                    color = Color.White.copy(alpha = 0.70f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "4 Mirrors",
                    fontSize = 9.sp,
                    color = Color(0xFF10B981),
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Mini-Info: Plot Synopsis Snippet
            if (item.description.isNotBlank()) {
                Spacer(Modifier.height(3.dp))
                Text(
                    text = item.description,
                    fontSize = 9.5.sp,
                    color = Color.White.copy(alpha = 0.50f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 12.sp
                )
            }
        }
    }
}

// Legacy MovieCinemaCard
@Composable
fun MovieCinemaCard(
    movie: MovieSoundtrack,
    onPlay: () -> Unit,
    onSelect: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.04f else 1.0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessMedium)
    )

    LiquidGlassCard(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale)
            .pointerHoverIcon(PointerIcon.Hand),
        backgroundColor = if (isHovered) Color(0xFF131824).copy(alpha = 0.45f) else Color(0xFF0A0D14).copy(alpha = 0.28f),
        borderColor = if (isHovered) movie.accentColor.copy(alpha = 0.75f) else Color.White.copy(alpha = 0.12f),
        hoverBorderColor = movie.accentColor,
        onClick = onSelect
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(7.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                .shadow(
                    elevation = if (isHovered) 18.dp else 6.dp,
                    shape = RoundedCornerShape(14.dp),
                    spotColor = movie.accentColor.copy(alpha = 0.50f)
                )
                .clip(RoundedCornerShape(14.dp))
                .border(
                    BorderStroke(1.dp, if (isHovered) movie.accentColor.copy(alpha = 0.80f) else Color.White.copy(alpha = 0.12f)),
                    shape = RoundedCornerShape(14.dp)
                )
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            LiquidGlassBox(
                shape = RoundedCornerShape(6.dp),
                borderColor = movie.accentColor.copy(alpha = 0.60f),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            ) {
                Text(movie.bannerBadge, color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
            }

            if (isHovered) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .background(movie.accentColor)
                        .clickable { onPlay() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.White, modifier = Modifier.size(24.dp))
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = movie.title,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = "${movie.year} • ${movie.genre}",
            fontSize = 10.5.sp,
            color = Color.White.copy(alpha = 0.70f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        }
    }
}

@Composable
fun FranchiseCard(
    collection: MovieBoxCollection,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    LiquidGlassBox(
        shape = RoundedCornerShape(14.dp),
        isSelected = isSelected,
        selectedBgColor = Color(0xFFE11D48).copy(alpha = 0.25f),
        selectedBorderColor = Color(0xFFE11D48),
        modifier = Modifier
            .width(200.dp)
            .height(78.dp)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = collection.emoji, fontSize = 24.sp)
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = collection.name,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = collection.tagline,
                    fontSize = 10.sp,
                    color = Color.White.copy(alpha = 0.70f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 12.sp
                )
            }
        }
    }
}

@Composable
fun LiveChannelCard(
    channel: MovieBoxLiveChannel,
    onPlay: () -> Unit
) {
    LiquidGlassBox(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable { onPlay() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White.copy(alpha = 0.10f))
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = channel.logo,
                    contentDescription = channel.name,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFEF4444))
                    )
                    Text("LIVE ${channel.country}", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFEF4444))
                }
                Text(channel.name, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 1)
                Text(channel.category, fontSize = 11.sp, color = Color.White.copy(alpha = 0.65f))
            }

            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE11D48)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.White, modifier = Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun MovieVibePill(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    LiquidGlassBox(
        shape = RoundedCornerShape(16.dp),
        isSelected = isSelected,
        selectedBgColor = Color(0xFFE11D48).copy(alpha = 0.22f),
        selectedBorderColor = Color(0xFFE11D48).copy(alpha = 0.70f),
        backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.28f),
        borderColor = Color.White.copy(alpha = 0.12f),
        hoverBorderColor = Color(0xFFE11D48).copy(alpha = 0.45f),
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                fontSize = 11.5.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) Color.White else Color.White.copy(alpha = 0.75f)
            )
        }
    }
}

// =========================================================================
// DETAIL MODAL: STREAMS, TRAILER, AND SOUNDTRACK JUKEBOX
// =========================================================================

@Composable
fun SeniorMovieBoxDetailModal(
    movie: MovieBoxItem,
    onDismiss: () -> Unit,
    onStreamSelected: (MovieStreamOption, List<MovieStreamOption>) -> Unit,
    onTrailerClick: () -> Unit,
    onPlaySoundtrack: () -> Unit,
    onAddToPlaylist: (Track) -> Unit,
    onDownloadTrack: (Track) -> Unit
) {
    var streams by remember { mutableStateOf<List<MovieStreamOption>>(emptyList()) }
    var isLoadingStreams by remember { mutableStateOf(true) }

    LaunchedEffect(movie.id) {
        isLoadingStreams = true
        streams = MoviePlayRepository.fetchMovieStreams(movie)
        isLoadingStreams = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.82f))
            .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {
                onDismiss()
            }
            .zIndex(90f),
        contentAlignment = Alignment.Center
    ) {
        LiquidGlassCard(
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .width(820.dp)
                .heightIn(max = 680.dp)
                .shadow(28.dp, RoundedCornerShape(22.dp), spotColor = Color(0xFFE11D48).copy(alpha = 0.50f))
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { /* Consume */ },
            backgroundColor = Color(0xFF0A0C10).copy(alpha = 0.60f),
            borderColor = Color(0xFFE11D48).copy(alpha = 0.50f)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                // Header row
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            LiquidGlassBox(
                                shape = RoundedCornerShape(6.dp),
                                borderColor = Color(0xFFE11D48).copy(alpha = 0.50f)
                            ) {
                                Text(movie.qualityBadge.ifBlank { "4K UHD" }, color = Color(0xFFE11D48), fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
                            }
                            Text("MOVIEBOX STREAMING REVERSE CORE", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.70f))
                        }

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.12f))
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                    }
                }

                // Billboard Banner with Poster & Info
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(12.dp))
                        ) {
                            AsyncImage(
                                model = movie.coverUrl.ifBlank { movie.bannerUrl },
                                contentDescription = movie.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFBBF24), modifier = Modifier.size(14.dp))
                                Text("${movie.rating} / 10 IMDB", color = Color(0xFFFBBF24), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                Text("•  ${movie.year}  •  ${movie.duration.ifBlank { "Feature Film" }}", color = Color.White.copy(alpha = 0.70f), fontSize = 12.sp)
                            }

                            Text(
                                text = movie.title,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )

                            Text(
                                text = "Genres: ${movie.genre}",
                                fontSize = 12.sp,
                                color = Color(0xFF38BDF8),
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = movie.description,
                                fontSize = 12.5.sp,
                                color = Color.White.copy(alpha = 0.85f),
                                lineHeight = 17.sp,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(Modifier.height(6.dp))

                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Button(
                                    onClick = {
                                        val best = streams.firstOrNull { !it.isEmbed } ?: streams.firstOrNull()
                                        if (best != null) {
                                            onStreamSelected(best, streams)
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Stream Movie Now", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }

                                Button(
                                    onClick = onTrailerClick,
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.15f)),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(Icons.Default.Theaters, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Official Trailer", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }

                                Button(
                                    onClick = onPlaySoundtrack,
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE11D48)),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Icon(Icons.AutoMirrored.Filled.QueueMusic, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Play Soundtrack Jukebox", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }

                // Available Stream Mirrors Section
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text(
                            text = "Instant Streaming Mirrors (${streams.size})",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White
                        )

                        if (isLoadingStreams) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                CircularProgressIndicator(color = Color(0xFFE11D48), strokeWidth = 2.dp, modifier = Modifier.size(18.dp))
                                Text("Resolving high-speed streaming mirrors...", color = Color.White.copy(alpha = 0.70f), fontSize = 12.sp)
                            }
                        } else {
                            streams.forEach { stream ->
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .pointerHoverIcon(PointerIcon.Hand)
                                        .clickable { onStreamSelected(stream, streams) }
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth().padding(horizontal = 14.dp, vertical = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                            Box(
                                                modifier = Modifier
                                                    .size(32.dp)
                                                    .clip(CircleShape)
                                                    .background(Color(0xFFE11D48).copy(alpha = 0.20f)),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color(0xFFE11D48), modifier = Modifier.size(18.dp))
                                            }

                                            Column {
                                                Text(stream.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                                Text(
                                                    "${stream.format} • ${stream.resolution}p • ${stream.audio}${if (stream.size.isNotBlank()) " • " + stream.size else ""}",
                                                    fontSize = 11.sp,
                                                    color = Color.White.copy(alpha = 0.65f)
                                                )
                                            }
                                        }

                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(6.dp))
                                                .background(Color(0xFFE11D48))
                                                .padding(horizontal = 12.dp, vertical = 6.dp)
                                        ) {
                                            Text("Stream Now", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// Legacy SeniorMovieDetailModal
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
        LiquidGlassCard(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(780.dp)
                .heightIn(max = 640.dp)
                .shadow(24.dp, RoundedCornerShape(20.dp), spotColor = movie.accentColor)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { /* Consume */ },
            borderColor = movie.accentColor.copy(alpha = 0.50f)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(movie.accentColor.copy(alpha = 0.20f))
                                    .border(1.dp, movie.accentColor.copy(alpha = 0.60f), RoundedCornerShape(6.dp))
                                    .padding(horizontal = 8.dp, vertical = 3.dp)
                            ) {
                                Text(movie.bannerBadge, color = movie.accentColor, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                            Text("CINEMA SOUNDTRACK", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.60f))
                        }

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color.White.copy(alpha = 0.12f))
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(18.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(140.dp)
                                .height(180.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .border(1.dp, Color.White.copy(alpha = 0.20f), RoundedCornerShape(12.dp))
                        ) {
                            AsyncImage(
                                model = movie.posterUrl,
                                contentDescription = movie.title,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(movie.title, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                            Text("Music & Direction: ${movie.directorOrComposer}", fontSize = 12.sp, color = Color(0xFF38BDF8), fontWeight = FontWeight.Medium)
                            Text("Cast: ${movie.starCast}", fontSize = 12.sp, color = Color.White.copy(alpha = 0.85f))
                            Text(movie.description, fontSize = 12.sp, color = Color.White.copy(alpha = 0.75f), maxLines = 3, overflow = TextOverflow.Ellipsis)
                            Spacer(Modifier.height(4.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(
                                    onClick = onPlayAll,
                                    colors = ButtonDefaults.buttonColors(containerColor = movie.accentColor),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text("Play Jukebox", color = Color.White, fontSize = 11.5.sp, fontWeight = FontWeight.Bold)
                                }
                                Button(
                                    onClick = onShufflePlay,
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.14f)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Icon(Icons.Default.Shuffle, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text("Shuffle", color = Color.White, fontSize = 11.5.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// =========================================================================
// ALPHABETICAL A-Z NAVIGATION & SORTING COMPONENTS
// =========================================================================

@Composable
fun AlphabeticalRibbon(
    letters: List<String>,
    selectedLetter: String,
    letterCounts: Map<String, Int>,
    onLetterSelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(letters, key = { it }) { letter ->
            val count = letterCounts[letter] ?: 0
            val isSelected = letter == selectedLetter
            val hasItems = letter == "All" || count > 0

            LiquidGlassBox(
                shape = RoundedCornerShape(8.dp),
                isSelected = isSelected,
                selectedBgColor = Color(0xFFE11D48),
                selectedBorderColor = Color(0xFFE11D48),
                onClick = if (hasItems) { { onLetterSelected(letter) } } else null
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = letter,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.Bold,
                        color = when {
                            isSelected -> Color.White
                            hasItems -> Color.White
                            else -> Color.White.copy(alpha = 0.35f)
                        }
                    )
                    if (count > 0 && letter != "All") {
                        Text(
                            text = count.toString(),
                            fontSize = 9.sp,
                            color = if (isSelected) Color.White.copy(alpha = 0.90f) else Color.White.copy(alpha = 0.50f),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AlphabeticalSectionHeader(
    letter: String,
    count: Int,
    onJumpToLetter: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(8.dp),
                borderColor = Color(0xFFE11D48).copy(alpha = 0.70f),
                modifier = Modifier.size(34.dp)
            ) {
                Text(
                    text = letter,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFFE11D48)
                )
            }

            Column {
                Text(
                    text = if (letter == "#") "Special & Numeric Titles" else "Letter $letter",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(
                    text = "$count movies & series starting with $letter",
                    fontSize = 11.sp,
                    color = Color.White.copy(alpha = 0.60f)
                )
            }
        }

        LiquidGlassBox(
            shape = RoundedCornerShape(8.dp),
            onClick = onJumpToLetter
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = Color.White.copy(alpha = 0.70f), modifier = Modifier.size(12.dp))
                Text(
                    text = "Filter $letter Only",
                    fontSize = 10.5.sp,
                    color = Color.White.copy(alpha = 0.85f),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun MovieSortSelector(
    currentSort: MovieSortOrder,
    onSortSelected: (MovieSortOrder) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        LiquidGlassBox(
            shape = RoundedCornerShape(8.dp),
            onClick = { expanded = !expanded }
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(Icons.Default.SortByAlpha, contentDescription = null, tint = Color(0xFFE11D48), modifier = Modifier.size(15.dp))
                Text(
                    text = currentSort.label,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.White.copy(alpha = 0.70f), modifier = Modifier.size(16.dp))
            }
        }

        if (expanded) {
            androidx.compose.material3.DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(Color(0xFF0F172A).copy(alpha = 0.90f))
            ) {
                MovieSortOrder.values().forEach { sort ->
                    androidx.compose.material3.DropdownMenuItem(
                        text = {
                            Text(
                                text = sort.label,
                                color = if (sort == currentSort) Color(0xFFE11D48) else Color.White,
                                fontSize = 12.sp,
                                fontWeight = if (sort == currentSort) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        onClick = {
                            onSortSelected(sort)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
