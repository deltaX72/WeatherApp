package com.deltax72.weatherapp.domain.usecases

import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.repositories.CityRepository

class SetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(city: City) {
        this.cityRepository.setCity(city)
    }
}