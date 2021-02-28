package com.deltax72.weatherapp.cities

import java.lang.RuntimeException
import kotlin.collections.HashMap

class City(
    val name: String,
    val date: Date,
    var temperatures: Map<Int, Pair<Double, Weather.WeatherType>>
) {
    var id: Long
        private set

    companion object {
        var totalCities: Long = 0
    }
    init {
        this.id = ++totalCities
    }

    constructor(): this(name = "", date = Date(), temperatures = emptyMap())

    fun getTemperature(hour: Int): Double {
//        val city = this.cities.firstOrNull { it.name == name && it.date == date }
        return this.temperatures[hour]?.first ?: throw RuntimeException("Value doesn't exist!")
    }
    fun getWeatherType(hour: Int): Weather.WeatherType {
        return this.temperatures[hour]?.second ?: throw RuntimeException("Value doesn't exist!")
    }
    fun getTime(hour: Int) = "${if (hour in 0..9) "0$hour" else "$hour"}:00"
}

class Date(
    private val year: Int,
    private val month: Int,
    private val day: Int
) {
    override fun toString(): String {
        return "$year-$month-$day"
    }

    constructor(): this(0, 0, 0)
}

class Weather {
    enum class WeatherType {
        SUN,
        CLOUDY,
        MAINLY_CLOUD,
        SNOW,
        WIND,
        FROST
    }

    companion object {
//        val adviceList = arrayListOf(
//            "You should go to walk today",
//            "It's cold but you can still walk",
//            "You should wear warm clothes",
//            "We should not to go work today",
//            "You should buy your own nuclear reactor"
//        )
//        val descriptionList = arrayListOf(
//            "Bright sun",
//            "The sky is partly in the clouds",
//            "It's windy",
//            "Today it is biting frost",
//            "There are many thick clouds in the sky",
//            "It's snowy now"
//        )
        fun getAdvice(temperature: Double): String {
            return when(temperature) {
                in -5.0..0.0 -> "You should go to walk today"
                in -15.0..-6.0 -> "It's cold but you can still walk"
                in -30.0..-16.0 -> "You should wear warm clothes"
                in -49.0..-31.0 -> "You shouldn't go work today"
                in -273.15..-50.0 -> "You should buy your own nuclear reactor"
                else -> throw RuntimeException("Information not found!")
            }
        }
        fun getDescription(weatherType: WeatherType): String {
            return when(weatherType) {
                WeatherType.SUN -> "Bright sun"
                WeatherType.CLOUDY -> "The sky is partly in the clouds"
                WeatherType.WIND -> "It's windy"
                WeatherType.FROST -> "Today it is biting frost"
                WeatherType.MAINLY_CLOUD -> "There are many thick clouds in the sky"
                WeatherType.SNOW -> "It's snowy now"
            }
        }
    }
}