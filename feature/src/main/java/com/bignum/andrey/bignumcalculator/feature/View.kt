package com.bignum.andrey.bignumcalculator.feature

import android.support.v7.widget.AppCompatButton
import android.view.View
import android.widget.TextView
import java.util.*

class View(private var VM:ExtendedViewModel, private var calculationDisplay:TextView) {
    private var displays: LinkedList<TextView> = LinkedList()
    private var buttons: LinkedList<AppCompatButton> = LinkedList()

    fun setCalculationDisplay(displ:TextView) {
        calculationDisplay = displ
    }

    fun AddDisplay(displ: TextView) {
        displays.add(displ)
    }

    fun DisplayText(txt: String) {
        calculationDisplay.text = txt
        displays.forEach {
            it.text = txt
        }
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

    fun calculate(action: Actions) =  DisplayText(VM.MakeCalculation(calculationDisplay.text.toString(), action))

    fun getText() = calculationDisplay.text.toString()

}