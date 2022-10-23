package com.alonsogallego.superheroes.data.remote

import com.alonsogallego.superheroes.data.remote.models.SuperHeroApiModel
import com.alonsogallego.superheroes.data.remote.models.SuperHeroBiographyApiModel
import com.alonsogallego.superheroes.data.remote.models.SuperHeroWorkApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroesApiService {
    private val urlEndPoint = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"
    private var apiEndPoints: SuperHeroesEndPoints

    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): SuperHeroesEndPoints {
        return buildClient().create(SuperHeroesEndPoints::class.java)
    }

    fun getSuperheroes(): List<SuperHeroApiModel>? {
        val callSuperheroes = apiEndPoints.getSuperheroes() //Llamada
        val response = callSuperheroes.execute() //Ejecución de la llamada
        return if (response.isSuccessful) {
            response.body()
        } else{
            null
        }
    }

    fun getSuperHeroBiography(superheroId: Int): SuperHeroBiographyApiModel? {
        val callSuperHeroBiography = apiEndPoints.getSuperHeroBiography(superheroId)
        val response = callSuperHeroBiography.execute()
        return if (response.isSuccessful) {
            response.body()
        } else{
            null
        }
    }

    fun getSuperHeroWork(superheroId: Int): SuperHeroWorkApiModel? {
        val callSuperHeroWork = apiEndPoints.getSuperHeroWork(superheroId)
        val response = callSuperHeroWork.execute()
        return if (response.isSuccessful) {
            response.body()
        } else{
            null
        }
    }
}