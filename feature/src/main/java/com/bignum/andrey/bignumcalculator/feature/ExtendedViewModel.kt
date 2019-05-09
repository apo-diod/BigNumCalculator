package com.bignum.andrey.bignumcalculator.feature

import android.arch.lifecycle.ViewModel

class ExtendedViewModel :ViewModel() {

    companion object{
        fun makeCalculation(expression:String, action: Actions) = Model.calculate(expression, action)
    }

}