class Bike(bikeNumber: String) : Vehicle(bikeNumber) {
    override fun calculateFare(distance: Double): Double = distance * 8.0
}
