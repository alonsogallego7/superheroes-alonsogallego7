package com.alonsogallego.superheroes.data.appearance.local.mem

import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.appearance.local.AppearanceLocalDataSource
import com.alonsogallego.superheroes.domain.Appearance

class AppearanceMemLocalDataSource(private val dataStore: MemDataStore<Appearance>): AppearanceLocalDataSource {
    override fun save(heroId: Int, appearance: Appearance) {
        dataStore.put(heroId.toString(), appearance)
    }

    override fun getAppearance(heroId: Int): Appearance? {
        return dataStore.get(heroId.toString())
    }
}