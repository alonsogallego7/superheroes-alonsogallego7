package com.alonsogallego.superheroes.domain

import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel

interface SuperHeroesRepository {
    fun getSuperheroes(): List<SuperHero>
}