package com.alonsogallego.superheroes.data.local.xml

import android.content.SharedPreferences
import com.alonsogallego.commons.KSerializer
import com.alonsogallego.superheroes.data.local.SuperHeroesLocalDataSource
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroesXmlLocalDataSource (
    private val sharedPref: SharedPreferences,
    private val jSerializer: KSerializer
): SuperHeroesLocalDataSource {

    override fun saveSuperheroes(superheroes: List<SuperHero>) {
        superheroes.forEach {
            saveSuperhero(it)
        }
    }

    private fun saveSuperhero(superhero: SuperHero) {
        val jsonUser: String = jSerializer.toJson(superhero, SuperHero::class.java)
        val edit = sharedPref.edit()
        edit.putString(superhero.id.toString(), jsonUser)
        edit.apply() //guarda de forma asíncrona
    }

    override fun getSuperheroes(): List<SuperHero> {
        val superheroes = mutableListOf<SuperHero>()
        sharedPref.all.forEach { map ->
            superheroes.add(jSerializer.fromJson(map.value as String, SuperHero::class.java))
        }
        return superheroes
    }

    override fun findById(superheroId: Int): SuperHero? {
        val superhero: String? = sharedPref.getString(superheroId.toString(), null)
        return superhero?.let {
            jSerializer.fromJson(it, SuperHero::class.java)
        }
    }

    fun remove(superheroId: Int) {
        sharedPref.edit().remove(superheroId.toString()).apply()
    }
}