package com.deltax72.weatherapp.domain.usecases

import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.repositories.CityRepository

class GetCitiesUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(): List<City> = this.cityRepository.getCities()
}