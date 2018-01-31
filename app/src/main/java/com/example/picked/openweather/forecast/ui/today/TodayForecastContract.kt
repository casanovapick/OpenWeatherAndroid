package com.example.picked.openweather.forecast.ui.today


interface TodayForecastContract {
    interface View {
        fun dismissProgressbar()
        fun showProgressbar()
    }

    interface Action {
        fun getForecast()
        fun convertUnit()
    }
}