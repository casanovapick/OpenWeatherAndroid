package com.example.picked.openweather.forecast.ui.week

import com.example.picked.openweather.forecast.domain.usecase.GetWeekForecast
import com.example.picked.openweather.utility.RxSchedulersOverrideRule
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.willReturn
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class WeekForecastPresenterTest {
    @get:Rule
    val rxSchedulersOverrideRule = RxSchedulersOverrideRule()
    lateinit var presenter: WeekForecastPresenter
    @Mock
    lateinit var getWeekForecast: GetWeekForecast
    val viewModel = WeekForecastViewModel()
    @Mock
    lateinit var view: WeekForecastContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = WeekForecastPresenter(getWeekForecast = getWeekForecast
                                          , viewModel = viewModel
                                          , view = view)
    }

    @Test
    fun start_EmptyList_callGetForecast() {
        viewModel.dailyForecastItemList.clear()
        given(getWeekForecast.execute(any())).willReturn { Observable.empty() }
        presenter.start()
        verify(getWeekForecast).execute(any())
    }

    @Test
    fun start_hasForecastData_neverGetForecast() {
        viewModel.dailyForecastItemList.add(DailyForecastItem())
        presenter.start()
        verify(getWeekForecast, never()).execute(any())
    }

}