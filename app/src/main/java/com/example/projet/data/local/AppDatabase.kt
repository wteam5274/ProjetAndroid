package com.example.projet.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projet.data.models.Bulletin
import com.example.projet.data.models.Person
import com.example.projet.data.models.Revenue
import com.example.projet.data.models.Screen

@Database(
    entities = arrayOf(Screen::class, Revenue::class, Person::class, Bulletin::class),
    version = 8,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun screenDao(): ScreenDao
    abstract fun revenueDao(): RevenueDao
    abstract fun personDao(): PersonDao
    abstract fun bulletinDao(): BulletinDao
}