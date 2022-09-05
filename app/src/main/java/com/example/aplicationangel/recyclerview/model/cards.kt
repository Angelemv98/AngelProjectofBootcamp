package com.example.aplicationangel.recyclerview.model // ktlint-disable filename

enum class KindOfCard(val value: Int) {
    FIRST(1),
    SECOND(2)
}

data class Card(
    val type: KindOfCard,
    val message: String
)
