package com.example.aplicationangel.dashAct

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

sealed class InfoState {
    object Cargando : InfoState()
    object Exitoso : InfoState()

    data class Error(val message: String) : InfoState()
}
