package com.alonsogallego.superheroes.domain

class GetSuperHeroesFeedUseCase(val repository: SuperHeroesRepository) {
    fun execute(): List<SuperHero>? {
        return repository.getSuperheroes()
    }
}