package com.alonsogallego.superheroes.data.local

import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroesMockLocalSource : SuperHeroesLocalSource {

    override fun saveSuperheroes(superHeroes: List<SuperHero>) {
        TODO("Not yet implemented")
    }

    override fun getSuperheroes(): List<SuperHero> {
        Thread.sleep(5000)
        return mutableListOf(
            SuperHero(1, "SuperMan", SuperHero.Images("")),
            SuperHero(2, "SpiderMan", SuperHero.Images("")),
            SuperHero(3, "CatWoman", SuperHero.Images(""))
        )
    }

    override fun findById(superHeroeId: Int): SuperHero? {
        TODO("Not yet implemented")
    }
}