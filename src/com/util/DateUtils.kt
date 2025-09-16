package com.officeattendance.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {
    fun todayDate(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return LocalDate.now().format(formatter)
    }
}
