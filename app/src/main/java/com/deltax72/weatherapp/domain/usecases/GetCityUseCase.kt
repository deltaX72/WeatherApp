package com.deltax72.weatherapp.domain.usecases

import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.repositories.CityRepository

class GetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(id: Long): City? = this.cityRepository.getCity(id)
}