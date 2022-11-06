package com.alonsogallego.superheroes.presentation

import android.content.Context
import android.content.SharedPreferences
import com.alonsogallego.commons.GsonJSerializer
import com.alonsogallego.commons.MoshiJSerializer
import com.alonsogallego.superheroes.data.SuperHeroesDataRepository
import com.alonsogallego.superheroes.data.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.data.local.SuperHeroesMockLocalSource
import com.alonsogallego.superheroes.data.remote.SuperHeroesApiService
import com.alonsogallego.superheroes.data.remote.SuperHeroesRemoteSource
import com.alonsogallego.superheroes.domain.GetSuperHeroFeedUseCase
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
                        SuperHeroLocalDataSource(sharedPreferences, GsonJSerializer()),
                        SuperHeroesRemoteSource(SuperHeroesApiService())
                    )
                )
            )
        }
    }
}

class SuperHeroesDetailFactory {
    companion object {
        fun getViewModel(
            context: Context,
            sharedPreferences: SharedPreferences
        ): SuperHeroDetailViewModel {
            return SuperHeroDetailViewModel(
                GetSuperHeroFeedUseCase(
                    SuperHeroesDataRepository(
                        SuperHeroLocalDataSource(sharedPreferences, GsonJSerializer()),
                        SuperHeroesRemoteSource(SuperHeroesApiService())
                    )
                )
            )
        }
    }
}
