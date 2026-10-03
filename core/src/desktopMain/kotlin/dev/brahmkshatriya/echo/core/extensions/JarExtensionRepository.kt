package dev.brahmkshatriya.echo.core.extensions

import dev.brahmkshatriya.echo.common.clients.ExtensionClient
import dev.brahmkshatriya.echo.common.models.ExtensionType
import dev.brahmkshatriya.echo.common.models.ImportType
import dev.brahmkshatriya.echo.common.models.Metadata
import dev.brahmkshatriya.echo.core.platform.AppPlatform
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.net.URLClassLoader
import java.util.jar.JarFile

/**
 * Desktop extension repository that loads extensions from .jar files
 * placed in the extensions directory using URLClassLoader.
 *
 * This is the Desktop equivalent of the Android DexLoader which uses DexClassLoader.
 * The extension JARs must contain:
 *   - META-INF/echo-extension.json (manifest with className, id, name, version, type)
 *   - The ExtensionClient implementation class (on the classpath)
 */
class JarExtensionRepository @JvmOverloads constructor(
    private val platform: AppPlatform,
    private val settings: dev.brahmkshatriya.echo.core.settings.EchoSettings? = null,
) : ExtensionRepository {

    private val json = Json { ignoreUnknownKeys = true }

    init {
        unpackBundledExtensions()
    }

    private fun unpackBundledExtensions() {
        try {
            val destDir = platform.extensionsDir.toFile().also { it.mkdirs() }
            val bundled = listOf(
                "spotify.jar", "youtube.jar", "saavn.jar", "soundcloud.jar", "radiobrowser.jar",
                "lrclib.jar", "genius.jar", "musixmatch.jar", "discordrpc.jar", "lastfm.jar"
            )
            for (name in bundled) {
                val file = java.io.File(destDir, name)
                if (!file.exists() || file.length() == 0L) {
                    val stream = javaClass.getResourceAsStream("/extensions/$name")
                        ?: javaClass.getResourceAsStream("extensions/$name")
                        ?: Thread.currentThread().contextClassLoader?.getResourceAsStream("extensions/$name")
                        ?: ClassLoader.getSystemResourceAsStream("extensions/$name")
                    if (stream != null) {
                        stream.use { input ->
                            file.outputStream().use { output -> input.copyTo(output) }
                        }
                        println("[Echo JarExtensionRepository] Unpacked bundled extension $name to ${file.absolutePath}")
                    }
                }
            }
        } catch (e: Exception) {
            System.err.println("[Echo JarExtensionRepository] Error unpacking bundled extensions: ${e.message}")
        }
    }

    private data class CachedJar(
        val lastModified: Long,
        val result: Result<Pair<Metadata, Lazy<ExtensionClient>>>
    )
    private val jarCache = mutableMapOf<String, CachedJar>()

    override val flow: Flow<List<Result<Pair<Metadata, Lazy<ExtensionClient>>>>> = flow {
        val localBuiltin = Result.success(
            dev.brahmkshatriya.echo.core.extensions.builtin.LocalMusicExtension.METADATA to lazy {
                dev.brahmkshatriya.echo.core.extensions.builtin.LocalMusicExtension(platform, settings)
            }
        )
        val spotifyBuiltin = Result.success(
            dev.brahmkshatriya.echo.core.extensions.builtin.SpotifyExtension.METADATA to lazy {
                dev.brahmkshatriya.echo.core.extensions.builtin.SpotifyExtension(platform, settings)
            }
        )
        var lastFingerprint = ""
        while (true) {
            val extensionsDir = platform.extensionsDir.toFile().also { it.mkdirs() }
            val jarFiles = extensionsDir.listFiles { f -> f.extension.equals("jar", ignoreCase = true) } ?: emptyArray()
            val currentFingerprint = jarFiles.sortedBy { it.absolutePath }
                .joinToString(";") { "${it.absolutePath}:${it.lastModified()}" }

            if (currentFingerprint != lastFingerprint) {
                lastFingerprint = currentFingerprint
                val scanned = scanExtensions(jarFiles)
                println("[Echo JarExtensionRepository] Extensions list changed. Emitting ${scanned.size} JAR extension(s) + Spotify + local music.")
                emit(scanned + listOf(spotifyBuiltin, localBuiltin))
            }
            delay(3_000)
        }
    }

    private fun scanExtensions(jarFiles: Array<java.io.File>): List<Result<Pair<Metadata, Lazy<ExtensionClient>>>> {
        val currentPaths = jarFiles.map { it.absolutePath }.toSet()
        jarCache.keys.retainAll(currentPaths)

        return jarFiles.map { jar ->
            val cached = jarCache[jar.absolutePath]
            if (cached != null && cached.lastModified == jar.lastModified()) {
                cached.result
            } else {
                val res = loadJar(jar.absolutePath)
                jarCache[jar.absolutePath] = CachedJar(jar.lastModified(), res)
                res
            }
        }
    }

    private fun loadJar(jarPath: String): Result<Pair<Metadata, Lazy<ExtensionClient>>> {
        return runCatching {
            val jarFileObj = java.io.File(jarPath).canonicalFile
            val allowedDir = platform.extensionsDir.toFile().canonicalFile
            require(jarFileObj.parentFile == allowedDir) {
                "Security exception: Refusing to load extension outside extensions directory: ${jarFileObj.absolutePath}"
            }
            val metadata = parseExtensionMetadata(jarFileObj.absolutePath)
            println("[Echo] Discovered JAR extension: ${metadata.name} (${metadata.id}) at $jarPath")
            val lazyClient = lazy {
                try {
                    val loader = URLClassLoader(
                        arrayOf(jarFileObj.toURI().toURL()),
                        javaClass.classLoader
                    )
                    println("[Echo] Loading extension class: ${metadata.className}")
                    val clazz = loader.loadClass(metadata.className)
                    val instance = clazz.getDeclaredConstructor().newInstance() as ExtensionClient
                    println("[Echo] Successfully instantiated extension: ${metadata.name}")
                    instance
                } catch (t: Throwable) {
                    System.err.println("[Echo] Error instantiating extension ${metadata.name}: ${t.message}")
                    t.printStackTrace()
                    throw t
                }
            }
            metadata to lazyClient
        }.onFailure { e ->
            System.err.println("[Echo] Failed to parse JAR extension at $jarPath: ${e.message}")
        }
    }

    private fun parseExtensionMetadata(jarPath: String): Metadata {
        val file = java.io.File(jarPath)
        if (file.extension.equals("apk", ignoreCase = true) || file.extension.equals("eapk", ignoreCase = true)) {
            error("Cannot load Android APK '${file.name}'. Echo Desktop requires JVM JAR extensions (.jar).")
        }
        val jarFile = JarFile(jarPath)
        val jsonEntry = jarFile.getJarEntry("META-INF/echo-extension.json")
        if (jsonEntry != null) {
            val jsonStr = jarFile.getInputStream(jsonEntry).bufferedReader().readText()
            jarFile.close()
            val dto = json.decodeFromString<ExtensionManifest>(jsonStr)
            val fullClassName = if (dto.className.contains('.')) dto.className else "dev.brahmkshatriya.echo.extension.${dto.className}"
            val isEnabled = settings?.getBoolean("ext_enabled_${dto.id}", true) ?: true
            return Metadata(
                className = fullClassName,
                path = jarPath,
                importType = ImportType.File,
                type = ExtensionType.valueOf(dto.type.uppercase()),
                id = dto.id,
                name = dto.name,
                version = dto.version,
                description = dto.description ?: "",
                author = dto.author ?: "Unknown",
                authorUrl = dto.authorUrl,
                repoUrl = dto.repoUrl,
                updateUrl = dto.updateUrl,
                isEnabled = isEnabled,
            )
        }

        // Fallback: Read standard Echo MANIFEST.MF attributes
        val manifest = jarFile.manifest
            ?: run { jarFile.close(); error("Neither META-INF/echo-extension.json nor MANIFEST.MF found in ${file.name}") }
        val attrs = manifest.mainAttributes
        val rawClass = attrs.getValue("Extension-Class")
            ?: run { jarFile.close(); error("Missing Extension-Class attribute in MANIFEST.MF of ${file.name}") }
        val fullClassName = if (rawClass.contains('.')) rawClass else "dev.brahmkshatriya.echo.extension.$rawClass"
        val id = attrs.getValue("Extension-Id") ?: file.nameWithoutExtension
        val name = attrs.getValue("Extension-Name") ?: id
        val typeStr = (attrs.getValue("Extension-Type") ?: "MUSIC").uppercase()
        val version = attrs.getValue("Extension-Version-Name") ?: attrs.getValue("Extension-Version-Code") ?: "1.0.0"
        val description = attrs.getValue("Extension-Description") ?: ""
        val author = attrs.getValue("Extension-Author") ?: dev.brahmkshatriya.echo.common.config.FlavorConfig.APP_AUTHOR
        val authorUrl = attrs.getValue("Extension-Author-Url")
        val repoUrl = attrs.getValue("Extension-Repo-Url")
        val updateUrl = attrs.getValue("Extension-Update-Url")
        jarFile.close()

        val type = runCatching { ExtensionType.valueOf(typeStr) }.getOrDefault(ExtensionType.MUSIC)
        val isEnabled = settings?.getBoolean("ext_enabled_$id", true) ?: true
        return Metadata(
            className = fullClassName,
            path = jarPath,
            importType = ImportType.File,
            type = type,
            id = id,
            name = name,
            version = version,
            description = description,
            author = author,
            authorUrl = authorUrl,
            repoUrl = repoUrl,
            updateUrl = updateUrl,
            isEnabled = isEnabled,
        )
    }

    override suspend fun install(source: ExtensionInstallSource): Result<Metadata> {
        return runCatching {
            val destDir = platform.extensionsDir.toFile().also { it.mkdirs() }.canonicalFile
            when (source) {
                is ExtensionInstallSource.LocalFile -> {
                    val src = java.io.File(source.path).canonicalFile
                    if (src.extension.equals("apk", ignoreCase = true) || src.extension.equals("eapk", ignoreCase = true)) {
                        error("Cannot install '${src.name}'. Android APK/EAPK files run Dalvik bytecode (.dex). Echo Desktop requires Kotlin JVM .jar extensions. Please use or compile the .jar release of this extension.")
                    }
                    val safeName = sanitizeExtensionFileName(src.name)
                    val dest = java.io.File(destDir, safeName).canonicalFile
                    require(dest.parentFile == destDir) { "Security violation: Path traversal detected in extension name." }
                    src.copyTo(dest, overwrite = true)
                    parseExtensionMetadata(dest.absolutePath)
                }
                is ExtensionInstallSource.RemoteUrl -> {
                    val rawUrl = source.url.trim()
                    require(rawUrl.startsWith("https://", ignoreCase = true)) {
                        "Security violation: Extensions may only be downloaded over secure HTTPS."
