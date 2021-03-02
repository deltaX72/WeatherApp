package com.deltax72.weatherapp.cities

import com.deltax72.weatherapp.BasePresenter
import com.deltax72.weatherapp.CitiesActions

class CityPresenter(private val citiesActions: CitiesActions): BasePresenter<CitiesListView>() {
    fun onViewResumed() {
        val cityList = citiesActions.getCities()
        this.view?.bindCityList(cityList)
    }

    fun onCityClick(city: City) {
        this.view?.openCityWeatherScreen(cityId = city.id)
    }
}