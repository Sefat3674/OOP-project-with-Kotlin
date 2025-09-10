class Auto(autoNumber: String) : Vehicle(autoNumber) {
    override fun calculateFare(distance: Double): Double = distance * 12.0
}