package com.example.projet.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bulletin")
data class Bulletin(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("address") val address: String,
    @SerializedName("birthDate") val birthDate: String,
    @SerializedName("birthPlace") val birthPlace: String,
    @SerializedName("cin") val cin: String,
    @SerializedName("dateConviction") val dateConviction: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("matherName") val matherName: String,
    @SerializedName("natureSentences") val natureSentences: String,
    @SerializedName("offenseNature") val offenseNature: String,
    @SerializedName("sentencesDuration") val sentencesDuration: String,
    @SerializedName("tribunal") val tribunal: String,
    @SerializedName("work") val work: String
)