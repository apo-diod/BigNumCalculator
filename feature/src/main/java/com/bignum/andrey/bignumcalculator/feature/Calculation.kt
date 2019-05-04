package com.bignum.andrey.bignumcalculator.feature

import android.view.View
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import kotlin.math.absoluteValue

class Calculation(text:String, view: TextView) {
    var calculation_text = text
    var ViewText = view

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
                rem = (resStr[i-1].toInt()%Math.pow(10.0, 6.0-resStr[i].length).toInt()).toString()
                resStr[i-1] = (resStr[i-1].toInt()/Math.pow(10.0, 6.0-resStr[i].length).toInt()).toString()
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

    fun Addition():String {
        var nums = calculation_text.split(" ")
        if (nums.count() != 2) {
            return ""
        }
        var num1 = nums[0]
        var num2 = nums[1]
        return add(num1, num2)
    }

    fun Subtract():String {
        var nums = calculation_text.split(" ")
        if (nums.count() != 2) {
            return ""
        }
        var num1 = nums[0]
        var num2 = nums[1]
        return subt(num1, num2)
    }

    fun mult(n1:String, n2:String):String {
        var num1 = n1
        var num2 = n2
        num2 = subt(num2, "1")
        while (num2 != "0") {
            num1 = add(num1, n1)
            num2 = subt(num2, "1")
        }
        return num1
    }

    fun Multiplication():String {
        var nums = calculation_text.split(" ")
        if (nums.count() != 2 || nums[1].isBlank() || nums[1].isEmpty()) {
            return ""
        }
        var num1 = nums[0]
        var num2 = nums[1]
        return mult(num1, num2)
    }

    fun Fact():String {
        var base = calculation_text.toInt()
        if (calculation_text.isEmpty()|| calculation_text.isBlank()) {
            return ""
        }
        var result = "1"
        for (i in 1..base) {
            result = mult(result, i.toString())
        }
        return result
    }

    fun Display(s : String) {
        ViewText.text = s
    }
}