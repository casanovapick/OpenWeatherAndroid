package com.example.picked.openweather.forecast.ui.today

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import com.example.picked.openweather.R
import com.example.picked.openweather.databinding.ActivityTodayForecastBinding
import kotlinx.android.synthetic.main.activity_today_forecast.*
import javax.inject.Inject

class TodayForecastActivity : AppCompatActivity(), TodayForecastContract.View {

    @Inject
    lateinit var viewModel: TodayForecastViewModel
    @Inject
    lateinit var presenter: TodayForecastPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        bindViewModel()
        bindUserEvent()
    }

    private fun bindViewModel() {
        val binding = DataBindingUtil.setContentView<ActivityTodayForecastBinding>(this,
                R.layout.activity_today_forecast)
        binding.todayForecastViewModel = viewModel
    }

    private fun injectDependencies() {
        DaggerTodayForecastComponent.builder()
            .todayForecastModule(TodayForecastModule(this))
            .build()
            .inject(this)
    }

    private fun bindUserEvent() {
        inputCity.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.getForecast()
            }
            return@setOnEditorActionListener false
        }
        toggleUnit.setOnClickListener {
            presenter.convertUnit()
        }
    }

    override fun dismissProgressbar() {
        progressBar.visibility = View.GONE
    }

    override fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
    }
}
