package com.alonsogallego.superheroes.data.biography.local

import com.alonsogallego.superheroes.domain.Biography

interface BiographyLocalDataSource {
    fun save(heroId: Int, biography: Biography)
    fun getBiography(heroId: Int): Biography?
}