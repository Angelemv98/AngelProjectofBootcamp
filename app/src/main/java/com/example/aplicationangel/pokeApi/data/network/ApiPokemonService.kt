package com.example.aplicationangel.pokeApi.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiPokemonService {
    // https://pokeapi.co        //HOST
    // /api/v2/pokemon/charizard?   //ENDPOINT
    // limit=1                      //Parametros
    @GET("/api/v2/pokemon?")
    suspend fun get(@Query("limit") limit: Int): com.example.aplicationangel.data.model.Response
}
