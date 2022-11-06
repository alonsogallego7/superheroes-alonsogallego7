package com.alonsogallego.superheroes.data.biography.remote.api

import com.alonsogallego.superheroes.data.ApiClient
import com.alonsogallego.superheroes.data.biography.remote.BiographyRemoteDataSource
import com.alonsogallego.superheroes.domain.Biography

class BiographyApiRemoteDataSource(private val apiClient: ApiClient) : BiographyRemoteDataSource {

    override fun getBiography(superHeroId: Int): Biography? =
        apiClient.getBiography(superHeroId)?.toDomain()
}