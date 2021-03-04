package com.deltax72.weatherapp.presentation.cities

import com.deltax72.weatherapp.presentation.BasePresenter
import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.usecase.GetCitiesUseCase

class CitiesPresenter(private val getCitiesUseCase: GetCitiesUseCase): BasePresenter<CitiesView>() {
    fun onViewResumed() {
        val cityList = this.getCitiesUseCase()
        this.view?.bindCityList(cityList)
    }

    fun onCityClick(city: City) {
        this.view?.openCityWeatherScreen(cityId = city.id)
    }
}