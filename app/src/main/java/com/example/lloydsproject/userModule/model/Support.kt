package com.example.lloydsproject.userModule.model

import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("url") var url: String? = null,
    @SerializedName("text") var text: String? = null
)
