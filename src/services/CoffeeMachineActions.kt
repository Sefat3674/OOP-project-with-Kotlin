package services

import models.Coffee

interface CoffeeMachineActions {
    fun makeCoffee(coffee: Coffee)
    fun refill(water: Int, milk: Int, beans: Int, cups: Int)
    fun showResources()
}
