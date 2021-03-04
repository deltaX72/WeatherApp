package com.deltax72.weatherapp.presentation.di

import com.deltax72.weatherapp.data.repo.CityLocalDataSourceImpl
import com.deltax72.weatherapp.data.repo.CityRepositoryImpl
import com.deltax72.weatherapp.domain.usecases.GetCityUseCase
import com.deltax72.weatherapp.presentation.presenters.WeatherPresenter

object WeatherPresenterFactory {
    fun getWeatherPresenter(id: Long): WeatherPresenter {
        val cityDataSource =
            CityLocalDataSourceImpl()
        val cityRepository =
            CityRepositoryImpl(
                cityDataSource
            )
        val getCityUseCase = GetCityUseCase(cityRepository)
        return WeatherPresenter(
            getCityUseCase,
            id
        )
    }
}