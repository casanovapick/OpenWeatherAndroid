package com.example.picked.openweather.forecast.domain.usecase

import com.example.picked.openweather.UseCase
import com.example.picked.openweather.forecast.data.source.today.TodayWeatherForecastDataSource
import com.example.picked.openweather.forecast.domain.model.TodayWeatherForecastData
import io.reactivex.Observable
import javax.inject.Inject


class GetTodayWeatherForecast @Inject constructor(
        private val dataSource: TodayWeatherForecastDataSource) :
        UseCase<GetTodayWeatherForecast.Result, GetTodayWeatherForecast.Request> {

    override fun execute(request: Request): Observable<Result> {
        val mapper: (TodayWeatherForecastData) -> Result = { forecastData ->
            Result(data = forecastData, isSuccess = forecastData.cod == 200)
        }
        return dataSource.getForecastData(request.cityName).map(mapper)
    }

    data class Request(val cityName: String) : UseCase.Request


    data class Result(val data: TodayWeatherForecastData, val isSuccess: Boolean) : UseCase.Result
}