package com.example.retrofit.presentation.movie_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.Constants
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.movie_screen.items.Event
import com.example.retrofit.presentation.movie_screen.items.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(State())
        private set

    fun onEvent(event: Event){
        when(event){
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

   fun fetchData(){
        viewModelScope.launch {
            val movieResults = repository.getMovieList(state.movieType,state.page).body()?.movieResults
            if (movieResults != null) {
                state = state.copy(dataItems = movieResults)
            } else {
                println{"Movie results is null"}
            }
        }
    }

    fun fetchData2(){
        viewModelScope.launch {
            val movieResults = repository.getTvList().body()?.tv_results
            if (movieResults != null) {
                state = state.copy(tvdataItems = movieResults)
                println("Working")
            } else {
                println{"Movie results is null"}
            }
        }
    }
}