package com.alonsogallego.superheroes.data.connections

import com.alonsogallego.superheroes.data.connections.local.ConnectionsLocalDataSource
import com.iesam.superhero.data.connections.remote.ConnectionsRemoteDataSource
import com.alonsogallego.superheroes.domain.Connections
import com.alonsogallego.superheroes.domain.ConnectionsRepository

class ConnectionsDataRepository(
    val localDataSource: ConnectionsLocalDataSource,
    val remoteDataSource: ConnectionsRemoteDataSource
) :
    ConnectionsRepository {

    override fun getConnections(superHeroId: Int): Connections {
        var connections = localDataSource.getConnections(superHeroId)
        if (connections == null) {
            connections = remoteDataSource.getConnections(superHeroId)
            localDataSource.save(superHeroId, connections)
        }
        return connections
    }
}