package com.example.mypokedex.data.repositories

import android.app.Application
import android.content.Context
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.data.mappers.PokemonDeserialized
import com.example.mypokedex.data.mappers.PokemonListDeserializated
import com.example.mypokedex.domain.repositories.IObtainPokemonLocal
import com.example.mypokedex.domain.repositories.IObtainPokemonRemote
import com.example.mypokedex.domain.repositories.IPokemonAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PokemonRepositoryLocal @Inject constructor(application: Application): IObtainPokemonLocal, IObtainPokemonRemote {

    private val context: Context = application.applicationContext
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

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

    override fun obtainFromApi(pokemonName: String): Pokemon {
        val pokemonService: IPokemonAPI = retrofit.create(IPokemonAPI::class.java)

        val call = pokemonService.getPokemon(pokemonName)

        val gson: Gson = GsonBuilder().registerTypeAdapter(
            Pokemon::class.java,
            PokemonDeserialized()
        ).create()

        val pokemonAPI = gson.fromJson(call.execute().body().toString(), Pokemon::class.java)

        return pokemonAPI
    }
}