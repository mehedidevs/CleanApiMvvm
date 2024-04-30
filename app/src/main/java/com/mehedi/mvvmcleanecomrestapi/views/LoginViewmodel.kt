package com.mehedi.mvvmcleanecomrestapi.views

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.mvvmcleanecomrestapi.data.model.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.data.repo.PlatziRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(private val repository: PlatziRepository) : ViewModel() {


    fun login(requestLogin: RequestLogin) {
        viewModelScope.launch {
            val response = repository.login(requestLogin)

            if (response.isSuccessful) {
                Log.d("TAG", "login: ${response.body()} ")
            }


        }


    }


}