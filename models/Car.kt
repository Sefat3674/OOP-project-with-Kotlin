class Car(carNumber: String) : Vehicle(carNumber) {
    override fun calculateFare(distance: Double): Double = distance * 15.0
}
