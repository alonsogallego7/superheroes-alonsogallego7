package com.alonsogallego.superheroes.data

import com.alonsogallego.superheroes.data.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.data.local.SuperHeroesMockLocalSource
import com.alonsogallego.superheroes.data.remote.SuperHeroesApiService
import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel
import com.alonsogallego.superheroes.domain.SuperHero
import com.alonsogallego.superheroes.domain.SuperHeroesRepository

class SuperHeroesDataRepository(
    val localSource: SuperHeroesMockLocalSource,
): SuperHeroesRepository {

    override fun saveSuperheroes(superHeroes: List<SuperHero>) {
        localSource.saveSuperheroes(superHeroes)
    }

    override fun getSuperheroes(): List<SuperHero> {
        var superheroes = localSource.getSuperheroes()
        return superheroes
    }

    override fun getSuperheroById(superheroId: Int): SuperHero? {
        var superhero = localSource.findById(superheroId)
        return superhero
    }

}