package com.example.bus_app

import android.annotation.SuppressLint
import android.app.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.text.SimpleDateFormat
import java.util.*

import android.content.Context

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.preference.PreferenceManager
import android.text.format.DateUtils
import android.widget.*
import androidx.annotation.RequiresApi
import java.lang.StringBuilder


class student_all_week : AppCompatActivity() {

    val multiValueMap: MutableMap<String, ArrayList<String>> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_all_week)

        val source = findViewById<EditText>(R.id.source)
        val desti = findViewById<EditText>(R.id.desti)

        multiValueMap["nigdipunestation"] = ArrayList()
        multiValueMap["nigdipunestation"]!!.add("dapodi-khadki-wakdewadi")
        multiValueMap["nigdipunestation"]!!.add("wakad-aundh-shivajinagar")

        multiValueMap["katrajnigdi"] = ArrayList()
        multiValueMap["katrajnigdi"]!!.add("shivajinar--decaan--swargate")
        multiValueMap["katrajnigdi"]!!.add("dangechowk--wakad--warje")
        multiValueMap["katrajnigdi"]!!.add("dangechowk-wakad-warje-ambegaon")

        val btn= findViewById<Button>(R.id.btnsearch)
        btn.setOnClickListener {

            val a = source.text.toString()
            val b = desti.text.toString()
            val result = a.plus(b)
            listdata(result)
            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = pref.edit()
            editor.putString("name",result)
            editor.apply()
            editor.commit()
        }





    }

    private fun listdata(result: String) {
        val listview = findViewById<ListView>(R.id.listview)
        val size = multiValueMap[result]!!.size
        val name = arrayOfNulls<String>(size)

        for(i in 0 until size)
        {
            //Toast.makeText(applicationContext, multiValueMap[result]?.get(i),Toast.LENGTH_LONG).show()
            name.set(i, multiValueMap[result]?.get(i).toString())

        }

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,
            name)

        listview.adapter = arrayAdapter
        listview.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext,student_all_week_qrcode::class.java)
            startActivity(intent)
        }
    }

}
