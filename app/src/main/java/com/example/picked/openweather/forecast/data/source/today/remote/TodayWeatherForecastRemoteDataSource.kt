package com.example.picked.openweather.forecast.data.source.today.remote

import com.example.picked.openweather.forecast.domain.model.TodayWeatherForecastData
import com.example.picked.openweather.forecast.data.source.today.TodayWeatherForecastDataSource
import com.google.gson.Gson
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject


class TodayWeatherForecastRemoteDataSource @Inject constructor(
        private val api: TodayWeatherForecastApi) : TodayWeatherForecastDataSource {

    override fun getForecastData(cityName: String): Observable<TodayWeatherForecastData> {
        val mapper: (Response<TodayWeatherForecastData>) -> TodayWeatherForecastData? = { response ->
            if (response.isSuccessful) {
                response.body()
            } else {
                Gson().fromJson(response.errorBody()?.string(), TodayWeatherForecastData::class.java)
            }
        }
        return api.getTodayWeatherForecast(cityName).map(mapper)
    }
}