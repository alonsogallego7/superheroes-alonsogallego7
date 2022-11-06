package com.iesam.superhero.data.connections.remote

import com.alonsogallego.superheroes.domain.Connections

interface ConnectionsRemoteDataSource {
    fun getConnections(superHeroId: Int): Connections
}