package com.example.picked.openweather.forecast.data.source.week.remote

import com.example.picked.openweather.forecast.domain.model.WeekForecastData
import com.example.picked.openweather.forecast.data.source.week.WeekForecastDataSource
import io.reactivex.Observable
import javax.inject.Inject


class WeekForecastRemoteDataSource @Inject constructor(private val api: WeekForecastApi) : WeekForecastDataSource {
    override fun getWeekForecast(): Observable<WeekForecastData> {
        return api.getWeekForecast().map { response ->
            response.body()
        }
    }

}