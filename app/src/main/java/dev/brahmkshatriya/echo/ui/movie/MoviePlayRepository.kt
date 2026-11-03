package dev.brahmkshatriya.echo.ui.movie

import android.content.Context
import dev.brahmkshatriya.echo.common.models.Track
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class MovieBoxItem(
    val id: String,
    val title: String,
    val type: String = "movie",
    val year: String = "2024",
    val duration: String = "",
    val genre: String = "Cinema",
    val rating: String = "8.5",
    val qualityBadge: String = "1080p HD",
    val coverUrl: String = "",
    val bannerUrl: String = "",
    val description: String = "",
    val provider: String = "moviebox",
    val rawTitle: String = "",
    val releaseDate: String = ""
)

object MoviePlayRepository {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }

    private var cachedMovies: List<MovieBoxItem>? = null

    fun getMovies(context: Context): List<MovieBoxItem> {
        cachedMovies?.let { return it }

        val loaded = runCatching {
            context.assets.open("moviebox/curated_catalog.json").bufferedReader().use { reader ->
                val content = reader.readText()
                json.decodeFromString<List<MovieBoxItem>>(content)
            }
        }.getOrNull()

        val result = if (!loaded.isNullOrEmpty()) {
            loaded
        } else {
            fallbackMovies()
        }
        cachedMovies = result
        return result
    }

    private fun fallbackMovies(): List<MovieBoxItem> = listOf(
        MovieBoxItem(
            id = "12_angry_men",
            title = "12 Angry Men",
            year = "1957",
            genre = "Crime, Drama",
            duration = "96 min",
            qualityBadge = "1080p HD",
            coverUrl = "https://images.metahub.space/poster/medium/tt0050083/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt0050083/img.jpg",
            description = "The jury in a New York City murder trial is frustrated by a single member whose skeptical caution forces them to more carefully consider the evidence."
        ),
        MovieBoxItem(
            id = "1883",
            title = "1883",
            year = "2021",
            genre = "Drama, Western",
            duration = "10 eps",
            qualityBadge = "HD TV",
            coverUrl = "https://images.metahub.space/poster/medium/tt13991232/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt13991232/img.jpg",
            description = "Follows the Dutton family on a journey west through the Great Plains toward the last bastion of untamed America."
        ),
        MovieBoxItem(
            id = "1917",
            title = "1917",
            year = "2019",
            genre = "Action, Drama, War",
            duration = "119 min",
            qualityBadge = "1080p HD",
            coverUrl = "https://images.metahub.space/poster/medium/tt8579674/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt8579674/img.jpg",
            description = "Two soldiers are assigned to race against time and deliver a message, stopping 1,600 men from walking straight into a deadly trap."
        ),
        MovieBoxItem(
            id = "1923",
            title = "1923",
            year = "2022",
            genre = "Drama, Western",
            duration = "8 eps",
            qualityBadge = "HD TV",
            coverUrl = "https://images.metahub.space/poster/medium/tt18335752/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt18335752/img.jpg",
            description = "The Duttons face a new set of challenges in the early 20th century, including the rise of Western expansion and the Great Depression."
        ),
        MovieBoxItem(
            id = "2_fast_2_furious",
            title = "2 Fast 2 Furious",
            year = "2003",
            genre = "Action, Crime, Thriller",
            duration = "107 min",
            qualityBadge = "1080p HD",
            coverUrl = "https://images.metahub.space/poster/medium/tt0322259/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt0322259/img.jpg",
            description = "Former cop Brian O'Conner is called upon to bust a dangerous criminal and he recruits the help of his former pal, Roman Pearce."
        ),
        MovieBoxItem(
            id = "oppenheimer",
            title = "Oppenheimer",
            year = "2023",
            genre = "Biography, Drama, History",
            duration = "180 min",
            qualityBadge = "CINEMA 4K",
            coverUrl = "https://images.metahub.space/poster/medium/tt15398776/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt15398776/img.jpg",
            description = "The story of American scientist J. Robert Oppenheimer and his role in the development of the atomic bomb."
        ),
        MovieBoxItem(
            id = "interstellar",
            title = "Interstellar",
            year = "2014",
            genre = "Sci-Fi, Adventure, Drama",
            duration = "169 min",
            qualityBadge = "CINEMA 4K",
            coverUrl = "https://images.metahub.space/poster/medium/tt0816692/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt0816692/img.jpg",
            description = "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot is tasked to pilot a spacecraft along with a team of researchers."
        ),
        MovieBoxItem(
            id = "dune_part_two",
            title = "Dune: Part Two",
            year = "2024",
            genre = "Action, Adventure, Sci-Fi",
            duration = "166 min",
            qualityBadge = "CINEMA 4K",
            coverUrl = "https://images.metahub.space/poster/medium/tt15239678/img.jpg",
            bannerUrl = "https://images.metahub.space/background/medium/tt15239678/img.jpg",
            description = "Paul Atreides unites with Chani and the Fremen while seeking revenge against the conspirators who destroyed his family."
        )
    )
}
