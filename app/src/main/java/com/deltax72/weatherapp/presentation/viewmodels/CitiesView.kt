package com.deltax72.weatherapp.presentation.viewmodels

import com.deltax72.weatherapp.domain.models.City

interface CitiesView: BaseView {
    fun bindCitiesList(list: List<City>)
    fun openCityWeatherScreen(cityId: Long)
}