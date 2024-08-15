package com.example.retrofit.presentation.movie_list_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.utils.Constants
import com.example.retrofit.data.pagination.PaginationFactory
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.movie_list_screen.items.Event
import com.example.retrofit.presentation.movie_list_screen.items.State
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
        loadNext()
    }

    private inline fun pagination() = PaginationFactory(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = {next ->
            repository.getMovieList(state.movieType,next)
        },
        getNextKey = { state.page + 1},
        onError = {
            state = state.copy(
                error = it!!.localizedMessage
            )
        },
        onSuccess = {items, newPage ->
            state = state.copy(
                dataItems = state.dataItems + items.results,
                page =  newPage,
                endReached = state.page == items.total_pages
            )
        }
    )


    fun loadNext() {
        viewModelScope.launch {
            pagination()?.newPage()
        }
    }
    private fun reset() {
        viewModelScope.launch {
            pagination().reset()
        }
    }


    private fun changeMovieType(newType: String) {
        state = state.copy(
            movieType = newType,
            page = 1,
            dataItems = emptyList(),
            endReached = false
        )
        reset()
        loadNext()
    }

    fun onEvent(event: Event) {
        when (event) {
            Event.MovieButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_POPULAR)
                changeMovieType(Constants.MOVIE_TYPE_POPULAR)
            }

            Event.PopularButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_POPULAR)
                changeMovieType(Constants.MOVIE_TYPE_POPULAR)
            }

            Event.ShowsButtonClicked -> TODO()
            Event.TopRatedButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_TOP_RATED)
                changeMovieType(Constants.MOVIE_TYPE_TOP_RATED)
            }

            Event.UpcomingButtonClicked -> {
                state = state.copy(movieType = Constants.MOVIE_TYPE_UPCOMING)
                changeMovieType(Constants.MOVIE_TYPE_UPCOMING)
            }

        }
    }
}