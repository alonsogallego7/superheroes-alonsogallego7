package com.alonsogallego.superheroes.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.superheroes.presentation.SuperHeroCallback
import com.alonsogallego.superheroes.domain.GetSuperHeroFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHerosViewModel(private val getSuperHerosFeed: GetSuperHeroFeedUseCase) : ViewModel() {

    //Publisher
    val superHeroFeedPublisher: MutableLiveData<List<GetSuperHeroFeedUseCase.SuperHeroFeed>> by lazy {
        MutableLiveData<List<GetSuperHeroFeedUseCase.SuperHeroFeed>>()
    }

    fun loadSuperHeros() {
        viewModelScope.launch(Dispatchers.IO) {
            val superHerosFeed = getSuperHerosFeed.execute()
            superHeroFeedPublisher.postValue(superHerosFeed)
        }
    }

    fun loadSuperHerosWithCallbacks(superHeroCallback: SuperHeroCallback) {
        viewModelScope.launch(Dispatchers.IO) {
            val superHerosFeed = getSuperHerosFeed.execute()
            withContext(Dispatchers.Main) {
                superHeroCallback.onCall(superHerosFeed)
            }
        }
    }
}