class Ride(
    val userName: String,
    val distance: Double,
    val vehicleType: String,
    private val drivers: List<Driver>
) : RideActions() {

    private var assignedDriver: Driver? = null
    private var fare: Double = 0.0

    // Assign a driver based on availability & vehicle type
    override fun assignDriver(): Driver? {
    assignedDriver = drivers.firstOrNull {
        it.isDriverAvailable() && it.getVehicle().javaClass.simpleName == vehicleType
    }
    assignedDriver?.setAvailability(false)
    return assignedDriver
}



    // Track driver location
    override fun trackDriver() {
        if (assignedDriver != null) {
            println("Tracking driver ${assignedDriver?.name}... Arriving in 5 mins 🚗")
        } else {
            println("No driver assigned yet!")
        }
    }

    // Start the ride
    fun startRide() {
        val driver = assignDriver()
        if (driver != null) {
            fare = driver.getVehicle().calculateFare(distance)
            println("Ride confirmed with ${driver.name}. Fare: $fare")
            trackDriver()
        } else {
            println("No $vehicleType available right now. Please try again later.")
        }
    }

    // End the ride safely
    fun endRide() {
        assignedDriver?.setAvailability(true)
        println("Ride ended. Thank you, $userName! Total fare: $fare")
    }
}