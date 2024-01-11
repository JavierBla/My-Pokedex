package com.example.mypokedex.domain.repositories

import android.app.Application
import android.content.Context
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.domain.model.PokemonDeserialized
import com.example.mypokedex.domain.model.PokemonListDeserializated
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import javax.inject.Inject

class PokemonRepository @Inject constructor(application: Application): IObtainPokemon {

    private val context: Context = application.applicationContext

    override fun obtainFromJson(pokemonName: String): Pokemon {
        val jsonFile = context.assets.open("$pokemonName.json").bufferedReader().use { it.readText() }
        val gson: Gson = GsonBuilder().registerTypeAdapter(
            Pokemon::class.java,
            PokemonDeserialized()
        ).create()
        val pokemonJson = gson.fromJson(jsonFile, Pokemon::class.java)

        return pokemonJson
    }

    override fun obtainListFromJson(): List<*> {
        val jsonFile = context.assets.open("pokemon.json").bufferedReader().use { it.readText() }
        val gson: Gson = GsonBuilder().registerTypeAdapter(
            List::class.java,
            PokemonListDeserializated()
        ).create()
        val listJson = gson.fromJson(jsonFile, List::class.java)

        return listJson
    }

    override fun obtainFromApi() {
        TODO("Not yet implemented")
    }
}