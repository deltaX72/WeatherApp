package com.deltax72.weatherapp.data.repo

import com.deltax72.weatherapp.data.CityDataSource
import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.domain.models.Time
import com.deltax72.weatherapp.domain.models.Weather

class CityLocalDataSourceImpl: CityDataSource {
    private val cities = this.generateRandomCities(
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

    private fun generateRandomCity(id: Long, name: String, timeFrom: Time, timeTo: Time): City {
        val city = City(id = id, name = name)
        val startMinutes = timeFrom.hour * 60 + timeFrom.minute
        val endMinutes = timeTo.hour * 60 + timeTo.minute
        for (i in startMinutes..endMinutes) {
            city[Time(i / 60, i % 60)] = Pair(- (Math.random() * 20).toInt().toDouble(), Weather.getRandomType())
        }
        return city
    }

    private fun generateRandomCities(vararg names: String, timeFrom: Time, timeTo: Time): MutableList<City> {
        return ArrayList<City>().apply {
            for ((index, name) in names.withIndex()) {
                this.add(generateRandomCity(id = index.toLong(), name = name, timeFrom = timeFrom, timeTo = timeTo))
            }
        }
    }
}