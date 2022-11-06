package com.alonsogallego.superheroes.data.superheroe.remote.api

import com.alonsogallego.superheroes.data.superheroe.remote.api.SuperHeroApiModel
import com.alonsogallego.superheroes.domain.SuperHero

fun SuperHeroApiModel.toDomain(): SuperHero {
    return SuperHero(
        this.id, this.name, listOf(
            this.images.xs, this.images.sm, this.images.md, this.images.lg
        )
    )
}
