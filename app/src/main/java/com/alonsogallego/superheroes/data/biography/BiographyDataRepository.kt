package com.alonsogallego.superheroes.data.biography

import com.alonsogallego.superheroes.data.biography.local.BiographyLocalDataSource
import com.alonsogallego.superheroes.data.biography.remote.BiographyRemoteDataSource
import com.alonsogallego.superheroes.domain.Biography
import com.alonsogallego.superheroes.domain.BiographyRepository

class BiographyDataRepository(
    val localDataSource: BiographyLocalDataSource,
    val remoteDataSource: BiographyRemoteDataSource
) :
    BiographyRepository {

    override fun getBiography(superHeroId: Int): Biography {
        var biography = localDataSource.getBiography(superHeroId)
        if (biography == null) {
            biography = remoteDataSource.getBiography(superHeroId)
            if (biography != null) {
                localDataSource.save(superHeroId, biography)
            }
        }
        return biography!!
    }
}