package com.alonsogallego.superheroes.data.superheroe.remote.api

import com.alonsogallego.superheroes.data.ApiClient
import com.alonsogallego.superheroes.data.superheroe.remote.SuperHeroRemoteDataSource
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroApiRemoteDataSource(val apiClient: ApiClient) : SuperHeroRemoteDataSource {

    override fun getSuperHeroes(): List<SuperHero> {
        val superHeros = apiClient.getSuperHeroes().subList(0, 15)
        return superHeros.map {
            it.toDomain()
        }
    }

    override fun getSuperHero(superHeroId: Int): SuperHero? {
        return apiClient.getSuperHero(superHeroId)?.toDomain()
    }
}