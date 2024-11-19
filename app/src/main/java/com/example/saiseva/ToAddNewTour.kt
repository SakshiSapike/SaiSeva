package com.example.saiseva

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ToAddNewTour : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_add_new_tour)

        // Ensure the root view is found correctly
        val rootView = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)

        // Adjust padding to handle system window insets dynamically
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }


        val Packagebutton: ImageView = findViewById(R.id.upload)
        Packagebutton.setOnClickListener {
            val intent = Intent(this, Package::class.java)
            startActivity(intent)
        }
    }
}
