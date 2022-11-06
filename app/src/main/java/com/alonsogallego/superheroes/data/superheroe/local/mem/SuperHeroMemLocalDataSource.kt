package com.alonsogallego.superheroes.data.superheroe.local.mem

import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.superheroe.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroMemLocalDataSource(private val dataStore: MemDataStore<SuperHero>) :
    SuperHeroLocalDataSource {

    override fun save(superHeros: List<SuperHero>) {
        superHeros.map {
            dataStore.put(it.id.toString(), it)
        }

    }

    override fun getHeroes(): List<SuperHero> {
        val superHeroes = mutableListOf<SuperHero>()
        dataStore.getAll().map() {
            superHeroes[it.key.toInt()] = it.value
        }
        return superHeroes
    }

    override fun getHero(heroId: Int): SuperHero? {
        return dataStore.get(heroId.toString())
    }
}