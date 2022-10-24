package com.alonsogallego.superheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.alonsogallego.superheroes.data.remote.SuperHeroesApiService
import com.alonsogallego.superheroes.presentation.SuperHeroesListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.actionOpenSuperHeroes).setOnClickListener {
            val intent = Intent(this, SuperHeroesListActivity::class.java)
            startActivity(intent)
        }
    }

}