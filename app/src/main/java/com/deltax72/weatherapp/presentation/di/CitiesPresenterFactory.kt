package com.deltax72.weatherapp.presentation.di

import com.deltax72.weatherapp.data.repo.CityLocalDataSourceImpl
import com.deltax72.weatherapp.data.repo.CityRepositoryImpl
import com.deltax72.weatherapp.domain.usecases.GetCitiesUseCase
import com.deltax72.weatherapp.presentation.presenters.CitiesPresenter

object CitiesPresenterFactory {
    fun getCitiesPresenter(): CitiesPresenter {
        val cityDataSource =
            CityLocalDataSourceImpl()
        val cityRepository =
            CityRepositoryImpl(
                cityDataSource
            )
        val getCitiesUseCase = GetCitiesUseCase(cityRepository)
        return CitiesPresenter(
            getCitiesUseCase
        )
    }
}