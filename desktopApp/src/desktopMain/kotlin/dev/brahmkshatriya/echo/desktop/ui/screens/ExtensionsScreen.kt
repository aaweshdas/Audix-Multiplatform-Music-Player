package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.brahmkshatriya.echo.common.Extension
import dev.brahmkshatriya.echo.common.LyricsExtension
import dev.brahmkshatriya.echo.common.MiscExtension
import dev.brahmkshatriya.echo.common.MusicExtension
import dev.brahmkshatriya.echo.common.TrackerExtension
import dev.brahmkshatriya.echo.common.models.ExtensionType
import dev.brahmkshatriya.echo.common.models.Metadata
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import dev.brahmkshatriya.echo.desktop.viewmodel.ExtensionsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.compose.koinInject
import java.awt.Desktop
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

// ============================================================================
// DOMAIN MODELS & ENUMS
// ============================================================================

enum class ExtensionViewTab(val title: String, val icon: ImageVector) {
    INSTALLED("Installed", Icons.Default.CheckCircle),
    EXPLORE("Community Catalog", Icons.Default.Explore)
}

enum class ExtensionCategoryFilter(val label: String, val icon: ImageVector) {
    ALL("All Extensions", Icons.Default.Extension),
    MUSIC("Music Sources", Icons.Default.MusicNote),
    LYRICS("Lyrics Engines", Icons.Default.Description),
    TRACKERS("Integrations & RPC", Icons.Default.Hub),
    RADIO("Live Radio", Icons.Default.Radio)
}

data class CuratedExtension(
    val id: String,
    val name: String,
    val version: String,
    val author: String,
    val description: String,
    val type: ExtensionType,
    val icon: ImageVector,
    val capabilities: List<String>,
    val bundledFileName: String? = null,
    val directJarUrl: String? = null,
    val aliases: List<String> = emptyList()
)

private val CURATED_COMMUNITY_EXTENSIONS = listOf(
    CuratedExtension(
        id = "youtube_music",
        name = "YouTube Music",
        version = "1.0.0",
        author = "Echo Community",
        description = "Universal music streaming catalog powered by YouTube Music InnerTube engine with high-bitrate Opus streams, artist radios, and trending charts.",
        type = ExtensionType.MUSIC,
        icon = Icons.Default.MusicNote,
        capabilities = listOf("High Bitrate Opus", "Global Charts", "Artist Radio", "Trending Feeds"),
        bundledFileName = "youtube.jar",
        aliases = listOf("youtube", "youtube_music")
    ),
    CuratedExtension(
        id = "saavn_music",
        name = "JioSaavn Music",
        version = "1.0.0",
        author = "Echo Community",
        description = "High-fidelity audio streaming catalog featuring 80M+ tracks across regional, Bollywood, and international libraries in pristine 320kbps AAC.",
        type = ExtensionType.MUSIC,
        icon = Icons.Default.GraphicEq,
        capabilities = listOf("Lossless 320kbps", "Regional Catalogs", "Curated Playlists", "Zero Ads"),
        bundledFileName = "saavn.jar",
        aliases = listOf("saavn", "saavn_music")
    ),
    CuratedExtension(
        id = "spotify_music",
        name = "Spotify Global Charts",
        version = "1.0.0",
        author = "Echo Community",
        description = "Instant access to Spotify Top 50 Global, Viral Hits, trending playlists, and deep metadata matching with seamless playback integration.",
        type = ExtensionType.MUSIC,
        icon = Icons.Default.Public,
        capabilities = listOf("Top 50 Global", "Viral Hits", "Metadata Matcher", "Built-in Source"),
        bundledFileName = "spotify.jar",
        aliases = listOf("spotify", "spotify_music")
    ),
    CuratedExtension(
        id = "soundcloud",
        name = "SoundCloud",
        version = "1.0.0",
        author = "Echo Community",
        description = "Vibrant indie catalog featuring independent producers, underground mixes, electronic sets, and trending soundscapes.",
        type = ExtensionType.MUSIC,
        icon = Icons.Default.GraphicEq,
        capabilities = listOf("Indie Creators", "DJ Mixes & Sets", "Live Feeds", "Underground Tracks"),
        bundledFileName = "soundcloud.jar",
        aliases = listOf("soundcloud", "soundcloud_music")
    ),
    CuratedExtension(
        id = "radio_browser",
        name = "Radio Browser",
        version = "1.0.0",
        author = "Echo Community",
        description = "Over 35,000 live internet radio stations worldwide spanning genres, countries, languages, and news feeds.",
        type = ExtensionType.MUSIC,
        icon = Icons.Default.Radio,
        capabilities = listOf("35,000+ Stations", "Live Broadcasts", "Worldwide Channels", "Low Latency"),
        bundledFileName = "radiobrowser.jar",
        aliases = listOf("radiobrowser", "radio_browser")
    ),
    CuratedExtension(
        id = "lrclib_lyrics",
        name = "LRCLIB Realtime Lyrics",
        version = "1.0.0",
        author = "Echo Community",
        description = "Millisecond-precision synchronized karaoke lyrics engine crowdsourced from the open LRCLIB database.",
        type = ExtensionType.LYRICS,
        icon = Icons.Default.Description,
        capabilities = listOf("Karaoke Sync", "Millisecond Accurate", "Offline Cache", "Multi-Language"),
        bundledFileName = "lrclib.jar",
        aliases = listOf("lrclib", "lrclib_lyrics")
    ),
    CuratedExtension(
        id = "genius_lyrics",
        name = "Genius Lyrics & Trivia",
        version = "1.0.0",
        author = "Echo Community",
        description = "Comprehensive song lyric annotations, artist trivia, verified songwriter explanations, and track backgrounds.",
        type = ExtensionType.LYRICS,
        icon = Icons.Default.Description,
        capabilities = listOf("Song Annotations", "Artist Meanings", "Track Trivia", "Global Lyrics"),
        bundledFileName = "genius.jar",
        aliases = listOf("genius", "genius_lyrics")
    ),
    CuratedExtension(
        id = "musixmatch_lyrics",
        name = "Musixmatch Lyrics",
        version = "1.0.0",
        author = "Echo Community",
        description = "Extensive synchronized lyrics database with multi-lingual line-by-line translations and synced timecodes.",
        type = ExtensionType.LYRICS,
        icon = Icons.Default.Description,
        capabilities = listOf("Synced Lines", "Word Translation", "Global Database"),
        bundledFileName = "musixmatch.jar",
        aliases = listOf("musixmatch", "musixmatch_lyrics")
    ),
    CuratedExtension(
        id = "discord_rpc",
        name = "Discord Rich Presence",
        version = "1.0.0",
        author = "Echo Community",
        description = "Broadcasts your currently playing track, artist name, high-res album art, elapsed time, and Audix presence to Discord.",
        type = ExtensionType.TRACKER,
        icon = Icons.Default.Hub,
        capabilities = listOf("Rich Presence", "Live Album Art", "Time Sync", "Discord Activity"),
        bundledFileName = "discordrpc.jar",
        aliases = listOf("discordrpc", "discord_rpc")
    ),
    CuratedExtension(
        id = "lastfm_tracker",
        name = "Last.fm Scrobbler",
        version = "1.0.0",
        author = "Echo Community",
        description = "Automatically logs every track you listen to on Audix into your personal Last.fm scrobble profile and listening history.",
        type = ExtensionType.TRACKER,
        icon = Icons.Default.Hub,
        capabilities = listOf("Auto Scrobbler", "Now Playing Status", "History Tracking"),
        bundledFileName = "lastfm.jar",
        aliases = listOf("lastfm", "lastfm_tracker")
    )
)

// ============================================================================
// MAIN COMPOSABLE (MINIMALIST MONOCHROME / DECENT BLACK & WHITE)
// ============================================================================

@Composable
fun ExtensionsScreen(
    viewModel: ExtensionsViewModel = koinInject()
) {
    val platform = koinInject<AppPlatform>()
    val coroutineScope = rememberCoroutineScope()

    val musicExtensions by viewModel.music.collectAsState()
    val lyricsExtensions by viewModel.lyrics.collectAsState()
    val trackerExtensions by viewModel.tracker.collectAsState()
    val miscExtensions by viewModel.misc.collectAsState()
    val currentExtension by viewModel.currentExtension.collectAsState()

    // Screen State
    var selectedTab by remember { mutableStateOf(ExtensionViewTab.INSTALLED) }
    var selectedCategory by remember { mutableStateOf(ExtensionCategoryFilter.ALL) }
    var searchQuery by remember { mutableStateOf("") }

    // Dialog & Feedback States
    var statusMessage by remember { mutableStateOf<String?>(null) }
    var statusIsError by remember { mutableStateOf(false) }
    var showAddDialog by remember { mutableStateOf(false) }
    var inspectingMetadata by remember { mutableStateOf<Metadata?>(null) }
    var pendingUninstallMetadata by remember { mutableStateOf<Metadata?>(null) }

    fun showFeedback(msg: String, isError: Boolean = false) {
        statusMessage = msg
        statusIsError = isError
    }

    fun pickAndInstallFromFile() {
        coroutineScope.launch(Dispatchers.Main) {
            try {
                val dialog = FileDialog(null as Frame?, "Select Extension JAR", FileDialog.LOAD)
                dialog.setFile("*.jar")
                dialog.isVisible = true
                val dir = dialog.directory
                val file = dialog.file
                if (dir != null && file != null) {
                    val fullPath = File(dir, file).absolutePath
                    withContext(Dispatchers.IO) {
                        viewModel.installFromFile(fullPath)
                    }
                    showFeedback("Installing extension from $file...")
                }
            } catch (e: Exception) {
                showFeedback("Error opening file picker: ${e.message}", isError = true)
            }
        }
    }

    fun installFromCurated(curated: CuratedExtension) {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val destDir = platform.extensionsDir.toFile().canonicalFile.also { it.mkdirs() }
                val rawName = curated.bundledFileName ?: "${curated.id}.jar"
                val safeName = File(rawName).name.replace(Regex("""[^a-zA-Z0-9._-]"""), "_")
                val targetFile = File(destDir, safeName).canonicalFile
                if (targetFile.parentFile?.canonicalPath != destDir.canonicalPath) {
                    throw SecurityException("Invalid extension target path: path traversal detected")
                }

                val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("extensions/$safeName")
                    ?: platform::class.java.getResourceAsStream("/extensions/$safeName")
                    ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "extensions", safeName).toFile().takeIf { it.exists() }?.inputStream()
                    ?: java.nio.file.Paths.get("app", "resources", "extensions", safeName).toFile().takeIf { it.exists() }?.inputStream()
                    ?: java.nio.file.Paths.get("desktopApp", "src", "desktopMain", "resources", "extensions", safeName).toFile().takeIf { it.exists() }?.inputStream()

                if (stream != null) {
                    stream.use { input ->
                        targetFile.outputStream().use { output -> input.copyTo(output) }
                    }
                    viewModel.installFromFile(targetFile.absolutePath)
                    withContext(Dispatchers.Main) {
                        showFeedback("Installed ${curated.name} successfully.")
                    }
                    return@launch
                }

                if (!curated.directJarUrl.isNullOrBlank()) {
                    viewModel.installFromUrl(curated.directJarUrl)
                    withContext(Dispatchers.Main) {
                        showFeedback("Downloading ${curated.name}...")
                    }
                    return@launch
                }

                val defaultRepoUrl = "https://raw.githubusercontent.com/itsmechinmoy/echo-extensions/main/jars/$safeName"
                viewModel.installFromUrl(defaultRepoUrl)
                withContext(Dispatchers.Main) {
                    showFeedback("Fetching ${curated.name} from repository...")
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showFeedback("Installation error: ${e.message}", isError = true)
                }
            }
        }
    }

    fun openExtensionsFolder() {
        runCatching {
            val destDir = platform.extensionsDir.toFile().also { it.mkdirs() }
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(destDir)
            }
        }.onFailure {
            showFeedback("Could not open folder: ${it.message}", isError = true)
        }
    }

    // Consolidated installed list
    val allInstalledList = remember(musicExtensions, lyricsExtensions, trackerExtensions, miscExtensions) {
        val list = mutableListOf<Pair<Metadata, ExtensionType>>()
        musicExtensions.forEach { list.add(it.metadata to ExtensionType.MUSIC) }
        lyricsExtensions.forEach { list.add(it.metadata to ExtensionType.LYRICS) }
        trackerExtensions.forEach { list.add(it.metadata to ExtensionType.TRACKER) }
        miscExtensions.forEach { list.add(it.metadata to ExtensionType.MISC) }
        list
    }

    val installedIds = remember(allInstalledList) {
        allInstalledList.map { it.first.id.lowercase() }.toSet()
    }

    fun isCuratedInstalled(curated: CuratedExtension): Boolean {
        val candidates = listOf(curated.id.lowercase()) +
                curated.aliases.map { it.lowercase() } +
                listOfNotNull(curated.bundledFileName?.removeSuffix(".jar")?.lowercase())
        return candidates.any { installedIds.contains(it) }
    }

    fun findCuratedMusicExtension(curated: CuratedExtension): MusicExtension? {
        return musicExtensions.firstOrNull { ext ->
            ext.id.equals(curated.id, ignoreCase = true) ||
            curated.aliases.any { ext.id.equals(it, ignoreCase = true) } ||
            (curated.bundledFileName != null && ext.id.equals(curated.bundledFileName.removeSuffix(".jar"), ignoreCase = true)) ||
            ext.metadata.name.contains(curated.name, ignoreCase = true) ||
            curated.name.contains(ext.metadata.name, ignoreCase = true)
        }
    }

    val filteredInstalled = remember(allInstalledList, selectedCategory, searchQuery) {
        allInstalledList.filter { (meta, type) ->
            val matchesCategory = when (selectedCategory) {
                ExtensionCategoryFilter.ALL -> true
                ExtensionCategoryFilter.MUSIC -> type == ExtensionType.MUSIC
                ExtensionCategoryFilter.LYRICS -> type == ExtensionType.LYRICS
                ExtensionCategoryFilter.TRACKERS -> type == ExtensionType.TRACKER
                ExtensionCategoryFilter.RADIO -> meta.id.contains("radio", ignoreCase = true) || meta.name.contains("radio", ignoreCase = true)
            }
            val q = searchQuery.trim().lowercase()
            val matchesQuery = q.isEmpty() ||
                    meta.name.lowercase().contains(q) ||
                    meta.id.lowercase().contains(q) ||
                    meta.description.lowercase().contains(q) ||
                    meta.author.lowercase().contains(q)
            matchesCategory && matchesQuery
        }
    }

    val filteredCurated = remember(selectedCategory, searchQuery) {
        CURATED_COMMUNITY_EXTENSIONS.filter { curated ->
            val matchesCategory = when (selectedCategory) {
                ExtensionCategoryFilter.ALL -> true
                ExtensionCategoryFilter.MUSIC -> curated.type == ExtensionType.MUSIC
                ExtensionCategoryFilter.LYRICS -> curated.type == ExtensionType.LYRICS
                ExtensionCategoryFilter.TRACKERS -> curated.type == ExtensionType.TRACKER
                ExtensionCategoryFilter.RADIO -> curated.id.contains("radio", ignoreCase = true)
            }
            val q = searchQuery.trim().lowercase()
            val matchesQuery = q.isEmpty() ||
                    curated.name.lowercase().contains(q) ||
                    curated.id.lowercase().contains(q) ||
                    curated.description.lowercase().contains(q) ||
                    curated.author.lowercase().contains(q) ||
                    curated.capabilities.any { it.lowercase().contains(q) }
            matchesCategory && matchesQuery
        }
    }

    // ========================================================================
    // ROOT UI LAYOUT (MONOCHROMATIC & DECENT)
    // ========================================================================

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp, vertical = 20.dp)
    ) {
        // --------------------------------------------------------------------
        // 1. MINIMALIST MONOCHROME HEADER (NO PURPLE, CLEAN & ELEGANT)
        // --------------------------------------------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Extensions",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "Manage audio sources, synchronized lyrics, scrobblers and integrations",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.70f),
                    fontSize = 13.sp
                )
            }

            // Global Actions (Decent Black & White)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
                OutlinedButton(
                    onClick = { openExtensionsFolder() },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f))
                ) {
                    Icon(Icons.Default.FolderOpen, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Open Folder", fontSize = 14.sp)
                }

                OutlinedButton(
                    onClick = { pickAndInstallFromFile() },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f))
                ) {
                    Icon(Icons.Default.UploadFile, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Install JAR", fontSize = 14.sp)
                }

                Button(
                    onClick = { showAddDialog = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Color.Black, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Add Extension", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        // --------------------------------------------------------------------
        // 2. MONOCHROME KPI TELEMETRY BAR
        // --------------------------------------------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatusKpiCard(
                title = "Primary Audio Engine",
                value = currentExtension?.name ?: "None Selected",
                subtitle = if (currentExtension != null) "Active Audio Router" else "Select a provider below",
                icon = Icons.Default.MusicNote,
                modifier = Modifier.weight(1f)
            )

            StatusKpiCard(
                title = "Lyrics Engine",
                value = if (lyricsExtensions.isNotEmpty()) lyricsExtensions.first().name else "Standard",
                subtitle = "${lyricsExtensions.size} Provider(s) Loaded",
                icon = Icons.Default.Description,
                modifier = Modifier.weight(1f)
            )

            StatusKpiCard(
                title = "Trackers & RPC",
                value = "${trackerExtensions.size + miscExtensions.size} Active",
                subtitle = "Discord RPC, Last.fm",
                icon = Icons.Default.Hub,
                modifier = Modifier.weight(1f)
            )

            StatusKpiCard(
                title = "Total Installed",
                value = "${allInstalledList.size} Extensions",
                subtitle = "In extensions folder",
                icon = Icons.Default.CheckCircle,
                modifier = Modifier.weight(1f)
            )
        }

        // --------------------------------------------------------------------
        // 3. MINIMALIST FEEDBACK BANNER
        // --------------------------------------------------------------------
        AnimatedVisibility(
            visible = statusMessage != null,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            statusMessage?.let { msg ->
                Spacer(Modifier.height(14.dp))
                LiquidGlassCard(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                if (statusIsError) Icons.Default.Warning else Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = msg,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal
                            )
                        }
                        IconButton(onClick = { statusMessage = null }, modifier = Modifier.size(24.dp)) {
                            Icon(Icons.Default.Close, contentDescription = "Dismiss", tint = Color.White.copy(alpha = 0.6f), modifier = Modifier.size(14.dp))
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        // --------------------------------------------------------------------
        // 4. TAB SELECTOR & PROPERLY SIZED SEARCH TOOLBAR
        // --------------------------------------------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Segmented Tab Switcher (Liquid Glass)
            LiquidGlassBox(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color(0x66111111),
                borderColor = Color.White.copy(alpha = 0.12f)
            ) {
                Row(modifier = Modifier.padding(3.dp)) {
                    ExtensionViewTab.entries.forEach { tab ->
                        val isSelected = selectedTab == tab
                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = if (isSelected) Color.White else Color.Transparent,
                            borderColor = if (isSelected) Color.White else Color.Transparent,
                            modifier = Modifier.clickable { selectedTab = tab }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 7.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    tab.icon,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    text = tab.title,
                                    color = Color.White,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 13.sp
                                )
                                if (tab == ExtensionViewTab.INSTALLED) {
                                    Spacer(Modifier.width(6.dp))
                                    LiquidGlassBox(
                                        shape = CircleShape,
                                        backgroundColor = if (isSelected) Color.Black.copy(alpha = 0.12f) else Color.White.copy(alpha = 0.10f),
                                        borderColor = if (isSelected) Color.Black.copy(alpha = 0.20f) else Color.White.copy(alpha = 0.15f)
                                    ) {
                                        Text(
                                            text = allInstalledList.size.toString(),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 1.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Minimalist Search Bar with clean unclipped text
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        "Search by name, provider, author...",
                        color = Color.White.copy(alpha = 0.35f),
                        fontSize = 13.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White.copy(alpha = 0.5f),
                        modifier = Modifier.size(17.dp)
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White.copy(alpha = 0.6f), modifier = Modifier.size(15.dp))
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White.copy(alpha = 0.15f),
                    focusedContainerColor = Color(0xFF101010),
                    unfocusedContainerColor = Color(0xFF101010),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier.width(340.dp)
            )
        }

        Spacer(Modifier.height(14.dp))

        // Category Filter Chips (Monochrome Decent Style)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(ExtensionCategoryFilter.entries, key = { it.name }) { cat ->
                val isSelected = selectedCategory == cat
                LiquidGlassBox(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = if (isSelected) Color.White.copy(alpha = 0.18f) else Color(0x66121212),
                    borderColor = if (isSelected) Color.White.copy(alpha = 0.50f) else Color.White.copy(alpha = 0.10f),
                    modifier = Modifier.clickable { selectedCategory = cat }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            cat.icon,
                            contentDescription = null,
                            tint = if (isSelected) Color.White else Color.White.copy(alpha = 0.55f),
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = cat.label,
                            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.65f),
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // --------------------------------------------------------------------
        // 5. MAIN CONTENT AREA
        // --------------------------------------------------------------------
        when (selectedTab) {
            ExtensionViewTab.INSTALLED -> {
                if (filteredInstalled.isEmpty()) {
                    EmptyExtensionsState(
                        searchQuery = searchQuery,
                        onClearSearch = { searchQuery = "" },
                        onExploreStore = { selectedTab = ExtensionViewTab.EXPLORE }
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(bottom = 32.dp)
                    ) {
                        items(filteredInstalled, key = { it.first.id }) { (meta, type) ->
                            val isActiveMusic = (type == ExtensionType.MUSIC && currentExtension?.id == meta.id)
                            InstalledExtensionCard(
                                metadata = meta,
                                type = type,
                                isActive = isActiveMusic,
                                onSelectAsActive = {
                                    val matched = musicExtensions.firstOrNull { it.id == meta.id }
                                    if (matched != null) {
                                        viewModel.selectExtension(matched)
                                        showFeedback("Switched active music provider to ${meta.name}")
                                    }
                                },
                                onInspect = { inspectingMetadata = meta },
                                onRequestUninstall = { pendingUninstallMetadata = meta }
                            )
                        }
                    }
                }
            }

            ExtensionViewTab.EXPLORE -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(bottom = 32.dp)
                ) {
                    // Minimalist Catalog Banner
                    item {
                        LiquidGlassCard(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(18.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(4.dp),
                                            backgroundColor = Color.White.copy(alpha = 0.12f),
                                            borderColor = Color.White.copy(alpha = 0.20f)
                                        ) {
                                            Text(
                                                "VERIFIED CATALOG",
                                                color = Color.White,
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 10.sp,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                            )
                                        }
                                        Spacer(Modifier.width(8.dp))
                                        Text(
                                            "Audix Community Extensions",
                                            style = MaterialTheme.typography.titleMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        "Install verified streaming providers, synchronized lyrics, and scrobblers in one click. Extensions run locally in JVM isolated ClassLoaders.",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = Color.White.copy(alpha = 0.55f),
                                        lineHeight = 18.sp
                                    )
                                }

                                Spacer(Modifier.width(18.dp))

                                OutlinedButton(
                                    onClick = { showAddDialog = true },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f))
                                ) {
                                    Icon(Icons.Default.Link, contentDescription = null, modifier = Modifier.size(15.dp))
                                    Spacer(Modifier.width(6.dp))
                                    Text("Custom Repo", fontSize = 13.sp)
                                }
                            }
                        }
                    }

                    // Curated Items
                    items(filteredCurated, key = { it.id }) { curated ->
                        val isInstalled = isCuratedInstalled(curated)
                        val matchedMusic = findCuratedMusicExtension(curated)
                        val isActiveMusic = (curated.type == ExtensionType.MUSIC && isInstalled && currentExtension != null &&
                                (currentExtension?.id == matchedMusic?.id || currentExtension?.id?.equals(curated.id, ignoreCase = true) == true ||
                                 curated.aliases.any { currentExtension?.id?.equals(it, ignoreCase = true) == true }))
                        CuratedExtensionCard(
                            curated = curated,
                            isInstalled = isInstalled,
                            isActive = isActiveMusic,
                            onInstall = { installFromCurated(curated) },
                            onSelectIfInstalled = {
                                if (matchedMusic != null) {
                                    viewModel.selectExtension(matchedMusic)
                                    showFeedback("Switched active streaming provider to ${curated.name}")
                                } else {
                                    showFeedback("${curated.name} is installed and active")
                                }
                            }
                        )
                    }
                }
            }
        }
    }

    // ========================================================================
    // MODALS & DIALOGS (MONOCHROMATIC & DECENT)
    // ========================================================================

    if (showAddDialog) {
        AddExtensionDialog(
            onDismiss = { showAddDialog = false },
            onInstallFromUrl = { url ->
                showAddDialog = false
                viewModel.installFromUrl(url)
                showFeedback("Fetching extension from $url...")
            },
            onPickFile = {
                showAddDialog = false
                pickAndInstallFromFile()
            }
        )
    }

    inspectingMetadata?.let { meta ->
        ExtensionDetailsDialog(
            metadata = meta,
            onDismiss = { inspectingMetadata = null }
        )
    }

    pendingUninstallMetadata?.let { meta ->
        UninstallConfirmDialog(
            metadata = meta,
            onDismiss = { pendingUninstallMetadata = null },
            onConfirm = {
                pendingUninstallMetadata = null
                viewModel.uninstall(meta)
                showFeedback("Uninstalled ${meta.name}")
            }
        )
    }
}

// ============================================================================
// KPI STATUS CARD (BLACK & WHITE)
// ============================================================================

@Composable
private fun StatusKpiCard(
    title: String,
    value: String,
    subtitle: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    LiquidGlassCard(
        shape = RoundedCornerShape(14.dp),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.White.copy(alpha = 0.08f),
                borderColor = Color.White.copy(alpha = 0.15f),
                modifier = Modifier.size(38.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                }
            }
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.70f),
                    fontSize = 12.sp
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = value,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.65f),
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

// ============================================================================
// INSTALLED EXTENSION CARD (DECENT MONOCHROME)
// ============================================================================

@Composable
private fun InstalledExtensionCard(
    metadata: Metadata,
    type: ExtensionType,
    isActive: Boolean,
    onSelectAsActive: () -> Unit,
    onInspect: () -> Unit,
    onRequestUninstall: () -> Unit
) {
    val isBuiltIn = metadata.id == "desktop_local_music" || metadata.id == "local_music" || metadata.id == "desktop_spotify" || metadata.id == "spotify"

    val iconVector = remember(metadata.id, type) {
        when {
            metadata.id.contains("saavn", ignoreCase = true) -> Icons.Default.GraphicEq
            metadata.id.contains("youtube", ignoreCase = true) -> Icons.Default.MusicNote
            metadata.id.contains("soundcloud", ignoreCase = true) -> Icons.Default.GraphicEq
            metadata.id.contains("spotify", ignoreCase = true) -> Icons.Default.Public
            metadata.id.contains("radio", ignoreCase = true) -> Icons.Default.Radio
            metadata.id.contains("lyrics", ignoreCase = true) || metadata.id.contains("lrclib", ignoreCase = true) || metadata.id.contains("genius", ignoreCase = true) -> Icons.Default.Description
            metadata.id.contains("discord", ignoreCase = true) || metadata.id.contains("lastfm", ignoreCase = true) -> Icons.Default.Hub
            type == ExtensionType.MUSIC -> Icons.Default.MusicNote
            type == ExtensionType.LYRICS -> Icons.Default.Description
            type == ExtensionType.TRACKER -> Icons.Default.Hub
            else -> Icons.Default.Extension
        }
    }

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left icon & details
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                LiquidGlassBox(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.White.copy(alpha = 0.08f),
                    borderColor = Color.White.copy(alpha = 0.15f),
                    modifier = Modifier.size(46.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            imageVector = iconVector,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }

                Spacer(Modifier.width(16.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = metadata.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 16.sp
                        )

                        Spacer(Modifier.width(8.dp))

                        // Version badge
                        LiquidGlassBox(
                            shape = RoundedCornerShape(4.dp),
                            backgroundColor = Color.White.copy(alpha = 0.08f),
                            borderColor = Color.White.copy(alpha = 0.16f)
                        ) {
                            Text(
                                text = "v${metadata.version}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White.copy(alpha = 0.85f),
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                            )
                        }

                        Spacer(Modifier.width(6.dp))

                        // Category Type badge
                        LiquidGlassBox(
                            shape = RoundedCornerShape(4.dp),
                            backgroundColor = Color.White.copy(alpha = 0.08f),
                            borderColor = Color.White.copy(alpha = 0.16f)
                        ) {
                            Text(
                                text = type.name,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White.copy(alpha = 0.85f),
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                            )
                        }

                        if (isBuiltIn) {
                            Spacer(Modifier.width(6.dp))
                            LiquidGlassBox(
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = Color.White.copy(alpha = 0.12f),
                                borderColor = Color.White.copy(alpha = 0.22f)
                            ) {
                                Text(
                                    text = "BUILT-IN",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                )
                            }
                        }

                        if (metadata.author.isNotBlank()) {
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = "by ${metadata.author}",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.65f),
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = if (metadata.description.isNotBlank()) metadata.description else "Audix modular media extension",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.75f),
                        fontSize = 13.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(Modifier.width(16.dp))

            // Action Controls (Subtle & Decent Black/White)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (type == ExtensionType.MUSIC) {
                    if (isActive) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = Color.White.copy(alpha = 0.12f),
                            borderColor = Color.White.copy(alpha = 0.30f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .background(Color.White, CircleShape)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "Active Primary",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    } else {
                        OutlinedButton(
                            onClick = onSelectAsActive,
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Set as Active", fontSize = 13.sp)
                        }
                    }
                } else {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color.White.copy(alpha = 0.08f),
                        borderColor = Color.White.copy(alpha = 0.16f)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(5.dp)
                                    .background(Color.White.copy(alpha = 0.8f), CircleShape)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text(
                                "Auto-Enabled",
                                color = Color.White.copy(alpha = 0.85f),
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onInspect,
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White.copy(alpha = 0.70f))
                ) {
                    Icon(Icons.Default.Info, contentDescription = "Inspect Details", modifier = Modifier.size(18.dp))
                }

                if (!isBuiltIn) {
                    IconButton(
                        onClick = onRequestUninstall,
                        colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White.copy(alpha = 0.60f))
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Uninstall extension", modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    }
}

// ============================================================================
// CURATED STORE / EXPLORE EXTENSION CARD (BLACK & WHITE)
// ============================================================================

@Composable
private fun CuratedExtensionCard(
    curated: CuratedExtension,
    isInstalled: Boolean,
    isActive: Boolean = false,
    onInstall: () -> Unit,
    onSelectIfInstalled: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    LiquidGlassCard(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                LiquidGlassBox(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.White.copy(alpha = 0.08f),
                    borderColor = Color.White.copy(alpha = 0.15f),
                    modifier = Modifier.size(46.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            imageVector = curated.icon,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }

                Spacer(Modifier.width(16.dp))

                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = curated.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 16.sp
                        )

                        Spacer(Modifier.width(8.dp))

                        LiquidGlassBox(
                            shape = RoundedCornerShape(4.dp),
                            backgroundColor = Color.White.copy(alpha = 0.08f),
                            borderColor = Color.White.copy(alpha = 0.16f)
                        ) {
                            Text(
                                text = "v${curated.version}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White.copy(alpha = 0.85f),
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                            )
                        }

                        Spacer(Modifier.width(6.dp))

                        Text(
                            text = "by ${curated.author}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White.copy(alpha = 0.65f),
                            fontSize = 12.sp
                        )
                    }

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = curated.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.75f),
                        fontSize = 13.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        curated.capabilities.take(3).forEach { cap ->
                            LiquidGlassBox(
                                shape = RoundedCornerShape(4.dp),
                                backgroundColor = Color.White.copy(alpha = 0.08f),
                                borderColor = Color.White.copy(alpha = 0.14f)
                            ) {
                                Text(
                                    text = cap,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White.copy(alpha = 0.80f),
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(Modifier.width(16.dp))

            if (isInstalled) {
                if (curated.type == ExtensionType.MUSIC) {
                    if (isActive) {
                        LiquidGlassBox(
                            shape = RoundedCornerShape(8.dp),
                            backgroundColor = Color.White.copy(alpha = 0.12f),
                            borderColor = Color.White.copy(alpha = 0.30f)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .background(Color.White, CircleShape)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "Active Primary",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    } else {
                        OutlinedButton(
                            onClick = onSelectIfInstalled,
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                            border = BorderStroke(1.dp, Color.White.copy(alpha = 0.25f)),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Set as Active", fontSize = 13.sp)
                        }
                    }
                } else {
                    LiquidGlassBox(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = Color.White.copy(alpha = 0.08f),
                        borderColor = Color.White.copy(alpha = 0.16f),
                        modifier = Modifier.clickable { onSelectIfInstalled() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                            Spacer(Modifier.width(6.dp))
                            Text(
                                "Installed & Active",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            } else {
                Button(
                    onClick = onInstall,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                ) {
                    Icon(Icons.Default.Download, contentDescription = null, tint = Color.Black, modifier = Modifier.size(15.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Install", fontWeight = FontWeight.Bold, fontSize = 13.sp)
                }
            }
        }
    }
}

// ============================================================================
// EMPTY STATE (BLACK & WHITE)
// ============================================================================

@Composable
private fun EmptyExtensionsState(
    searchQuery: String,
    onClearSearch: () -> Unit,
    onExploreStore: () -> Unit
) {
    LiquidGlassCard(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp)
    ) {
        Column(
            modifier = Modifier.padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LiquidGlassBox(
                shape = CircleShape,
                backgroundColor = Color.White.copy(alpha = 0.08f),
                borderColor = Color.White.copy(alpha = 0.15f),
                modifier = Modifier.size(50.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Icon(
                        Icons.Default.Extension,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = if (searchQuery.isNotEmpty()) "No matching extensions found" else "No extensions installed in this category",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 17.sp
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = if (searchQuery.isNotEmpty())
                    "No results found for \"$searchQuery\". Try checking the spelling or browse the Community Catalog."
                else
                    "You haven't installed any extensions matching this category yet. Explore the community store to discover verified streaming engines.",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.70f),
                fontSize = 13.sp,
                modifier = Modifier.width(440.dp)
            )

            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                if (searchQuery.isNotEmpty()) {
                    OutlinedButton(
                        onClick = onClearSearch,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f))
                    ) {
                        Text("Clear Search", fontSize = 13.sp)
                    }
                }
                Button(
                    onClick = onExploreStore,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(Icons.Default.Explore, contentDescription = null, tint = Color.Black, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Explore Community Catalog", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

// ============================================================================
// DIALOG 1: ADD EXTENSION DIALOG (BLACK & WHITE)
// ============================================================================

@Composable
private fun AddExtensionDialog(
    onDismiss: () -> Unit,
    onInstallFromUrl: (String) -> Unit,
    onPickFile: () -> Unit
) {
    var urlInput by remember { mutableStateOf("") }
    var inputError by remember { mutableStateOf<String?>(null) }

    val officialRepoUrl = "https://raw.githubusercontent.com/itsmechinmoy/echo-extensions/main/echo_extensions.json"

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text("Add Audix Extension", fontWeight = FontWeight.Bold, color = Color.White)
            }
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Install custom streaming sources or lyrics engines by entering a repository URL, shortcode, direct HTTPS JAR link, or picking a local JAR file.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.75f),
                    fontSize = 13.sp,
                    lineHeight = 19.sp
                )

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = urlInput,
                    onValueChange = {
                        urlInput = it
                        inputError = null
                    },
                    label = { Text("Extension URL or Shortcode", fontSize = 13.sp) },
                    placeholder = { Text("Type 'extension' or paste HTTPS link", fontSize = 13.sp) },
                    singleLine = true,
                    isError = inputError != null,
                    supportingText = {
                        if (inputError != null) {
                            Text(inputError ?: "", color = Color.White, fontSize = 12.sp)
                        } else {
                            Text("Shortcode 'extension' connects to official verified repository.", color = Color.White.copy(alpha = 0.65f), fontSize = 12.sp)
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White.copy(alpha = 0.2f),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = { urlInput = "extension" },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Use 'extension'", fontSize = 12.sp)
                    }

                    OutlinedButton(
                        onClick = { urlInput = officialRepoUrl },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Official Repo", fontSize = 12.sp)
                    }
                }

                Spacer(Modifier.height(16.dp))

                HorizontalDivider(color = Color.White.copy(alpha = 0.12f))

                Spacer(Modifier.height(16.dp))

                OutlinedButton(
                    onClick = onPickFile,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.22f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.FolderOpen, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Select Local JAR File (.jar)...", fontSize = 13.sp)
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val trimmed = urlInput.trim()
                    if (trimmed.isEmpty()) {
                        inputError = "Please enter a URL or shortcode"
                    } else {
                        onInstallFromUrl(trimmed)
                    }
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Install", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = Color.White.copy(alpha = 0.75f), fontSize = 13.sp)
            }
        },
        containerColor = Color(0xFF141414),
        shape = RoundedCornerShape(14.dp)
    )
}

// ============================================================================
// DIALOG 2: EXTENSION DETAILS INSPECTOR (BLACK & WHITE)
// ============================================================================

@Composable
private fun ExtensionDetailsDialog(
    metadata: Metadata,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Info, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text("Extension Package Specs", fontWeight = FontWeight.Bold, color = Color.White)
            }
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DetailSpecRow(label = "Extension Name", value = metadata.name)
                DetailSpecRow(label = "Package Identifier", value = metadata.id)
                DetailSpecRow(label = "Installed Version", value = "v${metadata.version}")
                DetailSpecRow(label = "Category Type", value = metadata.type.name)
                DetailSpecRow(label = "Author / Maintainer", value = if (metadata.author.isNotBlank()) metadata.author else "Community")
                DetailSpecRow(label = "Entry Class", value = metadata.className)
                DetailSpecRow(label = "JAR Location", value = metadata.path)

                if (metadata.description.isNotBlank()) {
                    Spacer(Modifier.height(4.dp))
                    Text("Description:", fontWeight = FontWeight.Bold, color = Color.White, fontSize = 13.sp)
                    Text(
                        metadata.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.75f),
                        fontSize = 13.sp,
                        lineHeight = 19.sp
                    )
                }

                Spacer(Modifier.height(6.dp))

                LiquidGlassBox(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.White.copy(alpha = 0.08f),
                    borderColor = Color.White.copy(alpha = 0.16f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Verified JVM Extension • Isolated ClassLoader",
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Close", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
        },
        containerColor = Color(0xFF141414),
        shape = RoundedCornerShape(14.dp)
    )
}

@Composable
private fun DetailSpecRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, color = Color.White.copy(alpha = 0.70f), fontSize = 13.sp)
        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 13.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

// ============================================================================
// DIALOG 3: UNINSTALL CONFIRMATION (BLACK & WHITE)
// ============================================================================

@Composable
private fun UninstallConfirmDialog(
    metadata: Metadata,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Warning, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                Text("Uninstall Extension?", fontWeight = FontWeight.Bold, color = Color.White)
            }
        },
        text = {
            Text(
                "Are you sure you want to remove '${metadata.name}' (v${metadata.version})? The corresponding JAR file will be deleted from your extensions directory.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 14.sp,
                lineHeight = 22.sp
            )
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Uninstall", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = Color.White.copy(alpha = 0.75f), fontSize = 13.sp)
            }
        },
        containerColor = Color(0xFF141414),
        shape = RoundedCornerShape(14.dp)
    )
}
