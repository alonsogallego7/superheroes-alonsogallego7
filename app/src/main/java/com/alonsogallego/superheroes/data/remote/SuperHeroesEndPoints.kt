package com.alonsogallego.superheroes.data.remote

import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel
import com.alonsogallego.superheroes.data.remote.models.SuperHeroBiographyApiModel
import com.alonsogallego.superheroes.data.remote.models.SuperHeroWorkApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroesEndPoints {
    @GET("all.json")
    fun getSuperheroes(): Call<List<SuperHeroApiModel>>

    @GET("biography/{superheroId}.json")
    fun getSuperHeroBiography(@Path("superheroId") superheroId: Int): Call<SuperHeroBiographyApiModel>

    @GET("work/{superheroId}.json")
    fun getSuperHeroWork(@Path("superheroId") superheroId: Int): Call<SuperHeroWorkApiModel>
}