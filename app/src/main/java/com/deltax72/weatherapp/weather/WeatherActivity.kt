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
import com.deltax72.weatherapp.cities.Weather

class WeatherActivity : AppCompatActivity() {
    private lateinit var cityAndDate: TextView

    private lateinit var citiesActions: CitiesActions
    private lateinit var weatherList: RecyclerView
    private val adapter = WeatherAdapter()

    private lateinit var map: Map<Int, Pair<Double, Weather.WeatherType>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.citiesActions = (application as WeatherApplication).citiesActions
        setContentView(R.layout.activity_weather)

        val id = intent.getLongExtra(EXTRA_ID, 0)
        val city = this.citiesActions.getCity(id)

        if (city != null) {
            this.cityAndDate = findViewById(R.id.city_and_date)
            this.weatherList = findViewById(R.id.weatherList)
            this.weatherList.adapter = this.adapter
            this.map = city.temperatures

            this.cityAndDate.text = getString(R.string.city_and_date_format, city.name, city.date)
        } else {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        this.adapter.city.temperatures = this.map
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