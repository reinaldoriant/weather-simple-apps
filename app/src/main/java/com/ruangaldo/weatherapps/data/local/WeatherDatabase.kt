package com.ruangaldo.weatherapps.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDatabase:RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
