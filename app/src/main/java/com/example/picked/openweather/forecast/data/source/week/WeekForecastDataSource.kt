package com.example.picked.openweather.forecast.data.source.week

import com.example.picked.openweather.forecast.domain.model.WeekForecastData
import io.reactivex.Observable


interface WeekForecastDataSource {
    fun getWeekForecast(): Observable<WeekForecastData>
}