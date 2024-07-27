package com.example.retrofit.domain.repository

import com.example.retrofit.core.Resource
import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.Model
import com.example.retrofit.domain.model.movie_model.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface Repository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ) : Flow<Resource<List<Result>>>
}