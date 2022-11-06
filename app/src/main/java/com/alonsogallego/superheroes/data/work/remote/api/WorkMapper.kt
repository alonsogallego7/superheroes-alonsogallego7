package com.alonsogallego.superheroes.data.work.remote.api

import com.alonsogallego.superheroes.data.work.remote.api.WorkApiModel
import com.alonsogallego.superheroes.domain.Work

fun WorkApiModel.toDomain() = Work(this.occupation)