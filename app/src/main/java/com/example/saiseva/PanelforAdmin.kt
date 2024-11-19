package com.example.saiseva
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class PanelforAdmin : AppCompatActivity() {

    // Predefined admin email and password
    private val adminEmail = "admin@saiseva.com"
    private val adminPassword = "admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge display
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContentView(R.layout.activity_panelfor_admin)

        // Adjust padding to handle system window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Binding views
        val emailInput: EditText = findViewById(R.id.adminemail)
        val passwordInput: EditText = findViewById(R.id.admin_password)
        val loginButton: TextView = findViewById(R.id.admin_login)
        val dontHaveAccountText: TextView = findViewById(R.id.admin_txt_of_dha)
        val nextPageIcon: ImageView = findViewById(R.id.next_page)

        // Handle login button click
        loginButton.setOnClickListener {
            val enteredEmail = emailInput.text.toString().trim()
            val enteredPassword = passwordInput.text.toString().trim()

            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else if (enteredEmail != adminEmail) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            } else if (enteredPassword != adminPassword) {
                Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                // Navigate to Admin Dashboard Activity
                val intent = Intent(this, ToAddNewTour::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Handle "Don't Have Account" click
        dontHaveAccountText.setOnClickListener {
            Toast.makeText(this, "Contact support for admin access.", Toast.LENGTH_SHORT).show()
        }

        // Handle next page icon click (optional functionality)
        nextPageIcon.setOnClickListener {
            Toast.makeText(this, "Feature not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }
}
