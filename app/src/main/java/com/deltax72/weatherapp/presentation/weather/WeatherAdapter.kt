package com.deltax72.weatherapp.presentation.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.R
import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.model.Time
import com.deltax72.weatherapp.domain.model.Weather

class WeatherAdapter: RecyclerView.Adapter<WeatherHolder>() {
    var city = City()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return WeatherHolder(view, city)
    }

    override fun getItemCount(): Int {
        return this.city.temperatures.entries.count()
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        var index = 0
        for (i in city.temperatures) {
            if (index == position) {
                holder.bind(i)
                break
            }
            index++
        }
    }
}

class WeatherHolder(itemView: View, private val city: City): RecyclerView.ViewHolder(itemView) {
    private val timeAndTemperature: TextView = this.itemView.findViewById(R.id.time_and_temperature)
    private val description: TextView = this.itemView.findViewById(R.id.description)
    private val weatherIcon: ImageView = this.itemView.findViewById(R.id.weather_icon)

    fun bind(period: Map.Entry<Time, Pair<Double, Weather.WeatherType>>) {
        this.timeAndTemperature.text = this.itemView.context.getString(R.string.time_and_temperature_format, period.key, period.value.first.toString())
        this.description.text = this.itemView.context.getString(
            R.string.weather_desc_and_advice_format,
            Weather.getDescription(city.getWeatherType(period.key)),
            Weather.getAdvice(city.getTemperature(period.key))
        )
        this.weatherIcon.setImageResource(Weather.getImageResourceByWeatherType(city.getWeatherType(period.key)))
//        when (city.getWeatherType(period.key)) {
//            Weather.WeatherType.SUN -> this.weatherIcon.setImageResource(R.drawable.sun)
//            Weather.WeatherType.CLOUDY -> this.weatherIcon.setImageResource(R.drawable.partly_cloud)
//            Weather.WeatherType.SNOW -> this.weatherIcon.setImageResource(R.drawable.snow)
//            Weather.WeatherType.WIND -> this.weatherIcon.setImageResource(R.drawable.windy)
//            Weather.WeatherType.MAINLY_CLOUD -> this.weatherIcon.setImageResource(R.drawable.cloud)
//            Weather.WeatherType.FROST -> this.weatherIcon.setImageResource(R.drawable.frost)
//        }
    }
}