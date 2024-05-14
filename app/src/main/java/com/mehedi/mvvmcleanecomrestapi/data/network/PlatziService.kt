package com.mehedi.mvvmcleanecomrestapi.data.network

import com.mehedi.mvvmcleanecomrestapi.data.model.login.LoginResponse
import com.mehedi.mvvmcleanecomrestapi.data.model.login.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.data.model.login.ResponseLogin
import com.mehedi.mvvmcleanecomrestapi.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PlatziService {

    @POST(Constants.LOGIN)
    suspend fun login(@Body requestLogin: RequestLogin): Response<LoginResponse>


}