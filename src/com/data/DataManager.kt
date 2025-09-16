package com.officeattendance.data

import com.officeattendance.model.*

object DataManager {
    private val employees = mutableListOf<Employee>()
    private val officers = mutableListOf<Officer>()

    fun addEmployee(emp: Employee) {
        employees.add(emp)
    }

    fun employeeLogin(id: String): Employee? {
        return employees.find { it.id == id }
    }

    fun addOfficer(officer: Officer) {
        officers.add(officer)
    }

    fun officerLogin(username: String, password: String): Officer? {
        return officers.find { it.username == username && it.password == password }
    }

    fun getEmployeeById(id: String): Employee? {
        return employees.find { it.id == id }
    }
}
