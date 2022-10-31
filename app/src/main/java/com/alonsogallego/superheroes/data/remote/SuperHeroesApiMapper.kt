package com.alonsogallego.superheroes.data.remote

import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel
import com.alonsogallego.superheroes.domain.SuperHero

fun SuperHeroApiModel.toDomain(): SuperHero {
    return SuperHero(this.id, this.name, this.images.sm, this.biography.fullName, this.work.occupation, this.biography.alignment, this.powerstats.intelligence, this.powerstats.combat, this.powerstats.speed, this.connections.groupAffiliation)
}