package com.alonsogallego.superheroes.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.extensions.loadUrl
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun render(model: SuperHero) {

        view.findViewById<ImageView>(R.id.img).loadUrl(
            model.imageUrl
        )
        view.findViewById<TextView>(R.id.name).text = model.name
        view.findViewById<TextView>(R.id.fullName).text = model.id.toString()
    }

}