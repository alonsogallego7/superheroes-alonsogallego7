package com.alonsogallego.superheroes.data.powerstats.local

import com.alonsogallego.superheroes.domain.PowerStats

interface PowerStatsLocalDataSource {
    fun save(heroId: Int, powerStats: PowerStats)
    fun getPowerStats(): List<PowerStats>
    fun getPowerStats(heroId: Int): PowerStats?
}