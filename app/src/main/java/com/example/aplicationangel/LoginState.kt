package com.example.aplicationangel

enum class TypeRerror {
    USUARIO_CONTRASENA,
    INTERNET,
    SERVER
}

data class CustomError(
    val mensaje: String,
    val code: Int,
    val type: TypeRerror
)

sealed class LoginState {
    object Cargando : LoginState()
    object Exitoso : LoginState()

    data class Error(val message: String) : LoginState()
}
