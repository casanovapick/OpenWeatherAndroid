package com.example.picked.openweather.forecast.domain.converter.tempurature

import org.junit.Assert
import org.junit.Test

class KelvinToFahrenheitConverterTest {
    private val useCase = KelvinToFahrenheitConverter()
    private val delta = 0.01

    @Test
    fun execute_260k_8p33F() {
        val inputKelvin = 260.00
        val result = useCase.convert(inputKelvin)
        val expected = 8.33
        Assert.assertEquals(expected, result, delta)
    }

    @Test
    fun execute_0k_minus459p67F() {
        val inputKelvin = 0.0
        val result = useCase.convert(inputKelvin)
        val expected = -459.67
        Assert.assertEquals(expected, result, delta)
    }
}