package services

import models.Coffee

class CoffeeMachine(
    private var water: Int = 1000,
    private var milk: Int = 1000,
    private var beans: Int = 500,
    private var cups: Int = 10
) : CoffeeMachineActions {

    override fun makeCoffee(coffee: Coffee) {
        if (hasEnoughResources(coffee)) {
            water -= coffee.waterNeeded
            milk -= coffee.milkNeeded
            beans -= coffee.beansNeeded
            cups--

            println("☕ Brewing ${coffee.name}... Price: \$${coffee.price}")
            coffee.brew()
        } else {
            println("❌ Not enough resources to make ${coffee.name}")
        }
    }

    private fun hasEnoughResources(coffee: Coffee): Boolean {
        return water >= coffee.waterNeeded &&
               milk >= coffee.milkNeeded &&
               beans >= coffee.beansNeeded &&
               cups > 0
    }

    override fun refill(water: Int, milk: Int, beans: Int, cups: Int) {
        this.water += water
        this.milk += milk
        this.beans += beans
        this.cups += cups
        println("✅ Machine refilled successfully!")
    }

    override fun showResources() {
        println("\n📦 Current Machine Resources:")
        println("Water: $water ml | Milk: $milk ml | Beans: $beans g | Cups: $cups")
    }
}
