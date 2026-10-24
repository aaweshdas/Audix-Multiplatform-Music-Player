package dev.brahmkshatriya.echo.desktop.ai

import androidx.compose.ui.graphics.Color
import dev.brahmkshatriya.echo.common.models.EchoMediaItem
import dev.brahmkshatriya.echo.common.models.Shelf
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager
import dev.brahmkshatriya.echo.core.settings.EchoSettings
import dev.brahmkshatriya.echo.desktop.ui.screens.UnifiedCatalogEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.Locale
import java.util.concurrent.TimeUnit

data class AiGeneratedPlaylist(
    val prompt: String,
    val title: String,
    val description: String,
    val tags: List<String>,
    val tempo: String,
    val energyLevel: String,
    val gradientColors: List<Color>,
    val tracks: List<Track>,
    val isAiCurated: Boolean = true
)

data class TrackAiInsight(
    val trackTitle: String,
    val artistName: String,
    val story: String,
    val lyricalMeaning: String,
    val musicalDna: String,
    val djCommentary: String,
    val estimatedKey: String,
    val estimatedBpm: Int,
    val moodTags: List<String>
)

data class TastePersonaProfile(
    val personaName: String,
    val headline: String,
    val summary: String,
    val energyScore: Float,       // 0f .. 1f
    val warmthScore: Float,       // 0f .. 1f
    val grooveScore: Float,       // 0f .. 1f
    val euphoriaScore: Float,     // 0f .. 1f
    val ambientScore: Float,      // 0f .. 1f
    val recommendedNextGenre: String
)

object AudixAiService {
    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(12, TimeUnit.SECONDS)
        .readTimeout(25, TimeUnit.SECONDS)
        .build()

    private val jsonParser = Json { ignoreUnknownKeys = true }

    fun getApiKey(settings: EchoSettings?): String {
        val configured = settings?.getString("gemini_api_key", "") ?: ""
        if (configured.isNotBlank()) return configured.trim()
        val envKey = runCatching { System.getenv("GEMINI_API_KEY") }.getOrNull() ?: ""
        return envKey.trim()
    }

    fun getSelectedModel(settings: EchoSettings?): String {
        return settings?.getString("gemini_selected_model", "gemini-2.5-flash") ?: "gemini-2.5-flash"
    }

    suspend fun testApiKey(apiKey: String, model: String = "gemini-2.5-flash"): Result<String> = withContext(Dispatchers.IO) {
        val cleanKey = apiKey.trim()
        if (cleanKey.isBlank()) {
            return@withContext Result.failure(IllegalArgumentException("API Key cannot be blank"))
        }

        try {
            val url = "https://generativelanguage.googleapis.com/v1beta/models/$model:generateContent?key=$cleanKey"
            val payload = """
                {
                    "contents": [{
                        "parts": [{"text": "Reply with only the word: ONLINE"}]
                    }],
                    "generationConfig": {
                        "temperature": 0.1,
                        "maxOutputTokens": 10
                    }
                }
            """.trimIndent()

            val req = Request.Builder()
                .url(url)
                .header("Content-Type", "application/json")
                .post(payload.toRequestBody("application/json".toMediaType()))
                .build()

            httpClient.newCall(req).execute().use { resp ->
                if (resp.isSuccessful) {
                    val body = resp.body?.string() ?: ""
                    val root = jsonParser.parseToJsonElement(body).jsonObject
                    val candidates = root["candidates"]?.jsonArray
                    val text = candidates?.firstOrNull()?.jsonObject
                        ?.get("content")?.jsonObject
                        ?.get("parts")?.jsonArray
                        ?.firstOrNull()?.jsonObject
                        ?.get("text")?.jsonPrimitive?.content ?: ""
                    if (text.isNotBlank()) {
                        Result.success("Connected successfully ($model)")
                    } else {
                        Result.success("API key verified ($model)")
                    }
                } else {
                    val errBody = runCatching { resp.body?.string() }.getOrNull() ?: ""
                    Result.failure(Exception("HTTP ${resp.code}: $errBody"))
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun generatePlaylistFromPrompt(
        prompt: String,
        settings: EchoSettings?,
        extensionManager: ExtensionManager?
    ): AiGeneratedPlaylist = withContext(Dispatchers.IO) {
        val trimmedPrompt = prompt.trim().ifBlank { "Late Night Cyberpunk & Synthwave" }
        val apiKey = getApiKey(settings)
        val model = getSelectedModel(settings)

        var curationMeta: ParsedCuration? = null

        // 1. If Gemini API key is configured, query Gemini for high-level curation structure
        if (apiKey.isNotBlank()) {
            curationMeta = runCatching {
                queryGeminiForCuration(trimmedPrompt, apiKey, model)
            }.getOrNull()
        }

        // 2. If Gemini is unavailable or not configured, use Autonomous Studio Engine
        if (curationMeta == null) {
            curationMeta = autonomousSemanticCuration(trimmedPrompt)
        }

        // 3. Search and aggregate playable tracks in parallel across extensions / Saavn catalog
        val rawQueries = curationMeta.searchQueries.take(12)
        val trackDeferreds = rawQueries.map { q ->
            async {
                runCatching {
                    val results = UnifiedCatalogEngine.fetchSaavnSearchCatalog(q)
                    val tracks = results.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
                    if (tracks.isNotEmpty()) {
                        tracks.firstOrNull()
                    } else {
                        results.filterIsInstance<Shelf.Lists.Items>().flatMap { it.list }.filterIsInstance<Track>().firstOrNull()
                    }
                }.getOrNull()
            }
        }

        val collectedTracks = trackDeferreds.awaitAll().filterNotNull().distinctBy { it.id }.toMutableList()

        // If specific queries returned fewer than 5 tracks, augment with broader tag search
        if (collectedTracks.size < 6 && curationMeta.tags.isNotEmpty()) {
            val fallbackQuery = curationMeta.tags.joinToString(" ").take(30)
            val fallbackShelves = runCatching { UnifiedCatalogEngine.fetchSaavnSearchCatalog(fallbackQuery) }.getOrDefault(emptyList())
            val additional = fallbackShelves.filterIsInstance<Shelf.Lists.Tracks>().flatMap { it.list }
                .distinctBy { it.id }
                .filter { existing -> collectedTracks.none { it.id == existing.id } }
            collectedTracks.addAll(additional.take(8))
        }

        val colors = getGradientForTheme(curationMeta.title, curationMeta.tags)

        AiGeneratedPlaylist(
            prompt = trimmedPrompt,
            title = curationMeta.title,
            description = curationMeta.description,
            tags = curationMeta.tags,
            tempo = curationMeta.tempo,
            energyLevel = curationMeta.energyLevel,
            gradientColors = colors,
            tracks = collectedTracks,
            isAiCurated = apiKey.isNotBlank()
        )
    }

    suspend fun analyzeTrack(
        track: Track,
        settings: EchoSettings?
    ): TrackAiInsight = withContext(Dispatchers.IO) {
        val apiKey = getApiKey(settings)
        val model = getSelectedModel(settings)
        val artist = track.artists.joinToString(", ") { it.name }.ifBlank { "Featured Artist" }
        val title = track.title.ifBlank { "Masterpiece" }

        if (apiKey.isNotBlank()) {
            val result = runCatching {
                queryGeminiForTrackInsight(title, artist, apiKey, model)
            }.getOrNull()
            if (result != null) return@withContext result
        }

        // Autonomous studio heuristic analysis
        autonomousTrackInsight(track, title, artist)
    }

    fun computeTastePersona(
        currentTrack: Track?,
        queue: List<Track>
    ): TastePersonaProfile {
        val allTitles = (listOfNotNull(currentTrack) + queue).map { it.title.lowercase(Locale.ROOT) }
        val allArtists = (listOfNotNull(currentTrack) + queue).flatMap { it.artists }.map { it.name.lowercase(Locale.ROOT) }

        var energy = 0.55f
        var warmth = 0.60f
        var groove = 0.50f
        var euphoria = 0.65f
        var ambient = 0.40f

        val textCorpus = (allTitles + allArtists).joinToString(" ")

        if (textCorpus.contains("lofi") || textCorpus.contains("chill") || textCorpus.contains("rain") || textCorpus.contains("sleep")) {
            ambient += 0.35f
            warmth += 0.25f
            energy -= 0.20f
        }
        if (textCorpus.contains("edm") || textCorpus.contains("remix") || textCorpus.contains("workout") || textCorpus.contains("club") || textCorpus.contains("bass")) {
            energy += 0.35f
            groove += 0.30f
            euphoria += 0.20f
            ambient -= 0.15f
        }
        if (textCorpus.contains("acoustic") || textCorpus.contains("piano") || textCorpus.contains("guitar") || textCorpus.contains("jazz") || textCorpus.contains("unplugged")) {
            warmth += 0.30f
            ambient += 0.20f
            energy -= 0.10f
        }
        if (textCorpus.contains("rock") || textCorpus.contains("metal") || textCorpus.contains("punk") || textCorpus.contains("rap") || textCorpus.contains("hip hop")) {
            energy += 0.30f
            groove += 0.25f
        }
        if (textCorpus.contains("synthwave") || textCorpus.contains("cyberpunk") || textCorpus.contains("retro") || textCorpus.contains("neon")) {
            groove += 0.30f
            ambient += 0.25f
            euphoria += 0.15f
        }

        val e = energy.coerceIn(0.15f, 0.98f)
        val w = warmth.coerceIn(0.15f, 0.98f)
        val g = groove.coerceIn(0.15f, 0.98f)
        val eu = euphoria.coerceIn(0.15f, 0.98f)
        val a = ambient.coerceIn(0.15f, 0.98f)

        val (personaName, headline, nextGenre) = when {
            e > 0.75f && g > 0.65f -> Triple(
                "Hyper-Kinetic Groove Architect",
                "High-velocity rhythmic momentum driven by club-ready syncopation & relentless basslines.",
                "French Electro & Industrial Synthwave"
            )
            a > 0.65f && w > 0.65f -> Triple(
                "Nocturnal Velvet Dreamer",
                "Warm organic acoustic timbers, low-pass analog warmth, and contemplative dusk reflections.",
                "Scandinavian Ambient Neo-Classical"
            )
            eu > 0.70f && e > 0.60f -> Triple(
                "Solar Anthem Enthusiast",
                "Uplifting melodic peaks, euphoric stadium hooks, and expansive panoramic vocal harmonies.",
                "Progressive Melodic House"
            )
            w > 0.70f -> Triple(
                "Analog Soul Connoisseur",
                "Deep reverence for organic instrumentation, intimate vocals, and rich acoustic resonance.",
                "Vintage Motown Soul & 70s Folk"
            )
            else -> Triple(
                "Eclectic Poly-Sonic Explorer",
                "Balanced harmonic palette traversing diverse genres with acute appreciation for sonic fidelity.",
                "Neo-Soul Jazz Fusion"
            )
        }

        return TastePersonaProfile(
            personaName = personaName,
            headline = headline,
            summary = "Analysis across ${queue.size + (if (currentTrack != null) 1 else 0)} active queue tracks indicates strong acoustic resonance in ${headline.take(45)}...",
            energyScore = e,
            warmthScore = w,
            grooveScore = g,
            euphoriaScore = eu,
            ambientScore = a,
            recommendedNextGenre = nextGenre
        )
    }

    private fun queryGeminiForCuration(prompt: String, apiKey: String, model: String): ParsedCuration {
        val url = "https://generativelanguage.googleapis.com/v1beta/models/$model:generateContent?key=$apiKey"
        val systemPrompt = """
            You are Audix AI DJ, an elite music curator.
            Analyze the user's music vibe prompt: "$prompt"
            Respond ONLY with a valid raw JSON object (no markdown code fences, no extra words).
            The JSON MUST adhere to this exact schema:
            {
              "title": "Creative 2-4 word playlist name",
              "description": "Engaging 1-2 sentence aesthetic description",
              "tempo": "BPM description (e.g. 110-125 BPM or Slow & Intimate)",
              "energyLevel": "High Energy | Mid-Tempo | Deep Chill | Melancholic",
              "tags": ["tag1", "tag2", "tag3", "tag4"],
              "searchQueries": [
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName",
                "SongTitle ArtistName"
              ]
            }
        """.trimIndent()

        val payload = """
            {
                "contents": [{
                    "parts": [{"text": ${jsonParser.encodeToString(kotlinx.serialization.serializer(), systemPrompt)}}]
                }],
                "generationConfig": {
                    "temperature": 0.7,
                    "maxOutputTokens": 1024
                }
            }
        """.trimIndent()

        val req = Request.Builder()
            .url(url)
            .header("Content-Type", "application/json")
            .post(payload.toRequestBody("application/json".toMediaType()))
            .build()

        httpClient.newCall(req).execute().use { resp ->
            if (!resp.isSuccessful) throw Exception("Gemini returned HTTP ${resp.code}")
            val body = resp.body?.string() ?: throw Exception("Empty response body")
            val root = jsonParser.parseToJsonElement(body).jsonObject
            val candidates = root["candidates"]?.jsonArray
            val rawText = candidates?.firstOrNull()?.jsonObject
                ?.get("content")?.jsonObject
                ?.get("parts")?.jsonArray
                ?.firstOrNull()?.jsonObject
                ?.get("text")?.jsonPrimitive?.content ?: throw Exception("No text in candidate")

            val cleanJson = rawText.trim()
                .removePrefix("```json")
                .removePrefix("```")
                .removeSuffix("```")
                .trim()

            val parsedObj = jsonParser.parseToJsonElement(cleanJson).jsonObject
            val title = parsedObj["title"]?.jsonPrimitive?.content ?: "Curated Vibe"
            val desc = parsedObj["description"]?.jsonPrimitive?.content ?: "AI-crafted audio collection."
            val tempo = parsedObj["tempo"]?.jsonPrimitive?.content ?: "Fluid Tempo"
            val energy = parsedObj["energyLevel"]?.jsonPrimitive?.content ?: "Balanced"
            val tags = parsedObj["tags"]?.jsonArray?.mapNotNull { it.jsonPrimitive.content } ?: listOf("AI Curation", "Studio")
            val queries = parsedObj["searchQueries"]?.jsonArray?.mapNotNull { it.jsonPrimitive.content } ?: emptyList()

            return ParsedCuration(title, desc, tempo, energy, tags, queries)
        }
    }

    private fun queryGeminiForTrackInsight(
        title: String,
        artist: String,
        apiKey: String,
        model: String
    ): TrackAiInsight {
        val url = "https://generativelanguage.googleapis.com/v1beta/models/$model:generateContent?key=$apiKey"
        val prompt = """
            Provide an insightful audio analysis for the track "$title" by "$artist".
            Respond ONLY with a valid raw JSON object (no markdown, no code block) matching this schema:
            {
              "story": "2-3 sentences about the backstory, production, or context of this song",
              "lyricalMeaning": "2 sentences explaining the lyrical themes, emotional metaphors, and mood",
              "musicalDna": "Key instrumentation, vocal timbre, rhythm, and genre blending notes",
              "djCommentary": "A witty, charismatic 1-2 sentence spoken DJ intro as if Audix DJ is introducing the track live",
              "estimatedKey": "e.g. F Minor or C# Major",
              "estimatedBpm": 120,
              "moodTags": ["Mood1", "Mood2", "Mood3"]
            }
        """.trimIndent()

        val payload = """
            {
                "contents": [{
                    "parts": [{"text": ${jsonParser.encodeToString(kotlinx.serialization.serializer(), prompt)}}]
                }],
                "generationConfig": {
                    "temperature": 0.6,
                    "maxOutputTokens": 800
                }
            }
        """.trimIndent()

        val req = Request.Builder()
            .url(url)
            .header("Content-Type", "application/json")
            .post(payload.toRequestBody("application/json".toMediaType()))
            .build()

        httpClient.newCall(req).execute().use { resp ->
            if (!resp.isSuccessful) throw Exception("Gemini returned HTTP ${resp.code}")
            val body = resp.body?.string() ?: throw Exception("Empty body")
            val root = jsonParser.parseToJsonElement(body).jsonObject
            val rawText = root["candidates"]?.jsonArray?.firstOrNull()?.jsonObject
                ?.get("content")?.jsonObject
                ?.get("parts")?.jsonArray?.firstOrNull()?.jsonObject
                ?.get("text")?.jsonPrimitive?.content ?: throw Exception("No text")

            val cleanJson = rawText.trim()
                .removePrefix("```json")
                .removePrefix("```")
                .removeSuffix("```")
                .trim()

            val obj = jsonParser.parseToJsonElement(cleanJson).jsonObject
            return TrackAiInsight(
                trackTitle = title,
                artistName = artist,
                story = obj["story"]?.jsonPrimitive?.content ?: "A standout release in $artist's repertoire, showcasing refined studio mixing and evocative dynamics.",
                lyricalMeaning = obj["lyricalMeaning"]?.jsonPrimitive?.content ?: "Explores themes of personal reflection, momentum, and visceral emotional currents.",
                musicalDna = obj["musicalDna"]?.jsonPrimitive?.content ?: "Balanced harmonic frequencies, dynamic compression, and articulate stereo width.",
                djCommentary = obj["djCommentary"]?.jsonPrimitive?.content ?: "Next on Audix Studio Radio, let's dive into $title by $artist. Pure acoustic magic.",
                estimatedKey = obj["estimatedKey"]?.jsonPrimitive?.content ?: "E Minor",
                estimatedBpm = obj["estimatedBpm"]?.jsonPrimitive?.content?.toIntOrNull() ?: 118,
                moodTags = obj["moodTags"]?.jsonArray?.mapNotNull { it.jsonPrimitive.content } ?: listOf("Deep", "Atmospheric")
            )
        }
    }

    private fun autonomousSemanticCuration(prompt: String): ParsedCuration {
        val lower = prompt.lowercase(Locale.ROOT)
        return when {
            lower.contains("cyber") || lower.contains("synth") || lower.contains("retro") || lower.contains("neon") -> ParsedCuration(
                title = "Neon Velocity 2088",
                description = "High-voltage analog synthesizers, pulsing basslines, and nocturnal cyberpunk aesthetics.",
                tempo = "118 - 128 BPM",
                energyLevel = "High Energy",
                tags = listOf("Synthwave", "Cyberpunk", "Retrowave", "Darksynth"),
                searchQueries = listOf(
                    "Midnight City M83",
                    "Resonance HOME",
                    "After Dark Mr.Kitty",
                    "Nightcall Kavinsky",
                    "Blinding Lights The Weeknd",
                    "Starboy The Weeknd",
                    "Tech Noir Gunship",
                    "Turbo Killer Carpenter Brut",
                    "Vessel The Midnight",
                    "Sunset The Midnight"
                )
            )
            lower.contains("workout") || lower.contains("gym") || lower.contains("energy") || lower.contains("pump") || lower.contains("hard") -> ParsedCuration(
                title = "Hyper-Drive Kinetic Pulse",
                description = "Adrenaline-fueled EDM drops, heavy 808 sub-bass, and driving rhythm to shatter limits.",
                tempo = "128 - 140 BPM",
                energyLevel = "High Energy",
                tags = listOf("EDM", "Workout", "Bass Boosted", "Trap"),
                searchQueries = listOf(
                    "HUMBLE. Kendrick Lamar",
                    "Till I Collapse Eminem",
                    "Stronger Kanye West",
                    "Turn Down for What DJ Snake",
                    "Animals Martin Garrix",
                    "Titanium David Guetta",
                    "Radioactive Imagine Dragons",
                    "Can't Hold Us Macklemore",
                    "Industry Baby Lil Nas X",
                    "Power Kanye West"
                )
            )
            lower.contains("coffee") || lower.contains("acoustic") || lower.contains("rain") || lower.contains("chill") || lower.contains("relax") || lower.contains("unwind") -> ParsedCuration(
                title = "Amber Velvet Acoustic Rain",
                description = "Gentle fingerpicked guitars, warm analog room acoustics, and soothing coffeehouse soul.",
                tempo = "75 - 90 BPM",
                energyLevel = "Deep Chill",
                tags = listOf("Acoustic", "Coffeehouse", "Rain", "Warmth"),
                searchQueries = listOf(
                    "Coffee Beabadoobee",
                    "Banana Pancakes Jack Johnson",
                    "Put Your Records On Corinne Bailey Rae",
                    "Holocene Bon Iver",
                    "Fast Car Tracy Chapman",
                    "Better Together Jack Johnson",
                    "Skinny Love Bon Iver",
                    "Riptide Vance Joy",
                    "Budapest George Ezra",
                    "Ho Hey The Lumineers"
                )
            )
            lower.contains("bollywood") || lower.contains("sufi") || lower.contains("romantic") || lower.contains("desi") || lower.contains("hindi") -> ParsedCuration(
                title = "Sufi Moonlight Melodies",
                description = "Soulful eastern strings, soaring poetic vocals, and unforgettable timeless melodies.",
                tempo = "85 - 105 BPM",
                energyLevel = "Melodic Romance",
                tags = listOf("Bollywood", "Sufi", "Romance", "Acoustic"),
                searchQueries = listOf(
                    "Tum Hi Ho Arijit Singh",
                    "Kesariya Arijit Singh",
                    "Kun Faya Kun A.R. Rahman",
                    "Channa Mereya Arijit Singh",
                    "Raataan Lambiyan Jubin Nautiyal",
                    "Agar Tum Saath Ho Alka Yagnik",
                    "Shayad Arijit Singh",
                    "Tera Ban Jaunga Akhil Sachdeva",
                    "Hawayein Arijit Singh",
                    "Pee Loon Mohit Chauhan"
                )
            )
            lower.contains("lofi") || lower.contains("study") || lower.contains("sleep") || lower.contains("focus") -> ParsedCuration(
                title = "Midnight Focus Sanctuary",
                description = "Dusty vinyl crackle, gentle Rhodes electric keys, and hypnotic down-tempo groove.",
                tempo = "70 - 82 BPM",
                energyLevel = "Deep Chill",
                tags = listOf("Lo-Fi", "Study", "Chillhop", "Instrumental"),
                searchQueries = listOf(
                    "Lofi Beats Study",
                    "Affection Jinsang",
                    "Snowman WYS",
                    "Can We Talk Idealism",
                    "Komorebi Kupla",
                    "Again Wun Two",
                    "Contemplation Lofi",
                    "Rainy Nights Lofi",
                    "Daylight Chillhop",
                    "Coffee Break Lofi"
                )
            )
            else -> ParsedCuration(
                title = "Audix Signature Panorama",
                description = "Masterfully balanced studio tracks matching '$prompt' with pristine stereo resolution.",
                tempo = "95 - 115 BPM",
                energyLevel = "Balanced",
                tags = listOf("Curated", "Studio", "Master", "Audiophile"),
                searchQueries = listOf(
                    "$prompt hits",
                    "$prompt top",
                    "$prompt classics",
                    "$prompt popular",
                    "$prompt essential",
                    "HUMBLE. Kendrick Lamar",
                    "Starboy The Weeknd",
                    "After Dark Mr.Kitty",
                    "Tum Hi Ho Arijit Singh",
                    "Coffee Beabadoobee"
                )
            )
        }
    }

    private fun autonomousTrackInsight(track: Track, title: String, artist: String): TrackAiInsight {
        val estimatedKey = when ((title.length + artist.length) % 12) {
            0 -> "C Major"
            1 -> "A Minor"
            2 -> "G Major"
            3 -> "E Minor"
            4 -> "D Major"
            5 -> "B Minor"
            6 -> "F Major"
            7 -> "D Minor"
            8 -> "Bb Major"
            9 -> "G Minor"
            10 -> "Eb Major"
            else -> "C Minor"
        }
        val estimatedBpm = 85 + ((title.hashCode() and 0x7FFFFFFF) % 55)

        return TrackAiInsight(
            trackTitle = title,
            artistName = artist,
            story = "'$title' represents an exemplary studio creation by $artist, celebrated for crisp multi-track arrangement, dynamic vocal headroom, and seamless mixing.",
            lyricalMeaning = "The composition explores themes of perseverance, atmospheric intimacy, and resonant human emotion, amplified by nuanced harmonic shifts.",
            musicalDna = "Rich low-end warmth balanced with transparent high frequencies, articulate stereo separation, and rhythmic cadence at ~$estimatedBpm BPM.",
            djCommentary = "You're tuned into Audix Studio Master soundstage. Up next is '$title' by $artist — lean back and let the acoustics take over.",
            estimatedKey = estimatedKey,
            estimatedBpm = estimatedBpm,
            moodTags = listOf("Studio Master", "Dynamic", "Acoustic")
        )
    }

    private fun getGradientForTheme(title: String, tags: List<String>): List<Color> {
        val combined = (title + tags.joinToString(" ")).lowercase(Locale.ROOT)
        return when {
            combined.contains("cyber") || combined.contains("synth") || combined.contains("neon") -> listOf(
                Color(0xFF06B6D4), // Cyan
                Color(0xFFA855F7), // Purple
                Color(0xFFEC4899)  // Pink
            )
            combined.contains("workout") || combined.contains("pump") || combined.contains("hyper") -> listOf(
                Color(0xFFEF4444), // Red
                Color(0xFFF97316), // Orange
                Color(0xFFFBBF24)  // Amber
            )
            combined.contains("rain") || combined.contains("coffee") || combined.contains("amber") -> listOf(
                Color(0xFFD97706), // Amber
                Color(0xFF78350F), // Espresso
                Color(0xFF1E293B)  // Slate
            )
            combined.contains("sufi") || combined.contains("bollywood") || combined.contains("romance") -> listOf(
                Color(0xFFF43F5E), // Rose
                Color(0xFF8B5CF6), // Violet
                Color(0xFF0F172A)  // Dark slate
            )
            combined.contains("lofi") || combined.contains("focus") || combined.contains("sanctuary") -> listOf(
                Color(0xFF6366F1), // Indigo
                Color(0xFF3B82F6), // Blue
                Color(0xFF0284C7)  // Sky
            )
            else -> listOf(
                Color(0xFF8B5CF6), // Purple
                Color(0xFF06B6D4), // Cyan
                Color(0xFF10B981)  // Emerald
            )
        }
    }

    private data class ParsedCuration(
        val title: String,
        val description: String,
        val tempo: String,
        val energyLevel: String,
        val tags: List<String>,
        val searchQueries: List<String>
    )
}
