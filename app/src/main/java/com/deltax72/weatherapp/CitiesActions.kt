package com.deltax72.weatherapp

import com.deltax72.weatherapp.cities.City
import com.deltax72.weatherapp.cities.Date
import com.deltax72.weatherapp.cities.Time
import com.deltax72.weatherapp.cities.Weather
import java.lang.RuntimeException

class CitiesActions {
    private val cities = mutableListOf(
            generateRandomCity("Tomsk", Time(0, 0), Time(6, 0)),
            generateRandomCity("Moscow", Time(0, 0), Time(6, 0)),
            generateRandomCity("Novosibirsk", Time(0, 0), Time(6, 0))
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
        val minutes = (timeTo.hour - timeFrom.hour) * 60 + (timeTo.minute - timeFrom.minute)
        for (i in 0..minutes) {
            city[Time(i / 60, i % 60)] = Pair(- (Math.random() * 20).toInt().toDouble(), Weather.getRandomType())
        }
//        for (h in timeFrom.hour until timeTo.hour) {
//            for (m in timeFrom.minute until timeTo.minute + 60) {
//                city[Time(h, m)] = Pair(- (Math.random() * 20).toInt().toDouble(), Weather.getRandomType())
//            }
//        }
        return city
    }
}