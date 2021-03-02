package com.deltax72.weatherapp.cities

import com.deltax72.weatherapp.BaseView

interface CitiesListView: BaseView {
    fun bindCityList(list: List<City>)
    fun openCityWeatherScreen(cityId: Long)
}