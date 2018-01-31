package com.example.picked.openweather.forecast.ui.today

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides


@Module
class TodayForecastModule(private val activity: TodayForecastActivity) {
    @Provides
    fun provideView(): TodayForecastContract.View = activity

    @Provides
    fun provideViewModel(): TodayForecastViewModel =
            ViewModelProviders.of(activity).get(TodayForecastViewModel::class.java)
}