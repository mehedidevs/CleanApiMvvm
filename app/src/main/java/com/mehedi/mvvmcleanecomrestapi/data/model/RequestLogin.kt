package com.mehedi.mvvmcleanecomrestapi.data.model


import androidx.annotation.Keep

@Keep
data class RequestLogin(
    val email: String? = null,
    val password: String? = null
)