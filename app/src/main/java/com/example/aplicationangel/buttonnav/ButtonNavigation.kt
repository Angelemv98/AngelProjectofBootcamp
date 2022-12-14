package com.example.aplicationangel.buttonnav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.aplicationangel.R
import com.example.aplicationangel.databinding.ButtonNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ButtonNavigation : AppCompatActivity() {
    private lateinit var binding: ButtonNavigationBinding
    private lateinit var botomnavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ButtonNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botomnavigation = binding.bottomNavigation
        changefragment(HomeFragment())
        botomnavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> changefragment(HomeFragment())
                R.id.item_notification -> changefragment(NotifiactionFragment())
                R.id.item_perfil -> changefragment(ProfileFragment())
                else -> {
                    changefragment(HomeFragment())
                }
            }
            true
        }
    }

    fun changefragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaccion: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaccion.replace(R.id.container, fragment)
        fragmentTransaccion.commit()
    }
}
