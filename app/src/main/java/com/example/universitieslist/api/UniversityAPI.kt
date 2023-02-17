package com.example.universitieslist.api

import com.example.universitieslist.models.UniversityRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityAPI {
    @GET("search?")
    suspend fun getUniversity(@Query("country") country:String) : Response<ArrayList<UniversityRes>>
}