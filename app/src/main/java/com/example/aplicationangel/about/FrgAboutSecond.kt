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
import com.example.aplicationangel.databinding.FrgaboutsecundaryBinding

class FrgAboutSecond : Fragment() {
    private lateinit var binding: FrgaboutsecundaryBinding
    private val args: FrgAboutSecondArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgaboutsecundaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Argumento: 1: ${args.argFromA}")

        view.findViewById<Button>(R.id.btnToFragmentC).setOnClickListener {
            var params =
                FrgAboutSecondDirections.toFrgAboutthird(23, true, "Desde fragmento B")
            findNavController().navigate(R.id.to_frgAboutthird)
        }
    }
}
