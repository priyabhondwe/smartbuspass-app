package com.example.bus_app.Normal_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bus_app.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class normal_register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_register)

        lateinit var auth : FirebaseAuth

        var databaseReference: DatabaseReference? =null
        var database: FirebaseDatabase? = null
        val name= findViewById<EditText>(R.id.no_name)
        val adhar = findViewById<EditText>(R.id.no_card)
        val number = findViewById<EditText>(R.id.no_monumber)
        val email = findViewById<EditText>(R.id.no_email)
        val password = findViewById<EditText>(R.id.no_password)
        val btn = findViewById<Button>(R.id.btnregister)
        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Normaluser")

        btn.setOnClickListener {
            if(name.text.isEmpty())
            {
                name.setError("Enter name")
                return@setOnClickListener
            }else if(adhar.text.isEmpty())
            {
                adhar.setError("Enter adhar card no")
                return@setOnClickListener
            }else if(password.text.isEmpty())
            {
                password.setError("Enter Password ")
                return@setOnClickListener
            }else if(number.text.isEmpty())
            {
                number.setError("Enter Contact Number")
                return@setOnClickListener
            }else if(email.text.isEmpty())
            {
                email.setError("Enter Email id")
                return@setOnClickListener
            }


            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        val currentuser = auth.currentUser
                        val currentUserdb = databaseReference?.child((currentuser?.uid!!))
                        currentUserdb?.child("name")?.setValue(name.text.toString())
                        currentUserdb?.child("adharcard")?.setValue(adhar.text.toString())

                        currentUserdb?.child("number")?.setValue(number.text.toString())

                        Toast.makeText(applicationContext,"success", Toast.LENGTH_LONG).show()
//                        Toast.makeText(applicationContext,adhar.text.toString(), Toast.LENGTH_LONG).show()
                        matchadhar(adhar.text.toString())

                    }
                    else
                    {
                        Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
                    }
                }
            sharedata(name.text.toString(),email.text.toString())
        }

    }

    private fun sharedata(value: String, email: String) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("normal-name",value)
        editor.putString("normal-email",email)
        editor.apply()
        editor.commit()

    }

    private fun matchadhar(no: String) {

        var no:Int = no.toInt()

        val myMap: Map<Int, Int> = mapOf<Int,Int>(4910 to 20 , 3910 to 33, 2910 to 66)
        for(key in myMap.keys) {
//            Toast.makeText(applicationContext,"your age is"+myMap.getValue(no),Toast.LENGTH_LONG).show()
            if(((myMap).getValue(no)>=20)&&((myMap.getValue(no)<=60)))
            {
//                Toast.makeText(applicationContext,"age is valid",Toast.LENGTH_LONG).show()
            }else
            {
//                Toast.makeText(applicationContext,"age invalid",Toast.LENGTH_LONG).show()
            }



        }
    }
}