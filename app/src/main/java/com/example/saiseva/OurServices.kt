package com.example.saiseva

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OurServices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge UI
        setContentView(R.layout.activity_our_services) // Sets the layout for the activity

        // Setting window insets listener to adjust for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize button and set up navigation to Nashik activity
        val nashikButton: Button = findViewById(R.id.nashik)
        nashikButton.setOnClickListener {
            val intent = Intent(this, Nashik::class.java)
            startActivity(intent)
        }
        val csnnbutton:Button =findViewById(R.id.csn)
        csnnbutton.setOnClickListener{
            val intent =Intent(this,ChatrapatiSambhajinagar::class.java)
            startActivity(intent)
        }
        val bhimashankarbutton:Button =findViewById(R.id.bhimashankar)
        bhimashankarbutton.setOnClickListener{
            val intent =Intent(this,Bhimashankar::class.java)
            startActivity(intent)
        }
        val pvbutton:Button =findViewById(R.id.PV)
        pvbutton.setOnClickListener{
            val intent =Intent(this,ParaliVaijinath::class.java)
            startActivity(intent)
        }
        val avbutton:Button =findViewById(R.id.AN)
        avbutton.setOnClickListener{
            val intent =Intent(this,aungannath::class.java)
            startActivity(intent)
        }
        val mahabaleshwarbutton:Button =findViewById(R.id.mahabaleshwar)
        mahabaleshwarbutton.setOnClickListener{
            val intent =Intent(this,Mahabaleshwar::class.java)
            startActivity(intent)
        }
        val goabutton:Button =findViewById(R.id.goa)
        goabutton.setOnClickListener{
            val intent =Intent(this,Goa::class.java)
            startActivity(intent)
        }
        val lonavalabutton:Button =findViewById(R.id.Lonavala)
        lonavalabutton.setOnClickListener{
            val intent =Intent(this,Lonavala::class.java)
            startActivity(intent)
        }
        val vanibutton:Button =findViewById(R.id.Vani)
        vanibutton.setOnClickListener{
            val intent =Intent(this,VaniSaptashrungi::class.java)
            startActivity(intent)
        }


}}
