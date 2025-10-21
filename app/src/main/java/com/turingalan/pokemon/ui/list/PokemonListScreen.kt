package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.turingalan.pokemon.data.model.Pokemon
import com.turingalan.pokemon.data.repository.PokemonInMemoryRepository

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
    onShowDetail: (Long) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    val pokemons: List<Pokemon> = PokemonInMemoryRepository().readAll()
    Scaffold(
    ){
        paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            contentPadding = PaddingValues(8.dp)) {
            items(
                items = pokemons,
                key = {
                    it.id
                }
            ){
                PokemonListScreen(
                    onShowDetail = onShowDetail
                )

            }
        }
    }
}

@Composable
fun PokemonListItemCard(
    modifier: Modifier = Modifier,
    pokemonID: Long,
    name: String,
    spriteId:Int,
    onShowDetail: (Long) -> Unit ={},
){
    Card (
        modifier = Modifier.fillMaxWidth().clickable(enabled = true, onClick = {
            onShowDetail (pokemonID)
        })
    ){
        Row {
            Image(painterResource(spriteId), contentDescription = "imagen")
            Text(text = name,
                style = MaterialTheme.typography.bodySmall)
        }
    }
}