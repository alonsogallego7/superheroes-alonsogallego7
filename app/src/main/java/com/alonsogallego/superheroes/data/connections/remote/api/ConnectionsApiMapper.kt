package com.alonsogallego.superheroes.data.connections.remote.api

import com.alonsogallego.superheroes.domain.Connections

fun ConnectionsApiModel.toDomain(): Connections {
    return Connections(this.groupAffiliation)
}
