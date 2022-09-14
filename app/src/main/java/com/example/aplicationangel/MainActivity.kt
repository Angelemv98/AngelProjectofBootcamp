package com.example.aplicationangel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicationangel.dashAct.ActDash
import com.example.aplicationangel.data.model.LoginRequest
import com.example.aplicationangel.databinding.ActivityMainBinding
import com.example.aplicationangel.presentation.viewmodel.MainViewModel
import com.example.aplicationangel.registerAct.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()

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
                val nameLog: String = binding.etUser.text.toString().trim()
                val passLog: String = binding.etPassword.text.toString().trim()

                val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                var editor = sharedPreference.edit()
                editor.putString("userName", nameLog)
                editor.putString("userPassword", passLog)
                editor.apply()
            }
            /*lifecycleScope.launch {
                val database = DataBase(this@MainActivity).getDB()
                database.daoUser().deleteUSer()
                database.daoUser().insertUser(
                    UserEntity(
                        "Root",
                        "Angel",
                        "Morales",
                        "angel123"
                    )
                )
                val users = database.daoUser().getUSer()
                println(users)
            }*/
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
                    val intent = Intent(this, ActDash::class.java)
                    startActivity(intent)
                }
                is LoginState.Error -> {
                    Toast.makeText(this@MainActivity, "Something went wrong", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    private fun checkisValid() =
        binding.etUser.text.toString().isNotEmpty() && binding.etPassword.text.toString()
            .isNotEmpty()
}
