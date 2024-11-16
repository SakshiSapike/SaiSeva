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

        val bhimashankarButton: Button = findViewById(R.id.bhimashankar)
        bhimashankarButton.setOnClickListener {
            val intent = Intent(this, Bhimashankar::class.java)
            startActivity(intent)
        }

    }
}