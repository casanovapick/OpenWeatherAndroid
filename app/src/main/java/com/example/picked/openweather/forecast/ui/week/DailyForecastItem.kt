package com.example.picked.openweather.forecast.ui.week

import com.example.picked.openweather.forecast.domain.model.DailyForecastData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


data class DailyForecastItem(val dailyForecastData: DailyForecastData? = null) {
    fun getDisplayDate(): String {
        dailyForecastData?.let { forecastData ->
            val pattern = "EEE, d MMM"
            val simpleDateFormat = SimpleDateFormat(pattern, Locale.US)
            return simpleDateFormat.format(Date(forecastData.dt))
        }
        return ""
    }
}
