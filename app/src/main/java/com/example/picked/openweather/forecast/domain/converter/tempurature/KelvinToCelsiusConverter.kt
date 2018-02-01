package com.example.picked.openweather.forecast.domain.converter.tempurature

import javax.inject.Inject


class KelvinToCelsiusConverter @Inject constructor() {
    fun convert(kelvin: Double) = kelvin - 273.15
}
