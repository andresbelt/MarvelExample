package com.test.grability.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.test.grability.R
import com.test.grability.data.vo.UiState
import com.test.grability.domain.entities.Characters

class CharactersPagedListAdapter : PagedListAdapter<Characters, CharacterViewHolder>(
    diffCallback
) {

    private var state : UiState = UiState.Loading

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_card, parent, false)

        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindTo( item!!)
    }

    fun setState(state : UiState) {
        this.state = state
        notifyItemChanged(super.getItemCount())
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Characters>() {
            override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem == newItem
            }

        }
    }
}