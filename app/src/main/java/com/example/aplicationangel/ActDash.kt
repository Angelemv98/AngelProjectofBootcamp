package com.example.aplicationangel

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActDash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_dash)

        // Obtencion de datos de put extra
        var bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val password = bundle?.getString("password")

        // Seteo de esos datos a un sp
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.putString("userName", name)
        editor.putString("userPassword", password)
        editor.apply()
    }
}
