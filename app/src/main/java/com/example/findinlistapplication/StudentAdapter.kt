package com.example.findinlistapplication

// src/main/java/[tên_package]/StudentAdapter.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter cho RecyclerView
class StudentAdapter(private var studentList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // ViewHolder chứa các thành phần View của từng item
    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.tvName)
        val mssvTextView: TextView = view.findViewById(R.id.tvMSSV)
    }

    // Tạo ViewHolder mới khi RecyclerView cần
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    // Gán dữ liệu cho ViewHolder
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.nameTextView.text = student.name
        holder.mssvTextView.text = student.mssv
    }

    // Số lượng item trong danh sách
    override fun getItemCount() = studentList.size

    // Cập nhật danh sách sinh viên khi có dữ liệu mới
    fun updateList(newList: List<Student>) {
        studentList = newList
        notifyDataSetChanged()  // Thông báo dữ liệu thay đổi
    }
}
