package com.bignum.andrey.bignumcalculator.feature

enum class Actions {
    Addition{
       override val symbol = "+"
    },

    Subtraction{
        override val symbol = "-"
    },

    Multiplication{
        override val symbol = "*"
    },

    Factorial{
        override val symbol = "!"
    };
    abstract val symbol:String
}