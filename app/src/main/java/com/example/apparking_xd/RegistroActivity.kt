package com.example.apparking_xd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val nextButton: Button = findViewById(R.id.nextButton)
        val firstName: EditText = findViewById(R.id.firstName)
        val lastName: EditText = findViewById(R.id.lastName)
        val docType: EditText = findViewById(R.id.docType)
        val docNumber: EditText = findViewById(R.id.docNumber)
        val phone: EditText = findViewById(R.id.phone)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val confirmPassword: EditText = findViewById(R.id.confirmPassword)

        backButton.setOnClickListener {
            onBackPressed()
        }

        nextButton.setOnClickListener {
            // Puedes añadir lógica adicional para validar y procesar los datos aquí
            Toast.makeText(this, "Siguiente", Toast.LENGTH_SHORT).show()
        }
    }
}
