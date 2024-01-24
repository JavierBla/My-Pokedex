package com.example.mypokedex.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypokedex.data.repositories.PokemonRepositoryLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepositoryLocal
): ViewModel() {
    private val _list: MutableLiveData<List<*>> = MutableLiveData()
    val list: LiveData<List<*>> = _list

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            val pokemonLoaded = withContext(Dispatchers.IO) {
                pokemonRepository.obtainListFromJson()
            }
            _list.postValue(pokemonLoaded as List<*>?)
        }
    }
}