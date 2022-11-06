package com.alonsogallego.superheroes.data.local.db

import com.alonsogallego.superheroes.domain.SuperHero

fun SuperHeroeEntity.toDomain() = SuperHero(this.id, this.name, this.imageUrl)
fun SuperHero.toEntity() = SuperHeroeEntity(this.id, this.name, this.imageUrl)