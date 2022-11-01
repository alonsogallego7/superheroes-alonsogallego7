package com.alonsogallego.superheroes.presentation.adapter.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroDetailAdapter : RecyclerView.Adapter<SuperHeroDetailViewHolder>() {
    private val dataSet: MutableList<SuperHero> = mutableListOf()
    fun loadSuperHero(superHero: SuperHero) {
        dataSet.clear()
        dataSet.add(superHero)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroDetailViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_super_heroes_list, parent, false)
        return SuperHeroDetailViewHolder(view)
    }
    override fun onBindViewHolder(holder: SuperHeroDetailViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}