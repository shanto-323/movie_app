package com.example.retrofit.presentation.movie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.Constants
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.movie.items.Event
import com.example.retrofit.presentation.movie.items.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(State())
        private set

    init {
        println("Working")
        try {
            viewModelScope.launch {
                val movieResults =
                    repository.movieDiscover().body()?.results
                if (movieResults != null) {
                    state = state.copy(dataItems = movieResults)
                } else {
                    println { "Movie results is null" }
                }
            }
        } catch (e: Exception) {
            println("Error")
        }

    }

    fun onEvent(event: Event) {
        when (event) {
            Event.MovieButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_POPULAR)
                fetchData()
            }

            Event.PopularButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_POPULAR)
                fetchData()
            }

            Event.ShowsButtonClicked -> TODO()
            Event.TopRatedButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_TOP_RATED)
                fetchData()
            }

            Event.UpcomingButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_UPCOMING)
                fetchData()
            }




            Event.NextButtonClicked -> {
                state = state.copy(page = state.page + 1)
                fetchData()
            }

            Event.PrevButtonClicked -> {

            }
        }
    }



    private fun fetchData() {
        println("Working Here")
        viewModelScope.launch {
            val movieResults =
                repository.getMovieList(state.movieType, state.page).body()?.results
            if (movieResults != null) {
                state = state.copy(dataItems = movieResults)
            } else {
                println { "Movie results is null" }
            }
        }
    }
}