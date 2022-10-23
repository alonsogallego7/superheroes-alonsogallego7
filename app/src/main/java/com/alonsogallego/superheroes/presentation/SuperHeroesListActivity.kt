package com.alonsogallego.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.data.remote.SuperHeroesApiService

class SuperHeroesListActivity : AppCompatActivity() {

    val apiClient = SuperHeroesApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroes_list)

        Thread {
            val superheroes = apiClient.getSuperheroes()
            Log.d("@dev", "Superheroes: $superheroes")
        }.start()

        Thread {
            val biography = apiClient.getSuperHeroBiography(620)
            Log.d("@dev", "Biografia: $biography")
        }.start()

        Thread {
            val work = apiClient.getSuperHeroWork(620)
            Log.d("@dev", "Trabajo: $work")
        }.start()

        Thread {
            val superhero = apiClient.getSuperHeroById(620)
            Log.d("@dev", "Superheroe: $superhero")
        }.start()
    }
}