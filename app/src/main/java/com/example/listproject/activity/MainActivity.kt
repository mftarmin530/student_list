package com.example.listproject.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listproject.adapter.StudentAdapter
import com.example.listproject.database.StudentModel
import com.example.listproject.database.DatabaseBuilder
import com.example.listproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var studentList = mutableListOf<StudentModel>()
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.addBtn.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, 1001)
        }
    }

    override fun onResume() {
        super.onResume()

        val db = DatabaseBuilder.getInstance(this)

        studentList = db.studentDao().getAllStudent()

        adapter = StudentAdapter(studentList)

        binding.studentRv.layoutManager = LinearLayoutManager(this)
        binding.studentRv.adapter = adapter
    }

}