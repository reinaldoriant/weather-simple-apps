package com.ruangaldo.weatherapps.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDatabase:RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
    companion object{
        private var INSTANCE : WeatherDatabase? =null

        fun getAppDataBase(context: Context): WeatherDatabase? {
            if (INSTANCE == null){
                synchronized(WeatherDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        WeatherDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}
