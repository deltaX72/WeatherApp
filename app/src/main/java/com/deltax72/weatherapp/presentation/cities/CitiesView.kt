package com.deltax72.weatherapp.presentation.cities

import com.deltax72.weatherapp.presentation.BaseView
import com.deltax72.weatherapp.domain.model.City

interface CitiesView: BaseView {
    fun bindCityList(list: List<City>)
    fun openCityWeatherScreen(cityId: Long)
}