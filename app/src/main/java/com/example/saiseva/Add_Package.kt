package com.example.saiseva

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Add_Package : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_package)

        // References
        val totalNumberEditText = findViewById<EditText>(R.id.editTextNumber)
        val generateButton = findViewById<Button>(R.id.newbutton)
        val newSpotLayout = findViewById<LinearLayout>(R.id.newspot)

        // Set onClickListener for the button
        generateButton.setOnClickListener {
            // Clear previous views in the layout
            newSpotLayout.removeAllViews()

            // Get the number of spots entered
            val totalSpots = totalNumberEditText.text.toString().toIntOrNull()

            if (totalSpots != null && totalSpots > 0) {
                for (i in 1..totalSpots) {
                    // Create EditText for spot name
                    val spotNameEditText = EditText(this).apply {
                        hint = "Spot $i Name"
                        textSize = 16f
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                    }

                    // Create ImageView for spot image
                    val spotImageView = ImageView(this).apply {
                        setImageResource(android.R.drawable.ic_menu_camera) // Placeholder icon
                        layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            300 // Set a fixed height for image
                        ).apply {
                            setMargins(0, 16, 0, 16) // Add margins
                        }
                        scaleType = ImageView.ScaleType.CENTER_CROP
                    }

                    // Add views to the layout
                    newSpotLayout.addView(spotNameEditText)
                    newSpotLayout.addView(spotImageView)

                    // Optionally: Add a click listener for image selection
                    spotImageView.setOnClickListener {
                        // Handle image selection logic here
                    }
                }
            } else {
                // Show error message or handle invalid input
                totalNumberEditText.error = "Please enter a valid number"
            }
        }
    }
}
