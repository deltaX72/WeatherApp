package com.deltax72.weatherapp.cities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.R
import java.util.*

class CitiesAdapter(private val onClick: (City) -> Unit): RecyclerView.Adapter<CityHolder>() {
    var cities: List<City> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityHolder(view, this.onClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bind(this.cities[position])
    }

    override fun getItemCount(): Int {
        return this.cities.count()
    }
}

class CityHolder(itemView: View, private val onClick: (City) -> Unit): RecyclerView.ViewHolder(itemView) {
    private val cityName: TextView = this.itemView.findViewById(R.id.cityName)
    private val dataTime: TextView = this.itemView.findViewById(R.id.dataTime)

    fun bind(city: City) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        this.cityName.text = this.itemView.context.getString(R.string.city_format, city.name)
        this.dataTime.text = this.itemView.context.getString(R.string.data_time_format, Time(hour, minute))
        this.itemView.setOnClickListener { this.onClick(city) }
    }
}