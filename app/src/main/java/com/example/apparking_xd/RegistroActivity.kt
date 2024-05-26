package com.example.apparking_xd

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistroActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro) // Asegúrate de que el layout correcto está siendo referenciado

        database = FirebaseDatabase.getInstance().reference

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

        // Manejar el botón de retroceso
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Aquí manejas la acción del botón de retroceso
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        nextButton.setOnClickListener {
            val firstNameStr = firstName.text.toString()
            val lastNameStr = lastName.text.toString()
            val docTypeStr = docType.text.toString()
            val docNumberStr = docNumber.text.toString()
            val phoneStr = phone.text.toString()
            val emailStr = email.text.toString()
            val passwordStr = password.text.toString()
            val confirmPasswordStr = confirmPassword.text.toString()

            if (passwordStr == confirmPasswordStr) {
                val userId = database.push().key
                val user = User(firstNameStr, lastNameStr, docTypeStr, docNumberStr, phoneStr, emailStr, passwordStr)
                if (userId != null) {
                    database.child("users").child(userId).setValue(user).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                            // Redirigir a DatosAutoActivity
                            val intent = Intent(this, DatosAutoActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Error en el registro", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
        }
    }

    data class User(
        val firstName: String,
        val lastName: String,
        val docType: String,
        val docNumber: String,
        val phone: String,
        val email: String,
        val password: String
    )
}
