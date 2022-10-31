package com.alonsogallego.superheroes.data.remote.models

data class SuperHeroApiModel (val id: Int, val name: String, val images: Images, val biography: SuperHeroBiographyApiModel, val work: SuperHeroWorkApiModel, val powerstats: Powerstats, val connections: SuperHeroConnectionsApiModel)
data class SuperHeroConnectionsApiModel (val groupAffiliation: String)
data class Powerstats (val intelligence: Int, val speed: Int, val combat: Int)
data class Images (val xs: String, val sm: String, val md: String, val lg: String)
data class SuperHeroBiographyApiModel (val fullName: String, val alignment: String)
data class SuperHeroWorkApiModel (val occupation: String)
