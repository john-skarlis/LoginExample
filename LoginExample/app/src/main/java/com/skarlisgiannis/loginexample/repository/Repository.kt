package com.skarlisgiannis.loginexample.repository

import com.skarlisgiannis.loginexample.model.LoginPost
import com.skarlisgiannis.loginexample.model.LoginResponse
import com.skarlisgiannis.loginexample.network.RetroInstance
import retrofit2.Response

class Repository {
    suspend fun login(post: LoginPost) : Response<LoginResponse>{
        return RetroInstance.api.login(post)
    }
}