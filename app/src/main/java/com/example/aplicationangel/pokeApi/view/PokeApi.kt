package com.example.aplicationangel.pokeApi.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicationangel.R
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

    private fun createChat(typechat: Typechat, message: String, isChecked: Boolean): Chat {
        return Chat(typechat, message, isChecked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.rvPoke.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            val response = RetrofitPokeApi.api().get(1000)
            var pokenList = mutableListOf<Chat>()
            response.listPokemon.forEach {
                pokenList.add(
                    Chat(
                        Typechat.MESSAGE_SENT,
                        message = "${it.name}",
                        isChecked = false
                    )
                )
            }
            adapter = AdapterAngelChat(pokenList)
            binding.rvPoke.adapter = adapter
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.recyclermenusearch, menu)
        val search = menu.findItem(R.id.actionAmSearch)
        val searchView = search.actionView as SearchView
        searchView.queryHint = "Buscar..."

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                println("$newText")
                adapter?.filter?.filter(newText)
                return true
            }
        })
    }
}
