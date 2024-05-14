package com.mehedi.mvvmcleanecomrestapi.data.repo

import com.mehedi.mvvmcleanecomrestapi.data.model.login.LoginResponse
import com.mehedi.mvvmcleanecomrestapi.data.model.login.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.data.model.login.ResponseLogin
import com.mehedi.mvvmcleanecomrestapi.data.network.PlatziService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PlatziRepository @Inject constructor(private val service: PlatziService) {


    suspend fun login(requestLogin: RequestLogin): Response<LoginResponse> {

        return service.login(requestLogin)

    }

}