package com.example.universitieslist


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class UniversityActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(UniversityActivity::class.java)

    @Test
    fun universityActivityTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.etCountryName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("india"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etCountryName), withText("india"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(pressImeActionButton())

        val appCompatTextView = onView(
            allOf(
                withId(R.id.tvSearch), withText("Search"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatTextView.perform(click())

        val appCompatImageView = onView(
            allOf(
                withId(R.id.ivBack),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView.perform(click())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.etCountryName), withText("india"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("indi"))

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.etCountryName), withText("indi"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.etCountryName), withText("indi"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(pressImeActionButton())

        val appCompatTextView2 = onView(
            allOf(
                withId(R.id.tvSearch), withText("Search"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatTextView2.perform(click())

        val appCompatImageView2 = onView(
            allOf(
                withId(R.id.ivBack),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_nav_host_fragment),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageView2.perform(click())
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
