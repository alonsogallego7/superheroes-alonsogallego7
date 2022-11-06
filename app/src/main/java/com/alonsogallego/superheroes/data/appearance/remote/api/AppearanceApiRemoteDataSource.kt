package com.alonsogallego.superheroes.data.appearance.remote.api

import com.alonsogallego.superheroes.data.ApiClient
import com.alonsogallego.superheroes.data.appearance.remote.AppearanceRemoteDataSource
import com.alonsogallego.superheroes.data.work.remote.api.toDomain
import com.alonsogallego.superheroes.domain.Appearance
import com.alonsogallego.superheroes.domain.Work

class AppearanceApiRemoteDataSource(private val apiClient: ApiClient) : AppearanceRemoteDataSource {
    override fun getAppearance(superHeroId: Int): Appearance? {
        return apiClient.getAppearance(superHeroId)?.toDomain()
    }
}