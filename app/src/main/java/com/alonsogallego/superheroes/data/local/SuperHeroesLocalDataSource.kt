package com.alonsogallego.superheroes.data.local

import com.alonsogallego.superheroes.domain.SuperHero

interface SuperHeroesLocalDataSource {
    fun save(superHeroes: List<SuperHero>)
    fun getAll(): List<SuperHero>
    fun findById(superHeroeId: Int): SuperHero?
}