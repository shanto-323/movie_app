package com.example.retrofit.data.network

import com.example.retrofit.core.Constants
import com.example.retrofit.domain.model.movie_model.MovieDto
import com.example.retrofit.domain.model.tv_model.TvDto
import com.example.retrofit.domain.model.tv_model.TvResult
import com.example.retrofit_api.movie_app.movie_model.MovieResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/{type}")
    suspend fun getMovieList(
        @Path("type") type: String,
        @Query("page") page:Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<MovieDto>

    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<MovieResult>

    @GET("tv/top_rated")
    suspend fun getTvShows(
//        @Path("type") type: String,
//        @Query("id") id: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ) : Response<TvDto>

    @GET("tv/{id}")
    suspend fun getTv(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ) : Response<TvResult>
}