package com.example.picked.openweather.forecast.ui.week

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.picked.openweather.R
import com.example.picked.openweather.databinding.ItemWeekForecastBinding
import javax.inject.Inject


class WeekForecastAdapter @Inject constructor(
        val dailyForecastItemList: MutableList<DailyForecastItem>) : RecyclerView.Adapter<WeekForecastAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val attachToRoot = false
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.item_week_forecast, parent, attachToRoot)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dailyForecastItemList.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.binding?.dailyForecastItem = dailyForecastItemList[position]
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemWeekForecastBinding

        init {
            binding = ItemWeekForecastBinding.bind(itemView!!)
        }
    }
}