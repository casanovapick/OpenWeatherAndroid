package com.example.picked.openweather.forecast.ui.today

import android.util.Log
import com.example.picked.openweather.forecast.domain.usecase.GetTodayWeatherForecast
import com.example.picked.openweather.forecast.domain.usecase.KelvinToCelsius
import com.example.picked.openweather.forecast.domain.usecase.KelvinToFahrenheit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class TodayForecastPresenter @Inject constructor(
        private val getTodayWeather: GetTodayWeatherForecast,
        private val kelvinToFahrenheit: KelvinToFahrenheit,
        private val kelvinToCelsius: KelvinToCelsius, private val viewModel: TodayForecastViewModel,
        private val view: TodayForecastContract.View) : TodayForecastContract.Action {

    override fun convertUnit() {
        val kelvin = viewModel.kelvin
        if (viewModel.isDisplayFahrenheit.get()) {
            convertToFahrenheit(kelvin)
        } else {
            convertToCelsius(kelvin)
        }
    }

    private fun convertToCelsius(kelvin: Double) {
        kelvinToCelsius.execute(KelvinToCelsius.Request(kelvin))
                .subscribeBy(onNext = { result ->
                    viewModel.temperature.set(result.celsius)
                })
    }

    private fun convertToFahrenheit(kelvin: Double) {
        kelvinToFahrenheit.execute(KelvinToFahrenheit.Request(kelvin))
                .subscribeBy(onNext = { result ->
                    viewModel.temperature.set(result.fahrenheit)
                })
    }

    override fun getForecast() {
        view.showProgressbar()
        viewModel.isShowContent.set(false)
        val request = GetTodayWeatherForecast.Request(cityName = viewModel.inputCity.get())
        getTodayWeather.execute(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doFinally {
                    view.dismissProgressbar()
                }
                .subscribeBy(onError = { throwable ->
                    Log.e("getForecast", "" + throwable)
                }, onNext = { result ->
                    val weatherInfo = result.data.weatherInfo
                    viewModel.humidity.set(weatherInfo?.humidity.toString())
                    val kelvin = weatherInfo?.temp ?: 0.0
                    viewModel.temperature.set(kelvin)
                    viewModel.isShowContent.set(true)
                    viewModel.kelvin = kelvin
                    viewModel.imageId = result.data.weatherDescriptionList[0]?.icon ?: ""
                })
    }

}