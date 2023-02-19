package com.example.bus_app.Normal_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bus_app.R
import com.example.bus_app.student_se_monthpass
import com.example.bus_app.student_se_onepass
import com.example.bus_app.student_se_weekpass

class normal_sepass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_sepass)

        val btnone = findViewById<Button>(R.id.btnone)
        val btnweek = findViewById<Button>(R.id.btnweek)
        val btnmonth = findViewById<Button>(R.id.btnmonth)

        btnone.setOnClickListener {
            val intent = Intent(applicationContext, normal_se_one_pass::class.java)
            startActivity(intent)
        }
        btnweek.setOnClickListener {
            val intent = Intent(applicationContext, normal_se_week_pass::class.java)
            startActivity(intent)
        }

        btnmonth.setOnClickListener {
            val intent = Intent(applicationContext, normal_se_month_pass::class.java)
            startActivity(intent)
        }

    }
}