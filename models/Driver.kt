data class Driver(
    val name: String,
    private val vehicle: Vehicle,
    private var isAvailable: Boolean = true
) {
    fun getVehicle() = vehicle
    fun isDriverAvailable() = isAvailable
    fun setAvailability(status: Boolean) {
        isAvailable = status
    }
}