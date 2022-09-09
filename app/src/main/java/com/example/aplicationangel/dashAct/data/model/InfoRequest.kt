package com.example.aplicationangel.dashAct.data.model

import com.google.gson.annotations.SerializedName

data class InfoRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("secondLastName")
    val secondLastName: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("phone")
    val phone: String
)
