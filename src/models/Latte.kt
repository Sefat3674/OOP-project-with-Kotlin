package models


class Latte : Coffee("Latte", 3.5, 200, 150, 24) {
    override fun brew() {
        println("🥛 Brewing a creamy Latte with milk foam.")
    }
}