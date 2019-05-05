package com.bignum.andrey.bignumcalculator.feature

import android.arch.lifecycle.ViewModel
import java.util.*

class ExtendedViewModel(private var calculatorModel: Model) :ViewModel() {

    fun MakeCalculation(expression:String, action: Actions) = calculatorModel.Calculate(expression, action)

}