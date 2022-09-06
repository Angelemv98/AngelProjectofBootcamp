package com.example.aplicationangel.domain.usecase

import com.example.aplicationangel.data.model.LoginRequest
import com.example.aplicationangel.data.model.LoginResponse
import com.example.aplicationangel.domain.repositry.LoginRepository

class LoginUseCase {
    private val loginRepository = LoginRepository()
    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse {
        return loginRepository.login(loginRequest)
    }
}
