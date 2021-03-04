package com.deltax72.weatherapp.presentation.presenters

import com.deltax72.weatherapp.domain.usecases.GetCityUseCase
import com.deltax72.weatherapp.presentation.viewmodels.WeatherView

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