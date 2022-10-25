package com.alonsogallego.superheroes.presentation

import androidx.lifecycle.ViewModel
import com.alonsogallego.superheroes.domain.GetSuperHeroesFeedUseCase
import kotlin.concurrent.thread

class SuperHeroesListViewModel(private val superHeroesFeedUseCase: GetSuperHeroesFeedUseCase) :
    ViewModel() {

    fun obtainSuperHeroes(callback: SuperHeroesCallback) {
        thread {
            val superHeroes = superHeroesFeedUseCase.execute()
            callback.onCall(superHeroes)
        }
    }
}