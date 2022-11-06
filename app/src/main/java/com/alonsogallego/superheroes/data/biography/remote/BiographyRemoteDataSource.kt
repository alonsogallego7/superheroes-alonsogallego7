package com.alonsogallego.superheroes.data.biography.remote

import com.alonsogallego.superheroes.domain.Biography

interface BiographyRemoteDataSource {
    fun getBiography(superHeroId: Int): Biography?
}