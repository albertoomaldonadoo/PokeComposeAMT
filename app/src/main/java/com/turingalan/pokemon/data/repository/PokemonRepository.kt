package com.turingalan.pokemon.data.repository

import com.turingalan.pokemon.data.model.Pokemon

interface PokemonRepository {

    fun readOne(id: Int): Pokemon?
    fun readAll():List<Pokemon>
}