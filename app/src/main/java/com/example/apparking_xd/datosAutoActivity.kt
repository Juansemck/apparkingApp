package com.example.apparking_xd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class DatosAutoActivity : AppCompatActivity() {

    private lateinit var licTransit: EditText
    private lateinit var classVehicle: EditText
    private lateinit var plateVehicle: EditText
    private lateinit var colorVehicle: EditText
    private lateinit var brandVehicle: EditText
    private lateinit var nextButton: Button
    private lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_auto)

        licTransit = findViewById(R.id.licTransit)
        classVehicle = findViewById(R.id.classVehicle)
        plateVehicle = findViewById(R.id.plateVehicle)
        colorVehicle = findViewById(R.id.colorVehicle)
        brandVehicle = findViewById(R.id.brandVehicle)
        nextButton = findViewById(R.id.nextButton)
        backButton = findViewById(R.id.Botonatras)

        backButton.setOnClickListener {
            finish() // Vuelve a la actividad anterior
        }

        nextButton.setOnClickListener {
            // Aquí puedes añadir la lógica para manejar el clic en el botón "Siguiente"
        }
    }
}
