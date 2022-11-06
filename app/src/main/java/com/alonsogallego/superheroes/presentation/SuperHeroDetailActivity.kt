package com.alonsogallego.superheroes.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.databinding.ActivitySuperheroesBinding
import com.alonsogallego.superheroes.domain.SuperHero
import com.alonsogallego.superheroes.presentation.adapter.detail.SuperHeroDetailAdapter

class SuperHeroDetailActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroesBinding? = null
    private var superHeroeAdapter: SuperHeroDetailAdapter = SuperHeroDetailAdapter()

    private val viewModel by lazy {
        SuperHeroesDetailFactory.getViewModel(
            applicationContext,
            getSharedPreferences("nombre_shared_pref", MODE_PRIVATE)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)
        setupView()
        val superHeroeId = intent.getIntExtra(KEY_SUPERHEROE_ID, 1)
        supportActionBar?.title = "SuperHeroe:$superHeroeId"
        loadSuperHeroe(superHeroeId)
    }

    private fun setupView() {
        binding = ActivitySuperheroesBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.apply {
            listSuperheroes.adapter = superHeroeAdapter
            val verticalLayout = LinearLayoutManager(this@SuperHeroDetailActivity)
            verticalLayout.orientation = LinearLayoutManager.VERTICAL
            listSuperheroes.layoutManager = verticalLayout
        }
    }

    private fun loadSuperHeroe(superHeroeId: Int) {
        viewModel.obtainSuperHero(superHeroeId, object : SuperHeroCallback {
            override fun onCall(superHero: SuperHero) {
                updateSuperHero(superHero)
            }
        })
    }

    companion object {
        val KEY_SUPERHEROE_ID = "SUPERHEROE_ID_KEY"
        fun createIntent(context: Context, superHeroeId: Int): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHEROE_ID, superHeroeId)
            return intent
        }
    }

    private fun updateSuperHero(superHero: SuperHero) {
        superHeroeAdapter.loadSuperHero(superHero)
    }
}