package com.example.aplicationangel.recyclerview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicationangel.R
import com.example.aplicationangel.databinding.FrgContentBinding
import com.example.aplicationangel.recyclerview.adapter.AdapterRecycler
import com.example.aplicationangel.recyclerview.model.Card
import com.example.aplicationangel.recyclerview.model.KindOfCard

class FrgContent : Fragment() {
    lateinit var binding: FrgContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun createCard(kindofcard: KindOfCard, message: String): Card {
        return Card(kindofcard, message)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cards = listOf(
            createCard(KindOfCard.FIRST, resources.getString(R.string.textspamtwo)),
            createCard(KindOfCard.SECOND, resources.getString(R.string.textpamthree)),
            createCard(KindOfCard.FIRST, resources.getString(R.string.textspam)),
            createCard(KindOfCard.SECOND, resources.getString(R.string.textspamtwo))
        )
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        binding.rvChat.adapter = AdapterRecycler(cards)
    }
}
