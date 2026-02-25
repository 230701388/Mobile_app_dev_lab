package com.example.panvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pan = findViewById<EditText>(R.id.etPAN)
        val pincode = findViewById<EditText>(R.id.etPincode)
        val validate = findViewById<Button>(R.id.btValidate)

        validate.setOnClickListener {

            val panText = pan.text.toString().trim()
            val pinText = pincode.text.toString().trim()

            if (panText.isEmpty() || pinText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Both fields should not be empty",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            val panPattern = "^[A-Za-z0-9]{10}$".toRegex()

            if (!panPattern.matches(panText)) {

                Toast.makeText(
                    this,
                    "PAN must be 10 alphanumeric characters",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            val pincodePattern = "^[0-9]{6}$".toRegex()

            if (!pincodePattern.matches(pinText)) {

                Toast.makeText(
                    this,
                    "Pincode must be 6 digits",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            // Success Message
            Toast.makeText(
                this,
                "Validation Successful",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}