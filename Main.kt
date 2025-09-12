import models.*
import library.*
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val movieLibrary = MovieLibrary()

    // Add sample movies
    movieLibrary.addMovie(Action("Avengers: Endgame", 2019, stunLevel = 9))
    movieLibrary.addMovie(Drama("The Godfather", 1972, emotionalDepth = 10))
    movieLibrary.addMovie(Comedy("The Mask", 1994, humorLevel = 8))
    movieLibrary.addMovie(Action("Mad Max: Fury Road", 2015, stunLevel = 10))
    movieLibrary.addMovie(Drama("Forrest Gump", 1994, emotionalDepth = 9))
    movieLibrary.addMovie(Comedy("Superbad", 2007, humorLevel = 7))

    val user = User("Alice")

    println("🎬 Welcome to the Movie Recommendation System!")

    // Labeled loop for break/continue inside when
    menuLoop@ while (true) {
        println("\n--- Menu ---")
        println("1. View All Movies")
        println("2. Rate a Movie")
        println("3. Get Recommendations")
        println("4. Exit")
        println("5. Add a New Movie")
        println("6. View Watched Movies & Ratings")
        print("Choose an option (1-6): ")

        val choice = if (scanner.hasNextInt()) scanner.nextInt() else {
            println("❌ Invalid input. Please enter a number.")
            scanner.nextLine()
            continue@menuLoop
        }

        when (choice) {
            1 -> {
                println("\n--- All Movies in Library ---")
                movieLibrary.getAllMovies().forEachIndexed { index, movie ->
                    val type = when (movie) {
                        is Action -> "Action"
                        is Drama -> "Drama"
                        is Comedy -> "Comedy"
                        else -> "Unknown"
                    }
                    println("${index + 1}. ${movie.title} (${movie.year}) - $type")
                }
            }

            2 -> {
                println("\n--- Rate a Movie ---")
                movieLibrary.getAllMovies().forEachIndexed { index, movie ->
                    val type = when (movie) {
                        is Action -> "Action"
                        is Drama -> "Drama"
                        is Comedy -> "Comedy"
                        else -> "Unknown"
                    }
                    println("${index + 1}. ${movie.title} (${movie.year}) - $type")
                }

                print("Enter movie number to rate: ")
                val movieIndex = if (scanner.hasNextInt()) scanner.nextInt() - 1 else {
                    println("❌ Invalid input.")
                    scanner.nextLine()
                    continue@menuLoop
                }

                if (movieIndex !in movieLibrary.getAllMovies().indices) {
                    println("❌ Invalid movie number.")
                    continue@menuLoop
                }

                val movie = movieLibrary.getAllMovies()[movieIndex]
                print("Enter rating (1-5): ")
                val rating = if (scanner.hasNextInt()) scanner.nextInt().coerceIn(1, 5) else {
                    println("❌ Invalid input.")
                    scanner.nextLine()
                    continue@menuLoop
                }

                movieLibrary.addRating(user, movie, rating)
                println("✅ You rated '${movie.title}' with $rating stars.")
            }

            3 -> {
                println("\n--- Recommended Movies for ${user.name} ---")
                val recommendations = movieLibrary.getRecommendations(user)
                if (recommendations.isEmpty()) {
                    println("🎉 You have watched all movies!")
                } else {
                    recommendations.forEach { movie ->
                        println("${movie.title} (${movie.year}) - Score: ${movie.getRecommendationScore(user)}")
                    }
                }
            }

            4 -> {
                println("👋 Goodbye!")
                break@menuLoop
            }

            5 -> {
                println("\n--- Add a New Movie ---")
                print("Enter movie type (Action/Drama/Comedy): ")
                val type = scanner.next()
                scanner.nextLine() // consume newline
                print("Enter title: ")
                val title = scanner.nextLine()
                print("Enter release year: ")
                val year = if (scanner.hasNextInt()) scanner.nextInt() else {
                    println("❌ Invalid year.")
                    scanner.nextLine()
                    continue@menuLoop
                }

                when (type.toLowerCase()) {
                    "action" -> {
                        print("Enter stun level (1-10): ")
                        val stunLevel = if (scanner.hasNextInt()) scanner.nextInt() else 5
                        movieLibrary.addMovie(Action(title, year, stunLevel))
                    }
                    "drama" -> {
                        print("Enter emotional depth (1-10): ")
                        val emotionalDepth = if (scanner.hasNextInt()) scanner.nextInt() else 5
                        movieLibrary.addMovie(Drama(title, year, emotionalDepth))
                    }
                    "comedy" -> {
                        print("Enter humor level (1-10): ")
                        val humorLevel = if (scanner.hasNextInt()) scanner.nextInt() else 5
                        movieLibrary.addMovie(Comedy(title, year, humorLevel))
                    }
                    else -> println("❌ Unknown movie type.")
                }
                println("✅ Movie added successfully!")
            }

            6 -> {
                println("\n--- Watched Movies & Ratings ---")
                if (user.watchedMovies.isEmpty()) {
                    println("You haven't rated any movies yet.")
                } else {
                    user.watchedMovies.forEachIndexed { index, movie ->
                        val rating = user.ratings[movie] ?: 0
                        println("${index + 1}. ${movie.title} (${movie.year}) - Rating: $rating")
                    }
                }
            }

            else -> {
                println("❌ Invalid option, please try again.")
                continue@menuLoop
            }
        }
    }
}
