package com.alonsogallego.superheroes.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.app.extensions.loadUrl
import com.alonsogallego.superheroes.databinding.ViewItemSuperheroDetailBinding

class SuperHeroDetailViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(urlImage: String) {
        val binding = ViewItemSuperheroDetailBinding.bind(view)
        binding.imageSuperhero.loadUrl(urlImage)
    }
}