package com.alonsogallego.superheroes.data.biography.remote.api

import com.alonsogallego.superheroes.data.biography.remote.api.BiographyApiModel
import com.alonsogallego.superheroes.domain.Biography

fun BiographyApiModel.toDomain() = Biography(this.fullName, this.alignment)