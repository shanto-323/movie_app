package com.example.retrofit.domain.repository

import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.movie_model.MovieDto
import com.example.retrofit.domain.model.tv_model.TvDto
import com.example.retrofit.domain.model.tv_model.TvResult
import com.example.retrofit_api.movie_app.movie_model.MovieResult
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieList(type: String,page: Int): Response<MovieDto> {
        return apiService.getMovieList(type,page)
    }

    suspend fun getMovie(id: Int): Response<MovieResult> {
        return apiService.getMovie(id)
    }

    suspend fun getTvList(): Response<TvDto> {
        return apiService.getTvShows()
    }

    suspend fun getTv(id: Int): Response<TvResult> {
        return apiService.getTv(id)
    }
}