package com.example.mypokedex.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.domain.repositories.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
): ViewModel() {

    private val _pokemon: MutableLiveData<Pokemon> = MutableLiveData(null)
    val pokemon: LiveData<Pokemon> = _pokemon

    fun loadPokemon(name: String) {
        viewModelScope.launch {
            val pokemonLoaded = withContext(Dispatchers.IO) {
                pokemonRepository.obtainFromApi(name)
            }
            _pokemon.postValue(pokemonLoaded)
        }
    }

    fun comproveId(): String {
        return if (pokemon.value?.id == null) {
            ""
        } else {
            pokemon.value?.id.toString()
        }
    }
}