package com.example.aplicationangel.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationangel.R
import com.example.aplicationangel.recyclerview.model.Card

class AdapterRecycler(private val cards: List<Card>) :
    RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            1 -> R.layout.item_card
            2 -> R.layout.item_cardtwo
            else -> throw Exception("Tipo invalido")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return cards[position].type.value
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount() = cards.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(card: Card) {
            when (card.type.value) {
                1 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvCard)
                    tvMessage.text = card.message
                }
                2 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvCardTwo)
                    tvMessage.text = card.message
                }
            }
        }
    }
}
