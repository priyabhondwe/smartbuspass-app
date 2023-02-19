package com.example.bus_app.Sr.citizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bus_app.R
import com.example.bus_app.student_all_one_disqr
import com.example.bus_app.student_passtype
import com.example.bus_app.student_sepass

class sr_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sr_home)

        val btnall = findViewById<Button>(R.id.btnall)
        val btnsep= findViewById<Button>(R.id.btnsep)
        val btnqr= findViewById<Button>(R.id.btnqr)

        btnall.setOnClickListener {
            val intent = Intent(applicationContext, citizen_passtype::class.java)
            startActivity(intent)
        }
        btnsep.setOnClickListener {
            val intent = Intent(applicationContext,citizen_sepass::class.java)
            startActivity(intent)
        }

        btnqr.setOnClickListener {
            val intent = Intent(applicationContext, citizen_disqrcode::class.java)
            startActivity(intent)
        }

    }
}