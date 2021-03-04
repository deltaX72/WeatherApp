package com.deltax72.weatherapp.data

import com.deltax72.weatherapp.domain.repository.CityRepository
import com.deltax72.weatherapp.domain.model.City

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {
    override fun getCities(): List<City> {
        return this.cityDataSource.getCities()
    }

    override fun getCity(name: String): City? {
        return this.cityDataSource.getCity(name)
    }

    override fun getCity(id: Long): City? {
        return this.cityDataSource.getCity(id)
    }

    override fun setCity(city: City) {
        return this.cityDataSource.setCity(city)
    }
}