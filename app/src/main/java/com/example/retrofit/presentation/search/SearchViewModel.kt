package com.example.retrofit.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.search.items.State
import com.example.retrofit.presentation.search.items.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(State())
        private set

    fun onEvent(event: Event) {
        when (event) {
            is Event.ListChange -> {
                state = state.copy(dataItems = event.list)
            }

            is Event.NameChange -> {
                state = state.copy(name = event.name)
                getMovie(state.name)
            }
        }
    }

    fun getMovie(query:String){
        try {
            viewModelScope.launch {
                val movieResults =
                    repository.getSearchedList(query).body()?.results
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
}