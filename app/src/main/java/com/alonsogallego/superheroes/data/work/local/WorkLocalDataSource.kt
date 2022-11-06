package com.alonsogallego.superheroes.data.work.local

import com.alonsogallego.superheroes.domain.Work

interface WorkLocalDataSource {
    fun save(heroId: Int, work: Work)
    fun getWork(heroId: Int): Work?
}