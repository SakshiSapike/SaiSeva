package com.example.saiseva

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Package : AppCompatActivity() {

    private lateinit var packageNameEditText: EditText
    private lateinit var totalSpotsEditText: EditText
    private lateinit var spotsContainer: LinearLayout
    private lateinit var addSpotButton: Button
    private lateinit var submitButton: Button

    private val spotViews = mutableListOf<SpotView>()
    private var totalSpots: Int = 0

    private var currentSpotView: SpotView? = null

    private val imagePickerLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            currentSpotView?.onImageSelected(uri)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_package)

        // Adjust padding for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        packageNameEditText = findViewById(R.id.editTextPackageName)
        totalSpotsEditText = findViewById(R.id.editTextTotalSpots)
        spotsContainer = findViewById(R.id.spotsContainer)
        addSpotButton = findViewById(R.id.buttonAddSpot)
        submitButton = findViewById(R.id.buttonSubmit)

        // Set button listeners
        addSpotButton.setOnClickListener {
            if (validateTotalSpots()) {
                addSpotInput()
            }
        }

        submitButton.setOnClickListener {
            handleSubmit()
        }
    }

    private fun validateTotalSpots(): Boolean {
        val totalSpotsInput = totalSpotsEditText.text.toString()
        if (totalSpotsInput.isBlank() || totalSpotsInput.toIntOrNull() == null) {
            Toast.makeText(this, "Please enter a valid total number of spots.", Toast.LENGTH_SHORT).show()
            return false
        }

        totalSpots = totalSpotsInput.toInt()
        if (spotViews.size >= totalSpots) {
            Toast.makeText(this, "You can only add $totalSpots spots.", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun addSpotInput() {
        val spotView = SpotView(this)
        spotsContainer.addView(spotView.view)
        spotViews.add(spotView)
    }

    private fun handleSubmit() {
        val packageName = packageNameEditText.text.toString()
        val spots = spotViews.map { it.getSpotDetails() }

        if (packageName.isBlank() || totalSpots <= 0 || spots.isEmpty()) {
            Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            return
        }

        // Handle submission logic here
        Toast.makeText(this, "Package Submitted: $packageName", Toast.LENGTH_LONG).show()
    }

    inner class SpotView(activity: Activity) {
        val view: LinearLayout = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        private val spotNameEditText = EditText(activity).apply {
            hint = "Spot Name"
            inputType = android.text.InputType.TYPE_CLASS_TEXT
        }

        private val spotImageButton = Button(activity).apply {
            text = "Choose Image"
            setOnClickListener { chooseImage() }
        }

        private val spotImageView = ImageView(activity).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                300
            )
        }

        private var imageUri: Uri? = null

        init {
            view.addView(spotNameEditText)
            view.addView(spotImageButton)
            view.addView(spotImageView)
        }

        private fun chooseImage() {
            currentSpotView = this

            var activity = null
            (activity as Package).imagePickerLauncher.launch("image/*")
        }

        fun onImageSelected(uri: Uri?) {
            imageUri = uri
            spotImageView.setImageURI(uri)
        }

        fun getSpotDetails(): SpotDetails {
            return SpotDetails(
                name = spotNameEditText.text.toString(),
                imageUri = imageUri
            )
        }
    }

    data class SpotDetails(val name: String, val imageUri: Uri?)
}
