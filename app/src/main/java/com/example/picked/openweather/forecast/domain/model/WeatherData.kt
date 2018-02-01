package com.example.picked.openweather.forecast.domain.model

import com.google.gson.annotations.SerializedName

data class WeatherData(

	@field:SerializedName("temp")
	val temp: Double? = null,

	@field:SerializedName("temp_min")
	val tempMin: Double? = null,

	@field:SerializedName("humidity")
	val humidity: Double? = null,

	@field:SerializedName("pressure")
	val pressure: Double? = null,

	@field:SerializedName("temp_max")
	val tempMax: Double? = null
)