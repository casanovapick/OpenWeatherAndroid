package com.example.picked.openweather.forecast.ui.today


interface TodayForecastContract {
    interface View {
        fun dismissProgressbar()
        fun showProgressbar()
        fun alertNotFound()
        fun alertNetworkError()
    }

    interface Action {
        fun getForecast()
        fun convertUnit()
        fun stop()
    }
}