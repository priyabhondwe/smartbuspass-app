package com.example.bus_app.Sr.citizen

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.preference.PreferenceManager
import android.widget.ImageView
import android.widget.Toast
import com.example.bus_app.R
import com.example.bus_app.send
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class citizen_disqrcode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citizen_disqrcode)

        val img = findViewById<ImageView>(R.id.imgqr)
        val bitmap =
            BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().absolutePath + File.separator+"test.jpeg")
        img.setImageBitmap(bitmap)



//        Toast.makeText(applicationContext, res, Toast.LENGTH_LONG).show()
        val mSharedPreference = PreferenceManager.getDefaultSharedPreferences(
            baseContext
        )

        val mail = mSharedPreference.getString("citizen-email","DEFAULT")
        val data = mSharedPreference.getString("data","DEFAULT")
        val day = mSharedPreference.getInt("days",0)

//        Toast.makeText(applicationContext,data,Toast.LENGTH_LONG).show()
//        Toast.makeText(applicationContext,day.toString(),Toast.LENGTH_LONG).show()
//        Toast.makeText(applicationContext,mail,Toast.LENGTH_LONG).show()
        if(day==1)
        {
            Toast.makeText(applicationContext, day.toString(), Toast.LENGTH_LONG).show()
            val sdf = SimpleDateFormat("dd/M/yyyy")
            val cdate = sdf.format(Date())
//

            val cal = Calendar.getInstance()
            val s = SimpleDateFormat("dd/M/yyyy")
            cal.add(Calendar.DAY_OF_YEAR,1)
            val res = s.format(Date(cal.timeInMillis))
            if(cdate==res)
            {
                val s = send(applicationContext,mail,"Alert",data)
                s.execute()
            }

        }else if(day==7)
        {
            Toast.makeText(applicationContext, day.toString(), Toast.LENGTH_LONG).show()
            val sdf = SimpleDateFormat("dd/M/yyyy")
            val cdate = sdf.format(Date())


            val cal = Calendar.getInstance()
            val s = SimpleDateFormat("dd/M/yyyy")
            cal.add(Calendar.DAY_OF_YEAR,5)
            val res = s.format(Date(cal.timeInMillis))
            if(cdate==res)
            {
                val s = send(applicationContext,mail,"Alert",data)
                s.execute()
            }
        }else if(day==28)
        {
            Toast.makeText(applicationContext, day.toString(), Toast.LENGTH_LONG).show()
            val sdf = SimpleDateFormat("dd/M/yyyy")
            val cdate = sdf.format(Date())


            val cal = Calendar.getInstance()
            val s = SimpleDateFormat("dd/M/yyyy")
            cal.add(Calendar.DAY_OF_YEAR,26)
            val res = s.format(Date(cal.timeInMillis))
            if(cdate==res)
            {
                val s = send(applicationContext,mail,"Alert",data)
                s.execute()
            }
        }



    }
}