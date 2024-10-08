package com.example.retrofit.presentation.movie_list_screen.items

sealed class Event {
    data object MovieButtonClicked : Event()
    data object ShowsButtonClicked : Event()
    data object PopularButtonClicked : Event()
    data object UpcomingButtonClicked : Event()
    data object TopRatedButtonClicked : Event()
}