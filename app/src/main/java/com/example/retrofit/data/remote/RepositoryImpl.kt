package com.example.retrofit.data.remote

import com.example.retrofit.core.Resource
import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.movie_model.MovieDto
import com.example.retrofit.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun getMovieList(type: String, page: Int): Response<MovieDto> {
        return apiService.getMovieList(type, page)
    }
}