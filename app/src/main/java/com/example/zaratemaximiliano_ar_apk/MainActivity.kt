package com.example.zaratemaximiliano_ar_apk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.inputmethod.InputMethodManager
import android.media.MediaPlayer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var editTextN1: EditText
    private lateinit var editTextN2: EditText
    private lateinit var resultado: TextView
    private lateinit var compararButton: Button
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextN1 = findViewById(R.id.texto_n1)
        editTextN2 = findViewById(R.id.texto_n2)
        resultado = findViewById(R.id.resultado)
        compararButton = findViewById(R.id.comparar_button)
        mediaPlayer = MediaPlayer.create(this, R.raw.mario)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.result.observe(this, { result ->
            resultado.text = result
            resultado.visibility = View.VISIBLE
        })

        compararButton.setOnClickListener {
            val textoN1 = editTextN1.text.toString()
            val textoN2 = editTextN2.text.toString()

            viewModel.compareWords(textoN1, textoN2)

            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.releaseMediaPlayer()
    }
}
