package com.alonsogallego.superheroes.data

import com.alonsogallego.superheroes.data.appearance.remote.api.AppearanceApiModel
import com.alonsogallego.superheroes.data.biography.remote.api.BiographyApiModel
import com.alonsogallego.superheroes.data.connections.remote.api.ConnectionsApiModel
import com.alonsogallego.superheroes.data.superheroe.remote.api.SuperHeroApiModel
import com.alonsogallego.superheroes.data.work.remote.api.WorkApiModel
import com.iesam.superhero.data.powerstats.remote.api.PowerStatsApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Endpoints o Servicios para SuperHeros
 */
interface ApiServices {
    @GET("all.json")
    fun getSuperHeroesFeed(): Call<List<SuperHeroApiModel>>

    @GET("id/{heroId}.json")
    fun getSuperHero(@Path("heroId") heroId: Int): Call<SuperHeroApiModel>

    @GET("biography/{heroId}.json")
    fun getBiography(@Path("heroId") heroId: Int): Call<BiographyApiModel>

    @GET("work/{heroId}.json")
    fun getWork(@Path("heroId") heroId: Int): Call<WorkApiModel>

    @GET("connections/{heroId}.json")
    fun getConnections(@Path("heroId") heroId: Int): Call<ConnectionsApiModel>

    @GET("powerstats/{heroId}.json")
    fun getPowerstats(@Path("heroId") heroId: Int): Call<PowerStatsApiModel>

    @GET("appearance/{heroId}.json")
    fun getAppearance(@Path("heroId") heroId: Int): Call<AppearanceApiModel>
}