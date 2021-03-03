package com.deltax72.weatherapp.weather

import com.deltax72.weatherapp.BasePresenter
import com.deltax72.weatherapp.CitiesRepository

class WeatherPresenter(
    private val citiesRepository: CitiesRepository,
    private val cityId: Long
): BasePresenter<WeatherView>() {
    override fun onViewAttached() {
        val city = this.citiesRepository.getCity(this.cityId)
        if (city != null) {
            this.view?.bindCity(city)
        } else {
            this.view?.closeScreen()
        }
    }
}