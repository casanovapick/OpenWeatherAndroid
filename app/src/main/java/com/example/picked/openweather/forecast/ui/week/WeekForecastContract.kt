package com.example.picked.openweather.forecast.ui.week


interface WeekForecastContract {
    interface View {
        fun refreshList()
        fun showProgressbar()
        fun dismissProgressbar()
    }

    interface Action {
        fun start()
        fun stop()
    }
}