package com.deltax72.weatherapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WeatherApplication : Application() {
    lateinit var citiesActions: CitiesActions
    override fun onCreate() {
        super.onCreate()
        this.citiesActions = CitiesActions()
    }
}