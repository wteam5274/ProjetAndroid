package com.example.projet.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class Person(
    @PrimaryKey
    @SerializedName("id") var id: Int,
    @SerializedName("birthDate") var birthDate: String,
    @SerializedName("birthPlace") var birthPlace: String,
    @SerializedName("cin") var cin: String,
    @SerializedName("fatherName") var fatherName: String,
    @SerializedName("firstName") var firstName: String,
    @SerializedName("gender") var gender: String,
    @SerializedName("lastName") var lastName: String,
    @SerializedName("matherName") var matherName: String,
    @SerializedName("nationalityFather") var nationalityFather: String,
    @SerializedName("nationalityMather") var nationalityMather: String,
    @SerializedName("reportingDate") var reportingDate: String,
    @SerializedName("reportingName") var reportingName: String,
    @SerializedName("stateRegistrarName") var stateRegistrarName: String
)