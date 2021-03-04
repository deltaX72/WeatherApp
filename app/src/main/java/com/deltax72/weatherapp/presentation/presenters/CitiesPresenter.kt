package com.deltax72.weatherapp.presentation.presenters

import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.usecases.GetCitiesUseCase
import com.deltax72.weatherapp.presentation.viewmodels.CitiesView

class CitiesPresenter(private val getCitiesUseCase: GetCitiesUseCase): BasePresenter<CitiesView>() {
    fun onViewResumed() {
        val cityList = this.getCitiesUseCase()
        this.view?.bindCitiesList(cityList)
    }

    fun onCityClick(city: City) {
        this.view?.openCityWeatherScreen(cityId = city.id)
    }
}