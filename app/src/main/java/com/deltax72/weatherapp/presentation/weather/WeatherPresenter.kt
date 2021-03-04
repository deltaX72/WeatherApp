package com.deltax72.weatherapp.presentation.weather

import com.deltax72.weatherapp.presentation.BasePresenter
import com.deltax72.weatherapp.domain.repository.CityRepository
import com.deltax72.weatherapp.domain.usecase.GetCityUseCase

class WeatherPresenter(
        private val getCityUseCase: GetCityUseCase,
        private val cityId: Long
): BasePresenter<WeatherView>() {
    override fun onViewAttached() {
        val city = this.getCityUseCase(this.cityId)
        if (city != null) {
            this.view?.bindCity(city)
//            (this.view as WeatherActivity).adapter.city.temperatures = (this.view as WeatherActivity).map
        } else {
            this.view?.closeScreen()
        }
    }
}