package com.example.aplicationangel

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aplicationangel.databinding.FrgProfileBinding

class FrgProfile : Fragment() {
    private lateinit var binding: FrgProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FrgProfileBinding.bind(view)

        var sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("userName", "")
        val pass = sharedPreferences.getString("userPassword", "")
        binding.tvUserNameProfile.text = "$user"
        binding.tvPasswordProfile.text = "$pass"
    }
}
