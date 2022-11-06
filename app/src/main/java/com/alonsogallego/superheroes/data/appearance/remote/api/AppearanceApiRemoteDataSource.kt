package com.alonsogallego.superheroes.data.appearance.remote.api

import com.alonsogallego.superheroes.data.appearance.remote.AppearanceRemoteDataSource
import com.alonsogallego.superheroes.domain.Appearance

class AppearanceApiRemoteDataSource : AppearanceRemoteDataSource {
    override fun getAppearance(heroId: Int): Appearance? {
        //mock
        return Appearance("male", "human")
    }
}