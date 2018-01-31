package com.example.picked.openweather.forecast.data.source.remote

import com.example.picked.openweather.BuildConfig
import com.example.picked.openweather.forecast.data.TodayWeatherForecastData
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TodayWeatherForecastApi {
    @GET("weather?APPID=" + BuildConfig.OPEN_WEATHER_APPID_VALUE)
    fun getTodayWeatherForecast(@Query("q") cityName: String): Observable<Response<TodayWeatherForecastData>>
}