package com.alonsogallego.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.bind
import android.util.Log
import android.widget.TextView
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero

class SuperHeroesListActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroesBinding? = null

    val viewModel by lazy {
        SuperHeroesFactory.getViewModel(
            getSharedPreferences("nombre_shared_pref", MODE_PRIVATE)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_superheroes)
        binding = ActivitySuperheroesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        loadSuperHeroes()
    }

    private fun loadSuperHeroes() {
        viewModel.obtainSuperHeroes(object : SuperHeroesCallback {
            override fun onCall(superHeroes: List<SuperHero>) {
                bind(superHeroes)
            }
        })
    }

    private fun bind(superHeroes: List<SuperHero>) {
        binding?.apply {
            name.text = "asd"
            realName.text = "asd"
        }
    }


}