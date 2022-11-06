package com.alonsogallego.superheroes.data.powerstats

import com.alonsogallego.superheroes.data.powerstats.local.PowerStatsLocalDataSource
import com.iesam.superhero.data.powerstats.remote.PowerStatsRemoteDataSource
import com.alonsogallego.superheroes.domain.PowerStats
import com.alonsogallego.superheroes.domain.PowerStatsRepository

class PowerStatsDataRepository(
    val localDataSource: PowerStatsLocalDataSource,
    val remoteDataSource: PowerStatsRemoteDataSource
) :
    PowerStatsRepository {

    override fun getPowerStats(superHeroId: Int): PowerStats {
        var powerStats = localDataSource.getPowerStats(superHeroId)
        if (powerStats == null) {
            powerStats = remoteDataSource.getPowerStats(superHeroId)
            if (powerStats != null) {
                localDataSource.save(superHeroId, powerStats)
            }
        }

        return powerStats
    }
}