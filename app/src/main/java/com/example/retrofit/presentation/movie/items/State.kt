package com.example.retrofit.presentation.movie.items

import com.example.retrofit.core.Constants
import com.example.retrofit_api.movie_app.movie_model.Result

data class State(
    val dataItems: List<Result> = emptyList(),
    val movieResult: Result? = null,
    val id : Int = 0,
    val movieType: String = Constants.MOVIE_TYPE_POPULAR,
    val page : Int = 1
)