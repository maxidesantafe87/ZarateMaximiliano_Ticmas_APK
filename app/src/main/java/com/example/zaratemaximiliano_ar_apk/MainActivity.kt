package com.example.zaratemaximiliano_ar_apk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.inputmethod.InputMethodManager
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {
    private lateinit var editTextN1: EditText
    private lateinit var editTextN2: EditText
    private lateinit var resultado: TextView
    private lateinit var compararButton: Button
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextN1 = findViewById(R.id.texto_n1)
        editTextN2 = findViewById(R.id.texto_n2)
        resultado = findViewById(R.id.resultado)
        compararButton = findViewById(R.id.comparar_button)
        mediaPlayer = MediaPlayer.create(this, R.raw.mario)

        compararButton.setOnClickListener {
            val textoN1 = editTextN1.text.toString()
            val textoN2 = editTextN2.text.toString()

            val resultadoText = when {
                textoN1.isEmpty() && textoN2.isEmpty() -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.fallo)
                    "Debe ingresar ambos textos. 😒"
                }
                textoN1.isEmpty() || textoN2.isEmpty() -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.fallo)
                    "Debe llenar ambos campos. 😲"
                }
                textoN1 == textoN2 -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.mario)
                    "LAS PALABRAS SON IGUALES!!! 👍"
                }
                else -> {
                    mediaPlayer = MediaPlayer.create(this, R.raw.perder)
                    "Las palabras no son iguales. 😭"
                }
            }

            resultado.text = resultadoText
            resultado.visibility = View.VISIBLE
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
