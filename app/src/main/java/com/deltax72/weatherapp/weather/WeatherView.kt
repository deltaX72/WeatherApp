package com.deltax72.weatherapp.weather

import com.deltax72.weatherapp.BaseView
import com.deltax72.weatherapp.cities.City

interface WeatherView: BaseView {
    fun bindCity(city: City)
    fun closeScreen()
}