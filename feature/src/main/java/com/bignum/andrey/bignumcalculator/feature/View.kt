package com.bignum.andrey.bignumcalculator.feature

import android.support.v7.widget.AppCompatButton
import android.view.View
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.onComplete
import java.util.*

class View(private var calculationDisplay:TextView) {
    private var buttons: LinkedList<AppCompatButton> = LinkedList()

    fun setCalculationDisplay(displ:TextView) {
        calculationDisplay = displ
    }

    fun addButton(btn:AppCompatButton, onClickListener: View.OnClickListener) {
        btn.setOnClickListener(onClickListener)
        buttons.add(btn)
    }

    fun addButton(btn:AppCompatButton, onLongClickListener: View.OnLongClickListener){
        btn.setOnLongClickListener(onLongClickListener)
        buttons.add(btn)
    }

    fun addButton(btn:AppCompatButton, onClickListener: View.OnClickListener, onLongClickListener: View.OnLongClickListener) {
        btn.setOnClickListener(onClickListener)
        btn.setOnLongClickListener(onLongClickListener)
        buttons.add(btn)
    }

    fun displayText(txt:String){
        calculationDisplay.text =txt
    }

    fun calculate(action: Actions) {
        calculationDisplay.text = ExtendedViewModel.makeCalculation(calculationDisplay.text.toString(), action).toString()
    }

    fun getText() = calculationDisplay.text.toString()

}