package com.example.aplicationangel.pokeApi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicationangel.databinding.PokeApiBinding
import com.example.aplicationangel.pokeApi.adapter.AdapterAngelChat
import com.example.aplicationangel.pokeApi.data.network.RetrofitPokeApi
import com.example.aplicationangel.pokeApi.model.Chat
import com.example.aplicationangel.pokeApi.model.Typechat
import kotlinx.coroutines.launch

class PokeApi : Fragment() {
    private lateinit var binding: PokeApiBinding
    private var adapter: AdapterAngelChat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokeApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun createChat(typechat: Typechat, message: String, date: String): Chat {
        return Chat(typechat, message, date)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.rvPoke.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            val response = RetrofitPokeApi.api().get(200)
            var pokenList = mutableListOf<Chat>()
            response.listPokemon.forEach {
                pokenList.add(Chat(Typechat.MESSAGE_SENT, message = "${it.name}", date = ""))
            }
            adapter = AdapterAngelChat(pokenList)
            binding.rvPoke.adapter = adapter
        }
    }
}
