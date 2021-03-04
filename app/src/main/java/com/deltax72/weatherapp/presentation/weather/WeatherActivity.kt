package com.deltax72.weatherapp.presentation.weather

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.domain.repository.CityRepository
import com.deltax72.weatherapp.R
import com.deltax72.weatherapp.WeatherApplication
import com.deltax72.weatherapp.domain.model.City
import com.deltax72.weatherapp.domain.model.Time
import com.deltax72.weatherapp.domain.model.Weather

class WeatherActivity : AppCompatActivity(), WeatherView {
    private lateinit var cityAndDate: TextView

    private lateinit var weatherList: RecyclerView

    lateinit var map: MutableMap<Time, Pair<Double, Weather.WeatherType>>

    val adapter = WeatherAdapter()

    private val presenter by lazy {
        val id = intent.getLongExtra(EXTRA_ID, 0)
        WeatherPresenterFactory.getWeatherPresenter(id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        this.cityAndDate = findViewById(R.id.city_and_date)
        this.weatherList = findViewById(R.id.weatherList)
        this.weatherList.adapter = this.adapter

        this.presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        this.presenter.onViewAttached()
        this.adapter.city.temperatures = this.map
    }

    override fun closeScreen() {
        finish()
    }

    override fun bindCity(city: City) {
        this.map = city.temperatures.filter { it.key.minute % 60 == 0 }.toMutableMap()
        this.cityAndDate.text = getString(R.string.city_and_date_format, city.name)
    }

    companion object {
        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            Intent(context, WeatherActivity::class.java).also { intent ->
                intent.putExtra(EXTRA_ID, id)
                context.startActivity(intent)
            }
        }
    }
}