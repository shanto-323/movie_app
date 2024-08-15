package com.example.retrofit.presentation.movie_list_screen.items

import com.example.retrofit.utils.Constants
import com.example.retrofit_api.movie_app.movie_model.Result

data class State(
    val dataItems: List<Result> = emptyList(),
    val id : Int = 0,
    val movieType: String = Constants.MOVIE_TYPE_POPULAR,
    val page : Int = 1,
    val isLoading: Boolean = false,
    val error: String = "",
    val endReached: Boolean = false,
)