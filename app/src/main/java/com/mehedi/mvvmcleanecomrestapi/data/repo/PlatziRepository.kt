package com.mehedi.mvvmcleanecomrestapi.data.repo

import com.mehedi.mvvmcleanecomrestapi.data.model.login.LoginResponse
import com.mehedi.mvvmcleanecomrestapi.data.model.login.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.data.model.user.ResponseUser
import com.mehedi.mvvmcleanecomrestapi.data.network.PlatziSecuredService
import com.mehedi.mvvmcleanecomrestapi.data.network.PlatziService
import retrofit2.Response
import javax.inject.Inject

class PlatziRepository @Inject constructor(
    private val service: PlatziService,
    private val securedService: PlatziSecuredService
) {
    
    
    suspend fun login(requestLogin: RequestLogin): Response<LoginResponse> {
        
        return service.login(requestLogin)
        
    }
    
    
    suspend fun getProfile(): Response<ResponseUser> {
        return securedService.getProfile()
    }
    
}