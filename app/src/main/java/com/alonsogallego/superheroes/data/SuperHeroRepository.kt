package com.alonsogallego.superheroes.data

import com.alonsogallego.superheroes.data.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.domain.SuperHero

class UserRepository(
    val localSource: SuperHeroLocalDataSource,
) {

    fun getSuperhero(): List<SuperHero> {
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