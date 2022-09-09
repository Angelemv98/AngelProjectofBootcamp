package com.example.aplicationangel.dashAct.data.model

import com.example.aplicationangel.registerAct.local.room.dao.UserDaoPtll
import com.example.aplicationangel.registerAct.local.room.entity.UserParadigms
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("lastname")
    val lastName: String = "",
    @SerializedName("secondLastName")
    val secondLastName: String = "",
    @SerializedName("birthday")
    val birthday: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("state")
    val state: String = "",
    @SerializedName("phone")
    val phone: String = ""
)

data class InfoResponse(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("user")
    val user: User
)

fun UserParadigms.toUser(): User =
    User(name, lastName, secondLastName, birthday, email, gender, state, phone)

