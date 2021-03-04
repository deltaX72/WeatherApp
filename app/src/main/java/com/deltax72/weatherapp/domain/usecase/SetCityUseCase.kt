package com.deltax72.weatherapp.domain.usecase

import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.repository.CityRepository

class SetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(city: City) {
        this.cityRepository.setCity(city)
    }
}