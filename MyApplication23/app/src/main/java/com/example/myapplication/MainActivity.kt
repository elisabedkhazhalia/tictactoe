

package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var saxeli1: EditText
    private lateinit var  saxeli2: EditText
    private lateinit var registracia: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saxeli1 = findViewById(R.id.editTextTextPersonName)
        saxeli2 = findViewById(R.id.editTextTextPersonName2)
        registracia = findViewById(R.id.button)
        registracia.setOnClickListener {
            var sheikvaneSaxeli1:Boolean = saxeli1.text.toString().isNotEmpty()
            var sheikvaneSaxeli2:Boolean = saxeli2.text.toString().isNotEmpty()

            if (sheikvaneSaxeli2  && sheikvaneSaxeli1){
                Toast.makeText(this, "რეგისტრირებული ხართ", Toast.LENGTH_SHORT).show()
                val Intent = Intent(this, MainActivity2::class.java)
                Intent.putExtra("play1name", saxeli1.text.toString())
                Intent.putExtra("play2name", saxeli2.text.toString())

                startActivity(Intent)
            }
        }

    }
}