package com.example.picked.openweather.forecast.data.source.week.remote

import com.example.picked.openweather.retrofit.createApi
import dagger.Module
import dagger.Provides

@Module
class WeekForecastApiModule {
    @Provides
    fun provideApi(): WeekForecastApi = createApi(WeekForecastApi::class.java)
}