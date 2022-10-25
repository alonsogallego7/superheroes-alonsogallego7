package com.alonsogallego.superheroes.presentation

import android.content.SharedPreferences
import com.alonsogallego.commons.GsonJSerializer
import com.alonsogallego.commons.MoshiJSerializer
import com.alonsogallego.superheroes.data.SuperHeroesDataRepository
import com.alonsogallego.superheroes.data.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.domain.GetSuperHeroesFeedUseCase

class SuperHeroesFactory {
    companion object {
        fun getViewModel(sharedPreferences: SharedPreferences): SuperHeroesListViewModel {
            return SuperHeroesListViewModel(
                GetSuperHeroesFeedUseCase(
                    SuperHeroesDataRepository(
                        SuperHeroLocalDataSource(sharedPreferences, GsonJSerializer()),
                    )
                )
            )
        }
    }
}