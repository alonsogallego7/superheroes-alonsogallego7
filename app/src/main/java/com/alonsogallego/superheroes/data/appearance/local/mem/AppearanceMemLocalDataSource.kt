package com.alonsogallego.superheroes.data.appearance.local.mem

import com.alonsogallego.superheroes.data.appearance.local.AppearanceLocalDataSource
import com.alonsogallego.superheroes.domain.Appearance

class AppearanceMemLocalDataSource : AppearanceLocalDataSource {
    override fun save(heroId: Int, appearance: Appearance) {
        //implementar
    }

    override fun getAppearance(heroId: Int): Appearance? {
        //mock
        return Appearance("male", "human")
    }
}