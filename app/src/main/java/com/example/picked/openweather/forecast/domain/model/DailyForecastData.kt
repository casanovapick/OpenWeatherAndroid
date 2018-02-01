package com.example.picked.openweather.forecast.domain.model

import com.google.gson.annotations.SerializedName

data class DailyForecastData(

        @field:SerializedName("dt")
        val dt: Long = 0,

        @field:SerializedName("temp")
        val tempuratureData: TempuratureData? = null,

        @field:SerializedName("deg")
        val deg: Int? = null,

        @field:SerializedName("weather")
        val weather: List<WeatherDescription?>? = null,

        @field:SerializedName("humidity")
        val humidity: Double? = null,

        @field:SerializedName("pressure")
        val pressure: Double? = null,

        @field:SerializedName("clouds")
        val clouds: Int? = null,

        @field:SerializedName("speed")
        val speed: Double? = null
)