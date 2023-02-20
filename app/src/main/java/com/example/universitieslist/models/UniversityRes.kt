package com.example.universitieslist.models

import com.google.gson.annotations.SerializedName

data class UniversityRes (
    @SerializedName("domains"        ) var domains        : ArrayList<String> = arrayListOf(),
    @SerializedName("country"        ) var country        : String?           = null,
    @SerializedName("alpha_two_code" ) var alphaTwoCode   : String?           = null,
    @SerializedName("web_pages"      ) var webPages       : ArrayList<String> = arrayListOf(),
    @SerializedName("state-province" ) var state_province : String?           ,
    @SerializedName("name"           ) var name           : String?           = null
)
