package com.example.aplicationangel.data.model

import com.google.gson.annotations.SerializedName

class LoginResponse (
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String
)