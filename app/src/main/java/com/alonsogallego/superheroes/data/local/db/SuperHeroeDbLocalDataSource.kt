package com.alonsogallego.superheroes.data.local.db

import android.content.Context
import androidx.room.Room
import com.alonsogallego.data.AppDatabase
import com.alonsogallego.superheroes.data.local.SuperHeroesLocalDataSource
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroeDbLocalDataSource(val applicationContext: Context) : SuperHeroesLocalDataSource {

    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "db-superheroe"
    ).build()

    override fun save(superHeroes: List<SuperHero>) {
        TODO("Not yet implemented")
    }

    override fun getAll() = db.superHeroeDao().getAll().map { superHeroeEntity ->
        superHeroeEntity.toDomain()
    }

    override fun findById(superHeroeId: Int): SuperHero? {
        TODO("Not yet implemented")
    }
}