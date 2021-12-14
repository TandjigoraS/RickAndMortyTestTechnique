package fr.tandjigora.rickandmortydeadoralivefanbase.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.hamcrest.Matchers


import org.junit.Assert

class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {
    override fun check(view: View, noViewFoundException: NoMatchingViewException) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }
        val recyclerView = view as RecyclerView
        if (recyclerView.adapter != null) {
            Assert.assertThat(
                recyclerView.adapter!!.itemCount, Matchers.`is`(
                    expectedCount
                )
            )
        }
    }
}