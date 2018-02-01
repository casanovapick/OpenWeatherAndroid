package com.example.picked.openweather.forecast.ui.today

import com.example.picked.openweather.forecast.domain.converter.tempurature.KelvinToCelsiusConverter
import com.example.picked.openweather.forecast.domain.converter.tempurature.KelvinToFahrenheitConverter
import com.example.picked.openweather.forecast.domain.model.TodayWeatherForecastData
import com.example.picked.openweather.forecast.domain.usecase.GetTodayWeatherForecast
import com.example.picked.openweather.utility.RxSchedulersOverrideRule
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TodayForecastPresenterTest {
    @get:Rule val rxSchedulersOverrideRule = RxSchedulersOverrideRule()
    lateinit var presenter: TodayForecastPresenter
    @Mock
    lateinit var getTodayWeather: GetTodayWeatherForecast

    @Mock
    lateinit var kelvinToCelsius: KelvinToCelsiusConverter

    private val viewModel = TodayForecastViewModel()

    @Mock
    lateinit var view: TodayForecastContract.View

    @Mock
    lateinit var kelvinToFahrenheit: KelvinToFahrenheitConverter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = TodayForecastPresenter(getTodayWeather = getTodayWeather
                                           , kelvinToCelsius = kelvinToCelsius
                                           , kelvinToFahrenheit = kelvinToFahrenheit
                                           , view = view
                                           , viewModel = viewModel)
    }

    @Test
    fun getForecast_success_showContent() {
        val data = TodayWeatherForecastData(weatherDescriptionList = listOf())
        val observableResult = Observable.just(GetTodayWeatherForecast.Result(data, isSuccess = true))
        viewModel.inputCity.set("bangkok")
        given(getTodayWeather.execute(any())).willReturn(observableResult)
        presenter.getForecast()
        Assert.assertEquals(true, viewModel.isShowContent.get())
    }

    @Test
    fun getForecast_notFound_alertNotFound() {
        val data = TodayWeatherForecastData(weatherDescriptionList = listOf())
        val observableResult = Observable.just(GetTodayWeatherForecast.Result(data, isSuccess = false))
        viewModel.inputCity.set("ABC")
        given(getTodayWeather.execute(any())).willReturn(observableResult)
        presenter.getForecast()
        Assert.assertEquals(false, viewModel.isShowContent.get())
        verify(view).alertNotFound()
    }

    @Test
    fun convertUnit_isDisplayFahrenheit_callConvertToFahrenheit() {
        viewModel.isDisplayFahrenheit.set(true)
        presenter.convertUnit()
        verify(kelvinToFahrenheit).convert(any())
    }

    @Test
    fun convertUnit_isNotDisplayFahrenheit_callConvertToCelsius() {
        viewModel.isDisplayFahrenheit.set(false)
        presenter.convertUnit()
        verify(kelvinToCelsius).convert(any())
    }
}