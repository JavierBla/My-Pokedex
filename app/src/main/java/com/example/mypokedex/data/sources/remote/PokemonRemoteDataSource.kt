package com.example.mypokedex.data.sources.remote

import com.example.mypokedex.data.mappers.PokemonDeserialized
import com.example.mypokedex.data.mappers.PokemonListDeserializated
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.domain.repositories.IObtainPokemonRemote
import com.example.mypokedex.domain.repositories.IPokemonAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRemoteDataSource: IObtainPokemonRemote {

    var retrofit: IPokemonAPI = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IPokemonAPI::class.java)

    override fun obtainPokemonFromApi(pokemonName: String): Pokemon {
        val call = retrofit.getPokemon(pokemonName)

        val gson: Gson = GsonBuilder().registerTypeAdapter(
            Pokemon::class.java,
            PokemonDeserialized()
        ).create()

        val pokemonAPI = gson.fromJson(call.execute().body().toString(), Pokemon::class.java)

        return pokemonAPI
    }

    override fun obtainListFromApi(): List<*> {
        val call = retrofit.getListPokemon()

        val gson: Gson = GsonBuilder().registerTypeAdapter(
            List::class.java,
            PokemonListDeserializated()
        ).create()

        val pokemonListApi = gson.fromJson(call.execute().body().toString(), List::class.java)

        return pokemonListApi
    }
}