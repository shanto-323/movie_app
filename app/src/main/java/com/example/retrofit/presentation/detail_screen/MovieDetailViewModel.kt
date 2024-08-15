package com.example.retrofit.presentation.detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.detail_screen.items.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(State())
        private set
    fun getMovie(id : Int){
        viewModelScope.launch {
            val movie = repository.getMovie(id).body()
            if (movie != null) {
                state = state.copy(movieResult = movie)
            } else {
                println{"Movie results is null"}
            }
        }
    }

    fun getPerson(id : Int){
        viewModelScope.launch {
            val person = repository.getPerson(id)
            if (person != null) {
                state = state.copy(personResult = person.body()!!.cast)
            } else {
                "not Working"
            }
        }
    }

    fun getSimilarMovies(id : Int){
        viewModelScope.launch {
            val person = repository.getSimilarMovies(id)
            if (person != null) {
                state = state.copy(similarMovies = person.body()!!.results)
            } else {
                "not Working"
            }
        }
    }
}


