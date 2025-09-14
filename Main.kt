fun patientSelectDoctor(patient: Patient, doctors: List<Doctor>): Doctor? {
    val specialties = doctors.map { it.specialty }.distinct()
    println("Available specialties:")
    specialties.forEachIndexed { index, spec -> println("${index + 1}. $spec") }

    print("Select a specialty: ")
    val specIndex = readLine()?.toIntOrNull() ?: return null
    val selectedSpec = specialties.getOrNull(specIndex - 1) ?: return null

    val availableDoctors = doctors.filter { it.specialty == selectedSpec }
    println("Available doctors in $selectedSpec:")
    availableDoctors.forEachIndexed { index, doc -> println("${index + 1}. Dr. ${doc.name}") }

    print("Select a doctor: ")
    val docIndex = readLine()?.toIntOrNull() ?: return null
    return availableDoctors.getOrNull(docIndex - 1)
}

fun main() {
    val patients = mutableListOf<Patient>()
    val doctors = mutableListOf<Doctor>()
    val appointments = mutableListOf<Appointment>()

    mainLoop@ while (true) {
        println("\n===== Hospital Management System =====")
        println("1. Add Patient")
        println("2. Add Doctor")
        println("3. Patient Request Appointment")
        println("4. Doctor Accept & Prescribe")
        println("5. Patient Buy Medicines & Generate Bill")
        println("6. Exit")
        print("Choose an option: ")

        when (readLine()?.toIntOrNull()) {

            1 -> {
                print("Enter patient name: ")
                val name = readLine() ?: ""
                print("Enter age: ")
                val age = readLine()?.toIntOrNull() ?: 0
                print("Enter contact: ")
                val contact = readLine() ?: ""
                print("Enter patient ID: ")
                val id = readLine() ?: ""
                val patient = Patient(name, age, contact, id)
                patients.add(patient)
                println("✅ Patient added: ${patient.getDetails()}")
            }

            2 -> {
                print("Enter doctor name: ")
                val name = readLine() ?: ""
                print("Enter age: ")
                val age = readLine()?.toIntOrNull() ?: 0
                print("Enter contact: ")
                val contact = readLine() ?: ""
                print("Enter doctor ID: ")
                val id = readLine() ?: ""
                print("Enter specialty: ")
                val specialty = readLine() ?: ""
                val doctor = Doctor(name, age, contact, id, specialty)
                doctors.add(doctor)
                println("✅ Doctor added: ${doctor.getDetails()}")
            }

            3 -> {
                if (patients.isEmpty() || doctors.isEmpty()) {
                    println("⚠ Please add both patients and doctors first.")
                    continue@mainLoop
                }

                println("Select patient index:")
                patients.forEachIndexed { index, p -> println("$index. ${p.name}") }
                val pIndex = readLine()?.toIntOrNull() ?: continue@mainLoop
                val patient = patients.getOrNull(pIndex) ?: continue@mainLoop

                val doctor = patientSelectDoctor(patient, doctors)
                if (doctor != null) {
                    print("Enter appointment ID: ")
                    val appID = readLine() ?: ""
                    print("Enter date & time: ")
                    val dt = readLine() ?: ""
                    val appointment = Appointment(appID, dt, doctor, patient)
                    patient.requestAppointment(appointment)
                    appointments.add(appointment)
                    println("✅ Appointment requested for ${patient.name} with Dr.${doctor.name}")
                } else println("⚠ Invalid selection.")
            }

            4 -> {
                if (appointments.isEmpty()) {
                    println("⚠ No appointment requests available.")
                    continue@mainLoop
                }

                println("Select appointment index for doctor to accept:")
                appointments.forEachIndexed { index, a -> println("$index. ${a.patient.name} with Dr.${a.doctor.name}") }
                val aIndex = readLine()?.toIntOrNull() ?: continue@mainLoop
                val appointment = appointments.getOrNull(aIndex) ?: continue@mainLoop

                appointment.doctor.acceptAppointment(appointment)

                val prescription = Prescription("RX-${appointment.appointmentID}", appointment)
                while (true) {
                    print("Enter medicine name (or 'done' to finish): ")
                    val medName = readLine() ?: ""
                    if (medName.toLowerCase() == "done") break
                    print("Enter stock: ")
                    val stock = readLine()?.toIntOrNull() ?: 0
                    print("Enter price: ")
                    val price = readLine()?.toDoubleOrNull() ?: 0.0
                    val medicine = Medicine(medName, stock, price)
                    prescription.addMedicine(medicine)
                }

                print("Enter patient condition/notes: ")
                val record = readLine() ?: ""
                appointment.doctor.examinePatient(appointment, record, prescription)
                println("✅ Prescription recorded for ${appointment.patient.name}")
            }

            5 -> {
                if (appointments.isEmpty()) {
                    println("⚠ No appointments available for billing.")
                    continue@mainLoop
                }

                println("Select appointment index for billing:")
                appointments.forEachIndexed { index, a -> println("$index. ${a.patient.name} with Dr.${a.doctor.name}") }
                val aIndex = readLine()?.toIntOrNull() ?: continue@mainLoop
                val appointment = appointments.getOrNull(aIndex) ?: continue@mainLoop

                val prescription = Prescription("RX-${appointment.appointmentID}", appointment)
                while (true) {
                    print("Enter medicine name to buy (or 'done' to finish): ")
                    val medName = readLine() ?: ""
                    if (medName.toLowerCase() == "done") break
                    print("Enter price: ")
                    val price = readLine()?.toDoubleOrNull() ?: 0.0
                    val medicine = Medicine(medName, 1, price)
                    prescription.addMedicine(medicine)
                }

                print("Enter appointment fee: ")
                val fee = readLine()?.toDoubleOrNull() ?: 0.0

                // Calculate total manually
                var medTotal = 0.0
                for (med in prescription.getMedicines()) medTotal += med.price
                val totalBill = fee + medTotal

                println("💰 Total bill for ${appointment.patient.name}: \$${totalBill}")
            }

            6 -> {
                println("🚪 Exiting... Goodbye!")
                break@mainLoop
            }

            else -> println("⚠ Invalid option.")
        }
    }
}
