package com.example.picked.openweather.forecast.data.source

import com.example.picked.openweather.forecast.data.TodayWeatherForecastData
import io.reactivex.Observable


interface TodayWeatherForecastDataSource {
    fun getForecastData(cityName: String): Observable<TodayWeatherForecastData>
}