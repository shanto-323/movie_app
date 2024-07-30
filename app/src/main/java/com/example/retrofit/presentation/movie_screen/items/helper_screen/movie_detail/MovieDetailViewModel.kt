package com.example.retrofit.presentation.movie_screen.items.helper_screen.movie_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.movie_screen.items.State
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
}


