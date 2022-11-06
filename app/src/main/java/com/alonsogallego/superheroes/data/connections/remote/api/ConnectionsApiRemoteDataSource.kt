package com.alonsogallego.superheroes.data.connections.remote.api

import com.alonsogallego.superheroes.data.ApiClient
import com.iesam.superhero.data.connections.remote.ConnectionsRemoteDataSource
import com.alonsogallego.superheroes.domain.Connections

class ConnectionsApiRemoteDataSource(val apiClient: ApiClient) : ConnectionsRemoteDataSource {

    override fun getConnections(superHeroId: Int): Connections {
        val connections = apiClient.getConnections(superHeroId)!!
        return connections.toDomain()
    }
}