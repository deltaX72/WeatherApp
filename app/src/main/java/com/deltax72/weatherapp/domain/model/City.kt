package com.deltax72.weatherapp.domain.model

import com.deltax72.weatherapp.R
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

class Date(private val year: Int = 0, private val month: Int = 0, private val day: Int = 0) {
    override fun toString(): String {
        return "$year-$month-$day"
    }
}

class Time(val hour: Int = 0, val minute: Int = 0) {
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
        fun getImageResourceByWeatherType(type: WeatherType): Int {
            return when (type) {
                WeatherType.SUN -> R.drawable.sun
                WeatherType.CLOUDY -> R.drawable.partly_cloud
                WeatherType.SNOW -> R.drawable.snow
                WeatherType.MAINLY_CLOUD -> R.drawable.cloud
                WeatherType.FROST -> R.drawable.frost
                WeatherType.WIND -> R.drawable.windy
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