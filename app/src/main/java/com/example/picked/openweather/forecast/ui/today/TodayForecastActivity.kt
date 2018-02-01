package com.example.picked.openweather.forecast.ui.today

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import com.example.picked.openweather.R
import com.example.picked.openweather.databinding.ActivityTodayForecastBinding
import com.example.picked.openweather.forecast.ui.week.WeekForecastActivity
import kotlinx.android.synthetic.main.activity_today_forecast.inputCity
import kotlinx.android.synthetic.main.activity_today_forecast.progressBar
import kotlinx.android.synthetic.main.activity_today_forecast.toggleUnit
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.today_forecast_menu, menu)
        return true
    }

    private fun bindViewModel() {
        val activity = this
        val layoutId = R.layout.activity_today_forecast
        val binding = DataBindingUtil.setContentView<ActivityTodayForecastBinding>(activity, layoutId)
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

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            if (it.itemId == R.id.menuWeekForecast) {
                startActivity(Intent(this, WeekForecastActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun dismissProgressbar() {
        progressBar.visibility = View.GONE
    }

    override fun showProgressbar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun alertNotFound() {
        AlertDialog.Builder(this).setMessage(R.string.forecast_today_not_found)
                .setNeutralButton(R.string.common_ok, { _, _ -> }).show()
    }

    override fun alertNetworkError() {
        AlertDialog.Builder(this).setMessage(R.string.common_network_error)
                .setNeutralButton(R.string.common_ok, { _, _ -> }).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.stop()
    }
}
