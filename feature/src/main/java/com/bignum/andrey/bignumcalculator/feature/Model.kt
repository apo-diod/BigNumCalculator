package com.bignum.andrey.bignumcalculator.feature

class Model {

    companion object{
        fun calculate(expression: String, action:Actions):String {

            var result = ""

            val calculation = Calculation(expression)
            if (action == Actions.Addition) {
                result = calculation.addition()
            }
            if (action == Actions.Subtraction) {
                result = calculation.subtract()
            }
            if (action == Actions.Multiplication) {
                result = calculation.multiplication()
            }
            if (action == Actions.Factorial) {
                result = calculation.fact()
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
}