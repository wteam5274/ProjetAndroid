package com.example.projet.data.repository

import com.example.projet.data.local.PersonDao
import com.example.projet.data.models.Person
import com.example.projet.data.remote.RemoteService
import com.example.projet.domain.repository.PersonRepository
import com.example.projet.extensions.withDefaultSchedulers
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonRepositoryImpl @Inject
constructor(
    private val remoteService: RemoteService,
    private val personDao: PersonDao
) : PersonRepository {
    override fun getPersonsByInfo(cin: String, firstName: String, lastName: String, birthDate: String): Single<Person> {
        return remoteService.getInforPerso(cin)
            .withDefaultSchedulers()
            .map {
                personDao.savePerson(it)
                it
            }
    }


}