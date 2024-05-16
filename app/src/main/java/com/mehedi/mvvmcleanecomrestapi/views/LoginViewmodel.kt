package com.mehedi.mvvmcleanecomrestapi.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.mvvmcleanecomrestapi.data.model.login.LoginResponse
import com.mehedi.mvvmcleanecomrestapi.data.model.login.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.data.repo.PlatziRepository
import com.mehedi.mvvmcleanecomrestapi.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(private val repository: PlatziRepository) : ViewModel() {
    
    private val _loginResponse = MutableLiveData<DataState<LoginResponse>>()
    
    val loginResponse: LiveData<DataState<LoginResponse>>
        get() = _loginResponse
    
    
    fun login(requestLogin: RequestLogin) {
        _loginResponse.postValue(DataState.Loading())
        
        viewModelScope.launch {
            val response = repository.login(requestLogin).body()
            
            Log.d("TAG", "login: ${response?.accessToken} ")
            
            try {
                _loginResponse.postValue(DataState.Success(response))
            } catch (e: Exception) {
                _loginResponse.postValue(DataState.Error(e.message))
            }
            
        }
        
        
    }
    
    
}


