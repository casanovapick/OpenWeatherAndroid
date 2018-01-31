package com.example.picked.openweather.forecast.data.source.remote

import com.example.picked.openweather.forecast.data.TodayWeatherForecastData
import com.example.picked.openweather.forecast.data.source.TodayWeatherForecastDataSource
import io.reactivex.Observable
import java.io.IOException
import javax.inject.Inject


class TodayWeatherForecastRemoteDataSource @Inject constructor(private val api: TodayWeatherForecastApi) : TodayWeatherForecastDataSource {

    override fun getForecastData(cityName: String): Observable<TodayWeatherForecastData> {
        return api.getTodayWeatherForecast(cityName).map({ response ->
            if (response.isSuccessful) {
                return@map response.body()
            }
            throw IOException()
        })
    }
}