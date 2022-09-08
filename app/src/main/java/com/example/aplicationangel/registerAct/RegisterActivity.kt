package com.example.aplicationangel.registerAct

import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aplicationangel.DatePickerAlert
import com.example.aplicationangel.R
import com.example.aplicationangel.databinding.ActivityRegisterBinding
import com.example.aplicationangel.registerAct.local.room.DataBase
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
            if (validaciones() == true) {
                lifecycleScope.launch {
                    val database =
                        DataBase(this@RegisterActivity)
                            .getDB()
                    database.daoUserptll().insertUser(
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
                    val users = database.daoUserptll().getUSer()
                    println(users)
                }
                Toast.makeText(this, "Usuario ingresado", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Revisa tus errores", Toast.LENGTH_LONG).show()
            }
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

    fun validaciones(): Boolean {
        var flag = true
        flag = emailFocusListener()
        flag = textNameFocusListener()
        flag = textSurName()
        flag = textSecodnSurNameSurName()
        flag = birthtdayListener()
        flag = sexoListener()
        flag = stateLsitener()
        flag = phoneListener()
        flag = userNameListener()
        flag = passwordListener()
        flag = passwordSecondListener()
        flag = passwordmatch()
        return flag
    }

    private fun passwordmatch(): Boolean {
        var flag: Boolean
        if (binding.etAngelPassword.text.toString() == binding.etAngelConfirmPassword.text.toString()) {
            flag = true
        } else {
            binding.inputAngelPassword.helperText = "Las contraseñas deben coincidir"
            binding.inputAngelConfirmPassword.helperText = "Las contraseñas deben coincidir"
            flag = false
        }
        return flag
    }

    fun textNameFocusListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validNombre()
                binding.inputAngelName.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validNombre(): String? {
        val nameText = binding.etAngelName.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun textSurName(): Boolean {
        var flag: Boolean = true
        binding.etAngelSurname.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validSurname()
                binding.inputAngelSurname.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validSurname(): String? {
        val nameText = binding.etAngelSurname.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun textSecodnSurNameSurName(): Boolean {
        var flag: Boolean = true
        binding.etAngelSecondSurname.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validSecondSurname()
                binding.inputAngelSecondSurname.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validSecondSurname(): String? {
        val nameText = binding.etAngelSecondSurname.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun birthtdayListener(): Boolean {
        var flag: Boolean = true
        if (binding.etAngelBirthday.text.toString().isEmpty()) {
            flag = false
            binding.inputAngelBirhtday.error = "No dejar campo vacio"
        } else {
            binding.inputAngelBirhtday.error = null
        }
        return flag
    }

    private fun sexoListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelGender.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validGender()
                binding.inputAngelGender.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validGender(): String? {
        val nameText = binding.etAngelGender.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    fun emailFocusListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validEmail()
                binding.inputAngelEmail.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validEmail(): String? {
        val emailText = binding.etAngelEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Correo invalido"
        }
        return null
    }

    private fun stateLsitener(): Boolean {
        var flag: Boolean = true
        binding.etAngelPlace.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validState()
                binding.inputAngelPlace.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validState(): String? {
        val nameText = binding.etAngelPlace.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun phoneListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelPhone.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validhone()
                binding.inputAngelPhone.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validhone(): String? {
        val nameText = binding.etAngelPhone.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun userNameListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelUserName.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validUserName()
                binding.inputUserName.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validUserName(): String? {
        val nameText = binding.etAngelUserName.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun passwordListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validPassword()
                binding.inputAngelPassword.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validPassword(): String? {
        val nameText = binding.etAngelPassword.text.toString()
        if (nameText.isEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }

    private fun passwordSecondListener(): Boolean {
        var flag: Boolean = true
        binding.etAngelConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                val message = validSencondPass()
                binding.inputAngelConfirmPassword.helperText = message
                if (message != null) {
                    flag = false
                }
            }
        }
        return flag
    }

    private fun validSencondPass(): String? {
        val nameText = binding.etAngelSecondSurname.text.toString()
        if (nameText.isNotEmpty()) {
            return "No dejes este campo vacio"
        }
        return null
    }
}
