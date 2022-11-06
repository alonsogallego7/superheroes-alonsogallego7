package com.alonsogallego.superheroes.data.appearance.local

import com.alonsogallego.superheroes.domain.Appearance

interface AppearanceLocalDataSource {
    fun save(heroId: Int, appearance: Appearance)
    fun getAppearance(heroId: Int): Appearance?
}