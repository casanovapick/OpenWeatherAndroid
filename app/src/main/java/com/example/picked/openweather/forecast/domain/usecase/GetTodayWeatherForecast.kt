package com.example.picked.openweather.forecast.domain.usecase

import com.example.picked.openweather.UseCase
import com.example.picked.openweather.forecast.data.TodayWeatherForecastData
import com.example.picked.openweather.forecast.data.source.TodayWeatherForecastDataSource
import io.reactivex.Observable
import javax.inject.Inject


class GetTodayWeatherForecast @Inject constructor(
        private val dataSource: TodayWeatherForecastDataSource) :
        UseCase<GetTodayWeatherForecast.Result, GetTodayWeatherForecast.Request> {

    override fun execute(request: Request): Observable<Result> {
        return dataSource.getForecastData(request.cityName)
            .map {
                return@map Result(data = it)
            }
    }

    data class Request(val cityName: String) : UseCase.Request


    data class Result(val data: TodayWeatherForecastData) : UseCase.Result
}