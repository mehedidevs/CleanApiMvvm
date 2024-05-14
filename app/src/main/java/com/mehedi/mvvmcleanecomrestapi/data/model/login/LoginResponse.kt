package com.mehedi.mvvmcleanecomrestapi.data.model.login


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("refresh_token")
    val refreshToken: String? = null
)