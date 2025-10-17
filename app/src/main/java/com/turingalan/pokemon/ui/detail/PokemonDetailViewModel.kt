package com.turingalan.pokemon.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.turingalan.pokemon.data.repository.PokemonRepository
import javax.inject.Inject

data class DetailUiSate(
    val name:String,
    val artwork:Int,
)
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val pokemonRepository: PokemonRepository

): ViewModel() {

    init {

    }

}