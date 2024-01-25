package com.example.mypokedex.data.repositories

import android.app.Application
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.data.sources.local.PokemonLocalDataSource
import com.example.mypokedex.data.sources.remote.PokemonRemoteDataSource
import javax.inject.Inject

class PokemonRepository @Inject constructor(application: Application) {

    private val pokemonRemote = PokemonRemoteDataSource()
    private val pokemonLocal = PokemonLocalDataSource(application)

    fun obtainPokemon(pokemonName: String): Pokemon {
        return try {
            pokemonRemote.obtainPokemonFromApi(pokemonName)
        } catch (e: Exception) {
            pokemonLocal.obtainFromJson("ditto")
        }
    }

    fun obtainListPokemon(): List<*> {
        return try {
            pokemonRemote.obtainListFromApi()
        } catch (e: Exception) {
            pokemonLocal.obtainListFromJson()
        }
    }
}