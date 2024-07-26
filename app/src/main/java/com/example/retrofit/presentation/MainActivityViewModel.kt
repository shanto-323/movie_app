package com.example.retrofit.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.network.ApiService
import com.example.retrofit.domain.model.Model
import com.example.retrofit.domain.model.ModelItem
import com.example.retrofit.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _todos = MutableStateFlow(Model())
    val todos: StateFlow<Model> = _todos//.asStateFlow()


    fun fetchTodos() = viewModelScope.launch {
        val response = repository.getListOfTodos()
        try{
            _todos.value = response.body()!!
        }catch (e: Exception){
            println("This line is Error${e.message}")
        }
    }
}