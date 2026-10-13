package dev.brahmkshatriya.echo.desktop.ui.screensaver

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeDown
import androidx.compose.material.icons.automirrored.filled.VolumeMute
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.ui.screens.LiquidGlassBox
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel
import kotlinx.coroutines.delay
import org.koin.compose.koinInject
import java.io.File
import java.time.LocalDateTime
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private var cachedDefaultScreensaverBitmap: ImageBitmap? = null

private fun loadScreensaverDefaultBitmap(): ImageBitmap? {
    if (cachedDefaultScreensaverBitmap != null) return cachedDefaultScreensaverBitmap
    return runCatching {
        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/screensaver_bg.jpg")
            ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "screensaver_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("desktopApp", "src", "desktopMain", "resources", "images", "screensaver_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("desktopApp", "build", "compose", "binaries", "main", "app", "Audix", "app", "resources", "images", "screensaver_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.io.File("app/resources/images/screensaver_bg.jpg").takeIf { it.exists() }?.inputStream()
            ?: java.io.File("resources/images/screensaver_bg.jpg").takeIf { it.exists() }?.inputStream()
        stream?.use { loadImageBitmap(it) }
    }.getOrNull()?.also { cachedDefaultScreensaverBitmap = it }
}

private var cachedCosmicClockDialBitmap: ImageBitmap? = null

private fun loadCosmicClockDialBitmap(): ImageBitmap? {
    if (cachedCosmicClockDialBitmap != null) return cachedCosmicClockDialBitmap
    return runCatching {
        val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/cosmic_clock_dial.png")
            ?: java.nio.file.Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "cosmic_clock_dial.png").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("desktopApp", "src", "desktopMain", "resources", "images", "cosmic_clock_dial.png").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.nio.file.Paths.get("desktopApp", "build", "compose", "binaries", "main", "app", "Audix", "app", "resources", "images", "cosmic_clock_dial.png").toFile().takeIf { it.exists() }?.inputStream()
            ?: java.io.File("app/resources/images/cosmic_clock_dial.png").takeIf { it.exists() }?.inputStream()
            ?: java.io.File("resources/images/cosmic_clock_dial.png").takeIf { it.exists() }?.inputStream()
        stream?.use { loadImageBitmap(it) }
    }.getOrNull()?.also { cachedCosmicClockDialBitmap = it }
}

/**
 * Authentic Apple iOS Music Screensaver on 3D Album Mosaic Backdrop.
 * Combines the high-resolution 3D Album Art Mosaic background wallpaper with the
 * pixel-perfect Apple iOS Now Playing lock-screen music player widget, and the signature
 * Cosmic Gravitational Lensing Clock in the top-right corner.
 */
@Composable
fun EchoScreensaver(
    playerViewModel: PlayerViewModel,
    onWakeUp: () -> Unit,
    modifier: Modifier = Modifier,
    screensaverActivatedAt: Long = 0L,
    settings: EchoSettings? = null
) {
    val resolvedSettings = settings ?: runCatching { koinInject<EchoSettings>() }.getOrNull()

    val bgMode = remember(resolvedSettings) {
        resolvedSettings?.getString("screensaver_bg_mode", "default") ?: "default"
    }
    val bgCustomPath = remember(resolvedSettings) {
        resolvedSettings?.getString("screensaver_bg_custom_path", "") ?: ""
    }
    val bgOpacityPercent = remember(resolvedSettings) {
        resolvedSettings?.getInt("screensaver_bg_opacity", 45) ?: 45
    }
    val bgAlpha = (bgOpacityPercent / 100f).coerceIn(0.05f, 1.0f)

    // Player state
    val currentTrack by playerViewModel.currentTrack.collectAsState()
    val isPlaying by playerViewModel.isPlaying.collectAsState()
    val positionMs by playerViewModel.positionMs.collectAsState()
    val durationMs by playerViewModel.durationMs.collectAsState()
    val volume by playerViewModel.volume.collectAsState()

    // Extract cover artwork URL safely
    val coverUrl = remember(currentTrack) {
        when (val cover = currentTrack?.cover) {
            is ImageHolder.NetworkRequestImageHolder -> cover.request.url
            is ImageHolder.ResourceUriImageHolder -> cover.uri
            else -> null
        }
    }

    val defaultScreensaverBitmap = remember {
        loadScreensaverDefaultBitmap()
    }

    val customImageFile = remember(bgCustomPath) {
        if (bgCustomPath.isNotBlank()) File(bgCustomPath) else null
    }
    val isCustomValid = bgMode == "custom_image" && customImageFile != null && customImageFile.exists() && customImageFile.isFile
    val isAlbumArtValid = bgMode == "album_art" && coverUrl != null

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF06080D))
            .clickable {
                val now = System.currentTimeMillis()
                if (now - screensaverActivatedAt > 400L) {
                    onWakeUp()
                }
            }
    ) {
        // -----------------------------------------------------------------
        // 1. SCREENSAVER BACKGROUND BACKDROP (Restored Mosaic Wallpaper)
        // -----------------------------------------------------------------
        if (isCustomValid) {
            customImageFile?.let { imageFile ->
                AsyncImage(
                    model = imageFile,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(bgAlpha)
                )
            }
        } else if (isAlbumArtValid) {
            coverUrl?.let { url ->
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(bgAlpha)
                )
            }
        } else {
            // Default 3D Album Mosaic Grid Wallpaper
            if (defaultScreensaverBitmap != null) {
                Image(
                    bitmap = defaultScreensaverBitmap,
                    contentDescription = "Mosaic Screensaver Backdrop",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // -----------------------------------------------------------------
        // 2. PIXEL-PERFECT APPLE iOS NOW PLAYING CONSOLE OVERLAY
        // Seamlessly mapped onto the central card in the wallpaper
        // -----------------------------------------------------------------
        RenderMosaicCardScreensaver(
            track = currentTrack,
            coverUrl = coverUrl,
            isPlaying = isPlaying,
            playerViewModel = playerViewModel,
            positionMs = positionMs,
            durationMs = durationMs,
            volume = volume
        )

        // -----------------------------------------------------------------
        // 3. COSMIC VORTEX GRAVITATIONAL CLOCK (Top Right Corner)
        // -----------------------------------------------------------------
        CosmicVortexClock(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 28.dp, end = 32.dp)
                .size(240.dp)
        )


    }
}

/**
 * Top-Right Cosmic Gravitational Lensing Clock.
 * Renders the vortex dial face, glowing event horizon singularity,
 * swirling numerals (1-12), and live sweeping analog hands with neon cyan aura.
 */
@Composable
private fun CosmicVortexClock(
    modifier: Modifier = Modifier
) {
    val dialBitmap = remember { loadCosmicClockDialBitmap() }

    var timeSnapshot by remember { mutableStateOf(LocalDateTime.now()) }
    LaunchedEffect(Unit) {
        while (true) {
            timeSnapshot = LocalDateTime.now()
            delay(100)
        }
    }

    val hour = timeSnapshot.hour % 12
    val minute = timeSnapshot.minute
    val second = timeSnapshot.second
    val nano = timeSnapshot.nano

    val smoothSec = second + nano / 1_000_000_000f
    val smoothMin = minute + smoothSec / 60f
    val smoothHr = hour + smoothMin / 60f

    val hrAngleDeg = smoothHr * 30f
    val minAngleDeg = smoothMin * 6f
    val secAngleDeg = smoothSec * 6f

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val cx = w / 2f
            val cy = h / 2f
            val radius = minOf(w, h) / 2f

            // 1. Draw Cosmic Clock Dial Face Asset
            if (dialBitmap != null) {
                drawImage(
                    image = dialBitmap,
                    dstSize = IntSize(w.toInt(), h.toInt())
                )
            }

            // 2. Draw Hour Hand (White core with glowing cyan aura)
            val hrRad = (hrAngleDeg * PI / 180.0).toFloat()
            val hrLen = radius * 0.38f
            val hrX = cx + hrLen * sin(hrRad)
            val hrY = cy - hrLen * cos(hrRad)

            drawLine(
                color = Color(0x6638BDF8),
                start = Offset(cx, cy),
                end = Offset(hrX, hrY),
                strokeWidth = radius * 0.052f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color(0xFFF0F9FF),
                start = Offset(cx, cy),
                end = Offset(hrX, hrY),
                strokeWidth = radius * 0.026f,
                cap = StrokeCap.Round
            )

            // 3. Draw Minute Hand
            val minRad = (minAngleDeg * PI / 180.0).toFloat()
            val minLen = radius * 0.58f
            val minX = cx + minLen * sin(minRad)
            val minY = cy - minLen * cos(minRad)

            drawLine(
                color = Color(0x6638BDF8),
                start = Offset(cx, cy),
                end = Offset(minX, minY),
                strokeWidth = radius * 0.040f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color(0xFFF0F9FF),
                start = Offset(cx, cy),
                end = Offset(minX, minY),
                strokeWidth = radius * 0.020f,
                cap = StrokeCap.Round
            )

            // 4. Draw Second Hand (Cyan needle with counter-balance tail)
            val secRad = (secAngleDeg * PI / 180.0).toFloat()
            val secLen = radius * 0.72f
            val secTail = radius * 0.16f
            val secX = cx + secLen * sin(secRad)
            val secY = cy - secLen * cos(secRad)
            val tailX = cx - secTail * sin(secRad)
            val tailY = cy + secTail * cos(secRad)

            drawLine(
                color = Color(0x5500E5FF),
                start = Offset(tailX, tailY),
                end = Offset(secX, secY),
                strokeWidth = radius * 0.028f,
                cap = StrokeCap.Round
            )
            drawLine(
                color = Color(0xFF38BDF8),
                start = Offset(tailX, tailY),
                end = Offset(secX, secY),
                strokeWidth = radius * 0.012f,
                cap = StrokeCap.Round
            )

            // 5. Central Event Horizon Pivot
            drawCircle(
                color = Color(0x8838BDF8),
                radius = radius * 0.065f,
                center = Offset(cx, cy)
            )
            drawCircle(
                color = Color(0xFFE0F7FF),
                radius = radius * 0.038f,
                center = Offset(cx, cy)
            )
        }
    }
}

/**
 * Authentic Apple AirPlay Audio Destination Icon.
 * Features an upward-pointing solid triangle crowned by dual concentric radiating circular arcs.
 */
@Composable
private fun IosAirPlayIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.White
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val cx = w / 2f

        // Upward solid triangle in the bottom center
        val triBottom = h * 0.92f
        val triHeight = h * 0.38f
        val triTop = triBottom - triHeight
        val triHalfW = w * 0.22f

        val triPath = Path().apply {
            moveTo(cx, triTop)
            lineTo(cx + triHalfW, triBottom)
            lineTo(cx - triHalfW, triBottom)
            close()
        }
        drawPath(triPath, color = tint)

        // Concentric radiating arcs above triangle
        val strokeWidth = (w * 0.085f).coerceIn(1.8f, 3.2f)
        val arcStyle = Stroke(width = strokeWidth, cap = StrokeCap.Round)
        val arcCenterY = triTop + h * 0.04f

        val rInner = w * 0.26f
        drawArc(
            color = tint,
            startAngle = 205f,
            sweepAngle = 130f,
            useCenter = false,
            topLeft = Offset(cx - rInner, arcCenterY - rInner),
            size = Size(rInner * 2f, rInner * 2f),
            style = arcStyle
        )

        val rOuter = w * 0.44f
        drawArc(
            color = tint,
            startAngle = 205f,
            sweepAngle = 130f,
            useCenter = false,
            topLeft = Offset(cx - rOuter, arcCenterY - rOuter),
            size = Size(rOuter * 2f, rOuter * 2f),
            style = arcStyle
        )
    }
}

/**
 * Centered Interactive Now Playing Console matching Apple iOS Design.
 * Seamlessly projected onto the wallpaper card dimensions (1024x576 base image).
 */
@Composable
private fun RenderMosaicCardScreensaver(
    track: Track?,
    coverUrl: String?,
    isPlaying: Boolean,
    playerViewModel: PlayerViewModel,
    positionMs: Long,
    durationMs: Long,
    volume: Float,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val density = LocalDensity.current
        val widthPx = with(density) { maxWidth.toPx() }
        val heightPx = with(density) { maxHeight.toPx() }

        // Base image dimensions: 1024 x 576 (16:9 ratio)
        // ContentScale.Crop scaling calculations
        val scale = maxOf(widthPx / 1024f, heightPx / 576f)
        val offsetX = (widthPx - 1024f * scale) / 2f
        val offsetY = (heightPx - 576f * scale) / 2f

        // Card dimensions inside screensaver_bg.jpg (x=376..647, y=111..492)
        val cardBaseX = 376f
        val cardBaseY = 111f
        val cardBaseW = 271f
        val cardBaseH = 381f
        val cardCornerRadius = (22f * scale).coerceAtLeast(10f)

        val cardLeft = with(density) { (offsetX + cardBaseX * scale).toDp() }
        val cardTop = with(density) { (offsetY + cardBaseY * scale).toDp() }
        val cardWidth = with(density) { (cardBaseW * scale).toDp() }
        val cardHeight = with(density) { (cardBaseH * scale).toDp() }
        val cardCornerRadiusDp = with(density) { cardCornerRadius.toDp() }

        // Complete Card Box
        Box(
            modifier = Modifier
                .offset(x = cardLeft, y = cardTop)
                .size(width = cardWidth, height = cardHeight)
                .shadow(
                    elevation = with(density) { (18f * scale).toDp() },
                    shape = RoundedCornerShape(cardCornerRadiusDp),
                    spotColor = Color.Black.copy(alpha = 0.85f),
                    ambientColor = Color.Black.copy(alpha = 0.60f)
                )
                .clip(RoundedCornerShape(cardCornerRadiusDp))
                .border(
                    width = with(density) { (1.2f * scale).coerceIn(1f, 2.5f).toDp() },
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0x55FFFFFF),
                            Color(0x25FFFFFF),
                            Color(0x15FFFFFF),
                            Color(0x35FFFFFF)
                        )
                    ),
                    shape = RoundedCornerShape(cardCornerRadiusDp)
                )
                .background(Color(0xFF0C0D11))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    // Swallowing click so interacting with widget does NOT exit screensaver
                }
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // -------------------------------------------------------------
                // 1. TOP ALBUM ARTWORK (Flush with top, left, right borders)
                // -------------------------------------------------------------
                val artHeight = with(density) { (208f * scale).toDp() }
                val artShape = RoundedCornerShape(
                    topStart = cardCornerRadiusDp,
                    topEnd = cardCornerRadiusDp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(artHeight)
                        .clip(artShape)
                        .background(Color(0xFF090A0E))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            if (track != null) {
                                playerViewModel.togglePlayPause()
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (track != null && !coverUrl.isNullOrBlank()) {
                        AsyncImage(
                            model = coverUrl,
                            contentDescription = track.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else if (track != null) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.linearGradient(
                                        listOf(Color(0xFF1E2129), Color(0xFF101217))
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.MusicNote,
                                contentDescription = null,
                                tint = Color.White.copy(alpha = 0.40f),
                                modifier = Modifier.size(with(density) { (42f * scale).coerceIn(28f, 60f).toDp() })
                            )
                        }
                    }
                }

                // -------------------------------------------------------------
                // 2. BOTTOM CONTROL CONSOLE (100% Solid Obsidian Dark)
                // -------------------------------------------------------------
                val consoleShape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = cardCornerRadiusDp,
                    bottomEnd = cardCornerRadiusDp
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .clip(consoleShape)
                        .background(Color(0xFF0C0D11))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                horizontal = with(density) { (15f * scale).coerceIn(10f, 24f).toDp() },
                                vertical = with(density) { (10f * scale).coerceIn(6f, 16f).toDp() }
                            ),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // A. TITLE, SUBTITLE & AIRPLAY ROW
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = with(density) { (1f * scale).toDp() }),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(1f).padding(end = with(density) { (8f * scale).toDp() })
                            ) {
                                Text(
                                    text = track?.title ?: "Make Some Noise For The Desi Boyz",
                                    color = Color.White,
                                    fontSize = (13f * scale).coerceIn(10.5f, 17f).sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(Modifier.height(with(density) { (1.5f * scale).toDp() }))
                                Text(
                                    text = track?.artists?.joinToString(", ") { it.name }?.ifBlank { "Song" } ?: "Song",
                                    color = Color(0xFF8E8E93),
                                    fontSize = (10f * scale).coerceIn(8.5f, 13.5f).sp,
                                    fontWeight = FontWeight.Normal,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            // Authentic AirPlay Icon
                            IosAirPlayIcon(
                                modifier = Modifier
                                    .size(with(density) { (19f * scale).coerceIn(15f, 26f).toDp() })
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable { playerViewModel.toggleAudioEffectsDialog() },
                                tint = Color.White
                            )
                        }

                        // B. PROGRESS SCRUBBER WITH THUMB KNOB & TIMESTAMPS
                        Column(modifier = Modifier.fillMaxWidth()) {
                            val trackFraction = if (durationMs > 0) (positionMs.toFloat() / durationMs.toFloat()).coerceIn(0f, 1f) else 0f
                            var isDraggingProgress by remember { mutableStateOf(false) }
                            var dragProgressFraction by remember { mutableFloatStateOf(0f) }
                            val currentProgress = if (isDraggingProgress) dragProgressFraction else trackFraction

                            val trackHeightPx = with(density) { (2.6f * scale).coerceIn(2f, 4.5f).toDp().toPx() }
                            val thumbRadiusPx = with(density) { (4.5f * scale).coerceIn(3.5f, 6.5f).toDp().toPx() }
                            val scrubBoxHeightDp = with(density) { (14f * scale).coerceIn(10f, 20f).toDp() }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(scrubBoxHeightDp)
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .pointerInput(durationMs) {
                                        detectTapGestures { offset ->
                                            if (size.width > 0 && durationMs > 0) {
                                                val frac = (offset.x / size.width.toFloat()).coerceIn(0f, 1f)
                                                playerViewModel.seekTo((durationMs * frac).toLong())
                                            }
                                        }
                                    }
                                    .pointerInput(durationMs) {
                                        detectHorizontalDragGestures(
                                            onDragStart = { offset ->
                                                if (size.width > 0) {
                                                    isDraggingProgress = true
                                                    dragProgressFraction = (offset.x / size.width.toFloat()).coerceIn(0f, 1f)
                                                }
                                            },
                                            onDragEnd = {
                                                if (durationMs > 0) {
                                                    playerViewModel.seekTo((durationMs * dragProgressFraction).toLong())
                                                }
                                                isDraggingProgress = false
                                            },
                                            onDragCancel = {
                                                isDraggingProgress = false
                                            },
                                            onHorizontalDrag = { _, dragAmount ->
                                                if (size.width > 0) {
                                                    dragProgressFraction = (dragProgressFraction + dragAmount / size.width.toFloat()).coerceIn(0f, 1f)
                                                }
                                            }
                                        )
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Canvas(modifier = Modifier.fillMaxSize()) {
                                    val w = size.width
                                    val cy = size.height / 2f

                                    // Inactive track line (dark charcoal #38383D)
                                    drawLine(
                                        color = Color(0xFF38383D),
                                        start = Offset(0f, cy),
                                        end = Offset(w, cy),
                                        strokeWidth = trackHeightPx,
                                        cap = StrokeCap.Round
                                    )

                                    // Active progress fill (solid white)
                                    val activeEnd = (w * currentProgress).coerceIn(0f, w)
                                    if (activeEnd > 0f) {
                                        drawLine(
                                            color = Color.White,
                                            start = Offset(0f, cy),
                                            end = Offset(activeEnd, cy),
                                            strokeWidth = trackHeightPx,
                                            cap = StrokeCap.Round
                                        )
                                    }

                                    // White circular thumb knob
                                    drawCircle(
                                        color = Color.White,
                                        radius = thumbRadiusPx,
                                        center = Offset(activeEnd, cy)
                                    )
                                }
                            }

                            // Real-time timestamps directly below scrubber
                            val displayPosMs = if (isDraggingProgress) (durationMs * dragProgressFraction).toLong() else positionMs
                            val displayRemMs = (durationMs - displayPosMs).coerceAtLeast(0L)

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 2.dp, end = 2.dp, top = 2.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = formatTimeMs(displayPosMs),
                                    color = Color(0xFF8E8E93),
                                    fontSize = (9f * scale).coerceIn(7f, 12.5f).sp,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    text = if (durationMs > 0) "-${formatTimeMs(displayRemMs)}" else "-0:00",
                                    color = Color(0xFF8E8E93),
                                    fontSize = (9f * scale).coerceIn(7f, 12.5f).sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }

                        // C. PLAYBACK CONTROLS (Prev <<, Play/Pause ||, Next >>)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val sideIconSize = with(density) { (22f * scale).coerceIn(16f, 30f).toDp() }
                            val sideBtnSize = with(density) { (38f * scale).coerceIn(28f, 50f).toDp() }
                            val playIconSize = with(density) { (26f * scale).coerceIn(20f, 36f).toDp() }
                            val playBtnSize = with(density) { (44f * scale).coerceIn(32f, 56f).toDp() }
                            val ctrlGap = with(density) { (30f * scale).coerceIn(20f, 48f).toDp() }

                            // Fast Rewind
                            IconButton(
                                onClick = { playerViewModel.skipPrevious() },
                                modifier = Modifier
                                    .size(sideBtnSize)
                                    .pointerHoverIcon(PointerIcon.Hand)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FastRewind,
                                    contentDescription = "Previous Track",
                                    tint = Color.White,
                                    modifier = Modifier.size(sideIconSize)
                                )
                            }

                            Spacer(Modifier.width(ctrlGap))

                            // Play / Pause Button
                            IconButton(
                                onClick = {
                                    if (track != null) {
                                        playerViewModel.togglePlayPause()
                                    } else {
                                        val firstQueue = playerViewModel.queue.value.firstOrNull()
                                        if (firstQueue != null) {
                                            playerViewModel.play(firstQueue)
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .size(playBtnSize)
                                    .pointerHoverIcon(PointerIcon.Hand)
                            ) {
                                if (isPlaying) {
                                    // Authentic iOS Pause Bars (two vertical rounded pills)
                                    Canvas(modifier = Modifier.size(width = playIconSize * 0.75f, height = playIconSize)) {
                                        val pillW = size.width * 0.28f
                                        val pillH = size.height * 0.90f
                                        val gap = size.width * 0.28f
                                        val topY = (size.height - pillH) / 2f
                                        val leftX1 = (size.width - (2 * pillW + gap)) / 2f
                                        val leftX2 = leftX1 + pillW + gap
                                        val cr = CornerRadius(pillW / 2f, pillW / 2f)

                                        drawRoundRect(
                                            color = Color.White,
                                            topLeft = Offset(leftX1, topY),
                                            size = Size(pillW, pillH),
                                            cornerRadius = cr
                                        )
                                        drawRoundRect(
                                            color = Color.White,
                                            topLeft = Offset(leftX2, topY),
                                            size = Size(pillW, pillH),
                                            cornerRadius = cr
                                        )
                                    }
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Play",
                                        tint = Color.White,
                                        modifier = Modifier.size(playIconSize)
                                    )
                                }
                            }

                            Spacer(Modifier.width(ctrlGap))

                            // Fast Forward
                            IconButton(
                                onClick = { playerViewModel.skipNext() },
                                modifier = Modifier
                                    .size(sideBtnSize)
                                    .pointerHoverIcon(PointerIcon.Hand)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FastForward,
                                    contentDescription = "Next Track",
                                    tint = Color.White,
                                    modifier = Modifier.size(sideIconSize)
                                )
                            }
                        }

                        // D. VOLUME SLIDER ROW
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = with(density) { (2f * scale).toDp() }),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(with(density) { (8f * scale).coerceIn(5f, 12f).toDp() })
                        ) {
                            val volIconSize = with(density) { (15f * scale).coerceIn(11f, 20f).toDp() }
                            var lastNonZeroVol by remember { mutableFloatStateOf(0.8f) }

                            Icon(
                                imageVector = if (volume <= 0.01f) Icons.AutoMirrored.Filled.VolumeMute else Icons.AutoMirrored.Filled.VolumeDown,
                                contentDescription = "Mute Toggle",
                                tint = Color(0xFF8E8E93),
                                modifier = Modifier
                                    .size(volIconSize)
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable {
                                        if (volume > 0.01f) {
                                            lastNonZeroVol = volume
                                            playerViewModel.setVolume(0f)
                                        } else {
                                            playerViewModel.setVolume(lastNonZeroVol.coerceAtLeast(0.3f))
                                        }
                                    }
                            )

                            var isDraggingVolume by remember { mutableStateOf(false) }
                            var dragVolFraction by remember { mutableFloatStateOf(0f) }
                            val currentVol = if (isDraggingVolume) dragVolFraction else volume.coerceIn(0f, 1f)

                            val volTrackHeightPx = with(density) { (2.6f * scale).coerceIn(2f, 4.5f).toDp().toPx() }
                            val volThumbRadiusPx = with(density) { (4.5f * scale).coerceIn(3.5f, 6.5f).toDp().toPx() }
                            val volBoxHeightDp = with(density) { (14f * scale).coerceIn(10f, 20f).toDp() }

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(volBoxHeightDp)
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .pointerInput(Unit) {
                                        detectTapGestures { offset ->
                                            if (size.width > 0) {
                                                val frac = (offset.x / size.width.toFloat()).coerceIn(0f, 1f)
                                                playerViewModel.setVolume(frac)
                                            }
                                        }
                                    }
                                    .pointerInput(Unit) {
                                        detectHorizontalDragGestures(
                                            onDragStart = { offset ->
                                                if (size.width > 0) {
                                                    isDraggingVolume = true
                                                    dragVolFraction = (offset.x / size.width.toFloat()).coerceIn(0f, 1f)
                                                }
                                            },
                                            onDragEnd = {
                                                playerViewModel.setVolume(dragVolFraction)
                                                isDraggingVolume = false
                                            },
                                            onDragCancel = {
                                                isDraggingVolume = false
                                            },
                                            onHorizontalDrag = { _, dragAmount ->
                                                if (size.width > 0) {
                                                    val newFrac = (dragVolFraction + dragAmount / size.width.toFloat()).coerceIn(0f, 1f)
                                                    dragVolFraction = newFrac
                                                    playerViewModel.setVolume(newFrac)
                                                }
                                            }
                                        )
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Canvas(modifier = Modifier.fillMaxSize()) {
                                    val w = size.width
                                    val cy = size.height / 2f

                                    // Inactive volume track (#38383D)
                                    drawLine(
                                        color = Color(0xFF38383D),
                                        start = Offset(0f, cy),
                                        end = Offset(w, cy),
                                        strokeWidth = volTrackHeightPx,
                                        cap = StrokeCap.Round
                                    )

                                    // Active volume fill (white)
                                    val activeEnd = (w * currentVol).coerceIn(0f, w)
                                    if (activeEnd > 0f) {
                                        drawLine(
                                            color = Color.White,
                                            start = Offset(0f, cy),
                                            end = Offset(activeEnd, cy),
                                            strokeWidth = volTrackHeightPx,
                                            cap = StrokeCap.Round
                                        )
                                    }

                                    // Volume thumb knob
                                    drawCircle(
                                        color = Color.White,
                                        radius = volThumbRadiusPx,
                                        center = Offset(activeEnd, cy)
                                    )
                                }
                            }

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                                contentDescription = "Max Volume",
                                tint = Color(0xFF8E8E93),
                                modifier = Modifier
                                    .size(volIconSize)
                                    .pointerHoverIcon(PointerIcon.Hand)
                                    .clickable { playerViewModel.setVolume(1f) }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun formatTimeMs(ms: Long): String {
    if (ms <= 0) return "0:00"
    val totalSec = ms / 1000
    val min = totalSec / 60
    val sec = totalSec % 60
    return "$min:${if (sec < 10) "0$sec" else "$sec"}"
}
