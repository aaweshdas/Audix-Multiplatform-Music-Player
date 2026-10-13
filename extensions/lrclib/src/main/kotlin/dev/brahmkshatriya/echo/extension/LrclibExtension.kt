package dev.brahmkshatriya.echo.extension

import dev.brahmkshatriya.echo.common.clients.LyricsClient
import dev.brahmkshatriya.echo.common.models.Feed
import dev.brahmkshatriya.echo.common.models.Feed.Companion.toFeed
import dev.brahmkshatriya.echo.common.models.Lyrics
import dev.brahmkshatriya.echo.common.settings.Setting
import dev.brahmkshatriya.echo.common.settings.Settings
import dev.brahmkshatriya.echo.common.models.Track
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

class LrclibExtension : LyricsClient {

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    private val lrcRegex = Pattern.compile("^\\[(\\d{2}):(\\d{2})\\.(\\d{2,3})\\]\\s*(.*)$")

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    override suspend fun searchTrackLyrics(clientId: String, track: Track): Feed<Lyrics> = withContext(Dispatchers.IO) {
        val title = track.title.trim()
        val artist = track.artists.firstOrNull()?.name?.trim() ?: ""
        val album = track.album?.title?.trim() ?: ""
        val duration = track.duration?.div(1000)

        // 1. Try exact get
        val exactLyrics = tryGetExact(title, artist, album, duration)
        if (exactLyrics != null) {
            return@withContext listOf(exactLyrics).toFeed()
        }

        // 2. Fallback to search
        val query = if (artist.isNotBlank()) "$title $artist" else title
        val searchList = searchLyrics(query)
        searchList.toFeed()
    }

    override suspend fun loadLyrics(lyrics: Lyrics): Lyrics = withContext(Dispatchers.IO) {
        if (lyrics.lyrics != null) return@withContext lyrics

        // Fetch full lyrics by ID if needed
        val id = lyrics.id
        try {
            val req = Request.Builder()
                .url("https://lrclib.net/api/get/$id")
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val obj = json.parseToJsonElement(body).jsonObject
            val synced = obj["syncedLyrics"]?.jsonPrimitive?.content
            val plain = obj["plainLyrics"]?.jsonPrimitive?.content

            val parsedLyric = parseLyricContent(synced, plain)
            lyrics.copy(lyrics = parsedLyric)
        } catch (_: Exception) {
            lyrics
        }
    }

    private fun tryGetExact(title: String, artist: String, album: String, durationSec: Long?): Lyrics? {
        return try {
            val qTitle = URLEncoder.encode(title, "UTF-8")
            val qArtist = URLEncoder.encode(artist, "UTF-8")
            val qAlbum = URLEncoder.encode(album, "UTF-8")
            var url = "https://lrclib.net/api/get?track_name=$qTitle&artist_name=$qArtist"
            if (album.isNotBlank()) url += "&album_name=$qAlbum"
            if (durationSec != null && durationSec > 0) url += "&duration=$durationSec"

            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return null
                val body = resp.body.string()
                val obj = json.parseToJsonElement(body).jsonObject
                val id = obj["id"]?.jsonPrimitive?.content ?: title
                val synced = obj["syncedLyrics"]?.jsonPrimitive?.content
                val plain = obj["plainLyrics"]?.jsonPrimitive?.content
                val parsed = parseLyricContent(synced, plain) ?: return null

                Lyrics(
                    id = id,
                    title = title,
                    subtitle = if (artist.isNotBlank()) "$artist • LRCLIB" else "LRCLIB",
                    lyrics = parsed
                )
            }
        } catch (_: Exception) {
            null
        }
    }

    private fun searchLyrics(query: String): List<Lyrics> {
        return try {
            val encoded = URLEncoder.encode(query, "UTF-8")
            val req = Request.Builder()
                .url("https://lrclib.net/api/search?q=$encoded")
                .header("User-Agent", "Audix/1.0.0 (Windows; OpenJDK 21)")
                .build()

            val body = client.newCall(req).execute().use { it.body.string() }
            val arr = json.parseToJsonElement(body).jsonArray

            arr.mapNotNull { elem ->
                runCatching {
                    val obj = elem.jsonObject
                    val id = obj["id"]?.jsonPrimitive?.content ?: return@runCatching null
                    val tName = obj["trackName"]?.jsonPrimitive?.content ?: obj["name"]?.jsonPrimitive?.content ?: "Track"
                    val aName = obj["artistName"]?.jsonPrimitive?.content ?: ""
                    val synced = obj["syncedLyrics"]?.jsonPrimitive?.content
                    val plain = obj["plainLyrics"]?.jsonPrimitive?.content
                    val parsed = parseLyricContent(synced, plain)

                    Lyrics(
                        id = id,
                        title = tName,
                        subtitle = if (aName.isNotBlank()) "$aName • LRCLIB" else "LRCLIB",
                        lyrics = parsed
                    )
                }.getOrNull()
            }
        } catch (_: Exception) {
            emptyList()
        }
    }

    private fun parseLyricContent(synced: String?, plain: String?): Lyrics.Lyric? {
        if (!synced.isNullOrBlank()) {
            val items = mutableListOf<Lyrics.Item>()
            val lines = synced.lines()
            for (line in lines) {
                val matcher = lrcRegex.matcher(line.trim())
                if (matcher.matches()) {
                    val min = matcher.group(1).toLongOrNull() ?: 0L
                    val sec = matcher.group(2).toLongOrNull() ?: 0L
                    val fracStr = matcher.group(3)
                    val frac = fracStr.toLongOrNull() ?: 0L
                    val msFrac = if (fracStr.length == 2) frac * 10 else frac
                    val startMs = (min * 60 + sec) * 1000 + msFrac
                    val text = matcher.group(4) ?: ""
                    items.add(Lyrics.Item(text = text, startTime = startMs, endTime = startMs + 3500L))
                }
            }

            if (items.isNotEmpty()) {
                // Adjust end times based on next item's start time
                for (i in 0 until items.size - 1) {
                    val current = items[i]
                    val nextStart = items[i + 1].startTime
                    items[i] = current.copy(endTime = nextStart)
                }
                return Lyrics.Timed(items)
            }
        }

        if (!plain.isNullOrBlank()) {
            return Lyrics.Simple(plain.trim())
        }

        return null
    }
}
