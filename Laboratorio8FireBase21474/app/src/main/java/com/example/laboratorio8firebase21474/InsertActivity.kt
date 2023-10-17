package com.example.laboratorio8firebase21474

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertActivity : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var edad: EditText
    private lateinit var deporte: EditText
    private lateinit var btnGuardar: Button
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
        nombre = findViewById(R.id.editTextText)
        edad = findViewById(R.id.editTextText2)
        deporte = findViewById(R.id.editTextText3)
        btnGuardar = findViewById(R.id.button5)
        dbRef = FirebaseDatabase.getInstance().getReference("Employees")

        btnGuardar.setOnClickListener{
            saveData()
        }
    }

    private fun saveData() {
        //obteniendo los valores.
        val Anombre = nombre.text.toString()
        val Aedad = edad.text.toString()
        val Adeporte = deporte.text.toString()

        //evaluar si las casillas estan llenas o no para madnar los datos...
        if (Anombre.isEmpty()) {
            nombre.error = "por favor ingresa un nombre..."
        }
        if (Aedad.isEmpty()) {
            edad.error = "por favor ingresa la edad..."
        }
        if (Adeporte.isEmpty()) {
            deporte.error = "por favor ingresa el deporte..."
        }
        //creacion de los ids para identificar cada registro...
        val Aid = dbRef.push().key!!

        val Atleta = AtletaModel(Aid, Anombre, Aedad, Adeporte)
        dbRef.child(Aid).setValue(Atleta)
            .addOnCompleteListener{
                Toast.makeText(this, "Data Inserted succesfully", Toast.LENGTH_LONG).show()
                nombre.text.clear()
                edad.text.clear()
                deporte.text.clear()
            }.addOnFailureListener{err->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}