package com.deltax72.weatherapp.domain.models

class Date(private val year: Int = 0, private val month: Int = 0, private val day: Int = 0) {
    override fun toString(): String {
        return "$year-$month-$day"
    }
}