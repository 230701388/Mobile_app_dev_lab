package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
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

        val tvHello = findViewById<TextView>(R.id.tvHello)
        val btnFontSize = findViewById<Button>(R.id.btnFontSize)
        val btnTextColor = findViewById<Button>(R.id.btnTextColor)
        val btnBgColor = findViewById<Button>(R.id.btnBgColor)
        val layoutMain = findViewById<LinearLayout>(R.id.layoutMain)

        var fontSize = 20f
        var textColorIndex = 0
        var bgColorIndex = 0
        val colors = arrayOf(Color.RED, Color.GREEN, Color.BLUE)

        btnFontSize.setOnClickListener {
            fontSize += 5
            if (fontSize > 50) {
                fontSize = 0f
            }
            tvHello.textSize = fontSize
        }

        btnTextColor.setOnClickListener {
            tvHello.setTextColor(colors[textColorIndex])
            textColorIndex = (textColorIndex + 1) % colors.size
        }

        btnBgColor.setOnClickListener {
            layoutMain.setBackgroundColor(colors[bgColorIndex])
            bgColorIndex = (bgColorIndex + 1) % colors.size
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
