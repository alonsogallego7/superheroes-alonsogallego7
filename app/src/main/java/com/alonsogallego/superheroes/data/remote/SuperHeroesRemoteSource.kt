package com.alonsogallego.superheroes.data.remote

import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroesRemoteSource(val apiClient: SuperHeroesApiService) {

    fun getSuperHeroes(): List<SuperHero>? =
        apiClient.getSuperheroes()?.map { apiSuperHeroe ->
            apiSuperHeroe.toDomain()
        }
}