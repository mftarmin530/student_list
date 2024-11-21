package com.example.listproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Insert
    fun insertUser(studentModel: StudentModel)

    @Query("SELECT * FROM student")
    fun getAllStudent(): MutableList<StudentModel>

}