class Doctor(name: String, age: Int, contact: String, val doctorID: String, val specialty: String) : Person(name, age, contact) {
    val acceptedAppointments = mutableListOf<Appointment>()

    fun acceptAppointment(appointment: Appointment) {
        acceptedAppointments.add(appointment)
        println("✅ Appointment accepted for ${appointment.patient.name} on ${appointment.dateTime}")
    }

    fun examinePatient(appointment: Appointment, record: String, prescription: Prescription) {
        appointment.patient.addRecord(record)
        println("🩺 Doctor examined ${appointment.patient.name}: $record")
        println("💊 Prescription added for ${appointment.patient.name}")
    }
}
