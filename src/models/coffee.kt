package models

abstract class Coffee(
    val name: String,
    val price: Double,
    val waterNeeded: Int,
    val milkNeeded: Int,
    val beansNeeded: Int
) {
    abstract fun brew()
}

