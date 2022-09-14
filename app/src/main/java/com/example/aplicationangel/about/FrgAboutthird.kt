package com.example.aplicationangel.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.aplicationangel.R
import com.example.aplicationangel.databinding.FrgAboutthirdBinding

class FrgAboutthird : Fragment() {
    private val argsfromB: FrgAboutthirdArgs by navArgs()
    private lateinit var binding: FrgAboutthirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgAboutthirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("Argumento 1 Integer: ${argsfromB.argFromBint}")
        println("Argumento 2 Boolean: ${argsfromB.argFromBboolean}")
        println("Argumento 3 String: ${argsfromB.argFromBstring}")
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnToFragmentA).setOnClickListener {
            findNavController().navigate(R.id.to_frgForo)
        }
    }
}
