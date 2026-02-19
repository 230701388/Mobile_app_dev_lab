package com.example.bmicalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wt = findViewById<EditText>(R.id.wt)
        val ht = findViewById<EditText>(R.id.ht)
        val btnCalculate = findViewById<Button>(R.id.btnCalc)
        val result = findViewById<TextView>(R.id.result)

        btnCalculate.setOnClickListener {

            val weight = wt.text.toString().toDouble()
            val height = ht.text.toString().toDouble()
            val bmi = weight / ((height/100) * (height)/100)
            result.text = bmi.toString()
        }
    }
}
