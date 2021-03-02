package com.deltax72.weatherapp.cities

import java.lang.RuntimeException
import kotlin.collections.HashMap

class City(
    val name: String,
    var temperatures: MutableMap<Time, Pair<Double, Weather.WeatherType>>
) {
    var id: Long
        private set

    companion object {
        var totalCities: Long = 0
    }
    init {
        this.id = ++totalCities
    }

    constructor(name: String): this(name, mapOf<Time, Pair<Double, Weather.WeatherType>>().toMutableMap())
    constructor(): this(name = "")

    fun getTemperature(time: Time): Double {
//        val city = this.cities.firstOrNull { it.name == name && it.date == date }
        return this.temperatures[time]?.first ?: throw RuntimeException("Value doesn't exist!")
    }
    fun getWeatherType(time: Time): Weather.WeatherType {
//        println("\n\n\n\n\n\n\n\n\n\n\n\n${this.temperatures[Time(hour, minute)]}\n\n\n\n\n\n\n\n\n\n")
        return this.temperatures[time]?.second ?: throw RuntimeException("Value doesn't exist!")
    }
//    fun getTime(hour: Int) = "${if (hour in 0..9) "0$hour" else "$hour"}:00"

    operator fun set(time: Time, map: Pair<Double, Weather.WeatherType>) {
        this.temperatures?.set(time, map)
    }
//    operator fun get(time: Time): {
////        return
//    }
}

class Date(private val year: Int, private val month: Int, private val day: Int) {
    override fun toString(): String {
        return "$year-$month-$day"
    }

    constructor(): this(0, 0, 0)
}

class Time(val hour: Int, val minute: Int) {
    constructor(): this(0, 0)

    override fun toString(): String {
        return "${if (hour < 10) "0$hour" else "$hour"}:${if (minute < 10) "0$minute" else "$minute"}"
    }
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

        fun getRandomType(): WeatherType {
            return when((Math.random() * WeatherType.values().size).toInt()) {
                0 -> WeatherType.SUN
                1 -> WeatherType.WIND
                2 -> WeatherType.FROST
                3 -> WeatherType.MAINLY_CLOUD
                4 -> WeatherType.SNOW
                5 -> WeatherType.CLOUDY
                else -> throw RuntimeException("")
            }
        }
    }
}