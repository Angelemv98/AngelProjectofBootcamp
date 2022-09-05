package com.example.aplicationangel

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aplicationangel.databinding.FrgHomeBinding

class FrgHome : Fragment() {
    private lateinit var binding: FrgHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrgHomeBinding.bind(view)

        var sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("userName", "Angel")
        binding.tvWelcomeHome.text = "Bienvenido de nuevo: \n $user"

        binding.btnForo.setOnClickListener() {
            findNavController().navigate(R.id.to_frgForo)
        }
        binding.btnProfile.setOnClickListener() {
            findNavController().navigate(R.id.to_frgProfile)
        }
        binding.btnRecycler.setOnClickListener() {
            findNavController().navigate(R.id.to_frgContent)
        }
    }
}
