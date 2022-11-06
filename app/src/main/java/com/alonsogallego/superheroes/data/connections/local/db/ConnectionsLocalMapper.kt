package com.alonsogallego.superheroes.data.connections.local.db

import com.alonsogallego.superheroes.data.connections.local.db.ConnectionsEntity
import com.alonsogallego.superheroes.domain.Connections

fun ConnectionsEntity.toDomain(): Connections = Connections(this.groupAffiliation)
fun Connections.toEntity(heroId: Int) = ConnectionsEntity(heroId, this.groupAffiliation)