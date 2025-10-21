package com.turingalan.pokemon.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn {
        items(
            items = uiState.list,
        ){
            PokemonListItemCard(
                pokemonID = it.id,
                name = it.name,
                spriteId = it.spriteId,
                onShowDetail = onShowDetail
            )
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