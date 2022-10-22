package com.alonsogallego.superheroes.data.local

import android.content.SharedPreferences
import com.alonsogallego.superheroes.domain.SuperHero
import com.google.gson.Gson

class SuperHeroLocalDataSource(val sharedPref: SharedPreferences) {

        private val gson = Gson()

        fun saveSuperheroes(superheroes: List<SuperHero>) {
            superheroes.forEach {
                saveSuperhero(it)
            }
        }

        private fun saveSuperhero(superhero: SuperHero) {
            val jsonUser: String = gson.toJson(superhero, SuperHero::class.java)
            val edit = sharedPref.edit()
            edit.putString(superhero.id.toString(), jsonUser)
            edit.apply() //guarda de forma asíncrona
        }

        fun getSuperheroes(): List<SuperHero> {
            val superheroes = mutableListOf<SuperHero>()
            sharedPref.all.forEach { map ->
                superheroes.add(gson.fromJson(map.value as String, SuperHero::class.java))
            }
            return superheroes
        }

        fun findById(superheroId: Int): SuperHero? {
            val superhero: String? = sharedPref.getString(superheroId.toString(), null)
            return superhero?.let {
                gson.fromJson(it, SuperHero::class.java)
            }
        }

        fun remove(superheroId: Int) {
            sharedPref.edit().remove(superheroId.toString()).apply()
        }
    }