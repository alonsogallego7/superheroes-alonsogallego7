package com.alonsogallego.superheroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.superheroes.domain.GetSuperHeroFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHeroDetailViewModel (private val superHeroesFeedUseCase: GetSuperHeroFeedUseCase) :
    ViewModel() {

    fun obtainSuperHero(superHeroId: Int, callback: SuperHeroCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHero = superHeroesFeedUseCase.execute(superHeroId)
            withContext(Dispatchers.Main) {
                if (superHero != null) {
                    callback.onCall(superHero)
                }
            }
        }
    }
}