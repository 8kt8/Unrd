package com.example.unrd

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.unrd.fragment.MainFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainFlowTest: TestWithBinding() {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun mainFlowTest() {

        val scenario: FragmentScenario<MainFragment> =
            launchFragmentInContainer(null, R.style.AppTheme)

        dataBindingIdlingResource.monitorFragment(scenario)

        scenario.onFragment { fragment ->

            val appCompatImageButton = onView(
                allOf(
                    withId(R.id.intro_video),
                    childAtPosition(
                        childAtPosition(
                            withId(R.id.nav_host_fragment),
                            0
                        ),
                        5
                    ),
                    isDisplayed()
                )
            )
            appCompatImageButton.perform(click())

            pressBack()

            val appCompatImageButton2 = onView(
                allOf(
                    withId(R.id.video),
                    childAtPosition(
                        childAtPosition(
                            withId(R.id.nav_host_fragment),
                            0
                        ),
                        6
                    ),
                    isDisplayed()
                )
            )
            appCompatImageButton2.perform(click())

            pressBack()

            val appCompatImageButton3 = onView(
                allOf(
                    withId(R.id.image),
                    childAtPosition(
                        childAtPosition(
                            withId(R.id.nav_host_fragment),
                            0
                        ),
                        7
                    ),
                    isDisplayed()
                )
            )
            appCompatImageButton3.perform(click())

            pressBack()
        }
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
