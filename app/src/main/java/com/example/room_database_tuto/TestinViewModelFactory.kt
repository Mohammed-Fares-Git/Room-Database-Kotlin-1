package com.example.room_database_tuto

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.room_database_tuto.repositry.Repository
import javax.inject.Inject

class TestinViewModelFactory @Inject constructor(private val repository: Repository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestingViewModel::class.java)) {
            return TestingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}