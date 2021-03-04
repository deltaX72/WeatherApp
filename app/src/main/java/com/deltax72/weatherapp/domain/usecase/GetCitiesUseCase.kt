package com.deltax72.weatherapp.domain.usecase

import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.repository.CityRepository

class GetCitiesUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(): List<City> = this.cityRepository.getCities()
}