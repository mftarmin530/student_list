package com.example.listproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
    val description: String
)
