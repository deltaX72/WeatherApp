package com.deltax72.weatherapp.presentation.viewmodels

import com.deltax72.weatherapp.domain.models.City

interface WeatherView: BaseView {
    fun bindCity(city: City)
    fun closeScreen()
}