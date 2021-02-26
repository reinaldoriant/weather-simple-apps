package com.ruangaldo.weatherapps

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ruangaldo.weatherapps.data.remote.ApiModule.service
import com.ruangaldo.weatherapps.utils.ui.CITY_CODE
import com.ruangaldo.weatherapps.utils.ui.KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GetApiTest {

    @get:Rule
    val instanTaskExecutorRule = InstantTaskExecutorRule()
    private var disposable: Disposable? = null

    @Test
    @Throws(Exception::class)
    fun get_data_from_api() {

        disposable = service.getCurrentWeather(CITY_CODE, KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Assert.assertNotNull(it)
                Assert.assertEquals("ID", it.sys.country)

            }
    }
}