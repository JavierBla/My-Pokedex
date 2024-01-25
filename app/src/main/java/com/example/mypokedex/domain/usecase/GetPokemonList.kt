package com.example.mypokedex.domain.usecase

import com.example.mypokedex.data.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonList @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend fun getPokemonList(): List<*> {
        val pokemonList = withContext(Dispatchers.IO) {
            pokemonRepository.obtainListPokemon()
        }
        return pokemonList
    }
}