plugins {
    id("com.android.application") // Plugin for Android app
    id("org.jetbrains.kotlin.android") // Kotlin Android plugin
    id("com.google.gms.google-services") // Google services plugin
}

android {
    namespace = "com.example.saiseva"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.saiseva"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Core Android dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Firebase and Google services dependencies
    implementation("com.google.firebase:firebase-database-ktx:20.0.3")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    // Transition animations
    implementation("androidx.transition:transition:1.4.1")
    implementation(libs.androidx.activity)

    // Unit Testing dependencies
    testImplementation("junit:junit:4.13.2")

    // Android Testing dependencies
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
