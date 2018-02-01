package com.example.picked.openweather.forecast.domain.model

import com.google.gson.annotations.SerializedName

data class WeekForecastData(

        @field:SerializedName("list")
        val list: List<DailyForecastData?>? = null,
        @field:SerializedName("cod")
        val cod: Int? = null
)