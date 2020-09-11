package com.test.grability.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.grability.R
import com.test.grability.domain.entities.Characters
import kotlinx.android.synthetic.main.character_card.view.*


class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var placeholdersList: List<Int> = listOf(
        R.drawable.marvel_placeholder1
    )

    var comicTitle: AppCompatTextView = itemView.comicTitle
    var comicDescription: AppCompatTextView = itemView.comicDescription
    var comicDescriptionSmall: AppCompatTextView = itemView.comicDescriptionSmall
    var comicThumbnail: AppCompatImageView = itemView.comicThumbnail
    private var expandButton: AppCompatImageButton = itemView.expand_button

    fun bindTo(comicItem: Characters) {

        Glide.with(itemView.context)
            .load(comicItem.thumbnail)
            .placeholder(ContextCompat.getDrawable(itemView.context, placeholdersList.random()!!))
            .centerInside()
            .into(comicThumbnail)

        comicTitle.text = comicItem.name
        comicDescription.text = comicItem.description

        comicItem.description?.let { it ->
            comicDescriptionSmall.text = it.take(100).plus("...")
        }

        expandButton.setOnClickListener { _ ->
            when (comicDescription.visibility) {
                View.VISIBLE -> {
                    val degree: Float = if (expandButton.rotation == 180f) 0f else 180f
                    expandButton.animate().rotation(degree).duration = 200
                    comicDescription.visibility = View.GONE
                }
                View.GONE -> {
                    val degree: Float = if (expandButton.rotation == 180f) 0f else 180f
                    expandButton.animate().rotation(degree).duration = 200
                    comicDescription.visibility = View.VISIBLE
                }
            }
        }
    }
}
