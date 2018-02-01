package com.example.picked.openweather.forecast.data.source.today

import com.example.picked.openweather.forecast.domain.model.TodayWeatherForecastData
import io.reactivex.Observable


interface TodayWeatherForecastDataSource {
    fun getForecastData(cityName: String): Observable<TodayWeatherForecastData>
}