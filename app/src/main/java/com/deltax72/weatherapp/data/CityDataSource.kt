package com.deltax72.weatherapp.data

import com.deltax72.weatherapp.domain.model.City

interface CityDataSource {
    fun getCities(): List<City>

    fun getCity(name: String): City?

    fun getCity(id: Long): City?

    fun setCity(city: City)
}