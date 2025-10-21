package com.turingalan.pokemon.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.turingalan.pokemon.data.model.Pokemon
import com.turingalan.pokemon.data.repository.PokemonRepository
import com.turingalan.pokemon.ui.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class DetailUiSate(
    val name:String = "",
    val artworkID:Int? = null,
)
@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val pokemonRepository: PokemonRepository

): ViewModel() {
    private val _uiState: MutableStateFlow<DetailUiSate> =
        MutableStateFlow(DetailUiSate())
    val uiState: StateFlow<DetailUiSate>
        get() = _uiState.asStateFlow()
    init {
        val route = savedStateHandle.toRoute<Destination.Detail>()
        val pokemonID = route.id
        val pokemon = pokemonRepository.readOne(pokemonID)

        pokemon?.let{
            _uiState.value = pokemon.toDetailUserState()
        }
    }

}

fun Pokemon.toDetailUserState(): DetailUiSate = DetailUiSate(
    name = this.name,
    artworkID = this.artworkId
)