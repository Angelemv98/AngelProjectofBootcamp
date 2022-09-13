package com.example.aplicationangel.pokeApi.model

enum class Typechat(val value: Int) {
    MESSAGE_SENT(0)
}

data class Chat(
    val type: Typechat,
    val message: String,
    var isChecked: Boolean
)
