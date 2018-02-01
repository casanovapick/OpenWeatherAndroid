package com.example.picked.openweather.forecast.ui.week

import com.example.picked.openweather.forecast.domain.model.DailyForecastData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DailyForecastItemTest {
    @Before
    fun setUp() {
    }

    @Test
    fun getDisplayDate_dt0_Thu1Jan() {
        val dailyForecastData = DailyForecastData(dt = 0)
        val dailyForecastItem = DailyForecastItem(dailyForecastData)
        val displayDate = dailyForecastItem.getDisplayDate()
        val expectedDisplayDate = "Thu, 1 Jan"
        Assert.assertEquals(expectedDisplayDate, displayDate)
    }

    @Test
    fun getDisplayDate_nullForecastData_emptyString() {
        val dailyForecastItem = DailyForecastItem()
        val displayDate = dailyForecastItem.getDisplayDate()
        val expectedDisplayDate = ""
        Assert.assertEquals(expectedDisplayDate, displayDate)
    }

}