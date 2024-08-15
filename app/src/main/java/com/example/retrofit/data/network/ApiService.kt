package com.example.retrofit.data.network

import com.example.retrofit.utils.Constants
import com.example.retrofit.domain.model.movie_model.MovieDto
import com.example.retrofit.domain.model.person.PersonDto
import com.example.retrofit_api.movie_app.movie_model.Result
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

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query:String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<MovieDto>

    @GET("trending/movie/day")
    suspend fun trendingMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<MovieDto>


    @GET("movie/{id}")
    suspend fun getMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<Result>

    @GET("movie/{id}/similar")
    suspend fun similarMovies(
        @Path("id") query:Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<MovieDto>



    @GET("movie/{id}/credits")
    suspend fun personSearch(
        @Path("id") query:Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Response<PersonDto>
}