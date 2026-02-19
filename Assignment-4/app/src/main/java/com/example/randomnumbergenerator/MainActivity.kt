package com.example.randomnumbergenerator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val min = findViewById<EditText>(R.id.min)
        val max = findViewById<EditText>(R.id.max)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val result = findViewById<TextView>(R.id.result)

        btnGenerate.setOnClickListener {

            val minimum = min.text.toString().toInt()
            val maximum = max.text.toString().toInt()
            val randomNumber = Random.nextInt(minimum, maximum + 1)

            result.text = randomNumber.toString()
        }
    }
}