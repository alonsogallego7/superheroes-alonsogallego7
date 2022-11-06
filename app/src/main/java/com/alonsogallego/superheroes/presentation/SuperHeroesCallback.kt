package com.alonsogallego.superheroes.presentation

import com.alonsogallego.superheroes.domain.SuperHero

interface SuperHeroesCallback {
    fun onCall(superHeroes: List<SuperHero>)
}

interface SuperHeroCallback {
    fun onCall(superHero: SuperHero)
}