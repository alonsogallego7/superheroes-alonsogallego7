package com.alonsogallego.superheroes.presentation

import com.alonsogallego.superheroes.domain.GetSuperHeroDetailUseCase
import com.alonsogallego.superheroes.domain.GetSuperHeroFeedUseCase

interface SuperHeroCallback {
    fun onCall(superHerosFeed: List<GetSuperHeroFeedUseCase.SuperHeroFeed>)
}

interface SuperHeroDetailCallback {
    fun onCall(superHeroDetail: GetSuperHeroDetailUseCase.SuperHeroDetail)
}