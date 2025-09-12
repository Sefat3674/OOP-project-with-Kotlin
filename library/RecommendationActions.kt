package library

import models.Movie
import models.User

abstract class RecommendationActions {
    abstract fun recommendMovie(user: User): List<Movie>
    abstract fun addRating(user: User, movie: Movie, rating: Int)
}
