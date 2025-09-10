package models


class Cappuccino : Coffee("Cappuccino", 4.0, 250, 100, 24) {
    override fun brew() {
        println("🍫 Brewing a foamy Cappuccino topped with chocolate powder.")
    }
}
