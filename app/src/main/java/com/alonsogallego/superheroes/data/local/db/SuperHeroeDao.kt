package com.alonsogallego.superheroes.data.local.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SuperHeroeDao:  {
    @Query("Select * FROM $SUPERHEROES_TABLA_NAME")
    fun getAll(): List<SuperHeroeEntity>

    @Query("Select * FROM $SUPERHEROES_TABLA_NAME WHERE :id(superHeroeId)")
    fun findById(): SuperHeroeEntity
}