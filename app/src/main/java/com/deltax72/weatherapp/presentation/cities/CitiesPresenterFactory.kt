package com.deltax72.weatherapp.presentation.cities

import com.deltax72.weatherapp.data.CityLocalDataSourceImpl
import com.deltax72.weatherapp.data.CityRepositoryImpl
import com.deltax72.weatherapp.domain.usecase.GetCitiesUseCase
import com.deltax72.weatherapp.domain.usecase.GetCityUseCase

object CitiesPresenterFactory {
    fun getCitiesPresenter(): CitiesPresenter {
        val cityDataSource = CityLocalDataSourceImpl()
        val cityRepository = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepository)
        return CitiesPresenter(getCitiesUseCase)
    }
}