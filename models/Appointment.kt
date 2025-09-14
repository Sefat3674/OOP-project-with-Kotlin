class Appointment(val appointmentID: String, val dateTime: String, val doctor: Doctor, val patient: Patient) {
    fun schedule() { println("📅 Appointment scheduled for ${patient.name} with Dr. ${doctor.name} at $dateTime") }
}
