package com.example.retrofit.data.network

import androidx.lifecycle.LiveData
import com.example.retrofit.core.Constants
import com.example.retrofit.domain.model.movie_model.MovieDto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movies/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<MovieDto>

}