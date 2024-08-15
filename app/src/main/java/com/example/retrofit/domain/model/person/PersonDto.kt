package com.example.retrofit.domain.model.person

data class PersonDto(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)