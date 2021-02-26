package com.ruangaldo.weatherapps.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dataWeather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "city") val city: String? = null,
    @ColumnInfo(name = "country") val country: String? = null,
    @ColumnInfo(name = "update_at") var update_at: Int? = null,
    @ColumnInfo(name = "status") val status: String? = null,
    @ColumnInfo(name = "temp") val temp: Double? = null,
    @ColumnInfo(name = "temp_min") val temp_min: Double? = null,
    @ColumnInfo(name = "temp_max") val temp_max: Double? = null,
    @ColumnInfo(name = "sunrise") val sunrise: Long? = null,
    @ColumnInfo(name = "sunset") val sunset: Long? = null,
    @ColumnInfo(name = "wind") val wind: Double? = null,
    @ColumnInfo(name = "pressure") val pressure: Int? = null,
    @ColumnInfo(name = "humidity") val humidity: Int? = null,
    )
