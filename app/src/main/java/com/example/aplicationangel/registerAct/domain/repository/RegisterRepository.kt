package com.example.aplicationangel.registerAct.domain.repository

import com.example.aplicationangel.registerAct.data.model.RegisterRequest
import com.example.aplicationangel.registerAct.data.model.RegisterResponse
import com.example.aplicationangel.registerAct.data.network.RetrofitClientPokemon

class RegisterRepository {
    var wifi = true
    suspend fun register(registerRequest: RegisterRequest): RegisterResponse {
        return if (wifi) {
            RetrofitClientPokemon.api().postdomin(registerRequest)
        } else {
            RegisterResponse(
                false,
                "Connection Failed"
            )
        }
    }
}
