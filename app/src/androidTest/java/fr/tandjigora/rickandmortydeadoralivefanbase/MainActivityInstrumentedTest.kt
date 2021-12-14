package fr.tandjigora.rickandmortydeadoralivefanbase

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import fr.tandjigora.rickandmortydeadoralivefanbase.ui.MainActivity
import fr.tandjigora.rickandmortydeadoralivefanbase.utils.RecyclerViewItemCountAssertion

import org.hamcrest.Matchers
import org.hamcrest.core.AllOf.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    val CHARACTERS_ALIVE = 6
    val CHARACTERS_MALE = 12

    @Rule
    @JvmField
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java
    )


    @Test
    fun myCharactersList_shouldNotBeEmpty() {

        Espresso.onView(withId(R.id.recyclerview))
            .check(ViewAssertions.matches(ViewMatchers.hasMinimumChildCount(1)))
    }


    @Test
    fun checkWhenClickFilterByGenderMaleListCharactersIsFilteredByThisGender() {
        Espresso.onView(withId(R.id.filter))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Filter by gender male"))
            .perform(ViewActions.click())
         }


    @Test
    fun checkWhenClickFilterByStatusAliveListCharactersIsFilteredByThisStatus() {
        Espresso.onView(withId(R.id.filter))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Filter by status alive"))
            .perform(ViewActions.click())


    }
}



