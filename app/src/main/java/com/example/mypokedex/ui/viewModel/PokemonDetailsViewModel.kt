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
    private val _pokemonName: MutableLiveData<String> = MutableLiveData("ditto")
    val pokemon: LiveData<Pokemon> = _pokemon
    val name: LiveData<String> = _pokemonName

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            val pokemonLoaded = withContext(Dispatchers.IO) {
                pokemonRepository.obtainFromApi(getPokemonName())
            }
            _pokemon.postValue(pokemonLoaded)
        }
    }

    private fun getPokemonName(): String {
        return _pokemonName.value.toString()
    }

    fun setPokemonName(name: String?) {
        _pokemonName.value = name
    }
}