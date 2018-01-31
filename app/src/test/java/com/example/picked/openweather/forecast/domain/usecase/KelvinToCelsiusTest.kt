package com.example.picked.openweather.forecast.domain.usecase

import org.junit.Assert
import org.junit.Test

class KelvinToCelsiusTest {
    private val delta = 0.01
    private val useCase = KelvinToCelsius()
    @Test
    fun execute_0K_minus273p15C() {
        val inputKelvin = 0.0
        val request = KelvinToCelsius.Request(inputKelvin)
        val result = useCase.execute(request)
            .blockingFirst()
        val expected = -273.15
        Assert.assertEquals(expected, result.celsius, delta)
    }

    @Test
    fun execute_273p15K_0C() {
        val inputKelvin = 273.15
        val request = KelvinToCelsius.Request(inputKelvin)
        val result = useCase.execute(request)
            .blockingFirst()
        val expected = 0.0
        Assert.assertEquals(expected, result.celsius, delta)
    }
}