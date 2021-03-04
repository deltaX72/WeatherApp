package com.deltax72.weatherapp.presentation.weather

import com.deltax72.weatherapp.presentation.BaseView
import com.deltax72.weatherapp.domain.model.City

interface WeatherView: BaseView {
    fun bindCity(city: City)
    fun closeScreen()
}