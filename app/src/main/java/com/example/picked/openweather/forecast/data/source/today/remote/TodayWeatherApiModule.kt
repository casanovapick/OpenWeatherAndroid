package com.example.picked.openweather.forecast.data.source.today.remote

import com.example.picked.openweather.retrofit.createApi
import dagger.Module
import dagger.Provides

@Module
class TodayWeatherApiModule {
    @Provides
    fun provideApi(): TodayWeatherForecastApi = createApi(TodayWeatherForecastApi::class.java)
}