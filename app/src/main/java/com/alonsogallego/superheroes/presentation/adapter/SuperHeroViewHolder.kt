package com.alonsogallego.superheroes.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alonsogallego.app.extensions.loadUrl
import com.alonsogallego.superheroes.databinding.ViewItemSuperheroeFeedBinding
import com.alonsogallego.superheroes.domain.GetSuperHeroFeedUseCase
import com.alonsogallego.superheroes.presentation.SuperHeroDetailActivity

class SuperHeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(superHero: GetSuperHeroFeedUseCase.SuperHeroFeed) {
        val binding = ViewItemSuperheroeFeedBinding.bind(view)
        binding.imgSuperheroe.loadUrl(superHero.urlImage)
        binding.labelNameSuperheroe.text = superHero.nameSuperHero
        binding.labelRealnameSuperheroe.text = superHero.realName
        binding.labelOccupationSuperheroe.text = superHero.occupation
        view.setOnClickListener {
            view.context.startActivity(
                SuperHeroDetailActivity.getIntent(
                    view.context, superHero.id
                )
            )
        }
    }

}