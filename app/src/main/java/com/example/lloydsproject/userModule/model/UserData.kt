package com.example.lloydsproject.userModule.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserData(
    @SerializedName("id") @PrimaryKey var id: Int,
    @SerializedName("email") var email: String? = null,
    @SerializedName("first_name") var firstName: String? = null,
    @SerializedName("last_name") var lastName: String? = null,
    @SerializedName("avatar") var avatar: String? = null
)
