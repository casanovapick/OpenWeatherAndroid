package com.example.picked.openweather.forecast.data.source

import com.example.picked.openweather.forecast.data.source.remote.TodayWeatherApiModule
import com.example.picked.openweather.forecast.data.source.remote.TodayWeatherForecastApi
import com.example.picked.openweather.forecast.data.source.remote.TodayWeatherForecastRemoteDataSource
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(TodayWeatherApiModule::class))
class TodayWeatherForecastDataSourceModule {

    @Provides
    fun provideRemoteDataSource(api: TodayWeatherForecastApi): TodayWeatherForecastDataSource {
        return TodayWeatherForecastRemoteDataSource(api)
    }
}