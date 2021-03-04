package com.deltax72.weatherapp.domain.repositories

import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.models.Time
import com.deltax72.weatherapp.domain.models.Weather

interface CityRepository {
    fun getCities(): List<City>

    fun getCity(name: String): City?

    fun getCity(id: Long): City?

    fun setCity(city: City)
}