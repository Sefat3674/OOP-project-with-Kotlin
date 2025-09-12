package models

// Base Movie class
open class Movie(
    var title: String,
    var year: Int   // ✅ Removed trailing comma
) {
    open fun getRecommendationScore(user: User): Double {
        return 1.0
    }
}

// Action subclass
class Action(title: String, year: Int, val stunLevel: Int) : Movie(title, year) {
    override fun getRecommendationScore(user: User): Double {
        val preference = user.genrePreferences["Action"] ?: 1.0
        return stunLevel * preference
    }
}

// Drama subclass
class Drama(title: String, year: Int, val emotionalDepth: Int) : Movie(title, year) {
    override fun getRecommendationScore(user: User): Double {
        val preference = user.genrePreferences["Drama"] ?: 1.0
        return emotionalDepth * preference
    }
}

// Comedy subclass
class Comedy(title: String, year: Int, val humorLevel: Int) : Movie(title, year) {
    override fun getRecommendationScore(user: User): Double {
        val preference = user.genrePreferences["Comedy"] ?: 1.0
        return humorLevel * preference
    }
}
