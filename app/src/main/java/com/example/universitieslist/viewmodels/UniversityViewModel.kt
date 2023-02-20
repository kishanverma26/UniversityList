package com.example.universitieslist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.universitieslist.models.UniversityRes
import com.example.universitieslist.repository.UniversityRepository
import kotlinx.coroutines.launch

class UniversityViewModel(val repository: UniversityRepository) : ViewModel() {

    val universityList: LiveData<ArrayList<UniversityRes>>
    get() = repository.universityList

     fun getList(countryName:String){
        viewModelScope.launch {
            repository.getUniversity(countryName)
        }
    }
}