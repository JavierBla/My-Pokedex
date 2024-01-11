package com.example.mypokedex.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mypokedex.ui.components.PokemonListItem
import com.example.mypokedex.ui.viewModel.PokemonListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonList(paddingValues: PaddingValues, list: List<*>?) {

    LazyVerticalStaggeredGrid(
        modifier = Modifier.padding(paddingValues),
        columns = StaggeredGridCells.Fixed(2),
        content = {
            list?.size?.let {
                items(it) { index ->
                    PokemonListItem(pokemonName = list[index].toString())
                }
            }
        },
        verticalItemSpacing = 25.dp,
        contentPadding = PaddingValues(start = 20.dp),

    )
}