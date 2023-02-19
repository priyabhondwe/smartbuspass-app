package com.example.bus_app.Sr.citizen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bus_app.R
import com.example.bus_app.student_all_monthpass
import com.example.bus_app.student_all_onepass
import com.example.bus_app.student_all_week

class citizen_passtype : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citizen_passtype)

        val btnone = findViewById<Button>(R.id.btnone)
        val btnweek = findViewById<Button>(R.id.btnweek)
        val btnmonth = findViewById<Button>(R.id.btnmonth)

        btnone.setOnClickListener {
            val intent = Intent(applicationContext, citizen_all_one_pass::class.java)
            startActivity(intent)
        }

        btnweek.setOnClickListener {
            val intent = Intent(applicationContext, citizen_all_week_pass::class.java)
            startActivity(intent)
        }

        btnmonth.setOnClickListener {
            val intent = Intent(applicationContext, citizen_all_month_pass::class.java)
            startActivity(intent)
        }
    }
}