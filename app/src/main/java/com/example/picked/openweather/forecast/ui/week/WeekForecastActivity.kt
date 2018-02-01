package com.example.picked.openweather.forecast.ui.week

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.picked.openweather.R
import kotlinx.android.synthetic.main.activity_week_forecast.progressBar
import kotlinx.android.synthetic.main.activity_week_forecast.recyclerView
import javax.inject.Inject

class WeekForecastActivity : AppCompatActivity(), WeekForecastContract.View {
    @Inject
    lateinit var presenter: WeekForecastPresenter
    @Inject
    lateinit var viewModel: WeekForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContentView(R.layout.activity_week_forecast)
        recyclerView.adapter = WeekForecastAdapter(viewModel.dailyForecastItemList)
        presenter.start()
    }

    private fun injectDependencies() {
        DaggerWeekForecastComponent.builder().weekForecastModule(WeekForecastModule(this)).build()
                .inject(this)
    }

    override fun refreshList() {
        recyclerView.adapter.notifyDataSetChanged()
    }

    override fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissProgressbar() {
        progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.stop()
    }
}
