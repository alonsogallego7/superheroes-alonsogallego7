package com.alonsogallego.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alonsogallego.superheroes.data.connections.local.db.ConnectionsDao
import com.alonsogallego.superheroes.data.connections.local.db.ConnectionsEntity
import com.alonsogallego.superheroes.data.superheroe.local.db.SuperHeroDao
import com.alonsogallego.superheroes.data.superheroe.local.db.SuperHeroEntity

@Database(entities = [ConnectionsEntity::class, SuperHeroEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun connectionsDao(): ConnectionsDao
    abstract fun superHeroDao(): SuperHeroDao
}