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
import java.io.File
import java.net.URI
import java.net.URL
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

    @Serializable
    private data class ExtensionManifest(
        val id: String,
        val name: String,
        val version: String,
        val type: String = "MUSIC",
        val className: String,
        val description: String? = null,
        val author: String? = null,
        val authorUrl: String? = null,
        val repoUrl: String? = null,
        val updateUrl: String? = null,
    )

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
                val file = File(destDir, name)
                val stream = javaClass.getResourceAsStream("/extensions/$name")
                    ?: javaClass.getResourceAsStream("extensions/$name")
                    ?: Thread.currentThread().contextClassLoader?.getResourceAsStream("extensions/$name")
                    ?: ClassLoader.getSystemResourceAsStream("extensions/$name")
                    ?: findDiskExtensionStream(name)
                if (stream != null) {
                    val bytes = stream.use { it.readBytes() }
                    if (!file.exists() || file.length() != bytes.size.toLong()) {
                        file.writeBytes(bytes)
                        println("[Echo JarExtensionRepository] Updated bundled extension $name (${bytes.size} bytes) to ${file.absolutePath}")
                    }
                } else if (!file.exists()) {
                    System.err.println("[Echo JarExtensionRepository] Warning: Could not locate bundled extension $name")
                }
            }
        } catch (e: Exception) {
            System.err.println("[Echo JarExtensionRepository] Error unpacking bundled extensions: ${e.message}")
        }
    }

    private fun findDiskExtensionStream(name: String): java.io.InputStream? {
        val candidates = listOf(
            File("app/resources/extensions", name),
            File("resources/extensions", name),
            File("desktopApp/src/desktopMain/resources/extensions", name),
            File("release-artifacts/Audix-Windows-Portable/app/resources/extensions", name)
        )
        for (f in candidates) {
            if (f.exists() && f.length() > 0L) {
                return runCatching { f.inputStream() }.getOrNull()
            }
        }
        return null
    }

    private data class CachedJar(
        val lastModified: Long,
        val result: Result<Pair<Metadata, Lazy<ExtensionClient>>>,
        val classLoader: URLClassLoader? = null
    )
    private val jarCache = mutableMapOf<String, CachedJar>()

    private fun clearCache() {
        for (cached in jarCache.values) {
            runCatching { cached.classLoader?.close() }
        }
        jarCache.clear()
    }

    override val flow: Flow<List<Result<Pair<Metadata, Lazy<ExtensionClient>>>>> = flow {
        val builtins = mutableListOf<Result<Pair<Metadata, Lazy<ExtensionClient>>>>()
        runCatching {
            builtins.add(Result.success(
                dev.brahmkshatriya.echo.core.extensions.builtin.LocalMusicExtension.METADATA to lazy {
                    dev.brahmkshatriya.echo.core.extensions.builtin.LocalMusicExtension(platform, settings)
                }
            ))
        }
        var lastFingerprint: String? = null
        while (true) {
            val extensionsDir = platform.extensionsDir.toFile().also { it.mkdirs() }
            val jarFiles = extensionsDir.listFiles { f -> f.extension.equals("jar", ignoreCase = true) } ?: emptyArray()
            val currentFingerprint = jarFiles.sortedBy { it.absolutePath }
                .joinToString(";") { "${it.absolutePath}:${it.lastModified()}" }

            if (currentFingerprint != lastFingerprint) {
                lastFingerprint = currentFingerprint
                val scanned = scanExtensions(jarFiles)
                println("[Echo JarExtensionRepository] Extensions list changed. Emitting ${scanned.size} JAR extension(s) + builtins.")
                emit(scanned + builtins)
            }
            delay(3_000)
        }
    }

    private fun scanExtensions(jarFiles: Array<File>): List<Result<Pair<Metadata, Lazy<ExtensionClient>>>> {
        val currentPaths = jarFiles.map { it.absolutePath }.toSet()
        val removed = jarCache.keys - currentPaths
        for (path in removed) {
            jarCache.remove(path)?.classLoader?.let { loader ->
                runCatching { loader.close() }
            }
        }

        return jarFiles.map { jar ->
            val cached = jarCache[jar.absolutePath]
            if (cached != null && cached.lastModified == jar.lastModified()) {
                cached.result
            } else {
                runCatching { cached?.classLoader?.close() }
                val (res, loader) = loadJarWithLoader(jar.absolutePath)
                jarCache[jar.absolutePath] = CachedJar(jar.lastModified(), res, loader)
                res
            }
        }
    }

    private fun loadJarWithLoader(jarPath: String): Pair<Result<Pair<Metadata, Lazy<ExtensionClient>>>, URLClassLoader?> {
        var createdLoader: URLClassLoader? = null
        val res = runCatching {
            val jarFileObj = File(jarPath).canonicalFile
            val allowedDir = platform.extensionsDir.toFile().canonicalFile
            require(jarFileObj.parentFile == allowedDir) {
                "Security exception: Refusing to load extension outside extensions directory: ${jarFileObj.absolutePath}"
            }
            val metadata = parseExtensionMetadata(jarFileObj.absolutePath)

            val dangerousPackages = listOf("java.", "javax.", "sun.", "com.sun.", "jdk.", "org.apache.commons.", "org.springframework.")
            if (dangerousPackages.any { metadata.className.startsWith(it) }) {
                error("Security violation: Class '${metadata.className}' is in a protected or restricted system package.")
            }

            println("[Echo] Discovered JAR extension: ${metadata.name} (${metadata.id}) at $jarPath")
            val loader = URLClassLoader(
                arrayOf(jarFileObj.toURI().toURL()),
                javaClass.classLoader
            )
            createdLoader = loader

            val lazyClient = lazy {
                try {
                    println("[Echo] Loading extension class: ${metadata.className}")
                    val clazz = loader.loadClass(metadata.className)
                    if (!ExtensionClient::class.java.isAssignableFrom(clazz)) {
                        error("Security violation: Class '${metadata.className}' does not implement ExtensionClient.")
                    }
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
            runCatching { createdLoader?.close() }
            createdLoader = null
        }
        return res to createdLoader
    }

    private fun parseExtensionMetadata(jarPath: String): Metadata {
        val file = File(jarPath)
        if (file.extension.equals("apk", ignoreCase = true) || file.extension.equals("eapk", ignoreCase = true)) {
            error("Cannot load Android APK '${file.name}'. Echo Desktop requires JVM JAR extensions (.jar).")
        }
        return JarFile(jarPath).use { jarFile ->
            val jsonEntry = jarFile.getJarEntry("META-INF/echo-extension.json")
            if (jsonEntry != null) {
                val jsonStr = jarFile.getInputStream(jsonEntry).bufferedReader().readText()
                val dto = json.decodeFromString<ExtensionManifest>(jsonStr)
                val fullClassName = if (dto.className.contains('.')) dto.className else "dev.brahmkshatriya.echo.extension.${dto.className}"
                val isEnabled = settings?.getBoolean("ext_enabled_${dto.id}", true) ?: true
                Metadata(
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
            } else {
                // Fallback: Read standard Echo MANIFEST.MF attributes
                val manifest = jarFile.manifest
                    ?: error("Neither META-INF/echo-extension.json nor MANIFEST.MF found in ${file.name}")
                val attrs = manifest.mainAttributes
                val rawClass = attrs.getValue("Extension-Class")
                    ?: error("Missing Extension-Class attribute in MANIFEST.MF of ${file.name}")
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

                val type = runCatching { ExtensionType.valueOf(typeStr) }.getOrDefault(ExtensionType.MUSIC)
                val isEnabled = settings?.getBoolean("ext_enabled_$id", true) ?: true
                Metadata(
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
        }
    }

    private fun verifyJarMagicBytes(file: File) {
        require(file.exists() && file.length() >= 4) { "Invalid JAR file: file is empty or missing" }
        file.inputStream().use { input ->
            val header = ByteArray(4)
            val read = input.read(header)
            require(read == 4 && header[0] == 0x50.toByte() && header[1] == 0x4B.toByte() &&
                    header[2] == 0x03.toByte() && header[3] == 0x04.toByte()) {
                "Security violation: File is not a valid ZIP/JAR archive (invalid magic bytes)"
            }
        }
    }

    override suspend fun install(source: ExtensionInstallSource): Result<Metadata> {
        return runCatching {
            val destDir = platform.extensionsDir.toFile().also { it.mkdirs() }
            when (source) {
                is ExtensionInstallSource.LocalFile -> {
                    val src = File(source.path).canonicalFile
                    if (src.extension.equals("apk", ignoreCase = true) || src.extension.equals("eapk", ignoreCase = true)) {
                        error("Cannot install '${src.name}'. Android APK/EAPK files run Dalvik bytecode (.dex). Echo Desktop requires Kotlin JVM .jar extensions. Please use or compile the .jar release of this extension.")
                    }
                    verifyJarMagicBytes(src)
                    val safeName = src.name.replace(Regex("[^a-zA-Z0-9._-]"), "_")
                    val dest = File(destDir, safeName).canonicalFile
                    require(dest.parentFile == destDir.canonicalFile) { "Security violation: Path traversal detected in extension name." }
                    src.copyTo(dest, overwrite = true)
                    verifyJarMagicBytes(dest)
                    parseExtensionMetadata(dest.absolutePath)
                }
                is ExtensionInstallSource.RemoteUrl -> {
                    fun validateRemoteUrl(uStr: String): URL {
                        require(uStr.startsWith("https://", ignoreCase = true)) {
                            "Security violation: Extensions may only be downloaded over secure HTTPS."
                        }
                        val u = URI(uStr).toURL()
                        val h = (u.host ?: "").lowercase()
                        require(h.isNotBlank() && h != "localhost" && h != "127.0.0.1" && h != "::1" && h != "169.254.169.254" && h != "0.0.0.0") {
                            "Security violation: Extension download from loopback or internal address is prohibited."
                        }
                        val inet = runCatching { java.net.InetAddress.getByName(h) }.getOrNull()
                        if (inet != null) {
                            require(!inet.isLoopbackAddress && !inet.isSiteLocalAddress && !inet.isLinkLocalAddress && !inet.isAnyLocalAddress) {
                                "Security violation: Extension download from private network is prohibited."
                            }
                        }
                        return u
                    }

                    var url = validateRemoteUrl(source.url.trim())
                    val rawFile = url.file.substringAfterLast('/')
                    val fileName = if (rawFile.endsWith(".jar", ignoreCase = true)) rawFile else "$rawFile.jar"
                    val safeName = fileName.replace(Regex("[^a-zA-Z0-9._-]"), "_")
                    val dest = File(destDir, safeName).canonicalFile
                    require(dest.parentFile == destDir.canonicalFile) { "Security violation: Path traversal detected in extension name." }

                    var conn: java.net.HttpURLConnection? = null
                    var redirects = 0
                    while (redirects < 4) {
                        val c = url.openConnection() as java.net.HttpURLConnection
                        c.instanceFollowRedirects = false
                        c.connectTimeout = 15000
                        c.readTimeout = 30000
                        c.setRequestProperty("User-Agent", "Audix/1.0 (Windows; Desktop)")
                        c.connect()
                        val responseCode = c.responseCode
                        if (responseCode in 300..399) {
                            val location = c.getHeaderField("Location")
                            c.disconnect()
                            require(!location.isNullOrBlank()) { "Invalid redirect without Location header" }
                            val resolvedUri = url.toURI().resolve(location)
                            url = validateRemoteUrl(resolvedUri.toString())
                            redirects++
                            continue
                        }
                        conn = c
                        break
                    }
                    val finalConn = conn ?: error("Failed to establish secure connection to download extension.")
                    try {
                        val input = finalConn.inputStream
                        val output = dest.outputStream()
                        val buf = ByteArray(16384)
                        var total = 0L
                        var n: Int
                        try {
                            while (input.read(buf).also { n = it } != -1) {
                                total += n
                                if (total > 50L * 1024 * 1024) {
                                    throw SecurityException("Security violation: Extension exceeds maximum allowed file size of 50 MB.")
                                }
                                output.write(buf, 0, n)
                            }
                            output.flush()
                        } finally {
                            runCatching { output.close() }
                            runCatching { input.close() }
                        }
                    } finally {
                        runCatching { finalConn.disconnect() }
                    }

                    verifyJarMagicBytes(dest)
                    parseExtensionMetadata(dest.absolutePath)
                }
            }
        }
    }

    override suspend fun uninstall(id: String, type: ExtensionType): Result<Unit> {
        return runCatching {
            val extensionsDir = platform.extensionsDir.toFile().also { it.mkdirs() }
            val jarFiles = extensionsDir.listFiles { f -> f.extension.equals("jar", ignoreCase = true) } ?: emptyArray()
            for (jar in jarFiles) {
                runCatching {
                    val meta = parseExtensionMetadata(jar.absolutePath)
                    if (meta.id == id && meta.type == type) {
                        jarCache.remove(jar.absolutePath)?.classLoader?.let { loader ->
                            runCatching { loader.close() }
                        }
                        System.gc()
                        jar.delete()
                        println("[Echo JarExtensionRepository] Deleted uninstalled extension jar: ${jar.name}")
                    }
                }
            }
            clearCache()
            Unit
        }
    }

    override suspend fun setEnabled(id: String, enabled: Boolean) {
        settings?.putBoolean("ext_enabled_$id", enabled)
        clearCache()
    }

    override suspend fun reload() {
        clearCache()
    }
}
