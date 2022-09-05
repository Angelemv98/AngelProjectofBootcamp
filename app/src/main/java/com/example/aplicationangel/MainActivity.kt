package com.example.aplicationangel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicationangel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// Modelo
        val name = "Angelemv"
        val password = "cande0202"

        val buttonlogin = findViewById<Button>(R.id.btnLogin)

        buttonlogin.setOnClickListener {
            val editTextname = binding.etUser.text.toString()
            val edittextpassword = binding.etPassword.text.toString()
            if (editTextname == name && edittextpassword == password) {
                intent = Intent(this, ActDash::class.java)
                intent.putExtra("name", name)
                intent.putExtra("password", password)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Ingreso incorrecto", Toast.LENGTH_LONG).show()
            }
        }
    }
}
