package com.example.listproject.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.listproject.R
import com.example.listproject.activity.DetailActivity
import com.example.listproject.database.StudentModel

class StudentAdapter(private val list: MutableList<StudentModel>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv = view.findViewById<TextView>(R.id.nameTv)
        val ageTv = view.findViewById<TextView>(R.id.ageTv)
        val root = view.findViewById<ConstraintLayout>(R.id.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.nameTv.text = item.name
        holder.ageTv.text = item.age.toString()
        holder.root.setOnClickListener {
            val intent = Intent(holder.root.context, DetailActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("age", item.age)
            intent.putExtra("description", item.description)
            holder.root.context.startActivity(intent)
        }
    }

}