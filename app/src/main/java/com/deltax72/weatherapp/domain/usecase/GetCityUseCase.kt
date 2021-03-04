package com.deltax72.weatherapp.domain.usecase

import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.repository.CityRepository

class GetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(id: Long): City? = this.cityRepository.getCity(id)
}