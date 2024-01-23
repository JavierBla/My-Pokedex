package com.example.mypokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mypokedex.R
import com.example.mypokedex.ui.viewModel.PokemonDetailsViewModel

@Composable
fun PokemonListItem(
    pokemonName: String,
    navHostController: NavHostController,
    pokemonViewModel: PokemonDetailsViewModel
) {

    Card(
        modifier = Modifier
            .clickable {
                pokemonViewModel.loadPokemon(pokemonName)
                navHostController.navigate("PokemonDetails")
            }
            .padding(end = 25.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.charizard),
            contentDescription = "",
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = pokemonName.replaceFirstChar { it.toUpperCase() },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}