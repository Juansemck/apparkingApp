package com.example.apparking_xd

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PagPrincipalActivity : AppCompatActivity() {

    private lateinit var closeButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pag_principal)  // Actualiza la referencia aquí

        closeButton = findViewById(R.id.close_button)
        closeButton.setOnClickListener { finish() }
    }
}
