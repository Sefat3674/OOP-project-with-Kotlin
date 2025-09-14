class Medicine(val name: String, var stock: Int, val price: Double) {
    fun updateStock(qty: Int) { stock += qty }
}
