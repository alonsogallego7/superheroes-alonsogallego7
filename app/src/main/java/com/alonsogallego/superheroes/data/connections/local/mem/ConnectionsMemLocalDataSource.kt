package com.alonsogallego.superheroes.data.connections.local.mem

import com.alonsogallego.app.data.mem.MemDataStore
import com.alonsogallego.superheroes.data.connections.local.ConnectionsLocalDataSource
import com.alonsogallego.superheroes.domain.Connections

class ConnectionsMemLocalDataSource(private val dataStore: MemDataStore<Connections>) :
    ConnectionsLocalDataSource {

    override fun save(heroId: Int, connections: Connections) {
        dataStore.put(heroId.toString(), connections)
    }

    override fun getConnections(heroId: Int): Connections? {
        return dataStore.get(heroId.toString())
    }
}