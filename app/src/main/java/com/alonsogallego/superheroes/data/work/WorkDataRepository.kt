package com.alonsogallego.superheroes.data.work

import com.alonsogallego.superheroes.data.work.local.mem.WorkMemLocalDataSource
import com.alonsogallego.superheroes.data.work.remote.WorkRemoteDataSource
import com.alonsogallego.superheroes.domain.Work
import com.alonsogallego.superheroes.domain.WorkRepository

class WorkDataRepository(
    private val localDataSource: WorkMemLocalDataSource,
    private val remoteDataSource: WorkRemoteDataSource
) : WorkRepository {

    override fun getWork(superHeroId: Int): Work {
        var work = localDataSource.getWork(superHeroId)
        if (work == null) {
            work = remoteDataSource.getWork(superHeroId)!! //Siempre devuelve un work
            localDataSource.save(superHeroId, work)
        }
        return work
    }
}