package com.alonsogallego.superheroes.data.appearance

import com.alonsogallego.superheroes.data.appearance.local.AppearanceLocalDataSource
import com.alonsogallego.superheroes.data.appearance.remote.AppearanceRemoteDataSource
import com.alonsogallego.superheroes.domain.Appearance
import com.alonsogallego.superheroes.domain.AppearanceRepository

class AppearanceDataRepository(
    val localDataSource: AppearanceLocalDataSource, val remoteDataSource: AppearanceRemoteDataSource
) : AppearanceRepository {

    override fun getAppearance(superHeroId: Int): Appearance {
        var appearance = localDataSource.getAppearance(superHeroId)
        if (appearance == null) {
            appearance = remoteDataSource.getAppearance(superHeroId)!! //Siempre devuelve un work
            localDataSource.save(superHeroId, appearance)
        }
        return appearance
    }
}