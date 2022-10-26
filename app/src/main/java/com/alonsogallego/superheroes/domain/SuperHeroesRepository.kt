package com.alonsogallego.superheroes.domain

interface SuperHeroesRepository {
    fun saveSuperheroes(superHeroes: List<SuperHero>)
    fun getSuperheroes(): List<SuperHero>?
    fun getSuperheroById(superHeroId: Int): SuperHero?
}