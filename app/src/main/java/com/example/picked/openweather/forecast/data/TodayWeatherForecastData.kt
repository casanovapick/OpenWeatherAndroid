package com.example.picked.openweather.forecast.data

import com.google.gson.annotations.SerializedName

data class TodayWeatherForecastData(
        @field:SerializedName("dt") val dt: Long? = null
        , @field:SerializedName("visibility") val visibility: Long? = null
        , @field:SerializedName("name") val name: String? = null
        , @field:SerializedName("cod") val cod: Long? = null
        , @field:SerializedName("main") val weatherInfo: WeatherInfo? = null
        , @field:SerializedName("weather") val weatherDescriptionList: List<WeatherDescription?>
        , @field:SerializedName("id") val id: Long? = null
        , @field:SerializedName("sys") val weatherSystemInfo: WeatherSystemInfo? = null
        , @field:SerializedName("base") val base: String? = null
)