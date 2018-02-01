package com.example.picked.openweather.forecast.ui.today

import com.example.picked.openweather.forecast.domain.converter.tempurature.KelvinToCelsiusConverter
import com.example.picked.openweather.forecast.domain.converter.tempurature.KelvinToFahrenheitConverter
import com.example.picked.openweather.forecast.domain.usecase.GetTodayWeatherForecast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class TodayForecastPresenter @Inject constructor(
        private val getTodayWeather: GetTodayWeatherForecast,
        private val kelvinToFahrenheit: KelvinToFahrenheitConverter,
        private val kelvinToCelsius: KelvinToCelsiusConverter, private val viewModel: TodayForecastViewModel,
        private val view: TodayForecastContract.View) : TodayForecastContract.Action {

    private val compositeDisposable = CompositeDisposable()

    override fun convertUnit() {
        val kelvin = viewModel.kelvin
        if (viewModel.isDisplayFahrenheit.get()) {
            convertToFahrenheit(kelvin)
        } else {
            convertToCelsius(kelvin)
        }
    }

    private fun convertToCelsius(kelvin: Double) {
        viewModel.temperature.set(kelvinToCelsius.convert(kelvin))
    }

    private fun convertToFahrenheit(kelvin: Double) {
        viewModel.temperature.set(kelvinToFahrenheit.convert(kelvin))
    }

    override fun getForecast() {
        view.showProgressbar()
        viewModel.isShowContent.set(false)
        val request = GetTodayWeatherForecast.Request(cityName = viewModel.inputCity.get())
        val disposable = getTodayWeather.execute(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doFinally {
                    view.dismissProgressbar()
                }
                .subscribeBy(onError = { _ ->
                    view.alertNetworkError()
                }, onNext = { result ->
                    if (result.isSuccess) {
                        val weatherInfo = result.data.weatherData
                        viewModel.humidity.set(weatherInfo?.humidity.toString())
                        val kelvin = weatherInfo?.temp ?: 0.0
                        viewModel.temperature.set(kelvin)
                        viewModel.isShowContent.set(true)
                        viewModel.kelvin = kelvin
                        viewModel.imageId.set(result.data.weatherDescriptionList[0]?.icon)
                        convertUnit()
                    } else {
                        view.alertNotFound()
                    }
                })
        compositeDisposable.add(disposable)
    }

    override fun stop() {
        compositeDisposable.dispose()
    }

}