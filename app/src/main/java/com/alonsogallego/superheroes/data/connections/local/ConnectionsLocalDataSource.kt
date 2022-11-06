package com.alonsogallego.superheroes.data.connections.local

import com.alonsogallego.superheroes.domain.Connections

interface ConnectionsLocalDataSource {
    fun findByHeroId(heroId: Int): Connections?
    fun save(heroId: Int, connections: Connections)
}