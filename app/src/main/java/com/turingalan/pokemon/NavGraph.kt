package com.turingalan.pokemon

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.turingalan.pokemon.ui.Destination
import com.turingalan.pokemon.ui.detail.PokemonDetailScreen
import com.turingalan.pokemon.ui.list.PokemonListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val startDestination = Destination.List
    Scaffold(
        topBar =
            {
                TopAppBar(
                    title= {
                        Text(text = "Personajes Rainbow Six")
                    }
                )
            }
    ) { innerPadding ->
        val contentModifier = Modifier.consumeWindowInsets(innerPadding).padding()

        NavHost(
            navController = navController,
            startDestination = startDestination)
        {
            composable<Destination.List> {
                PokemonListScreen(modifier = contentModifier,
                    onShowDetail = {
                        id -> navController.navigate(Destination.Detail(id))
                    })
            }
            composable<Destination.Detail> {
                PokemonDetailScreen(
                    modifier = contentModifier,
                    name = "NAME",
                    artworkId = 1
                )
            }
        }
    }

}