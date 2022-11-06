package com.alonsogallego.superheroes.data.work.local.mem

import com.alonsogallego.superheroes.data.work.local.WorkLocalDataSource
import com.alonsogallego.superheroes.domain.Work

class WorkMemLocalDataSource : WorkLocalDataSource {

    private val dataStore: MutableMap<Int, Work> = mutableMapOf()

    override fun save(heroId: Int, work: Work) {
        dataStore.put(heroId, work)
    }

    override fun getWork(heroId: Int): Work? {
        return dataStore[heroId]
    }
}