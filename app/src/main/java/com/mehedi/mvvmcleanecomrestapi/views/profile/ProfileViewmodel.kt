package com.mehedi.mvvmcleanecomrestapi.views.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.mvvmcleanecomrestapi.data.model.user.ResponseUser
import com.mehedi.mvvmcleanecomrestapi.data.repo.PlatziRepository
import com.mehedi.mvvmcleanecomrestapi.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewmodel @Inject constructor(private val repository: PlatziRepository) : ViewModel() {
    
    
    private val _profileResponse = MutableStateFlow<DataState<ResponseUser>>(DataState.Loading())
    val profileResponse: StateFlow<DataState<ResponseUser>>
        get() = _profileResponse
    
    fun getProfile() {
        viewModelScope.launch {
            val response = repository.getProfile()
            
            if (response.isSuccessful) {
                
                _profileResponse.emit(DataState.Success(response.body()))
            } else {
                _profileResponse.emit(DataState.Error(response.message()))
            }
            
            
        }
        
        
    }
    
    
}


