package com.example.aplicationangel.profilefrg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aplicationangel.R
import com.example.aplicationangel.dashAct.presentation.viewmodel.ActDashViewModel
import com.example.aplicationangel.databinding.FrgProfileBinding

class FrgProfile : Fragment() {
    private lateinit var binding: FrgProfileBinding
    private lateinit var viewModel: ActDashViewModel

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

        viewModel = requireActivity().run {
            ViewModelProvider(this)[ActDashViewModel::class.java]
        }

        var sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val userflogin = sharedPreferences.getString("userName", "")
        val userfromlogin: String = userflogin.toString()
        binding.tvUserNameProfile.text = userfromlogin

        viewModel.perfilData("Angelemv98", requireContext())
        viewModel.stateInfo.observe(viewLifecycleOwner) {
            var nombre = it.name
            var email = it.email
            binding.tvnameUser.text = nombre
            binding.tvEmailprof.text = email
            println("GOD ${it.name} ${it.birthday}")
        }
    }
}
