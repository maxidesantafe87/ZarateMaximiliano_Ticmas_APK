package com.example.zaratemaximiliano_ar_apk

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testButtonClick() {
        // Realiza una acción de clic en un botón con el ID "comparar_button"
        Espresso.onView(ViewMatchers.withId(R.id.comparar_button))
            .perform(ViewActions.click())

        // Verifica que al tocar el boton no hay datos escritos
        Espresso.onView(ViewMatchers.withId(R.id.resultado))
            .check(ViewAssertions.matches(ViewMatchers.withText("Debe ingresar ambos textos. 😒")))
    }
}
