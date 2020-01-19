package com.example.projet.domain.repository

import com.example.projet.data.models.Screen
import io.reactivex.Single

interface ScreenRepository {
    fun getScreens() : Single<List<Screen>>
}