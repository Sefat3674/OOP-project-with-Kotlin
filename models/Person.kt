open class Person(val name: String, val age: Int, val contact: String) {
    open fun getDetails() = "$name, $age, $contact"
}
