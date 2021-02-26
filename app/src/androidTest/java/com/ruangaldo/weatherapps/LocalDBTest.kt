package com.ruangaldo.weatherapps

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ruangaldo.weatherapps.data.local.WeatherDao
import com.ruangaldo.weatherapps.data.local.WeatherDatabase
import com.ruangaldo.weatherapps.data.local.WeatherEntity
import com.ruangaldo.weatherapps.utils.ui.ID_DB
import io.reactivex.schedulers.Schedulers
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DBTest {

    @get:Rule
    val instanTaskExecutorRule = InstantTaskExecutorRule()

    private var dao: WeatherDao? = null
    private var db: WeatherDatabase? = null

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(appContext, WeatherDatabase::class.java).build()
        dao = db?.weatherDao()
    }

    @Test
    @Throws(Exception::class)
    fun insert_and_get_data_from_db_room() {
        val data = WeatherEntity(
            ID_DB,
            "Jakarta",
            "ID",
            1614066476,
            "Cloud",
            303.02,
            300.0,
            400.2,
            1614121109,
            1614165216,
            4.12,
            1009,
            83
        )

        // insert
        val insertDb = dao?.insertData(data)
        Assert.assertNotNull(insertDb)

        //get user
        val getDb = dao?.getData(ID_DB)
        Assert.assertNotNull(getDb)

        getDb?.observeOn(Schedulers.io())?.subscribe {
            Assert.assertEquals(data.update_at, it.update_at)
            Assert.assertNotNull(it)
        }
    }

    fun get_data_from_api() {
        val data = WeatherEntity(
            ID_DB,
            "Jakarta",
            "ID",
            1614066476,
            "Cloud",
            303.02,
            300.0,
            400.2,
            1614121109,
            1614165216,
            4.12,
            1009,
            83
        )

        // insert
        val insertDb = dao?.insertData(data)
        Assert.assertNotNull(insertDb)

        //get user
        val getDb = dao?.getData(ID_DB)
        Assert.assertNotNull(getDb)

        getDb?.observeOn(Schedulers.io())?.subscribe {
            Assert.assertEquals(data.update_at, it.update_at)
            Assert.assertNotNull(it)
        }
    }


    @After
    fun closeDb() {
        db?.close()
    }
}