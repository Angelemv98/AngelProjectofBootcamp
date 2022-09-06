package com.example.aplicationangel.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicationangel.LoginState
import com.example.aplicationangel.data.model.LoginRequest
import com.example.aplicationangel.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val loginUseCase = LoginUseCase()

    private var _stateLogin: MutableLiveData<LoginState> = MutableLiveData()
    val stateLogin: LiveData<LoginState> get() = _stateLogin

    fun login(loginRequest: LoginRequest) {
        println("Ususario: ${loginRequest.user} Passoword: ${loginRequest.pass}")

        viewModelScope.launch {
            _stateLogin.postValue(LoginState.Cargando)
            val response = loginUseCase(loginRequest)

            Thread.sleep(2000)

            if (response.status) {
                _stateLogin.postValue(LoginState.Exitoso)
            } else {
                _stateLogin.postValue(LoginState.Error(response.message))
            }
        }
    }
}
