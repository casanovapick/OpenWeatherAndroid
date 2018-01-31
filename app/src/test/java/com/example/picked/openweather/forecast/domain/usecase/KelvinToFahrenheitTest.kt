package com.example.picked.openweather.forecast.domain.usecase

import org.junit.Assert
import org.junit.Test

class KelvinToFahrenheitTest {
    private val useCase = KelvinToFahrenheit()
    private val delta = 0.01

    @Test
    fun execute_260k_8p33F() {
        val inputKelvin = 260.00
        val request = KelvinToFahrenheit.Request(inputKelvin)
        val result = useCase.execute(request)
            .blockingFirst()
        val expected = 8.33
        Assert.assertEquals(expected, result.fahrenheit, delta)
    }

    @Test
    fun execute_0k_minus459p67F() {
        val inputKelvin = 0.0
        val request = KelvinToFahrenheit.Request(inputKelvin)
        val result = useCase.execute(request)
            .blockingFirst()
        val expected = -459.67
        Assert.assertEquals(expected, result.fahrenheit, delta)
    }
}