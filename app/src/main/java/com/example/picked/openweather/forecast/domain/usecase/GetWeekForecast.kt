package com.example.picked.openweather.forecast.domain.usecase

import com.example.picked.openweather.UseCase
import com.example.picked.openweather.forecast.domain.model.WeekForecastData
import com.example.picked.openweather.forecast.data.source.week.remote.WeekForecastRemoteDataSource
import io.reactivex.Observable
import javax.inject.Inject


class GetWeekForecast @Inject constructor(
        private val dataSource: WeekForecastRemoteDataSource) : UseCase<GetWeekForecast.Result, GetWeekForecast.Request> {
    override fun execute(request: GetWeekForecast.Request): Observable<Result> {
        return dataSource.getWeekForecast().map { forecastData ->
            Result(forecastData)
        }
    }

    class Request() : UseCase.Request
    data class Result(val weekForecastData: WeekForecastData) : UseCase.Result
}