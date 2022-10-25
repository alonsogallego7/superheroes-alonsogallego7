package com.alonsogallego.superheroes.presentation

import com.alonsogallego.superheroes.domain.SuperHero

interface SuperHeroesCallback {
    fun onCall(superHeroes: List<SuperHero>)
}