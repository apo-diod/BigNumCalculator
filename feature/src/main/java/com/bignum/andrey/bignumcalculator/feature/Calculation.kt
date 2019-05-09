package com.bignum.andrey.bignumcalculator.feature

import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.round

class Calculation(text:String) {
    var calculationText = text

    private fun representAsList(num: String):LinkedList<Int> {
        var resStr = LinkedList<String>()
        var i = 0
        while(i < num.length){
            if (i + 6 <= num.length){
                resStr.add(num.substring(i, i+6))
            } else {
                resStr.add(num.substring(i, num.length))
            }
            i+=6
        }
        i = resStr.count()-1
        var rem = ""
        while (i > 0) {
            if (resStr[i].length < 6) {
                rem = resStr[i-1].substring(resStr[i].length, 6)
                resStr[i-1] = resStr[i-1].substring(0, 6-rem.length)
                resStr[i] = rem+resStr[i]
            }
            i--
        }
        var res = LinkedList<Int>()
        resStr.forEach {
            res.add(it.toInt())
        }
        return res
    }

    private fun add(num1:String, num2:String):String{
        var result = ""
        var x = representAsList(num1)
        var y = representAsList(num2)
        if (x.count() < y.count()) {
            var c = x
            x = y
            y = c
        }
        x.reverse()
        y.reverse()
        var i: Int
        for (i in 0..y.count()-1){
            x[i] += y[i]
        }
        x.reverse()
        y.reverse()
        var remainder = false
        i = x.count()-1
        while (i > -1){
            if (x[i] >= 1000000){
                if ( i == 0) {
                    remainder = true
                } else {
                    x[i-1] += 1
                }
                x[i] = x[i]%1000000
            }
            i--
        }

        if (remainder) {
            result += "1"
        } else {
            result += x[0].toString()
            x.removeAt(0)
        }
        x.forEach {
            if (it.toString().length < 6) {
                for(i in 1..6-it.toString().length){
                    result += "0"
                }
            } else if (it == 0) {
                result += "00000"
            }
            result += it.toString()
        }
        return result
    }

    private fun subt(num1:String, num2:String):String {
        var result = ""
        if (num1.length < num2.length) {
            result = "-"
        }
        var x = representAsList(num1)
        var y = representAsList(num2)
        if (x.count() < y.count()) {
            var c = x
            x = y
            y = c
        }
        var i = y.count()
        while ( i > 0){
            x[x.count()-i] -= y[y.count()-i]
            i--
        }
        x.reverse()
        for ( i in 0 .. x.count()-2) {
            if (x[i] < 0) {
                x[i] += 1000000
                x[i+1] -= 1
            }
        }
        x.reverse()
        if (result == "-"){
            x[0] = x[0].absoluteValue
        }
        result += x[0].toString()
        x.removeAt(0)
        x.forEach {
            if (it.toString().length < 6) {
                for(i in 1..6-it.toString().length){
                    result += "0"
                }
            } else if (it == 0) {
                result += "00000"
            }
            result += it.toString()
        }
        return result
    }

    fun addition():String {
        val nums = calculationText.split(" ")
        if (nums.count() != 2) {
            return ""
        }
        val num1 = nums[0]
        val num2 = nums[1]
        return add(num1, num2)
    }

    fun subtract():String {
        val nums = calculationText.split(" ")
        if (nums.count() != 2) {
            return ""
        }
        val num1 = nums[0]
        val num2 = nums[1]
        return subt(num1, num2)
    }

    private fun mult(n1:String, n2:String):String {
        var num1 = n1
        var num2 = n2
        if (n1.length < n2.length) {
            val c = num1
            num1 = num2
            num2 = c
        }
        if (num1.length == 1 || num2.length == 1) {
            val base = num1
            num2 = subt(num2, "1")
            while (num2 != "0") {
                num1 = add(num1, base)
                num2 = subt(num2, "1")
            }
            return num1
        }
        return Multiplication.multiplicate(num1, num2)
    }

    fun multiplication():String {
        var nums = calculationText.split(" ")
        if (nums.count() != 2 || nums[1].isBlank() || nums[1].isEmpty()) {
            return ""
        }
        var num1 = nums[0]
        var num2 = nums[1]
        return mult(num1, num2)
    }

    fun fact():String {
        if(calculationText.isBlank() || calculationText.isEmpty()) {
            return ""
        }
        var base = calculationText.toInt()
        if (calculationText.isEmpty()|| calculationText.isBlank()) {
            return ""
        }
        var result = "1"
        for (i in 1..base) {
            result = mult(result, i.toString())
        }
        return result
    }

}