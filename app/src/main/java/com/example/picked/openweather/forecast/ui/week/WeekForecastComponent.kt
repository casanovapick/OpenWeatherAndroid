package com.example.picked.openweather.forecast.ui.week

import com.example.picked.openweather.forecast.data.source.week.remote.WeekForecastApiModule
import dagger.Component

@Component(modules = arrayOf(WeekForecastModule::class, WeekForecastApiModule::class))
interface WeekForecastComponent {
    fun inject(activity: WeekForecastActivity)
}