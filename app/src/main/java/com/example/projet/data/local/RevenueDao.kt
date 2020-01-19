package com.example.projet.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projet.data.models.Revenue

@Dao
interface RevenueDao {

    @Query("SELECT * FROM revenue")
    fun getRevenues(): List<Revenue>

    @Query("SELECT * FROM revenue WHERE cin = :cin")
    fun getRevenues(cin: String): List<Revenue>

    @Query("SELECT * FROM revenue WHERE cin = :id")
    fun getRevenue(id: Int): Revenue?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllRevenues(screens: List<Revenue>)

    @Insert
    fun saveRevenue(screen: Revenue)

    @Query("DELETE FROM revenue")
    fun clear()
}