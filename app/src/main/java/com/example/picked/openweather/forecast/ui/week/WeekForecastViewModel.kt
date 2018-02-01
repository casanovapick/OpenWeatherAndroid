package com.example.picked.openweather.forecast.ui.week

import android.arch.lifecycle.ViewModel


class WeekForecastViewModel : ViewModel() {
    val dailyForecastItemList = mutableListOf<DailyForecastItem>()
}