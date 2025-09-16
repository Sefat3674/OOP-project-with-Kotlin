package com.officeattendance.utils

object IdGenerator {
    private var employeeCount = 0
    private var officerCount = 0

    fun generateEmployeeId(): String {
        employeeCount++
        return "EMP%03d".format(employeeCount)
    }

    fun generateOfficerId(): String {
        officerCount++
        return "OFF%03d".format(officerCount)
    }
}
