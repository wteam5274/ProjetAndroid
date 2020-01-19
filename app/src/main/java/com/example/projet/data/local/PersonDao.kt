package com.example.projet.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projet.data.models.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun getPersons(): List<Person>

    @Query("SELECT * FROM person WHERE cin = :cin")
    fun getPersons(cin: String): Person?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllPersons(persons: List<Person>)

    @Insert
    fun savePerson(person: Person)

    @Query("DELETE FROM person")
    fun clear()
}