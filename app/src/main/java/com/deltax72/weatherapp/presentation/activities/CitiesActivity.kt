package com.deltax72.weatherapp.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.R
import com.deltax72.weatherapp.domain.models.City
import com.deltax72.weatherapp.presentation.adapters.CitiesAdapter
import com.deltax72.weatherapp.presentation.di.CitiesPresenterFactory
import com.deltax72.weatherapp.presentation.viewmodels.CitiesView

class CitiesActivity : AppCompatActivity(),
        CitiesView {
    private lateinit var citiesList: RecyclerView
    private lateinit var findButton: Button

    private val presenter by lazy {
        CitiesPresenterFactory.getCitiesPresenter()
    }

    private val adapter =
            CitiesAdapter {
                this.presenter.onCityClick(it)
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
        this.presenter.attachView(this)

        this.citiesList = findViewById(R.id.citiesList)
        this.citiesList.adapter = this.adapter
    }

    override fun onResume() {
        super.onResume()
        this.presenter.onViewResumed()
    }

    override fun bindCitiesList(list: List<City>) {
        this.adapter.cities = list
    }

    override fun openCityWeatherScreen(cityId: Long) {
        WeatherActivity.start(this, cityId)
    }

    override fun onDestroy() {
        this.presenter.detachView()
        super.onDestroy()
    }
}