package models

class User(val name: String) {
    val watchedMovies = mutableListOf<Movie>()
    val ratings = mutableMapOf<Movie, Int>()
    val genrePreferences = mutableMapOf(
        "Action" to 1.0,
        "Drama" to 1.0,
        "Comedy" to 1.0
    )
}
