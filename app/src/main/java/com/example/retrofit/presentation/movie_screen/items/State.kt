package com.example.retrofit.presentation.movie_screen.items

import com.example.retrofit_api.movie_app.movie_model.Result

data class State(
    val dataItems: List<Result> = emptyList()
)