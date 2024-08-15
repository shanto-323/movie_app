package com.example.retrofit.presentation.search_screen.items

import com.example.retrofit_api.movie_app.movie_model.Result

sealed class Event {
    data class ListChange(val list: List<Result>) : Event()
    data class NameChange(val name: String) : Event()
}