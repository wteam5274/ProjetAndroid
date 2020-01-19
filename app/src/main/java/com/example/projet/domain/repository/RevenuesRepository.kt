package com.example.projet.domain.repository

import com.example.projet.data.models.Revenue
import io.reactivex.Single

interface RevenuesRepository {
    fun getRevenues(): Single<List<Revenue>>
    fun getRevenuesByCIN(cin: String): Single<List<Revenue>>
    fun getRevenueById(id: Int): Single<Revenue>
}