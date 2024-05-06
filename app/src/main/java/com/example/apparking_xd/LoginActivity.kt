package com.example.apparking_xd
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View


@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun goToRegistroActivity(view: View) {
        // Crear una intención para iniciar la actividad de registro
        val intent = Intent(this, RegistroActivity::class.java)
        // Iniciar la actividad de registro
        startActivity(intent)
        // Aplicar una animación de transición personalizada
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        // Finalizar la actividad actual para que no se pueda volver atrás a ella
        finish()
    }
}
