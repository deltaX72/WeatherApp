package com.deltax72.weatherapp.presentation.weather

import com.deltax72.weatherapp.data.CityDataSource
import com.deltax72.weatherapp.data.CityLocalDataSourceImpl
import com.deltax72.weatherapp.data.CityRepositoryImpl
import com.deltax72.weatherapp.domain.usecase.GetCityUseCase

object WeatherPresenterFactory {
    fun getWeatherPresenter(id: Long): WeatherPresenter {
        val cityDataSource = CityLocalDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepository)
        return WeatherPresenter(getCityUseCase, id)
    }
}