package com.alonsogallego.superheroes.presentation.adapter.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroAdapter : RecyclerView.Adapter<SuperHeroViewHolder>() {
    private val dataSet: MutableList<SuperHero> = mutableListOf()
    fun loadList(superHeroes: List<SuperHero>) {
        dataSet.clear()
        dataSet.addAll(superHeroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_super_heroes_list, parent, false)
        return SuperHeroViewHolder(view)
    }
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

}