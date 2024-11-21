package com.example.listproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listproject.database.StudentModel
import com.example.listproject.database.DatabaseBuilder
import com.example.listproject.databinding.ActivityAddStudentBinding

class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {

            val student = StudentModel(
                name = binding.nameEt.text.toString(),
                age = binding.ageEt.text.toString().toInt(),
                description = binding.descriptionEt.text.toString()
            )

            val db = DatabaseBuilder.getInstance(this)
            db.studentDao().insertUser(student)

            finish()


        }
    }
}