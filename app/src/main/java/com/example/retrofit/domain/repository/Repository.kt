package com.example.retrofit.domain.repository

import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.movie_model.MovieDto
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieList(type: String, page: Int): Response<MovieDto> {
        return apiService.getMovieList(type, page)
    }
}