package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.LyricsClient
import dev.brahmkshatriya.echo.common.models.Feed
import dev.brahmkshatriya.echo.common.models.Feed.Companion.toFeed
import dev.brahmkshatriya.echo.common.models.Lyrics
import dev.brahmkshatriya.echo.common.models.Track
import dev.brahmkshatriya.echo.common.settings.Setting
import dev.brahmkshatriya.echo.common.settings.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

class GeniusExtension : LyricsClient {

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    override suspend fun searchTrackLyrics(clientId: String, track: Track): Feed<Lyrics> = withContext(Dispatchers.IO) {
        val title = track.title.trim()
        val artist = track.artists.firstOrNull()?.name?.trim() ?: ""

        val list = mutableListOf<Lyrics>()

        // 1. Try Genius multi-search
        val geniusLyrics = trySearchGenius(title, artist)
        if (geniusLyrics != null) {
            list.add(geniusLyrics)
        }

        // 2. Fallback to LRCLIB plain/synced lyrics if Genius was blocked or not found
        if (list.isEmpty()) {
            val fallback = tryGetLrclib(title, artist)
            if (fallback != null) {
                list.add(fallback)
            }
        }

        list.toFeed()
    }

    override suspend fun loadLyrics(lyrics: Lyrics): Lyrics = withContext(Dispatchers.IO) {
        if (lyrics.lyrics != null) return@withContext lyrics

        val url = lyrics.extras["url"] ?: return@withContext lyrics
        val text = fetchGeniusHtmlLyrics(url)
        if (!text.isNullOrBlank()) {
            lyrics.copy(lyrics = Lyrics.Simple(text))
        } else {
            lyrics
        }
    }

    private fun trySearchGenius(title: String, artist: String): Lyrics? {
        return runCatching {
            val query = if (artist.isNotBlank()) "$title $artist" else title
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://genius.com/api/search/multi?q=$encoded"

            val req = Request.Builder()
                .url(url)
                .header("User-Agent", userAgent)
                .header("Accept", "application/json")
                .build()

            val body = client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return@runCatching null
                resp.body.string()
            }

            val root = json.parseToJsonElement(body).jsonObject
            val sections = root["response"]?.jsonObject?.get("sections")?.jsonArray ?: return@runCatching null

            for (sec in sections) {
                val hits = sec.jsonObject["hits"]?.jsonArray ?: continue
                for (h in hits) {
                    val res = h.jsonObject["result"]?.jsonObject ?: continue
                    val songTitle = res["title"]?.jsonPrimitive?.content ?: title
                    val songArtist = res["primary_artist"]?.jsonObject?.get("name")?.jsonPrimitive?.content ?: artist
                    val songUrl = res["url"]?.jsonPrimitive?.content ?: continue
                    val songId = res["id"]?.jsonPrimitive?.content ?: songTitle.hashCode().toString()

                    val lyricsText = fetchGeniusHtmlLyrics(songUrl)
                    val lyricContent = if (!lyricsText.isNullOrBlank()) {
                        Lyrics.Simple(lyricsText)
                    } else null

                    return@runCatching Lyrics(
                        id = "genius_$songId",
                        title = songTitle,
                        subtitle = songArtist,
                        lyrics = lyricContent,
                        extras = mapOf(
                            "url" to songUrl,
                            "source" to "Genius"
                        )
                    )
                }
            }
            null
        }.getOrNull()
    }

    private fun fetchGeniusHtmlLyrics(url: String): String? {
        return runCatching {
            val req = Request.Builder()
                .url(url)
                .header("User-Agent", userAgent)
                .header("Accept", "text/html")
                .build()

            val body = client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return@runCatching null
                resp.body.string()
            }

            // Extract text from Lyrics__Container or lyrics div
            val containerPattern = Pattern.compile("<div[^>]+data-lyrics-container=\"true\"[^>]*>(.*?)</div>", Pattern.DOTALL)
            val matcher = containerPattern.matcher(body)
            val sb = StringBuilder()
            var found = false
            while (matcher.find()) {
                found = true
                val snippet = matcher.group(1)
                val clean = cleanHtmlSnippet(snippet)
                sb.append(clean).append("\n\n")
            }

            if (found && sb.isNotBlank()) {
                return@runCatching sb.toString().trim()
            }

            // Fallback old layout <div class="lyrics">
            val oldPattern = Pattern.compile("<div class=\"lyrics\">(.*?)</div>", Pattern.DOTALL)
            val oldMatcher = oldPattern.matcher(body)
            if (oldMatcher.find()) {
                val clean = cleanHtmlSnippet(oldMatcher.group(1))
                if (clean.isNotBlank()) return@runCatching clean
            }

            null
        }.getOrNull()
    }

    private fun cleanHtmlSnippet(html: String): String {
        return html
            .replace("<br/>", "\n")
            .replace("<br>", "\n")
            .replace("<br />", "\n")
            .replace(Regex("<[^>]+>"), "")
            .replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&quot;", "\"")
            .replace("&#x27;", "'")
            .replace("&#39;", "'")
            .trim()
    }

    private fun tryGetLrclib(title: String, artist: String): Lyrics? {
        return runCatching {
            val query = if (artist.isNotBlank()) "$title $artist" else title
            val encoded = URLEncoder.encode(query, "UTF-8")
            val url = "https://lrclib.net/api/search?q=$encoded"

            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Audix/1.0.0")
                .build()

            val body = client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return@runCatching null
                resp.body.string()
            }

            val array = json.parseToJsonElement(body).jsonArray
            if (array.isEmpty()) return@runCatching null

            val first = array[0].jsonObject
            val id = first["id"]?.jsonPrimitive?.content ?: return@runCatching null
            val trackName = first["trackName"]?.jsonPrimitive?.content ?: title
            val artistName = first["artistName"]?.jsonPrimitive?.content ?: artist
            val plain = first["plainLyrics"]?.jsonPrimitive?.content

            if (plain.isNullOrBlank()) return@runCatching null

            Lyrics(
                id = "genius_fallback_$id",
                title = trackName,
                subtitle = artistName,
                lyrics = Lyrics.Simple(plain),
                extras = mapOf("source" to "Genius/LRCLIB")
            )
        }.getOrNull()
    }
}
