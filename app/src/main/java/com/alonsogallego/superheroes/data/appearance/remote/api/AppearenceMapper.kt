package com.alonsogallego.superheroes.data.appearance.remote.api

import com.alonsogallego.superheroes.domain.Appearance

fun AppearanceApiModel.toDomain() = Appearance(this.gender, this.race)