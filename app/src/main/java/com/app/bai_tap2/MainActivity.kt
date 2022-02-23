package com.app.bai_tap2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        caculate()
    }
    fun caculate(){
        var button : Button  = findViewById(R.id.caculate);
        var editText : EditText = findViewById(R.id.input)

        var radioGroup : RadioGroup = findViewById(R.id.tip_options)

        var switch:Switch = findViewById(R.id.round_up_switch)

        var display : TextView = findViewById(R.id.display)

        var result = 0.0

        button.setOnClickListener {

            var getPercent = when(radioGroup.checkedRadioButtonId){
                R.id.option_20 -> 0.20
                R.id.option_18 -> 0.18
                else -> 0.15
            }

            if (editText.text.toString().isEmpty()){
                display.text ="Tip amount : "

            }else{
                result = editText.text.toString().toDouble() * getPercent
                display.text = "Tip amount : " + result.toString()
            }
            if(switch.isChecked){
                display.text = "Tip amount : " + kotlin.math.ceil(result)
            }

            var format = NumberFormat.getCurrencyInstance().format(result)
            display.text = "Tip amount : " + format

        }


    }
}

