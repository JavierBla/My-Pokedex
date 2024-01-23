package com.example.mypokedex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mypokedex.ui.screens.PokemonDetails
import com.example.mypokedex.ui.screens.PokemonList
import com.example.mypokedex.ui.theme.MyPokedexTheme
import com.example.mypokedex.ui.theme.PokedexColor
import com.example.mypokedex.ui.viewModel.PokemonDetailsViewModel
import com.example.mypokedex.ui.viewModel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPokedexTheme {
                val listViewModel: PokemonListViewModel by viewModels()
                val pokemonViewModel: PokemonDetailsViewModel by viewModels()
                MyScaffold(pokemonViewModel, listViewModel)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun MyScaffold(pokemonViewModel: PokemonDetailsViewModel, listViewModel: PokemonListViewModel) {
    val listPokemon = listViewModel.list.observeAsState().value
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { MyTopAppBar(navController, pokemonViewModel) }
    ) {
        if (listPokemon != null) {
            MyNavController(navController, listPokemon, it, pokemonViewModel)
        } else {
            Column(
                modifier = Modifier.padding(paddingValues = it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pokeballm),
                    contentDescription = "",
                    alignment = Alignment.Center
                )
            }
        }
    }
}

@Composable
private fun MyNavController(
    navController: NavHostController,
    listPokemon: List<*>?,
    paddingValues: PaddingValues,
    pokemonViewModel: PokemonDetailsViewModel
) {
    NavHost(navController = navController, startDestination = "PokemonList") {
        composable("PokemonList") {
            PokemonList(paddingValues, listPokemon, navController, pokemonViewModel)
        }
        composable("PokemonDetails"
        ) {backStackEntry ->
            PokemonDetails(paddingValues, pokemonViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    navHostController: NavHostController,
    pokemonViewModel: PokemonDetailsViewModel
) {
    TopAppBar(
        title = { Text(text = "Pokedex", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { navHostController.navigate("PokemonList") }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
            }
        },
        actions = {
            Text(
                text = pokemonViewModel.comproveId(),
                color = Color.White)
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(PokedexColor)
    )
}