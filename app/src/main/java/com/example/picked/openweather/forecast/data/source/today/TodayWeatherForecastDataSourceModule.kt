package com.example.picked.openweather.forecast.data.source.today

import com.example.picked.openweather.forecast.data.source.today.remote.TodayWeatherApiModule
import com.example.picked.openweather.forecast.data.source.today.remote.TodayWeatherForecastApi
import com.example.picked.openweather.forecast.data.source.today.remote.TodayWeatherForecastRemoteDataSource
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(TodayWeatherApiModule::class))
class TodayWeatherForecastDataSourceModule {

    @Provides
    fun provideRemoteDataSource(api: TodayWeatherForecastApi): TodayWeatherForecastDataSource {
        return TodayWeatherForecastRemoteDataSource(
                api)
    }
}