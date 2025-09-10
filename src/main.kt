import models.*
import services.CoffeeMachine
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val machine = CoffeeMachine(500, 400, 200, 5)

    while (true) {
        println(
            """
            ==========================
              ☕ Coffee Machine Menu ☕
            ==========================
            1. Make Espresso
            2. Make Latte
            3. Make Cappuccino
            4. Show Resources
            5. Refill Machine
            6. Exit
            """.trimIndent()
        )

        print("➡ Enter choice: ")
        when (scanner.nextInt()) {
            1 -> machine.makeCoffee(Espresso())
            2 -> machine.makeCoffee(Latte())
            3 -> machine.makeCoffee(Cappuccino())
            4 -> machine.showResources()
            5 -> {
                print("Enter water to add (ml): "); val w = scanner.nextInt()
                print("Enter milk to add (ml): "); val m = scanner.nextInt()
                print("Enter beans to add (g): "); val b = scanner.nextInt()
                print("Enter cups to add: "); val c = scanner.nextInt()
                machine.refill(w, m, b, c)
            }
            6 -> {
                println("👋 Exiting Coffee Machine. Goodbye!")
                break
            }
            else -> println("❌ Invalid choice! Please try again.")
        }
        println()
    }
}
