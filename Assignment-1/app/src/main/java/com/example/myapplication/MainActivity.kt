package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val countTxt = findViewById<TextView>(R.id.count)
        val btncheckIn = findViewById<Button>(R.id.checkIn)
        val btncheckOut = findViewById<Button>(R.id.checkOut)
        var count:Int = 0

        btncheckIn.setOnClickListener {
            count += 1
            countTxt.text = count.toString()
        }

        btncheckOut.setOnClickListener {
            count -= 1
            countTxt.text = count.toString()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}