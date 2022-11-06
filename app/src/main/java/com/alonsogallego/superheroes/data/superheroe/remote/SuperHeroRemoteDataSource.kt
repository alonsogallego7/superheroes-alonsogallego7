package com.alonsogallego.superheroes.data.superheroe.remote

import com.alonsogallego.superheroes.domain.SuperHero

interface SuperHeroRemoteDataSource {
    fun getSuperHeroes(): List<SuperHero>
    fun getSuperHero(superHeroId: Int): SuperHero?
}