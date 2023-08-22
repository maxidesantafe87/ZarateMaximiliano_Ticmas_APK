package com.example.zaratemaximiliano_ar_apk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextN1: EditText = findViewById(R.id.texto_n1)
        val editTextN2: EditText = findViewById(R.id.texto_n2)
        val resultado: TextView = findViewById(R.id.resultado)
        val compararButton: Button = findViewById(R.id.comparar_button)

        compararButton.setOnClickListener {
            val textoN1 = editTextN1.text.toString()
            val textoN2 = editTextN2.text.toString()

            when {
                textoN1.isEmpty() && textoN2.isEmpty() -> {
                    resultado.text = "Debe ingresar ambos textos. 😒"
                }
                textoN1.isEmpty() -> {
                    resultado.text = "Debe ingresar texto en la Primera palabra.\uD83D\uDE32"
                }
                textoN2.isEmpty() -> {
                    resultado.text = "Debe ingresar texto en la Segunda palabra. 😲"
                }
                textoN1 == textoN2 -> {
                    resultado.text = "LAS PALABRAS SON IGUALES!!!👍"
                }
                else -> {
                    resultado.text = "Las palabras no son iguales. 😭"
                }
            }

            // Mostrar el resultado y cerrar el teclado virtual
            resultado.visibility = View.VISIBLE
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}
