package com.example.picked.openweather.forecast.ui.week

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

@Module
class WeekForecastModule(private val activity: WeekForecastActivity) {
    @Provides
    fun provideViewModel(): WeekForecastViewModel = ViewModelProviders.of(activity).get(
            WeekForecastViewModel::class.java)
    @Provides
    fun provideView(): WeekForecastContract.View = activity
}