package com.mehedi.mvvmcleanecomrestapi.data.network

import com.mehedi.mvvmcleanecomrestapi.data.model.user.ResponseUser
import com.mehedi.mvvmcleanecomrestapi.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface PlatziSecuredService {
    
    @GET(Constants.PROFILE)
    suspend fun getProfile(): Response<ResponseUser>
    
}