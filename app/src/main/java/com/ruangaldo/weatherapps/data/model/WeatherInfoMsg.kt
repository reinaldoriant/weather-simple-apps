package com.ruangaldo.weatherapps.data.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherInfoMsg(
    //Update time
    @Json(name = "dt")
    val dt: Int,
    //City
    @Json(name = "name")
    val name: String,
    //Timezone
    @Json(name = "timezone")
    val timezone: Int,
)