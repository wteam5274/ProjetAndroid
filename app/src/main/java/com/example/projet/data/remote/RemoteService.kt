package com.example.projet.data.remote

import com.example.projet.data.models.Bulletin
import com.example.projet.data.models.Person
import com.example.projet.data.models.Revenue
import io.reactivex.Single
import retrofit2.http.*

interface RemoteService {

    @GET("/revenue")
    fun getRevenues(): Single<List<Revenue>>

    /**
     * get list revenue by cin ws
     */
    @GET("/revenue/cin")
    fun getRevenues(@Query("cin") cin: String): Single<List<Revenue>>

    /**
     * get list revenue by cin ws
     */
    @GET("interior/cin")
    fun getBulletins(@Query("cin") cin: String): Single<Bulletin>


    /**
     * get list revenue by cin ws
     */
    @GET("/revenue/id")
    fun getRevenues(@Query("cin") cin: Int): Single<Revenue>

    /**
     * get municipality by cin
     */
    @GET("/municipality")
    fun getInforPerso(@Query("cin") cin: String): Single<Person>


}