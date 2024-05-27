package com.example.apparking_xd
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
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
        buttonIngresar.setOnClickListener{
            if(editTextUser.text.isNotEmpty() && editTextPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(editTextUser.text.toString(),editTextPassword.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        goToPagPrincipal()
                    }else{
                        showAlert()
                    }
                }
            }
        }
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

    fun goToRegistroActivity() {
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