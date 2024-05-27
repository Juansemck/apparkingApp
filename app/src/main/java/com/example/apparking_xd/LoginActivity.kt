package com.example.apparking_xd
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import android.widget.EditText
import android.widget.Button

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUser: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonIngresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextUser = findViewById(R.id.editTextUser)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonIngresar = findViewById(R.id.buttonIngresar)
        setup()
    }

    private fun setup() {
        buttonIngresar.setOnClickListener {
            if (editTextUser.text.isEmpty() || editTextPassword.text.isEmpty()) {
                showMissingDataAlert()
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextUser.text.toString(), editTextPassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        goToPagPrincipal()
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showMissingDataAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Por favor ingresar todos los datos.")
        builder.setPositiveButton("Continuar") { _, _ ->
            // Cerrar la ventana emergente
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun goToPagPrincipal() {
        // Crear una intención para iniciar la actividad de registro
        val intent = Intent(this, PagPrincipalActivity::class.java)
        // Iniciar la actividad de registro
        startActivity(intent)
        // Aplicar una animación de transición personalizada
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        // Finalizar la actividad actual para que no se pueda volver atrás a ella
        finish()
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun goToSelectUserTypeActivity(view: View) {
        // Crear una intención para iniciar la actividad de selección de tipo de usuario
        val intent = Intent(this, selectUserType::class.java)
        // Iniciar la actividad de selección de tipo de usuario
        startActivity(intent)
        // Aplicar una animación de transición personalizada
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        // Finalizar la actividad actual para que no se pueda volver atrás a ella
        finish()
    }
}