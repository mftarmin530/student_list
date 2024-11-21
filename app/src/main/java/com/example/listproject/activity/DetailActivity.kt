package com.example.listproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listproject.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", -1)
        val description = intent.getStringExtra("description")

        binding.nameTv.text = name
        binding.ageTv.text = age.toString()
        binding.descriptionTv.text = description
    }
}