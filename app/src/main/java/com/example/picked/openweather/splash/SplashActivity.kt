package com.example.picked.openweather.forecast.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.picked.openweather.R
import com.example.picked.openweather.forecast.ui.today.TodayForecastActivity

class SplashActivity : AppCompatActivity() {
    private val splashDelay = 3000L
    private val handler = Handler()
    private val openTodayForecast = {
        val context = this
        val intent = Intent(context, TodayForecastActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(openTodayForecast, splashDelay)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(openTodayForecast)
    }
}
