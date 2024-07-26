package com.example.retrofit.domain.repository

import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.Model
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
)  {
    suspend fun getListOfTodos(): Response<Model> {
        return apiService.getListOfTodos()
    }

}