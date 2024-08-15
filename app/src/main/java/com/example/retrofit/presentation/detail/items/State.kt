package com.example.retrofit.presentation.detail.items

import com.example.retrofit.domain.model.person.Cast
import com.example.retrofit.domain.model.person.PersonDto
import com.example.retrofit_api.movie_app.movie_model.Result

data class State (
    val movieResult: Result? = null,
    val personResult: List<Cast> = emptyList(),
    val similarMovies: List<Result> = emptyList(),
)