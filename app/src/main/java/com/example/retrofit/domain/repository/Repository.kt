package com.example.retrofit.domain.repository

import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.movie_model.MovieDto
import com.example.retrofit_api.movie_app.movie_model.Result
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieList(type: String,page: Int): Response<MovieDto> {
        return apiService.getMovieList(type,page)
    }

    suspend fun movieDiscover(): Response<MovieDto> {
        return apiService.discoverMovie()
    }

    suspend fun getMovie(id: Int): Response<Result> {
        return apiService.getMovie(id)
    }
}