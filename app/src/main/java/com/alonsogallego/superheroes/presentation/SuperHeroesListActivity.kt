package com.alonsogallego.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroesListActivity : AppCompatActivity() {

    val viewModel by lazy {
        SuperHeroesFactory.getViewModel(
            getSharedPreferences("nombre_shared_pref", MODE_PRIVATE)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroes_list)
        getSuperHeroes()
    }

    fun getSuperHeroes() {
        viewModel.obtainSuperHeroes(object : SuperHeroesCallback {
            override fun onCall(superHeroes: List<SuperHero>) {
                Log.d("@dev", "Ejecutado...")
                runOnUiThread {
                    findViewById<TextView>(R.id.name).text = superHeroes.first().name
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("@dev", "Destroy...")
    }
}