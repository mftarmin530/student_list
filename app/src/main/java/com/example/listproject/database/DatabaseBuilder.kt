package com.example.listproject.database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (instance == null) {
            synchronized(AppDatabase::class) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_db"
                ).allowMainThreadQueries().build()
            }
        }

        return instance!!
    }

}