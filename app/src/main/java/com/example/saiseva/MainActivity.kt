package com.example.saiseva
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apply window insets to set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // This line ensures a WindowInsetsCompat is returned
        }
        // Initialize Firebase Database and set a value
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        myRef.setValue("Hello, Firebase")
        myRef.setValue("Hello, Sakshi")// Set the Firebase value outside of the insets listener

        val svButton: Button = findViewById(R.id.newbutton)

        // Set an OnClickListener to navigate to the next activity
        svButton.setOnClickListener {
            val intent = Intent(this, OurServices::class.java)
            startActivity(intent)
        }
    }
}