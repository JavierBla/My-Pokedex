package com.example.mypokedex.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mypokedex.ui.components.PokemonListItem
import com.example.mypokedex.ui.viewModel.PokemonDetailsViewModel

@Composable
fun PokemonList(
    paddingValues: PaddingValues,
    list: List<*>?,
    navHostController: NavHostController,
    pokemonViewModel: PokemonDetailsViewModel
) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier.padding(paddingValues),
        columns = StaggeredGridCells.Fixed(1),
        content = {
            list?.size?.let {
                items(it) { index ->
                    PokemonListItem(
                        list[index].toString(),
                        navHostController,
                        pokemonViewModel)
                }
            }
        },
        verticalItemSpacing = 25.dp,
        contentPadding = PaddingValues(start = 20.dp),
    )
}