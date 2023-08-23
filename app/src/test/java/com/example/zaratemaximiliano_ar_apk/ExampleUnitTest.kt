package com.example.zaratemaximiliano_ar_apk

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.example.zaratemaximiano_ar_apk.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.junit.Assert.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class ExampleUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(ApplicationProvider.getApplicationContext())
        viewModel.result.observeForever(observer)
    }

    @Test
    fun testCompareWords() {
        assertEquals("Debe ingresar ambos textos. 😒", viewModel.compareWords("", ""))
        assertEquals("Debe llenar ambos campos. 😲", viewModel.compareWords("", "Texto"))
        assertEquals("Debe llenar ambos campos. 😲", viewModel.compareWords("Texto", ""))
        assertEquals("LAS PALABRAS SON IGUALES!!! 👍", viewModel.compareWords("Hola", "Hola"))
        assertEquals("Las palabras no son iguales. 😭", viewModel.compareWords("Hola", "Mundo"))

        println("")
        println("***********************************************")
        println("***********************************************")
        println("** TEST PASADO CORRECTAMENTE - FELICITACION! **")
        println("***********************************************")
        println("***********************************************")
        println("")
    }
}


