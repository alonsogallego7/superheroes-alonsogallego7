package com.alonsogallego.superheroes.data.superheroe.local.db

import com.alonsogallego.superheroes.data.superheroe.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroDbLocalDataSource(private val dao: SuperHeroDao) : SuperHeroLocalDataSource {

    override fun save(superHeroes: List<SuperHero>) {
        superHeroes.forEach { superHero ->
            dao.save(superHero.toEntity())
        }
    }

    override fun getHeroes(): List<SuperHero> {
        return dao.findAll().map {
            it.toDomain()
        }
    }

    override fun getHero(heroId: Int): SuperHero? {
        return dao.findById(heroId)?.toDomain()
    }
}