package com.mehedi.mvvmcleanecomrestapi.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mehedi.mvvmcleanecomrestapi.data.model.RequestLogin
import com.mehedi.mvvmcleanecomrestapi.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewmodel by viewModels<LoginViewmodel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val requestLogin = RequestLogin(
                email = "john@mail.com",
                password = "changeme"
            )


            viewmodel.login(requestLogin)


        }


    }
}