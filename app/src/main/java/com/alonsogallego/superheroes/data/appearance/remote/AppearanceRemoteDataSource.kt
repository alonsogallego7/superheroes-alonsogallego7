package com.alonsogallego.superheroes.data.appearance.remote

import com.alonsogallego.superheroes.domain.Appearance

interface AppearanceRemoteDataSource {
    fun getAppearance(heroId: Int): Appearance?
}