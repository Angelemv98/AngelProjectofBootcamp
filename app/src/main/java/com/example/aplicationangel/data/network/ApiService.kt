package com.example.aplicationangel.data.network

import com.example.aplicationangel.data.model.Request

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // https://pokeapi.co        //HOST
    // /api/v2/pokemon/charizard?   //ENDPOINT
    // limit=1                      //Parametros

    @GET("/api/v2/pokemon/charizard?")
    suspend fun get(@Query("limit") limit: Int): Request
}
