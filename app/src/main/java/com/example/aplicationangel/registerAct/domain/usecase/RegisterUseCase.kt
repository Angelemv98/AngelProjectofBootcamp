package com.example.aplicationangel.registerAct.domain.usecase

import com.example.aplicationangel.registerAct.data.model.RegisterRequest
import com.example.aplicationangel.registerAct.data.model.RegisterResponse
import com.example.aplicationangel.registerAct.domain.repository.RegisterRepository

class RegisterUseCase {
    private val registerRepository = RegisterRepository()
    suspend operator fun invoke(registerRequest: RegisterRequest): RegisterResponse {
        return registerRepository.register(registerRequest)
    }
}
