package com.alonsogallego.superheroes.data.local

import com.alonsogallego.superheroes.domain.SuperHero

interface SuperHeroesLocalSource {
    fun saveSuperheroes(superHeroes: List<SuperHero>)
    fun getSuperheroes(): List<SuperHero>
    fun findById(superHeroId: Int): SuperHero?
}