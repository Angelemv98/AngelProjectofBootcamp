package com.example.aplicationangel.dashAct.data.network

import com.example.aplicationangel.dashAct.data.model.InfoRequest
import com.example.aplicationangel.dashAct.data.model.InfoResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInfo {
    @GET(PathInfo.POSTDOMINION)
    suspend fun postdomin(@Path("user") user: String): InfoResponse
}
