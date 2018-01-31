package com.example.picked.openweather.forecast.ui.today

import com.example.picked.openweather.forecast.data.source.TodayWeatherForecastDataSourceModule
import com.example.picked.openweather.forecast.data.source.remote.TodayWeatherApiModule
import dagger.Component

@Component(modules = arrayOf(TodayWeatherApiModule::class, TodayForecastModule::class,
        TodayWeatherForecastDataSourceModule::class))
interface TodayForecastComponent {
    fun inject(activity: TodayForecastActivity)
}
