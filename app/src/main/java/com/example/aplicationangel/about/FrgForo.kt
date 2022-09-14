package com.example.aplicationangel.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aplicationangel.R
import com.example.aplicationangel.databinding.FrgForoBinding

class FrgForo : Fragment() {
    private lateinit var binding: FrgForoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgForoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnToFragmentB).setOnClickListener {
            var acttionWithParameters =
                FrgForoDirections.toAboutsecundary("Hola Estoy mandando este parametro desde A")
            findNavController().navigate(R.id.to_aboutsecundary)
        }
    }
}
