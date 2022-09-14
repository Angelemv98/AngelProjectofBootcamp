package com.example.aplicationangel.domain.repositry

import com.example.aplicationangel.data.model.LoginRequest
import com.example.aplicationangel.data.model.LoginResponse
import com.example.aplicationangel.data.network.RetrofitClientPokemon
import javax.inject.Inject

class LoginRepository @Inject constructor() {
    var wifi = true
    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        return if (wifi) {
            RetrofitClientPokemon.api().postdomin(loginRequest)
        } else {
            LoginResponse(
                false,
                "Connection Failed"
            )
        }
    }
}
