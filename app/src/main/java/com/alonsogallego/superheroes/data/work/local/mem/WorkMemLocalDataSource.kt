package com.alonsogallego.superheroes.data.work.local.mem

import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.work.local.WorkLocalDataSource
import com.alonsogallego.superheroes.domain.Work

class WorkMemLocalDataSource(private val dataStore: MemDataStore<Work>) : WorkLocalDataSource {

    override fun save(heroId: Int, work: Work) {
        dataStore.put(heroId.toString(), work)
    }

    override fun getWork(heroId: Int): Work? {
        return dataStore.get(heroId.toString())
    }
}