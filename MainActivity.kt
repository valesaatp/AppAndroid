package com.example.loginapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Spinner
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Vincular componentes con el código
        val edtCorreo = findViewById<EditText>(R.id.edtCorreo)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val spinnerRol = findViewById<Spinner>(R.id.spinnerRol)

        val opciones = arrayOf(
            "Administrador",
            "Usuario",
            "Invitado"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            opciones
        )

        spinnerRol.adapter = adapter
        edtCorreo.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (!edtCorreo.text.toString().contains("@")) {
                    edtCorreo.error = "Debe contener @"
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        // Evento clic del botón
        btnIngresar.setOnClickListener {

            val correo = edtCorreo.text.toString()
            val password = edtPassword.text.toString()

            // Validación de campos vacíos
            if (correo.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Por favor llena todos los campos",
                    Toast.LENGTH_SHORT
                ).show()

            }

            // Validación básica del correo
            else if (!correo.contains("@")) {

                Toast.makeText(
                    this,
                    "Correo electrónico inválido",
                    Toast.LENGTH_SHORT
                ).show()

            }

            // Inicio de sesión exitoso
            else {

                Toast.makeText(
                    this,
                    "Inicio de sesión exitoso",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}
