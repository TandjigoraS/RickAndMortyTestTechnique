package fr.tandjigora.rickandmortydeadoralivefanbase

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import fr.tandjigora.rickandmortydeadoralivefanbase.ui.MainActivity
import org.hamcrest.Matchers
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterInformationInstrumentedTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java
    )


    @Test
    fun checkIfClickItemListCharactersInformationIsDisplayed() {


        Espresso.onView(withId(R.id.recyclerview))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>
                    (0, clickOnViewChild(R.id.character_image))
            )




        Espresso.onView(withId(R.id.activity_character_information))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkCharacterInformationActivityIsDisplayedNameOfCharacterIsFilled() {
        Espresso.onView(
            allOf(
                withId(R.id.recyclerview),
                ViewMatchers.isDisplayed()
            )
        )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    clickOnViewChild(R.id.character_image)
                )
            )
        Espresso.onView(withId(R.id.character_name_txt_info)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    Matchers.containsString("Rick Sanchez")
                )
            )
        )
    }

}