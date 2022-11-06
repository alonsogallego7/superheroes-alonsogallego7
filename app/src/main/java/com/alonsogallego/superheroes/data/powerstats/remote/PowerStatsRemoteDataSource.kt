package com.iesam.superhero.data.powerstats.remote

import com.alonsogallego.superheroes.domain.PowerStats

interface PowerStatsRemoteDataSource {
    fun getPowerStats(superHeroId: Int): PowerStats
}