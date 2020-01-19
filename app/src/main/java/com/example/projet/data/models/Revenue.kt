package com.example.projet.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "revenue")
data class Revenue(
    @PrimaryKey
    @SerializedName("id") var id: Int,
    @SerializedName("cin") var cin: String,
    @SerializedName("namePerson") var namePerson: String,
    @SerializedName("type") var type: String,
    @SerializedName("description") var description: String,
    @SerializedName("amount") var amount: Double
)