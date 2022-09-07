package com.example.aplicationangel.registerAct

import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aplicationangel.DatePickerAlert
import com.example.aplicationangel.LoginState
import com.example.aplicationangel.R
import com.example.aplicationangel.data.local.room.DataBase
import com.example.aplicationangel.databinding.ActivityRegisterBinding
import com.example.aplicationangel.registerAct.local.room.entity.UserParadigms
import com.example.aplicationangel.registerAct.presentation.viewmodel.RegisterViewModel
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listas()
        validaciones()
        binding.btnAngelSave.setOnClickListener {
            /* CON API
            viewModel.register(
                 RegisterRequest(
                     binding.etAngelUserName.text.toString(),
                     binding.etAngelName.text.toString(),
                     binding.etAngelSurname.text.toString(),
                     binding.etAngelSecondSurname.text.toString(),
                     binding.etAngelBirthday.text.toString(),
                     binding.etAngelEmail.text.toString(),
                     binding.etAngelGender.text.toString(),
                     binding.etAngelPlace.text.toString(),
                     binding.etAngelPhone.text.toString(),
                     binding.etAngelPassword.text.toString(),
                     "Solero"
                 )
             )
            DATABASE INTERNA
            lifecycleScope.launch {
                val database =
                    com.example.aplicationangel.registerAct.local.room.DataBase(this@RegisterActivity)
                        .getDB()
                database.daoUser().deleteUSer()
                database.daoUser().insertUser(
                    UserParadigms(
                        binding.etAngelUserName.text.toString(),
                        binding.etAngelName.text.toString(),
                        binding.etAngelSurname.text.toString(),
                        binding.etAngelSecondSurname.text.toString(),
                        binding.etAngelBirthday.text.toString(),
                        binding.etAngelBirthday.text.toString(),
                        binding.etAngelGender.text.toString(),
                        binding.etAngelPlace.text.toString(),
                        binding.etAngelPhone.text.toString(),
                        binding.etAngelPassword.text.toString(),
                        "Soltero"
                    )
                )
                val users = database.daoUser().getUSer()
                println(users)
            }
        }
        viewModel.stateRegister.observe(this) {
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
            }*/
        }
    }

    fun listas() {
        binding.etAngelGender.setAdapter(
            ArrayAdapter(this, R.layout.item_options, resources.getStringArray(R.array.genero))
        )
        binding.etAngelPlace.setAdapter(
            ArrayAdapter(this, R.layout.item_options, resources.getStringArray(R.array.estados))
        )
        binding.etAngelBirthday.setOnClickListener() {
            DatePickerAlert(this).show(binding.etAngelBirthday, binding.inputAngelBirhtday)
        }
    }

    fun validaciones() {
        emailFocusListener()
        textNameFocusListener()
        textSurName()
        textSecodnSurNameSurName()
        birthtdayListener()
        sexoListener()
        stateLsitener()
        phoneListener()
        userNameListener()
        passwordListener()
        passwordSecondListener()
    }

    private fun passwordSecondListener() {
        binding.etAngelConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelConfirmPassword.helperText = validSencondPass()
            }
        }
    }
    private fun validSencondPass(): String? {
        val nameText = binding.etAngelSecondSurname.text.toString()
        if (nameText.isNotEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun textNameFocusListener() {
        binding.etAngelName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelName.helperText = validNombre()
            }
        }
    }

    private fun validNombre(): String? {
        val nameText = binding.etAngelName.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun textSurName() {
        binding.etAngelSurname.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelSurname.helperText = validSurname()
            }
        }
    }

    private fun validSurname(): String? {
        val nameText = binding.etAngelSurname.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun textSecodnSurNameSurName() {
        binding.etAngelSecondSurname.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelSecondSurname.helperText = validSecondSurname()
            }
        }
    }

    private fun validSecondSurname(): String? {
        val nameText = binding.etAngelSecondSurname.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun birthtdayListener() {
        if (binding.etAngelBirthday.text.toString().isEmpty()) {
            binding.inputAngelBirhtday.error = "No dejar campo vacio"
        } else {
            binding.inputAngelBirhtday.error = null
        }
    }


    private fun sexoListener() {
        binding.etAngelGender.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelGender.helperText = validGender()
            }
        }
    }

    private fun validGender(): String? {
        val nameText = binding.etAngelGender.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun emailFocusListener() {
        binding.etAngelEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelEmail.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.etAngelEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Correo invalido"
        }
        return null
    }

    private fun stateLsitener() {
        binding.etAngelPlace.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelPlace.helperText = validState()
            }
        }
    }

    private fun validState(): String? {
        val nameText = binding.etAngelPlace.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun phoneListener() {
        binding.etAngelPhone.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelPhone.helperText = validhone()
            }
        }
    }

    private fun validhone(): String? {
        val nameText = binding.etAngelPhone.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun userNameListener() {
        binding.etAngelUserName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputUserName.helperText = validUserName()
            }
        }
    }

    private fun validUserName(): String? {
        val nameText = binding.etAngelUserName.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun passwordListener() {
        binding.etAngelPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.inputAngelPassword.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val nameText = binding.etAngelPassword.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }
}
