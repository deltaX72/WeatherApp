package com.deltax72.weatherapp.data

import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.model.Time

class CityLocalDataSourceImpl: CityDataSource {
    private val cities = generateRandomCities(
        timeFrom = Time(0, 0),
        timeTo = Time(23, 0),
        names = *arrayOf(
                "Tomsk",
                "Moscow",
                "Novosibirsk",
                "Krasnoyarsk",
                "Kemerovo",
                "Ufa",
                "Sochi",
                "Krasnodar",
                "Omsk",
                "Yaroslavl"
        )
    )

    override fun getCities(): List<City> = this.cities

    override fun getCity(name: String): City? = this.cities.firstOrNull { it.name == name }

    override fun getCity(id: Long): City? = this.cities.firstOrNull { it.id == id }

    override fun setCity(city: City) {
        val index = this.cities.indexOfFirst { it.name == city.name }
        if (index >= 0) {
            this.cities[index] = city
        }
    }
}