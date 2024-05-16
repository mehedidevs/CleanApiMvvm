package com.mehedi.mvvmcleanecomrestapi.views.profile

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mehedi.mvvmcleanecomrestapi.base.BaseFragment
import com.mehedi.mvvmcleanecomrestapi.databinding.FragmentProfileBinding
import com.mehedi.mvvmcleanecomrestapi.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    
    val viewmodel by viewModels<ProfileViewmodel>()
    
    override fun setListener() {
        
        viewmodel.getProfile()
        
        
    }
    
    override fun allObserver() {
        
        lifecycleScope.launch {
            viewmodel.profileResponse.collect { state ->
                
                when (state) {
                    is DataState.Error -> {}
                    is DataState.Loading -> {}
                    is DataState.Success -> {
                        Log.d("TAG", "allObserver: ${state.data}")
                        
                    }
                }
                
                
            }
        }
        
        
    }
    
    
}