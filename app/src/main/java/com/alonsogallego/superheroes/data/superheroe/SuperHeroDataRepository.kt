package com.alonsogallego.superheroes.data.superheroe

import com.alonsogallego.superheroes.data.superheroe.local.SuperHeroLocalDataSource
import com.alonsogallego.superheroes.data.superheroe.remote.SuperHeroRemoteDataSource
import com.alonsogallego.superheroes.domain.SuperHero
import com.alonsogallego.superheroes.domain.SuperHeroRepository


class SuperHeroDataRepository(
    val localSource: SuperHeroLocalDataSource,
    val remoteSource: SuperHeroRemoteDataSource
) :
    SuperHeroRepository {

    override fun getSuperHero(): List<SuperHero> {
        var superHeroes = localSource.getHeroes()
        if (superHeroes.isEmpty()) {
            superHeroes = remoteSource.getSuperHeroes()
            if (superHeroes.isNotEmpty()) {
                localSource.save(superHeroes)
            }
        }
        return superHeroes
    }

    override fun getSuperHeroById(superHeroId: Int): SuperHero? {
        //return localSource.getHero(superHeroId) ?: remoteSource.getSuperHero(superHeroId)
        var hero = localSource.getHero(superHeroId)
        if (hero == null) {
            hero = remoteSource.getSuperHero(superHeroId)
        }
        return hero
    }
}