package com.deltax72.weatherapp.weather

import com.deltax72.weatherapp.BasePresenter
import com.deltax72.weatherapp.CitiesActions
import com.deltax72.weatherapp.cities.Weather

class WeatherPresenter(
        private val citiesActions: CitiesActions,
        private val cityId: Long
): BasePresenter<WeatherView>() {
    override fun onViewAttached() {
        val city = this.citiesActions.getCity(this.cityId)
        if (city != null) {
            this.view?.bindCity(city)
        } else {
            this.view?.closeScreen()
        }
    }
}