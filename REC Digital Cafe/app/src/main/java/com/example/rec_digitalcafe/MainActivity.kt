package com.example.rec_digitalcafe

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

        val email = findViewById<EditText>(R.id.etEmail)
        val password = findViewById<EditText>(R.id.etPassword)
        val validate = findViewById<Button>(R.id.btValidate)

        validate.setOnClickListener {

            val emailText = email.text.toString().trim()
            val passText = password.text.toString().trim()

            // i) Both fields should not be empty
            if (emailText.isEmpty() || passText.isEmpty()) {
                Toast.makeText(
                    this,
                    "Both fields should not be empty",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // ii) Proper college email id
            // Example : anything@college.edu or @college.ac.in
            val collegeEmailPattern =
                "^[A-Za-z0-9._%+-]+@([A-Za-z0-9.-]+\\.(edu\\.in|ac\\.in))$".toRegex()

            if (!collegeEmailPattern.matches(emailText)) {
                Toast.makeText(
                    this,
                    "Enter valid college Email ID",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // iii) Password Validation
            // Minimum 12 characters
            // 1 uppercase
            // 1 number
            // 1 special symbol

            val passwordPattern =
                "^(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&#])[A-Za-z\\d@\$!%*?&#]{12,}$"
                    .toRegex()

            if (!passwordPattern.matches(passText)) {

                Toast.makeText(
                    this,
                    "Password must have 12+ chars, 1 Uppercase, 1 Number & 1 Special Symbol",
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