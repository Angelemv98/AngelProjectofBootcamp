package com.example.aplicationangel.data.network

import com.example.aplicationangel.pokeApi.data.network.ApiPokemonService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientPokemon {

    private const val connectionTimeOut = 20L
    private const val readTiemOut = 20L
    private const val writeTimeOut = 20L
    fun api(): ApiLoginService {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.addInterceptor(interceptor)

            Retrofit.Builder().baseUrl(Path.baseUrl)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit.build().create(ApiLoginService::class.java)
    }
}
