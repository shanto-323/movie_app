package com.example.retrofit.presentation.search.items

import com.example.retrofit_api.movie_app.movie_model.Result

data class State(
    val dataItems: List<Result> = emptyList(),
    val name : String = ""
)
