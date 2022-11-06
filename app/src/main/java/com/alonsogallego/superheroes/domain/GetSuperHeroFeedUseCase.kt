package com.alonsogallego.superheroes.domain

class GetSuperHeroFeedUseCase (val repository: SuperHeroesRepository) {
    fun execute(superHeroId: Int): SuperHero? {
        return repository.getSuperheroById(superHeroId)
    }
}