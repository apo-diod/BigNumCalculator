package com.bignum.andrey.bignumcalculator.feature

import java.util.*

class Model() {

    fun Calculate(expression: String, action:Actions):String {

        var result = ""

        val calculation = Calculation(expression)
        if (action == Actions.Addition) {
            result = calculation.Addition()
        }
        if (action == Actions.Subtraction) {
            result = calculation.Subtract()
        }
        if (action == Actions.Multiplication) {
            result = calculation.Multiplication()
        }
        if (action == Actions.Factorial) {
            result = calculation.Fact()
        }
        return result
    }

    /*
    private var history : LinkedList<Calculation> = LinkedList()

    fun addToHistory(calculation: Calculation) {
        history.add(calculation)
    }

    fun getHistory() = history
    */
}