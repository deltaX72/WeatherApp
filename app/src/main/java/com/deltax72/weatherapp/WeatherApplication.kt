package com.deltax72.weatherapp

import android.app.Application

class WeatherApplication : Application() {
    lateinit var citiesRepository: CitiesRepository
    override fun onCreate() {
        super.onCreate()
        this.citiesRepository = CitiesRepository()
    }
}