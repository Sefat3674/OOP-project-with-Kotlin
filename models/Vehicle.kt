open class Vehicle(var vehicleNumber: String) {
    open fun calculateFare(distance: Double): Double {
        return distance * 10
    }
}