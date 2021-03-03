package com.deltax72.weatherapp.cities

import com.deltax72.weatherapp.BasePresenter
import com.deltax72.weatherapp.CitiesRepository

class CityPresenter(private val citiesRepository: CitiesRepository): BasePresenter<CitiesListView>() {
    fun onViewResumed() {
        val cityList = citiesRepository.getCities()
        this.view?.bindCityList(cityList)
    }

    fun onCityClick(city: City) {
        this.view?.openCityWeatherScreen(cityId = city.id)
    }
}