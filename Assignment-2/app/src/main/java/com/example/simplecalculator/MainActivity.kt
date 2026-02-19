package com.example.simplecalculator

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val result = findViewById<TextView>(R.id.result)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        fun calculate(
            num1: EditText,
            num2: EditText,
            result: TextView,
            operator: String
        ) {
            val n1 = num1.text.toString().toDoubleOrNull()
            val n2 = num2.text.toString().toDoubleOrNull()

            if (n1 == null || n2 == null) {
                result.text = "Result: Invalid Input"
                return
            }

            var output: Double

            if (operator == "+") {
                output = n1 + n2
            } else if (operator == "-") {
                output = n1 - n2
            } else if (operator == "*") {
                output = n1 * n2
            } else if (operator == "/") {
                if (n2 != 0.0) {
                    output = n1 / n2
                } else {
                    result.text = "Result: Cannot divide by zero"
                    return
                }
            } else {
                result.text = "Result: Invalid Operator"
                return
            }

            result.text = "Result: $output"
        }
        btnAdd.setOnClickListener {
            calculate(num1, num2, result, "+")
        }

        btnSub.setOnClickListener {
            calculate(num1, num2, result, "-")
        }

        btnMul.setOnClickListener {
            calculate(num1, num2, result, "*")
        }

        btnDiv.setOnClickListener {
            calculate(num1, num2, result, "/")
        }
    }
}