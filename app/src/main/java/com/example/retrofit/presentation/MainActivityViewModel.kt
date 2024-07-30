package com.example.retrofit.presentation

import androidx.lifecycle.ViewModel
import com.example.retrofit.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
}