package com.example.radioapp
import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<LinearLayout>(R.id.main)
        val text = findViewById<TextView>(R.id.colorText)
        val green = findViewById<RadioButton>(R.id.greenc)
        val red = findViewById<RadioButton>(R.id.redc)
        val blue = findViewById<RadioButton>(R.id.bluec)


        red.setOnClickListener {
            mainLayout.setBackgroundColor(Color.RED)
        }
        green.setOnClickListener {
            mainLayout.setBackgroundColor(Color.GREEN)
        }
        blue.setOnClickListener {
            mainLayout.setBackgroundColor(Color.BLUE)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}