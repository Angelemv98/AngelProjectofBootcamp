package com.example.aplicationangel.data.model

import com.google.gson.annotations.SerializedName

data class Species(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class GameIndices(
    @SerializedName("game_index")
    var game_index: Int,
    @SerializedName("version")
    var version: version
)

data class version(
    @SerializedName("name")
    var name: String
)

data class Moves(
    @SerializedName("version_group_details")
    var version_group_details: List<move_learn_method>
)

data class move_learn_method(
    @SerializedName("move_learn_method")
    var moveLearnMethod: Species
)

data class Request(
    // Lo que viene entre llaves tipo de dato
    // entre corchetes lista de datos o objetos simples
    @SerializedName("id")
    var id: Int,

    @SerializedName
    ("weight")
    var weight: Int,

    @SerializedName("species")
    var species: Species,

    @SerializedName("forms")
    var forms: List<Species>,

    @SerializedName("name")
    var name: String,

    @SerializedName("game_indices")
    var game_indices: List<GameIndices>,

    @SerializedName("moves")
    var moves: List<Moves>

    // game_indices->version->name
    // moves->version_group_details->move_learn_method->name
)
