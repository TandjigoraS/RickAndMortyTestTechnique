package fr.tandjigora.rickandmortydeadoralivefanbase.ui

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import fr.tandjigora.rickandmortydeadoralivefanbase.R

class CharacterInformation : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_information)
        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapseLayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nameCharacter = findViewById<TextView>(R.id.character_name_txt_info)
        val genderCharacter = findViewById<TextView>(R.id.character_gender_txt_info)
        val typeCharacter = findViewById<TextView>(R.id.character_type_txt_info)
        val speciesCharacter = findViewById<TextView>(R.id.character_species_txt_info)
        val imageCharacter = findViewById<ImageView>(R.id.character_image_information)
        val statusCharacter = findViewById<TextView>(R.id.character_status_txt_info)



        collapsingToolbarLayout.title = intent.getStringExtra("name")

        nameCharacter.text = intent.getStringExtra("name")
        genderCharacter.text = intent.getStringExtra("gender")
        typeCharacter.text = intent.getStringExtra("type")
        speciesCharacter.text = intent.getStringExtra("species")
        statusCharacter.text = intent.getStringExtra("status")


        Glide.with(this)
            .load(Uri.parse(intent.getStringExtra("image")))
            .into(imageCharacter)


    }


}