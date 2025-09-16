package com.officeattendance.model

data class Employee(
    val id: String,
    val name: String,
    val attendanceRecords: MutableList<Attendance> = mutableListOf()
)
