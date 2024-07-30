package com.example.retrofit.domain.model.tv_model

data class TvDto(
    val page: Int,
    val tv_results: List<TvResult>,
    val total_pages: Int,
    val total_results: Int
)