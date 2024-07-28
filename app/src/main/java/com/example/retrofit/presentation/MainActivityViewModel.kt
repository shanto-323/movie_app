package com.example.retrofit.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit_api.movie_app.movie_model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(MovieState())

    init {
        viewModelScope.launch {
            val response = repository.getMovieList("popular", 1)
            state = state.copy(
                data = response.body()!!.results
            )
        }
    }
}


data class MovieState(
    val data: List<Result> = emptyList()
)