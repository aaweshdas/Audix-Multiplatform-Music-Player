package dev.brahmkshatriya.echo.desktop.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.skia.FilterTileMode
import org.jetbrains.skia.Image
import org.jetbrains.skia.ImageFilter
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Rect
import org.jetbrains.skia.Surface
import java.awt.RenderingHints
import java.awt.image.BufferedImage
import java.io.File
import java.nio.file.Paths
import java.util.concurrent.ConcurrentHashMap
import javax.imageio.ImageIO

val LocalAppBlurredBackground = compositionLocalOf<ImageBitmap?> { null }

data class BackgroundWallpaper(
    val id: String,
    val title: String,
    val subtitle: String,
    val resourcePath: String? = null,
    val thumbResourcePath: String? = null,
    val filePath: String? = null,
    val thumbFilePath: String? = null,
    val isCustom: Boolean = false,
    val dateAdded: Long = 0L
)

object DesktopBackgroundManager {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var echoSettings: EchoSettings? = null

    val PRESET_WALLPAPERS = listOf(
        BackgroundWallpaper(
            id = "default_master",
            title = "Audix 32K Master Atmosphere",
            subtitle = "Signature acoustic dark gradient with liquid glass grain",
            resourcePath = "images/audix_bg.jpg",
            thumbResourcePath = "images/backgrounds/default_master_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "cyber_industrial",
            title = "Cyber-Industrial Ember Shards",
            subtitle = "Futuristic machinery bathed in embers & dark metal",
            resourcePath = "images/backgrounds/cyber_industrial.png",
            thumbResourcePath = "images/backgrounds/cyber_industrial_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "midnight_music",
            title = "Midnight Music in the Park",
            subtitle = "Nocturnal acoustic melodies under city streetlamps",
            resourcePath = "images/backgrounds/midnight_music.png",
            thumbResourcePath = "images/backgrounds/midnight_music_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "midnight_ribbons",
            title = "Midnight Ribbons with Crimson Glow",
            subtitle = "Fluid abstract light trails woven in ruby crimson",
            resourcePath = "images/backgrounds/midnight_ribbons.png",
            thumbResourcePath = "images/backgrounds/midnight_ribbons_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "minimalist_workspace",
            title = "Minimalist Monochrome Workspace",
            subtitle = "Precision studio desk gear and monochrome aesthetics",
            resourcePath = "images/backgrounds/minimalist_workspace.png",
            thumbResourcePath = "images/backgrounds/minimalist_workspace_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "cosmic_brushstrokes",
            title = "Monochrome Cosmic Brushstrokes",
            subtitle = "Nebular deep ink waves and astral fluidity",
            resourcePath = "images/backgrounds/cosmic_brushstrokes.png",
            thumbResourcePath = "images/backgrounds/cosmic_brushstrokes_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "moody_audio_gear",
            title = "Moody Audio Gear on Dark Wood",
            subtitle = "Vintage audio hardware, cables & rich dark timber",
            resourcePath = "images/backgrounds/moody_audio_gear.png",
            thumbResourcePath = "images/backgrounds/moody_audio_gear_thumb.jpg",
            isCustom = false
        ),
        BackgroundWallpaper(
            id = "moody_tech_desk",
            title = "Moody Minimalist Tech Desk",
            subtitle = "Sleek producer workstation with subtle accent illumination",
            resourcePath = "images/backgrounds/moody_tech_desk.png",
            thumbResourcePath = "images/backgrounds/moody_tech_desk_thumb.jpg",
            isCustom = false
        )
    )

    private val _wallpapers = MutableStateFlow<List<BackgroundWallpaper>>(PRESET_WALLPAPERS)
    val wallpapers: StateFlow<List<BackgroundWallpaper>> = _wallpapers.asStateFlow()

    private val _currentWallpaperId = MutableStateFlow<String>("default_master")
    val currentWallpaperId: StateFlow<String> = _currentWallpaperId.asStateFlow()

    private val _currentBitmap = MutableStateFlow<ImageBitmap?>(null)
    val currentBitmap: StateFlow<ImageBitmap?> = _currentBitmap.asStateFlow()

    private val _currentBlurredBitmap = MutableStateFlow<ImageBitmap?>(null)
    val currentBlurredBitmap: StateFlow<ImageBitmap?> = _currentBlurredBitmap.asStateFlow()

    private val bitmapCache = ConcurrentHashMap<String, ImageBitmap>()
    private val blurredBitmapCache = ConcurrentHashMap<String, ImageBitmap>()
    private val thumbCache = ConcurrentHashMap<String, ImageBitmap>()

    init {
        // Eagerly resolve default wallpaper bitmap & blurred background
        val defaultWp = PRESET_WALLPAPERS.first()
        val defaultBmp = loadBitmapInternal(defaultWp)
        _currentBitmap.value = defaultBmp
        val defaultBlurred = loadBlurredBitmapInternal(defaultWp)
        _currentBlurredBitmap.value = defaultBlurred
    }

    fun initialize(settings: EchoSettings) {
        if (this.echoSettings != null) return
        this.echoSettings = settings

        val customList = loadCustomWallpapers()
        _wallpapers.value = PRESET_WALLPAPERS + customList

        val savedId = settings.getString("active_wallpaper_id", "default_master") ?: "default_master"
        val target = _wallpapers.value.find { it.id == savedId } ?: PRESET_WALLPAPERS.first()
        _currentWallpaperId.value = target.id

        val bmp = loadBitmapInternal(target)
        if (bmp != null) {
            _currentBitmap.value = bmp
        }
        val blurred = loadBlurredBitmapInternal(target)
        if (blurred != null) {
            _currentBlurredBitmap.value = blurred
        }
    }

    fun selectWallpaper(id: String) {
        val target = _wallpapers.value.find { it.id == id } ?: return
        _currentWallpaperId.value = id
        echoSettings?.putString("active_wallpaper_id", id)

        scope.launch {
            val bmp = loadBitmapInternal(target)
            if (bmp != null) {
                _currentBitmap.value = bmp
            }
            val blurred = loadBlurredBitmapInternal(target)
            if (blurred != null) {
                _currentBlurredBitmap.value = blurred
            }
        }
    }

    fun getCustomWallpapersDir(): File {
        val portableDir = File("release-artifacts/Audix-Windows-Portable/app/custom_wallpapers")
        if (portableDir.parentFile.exists()) {
            if (!portableDir.exists()) portableDir.mkdirs()
            return portableDir
        }
        val devDir = File("desktopApp/src/desktopMain/resources/custom_wallpapers")
        if (devDir.parentFile.exists()) {
            if (!devDir.exists()) devDir.mkdirs()
            return devDir
        }
        val userDir = File(System.getProperty("user.home"), ".audix/wallpapers")
        if (!userDir.exists()) userDir.mkdirs()
        return userDir
    }

    fun addCustomWallpaper(file: File, customTitle: String? = null): BackgroundWallpaper? {
        if (!file.exists() || !file.isFile) return null
        return runCatching {
            val dir = getCustomWallpapersDir()
            val timestamp = System.currentTimeMillis()
            val safeName = file.nameWithoutExtension.replace("[^a-zA-Z0-9_-]".toRegex(), "_").take(30)
            val ext = file.extension.lowercase().ifBlank { "png" }
            val targetFile = File(dir, "custom_${timestamp}_${safeName}.$ext")
            val thumbFile = File(dir, "custom_${timestamp}_${safeName}_thumb.jpg")

            file.copyTo(targetFile, overwrite = true)

            // Generate high quality thumbnail
            runCatching {
                val origImg = ImageIO.read(targetFile)
                if (origImg != null) {
                    val thumbWidth = 400
                    val thumbHeight = ((thumbWidth.toDouble() * origImg.height) / origImg.width).toInt().coerceAtLeast(100)
                    val thumbImg = BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB)
                    val g = thumbImg.createGraphics()
                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR)
                    g.drawImage(origImg, 0, 0, thumbWidth, thumbHeight, null)
                    g.dispose()
                    ImageIO.write(thumbImg, "jpg", thumbFile)
                }
            }

            val nameDisplay = customTitle ?: file.nameWithoutExtension.replace('_', ' ').replace('-', ' ').trim()
            val id = "custom_${timestamp}_${safeName}"
            val newWp = BackgroundWallpaper(
                id = id,
                title = nameDisplay,
                subtitle = "Custom user wallpaper (${targetFile.name})",
                resourcePath = null,
                thumbResourcePath = null,
                filePath = targetFile.absolutePath,
                thumbFilePath = if (thumbFile.exists()) thumbFile.absolutePath else targetFile.absolutePath,
                isCustom = true,
                dateAdded = timestamp
            )

            val updated = _wallpapers.value + newWp
            _wallpapers.value = updated
            persistCustomManifest(updated.filter { it.isCustom })

            selectWallpaper(newWp.id)
            newWp
        }.getOrNull()
    }

    fun deleteCustomWallpaper(id: String) {
        val target = _wallpapers.value.find { it.id == id && it.isCustom } ?: return
        val updated = _wallpapers.value.filter { it.id != id }
        _wallpapers.value = updated
        persistCustomManifest(updated.filter { it.isCustom })

        runCatching {
            target.filePath?.let { File(it).takeIf { f -> f.exists() }?.delete() }
            target.thumbFilePath?.let { File(it).takeIf { f -> f.exists() }?.delete() }
            bitmapCache.remove(id)
            blurredBitmapCache.remove(id)
            thumbCache.remove(id)
        }

        if (_currentWallpaperId.value == id) {
            selectWallpaper("default_master")
        }
    }

    private fun loadCustomWallpapers(): List<BackgroundWallpaper> {
        val dir = getCustomWallpapersDir()
        val savedManifest = echoSettings?.getString("custom_wallpaper_manifest", "") ?: ""
        val fromManifest = mutableListOf<BackgroundWallpaper>()

        if (savedManifest.isNotBlank()) {
            savedManifest.lines().forEach { line ->
                val parts = line.split("|")
                if (parts.size >= 4) {
                    val f = File(parts[2])
                    if (f.exists() && f.isFile) {
                        fromManifest.add(
                            BackgroundWallpaper(
                                id = parts[0],
                                title = parts[1],
                                subtitle = "Custom user wallpaper (${f.name})",
                                resourcePath = null,
                                thumbResourcePath = null,
                                filePath = f.absolutePath,
                                thumbFilePath = parts.getOrNull(3)?.takeIf { File(it).exists() } ?: f.absolutePath,
                                isCustom = true,
                                dateAdded = parts.getOrNull(4)?.toLongOrNull() ?: 0L
                            )
                        )
                    }
                }
            }
        }

        if (dir.exists()) {
            val scannedFiles = dir.listFiles { f ->
                f.isFile && !f.name.contains("_thumb") &&
                        (f.name.endsWith(".png", true) || f.name.endsWith(".jpg", true) || f.name.endsWith(".jpeg", true) || f.name.endsWith(".webp", true) || f.name.endsWith(".bmp", true))
            } ?: emptyArray()

            for (f in scannedFiles) {
                if (fromManifest.none { it.filePath == f.absolutePath }) {
                    val thumbFile = File(dir, f.nameWithoutExtension + "_thumb.jpg")
                    fromManifest.add(
                        BackgroundWallpaper(
                            id = "custom_" + f.nameWithoutExtension,
                            title = f.nameWithoutExtension.removePrefix("custom_").replace('_', ' ').trim(),
                            subtitle = "Custom user wallpaper (${f.name})",
                            filePath = f.absolutePath,
                            thumbFilePath = if (thumbFile.exists()) thumbFile.absolutePath else f.absolutePath,
                            isCustom = true,
                            dateAdded = f.lastModified()
                        )
                    )
                }
            }
        }

        return fromManifest
    }

    private fun persistCustomManifest(customList: List<BackgroundWallpaper>) {
        val serialized = customList.joinToString("\n") {
            "${it.id}|${it.title}|${it.filePath.orEmpty()}|${it.thumbFilePath.orEmpty()}|${it.dateAdded}"
        }
        echoSettings?.putString("custom_wallpaper_manifest", serialized)
    }

    fun loadThumbnailBitmap(wallpaper: BackgroundWallpaper): ImageBitmap? {
        thumbCache[wallpaper.id]?.let { return it }

        val bmp = runCatching {
            if (wallpaper.thumbFilePath != null) {
                val f = File(wallpaper.thumbFilePath)
                if (f.exists()) f.inputStream().use { ImageIO.read(it)?.toComposeImageBitmap() } else null
            } else if (wallpaper.thumbResourcePath != null) {
                val res = wallpaper.thumbResourcePath
                val stream = Thread.currentThread().contextClassLoader.getResourceAsStream(res)
                    ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("desktopApp", "src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                stream?.use { ImageIO.read(it)?.toComposeImageBitmap() }
            } else if (wallpaper.filePath != null) {
                val f = File(wallpaper.filePath)
                if (f.exists()) f.inputStream().use { ImageIO.read(it)?.toComposeImageBitmap() } else null
            } else if (wallpaper.resourcePath != null) {
                val res = wallpaper.resourcePath
                val stream = Thread.currentThread().contextClassLoader.getResourceAsStream(res)
                    ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("desktopApp", "src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                stream?.use { ImageIO.read(it)?.toComposeImageBitmap() }
            } else null
        }.getOrNull()

        if (bmp != null) {
            thumbCache[wallpaper.id] = bmp
        }
        return bmp
    }

    private fun loadBitmapInternal(wallpaper: BackgroundWallpaper): ImageBitmap? {
        bitmapCache[wallpaper.id]?.let { return it }

        val bmp = runCatching {
            if (wallpaper.filePath != null) {
                val f = File(wallpaper.filePath)
                if (f.exists()) f.inputStream().use { ImageIO.read(it)?.toComposeImageBitmap() } else null
            } else if (wallpaper.resourcePath != null) {
                val res = wallpaper.resourcePath
                val stream = Thread.currentThread().contextClassLoader.getResourceAsStream(res)
                    ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("desktopApp", "src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                    ?: Paths.get("src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                stream?.use { ImageIO.read(it)?.toComposeImageBitmap() }
            } else null
        }.getOrNull()

        if (bmp != null) {
            bitmapCache[wallpaper.id] = bmp
            return bmp
        }

        // Graceful fallback to default master
        return bitmapCache["default_master"] ?: runCatching {
            val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_bg.jpg")
                ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
                ?: Paths.get("desktopApp", "src", "desktopMain", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            stream?.use { ImageIO.read(it)?.toComposeImageBitmap() }
        }.getOrNull()?.also { bitmapCache["default_master"] = it }
    }

    private fun loadBlurredBitmapInternal(wallpaper: BackgroundWallpaper): ImageBitmap? {
        blurredBitmapCache[wallpaper.id]?.let { return it }

        val bmp = runCatching {
            val bytes = when {
                wallpaper.filePath != null -> {
                    val f = File(wallpaper.filePath)
                    if (f.exists()) f.readBytes() else null
                }
                wallpaper.resourcePath != null -> {
                    val res = wallpaper.resourcePath
                    val stream = Thread.currentThread().contextClassLoader.getResourceAsStream(res)
                        ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                        ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", res).toFile().takeIf { it.exists() }?.inputStream()
                        ?: Paths.get("desktopApp", "src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                        ?: Paths.get("src", "desktopMain", "resources", res).toFile().takeIf { it.exists() }?.inputStream()
                    stream?.use { it.readBytes() }
                }
                else -> null
            }

            if (bytes != null && bytes.isNotEmpty()) {
                val skiaImg = Image.makeFromEncoded(bytes)
                if (skiaImg.width > 0 && skiaImg.height > 0) {
                    val targetW = 960
                    val targetH = ((targetW.toDouble() * skiaImg.height) / skiaImg.width).toInt().coerceAtLeast(100)
                    val surface = Surface.makeRasterN32Premul(targetW, targetH)
                    val canvas = surface.canvas

                    // 24f Gaussian blur for luxurious, elegant frosted-glass bokeh
                    val blurFilter = ImageFilter.makeBlur(24f, 24f, FilterTileMode.CLAMP)
                    val paint = Paint().apply { imageFilter = blurFilter }

                    val srcRect = Rect.makeWH(skiaImg.width.toFloat(), skiaImg.height.toFloat())
                    val dstRect = Rect.makeWH(targetW.toFloat(), targetH.toFloat())
                    canvas.drawImageRect(skiaImg, srcRect, dstRect, paint)

                    val blurredSkia = surface.makeImageSnapshot()
                    blurredSkia.toComposeImageBitmap()
                } else null
            } else null
        }.getOrNull()

        if (bmp != null) {
            blurredBitmapCache[wallpaper.id] = bmp
            return bmp
        }

        // Graceful fallback to default master
        return blurredBitmapCache["default_master"] ?: runCatching {
            val stream = Thread.currentThread().contextClassLoader.getResourceAsStream("images/audix_bg.jpg")
                ?: Paths.get("release-artifacts", "Audix-Windows-Portable", "app", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
                ?: Paths.get("desktopApp", "src", "desktopMain", "resources", "images", "audix_bg.jpg").toFile().takeIf { it.exists() }?.inputStream()
            val bytes = stream?.use { it.readBytes() }
            if (bytes != null && bytes.isNotEmpty()) {
                val skiaImg = Image.makeFromEncoded(bytes)
                val targetW = 960
                val targetH = ((targetW.toDouble() * skiaImg.height) / skiaImg.width).toInt().coerceAtLeast(100)
                val surface = Surface.makeRasterN32Premul(targetW, targetH)
                val blurFilter = ImageFilter.makeBlur(24f, 24f, FilterTileMode.CLAMP)
                val paint = Paint().apply { imageFilter = blurFilter }
                surface.canvas.drawImageRect(skiaImg, Rect.makeWH(skiaImg.width.toFloat(), skiaImg.height.toFloat()), Rect.makeWH(targetW.toFloat(), targetH.toFloat()), paint)
                surface.makeImageSnapshot().toComposeImageBitmap().also {
                    blurredBitmapCache["default_master"] = it
                }
            } else null
        }.getOrNull()
    }
}
