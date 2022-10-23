package com.alonsogallego.superheroes.domain

import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel

class GetSuperHeroesFeedUseCase(val repository: SuperHeroesRepository) {
    fun execute(): List<SuperHero> {
        return repository.getSuperheroes()
    }
}