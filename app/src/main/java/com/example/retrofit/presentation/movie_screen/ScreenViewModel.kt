package com.example.retrofit.presentation.movie_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.Constants
import com.example.retrofit.domain.repository.Repository
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

    init {

        viewModelScope.launch {
            val movieResults = repository.getMovieList(Constants.MOVIE_TYPE_POPULAR,2).body()?.results
            if (movieResults != null) {
                state = state.copy(dataItems = movieResults)
            } else {
                println{"Movie results is null"}
            }
        }
    }
}