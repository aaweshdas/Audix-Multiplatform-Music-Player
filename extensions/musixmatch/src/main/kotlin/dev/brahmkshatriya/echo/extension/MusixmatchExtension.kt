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

class MusixmatchExtension : LyricsClient {

    private val json = Json { ignoreUnknownKeys = true }
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val lrcRegex = Pattern.compile("^\\[(\\d{2}):(\\d{2})\\.(\\d{2,3})\\]\\s*(.*)$")

    override suspend fun getSettingItems(): List<Setting> = emptyList()
    override fun setSettings(settings: Settings) {}

    override suspend fun searchTrackLyrics(clientId: String, track: Track): Feed<Lyrics> = withContext(Dispatchers.IO) {
        val title = track.title.trim()
        val artist = track.artists.firstOrNull()?.name?.trim() ?: ""

        val list = mutableListOf<Lyrics>()

        // 1. Try Musixmatch Desktop Macro API
        val mmLyrics = tryGetMusixmatch(title, artist)
        if (mmLyrics != null) {
            list.add(mmLyrics)
        }

        // 2. Fallback to LRCLIB synced lyrics if not found
        if (list.isEmpty()) {
            val fallback = tryGetLrclib(title, artist)
            if (fallback != null) {
                list.add(fallback)
            }
        }

        list.toFeed()
    }

    override suspend fun loadLyrics(lyrics: Lyrics): Lyrics = lyrics

    private fun tryGetMusixmatch(title: String, artist: String): Lyrics? {
        return runCatching {
            val qTrack = URLEncoder.encode(title, "UTF-8")
            val qArtist = URLEncoder.encode(artist, "UTF-8")
            val url = "https://apic-desktop.musixmatch.com/ws/1.1/macro.subtitles.get?format=json&q_track=$qTrack&q_artist=$qArtist&user_language=en&f_subtitle_length_max_percent=0.7&app_id=web-desktop-app-v1.0"

            val req = Request.Builder()
                .url(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                .header("Cookie", "AWSELBCORS=0; AWSELB=0")
                .build()

            val body = client.newCall(req).execute().use { resp ->
                if (!resp.isSuccessful) return@runCatching null
                resp.body.string()
            }

            val root = json.parseToJsonElement(body).jsonObject
            val message = root["message"]?.jsonObject ?: return@runCatching null
            val calls = message["body"]?.jsonObject?.get("macro_calls")?.jsonObject ?: return@runCatching null

            // 1. Try timestamped subtitles (synced lyrics)
            val subList = calls["track.subtitles.get"]?.jsonObject
                ?.get("message")?.jsonObject
                ?.get("body")?.jsonObject
                ?.get("subtitle_list")?.jsonArray

            val subtitleBody = subList?.firstOrNull()?.jsonObject
                ?.get("subtitle")?.jsonObject
                ?.get("subtitle_body")?.jsonPrimitive?.content

            if (!subtitleBody.isNullOrBlank()) {
                val parsed = parseLrc(subtitleBody)
                if (parsed != null) {
                    return@runCatching Lyrics(
                        id = "musixmatch_${title.hashCode()}",
                        title = title,
                        subtitle = if (artist.isNotBlank()) "$artist • Musixmatch" else "Musixmatch",
                        lyrics = parsed,
                        extras = mapOf("source" to "Musixmatch")
                    )
                }
            }

            // 2. Try plain lyrics
            val lyricsBody = calls["track.lyrics.get"]?.jsonObject
                ?.get("message")?.jsonObject
                ?.get("body")?.jsonObject
                ?.get("lyrics")?.jsonObject
                ?.get("lyrics_body")?.jsonPrimitive?.content

            if (!lyricsBody.isNullOrBlank()) {
                val clean = lyricsBody.substringBefore("******* This Lyrics is NOT for Commercial use *******").trim()
                return@runCatching Lyrics(
                    id = "musixmatch_${title.hashCode()}",
                    title = title,
                    subtitle = if (artist.isNotBlank()) "$artist • Musixmatch" else "Musixmatch",
                    lyrics = Lyrics.Simple(clean),
                    extras = mapOf("source" to "Musixmatch")
                )
            }

            null
        }.getOrNull()
    }

    private fun parseLrc(lrcContent: String): Lyrics.Timed? {
        val items = mutableListOf<Lyrics.Item>()
        val lines = lrcContent.lines()
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
        return if (items.isNotEmpty()) Lyrics.Timed(items) else null
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
            val synced = first["syncedLyrics"]?.jsonPrimitive?.content
            val plain = first["plainLyrics"]?.jsonPrimitive?.content

            val parsed = if (!synced.isNullOrBlank()) parseLrc(synced) else plain?.let { Lyrics.Simple(it) }
            if (parsed == null) return@runCatching null

            Lyrics(
                id = "musixmatch_lrclib_$id",
                title = trackName,
                subtitle = "$artistName • Musixmatch/LRCLIB",
                lyrics = parsed,
                extras = mapOf("source" to "Musixmatch/LRCLIB")
            )
        }.getOrNull()
    }
}
