package com.alonsogallego.superheroes.data

import com.alonsogallego.superheroes.data.local.SuperHeroesLocalDataSource
import com.alonsogallego.superheroes.domain.SuperHero
import com.alonsogallego.superheroes.domain.SuperHeroesRepository

class SuperHeroesDataRepository(
    val localSource: SuperHeroesLocalDataSource,
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