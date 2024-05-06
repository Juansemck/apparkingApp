package com.example.apparking_xd

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.Handler

@Suppress("DEPRECATION")
class Exito : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000 // Tiempo de espera en milisegundos (3 segundos)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exito)
        Handler().postDelayed({
            // Crea una intención para abrir la actividad de inicio de sesión
            val intent = Intent(this@Exito, LoginActivity::class.java)
            // Inicia la actividad de inicio de sesión con una transición de desvanecimiento
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            // Cierra la actividad actual para que el usuario no pueda regresar a ella con el botón "atrás"
            finish()
        }, SPLASH_TIME_OUT)
    }
}
