package com.alonsogallego.superheroes.data.powerstats.local.mem

import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.powerstats.local.PowerStatsLocalDataSource
import com.alonsogallego.superheroes.domain.PowerStats

class PowerStatsMemLocalDataSource(private val dataStore: MemDataStore<PowerStats>):
    PowerStatsLocalDataSource {
    override fun save(heroId: Int, powerStats: PowerStats) {
        dataStore.put(heroId.toString(), powerStats)
    }

    override fun getPowerStats(): List<PowerStats> {
        val powerStats = mutableListOf<PowerStats>()
        dataStore.getAll().map() {
            powerStats[it.key.toInt()] = it.value
        }
        return powerStats
    }

    override fun getPowerStats(heroId: Int): PowerStats? {
        return dataStore.get(heroId.toString())
    }

}