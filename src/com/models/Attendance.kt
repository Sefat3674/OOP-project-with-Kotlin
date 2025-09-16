package com.officeattendance.model

data class Attendance(
    val date: String,
    val arrivalTime: String,
    val isLate: Boolean,
    val lateCause: String? = null
)
