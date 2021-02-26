package com.ruangaldo.weatherapps

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.ruangaldo.weatherapps.ui.WeatherActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class WeatherActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(WeatherActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.ruangaldo.weatherapps", appContext.packageName)

    }

    @Test
    fun user_can_enter_email() {
        Espresso.onView(ViewMatchers.withId(R.id.swipe_refresh)).perform(ViewActions.swipeDown())
    }
}