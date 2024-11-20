package com.example.saiseva

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChatrapatiSambhajinagar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatrapati_sambhajinagar) // Sets the layout for the activity

        // Setting window insets listener to adjust for edge-to-edge
        val mainView = findViewById<View>(R.id.main) // Ensure R.id.main exists in the layout
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }

        // Initialize "Book Now" button
        val bookNowButton: Button = findViewById(R.id.csnbuttonBook)
        bookNowButton.setOnClickListener {
            // Handle "Book Now" action, e.g., navigate to another activity or show a toast
            Toast.makeText(this, "Booking functionality coming soon!", Toast.LENGTH_SHORT).show()
        }
    }
}
