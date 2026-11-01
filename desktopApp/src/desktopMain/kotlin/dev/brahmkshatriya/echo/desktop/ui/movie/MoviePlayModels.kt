package dev.brahmkshatriya.echo.desktop.ui.movie

import androidx.compose.ui.graphics.Color
import dev.brahmkshatriya.echo.common.models.Album
import dev.brahmkshatriya.echo.common.models.Artist
import dev.brahmkshatriya.echo.common.models.ImageHolder
import dev.brahmkshatriya.echo.common.models.NetworkRequest
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

data class MovieSoundtrack(
    val id: String,
    val title: String,
    val year: String,
    val directorOrComposer: String,
    val starCast: String,
    val posterUrl: String,
    val backdropUrl: String? = null,
    val bannerBadge: String = "BLOCKBUSTER OST",
    val genre: String, // "Bollywood", "South Cinema", "Hollywood", "Romantic Hits", "Action & Thriller", "Golden Classics"
    val accentColor: Color = Color(0xFFF43F5E),
    val description: String,
    val tracks: List<Track>
)

object MoviePlayRepository {

    private val json = Json { ignoreUnknownKeys = true; isLenient = true }
    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(6, TimeUnit.SECONDS)
        .readTimeout(8, TimeUnit.SECONDS)
        .build()

    private fun makeMovieTrack(
        id: String,
        title: String,
        artist: String,
        movieTitle: String,
        coverUrl: String,
        durationMs: Long
    ): Track {
        val imgHolder = ImageHolder.NetworkRequestImageHolder(NetworkRequest(coverUrl), false)
        return Track(
            id = id,
            title = title,
            artists = listOf(Artist(id = "art_$id", name = artist, cover = imgHolder)),
            album = Album(id = "alb_$id", title = movieTitle, cover = imgHolder),
            cover = imgHolder,
            duration = durationMs,
            extras = mapOf(
                "source" to "saavn",
                "track_title" to title,
                "artist_name" to artist,
                "album_name" to movieTitle,
                "cover_url" to coverUrl
            )
        )
    }

    fun getCuratedMovies(): List<MovieSoundtrack> {
        return listOf(
            MovieSoundtrack(
                id = "movie_animal_2023",
                title = "Animal",
                year = "2023",
                directorOrComposer = "Sandeep Reddy Vanga • Music: Vishal Mishra, Pritam, Harshavardhan",
                starCast = "Ranbir Kapoor, Rashmika Mandanna, Bobby Deol, Anil Kapoor",
                posterUrl = "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg",
                bannerBadge = "MEGA ALL-TIME HIT",
                genre = "Bollywood",
                accentColor = Color(0xFFE11D48),
                description = "High-octane raw emotions, thunderous Punjabi battle anthems, and soulful romantic ballads that ruled the box office.",
                tracks = listOf(
                    makeMovieTrack("mov_an_1", "Arjan Vailly", "Bhupinder Babbal, Manan Bhardwaj", "Animal", "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg", 182000L),
                    makeMovieTrack("mov_an_2", "Satranga", "Arijit Singh, Shreyas Puranik", "Animal", "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg", 271000L),
                    makeMovieTrack("mov_an_3", "Pehle Bhi Main", "Vishal Mishra, Raj Shekhar", "Animal", "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg", 250000L),
                    makeMovieTrack("mov_an_4", "Hua Main", "Raghav Chaitanya, Pritam", "Animal", "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg", 277000L),
                    makeMovieTrack("mov_an_5", "Papa Meri Jaan", "Sonu Nigam, Harshavardhan Rameshwar", "Animal", "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg", 321000L),
                    makeMovieTrack("mov_an_6", "Haiwaan", "Harshavardhan Rameshwar", "Animal", "https://c.saavncdn.com/092/ANIMAL-Hindi-2023-20260724191152-500x500.jpg", 175000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_aashiqui2_2013",
                title = "Aashiqui 2",
                year = "2013",
                directorOrComposer = "Mohit Suri • Music: Mithoon, Ankit Tiwari, Jeet Gannguli",
                starCast = "Aditya Roy Kapur, Shraddha Kapoor",
                posterUrl = "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg",
                bannerBadge = "ROMANTIC MASTERPIECE",
                genre = "Romantic Hits",
                accentColor = Color(0xFF38BDF8),
                description = "The most defining romantic soundtrack of modern Indian cinema. Pure poetic melody and heartbreaking vocal performances.",
                tracks = listOf(
                    makeMovieTrack("mov_ash_1", "Tum Hi Ho", "Arijit Singh, Mithoon", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 262000L),
                    makeMovieTrack("mov_ash_2", "Sunn Raha Hai", "Ankit Tiwari", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 390000L),
                    makeMovieTrack("mov_ash_3", "Chahun Main Ya Naa", "Arijit Singh, Palak Muchhal", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 304000L),
                    makeMovieTrack("mov_ash_4", "Hum Mar Jayenge", "Arijit Singh, Tulsi Kumar", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 306000L),
                    makeMovieTrack("mov_ash_5", "Meri Aashiqui", "Arijit Singh, Palak Muchhal", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 266000L),
                    makeMovieTrack("mov_ash_6", "Piya Aaye Na", "KK, Tulsi Kumar", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 286000L),
                    makeMovieTrack("mov_ash_7", "Bhula Dena", "Mustafa Zahid", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 240000L),
                    makeMovieTrack("mov_ash_8", "Milne Hai Mujhse Aayi", "Arijit Singh", "Aashiqui 2", "https://c.saavncdn.com/430/Aashiqui-2-Hindi-2013-500x500.jpg", 295000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_jawan_2023",
                title = "Jawan",
                year = "2023",
                directorOrComposer = "Atlee • Music: Anirudh Ravichander",
                starCast = "Shah Rukh Khan, Nayanthara, Vijay Sethupathi, Deepika Padukone",
                posterUrl = "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg",
                bannerBadge = "THUNDER ACTION OST",
                genre = "Action & Thriller",
                accentColor = Color(0xFFF59E0B),
                description = "Electrifying commercial energy produced by rockstar composer Anirudh Ravichander for King Khan's blockbuster record breaker.",
                tracks = listOf(
                    makeMovieTrack("mov_jaw_1", "Chaleya", "Anirudh Ravichander, Arijit Singh, Shilpa Rao", "Jawan", "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg", 200000L),
                    makeMovieTrack("mov_jaw_2", "Zinda Banda", "Anirudh Ravichander", "Jawan", "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg", 264000L),
                    makeMovieTrack("mov_jaw_3", "Not Ramaiya Vastavaiya", "Anirudh Ravichander, Vishal Dadlani, Shilpa Rao", "Jawan", "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg", 203000L),
                    makeMovieTrack("mov_jaw_4", "Aaradhya", "Anirudh Ravichander", "Jawan", "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg", 232000L),
                    makeMovieTrack("mov_jaw_5", "Faraatta", "Arijit Singh, Jonita Gandhi, Badshah", "Jawan", "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg", 195000L),
                    makeMovieTrack("mov_jaw_6", "Jawan Title Track", "Anirudh Ravichander", "Jawan", "https://c.saavncdn.com/047/Jawan-Hindi-2023-20230921190854-500x500.jpg", 188000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_kabir_singh_2019",
                title = "Kabir Singh",
                year = "2019",
                directorOrComposer = "Sandeep Reddy Vanga • Music: Sachet-Parampara, Mithoon, Vishal Mishra",
                starCast = "Shahid Kapoor, Kiara Advani",
                posterUrl = "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg",
                bannerBadge = "ALL-TIME CLASSIC",
                genre = "Romantic Hits",
                accentColor = Color(0xFFA855F7),
                description = "Intense, rebellious, and unapologetically soulful. One of the highest-streamed film soundtracks in streaming history.",
                tracks = listOf(
                    makeMovieTrack("mov_ks_1", "Bekhayali", "Sachet Tandon", "Kabir Singh", "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg", 371000L),
                    makeMovieTrack("mov_ks_2", "Tujhe Kitna Chahne Lage", "Arijit Singh, Mithoon", "Kabir Singh", "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg", 284000L),
                    makeMovieTrack("mov_ks_3", "Kaise Hua", "Vishal Mishra", "Kabir Singh", "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg", 234000L),
                    makeMovieTrack("mov_ks_4", "Mere Sohneya", "Sachet Tandon, Parampara Thakur", "Kabir Singh", "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg", 193000L),
                    makeMovieTrack("mov_ks_5", "Tera Ban Jaunga", "Akhil Sachdeva, Tulsi Kumar", "Kabir Singh", "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg", 236000L),
                    makeMovieTrack("mov_ks_6", "Yeh Aaina", "Shreya Ghoshal", "Kabir Singh", "https://c.saavncdn.com/059/Kabir-Singh-Hindi-2019-20240410065223-500x500.jpg", 191000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_brahmastra_2022",
                title = "Brahmāstra: Shiva",
                year = "2022",
                directorOrComposer = "Ayan Mukerji • Music: Pritam",
                starCast = "Ranbir Kapoor, Alia Bhatt, Amitabh Bachchan, Shah Rukh Khan",
                posterUrl = "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg",
                bannerBadge = "MYTHICAL AURA",
                genre = "Bollywood",
                accentColor = Color(0xFFF97316),
                description = "Grand symphonic orchestra meets traditional Indian ragas and powerhouse vocals. Featuring the timeless Kesariya.",
                tracks = listOf(
                    makeMovieTrack("mov_bra_1", "Kesariya", "Pritam, Arijit Singh", "Brahmāstra", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 268000L),
                    makeMovieTrack("mov_bra_2", "Deva Deva", "Arijit Singh, Jonita Gandhi, Pritam", "Brahmāstra", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 279000L),
                    makeMovieTrack("mov_bra_3", "Dance Ka Bhoot", "Arijit Singh, Pritam", "Brahmāstra", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 246000L),
                    makeMovieTrack("mov_bra_4", "Rasiya", "Shreya Ghoshal, Tushar Joshi, Pritam", "Brahmāstra", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 295000L),
                    makeMovieTrack("mov_bra_5", "Shiva Theme", "Pritam", "Brahmāstra", "https://c.saavncdn.com/871/Brahmastra-Original-Motion-Picture-Soundtrack-Hindi-2022-20221006155213-500x500.jpg", 143000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_pushpa_2021_2024",
                title = "Pushpa: The Rule & Rise",
                year = "2021–2024",
                directorOrComposer = "Sukumar • Music: Devi Sri Prasad (DSP)",
                starCast = "Allu Arjun, Rashmika Mandanna, Fahadh Faasil",
                posterUrl = "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg",
                bannerBadge = "PAN-INDIA BLOCKBUSTER",
                genre = "South Cinema",
                accentColor = Color(0xFF10B981),
                description = "Earthy rustic folk rhythms, wild percussion grooves, and iconic mass celebration anthems from composer Devi Sri Prasad.",
                tracks = listOf(
                    makeMovieTrack("mov_pus_1", "Pushpa Pushpa", "Devi Sri Prasad, Mika Singh", "Pushpa 2", "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg", 258000L),
                    makeMovieTrack("mov_pus_2", "Angaaron (The Couple Song)", "Shreya Ghoshal, Devi Sri Prasad", "Pushpa 2", "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg", 262000L),
                    makeMovieTrack("mov_pus_3", "Oo Antava Mawa", "Indravathi Chauhan, Devi Sri Prasad", "Pushpa", "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg", 223000L),
                    makeMovieTrack("mov_pus_4", "Srivalli", "Javed Ali, Devi Sri Prasad", "Pushpa", "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg", 224000L),
                    makeMovieTrack("mov_pus_5", "Sami Sami", "Sunidhi Chauhan, Devi Sri Prasad", "Pushpa", "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg", 223000L),
                    makeMovieTrack("mov_pus_6", "Eyy Bidda Idhi Naa Adda", "Nakash Aziz, Devi Sri Prasad", "Pushpa", "https://c.saavncdn.com/823/Pushpa-The-Rise-Part-01-Hindi-2021-20220112163914-500x500.jpg", 234000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_rockstar_2011",
                title = "Rockstar",
                year = "2011",
                directorOrComposer = "Imtiaz Ali • Music: A. R. Rahman",
                starCast = "Ranbir Kapoor, Nargis Fakhri",
                posterUrl = "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg",
                bannerBadge = "SUFI-ROCK MONUMENT",
                genre = "Bollywood",
                accentColor = Color(0xFF6366F1),
                description = "Rahman's legendary magnum opus combining Sufi ecstasy, grunge rock fury, and transcendent spiritual longing.",
                tracks = listOf(
                    makeMovieTrack("mov_roc_1", "Kun Faya Kun", "A. R. Rahman, Javed Ali, Mohit Chauhan", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 473000L),
                    makeMovieTrack("mov_roc_2", "Nadaan Parindey", "A. R. Rahman, Mohit Chauhan", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 386000L),
                    makeMovieTrack("mov_roc_3", "Sadda Haq", "Mohit Chauhan, Orianthi", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 365000L),
                    makeMovieTrack("mov_roc_4", "Jo Bhi Main", "Mohit Chauhan", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 275000L),
                    makeMovieTrack("mov_roc_5", "Tum Ho", "Mohit Chauhan, Suzanne D'Mello", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 318000L),
                    makeMovieTrack("mov_roc_6", "Phir Se Ud Chala", "Mohit Chauhan", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 271000L),
                    makeMovieTrack("mov_roc_7", "Hawaa Hawaa", "Mohit Chauhan", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 342000L),
                    makeMovieTrack("mov_roc_8", "Katiya Karun", "Harshdeep Kaur", "Rockstar", "https://c.saavncdn.com/384/Rockstar-Hindi-2011-20221212024036-500x500.jpg", 239000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_yjhd_2013",
                title = "Yeh Jawaani Hai Deewani",
                year = "2013",
                directorOrComposer = "Ayan Mukerji • Music: Pritam",
                starCast = "Ranbir Kapoor, Deepika Padukone, Aditya Roy Kapur, Kalki Koechlin",
                posterUrl = "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg",
                bannerBadge = "YOUTH CELEBRATION",
                genre = "Bollywood",
                accentColor = Color(0xFFEC4899),
                description = "The anthem of a generation. Friendship, romance, unforgettable road trips, and celebratory wedding dances.",
                tracks = listOf(
                    makeMovieTrack("mov_yjh_1", "Badtameez Dil", "Benny Dayal, Shefali Alvares", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 252000L),
                    makeMovieTrack("mov_yjh_2", "Balam Pichkari", "Vishal Dadlani, Shalmali Kholgade", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 289000L),
                    makeMovieTrack("mov_yjh_3", "Ilahi", "Arijit Singh", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 229000L),
                    makeMovieTrack("mov_yjh_4", "Kabira", "Tochi Raina, Rekha Bhardwaj", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 251000L),
                    makeMovieTrack("mov_yjh_5", "Subhanallah", "Sreerama Chandra, Shilpa Rao", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 249000L),
                    makeMovieTrack("mov_yjh_6", "Dilliwaali Girlfriend", "Arijit Singh, Sunidhi Chauhan", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 260000L),
                    makeMovieTrack("mov_yjh_7", "Ghagra", "Vishal Dadlani, Rekha Bhardwaj", "YJHD", "https://c.saavncdn.com/463/Yeh-Jawaani-Hai-Deewani-Hindi-2013-500x500.jpg", 304000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_stree2_2024",
                title = "Stree 2",
                year = "2024",
                directorOrComposer = "Amar Kaushik • Music: Sachin-Jigar",
                starCast = "Shraddha Kapoor, Rajkummar Rao, Pankaj Tripathi",
                posterUrl = "https://c.saavncdn.com/791/Stree-2-Hindi-2024-20240830113110-500x500.jpg",
                bannerBadge = "2024 RECORD BREAKER",
                genre = "Bollywood",
                accentColor = Color(0xFFD946EF),
                description = "Viral dance-floor sensations and romantic folk melodies from India's most successful horror-comedy blockbuster.",
                tracks = listOf(
                    makeMovieTrack("mov_st2_1", "Aaj Ki Raat", "Madhubanti Bagchi, Divya Kumar, Sachin-Jigar", "Stree 2", "https://c.saavncdn.com/791/Stree-2-Hindi-2024-20240830113110-500x500.jpg", 228000L),
                    makeMovieTrack("mov_st2_2", "Khoobsurat", "Vishal Mishra, Sachin-Jigar", "Stree 2", "https://c.saavncdn.com/791/Stree-2-Hindi-2024-20240830113110-500x500.jpg", 244000L),
                    makeMovieTrack("mov_st2_3", "Aayi Nai", "Pawan Singh, Simran Choudhary, Sachin-Jigar", "Stree 2", "https://c.saavncdn.com/791/Stree-2-Hindi-2024-20240830113110-500x500.jpg", 178000L),
                    makeMovieTrack("mov_st2_4", "Tumhare Hi Rahenge Hum", "Varun Jain, Shilpa Rao, Sachin-Jigar", "Stree 2", "https://c.saavncdn.com/791/Stree-2-Hindi-2024-20240830113110-500x500.jpg", 230000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_shershaah_2021",
                title = "Shershaah",
                year = "2021",
                directorOrComposer = "Vishnuvardhan • Music: Tanishk Bagchi, B Praak, Jasleen Royal",
                starCast = "Sidharth Malhotra, Kiara Advani",
                posterUrl = "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg",
                bannerBadge = "PATRIOTIC & SOULFUL",
                genre = "Romantic Hits",
                accentColor = Color(0xFF06B6D4),
                description = "Heart-stirring acoustic warmth honoring Captain Vikram Batra PVC. Songs that touched every heart in the country.",
                tracks = listOf(
                    makeMovieTrack("mov_she_1", "Raataan Lambiyan", "Jubin Nautiyal, Asees Kaur", "Shershaah", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 230000L),
                    makeMovieTrack("mov_she_2", "Ranjha", "B Praak, Jasleen Royal", "Shershaah", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 228000L),
                    makeMovieTrack("mov_she_3", "Mann Bharryaa 2.0", "B Praak", "Shershaah", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 266000L),
                    makeMovieTrack("mov_she_4", "Kabhi Tumhe", "Darshan Raval", "Shershaah", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 230000L),
                    makeMovieTrack("mov_she_5", "Jai Hind Ki Senaa", "Vikram Montrose", "Shershaah", "https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", 152000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_ddlj_1995",
                title = "Dilwale Dulhania Le Jayenge",
                year = "1995",
                directorOrComposer = "Aditya Chopra • Music: Jatin-Lalit",
                starCast = "Shah Rukh Khan, Kajol, Amrish Puri",
                posterUrl = "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg",
                bannerBadge = "GOLDEN NOSTALGIA",
                genre = "Golden Classics",
                accentColor = Color(0xFFFBBF24),
                description = "The longest-running film in Indian history with evergreen melodies that defined romance for over three decades.",
                tracks = listOf(
                    makeMovieTrack("mov_ddlj_1", "Tujhe Dekha Toh", "Kumar Sanu, Lata Mangeshkar", "DDLJ", "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg", 303000L),
                    makeMovieTrack("mov_ddlj_2", "Mehndi Laga Ke Rakhna", "Udit Narayan, Lata Mangeshkar", "DDLJ", "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg", 290000L),
                    makeMovieTrack("mov_ddlj_3", "Ho Gaya Hai Tujhko", "Udit Narayan, Lata Mangeshkar", "DDLJ", "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg", 349000L),
                    makeMovieTrack("mov_ddlj_4", "Mere Khwabon Mein", "Lata Mangeshkar", "DDLJ", "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg", 257000L),
                    makeMovieTrack("mov_ddlj_5", "Ruk Ja O Dil Deewane", "Udit Narayan", "DDLJ", "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg", 314000L),
                    makeMovieTrack("mov_ddlj_6", "Zara Sa Jhoom Loon Main", "Asha Bhosle, Abhijeet", "DDLJ", "https://c.saavncdn.com/832/Dilwale-Dulhania-Le-Jayenge-Hindi-1995-20201016140134-500x500.jpg", 311000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_fighter_2024",
                title = "Fighter",
                year = "2024",
                directorOrComposer = "Siddharth Anand • Music: Vishal-Shekhar",
                starCast = "Hrithik Roshan, Deepika Padukone, Anil Kapoor",
                posterUrl = "https://c.saavncdn.com/001/Fighter-Hindi-2024-20240123180808-500x500.jpg",
                bannerBadge = "AERIAL ACTION GROOVES",
                genre = "Action & Thriller",
                accentColor = Color(0xFF0EA5E9),
                description = "Sleek synth-pop club tracks, pulsating fighter-jet adrenaline, and patriotic soaring power ballads.",
                tracks = listOf(
                    makeMovieTrack("mov_fig_1", "Sher Khul Gaye", "Vishal Dadlani, Shilpa Rao, Benny Dayal", "Fighter", "https://c.saavncdn.com/001/Fighter-Hindi-2024-20240123180808-500x500.jpg", 180000L),
                    makeMovieTrack("mov_fig_2", "Ishq Jaisa Kuch", "Vishal Dadlani, Shilpa Rao, Mellow D", "Fighter", "https://c.saavncdn.com/001/Fighter-Hindi-2024-20240123180808-500x500.jpg", 170000L),
                    makeMovieTrack("mov_fig_3", "Heer Aasmani", "Vishal Dadlani, Sheykhar Ravjiani, B Praak", "Fighter", "https://c.saavncdn.com/001/Fighter-Hindi-2024-20240123180808-500x500.jpg", 204000L),
                    makeMovieTrack("mov_fig_4", "Dil Banaane Waaleya", "Arijit Singh, Jonita Gandhi", "Fighter", "https://c.saavncdn.com/001/Fighter-Hindi-2024-20240123180808-500x500.jpg", 227000L),
                    makeMovieTrack("mov_fig_5", "Mitti", "Vishal Dadlani", "Fighter", "https://c.saavncdn.com/001/Fighter-Hindi-2024-20240123180808-500x500.jpg", 215000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_dunki_2023",
                title = "Dunki",
                year = "2023",
                directorOrComposer = "Rajkumar Hirani • Music: Pritam",
                starCast = "Shah Rukh Khan, Taapsee Pannu, Vicky Kaushal, Boman Irani",
                posterUrl = "https://c.saavncdn.com/264/Dunki-Hindi-2023-20231221191004-500x500.jpg",
                bannerBadge = "HEARTWARMING VOYAGE",
                genre = "Bollywood",
                accentColor = Color(0xFF14B8A6),
                description = "Tender homecoming ballads, energetic Punjabi dance anthems, and nostalgia-drenched storytelling by Hirani & Pritam.",
                tracks = listOf(
                    makeMovieTrack("mov_dun_1", "Lutt Putt Gaya", "Arijit Singh, Pritam", "Dunki", "https://c.saavncdn.com/264/Dunki-Hindi-2023-20231221191004-500x500.jpg", 225000L),
                    makeMovieTrack("mov_dun_2", "O Maahi", "Arijit Singh, Pritam", "Dunki", "https://c.saavncdn.com/264/Dunki-Hindi-2023-20231221191004-500x500.jpg", 233000L),
                    makeMovieTrack("mov_dun_3", "Nikle The Kabhi Hum Ghar Se", "Sonu Nigam, Pritam", "Dunki", "https://c.saavncdn.com/264/Dunki-Hindi-2023-20231221191004-500x500.jpg", 285000L),
                    makeMovieTrack("mov_dun_4", "Banda", "Diljit Dosanjh, Pritam", "Dunki", "https://c.saavncdn.com/264/Dunki-Hindi-2023-20231221191004-500x500.jpg", 204000L),
                    makeMovieTrack("mov_dun_5", "Main Tera Rasta Dekhunga", "Vishal Mishra, Shreya Ghoshal", "Dunki", "https://c.saavncdn.com/264/Dunki-Hindi-2023-20231221191004-500x500.jpg", 243000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_rrr_2022",
                title = "RRR",
                year = "2022",
                directorOrComposer = "S. S. Rajamouli • Music: M. M. Keeravani",
                starCast = "NTR Jr., Ram Charan, Alia Bhatt, Ajay Devgn",
                posterUrl = "https://c.saavncdn.com/475/RRR-Hindi-2022-20220412140645-500x500.jpg",
                bannerBadge = "OSCAR WINNER",
                genre = "South Cinema",
                accentColor = Color(0xFFEF4444),
                description = "Academy Award-winning global phenomenon featuring the electrifying Naatu Naatu and thunderous freedom war anthems.",
                tracks = listOf(
                    makeMovieTrack("mov_rrr_1", "Naatu Naatu", "Rahul Sipligunj, Kaala Bhairava", "RRR", "https://c.saavncdn.com/475/RRR-Hindi-2022-20220412140645-500x500.jpg", 215000L),
                    makeMovieTrack("mov_rrr_2", "Dosti", "Hemachandra, M. M. Keeravani", "RRR", "https://c.saavncdn.com/475/RRR-Hindi-2022-20220412140645-500x500.jpg", 340000L),
                    makeMovieTrack("mov_rrr_3", "Komuram Bheemudo", "Kaala Bhairava", "RRR", "https://c.saavncdn.com/475/RRR-Hindi-2022-20220412140645-500x500.jpg", 255000L),
                    makeMovieTrack("mov_rrr_4", "Raamam Raaghavam", "Vijay Prakash, Chandana Bala Kalyan", "RRR", "https://c.saavncdn.com/475/RRR-Hindi-2022-20220412140645-500x500.jpg", 231000L),
                    makeMovieTrack("mov_rrr_5", "Sholay", "Vishal Mishra, Benny Dayal", "RRR", "https://c.saavncdn.com/475/RRR-Hindi-2022-20220412140645-500x500.jpg", 256000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_hans_zimmer_cinematic",
                title = "Interstellar & Inception",
                year = "2010–2014",
                directorOrComposer = "Christopher Nolan • Music: Hans Zimmer",
                starCast = "Matthew McConaughey, Leonardo DiCaprio, Anne Hathaway",
                posterUrl = "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg",
                bannerBadge = "HOLLYWOOD MAJESTY",
                genre = "Hollywood",
                accentColor = Color(0xFF8B5CF6),
                description = "Cosmic pipe organs, ticking watches, and deep brass swells that redefine the scale and depth of cinema sound.",
                tracks = listOf(
                    makeMovieTrack("mov_hz_1", "Time", "Hans Zimmer", "Inception", "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg", 275000L),
                    makeMovieTrack("mov_hz_2", "Cornfield Chase", "Hans Zimmer", "Interstellar", "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg", 126000L),
                    makeMovieTrack("mov_hz_3", "Stay", "Hans Zimmer", "Interstellar", "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg", 412000L),
                    makeMovieTrack("mov_hz_4", "No Time for Caution", "Hans Zimmer", "Interstellar", "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg", 246000L),
                    makeMovieTrack("mov_hz_5", "Mountains", "Hans Zimmer", "Interstellar", "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg", 219000L),
                    makeMovieTrack("mov_hz_6", "Dream Is Collapsing", "Hans Zimmer", "Inception", "https://e-cdns-images.dzcdn.net/images/artist/f1ba9a399f9c7f1a3ec5fb2b75a02aa3/500x500-000000-80-0-0.jpg", 143000L)
                )
            ),
            MovieSoundtrack(
                id = "movie_gadar2_2023",
                title = "Gadar 2",
                year = "2023",
                directorOrComposer = "Anil Sharma • Music: Mithoon",
                starCast = "Sunny Deol, Ameesha Patel, Utkarsh Sharma",
                posterUrl = "https://c.saavncdn.com/142/Gadar-2-Hindi-2023-20230811124430-500x500.jpg",
                bannerBadge = "BLOCKBUSTER RETURN",
                genre = "Bollywood",
                accentColor = Color(0xFFF43F5E),
                description = "The return of the iconic handpump roar with modernized folk classics and roaring patriotic anthems.",
                tracks = listOf(
                    makeMovieTrack("mov_gad_1", "Main Nikla Gaddi Leke", "Udit Narayan, Aditya Narayan, Mithoon", "Gadar 2", "https://c.saavncdn.com/142/Gadar-2-Hindi-2023-20230811124430-500x500.jpg", 230000L),
                    makeMovieTrack("mov_gad_2", "Udd Jaa Kaale Kaava", "Udit Narayan, Alka Yagnik, Mithoon", "Gadar 2", "https://c.saavncdn.com/142/Gadar-2-Hindi-2023-20230811124430-500x500.jpg", 288000L),
                    makeMovieTrack("mov_gad_3", "Dil Jhoom", "Arijit Singh, Mithoon", "Gadar 2", "https://c.saavncdn.com/142/Gadar-2-Hindi-2023-20230811124430-500x500.jpg", 303000L),
                    makeMovieTrack("mov_gad_4", "Khairiyat", "Arijit Singh, Mithoon", "Gadar 2", "https://c.saavncdn.com/142/Gadar-2-Hindi-2023-20230811124430-500x500.jpg", 235000L)
                )
            )
        )
    }

    suspend fun searchOnlineMovieSoundtracks(query: String): List<MovieSoundtrack> = withContext(Dispatchers.IO) {
        val trimmed = query.trim()
        if (trimmed.length < 2) return@withContext emptyList()

        val localMatches = getCuratedMovies().filter { m ->
            m.title.contains(trimmed, ignoreCase = true) ||
            m.starCast.contains(trimmed, ignoreCase = true) ||
            m.directorOrComposer.contains(trimmed, ignoreCase = true) ||
            m.genre.contains(trimmed, ignoreCase = true) ||
            m.tracks.any { it.title.contains(trimmed, ignoreCase = true) }
        }
        if (localMatches.isNotEmpty()) return@withContext localMatches

        // Dynamically query JioSaavn album/movie search API
        runCatching {
            val encoded = URLEncoder.encode(trimmed, "UTF-8")
            val url = "https://www.jiosaavn.com/api.php?__call=search.getAlbumResults&_format=json&_marker=0&api_version=4&p=1&n=8&q=$encoded"
            val req = Request.Builder().url(url).header("User-Agent", "Mozilla/5.0").build()
            val body = httpClient.newCall(req).execute().use { it.body?.string().orEmpty() }
            val root = json.parseToJsonElement(body).jsonObject
            val results = root["results"]?.jsonArray ?: return@runCatching emptyList()

            val remoteMovies = mutableListOf<MovieSoundtrack>()
            for (elem in results) {
                val obj = elem.jsonObject
                val albId = obj["id"]?.jsonPrimitive?.content ?: continue
                val rawTitle = obj["title"]?.jsonPrimitive?.content ?: continue
                val year = obj["year"]?.jsonPrimitive?.content ?: "2024"
                val artist = obj["more_info"]?.jsonObject?.get("artist_name")?.jsonPrimitive?.content ?: "Cinema Master"
                val rawImg = obj["image"]?.jsonPrimitive?.content ?: ""
                val highResImg = rawImg.replace("150x150", "500x500").replace("50x50", "500x500")

                // Fetch details of this album to get tracks
                val detailUrl = "https://www.jiosaavn.com/api.php?__call=content.getAlbumDetails&_format=json&_marker=0&api_version=4&albumid=$albId"
                val dReq = Request.Builder().url(detailUrl).header("User-Agent", "Mozilla/5.0").build()
                val dBody = httpClient.newCall(dReq).execute().use { it.body?.string().orEmpty() }
                val dRoot = json.parseToJsonElement(dBody).jsonObject
                val songList = dRoot["list"]?.jsonArray ?: continue

                val movieTracks = mutableListOf<Track>()
                for (sElem in songList) {
                    val sObj = sElem.jsonObject
                    val sid = sObj["id"]?.jsonPrimitive?.content ?: continue
                    val sTitle = sObj["title"]?.jsonPrimitive?.content ?: continue
                    val sArtists = sObj["more_info"]?.jsonObject?.get("artist_name")?.jsonPrimitive?.content ?: artist
                    val sDur = sObj["more_info"]?.jsonObject?.get("duration")?.jsonPrimitive?.content?.toLongOrNull()?.times(1000L) ?: 210000L
                    movieTracks.add(makeMovieTrack(sid, sTitle, sArtists, rawTitle, highResImg, sDur))
                }

                if (movieTracks.isNotEmpty()) {
                    remoteMovies.add(
                        MovieSoundtrack(
                            id = "remote_$albId",
                            title = rawTitle,
                            year = year,
                            directorOrComposer = "Music: $artist",
                            starCast = "Film Cast & Original Soundtrack",
                            posterUrl = highResImg,
                            bannerBadge = "CINEMA ALBUM",
                            genre = "Bollywood",
                            accentColor = Color(0xFF38BDF8),
                            description = "Official complete motion picture soundtrack with ${movieTracks.size} original songs.",
                            tracks = movieTracks
                        )
                    )
                }
            }
            remoteMovies
        }.getOrDefault(emptyList())
    }
}
