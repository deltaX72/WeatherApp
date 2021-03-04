package com.deltax72.weatherapp.data

import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.model.Time
import com.deltax72.weatherapp.domain.model.Weather

fun generateRandomCity(id: Long, name: String, timeFrom: Time, timeTo: Time): City {
    val city = City(id = id, name = name)
    val startMinutes = timeFrom.hour * 60 + timeFrom.minute
    val endMinutes = timeTo.hour * 60 + timeTo.minute
    for (i in startMinutes..endMinutes) {
        city[Time(i / 60, i % 60)] = Pair(- (Math.random() * 20).toInt().toDouble(), Weather.getRandomType())
    }
    return city
}

fun generateRandomCities(vararg names: String, timeFrom: Time, timeTo: Time): MutableList<City> {
    return ArrayList<City>().apply {
        for ((index, name) in names.withIndex()) {
            this.add(generateRandomCity(id = index.toLong(), name = name, timeFrom = timeFrom, timeTo = timeTo))
        }
    }
}