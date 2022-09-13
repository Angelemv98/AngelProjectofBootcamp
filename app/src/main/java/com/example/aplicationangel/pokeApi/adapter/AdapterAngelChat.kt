package com.example.aplicationangel.pokeApi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationangel.R
import com.example.aplicationangel.pokeApi.model.Chat

class AdapterAngelChat(private val chat: List<Chat>) :
    RecyclerView.Adapter<AdapterAngelChat.ViewHolder>(), Filterable {
    private var chatfiltrable: List<Chat> = chat
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemLayout = when (viewType) {
            0 -> R.layout.item_card
            else -> throw Exception("Tipo invalido")
        }
        val view = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return chatfiltrable[position].type.value
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*val chat = chats[position]
        holder.tvMessage.text = chat.message
        holder.tvDate.text = chat.date*/
        holder.bind(chatfiltrable[position])
    }

    override fun getItemCount() = chatfiltrable.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(chat: Chat) {
            when (chat.type.value) {
                0 -> {
                    val tvMessage: TextView = itemView.findViewById(R.id.tvCard)
                    tvMessage.text = chat.message
                    var chPokemono: CheckBox = itemView.findViewById(R.id.cbCard)
                    chPokemono.setOnCheckedChangeListener { _, b ->
                        chat.isChecked = b
                    }
                    chPokemono.isChecked = chat.isChecked
                }
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val inputText = p0.toString()
                chatfiltrable = if (inputText.isEmpty()) {
                    chat
                } else {
                    var chatFiltereableTemp: MutableList<Chat> = ArrayList()
                    chatFiltereableTemp.clear()

                    chatfiltrable.forEach {
                        if (it.message.contains(inputText)) {
                            chatFiltereableTemp.add(it)
                        }
                    }
                    chatFiltereableTemp
                }
                val filterResult = FilterResults()
                filterResult.values = chatfiltrable
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                chatfiltrable = p1?.values as List<Chat>
                notifyDataSetChanged()
            }
        }
    }
}
