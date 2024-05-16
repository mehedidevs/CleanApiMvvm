package com.mehedi.mvvmcleanecomrestapi.di

import com.mehedi.mvvmcleanecomrestapi.data.network.PlatziSecuredService
import com.mehedi.mvvmcleanecomrestapi.data.network.PlatziService
import com.mehedi.mvvmcleanecomrestapi.utils.AuthInterceptor
import com.mehedi.mvvmcleanecomrestapi.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    
    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
    
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
    
    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit.Builder): PlatziService {
        return retrofit.build().create(PlatziService::class.java)
    }
    
    
    @Provides
    @Singleton
    fun providesSecuredService(
        okHttpClient: OkHttpClient,
        retrofit: Retrofit.Builder
    ): PlatziSecuredService {
        return retrofit.client(okHttpClient).build().create(PlatziSecuredService::class.java)
    }
    
    
}