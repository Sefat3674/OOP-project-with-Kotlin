package com.officeattendance.main

import com.officeattendance.model.*
import com.officeattendance.data.DataManager
import com.officeattendance.utils.*
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main() {
    println("===== Welcome to Office Attendance System =====")

    while (true) {
        println("\n1. Employee Sign Up\n2. Employee Login\n3. Officer Sign Up\n4. Officer Login\n5. Exit")
        when (readLine()!!) {
            "1" -> employeeSignUp()
            "2" -> employeeMenu()
            "3" -> officerSignUp()
            "4" -> officerMenu()
            "5" -> return
            else -> println("Invalid choice")
        }
    }
}

// ---------------- Employee -----------------
fun employeeSignUp() {
    println("Enter Employee Name:")
    val name = readLine()!!
    val id = IdGenerator.generateEmployeeId()
    val emp = Employee(id, name)
    DataManager.addEmployee(emp)
    println("Sign Up successful! Your Employee ID: $id")
}

fun employeeMenu() {
    println("Enter Employee ID:")
    val empId = readLine()!!
    val emp = DataManager.employeeLogin(empId)

    if (emp != null) {
        println("Welcome, ${emp.name}")
        while (true) {
            println("1. Add Attendance\n2. View Month Record\n3. Logout")
            when (readLine()!!) {
                "1" -> addAttendance(emp)
                "2" -> viewMonthRecord(emp)
                "3" -> return
                else -> println("Invalid choice")
            }
        }
    } else {
        println("Employee not found!")
    }
}

// ---------------- Officer -----------------
fun officerSignUp() {
    println("Enter Officer Username:")
    val username = readLine()!!
    println("Enter Password:")
    val password = readLine()!!
    val id = IdGenerator.generateOfficerId()
    val officer = Officer(id, username, password)
    DataManager.addOfficer(officer)
    println("Sign Up successful! Your Officer ID: $id")
}

fun officerMenu() {
    println("Officer Username:")
    val username = readLine()!!
    println("Password:")
    val password = readLine()!!

    val officer = DataManager.officerLogin(username, password)
    if (officer != null) {
        println("Welcome Officer ${officer.username}")
        while (true) {
            println("1. View Employee Record\n2. Logout")
            when (readLine()!!) {
                "1" -> {
                    println("Enter Employee ID to view records:")
                    val empId = readLine()!!
                    val emp = DataManager.employeeLogin(empId)
                    if (emp != null) viewMonthRecord(emp)
                    else println("Employee not found!")
                }
                "2" -> return
                else -> println("Invalid choice")
            }
        }
    } else {
        println("Invalid login!")
    }
}

// ---------------- Attendance -----------------
fun addAttendance(emp: Employee) {
    println("Enter Arrival Time (HH:mm):")
    val timeInput = readLine()!!

    // Parse time and check threshold
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val arrivalTime = LocalTime.parse(timeInput, formatter)
    val threshold = LocalTime.of(8, 30)

    val isLate = arrivalTime.isAfter(threshold)
    val cause = if (isLate) {
        println("You are late! Enter cause for being late:")
        readLine()
    } else null

    val attendance = Attendance(DateUtils.todayDate(), timeInput, isLate, cause)
    emp.attendanceRecords.add(attendance)
    println("Attendance added successfully! ${if (isLate) "Marked as Late." else "On Time."}")
}

fun viewMonthRecord(emp: Employee) {
    println("Attendance Records for ${emp.name}:")
    if (emp.attendanceRecords.isEmpty()) {
        println("No records yet.")
    } else {
        emp.attendanceRecords.forEach {
            val status = if (it.isLate) "Late (${it.lateCause})" else "On Time"
            println("${it.date} ${it.arrivalTime} -> $status")
        }
    }
}
