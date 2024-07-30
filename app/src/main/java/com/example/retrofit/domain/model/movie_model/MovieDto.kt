package com.example.retrofit.domain.model.movie_model

import com.example.retrofit_api.movie_app.movie_model.MovieResult

data class MovieDto(
    val page: Int,
    val movieResults: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)