package com.deltax72.weatherapp.weather

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.weatherapp.CitiesActions
import com.deltax72.weatherapp.R
import com.deltax72.weatherapp.WeatherApplication
import com.deltax72.weatherapp.cities.City
import com.deltax72.weatherapp.cities.Time
import com.deltax72.weatherapp.cities.Weather

class WeatherActivity : AppCompatActivity(), WeatherView {
    private lateinit var cityAndDate: TextView

    private lateinit var citiesActions: CitiesActions
    private lateinit var weatherList: RecyclerView

    lateinit var map: MutableMap<Time, Pair<Double, Weather.WeatherType>>

    private val adapter = WeatherAdapter()

    private var isTriggered = false

    private val presenter by lazy {
        WeatherPresenter(
                (application as WeatherApplication).citiesActions,
                intent.getLongExtra(EXTRA_ID, 0)
        )
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
        this.isTriggered = false
        this.presenter.onViewAttached()
        this.adapter.city.temperatures = this.map
    }

    override fun closeScreen() {
        finish()
    }

    override fun bindCity(city: City) {
        val map: MutableMap<Time, Pair<Double, Weather.WeatherType>> = mapOf<Time, Pair<Double, Weather.WeatherType>>().toMutableMap()
        if (!this.isTriggered) {
            for (i in city.temperatures.keys) {
                if (i.minute % 60 == 0) {
                    map[Time(i.hour, i.minute)] = city.temperatures[Time(i.hour, i.minute)] ?: throw RuntimeException("")
                }
            }
            this.map = map ?: throw RuntimeException("List is empty!")
            this.isTriggered = true
        } else {
            this.map = city.temperatures
        }
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