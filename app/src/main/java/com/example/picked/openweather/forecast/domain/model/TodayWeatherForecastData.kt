package com.example.picked.openweather.forecast.domain.model

import com.google.gson.annotations.SerializedName

data class TodayWeatherForecastData(
        @field:SerializedName("dt") val dt: Long? = 0
        , @field:SerializedName("visibility") val visibility: Long? = 0
        , @field:SerializedName("name") val name: String? = ""
        , @field:SerializedName("cod") val cod: Int? = 0
        , @field:SerializedName("main") val weatherData: WeatherData? = null
        , @field:SerializedName("weather") val weatherDescriptionList: List<WeatherDescription?>
        , @field:SerializedName("id") val id: Long? = 0
        , @field:SerializedName("base") val base: String? = ""
)