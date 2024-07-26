package com.example.retrofit.data.network

import androidx.lifecycle.LiveData
import com.example.retrofit.domain.model.Model
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("todos")
    suspend fun getListOfTodos(): Response<Model>
}