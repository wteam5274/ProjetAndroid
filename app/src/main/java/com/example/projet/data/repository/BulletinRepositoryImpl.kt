package com.example.projet.data.repository

import com.example.projet.data.local.BulletinDao
import com.example.projet.data.models.Bulletin
import com.example.projet.data.remote.RemoteService
import com.example.projet.domain.repository.BulletinRepository
import com.example.projet.extensions.withDefaultSchedulers
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BulletinRepositoryImpl @Inject
constructor(
    private val remoteService: RemoteService,
    private val bulletinDao: BulletinDao
) : BulletinRepository {
    override fun getBulletins(cin: String): Single<Bulletin> {

        return remoteService.getBulletins(cin)
            .withDefaultSchedulers()
            .map {
                bulletinDao.saveBulletin(it)
                it
            }
    }
}