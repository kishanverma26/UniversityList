package com.example.universitieslist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.universitieslist.api.UniversityAPI
import com.example.universitieslist.models.UniversityRes
import javax.inject.Inject

class UniversityRepository @Inject constructor(private val universityAPI: UniversityAPI) {

    private val _universityList= MutableLiveData<ArrayList<UniversityRes>>()
     val universityList: LiveData<ArrayList<UniversityRes>>
    get() = _universityList

    suspend fun getUniversity(country:String){
        val result = universityAPI.getUniversity(country)
        if (result.isSuccessful){
            _universityList.postValue(result.body())
        }
    }
}