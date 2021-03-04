package com.deltax72.weatherapp.domain.models

import java.lang.RuntimeException

class City(
    val id: Long = -1,
    val name: String = "",
    var temperatures: MutableMap<Time, Pair<Double, Weather.WeatherType>> = mapOf<Time, Pair<Double, Weather.WeatherType>>().toMutableMap()
) {
    fun getTemperature(time: Time): Double {
        return this.temperatures[time]?.first ?: throw RuntimeException("Value doesn't exist!")
    }
    
    fun getWeatherType(time: Time): Weather.WeatherType {
        return this.temperatures[time]?.second ?: throw RuntimeException("Value doesn't exist!")
    }

    operator fun set(time: Time, map: Pair<Double, Weather.WeatherType>) {
        this.temperatures[time] = map
    }
}