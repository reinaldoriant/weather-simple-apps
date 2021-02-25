package com.ruangaldo.weatherapps.data.model


import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.utils.ui.ID_DB
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherMsg(
    @Json(name = "dt")
    val dt: Int,
    @Json(name = "main")
    val main: Main,
    @Json(name = "name")
    val name: String,
    @Json(name = "sys")
    val sys: Sys,
    @Json(name = "weather")
    val weather: List<Weather>,
    @Json(name = "wind")
    val wind: Wind
) {
    data class Main(
        @Json(name = "humidity")
        val humidity: Int,
        @Json(name = "pressure")
        val pressure: Int,
        @Json(name = "temp")
        val temp: Double,
        @Json(name = "temp_max")
        val tempMax: Double,
        @Json(name = "temp_min")
        val tempMin: Double
    )

    data class Sys(
        @Json(name = "country")
        val country: String,
        @Json(name = "sunrise")
        val sunrise: Long,
        @Json(name = "sunset")
        val sunset: Long
    )

    data class Weather(
        @Json(name = "description")
        val description: String,
        @Json(name = "id")
        val id: Int,
        @Json(name = "main")
        val main: String
    )

    data class Wind(
        @Json(name = "speed")
        val speed: Double
    )

    fun backToEntity() = WeatherEntity(
        ID_DB,
        name,
        sys.country,
        dt,
        weather.first().main,
        main.temp,
        main.tempMin,
        main.tempMax,
        sys.sunrise,
        sys.sunset,
        wind.speed,
        main.pressure,
        main.humidity
    )

}