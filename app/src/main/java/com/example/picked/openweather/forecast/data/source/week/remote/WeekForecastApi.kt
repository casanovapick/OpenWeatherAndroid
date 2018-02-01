package com.example.picked.openweather.forecast.data.source.week.remote

import com.example.picked.openweather.forecast.domain.model.WeekForecastData
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET


interface WeekForecastApi {
    @GET("http://samples.openweathermap.org/data/2.5/forecast/daily?q=M%C3%BCnchen,DE&appid=b6907d289e10d714a6e88b30761fae22")
    fun getWeekForecast(): Observable<Response<WeekForecastData>>
}