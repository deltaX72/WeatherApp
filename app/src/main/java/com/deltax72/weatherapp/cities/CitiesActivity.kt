package com.deltax72.weatherapp.cities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.CitiesActions
import com.deltax72.weatherapp.R
import com.deltax72.weatherapp.WeatherApplication
import com.deltax72.weatherapp.newcity.NewCityActivity
import com.deltax72.weatherapp.weather.WeatherActivity

class CitiesActivity : AppCompatActivity(), CitiesListView {
    private lateinit var citiesList: RecyclerView
    private lateinit var findButton: Button

    private val presenter by lazy {
        CityPresenter((application as WeatherApplication).citiesActions)
    }

    private val adapter = CitiesAdapter {
        this.presenter.onCityClick(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
        this.presenter.attachView(this)

        this.citiesList = findViewById(R.id.citiesList)
//        this.findButton = findViewById(R.id.addButton)
//        this.findButton.setOnClickListener {
//            val intent = Intent(this, NewCityActivity::class.java)
//            startActivity(intent)
//        }
        this.citiesList.adapter = this.adapter
    }

    override fun onResume() {
        super.onResume()
        this.presenter.onViewResumed()
    }

    override fun bindCityList(list: List<City>) {
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