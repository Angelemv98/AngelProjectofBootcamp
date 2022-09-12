package com.example.aplicationangel.data.network

import com.example.aplicationangel.data.model.LoginRequest
import com.example.aplicationangel.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiLoginService {
    // https://pokeapi.co        //HOST
    // /api/v2/pokemon/charizard?   //ENDPOINT
    // limit=1                      //Parametros

    @POST(Path.POSTDOMINION)
    suspend fun postdomin(@Body loginRequest: LoginRequest): LoginResponse
}
