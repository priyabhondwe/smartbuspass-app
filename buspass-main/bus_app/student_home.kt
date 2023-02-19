package com.example.bus_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.R.string
import com.example.bus_app.Normal_user.normal_disqrcode
import com.example.bus_app.Normal_user.normal_passtype
import com.example.bus_app.Normal_user.normal_sepass


class student_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_home)

        val btnall = findViewById<Button>(R.id.btnall)
        val btnsep= findViewById<Button>(R.id.btnsep)
        val btnqr= findViewById<Button>(R.id.btnqr)

        btnall.setOnClickListener {
            val intent = Intent(applicationContext, student_passtype::class.java)
            startActivity(intent)
        }
        btnsep.setOnClickListener {
            val intent = Intent(applicationContext, student_sepass::class.java)
            startActivity(intent)
        }

        btnqr.setOnClickListener {
            val intent = Intent(applicationContext, student_all_one_disqr::class.java)
            startActivity(intent)
        }

    }
}