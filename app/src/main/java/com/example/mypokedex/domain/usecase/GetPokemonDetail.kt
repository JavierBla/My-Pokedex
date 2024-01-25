package com.example.mypokedex.domain.usecase

import com.example.mypokedex.data.repositories.PokemonRepository
import com.example.mypokedex.domain.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend fun getPokemon(name: String): Pokemon {
        val pokemonLoaded = withContext(Dispatchers.IO) {
            pokemonRepository.obtainPokemon(name)
        }
        return pokemonLoaded
    }
}