package com.alonsogallego.superheroes.domain

class GetSuperHeroFeedUseCase (val repository: SuperHeroesRepository) {
    fun execute(): SuperHero? {
        return repository.getSuperheroById(1)
    }
}