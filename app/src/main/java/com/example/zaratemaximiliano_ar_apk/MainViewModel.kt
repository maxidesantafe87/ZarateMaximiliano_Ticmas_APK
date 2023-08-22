package com.example.zaratemaximiliano_ar_apk

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private lateinit var mediaPlayer: MediaPlayer

    init {
        mediaPlayer = MediaPlayer.create(getApplication(), R.raw.mario)
    }

    fun compareWords(textoN1: String, textoN2: String) {
        val resultadoText = when {
            textoN1.isEmpty() && textoN2.isEmpty() -> {
                mediaPlayer = MediaPlayer.create(getApplication(), R.raw.fallo)
                "Debe ingresar ambos textos. 😒"
            }
            textoN1.isEmpty() || textoN2.isEmpty() -> {
                mediaPlayer = MediaPlayer.create(getApplication(), R.raw.fallo)
                "Debe llenar ambos campos. 😲"
            }
            textoN1 == textoN2 -> {
                mediaPlayer = MediaPlayer.create(getApplication(), R.raw.mario)
                "LAS PALABRAS SON IGUALES!!! 👍"
            }
            else -> {
                mediaPlayer = MediaPlayer.create(getApplication(), R.raw.perder)
                "Las palabras no son iguales. 😭"
            }
        }

        _result.value = resultadoText
        mediaPlayer.start()
    }

    fun releaseMediaPlayer() {
        mediaPlayer.release()
    }
}
