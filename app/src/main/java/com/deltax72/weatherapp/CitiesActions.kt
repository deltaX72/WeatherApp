package com.deltax72.weatherapp

import com.deltax72.weatherapp.cities.City
import com.deltax72.weatherapp.cities.Date
import com.deltax72.weatherapp.cities.Weather
import java.lang.RuntimeException

class CitiesActions {
    private val cities = mutableListOf(
            City("Tomsk", Date(2077, 1, 1), mapOf(
                Pair(0, Pair(-10.0, Weather.WeatherType.SNOW)),
                Pair(3, Pair(-14.0, Weather.WeatherType.WIND)),
                Pair(6, Pair(-15.0, Weather.WeatherType.SNOW)),
                Pair(9, Pair(-11.0, Weather.WeatherType.SNOW)),
                Pair(12, Pair(-10.0, Weather.WeatherType.CLOUDY)),
                Pair(15, Pair(-6.0, Weather.WeatherType.SUN)),
                Pair(18, Pair(-8.0, Weather.WeatherType.CLOUDY)),
                Pair(21, Pair(-12.0, Weather.WeatherType.SNOW))
            )),
            City("Moscow", Date(2077, 1, 1), mapOf(
                Pair(0, Pair(-270.0, Weather.WeatherType.SNOW)),
                Pair(3, Pair(-10.0, Weather.WeatherType.WIND)),
                Pair(6, Pair(-10.0, Weather.WeatherType.SNOW)),
                Pair(9, Pair(-10.0, Weather.WeatherType.SNOW)),
                Pair(12, Pair(-10.0, Weather.WeatherType.CLOUDY)),
                Pair(15, Pair(-10.0, Weather.WeatherType.SUN)),
                Pair(18, Pair(-10.0, Weather.WeatherType.CLOUDY)),
                Pair(21, Pair(-10.0, Weather.WeatherType.SNOW))
            )),
            City("Novosibirsk", Date(2077, 1, 1), mapOf(
                Pair(0, Pair(-35.0, Weather.WeatherType.SNOW)),
                Pair(3, Pair(-10.0, Weather.WeatherType.WIND)),
                Pair(6, Pair(-10.0, Weather.WeatherType.SNOW)),
                Pair(9, Pair(-10.0, Weather.WeatherType.SNOW)),
                Pair(12, Pair(-10.0, Weather.WeatherType.CLOUDY)),
                Pair(15, Pair(-10.0, Weather.WeatherType.SUN)),
                Pair(18, Pair(-10.0, Weather.WeatherType.CLOUDY)),
                Pair(21, Pair(-10.0, Weather.WeatherType.SNOW))
            ))
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
}