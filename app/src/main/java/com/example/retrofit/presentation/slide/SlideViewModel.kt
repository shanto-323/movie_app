package com.example.retrofit.presentation.slide

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
class SlideViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var state by mutableStateOf(State())
        private set

    init {
        try {
            viewModelScope.launch {
                val response = repository.getMovieList(Constants.MOVIE_TYPE_UPCOMING, 1)
                if (response != null) {
                    state = state.copy(
                        image = response.body()!!.results
                    )
                }else{
                    println("null")
                }
            }
        } catch (e: Exception) {
            println(e)
        }
    }
}


data class State(
    val image: List<Result> = emptyList()
)