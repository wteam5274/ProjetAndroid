package com.example.projet.data.repository

import android.app.Application
import com.example.projet.data.local.ScreenDao
import com.example.projet.data.models.Screen
import com.example.projet.data.models.Screens
import com.example.projet.data.utils.Utils
import com.example.projet.domain.repository.ScreenRepository
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreensRepositoryImpl @Inject
constructor(
    private val application: Application,
    private val screenDao: ScreenDao
) : ScreenRepository {

    override fun getScreens(): Single<List<Screen>> {
        val gson = Gson()
        val string = Utils.readJSONFromAsset(application.applicationContext, "get-screens.json")
        val screens = gson.fromJson(string, Screens::class.java)
        screenDao.saveAllScreens(screens.screens)
        return Single.just(screens.screens)
    }

}