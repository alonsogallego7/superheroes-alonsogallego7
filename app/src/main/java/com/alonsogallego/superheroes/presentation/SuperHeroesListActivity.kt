package com.alonsogallego.superheroes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.superheroes.R
import com.alonsogallego.superheroes.data.remote.SuperHeroesApiService

class SuperHeroesListActivity : AppCompatActivity() {

    val viewModel = SuperHeroesFactory.getViewModel(
        getSharedPreferences("sharedPref", MODE_PRIVATE)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroes_list)

    }
}