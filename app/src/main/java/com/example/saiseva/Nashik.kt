package com.example.saiseva

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Nashik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nashik) // Sets the layout for the activity

        // Setting window insets listener to adjust for edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        // Initialize "Book Now" button
        val bookNowButton: Button = findViewById(R.id.nashikbooknow)
        bookNowButton.setOnClickListener {
            // Handle "Book Now" action, e.g., navigate to another activity or show a toast
            Toast.makeText(this, "Booking functionality coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}
