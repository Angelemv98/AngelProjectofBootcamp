package com.example.aplicationangel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import com.example.aplicationangel.databinding.ActivityActDashBinding
import com.google.android.material.navigation.NavigationView

class ActDash : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityActDashBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActDashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigationView()
        setDrawerLayout()
    }

    private fun setNavigationView() {
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val viewHeader: View =
            LayoutInflater.from(this).inflate(R.layout.layout_dash_header, navigationView, false)
        navigationView.addHeaderView(viewHeader)
    }

    private fun setDrawerLayout() {
        setSupportActionBar(binding.topAppBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        actionBarDrawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_profile -> {
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.frgProfile)
            }
            R.id.menu_recycler -> {
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.frgContent)
            }
            R.id.menu_about -> {
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.frgForo)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
