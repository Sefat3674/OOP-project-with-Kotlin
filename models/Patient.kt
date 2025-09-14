class Patient(name: String, age: Int, contact: String, val patientID: String) : Person(name, age, contact) {
    private val medicalHistory = mutableListOf<String>()
    val appointmentRequests = mutableListOf<Appointment>()

    fun requestAppointment(appointment: Appointment) {
        appointmentRequests.add(appointment)
        println("✅ Appointment requested with Dr. ${appointment.doctor.name} on ${appointment.dateTime}")
    }

    fun addRecord(record: String) { medicalHistory.add(record) }
    fun getHistory(): List<String> = medicalHistory
}
