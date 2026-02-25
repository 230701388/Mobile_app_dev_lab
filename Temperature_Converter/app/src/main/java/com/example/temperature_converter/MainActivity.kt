package com.example.temperature_converter

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

        val temp = findViewById<EditText>(R.id.etTemp)
        val btnCel = findViewById<Button>(R.id.btC)
        val btnFar = findViewById<Button>(R.id.btF)
        val result = findViewById<TextView>(R.id.tvResult)

        btnCel.setOnClickListener {
            val input = temp.text.toString()
            val res = (input.toDouble() * 9/5) + 32
            result.text = res.toString()
        }

        btnFar.setOnClickListener {
            val input = temp.text.toString()
            val res = (input.toDouble() - 32) * 5/9
            result.text = res.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
















