package com.mehedi.mvvmcleanecomrestapi.views.login

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.mvvmcleanecomrestapi.R
import com.mehedi.mvvmcleanecomrestapi.base.BaseFragment
import com.mehedi.mvvmcleanecomrestapi.data.model.login.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.data.prefs.PrefsManager
import com.mehedi.mvvmcleanecomrestapi.databinding.FragmentLoginBinding
import com.mehedi.mvvmcleanecomrestapi.utils.DataState
import com.mehedi.mvvmcleanecomrestapi.views.LoginViewmodel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    
    private val viewmodel: LoginViewmodel by viewModels()
    
    @Inject
    lateinit var prefsManager: PrefsManager
    
    
    override fun setListener() {
        binding.loginBtn.setOnClickListener {
            
            val email = binding.userEmail.text.toString()
            val password = binding.password.text.toString()
            
            
            // handleLogin(email, password)
            handleLogin("john@mail.com", "changeme")
            
        }
        
        
        binding.registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        
    }
    
    override fun allObserver() {
        viewmodel.loginResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is DataState.Error -> {
                    loading.dismiss()
                }
                
                is DataState.Loading -> {
                    loading.show()
                }
                
                is DataState.Success -> {
                    loading.dismiss()
                    prefsManager.setPrefs(ACCESS_TOKEN, "${response.data?.accessToken}")
                    prefsManager.setPrefs(REFRESH_TOKEN, "${response.data?.refreshToken}")
                    
                    Log.d("TAG", "accessToken: ${prefsManager.getPrefs(ACCESS_TOKEN)}")
                    Log.d("TAG", "refreshToken: ${prefsManager.getPrefs(REFRESH_TOKEN)}")
                    
                    findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
                    
                }
            }
            
        }
    }
    
    
    private fun handleLogin(email: String, password: String) {
        
        val requestLogin = RequestLogin(email = email, password = password)
        
        viewmodel.login(requestLogin)
        
        
    }
    
    
    companion object {
        const val ACCESS_TOKEN = "accessToken"
        const val REFRESH_TOKEN = "refreshToken"
        
        
    }
    
}