package com.alonsogallego.superheroes.presentation

import android.content.Context
import android.content.SharedPreferences
import com.alonsogallego.superheroes.data.SuperHeroesDataRepository
import com.alonsogallego.superheroes.data.local.db.SuperHeroeDbLocalDataSource
import com.alonsogallego.superheroes.domain.GetSuperHeroesFeedUseCase

class SuperHeroesFactory {
    companion object {
        fun getViewModel(
            context: Context,
            sharedPreferences: SharedPreferences
        ): SuperHeroesListViewModel {
            return SuperHeroesListViewModel(
                GetSuperHeroesFeedUseCase(
                    SuperHeroesDataRepository(
                        SuperHeroeDbLocalDataSource(context)
                    )
                )
            )
        }
    }
}