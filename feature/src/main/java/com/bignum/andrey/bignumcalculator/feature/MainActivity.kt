package com.bignum.andrey.bignumcalculator.feature

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.AppCompatButton

@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {
    private lateinit var view:View
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("calculationResult", view.getText())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState?.get("calculationResult") != null) view.displayText(savedInstanceState.get("calculationResult").toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_main)

        view = View(result_text)
        for (i in 0 until buttonLayout.childCount){
            if ((i+1)%4 != 0 && i < 12) {
                view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                    val self = it as AppCompatButton
                    view.displayText(view.getText()+self.text.toString())
                })
            } else {
                when (i) {
                    13 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        val self = it as AppCompatButton
                        view.displayText(view.getText()+self.text.toString())
                    })
                    14 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        view.displayText(view.getText()+" ")
                    })
                    12 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        view.calculate(Actions.Factorial)
                    })
                    15 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        view.calculate(Actions.Multiplication)
                    })
                    3 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        var txt = view.getText()
                        if (txt.isNotBlank() || txt.isNotEmpty()) {
                            txt = txt.substring(0 until txt.length-1)
                        }
                        view.displayText(txt)
                    }, android.view.View.OnLongClickListener {
                        view.displayText("")
                        true
                    })
                    7 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        view.calculate(Actions.Addition)
                    })
                    11 -> view.addButton(buttonLayout.getChildAt(i) as AppCompatButton, android.view.View.OnClickListener {
                        view.calculate(Actions.Subtraction)
                    })
                }
            }
        }
    }
}
