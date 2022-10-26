package com.alonsogallego.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.domain.SuperHero
import com.alonsogallego.superheroes.presentation.adapter.SuperHeroAdapter

class SuperHeroesListActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroesBinding? = null
    private var superHeroeAdapter: SuperHeroAdapter = SuperHeroAdapter()

    private val viewModel by lazy {
        SuperHeroesFactory.getViewModel(
            applicationContext,
            getSharedPreferences("nombre_shared_pref", MODE_PRIVATE)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        loadSuperHeroes()
    }

    private fun setupView() {
        binding = ActivitySuperheroesBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            listSuperheroes.adapter = superHeroeAdapter
            val verticalLayout = LinearLayoutManager(this@SuperHeroesListActivity)
            verticalLayout.orientation = LinearLayoutManager.VERTICAL
            listSuperheroes.layoutManager = verticalLayout
        }
    }

    private fun loadSuperHeroes() {
        viewModel.obtainSuperHeroes(object : SuperHeroesCallback {
            override fun onCall(superHeroes: List<SuperHero>) {
                updateList(superHeroes)
            }
        })
    }

    private fun updateList(superHeroes: List<SuperHero>) {
        superHeroeAdapter.loadList(superHeroes)
    }
}