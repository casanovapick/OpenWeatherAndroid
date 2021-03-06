package com.example.picked.openweather.forecast.ui.today

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableDouble
import android.databinding.ObservableField


class TodayForecastViewModel : ViewModel() {
    val inputCity = ObservableField<String>()
    val humidity = ObservableField<String>()
    val temperature = ObservableDouble()
    val isDisplayFahrenheit = ObservableBoolean()
    val isShowContent = ObservableBoolean()
    var kelvin = 0.0
    var imageId = ObservableField<String>("")


}