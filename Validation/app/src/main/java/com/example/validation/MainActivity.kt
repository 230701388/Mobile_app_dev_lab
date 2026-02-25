package com.example.validation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.etUsername)
        val pin = findViewById<EditText>(R.id.etPin)
        val validate = findViewById<Button>(R.id.btValidate)

        validate.setOnClickListener {

            val usernameText = username.text.toString()
            val pinText = pin.text.toString()

            if (usernameText.isEmpty() || pinText.isEmpty()) {
                Toast.makeText(
                    this,
                    "Both fields should not be empty",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            val usernamePattern =
                "^[A-Za-z]+$".toRegex()

            if (!usernamePattern.matches(usernameText)) {
                Toast.makeText(
                    this,
                    "Username should contain only alphabets",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }



            val pinPattern =
                "^[\\d]{4}$"
                    .toRegex()

            if (!pinPattern.matches(pinText)) {

                Toast.makeText(
                    this,
                    "Pin should have exactly 4 digits",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            // Success
            Toast.makeText(
                this,
                "Validation Successful",
                Toast.LENGTH_LONG
            ).show()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}