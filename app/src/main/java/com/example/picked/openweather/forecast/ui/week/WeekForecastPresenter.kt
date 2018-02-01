package com.example.picked.openweather.forecast.ui.week

import android.util.Log
import com.example.picked.openweather.forecast.domain.usecase.GetWeekForecast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeekForecastPresenter @Inject constructor(
        private val getWeekForecast: GetWeekForecast, private val viewModel: WeekForecastViewModel,
        private val view: WeekForecastContract.View) : WeekForecastContract.Action {
    private val compositeDisposable = CompositeDisposable()
    override fun start() {
        if (viewModel.dailyForecastItemList.isEmpty()) {
            getWeekForecastData()
        }
    }

    private fun getWeekForecastData() {
        view.showProgressbar()
        val disposable = getWeekForecast.execute(GetWeekForecast.Request())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { view.dismissProgressbar() }
                .subscribeBy(onError = {
                    Log.e("", "" + it)
                }, onNext = { result ->
                    result.weekForecastData.list?.forEach { dailyForecastData ->
                        viewModel.dailyForecastItemList.add(DailyForecastItem(dailyForecastData))
                        view.refreshList()
                    }
                })
        compositeDisposable.add(disposable)
    }

    override fun stop() {
        compositeDisposable.dispose()
    }

}