package com.example.laboratorio8firebase21474

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var btnInsertData: Button
    private lateinit var btnFetching: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //______________________________________________________________________________________________
        //este es para instanciar la base de datos (creo que no la vamos a necesitar en este archivo de codigo...

        //_______________________________________________________________________________________________
        btnInsertData = findViewById(R.id.button)
        btnFetching = findViewById(R.id.button2)

        btnInsertData.setOnClickListener{
            val intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)
        }

        btnFetching.setOnClickListener{
            val intent = Intent(this, FetchingActivity:: class.java)
            startActivity(intent)
        }
    }
}