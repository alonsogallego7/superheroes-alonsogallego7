package com.alonsogallego.superheroes.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alonsogallego.superheroes.domain.GetSuperHeroDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(private val getSuperHeroDetailUseCase: GetSuperHeroDetailUseCase) :
    ViewModel() {

    val superHeroDetailPublisher: MutableLiveData<GetSuperHeroDetailUseCase.SuperHeroDetail> by lazy {
        MutableLiveData<GetSuperHeroDetailUseCase.SuperHeroDetail>()
    }

    fun loadSuperHeroDetails(superHeroId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            superHeroDetailPublisher.postValue(getSuperHeroDetailUseCase.execute(superHeroId))
        }
    }

}