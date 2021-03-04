package com.deltax72.weatherapp.data.repo

import com.deltax72.weatherapp.data.CityDataSource
import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.models.Time
import com.deltax72.weatherapp.domain.models.Weather
import com.deltax72.weatherapp.domain.repositories.CityRepository
import java.lang.RuntimeException

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