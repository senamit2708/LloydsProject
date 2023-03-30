package com.example.lloydsproject.userModule.model

import com.google.gson.annotations.SerializedName

data class ResponseUserData(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("data") var data: ArrayList<UserData> = arrayListOf(),
    @SerializedName("support") var support: Support? = Support()
)
