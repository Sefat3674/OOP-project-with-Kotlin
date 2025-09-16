[![GitHub Repo](https://img.shields.io/badge/GitHub-Project-blue)](https://github.com/Sefat3674/OOP-project-with-Kotlin)
[![Language](https://img.shields.io/badge/Kotlin-1.8-orange)](https://kotlinlang.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)


# OOP-project-with-Kotlin
My Goal is to create so many OOP project  that Clear my OOP concept as well as the concept of making mobile application by Kotlin

# 1. Coffee machine 
https://github.com/Sefat3674/OOP-project-with-Kotlin/tree/Coffee_machine_with_OOP_KOTLIN

# 2. Movie Recommendation
https://github.com/Sefat3674/OOP-project-with-Kotlin/tree/Movie_Recommendatin_OOP_Project

# 3. Hospital Management System
https://github.com/Sefat3674/OOP-project-with-Kotlin/tree/Hospital_Management_System

# 4. Office Attendence App
https://github.com/Sefat3674/OOP-project-with-Kotlin/tree/Office_Attendence_OOP_Project

# 5. 🚖 Kotlin Ride-Hailing Application

A simple console-based **ride-hailing system** implemented in Kotlin. Users can book rides, track drivers, and manage a list of drivers dynamically. The system supports multiple vehicle types and calculates fares based on distance.


---

## Features

- **Multiple Vehicle Types**: Car, Bike, Auto
- **Dynamic Driver Assignment**: Assigns available drivers based on vehicle type
- **Fare Calculation**: Automatically calculates fare per distance
- **Ride Tracking**: Simulates driver tracking with estimated arrival
- **Driver Management**: Add new drivers and view available drivers
- **Ride History**: Maintain a history of booked rides

---

## Classes

### Vehicle Classes
- `Vehicle` (open class)  
  Base class with `vehicleNumber` and a `calculateFare` method.
- `Car`, `Bike`, `Auto`  
  Subclasses that override `calculateFare` with specific rates.

### Driver Class
- `Driver`  
  Contains driver information, assigned vehicle, and availability status.

### RideActions (Abstract)
- Defines `assignDriver` and `trackDriver` functions for rides.

### Ride Class
- `Ride` inherits from `RideActions`
- Handles ride booking, fare calculation, driver assignment, ride tracking, and ending rides.

---

## How It Works

1. **Booking a Ride**
   - User inputs name, vehicle type, and distance.
   - System assigns the first available driver of the chosen type.
   - Fare is calculated and ride is confirmed.

2. **Tracking a Ride**
   - Shows a simulated tracking message for the assigned driver.

3. **Ending a Ride**
   - Marks the driver as available again.
   - Displays total fare.

4. **Driver Management**
   - Add new drivers dynamically.
   - View a list of available and busy drivers.

5. **Ride History**
   - Displays all previously booked rides.

---

## Usage

Run the application in a Kotlin-supported IDE or command line.  

Example interaction:

<img width="454" height="396" alt="image" src="https://github.com/user-attachments/assets/16e41117-d2b8-4037-97a3-be9f69528bb3" />


---

## Sample Data

Initial drivers included in the system:

| Name    | Vehicle Type | Vehicle Number |
|---------|--------------|----------------|
| Alice   | Car          | CAR123         |
| Bob     | Bike         | BIKE456        |
| Charlie | Auto         | AUTO789        |

---

## Notes

- Vehicle types are **case-sensitive** (`Car`, `Bike`, `Auto`).
- Distance must be a valid number.
- The system is console-based and meant for learning or prototype purposes.

---

## License

This project is open-source and available under the MIT License.
## MADE BY
## SEFAT AHMED
