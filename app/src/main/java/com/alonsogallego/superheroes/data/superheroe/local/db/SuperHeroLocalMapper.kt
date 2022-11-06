package com.alonsogallego.superheroes.data.superheroe.local.db

import com.alonsogallego.superheroes.data.superheroe.local.db.SuperHeroEntity
import com.alonsogallego.superheroes.domain.SuperHero

fun SuperHeroEntity.toDomain(): SuperHero = SuperHero(
    this.id, this.name, listOf(this.urlImageS, this.urlImageM, this.urlImageL, this.urlImageXL)
)

fun SuperHero.toEntity() = SuperHeroEntity(
    this.id,
    this.name,
    this.getUrlImageS(),
    this.getUrlImageM(),
    this.getUrlImageL(),
    this.getUrlImageXL()
)