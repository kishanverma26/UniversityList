package com.example.universitieslist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.universitieslist.repository.UniversityRepository
import javax.inject.Inject

class UniversityViewModelFactory @Inject constructor(private val repository: UniversityRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UniversityViewModel(repository) as T
    }
}