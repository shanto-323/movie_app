package com.example.retrofit.data.remote

import com.example.retrofit.core.Resource
import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.movie_model.Result
import com.example.retrofit.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    apiService: ApiService
) : Repository {
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ): Flow<Resource<List<Result>>> {
        return flow {
            emit(Resource.Loading(true))
            val movieList = try {
                apiService.getMovieList(type, page)
            }catch (e: Exception){}
        }
    }

}