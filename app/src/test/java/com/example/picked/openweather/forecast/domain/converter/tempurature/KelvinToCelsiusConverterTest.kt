package com.example.picked.openweather.forecast.domain.converter.tempurature

import org.junit.Assert
import org.junit.Test

class KelvinToCelsiusConverterTest {
    private val delta = 0.01
    private val useCase = KelvinToCelsiusConverter()
    @Test
    fun execute_0K_minus273p15C() {
        val inputKelvin = 0.0
        val result = useCase.convert(inputKelvin)
        val expected = -273.15
        Assert.assertEquals(expected, result, delta)
    }

    @Test
    fun execute_273p15K_0C() {
        val inputKelvin = 273.15
        val result = useCase.convert(inputKelvin)
        val expected = 0.0
        Assert.assertEquals(expected, result, delta)
    }
}