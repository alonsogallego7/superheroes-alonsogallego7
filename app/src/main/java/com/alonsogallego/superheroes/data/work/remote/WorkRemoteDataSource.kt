package com.alonsogallego.superheroes.data.work.remote

import com.alonsogallego.superheroes.domain.Work

interface WorkRemoteDataSource {
    fun getWork(superHeroId: Int): Work?
}