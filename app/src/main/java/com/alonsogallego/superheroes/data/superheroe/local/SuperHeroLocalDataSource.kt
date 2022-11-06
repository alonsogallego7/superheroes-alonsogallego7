package com.alonsogallego.superheroes.data.superheroe.local

import com.alonsogallego.superheroes.domain.SuperHero

interface SuperHeroLocalDataSource {
    fun save(superHeros: List<SuperHero>)
    fun getHeroes(): List<SuperHero>
    fun getHero(heroId: Int): SuperHero?
}