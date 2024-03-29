package com.cabify.cabistore

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class Excercise1Test {

  @Rule
  @JvmField
  var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

  @Test
  fun excercise1Test() {
    val appCompatImageView = onView(allOf(withId(R.id.addButton), childAtPosition(childAtPosition(withId(R.id.recyclerView), 0), 4), isDisplayed()))
    appCompatImageView.perform(click())

    val appCompatImageView2 = onView(allOf(withId(R.id.addButton), childAtPosition(childAtPosition(withId(R.id.recyclerView), 1), 4), isDisplayed()))
    appCompatImageView2.perform(click())

    val appCompatImageView3 = onView(allOf(withId(R.id.addButton), childAtPosition(childAtPosition(withId(R.id.recyclerView), 2), 4), isDisplayed()))
    appCompatImageView3.perform(click())
  }

  private fun childAtPosition(parentMatcher: Matcher<View>, position: Int): Matcher<View> {

    return object : TypeSafeMatcher<View>() {
      override fun describeTo(description: Description) {
        description.appendText("Child at position $position in parent ")
        parentMatcher.describeTo(description)
      }

      public override fun matchesSafely(view: View): Boolean {
        val parent = view.parent
        return parent is ViewGroup && parentMatcher.matches(parent) && view == parent.getChildAt(position)
      }
    }
  }
}
