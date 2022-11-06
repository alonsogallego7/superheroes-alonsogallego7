package com.alonsogallego.superheroes.data.work.remote.api

import com.alonsogallego.superheroes.data.ApiClient
import com.alonsogallego.superheroes.data.work.remote.WorkRemoteDataSource
import com.alonsogallego.superheroes.domain.Work

class WorkApiRemoteDataSource(private val apiClient: ApiClient) : WorkRemoteDataSource {

    override fun getWork(superHeroId: Int): Work? {
        return apiClient.getWork(superHeroId)?.toDomain()
    }
}