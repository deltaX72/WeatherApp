package com.deltax72.weatherapp.cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.CitiesActions
import com.deltax72.weatherapp.R
import com.deltax72.weatherapp.WeatherApplication
import com.deltax72.weatherapp.weather.WeatherActivity

class CitiesActivity : AppCompatActivity() {
    private lateinit var citiesActions: CitiesActions
    private lateinit var citiesList: RecyclerView

    private val adapter = CitiesAdapter {
        WeatherActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.citiesActions = (application as WeatherApplication).citiesActions
        setContentView(R.layout.activity_cities)
        this.citiesList = findViewById(R.id.citiesList)
        this.citiesList.adapter = this.adapter
    }

    override fun onResume() {
        super.onResume()
        this.adapter.cities = this.citiesActions.getCities()
    }
}