package com.alonsogallego.superheroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.superheroes.domain.GetSuperHeroesFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class SuperHeroesListViewModel(private val superHeroesFeedUseCase: GetSuperHeroesFeedUseCase) :
    ViewModel() {

    fun obtainSuperHeroes(callback: SuperHeroesCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHeroes = superHeroesFeedUseCase.execute()
            withContext(Dispatchers.Main) {
                if (superHeroes != null) {
                    callback.onCall(superHeroes)
                }
            }
        }
    }
}