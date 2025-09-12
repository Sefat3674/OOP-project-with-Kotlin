package library

import models.*

open class MovieLibrary : RecommendationActions() {
    private val movies = mutableListOf<Movie>()

    fun addMovie(movie: Movie) {
        movies.add(movie)
    }

    fun getMovie(title: String): Movie? {
        return movies.find { it.title == title }
    }

    override fun addRating(user: User, movie: Movie, rating: Int) {
        user.ratings[movie] = rating
        if (movie !in user.watchedMovies) user.watchedMovies.add(movie)

        val genre = when (movie) {
            is Action -> "Action"
            is Drama -> "Drama"
            is Comedy -> "Comedy"
            else -> ""
        }

        if (genre.isNotEmpty()) {
            val oldPref = user.genrePreferences[genre] ?: 1.0
            user.genrePreferences[genre] = (oldPref + rating / 5.0).coerceAtMost(10.0)
        }
    }

    override fun recommendMovie(user: User): List<Movie> {
        return movies.filter { it !in user.watchedMovies }
            .sortedByDescending { it.getRecommendationScore(user) }
            .take(5)
    }

    fun getRecommendations(user: User): List<Movie> = recommendMovie(user)
    fun getAllMovies(): List<Movie> = movies
}
