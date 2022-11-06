package com.alonsogallego.superheroes.data.biography.local.mem

import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.biography.local.BiographyLocalDataSource
import com.alonsogallego.superheroes.domain.Biography

class BiographyMemLocalDataSource(private val dataStore: MemDataStore<Biography>) :
    BiographyLocalDataSource {

    override fun save(heroId: Int, biography: Biography) {
        dataStore.put(heroId.toString(), biography)
    }

    override fun getBiography(heroId: Int): Biography? {
        return dataStore.get(heroId.toString())
    }
}