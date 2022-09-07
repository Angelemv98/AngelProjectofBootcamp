package com.example.aplicationangel.registerAct.data.model

import com.google.gson.annotations.SerializedName

class RegisterResponse(
    @SerializedName("status")
    val status: Boolean,

    @SerializedName("message")
    val message: String
)
