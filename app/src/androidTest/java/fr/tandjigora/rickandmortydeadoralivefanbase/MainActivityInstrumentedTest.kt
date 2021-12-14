package fr.tandjigora.rickandmortydeadoralivefanbase

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import fr.tandjigora.rickandmortydeadoralivefanbase.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {


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



