package com.example.picked.openweather.forecast.domain.converter.tempurature

import javax.inject.Inject


class KelvinToFahrenheitConverter @Inject constructor(){
    fun convert(kelvin: Double) = (kelvin * 1.80) - 459.67
}
