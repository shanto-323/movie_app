package com.example.retrofit.presentation.main_screen.items

import com.example.retrofit_api.movie_app.movie_model.Result

data class State(
    val image: List<Result> = emptyList()
)
