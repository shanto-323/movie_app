package com.example.retrofit.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.core.Constants
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit_api.movie_app.movie_model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(ScreenState())

    init {
        viewModelScope.launch {
            val movieResults = repository.getMovieList(Constants.MOVIE_TYPE_POPULAR,1).body()?.results
            if (movieResults != null) {
                state = state.copy(dataItems = movieResults)
            } else {
                println{"Movie results is null"}
            }
        }
    }

}


data class ScreenState(
    val dataItems: List<Result> = emptyList()
)