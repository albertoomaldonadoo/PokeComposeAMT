package com.turingalan.pokemon.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination (val route:String) {
    @Serializable
    data object  List:Destination("pokemon_list")
    @Serializable
    data class Detail(val id:Int):Destination(route="pokemon_detail")
}