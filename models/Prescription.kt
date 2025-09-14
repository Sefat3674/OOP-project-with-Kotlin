class Prescription(val prescriptionID: String, val appointment: Appointment) {
    private val medicines = mutableListOf<Medicine>()
    fun addMedicine(med: Medicine) { medicines.add(med) }
    fun getMedicines(): List<Medicine> = medicines
}
