package com.skarlisgiannis.loginexample.network

import com.skarlisgiannis.loginexample.model.LoginPost
import com.skarlisgiannis.loginexample.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetroService {

    @POST("api/login")
    suspend fun login(
        @Body post: LoginPost
    ): Response<LoginResponse>
}