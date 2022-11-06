package com.alonsogallego.superheroes.presentation.adapter.detail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.extensions.loadUrl
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroDetailViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun render(model: SuperHero) {

        view.findViewById<ImageView>(R.id.img).loadUrl(
            model.imageUrl
        )
        view.findViewById<ImageView>(R.id.img2).loadUrl(
            model.imageUrl
        )
        view.findViewById<TextView>(R.id.name).text = model.name
        view.findViewById<TextView>(R.id.fullName).text = model.fullName
        view.findViewById<TextView>(R.id.group).text = model.groupAffiliation
        view.findViewById<TextView>(R.id.stat1).text = model.intelligence.toString()
        view.findViewById<TextView>(R.id.stat2).text = model.speed.toString()
        view.findViewById<TextView>(R.id.stat3).text = model.combat.toString()
        view.findViewById<TextView>(R.id.alignment).text = model.alignment
    }

}