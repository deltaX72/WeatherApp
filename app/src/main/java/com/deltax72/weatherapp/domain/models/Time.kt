package com.deltax72.weatherapp.domain.models

class Time(val hour: Int = 0, val minute: Int = 0) {
    override fun toString(): String {
        return "${if (hour < 10) "0$hour" else "$hour"}:${if (minute < 10) "0$minute" else "$minute"}"
    }
}