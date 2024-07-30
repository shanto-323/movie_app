package com.example.retrofit.presentation.movie_screen.items

import com.example.retrofit.core.Constants
import com.example.retrofit.domain.model.tv_model.TvResult
import com.example.retrofit_api.movie_app.movie_model.MovieResult

data class State(
    val dataItems: List<MovieResult> = emptyList(),
    val tvdataItems: List<TvResult> = emptyList(),
    val movieResult: MovieResult? = null,
    val id : Int = 0,
    val movieType: String = Constants.MOVIE_TYPE_POPULAR,
    val page : Int = 1
)