package com.example.projet.data.repository

import com.example.projet.data.local.RevenueDao
import com.example.projet.data.models.Revenue
import com.example.projet.data.remote.RemoteService
import com.example.projet.domain.repository.RevenuesRepository
import com.example.projet.extensions.withDefaultSchedulers
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RevenuesRepositoryImpl @Inject
constructor(
    private val remoteService: RemoteService,
    private val revenueDao: RevenueDao
) : RevenuesRepository {

    /**
     * get list revnues
     */
    override fun getRevenues(): Single<List<Revenue>> {
        return remoteService.getRevenues()
            .withDefaultSchedulers()
            .map {
                revenueDao.saveAllRevenues(it)
                it
            }
    }

    /**
     * get revenue by cin
     */
    override fun getRevenuesByCIN(cin: String): Single<List<Revenue>> {
        return remoteService.getRevenues(cin).withDefaultSchedulers()
            .map {
                revenueDao.saveAllRevenues(it)
                it
            }
    }

    /**
     * get revenue by id
     */
    override fun getRevenueById(id: Int): Single<Revenue> {
        return remoteService.getRevenues(id).withDefaultSchedulers()
            .map {
                revenueDao.saveRevenue(it)
                it
            }

    }


}