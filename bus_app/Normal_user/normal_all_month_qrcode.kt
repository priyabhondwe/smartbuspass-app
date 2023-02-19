package com.example.bus_app.Normal_user

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.bus_app.R
import com.example.bus_app.databasemodel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class normal_all_month_qrcode : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_all_month_qrcode)

        val txtcharge = findViewById<TextView>(R.id.txtcharge)
        val btn = findViewById<Button>(R.id.btnqr)
        val imageview = findViewById<ImageView>(R.id.imageView)

        val btnpay = findViewById<Button>(R.id.btnpay)

        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Normaluser")



        val multiValueMap: MutableMap<String, ArrayList<String>> = HashMap()

        multiValueMap["nigdipunestation"] = ArrayList()
        multiValueMap["nigdipunestation"]!!.add("10")
        multiValueMap["nigdipunestation"]!!.add("15")

        multiValueMap["katrajnigdi"] = ArrayList()
        multiValueMap["katrajnigdi"]!!.add("33")
        multiValueMap["katrajnigdi"]!!.add("40")

        val mSharedPreference = PreferenceManager.getDefaultSharedPreferences(
            baseContext
        )
        val value = mSharedPreference.getString("name", "DEFAULT")
        val name = mSharedPreference.getString("normal-name", "DEFAULT")
//        val mail = mSharedPreference.getString("email","DEFALUT")
        val km = multiValueMap[value]?.get(0)!!.toInt()

        val charges = km * 28


        val discount = charges*2/100
        val result = charges-discount
        txtcharge.setText("Your Charges is "+result +"rs")

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val cdate = sdf.format(Date())
//        Toast.makeText(applicationContext, cdate, Toast.LENGTH_LONG).show()

        val cal = Calendar.getInstance()
        val s = SimpleDateFormat("dd/M/yyyy")
        cal.add(Calendar.DAY_OF_YEAR,28)
        val res = s.format(Date(cal.timeInMillis))

//        Toast.makeText(applicationContext, res, Toast.LENGTH_LONG).show()
        val sb = StringBuffer()
        sb.append("name ").append(name)
        sb.append(System.getProperty("line.separator"))
        sb.append("all Route 28 Day Pass")
        sb.append(System.getProperty("line.separator"))
        sb.append("your charges is ").append(result)
        sb.append(System.getProperty("line.separator"))
        sb.append("Expiry Date ").append(res)


        val msg =sb.toString()
//        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("data",msg)
        editor.putInt("days",28)
        editor.commit()
        editor.apply()

        btn.setOnClickListener {
            val writer = QRCodeWriter()
            try{
                val bitMatrix = writer.encode(msg, BarcodeFormat.QR_CODE,512,512)
                val width = bitMatrix.width
                val height = bitMatrix.height
                val bmp= Bitmap.createBitmap(width,height, Bitmap.Config.RGB_565)
                for(x in 0 until width){
                    for(y in 0 until height)
                    {
                        bmp.setPixel(x,y, if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)

                    }
                }
                imageview.setImageBitmap(bmp)
                createImageFile(bmp)
                val s = "all Route 28 Day Pass "
                val model= databasemodel(name,s,result,res)
                val id = databaseReference!!.push().key
                databaseReference!!.child(id!!).setValue(model)


            }catch (e: WriterException)
            {
                e.printStackTrace()
            }

        }

        btnpay.setOnClickListener {
            Toast.makeText(applicationContext,"payment done", Toast.LENGTH_LONG).show()

            val wallet = 500
            val balance = wallet-result
            Toast.makeText(applicationContext, "your balance rs$balance", Toast.LENGTH_LONG).show()

        }


    }

    private fun createImageFile(bmp: Bitmap) {
        val bytes = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.JPEG,40,bytes)
        val filepath = Environment.getExternalStorageDirectory().absolutePath + File.separator + "test.jpeg"
        val f = File(filepath)
        f.createNewFile()
        val fo = FileOutputStream(f)
        fo.write(bytes.toByteArray())
        fo.close()

    }
}