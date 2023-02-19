package com.example.bus_app.Normal_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bus_app.R
import com.example.bus_app.student_all_one_disqr
import com.example.bus_app.student_passtype
import com.example.bus_app.student_sepass

class normal_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_home)

        val btnall = findViewById<Button>(R.id.btnall)
        val btnsep= findViewById<Button>(R.id.btnsep)
        val btnqr= findViewById<Button>(R.id.btnqr)

        btnall.setOnClickListener {
            val intent = Intent(applicationContext, normal_passtype::class.java)
            startActivity(intent)
        }
        btnsep.setOnClickListener {
            val intent = Intent(applicationContext, normal_sepass::class.java)
            startActivity(intent)
        }

        btnqr.setOnClickListener {
            val intent = Intent(applicationContext, normal_disqrcode::class.java)
            startActivity(intent)
        }
    }
}