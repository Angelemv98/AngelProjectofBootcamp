package com.example.aplicationangel.registerAct

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicationangel.DatePickerAlert
import com.example.aplicationangel.R
import com.example.aplicationangel.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listas()
    }

    fun listas() {
        binding.etAngelGender.setAdapter(
            ArrayAdapter(this, R.layout.item_options, resources.getStringArray(R.array.genero))
        )
        binding.etAngelPlace.setAdapter(
            ArrayAdapter(this, R.layout.item_options, resources.getStringArray(R.array.estados))
        )
        binding.etAngelBirthday.setOnClickListener() {
            DatePickerAlert(this).show(binding.etAngelBirthday)
        }
    }

    fun validaciones() {
        val nombre = binding.etAngelName.text.toString()
        val apellidoPaterno = binding.etAngelSurname.text.toString()
        val apellidoMaterno = binding.etAngelSecondSurname.text.toString()
        val cumple = binding.etAngelBirthday.text.toString()
        val genero = binding.etAngelGender.text.toString()
        val email = binding.etAngelEmail.text.toString()
        val estado = binding.etAngelPlace.text.toString()
        val telefono = binding.etAngelPhone.text.toString()
        val nombreUsuario = binding.etAngelUserName.text.toString()
        val pass = binding.etAngelPassword.text.toString()
        val passconf = binding.etAngelConfirmPassword.text.toString()
        if (nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || cumple.isEmpty() || genero.isEmpty() || email.isEmpty() || estado.isEmpty()
            || telefono.isEmpty() || nombreUsuario.isEmpty()
        ) {
        }
        while (nombre.isEmpty()) do {
            binding.etAngelName.error = "Dejaste el campo vacio"
        } break

    }
}
