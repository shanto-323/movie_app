package com.example.retrofit.presentation.main_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.domain.repository.Repository
import com.example.retrofit.presentation.main_screen.items.State
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
        fetchData()
    }
    private fun fetchData(){
        try {
            viewModelScope.launch {
                val response = repository.getTrendingList()
                if (response != null) {
                    println("Working")
                    state = state.copy(
                        image = response.body()!!.results
                    )
                }else{
                    println("null")
                }
            }
        } catch (e: Exception) {
            println("this is problem $e")
        }
    }
}