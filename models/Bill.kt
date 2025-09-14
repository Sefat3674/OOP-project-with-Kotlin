abstract class Bill(val billID: String, var amount: Double) {
    abstract fun calculateTotal(): Double
}

class FullBill(
    billID: String,
    val appointmentFee: Double,
    val medicines: List<Medicine>
) : Bill(billID, appointmentFee) {

    override fun calculateTotal(): Double {
        var medTotal = 0.0
        for (med in medicines) {
            medTotal += med.price
        }
        return amount + medTotal
    }
}
