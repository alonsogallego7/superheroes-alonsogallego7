package com.alonsogallego.superheroes.data

import com.alonsogallego.superheroes.data.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.data.remote.SuperHeroesApiService
import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel
import com.alonsogallego.superheroes.domain.SuperHero
import com.alonsogallego.superheroes.domain.SuperHeroesRepository

class SuperHeroesDataRepository(
    val localSource: SuperHeroLocalDataSource,
): SuperHeroesRepository {

    fun saveSuperHeroes(superHeroes: List<SuperHero>) {
        localSource.saveSuperheroes(superHeroes)
    }

    override fun getSuperheroes(): List<SuperHero> {
        var superheroes = localSource.getSuperheroes()
        return superheroes
    }

    fun getSuperheroById(superheroId: Int): SuperHero? {
        var superhero = localSource.findById(superheroId)
        return superhero
    }

    fun removeSuperhero(superheroId: Int) {
        localSource.remove(superheroId)
    }

}