package com.example.mypokedex.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mypokedex.R
import com.example.mypokedex.domain.model.Pokemon
import com.example.mypokedex.domain.model.Types
import com.example.mypokedex.ui.theme.PokedexColor
import java.util.Locale

@Composable
fun PokemonDetails(pokemon: Pokemon, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(270.dp, 290.dp),
            shape = RoundedCornerShape(bottomEnd = 75.dp, bottomStart = 75.dp),
            colors = CardDefaults.cardColors(PokedexColor)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Color.Transparent,
                        RoundedCornerShape(bottomEnd = 75.dp, bottomStart = 75.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background_pokedex),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                AsyncImage(
                    model = pokemon.image,
                    contentDescription = "pokemon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(250.dp)
                )
            }
        }

        Text(text = pokemon.name.replaceFirstChar { it.uppercase() }, fontSize = 40.sp, color = Color.White)

        Spacer(modifier = Modifier.height(20.dp))

        Types(pokemon)

        BasicPokemonDatta(pokemon)

        PokemonStats(pokemon)
    }
}

@Composable
fun Types(pokemon: Pokemon) {
    Row {
        pokemon.pokemonTypes.map {
            Spacer(modifier = Modifier.size(30.dp, 50.dp))
            MyTypes(it)
            Spacer(modifier = Modifier.size(20.dp, 50.dp))
        }
    }
}

@Composable
private fun MyTypes(types: Types) {
    Text(
        text = types.typeName.uppercase(Locale.ROOT),
        color = Color.White,
        modifier = Modifier
            .background(
                color = types.color,
                shape = RoundedCornerShape(15.dp)
            )
            .size(130.dp, 25.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun BasicPokemonDatta(pokemon: Pokemon) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${pokemon.weight/10} KG", color = Color.White, fontSize = 25.sp)
        Spacer(modifier = Modifier.size(50.dp))
        Text(text = "${pokemon.height/10} M", color = Color.White, fontSize = 25.sp)
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Weight", color = Color.Gray)
        Spacer(modifier = Modifier.size(70.dp, 20.dp))
        Text(text = "Height", color = Color.Gray)
    }

    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
private fun PokemonStats(pokemon: Pokemon) {
    Text(text = "Base Stats", fontSize = 30.sp, color = Color.White)

    Spacer(modifier = Modifier.height(10.dp))

    pokemon.pokemonStats.map {
        val with = if (it.name == "EXP") 1000/10 else it.weight
        val weight = if (it.name == "EXP") "/1000" else "/300"

        Row(
            modifier = Modifier
                .padding(20.dp,0.dp)
        ) {
            Text(
                text = it.name,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(30.dp))
            Box {
                Text(
                    text = "",
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(15.dp))
                        .size(1000.dp, 22.dp)
                )
                Text(
                    text = "${it.weight}$weight",
                    modifier = Modifier
                        .background(it.color, RoundedCornerShape(15.dp))
                        .size(with.dp, 22.dp),
                    textAlign = TextAlign.End,
                    color = Color.White
                )
            }
        }
    }
}