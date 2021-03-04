package com.deltax72.weatherapp.domain.models

import com.deltax72.weatherapp.R
import java.lang.RuntimeException

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