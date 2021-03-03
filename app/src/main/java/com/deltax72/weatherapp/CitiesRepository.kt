package com.deltax72.weatherapp

import com.deltax72.weatherapp.cities.City
import com.deltax72.weatherapp.cities.Date
import com.deltax72.weatherapp.cities.Time
import com.deltax72.weatherapp.cities.Weather
import java.lang.RuntimeException

class CitiesRepository {
    private val hourFrom = 18
    private val hourTo = 23
    private val cities = mutableListOf(
            generateRandomCity("Tomsk", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Moscow", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Novosibirsk", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Krasnoyarsk", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Kemerovo", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Ufa", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Sochi", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Krasnodar", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Omsk", Time(hourFrom, 0), Time(hourTo, 0)),
            generateRandomCity("Yaroslavl", Time(hourFrom, 0), Time(hourTo, 0))
    )

    fun getCities(): List<City> = this.cities

    fun getCity(name: String): City? = this.cities.firstOrNull { it.name == name }
    fun getCity(id: Long): City? = this.cities.firstOrNull { it.id == id }

    fun setCity(city: City) {
        val index = this.cities.indexOfFirst { it.name == city.name }
        if (index >= 0) {
            this.cities[index] = city
        }
    }

    private fun generateRandomCity(name: String, timeFrom: Time, timeTo: Time): City {
        val city = City(name)
        val startMinutes = timeFrom.hour * 60 + timeFrom.minute
        val endMinutes = timeTo.hour * 60 + timeTo.minute
        for (i in startMinutes..endMinutes) {
            city[Time(i / 60, i % 60)] = Pair(- (Math.random() * 20).toInt().toDouble(), Weather.getRandomType())
        }
        return city
    }
}