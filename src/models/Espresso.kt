package models

class Espresso : Coffee("Espresso", 2.5, 50, 0, 18) {
    override fun brew() {
        println("☕ Brewing a strong Espresso with 50ml water and 18g beans.")
    }
}