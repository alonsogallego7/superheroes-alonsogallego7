package com.alonsogallego.superheroes.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogallego.superheroes.databinding.ActivitySuperheroeFeedBinding
import com.alonsogallego.superheroes.domain.GetSuperHeroFeedUseCase
import com.alonsogallego.superheroes.presentation.adapter.SuperHeroAdapter

class SuperHerosFeedActivity : AppCompatActivity() {

    private var binding: ActivitySuperheroeFeedBinding? = null
    private val superHeroAdapter = SuperHeroAdapter()
    private val viewModel by lazy {
        SuperHeroFactory().getSuperHerosViewModel(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupView()
        setupObservers()
        viewModel.loadSuperHeros()
    }

    private fun setupBinding() {
        binding = ActivitySuperheroeFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView() {
        binding?.apply {
            listSuperheroe.adapter = superHeroAdapter
            listSuperheroe.layoutManager =
                LinearLayoutManager(
                    this@SuperHerosFeedActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    private fun setupObservers() {
        // Create the observer which updates the UI.
        val superHeroFeedSubscriber =
            Observer<List<GetSuperHeroFeedUseCase.SuperHeroFeed>> { superHerosFeed ->
                //entro aquí
                superHeroAdapter.setDataItems(superHerosFeed)
            }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.superHeroFeedPublisher.observe(this, superHeroFeedSubscriber)
    }

    private fun loadSuperHerosWithCallbacks() {
        viewModel.loadSuperHerosWithCallbacks(object : SuperHeroCallback {
            override fun onCall(superHerosFeed: List<GetSuperHeroFeedUseCase.SuperHeroFeed>) {
                superHeroAdapter.setDataItems(superHerosFeed)
            }
        })
    }
}