package dev.brahmkshatriya.echo.desktop.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.ai.AiGeneratedPlaylist
import dev.brahmkshatriya.echo.desktop.ai.AudixAiService
import dev.brahmkshatriya.echo.desktop.ai.TastePersonaProfile
import dev.brahmkshatriya.echo.desktop.ai.TrackAiInsight
import dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

enum class AiStudioTab(val title: String) {
    PLAYLIST_GENERATOR("Prompt to Playlist"),
    TRACK_INTELLIGENCE("AI DJ & Track Lore"),
    TASTE_RADAR("Vibe & Persona Radar")
}

@Composable
fun AiStudioScreen(
    playerViewModel: PlayerViewModel = koinInject(),
    settings: EchoSettings? = runCatching { koinInject<EchoSettings>() }.getOrNull(),
    extensionManager: ExtensionManager? = runCatching { koinInject<ExtensionManager>() }.getOrNull()
) {
    var activeTab by remember { mutableStateOf(AiStudioTab.PLAYLIST_GENERATOR) }
    val scope = rememberCoroutineScope()

    // Playlist generator state
    var promptInput by remember { mutableStateOf("") }
    var isGenerating by remember { mutableStateOf(false) }
    var generatedPlaylist by remember { mutableStateOf<AiGeneratedPlaylist?>(null) }
    var isPlaylistSaved by remember { mutableStateOf(false) }

    // Track intelligence state
    val currentTrack by playerViewModel.currentTrack.collectAsState()
    var trackInsight by remember { mutableStateOf<TrackAiInsight?>(null) }
    var isAnalyzingTrack by remember { mutableStateOf(false) }

    // Taste persona state
    val queue by playerViewModel.queue.collectAsState()
    var tastePersona by remember { mutableStateOf<TastePersonaProfile?>(null) }

    val apiKey = remember(settings) { AudixAiService.getApiKey(settings) }
    val selectedModel = remember(settings) { AudixAiService.getSelectedModel(settings) }

    // Auto-analyze current track when switching to Track Lore tab
    LaunchedEffect(currentTrack, activeTab) {
        if (activeTab == AiStudioTab.TRACK_INTELLIGENCE && currentTrack != null) {
            isAnalyzingTrack = true
            trackInsight = AudixAiService.analyzeTrack(currentTrack!!, settings)
            isAnalyzingTrack = false
        } else if (activeTab == AiStudioTab.TASTE_RADAR) {
            tastePersona = AudixAiService.computeTastePersona(currentTrack, queue)
        }
    }

    val inspirationChips = listOf(
        "⚡ Late Night Cyberpunk & Synthwave",
        "☕ Rainy Coffeehouse Acoustic",
        "🔥 High-Octane Gym Workout",
        "💖 Bollywood Sufi Romance",
        "🎧 Midnight Lofi Focus",
        "🎷 Retro 80s City Pop & Funk"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 18.dp)
    ) {
        // -----------------------------------------------------------------------------------------
        // HEADER: AUDIX INTELLIGENCE HERO MASTHEAD
        // -----------------------------------------------------------------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFF06B6D4), Color(0xFFA855F7), Color(0xFFEC4899))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.AutoAwesome,
                            contentDescription = "AI Studio",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(
                        text = "Audix Intelligence Studio",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold,
                            letterSpacing = (-0.5).sp
                        ),
                        color = Color.White
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Next-generation generative playlists, real-time AI DJ commentary, and acoustic DNA intelligence",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.70f)
                )
            }

            // Connection Badge
            LiquidGlassBox(
                shape = RoundedCornerShape(12.dp),
                backgroundColor = if (apiKey.isNotBlank()) Color(0xFF10B981).copy(alpha = 0.18f) else Color.White.copy(alpha = 0.08f),
                borderColor = if (apiKey.isNotBlank()) Color(0xFF10B981).copy(alpha = 0.50f) else Color.White.copy(alpha = 0.18f),
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .clip(CircleShape)
                            .background(if (apiKey.isNotBlank()) Color(0xFF10B981) else Color(0xFF38BDF8))
                    )
                    Text(
                        text = if (apiKey.isNotBlank()) "Gemini AI Engine: Active" else "Autonomous Studio Engine: Ready",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(Modifier.height(18.dp))

        // -----------------------------------------------------------------------------------------
        // NAVIGATION SEGMENTED TABS
        // -----------------------------------------------------------------------------------------
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AiStudioTab.entries.forEach { tab ->
                val isSelected = activeTab == tab
                LiquidGlassBox(
                    shape = RoundedCornerShape(10.dp),
                    backgroundColor = if (isSelected) Color.White.copy(alpha = 0.22f) else Color.White.copy(alpha = 0.05f),
                    borderColor = if (isSelected) Color.White.copy(alpha = 0.70f) else Color.White.copy(alpha = 0.12f),
                    modifier = Modifier
                        .pointerHoverIcon(PointerIcon.Hand)
                        .clickable { activeTab = tab }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        val tabIcon = when (tab) {
                            AiStudioTab.PLAYLIST_GENERATOR -> Icons.Default.AutoAwesome
                            AiStudioTab.TRACK_INTELLIGENCE -> Icons.Default.GraphicEq
                            AiStudioTab.TASTE_RADAR -> Icons.Default.Speed
                        }
                        Icon(
                            imageVector = tabIcon,
                            contentDescription = null,
                            tint = if (isSelected) Color.White else Color.White.copy(alpha = 0.70f),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = tab.title,
                            fontSize = 13.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.70f)
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // -----------------------------------------------------------------------------------------
        // TAB 1: PROMPT-TO-PLAYLIST GENERATOR
        // -----------------------------------------------------------------------------------------
        if (activeTab == AiStudioTab.PLAYLIST_GENERATOR) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Prompt Input Box
                item {
                    LiquidGlassCard(
                        shape = RoundedCornerShape(18.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Text(
                                text = "What would you like to listen to?",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(Modifier.height(10.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFF05070D).copy(alpha = 0.60f))
                                    .border(1.dp, Color.White.copy(alpha = 0.15f), RoundedCornerShape(12.dp))
                                    .padding(horizontal = 14.dp, vertical = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                BasicTextField(
                                    value = promptInput,
                                    onValueChange = { promptInput = it },
                                    textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 14.5.sp,
                                        fontWeight = FontWeight.Normal
                                    ),
                                    cursorBrush = SolidColor(Color.White),
                                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
                                    keyboardActions = KeyboardActions(onGo = {
                                        if (promptInput.isNotBlank() && !isGenerating) {
                                            scope.launch {
                                                isGenerating = true
                                                isPlaylistSaved = false
                                                generatedPlaylist = AudixAiService.generatePlaylistFromPrompt(promptInput, settings, extensionManager)
                                                isGenerating = false
                                            }
                                        }
                                    }),
                                    modifier = Modifier.weight(1f),
                                    decorationBox = { innerTextField ->
                                        if (promptInput.isEmpty()) {
                                            Text(
                                                text = "e.g., 'Rainy midnight cyberpunk with dark analog synth bass' or 'Upbeat 90s indie rock workout'...",
                                                color = Color.White.copy(alpha = 0.40f),
                                                fontSize = 14.5.sp
                                            )
                                        }
                                        innerTextField()
                                    }
                                )

                                Spacer(Modifier.width(10.dp))

                                // Generate Action Button
                                LiquidGlassBox(
                                    shape = RoundedCornerShape(10.dp),
                                    backgroundColor = Color.White.copy(alpha = 0.20f),
                                    borderColor = Color.White.copy(alpha = 0.70f),
                                    modifier = Modifier
                                        .pointerHoverIcon(PointerIcon.Hand)
                                        .clickable {
                                            if (promptInput.isNotBlank() && !isGenerating) {
                                                scope.launch {
                                                    isGenerating = true
                                                    isPlaylistSaved = false
                                                    generatedPlaylist = AudixAiService.generatePlaylistFromPrompt(promptInput, settings, extensionManager)
                                                    isGenerating = false
                                                }
                                            }
                                        }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        if (isGenerating) {
                                            CircularProgressIndicator(
                                                modifier = Modifier.size(16.dp),
                                                color = Color.White,
                                                strokeWidth = 2.dp
                                            )
                                        } else {
                                            Icon(
                                                imageVector = Icons.Default.AutoAwesome,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                        Text(
                                            text = if (isGenerating) "Curating..." else "Generate Playlist",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = Color.White
                                        )
                                    }
                                }
                            }

                            Spacer(Modifier.height(14.dp))

                            // Inspiration Vibe Chips
                            Text(
                                text = "Instant Vibe Inspiration:",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White.copy(alpha = 0.60f)
                            )
                            Spacer(Modifier.height(8.dp))
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                items(inspirationChips) { chipText ->
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(8.dp),
                                        backgroundColor = Color.White.copy(alpha = 0.06f),
                                        borderColor = Color.White.copy(alpha = 0.15f),
                                        modifier = Modifier
                                            .pointerHoverIcon(PointerIcon.Hand)
                                            .clickable {
                                                promptInput = chipText.substringAfter(" ")
                                                scope.launch {
                                                    isGenerating = true
                                                    isPlaylistSaved = false
                                                    generatedPlaylist = AudixAiService.generatePlaylistFromPrompt(promptInput, settings, extensionManager)
                                                    isGenerating = false
                                                }
                                            }
                                    ) {
                                        Text(
                                            text = chipText,
                                            fontSize = 11.5.sp,
                                            color = Color.White.copy(alpha = 0.85f),
                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Generated Playlist Results
                if (generatedPlaylist != null) {
                    val pl = generatedPlaylist!!
                    item {
                        LiquidGlassCard(
                            shape = RoundedCornerShape(18.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(20.dp)) {
                                // Playlist Header Banner
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                                    ) {
                                        // Visualizer Gradient Icon
                                        Box(
                                            modifier = Modifier
                                                .size(72.dp)
                                                .clip(RoundedCornerShape(16.dp))
                                                .background(Brush.linearGradient(pl.gradientColors)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.MusicNote,
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(36.dp)
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = pl.title,
                                                fontSize = 22.sp,
                                                fontWeight = FontWeight.ExtraBold,
                                                color = Color.White
                                            )
                                            Spacer(Modifier.height(4.dp))
                                            Text(
                                                text = pl.description,
                                                fontSize = 12.5.sp,
                                                color = Color.White.copy(alpha = 0.75f),
                                                maxLines = 2,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Spacer(Modifier.height(6.dp))
                                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                                pl.tags.take(4).forEach { tag ->
                                                    Box(
                                                        modifier = Modifier
                                                            .clip(RoundedCornerShape(6.dp))
                                                            .background(Color.White.copy(alpha = 0.12f))
                                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                                    ) {
                                                        Text(
                                                            text = "#$tag",
                                                            fontSize = 10.sp,
                                                            fontWeight = FontWeight.Medium,
                                                            color = Color.White.copy(alpha = 0.85f)
                                                        )
                                                    }
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .clip(RoundedCornerShape(6.dp))
                                                        .background(Color(0xFF38BDF8).copy(alpha = 0.15f))
                                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                                ) {
                                                    Text(
                                                        text = "⚡ ${pl.energyLevel}",
                                                        fontSize = 10.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color(0xFF38BDF8)
                                                    )
                                                }
                                            }
                                        }
                                    }

                                    // Action Buttons
                                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                        // Save to Library Button
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(10.dp),
                                            backgroundColor = if (isPlaylistSaved) Color(0xFF10B981).copy(alpha = 0.20f) else Color.White.copy(alpha = 0.10f),
                                            borderColor = if (isPlaylistSaved) Color(0xFF10B981).copy(alpha = 0.60f) else Color.White.copy(alpha = 0.25f),
                                            modifier = Modifier
                                                .pointerHoverIcon(PointerIcon.Hand)
                                                .clickable {
                                                    if (!isPlaylistSaved && pl.tracks.isNotEmpty()) {
                                                        val lib = DesktopLibraryManager.getInstance()
                                                        lib.saveImportedPlaylist(pl.title, pl.description, pl.tracks)
                                                        isPlaylistSaved = true
                                                    }
                                                }
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                                            ) {
                                                Icon(
                                                    imageVector = if (isPlaylistSaved) Icons.Default.Check else Icons.Default.BookmarkBorder,
                                                    contentDescription = null,
                                                    tint = Color.White,
                                                    modifier = Modifier.size(16.dp)
                                                )
                                                Text(
                                                    text = if (isPlaylistSaved) "Saved to Library" else "Save Playlist",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 12.sp,
                                                    color = Color.White
                                                )
                                            }
                                        }

                                        // Play All Button
                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(10.dp),
                                            backgroundColor = Color.White,
                                            borderColor = Color.White,
                                            modifier = Modifier
                                                .pointerHoverIcon(PointerIcon.Hand)
                                                .clickable {
                                                    if (pl.tracks.isNotEmpty()) {
                                                        playerViewModel.playWithQueue(pl.tracks.first(), pl.tracks)
                                                    }
                                                }
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                                            ) {
                                                Icon(
                                                    imageVector = Icons.Default.PlayArrow,
                                                    contentDescription = "Play All",
                                                    tint = Color.Black,
                                                    modifier = Modifier.size(18.dp)
                                                )
                                                Text(
                                                    text = "Play AI Playlist (${pl.tracks.size})",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 12.5.sp,
                                                    color = Color.Black
                                                )
                                            }
                                        }
                                    }
                                }

                                Spacer(Modifier.height(18.dp))

                                // Tracklist
                                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                    pl.tracks.forEachIndexed { index, track ->
                                        val coverUrl = when (val c = track.cover) {
                                            is ImageHolder.NetworkRequestImageHolder -> c.request.url
                                            is ImageHolder.ResourceUriImageHolder -> c.uri
                                            else -> null
                                        }

                                        LiquidGlassBox(
                                            shape = RoundedCornerShape(10.dp),
                                            backgroundColor = Color.White.copy(alpha = 0.04f),
                                            borderColor = Color.White.copy(alpha = 0.08f),
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .pointerHoverIcon(PointerIcon.Hand)
                                                .clickable {
                                                    playerViewModel.playWithQueue(track, pl.tracks)
                                                }
                                        ) {
                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "${index + 1}",
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White.copy(alpha = 0.50f),
                                                    modifier = Modifier.width(28.dp)
                                                )

                                                // Cover
                                                Box(
                                                    modifier = Modifier
                                                        .size(38.dp)
                                                        .clip(RoundedCornerShape(6.dp))
                                                        .background(Color.White.copy(alpha = 0.08f)),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    if (coverUrl != null) {
                                                        AsyncImage(
                                                            model = coverUrl,
                                                            contentDescription = track.title,
                                                            modifier = Modifier.fillMaxSize(),
                                                            contentScale = ContentScale.Crop
                                                        )
                                                    } else {
                                                        Icon(Icons.Default.MusicNote, null, tint = Color.White.copy(alpha = 0.40f), modifier = Modifier.size(18.dp))
                                                    }
                                                }

                                                Spacer(Modifier.width(12.dp))

                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text(
                                                        text = track.title,
                                                        fontSize = 13.5.sp,
                                                        fontWeight = FontWeight.SemiBold,
                                                        color = Color.White,
                                                        maxLines = 1,
                                                        overflow = TextOverflow.Ellipsis
                                                    )
                                                    Text(
                                                        text = track.artists.joinToString(", ") { it.name }.ifBlank { "Audix Artist" },
                                                        fontSize = 11.5.sp,
                                                        color = Color.White.copy(alpha = 0.65f),
                                                        maxLines = 1,
                                                        overflow = TextOverflow.Ellipsis
                                                    )
                                                }

                                                val durMs = track.duration ?: 0L
                                                val durMin = durMs / 60000L
                                                val durSec = (durMs % 60000L) / 1000L
                                                Text(
                                                    text = if (durMs > 0L) String.format("%d:%02d", durMin, durSec) else "--:--",
                                                    fontSize = 11.5.sp,
                                                    color = Color.White.copy(alpha = 0.50f)
                                                )

                                                Spacer(Modifier.width(12.dp))

                                                Icon(
                                                    imageVector = Icons.Default.PlayArrow,
                                                    contentDescription = "Play",
                                                    tint = Color.White,
                                                    modifier = Modifier.size(18.dp)
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
        }

        // -----------------------------------------------------------------------------------------
        // TAB 2: AI DJ & TRACK LORE
        // -----------------------------------------------------------------------------------------
        if (activeTab == AiStudioTab.TRACK_INTELLIGENCE) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    val activeTrack = currentTrack
                    if (activeTrack == null) {
                        LiquidGlassCard(
                            shape = RoundedCornerShape(18.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(40.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Default.GraphicEq,
                                    contentDescription = null,
                                    tint = Color.White.copy(alpha = 0.40f),
                                    modifier = Modifier.size(48.dp)
                                )
                                Spacer(Modifier.height(12.dp))
                                Text(
                                    text = "No Track Currently Playing",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Play any song from Home, Search, or Library to unlock deep AI lore, lyrical breakdown, and DJ commentary.",
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.60f)
                                )
                            }
                        }
                    } else {
                        // Track Intelligence Card
                        LiquidGlassCard(
                            shape = RoundedCornerShape(18.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(20.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                                    ) {
                                        val coverUrl = when (val c = activeTrack.cover) {
                                            is ImageHolder.NetworkRequestImageHolder -> c.request.url
                                            is ImageHolder.ResourceUriImageHolder -> c.uri
                                            else -> null
                                        }

                                        Box(
                                            modifier = Modifier
                                                .size(54.dp)
                                                .clip(RoundedCornerShape(12.dp))
                                                .background(Color.White.copy(alpha = 0.08f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            if (coverUrl != null) {
                                                AsyncImage(
                                                    model = coverUrl,
                                                    contentDescription = activeTrack.title,
                                                    modifier = Modifier.fillMaxSize(),
                                                    contentScale = ContentScale.Crop
                                                )
                                            } else {
                                                Icon(Icons.Default.MusicNote, null, tint = Color.White, modifier = Modifier.size(24.dp))
                                            }
                                        }

                                        Column {
                                            Text(
                                                text = activeTrack.title,
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                            Text(
                                                text = activeTrack.artists.joinToString(", ") { it.name }.ifBlank { "Audix Artist" },
                                                fontSize = 13.sp,
                                                color = Color.White.copy(alpha = 0.70f)
                                            )
                                        }
                                    }

                                    // Refresh analysis button
                                    LiquidGlassBox(
                                        shape = RoundedCornerShape(10.dp),
                                        backgroundColor = Color.White.copy(alpha = 0.08f),
                                        borderColor = Color.White.copy(alpha = 0.18f),
                                        modifier = Modifier
                                            .pointerHoverIcon(PointerIcon.Hand)
                                            .clickable {
                                                scope.launch {
                                                    isAnalyzingTrack = true
                                                    trackInsight = AudixAiService.analyzeTrack(activeTrack, settings)
                                                    isAnalyzingTrack = false
                                                }
                                            }
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            Icon(Icons.Default.Refresh, null, tint = Color.White, modifier = Modifier.size(14.dp))
                                            Text("Refresh Insight", fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                        }
                                    }
                                }

                                Spacer(Modifier.height(20.dp))

                                if (isAnalyzingTrack) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(30.dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp, modifier = Modifier.size(22.dp))
                                        Spacer(Modifier.width(12.dp))
                                        Text("Synthesizing audio DNA & lyrical themes with AI...", fontSize = 13.sp, color = Color.White)
                                    }
                                } else if (trackInsight != null) {
                                    val ins = trackInsight!!

                                    // DJ Voice Commentary Card
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(12.dp))
                                            .background(
                                                Brush.linearGradient(
                                                    listOf(Color(0xFF06B6D4).copy(alpha = 0.15f), Color(0xFFA855F7).copy(alpha = 0.15f))
                                                )
                                            )
                                            .border(1.dp, Color(0xFF06B6D4).copy(alpha = 0.35f), RoundedCornerShape(12.dp))
                                            .padding(14.dp)
                                    ) {
                                        Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                            Icon(
                                                imageVector = Icons.Default.Psychology,
                                                contentDescription = null,
                                                tint = Color(0xFF06B6D4),
                                                modifier = Modifier.size(22.dp)
                                            )
                                            Column {
                                                Text(
                                                    text = "AUDIX AI DJ COMMENTARY",
                                                    fontSize = 10.5.sp,
                                                    fontWeight = FontWeight.ExtraBold,
                                                    letterSpacing = 0.5.sp,
                                                    color = Color(0xFF38BDF8)
                                                )
                                                Spacer(Modifier.height(4.dp))
                                                Text(
                                                    text = "\"${ins.djCommentary}\"",
                                                    fontSize = 13.5.sp,
                                                    fontWeight = FontWeight.Medium,
                                                    color = Color.White,
                                                    lineHeight = 18.sp
                                                )
                                            }
                                        }
                                    }

                                    Spacer(Modifier.height(16.dp))

                                    // Lyrical Meaning & Song Story
                                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                                        // Story
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(12.dp))
                                                .background(Color.White.copy(alpha = 0.05f))
                                                .border(1.dp, Color.White.copy(alpha = 0.12f), RoundedCornerShape(12.dp))
                                                .padding(14.dp)
                                        ) {
                                            Column {
                                                Text("The Story Behind The Track", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                                                Spacer(Modifier.height(6.dp))
                                                Text(ins.story, fontSize = 12.5.sp, color = Color.White.copy(alpha = 0.85f), lineHeight = 17.sp)
                                            }
                                        }

                                        // Lyrical Meaning
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(12.dp))
                                                .background(Color.White.copy(alpha = 0.05f))
                                                .border(1.dp, Color.White.copy(alpha = 0.12f), RoundedCornerShape(12.dp))
                                                .padding(14.dp)
                                        ) {
                                            Column {
                                                Text("Lyrical Themes & Metaphor", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA855F7))
                                                Spacer(Modifier.height(6.dp))
                                                Text(ins.lyricalMeaning, fontSize = 12.5.sp, color = Color.White.copy(alpha = 0.85f), lineHeight = 17.sp)
                                            }
                                        }
                                    }

                                    Spacer(Modifier.height(14.dp))

                                    // Acoustic DNA Spec Pills
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        // Estimated Key
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Color.White.copy(alpha = 0.05f))
                                                .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(10.dp))
                                                .padding(10.dp)
                                        ) {
                                            Column {
                                                Text("ESTIMATED KEY", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.50f))
                                                Spacer(Modifier.height(2.dp))
                                                Text(ins.estimatedKey, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                            }
                                        }

                                        // Estimated BPM
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Color.White.copy(alpha = 0.05f))
                                                .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(10.dp))
                                                .padding(10.dp)
                                        ) {
                                            Column {
                                                Text("TEMPO", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.50f))
                                                Spacer(Modifier.height(2.dp))
                                                Text("${ins.estimatedBpm} BPM", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                            }
                                        }

                                        // Mood Tags
                                        Box(
                                            modifier = Modifier
                                                .weight(1.5f)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Color.White.copy(alpha = 0.05f))
                                                .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(10.dp))
                                                .padding(10.dp)
                                        ) {
                                            Column {
                                                Text("ACOUSTIC MOOD", fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.50f))
                                                Spacer(Modifier.height(2.dp))
                                                Text(ins.moodTags.joinToString(" • "), fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
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

        // -----------------------------------------------------------------------------------------
        // TAB 3: TASTE & PERSONA RADAR
        // -----------------------------------------------------------------------------------------
        if (activeTab == AiStudioTab.TASTE_RADAR) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    val p = tastePersona
                    if (p != null) {
                        LiquidGlassCard(
                            shape = RoundedCornerShape(18.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(22.dp)) {
                                Text(
                                    text = "Your Acoustic Persona Profile",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 0.8.sp,
                                    color = Color(0xFF38BDF8)
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = p.personaName,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                                Spacer(Modifier.height(6.dp))
                                Text(
                                    text = p.headline,
                                    fontSize = 13.5.sp,
                                    color = Color.White.copy(alpha = 0.80f),
                                    lineHeight = 18.sp
                                )

                                Spacer(Modifier.height(22.dp))

                                // Visual Spectrum Progress Bars
                                Text(
                                    text = "Active Session Audio Spectrum:",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Spacer(Modifier.height(12.dp))

                                val dimensions = listOf(
                                    Triple("Energy & Drive", p.energyScore, Color(0xFFEF4444)),
                                    Triple("Warmth & Acoustic Resonance", p.warmthScore, Color(0xFFF59E0B)),
                                    Triple("Rhythm & Syncopated Groove", p.grooveScore, Color(0xFF10B981)),
                                    Triple("Melodic Euphoria", p.euphoriaScore, Color(0xFF06B6D4)),
                                    Triple("Atmospheric Ambient Space", p.ambientScore, Color(0xFFA855F7))
                                )

                                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                    dimensions.forEach { (label, score, color) ->
                                        Column {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(label, fontSize = 12.sp, color = Color.White.copy(alpha = 0.85f))
                                                Text("${(score * 100).toInt()}%", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = color)
                                            }
                                            Spacer(Modifier.height(4.dp))
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(6.dp)
                                                    .clip(RoundedCornerShape(3.dp))
                                                    .background(Color.White.copy(alpha = 0.10f))
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxHeight()
                                                        .fillMaxWidth(score)
                                                        .clip(RoundedCornerShape(3.dp))
                                                        .background(color)
                                                )
                                            }
                                        }
                                    }
                                }

                                Spacer(Modifier.height(22.dp))

                                // AI Recommendation
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color.White.copy(alpha = 0.05f))
                                        .border(1.dp, Color.White.copy(alpha = 0.12f), RoundedCornerShape(12.dp))
                                        .padding(14.dp)
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                        Icon(Icons.Default.Tune, null, tint = Color(0xFF38BDF8), modifier = Modifier.size(20.dp))
                                        Column {
                                            Text("RECOMMENDED SONIC LEAP", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                                            Text(
                                                "Based on your current harmonic curve, dive into: ${p.recommendedNextGenre}",
                                                fontSize = 12.5.sp,
                                                fontWeight = FontWeight.Medium,
                                                color = Color.White
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
    }
}
