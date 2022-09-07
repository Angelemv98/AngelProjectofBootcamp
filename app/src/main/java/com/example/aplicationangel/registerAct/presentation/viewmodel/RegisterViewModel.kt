package com.example.aplicationangel.registerAct.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicationangel.LoginState
import com.example.aplicationangel.registerAct.data.model.RegisterRequest
import com.example.aplicationangel.registerAct.domain.usecase.RegisterUseCase
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private var registerUseCase = RegisterUseCase()

    private var _stateRegister: MutableLiveData<LoginState> = MutableLiveData()
    val stateRegister: LiveData<LoginState> get() = _stateRegister

    fun register(registerRequest: RegisterRequest) {
        // println("Ususario: ${registerRequest.user} Passoword: ${registerRequest.pass}")

        viewModelScope.launch {
            _stateRegister.postValue(LoginState.Cargando)
            val response = registerUseCase(registerRequest)

            Thread.sleep(2000)

            if (response.status) {
                _stateRegister.postValue(LoginState.Exitoso)
            } else {
                _stateRegister.postValue(LoginState.Error(response.message))
            }
        }
    }
}
