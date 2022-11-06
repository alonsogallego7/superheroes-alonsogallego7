package com.alonsogallego.superheroes.data.connections.local.db

import com.alonsogallego.superheroes.data.connections.local.ConnectionsLocalDataSource
import com.alonsogallego.superheroes.domain.Connections

class ConnectionsDbLocalDataSource(private val dao: ConnectionsDao) : ConnectionsLocalDataSource {

    override fun findByHeroId(heroId: Int): Connections? {
        return dao.findById(heroId)?.toDomain()
    }

    override fun save(heroId: Int, connections: Connections) {
        dao.save(connections.toEntity(heroId))
    }
}