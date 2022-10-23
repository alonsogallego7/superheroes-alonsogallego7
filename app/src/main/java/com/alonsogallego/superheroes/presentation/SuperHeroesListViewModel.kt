package com.alonsogallego.superheroes.presentation

import androidx.lifecycle.ViewModel
import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel
import com.alonsogallego.superheroes.domain.GetSuperHeroesFeedUseCase
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroesListViewModel(private val superHeroesFeedUseCase: GetSuperHeroesFeedUseCase) :
    ViewModel() {

    fun obtainSuperHeroes(): List<SuperHeroApiModel>? {
        return superHeroesFeedUseCase.execute()
    }
}