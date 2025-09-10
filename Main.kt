fun main() {
    val drivers = mutableListOf(
        Driver("Alice", Car("CAR123")),
        Driver("Bob", Bike("BIKE456")),
        Driver("Charlie", Auto("AUTO789"))
    )

    val rides = mutableListOf<Ride>()

    // Label the while loop so we can break from inside when
    mainLoop@ while (true) {
        println("\n===== 🚖 Ride-Hailing Menu =====")
        println("1. Book a Ride")
        println("2. View Available Drivers")
        println("3. Add a New Driver")
        println("4. View Ride History")
        println("5. Exit")
        print("Select an option: ")

        when (readLine()?.trim()) {
            "1" -> {
                print("Enter your name: ")
                val userName = readLine()!!.trim()
                print("Enter vehicle type (Car/Bike/Auto): ")
                val vehicleType = readLine()!!.trim()
                print("Enter distance (km): ")
                val distance = readLine()?.toDoubleOrNull() ?: 0.0

                val ride = Ride(userName, distance, vehicleType, drivers.toList())
                ride.startRide()
                rides.add(ride)
                ride.endRide()
            }

            "2" -> {
                println("\nAvailable Drivers:")
                drivers.forEach { driver ->
                    val status = if (driver.isDriverAvailable()) "Available" else "Busy"
                    // FIXED: use javaClass.simpleName instead of ::class.simpleName
                    println("${driver.name} (${driver.getVehicle().javaClass.simpleName}) - $status")
                }
            }

            "3" -> {
                print("Enter driver name: ")
                val name = readLine()!!.trim()
                print("Enter vehicle type (Car/Bike/Auto): ")
                val type = readLine()!!.trim()
                print("Enter vehicle number: ")
                val number = readLine()!!.trim()

                val vehicle = when (type) {
                    "Car" -> Car(number)
                    "Bike" -> Bike(number)
                    "Auto" -> Auto(number)
                    else -> {
                        println("Invalid vehicle type!")
                        null
                    }
                }

                if (vehicle != null) {
                    drivers.add(Driver(name, vehicle))
                    println("Driver $name added successfully!")
                }
            }

            "4" -> {
                println("\nRide History:")
                if (rides.isEmpty()) {
                    println("No rides booked yet.")
                } else {
                    rides.forEach { ride ->
                        println("${ride.userName} took a ${ride.vehicleType} ride of ${ride.distance} km")
                    }
                }
            }

            "5" -> {
                println("Exiting... Thank you!")
                break@mainLoop
            }

            else -> println("Invalid option! Please try again.")
        }
    }
}
