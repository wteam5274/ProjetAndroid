package com.example.projet.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projet.data.models.Bulletin

@Dao
interface BulletinDao {

    @Query("SELECT * FROM bulletin")
    fun getBulletins(): List<Bulletin>

    @Query("SELECT * FROM bulletin WHERE cin = :cin")
    fun getBulletin(cin: String): Bulletin?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllBulletins(persons: List<Bulletin>)

    @Insert
    fun saveBulletin(bulletin: Bulletin)

    @Query("DELETE FROM bulletin")
    fun clear()
}