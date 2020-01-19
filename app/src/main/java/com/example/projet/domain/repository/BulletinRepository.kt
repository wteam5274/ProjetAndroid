package com.example.projet.domain.repository

import com.example.projet.data.models.Bulletin
import io.reactivex.Single

interface BulletinRepository {
    fun getBulletins(cin: String) : Single<Bulletin>
}