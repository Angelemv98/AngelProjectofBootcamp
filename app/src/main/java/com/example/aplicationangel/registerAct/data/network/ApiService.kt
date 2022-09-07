package com.example.aplicationangel.registerAct.data.network


import com.example.aplicationangel.registerAct.data.model.RegisterRequest
import com.example.aplicationangel.registerAct.data.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    // https://pokeapi.co        //HOST
    // /api/v2/pokemon/charizard?   //ENDPOINT
    // limit=1                      //Parametros

    @POST(Path.POSTDOMINION)
    suspend fun postdomin(@Body registerRequest: RegisterRequest): RegisterResponse
}
