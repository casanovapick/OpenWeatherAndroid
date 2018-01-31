package com.example.picked.openweather.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class OpenWeatherApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
      return  DaggerAppComponent.builder().application(this).build()
    }
}