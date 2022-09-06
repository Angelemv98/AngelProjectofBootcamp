package com.example.aplicationangel

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicationangel.data.model.LoginRequest
import com.example.aplicationangel.databinding.ActivityMainBinding
import com.example.aplicationangel.presentation.viewmodel.MainViewModel
import com.example.aplicationangel.registerAct.RegisterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (checkisValid()) {
                viewModel.login(
                    LoginRequest(
                        binding.etUser.text.toString(),
                        binding.etPassword.text.toString()
                    )
                )
            }
        }
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        viewModel.stateLogin.observe(this) {
            when (it) {
                is LoginState.Cargando -> {
                    println("Api cargando")
                }
                is LoginState.Exitoso -> {
                    println("Api exitoso")
                }
                is LoginState.Error -> {
                    println("${it.message}")
                }
            }
        }
    }

    private fun checkisValid() =
        binding.etUser.text.toString().isNotEmpty() && binding.etPassword.text.toString()
            .isNotEmpty()
}
