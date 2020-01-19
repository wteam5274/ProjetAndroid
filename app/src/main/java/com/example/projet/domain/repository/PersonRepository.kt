package com.example.projet.domain.repository

import com.example.projet.data.models.Person
import io.reactivex.Single

interface PersonRepository {
    fun getPersonsByInfo(cin: String, firstName: String, lastName: String, birthDate: String): Single<Person>
}