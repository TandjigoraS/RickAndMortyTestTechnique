package fr.tandjigora.rickandmortydeadoralivefanbase.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import fr.tandjigora.rickandmortydeadoralivefanbase.ListCharactersQuery
import fr.tandjigora.rickandmortydeadoralivefanbase.R
import fr.tandjigora.rickandmortydeadoralivefanbase.adapter.CharacterItemDecoration
import fr.tandjigora.rickandmortydeadoralivefanbase.adapter.ListCharactersAdapter
import fr.tandjigora.rickandmortydeadoralivefanbase.apolloClient

class MainActivity : AppCompatActivity() {

    private var newListCharactersByStatusUnknown: List<ListCharactersQuery.Result?>? = null
    private var newListCharactersByStatusAlive: List<ListCharactersQuery.Result?>? = null
    private var newListCharactersByStatusDead: List<ListCharactersQuery.Result?>? = null
    private var newListCharactersByGenderUnknown: List<ListCharactersQuery.Result?>? = null
    private var newListCharactersByGenderGenderless: List<ListCharactersQuery.Result?>? = null
    private var newListCharactersByGenderMale: List<ListCharactersQuery.Result?>? = null
    private var newListCharactersByGenderFemale: List<ListCharactersQuery.Result?>? = null
    private var newListCharacters: List<ListCharactersQuery.Result?>? = null
    private lateinit var mRecyclerView: RecyclerView
    private val listCharacters = ArrayList<ListCharactersQuery.Result>()


    val adapter = ListCharactersAdapter(this, listCharacters, R.layout.item_list_characters)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mRecyclerView = findViewById(R.id.recyclerview)
        mRecyclerView.adapter = adapter
        mRecyclerView.addItemDecoration(CharacterItemDecoration())



        lifecycleScope.launchWhenResumed {

            val listCharactersQuery =
                apolloClient()
                    .query(ListCharactersQuery())
                    .execute()


            newListCharacters =
                listCharactersQuery.data?.characters?.results
            newListCharactersByGenderFemale =
                listCharactersQuery.data?.characters?.results?.filter { it?.gender == "Female" }
            newListCharactersByGenderMale =
                listCharactersQuery.data?.characters?.results?.filter { it?.gender == "Male" }
            newListCharactersByGenderGenderless =
                listCharactersQuery.data?.characters?.results?.filter { it?.gender == "Genderless" }
            newListCharactersByGenderUnknown =
                listCharactersQuery.data?.characters?.results?.filter { it?.gender == "unknown" }
            newListCharactersByStatusDead =
                listCharactersQuery.data?.characters?.results?.filter { it?.status == "Dead" }
            newListCharactersByStatusAlive =
                listCharactersQuery.data?.characters?.results?.filter { it?.status == "Alive" }
            newListCharactersByStatusUnknown =
                listCharactersQuery.data?.characters?.results?.filter { it?.status == "unknown" }



            if (newListCharacters != null) {
                adapter.updateCharacters(newListCharacters as List<ListCharactersQuery.Result>?)
            }


        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.all_characters ->  adapter.updateCharacters(newListCharacters as List<ListCharactersQuery.Result>?)
            R.id.filter_by_gender_male -> adapter.updateCharacters(newListCharactersByGenderMale as List<ListCharactersQuery.Result>?)
            R.id.filter_by_gender_female -> adapter.updateCharacters(newListCharactersByGenderFemale as List<ListCharactersQuery.Result>?)
            R.id.filter_by_gender_genderless -> adapter.updateCharacters(newListCharactersByGenderGenderless as List<ListCharactersQuery.Result>?)
            R.id.filter_by_gender_unknown -> adapter.updateCharacters(newListCharactersByGenderUnknown as List<ListCharactersQuery.Result>?)
            R.id.filter_by_status_alive -> adapter.updateCharacters(newListCharactersByStatusAlive as List<ListCharactersQuery.Result>?)
            R.id.filter_by_status_dead -> adapter.updateCharacters(newListCharactersByStatusDead as List<ListCharactersQuery.Result>?)
            R.id.filter_by_status_unknown -> adapter.updateCharacters(newListCharactersByStatusUnknown as List<ListCharactersQuery.Result>?)


        }
        return super.onOptionsItemSelected(item)
    }




}

