package com.example.bus_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class student_sepass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_sepass)
        val btnone = findViewById<Button>(R.id.btnone)
        val btnweek = findViewById<Button>(R.id.btnweek)
        val btnmonth = findViewById<Button>(R.id.btnmonth)

        btnone.setOnClickListener {
            val intent = Intent(applicationContext,student_se_onepass::class.java)
            startActivity(intent)
        }
        btnweek.setOnClickListener {
            val intent = Intent(applicationContext,student_se_weekpass::class.java)
            startActivity(intent)
        }

        btnmonth.setOnClickListener {
            val intent = Intent(applicationContext,student_se_monthpass::class.java)
            startActivity(intent)
        }




    }
}