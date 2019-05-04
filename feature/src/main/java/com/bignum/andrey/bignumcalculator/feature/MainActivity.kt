package com.bignum.andrey.bignumcalculator.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import java.util.Stack
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    fun viewDisplay(text: String) {
        var textView = findViewById<TextView>(R.id.result_text)
        textView.text = textView.text.toString() + text
    }

    fun viewDel() {
        if (result_text.text.isEmpty()) {
            return
        }
        result_text.text = result_text.text.subSequence(0, result_text.length()-1)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        println("Created!")
        one_button.setOnClickListener {
            viewDisplay("1")
        }
        two_button.setOnClickListener {
            viewDisplay("2")
        }
        three_button.setOnClickListener {
            viewDisplay("3")
        }
        four_button.setOnClickListener {
            viewDisplay("4")
        }
        five_button.setOnClickListener {
            viewDisplay("5")
        }
        six_button.setOnClickListener {
            viewDisplay("6")
        }
        seven_button.setOnClickListener {
            viewDisplay("7")
        }
        eight_button.setOnClickListener {
            viewDisplay("8")
        }
        nine_button.setOnClickListener {
            viewDisplay("9")
        }
        zero_button.setOnClickListener {
            viewDisplay("0")
        }
        add_button.setOnClickListener {
            var calc = Calculation(result_text.text.toString(), result_text)
            calc.Addition()
        }
        subtract_button.setOnClickListener {
            viewDisplay("-")
        }
        multiply_button.setOnClickListener {

        }
        del_button.setOnLongClickListener {
            while (result_text.text.isNotEmpty())
                viewDel()
            true
        }
        del_button.setOnClickListener {
            viewDel()
        }
        result_button.setOnClickListener {
            viewDisplay(" ")
        }
    }
}
