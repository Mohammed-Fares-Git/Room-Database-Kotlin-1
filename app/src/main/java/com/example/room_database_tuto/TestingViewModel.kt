package com.example.room_database_tuto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room_database_tuto.repositry.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestingViewModel(val repository: Repository): ViewModel() {

    private val _textStateFlow: MutableStateFlow<String> = MutableStateFlow("Mohammed-Fares-Git")
    val textState: StateFlow<String>
        get() = _textStateFlow

    init {
        viewModelScope.launch {
            repository.getAll().collect { appartements ->
                val appartementsFlow = appartements.asFlow()

                appartementsFlow.collect { appartement ->
                    delay(1000L)
                    _textStateFlow.value = appartements.toString()
                }
            }
        }
    }
}