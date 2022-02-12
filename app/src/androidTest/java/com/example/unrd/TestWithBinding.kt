package com.example.unrd

import androidx.test.espresso.IdlingPolicies
import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
@LargeTest
abstract class TestWithBinding {

    // An Idling Resource that waits for Data Binding to have no pending bindings
    protected val dataBindingIdlingResource = DataBindingIdlingResource()

    @Before
    fun idlingResourceTimeout() {
        IdlingPolicies.setIdlingResourceTimeout(4000, TimeUnit.MILLISECONDS)
    }

    /**
     * Idling resources tell Espresso that the app is idle or busy. This is needed when operations
     * are not scheduled in the main Looper (for example when executed on a different thread).
     */

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(dataBindingIdlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(dataBindingIdlingResource)
    }


}
