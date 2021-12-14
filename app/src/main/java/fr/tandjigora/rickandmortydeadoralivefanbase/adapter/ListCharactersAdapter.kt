package fr.tandjigora.rickandmortydeadoralivefanbase.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.tandjigora.rickandmortydeadoralivefanbase.ui.CharacterInformation
import fr.tandjigora.rickandmortydeadoralivefanbase.ListCharactersByGenderMaleQuery
import fr.tandjigora.rickandmortydeadoralivefanbase.ListCharactersQuery
import fr.tandjigora.rickandmortydeadoralivefanbase.R
import fr.tandjigora.rickandmortydeadoralivefanbase.ui.MainActivity

class ListCharactersAdapter (
    private val context : MainActivity,
    private val listCharacters : ArrayList<ListCharactersQuery.Result>,
    private val layoutId : Int
        ) : RecyclerView.Adapter<ListCharactersAdapter.ViewHolder>() {

    fun updateCharacters(myListCharacters: List<ListCharactersQuery.Result>?) {
        listCharacters.clear()
        if (myListCharacters != null)
            listCharacters.addAll(myListCharacters)

        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val characterName: TextView = view.findViewById(R.id.character_name_txt)
        val characterGender: TextView = view.findViewById(R.id.character_gender_txt)
        val characterImage: ImageView = view.findViewById(R.id.character_image)
        val characterStatus: TextView = view.findViewById(R.id.character_status_txt)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCharacter = listCharacters[position]

        holder.characterName.text = currentCharacter.name
        holder.characterGender.text = currentCharacter.gender
        holder.characterStatus.text = currentCharacter.status
        Glide.with(context)
                .load(Uri.parse(currentCharacter.image))
                .into(holder.characterImage)

        holder.characterImage.setOnClickListener {
                val intent = Intent(context, CharacterInformation::class.java).apply {
                    putExtra("name",currentCharacter.name)
                    putExtra("gender",currentCharacter.gender)
                    putExtra("species",currentCharacter.species)
                    putExtra("type",currentCharacter.type)
                    putExtra("image",currentCharacter.image)
                    putExtra("status",currentCharacter.status)

                }
            it.context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

}