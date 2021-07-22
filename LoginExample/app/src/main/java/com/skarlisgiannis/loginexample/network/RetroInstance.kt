package com.skarlisgiannis.loginexample.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {

        private const val BASE_URL = "https://reqres.in/"

        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api : RetroService by lazy {
            retrofit.create(RetroService::class.java)
        }
    }


}